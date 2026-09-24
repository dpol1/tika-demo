# Tika demo

StormCrawler fetches pages and PDFs from a local server and sends their bytes to Tika over
gRPC. Tika's `ParseBytes` call returns a typed `Document` with metadata and parse status.
The checker verifies byte hashes, provenance, PDF metadata and HTTP request counts.

`ParseBytes` and `Document` are not released yet. This demo uses the
[`TIKA-4795-parseBytes`](https://github.com/ai-pipestream/tika/tree/TIKA-4795-parseBytes)
branch ([TIKA-4795](https://issues.apache.org/jira/browse/TIKA-4795),
[TIKA-4766](https://issues.apache.org/jira/browse/TIKA-4766)).

## What the checker verifies

- Each seeded or discovered URL produces one result, with no RPC or parse errors.
- Correlation IDs, source URLs, byte sizes and truncation flags match the request.
- SHA-256 values match at both ends; served PDFs also match the files on disk.
- The access log contains one GET for each document URL.
- `testPDF.pdf` returns the expected title and author, a creation date and an integer page count.
- A PDF served without an extension as `application/octet-stream` is detected as a PDF.
- The PDF with attachments and the PDF with an owner password parse successfully.

See [`verify.py`](verify.py) for the checks and [`sample-run/`](sample-run/) for a recorded run.

## Run it

Requires Java 17+, Maven, Docker and Python 3. Written for Linux and macOS, tested on
Linux x86_64; on Windows use WSL2. The default fixture hostname uses nip.io and requires DNS.

Build tika-grpc at commit `92817ea8d4b776e3e55251e18b1538b870cc844e`, in a folder next to
this repository:

```sh
git clone https://github.com/dpol1/tika-demo.git
git clone https://github.com/ai-pipestream/tika.git tika-4795-demo
cd tika-4795-demo
git checkout 92817ea8d4b776e3e55251e18b1538b870cc844e
./mvnw -q clean package dependency:build-classpath -pl tika-grpc -am -Pfast \
  -Dmdep.includeScope=runtime -Dmdep.outputFile="$PWD/tika-grpc/target/cp.txt"
```

Then run the demo:

```sh
cd ../tika-demo
./run.sh
```

The script starts Tika, URLFrontier and the fixture server, crawls for two minutes, then runs
the checker. Startup and downloads take additional time. Results and logs go to `out/`;
exit code 0 means all checks passed.

Environment variables:

- `TIKA_DIR`: the Tika checkout built with the command above (default `../tika-4795-demo`).
- `TIKA_TARGET`: an existing ParseBytes server (`host:port`); skips local Tika startup.
- `TIKA_PORT`: local Tika port (default 50052; another is chosen if occupied).
- `RUN_MINUTES`: crawl duration in minutes (default 2).
- `FIXTURE_HOST`: host name of the web server (default a nip.io name for 127.0.0.1). Offline,
  add a name for 127.0.0.1 to `/etc/hosts` and use it here.
- `FIXTURE_BIND`: address the web server listens on (default 127.0.0.1).
- `ARCHIVE=1`: require a clean demo checkout and, for local Tika, a clean Tika checkout.

## Using another ParseBytes server

Use the Tika build above with this configuration:

```json
{
  "parse-context": {
    "commons-digester-factory": {
      "digests": [ { "algorithm": "SHA256" } ],
      "skipContainerDocumentDigest": false
    }
  },
  "pipes": { "emitStrategy": { "type": "PASSBACK_ALL" } },
  "plugin-roots": "/path/to/tika/tika-grpc/target/plugins"
}
```

- The digester supplies `origin.sha256` for the checksum check.
- `PASSBACK_ALL` returns large results without requiring an emitter.
- `plugin-roots` must be in the file so the forked parser can read it; the command-line
  option reaches only the parent process.

Save this as `tika-grpc-demo.json` in the Tika checkout and start the server:

```sh
cd /path/to/tika
java -cp "tika-grpc/target/classes:$(tr ':' '\n' < tika-grpc/target/cp.txt | grep -v '\.zip$' | paste -s -d : -)" \
  org.apache.tika.pipes.grpc.TikaGrpcServer -c tika-grpc-demo.json -p 50052
```

Use this command: with `run-dev.sh`, forked parsers inherit Maven's classpath and fail to start.

Then point the demo at it:

```sh
TIKA_TARGET=localhost:50052 ./run.sh
```

For a remote Tika server, use `FIXTURE_HOST=myhost.lan FIXTURE_BIND=0.0.0.0` with a hostname
it can reach, so any fetch from that server appears in the access log.

## License

[Apache License 2.0](LICENSE). The protos, the generated classes and the three test PDFs come
from Apache Tika; see [NOTICE](NOTICE).
