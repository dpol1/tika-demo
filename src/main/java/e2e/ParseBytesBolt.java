package e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.HexFormat;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.apache.stormcrawler.Metadata;
import org.apache.tika.grpc.v2.Document;
import org.apache.tika.grpc.v2.MetadataField;
import org.apache.tika.grpc.v2.MetadataValue;
import org.apache.tika.grpc.v2.ParseBytesRequest;
import org.apache.tika.grpc.v2.ParseBytesResponse;
import org.apache.tika.grpc.v2.TikaV2ServiceGrpc;

/**
 * Sends fetched bytes to TikaV2Service.ParseBytes, writes each reply or error as a JSON line,
 * copies Tika's results into the tuple's metadata under {@code tika.} and passes the tuple on.
 *
 * <p>A parse failure is part of the reply (status and errors), so that tuple still goes on.
 * When Tika cannot be reached the call is retried; if it still fails the tuple is failed, so
 * the spout hands the URL out again instead of the document being lost.
 */
public class ParseBytesBolt extends BaseRichBolt {

    private static final ObjectMapper JSON = new ObjectMapper();

    // Keys of Document.extra copied to the result line: the value type under <name>_type,
    // and the first integer value under <name>.
    private static final Map<String, String> TYPED_FIELDS =
            Map.of("xmpTPg:NPages", "pages", "csv:num-rows", "rows");

    // Attempts for a call that ends UNAVAILABLE, and the wait before the first retry.
    private static final int ATTEMPTS = 3;
    private static final long BACKOFF_MS = 1_000;

    // Storm serializes the bolt; the non-serializable parts are created in prepare().
    private transient OutputCollector collector;
    private transient ManagedChannel channel;
    private transient TikaV2ServiceGrpc.TikaV2ServiceBlockingStub stub;
    private transient PrintWriter out;

    @Override
    public void prepare(Map<String, Object> conf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
        String target = (String) conf.getOrDefault("parsebytes.target", "localhost:50052");
        String results = (String) conf.getOrDefault("parsebytes.results", "out/results.jsonl");
        channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        stub = TikaV2ServiceGrpc.newBlockingStub(channel);
        try {
            // Append, flush per line.
            out = new PrintWriter(new FileWriter(results, true), true);
        } catch (IOException e) {
            throw new IllegalStateException("cannot open " + results, e);
        }
    }

    @Override
    public void execute(Tuple tuple) {
        String url = tuple.getStringByField("url");
        byte[] content = tuple.getBinaryByField("content");
        Metadata metadata = (Metadata) tuple.getValueByField("metadata");
        ObjectNode line = JSON.createObjectNode().put("url", url).put("bytes", content.length);
        long start = System.nanoTime();
        boolean unreachable = false;
        if (content.length == 0) {
            // ParseBytes rejects empty content with INVALID_ARGUMENT; there is nothing to parse.
            line.put("skipped", "empty content");
            metadata.setValue("tika.status", "SKIPPED_EMPTY");
        } else {
            try {
                ParseBytesRequest request =
                        ParseBytesRequest.newBuilder()
                                .setCorrelationId("crawl:" + url)
                                .setContent(ByteString.copyFrom(content))
                                .setResourceName(resourceName(url))
                                .setSourceUri(url)
                                // set by StormCrawler when the body was cut at http.content.limit
                                .setTruncated("true".equals(metadata.getFirstValue("protocol.http.trimmed")))
                                .build();
                ParseBytesResponse reply = call(request, line);
                Document doc = reply.getDocument();
                line.put("correlation_id", request.getCorrelationId())
                        .put("doc_id", doc.getId())
                        .put("reply_correlation_id", reply.getCorrelationId())
                        .put("client_sha256", sha256(content))
                        .put("origin_sha256", doc.getOrigin().getSha256())
                        .put("origin_byte_size", doc.getOrigin().getByteSize())
                        .put("origin_source_uri", doc.getOrigin().getSourceUri())
                        .put("content_type", doc.getContentType())
                        .put("title", doc.getMetadata().getTitle())
                        .put("authors", String.join(";", doc.getMetadata().getAuthorsList()))
                        .put("created", doc.getMetadata().hasCreated()
                                ? Instant.ofEpochSecond(doc.getMetadata().getCreated().getSeconds()).toString()
                                : "")
                        .put("parsers_used", String.join(",", doc.getStatus().getParsersUsedList()))
                        .put("errors", String.join(" | ", doc.getStatus().getErrorsList()))
                        .put("pipes_status", doc.getStatus().getPipesStatus())
                        .put("status", doc.getStatus().getStatus().name())
                        .put("tika_version", doc.getStatus().getTikaVersion())
                        .put("extra_fields", doc.getExtraCount())
                        .put("document_bytes", doc.getSerializedSize())
                        .put("truncated_sent", request.getTruncated())
                        .put("truncated", doc.getOrigin().getTruncated());
                for (MetadataField field : doc.getExtraList()) {
                    String name = TYPED_FIELDS.get(field.getKey());
                    if (name != null) {
                        MetadataValue value = field.getValue();
                        line.put(name + "_type", value.getValuesCase().name().toLowerCase());
                        if (value.hasIntegers() && value.getIntegers().getValuesCount() > 0) {
                            line.put(name, value.getIntegers().getValues(0));
                        }
                    }
                }
                copyToMetadata(doc, line, metadata);
            } catch (StatusRuntimeException e) {
                line.put("error", e.getStatus().toString());
                unreachable = e.getStatus().getCode() == Status.Code.UNAVAILABLE;
                metadata.setValue("tika.status", "RPC_" + e.getStatus().getCode());
            } catch (Exception e) {
                line.put("error", e.toString());
                metadata.setValue("tika.status", "CLIENT_ERROR");
            }
        }
        line.put("elapsed_ms", (System.nanoTime() - start) / 1_000_000);
        out.println(line);
        System.out.println(">>> parsebytes " + line);
        if (unreachable) {
            collector.fail(tuple);
            return;
        }
        collector.emit(tuple, new Values(url, content, metadata));
        collector.ack(tuple);
    }

