package okhttp3.internal.http;

import java.net.Proxy.Type;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000c¢\u0006\u0004\u0008\u000e\u0010\u000f¨\u0006\u0012", d2 = {"Lokhttp3/internal/http/RequestLine;", "", "Lokhttp3/Request;", "request", "Ljava/net/Proxy$Type;", "proxyType", "", "includeAuthorityInRequestLine", "(Lokhttp3/Request;Ljava/net/Proxy$Type;)Z", "", "get", "(Lokhttp3/Request;Ljava/net/Proxy$Type;)Ljava/lang/String;", "Lokhttp3/HttpUrl;", "url", "requestPath", "(Lokhttp3/HttpUrl;)Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RequestLine {

    public static final okhttp3.internal.http.RequestLine INSTANCE;
    static {
        RequestLine requestLine = new RequestLine();
        RequestLine.INSTANCE = requestLine;
    }

    private final boolean includeAuthorityInRequestLine(Request request, Proxy.Type proxy$Type2) {
        boolean obj1;
        if (!request.isHttps() && type2 == Proxy.Type.HTTP) {
            obj1 = type2 == Proxy.Type.HTTP ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public final String get(Request request, Proxy.Type proxy$Type2) {
        Object obj3;
        n.f(request, "request");
        n.f(type2, "proxyType");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(request.method());
        stringBuilder.append(' ');
        okhttp3.internal.http.RequestLine iNSTANCE = RequestLine.INSTANCE;
        if (iNSTANCE.includeAuthorityInRequestLine(request, type2)) {
            stringBuilder.append(request.url());
        } else {
            stringBuilder.append(iNSTANCE.requestPath(request.url()));
        }
        stringBuilder.append(" HTTP/1.1");
        obj3 = stringBuilder.toString();
        n.e(obj3, "StringBuilder().apply(builderAction).toString()");
        return obj3;
    }

    public final String requestPath(HttpUrl httpUrl) {
        String encodedPath;
        StringBuilder stringBuilder;
        n.f(httpUrl, "url");
        final String obj3 = httpUrl.encodedQuery();
        if (obj3 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(httpUrl.encodedPath());
            stringBuilder.append('?');
            stringBuilder.append(obj3);
            encodedPath = stringBuilder.toString();
        }
        return encodedPath;
    }
}
