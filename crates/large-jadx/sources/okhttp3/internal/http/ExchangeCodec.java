package okhttp3.internal.http;

import kotlin.Metadata;
import l.b0;
import l.d0;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008f\u0018\u0000 #2\u00020\u0001:\u0001#J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\u000c\u001a\u00020\tH&¢\u0006\u0004\u0008\u000c\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\u0008\u000e\u0010\rJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH&¢\u0006\u0004\u0008\u001e\u0010\rR\u0016\u0010\"\u001a\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!¨\u0006$", d2 = {"Lokhttp3/internal/http/ExchangeCodec;", "", "Lokhttp3/Request;", "request", "", "contentLength", "Ll/b0;", "createRequestBody", "(Lokhttp3/Request;J)Ll/b0;", "Lkotlin/w;", "writeRequestHeaders", "(Lokhttp3/Request;)V", "flushRequest", "()V", "finishRequest", "", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "Lokhttp3/Response;", "response", "reportedContentLength", "(Lokhttp3/Response;)J", "Ll/d0;", "openResponseBodySource", "(Lokhttp3/Response;)Ll/d0;", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "cancel", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface ExchangeCodec {

    public static final okhttp3.internal.http.ExchangeCodec.Companion Companion = null;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/internal/http/ExchangeCodec$Companion;", "", "", "DISCARD_STREAM_TIMEOUT_MILLIS", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        static final okhttp3.internal.http.ExchangeCodec.Companion $$INSTANCE = null;
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
        static {
            ExchangeCodec.Companion companion = new ExchangeCodec.Companion();
            ExchangeCodec.Companion.$$INSTANCE = companion;
        }
    }
    static {
        ExchangeCodec.Companion = ExchangeCodec.Companion.$$INSTANCE;
    }

    public abstract void cancel();

    public abstract b0 createRequestBody(Request request, long l2);

    public abstract void finishRequest();

    public abstract void flushRequest();

    public abstract RealConnection getConnection();

    public abstract d0 openResponseBodySource(Response response);

    public abstract Response.Builder readResponseHeaders(boolean z);

    public abstract long reportedContentLength(Response response);

    public abstract Headers trailers();

    public abstract void writeRequestHeaders(Request request);
}
