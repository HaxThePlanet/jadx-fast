package com.revenuecat.purchases.subscriberattributes;

import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.j0.i;
import kotlin.y.j0;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a5\u0010\t\u001a&\u0012\u0008\u0012\u00060\u0002j\u0002`\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u00070\u0001j\u0002`\u0008*\u00020\u0000¢\u0006\u0004\u0008\t\u0010\u0005\u001a!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0007*\u00020\u0000¢\u0006\u0004\u0008\n\u0010\u0005¨\u0006\u000b", d2 = {"Lorg/json/JSONObject;", "", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "buildLegacySubscriberAttributes", "(Lorg/json/JSONObject;)Ljava/util/Map;", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesPerAppUserIDMap;", "buildSubscriberAttributesMapPerUser", "buildSubscriberAttributesMap", "subscriber-attributes_release"}, k = 2, mv = {1, 4, 0})
public final class SubscriberAttributesFactoriesKt {
    public static final Map<String, com.revenuecat.purchases.subscriberattributes.SubscriberAttribute> buildLegacySubscriberAttributes(JSONObject jSONObject) {
        n.f(jSONObject, "$this$buildLegacySubscriberAttributes");
        JSONObject obj1 = jSONObject.getJSONObject("attributes");
        n.e(obj1, "attributesJSONObject");
        return SubscriberAttributesFactoriesKt.buildSubscriberAttributesMap(obj1);
    }

    public static final Map<String, com.revenuecat.purchases.subscriberattributes.SubscriberAttribute> buildSubscriberAttributesMap(JSONObject jSONObject) {
        n.f(jSONObject, "$this$buildSubscriberAttributesMap");
        java.util.Iterator keys = jSONObject.keys();
        n.e(keys, "this.keys()");
        SubscriberAttributesFactoriesKt.buildSubscriberAttributesMap.1 anon = new SubscriberAttributesFactoriesKt.buildSubscriberAttributesMap.1(jSONObject);
        return j0.v(i.u(i.a(keys), anon));
    }

    public static final Map<String, Map<String, com.revenuecat.purchases.subscriberattributes.SubscriberAttribute>> buildSubscriberAttributesMapPerUser(JSONObject jSONObject) {
        n.f(jSONObject, "$this$buildSubscriberAttributesMapPerUser");
        JSONObject obj2 = jSONObject.getJSONObject("attributes");
        java.util.Iterator keys = obj2.keys();
        n.e(keys, "attributesJSONObject.keys()");
        SubscriberAttributesFactoriesKt.buildSubscriberAttributesMapPerUser.1 anon = new SubscriberAttributesFactoriesKt.buildSubscriberAttributesMapPerUser.1(obj2);
        return j0.v(i.u(i.a(keys), anon));
    }
}
