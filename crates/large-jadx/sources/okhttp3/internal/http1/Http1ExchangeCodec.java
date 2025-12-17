package okhttp3.internal.http1;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import l.b0;
import l.d0;
import l.e0;
import l.f;
import l.g;
import l.h;
import l.m;
import okhttp3.Address;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http.StatusLine.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\r\u0018\u0000 R2\u00020\u0001:\u0007STURVWXB)\u0012\u0008\u0010B\u001a\u0004\u0018\u00010A\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\u0008P\u0010QJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\u0008!\u0010\"J\u0017\u0010#\u001a\u00020\u00082\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\u0008#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\u0008&\u0010'J\u000f\u0010(\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008(\u0010\u001cJ\u000f\u0010)\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008)\u0010\u001cJ\u001d\u0010-\u001a\u00020\u00132\u0006\u0010*\u001a\u00020%2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\u0008-\u0010.J\u0019\u00102\u001a\u0004\u0018\u0001012\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\u00082\u00103J\u0015\u00104\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\u00084\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00087\u00108R\u0013\u00109\u001a\u00020/8F@\u0006¢\u0006\u0006\u001a\u0004\u00089\u0010:R\u001a\u0010;\u001a\u00020/*\u00020\u00168B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008>\u0010?R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008&\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008B\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008E\u0010FR\u001c\u0010H\u001a\u00020G8\u0016@\u0016X\u0096\u0004¢\u0006\u000c\n\u0004\u0008H\u0010I\u001a\u0004\u0008J\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008M\u0010NR\u001a\u0010;\u001a\u00020/*\u00020\u001f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008;\u0010O¨\u0006Y", d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "Ll/b0;", "newChunkedSink", "()Ll/b0;", "newKnownLengthSink", "", "length", "Ll/d0;", "newFixedLengthSource", "(J)Ll/d0;", "Lokhttp3/HttpUrl;", "url", "newChunkedSource", "(Lokhttp3/HttpUrl;)Ll/d0;", "newUnknownLengthSource", "()Ll/d0;", "Ll/m;", "timeout", "Lkotlin/w;", "detachTimeout", "(Ll/m;)V", "Lokhttp3/Request;", "request", "contentLength", "createRequestBody", "(Lokhttp3/Request;J)Ll/b0;", "cancel", "()V", "writeRequestHeaders", "(Lokhttp3/Request;)V", "Lokhttp3/Response;", "response", "reportedContentLength", "(Lokhttp3/Response;)J", "openResponseBodySource", "(Lokhttp3/Response;)Ll/d0;", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "flushRequest", "finishRequest", "headers", "", "requestLine", "writeRequest", "(Lokhttp3/Headers;Ljava/lang/String;)V", "", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "skipConnectBody", "(Lokhttp3/Response;)V", "Ll/g;", "sink", "Ll/g;", "isClosed", "()Z", "isChunked", "(Lokhttp3/Request;)Z", "Ll/h;", "source", "Ll/h;", "Lokhttp3/Headers;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "Lokhttp3/internal/http1/HeadersReader;", "headersReader", "Lokhttp3/internal/http1/HeadersReader;", "Lokhttp3/internal/connection/RealConnection;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "", "state", "I", "(Lokhttp3/Response;)Z", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Ll/h;Ll/g;)V", "Companion", "AbstractSource", "ChunkedSink", "ChunkedSource", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http1ExchangeCodec implements ExchangeCodec {

    public static final okhttp3.internal.http1.Http1ExchangeCodec.Companion Companion = null;
    private static final long NO_CHUNK_YET = -1L;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final OkHttpClient client;
    private final RealConnection connection;
    private final okhttp3.internal.http1.HeadersReader headersReader;
    private final g sink;
    private final h source;
    private int state;
    private Headers trailers;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0008\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0007R\u0016\u0010\u000c\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\r\u0010\u0007¨\u0006\u0010", d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$Companion;", "", "", "NO_CHUNK_YET", "J", "", "STATE_CLOSED", "I", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\t\u0010\nJ\r\u0010\u000c\u001a\u00020\u000b¢\u0006\u0004\u0008\u000c\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u00020\u00158\u0004@\u0004X\u0084\u0004¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0016\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006\u001b", d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Ll/d0;", "Ll/e0;", "timeout", "()Ll/e0;", "Ll/f;", "sink", "", "byteCount", "read", "(Ll/f;J)J", "Lkotlin/w;", "responseBodyComplete", "()V", "", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "Ll/m;", "Ll/m;", "getTimeout", "()Ll/m;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private abstract class AbstractSource implements d0 {

        private boolean closed;
        final okhttp3.internal.http1.Http1ExchangeCodec this$0;
        private final m timeout;
        public AbstractSource(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
            this.this$0 = http1ExchangeCodec;
            super();
            m mVar = new m(Http1ExchangeCodec.access$getSource$p(http1ExchangeCodec).timeout());
            this.timeout = mVar;
        }

        @Override // l.d0
        public abstract void close();

        @Override // l.d0
        protected final boolean getClosed() {
            return this.closed;
        }

        @Override // l.d0
        protected final m getTimeout() {
            return this.timeout;
        }

        @Override // l.d0
        public long read(f f, long l2) {
            n.f(f, "sink");
            return Http1ExchangeCodec.access$getSource$p(this.this$0).read(f, l2);
        }

        @Override // l.d0
        public final void responseBodyComplete() {
            int i3 = 6;
            if (Http1ExchangeCodec.access$getState$p(this.this$0) == i3) {
            }
            if (Http1ExchangeCodec.access$getState$p(this.this$0) != 5) {
            } else {
                Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
                Http1ExchangeCodec.access$setState$p(this.this$0, i3);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("state: ");
            stringBuilder.append(Http1ExchangeCodec.access$getState$p(this.this$0));
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }

        @Override // l.d0
        protected final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // l.d0
        public e0 timeout() {
            return this.timeout;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\u000c\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u000c\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u000e\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0013¨\u0006\u0016", d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Ll/b0;", "Ll/e0;", "timeout", "()Ll/e0;", "Ll/f;", "source", "", "byteCount", "Lkotlin/w;", "write", "(Ll/f;J)V", "flush", "()V", "close", "", "closed", "Z", "Ll/m;", "Ll/m;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class ChunkedSink implements b0 {

        private boolean closed;
        final okhttp3.internal.http1.Http1ExchangeCodec this$0;
        private final m timeout;
        public ChunkedSink(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
            this.this$0 = http1ExchangeCodec;
            super();
            m mVar = new m(Http1ExchangeCodec.access$getSink$p(http1ExchangeCodec).timeout());
            this.timeout = mVar;
        }

        @Override // l.b0
        public void close() {
            synchronized (this) {
                try {
                    this.closed = true;
                    Http1ExchangeCodec.access$getSink$p(this.this$0).E0("0\r\n\r\n");
                    Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
                    Http1ExchangeCodec.access$setState$p(this.this$0, 3);
                }
            }
        }

        @Override // l.b0
        public void flush() {
            synchronized (this) {
                try {
                    Http1ExchangeCodec.access$getSink$p(this.this$0).flush();
                }
            }
        }

        @Override // l.b0
        public e0 timeout() {
            return this.timeout;
        }

        @Override // l.b0
        public void write(f f, long l2) {
            n.f(f, "source");
            if (closed ^= 1 == 0) {
            } else {
                if (Long.compare(l2, i2) == 0) {
                }
                Http1ExchangeCodec.access$getSink$p(this.this$0).X0(l2);
                final String str2 = "\r\n";
                Http1ExchangeCodec.access$getSink$p(this.this$0).E0(str2);
                Http1ExchangeCodec.access$getSink$p(this.this$0).write(f, l2);
                Http1ExchangeCodec.access$getSink$p(this.this$0).E0(str2);
            }
            IllegalStateException obj3 = new IllegalStateException("closed".toString());
            throw obj3;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\u000c\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u000c\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u000e\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0013¨\u0006\u0016", d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Ll/b0;", "Ll/e0;", "timeout", "()Ll/e0;", "Ll/f;", "source", "", "byteCount", "Lkotlin/w;", "write", "(Ll/f;J)V", "flush", "()V", "close", "", "closed", "Z", "Ll/m;", "Ll/m;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class KnownLengthSink implements b0 {

        private boolean closed;
        final okhttp3.internal.http1.Http1ExchangeCodec this$0;
        private final m timeout;
        public KnownLengthSink(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
            this.this$0 = http1ExchangeCodec;
            super();
            m mVar = new m(Http1ExchangeCodec.access$getSink$p(http1ExchangeCodec).timeout());
            this.timeout = mVar;
        }

        @Override // l.b0
        public void close() {
            if (this.closed) {
            }
            this.closed = true;
            Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
            Http1ExchangeCodec.access$setState$p(this.this$0, 3);
        }

        @Override // l.b0
        public void flush() {
            if (this.closed) {
            }
            Http1ExchangeCodec.access$getSink$p(this.this$0).flush();
        }

        @Override // l.b0
        public e0 timeout() {
            return this.timeout;
        }

        @Override // l.b0
        public void write(f f, long l2) {
            n.f(f, "source");
            if (closed ^= 1 == 0) {
            } else {
                Util.checkOffsetAndCount(f.size(), obj2, 0);
                Http1ExchangeCodec.access$getSink$p(this.this$0).write(f, l2);
            }
            IllegalStateException obj8 = new IllegalStateException("closed".toString());
            throw obj8;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\u000c\u001a\u00020\u0003H\u0016¢\u0006\u0004\u0008\u000c\u0010\u0005R\u0016\u0010\r\u001a\u00020\u00088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014¨\u0006\u0017", d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lkotlin/w;", "readChunkSize", "()V", "Ll/f;", "sink", "", "byteCount", "read", "(Ll/f;J)J", "close", "bytesRemainingInChunk", "J", "Lokhttp3/HttpUrl;", "url", "Lokhttp3/HttpUrl;", "", "hasMoreChunks", "Z", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class ChunkedSource extends okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource {

        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        final okhttp3.internal.http1.Http1ExchangeCodec this$0;
        private final HttpUrl url;
        public ChunkedSource(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl2) {
            n.f(httpUrl2, "url");
            this.this$0 = http1ExchangeCodec;
            super(http1ExchangeCodec);
            this.url = httpUrl2;
            int obj2 = -1;
            obj2 = 1;
        }

        private final void readChunkSize() {
            int cmp;
            int cookieJar;
            int cmp2;
            int i;
            int i2;
            int i3;
            if (Long.compare(bytesRemainingInChunk, i) != 0) {
                Http1ExchangeCodec.access$getSource$p(this.this$0).m1();
            }
            this.bytesRemainingInChunk = Http1ExchangeCodec.access$getSource$p(this.this$0).d2();
            String str = Http1ExchangeCodec.access$getSource$p(this.this$0).m1();
            if (str == null) {
            } else {
                String string = l.a1(str).toString();
                int i5 = 0;
                if (Long.compare(bytesRemainingInChunk3, i5) < 0) {
                } else {
                    i = 0;
                    cmp2 = string.length() > 0 ? 1 : i;
                    if (cmp2 != 0 && l.M(string, ";", i, 2, 0)) {
                        if (!l.M(string, ";", i, 2, 0)) {
                        } else {
                            if (Long.compare(bytesRemainingInChunk2, i5) == 0) {
                                this.hasMoreChunks = i;
                                okhttp3.internal.http1.Http1ExchangeCodec this$03 = this.this$0;
                                Http1ExchangeCodec.access$setTrailers$p(this$03, Http1ExchangeCodec.access$getHeadersReader$p(this$03).readHeaders());
                                OkHttpClient client = Http1ExchangeCodec.access$getClient$p(this.this$0);
                                n.d(client);
                                i = Http1ExchangeCodec.access$getTrailers$p(this.this$0);
                                n.d(i);
                                HttpHeaders.receiveHeaders(client.cookieJar(), this.url, i);
                                responseBodyComplete();
                            }
                        }
                    } else {
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("expected chunk size and optional extensions");
                stringBuilder.append(" but was \"");
                stringBuilder.append(this.bytesRemainingInChunk);
                stringBuilder.append(string);
                stringBuilder.append('"');
                ProtocolException protocolException2 = new ProtocolException(stringBuilder.toString());
                throw protocolException2;
            }
            NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            throw nullPointerException;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
        public void close() {
            boolean hasMoreChunks;
            TimeUnit mILLISECONDS;
            if (getClosed()) {
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                if (!Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.this$0.getConnection().noNewExchanges$okhttp();
                    responseBodyComplete();
                }
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
        public long read(f f, long l2) {
            boolean hasMoreChunks;
            int i;
            n.f(f, "sink");
            int i2 = 0;
            int i5 = 1;
            i = Long.compare(l2, i2) >= 0 ? i5 : 0;
            if (i == 0) {
            } else {
                if (closed ^= i5 == 0) {
                } else {
                    int i6 = -1;
                    if (!this.hasMoreChunks) {
                        return i6;
                    }
                    final long bytesRemainingInChunk3 = this.bytesRemainingInChunk;
                    if (Long.compare(bytesRemainingInChunk3, i2) != 0) {
                        readChunkSize();
                        if (Long.compare(bytesRemainingInChunk3, i6) == 0 && !this.hasMoreChunks) {
                            readChunkSize();
                            if (!this.hasMoreChunks) {
                                return i6;
                            }
                        }
                    } else {
                    }
                    long obj8 = super.read(f, Math.min(l2, obj10));
                    if (Long.compare(obj8, i6) == 0) {
                    } else {
                        this.bytesRemainingInChunk = bytesRemainingInChunk2 -= obj8;
                        return obj8;
                    }
                    this.this$0.getConnection().noNewExchanges$okhttp();
                    obj8 = new ProtocolException("unexpected end of stream");
                    responseBodyComplete();
                    throw obj8;
                }
                obj8 = new IllegalStateException("closed".toString());
                throw obj8;
            }
            obj8 = new StringBuilder();
            obj8.append("byteCount < 0: ");
            obj8.append(l2);
            IllegalArgumentException obj9 = new IllegalArgumentException(obj8.toString().toString());
            throw obj9;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u000c\u001a\u00020\u0005¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u0016\u0010\u000c\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000c\u0010\r¨\u0006\u0010", d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "Ll/f;", "sink", "", "byteCount", "read", "(Ll/f;J)J", "Lkotlin/w;", "close", "()V", "bytesRemaining", "J", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class FixedLengthSource extends okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource {

        private long bytesRemaining;
        final okhttp3.internal.http1.Http1ExchangeCodec this$0;
        public FixedLengthSource(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec, long l2) {
            this.this$0 = http1ExchangeCodec;
            super(http1ExchangeCodec);
            this.bytesRemaining = l2;
            if (Long.compare(l2, i) == 0) {
                responseBodyComplete();
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
        public void close() {
            int connection;
            TimeUnit mILLISECONDS;
            if (getClosed()) {
            }
            if (Long.compare(bytesRemaining, i3) != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                if (!Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.this$0.getConnection().noNewExchanges$okhttp();
                    responseBodyComplete();
                }
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
        public long read(f f, long l2) {
            int i;
            n.f(f, "sink");
            int i2 = 0;
            final int i5 = 1;
            i = Long.compare(l2, i2) >= 0 ? i5 : 0;
            if (i == 0) {
            } else {
                if (closed ^= i5 == 0) {
                } else {
                    long bytesRemaining = this.bytesRemaining;
                    final int i6 = -1;
                    if (Long.compare(bytesRemaining, i2) == 0) {
                        return i6;
                    }
                    long obj8 = super.read(f, Math.min(bytesRemaining, i5));
                    if (Long.compare(obj8, i6) == 0) {
                    } else {
                        bytesRemaining2 -= obj8;
                        this.bytesRemaining = i4;
                        if (Long.compare(i4, i2) == 0) {
                            responseBodyComplete();
                        }
                        return obj8;
                    }
                    this.this$0.getConnection().noNewExchanges$okhttp();
                    obj8 = new ProtocolException("unexpected end of stream");
                    responseBodyComplete();
                    throw obj8;
                }
                obj8 = new IllegalStateException("closed".toString());
                throw obj8;
            }
            obj8 = new StringBuilder();
            obj8.append("byteCount < 0: ");
            obj8.append(l2);
            IllegalArgumentException obj9 = new IllegalArgumentException(obj8.toString().toString());
            throw obj9;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\u000c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\r\u0010\u000e¨\u0006\u0011", d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "Ll/f;", "sink", "", "byteCount", "read", "(Ll/f;J)J", "Lkotlin/w;", "close", "()V", "", "inputExhausted", "Z", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class UnknownLengthSource extends okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource {

        private boolean inputExhausted;
        final okhttp3.internal.http1.Http1ExchangeCodec this$0;
        public UnknownLengthSource(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
            this.this$0 = http1ExchangeCodec;
            super(http1ExchangeCodec);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
        public void close() {
            if (getClosed()) {
            }
            if (!this.inputExhausted) {
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
        public long read(f f, long l2) {
            int i;
            n.f(f, "sink");
            final int i4 = 1;
            i = Long.compare(l2, i2) >= 0 ? i4 : 0;
            if (i == 0) {
            } else {
                if (closed ^= i4 == 0) {
                } else {
                    final int i5 = -1;
                    if (this.inputExhausted) {
                        return i5;
                    }
                    long obj5 = super.read(f, l2);
                    if (Long.compare(obj5, i5) == 0) {
                        this.inputExhausted = i4;
                        responseBodyComplete();
                        return i5;
                    }
                    return obj5;
                }
                obj5 = new IllegalStateException("closed".toString());
                throw obj5;
            }
            obj5 = new StringBuilder();
            obj5.append("byteCount < 0: ");
            obj5.append(l2);
            IllegalArgumentException obj6 = new IllegalArgumentException(obj5.toString().toString());
            throw obj6;
        }
    }
    static {
        Http1ExchangeCodec.Companion companion = new Http1ExchangeCodec.Companion(0);
        Http1ExchangeCodec.Companion = companion;
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection2, h h3, g g4) {
        n.f(realConnection2, "connection");
        n.f(h3, "source");
        n.f(g4, "sink");
        super();
        this.client = okHttpClient;
        this.connection = realConnection2;
        this.source = h3;
        this.sink = g4;
        HeadersReader obj2 = new HeadersReader(h3);
        this.headersReader = obj2;
    }

    public static final void access$detachTimeout(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec, m m2) {
        http1ExchangeCodec.detachTimeout(m2);
    }

    public static final OkHttpClient access$getClient$p(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.client;
    }

    public static final okhttp3.internal.http1.HeadersReader access$getHeadersReader$p(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.headersReader;
    }

    public static final g access$getSink$p(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.sink;
    }

    public static final h access$getSource$p(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.source;
    }

    public static final int access$getState$p(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.state;
    }

    public static final Headers access$getTrailers$p(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.trailers;
    }

    public static final void access$setState$p(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec, int i2) {
        http1ExchangeCodec.state = i2;
    }

    public static final void access$setTrailers$p(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec, Headers headers2) {
        http1ExchangeCodec.trailers = headers2;
    }

    private final void detachTimeout(m m) {
        final e0 e0Var = m.a();
        m.b(e0.NONE);
        e0Var.clearDeadline();
        e0Var.clearTimeout();
    }

    private final boolean isChunked(Request request) {
        return l.x("chunked", request.header("Transfer-Encoding"), true);
    }

    private final boolean isChunked(Response response) {
        int i = 0;
        return l.x("chunked", Response.header$default(response, "Transfer-Encoding", i, 2, i), true);
    }

    private final b0 newChunkedSink() {
        int i;
        if (this.state == 1) {
        } else {
            i = 0;
        }
        if (i == 0) {
        } else {
            this.state = 2;
            Http1ExchangeCodec.ChunkedSink chunkedSink = new Http1ExchangeCodec.ChunkedSink(this);
            return chunkedSink;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.state);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
        throw illegalStateException;
    }

    private final d0 newChunkedSource(HttpUrl httpUrl) {
        int i;
        i = this.state == 4 ? 1 : 0;
        if (i == 0) {
        } else {
            this.state = 5;
            Http1ExchangeCodec.ChunkedSource chunkedSource = new Http1ExchangeCodec.ChunkedSource(this, httpUrl);
            return chunkedSource;
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("state: ");
        obj3.append(this.state);
        IllegalStateException illegalStateException = new IllegalStateException(obj3.toString().toString());
        throw illegalStateException;
    }

    private final d0 newFixedLengthSource(long l) {
        int i;
        i = this.state == 4 ? 1 : 0;
        if (i == 0) {
        } else {
            this.state = 5;
            Http1ExchangeCodec.FixedLengthSource fixedLengthSource = new Http1ExchangeCodec.FixedLengthSource(this, l, obj4);
            return fixedLengthSource;
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("state: ");
        obj3.append(this.state);
        IllegalStateException obj4 = new IllegalStateException(obj3.toString().toString());
        throw obj4;
    }

    private final b0 newKnownLengthSink() {
        int i;
        if (this.state == 1) {
        } else {
            i = 0;
        }
        if (i == 0) {
        } else {
            this.state = 2;
            Http1ExchangeCodec.KnownLengthSink knownLengthSink = new Http1ExchangeCodec.KnownLengthSink(this);
            return knownLengthSink;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.state);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
        throw illegalStateException;
    }

    private final d0 newUnknownLengthSource() {
        int i;
        i = this.state == 4 ? 1 : 0;
        if (i == 0) {
        } else {
            this.state = 5;
            getConnection().noNewExchanges$okhttp();
            Http1ExchangeCodec.UnknownLengthSource unknownLengthSource = new Http1ExchangeCodec.UnknownLengthSource(this);
            return unknownLengthSource;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state: ");
        stringBuilder.append(this.state);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
        throw illegalStateException;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getConnection().cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public b0 createRequestBody(Request request, long l2) {
        RequestBody duplex;
        b0 obj3;
        n.f(request, "request");
        if (request.body() != null) {
            if (request.body().isDuplex()) {
            } else {
            }
            obj3 = new ProtocolException("Duplex connections are not supported for HTTP/1");
            throw obj3;
        }
        if (isChunked(request)) {
            obj3 = newChunkedSink();
            return obj3;
        } else {
            if (Long.compare(l2, duplex) == 0) {
            } else {
                obj3 = newKnownLengthSink();
            }
        }
        obj3 = new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        throw obj3;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final boolean isClosed() {
        int i;
        i = this.state == 6 ? 1 : 0;
        return i;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public d0 openResponseBodySource(Response response) {
        boolean headersContentLength;
        int i;
        d0 obj5;
        n.f(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            obj5 = newFixedLengthSource(0);
        } else {
            if (isChunked(response)) {
                obj5 = newChunkedSource(response.request().url());
            } else {
                headersContentLength = Util.headersContentLength(response);
                if (Long.compare(headersContentLength, i) != 0) {
                    obj5 = newFixedLengthSource(headersContentLength);
                } else {
                    obj5 = newUnknownLengthSource();
                }
            }
        }
        return obj5;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z) {
        int i;
        int headers;
        int obj5;
        int state = this.state;
        final int i2 = 3;
        if (state != 1) {
            if (state == i2) {
            } else {
                i = 0;
            }
        }
        if (i == 0) {
        } else {
            StatusLine parse = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder builder = new Response.Builder();
            headers = builder.protocol(parse.protocol).code(parse.code).message(parse.message).headers(this.headersReader.readHeaders());
            int i3 = 100;
            if (z != null && parse.code == i3) {
                if (parse.code == i3) {
                    headers = 0;
                } else {
                    if (parse.code == i3) {
                        this.state = i2;
                    } else {
                        this.state = 4;
                    }
                }
            } else {
            }
            return headers;
        }
        obj5 = new StringBuilder();
        obj5.append("state: ");
        obj5.append(this.state);
        IllegalStateException illegalStateException = new IllegalStateException(obj5.toString().toString());
        throw illegalStateException;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        int headersContentLength;
        n.f(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            headersContentLength = 0;
        } else {
            if (isChunked(response)) {
                headersContentLength = -1;
            } else {
                headersContentLength = Util.headersContentLength(response);
            }
        }
        return headersContentLength;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void skipConnectBody(Response response) {
        n.f(response, "response");
        long headersContentLength = Util.headersContentLength(response);
        if (Long.compare(headersContentLength, i2) == 0) {
        }
        d0 obj5 = newFixedLengthSource(headersContentLength);
        Util.skipAll(obj5, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        obj5.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers trailers() {
        int i;
        Headers eMPTY_HEADERS;
        i = this.state == 6 ? 1 : 0;
        if (i == 0) {
        } else {
            if (this.trailers != null) {
            } else {
                eMPTY_HEADERS = Util.EMPTY_HEADERS;
            }
            return eMPTY_HEADERS;
        }
        IllegalStateException illegalStateException = new IllegalStateException("too early; can't read the trailers yet".toString());
        throw illegalStateException;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void writeRequest(Headers headers, String string2) {
        int i2;
        int i;
        g gVar;
        String value;
        n.f(headers, "headers");
        n.f(string2, "requestLine");
        final int i3 = 1;
        i2 = this.state == 0 ? i3 : i;
        if (i2 == 0) {
        } else {
            String str3 = "\r\n";
            this.sink.E0(string2).E0(str3);
            while (i < headers.size()) {
                this.sink.E0(headers.name(i)).E0(": ").E0(headers.value(i)).E0(str3);
                i++;
            }
            this.sink.E0(str3);
            this.state = i3;
        }
        StringBuilder obj6 = new StringBuilder();
        obj6.append("state: ");
        obj6.append(this.state);
        IllegalStateException obj7 = new IllegalStateException(obj6.toString().toString());
        throw obj7;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        n.f(request, "request");
        java.net.Proxy.Type type = getConnection().route().proxy().type();
        n.e(type, "connection.route().proxy.type()");
        writeRequest(request.headers(), RequestLine.INSTANCE.get(request, type));
    }
}
