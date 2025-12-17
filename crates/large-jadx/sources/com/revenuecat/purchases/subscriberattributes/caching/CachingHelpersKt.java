package com.revenuecat.purchases.subscriberattributes.caching;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a3\u0010\u0006\u001a\u00020\u0005*\"\u0012\u0008\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u00040\u0000H\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"", "", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "Lorg/json/JSONObject;", "toJSONObject", "(Ljava/util/Map;)Lorg/json/JSONObject;", "subscriber-attributes_release"}, k = 2, mv = {1, 4, 0})
public final class CachingHelpersKt {
    public static final JSONObject toJSONObject(Map<String, ? extends Map<String, SubscriberAttribute>> map) {
        Iterator iterator;
        Object key;
        JSONObject jSONObject2;
        boolean jSONObject;
        Object key2;
        n.f(map, "$this$toJSONObject");
        JSONObject jSONObject3 = new JSONObject();
        Iterator obj6 = map.entrySet().iterator();
        for (Map.Entry next2 : obj6) {
            jSONObject2 = new JSONObject();
            iterator = (Map)next2.getValue().entrySet().iterator();
            for (Map.Entry next3 : iterator) {
                jSONObject2.put((String)next3.getKey(), (SubscriberAttribute)next3.getValue().toJSONObject());
            }
            jSONObject3.put((String)next2.getKey(), jSONObject2);
            Object next3 = iterator.next();
            jSONObject2.put((String)(Map.Entry)next3.getKey(), (SubscriberAttribute)next3.getValue().toJSONObject());
        }
        obj6 = new JSONObject();
        obj6.put("attributes", jSONObject3);
        return obj6;
    }
}
