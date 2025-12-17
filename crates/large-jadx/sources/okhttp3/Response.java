package okhttp3;

import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import l.f;
import l.h;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u00002\u00020\u0001:\u0001XB}\u0008\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u001d\u0012\u0008\u0010(\u001a\u0004\u0018\u00010#\u0012\u0008\u0010.\u001a\u0004\u0018\u00010\u0000\u0012\u0008\u00100\u001a\u0004\u0018\u00010\u0000\u0012\u0008\u00102\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010<\u001a\u00020!\u0012\u0006\u0010>\u001a\u00020!\u0012\u0008\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\u0008V\u0010WJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\u0008\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\u0008\u0018\u0010\u0019J%\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u000f\u0010\u0018\u001a\u00020\u001dH\u0007¢\u0006\u0004\u0008\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u001d¢\u0006\u0004\u0008 \u0010\u001fJ\u0015\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\u0008$\u0010%J\u0011\u0010(\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0004\u0008&\u0010'J\r\u0010*\u001a\u00020)¢\u0006\u0004\u0008*\u0010+J\u0011\u0010.\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\u0008,\u0010-J\u0011\u00100\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\u0008/\u0010-J\u0011\u00102\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\u00081\u0010-J\u0013\u00104\u001a\u0008\u0012\u0004\u0012\u0002030\u0017¢\u0006\u0004\u00084\u00105J\u000f\u00109\u001a\u000206H\u0007¢\u0006\u0004\u00087\u00108J\u000f\u0010<\u001a\u00020!H\u0007¢\u0006\u0004\u0008:\u0010;J\u000f\u0010>\u001a\u00020!H\u0007¢\u0006\u0004\u0008=\u0010;J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\u0008@\u0010AJ\u000f\u0010B\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008B\u0010\u0010R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0015\u0010C\u001a\u0004\u0008\u0015\u0010\u0014R\u0013\u00109\u001a\u0002068G@\u0006¢\u0006\u0006\u001a\u0004\u00089\u00108R\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008(\u0010D\u001a\u0004\u0008(\u0010'R\u0019\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010E\u001a\u0004\u0008\r\u0010\u000cR\u001b\u00102\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\u000c\n\u0004\u00082\u0010F\u001a\u0004\u00082\u0010-R\u001b\u0010.\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\u000c\n\u0004\u0008.\u0010F\u001a\u0004\u0008.\u0010-R\u0019\u0010>\u001a\u00020!8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008>\u0010G\u001a\u0004\u0008>\u0010;R\u0013\u0010I\u001a\u00020H8F@\u0006¢\u0006\u0006\u001a\u0004\u0008I\u0010JR\u0019\u0010\u0018\u001a\u00020\u001d8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0018\u0010K\u001a\u0004\u0008\u0018\u0010\u001fR\u001b\u00100\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\u000c\n\u0004\u00080\u0010F\u001a\u0004\u00080\u0010-R\u0018\u0010L\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008L\u0010MR\u0019\u0010<\u001a\u00020!8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008<\u0010G\u001a\u0004\u0008<\u0010;R\u001e\u0010O\u001a\u0004\u0018\u00010N8\u0001@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008O\u0010P\u001a\u0004\u0008O\u0010QR\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010R\u001a\u0004\u0008\u0005\u0010\u0004R\u0013\u0010S\u001a\u00020H8F@\u0006¢\u0006\u0006\u001a\u0004\u0008S\u0010JR\u0019\u0010\u0011\u001a\u00020\u000e8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0011\u0010T\u001a\u0004\u0008\u0011\u0010\u0010R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010U\u001a\u0004\u0008\t\u0010\u0008¨\u0006Y", d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", "Lokhttp3/Request;", "-deprecated_request", "()Lokhttp3/Request;", "request", "Lokhttp3/Protocol;", "-deprecated_protocol", "()Lokhttp3/Protocol;", "protocol", "", "-deprecated_code", "()I", "code", "", "-deprecated_message", "()Ljava/lang/String;", "message", "Lokhttp3/Handshake;", "-deprecated_handshake", "()Lokhttp3/Handshake;", "handshake", "name", "", "headers", "(Ljava/lang/String;)Ljava/util/List;", "defaultValue", "header", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/Headers;", "-deprecated_headers", "()Lokhttp3/Headers;", "trailers", "", "byteCount", "Lokhttp3/ResponseBody;", "peekBody", "(J)Lokhttp3/ResponseBody;", "-deprecated_body", "()Lokhttp3/ResponseBody;", "body", "Lokhttp3/Response$Builder;", "newBuilder", "()Lokhttp3/Response$Builder;", "-deprecated_networkResponse", "()Lokhttp3/Response;", "networkResponse", "-deprecated_cacheResponse", "cacheResponse", "-deprecated_priorResponse", "priorResponse", "Lokhttp3/Challenge;", "challenges", "()Ljava/util/List;", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "-deprecated_sentRequestAtMillis", "()J", "sentRequestAtMillis", "-deprecated_receivedResponseAtMillis", "receivedResponseAtMillis", "Lkotlin/w;", "close", "()V", "toString", "Lokhttp3/Handshake;", "Lokhttp3/ResponseBody;", "I", "Lokhttp3/Response;", "J", "", "isRedirect", "()Z", "Lokhttp3/Headers;", "lazyCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/internal/connection/Exchange;", "Lokhttp3/Request;", "isSuccessful", "Ljava/lang/String;", "Lokhttp3/Protocol;", "<init>", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Response implements Closeable {

    private final okhttp3.ResponseBody body;
    private final okhttp3.Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final okhttp3.Handshake handshake;
    private final okhttp3.Headers headers;
    private okhttp3.CacheControl lazyCacheControl;
    private final String message;
    private final okhttp3.Response networkResponse;
    private final okhttp3.Response priorResponse;
    private final okhttp3.Protocol protocol;
    private final long receivedResponseAtMillis;
    private final okhttp3.Request request;
    private final long sentRequestAtMillis;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008&\n\u0002\u0018\u0002\n\u0002\u0008\u0019\u0008\u0016\u0018\u00002\u00020\u0001B\t\u0008\u0016¢\u0006\u0004\u0008j\u0010kB\u0011\u0008\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008j\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0019\u0010\t\u001a\u00020\u00062\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0017\u0010\u000c\u001a\u00020\u00002\u0006\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\u000c\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00002\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u001d\u0010\u0015J\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\u0008\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u00002\u0008\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\u0008\"\u0010#J\u0019\u0010$\u001a\u00020\u00002\u0008\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\u0008$\u0010%J\u0019\u0010&\u001a\u00020\u00002\u0008\u0010&\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\u0008&\u0010%J\u0019\u0010'\u001a\u00020\u00002\u0008\u0010'\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\u0008'\u0010%J\u0017\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\u0008)\u0010*J\u0017\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020(H\u0016¢\u0006\u0004\u0008+\u0010*J\u0017\u00100\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0000¢\u0006\u0004\u0008.\u0010/J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\u00081\u00102R$\u0010\u000c\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u000c\u00103\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R$\u0010'\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008'\u00108\u001a\u0004\u00089\u00102\"\u0004\u0008:\u0010\nR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0017\u0010;\u001a\u0004\u0008<\u0010=\"\u0004\u0008>\u0010?R$\u0010\"\u001a\u0004\u0018\u00010!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\"\u0010@\u001a\u0004\u0008A\u0010B\"\u0004\u0008C\u0010DR\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0012\u0010E\u001a\u0004\u0008F\u0010G\"\u0004\u0008H\u0010IR$\u0010$\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008$\u00108\u001a\u0004\u0008J\u00102\"\u0004\u0008K\u0010\nR$\u0010&\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008&\u00108\u001a\u0004\u0008L\u00102\"\u0004\u0008M\u0010\nR\"\u0010+\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008+\u0010N\u001a\u0004\u0008O\u0010P\"\u0004\u0008Q\u0010RR\"\u0010\u001f\u001a\u00020S8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u001f\u0010T\u001a\u0004\u0008U\u0010V\"\u0004\u0008W\u0010XR\"\u0010)\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008)\u0010N\u001a\u0004\u0008Y\u0010P\"\u0004\u0008Z\u0010RR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u000f\u0010[\u001a\u0004\u0008\\\u0010]\"\u0004\u0008^\u0010_R$\u0010`\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008`\u0010a\u001a\u0004\u0008b\u0010c\"\u0004\u0008d\u0010/R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0014\u0010e\u001a\u0004\u0008f\u0010g\"\u0004\u0008h\u0010i¨\u0006l", d2 = {"Lokhttp3/Response$Builder;", "", "", "name", "Lokhttp3/Response;", "response", "Lkotlin/w;", "checkSupportResponse", "(Ljava/lang/String;Lokhttp3/Response;)V", "checkPriorResponse", "(Lokhttp3/Response;)V", "Lokhttp3/Request;", "request", "(Lokhttp3/Request;)Lokhttp3/Response$Builder;", "Lokhttp3/Protocol;", "protocol", "(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;", "", "code", "(I)Lokhttp3/Response$Builder;", "message", "(Ljava/lang/String;)Lokhttp3/Response$Builder;", "Lokhttp3/Handshake;", "handshake", "(Lokhttp3/Handshake;)Lokhttp3/Response$Builder;", "value", "header", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Response$Builder;", "Lokhttp3/ResponseBody;", "body", "(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;", "networkResponse", "(Lokhttp3/Response;)Lokhttp3/Response$Builder;", "cacheResponse", "priorResponse", "", "sentRequestAtMillis", "(J)Lokhttp3/Response$Builder;", "receivedResponseAtMillis", "Lokhttp3/internal/connection/Exchange;", "deferredTrailers", "initExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "initExchange", "build", "()Lokhttp3/Response;", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "Lokhttp3/Response;", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "I", "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "J", "getReceivedResponseAtMillis$okhttp", "()J", "setReceivedResponseAtMillis$okhttp", "(J)V", "Lokhttp3/Headers$Builder;", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "getSentRequestAtMillis$okhttp", "setSentRequestAtMillis$okhttp", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "exchange", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static class Builder {

        private okhttp3.ResponseBody body;
        private okhttp3.Response cacheResponse;
        private int code = -1;
        private Exchange exchange;
        private okhttp3.Handshake handshake;
        private okhttp3.Headers.Builder headers;
        private String message;
        private okhttp3.Response networkResponse;
        private okhttp3.Response priorResponse;
        private okhttp3.Protocol protocol;
        private long receivedResponseAtMillis;
        private okhttp3.Request request;
        private long sentRequestAtMillis;
        public Builder() {
            super();
            int i = -1;
            Headers.Builder builder = new Headers.Builder();
            this.headers = builder;
        }

        public Builder(okhttp3.Response response) {
            n.f(response, "response");
            super();
            int i = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }

        private final void checkPriorResponse(okhttp3.Response response) {
            int obj2;
            if (response != null) {
                obj2 = response.body() == null ? 1 : 0;
                if (obj2 == null) {
                } else {
                }
                obj2 = new IllegalArgumentException("priorResponse.body != null".toString());
                throw obj2;
            }
        }

        private final void checkSupportResponse(String string, okhttp3.Response response2) {
            int i2;
            int i;
            int i5;
            int i3;
            int i4;
            okhttp3.Response obj5;
            if (response2 != null) {
                i3 = 1;
                i4 = 0;
                i = response2.body() == null ? i3 : i4;
                if (i == 0) {
                } else {
                    i5 = response2.networkResponse() == null ? i3 : i4;
                    if (i5 == 0) {
                    } else {
                        i2 = response2.cacheResponse() == null ? i3 : i4;
                        if (i2 == 0) {
                        } else {
                            if (response2.priorResponse() == null) {
                            } else {
                                i3 = i4;
                            }
                            if (i3 == 0) {
                            } else {
                            }
                            obj5 = new StringBuilder();
                            obj5.append(string);
                            obj5.append(".priorResponse != null");
                            obj5 = new IllegalArgumentException(obj5.toString().toString());
                            throw obj5;
                        }
                        obj5 = new StringBuilder();
                        obj5.append(string);
                        obj5.append(".cacheResponse != null");
                        obj5 = new IllegalArgumentException(obj5.toString().toString());
                        throw obj5;
                    }
                    obj5 = new StringBuilder();
                    obj5.append(string);
                    obj5.append(".networkResponse != null");
                    obj5 = new IllegalArgumentException(obj5.toString().toString());
                    throw obj5;
                }
                obj5 = new StringBuilder();
                obj5.append(string);
                obj5.append(".body != null");
                obj5 = new IllegalArgumentException(obj5.toString().toString());
                throw obj5;
            }
        }

        public okhttp3.Response.Builder addHeader(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "value");
            this.headers.add(string, string2);
            return this;
        }

        public okhttp3.Response.Builder body(okhttp3.ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public okhttp3.Response build() {
            int i;
            final Object obj = this;
            final int code2 = obj.code;
            i = code2 >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                okhttp3.Request request = obj.request;
                if (request == null) {
                } else {
                    final okhttp3.Protocol protocol = obj.protocol;
                    if (protocol == null) {
                    } else {
                        final String message = obj.message;
                        if (message == null) {
                        } else {
                            super(request, protocol, message, code2, obj.handshake, obj.headers.build(), obj.body, obj.networkResponse, obj.cacheResponse, obj.priorResponse, obj.sentRequestAtMillis, obj13, obj.receivedResponseAtMillis, obj15, obj.exchange);
                            return response2;
                        }
                        IllegalStateException illegalStateException2 = new IllegalStateException("message == null".toString());
                        throw illegalStateException2;
                    }
                    IllegalStateException illegalStateException3 = new IllegalStateException("protocol == null".toString());
                    throw illegalStateException3;
                }
                IllegalStateException illegalStateException = new IllegalStateException("request == null".toString());
                throw illegalStateException;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("code < 0: ");
            stringBuilder.append(obj.code);
            IllegalStateException illegalStateException4 = new IllegalStateException(stringBuilder.toString().toString());
            throw illegalStateException4;
        }

        public okhttp3.Response.Builder cacheResponse(okhttp3.Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        public okhttp3.Response.Builder code(int i) {
            this.code = i;
            return this;
        }

        public final okhttp3.ResponseBody getBody$okhttp() {
            return this.body;
        }

        public final okhttp3.Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        public final okhttp3.Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        public final okhttp3.Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMessage$okhttp() {
            return this.message;
        }

        public final okhttp3.Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        public final okhttp3.Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        public final okhttp3.Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        public final okhttp3.Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        public okhttp3.Response.Builder handshake(okhttp3.Handshake handshake) {
            this.handshake = handshake;
            return this;
        }

        public okhttp3.Response.Builder header(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "value");
            this.headers.set(string, string2);
            return this;
        }

        public okhttp3.Response.Builder headers(okhttp3.Headers headers) {
            n.f(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(Exchange exchange) {
            n.f(exchange, "deferredTrailers");
            this.exchange = exchange;
        }

        public okhttp3.Response.Builder message(String string) {
            n.f(string, "message");
            this.message = string;
            return this;
        }

        public okhttp3.Response.Builder networkResponse(okhttp3.Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        public okhttp3.Response.Builder priorResponse(okhttp3.Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        public okhttp3.Response.Builder protocol(okhttp3.Protocol protocol) {
            n.f(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        public okhttp3.Response.Builder receivedResponseAtMillis(long l) {
            this.receivedResponseAtMillis = l;
            return this;
        }

        public okhttp3.Response.Builder removeHeader(String string) {
            n.f(string, "name");
            this.headers.removeAll(string);
            return this;
        }

        public okhttp3.Response.Builder request(okhttp3.Request request) {
            n.f(request, "request");
            this.request = request;
            return this;
        }

        public okhttp3.Response.Builder sentRequestAtMillis(long l) {
            this.sentRequestAtMillis = l;
            return this;
        }

        public final void setBody$okhttp(okhttp3.ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(okhttp3.Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i) {
            this.code = i;
        }

        public final void setExchange$okhttp(Exchange exchange) {
            this.exchange = exchange;
        }

        public final void setHandshake$okhttp(okhttp3.Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(okhttp3.Headers.Builder headers$Builder) {
            n.f(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMessage$okhttp(String string) {
            this.message = string;
        }

        public final void setNetworkResponse$okhttp(okhttp3.Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(okhttp3.Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(okhttp3.Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long l) {
            this.receivedResponseAtMillis = l;
        }

        public final void setRequest$okhttp(okhttp3.Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long l) {
            this.sentRequestAtMillis = l;
        }
    }
    public Response(okhttp3.Request request, okhttp3.Protocol protocol2, String string3, int i4, okhttp3.Handshake handshake5, okhttp3.Headers headers6, okhttp3.ResponseBody responseBody7, okhttp3.Response response8, okhttp3.Response response9, okhttp3.Response response10, long l11, long l12, Exchange exchange13) {
        final Object obj = this;
        n.f(request, "request");
        n.f(protocol2, "protocol");
        n.f(string3, "message");
        n.f(headers6, "headers");
        super();
        obj.request = request;
        obj.protocol = protocol2;
        obj.message = string3;
        obj.code = i4;
        obj.handshake = handshake5;
        obj.headers = headers6;
        obj.body = responseBody7;
        obj.networkResponse = response8;
        obj.cacheResponse = response9;
        obj.priorResponse = response10;
        obj.sentRequestAtMillis = l11;
        obj.receivedResponseAtMillis = exchange13;
        obj.exchange = obj21;
    }

    public static String header$default(okhttp3.Response response, String string2, String string3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return response.header(string2, obj2);
    }

    @Override // java.io.Closeable
    public final okhttp3.ResponseBody -deprecated_body() {
        return this.body;
    }

    @Override // java.io.Closeable
    public final okhttp3.CacheControl -deprecated_cacheControl() {
        return cacheControl();
    }

    @Override // java.io.Closeable
    public final okhttp3.Response -deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @Override // java.io.Closeable
    public final int -deprecated_code() {
        return this.code;
    }

    @Override // java.io.Closeable
    public final okhttp3.Handshake -deprecated_handshake() {
        return this.handshake;
    }

    @Override // java.io.Closeable
    public final okhttp3.Headers -deprecated_headers() {
        return this.headers;
    }

    @Override // java.io.Closeable
    public final String -deprecated_message() {
        return this.message;
    }

    @Override // java.io.Closeable
    public final okhttp3.Response -deprecated_networkResponse() {
        return this.networkResponse;
    }

    @Override // java.io.Closeable
    public final okhttp3.Response -deprecated_priorResponse() {
        return this.priorResponse;
    }

    @Override // java.io.Closeable
    public final okhttp3.Protocol -deprecated_protocol() {
        return this.protocol;
    }

    @Override // java.io.Closeable
    public final long -deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Override // java.io.Closeable
    public final okhttp3.Request -deprecated_request() {
        return this.request;
    }

    @Override // java.io.Closeable
    public final long -deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @Override // java.io.Closeable
    public final okhttp3.ResponseBody body() {
        return this.body;
    }

    @Override // java.io.Closeable
    public final okhttp3.CacheControl cacheControl() {
        okhttp3.CacheControl lazyCacheControl;
        okhttp3.Headers headers;
        if (this.lazyCacheControl == null) {
            this.lazyCacheControl = CacheControl.Companion.parse(this.headers);
        }
        return lazyCacheControl;
    }

    @Override // java.io.Closeable
    public final okhttp3.Response cacheResponse() {
        return this.cacheResponse;
    }

    public final List<okhttp3.Challenge> challenges() {
        String str;
        int i;
        int code = this.code;
        if (code != 401) {
            if (code != 407) {
                return p.g();
            }
            str = "Proxy-Authenticate";
        } else {
            str = "WWW-Authenticate";
        }
        return HttpHeaders.parseChallenges(this.headers, str);
    }

    @Override // java.io.Closeable
    public void close() {
        okhttp3.ResponseBody body = this.body;
        if (body == null) {
        } else {
            body.close();
        }
        IllegalStateException illegalStateException = new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public final int code() {
        return this.code;
    }

    @Override // java.io.Closeable
    public final Exchange exchange() {
        return this.exchange;
    }

    @Override // java.io.Closeable
    public final okhttp3.Handshake handshake() {
        return this.handshake;
    }

    @Override // java.io.Closeable
    public final String header(String string) {
        final int i = 0;
        return Response.header$default(this, string, i, 2, i);
    }

    @Override // java.io.Closeable
    public final String header(String string, String string2) {
        String obj3;
        n.f(string, "name");
        final String obj2 = this.headers.get(string);
        if (obj2 != null) {
            obj3 = obj2;
        }
        return obj3;
    }

    public final List<String> headers(String string) {
        n.f(string, "name");
        return this.headers.values(string);
    }

    @Override // java.io.Closeable
    public final okhttp3.Headers headers() {
        return this.headers;
    }

    @Override // java.io.Closeable
    public final boolean isRedirect() {
        int i;
        int i2;
        int code = this.code;
        if (code != 307 && code != 308) {
            if (code != 308) {
                i = /* condition */ ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // java.io.Closeable
    public final boolean isSuccessful() {
        int i;
        int i2;
        int code = this.code;
        if (200 > code) {
            i = 0;
        } else {
            if (299 >= code) {
                i = 1;
            } else {
            }
        }
        return i;
    }

    @Override // java.io.Closeable
    public final String message() {
        return this.message;
    }

    @Override // java.io.Closeable
    public final okhttp3.Response networkResponse() {
        return this.networkResponse;
    }

    @Override // java.io.Closeable
    public final okhttp3.Response.Builder newBuilder() {
        Response.Builder builder = new Response.Builder(this);
        return builder;
    }

    @Override // java.io.Closeable
    public final okhttp3.ResponseBody peekBody(long l) {
        okhttp3.ResponseBody body = this.body;
        n.d(body);
        h peek = body.source().peek();
        f fVar = new f();
        peek.request(l);
        fVar.g0(peek, Math.min(l, obj6));
        return ResponseBody.Companion.create(fVar, this.body.contentType(), fVar.size());
    }

    @Override // java.io.Closeable
    public final okhttp3.Response priorResponse() {
        return this.priorResponse;
    }

    @Override // java.io.Closeable
    public final okhttp3.Protocol protocol() {
        return this.protocol;
    }

    @Override // java.io.Closeable
    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Override // java.io.Closeable
    public final okhttp3.Request request() {
        return this.request;
    }

    @Override // java.io.Closeable
    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @Override // java.io.Closeable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response{protocol=");
        stringBuilder.append(this.protocol);
        stringBuilder.append(", code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", url=");
        stringBuilder.append(this.request.url());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override // java.io.Closeable
    public final okhttp3.Headers trailers() {
        Exchange exchange = this.exchange;
        if (exchange == null) {
        } else {
            return exchange.trailers();
        }
        IllegalStateException illegalStateException = new IllegalStateException("trailers not available".toString());
        throw illegalStateException;
    }
}
