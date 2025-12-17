package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class ha<E>  extends com.google.android.gms.internal.measurement.l7<E> implements RandomAccess {

    private static final com.google.android.gms.internal.measurement.ha<Object> v;
    private E[] b;
    private int c;
    static {
        final int i = 0;
        ha haVar = new ha(new Object[i], i);
        ha.v = haVar;
        haVar.zzb();
    }

    private ha(E[] eArr, int i2) {
        super();
        this.b = eArr;
        this.c = i2;
    }

    public static <E> com.google.android.gms.internal.measurement.ha<E> d() {
        return ha.v;
    }

    private final String g(int i) {
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    private final void h(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= this.c) {
            } else {
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(g(i));
        throw indexOutOfBoundsException;
    }

    public final void add(int i, E e2) {
        int arr;
        int i2;
        Object[] objArr;
        int i4;
        int i3;
        b();
        if (i < 0) {
        } else {
            i2 = this.c;
            if (i > i2) {
            } else {
                objArr = this.b;
                if (i2 < objArr.length) {
                    System.arraycopy(objArr, i, objArr, i + 1, i2 -= i);
                } else {
                    arr = new Object[i6++];
                    int i8 = 0;
                    System.arraycopy(objArr, i8, arr, i8, i);
                    System.arraycopy(this.b, i, arr, i + 1, i9 -= i);
                    this.b = arr;
                }
                this.b[i] = e2;
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(g(i));
        throw obj6;
    }

    public final boolean add(E e) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    public final com.google.android.gms.internal.measurement.c9 f(int i) {
        if (i < this.c) {
        } else {
            ha haVar = new ha(Arrays.copyOf(this.b, i), this.c);
            return haVar;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    public final E get(int i) {
        h(i);
        return this.b[i];
    }

    public final E remove(int i) {
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

    public final E set(int i, E e2) {
        b();
        h(i);
        final Object[] objArr = this.b;
        objArr[i] = e2;
        this.modCount = obj3++;
        return objArr[i];
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int size() {
        return this.c;
    }
}
