package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class k extends androidx.camera.core.impl.l implements androidx.camera.core.impl.j {

    private static final androidx.camera.core.impl.g.b e;
    static {
        k.e = g.b.OPTIONAL;
    }

    private k(TreeMap<androidx.camera.core.impl.g.a<?>, Map<androidx.camera.core.impl.g.b, Object>> treeMap) {
        super(treeMap);
    }

    public static androidx.camera.core.impl.k k() {
        TreeMap treeMap = new TreeMap(l.d);
        k kVar = new k(treeMap);
        return kVar;
    }

    public <ValueT> void e(androidx.camera.core.impl.g.a<ValueT> g$a, ValueT valuet2) {
        l(a, k.e, valuet2);
    }

    public <ValueT> void l(androidx.camera.core.impl.g.a<ValueT> g$a, androidx.camera.core.impl.g.b g$b2, ValueT valuet3) {
        boolean equals;
        Object obj = this.c.get(a);
        if ((Map)obj == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.c.put(a, arrayMap);
            arrayMap.put(b2, valuet3);
        }
        Object obj3 = Collections.min((Map)obj.keySet());
        if (!obj.get((g.b)obj3).equals(valuet3)) {
            if (g.g(obj3, b2)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Option values conflicts: ");
            stringBuilder.append(a.c());
            stringBuilder.append(", existing value (");
            stringBuilder.append(obj3);
            String obj6 = ")=";
            stringBuilder.append(obj6);
            stringBuilder.append(obj.get(obj3));
            stringBuilder.append(", conflicting (");
            stringBuilder.append(b2);
            stringBuilder.append(obj6);
            stringBuilder.append(valuet3);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        obj.put(b2, valuet3);
    }
}
