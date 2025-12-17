package com.google.common.collect;

import java.util.ListIterator;

/* loaded from: classes2.dex */
public abstract class c1<E>  extends com.google.common.collect.b1<E> implements ListIterator<E> {
    @Deprecated
    public final void add(E e) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Deprecated
    public final void set(E e) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }
}
