package com.google.common.collect;

import java.util.Iterator;

/* loaded from: classes2.dex */
final class t0<E>  extends com.google.common.collect.z<E> {

    static final com.google.common.collect.t0<Object> z;
    final transient Object[] c;
    final transient Object[] v;
    private final transient int w;
    private final transient int x;
    private final transient int y;
    static {
        super(new Object[0], 0, 0, 0, 0);
        t0.z = t0Var2;
    }

    t0(Object[] objectArr, int i2, Object[] object3Arr3, int i4, int i5) {
        super();
        this.c = objectArr;
        this.v = object3Arr3;
        this.w = i4;
        this.x = i2;
        this.y = i5;
    }

    @Override // com.google.common.collect.z
    public boolean contains(Object object) {
        int i;
        boolean equals;
        final Object[] objArr = this.v;
        final int i2 = 0;
        if (object != null) {
            if (objArr == null) {
            } else {
                i = s.c(object);
                i &= i4;
                Object obj = objArr[i3];
                while (obj == null) {
                    i3++;
                    i &= i4;
                    obj = objArr[i3];
                }
            }
            return i2;
        }
        return i2;
    }

    @Override // com.google.common.collect.z
    int d(Object[] objectArr, int i2) {
        System.arraycopy(this.c, 0, objectArr, i2, this.y);
        return i2 += obj4;
    }

    @Override // com.google.common.collect.z
    Object[] g() {
        return this.c;
    }

    @Override // com.google.common.collect.z
    int h() {
        return this.y;
    }

    @Override // com.google.common.collect.z
    public int hashCode() {
        return this.x;
    }

    @Override // com.google.common.collect.z
    int i() {
        return 0;
    }

    @Override // com.google.common.collect.z
    public Iterator iterator() {
        return m();
    }

    @Override // com.google.common.collect.z
    boolean l() {
        return 0;
    }

    public com.google.common.collect.b1<E> m() {
        return b().m();
    }

    @Override // com.google.common.collect.z
    public int size() {
        return this.y;
    }

    com.google.common.collect.v<E> u() {
        return v.q(this.c, this.y);
    }

    @Override // com.google.common.collect.z
    boolean v() {
        return 1;
    }
}
