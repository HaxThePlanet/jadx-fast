package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.y.p;
import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\u0008%\u0010&J/\u0010\n\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u001f\u0010\u000c\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ#\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J!\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\u0008 \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008#\u0010$¨\u0006(", d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "Ljava/io/IOException;", "e", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/Request;", "userRequest", "", "requestSendStarted", "recover", "(Ljava/io/IOException;Lokhttp3/internal/connection/RealCall;Lokhttp3/Request;Z)Z", "requestIsOneShot", "(Ljava/io/IOException;Lokhttp3/Request;)Z", "isRecoverable", "(Ljava/io/IOException;Z)Z", "Lokhttp3/Response;", "userResponse", "Lokhttp3/internal/connection/Exchange;", "exchange", "followUpRequest", "(Lokhttp3/Response;Lokhttp3/internal/connection/Exchange;)Lokhttp3/Request;", "", "method", "buildRedirectRequest", "(Lokhttp3/Response;Ljava/lang/String;)Lokhttp3/Request;", "", "defaultDelay", "retryAfter", "(Lokhttp3/Response;I)I", "Lokhttp3/Interceptor$Chain;", "chain", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "<init>", "(Lokhttp3/OkHttpClient;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RetryAndFollowUpInterceptor implements Interceptor {

    public static final okhttp3.internal.http.RetryAndFollowUpInterceptor.Companion Companion = null;
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "", "MAX_FOLLOW_UPS", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        RetryAndFollowUpInterceptor.Companion companion = new RetryAndFollowUpInterceptor.Companion(0);
        RetryAndFollowUpInterceptor.Companion = companion;
    }

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        n.f(okHttpClient, "client");
        super();
        this.client = okHttpClient;
    }

    private final Request buildRedirectRequest(Response response, String string2) {
        Object header$default;
        int body;
        boolean followSslRedirects;
        Object str;
        boolean permitsRequestBody;
        boolean redirectsToGet;
        int i3;
        int i2;
        int i;
        boolean obj9;
        String obj10;
        body = 0;
        if (!this.client.followRedirects()) {
            return body;
        }
        header$default = Response.header$default(response, "Location", body, 2, body);
        header$default = response.request().url().resolve(header$default);
        if (header$default != null && header$default != null && !n.b(header$default.scheme(), response.request().url().scheme()) && !this.client.followSslRedirects()) {
            header$default = response.request().url().resolve(header$default);
            if (header$default != null) {
                if (!n.b(header$default.scheme(), response.request().url().scheme())) {
                    if (!this.client.followSslRedirects()) {
                        return body;
                    }
                }
                Request.Builder builder = response.request().newBuilder();
                if (HttpMethod.permitsRequestBody(string2)) {
                    permitsRequestBody = response.code();
                    okhttp3.internal.http.HttpMethod iNSTANCE = HttpMethod.INSTANCE;
                    i2 = 307;
                    i = 308;
                    if (!iNSTANCE.redirectsWithBody(string2) && permitsRequestBody != i) {
                        if (permitsRequestBody != i) {
                            if (permitsRequestBody == i2) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                    if (iNSTANCE.redirectsToGet(string2) && permitsRequestBody != i && permitsRequestBody != i2) {
                        if (permitsRequestBody != i) {
                            if (permitsRequestBody != i2) {
                                builder.method("GET", body);
                            } else {
                                if (i3 != 0) {
                                    body = response.request().body();
                                }
                                builder.method(string2, body);
                            }
                        } else {
                        }
                    } else {
                    }
                    if (i3 == 0) {
                        builder.removeHeader("Transfer-Encoding");
                        builder.removeHeader("Content-Length");
                        builder.removeHeader("Content-Type");
                    }
                }
                if (!Util.canReuseConnectionFor(response.request().url(), header$default)) {
                    builder.removeHeader("Authorization");
                }
                return builder.url(header$default).build();
            }
        }
        return body;
    }

    private final Request followUpRequest(Response response, Exchange exchange2) {
        RealConnection connection$okhttp;
        int route;
        RequestBody oneShot;
        Response priorResponse;
        Response priorResponse2;
        RequestBody coalescedConnection$okhttp;
        int i;
        int obj7;
        int i3 = 0;
        connection$okhttp = exchange2.getConnection$okhttp();
        if (exchange2 != 0 && connection$okhttp != null) {
            connection$okhttp = exchange2.getConnection$okhttp();
            if (connection$okhttp != null) {
                route = connection$okhttp.route();
            } else {
                route = i3;
            }
        } else {
        }
        final int code = response.code();
        obj7 = 503;
        obj7 = 408;
        if (code != 307 && code != 308 && code != 401 && code != 421 && code != obj7 && code != 407 && code != obj7 && /* condition */) {
            if (code != 308) {
                if (code != 401) {
                    if (code != 421) {
                        obj7 = 503;
                        if (code != obj7) {
                            if (code != 407) {
                                obj7 = 408;
                                if (code != obj7) {
                                    if (/* condition */) {
                                    }
                                    return i3;
                                }
                                if (!this.client.retryOnConnectionFailure()) {
                                    return i3;
                                }
                                oneShot = response.request().body();
                                if (oneShot != null && oneShot.isOneShot()) {
                                    if (oneShot.isOneShot()) {
                                        return i3;
                                    }
                                }
                                priorResponse = response.priorResponse();
                                if (priorResponse != null && priorResponse.code() == obj7) {
                                    if (priorResponse.code() == obj7) {
                                        return i3;
                                    }
                                }
                                if (retryAfter(response, 0) > 0) {
                                    return i3;
                                }
                                return response.request();
                            }
                            n.d(route);
                            if (route.proxy().type() != Proxy.Type.HTTP) {
                            } else {
                                return this.client.proxyAuthenticator().authenticate(route, response);
                            }
                            ProtocolException obj6 = new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                            throw obj6;
                        }
                        priorResponse2 = response.priorResponse();
                        if (priorResponse2 != null && priorResponse2.code() == obj7) {
                            if (priorResponse2.code() == obj7) {
                                return i3;
                            }
                        }
                        if (retryAfter(response, Integer.MAX_VALUE) == 0) {
                            return response.request();
                        }
                        return i3;
                    }
                    coalescedConnection$okhttp = response.request().body();
                    if (coalescedConnection$okhttp != null && coalescedConnection$okhttp.isOneShot()) {
                        if (coalescedConnection$okhttp.isOneShot()) {
                            return i3;
                        }
                    }
                    if (exchange2 != 0 && !exchange2.isCoalescedConnection$okhttp()) {
                        if (!exchange2.isCoalescedConnection$okhttp()) {
                        }
                        exchange2.getConnection$okhttp().noCoalescedConnections$okhttp();
                        return response.request();
                    }
                    return i3;
                }
                return this.client.authenticator().authenticate(route, response);
            }
        }
        return buildRedirectRequest(response, response.request().method());
    }

    private final boolean isRecoverable(IOException iOException, boolean z2) {
        int i;
        boolean obj5;
        i = 0;
        if (iOException instanceof ProtocolException != null) {
            return i;
        }
        final int i2 = 1;
        if (iOException instanceof InterruptedIOException != null && iOException instanceof SocketTimeoutException != null && !z2) {
            if (iOException instanceof SocketTimeoutException != null) {
                if (!z2) {
                    i = i2;
                }
            }
            return i;
        }
        if (iOException instanceof SSLHandshakeException != null && obj5 instanceof CertificateException != null) {
            if (obj5 instanceof CertificateException != null) {
                return i;
            }
        }
        if (iOException instanceof SSLPeerUnverifiedException != null) {
            return i;
        }
        return i2;
    }

    private final boolean recover(IOException iOException, RealCall realCall2, Request request3, boolean z4) {
        Request obj5;
        final int i = 0;
        if (!this.client.retryOnConnectionFailure()) {
            return i;
        }
        if (z4 && requestIsOneShot(iOException, request3)) {
            if (requestIsOneShot(iOException, request3)) {
                return i;
            }
        }
        if (!isRecoverable(iOException, z4)) {
            return i;
        }
        if (!realCall2.retryAfterFailure()) {
            return i;
        }
        return 1;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request2) {
        Object obj1;
        boolean obj2;
        obj2 = request2.body();
        if (obj2 != null) {
            if (!obj2.isOneShot()) {
                obj1 = iOException instanceof FileNotFoundException != null ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }

    private final int retryAfter(Response response, int i2) {
        final int i = 0;
        String obj4 = Response.header$default(response, "Retry-After", i, 2, i);
        h obj5 = new h("\\d+");
        if (obj4 != null && obj5.d(obj4)) {
            obj5 = new h("\\d+");
            if (obj5.d(obj4)) {
                obj4 = Integer.valueOf(obj4);
                n.e(obj4, "Integer.valueOf(header)");
                return obj4.intValue();
            }
            return Integer.MAX_VALUE;
        }
        return i2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        Request request$okhttp;
        Response proceed;
        RequestBody oneShot;
        java.util.Collection collection;
        java.util.List list;
        Throwable th;
        int i;
        boolean canceled;
        int i2;
        int i3;
        boolean recover;
        Object obj11;
        n.f(chain, "chain");
        request$okhttp = (RealInterceptorChain)chain.getRequest$okhttp();
        final RealCall call$okhttp = chain.getCall$okhttp();
        list = p.g();
        final int i5 = 0;
        final int i6 = 1;
        final int i7 = 0;
        i2 = i5;
        i = i6;
        i3 = i7;
        call$okhttp.enterNetworkInterceptorExchange(request$okhttp, i);
        while (!call$okhttp.isCanceled()) {
            if (i2 != 0) {
            }
            i2 = proceed;
            Exchange interceptorScopedExchange$okhttp = call$okhttp.getInterceptorScopedExchange$okhttp();
            Request followUpRequest = followUpRequest(i2, interceptorScopedExchange$okhttp);
            oneShot = followUpRequest.body();
            okhttp3.ResponseBody body = i2.body();
            if (body != null) {
            }
            i3++;
            call$okhttp.exitNetworkInterceptorExchange$okhttp(i6);
            request$okhttp = followUpRequest;
            i = i6;
            call$okhttp.enterNetworkInterceptorExchange(request$okhttp, i);
            Util.closeQuietly(body);
            proceed = chain.proceed(request$okhttp).newBuilder().priorResponse(i2.newBuilder().body(i5).build()).build();
        }
        obj11 = new IOException("Canceled");
        throw obj11;
    }
}
