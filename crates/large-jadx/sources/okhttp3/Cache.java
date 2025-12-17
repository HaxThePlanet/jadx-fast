package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.io.b;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.p;
import kotlin.y.q0;
import l.b0;
import l.d0;
import l.f;
import l.g;
import l.h;
import l.i;
import l.i.a;
import l.q;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http.StatusLine.Companion;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0004ONPQB!\u0008\u0000\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\u0008K\u0010LB\u0019\u0008\u0016\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\u0008K\u0010MJ\u001d\u0010\u0007\u001a\u00020\u00062\u000c\u0010\u0005\u001a\u0008\u0018\u00010\u0003R\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\u0008\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\u0008\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\u0008\u001f\u0010\u001dJ\u0013\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020!0 ¢\u0006\u0004\u0008\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\u0008%\u0010&J\r\u0010'\u001a\u00020$¢\u0006\u0004\u0008'\u0010&J\r\u0010)\u001a\u00020(¢\u0006\u0004\u0008)\u0010*J\r\u0010+\u001a\u00020(¢\u0006\u0004\u0008+\u0010*J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008,\u0010\u001dJ\u000f\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008-\u0010\u001dJ\u000f\u00101\u001a\u00020.H\u0007¢\u0006\u0004\u0008/\u00100J\u0017\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u000202H\u0000¢\u0006\u0004\u00084\u00105J\u000f\u00108\u001a\u00020\u0006H\u0000¢\u0006\u0004\u00087\u0010\u001dJ\r\u00109\u001a\u00020$¢\u0006\u0004\u00089\u0010&J\r\u0010:\u001a\u00020$¢\u0006\u0004\u0008:\u0010&J\r\u0010;\u001a\u00020$¢\u0006\u0004\u0008;\u0010&R\"\u0010%\u001a\u00020$8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008%\u0010<\u001a\u0004\u0008=\u0010&\"\u0004\u0008>\u0010?R\u0016\u0010:\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008:\u0010<R\u001c\u0010@\u001a\u00020\u00048\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008@\u0010A\u001a\u0004\u0008B\u0010CR\"\u0010'\u001a\u00020$8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008'\u0010<\u001a\u0004\u0008D\u0010&\"\u0004\u0008E\u0010?R\u0016\u00109\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00089\u0010<R\u0016\u0010;\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008;\u0010<R\u0013\u0010G\u001a\u00020F8F@\u0006¢\u0006\u0006\u001a\u0004\u0008G\u0010HR\u0013\u00101\u001a\u00020.8G@\u0006¢\u0006\u0006\u001a\u0004\u00081\u00100¨\u0006R", d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "Lkotlin/w;", "abortQuietly", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "get$okhttp", "(Lokhttp3/Request;)Lokhttp3/Response;", "get", "response", "Lokhttp3/internal/cache/CacheRequest;", "put$okhttp", "(Lokhttp3/Response;)Lokhttp3/internal/cache/CacheRequest;", "put", "remove$okhttp", "(Lokhttp3/Request;)V", "remove", "cached", "network", "update$okhttp", "(Lokhttp3/Response;Lokhttp3/Response;)V", "update", "initialize", "()V", "delete", "evictAll", "", "", "urls", "()Ljava/util/Iterator;", "", "writeAbortCount", "()I", "writeSuccessCount", "", "size", "()J", "maxSize", "flush", "close", "Ljava/io/File;", "-deprecated_directory", "()Ljava/io/File;", "directory", "Lokhttp3/internal/cache/CacheStrategy;", "cacheStrategy", "trackResponse$okhttp", "(Lokhttp3/internal/cache/CacheStrategy;)V", "trackResponse", "trackConditionalCacheHit$okhttp", "trackConditionalCacheHit", "networkCount", "hitCount", "requestCount", "I", "getWriteAbortCount$okhttp", "setWriteAbortCount$okhttp", "(I)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "", "isClosed", "()Z", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "<init>", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "(Ljava/io/File;J)V", "Companion", "CacheResponseBody", "Entry", "RealCacheRequest", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Cache implements Closeable, Flushable {

    public static final okhttp3.Cache.Companion Companion = null;
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\r\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008%\u0010&J\u0019\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u000bH\u0007¢\u0006\u0004\u0008\r\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013J%\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u001a*\u00020\u0015¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0015¢\u0006\u0004\u0008\t\u0010\u001fR\u0016\u0010 \u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008 \u0010!R\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\"\u0010!R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008#\u0010!R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008$\u0010!¨\u0006'", d2 = {"Lokhttp3/Cache$Companion;", "", "Lokhttp3/Headers;", "", "", "varyFields", "(Lokhttp3/Headers;)Ljava/util/Set;", "requestHeaders", "responseHeaders", "varyHeaders", "(Lokhttp3/Headers;Lokhttp3/Headers;)Lokhttp3/Headers;", "Lokhttp3/HttpUrl;", "url", "key", "(Lokhttp3/HttpUrl;)Ljava/lang/String;", "Ll/h;", "source", "", "readInt$okhttp", "(Ll/h;)I", "readInt", "Lokhttp3/Response;", "cachedResponse", "cachedRequest", "Lokhttp3/Request;", "newRequest", "", "varyMatches", "(Lokhttp3/Response;Lokhttp3/Headers;Lokhttp3/Request;)Z", "hasVaryAll", "(Lokhttp3/Response;)Z", "(Lokhttp3/Response;)Lokhttp3/Headers;", "ENTRY_BODY", "I", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        private final Set<String> varyFields(okhttp3.Headers headers) {
            int treeSet;
            int i5;
            boolean iterator;
            String string;
            int str;
            String value;
            char[] cArr;
            int i2;
            int i3;
            int i4;
            int i;
            final int i6 = 0;
            treeSet = 0;
            i5 = i6;
            while (i5 < headers.size()) {
                str = 1;
                if (!l.x("Vary", headers.name(i5), str)) {
                } else {
                }
                if (treeSet == null) {
                }
                cArr = new char[str];
                cArr[i6] = 44;
                iterator = l.D0(headers.value(i5), cArr, false, 0, 6, 0).iterator();
                for (String next : iterator) {
                    Objects.requireNonNull(next, "null cannot be cast to non-null type kotlin.CharSequence");
                    treeSet.add(l.a1(next).toString());
                }
                i5++;
                Object next = iterator.next();
                Objects.requireNonNull((String)next, "null cannot be cast to non-null type kotlin.CharSequence");
                treeSet.add(l.a1(next).toString());
                treeSet = new TreeSet(l.y(f0.a));
            }
            if (treeSet != null) {
            } else {
                treeSet = q0.b();
            }
            return treeSet;
        }

        private final okhttp3.Headers varyHeaders(okhttp3.Headers headers, okhttp3.Headers headers2) {
            int i;
            String name;
            boolean contains;
            final Set obj7 = varyFields(headers2);
            if (obj7.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            i = 0;
            while (i < headers.size()) {
                name = headers.name(i);
                if (obj7.contains(name)) {
                }
                i++;
                builder.add(name, headers.value(i));
            }
            return builder.build();
        }

        public final boolean hasVaryAll(okhttp3.Response response) {
            n.f(response, "$this$hasVaryAll");
            return varyFields(response.headers()).contains("*");
        }

        public final String key(okhttp3.HttpUrl httpUrl) {
            n.f(httpUrl, "url");
            return i.v.d(httpUrl.toString()).s().p();
        }

        public final int readInt$okhttp(h h) {
            int cmp;
            n.f(h, "source");
            long l = h.p0();
            String obj6 = h.m1();
            if (Long.compare(l, i) < 0) {
            } else {
                if (Long.compare(l, l2) > 0) {
                } else {
                    cmp = obj6.length() > 0 ? 1 : 0;
                    try {
                        if (cmp != 0) {
                        } else {
                        }
                        return (int)l;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("expected an int but was \"");
                        stringBuilder.append(l);
                        stringBuilder.append(obj6);
                        stringBuilder.append('"');
                        IOException iOException2 = new IOException(stringBuilder.toString());
                        throw iOException2;
                        h = h.getMessage();
                        IOException iOException = new IOException(h);
                        throw iOException;
                    }
                }
            }
        }

        public final okhttp3.Headers varyHeaders(okhttp3.Response response) {
            n.f(response, "$this$varyHeaders");
            okhttp3.Response networkResponse = response.networkResponse();
            n.d(networkResponse);
            return varyHeaders(networkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(okhttp3.Response response, okhttp3.Headers headers2, okhttp3.Request request3) {
            boolean empty;
            int i;
            List values;
            Object obj4;
            n.f(response, "cachedResponse");
            n.f(headers2, "cachedRequest");
            n.f(request3, "newRequest");
            obj4 = varyFields(response.headers());
            if (obj4 instanceof Collection != null && obj4.isEmpty()) {
                if (obj4.isEmpty()) {
                } else {
                    obj4 = obj4.iterator();
                    while (obj4.hasNext()) {
                        Object next = obj4.next();
                        if (z ^= i) {
                            break;
                        } else {
                        }
                    }
                }
            } else {
            }
            return i;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0011\u0008\u0016\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\u00087\u00108B\u0011\u0008\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\u00087\u00109J\u001d\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J%\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00082\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u000eR\u00020\u000f¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0019\u0010\u0016\u001a\u00020\u00152\n\u0010\u001b\u001a\u00060\u001aR\u00020\u000f¢\u0006\u0004\u0008\u0016\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008 \u0010\u001fR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008+\u0010,R\u0016\u0010-\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008-\u0010\u001fR\u0016\u0010.\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008.\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00080\u00101R\u0016\u00102\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00082\u0010&R\u0016\u00103\u001a\u00020\u00178B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u00083\u00104¨\u0006;", d2 = {"Lokhttp3/Cache$Entry;", "", "Ll/h;", "source", "", "Ljava/security/cert/Certificate;", "readCertificateList", "(Ll/h;)Ljava/util/List;", "Ll/g;", "sink", "certificates", "Lkotlin/w;", "writeCertList", "(Ll/g;Ljava/util/List;)V", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "writeTo", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "response", "", "matches", "(Lokhttp3/Request;Lokhttp3/Response;)Z", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)Lokhttp3/Response;", "", "message", "Ljava/lang/String;", "url", "", "code", "I", "Lokhttp3/Headers;", "varyHeaders", "Lokhttp3/Headers;", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/Protocol;", "", "sentRequestMillis", "J", "requestMethod", "receivedResponseMillis", "Lokhttp3/Handshake;", "handshake", "Lokhttp3/Handshake;", "responseHeaders", "isHttps", "()Z", "Ll/d0;", "rawSource", "<init>", "(Ll/d0;)V", "(Lokhttp3/Response;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    private static final class Entry {

        public static final okhttp3.Cache.Entry.Companion Companion;
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final okhttp3.Handshake handshake;
        private final String message;
        private final okhttp3.Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final okhttp3.Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final okhttp3.Headers varyHeaders;
        static {
            Cache.Entry.Companion companion = new Cache.Entry.Companion(0);
            Cache.Entry.Companion = companion;
            StringBuilder stringBuilder = new StringBuilder();
            Platform.Companion companion2 = Platform.Companion;
            stringBuilder.append(companion2.get().getPrefix());
            stringBuilder.append("-Sent-Millis");
            Cache.Entry.SENT_MILLIS = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(companion2.get().getPrefix());
            stringBuilder2.append("-Received-Millis");
            Cache.Entry.RECEIVED_MILLIS = stringBuilder2.toString();
        }

        public Entry(d0 d0) {
            okhttp3.TlsVersion forJavaName;
            int i2;
            boolean forJavaName2;
            Object certificateList;
            int certificateList2;
            int i3;
            int i;
            long companion2;
            boolean companion;
            String str;
            int long;
            n.f(d0, "rawSource");
            super();
            h hVar = q.d(d0);
            this.url = hVar.m1();
            this.requestMethod = hVar.m1();
            Headers.Builder builder = new Headers.Builder();
            certificateList2 = 0;
            i3 = certificateList2;
            while (i3 < Cache.Companion.readInt$okhttp(hVar)) {
                builder.addLenient$okhttp(hVar.m1());
                i3++;
            }
            this.varyHeaders = builder.build();
            StatusLine parse = StatusLine.Companion.parse(hVar.m1());
            this.protocol = parse.protocol;
            this.code = parse.code;
            this.message = parse.message;
            Headers.Builder builder2 = new Headers.Builder();
            i = certificateList2;
            while (i < Cache.Companion.readInt$okhttp(hVar)) {
                builder2.addLenient$okhttp(hVar.m1());
                i++;
            }
            certificateList = Cache.Entry.SENT_MILLIS;
            String str10 = builder2.get(certificateList);
            String rECEIVED_MILLIS = Cache.Entry.RECEIVED_MILLIS;
            final String str11 = builder2.get(rECEIVED_MILLIS);
            builder2.removeAll(certificateList);
            builder2.removeAll(rECEIVED_MILLIS);
            if (str10 != null) {
                companion2 = Long.parseLong(str10);
            } else {
                try {
                    companion2 = long;
                    this.sentRequestMillis = companion2;
                    if (str11 != null) {
                    }
                    long = Long.parseLong(str11);
                    this.receivedResponseMillis = long;
                    this.responseHeaders = builder2.build();
                    String str6 = hVar.m1();
                    if (isHttps() && str6.length() > 0) {
                    }
                    str6 = hVar.m1();
                    if (str6.length() > 0) {
                    }
                    certificateList2 = 1;
                    if (certificateList2 != 0) {
                    } else {
                    }
                    if (!hVar.b0()) {
                    } else {
                    }
                    forJavaName = TlsVersion.Companion.forJavaName(hVar.m1());
                    forJavaName = TlsVersion.SSL_3_0;
                    this.handshake = Handshake.Companion.get(forJavaName, CipherSuite.Companion.forJavaName(hVar.m1()), readCertificateList(hVar), readCertificateList(hVar));
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("expected \"\" but was \"");
                    stringBuilder.append(str6);
                    stringBuilder.append('"');
                    IOException iOException = new IOException(stringBuilder.toString());
                    throw iOException;
                    this.handshake = 0;
                    d0.close();
                    d0.close();
                    throw th;
                }
            }
        }

        public Entry(okhttp3.Response response) {
            n.f(response, "response");
            super();
            this.url = response.request().url().toString();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        private final boolean isHttps() {
            return l.M(this.url, "https://", false, 2, 0);
        }

        private final List<Certificate> readCertificateList(h h) {
            int i;
            Certificate certificate;
            f fVar;
            i.a aVar;
            int int$okhttp = Cache.Companion.readInt$okhttp(h);
            if (int$okhttp == -1) {
                return p.g();
            }
            ArrayList arrayList = new ArrayList(int$okhttp);
            i = 0;
            while (i < int$okhttp) {
                fVar = new f();
                i iVar = i.v.a(h.m1());
                n.d(iVar);
                fVar.e0(iVar);
                arrayList.add(CertificateFactory.getInstance("X.509").generateCertificate(fVar.g2()));
                i++;
            }
            return arrayList;
        }

        private final void writeCertList(g g, List<? extends Certificate> list2) {
            int i5;
            g gVar;
            i.a aVar;
            byte[] encoded;
            int i2;
            int i;
            int i3;
            int i4;
            try {
                final int i6 = 10;
                g.Y1((long)size).c0(i6);
                i5 = 0;
                while (i5 < list2.size()) {
                    encoded = (Certificate)list2.get(i5).getEncoded();
                    n.e(encoded, "bytes");
                    g.E0(i.a.g(i.v, encoded, 0, 0, 3, 0).a()).c0(i6);
                    i5++;
                }
                encoded = (Certificate)list2.get(i5).getEncoded();
                n.e(encoded, "bytes");
                g.E0(i.a.g(i.v, encoded, 0, 0, 3, 0).a()).c0(i6);
                i5++;
                g = g.getMessage();
                list2 = new IOException(g);
                throw list2;
            }
        }

        public final boolean matches(okhttp3.Request request, okhttp3.Response response2) {
            okhttp3.Cache.Companion companion;
            Object varyHeaders;
            int obj3;
            n.f(request, "request");
            n.f(response2, "response");
            if (n.b(this.url, request.url().toString()) && n.b(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response2, this.varyHeaders, request)) {
                if (n.b(this.requestMethod, request.method())) {
                    obj3 = Cache.Companion.varyMatches(response2, this.varyHeaders, request) ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj3;
        }

        public final okhttp3.Response response(DiskLruCache.Snapshot diskLruCache$Snapshot) {
            n.f(snapshot, "snapshot");
            String str4 = this.responseHeaders.get("Content-Length");
            Request.Builder builder = new Request.Builder();
            Response.Builder builder3 = new Response.Builder();
            Cache.CacheResponseBody cacheResponseBody = new Cache.CacheResponseBody(snapshot, this.responseHeaders.get("Content-Type"), str4);
            return builder3.request(builder.url(this.url).method(this.requestMethod, 0).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(cacheResponseBody).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor diskLruCache$Editor) {
            int i2;
            boolean https;
            int i;
            okhttp3.Protocol protocol;
            g gVar;
            String value;
            long value2;
            n.f(editor, "editor");
            i2 = 0;
            g obj8 = q.c(editor.newSink(i2));
            final int i5 = 10;
            obj8.E0(this.url).c0(i5);
            obj8.E0(this.requestMethod).c0(i5);
            obj8.Y1((long)size).c0(i5);
            i = i2;
            String str2 = ": ";
            while (i < this.varyHeaders.size()) {
                obj8.E0(this.varyHeaders.name(i)).E0(str2).E0(this.varyHeaders.value(i)).c0(i5);
                i++;
                str2 = ": ";
            }
            final String message = this.message;
            StatusLine statusLine = new StatusLine(this.protocol, this.code, message);
            obj8.E0(statusLine.toString()).c0(i5);
            obj8.Y1((long)i4).c0(i5);
            while (i2 < this.responseHeaders.size()) {
                obj8.E0(this.responseHeaders.name(i2)).E0(str2).E0(this.responseHeaders.value(i2)).c0(i5);
                i2++;
            }
            obj8.E0(Cache.Entry.SENT_MILLIS).E0(str2).Y1(this.sentRequestMillis).c0(i5);
            obj8.E0(Cache.Entry.RECEIVED_MILLIS).E0(str2).Y1(this.receivedResponseMillis).c0(i5);
            if (isHttps()) {
                obj8.c0(i5);
                okhttp3.Handshake handshake = this.handshake;
                n.d(handshake);
                obj8.E0(handshake.cipherSuite().javaName()).c0(i5);
                writeCertList(obj8, this.handshake.peerCertificates());
                writeCertList(obj8, this.handshake.localCertificates());
                obj8.E0(this.handshake.tlsVersion().javaName()).c0(i5);
            }
            w wVar = w.a;
            b.a(obj8, 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0002\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0011\u001a\u00060\u000fR\u00020\u0010\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\r\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\r¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u000cR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u000eR\u001d\u0010\u0011\u001a\u00060\u000fR\u00020\u00108\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\u0017", d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Ll/h;", "source", "()Ll/h;", "bodySource", "Ll/h;", "", "Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private static final class CacheResponseBody extends okhttp3.ResponseBody {

        private final h bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;
        public CacheResponseBody(DiskLruCache.Snapshot diskLruCache$Snapshot, String string2, String string3) {
            n.f(snapshot, "snapshot");
            super();
            this.snapshot = snapshot;
            this.contentType = string2;
            this.contentLength = string3;
            d0 obj2 = snapshot.getSource(1);
            Cache.CacheResponseBody.1 obj3 = new Cache.CacheResponseBody.1(this, obj2, obj2);
            this.bodySource = q.d(obj3);
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            int longOrDefault;
            final String contentLength = this.contentLength;
            if (contentLength != null) {
                longOrDefault = Util.toLongOrDefault(contentLength, -1);
            }
            return longOrDefault;
        }

        @Override // okhttp3.ResponseBody
        public okhttp3.MediaType contentType() {
            okhttp3.MediaType parse;
            okhttp3.MediaType.Companion companion;
            String contentType = this.contentType;
            if (contentType != null) {
                parse = MediaType.Companion.parse(contentType);
            } else {
                parse = 0;
            }
            return parse;
        }

        @Override // okhttp3.ResponseBody
        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public h source() {
            return this.bodySource;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u000c\u001a\u00060\nR\u00020\u000b¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0008R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\t\u0010\u0008R\u001a\u0010\u000c\u001a\u00060\nR\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000c\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006\u0017", d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "Lkotlin/w;", "abort", "()V", "Ll/b0;", "body", "()Ll/b0;", "Ll/b0;", "cacheOut", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "done", "Z", "getDone", "()Z", "setDone", "(Z)V", "<init>", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class RealCacheRequest implements CacheRequest {

        private final b0 body;
        private final b0 cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final okhttp3.Cache this$0;
        public RealCacheRequest(okhttp3.Cache cache, DiskLruCache.Editor diskLruCache$Editor2) {
            n.f(editor2, "editor");
            this.this$0 = cache;
            super();
            this.editor = editor2;
            b0 obj2 = editor2.newSink(1);
            this.cacheOut = obj2;
            Cache.RealCacheRequest.1 obj3 = new Cache.RealCacheRequest.1(this, obj2);
            this.body = obj3;
        }

        public static final DiskLruCache.Editor access$getEditor$p(okhttp3.Cache.RealCacheRequest cache$RealCacheRequest) {
            return realCacheRequest.editor;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            okhttp3.Cache this$0 = this.this$0;
            synchronized (this$0) {
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public b0 body() {
            return this.body;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public final boolean getDone() {
            return this.done;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public final void setDone(boolean z) {
            this.done = z;
        }
    }
    static {
        Cache.Companion companion = new Cache.Companion(0);
        Cache.Companion = companion;
    }

    public Cache(File file, long l2) {
        n.f(file, "directory");
        super(file, l2, obj4, FileSystem.SYSTEM);
    }

    public Cache(File file, long l2, FileSystem fileSystem3) {
        n.f(file, "directory");
        n.f(obj13, "fileSystem");
        super();
        super(obj13, file, 201105, 2, l2, obj7, TaskRunner.INSTANCE);
        this.cache = diskLruCache;
    }

    private final void abortQuietly(DiskLruCache.Editor diskLruCache$Editor) {
        if (editor != null) {
            editor.abort();
        }
        try {
        }
    }

    public static final String key(okhttp3.HttpUrl httpUrl) {
        return Cache.Companion.key(httpUrl);
    }

    @Override // java.io.Closeable
    public final File -deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable
    public void close() {
        this.cache.close();
    }

    @Override // java.io.Closeable
    public final void delete() {
        this.cache.delete();
    }

    @Override // java.io.Closeable
    public final File directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable
    public final void evictAll() {
        this.cache.evictAll();
    }

    @Override // java.io.Closeable
    public void flush() {
        this.cache.flush();
    }

    @Override // java.io.Closeable
    public final okhttp3.Response get$okhttp(okhttp3.Request request) {
        n.f(request, "request");
        int i = 0;
        DiskLruCache.Snapshot snapshot = this.cache.get(Cache.Companion.key(request.url()));
        Cache.Entry entry = new Cache.Entry(snapshot.getSource(0));
        okhttp3.Response response = entry.response(snapshot);
        okhttp3.ResponseBody obj5 = response.body();
        if (snapshot != null && !entry.matches(request, response) && obj5 != null) {
            entry = new Cache.Entry(snapshot.getSource(0));
            response = entry.response(snapshot);
            if (!entry.matches(request, response)) {
                obj5 = response.body();
                if (obj5 != null) {
                    Util.closeQuietly(obj5);
                }
                return i;
            }
            return response;
        }
        return i;
    }

    @Override // java.io.Closeable
    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    @Override // java.io.Closeable
    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    @Override // java.io.Closeable
    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    @Override // java.io.Closeable
    public final int hitCount() {
        return this.hitCount;
        synchronized (this) {
            return this.hitCount;
        }
    }

    @Override // java.io.Closeable
    public final void initialize() {
        this.cache.initialize();
    }

    @Override // java.io.Closeable
    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    @Override // java.io.Closeable
    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    @Override // java.io.Closeable
    public final int networkCount() {
        return this.networkCount;
        synchronized (this) {
            return this.networkCount;
        }
    }

    @Override // java.io.Closeable
    public final CacheRequest put$okhttp(okhttp3.Response response) {
        n.f(response, "response");
        int i2 = 0;
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            remove$okhttp(response.request());
            return i2;
        }
        if (z ^= 1 != 0) {
            return i2;
        }
        okhttp3.Cache.Companion companion = Cache.Companion;
        if (companion.hasVaryAll(response)) {
            return i2;
        }
        Cache.Entry entry = new Cache.Entry(response);
        DiskLruCache.Editor obj10 = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0, obj6, 2);
        if (obj10 != null) {
            entry.writeTo(obj10);
            Cache.RealCacheRequest realCacheRequest = new Cache.RealCacheRequest(this, obj10);
            return realCacheRequest;
        }
        return i2;
    }

    @Override // java.io.Closeable
    public final void remove$okhttp(okhttp3.Request request) {
        n.f(request, "request");
        this.cache.remove(Cache.Companion.key(request.url()));
    }

    @Override // java.io.Closeable
    public final int requestCount() {
        return this.requestCount;
        synchronized (this) {
            return this.requestCount;
        }
    }

    @Override // java.io.Closeable
    public final void setWriteAbortCount$okhttp(int i) {
        this.writeAbortCount = i;
    }

    @Override // java.io.Closeable
    public final void setWriteSuccessCount$okhttp(int i) {
        this.writeSuccessCount = i;
    }

    @Override // java.io.Closeable
    public final long size() {
        return this.cache.size();
    }

    @Override // java.io.Closeable
    public final void trackConditionalCacheHit$okhttp() {
        this.hitCount = hitCount++;
        return;
        synchronized (this) {
            this.hitCount = hitCount++;
        }
    }

    @Override // java.io.Closeable
    public final void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        int obj2;
        n.f(cacheStrategy, "cacheStrategy");
        this.requestCount = requestCount++;
        synchronized (this) {
            try {
                this.networkCount = obj2++;
                if (cacheStrategy.getCacheResponse() != null) {
                }
                this.hitCount = obj2++;
                throw cacheStrategy;
            }
        }
    }

    @Override // java.io.Closeable
    public final void update$okhttp(okhttp3.Response response, okhttp3.Response response2) {
        n.f(response, "cached");
        n.f(response2, "network");
        Cache.Entry entry = new Cache.Entry(response2);
        okhttp3.ResponseBody obj2 = response.body();
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        int obj3 = 0;
        obj3 = (Cache.CacheResponseBody)obj2.getSnapshot().edit();
        if (obj3 != null) {
            entry.writeTo(obj3);
            obj3.commit();
        }
    }

    public final Iterator<String> urls() {
        Cache.urls.1 anon = new Cache.urls.1(this);
        return anon;
    }

    @Override // java.io.Closeable
    public final int writeAbortCount() {
        return this.writeAbortCount;
        synchronized (this) {
            return this.writeAbortCount;
        }
    }

    @Override // java.io.Closeable
    public final int writeSuccessCount() {
        return this.writeSuccessCount;
        synchronized (this) {
            return this.writeSuccessCount;
        }
    }
}
