package com.revenuecat.purchases.common.networking;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0008\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\u0008\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0010\u0010\u0008\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0008\u0010\u0004J$\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0007J\u001a\u0010\u0011\u001a\u00020\u00102\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0018\u0010\u0019R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\n\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u0004¨\u0006\u001f", d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult;", "", "", "serialize", "()Ljava/lang/String;", "", "component1", "()I", "component2", "responseCode", "payload", "copy", "(ILjava/lang/String;)Lcom/revenuecat/purchases/common/networking/HTTPResult;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getResponseCode", "Lorg/json/JSONObject;", "body", "Lorg/json/JSONObject;", "getBody", "()Lorg/json/JSONObject;", "Ljava/lang/String;", "getPayload", "<init>", "(ILjava/lang/String;)V", "Companion", "common_release"}, k = 1, mv = {1, 4, 0})
public final class HTTPResult {

    public static final com.revenuecat.purchases.common.networking.HTTPResult.Companion Companion;
    private final JSONObject body;
    private final String payload;
    private final int responseCode;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPResult$Companion;", "", "", "serialized", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "deserialize", "(Ljava/lang/String;)Lcom/revenuecat/purchases/common/networking/HTTPResult;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final com.revenuecat.purchases.common.networking.HTTPResult deserialize(String string) {
            n.f(string, "serialized");
            JSONObject jSONObject = new JSONObject(string);
            final String str2 = "payload";
            String string2 = jSONObject.getString(str2);
            n.e(string2, str2);
            HTTPResult hTTPResult = new HTTPResult(jSONObject.getInt("responseCode"), string2);
            return hTTPResult;
        }
    }
    static {
        HTTPResult.Companion companion = new HTTPResult.Companion(0);
        HTTPResult.Companion = companion;
    }

    public HTTPResult(int i, String string2) {
        Object obj3;
        n.f(string2, "payload");
        super();
        this.responseCode = i;
        this.payload = string2;
        if (obj2 ^= 1 != 0) {
        } else {
            obj3 = 0;
        }
        if (obj3 != null) {
            JSONObject obj2 = new JSONObject(obj3);
        } else {
            super();
        }
        this.body = obj2;
    }

    public static com.revenuecat.purchases.common.networking.HTTPResult copy$default(com.revenuecat.purchases.common.networking.HTTPResult hTTPResult, int i2, String string3, int i4, Object object5) {
        int obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = hTTPResult.responseCode;
        }
        if (i4 &= 2 != 0) {
            obj2 = hTTPResult.payload;
        }
        return hTTPResult.copy(obj1, obj2);
    }

    public final int component1() {
        return this.responseCode;
    }

    public final String component2() {
        return this.payload;
    }

    public final com.revenuecat.purchases.common.networking.HTTPResult copy(int i, String string2) {
        n.f(string2, "payload");
        HTTPResult hTTPResult = new HTTPResult(i, string2);
        return hTTPResult;
    }

    public boolean equals(Object object) {
        boolean responseCode;
        int responseCode2;
        Object obj3;
        if (this != (HTTPResult)object && object instanceof HTTPResult != null && this.responseCode == object.responseCode && n.b(this.payload, object.payload)) {
            if (object instanceof HTTPResult != null) {
                if (this.responseCode == object.responseCode) {
                    if (n.b(this.payload, object.payload)) {
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

    public final String getPayload() {
        return this.payload;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public int hashCode() {
        int i;
        String payload = this.payload;
        if (payload != null) {
            i = payload.hashCode();
        } else {
            i = 0;
        }
        return i2 += i;
    }

    public final String serialize() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("responseCode", this.responseCode);
        jSONObject.put("payload", this.payload);
        String string = jSONObject.toString();
        n.e(string, "jsonObject.toString()");
        return string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTPResult(responseCode=");
        stringBuilder.append(this.responseCode);
        stringBuilder.append(", payload=");
        stringBuilder.append(this.payload);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
