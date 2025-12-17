package com.revenuecat.purchases.common.attribution;

import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008\u0086\u0008\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000c\u001a\u00020\u0005\u0012\u0008\u0010\r\u001a\u0004\u0018\u00010\u0008¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0008HÆ\u0003¢\u0006\u0004\u0008\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0008HÆ\u0001¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0008HÖ\u0001¢\u0006\u0004\u0008\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\u0008\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0016\u0010\u0017R\u0019\u0010\u000c\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010\u0018\u001a\u0004\u0008\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000b\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00088\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\u001c\u001a\u0004\u0008\u001d\u0010\n¨\u0006 ", d2 = {"Lcom/revenuecat/purchases/common/attribution/AttributionData;", "", "Lorg/json/JSONObject;", "component1", "()Lorg/json/JSONObject;", "Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "component2", "()Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "", "component3", "()Ljava/lang/String;", "data", "network", "networkUserId", "copy", "(Lorg/json/JSONObject;Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;Ljava/lang/String;)Lcom/revenuecat/purchases/common/attribution/AttributionData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "getNetwork", "Lorg/json/JSONObject;", "getData", "Ljava/lang/String;", "getNetworkUserId", "<init>", "(Lorg/json/JSONObject;Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class AttributionData {

    private final JSONObject data;
    private final com.revenuecat.purchases.common.attribution.AttributionNetwork network;
    private final String networkUserId;
    public AttributionData(JSONObject jSONObject, com.revenuecat.purchases.common.attribution.AttributionNetwork attributionNetwork2, String string3) {
        n.f(jSONObject, "data");
        n.f(attributionNetwork2, "network");
        super();
        this.data = jSONObject;
        this.network = attributionNetwork2;
        this.networkUserId = string3;
    }

    public static com.revenuecat.purchases.common.attribution.AttributionData copy$default(com.revenuecat.purchases.common.attribution.AttributionData attributionData, JSONObject jSONObject2, com.revenuecat.purchases.common.attribution.AttributionNetwork attributionNetwork3, String string4, int i5, Object object6) {
        JSONObject obj1;
        com.revenuecat.purchases.common.attribution.AttributionNetwork obj2;
        String obj3;
        if (i5 & 1 != 0) {
            obj1 = attributionData.data;
        }
        if (i5 & 2 != 0) {
            obj2 = attributionData.network;
        }
        if (i5 &= 4 != 0) {
            obj3 = attributionData.networkUserId;
        }
        return attributionData.copy(obj1, obj2, obj3);
    }

    public final JSONObject component1() {
        return this.data;
    }

    public final com.revenuecat.purchases.common.attribution.AttributionNetwork component2() {
        return this.network;
    }

    public final String component3() {
        return this.networkUserId;
    }

    public final com.revenuecat.purchases.common.attribution.AttributionData copy(JSONObject jSONObject, com.revenuecat.purchases.common.attribution.AttributionNetwork attributionNetwork2, String string3) {
        n.f(jSONObject, "data");
        n.f(attributionNetwork2, "network");
        AttributionData attributionData = new AttributionData(jSONObject, attributionNetwork2, string3);
        return attributionData;
    }

    public boolean equals(Object object) {
        String networkUserId;
        Object network;
        Object obj3;
        if (this != (AttributionData)object && object instanceof AttributionData != null && n.b(this.data, object.data) && n.b(this.network, object.network) && n.b(this.networkUserId, object.networkUserId)) {
            if (object instanceof AttributionData != null) {
                if (n.b(this.data, object.data)) {
                    if (n.b(this.network, object.network)) {
                        if (n.b(this.networkUserId, object.networkUserId)) {
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final com.revenuecat.purchases.common.attribution.AttributionNetwork getNetwork() {
        return this.network;
    }

    public final String getNetworkUserId() {
        return this.networkUserId;
    }

    public int hashCode() {
        int i2;
        int i;
        int i3;
        JSONObject data = this.data;
        i = 0;
        if (data != null) {
            i2 = data.hashCode();
        } else {
            i2 = i;
        }
        com.revenuecat.purchases.common.attribution.AttributionNetwork network = this.network;
        if (network != null) {
            i3 = network.hashCode();
        } else {
            i3 = i;
        }
        String networkUserId = this.networkUserId;
        if (networkUserId != null) {
            i = networkUserId.hashCode();
        }
        return i6 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AttributionData(data=");
        stringBuilder.append(this.data);
        stringBuilder.append(", network=");
        stringBuilder.append(this.network);
        stringBuilder.append(", networkUserId=");
        stringBuilder.append(this.networkUserId);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
