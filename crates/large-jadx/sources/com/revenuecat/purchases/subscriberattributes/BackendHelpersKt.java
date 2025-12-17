package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.common.SubscriberAttributeError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.u;
import kotlin.y.h0;
import kotlin.y.j0;
import kotlin.y.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000$\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a7\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00000\u0000*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a\u0019\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007*\u0004\u0018\u00010\u0006¢\u0006\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "", "toBackendMap", "(Ljava/util/Map;)Ljava/util/Map;", "Lorg/json/JSONObject;", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "getAttributeErrors", "(Lorg/json/JSONObject;)Ljava/util/List;", "subscriber-attributes_release"}, k = 2, mv = {1, 4, 0})
public final class BackendHelpersKt {
    public static final List<SubscriberAttributeError> getAttributeErrors(JSONObject jSONObject) {
        Object arrayList2;
        boolean next2;
        int string2;
        boolean subscriberAttributeError;
        ArrayList arrayList;
        int string;
        String str3;
        int jSONObject2;
        boolean next;
        String str2;
        ArrayList str;
        JSONObject obj7;
        if (jSONObject == null) {
            return p.g();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("attributes_error_response");
        if (optJSONObject != null) {
            obj7 = optJSONObject;
        }
        obj7 = obj7.optJSONArray("attribute_errors");
        if (obj7 != null) {
            int i = 0;
            kotlin.h0.f fVar = g.l(i, obj7.length());
            string = 10;
            arrayList = new ArrayList(p.r(fVar, string));
            Iterator iterator = fVar.iterator();
            while (iterator.hasNext()) {
                arrayList.add(obj7.getJSONObject((h0)iterator.d()));
            }
            obj7 = new ArrayList();
            Iterator iterator2 = arrayList.iterator();
            str3 = "message";
            str2 = "key_name";
            while (iterator2.hasNext()) {
                arrayList = iterator2.next();
                str = arrayList;
                if ((JSONObject)str.has(str2) && str.has(str3)) {
                } else {
                }
                next = i;
                if (next) {
                }
                str3 = "message";
                str2 = "key_name";
                obj7.add(arrayList);
                if (str.has(str3)) {
                } else {
                }
                next = 1;
            }
            arrayList2 = new ArrayList(p.r(obj7, string));
            obj7 = obj7.iterator();
            for (JSONObject next3 : obj7) {
                string = next3.getString(str2);
                n.e(string, "it.getString(\"key_name\")");
                string2 = next3.getString(str3);
                n.e(string2, "it.getString(\"message\")");
                subscriberAttributeError = new SubscriberAttributeError(string, string2);
                arrayList2.add(subscriberAttributeError);
            }
            if (p.L0(arrayList2) != null) {
            } else {
                obj7 = p.g();
            }
        } else {
        }
        return obj7;
    }

    public static final Map<String, Map<String, Object>> toBackendMap(Map<String, com.revenuecat.purchases.subscriberattributes.SubscriberAttribute> map) {
        int size;
        Object key;
        n.f(map, "$this$toBackendMap");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator obj3 = map.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            arrayList.add(u.a((String)next2.getKey(), (SubscriberAttribute)next2.getValue().toBackendMap()));
        }
        return j0.s(arrayList);
    }
}
