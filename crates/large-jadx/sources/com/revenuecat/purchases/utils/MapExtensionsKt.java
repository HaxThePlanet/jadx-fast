package com.revenuecat.purchases.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\u0003\u001a7\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\u0008\u0000\u0010\u0000\"\u0004\u0008\u0001\u0010\u0001*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004¨\u0006\u0005", d2 = {"K", "V", "", "filterNotNullValues", "(Ljava/util/Map;)Ljava/util/Map;", "utils_release"}, k = 2, mv = {1, 4, 0})
public final class MapExtensionsKt {
    public static final <K, V> Map<K, V> filterNotNullValues(Map<K, ? extends V> map) {
        Object value;
        int key;
        n.f(map, "$this$filterNotNullValues");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator obj3 = map.entrySet().iterator();
        while (obj3.hasNext()) {
            value = obj3.next();
            if ((Map.Entry)value.getValue() != null) {
            } else {
            }
            key = 0;
            if (key != null) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
            key = 1;
        }
        return linkedHashMap;
    }
}
