package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class l implements androidx.camera.core.impl.g {

    protected static final Comparator<androidx.camera.core.impl.g.a<?>> d;
    protected final TreeMap<androidx.camera.core.impl.g.a<?>, Map<androidx.camera.core.impl.g.b, Object>> c;
    static {
        final androidx.camera.core.impl.a aVar = a.a;
        l.d = aVar;
        TreeMap treeMap = new TreeMap(aVar);
    }

    l(TreeMap<androidx.camera.core.impl.g.a<?>, Map<androidx.camera.core.impl.g.b, Object>> treeMap) {
        super();
        this.c = treeMap;
    }

    public static androidx.camera.core.impl.l h(androidx.camera.core.impl.g g) {
        Object next;
        Iterator iterator;
        ArrayMap arrayMap;
        boolean next2;
        Object obj;
        if (l.class.equals(g.getClass())) {
            return (l)g;
        }
        TreeMap treeMap = new TreeMap(l.d);
        Iterator iterator2 = g.b().iterator();
        for (g.a next : iterator2) {
            arrayMap = new ArrayMap();
            iterator = g.c(next).iterator();
            for (g.b next2 : iterator) {
                arrayMap.put(next2, g.a(next, next2));
            }
            treeMap.put(next, arrayMap);
            next2 = iterator.next();
            arrayMap.put(next2, g.a(next, (g.b)next2));
        }
        l obj7 = new l(treeMap);
        return obj7;
    }

    static int i(androidx.camera.core.impl.g.a g$a, androidx.camera.core.impl.g.a g$a2) {
        return a.c().compareTo(a2.c());
    }

    public <ValueT> ValueT a(androidx.camera.core.impl.g.a<ValueT> g$a, androidx.camera.core.impl.g.b g$b2) {
        Object obj = this.c.get(a);
        final String str = "Option does not exist: ";
        if ((Map)obj == null) {
        } else {
            if (!(Map)obj.containsKey(b2)) {
            } else {
                return obj.get(b2);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(a);
            stringBuilder2.append(" with priority=");
            stringBuilder2.append(b2);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(a);
        IllegalArgumentException obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    public Set<androidx.camera.core.impl.g.a<?>> b() {
        return Collections.unmodifiableSet(this.c.keySet());
    }

    public Set<androidx.camera.core.impl.g.b> c(androidx.camera.core.impl.g.a<?> g$a) {
        Object obj2 = this.c.get(a);
        if ((Map)obj2 == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet((Map)obj2.keySet());
    }

    public <ValueT> ValueT f(androidx.camera.core.impl.g.a<ValueT> g$a, ValueT valuet2) {
        try {
            return j(a);
            return valuet2;
        }
    }

    public <ValueT> ValueT j(androidx.camera.core.impl.g.a<ValueT> g$a) {
        Object obj = this.c.get(a);
        if ((Map)obj == null) {
        } else {
            return obj.get((g.b)Collections.min((Map)obj.keySet()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Option does not exist: ");
        stringBuilder.append(a);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}
