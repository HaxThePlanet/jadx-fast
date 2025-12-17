package com.google.common.collect;

import com.google.common.base.g;
import java.util.Comparator;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public abstract class p0<T>  implements Comparator<T> {
    public static <T> com.google.common.collect.p0<T> a(Comparator<T> comparator) {
        boolean mVar;
        Object obj1;
        if (comparator instanceof p0) {
        } else {
            mVar = new m((p0)comparator);
            obj1 = mVar;
        }
        return obj1;
    }

    public static <C extends Comparable> com.google.common.collect.p0<C> c() {
        return n0.a;
    }

    public <E extends T> com.google.common.collect.v<E> b(Iterable<E> iterable) {
        return v.D(this, iterable);
    }

    public abstract int compare(T t, T t2);

    <T2 extends T> com.google.common.collect.p0<Map.Entry<T2, ?>> d() {
        return e(h0.d());
    }

    public <F> com.google.common.collect.p0<F> e(g<F, ? extends T> g) {
        h hVar = new h(g, this);
        return hVar;
    }

    public <S extends T> com.google.common.collect.p0<S> f() {
        v0 v0Var = new v0(this);
        return v0Var;
    }
}
