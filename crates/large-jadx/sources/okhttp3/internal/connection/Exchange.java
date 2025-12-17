package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import l.b0;
import l.d0;
import l.f;
import l.k;
import l.l;
import l.q;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket.Streams;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001:\u0002QRB'\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010M\u001a\u00020L¢\u0006\u0004\u0008O\u0010PJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0004\u0008\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\u0008\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\u0008\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\u0008\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\u0008\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\u0008 \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\u0008#\u0010$J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\u0008%\u0010\u0011J\r\u0010&\u001a\u00020\u0004¢\u0006\u0004\u0008&\u0010\u0011J\r\u0010'\u001a\u00020\u0004¢\u0006\u0004\u0008'\u0010\u0011J\r\u0010(\u001a\u00020\u0004¢\u0006\u0004\u0008(\u0010\u0011J9\u0010.\u001a\u00028\u0000\"\n\u0008\u0000\u0010)*\u0004\u0018\u00010\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\u0008.\u0010/J\r\u00100\u001a\u00020\u0004¢\u0006\u0004\u00080\u0010\u0011R\u001c\u00102\u001a\u0002018\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u00082\u00103\u001a\u0004\u00084\u00105R\u001c\u00107\u001a\u0002068\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u00087\u00108\u001a\u0004\u00089\u0010:R\u0016\u0010=\u001a\u00020\u000b8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008;\u0010<R\u001c\u0010?\u001a\u00020>8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008?\u0010@\u001a\u0004\u0008A\u0010BR$\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b8\u0000@BX\u0080\u000e¢\u0006\u000c\n\u0004\u0008D\u0010E\u001a\u0004\u0008F\u0010<R\u001c\u0010H\u001a\u00020G8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008H\u0010I\u001a\u0004\u0008J\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008M\u0010N¨\u0006S", d2 = {"Lokhttp3/internal/connection/Exchange;", "", "Ljava/io/IOException;", "e", "Lkotlin/w;", "trackFailure", "(Ljava/io/IOException;)V", "Lokhttp3/Request;", "request", "writeRequestHeaders", "(Lokhttp3/Request;)V", "", "duplex", "Ll/b0;", "createRequestBody", "(Lokhttp3/Request;Z)Ll/b0;", "flushRequest", "()V", "finishRequest", "responseHeadersStart", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "Lokhttp3/Response;", "response", "responseHeadersEnd", "(Lokhttp3/Response;)V", "Lokhttp3/ResponseBody;", "openResponseBody", "(Lokhttp3/Response;)Lokhttp3/ResponseBody;", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "()Lokhttp3/internal/ws/RealWebSocket$Streams;", "webSocketUpgradeFailed", "noNewExchangesOnConnection", "cancel", "detachWithViolence", "E", "", "bytesRead", "responseDone", "requestDone", "bodyComplete", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "noRequestBody", "Lokhttp3/internal/connection/RealConnection;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "isCoalescedConnection$okhttp", "()Z", "isCoalescedConnection", "Lokhttp3/internal/connection/ExchangeFinder;", "finder", "Lokhttp3/internal/connection/ExchangeFinder;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "<set-?>", "isDuplex", "Z", "isDuplex$okhttp", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/internal/connection/RealCall;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "Lokhttp3/internal/http/ExchangeCodec;", "codec", "Lokhttp3/internal/http/ExchangeCodec;", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "RequestBodySink", "ResponseBodySource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Exchange {

    private final okhttp3.internal.connection.RealCall call;
    private final ExchangeCodec codec;
    private final okhttp3.internal.connection.RealConnection connection;
    private final EventListener eventListener;
    private final okhttp3.internal.connection.ExchangeFinder finder;
    private boolean isDuplex;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\u0008\u001a\u0010\u001bJ#\u0010\u0005\u001a\u00028\u0000\"\n\u0008\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001f\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u000c\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\u0010\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0013¨\u0006\u001c", d2 = {"Lokhttp3/internal/connection/Exchange$RequestBodySink;", "Ll/k;", "Ljava/io/IOException;", "E", "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "Ll/f;", "source", "", "byteCount", "Lkotlin/w;", "write", "(Ll/f;J)V", "flush", "()V", "close", "", "completed", "Z", "bytesReceived", "J", "contentLength", "closed", "Ll/b0;", "delegate", "<init>", "(Lokhttp3/internal/connection/Exchange;Ll/b0;J)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class RequestBodySink extends k {

        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final okhttp3.internal.connection.Exchange this$0;
        public RequestBodySink(okhttp3.internal.connection.Exchange exchange, b0 b02, long l3) {
            n.f(b02, "delegate");
            this.this$0 = exchange;
            super(b02);
            this.contentLength = l3;
        }

        private final <E extends IOException> E complete(E e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return this.this$0.bodyComplete(this.bytesReceived, obj3, false, 1);
        }

        @Override // l.k
        public void close() {
            long contentLength;
            int bytesReceived;
            if (this.closed) {
            }
            this.closed = true;
            contentLength = this.contentLength;
            if (Long.compare(contentLength, i3) != 0) {
                if (Long.compare(bytesReceived, contentLength) != 0) {
                } else {
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                throw protocolException;
            }
            super.close();
            complete(0);
        }

        @Override // l.k
        public void flush() {
            try {
                super.flush();
                Throwable complete = complete(complete);
                throw complete;
            }
        }

        @Override // l.k
        public void write(f f, long l2) {
            long contentLength;
            int cmp;
            n.f(f, "source");
            if (closed ^= 1 == 0) {
            } else {
                contentLength = this.contentLength;
                if (Long.compare(contentLength, i4) != 0) {
                    bytesReceived3 += l2;
                    if (Long.compare(cmp, contentLength) > 0) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("expected ");
                    stringBuilder.append(this.contentLength);
                    stringBuilder.append(" bytes but received ");
                    stringBuilder.append(bytesReceived2 += l2);
                    ProtocolException obj5 = new ProtocolException(stringBuilder.toString());
                    throw obj5;
                }
                super.write(f, l2);
                this.bytesReceived = bytesReceived += l2;
            }
            obj5 = new IllegalStateException("closed".toString());
            throw obj5;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\t\u0010\nJ!\u0010\u000e\u001a\u00028\u0000\"\n\u0008\u0000\u0010\u000c*\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0016\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0014¨\u0006\u001c", d2 = {"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Ll/l;", "Ll/f;", "sink", "", "byteCount", "read", "(Ll/f;J)J", "Lkotlin/w;", "close", "()V", "Ljava/io/IOException;", "E", "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "", "closed", "Z", "bytesReceived", "J", "invokeStartEvent", "completed", "contentLength", "Ll/d0;", "delegate", "<init>", "(Lokhttp3/internal/connection/Exchange;Ll/d0;J)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class ResponseBodySource extends l {

        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent = true;
        final okhttp3.internal.connection.Exchange this$0;
        public ResponseBodySource(okhttp3.internal.connection.Exchange exchange, d0 d02, long l3) {
            int obj2;
            n.f(d02, "delegate");
            this.this$0 = exchange;
            super(d02);
            this.contentLength = l3;
            obj2 = 1;
            if (Long.compare(l3, obj2) == 0) {
                complete(0);
            }
        }

        @Override // l.l
        public void close() {
            if (this.closed) {
            }
            this.closed = true;
            super.close();
            complete(0);
        }

        public final <E extends IOException> E complete(E e) {
            int eventListener$okhttp;
            okhttp3.internal.connection.RealCall call$okhttp;
            if (this.completed) {
                return e;
            }
            this.completed = true;
            if (e == 0 && this.invokeStartEvent) {
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
            }
            return this.this$0.bodyComplete(this.bytesReceived, obj4, true, 0);
        }

        @Override // l.l
        public long read(f f, long l2) {
            Object call$okhttp;
            boolean obj10;
            n.f(f, "sink");
            if (closed ^= 1 == 0) {
            } else {
                long obj8 = delegate().read(f, l2);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
                int i2 = -1;
                final int i3 = 0;
                if (Long.compare(obj8, i2) == 0) {
                    complete(i3);
                    return i2;
                }
                bytesReceived += obj8;
                final long contentLength2 = this.contentLength;
                if (Long.compare(contentLength2, i2) != 0) {
                    if (Long.compare(i4, contentLength2) > 0) {
                    } else {
                    }
                    StringBuilder obj9 = new StringBuilder();
                    obj9.append("expected ");
                    obj9.append(this.contentLength);
                    obj9.append(" bytes but received ");
                    obj9.append(i4);
                    obj8 = new ProtocolException(obj9.toString());
                    throw obj8;
                }
                this.bytesReceived = i4;
                if (Long.compare(i4, contentLength2) == 0) {
                    complete(i3);
                }
                try {
                    return obj8;
                    f = complete(f);
                    throw f;
                    obj8 = new IllegalStateException("closed".toString());
                    throw obj8;
                }
            }
        }
    }
    public Exchange(okhttp3.internal.connection.RealCall realCall, EventListener eventListener2, okhttp3.internal.connection.ExchangeFinder exchangeFinder3, ExchangeCodec exchangeCodec4) {
        n.f(realCall, "call");
        n.f(eventListener2, "eventListener");
        n.f(exchangeFinder3, "finder");
        n.f(exchangeCodec4, "codec");
        super();
        this.call = realCall;
        this.eventListener = eventListener2;
        this.finder = exchangeFinder3;
        this.codec = exchangeCodec4;
        this.connection = exchangeCodec4.getConnection();
    }

    private final void trackFailure(IOException iOException) {
        this.finder.trackFailure(iOException);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long l, boolean z2, boolean z3, E e4) {
        EventListener eventListener;
        okhttp3.internal.connection.RealCall call;
        long obj3;
        okhttp3.internal.connection.RealCall obj4;
        if (obj7 != null) {
            trackFailure(obj7);
        }
        if (e4) {
            if (obj7 != null) {
                this.eventListener.requestFailed(this.call, obj7);
            } else {
                this.eventListener.requestBodyEnd(this.call, l);
            }
        }
        if (z3) {
            if (obj7 != null) {
                this.eventListener.responseFailed(this.call, obj7);
            } else {
                this.eventListener.responseBodyEnd(this.call, l);
            }
        }
        return this.call.messageDone$okhttp(this, e4, z3, obj7);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final b0 createRequestBody(Request request, boolean z2) {
        n.f(request, "request");
        this.isDuplex = z2;
        RequestBody obj5 = request.body();
        n.d(obj5);
        long contentLength = obj5.contentLength();
        this.eventListener.requestBodyStart(this.call);
        obj5 = new Exchange.RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength, obj1);
        return obj5;
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        final int i = 1;
        this.call.messageDone$okhttp(this, i, i, 0);
    }

    public final void finishRequest() {
        try {
            this.codec.finishRequest();
            this.eventListener.requestFailed(this.call, th);
            trackFailure(th);
            throw th;
        }
    }

    public final void flushRequest() {
        try {
            this.codec.flushRequest();
            this.eventListener.requestFailed(this.call, th);
            trackFailure(th);
            throw th;
        }
    }

    public final okhttp3.internal.connection.RealCall getCall$okhttp() {
        return this.call;
    }

    public final okhttp3.internal.connection.RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final okhttp3.internal.connection.ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return z ^= 1;
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, 0);
    }

    public final ResponseBody openResponseBody(Response response) {
        n.f(response, "response");
        final int i2 = 0;
        long reportedContentLength = this.codec.reportedContentLength(response);
        Exchange.ResponseBodySource responseBodySource = new Exchange.ResponseBodySource(this, this.codec.openResponseBodySource(response), reportedContentLength, i2);
        RealResponseBody obj5 = new RealResponseBody(Response.header$default(response, "Content-Type", i2, 2, i2), reportedContentLength, i2, q.d(responseBodySource));
        return obj5;
    }

    public final Response.Builder readResponseHeaders(boolean z) {
        try {
            final Response.Builder obj3 = this.codec.readResponseHeaders(z);
            if (obj3 != null) {
            }
            obj3.initExchange$okhttp(this);
            return obj3;
            this.eventListener.responseFailed(this.call, z);
            trackFailure(z);
            throw z;
        }
    }

    public final void responseHeadersEnd(Response response) {
        n.f(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Headers trailers() {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        this.bodyComplete(-1, obj2, true, 1);
    }

    public final void writeRequestHeaders(Request request) {
        n.f(request, "request");
        this.eventListener.requestHeadersStart(this.call);
        this.codec.writeRequestHeaders(request);
        this.eventListener.requestHeadersEnd(this.call, request);
    }
}
