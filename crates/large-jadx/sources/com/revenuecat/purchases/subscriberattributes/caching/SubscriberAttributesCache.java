package com.revenuecat.purchases.subscriberattributes.caching;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0018¢\u0006\u0004\u0008&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J?\u0010\u000c\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u0007j\u0002`\t*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u0007j\u0002`\t2\n\u0010\u000b\u001a\u00060\u0002j\u0002`\nH\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ1\u0010\u000f\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\u0002j\u0002`\n2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u0007j\u0002`\t¢\u0006\u0004\u0008\u000f\u0010\u0010J1\u0010\u0012\u001a&\u0012\u0008\u0012\u00060\u0002j\u0002`\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u0007j\u0002`\t0\u0007j\u0002`\u0011¢\u0006\u0004\u0008\u0012\u0010\u0013J)\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u0007j\u0002`\t2\n\u0010\u000b\u001a\u00060\u0002j\u0002`\n¢\u0006\u0004\u0008\u0012\u0010\u0014J1\u0010\u0015\u001a&\u0012\u0008\u0012\u00060\u0002j\u0002`\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u0007j\u0002`\t0\u0007j\u0002`\u0011¢\u0006\u0004\u0008\u0015\u0010\u0013J%\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u0007j\u0002`\t2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\u0008\u0015\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\u0008\u0016\u0010\u0006J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0017\u0010\u0006J?\u0010\u001c\u001a\u00020\u0004*\u00020\u00182*\u0010\u0019\u001a&\u0012\u0008\u0012\u00060\u0002j\u0002`\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u0007j\u0002`\t0\u0007j\u0002`\u0011H\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u00028@@\u0000X\u0080\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u001e\u001a\u0004\u0008\u001f\u0010 R\u001c\u0010\"\u001a\u00020\u00188\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\"\u0010#\u001a\u0004\u0008$\u0010%¨\u0006(", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "", "", "currentAppUserID", "Lkotlin/w;", "deleteSyncedSubscriberAttributesForOtherUsers", "(Ljava/lang/String;)V", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "appUserID", "filterUnsynced", "(Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;", "attributesToBeSet", "setAttributes", "(Ljava/lang/String;Ljava/util/Map;)V", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesPerAppUserIDMap;", "getAllStoredSubscriberAttributes", "()Ljava/util/Map;", "(Ljava/lang/String;)Ljava/util/Map;", "getUnsyncedSubscriberAttributes", "clearSubscriberAttributesIfSyncedForSubscriber", "cleanUpSubscriberAttributeCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "updatedSubscriberAttributesForAll", "putAttributes$subscriber_attributes_release", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Ljava/util/Map;)V", "putAttributes", "subscriberAttributesCacheKey$delegate", "Lkotlin/h;", "getSubscriberAttributesCacheKey$subscriber_attributes_release", "()Ljava/lang/String;", "subscriberAttributesCacheKey", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "getDeviceCache$subscriber_attributes_release", "()Lcom/revenuecat/purchases/common/caching/DeviceCache;", "<init>", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;)V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
public final class SubscriberAttributesCache {

    private final DeviceCache deviceCache;
    private final h subscriberAttributesCacheKey$delegate;
    public SubscriberAttributesCache(DeviceCache deviceCache) {
        n.f(deviceCache, "deviceCache");
        super();
        this.deviceCache = deviceCache;
        SubscriberAttributesCache.subscriberAttributesCacheKey.2 obj2 = new SubscriberAttributesCache.subscriberAttributesCacheKey.2(this);
        this.subscriberAttributesCacheKey$delegate = j.b(obj2);
    }

    private final void deleteSyncedSubscriberAttributesForOtherUsers(String string) {
        ArrayList arrayList;
        int size;
        boolean next;
        int key2;
        LinkedHashMap linkedHashMap;
        boolean value;
        int key;
        final int i = 1;
        Object[] arr = new Object[i];
        arr[0] = string;
        String format = String.format("Deleting old synced subscriber attributes that don't belong to %s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(this, *args)");
        LogWrapperKt.log(LogIntent.DEBUG, format);
        Map allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
        arrayList = new ArrayList(allStoredSubscriberAttributes.size());
        Iterator iterator = allStoredSubscriberAttributes.entrySet().iterator();
        synchronized (this) {
            try {
                while (iterator.hasNext()) {
                    Object next3 = iterator.next();
                    key2 = (Map.Entry)next3.getKey();
                    Object value3 = next3.getValue();
                    if (z ^= i != 0) {
                    } else {
                    }
                    size = u.a(key2, (Map)value3);
                    arrayList.add(size);
                    linkedHashMap = new LinkedHashMap();
                    Iterator iterator2 = value3.entrySet().iterator();
                    while (iterator2.hasNext()) {
                        value = iterator2.next();
                        if (synced ^= i != 0) {
                        }
                        linkedHashMap.put(value.getKey(), value.getValue());
                    }
                    size = u.a(key2, linkedHashMap);
                    value = iterator2.next();
                    if (synced ^= i != 0) {
                    }
                    linkedHashMap.put(value.getKey(), value.getValue());
                }
                next3 = iterator.next();
                key2 = (Map.Entry)next3.getKey();
                value3 = next3.getValue();
                if (z ^= i != 0) {
                } else {
                }
                linkedHashMap = new LinkedHashMap();
                iterator2 = (Map)value3.entrySet().iterator();
                while (iterator2.hasNext()) {
                    value = iterator2.next();
                    if (synced ^= i != 0) {
                    }
                    linkedHashMap.put(value.getKey(), value.getValue());
                }
                value = iterator2.next();
                if (synced ^= i != 0) {
                }
                linkedHashMap.put(value.getKey(), value.getValue());
                size = u.a(key2, linkedHashMap);
                size = u.a(key2, value3);
                arrayList.add(size);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Iterator obj9 = j0.s(arrayList).entrySet().iterator();
                while (obj9.hasNext()) {
                    arrayList = obj9.next();
                    if (empty ^= i) {
                    }
                    linkedHashMap2.put(arrayList.getKey(), arrayList.getValue());
                }
                arrayList = obj9.next();
                if (empty ^= i) {
                }
                linkedHashMap2.put(arrayList.getKey(), arrayList.getValue());
                putAttributes$subscriber_attributes_release(this.deviceCache, linkedHashMap2);
                throw string;
            }
        }
    }

    private final Map<String, SubscriberAttribute> filterUnsynced(Map<String, SubscriberAttribute> map, String string2) {
        Object value;
        int key;
        int values;
        boolean synced;
        String str;
        Object[] arr;
        int i3;
        Integer valueOf;
        int i5;
        int i4;
        int i;
        int i2;
        String obj13;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator obj12 = map.entrySet().iterator();
        values = 1;
        while (obj12.hasNext()) {
            value = obj12.next();
            if (values ^= synced != 0) {
            }
            values = 1;
            linkedHashMap.put(value.getKey(), value.getValue());
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i6 = 2;
        arr = new Object[i6];
        arr[0] = Integer.valueOf(linkedHashMap.size());
        arr[values] = string2;
        obj13 = String.format("Found %d unsynced attributes for App User ID: %s", Arrays.copyOf(arr, i6));
        n.e(obj13, "java.lang.String.format(this, *args)");
        stringBuilder.append(obj13);
        if (obj13 ^= values != 0) {
            obj13 = p.h0(linkedHashMap.values(), "\n", 0, 0, 0, 0, 0, 62, 0);
        } else {
            obj13 = "";
        }
        stringBuilder.append(obj13);
        LogWrapperKt.log(LogIntent.DEBUG, stringBuilder.toString());
        return linkedHashMap;
    }

    public final void cleanUpSubscriberAttributeCache(String string) {
        n.f(string, "currentAppUserID");
        SubscriberAttributesMigrationExtensionsKt.migrateSubscriberAttributesIfNeeded(this);
        deleteSyncedSubscriberAttributesForOtherUsers(string);
        return;
        synchronized (this) {
            n.f(string, "currentAppUserID");
            SubscriberAttributesMigrationExtensionsKt.migrateSubscriberAttributesIfNeeded(this);
            deleteSyncedSubscriberAttributesForOtherUsers(string);
        }
    }

    public final void clearSubscriberAttributesIfSyncedForSubscriber(String string) {
        n.f(string, "appUserID");
        int i2 = 1;
        synchronized (this) {
            try {
                final Object[] arr = new Object[i2];
                arr[0] = string;
                String format = String.format("Deleting subscriber attributes for %s from cache", Arrays.copyOf(arr, i2));
                n.e(format, "java.lang.String.format(this, *args)");
                LogWrapperKt.log(LogIntent.DEBUG, format);
                Map map = j0.y(getAllStoredSubscriberAttributes());
                map.remove(string);
                putAttributes$subscriber_attributes_release(this.deviceCache, j0.u(map));
                throw string;
            }
        }
    }

    public final Map<String, Map<String, SubscriberAttribute>> getAllStoredSubscriberAttributes() {
        Object subscriberAttributesMapPerUser;
        subscriberAttributesMapPerUser = this.deviceCache.getJSONObjectOrNull(getSubscriberAttributesCacheKey$subscriber_attributes_release());
        synchronized (this) {
            try {
                if (SubscriberAttributesFactoriesKt.buildSubscriberAttributesMapPerUser(subscriberAttributesMapPerUser) != null) {
                } else {
                }
                subscriberAttributesMapPerUser = j0.h();
                return subscriberAttributesMapPerUser;
                throw th;
            }
        }
    }

    public final Map<String, SubscriberAttribute> getAllStoredSubscriberAttributes(String string) {
        Object obj2;
        n.f(string, "appUserID");
        synchronized (this) {
            try {
                obj2 = j0.h();
                return obj2;
                throw string;
            }
        }
    }

    public final DeviceCache getDeviceCache$subscriber_attributes_release() {
        return this.deviceCache;
    }

    public final String getSubscriberAttributesCacheKey$subscriber_attributes_release() {
        return (String)this.subscriberAttributesCacheKey$delegate.getValue();
    }

    public final Map<String, Map<String, SubscriberAttribute>> getUnsyncedSubscriberAttributes() {
        int filterUnsynced;
        boolean value;
        Object key;
        Object key2;
        Map allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(j0.d(allStoredSubscriberAttributes.size()));
        Iterator iterator = allStoredSubscriberAttributes.entrySet().iterator();
        synchronized (this) {
            try {
                for (Object next2 : iterator) {
                    linkedHashMap2.put((Map.Entry)next2.getKey(), filterUnsynced((Map)next2.getValue(), (String)(Map.Entry)next2.getKey()));
                }
                Object next2 = iterator.next();
                linkedHashMap2.put((Map.Entry)next2.getKey(), filterUnsynced((Map)next2.getValue(), (String)(Map.Entry)next2.getKey()));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator iterator2 = linkedHashMap2.entrySet().iterator();
                while (iterator2.hasNext()) {
                    value = iterator2.next();
                    if (empty ^= 1 != 0) {
                    }
                    linkedHashMap.put(value.getKey(), value.getValue());
                }
                value = iterator2.next();
                if (empty ^= 1 != 0) {
                }
                linkedHashMap.put(value.getKey(), value.getValue());
                return linkedHashMap;
                throw th;
            }
        }
    }

    public final Map<String, SubscriberAttribute> getUnsyncedSubscriberAttributes(String string) {
        n.f(string, "appUserID");
        return filterUnsynced(getAllStoredSubscriberAttributes(string), string);
        synchronized (this) {
            n.f(string, "appUserID");
            return filterUnsynced(getAllStoredSubscriberAttributes(string), string);
        }
    }

    public final void putAttributes$subscriber_attributes_release(DeviceCache deviceCache, Map<String, ? extends Map<String, SubscriberAttribute>> map2) {
        n.f(deviceCache, "$this$putAttributes");
        n.f(map2, "updatedSubscriberAttributesForAll");
        String obj4 = CachingHelpersKt.toJSONObject(map2).toString();
        n.e(obj4, "updatedSubscriberAttribu…toJSONObject().toString()");
        this.deviceCache.putString(getSubscriberAttributesCacheKey$subscriber_attributes_release(), obj4);
    }

    public final void setAttributes(String string, Map<String, SubscriberAttribute> map2) {
        Object obj;
        n.f(string, "appUserID");
        n.f(map2, "attributesToBeSet");
        Map allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
        synchronized (this) {
            try {
                obj = j0.h();
                putAttributes$subscriber_attributes_release(this.deviceCache, j0.o(allStoredSubscriberAttributes, j0.e(u.a(string, j0.o(obj, map2)))));
                throw string;
            }
        }
    }
}
