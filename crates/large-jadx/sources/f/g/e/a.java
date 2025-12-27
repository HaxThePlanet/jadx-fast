package f.g.e;

import f.g.a.a;
import f.g.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CollectionUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static <Type> List<Type> a(Collection<Type> collection, Type type, b<Type, Type, Boolean> bVar) {
        int i = 0;
        i = 0;
        if (collection == null) {
            return new ArrayList(i);
        }
        final ArrayList arrayList = new ArrayList(collection);
        while (i < arrayList.size()) {
            i = i + 1;
        }
        if (i == 0) {
            arrayList.add(type);
        }
        return arrayList;
    }

    @SafeVarargs
    public static <Type> List<Type> b(List<Type>... listArr) {
        if (listArr != null) {
            length = listArr.length;
            if (listArr.length != 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = new CopyOnWriteArrayList(listArr).iterator();
                while (it2.hasNext()) {
                    CopyOnWriteArrayList copyOnWriteArrayList = it2.next();
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static <Type> List<Type> c(List<Type> list) {
        if (list == null) {
            return new ArrayList();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
        ArrayList arrayList2 = new ArrayList(copyOnWriteArrayList.size());
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next());
        }
        return arrayList2;
    }

    public static <Key, Value> Map<Key, Value> d(Map<Key, Value> map) {
        if (map == null) {
            return new HashMap();
        }
        final HashMap hashMap = new HashMap();
        hashMap.putAll(Collections.synchronizedMap(map));
        return hashMap;
    }

    public static <Type> List<Type> e(List<Type> list) {
        ArrayList arrayList;
        if (a.g(list)) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public static <Type> List<Type> f(Collection<Type> collection, a<Type, Boolean> aVar) {
        if (collection == null) {
            return new ArrayList(0);
        }
        final ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return arrayList;
    }

    public static <Type> boolean g(Collection<Type> collection) {
        boolean z = false;
        if (collection == null || collection.isEmpty()) {
            int i2 = 1;
        }
        return z;
    }

    public static <Type> boolean h(Type[] typeArr) {
        boolean z = false;
        if (typeArr != null) {
            length = typeArr.length;
            if (typeArr.length == 0) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    public static <Type> boolean i(Collection<Type> collection) {
        return !a.g(collection);
    }

    public static <Type> boolean j(Type[] typeArr) {
        return !a.h(typeArr);
    }

    public static <Type, Return> List<Return> k(Collection<Type> collection, a<Type, Return> aVar) {
        if (collection == null) {
            return new ArrayList(0);
        }
        final ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.apply(it.next()));
        }
        return arrayList;
    }

    public static <Type> List<Type> l(List<Type> list) {
        return Collections.unmodifiableList(a.e(list));
    }

}
