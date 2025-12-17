package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\u0008H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lcom/facebook/internal/BundleJSONConverter;", "", "()V", "SETTERS", "", "Ljava/lang/Class;", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "convertToBundle", "Landroid/os/Bundle;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "bundle", "Setter", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    private static final Map<Class<?>, com.facebook.internal.c.h> a;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0001H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0001H&¨\u0006\u000c", d2 = {"Lcom/facebook/internal/BundleJSONConverter$Setter;", "", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "value", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface h {
        public abstract void a(Bundle bundle, String string2, Object object3);
    }

    @Metadata(d1 = "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\r", d2 = {"com/facebook/internal/BundleJSONConverter$1", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "value", "", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements com.facebook.internal.c.h {
        @Override // com.facebook.internal.c$h
        public void a(Bundle bundle, String string2, Object object3) {
            n.f(bundle, "bundle");
            n.f(string2, "key");
            n.f(object3, "value");
            bundle.putBoolean(string2, (Boolean)object3.booleanValue());
        }
    }

    @Metadata(d1 = "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\r", d2 = {"com/facebook/internal/BundleJSONConverter$2", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "value", "", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements com.facebook.internal.c.h {
        @Override // com.facebook.internal.c$h
        public void a(Bundle bundle, String string2, Object object3) {
            n.f(bundle, "bundle");
            n.f(string2, "key");
            n.f(object3, "value");
            bundle.putInt(string2, (Integer)object3.intValue());
        }
    }

    @Metadata(d1 = "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\r", d2 = {"com/facebook/internal/BundleJSONConverter$3", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "value", "", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class c implements com.facebook.internal.c.h {
        @Override // com.facebook.internal.c$h
        public void a(Bundle bundle, String string2, Object object3) {
            n.f(bundle, "bundle");
            n.f(string2, "key");
            n.f(object3, "value");
            bundle.putLong(string2, (Long)object3.longValue());
        }
    }

    @Metadata(d1 = "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\r", d2 = {"com/facebook/internal/BundleJSONConverter$4", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "value", "", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class d implements com.facebook.internal.c.h {
        @Override // com.facebook.internal.c$h
        public void a(Bundle bundle, String string2, Object object3) {
            n.f(bundle, "bundle");
            n.f(string2, "key");
            n.f(object3, "value");
            bundle.putDouble(string2, (Double)object3.doubleValue());
        }
    }

    @Metadata(d1 = "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\r", d2 = {"com/facebook/internal/BundleJSONConverter$5", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "value", "", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class e implements com.facebook.internal.c.h {
        @Override // com.facebook.internal.c$h
        public void a(Bundle bundle, String string2, Object object3) {
            n.f(bundle, "bundle");
            n.f(string2, "key");
            n.f(object3, "value");
            bundle.putString(string2, (String)object3);
        }
    }

    @Metadata(d1 = "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\r", d2 = {"com/facebook/internal/BundleJSONConverter$6", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "value", "", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class f implements com.facebook.internal.c.h {
        @Override // com.facebook.internal.c$h
        public void a(Bundle bundle, String string2, Object object3) {
            n.f(bundle, "bundle");
            n.f(string2, "key");
            n.f(object3, "value");
            IllegalArgumentException obj2 = new IllegalArgumentException("Unexpected type from JSON");
            throw obj2;
        }
    }

    @Metadata(d1 = "\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\r", d2 = {"com/facebook/internal/BundleJSONConverter$7", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", "key", "", "value", "", "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class g implements com.facebook.internal.c.h {
        @Override // com.facebook.internal.c$h
        public void a(Bundle bundle, String string2, Object object3) {
            int i;
            Object obj;
            boolean z;
            n.f(bundle, "bundle");
            n.f(string2, "key");
            n.f(object3, "value");
            ArrayList arrayList = new ArrayList();
            if ((JSONArray)object3.length() == 0) {
                bundle.putStringArrayList(string2, arrayList);
            }
            i = 0;
            while (i < object3.length()) {
                obj = object3.get(i);
                arrayList.add(obj);
                i++;
            }
            bundle.putStringArrayList(string2, arrayList);
        }
    }
    static {
        HashMap hashMap = new HashMap();
        c.a = hashMap;
        c.a aVar = new c.a();
        hashMap.put(Boolean.class, aVar);
        c.b bVar = new c.b();
        hashMap.put(Integer.class, bVar);
        c.c cVar = new c.c();
        hashMap.put(Long.class, cVar);
        c.d dVar = new c.d();
        hashMap.put(Double.class, dVar);
        c.e eVar = new c.e();
        hashMap.put(String.class, eVar);
        c.f fVar = new c.f();
        hashMap.put(String[].class, fVar);
        c.g gVar = new c.g();
        hashMap.put(JSONArray.class, gVar);
    }

    public static final Bundle a(JSONObject jSONObject) {
        Object next;
        Object obj;
        Object nULL;
        String str;
        n.f(jSONObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        for (String next : keys) {
            obj = jSONObject.get(next);
            nULL = c.a.get(obj.getClass());
            n.e(next, "key");
            n.e(obj, "value");
            (c.h)nULL.a(bundle, next, obj);
            bundle.putBundle(next, c.a((JSONObject)obj));
        }
        return bundle;
    }
}
