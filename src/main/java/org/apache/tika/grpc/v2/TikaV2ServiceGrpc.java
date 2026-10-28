package org.apache.tika.grpc.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class TikaV2ServiceGrpc {

  private TikaV2ServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "org.apache.tika.grpc.v2.TikaV2Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.FetchAndParseRequest,
      org.apache.tika.grpc.v2.FetchAndParseResponse> getFetchAndParseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchAndParse",
      requestType = org.apache.tika.grpc.v2.FetchAndParseRequest.class,
      responseType = org.apache.tika.grpc.v2.FetchAndParseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.FetchAndParseRequest,
      org.apache.tika.grpc.v2.FetchAndParseResponse> getFetchAndParseMethod() {
    io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.FetchAndParseRequest, org.apache.tika.grpc.v2.FetchAndParseResponse> getFetchAndParseMethod;
    if ((getFetchAndParseMethod = TikaV2ServiceGrpc.getFetchAndParseMethod) == null) {
      synchronized (TikaV2ServiceGrpc.class) {
        if ((getFetchAndParseMethod = TikaV2ServiceGrpc.getFetchAndParseMethod) == null) {
          TikaV2ServiceGrpc.getFetchAndParseMethod = getFetchAndParseMethod =
              io.grpc.MethodDescriptor.<org.apache.tika.grpc.v2.FetchAndParseRequest, org.apache.tika.grpc.v2.FetchAndParseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchAndParse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.tika.grpc.v2.FetchAndParseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.tika.grpc.v2.FetchAndParseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TikaV2ServiceMethodDescriptorSupplier("FetchAndParse"))
              .build();
        }
      }
    }
    return getFetchAndParseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest,
      org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse> getFetchAndParseServerSideStreamingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchAndParseServerSideStreaming",
      requestType = org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest.class,
      responseType = org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest,
      org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse> getFetchAndParseServerSideStreamingMethod() {
    io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest, org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse> getFetchAndParseServerSideStreamingMethod;
    if ((getFetchAndParseServerSideStreamingMethod = TikaV2ServiceGrpc.getFetchAndParseServerSideStreamingMethod) == null) {
      synchronized (TikaV2ServiceGrpc.class) {
        if ((getFetchAndParseServerSideStreamingMethod = TikaV2ServiceGrpc.getFetchAndParseServerSideStreamingMethod) == null) {
          TikaV2ServiceGrpc.getFetchAndParseServerSideStreamingMethod = getFetchAndParseServerSideStreamingMethod =
              io.grpc.MethodDescriptor.<org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest, org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchAndParseServerSideStreaming"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TikaV2ServiceMethodDescriptorSupplier("FetchAndParseServerSideStreaming"))
              .build();
        }
      }
    }
    return getFetchAndParseServerSideStreamingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest,
      org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse> getFetchAndParseBiDirectionalStreamingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchAndParseBiDirectionalStreaming",
      requestType = org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest.class,
      responseType = org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest,
      org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse> getFetchAndParseBiDirectionalStreamingMethod() {
    io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest, org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse> getFetchAndParseBiDirectionalStreamingMethod;
    if ((getFetchAndParseBiDirectionalStreamingMethod = TikaV2ServiceGrpc.getFetchAndParseBiDirectionalStreamingMethod) == null) {
      synchronized (TikaV2ServiceGrpc.class) {
        if ((getFetchAndParseBiDirectionalStreamingMethod = TikaV2ServiceGrpc.getFetchAndParseBiDirectionalStreamingMethod) == null) {
          TikaV2ServiceGrpc.getFetchAndParseBiDirectionalStreamingMethod = getFetchAndParseBiDirectionalStreamingMethod =
              io.grpc.MethodDescriptor.<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest, org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchAndParseBiDirectionalStreaming"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TikaV2ServiceMethodDescriptorSupplier("FetchAndParseBiDirectionalStreaming"))
              .build();
        }
      }
    }
    return getFetchAndParseBiDirectionalStreamingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.ParseBytesRequest,
      org.apache.tika.grpc.v2.ParseBytesResponse> getParseBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ParseBytes",
      requestType = org.apache.tika.grpc.v2.ParseBytesRequest.class,
      responseType = org.apache.tika.grpc.v2.ParseBytesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.ParseBytesRequest,
      org.apache.tika.grpc.v2.ParseBytesResponse> getParseBytesMethod() {
    io.grpc.MethodDescriptor<org.apache.tika.grpc.v2.ParseBytesRequest, org.apache.tika.grpc.v2.ParseBytesResponse> getParseBytesMethod;
    if ((getParseBytesMethod = TikaV2ServiceGrpc.getParseBytesMethod) == null) {
      synchronized (TikaV2ServiceGrpc.class) {
        if ((getParseBytesMethod = TikaV2ServiceGrpc.getParseBytesMethod) == null) {
          TikaV2ServiceGrpc.getParseBytesMethod = getParseBytesMethod =
              io.grpc.MethodDescriptor.<org.apache.tika.grpc.v2.ParseBytesRequest, org.apache.tika.grpc.v2.ParseBytesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ParseBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.tika.grpc.v2.ParseBytesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.tika.grpc.v2.ParseBytesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TikaV2ServiceMethodDescriptorSupplier("ParseBytes"))
              .build();
        }
      }
    }
    return getParseBytesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TikaV2ServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TikaV2ServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TikaV2ServiceStub>() {
        @java.lang.Override
        public TikaV2ServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TikaV2ServiceStub(channel, callOptions);
        }
      };
    return TikaV2ServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static TikaV2ServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TikaV2ServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TikaV2ServiceBlockingV2Stub>() {
        @java.lang.Override
        public TikaV2ServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TikaV2ServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return TikaV2ServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TikaV2ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TikaV2ServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TikaV2ServiceBlockingStub>() {
        @java.lang.Override
        public TikaV2ServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TikaV2ServiceBlockingStub(channel, callOptions);
        }
      };
    return TikaV2ServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TikaV2ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TikaV2ServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TikaV2ServiceFutureStub>() {
        @java.lang.Override
        public TikaV2ServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TikaV2ServiceFutureStub(channel, callOptions);
        }
      };
    return TikaV2ServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Fetch via a previously saved fetcher and return a typed Document.
     * </pre>
     */
    default void fetchAndParse(org.apache.tika.grpc.v2.FetchAndParseRequest request,
        io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchAndParseMethod(), responseObserver);
    }

    /**
     * <pre>
     * FetchAndParse as a server stream: one response, then the stream completes.
     * </pre>
     */
    default void fetchAndParseServerSideStreaming(org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest request,
        io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchAndParseServerSideStreamingMethod(), responseObserver);
    }

    /**
     * <pre>
     * One response for each request on the stream.
     * </pre>
     */
    default io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest> fetchAndParseBiDirectionalStreaming(
        io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getFetchAndParseBiDirectionalStreamingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Parses the bytes sent in the request, without a fetcher, and returns the same
     * Document as FetchAndParse.
     * </pre>
     */
    default void parseBytes(org.apache.tika.grpc.v2.ParseBytesRequest request,
        io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.ParseBytesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getParseBytesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TikaV2Service.
   */
  public static abstract class TikaV2ServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TikaV2ServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TikaV2Service.
   */
  public static final class TikaV2ServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TikaV2ServiceStub> {
    private TikaV2ServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TikaV2ServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TikaV2ServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Fetch via a previously saved fetcher and return a typed Document.
     * </pre>
     */
    public void fetchAndParse(org.apache.tika.grpc.v2.FetchAndParseRequest request,
        io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchAndParseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * FetchAndParse as a server stream: one response, then the stream completes.
     * </pre>
     */
    public void fetchAndParseServerSideStreaming(org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest request,
        io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getFetchAndParseServerSideStreamingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * One response for each request on the stream.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest> fetchAndParseBiDirectionalStreaming(
        io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getFetchAndParseBiDirectionalStreamingMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Parses the bytes sent in the request, without a fetcher, and returns the same
     * Document as FetchAndParse.
     * </pre>
     */
    public void parseBytes(org.apache.tika.grpc.v2.ParseBytesRequest request,
        io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.ParseBytesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getParseBytesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TikaV2Service.
   */
  public static final class TikaV2ServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<TikaV2ServiceBlockingV2Stub> {
    private TikaV2ServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TikaV2ServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TikaV2ServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Fetch via a previously saved fetcher and return a typed Document.
     * </pre>
     */
    public org.apache.tika.grpc.v2.FetchAndParseResponse fetchAndParse(org.apache.tika.grpc.v2.FetchAndParseRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchAndParseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * FetchAndParse as a server stream: one response, then the stream completes.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse>
        fetchAndParseServerSideStreaming(org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getFetchAndParseServerSideStreamingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * One response for each request on the stream.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest, org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse>
        fetchAndParseBiDirectionalStreaming() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getFetchAndParseBiDirectionalStreamingMethod(), getCallOptions());
    }

    /**
     * <pre>
     * Parses the bytes sent in the request, without a fetcher, and returns the same
     * Document as FetchAndParse.
     * </pre>
     */
    public org.apache.tika.grpc.v2.ParseBytesResponse parseBytes(org.apache.tika.grpc.v2.ParseBytesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getParseBytesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service TikaV2Service.
   */
  public static final class TikaV2ServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TikaV2ServiceBlockingStub> {
    private TikaV2ServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TikaV2ServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TikaV2ServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Fetch via a previously saved fetcher and return a typed Document.
     * </pre>
     */
    public org.apache.tika.grpc.v2.FetchAndParseResponse fetchAndParse(org.apache.tika.grpc.v2.FetchAndParseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchAndParseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * FetchAndParse as a server stream: one response, then the stream completes.
     * </pre>
     */
    public java.util.Iterator<org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse> fetchAndParseServerSideStreaming(
        org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getFetchAndParseServerSideStreamingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Parses the bytes sent in the request, without a fetcher, and returns the same
     * Document as FetchAndParse.
     * </pre>
     */
    public org.apache.tika.grpc.v2.ParseBytesResponse parseBytes(org.apache.tika.grpc.v2.ParseBytesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getParseBytesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TikaV2Service.
   */
  public static final class TikaV2ServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TikaV2ServiceFutureStub> {
    private TikaV2ServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TikaV2ServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TikaV2ServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Fetch via a previously saved fetcher and return a typed Document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.tika.grpc.v2.FetchAndParseResponse> fetchAndParse(
        org.apache.tika.grpc.v2.FetchAndParseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchAndParseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Parses the bytes sent in the request, without a fetcher, and returns the same
     * Document as FetchAndParse.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.tika.grpc.v2.ParseBytesResponse> parseBytes(
        org.apache.tika.grpc.v2.ParseBytesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getParseBytesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_AND_PARSE = 0;
  private static final int METHODID_FETCH_AND_PARSE_SERVER_SIDE_STREAMING = 1;
  private static final int METHODID_PARSE_BYTES = 2;
  private static final int METHODID_FETCH_AND_PARSE_BI_DIRECTIONAL_STREAMING = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_AND_PARSE:
          serviceImpl.fetchAndParse((org.apache.tika.grpc.v2.FetchAndParseRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseResponse>) responseObserver);
          break;
        case METHODID_FETCH_AND_PARSE_SERVER_SIDE_STREAMING:
          serviceImpl.fetchAndParseServerSideStreaming((org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse>) responseObserver);
          break;
        case METHODID_PARSE_BYTES:
          serviceImpl.parseBytes((org.apache.tika.grpc.v2.ParseBytesRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.ParseBytesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_AND_PARSE_BI_DIRECTIONAL_STREAMING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.fetchAndParseBiDirectionalStreaming(
              (io.grpc.stub.StreamObserver<org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getFetchAndParseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.apache.tika.grpc.v2.FetchAndParseRequest,
              org.apache.tika.grpc.v2.FetchAndParseResponse>(
                service, METHODID_FETCH_AND_PARSE)))
        .addMethod(
          getFetchAndParseServerSideStreamingMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingRequest,
              org.apache.tika.grpc.v2.FetchAndParseServerSideStreamingResponse>(
                service, METHODID_FETCH_AND_PARSE_SERVER_SIDE_STREAMING)))
        .addMethod(
          getFetchAndParseBiDirectionalStreamingMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingRequest,
              org.apache.tika.grpc.v2.FetchAndParseBiDirectionalStreamingResponse>(
                service, METHODID_FETCH_AND_PARSE_BI_DIRECTIONAL_STREAMING)))
        .addMethod(
          getParseBytesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.apache.tika.grpc.v2.ParseBytesRequest,
              org.apache.tika.grpc.v2.ParseBytesResponse>(
                service, METHODID_PARSE_BYTES)))
        .build();
  }

  private static abstract class TikaV2ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TikaV2ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.tika.grpc.v2.TikaV2Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TikaV2Service");
    }
  }

  private static final class TikaV2ServiceFileDescriptorSupplier
      extends TikaV2ServiceBaseDescriptorSupplier {
    TikaV2ServiceFileDescriptorSupplier() {}
  }

  private static final class TikaV2ServiceMethodDescriptorSupplier
      extends TikaV2ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TikaV2ServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TikaV2ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TikaV2ServiceFileDescriptorSupplier())
              .addMethod(getFetchAndParseMethod())
              .addMethod(getFetchAndParseServerSideStreamingMethod())
              .addMethod(getFetchAndParseBiDirectionalStreamingMethod())
              .addMethod(getParseBytesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
