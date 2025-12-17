package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.f0.a;
import com.facebook.internal.f0.b;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.c;
import com.facebook.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.i0.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u00013B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u001fH\u0007J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0#2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0017\u0010$\u001a\u00020\u001f2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020'J\u0012\u0010&\u001a\u00020'2\u0008\u0010(\u001a\u0004\u0018\u00010\u0012H\u0007J\u001f\u0010)\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0008\u0010*\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\u0008+J\u0008\u0010,\u001a\u00020'H\u0002J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001fH\u0007J\u0008\u0010/\u001a\u00020'H\u0007J\u001a\u00100\u001a\u00020'2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00042\u0006\u00101\u001a\u000202H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u00064", d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager;", "", "()V", "APPLICATION_FIELDS", "", "APPLICATION_GATEKEEPER_CACHE_TIMEOUT", "", "APPLICATION_GATEKEEPER_EDGE", "APPLICATION_GATEKEEPER_FIELD", "APPLICATION_GRAPH_DATA", "APPLICATION_PLATFORM", "APPLICATION_SDK_VERSION", "APP_GATEKEEPERS_PREFS_KEY_FORMAT", "APP_GATEKEEPERS_PREFS_STORE", "APP_PLATFORM", "TAG", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "fetchedAppGateKeepers", "", "Lorg/json/JSONObject;", "gateKeeperRuntimeCache", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "timestamp", "Ljava/lang/Long;", "getAppGateKeepersQueryResponse", "applicationId", "getGateKeeperForKey", "", "name", "defaultValue", "getGateKeepersForApplication", "", "isTimestampValid", "(Ljava/lang/Long;)Z", "loadAppGateKeepersAsync", "", "callback", "parseAppGateKeepersFromJSON", "gateKeepersJSON", "parseAppGateKeepersFromJSON$facebook_core_release", "pollCallbacks", "queryAppGateKeepers", "forceRequery", "resetRuntimeGateKeeperCache", "setRuntimeGateKeeper", "gateKeeper", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class o {

    private static final AtomicBoolean a;
    private static final ConcurrentLinkedQueue<com.facebook.internal.o.a> b;
    private static final Map<String, JSONObject> c;
    private static Long d;
    private static b e;
    public static final com.facebook.internal.o f;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004", d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "", "onCompleted", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract void a();
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        final String a;
        final Context b;
        final String c;
        b(String string, Context context2, String string3) {
            this.a = string;
            this.b = context2;
            this.c = string3;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object valueOf;
            int length;
            String str;
            if (a.d(this)) {
            }
            com.facebook.internal.o oVar = o.f;
            valueOf = o.a(oVar, this.a);
            final int i = 0;
            if (valueOf.length() != 0) {
                o.k(this.a, valueOf);
                length = this.b.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", i).edit();
                length.putString(this.c, valueOf.toString()).apply();
                o.d(oVar, Long.valueOf(System.currentTimeMillis()));
            }
            o.c(oVar);
            o.b(oVar).set(i);
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class c implements Runnable {

        final com.facebook.internal.o.a a;
        c(com.facebook.internal.o.a o$a) {
            this.a = a;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            this.a.a();
        }
    }
    static {
        o oVar = new o();
        o.f = oVar;
        c0.b(o.class).o();
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        o.a = atomicBoolean;
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        o.b = concurrentLinkedQueue;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        o.c = concurrentHashMap;
    }

    public static final JSONObject a(com.facebook.internal.o o, String string2) {
        return o.e(string2);
    }

    public static final AtomicBoolean b(com.facebook.internal.o o) {
        return o.a;
    }

    public static final void c(com.facebook.internal.o o) {
        o.l();
    }

    public static final void d(com.facebook.internal.o o, Long long2) {
        o.d = long2;
    }

    private final JSONObject e(String string) {
        Object format;
        String str;
        int i;
        Object[] arr;
        p obj10;
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        bundle.putString("sdk_version", o.u());
        bundle.putString("fields", "gatekeepers");
        String str9 = "java.lang.String.format(format, *args)";
        String str10 = "mobile_sdk_gk";
        final int i2 = 0;
        final int i3 = 1;
        final int i4 = 0;
        if (b0.W(o.l())) {
            f0 f0Var2 = f0.a;
            i = 2;
            arr = new Object[i];
            arr[i2] = string;
            arr[i3] = str10;
            obj10 = String.format("%s/%s", Arrays.copyOf(arr, i));
            n.e(obj10, str9);
            obj10 = p.t.v(i4, obj10, i4);
            obj10.G(i3);
            obj10.F(bundle);
        } else {
            f0 f0Var = f0.a;
            Object[] arr2 = new Object[i3];
            arr2[i2] = str10;
            format = String.format("app/%s", Arrays.copyOf(arr2, i3));
            n.e(format, str9);
            p.t.v(i4, format, i4).F(bundle);
        }
        if (obj10.i().d() != null) {
        } else {
            obj10 = new JSONObject();
        }
        return obj10;
    }

    public static final boolean f(String string, String string2, boolean z3) {
        Object obj1;
        boolean obj3;
        n.f(string, "name");
        final Map obj2 = o.f.g(string2);
        if (!obj2.containsKey(string)) {
        } else {
            obj1 = obj2.get(string);
            if ((Boolean)obj1 != null) {
                obj3 = (Boolean)obj1.booleanValue();
            }
        }
        return obj3;
    }

    private final boolean h(Long long) {
        int i;
        int i3;
        int i2;
        int obj6;
        i = 0;
        if (long == 0) {
        } else {
            if (Long.compare(i3, i2) < 0) {
                i = 1;
            }
        }
        return i;
    }

    public static final void j(com.facebook.internal.o.a o$a) {
        ConcurrentLinkedQueue queue;
        boolean key;
        String string;
        int i;
        boolean jSONObject;
        final Class<com.facebook.internal.o> obj = o.class;
        synchronized (obj) {
            o.b.add(a);
            final String obj8 = o.g();
            com.facebook.internal.o oVar = o.f;
            if (oVar.h(o.d) && o.c.containsKey(obj8)) {
                if (o.c.containsKey(obj8)) {
                    oVar.l();
                }
            }
            try {
                Context context = o.f();
                f0 f0Var = f0.a;
                int i2 = 1;
                Object[] arr = new Object[i2];
                final int i3 = 0;
                arr[i3] = obj8;
                String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(arr, i2));
                n.e(format, "java.lang.String.format(format, *args)");
                if (context == null) {
                }
                string = context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", i3).getString(format, 0);
                if (!b0.W(string)) {
                }
                jSONObject = new JSONObject(string);
                i = jSONObject;
                b0.c0("FacebookSDK", th);
                if (i != null) {
                }
                o.k(obj8, i);
                Executor executor = o.n();
                if (executor != null && !o.a.compareAndSet(i3, i2)) {
                }
                if (!o.a.compareAndSet(i3, i2)) {
                }
                o.b bVar = new o.b(obj8, context, format);
                executor.execute(bVar);
                throw a;
            } catch (org.json.JSONException jSON) {
            } catch (Throwable th1) {
            }
        }
    }

    public static final JSONObject k(String string, JSONObject jSONObject2) {
        Object jSONObject;
        int i;
        String str;
        Throwable boolean;
        String string2;
        String str2;
        Object obj8;
        final Class<com.facebook.internal.o> obj = o.class;
        n.f(string, "applicationId");
        synchronized (obj) {
            try {
                obj8 = jSONObject2.optJSONArray("data");
                if (jSONObject2 != null && obj8 != null && obj8.optJSONObject(0) != null) {
                } else {
                }
                obj8 = jSONObject2.optJSONArray("data");
                if (obj8 != null) {
                } else {
                }
                if (obj8.optJSONObject(i) != null) {
                } else {
                }
                obj8 = new JSONObject();
                if (obj8.optJSONArray("gatekeepers") != null) {
                } else {
                }
                obj8 = new JSONArray();
                while (i < obj8.length()) {
                    JSONObject jSONObject3 = obj8.getJSONObject(i);
                    jSONObject.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                    i++;
                    b0.c0("FacebookSDK", boolean);
                }
                jSONObject3 = obj8.getJSONObject(i);
                jSONObject.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                b0.c0("FacebookSDK", boolean);
                i++;
                o.c.put(string, jSONObject);
                return jSONObject;
                throw string;
            } catch (org.json.JSONException jSON) {
            } catch (Throwable th1) {
            }
        }
    }

    private final void l() {
        Looper mainLooper;
        boolean cVar;
        Handler handler = new Handler(Looper.getMainLooper());
        ConcurrentLinkedQueue queue = o.b;
        while (!queue.isEmpty()) {
            mainLooper = queue.poll();
            if ((o.a)mainLooper != null) {
            }
            queue = o.b;
            cVar = new o.c((o.a)mainLooper);
            handler.post(cVar);
        }
    }

    public static final JSONObject m(String string, boolean z2) {
        String str;
        Object obj4;
        Map obj5;
        n.f(string, "applicationId");
        obj5 = o.c;
        if (z2 == null && obj5.containsKey(string)) {
            obj5 = o.c;
            if (obj5.containsKey(string)) {
                if ((JSONObject)obj5.get(string) != null) {
                } else {
                    obj4 = new JSONObject();
                }
                return obj4;
            }
        }
        obj5 = o.f.e(string);
        f0 f0Var = f0.a;
        int i = 1;
        Object[] arr = new Object[i];
        final int i2 = 0;
        arr[i2] = string;
        String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        o.f().getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", i2).edit().putString(format, obj5.toString()).apply();
        return o.k(string, obj5);
    }

    public final Map<String, Boolean> g(String string) {
        Object bVar;
        Object jSONObject;
        Map map;
        java.util.List valueOf;
        boolean hashMap;
        boolean key2;
        Object arrayList;
        Iterator iterator;
        boolean booleanValue;
        a aVar;
        Object key;
        HashMap obj8;
        i();
        if (string != null) {
            map = o.c;
            if (!map.containsKey(string)) {
            } else {
                b bVar2 = o.e;
                if (bVar2 != null) {
                    valueOf = bVar2.a(string);
                } else {
                    valueOf = 0;
                }
                if (valueOf != null) {
                    obj8 = new HashMap();
                    bVar = valueOf.iterator();
                    for (a next : bVar) {
                        obj8.put(next.a(), Boolean.valueOf(next.b()));
                    }
                } else {
                    hashMap = new HashMap();
                    if ((JSONObject)map.get(string) != null) {
                    } else {
                        jSONObject = new JSONObject();
                    }
                    Iterator keys = jSONObject.keys();
                    for (String iterator : keys) {
                        n.e(iterator, "key");
                        hashMap.put(iterator, Boolean.valueOf(jSONObject.optBoolean(iterator)));
                    }
                    if (o.e != null) {
                    } else {
                        bVar = new b();
                    }
                    arrayList = new ArrayList(hashMap.size());
                    iterator = hashMap.entrySet().iterator();
                    for (Map.Entry next3 : iterator) {
                        aVar = new a((String)next3.getKey(), (Boolean)next3.getValue().booleanValue());
                        arrayList.add(aVar);
                    }
                    bVar.b(string, arrayList);
                    o.e = bVar;
                    obj8 = hashMap;
                }
            }
            return obj8;
        }
        obj8 = new HashMap();
        return obj8;
    }

    public final void i() {
        o.j(0);
    }
}
