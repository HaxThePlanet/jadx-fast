package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.common.attribution.AttributionNetwork;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0018\u0010\u0019J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J#\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0008\u0010\u0007J#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\t\u0010\u0007J#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\n\u0010\u0007J3\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ4\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011\"\u0004\u0008\u0000\u0010\u000e\"\u0004\u0008\u0001\u0010\u000f*\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0082\u0004¢\u0006\u0004\u0008\u0012\u0010\u0013J)\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\u0008\u0016\u0010\u0017¨\u0006\u001a", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/AttributionDataMigrator;", "", "Lorg/json/JSONObject;", "data", "", "", "convertMParticleAttribution", "(Lorg/json/JSONObject;)Ljava/util/Map;", "convertBranchAttribution", "convertAppsFlyerAttribution", "convertAdjustAttribution", "mapping", "convertToSubscriberAttributes", "(Lorg/json/JSONObject;Ljava/util/Map;)Ljava/util/Map;", "A", "B", "that", "Lkotlin/o;", "or", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/o;", "Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "network", "convertAttributionDataToSubscriberAttributes", "(Lorg/json/JSONObject;Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;)Ljava/util/Map;", "<init>", "()V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
public final class AttributionDataMigrator {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            AttributionDataMigrator.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[AttributionNetwork.ADJUST.ordinal()] = 1;
            iArr[AttributionNetwork.APPSFLYER.ordinal()] = 2;
            iArr[AttributionNetwork.BRANCH.ordinal()] = 3;
            iArr[AttributionNetwork.MPARTICLE.ordinal()] = 4;
            iArr[AttributionNetwork.TENJIN.ordinal()] = 5;
            iArr[AttributionNetwork.FACEBOOK.ordinal()] = 6;
        }
    }
    private final Map<String, String> convertAdjustAttribution(JSONObject jSONObject) {
        o[] arr = new o[5];
        return convertToSubscriberAttributes(jSONObject, j0.k(u.a(or("adid", "rc_attribution_network_id"), "$adjustId"), u.a("network", "$mediaSource"), u.a("campaign", "$campaign"), u.a("adgroup", "$adGroup"), u.a("creative", "$creative")));
    }

    private final Map<String, String> convertAppsFlyerAttribution(JSONObject jSONObject) {
        boolean keys;
        Object next;
        Object obj;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (jSONObject.has("status") && optJSONObject != null) {
            if (optJSONObject != null) {
                keys = optJSONObject.keys();
                for (String next : keys) {
                    jSONObject.put(next, optJSONObject.get(next));
                }
            }
        }
        o[] arr = new o[7];
        return convertToSubscriberAttributes(jSONObject, j0.k(u.a(or("rc_appsflyer_id", "rc_attribution_network_id"), "$appsflyerId"), u.a(or("af_channel", "media_source"), "$mediaSource"), u.a("campaign", "$campaign"), u.a("adset", "$adGroup"), u.a(or("af_ad", "adgroup"), "$ad"), u.a("af_keywords", "$keyword"), u.a("ad_id", "$creative")));
    }

    private final Map<String, String> convertBranchAttribution(JSONObject jSONObject) {
        o[] arr = new o[2];
        return convertToSubscriberAttributes(jSONObject, j0.k(u.a("channel", "$mediaSource"), u.a("campaign", "$campaign")));
    }

    private final Map<String, String> convertMParticleAttribution(JSONObject jSONObject) {
        return convertToSubscriberAttributes(jSONObject, j0.e(u.a(or("rc_attribution_network_id", "mpid"), "$mparticleId")));
    }

    private final Map<String, String> convertToSubscriberAttributes(JSONObject jSONObject, Map<Object, String> map2) {
        Object value;
        Object optNullableString2;
        boolean optNullableString;
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator obj7 = map2.entrySet().iterator();
        while (obj7.hasNext()) {
            Object next2 = obj7.next();
            optNullableString2 = (Map.Entry)next2.getKey();
            value = next2.getValue();
            if (optNullableString2 instanceof String != null) {
            } else {
            }
            if (optNullableString2 instanceof o) {
            }
            Object obj2 = (o)optNullableString2.c();
            str = "null cannot be cast to non-null type kotlin.String";
            Objects.requireNonNull(obj2, str);
            Object obj = optNullableString2.d();
            Objects.requireNonNull(obj, str);
            if (JSONObjectExtensionsKt.optNullableString(jSONObject, (String)obj2) != null) {
            } else {
            }
            optNullableString = optNullableString2;
            if (optNullableString != null) {
            }
            linkedHashMap.put((String)value, optNullableString);
            optNullableString2 = JSONObjectExtensionsKt.optNullableString(jSONObject, (String)optNullableString2);
            if (optNullableString2 != null) {
            }
            linkedHashMap.put(value, optNullableString2);
        }
        return linkedHashMap;
    }

    private final <A, B> o<A, B> or(A a, B b2) {
        return u.a(a, b2);
    }

    public final Map<String, String> convertAttributionDataToSubscriberAttributes(JSONObject jSONObject, AttributionNetwork attributionNetwork2) {
        Map obj4;
        n.f(jSONObject, "data");
        n.f(attributionNetwork2, "network");
        o[] arr = new o[4];
        switch (obj5) {
            case 1:
                obj4 = convertAdjustAttribution(jSONObject);
                break;
            case 2:
                obj4 = convertAppsFlyerAttribution(jSONObject);
                break;
            case 3:
                obj4 = convertBranchAttribution(jSONObject);
                break;
            case 4:
                obj4 = convertMParticleAttribution(jSONObject);
                break;
            case 5:
                obj4 = j0.h();
                break;
            default:
                obj4 = new NoWhenBranchMatchedException();
                throw obj4;
        }
        return j0.o(convertToSubscriberAttributes(jSONObject, j0.k(u.a("rc_idfa", "$idfa"), u.a("rc_idfv", "$idfv"), u.a("rc_ip_address", "$ip"), u.a("rc_gps_adid", "$gpsAdId"))), obj4);
    }
}
