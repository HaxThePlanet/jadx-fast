package com.facebook.e0.t;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.e0.v.d;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.j0;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\rH\u0001¢\u0006\u0002\u0008\u0017J\r\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0008\u001aJC\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u00142\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0001¢\u0006\u0002\u0008\u001dJ\u0008\u0010\u001e\u001a\u00020\u001fH\u0007J2\u0010 \u001a\u00020\u00192\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\r2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0007J\u001c\u0010!\u001a\u00020\u00192\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0014H\u0002J\u0008\u0010\"\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseLoggerManager;", "", "()V", "CACHE_CLEAR_TIME_LIMIT_SEC", "", "LAST_CLEARED_TIME", "", "LAST_QUERY_PURCHASE_HISTORY_TIME", "PRODUCT_DETAILS_STORE", "PURCHASE_DETAILS_SET", "PURCHASE_IN_CACHE_INTERVAL", "PURCHASE_TIME", "cachedPurchaseMap", "", "", "cachedPurchaseSet", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "cacheDeDupPurchase", "", "Lorg/json/JSONObject;", "purchaseDetailsMap", "cacheDeDupPurchase$facebook_core_release", "clearOutdatedProductInfoInCache", "", "clearOutdatedProductInfoInCache$facebook_core_release", "constructLoggingReadyMap", "skuDetailsMap", "constructLoggingReadyMap$facebook_core_release", "eligibleQueryPurchaseHistory", "", "filterPurchaseLogging", "logPurchases", "readPurchaseCache", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class e {

    private static SharedPreferences a;
    private static final Set<String> b;
    private static final Map<String, Long> c;
    public static final com.facebook.e0.t.e d;
    static {
        e eVar = new e();
        e.d = eVar;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        e.b = copyOnWriteArraySet;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        e.c = concurrentHashMap;
    }

    public static final boolean d() {
        int cmp;
        int i;
        long long;
        String str = "LAST_QUERY_PURCHASE_HISTORY_TIME";
        final int i4 = 0;
        if (a.d(e.class)) {
            return i4;
        }
        e.d.g();
        currentTimeMillis /= i6;
        SharedPreferences sharedPreferences = e.a;
        int i7 = 0;
        final String str2 = "sharedPreferences";
        if (sharedPreferences == null) {
        } else {
            i = 0;
            long = sharedPreferences.getLong(str, i);
            if (Long.compare(long, i) != 0 && Long.compare(i, long) < 0) {
                if (Long.compare(i, long) < 0) {
                    return i4;
                }
            }
            SharedPreferences sharedPreferences2 = e.a;
            if (sharedPreferences2 == null) {
            } else {
                sharedPreferences2.edit().putLong(str, i5).apply();
                return 1;
            }
            n.w(str2);
            throw i7;
        }
        n.w(str2);
        throw i7;
    }

    public static final void e(Map<String, JSONObject> map, Map<String, ? extends JSONObject> map2) {
        if (a.d(e.class)) {
        }
        n.f(map, "purchaseDetailsMap");
        n.f(map2, "skuDetailsMap");
        com.facebook.e0.t.e eVar = e.d;
        eVar.g();
        eVar.f(eVar.c(eVar.a(map), map2));
    }

    private final void f(Map<String, String> map) {
        boolean value;
        Object key;
        int i;
        if (a.d(this)) {
        }
        Iterator obj4 = map.entrySet().iterator();
        while (obj4.hasNext()) {
            Object next2 = obj4.next();
            key = (Map.Entry)next2.getKey();
            value = next2.getValue();
            if ((String)key != null && (String)value) {
            }
            if ((String)value) {
            }
            d.f((String)key, (String)value, false);
        }
        try {
            a.b(map, this);
        }
    }

    private final void g() {
        Object sharedPreferences;
        Object stringSet;
        Set valueOf;
        String str;
        HashSet hashSet;
        long long;
        int i;
        int i2;
        int i3;
        if (a.d(this)) {
        }
        final int i5 = 0;
        sharedPreferences = o.f().getSharedPreferences("com.facebook.internal.SKU_DETAILS", i5);
        if (sharedPreferences.contains("LAST_CLEARED_TIME")) {
            sharedPreferences.edit().clear().apply();
            o.f().getSharedPreferences("com.facebook.internal.PURCHASE", i5).edit().clear().apply();
        }
        SharedPreferences sharedPreferences2 = o.f().getSharedPreferences("com.facebook.internal.iap.PRODUCT_DETAILS", i5);
        n.e(sharedPreferences2, "getApplicationContext().…RE, Context.MODE_PRIVATE)");
        e.a = sharedPreferences2;
        valueOf = e.b;
        if (sharedPreferences2 == null) {
        } else {
            hashSet = new HashSet();
            if (sharedPreferences2.getStringSet("PURCHASE_DETAILS_SET", hashSet) != null) {
            } else {
                try {
                    stringSet = new HashSet();
                    valueOf.addAll(stringSet);
                    Iterator iterator = valueOf.iterator();
                    for (Object next2 : iterator) {
                        i = 2;
                        List list = l.E0((String)next2, /* result */, false, i, 2, 0);
                        e.c.put(list.get(i5), Long.valueOf(Long.parseLong((String)list.get(1))));
                    }
                    i = 2;
                    list = l.E0((String)iterator.next(), /* result */, false, i, 2, 0);
                    e.c.put(list.get(i5), Long.valueOf(Long.parseLong((String)list.get(1))));
                    b();
                    n.w("sharedPreferences");
                    throw 0;
                    a.b(th, this);
                }
            }
        }
    }

    public final Map<String, JSONObject> a(Map<String, JSONObject> map) {
        int string;
        Object key;
        boolean stringBuilder;
        String str = "purchaseToken";
        final int i = 0;
        if (a.d(this)) {
            return i;
        }
        n.f(map, "purchaseDetailsMap");
        Iterator iterator = j0.u(map).entrySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            string = next2.getValue();
            if ((JSONObject)string.has(str)) {
            }
            string = string.getString(str);
            if (e.c.containsKey(string)) {
            } else {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(';');
            stringBuilder.append(currentTimeMillis /= string);
            e.b.add(stringBuilder.toString());
            map.remove((String)(Map.Entry)next2.getKey());
        }
        SharedPreferences sharedPreferences = e.a;
        if (sharedPreferences == null) {
        } else {
            sharedPreferences.edit().putStringSet("PURCHASE_DETAILS_SET", e.b).apply();
            HashMap hashMap = new HashMap(map);
            return hashMap;
        }
        try {
            n.w("sharedPreferences");
            throw i;
            a.b(map, this);
            return obj2;
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
    }

    public final void b() {
        Object long;
        SharedPreferences.Editor stringSet;
        int str;
        Object str2;
        int next;
        Object key;
        long longValue;
        int stringBuilder;
        int i;
        long l;
        long = "LAST_CLEARED_TIME";
        if (a.d(this)) {
        }
        currentTimeMillis /= i3;
        SharedPreferences sharedPreferences = e.a;
        str = 0;
        str2 = "sharedPreferences";
        if (sharedPreferences == null) {
        } else {
            next = 0;
            longValue = sharedPreferences.getLong(long, next);
            if (Long.compare(longValue, next) == 0) {
                SharedPreferences sharedPreferences2 = e.a;
                if (sharedPreferences2 == null) {
                } else {
                    sharedPreferences2.edit().putLong(long, i2).apply();
                }
                n.w(str2);
                throw str;
            }
            if (Long.compare(next, longValue) > 0) {
                Iterator iterator = j0.u(e.c).entrySet().iterator();
                try {
                    while (iterator.hasNext()) {
                        Object next2 = iterator.next();
                        key = (Map.Entry)next2.getKey();
                        longValue = (Number)next2.getValue().longValue();
                        if (Long.compare(stringBuilder, l) > 0) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append((String)key);
                        stringBuilder.append(';');
                        stringBuilder.append(longValue);
                        e.b.remove(stringBuilder.toString());
                        e.c.remove(key);
                    }
                    next2 = iterator.next();
                    key = (Map.Entry)next2.getKey();
                    longValue = (Number)next2.getValue().longValue();
                    if (Long.compare(stringBuilder, l) > 0) {
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append((String)key);
                    stringBuilder.append(';');
                    stringBuilder.append(longValue);
                    e.b.remove(stringBuilder.toString());
                    e.c.remove(key);
                    SharedPreferences sharedPreferences3 = e.a;
                    if (sharedPreferences3 == null) {
                    } else {
                    }
                    sharedPreferences3.edit().putStringSet("PURCHASE_DETAILS_SET", e.b).putLong(long, i2).apply();
                    n.w(str2);
                    throw str;
                    n.w(str2);
                    throw str;
                    a.b(th, this);
                }
            }
        }
    }

    public final Map<String, String> c(Map<String, ? extends JSONObject> map, Map<String, ? extends JSONObject> map2) {
        Object string;
        Object string2;
        boolean cmp;
        long l;
        final String str = "purchaseTime";
        if (a.d(this)) {
            return 0;
        }
        n.f(map, "purchaseDetailsMap");
        n.f(map2, "skuDetailsMap");
        final int i3 = 1000;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator obj14 = map.entrySet().iterator();
        while (obj14.hasNext()) {
            Object next2 = obj14.next();
            string = next2.getValue();
            string2 = map2.get((String)(Map.Entry)next2.getKey());
            if (string != null && (JSONObject)string.has(str)) {
            }
            if (string.has(str)) {
            }
            if (Long.compare(i5, l) > 0) {
            } else {
            }
            if ((JSONObject)string2 != null) {
            }
            string = string.toString();
            n.e(string, "purchaseDetail.toString()");
            string2 = (JSONObject)string2.toString();
            n.e(string2, "skuDetail.toString()");
            linkedHashMap.put(string, string2);
        }
        try {
            return linkedHashMap;
            a.b(map, this);
            return obj2;
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
    }
}
