package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import f.c.c.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public final class d0 {
    static <T> List<T> a(Iterable<T> iterable) {
        return (List)iterable;
    }

    static int b(int i) {
        i.b(i, "arraySize");
        return b.j(i2 += l2);
    }

    static boolean c(List<?> list, Object object2) {
        boolean z;
        int i;
        boolean z2;
        Object obj;
        n.o(list);
        final int i2 = 1;
        if (object2 == list) {
            return i2;
        }
        final int i3 = 0;
        if (object2 instanceof List == null) {
            return i3;
        }
        int size = list.size();
        if (size != (List)object2.size()) {
            return i3;
        }
        if (list instanceof RandomAccess && object2 instanceof RandomAccess) {
            if (object2 instanceof RandomAccess) {
                i = i3;
                while (i < size) {
                    i++;
                }
                return i2;
            }
        }
        return b0.c(list.iterator(), object2.iterator());
    }

    static int d(List<?> list, Object object2) {
        boolean z;
        if (list instanceof RandomAccess) {
            return d0.e(list, object2);
        }
        ListIterator obj1 = list.listIterator();
        for (Object next2 : obj1) {
        }
        return -1;
    }

    private static int e(List<?> list, Object object2) {
        int i;
        boolean equals;
        Object obj4;
        final int size = list.size();
        i = 0;
        if (object2 == null) {
        }
        return -1;
    }

    static int f(List<?> list, Object object2) {
        int size;
        if (list instanceof RandomAccess) {
            return d0.g(list, object2);
        }
        ListIterator obj1 = list.listIterator(list.size());
        while (obj1.hasPrevious()) {
        }
        return -1;
    }

    private static int g(List<?> list, Object object2) {
        int i;
        boolean equals;
        int obj3;
        if (object2 == null) {
            obj3--;
            while (obj3 >= 0) {
                obj3--;
            }
        } else {
            size--;
            while (i >= 0) {
                i--;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> h() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public static <E> ArrayList<E> i(Iterator<? extends E> iterator) {
        final ArrayList list = d0.h();
        b0.a(list, iterator);
        return list;
    }

    @SafeVarargs
    public static <E> ArrayList<E> j(E... eArr) {
        n.o(eArr);
        ArrayList arrayList = new ArrayList(d0.b(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <E> ArrayList<E> k(int i) {
        i.b(i, "initialArraySize");
        ArrayList arrayList = new ArrayList(i);
        return arrayList;
    }
}
