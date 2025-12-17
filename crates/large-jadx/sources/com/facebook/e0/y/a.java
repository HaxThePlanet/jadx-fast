package com.facebook.e0.y;

import android.util.Log;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0010%\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0008\u0010\u0015\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J&\u0010\u0018\u001a\u00020\u00112\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lcom/facebook/appevents/restrictivedatafilter/RestrictiveDataManager;", "", "()V", "PROCESS_EVENT_NAME", "", "REPLACEMENT_STRING", "RESTRICTIVE_PARAM", "RESTRICTIVE_PARAM_KEY", "TAG", "enabled", "", "restrictedEvents", "", "restrictiveParamFilters", "", "Lcom/facebook/appevents/restrictivedatafilter/RestrictiveDataManager$RestrictiveParamFilter;", "enable", "", "getMatchedRuleType", "eventName", "paramKey", "initialize", "isRestrictedEvent", "processEvent", "processParameters", "parameters", "", "RestrictiveParamFilter", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static boolean a = false;
    private static final String b = "com.facebook.e0.y.a";
    private static final List<com.facebook.e0.y.a.a> c;
    private static final Set<String> d;
    public static final com.facebook.e0.y.a e;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u000f", d2 = {"Lcom/facebook/appevents/restrictivedatafilter/RestrictiveDataManager$RestrictiveParamFilter;", "", "eventName", "", "restrictiveParams", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "getRestrictiveParams", "()Ljava/util/Map;", "setRestrictiveParams", "(Ljava/util/Map;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        private String a;
        private Map<String, String> b;
        public a(String string, Map<String, String> map2) {
            n.f(string, "eventName");
            n.f(map2, "restrictiveParams");
            super();
            this.a = string;
            this.b = map2;
        }

        public final String a() {
            return this.a;
        }

        public final Map<String, String> b() {
            return this.b;
        }

        public final void c(Map<String, String> map) {
            n.f(map, "<set-?>");
            this.b = map;
        }
    }
    static {
        a aVar = new a();
        a.e = aVar;
        ArrayList arrayList = new ArrayList();
        a.c = arrayList;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        a.d = copyOnWriteArraySet;
    }

    public static final void a() {
        if (a.d(a.class)) {
        }
        a.a = true;
        a.e.c();
    }

    private final String b(String string, String string2) {
        Iterator iterator2;
        List next;
        boolean iterator;
        boolean next2;
        boolean z;
        Object obj7;
        Object obj8;
        final int i = 0;
        if (a.d(this)) {
            return i;
        }
        ArrayList arrayList = new ArrayList(a.c);
        iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            if ((a.a)next == null) {
            } else {
            }
            if (n.b(string, (a.a)next.a())) {
            } else {
            }
            iterator = next.b().keySet().iterator();
            for (String next2 : iterator) {
            }
            next2 = iterator.next();
        }
        return i;
    }

    private final void c() {
        Iterator keys;
        Object pVar;
        int i;
        int length;
        Object jSONObject;
        JSONObject optJSONObject;
        com.facebook.e0.y.a.a aVar;
        HashMap hashMap;
        if (a.d(this)) {
        }
        pVar = q.o(o.g(), false);
        pVar = pVar.g();
        if (pVar != null && pVar != null && pVar.length() == 0) {
            pVar = pVar.g();
            if (pVar != null) {
                if (pVar.length() == 0) {
                    i = 1;
                }
                if (i != 0) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(pVar);
                        a.c.clear();
                        a.d.clear();
                        keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            length = keys.next();
                            jSONObject = jSONObject2.getJSONObject((String)length);
                            optJSONObject = jSONObject.optJSONObject("restrictive_param");
                            n.e(length, "key");
                            hashMap = new HashMap();
                            aVar = new a.a(length, hashMap);
                            if (jSONObject != null && optJSONObject != null) {
                            }
                            optJSONObject = jSONObject.optJSONObject("restrictive_param");
                            n.e(length, "key");
                            hashMap = new HashMap();
                            aVar = new a.a(length, hashMap);
                            if (optJSONObject != null) {
                            }
                            if (jSONObject.has("process_event_name") != 0) {
                            }
                            a.d.add(aVar.a());
                            aVar.c(b0.n(optJSONObject));
                            a.c.add(aVar);
                        }
                        length = keys.next();
                        jSONObject = jSONObject2.getJSONObject((String)length);
                        optJSONObject = jSONObject.optJSONObject("restrictive_param");
                        n.e(length, "key");
                        hashMap = new HashMap();
                        aVar = new a.a(length, hashMap);
                        if (jSONObject != null && optJSONObject != null) {
                        }
                        optJSONObject = jSONObject.optJSONObject("restrictive_param");
                        n.e(length, "key");
                        hashMap = new HashMap();
                        aVar = new a.a(length, hashMap);
                        if (optJSONObject != null) {
                        }
                        aVar.c(b0.n(optJSONObject));
                        a.c.add(aVar);
                        if (jSONObject.has("process_event_name") != 0) {
                        }
                        a.d.add(aVar.a());
                        a.b(th, this);
                    }
                }
            }
        }
    }

    private final boolean d(String string) {
        if (a.d(this)) {
            return 0;
        }
        return a.d.contains(string);
    }

    public static final String e(String string) {
        boolean z;
        Object obj3;
        if (a.d(a.class)) {
            return null;
        }
        n.f(string, "eventName");
        if (a.a && a.e.d(string)) {
            if (a.e.d(string)) {
                obj3 = "_removed_";
            }
        }
        return obj3;
    }

    public static final void f(Map<String, String> map, String string2) {
        Object hashMap;
        Iterator iterator;
        Set keySet;
        boolean next;
        String str;
        int obj6;
        if (a.d(a.class)) {
        }
        n.f(map, "parameters");
        n.f(string2, "eventName");
        if (!a.a) {
        }
        hashMap = new HashMap();
        ArrayList arrayList = new ArrayList(map.keySet());
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            keySet = iterator.next();
            str = a.e.b(string2, (String)keySet);
            if (str != null) {
            }
            hashMap.put(keySet, str);
            map.remove(keySet);
        }
        if (obj6 ^= 1 != 0) {
            try {
                obj6 = new JSONObject();
                Iterator iterator2 = hashMap.entrySet().iterator();
                for (Map.Entry next2 : iterator2) {
                    obj6.put((String)next2.getKey(), (String)next2.getValue());
                }
                Object next2 = iterator2.next();
                obj6.put((String)(Map.Entry)next2.getKey(), (String)next2.getValue());
                map.put("_restrictedParams", obj6.toString());
                a.b(map, obj0);
            } catch (org.json.JSONException jSON) {
            } catch (Throwable th1) {
            }
        }
    }
}