    /** Calls ParseBytes, retrying with a doubling wait while the server is UNAVAILABLE. */
    private ParseBytesResponse call(ParseBytesRequest request, ObjectNode line) throws InterruptedException {
        long backoff = BACKOFF_MS;
        for (int attempt = 1; ; attempt++) {
            try {
                ParseBytesResponse reply = stub.withDeadlineAfter(30, TimeUnit.SECONDS).parseBytes(request);
                line.put("attempts", attempt);
                return reply;
            } catch (StatusRuntimeException e) {
                // The server answers RESOURCE_EXHAUSTED when the content is over its limit, which
                // a retry cannot fix, so only UNAVAILABLE is retried.
                if (e.getStatus().getCode() != Status.Code.UNAVAILABLE || attempt == ATTEMPTS) {
                    line.put("attempts", attempt);
                    throw e;
                }
                Thread.sleep(backoff);
                backoff *= 2;
            }
        }
    }

    /** Puts Tika's results into StormCrawler's metadata, where the indexer can map them. */
    private static void copyToMetadata(Document doc, ObjectNode line, Metadata metadata) {
        metadata.setValue("tika.status", doc.getStatus().getStatus().name());
        metadata.setValue("tika.content_type", doc.getContentType());
        if (!doc.getMetadata().getTitle().isEmpty()) {
            metadata.setValue("tika.title", doc.getMetadata().getTitle());
        }
        if (doc.getMetadata().getAuthorsCount() > 0) {
            metadata.setValues("tika.authors", doc.getMetadata().getAuthorsList().toArray(new String[0]));
        }
        if (!line.get("created").asText().isEmpty()) {
            metadata.setValue("tika.created", line.get("created").asText());
        }
        if (doc.getStatus().getErrorsCount() > 0) {
            // An error is a stack trace; its first line names the exception.
            metadata.setValues("tika.errors", doc.getStatus().getErrorsList().stream()
                    .map(e -> e.lines().findFirst().orElse(""))
                    .toArray(String[]::new));
        }
        for (String name : TYPED_FIELDS.values()) {
            if (line.has(name)) {
                metadata.setValue("tika." + name, line.get(name).asText());
            }
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        // The fields the fetcher emits, which JSoupParserBolt reads.
        declarer.declare(new Fields("url", "content", "metadata"));
    }

    @Override
    public void cleanup() {
        out.close();
        channel.shutdownNow();
    }

    private static String resourceName(String url) {
        String path = URI.create(url).getPath();
        int slash = path.lastIndexOf('/');
        return slash < 0 ? path : path.substring(slash + 1);
    }

    private static String sha256(byte[] bytes) throws Exception {
        return HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256").digest(bytes));
    }
}
