package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import l.q;
import okhttp3.Cache;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\u0008\u0010\r\u001a\u0004\u0018\u00010\u000c¢\u0006\u0004\u0008\u0011\u0010\u0012J!\u0010\u0006\u001a\u00020\u00042\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000c8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0014", d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/internal/cache/CacheRequest;", "cacheRequest", "Lokhttp3/Response;", "response", "cacheWritingResponse", "(Lokhttp3/internal/cache/CacheRequest;Lokhttp3/Response;)Lokhttp3/Response;", "Lokhttp3/Interceptor$Chain;", "chain", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/Cache;", "cache", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "<init>", "(Lokhttp3/Cache;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CacheInterceptor implements Interceptor {

    public static final okhttp3.internal.cache.CacheInterceptor.Companion Companion;
    private final Cache cache;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\u0010\u0010\u000f¨\u0006\u0013", d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "Lokhttp3/Response;", "response", "stripBody", "(Lokhttp3/Response;)Lokhttp3/Response;", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "combine", "(Lokhttp3/Headers;Lokhttp3/Headers;)Lokhttp3/Headers;", "", "fieldName", "", "isEndToEnd", "(Ljava/lang/String;)Z", "isContentSpecificHeader", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static final Headers access$combine(okhttp3.internal.cache.CacheInterceptor.Companion cacheInterceptor$Companion, Headers headers2, Headers headers3) {
            return companion.combine(headers2, headers3);
        }

        public static final Response access$stripBody(okhttp3.internal.cache.CacheInterceptor.Companion cacheInterceptor$Companion, Response response2) {
            return companion.stripBody(response2);
        }

        private final Headers combine(Headers headers, Headers headers2) {
            int size;
            int i;
            int contentSpecificHeader;
            String name;
            String value;
            boolean contentSpecificHeader2;
            int i2;
            String str;
            Headers.Builder builder = new Headers.Builder();
            i = 0;
            contentSpecificHeader = i;
            while (contentSpecificHeader < headers.size()) {
                name = headers.name(contentSpecificHeader);
                value = headers.value(contentSpecificHeader);
                if (l.x("Warning", name, true) && l.M(value, "1", i, 2, 0)) {
                } else {
                }
                if (!isContentSpecificHeader(name) && isEndToEnd(name)) {
                } else {
                }
                builder.addLenient$okhttp(name, value);
                contentSpecificHeader++;
                if (isEndToEnd(name)) {
                } else {
                }
                if (headers2.get(name) == null) {
                }
                if (l.M(value, "1", i, 2, 0)) {
                } else {
                }
            }
            while (i < headers2.size()) {
                size = headers2.name(i);
                if (!isContentSpecificHeader(size) && isEndToEnd(size)) {
                }
                i++;
                if (isEndToEnd(size)) {
                }
                builder.addLenient$okhttp(size, headers2.value(i));
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String string) {
            boolean str;
            int i;
            String obj3;
            i = 1;
            if (!l.x("Content-Length", string, i) && !l.x("Content-Encoding", string, i)) {
                if (!l.x("Content-Encoding", string, i)) {
                    if (l.x("Content-Type", string, i)) {
                    } else {
                        i = 0;
                    }
                }
            }
            return i;
        }

        private final boolean isEndToEnd(String string) {
            boolean str;
            int i;
            String obj3;
            i = 1;
            if (!l.x("Connection", string, i) && !l.x("Keep-Alive", string, i) && !l.x("Proxy-Authenticate", string, i) && !l.x("Proxy-Authorization", string, i) && !l.x("TE", string, i) && !l.x("Trailers", string, i) && !l.x("Transfer-Encoding", string, i) && !l.x("Upgrade", string, i)) {
                if (!l.x("Keep-Alive", string, i)) {
                    if (!l.x("Proxy-Authenticate", string, i)) {
                        if (!l.x("Proxy-Authorization", string, i)) {
                            if (!l.x("TE", string, i)) {
                                if (!l.x("Trailers", string, i)) {
                                    if (!l.x("Transfer-Encoding", string, i)) {
                                        if (!l.x("Upgrade", string, i)) {
                                        } else {
                                            i = 0;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        private final Response stripBody(Response response) {
            ResponseBody body;
            Response obj3;
            final int i = 0;
            if (response != null) {
                body = response.body();
            } else {
                body = i;
            }
            if (body != null) {
                obj3 = response.newBuilder().body(i).build();
            }
            return obj3;
        }
    }
    static {
        CacheInterceptor.Companion companion = new CacheInterceptor.Companion(0);
        CacheInterceptor.Companion = companion;
    }

    public CacheInterceptor(Cache cache) {
        super();
        this.cache = cache;
    }

    private final Response cacheWritingResponse(okhttp3.internal.cache.CacheRequest cacheRequest, Response response2) {
        if (cacheRequest == null) {
            return response2;
        }
        ResponseBody body3 = response2.body();
        n.d(body3);
        CacheInterceptor.cacheWritingResponse.cacheWritingSource.1 anon = new CacheInterceptor.cacheWritingResponse.cacheWritingSource.1(body3.source(), cacheRequest, q.c(cacheRequest.body()));
        int i = 0;
        RealResponseBody realResponseBody = new RealResponseBody(Response.header$default(response2, "Content-Type", i, 2, i), response2.body().contentLength(), i, q.d(anon));
        return response2.newBuilder().body(realResponseBody).build();
    }

    @Override // okhttp3.Interceptor
    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        okhttp3.Call invalidatesCache;
        int body;
        Object method;
        boolean promisesBody;
        int eventListener$okhttp;
        Request request;
        boolean cache;
        n.f(chain, "chain");
        invalidatesCache = chain.call();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            body = cache2.get$okhttp(chain.request());
        } else {
            body = eventListener$okhttp;
        }
        CacheStrategy.Factory factory = new CacheStrategy.Factory(System.currentTimeMillis(), obj4, chain.request(), body);
        okhttp3.internal.cache.CacheStrategy compute = factory.compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse3 = compute.getCacheResponse();
        Cache cache4 = this.cache;
        if (cache4 != null) {
            cache4.trackResponse$okhttp(compute);
        }
        if (!invalidatesCache instanceof RealCall) {
        } else {
            eventListener$okhttp = invalidatesCache;
        }
        if (eventListener$okhttp != 0 && (RealCall)eventListener$okhttp.getEventListener$okhttp() != null) {
            if (eventListener$okhttp.getEventListener$okhttp() != null) {
            } else {
                eventListener$okhttp = EventListener.NONE;
            }
        } else {
        }
        cache = body.body();
        if (body != 0 && cacheResponse3 == null && cache != null) {
            if (cacheResponse3 == null) {
                cache = body.body();
                if (cache != null) {
                    Util.closeQuietly(cache);
                }
            }
        }
        if (networkRequest == null && cacheResponse3 == null) {
            if (cacheResponse3 == null) {
                Response.Builder builder = new Response.Builder();
                Response obj9 = builder.request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
                eventListener$okhttp.satisfactionFailure(invalidatesCache, obj9);
                return obj9;
            }
        }
        if (networkRequest == null) {
            n.d(cacheResponse3);
            obj9 = cacheResponse3.newBuilder().cacheResponse(CacheInterceptor.Companion.access$stripBody(CacheInterceptor.Companion, cacheResponse3)).build();
            eventListener$okhttp.cacheHit(invalidatesCache, obj9);
            return obj9;
        }
        if (cacheResponse3 != null) {
            eventListener$okhttp.cacheConditionalHit(invalidatesCache, cacheResponse3);
        } else {
            if (this.cache != null) {
                eventListener$okhttp.cacheMiss(invalidatesCache);
            }
        }
        obj9 = chain.proceed(networkRequest);
        body = body.body();
        if (obj9 == null && body != 0 && body != null) {
            if (body != 0) {
                body = body.body();
                if (body != null) {
                    Util.closeQuietly(body);
                }
            }
        }
        if (cacheResponse3 != null && obj9 != null && obj9.code() == 304) {
            if (obj9 != null) {
                if (obj9.code() == 304) {
                    okhttp3.internal.cache.CacheInterceptor.Companion companion3 = CacheInterceptor.Companion;
                    Response build = cacheResponse3.newBuilder().headers(CacheInterceptor.Companion.access$combine(companion3, cacheResponse3.headers(), obj9.headers())).sentRequestAtMillis(obj9.sentRequestAtMillis()).receivedResponseAtMillis(obj9.receivedResponseAtMillis()).cacheResponse(CacheInterceptor.Companion.access$stripBody(companion3, cacheResponse3)).networkResponse(CacheInterceptor.Companion.access$stripBody(companion3, obj9)).build();
                    obj9 = obj9.body();
                    n.d(obj9);
                    obj9.close();
                    obj9 = this.cache;
                    n.d(obj9);
                    obj9.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse3, build);
                    eventListener$okhttp.cacheHit(invalidatesCache, build);
                    return build;
                }
            }
            body = cacheResponse3.body();
            if (body != null) {
                Util.closeQuietly(body);
            }
        }
        n.d(obj9);
        okhttp3.internal.cache.CacheInterceptor.Companion companion4 = CacheInterceptor.Companion;
        obj9 = obj9.newBuilder().cacheResponse(CacheInterceptor.Companion.access$stripBody(companion4, cacheResponse3)).networkResponse(CacheInterceptor.Companion.access$stripBody(companion4, obj9)).build();
        if (this.cache != null && HttpHeaders.promisesBody(obj9) && CacheStrategy.Companion.isCacheable(obj9, networkRequest) && cacheResponse3 != null) {
            if (HttpHeaders.promisesBody(obj9)) {
                if (CacheStrategy.Companion.isCacheable(obj9, networkRequest)) {
                    if (cacheResponse3 != null) {
                        eventListener$okhttp.cacheMiss(invalidatesCache);
                    }
                    return cacheWritingResponse(this.cache.put$okhttp(obj9), obj9);
                }
            }
            if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                this.cache.remove$okhttp(networkRequest);
            }
        }
        return obj9;
    }
}
