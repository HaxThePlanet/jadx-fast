package com.revenuecat.purchases.subscriberattributes;

import android.app.Application;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.attribution.AttributionNetwork;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\u0008@\u0010AJ+\u0010\u0008\u001a\u00020\u00072\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ9\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2 \u0010\r\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0004\u0012\u00020\u00070\u000cH\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ+\u0010\u0011\u001a\u00020\u00072\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\u0008\u0011\u0010\tJ'\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00072\n\u0010\u0018\u001a\u00060\u0003j\u0002`\u0017¢\u0006\u0004\u0008\u0019\u0010\u001aJ%\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u001b2\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\u0008\u001c\u0010\u001dJ7\u0010\"\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0004\u0008\"\u0010#J\u001d\u0010$\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008$\u0010%J/\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008(\u0010)J%\u0010.\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\u0008.\u0010/R\u0019\u00101\u001a\u0002008\u0006@\u0006¢\u0006\u000c\n\u0004\u00081\u00102\u001a\u0004\u00083\u00104R\u0019\u00106\u001a\u0002058\u0006@\u0006¢\u0006\u000c\n\u0004\u00086\u00107\u001a\u0004\u00088\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008>\u0010?¨\u0006B", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "", "", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "attributesAsObjects", "appUserID", "Lkotlin/w;", "storeAttributesIfNeeded", "(Ljava/util/Map;Ljava/lang/String;)V", "Landroid/app/Application;", "applicationContext", "Lkotlin/Function1;", "completion", "getDeviceIdentifiers", "(Landroid/app/Application;Lkotlin/d0/c/l;)V", "attributesToSet", "setAttributes", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "key", "value", "setAttribute", "(Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "currentAppUserID", "synchronizeSubscriberAttributesForAllUsers", "(Ljava/lang/String;)V", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "getUnsyncedSubscriberAttributes", "(Ljava/lang/String;)Ljava/util/Map;", "attributesToMarkAsSynced", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "attributeErrors", "markAsSynced", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "collectDeviceIdentifiers", "(Ljava/lang/String;Landroid/app/Application;)V", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "attributionKey", "setAttributionID", "(Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey$AttributionIds;Ljava/lang/String;Ljava/lang/String;Landroid/app/Application;)V", "Lorg/json/JSONObject;", "jsonObject", "Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "network", "convertAttributionDataAndSetAsSubscriberAttributes", "(Lorg/json/JSONObject;Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;Ljava/lang/String;)V", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "deviceCache", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "getDeviceCache", "()Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "backend", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "getBackend", "()Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "Lcom/revenuecat/purchases/subscriberattributes/AttributionFetcher;", "attributionFetcher", "Lcom/revenuecat/purchases/subscriberattributes/AttributionFetcher;", "Lcom/revenuecat/purchases/subscriberattributes/AttributionDataMigrator;", "attributionDataMigrator", "Lcom/revenuecat/purchases/subscriberattributes/AttributionDataMigrator;", "<init>", "(Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;Lcom/revenuecat/purchases/subscriberattributes/AttributionFetcher;Lcom/revenuecat/purchases/subscriberattributes/AttributionDataMigrator;)V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
public final class SubscriberAttributesManager {

    private final com.revenuecat.purchases.subscriberattributes.AttributionDataMigrator attributionDataMigrator;
    private final com.revenuecat.purchases.subscriberattributes.AttributionFetcher attributionFetcher;
    private final com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster backend;
    private final SubscriberAttributesCache deviceCache;
    public SubscriberAttributesManager(SubscriberAttributesCache subscriberAttributesCache, com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster subscriberAttributesPoster2, com.revenuecat.purchases.subscriberattributes.AttributionFetcher attributionFetcher3, com.revenuecat.purchases.subscriberattributes.AttributionDataMigrator attributionDataMigrator4) {
        n.f(subscriberAttributesCache, "deviceCache");
        n.f(subscriberAttributesPoster2, "backend");
        n.f(attributionFetcher3, "attributionFetcher");
        n.f(attributionDataMigrator4, "attributionDataMigrator");
        super();
        this.deviceCache = subscriberAttributesCache;
        this.backend = subscriberAttributesPoster2;
        this.attributionFetcher = attributionFetcher3;
        this.attributionDataMigrator = attributionDataMigrator4;
    }

    private final void getDeviceIdentifiers(Application application, l<? super Map<String, String>, w> l2) {
        SubscriberAttributesManager.getDeviceIdentifiers.1 anon = new SubscriberAttributesManager.getDeviceIdentifiers.1(l2);
        this.attributionFetcher.getDeviceIdentifiers(application, anon);
    }

