package okhttp3.internal.http;

import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import l.b0;
import l.q;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0008\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0008\u0010\t¨\u0006\u000c", d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "forWebSocket", "Z", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CallServerInterceptor implements Interceptor {

    private final boolean forWebSocket;
    public CallServerInterceptor(boolean z) {
        super();
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        int cmp;
        int contentLength2;
        RequestBody duplex;
        Response build;
        ResponseBody eMPTY_RESPONSE;
        boolean z;
        String contentLength;
        int str;
        int responseHeaders;
        int code;
        int valueOf;
        int i;
        l.g multiplexed$okhttp;
        Object obj12;
        n.f(chain, "chain");
        Exchange exchange$okhttp = (RealInterceptorChain)chain.getExchange$okhttp();
        n.d(exchange$okhttp);
        obj12 = chain.getRequest$okhttp();
        duplex = obj12.body();
        long currentTimeMillis2 = System.currentTimeMillis();
        exchange$okhttp.writeRequestHeaders(obj12);
        valueOf = 0;
        final int i3 = 0;
        final int i4 = 1;
        if (HttpMethod.permitsRequestBody(obj12.method()) && duplex != null) {
            if (duplex != null) {
                if (l.x("100-continue", obj12.header("Expect"), i4)) {
                    exchange$okhttp.flushRequest();
                    responseHeaders = exchange$okhttp.readResponseHeaders(i4);
                    exchange$okhttp.responseHeadersStart();
                    i = i3;
                } else {
                    responseHeaders = valueOf;
                    i = i4;
                }
                if (responseHeaders == null) {
                    if (duplex.isDuplex()) {
                        exchange$okhttp.flushRequest();
                        duplex.writeTo(q.c(exchange$okhttp.createRequestBody(obj12, i4)));
                    } else {
                        multiplexed$okhttp = q.c(exchange$okhttp.createRequestBody(obj12, i3));
                        duplex.writeTo(multiplexed$okhttp);
                        multiplexed$okhttp.close();
                    }
                } else {
                    exchange$okhttp.noRequestBody();
                    if (!exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
                        exchange$okhttp.noNewExchangesOnConnection();
                    }
                }
            } else {
                exchange$okhttp.noRequestBody();
                responseHeaders = valueOf;
                i = i4;
            }
        } else {
        }
        if (duplex != null) {
            if (!duplex.isDuplex()) {
                exchange$okhttp.finishRequest();
            }
        } else {
        }
        n.d(exchange$okhttp.readResponseHeaders(i3));
        if (responseHeaders == 0 && i != 0) {
            n.d(exchange$okhttp.readResponseHeaders(i3));
            if (i != 0) {
                exchange$okhttp.responseHeadersStart();
                i = i3;
            }
        }
        Response.Builder responseHeaders2 = exchange$okhttp.readResponseHeaders(i3);
        n.d(responseHeaders2);
        if (responseHeaders.request(obj12).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis2).receivedResponseAtMillis(System.currentTimeMillis()).build().code() == 100 && i != 0) {
            responseHeaders2 = exchange$okhttp.readResponseHeaders(i3);
            n.d(responseHeaders2);
            if (i != 0) {
                exchange$okhttp.responseHeadersStart();
            }
            code = responseHeaders2.request(obj12).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis2).receivedResponseAtMillis(System.currentTimeMillis()).build().code();
        }
        exchange$okhttp.responseHeadersEnd(build);
        if (this.forWebSocket && code == 101) {
            if (code == 101) {
                obj12 = build.newBuilder().body(Util.EMPTY_RESPONSE).build();
            } else {
                obj12 = build.newBuilder().body(exchange$okhttp.openResponseBody(build)).build();
            }
        } else {
        }
        str = "Connection";
        final String str4 = "close";
        if (!l.x(str4, obj12.request().header(str), i4)) {
            if (l.x(str4, Response.header$default(obj12, str, valueOf, 2, valueOf), i4)) {
                exchange$okhttp.noNewExchangesOnConnection();
            }
        } else {
        }
        if (code != 204) {
            if (code == 205) {
                ResponseBody body = obj12.body();
                if (body != null) {
                    contentLength2 = body.contentLength();
                } else {
                    contentLength2 = -1;
                }
                if (Long.compare(contentLength2, str) > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("HTTP ");
                    stringBuilder.append(code);
                    stringBuilder.append(" had non-zero Content-Length: ");
                    obj12 = obj12.body();
                    if (obj12 == null) {
                    } else {
                        valueOf = Long.valueOf(obj12.contentLength());
                    }
                    stringBuilder.append(valueOf);
                    ProtocolException protocolException = new ProtocolException(stringBuilder.toString());
                    throw protocolException;
                }
            }
        } else {
        }
        return obj12;
    }
}
