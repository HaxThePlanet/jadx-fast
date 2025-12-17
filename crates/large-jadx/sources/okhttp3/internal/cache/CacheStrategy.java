package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u001d\u0008\u0000\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006R\u001b\u0010\u0008\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0010", d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "Lokhttp3/Response;", "cacheResponse", "Lokhttp3/Response;", "getCacheResponse", "()Lokhttp3/Response;", "Lokhttp3/Request;", "networkRequest", "Lokhttp3/Request;", "getNetworkRequest", "()Lokhttp3/Request;", "<init>", "(Lokhttp3/Request;Lokhttp3/Response;)V", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CacheStrategy {

    public static final okhttp3.internal.cache.CacheStrategy.Companion Companion;
    private final Response cacheResponse;
    private final Request networkRequest;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u0007\u0010\u0008¨\u0006\u000b", d2 = {"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "Lokhttp3/Response;", "response", "Lokhttp3/Request;", "request", "", "isCacheable", "(Lokhttp3/Response;Lokhttp3/Request;)Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final boolean isCacheable(Response response, Request request2) {
            int maxAgeSeconds;
            int str;
            int i;
            int i2;
            boolean obj5;
            n.f(response, "response");
            n.f(request2, "request");
            maxAgeSeconds = response.code();
            i = 0;
            if (maxAgeSeconds != 200 && maxAgeSeconds != 410 && maxAgeSeconds != 414 && maxAgeSeconds != 501 && maxAgeSeconds != 203 && maxAgeSeconds != 204) {
                if (maxAgeSeconds != 410) {
                    if (maxAgeSeconds != 414) {
                        if (maxAgeSeconds != 501) {
                            if (maxAgeSeconds != 203) {
                                if (maxAgeSeconds != 204) {
                                    if (maxAgeSeconds != 307) {
                                        if (maxAgeSeconds != 308 && maxAgeSeconds != 404 && maxAgeSeconds != 405) {
                                            if (maxAgeSeconds != 404) {
                                                if (maxAgeSeconds != 405) {
                                                    switch (maxAgeSeconds) {
                                                        case 300:
                                                            return i;
                                                        case 301:
                                                            i2 = 0;
                                                            return i;
                                                            return i;
                                                        default:
                                                            return i;
                                                    }
                                                    if (!request2.cacheControl().noStore()) {
                                                        i = 1;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010#\u001a\u00020\u0008\u0012\u0006\u0010\r\u001a\u00020\u000c\u0012\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\u0008(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\u0008\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012R\u001c\u0010\r\u001a\u00020\u000c8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\r\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008 \u0010\u0018R\u0018\u0010!\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008!\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\"\u0010\u0012R\u0016\u0010#\u001a\u00020\u00088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008#\u0010\u0012R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008'\u0010\u001f¨\u0006*", d2 = {"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "", "isFreshnessLifetimeHeuristic", "()Z", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "()Lokhttp3/internal/cache/CacheStrategy;", "", "computeFreshnessLifetime", "()J", "cacheResponseAge", "Lokhttp3/Request;", "request", "hasConditions", "(Lokhttp3/Request;)Z", "compute", "receivedResponseMillis", "J", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "", "lastModifiedString", "Ljava/lang/String;", "servedDateString", "Lokhttp3/Response;", "cacheResponse", "Lokhttp3/Response;", "Ljava/util/Date;", "servedDate", "Ljava/util/Date;", "etag", "lastModified", "sentRequestMillis", "nowMillis", "", "ageSeconds", "I", "expires", "<init>", "(JLokhttp3/Request;Lokhttp3/Response;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Factory {

        private int ageSeconds = -1;
        private final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;
        public Factory(long l, Request request2, Response response3) {
            String httpDateOrNull;
            String value;
            boolean str;
            int i;
            Headers obj6;
            Object obj7;
            Response obj8;
            n.f(response3, "request");
            super();
            this.nowMillis = l;
            this.request = response3;
            this.cacheResponse = obj8;
            if (obj8 != null) {
                this.sentRequestMillis = obj8.sentRequestAtMillis();
                this.receivedResponseMillis = obj8.receivedResponseAtMillis();
                obj6 = obj8.headers();
                obj7 = 0;
                while (obj7 < obj6.size()) {
                    httpDateOrNull = obj6.name(obj7);
                    value = obj6.value(obj7);
                    i = 1;
                    if (l.x(httpDateOrNull, "Date", i)) {
                    } else {
                    }
                    if (l.x(httpDateOrNull, "Expires", i)) {
                    } else {
                    }
                    if (l.x(httpDateOrNull, "Last-Modified", i)) {
                    } else {
                    }
                    if (l.x(httpDateOrNull, "ETag", i)) {
                    } else {
                    }
                    if (l.x(httpDateOrNull, "Age", i)) {
                    }
                    obj7++;
                    this.ageSeconds = Util.toNonNegativeInt(value, -1);
                    this.etag = value;
                    this.lastModified = DatesKt.toHttpDateOrNull(value);
                    this.lastModifiedString = value;
                    this.expires = DatesKt.toHttpDateOrNull(value);
                    this.servedDate = DatesKt.toHttpDateOrNull(value);
                    this.servedDateString = value;
                }
            }
        }

        private final long cacheResponseAge() {
            int i;
            int i2;
            int millis;
            long l;
            long time;
            Date servedDate = this.servedDate;
            if (servedDate != null) {
                i = Math.max(0, obj2);
            }
            int ageSeconds = this.ageSeconds;
            if (ageSeconds != -1) {
                l = (long)ageSeconds;
                i = Math.max(i, obj2);
            }
            long receivedResponseMillis2 = this.receivedResponseMillis;
            return i3 += i6;
        }

        private final okhttp3.internal.cache.CacheStrategy computeCandidate() {
            boolean handshake;
            CacheControl maxStaleSeconds;
            boolean noCache2;
            String lastModifiedString;
            boolean noCache;
            String str;
            int cmp;
            int freshnessLifetimeHeuristic;
            long freshnessLifetime;
            int maxAgeSeconds;
            int minFreshSeconds;
            boolean maxStaleSeconds2;
            int i;
            long millis;
            int millis3;
            int millis2;
            int i2 = 0;
            if (this.cacheResponse == null) {
                CacheStrategy cacheStrategy5 = new CacheStrategy(this.request, i2);
                return cacheStrategy5;
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                if (this.cacheResponse.handshake() == null) {
                    CacheStrategy cacheStrategy = new CacheStrategy(this.request, i2);
                    return cacheStrategy;
                }
            }
            if (!CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request)) {
                CacheStrategy cacheStrategy2 = new CacheStrategy(this.request, i2);
                return cacheStrategy2;
            }
            maxStaleSeconds = this.request.cacheControl();
            if (!maxStaleSeconds.noCache()) {
                if (hasConditions(this.request)) {
                } else {
                    CacheControl cacheControl = this.cacheResponse.cacheControl();
                    long cacheResponseAge = cacheResponseAge();
                    i = -1;
                    if (maxStaleSeconds.maxAgeSeconds() != i) {
                        freshnessLifetime = Math.min(computeFreshnessLifetime(), obj6);
                    }
                    millis3 = 0;
                    if (maxStaleSeconds.minFreshSeconds() != i) {
                        millis2 = TimeUnit.SECONDS.toMillis((long)minFreshSeconds2);
                    } else {
                        millis2 = millis3;
                    }
                    if (!cacheControl.mustRevalidate() && maxStaleSeconds.maxStaleSeconds() != i) {
                        if (maxStaleSeconds.maxStaleSeconds() != i) {
                            millis3 = TimeUnit.SECONDS.toMillis((long)maxStaleSeconds);
                        }
                    }
                    millis2 += cacheResponseAge;
                    Response.Builder builder2 = this.cacheResponse.newBuilder();
                    String str2 = "Warning";
                    if (!cacheControl.noCache() && Long.compare(millis2, millis3) < 0 && Long.compare(millis2, freshnessLifetime) >= 0) {
                        millis2 += cacheResponseAge;
                        if (Long.compare(millis2, millis3) < 0) {
                            builder2 = this.cacheResponse.newBuilder();
                            str2 = "Warning";
                            if (Long.compare(millis2, freshnessLifetime) >= 0) {
                                builder2.addHeader(str2, "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (Long.compare(cacheResponseAge, i3) > 0 && isFreshnessLifetimeHeuristic()) {
                                if (isFreshnessLifetimeHeuristic()) {
                                    builder2.addHeader(str2, "113 HttpURLConnection \"Heuristic expiration\"");
                                }
                            }
                            CacheStrategy cacheStrategy7 = new CacheStrategy(i2, builder2.build());
                            return cacheStrategy7;
                        }
                    }
                    str = "If-Modified-Since";
                    if (this.etag != null) {
                        str = "If-None-Match";
                        Headers.Builder builder3 = this.request.headers().newBuilder();
                        n.d(lastModifiedString);
                        builder3.addLenient$okhttp(str, lastModifiedString);
                        CacheStrategy cacheStrategy6 = new CacheStrategy(this.request.newBuilder().headers(builder3.build()).build(), this.cacheResponse);
                        return cacheStrategy6;
                    } else {
                        if (this.lastModified != null) {
                            lastModifiedString = this.lastModifiedString;
                        } else {
                            if (this.servedDate != null) {
                                lastModifiedString = this.servedDateString;
                            }
                        }
                    }
                }
                CacheStrategy cacheStrategy4 = new CacheStrategy(this.request, i2);
                return cacheStrategy4;
            }
            CacheStrategy cacheStrategy3 = new CacheStrategy(this.request, i2);
            return cacheStrategy3;
        }

        private final long computeFreshnessLifetime() {
            Date lastModified;
            int i;
            long receivedResponseMillis;
            long sentRequestMillis;
            int i2;
            long time;
            Response cacheResponse = this.cacheResponse;
            n.d(cacheResponse);
            CacheControl cacheControl = cacheResponse.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long)maxAgeSeconds);
            }
            Date expires = this.expires;
            i = 0;
            if (expires != null) {
                Date servedDate2 = this.servedDate;
                if (servedDate2 != null) {
                    receivedResponseMillis = servedDate2.getTime();
                } else {
                    receivedResponseMillis = this.receivedResponseMillis;
                }
                time2 -= receivedResponseMillis;
                if (Long.compare(i5, i) > 0) {
                    i = i5;
                }
                return i;
            }
            if (this.lastModified != null && this.cacheResponse.request().url().query() == null) {
                if (this.cacheResponse.request().url().query() == null) {
                    Date servedDate = this.servedDate;
                    if (servedDate != null) {
                        sentRequestMillis = servedDate.getTime();
                    } else {
                        sentRequestMillis = this.sentRequestMillis;
                    }
                    Date lastModified2 = this.lastModified;
                    n.d(lastModified2);
                    sentRequestMillis -= time;
                    if (Long.compare(i2, i) > 0) {
                        i = i2 / lastModified;
                    }
                }
            }
            return i;
        }

        private final boolean hasConditions(Request request) {
            String header;
            int obj2;
            if (request.header("If-Modified-Since") == null) {
                if (request.header("If-None-Match") != null) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            int maxAgeSeconds;
            int i;
            Response cacheResponse = this.cacheResponse;
            n.d(cacheResponse);
            if (cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null) {
                i = this.expires == null ? 1 : 0;
            } else {
            }
            return i;
        }

        public final okhttp3.internal.cache.CacheStrategy compute() {
            okhttp3.internal.cache.CacheStrategy cacheStrategy;
            Request networkRequest;
            if (computeCandidate().getNetworkRequest() != null && this.request.cacheControl().onlyIfCached()) {
                if (this.request.cacheControl().onlyIfCached()) {
                    networkRequest = 0;
                    cacheStrategy = new CacheStrategy(networkRequest, networkRequest);
                }
            }
            return cacheStrategy;
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }
    }
    static {
        CacheStrategy.Companion companion = new CacheStrategy.Companion(0);
        CacheStrategy.Companion = companion;
    }

    public CacheStrategy(Request request, Response response2) {
        super();
        this.networkRequest = request;
        this.cacheResponse = response2;
    }

    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
