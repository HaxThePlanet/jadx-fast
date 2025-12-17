package com.revenuecat.purchases.subscriberattributes.caching;

import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003\u001a?\u0010\u000b\u001a\u00020\u0001*\u00020\u00002*\u0010\n\u001a&\u0012\u0008\u0012\u00060\u0005j\u0002`\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\u00080\u0004j\u0002`\tH\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a\u001b\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005H\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a7\u0010\u0010\u001a&\u0012\u0008\u0012\u00060\u0005j\u0002`\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\u00080\u0004j\u0002`\t*\u00020\u0000H\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011¨\u0006\u0012", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "Lkotlin/w;", "migrateSubscriberAttributesIfNeeded", "(Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;)V", "", "", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesPerAppUserIDMap;", "legacySubscriberAttributesForAppUserID", "migrateSubscriberAttributes", "(Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Ljava/util/Map;)V", "appUserID", "legacySubscriberAttributesCacheKey", "(Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Ljava/lang/String;)Ljava/lang/String;", "getAllLegacyStoredSubscriberAttributes", "(Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;)Ljava/util/Map;", "subscriber-attributes_release"}, k = 2, mv = {1, 4, 0})
public final class SubscriberAttributesMigrationExtensionsKt {
    public static final Map<String, Map<String, SubscriberAttribute>> getAllLegacyStoredSubscriberAttributes(com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache subscriberAttributesCache) {
        int i2;
        Map legacySubscriberAttributes;
        Object obj;
        DeviceCache deviceCache$subscriber_attributes_release;
        int i;
        int i3;
        int i4;
        int i6;
        int i5;
        final Class<com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesMigrationExtensionsKt> obj2 = SubscriberAttributesMigrationExtensionsKt.class;
        n.f(subscriberAttributesCache, "$this$getAllLegacyStoredSubscriberAttributes");
        String legacySubscriberAttributesCacheKey = SubscriberAttributesMigrationExtensionsKt.legacySubscriberAttributesCacheKey(subscriberAttributesCache, "");
        Set keysThatStartWith = subscriberAttributesCache.getDeviceCache$subscriber_attributes_release().findKeysThatStartWith(legacySubscriberAttributesCacheKey);
        ArrayList arrayList = new ArrayList(p.r(keysThatStartWith, 10));
        Iterator iterator = keysThatStartWith.iterator();
        synchronized (obj2) {
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                i5 = 1;
                String[] strArr = new String[i5];
                strArr[0] = legacySubscriberAttributesCacheKey;
                legacySubscriberAttributes = subscriberAttributesCache.getDeviceCache$subscriber_attributes_release().getJSONObjectOrNull(next2);
                if (legacySubscriberAttributes != null && SubscriberAttributesFactoriesKt.buildLegacySubscriberAttributes(legacySubscriberAttributes) != null) {
                } else {
                }
                legacySubscriberAttributes = j0.h();
                arrayList.add(u.a((String)l.E0((String)next2, strArr, false, 0, 6, 0).get(i5), legacySubscriberAttributes));
                if (SubscriberAttributesFactoriesKt.buildLegacySubscriberAttributes(legacySubscriberAttributes) != null) {
                } else {
                }
            }
            return j0.s(arrayList);
        }
    }

    public static final String legacySubscriberAttributesCacheKey(com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache subscriberAttributesCache, String string2) {
        n.f(subscriberAttributesCache, "$this$legacySubscriberAttributesCacheKey");
        n.f(string2, "appUserID");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(subscriberAttributesCache.getSubscriberAttributesCacheKey$subscriber_attributes_release());
        stringBuilder.append('.');
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static final void migrateSubscriberAttributes(com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache subscriberAttributesCache, Map<String, ? extends Map<String, SubscriberAttribute>> map2) {
        DeviceCache deviceCache$subscriber_attributes_release;
        String legacySubscriberAttributesCacheKey;
        Object obj;
        final Class<com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesMigrationExtensionsKt> obj2 = SubscriberAttributesMigrationExtensionsKt.class;
        n.f(subscriberAttributesCache, "$this$migrateSubscriberAttributes");
        n.f(map2, "legacySubscriberAttributesForAppUserID");
        Map allStoredSubscriberAttributes = subscriberAttributesCache.getAllStoredSubscriberAttributes();
        final Map map = j0.y(allStoredSubscriberAttributes);
        Iterator obj7 = map2.entrySet().iterator();
        synchronized (obj2) {
            while (obj7.hasNext()) {
                Object next2 = obj7.next();
                Object key = (Map.Entry)next2.getKey();
                if ((Map)allStoredSubscriberAttributes.get((String)key) != null) {
                } else {
                }
                obj = j0.h();
                map.put(key, j0.o((Map)next2.getValue(), obj));
                subscriberAttributesCache.getDeviceCache$subscriber_attributes_release().remove(SubscriberAttributesMigrationExtensionsKt.legacySubscriberAttributesCacheKey(subscriberAttributesCache, key));
            }
            subscriberAttributesCache.putAttributes$subscriber_attributes_release(subscriberAttributesCache.getDeviceCache$subscriber_attributes_release(), map);
        }
    }

    public static final void migrateSubscriberAttributesIfNeeded(com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache subscriberAttributesCache) {
        Map allLegacyStoredSubscriberAttributes;
        final Class<com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesMigrationExtensionsKt> obj = SubscriberAttributesMigrationExtensionsKt.class;
        n.f(subscriberAttributesCache, "$this$migrateSubscriberAttributesIfNeeded");
        synchronized (obj) {
            try {
                if (allLegacyStoredSubscriberAttributes != null) {
                }
                SubscriberAttributesMigrationExtensionsKt.migrateSubscriberAttributes(subscriberAttributesCache, allLegacyStoredSubscriberAttributes);
                throw subscriberAttributesCache;
            }
        }
    }
}
