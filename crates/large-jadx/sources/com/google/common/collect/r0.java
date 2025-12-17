package com.google.common.collect;

import com.google.common.base.n;

/* loaded from: classes2.dex */
class r0<E>  extends com.google.common.collect.v<E> {

    static final com.google.common.collect.v<Object> w;
    final transient Object[] c;
    private final transient int v;
    static {
        final int i = 0;
        r0 r0Var = new r0(new Object[i], i);
        r0.w = r0Var;
    }

    r0(Object[] objectArr, int i2) {
        super();
        this.c = objectArr;
        this.v = i2;
    }

    @Override // com.google.common.collect.v
    int d(Object[] objectArr, int i2) {
        System.arraycopy(this.c, 0, objectArr, i2, this.v);
        return i2 += obj4;
    }

    @Override // com.google.common.collect.v
    Object[] g() {
        return this.c;
    }

    public E get(int i) {
        n.m(i, this.v);
        return this.c[i];
    }

    @Override // com.google.common.collect.v
    int h() {
        return this.v;
    }

    @Override // com.google.common.collect.v
    int i() {
        return 0;
    }

    @Override // com.google.common.collect.v
    boolean l() {
        return 0;
    }

    @Override // com.google.common.collect.v
    public int size() {
        return this.v;
    }
}
