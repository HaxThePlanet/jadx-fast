package androidx.lifecycle;

import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public final class c0 {

    private static final Class[] e;
    final Map<String, Object> a;
    final Map<String, SavedStateRegistry.b> b;
    private final Map<String, Object<?>> c;
    private final SavedStateRegistry.b d;

    class a implements SavedStateRegistry.b {

        final androidx.lifecycle.c0 a;
        a(androidx.lifecycle.c0 c0) {
            this.a = c0;
            super();
        }

        @Override // androidx.savedstate.SavedStateRegistry$b
        public Bundle a() {
            Map key;
            Bundle bundle;
            androidx.lifecycle.c0 c0Var;
            int size;
            Map map;
            HashMap hashMap = new HashMap(c0Var3.b);
            Iterator iterator = hashMap.entrySet().iterator();
            for (Map.Entry next2 : iterator) {
                this.a.c((String)next2.getKey(), (SavedStateRegistry.b)next2.getValue().a());
            }
            Set keySet = c0Var2.a.keySet();
            ArrayList arrayList = new ArrayList(keySet.size());
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator iterator2 = keySet.iterator();
            for (String next4 : iterator2) {
                arrayList.add(next4);
                arrayList2.add(c0Var4.a.get(next4));
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList("keys", arrayList);
            bundle2.putParcelableArrayList("values", arrayList2);
            return bundle2;
        }
    }
    static {
        Class tYPE;
        Class<android.util.Size> obj;
        Class[] arr = new Class[29];
        tYPE = Integer.TYPE;
        int i27 = 21;
        arr[i27] = Parcelable.class;
        arr[22] = Parcelable[].class;
        arr[23] = Serializable.class;
        arr[24] = Short.TYPE;
        arr[25] = short[].class;
        arr[26] = SparseArray.class;
        int sDK_INT = Build.VERSION.SDK_INT;
        obj = sDK_INT >= i27 ? Size.class : tYPE;
        arr[27] = obj;
        if (sDK_INT >= i27) {
            tYPE = SizeF.class;
        }
        arr[28] = tYPE;
        c0.e = arr;
    }

    public c0() {
        super();
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        HashMap hashMap2 = new HashMap();
        this.c = hashMap2;
        c0.a aVar = new c0.a(this);
        this.d = aVar;
        HashMap hashMap3 = new HashMap();
        this.a = hashMap3;
    }

    public c0(Map<String, Object> map) {
        super();
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        HashMap hashMap2 = new HashMap();
        this.c = hashMap2;
        c0.a aVar = new c0.a(this);
        this.d = aVar;
        HashMap hashMap3 = new HashMap(map);
        this.a = hashMap3;
    }

    static androidx.lifecycle.c0 a(Bundle bundle, Bundle bundle2) {
        Iterator iterator;
        int i;
        String size;
        Object next;
        Object obj;
        if (bundle == null && bundle2 == null) {
            if (bundle2 == null) {
                c0 obj4 = new c0();
                return obj4;
            }
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            iterator = bundle2.keySet().iterator();
            for (String next : iterator) {
                hashMap.put(next, bundle2.get(next));
            }
        }
        if (bundle == null) {
            obj4 = new c0(hashMap);
            return obj4;
        }
        ArrayList obj5 = bundle.getParcelableArrayList("keys");
        obj4 = bundle.getParcelableArrayList("values");
        if (obj5 == null) {
        } else {
            if (obj4 == null) {
            } else {
                if (obj5.size() != obj4.size()) {
                } else {
                    i = 0;
                    while (i < obj5.size()) {
                        hashMap.put((String)obj5.get(i), obj4.get(i));
                        i++;
                    }
                    obj4 = new c0(hashMap);
                    return obj4;
                }
            }
        }
        obj4 = new IllegalStateException("Invalid bundle passed as restored state");
        throw obj4;
    }

    private static void d(Object object) {
        int i;
        boolean instance;
        if (object == null) {
        }
        Class[] objArr = c0.e;
        i = 0;
        while (i < objArr.length) {
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't put value with type ");
        stringBuilder.append(object.getClass());
        stringBuilder.append(" into saved state");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    SavedStateRegistry.b b() {
        return this.d;
    }

    public <T> void c(String string, T t2) {
        Object obj;
        c0.d(t2);
        obj = this.c.get(string);
        if ((x)obj != null) {
            (x)obj.setValue(t2);
        } else {
            this.a.put(string, t2);
        }
    }
}
