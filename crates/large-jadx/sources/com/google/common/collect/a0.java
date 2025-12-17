package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class a0 {
    private static <E> Collection<E> a(Iterable<E> iterable) {
        Object obj1;
        if (iterable instanceof Collection != null) {
        } else {
            obj1 = d0.i((Collection)iterable.iterator());
        }
        return obj1;
    }

    public static <T> T b(Iterable<? extends T> iterable, T t2) {
        return b0.i(iterable.iterator(), t2);
    }

    public static <T> T c(Iterable<T> iterable) {
        if (iterable instanceof List != null) {
            if ((List)iterable.isEmpty()) {
            } else {
                return a0.e(iterable);
            }
            NoSuchElementException obj1 = new NoSuchElementException();
            throw obj1;
        }
        return b0.g(iterable.iterator());
    }

    public static <T> T d(Iterable<? extends T> iterable, T t2) {
        boolean z;
        if (iterable instanceof Collection != null && (Collection)iterable.isEmpty()) {
            if ((Collection)iterable.isEmpty()) {
                return t2;
            }
            if (iterable instanceof List != null) {
                return a0.e(d0.a(iterable));
            }
        }
        return b0.h(iterable.iterator(), t2);
    }

    private static <T> T e(List<T> list) {
        return list.get(size--);
    }

    static Object[] f(Iterable<?> iterable) {
        return a0.a(iterable).toArray();
    }

    public static String g(Iterable<?> iterable) {
        return b0.m(iterable.iterator());
    }
}
