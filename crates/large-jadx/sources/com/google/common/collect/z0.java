package com.google.common.collect;

import com.google.common.base.n;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class z0<E>  extends com.google.common.collect.z<E> {

    final transient E c;
    private transient int v;
    z0(E e) {
        super();
        n.o(e);
        this.c = e;
    }

    z0(E e, int i2) {
        super();
        this.c = e;
        this.v = i2;
    }

    @Override // com.google.common.collect.z
    public boolean contains(Object object) {
        return this.c.equals(object);
    }

    @Override // com.google.common.collect.z
    int d(Object[] objectArr, int i2) {
        objectArr[i2] = this.c;
        return i2++;
    }

    @Override // com.google.common.collect.z
    public final int hashCode() {
        int i;
        if (this.v == 0) {
            this.v = this.c.hashCode();
        }
        return i;
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
        return b0.l(this.c);
    }

    @Override // com.google.common.collect.z
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.z
    public String toString() {
        String string = this.c.toString();
        StringBuilder stringBuilder = new StringBuilder(length += 2);
        stringBuilder.append('[');
        stringBuilder.append(string);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    com.google.common.collect.v<E> u() {
        return v.A(this.c);
    }

    @Override // com.google.common.collect.z
    boolean v() {
        int i;
        i = this.v != 0 ? 1 : 0;
        return i;
    }
}
