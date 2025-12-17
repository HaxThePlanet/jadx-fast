package com.revenuecat.purchases.common.networking;

import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008\u0080\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000c\u001a\u00020\u0002\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\u0008 \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\u0008\n\u0010\u000bJ<\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00022\u0014\u0008\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0018\u0010\u0019R\u0019\u0010\u000c\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u001c\u001a\u0004\u0008\u001d\u0010\u000bR%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\u001e\u001a\u0004\u0008\u001f\u0010\u0008¨\u0006\"", d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPRequest;", "", "Ljava/net/URL;", "component1", "()Ljava/net/URL;", "", "", "component2", "()Ljava/util/Map;", "Lorg/json/JSONObject;", "component3", "()Lorg/json/JSONObject;", "fullURL", "headers", "body", "copy", "(Ljava/net/URL;Ljava/util/Map;Lorg/json/JSONObject;)Lcom/revenuecat/purchases/common/networking/HTTPRequest;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/net/URL;", "getFullURL", "Lorg/json/JSONObject;", "getBody", "Ljava/util/Map;", "getHeaders", "<init>", "(Ljava/net/URL;Ljava/util/Map;Lorg/json/JSONObject;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class HTTPRequest {

    private final JSONObject body;
    private final URL fullURL;
    private final Map<String, String> headers;
    public HTTPRequest(URL uRL, Map<String, String> map2, JSONObject jSONObject3) {
        n.f(uRL, "fullURL");
        n.f(map2, "headers");
        super();
        this.fullURL = uRL;
        this.headers = map2;
        this.body = jSONObject3;
    }

    public static com.revenuecat.purchases.common.networking.HTTPRequest copy$default(com.revenuecat.purchases.common.networking.HTTPRequest hTTPRequest, URL uRL2, Map map3, JSONObject jSONObject4, int i5, Object object6) {
        URL obj1;
        Map obj2;
        JSONObject obj3;
        if (i5 & 1 != 0) {
            obj1 = hTTPRequest.fullURL;
        }
        if (i5 & 2 != 0) {
            obj2 = hTTPRequest.headers;
        }
        if (i5 &= 4 != 0) {
            obj3 = hTTPRequest.body;
        }
        return hTTPRequest.copy(obj1, obj2, obj3);
    }

    public final URL component1() {
        return this.fullURL;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    public final JSONObject component3() {
        return this.body;
    }

    public final com.revenuecat.purchases.common.networking.HTTPRequest copy(URL uRL, Map<String, String> map2, JSONObject jSONObject3) {
        n.f(uRL, "fullURL");
        n.f(map2, "headers");
        HTTPRequest hTTPRequest = new HTTPRequest(uRL, map2, jSONObject3);
        return hTTPRequest;
    }

    public boolean equals(Object object) {
        JSONObject body;
        Object fullURL;
        Object obj3;
        if (this != (HTTPRequest)object && object instanceof HTTPRequest != null && n.b(this.fullURL, object.fullURL) && n.b(this.headers, object.headers) && n.b(this.body, object.body)) {
            if (object instanceof HTTPRequest != null) {
                if (n.b(this.fullURL, object.fullURL)) {
                    if (n.b(this.headers, object.headers)) {
                        if (n.b(this.body, object.body)) {
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final URL getFullURL() {
        return this.fullURL;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        URL fullURL = this.fullURL;
        i2 = 0;
        if (fullURL != null) {
            i = fullURL.hashCode();
        } else {
            i = i2;
        }
        Map headers = this.headers;
        if (headers != null) {
            i3 = headers.hashCode();
        } else {
            i3 = i2;
        }
        JSONObject body = this.body;
        if (body != null) {
            i2 = body.hashCode();
        }
        return i6 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTPRequest(fullURL=");
        stringBuilder.append(this.fullURL);
        stringBuilder.append(", headers=");
        stringBuilder.append(this.headers);
        stringBuilder.append(", body=");
        stringBuilder.append(this.body);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