    private final void storeAttributesIfNeeded(Map<String, com.revenuecat.purchases.subscriberattributes.SubscriberAttribute> map, String string2) {
        Object value;
        int key2;
        Object key3;
        int value3;
        Object value2;
        boolean key;
        int obj8;
        Map allStoredSubscriberAttributes = this.deviceCache.getAllStoredSubscriberAttributes(string2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        obj8 = map.entrySet().iterator();
        key2 = 1;
        while (obj8.hasNext()) {
            value = obj8.next();
            key3 = (Map.Entry)value.getKey();
            if (allStoredSubscriberAttributes.containsKey((String)key3)) {
            }
            if (key2 != null) {
            }
            key2 = 1;
            linkedHashMap.put(value.getKey(), value.getValue());
            Object obj = allStoredSubscriberAttributes.get(key3);
            if ((SubscriberAttribute)obj != null) {
            } else {
            }
            value3 = 0;
            if (z ^= key2 != 0) {
            } else {
            }
            key2 = 0;
            value3 = (SubscriberAttribute)obj.getValue();
        }
        if (obj8 ^= key2 != 0) {
            this.deviceCache.setAttributes(string2, linkedHashMap);
        }
    }

    public final void collectDeviceIdentifiers(String string, Application application2) {
        n.f(string, "appUserID");
        n.f(application2, "applicationContext");
        SubscriberAttributesManager.collectDeviceIdentifiers.1 anon = new SubscriberAttributesManager.collectDeviceIdentifiers.1(this, string);
        getDeviceIdentifiers(application2, anon);
    }

    public final void convertAttributionDataAndSetAsSubscriberAttributes(JSONObject jSONObject, AttributionNetwork attributionNetwork2, String string3) {
        n.f(jSONObject, "jsonObject");
        n.f(attributionNetwork2, "network");
        n.f(string3, "appUserID");
        setAttributes(this.attributionDataMigrator.convertAttributionDataToSubscriberAttributes(jSONObject, attributionNetwork2), string3);
    }

    public final com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster getBackend() {
        return this.backend;
    }

    public final SubscriberAttributesCache getDeviceCache() {
        return this.deviceCache;
    }

    public final Map<String, com.revenuecat.purchases.subscriberattributes.SubscriberAttribute> getUnsyncedSubscriberAttributes(String string) {
        n.f(string, "appUserID");
        return this.deviceCache.getUnsyncedSubscriberAttributes(string);
        synchronized (this) {
            n.f(string, "appUserID");
            return this.deviceCache.getUnsyncedSubscriberAttributes(string);
        }
    }

    public final void markAsSynced(String string, Map<String, com.revenuecat.purchases.subscriberattributes.SubscriberAttribute> map2, List<SubscriberAttributeError> list3) {
        int rC_ERROR;
        String copy$default;
        String str2;
        String str;
        Collection values;
        Object[] arr;
        String synced;
        int i2;
        int value;
        int i3;
        int i4;
        int i5;
        int i;
        Object obj15;
        n.f(string, "appUserID");
        n.f(map2, "attributesToMarkAsSynced");
        n.f(list3, "attributeErrors");
        int i6 = 1;
        int i7 = 0;
        synchronized (this) {
            try {
                arr = new Object[i6];
                arr[i7] = list3;
                obj15 = String.format("There were some subscriber attributes errors: %s", Arrays.copyOf(arr, i6));
                n.e(obj15, "java.lang.String.format(this, *args)");
                LogWrapperKt.log(LogIntent.RC_ERROR, obj15);
                if (map2.isEmpty()) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                Object[] arr2 = new Object[i6];
                arr2[i7] = string;
                String format = String.format("Marking the following attributes as synced for App User ID: %s", Arrays.copyOf(arr2, i6));
                n.e(format, "java.lang.String.format(this, *args)");
                stringBuilder.append(format);
                stringBuilder.append(p.h0(map2.values(), "\n", 0, 0, 0, 0, 0, 62, 0));
                LogWrapperKt.log(LogIntent.INFO, stringBuilder.toString());
                obj15 = this.deviceCache.getAllStoredSubscriberAttributes(string);
                Map map = j0.y(obj15);
                Iterator obj14 = map2.entrySet().iterator();
                while (obj14.hasNext()) {
                    Object next2 = obj14.next();
                    str2 = (Map.Entry)next2.getKey();
                    values = value2;
                    copy$default = obj15.get((String)str2);
                    if ((SubscriberAttribute)copy$default != null) {
                    }
                    if ((SubscriberAttribute)copy$default.isSynced() == null) {
                    } else {
                    }
                    copy$default = i2;
                    if (copy$default != null && n.b(copy$default.getValue(), (SubscriberAttribute)values.getValue()) != null) {
                    }
                    if (n.b(copy$default.getValue(), values.getValue()) != null) {
                    }
                    if (i2 != 0) {
                    }
                    map.put(str2, SubscriberAttribute.copy$default(values, null, 0, 0, 0, true, 15, 0));
                    i2 = copy$default;
                }
                next2 = obj14.next();
                str2 = (Map.Entry)next2.getKey();
                values = value2;
                copy$default = obj15.get((String)str2);
                if ((SubscriberAttribute)copy$default != null) {
                }
                if ((SubscriberAttribute)copy$default.isSynced() == null) {
                } else {
                }
                copy$default = i2;
                if (copy$default != null && n.b(copy$default.getValue(), (SubscriberAttribute)values.getValue()) != null) {
                }
                if (n.b(copy$default.getValue(), values.getValue()) != null) {
                }
                i2 = copy$default;
                if (i2 != 0) {
                }
                map.put(str2, SubscriberAttribute.copy$default(values, null, 0, 0, 0, true, 15, 0));
                this.deviceCache.setAttributes(string, map);
                throw string;
            }
        }
    }

    public final void setAttribute(com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey subscriberAttributeKey, String string2, String string3) {
        n.f(subscriberAttributeKey, "key");
        n.f(string3, "appUserID");
        setAttributes(j0.e(u.a(subscriberAttributeKey.getBackendKey(), string2)), string3);
        return;
        synchronized (this) {
            n.f(subscriberAttributeKey, "key");
            n.f(string3, "appUserID");
            setAttributes(j0.e(u.a(subscriberAttributeKey.getBackendKey(), string2)), string3);
        }
    }

    public final void setAttributes(Map<String, String> map, String string2) {
        int size;
        Object key;
        com.revenuecat.purchases.subscriberattributes.SubscriberAttribute subscriberAttribute;
        Object obj2;
        Object obj;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        n.f(map, "attributesToSet");
        n.f(string2, "appUserID");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator obj12 = map.entrySet().iterator();
        synchronized (this) {
            try {
                for (Map.Entry next2 : obj12) {
                    key = next2.getKey();
                    super((String)key, (String)next2.getValue(), 0, 0, 0, 28, 0);
                    arrayList.add(u.a(key, subscriberAttribute2));
                }
                Object next2 = obj12.next();
                key = (Map.Entry)next2.getKey();
                super((String)key, (String)next2.getValue(), 0, 0, 0, 28, 0);
                arrayList.add(u.a(key, subscriberAttribute2));
                storeAttributesIfNeeded(j0.s(arrayList), string2);
                throw map;
            }
        }
    }

    public final void setAttributionID(com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey.AttributionIds subscriberAttributeKey$AttributionIds, String string2, String string3, Application application4) {
        n.f(attributionIds, "attributionKey");
        n.f(string3, "appUserID");
        n.f(application4, "applicationContext");
        SubscriberAttributesManager.setAttributionID.1 anon = new SubscriberAttributesManager.setAttributionID.1(this, attributionIds, string2, string3);
        getDeviceIdentifiers(application4, anon);
    }

    public final void synchronizeSubscriberAttributesForAllUsers(String string) {
        boolean empty;
        Object key;
        com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster backend;
        Map backendMap;
        com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers$$inlined.forEach.lambda.1 anon2;
        com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers$$inlined.forEach.lambda.2 anon;
        n.f(string, "currentAppUserID");
        Map unsyncedSubscriberAttributes = this.deviceCache.getUnsyncedSubscriberAttributes();
        if (unsyncedSubscriberAttributes.isEmpty()) {
            LogWrapperKt.log(LogIntent.DEBUG, "No subscriber attributes to synchronize.");
        }
        Iterator iterator = unsyncedSubscriberAttributes.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            key = next2.getKey();
            empty = next2.getValue();
            anon2 = new SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers$$inlined.forEach.lambda.1((String)key, empty, this, string);
            anon = new SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers$$inlined.forEach.lambda.2(key, empty, this, string);
            this.backend.postSubscriberAttributes(BackendHelpersKt.toBackendMap((Map)empty), key, anon2, anon);
        }
    }
}
