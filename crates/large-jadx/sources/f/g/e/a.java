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

/* loaded from: classes2.dex */
public class a {
    static {
    }

    public static <Type> List<Type> a(Collection<Type> collection, Type type2, b<Type, Type, Boolean> b3) {
        int i;
        boolean booleanValue;
        int obj3;
        i = 0;
        if (collection == null) {
            obj3 = new ArrayList(i);
            return obj3;
        }
        ArrayList arrayList = new ArrayList(collection);
        obj3 = i;
        while (i < arrayList.size()) {
            if ((Boolean)b3.apply(arrayList.get(i), type2).booleanValue()) {
            }
            i++;
            arrayList.set(i, type2);
            obj3 = 1;
        }
        if (obj3 == null) {
            arrayList.add(type2);
        }
        return arrayList;
    }

    @SafeVarargs
    public static <Type> List<Type> b(List<Type>... listArr) {
        int length;
        CopyOnWriteArrayList copyOnWriteArrayList;
        boolean next;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        if (listArr != null) {
            if (listArr.length == 0) {
            } else {
                ArrayList arrayList = new ArrayList();
                copyOnWriteArrayList = new CopyOnWriteArrayList(listArr);
                Iterator obj3 = copyOnWriteArrayList.iterator();
                while (obj3.hasNext()) {
                    copyOnWriteArrayList = obj3.next();
                    if (a.i((List)copyOnWriteArrayList)) {
                    }
                    copyOnWriteArrayList2 = new CopyOnWriteArrayList(copyOnWriteArrayList);
                    copyOnWriteArrayList = copyOnWriteArrayList2.iterator();
                    for (Object copyOnWriteArrayList2 : copyOnWriteArrayList) {
                        arrayList.add(copyOnWriteArrayList2);
                    }
                    arrayList.add(copyOnWriteArrayList.next());
                }
            }
            return arrayList;
        }
        obj3 = new ArrayList();
        return obj3;
    }

    public static <Type> List<Type> c(List<Type> list) {
        int size;
        if (list == null) {
            ArrayList obj2 = new ArrayList();
            return obj2;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
        obj2 = new ArrayList(copyOnWriteArrayList.size());
        Iterator iterator = copyOnWriteArrayList.iterator();
        for (Object size : iterator) {
            obj2.add(size);
        }
        return obj2;
    }

    public static <Key, Value> Map<Key, Value> d(Map<Key, Value> map) {
        if (map == null) {
            HashMap obj1 = new HashMap();
            return obj1;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(Collections.synchronizedMap(map));
        return hashMap;
    }

    public static <Type> List<Type> e(List<Type> list) {
        Object obj1;
        if (a.g(list)) {
            obj1 = new ArrayList();
        }
        return obj1;
    }

    public static <Type> List<Type> f(Collection<Type> collection, a<Type, Boolean> a2) {
        int size;
        boolean booleanValue;
        if (collection == null) {
            ArrayList obj3 = new ArrayList(0);
            return obj3;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        obj3 = collection.iterator();
        while (obj3.hasNext()) {
            size = obj3.next();
            if ((Boolean)a2.apply(size).booleanValue()) {
            }
            arrayList.add(size);
        }
        return arrayList;
    }

    public static <Type> boolean g(Collection<Type> collection) {
        int obj0;
        if (collection != null) {
            if (collection.isEmpty()) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    public static <Type> boolean h(Type[] typeArr) {
        int obj0;
        if (typeArr != 0) {
            if (typeArr.length == 0) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    public static <Type> boolean i(Collection<Type> collection) {
        return obj0 ^= 1;
    }

    public static <Type> boolean j(Type[] typeArr) {
        return obj0 ^= 1;
    }

    public static <Type, Return> List<Return> k(Collection<Type> collection, a<Type, Return> a2) {
        int apply;
        if (collection == null) {
            ArrayList obj2 = new ArrayList(0);
            return obj2;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        obj2 = collection.iterator();
        for (Object next2 : obj2) {
            arrayList.add(a2.apply(next2));
        }
        return arrayList;
    }

    public static <Type> List<Type> l(List<Type> list) {
        return Collections.unmodifiableList(a.e(list));
    }
}
