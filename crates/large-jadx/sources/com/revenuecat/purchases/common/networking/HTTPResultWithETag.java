package com.revenuecat.purchases.common.networking;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\n\u0008\u0086\u0008\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\u0008\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\u0008\u0007\u0010\u0008J$\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\t\u001a\u00020\u00022\u0008\u0008\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\n\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0008R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\u0017\u001a\u0004\u0008\u0018\u0010\u0004¨\u0006\u001c", d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag;", "", "", "serialize", "()Ljava/lang/String;", "component1", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "component2", "()Lcom/revenuecat/purchases/common/networking/HTTPResult;", "eTag", "httpResult", "copy", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/networking/HTTPResult;)Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "getHttpResult", "Ljava/lang/String;", "getETag", "<init>", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/networking/HTTPResult;)V", "Companion", "common_release"}, k = 1, mv = {1, 4, 0})
public final class HTTPResultWithETag {

    public static final com.revenuecat.purchases.common.networking.HTTPResultWithETag.Companion Companion;
    private final String eTag;
    private final com.revenuecat.purchases.common.networking.HTTPResult httpResult;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag$Companion;", "", "", "serialized", "Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag;", "deserialize", "(Ljava/lang/String;)Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final com.revenuecat.purchases.common.networking.HTTPResultWithETag deserialize(String string) {
            n.f(string, "serialized");
            JSONObject jSONObject = new JSONObject(string);
            String obj5 = "eTag";
            final String string3 = jSONObject.getString(obj5);
            String string2 = jSONObject.getString("httpResult");
            n.e(string3, obj5);
            n.e(string2, "serializedHTTPResult");
            HTTPResultWithETag hTTPResultWithETag = new HTTPResultWithETag(string3, HTTPResult.Companion.deserialize(string2));
            return hTTPResultWithETag;
        }
    }
    static {
        HTTPResultWithETag.Companion companion = new HTTPResultWithETag.Companion(0);
        HTTPResultWithETag.Companion = companion;
    }

    public HTTPResultWithETag(String string, com.revenuecat.purchases.common.networking.HTTPResult hTTPResult2) {
        n.f(string, "eTag");
        n.f(hTTPResult2, "httpResult");
        super();
        this.eTag = string;
        this.httpResult = hTTPResult2;
    }

    public static com.revenuecat.purchases.common.networking.HTTPResultWithETag copy$default(com.revenuecat.purchases.common.networking.HTTPResultWithETag hTTPResultWithETag, String string2, com.revenuecat.purchases.common.networking.HTTPResult hTTPResult3, int i4, Object object5) {
        String obj1;
        com.revenuecat.purchases.common.networking.HTTPResult obj2;
        if (i4 & 1 != 0) {
            obj1 = hTTPResultWithETag.eTag;
        }
        if (i4 &= 2 != 0) {
            obj2 = hTTPResultWithETag.httpResult;
        }
        return hTTPResultWithETag.copy(obj1, obj2);
    }

    public final String component1() {
        return this.eTag;
    }

    public final com.revenuecat.purchases.common.networking.HTTPResult component2() {
        return this.httpResult;
    }

    public final com.revenuecat.purchases.common.networking.HTTPResultWithETag copy(String string, com.revenuecat.purchases.common.networking.HTTPResult hTTPResult2) {
        n.f(string, "eTag");
        n.f(hTTPResult2, "httpResult");
        HTTPResultWithETag hTTPResultWithETag = new HTTPResultWithETag(string, hTTPResult2);
        return hTTPResultWithETag;
    }

    public boolean equals(Object object) {
        boolean httpResult;
        String eTag;
        Object obj3;
        if (this != (HTTPResultWithETag)object && object instanceof HTTPResultWithETag && n.b(this.eTag, object.eTag) && n.b(this.httpResult, object.httpResult)) {
            if (object instanceof HTTPResultWithETag) {
                if (n.b(this.eTag, object.eTag)) {
                    if (n.b(this.httpResult, object.httpResult)) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final String getETag() {
        return this.eTag;
    }

    public final com.revenuecat.purchases.common.networking.HTTPResult getHttpResult() {
        return this.httpResult;
    }

    public int hashCode() {
        int i;
        int i2;
        String eTag = this.eTag;
        if (eTag != null) {
            i = eTag.hashCode();
        } else {
            i = i2;
        }
        final com.revenuecat.purchases.common.networking.HTTPResult httpResult = this.httpResult;
        if (httpResult != null) {
            i2 = httpResult.hashCode();
        }
        return i3 += i2;
    }

    public final String serialize() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("eTag", this.eTag);
        jSONObject.put("httpResult", this.httpResult.serialize());
        String string = jSONObject.toString();
        n.e(string, "JSONObject().apply {\n   …e())\n        }.toString()");
        return string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTPResultWithETag(eTag=");
        stringBuilder.append(this.eTag);
        stringBuilder.append(", httpResult=");
        stringBuilder.append(this.httpResult);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
