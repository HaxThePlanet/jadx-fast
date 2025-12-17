package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a {
    public static final <T> void a(Collection<T> collection, T t2) {
        n.f(collection, "<this>");
        if (t2 != null) {
            collection.add(t2);
        }
    }

    private static final int b(int i) {
        int i2;
        int obj1;
        if (i < 3) {
        } else {
            i2 = obj1 + 1;
        }
        return i2;
    }

    public static final <T> List<T> c(ArrayList<T> arrayList) {
        int i;
        Object obj2;
        n.f(arrayList, "<this>");
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                arrayList.trimToSize();
            } else {
                obj2 = p.b(p.X(arrayList));
            }
        } else {
            obj2 = p.g();
        }
        return obj2;
    }

    public static final <K> Map<K, Integer> d(Iterable<? extends K> iterable) {
        int i;
        int i2;
        Object next;
        n.f(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Iterator obj4 = iterable.iterator();
        i = 0;
        for (Object next : obj4) {
            linkedHashMap.put(next, Integer.valueOf(i));
            i = i2;
        }
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> e(int i) {
        HashMap hashMap = new HashMap(a.b(i));
        return hashMap;
    }

    public static final <E> HashSet<E> f(int i) {
        HashSet hashSet = new HashSet(a.b(i));
        return hashSet;
    }

    public static final <E> LinkedHashSet<E> g(int i) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(a.b(i));
        return linkedHashSet;
    }
}
