package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class h1<E>  extends com.google.protobuf.c<E> implements RandomAccess {

    private static final com.google.protobuf.h1<Object> v;
    private E[] b;
    private int c;
    static {
        final int i = 0;
        h1 h1Var = new h1(new Object[i], i);
        h1.v = h1Var;
        h1Var.F();
    }

    private h1(E[] eArr, int i2) {
        super();
        this.b = eArr;
        this.c = i2;
    }

    private static <E> E[] d(int i) {
        return new Object[i];
    }

    public static <E> com.google.protobuf.h1<E> g() {
        return h1.v;
    }

    private void h(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= this.c) {
            } else {
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(i(i));
        throw indexOutOfBoundsException;
    }

    private String i(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    public void add(int i, E e2) {
        int i2;
        int i4;
        Object[] objArr;
        int i3;
        int i5;
        b();
        if (i < 0) {
        } else {
            i4 = this.c;
            if (i > i4) {
            } else {
                objArr = this.b;
                if (i4 < objArr.length) {
                    System.arraycopy(objArr, i, objArr, i + 1, i4 -= i);
                } else {
                    i2 = h1.d(i7++);
                    int i9 = 0;
                    System.arraycopy(this.b, i9, i2, i9, i);
                    System.arraycopy(this.b, i, i2, i + 1, i10 -= i);
                    this.b = i2;
                }
                this.b[i] = e2;
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(i(i));
        throw obj6;
    }

    public boolean add(E e) {
        int copyOf;
        b();
        copyOf = this.c;
        Object[] objArr2 = this.b;
        final int i6 = 1;
        if (copyOf == objArr2.length) {
            this.b = Arrays.copyOf(objArr2, i2 += i6);
        }
        int i4 = this.c;
        this.c = i4 + 1;
        this.b[i4] = e;
        this.modCount = obj5 += i6;
        return i6;
    }

    @Override // com.google.protobuf.c
    public com.google.protobuf.c0.j c(int i) {
        return l(i);
    }

    public E get(int i) {
        h(i);
        return this.b[i];
    }

    public com.google.protobuf.h1<E> l(int i) {
        if (i < this.c) {
        } else {
            h1 h1Var = new h1(Arrays.copyOf(this.b, i), this.c);
            return h1Var;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    public E remove(int i) {
        int i3;
        int i2;
        b();
        h(i);
        final Object[] objArr = this.b;
        i3 = this.c;
        if (i < i3 + -1) {
            System.arraycopy(objArr, i + 1, objArr, i, i4--);
        }
        this.c = obj5--;
        this.modCount = obj5++;
        return objArr[i];
    }

    public E set(int i, E e2) {
        b();
        h(i);
        final Object[] objArr = this.b;
        objArr[i] = e2;
        this.modCount = obj3++;
        return objArr[i];
    }

    @Override // com.google.protobuf.c
    public int size() {
        return this.c;
    }
}
