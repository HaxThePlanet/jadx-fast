package okhttp3.internal.http;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;
import l.n;
import l.q;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\u00020\u00052\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u000f¨\u0006\u0012", d2 = {"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "", "Lokhttp3/Cookie;", "cookies", "", "cookieHeader", "(Ljava/util/List;)Ljava/lang/String;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/CookieJar;", "<init>", "(Lokhttp3/CookieJar;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class BridgeInterceptor implements Interceptor {

    private final CookieJar cookieJar;
    public BridgeInterceptor(CookieJar cookieJar) {
        n.f(cookieJar, "cookieJar");
        super();
        this.cookieJar = cookieJar;
    }

    private final String cookieHeader(List<Cookie> list) {
        int str;
        Object next;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator obj5 = list.iterator();
        str = 0;
        for (Object next : obj5) {
            if (str > 0) {
            }
            stringBuilder.append((Cookie)next.name());
            stringBuilder.append('=');
            stringBuilder.append(next.value());
            str = i;
            stringBuilder.append("; ");
        }
        obj5 = stringBuilder.toString();
        n.e(obj5, "StringBuilder().apply(builderAction).toString()");
        return obj5;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        Object realResponseBody;
        Object valueOf;
        Object cookieHeader;
        okhttp3.HttpUrl httpUrl;
        long contentLength;
        String hostHeader$default;
        String header;
        String header3;
        int str2;
        String header2;
        Headers promisesBody;
        Object contentType;
        int nVar;
        String str;
        Object obj13;
        n.f(chain, "chain");
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        valueOf = request.body();
        final String str8 = "Content-Type";
        final int i = -1;
        final String str9 = "Content-Length";
        contentType = valueOf.contentType();
        if (valueOf != null && contentType != null) {
            contentType = valueOf.contentType();
            if (contentType != null) {
                builder.header(str8, contentType.toString());
            }
            contentLength = valueOf.contentLength();
            str = "Transfer-Encoding";
            if (Long.compare(contentLength, i) != 0) {
                builder.header(str9, String.valueOf(contentLength));
                builder.removeHeader(str);
            } else {
                builder.header(str, "chunked");
                builder.removeHeader(str9);
            }
        }
        String str4 = "Host";
        int i2 = 1;
        final int i3 = 0;
        if (request.header(str4) == null) {
            builder.header(str4, Util.toHostHeader$default(request.url(), false, i2, i3));
        }
        String str5 = "Connection";
        if (request.header(str5) == null) {
            builder.header(str5, "Keep-Alive");
        }
        String str6 = "Accept-Encoding";
        final String str11 = "gzip";
        if (request.header(str6) == null && request.header("Range") == null) {
            if (request.header("Range") == null) {
                builder.header(str6, str11);
                nVar = i2;
            }
        }
        cookieHeader = this.cookieJar.loadForRequest(request.url());
        if (empty ^= i2 != 0) {
            builder.header("Cookie", cookieHeader(cookieHeader));
        }
        String str7 = "User-Agent";
        if (request.header(str7) == null) {
            builder.header(str7, "okhttp/4.9.2");
        }
        obj13 = chain.proceed(builder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), obj13.headers());
        Response.Builder request2 = obj13.newBuilder().request(request);
        realResponseBody = "Content-Encoding";
        httpUrl = 2;
        promisesBody = obj13.body();
        if (nVar != 0 && l.x(str11, Response.header$default(obj13, realResponseBody, i3, httpUrl, i3), i2) && HttpHeaders.promisesBody(obj13) && promisesBody != null) {
            realResponseBody = "Content-Encoding";
            httpUrl = 2;
            if (l.x(str11, Response.header$default(obj13, realResponseBody, i3, httpUrl, i3), i2)) {
                if (HttpHeaders.promisesBody(obj13)) {
                    promisesBody = obj13.body();
                    if (promisesBody != null) {
                        nVar = new n(promisesBody.source());
                        request2.headers(obj13.headers().newBuilder().removeAll(realResponseBody).removeAll(str9).build());
                        realResponseBody = new RealResponseBody(Response.header$default(obj13, str8, i3, httpUrl, i3), i, obj5, q.d(nVar));
                        request2.body(realResponseBody);
                    }
                }
            }
        }
        return request2.build();
    }
}
