package okhttp3;

import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.o;
import kotlin.y.j0;
import kotlin.y.p;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010$\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\n\u0018\u00002\u00020\u0001:\u00015BC\u0008\u0000\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0019\u0012\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\u0016\u0010&\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000c\u0012\u0004\u0012\u00020\u00010%¢\u0006\u0004\u00083\u00104J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\u0008\t\u0010\nJ%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\u0008\u0000\u0010\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000c¢\u0006\u0004\u0008\t\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\u0008\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0012H\u0007¢\u0006\u0004\u0008\u0013\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0016\u0010\u0017J\u000f\u0010\u0007\u001a\u00020\u0019H\u0007¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u000f\u0010#\u001a\u00020 H\u0007¢\u0006\u0004\u0008!\u0010\"J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008$\u0010\u0017R,\u0010&\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000c\u0012\u0004\u0012\u00020\u00010%8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008&\u0010'\u001a\u0004\u0008(\u0010)R\u0013\u0010#\u001a\u00020 8G@\u0006¢\u0006\u0006\u001a\u0004\u0008#\u0010\"R\u0019\u0010\u0007\u001a\u00020\u00198\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0007\u0010*\u001a\u0004\u0008\u0007\u0010\u001bR\u0019\u0010\u0015\u001a\u00020\u00128\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0015\u0010+\u001a\u0004\u0008\u0015\u0010\u0014R\u0013\u0010-\u001a\u00020,8F@\u0006¢\u0006\u0006\u001a\u0004\u0008-\u0010.R\u0019\u0010\u0018\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0018\u0010/\u001a\u0004\u0008\u0018\u0010\u0017R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u001f\u00100\u001a\u0004\u0008\u001f\u0010\u001eR\u0018\u00101\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00081\u00102¨\u00066", d2 = {"Lokhttp3/Request;", "", "", "name", "header", "(Ljava/lang/String;)Ljava/lang/String;", "", "headers", "(Ljava/lang/String;)Ljava/util/List;", "tag", "()Ljava/lang/Object;", "T", "Ljava/lang/Class;", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lokhttp3/Request$Builder;", "newBuilder", "()Lokhttp3/Request$Builder;", "Lokhttp3/HttpUrl;", "-deprecated_url", "()Lokhttp3/HttpUrl;", "url", "-deprecated_method", "()Ljava/lang/String;", "method", "Lokhttp3/Headers;", "-deprecated_headers", "()Lokhttp3/Headers;", "Lokhttp3/RequestBody;", "-deprecated_body", "()Lokhttp3/RequestBody;", "body", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "toString", "", "tags", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "Lokhttp3/Headers;", "Lokhttp3/HttpUrl;", "", "isHttps", "()Z", "Ljava/lang/String;", "Lokhttp3/RequestBody;", "lazyCacheControl", "Lokhttp3/CacheControl;", "<init>", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Request {

    private final okhttp3.RequestBody body;
    private final okhttp3.Headers headers;
    private okhttp3.CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final okhttp3.HttpUrl url;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010%\n\u0002\u0008\u0015\u0008\u0016\u0018\u00002\u00020\u0001B\t\u0008\u0016¢\u0006\u0004\u0008F\u0010GB\u0011\u0008\u0010\u0012\u0006\u0010H\u001a\u00020'¢\u0006\u0004\u0008F\u0010IJ\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0006J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0008J\u001f\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u001f\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\r\u0010\u000cJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u000e\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0000H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00002\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0017¢\u0006\u0004\u0008\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\u0008\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\u0008\u001e\u0010\u001bJ!\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\u0008\u001f\u0010 J\u0019\u0010!\u001a\u00020\u00002\u0008\u0010!\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\u0008!\u0010\"J/\u0010!\u001a\u00020\u0000\"\u0004\u0008\u0000\u0010#2\u000e\u0010%\u001a\n\u0012\u0006\u0008\u0000\u0012\u00028\u00000$2\u0008\u0010!\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\u0008!\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\u0008(\u0010)R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0019\u0010*\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R\"\u0010\u0010\u001a\u00020/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0010\u00100\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R2\u00106\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030$\u0012\u0004\u0012\u00020\u0001058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u00086\u00107\u001a\u0004\u00088\u00109\"\u0004\u0008:\u0010;R\"\u0010\u001f\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u001f\u0010<\u001a\u0004\u0008=\u0010>\"\u0004\u0008?\u0010@R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0003\u0010A\u001a\u0004\u0008B\u0010C\"\u0004\u0008D\u0010E¨\u0006J", d2 = {"Lokhttp3/Request$Builder;", "", "Lokhttp3/HttpUrl;", "url", "(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;", "", "(Ljava/lang/String;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/Request$Builder;", "name", "value", "header", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Request$Builder;", "Lokhttp3/CacheControl;", "cacheControl", "(Lokhttp3/CacheControl;)Lokhttp3/Request$Builder;", "get", "()Lokhttp3/Request$Builder;", "head", "Lokhttp3/RequestBody;", "body", "post", "(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;", "delete", "put", "patch", "method", "(Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;", "tag", "(Ljava/lang/Object;)Lokhttp3/Request$Builder;", "T", "Ljava/lang/Class;", "type", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Lokhttp3/Request;", "build", "()Lokhttp3/Request;", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "Lokhttp3/Headers$Builder;", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "", "tags", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "Ljava/lang/String;", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "<init>", "()V", "request", "(Lokhttp3/Request;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static class Builder {

        private okhttp3.RequestBody body;
        private okhttp3.Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private okhttp3.HttpUrl url;
        public Builder() {
            super();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.tags = linkedHashMap;
            this.method = "GET";
            Headers.Builder builder = new Headers.Builder();
            this.headers = builder;
        }

        public Builder(okhttp3.Request request) {
            Object linkedHashMap;
            n.f(request, "request");
            super();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            this.tags = linkedHashMap2;
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                linkedHashMap = new LinkedHashMap();
            } else {
                linkedHashMap = j0.y(request.getTags$okhttp());
            }
            this.tags = linkedHashMap;
            this.headers = request.headers().newBuilder();
        }

        public static okhttp3.Request.Builder delete$default(okhttp3.Request.Builder request$Builder, okhttp3.RequestBody requestBody2, int i3, Object object4) {
            okhttp3.RequestBody obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = Util.EMPTY_REQUEST;
                }
                return builder.delete(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            throw obj0;
        }

        public okhttp3.Request.Builder addHeader(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "value");
            this.headers.add(string, string2);
            return this;
        }

        public okhttp3.Request build() {
            okhttp3.HttpUrl url = this.url;
            if (url == null) {
            } else {
                super(url, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
                return request2;
            }
            IllegalStateException illegalStateException = new IllegalStateException("url == null".toString());
            throw illegalStateException;
        }

        public okhttp3.Request.Builder cacheControl(okhttp3.CacheControl cacheControl) {
            int i;
            okhttp3.Request.Builder obj3;
            n.f(cacheControl, "cacheControl");
            obj3 = cacheControl.toString();
            i = obj3.length() == 0 ? 1 : 0;
            final String str2 = "Cache-Control";
            if (i != 0) {
                obj3 = removeHeader(str2);
            } else {
                obj3 = header(str2, obj3);
            }
            return obj3;
        }

        public final okhttp3.Request.Builder delete() {
            int i = 0;
            return Request.Builder.delete$default(this, i, 1, i);
        }

        public okhttp3.Request.Builder delete(okhttp3.RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public okhttp3.Request.Builder get() {
            return method("GET", 0);
        }

        public final okhttp3.RequestBody getBody$okhttp() {
            return this.body;
        }

        public final okhttp3.Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final okhttp3.HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public okhttp3.Request.Builder head() {
            return method("HEAD", 0);
        }

        public okhttp3.Request.Builder header(String string, String string2) {
            n.f(string, "name");
            n.f(string2, "value");
            this.headers.set(string, string2);
            return this;
        }

        public okhttp3.Request.Builder headers(okhttp3.Headers headers) {
            n.f(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        public okhttp3.Request.Builder method(String string, okhttp3.RequestBody requestBody2) {
            int i;
            int permitsRequestBody;
            boolean requiresRequestBody;
            n.f(string, "method");
            int i2 = 1;
            i = string.length() > 0 ? i2 : 0;
            if (i == 0) {
            } else {
                String str2 = "method ";
                if (requestBody2 == null) {
                    if (i2 ^= requiresRequestBody == 0) {
                    } else {
                        this.method = string;
                        this.body = requestBody2;
                        return this;
                    }
                    StringBuilder obj5 = new StringBuilder();
                    obj5.append(str2);
                    obj5.append(string);
                    obj5.append(" must have a request body.");
                    obj5 = new IllegalArgumentException(obj5.toString().toString());
                    throw obj5;
                }
                if (!HttpMethod.permitsRequestBody(string)) {
                } else {
                }
                obj5 = new StringBuilder();
                obj5.append(str2);
                obj5.append(string);
                obj5.append(" must not have a request body.");
                obj5 = new IllegalArgumentException(obj5.toString().toString());
                throw obj5;
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("method.isEmpty() == true".toString());
            throw obj4;
        }

        public okhttp3.Request.Builder patch(okhttp3.RequestBody requestBody) {
            n.f(requestBody, "body");
            return method("PATCH", requestBody);
        }

        public okhttp3.Request.Builder post(okhttp3.RequestBody requestBody) {
            n.f(requestBody, "body");
            return method("POST", requestBody);
        }

        public okhttp3.Request.Builder put(okhttp3.RequestBody requestBody) {
            n.f(requestBody, "body");
            return method("PUT", requestBody);
        }

        public okhttp3.Request.Builder removeHeader(String string) {
            n.f(string, "name");
            this.headers.removeAll(string);
            return this;
        }

        public final void setBody$okhttp(okhttp3.RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(okhttp3.Headers.Builder headers$Builder) {
            n.f(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String string) {
            n.f(string, "<set-?>");
            this.method = string;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> map) {
            n.f(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(okhttp3.HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public <T> okhttp3.Request.Builder tag(Class<? super T> class, T t2) {
            Object tags;
            boolean linkedHashMap;
            Object obj3;
            n.f(class, "type");
            if (t2 == null) {
                this.tags.remove(class);
            } else {
                if (this.tags.isEmpty()) {
                    linkedHashMap = new LinkedHashMap();
                    this.tags = linkedHashMap;
                }
                obj3 = class.cast(t2);
                n.d(obj3);
                this.tags.put(class, obj3);
            }
            return this;
        }

        public okhttp3.Request.Builder tag(Object object) {
            return tag(Object.class, object);
        }

        public okhttp3.Request.Builder url(String string) {
            StringBuilder stringBuilder;
            int i;
            Object obj4;
            n.f(string, "url");
            i = 1;
            final String str6 = "(this as java.lang.String).substring(startIndex)";
            if (l.K(string, "ws:", i)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("http:");
                obj4 = string.substring(3);
                n.e(obj4, str6);
                stringBuilder.append(obj4);
                obj4 = stringBuilder.toString();
            } else {
                if (l.K(string, "wss:", i)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("https:");
                    obj4 = string.substring(4);
                    n.e(obj4, str6);
                    stringBuilder.append(obj4);
                    obj4 = stringBuilder.toString();
                }
            }
            return url(HttpUrl.Companion.get(obj4));
        }

        public okhttp3.Request.Builder url(URL uRL) {
            n.f(uRL, "url");
            String obj3 = uRL.toString();
            n.e(obj3, "url.toString()");
            return url(HttpUrl.Companion.get(obj3));
        }

        public okhttp3.Request.Builder url(okhttp3.HttpUrl httpUrl) {
            n.f(httpUrl, "url");
            this.url = httpUrl;
            return this;
        }
    }
    public Request(okhttp3.HttpUrl httpUrl, String string2, okhttp3.Headers headers3, okhttp3.RequestBody requestBody4, Map<Class<?>, ? extends Object> map5) {
        n.f(httpUrl, "url");
        n.f(string2, "method");
        n.f(headers3, "headers");
        n.f(map5, "tags");
        super();
        this.url = httpUrl;
        this.method = string2;
        this.headers = headers3;
        this.body = requestBody4;
        this.tags = map5;
    }

    public final okhttp3.RequestBody -deprecated_body() {
        return this.body;
    }

    public final okhttp3.CacheControl -deprecated_cacheControl() {
        return cacheControl();
    }

    public final okhttp3.Headers -deprecated_headers() {
        return this.headers;
    }

    public final String -deprecated_method() {
        return this.method;
    }

    public final okhttp3.HttpUrl -deprecated_url() {
        return this.url;
    }

    public final okhttp3.RequestBody body() {
        return this.body;
    }

    public final okhttp3.CacheControl cacheControl() {
        okhttp3.CacheControl lazyCacheControl;
        okhttp3.Headers headers;
        if (this.lazyCacheControl == null) {
            this.lazyCacheControl = CacheControl.Companion.parse(this.headers);
        }
        return lazyCacheControl;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String string) {
        n.f(string, "name");
        return this.headers.get(string);
    }

    public final List<String> headers(String string) {
        n.f(string, "name");
        return this.headers.values(string);
    }

    public final okhttp3.Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final okhttp3.Request.Builder newBuilder() {
        Request.Builder builder = new Request.Builder(this);
        return builder;
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public final <T> T tag(Class<? extends T> class) {
        n.f(class, "type");
        return class.cast(this.tags.get(class));
    }

    public String toString() {
        int size;
        int tags;
        int str;
        boolean next;
        int i;
        Object obj;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request{method=");
        stringBuilder.append(this.method);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        if (this.headers.size() != 0) {
            stringBuilder.append(", headers=[");
            str = 0;
            Iterator iterator = this.headers.iterator();
            for (Object next2 : iterator) {
                if (str > 0) {
                }
                stringBuilder.append((String)(o)next2.a());
                stringBuilder.append(':');
                stringBuilder.append((String)next2.b());
                str = i;
                stringBuilder.append(", ");
            }
            stringBuilder.append(']');
        }
        if (empty ^= 1 != 0) {
            stringBuilder.append(", tags=");
            stringBuilder.append(this.tags);
        }
        stringBuilder.append('}');
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final okhttp3.HttpUrl url() {
        return this.url;
    }
}
