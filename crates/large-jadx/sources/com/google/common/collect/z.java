package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class z<E>  extends com.google.common.collect.t<E> implements Set<E> {

    private transient com.google.common.collect.v<E> b;

    private static class a implements Serializable {

        private static final long serialVersionUID;
        final Object[] elements;
        a(Object[] objectArr) {
            super();
            this.elements = objectArr;
        }

        @Override // java.io.Serializable
        Object readResolve() {
            return z.t(this.elements);
        }
    }
    public static <E> com.google.common.collect.z<E> A(E e, E e2, E e3) {
        final int i = 3;
        final Object[] arr = new Object[i];
        arr[0] = e;
        arr[1] = e2;
        arr[2] = e3;
        return z.q(i, arr);
    }

    private static boolean B(int i, int i2) {
        int obj1;
        obj1 = i < i3 += obj2 ? 1 : 0;
        return obj1;
    }

    static int p(int i) {
        int i2;
        int i3;
        int highestOneBit;
        double d;
        int obj5 = Math.max(i, 2);
        i2 = 1;
        if (obj5 < 751619276) {
            i3 = highestOneBit << 1;
            while (Double.compare(i8, d) < 0) {
                i3 <<= 1;
            }
            return i3;
        }
        int i6 = 1073741824;
        if (obj5 < i6) {
        } else {
            i2 = 0;
        }
        n.e(i2, "collection too large");
        return i6;
    }

    private static <E> com.google.common.collect.z<E> q(int i, Object... object2Arr2) {
        int i2;
        Object obj2;
        int i6;
        int i4;
        int i5;
        int i3;
        int equals;
        Object obj;
        Object[] obj14;
        final int i7 = 0;
        final int i8 = 1;
        if (i != 0 && i != i8) {
            i7 = 0;
            i8 = 1;
            if (i != i8) {
                int i9 = z.p(i);
                final Object[] arr = new Object[i9];
                final int i12 = i9 + -1;
                i4 = i6;
                while (i2 < i) {
                    obj2 = object2Arr2[i2];
                    o0.a(obj2, i2);
                    i5 = obj2.hashCode();
                    i3 = s.b(i5);
                    equals = i3 & i12;
                    obj = arr[equals];
                    while (obj == null) {
                        if (!obj.equals(obj2)) {
                            break loop_5;
                        }
                        i3++;
                        equals = i3 & i12;
                        obj = arr[equals];
                    }
                    if (!obj.equals(obj2)) {
                    }
                    i3++;
                    i2++;
                    object2Arr2[i4] = obj2;
                    arr[equals] = obj2;
                    i6 += i5;
                    i4 = i3;
                }
                Arrays.fill(object2Arr2, i4, i, 0);
                if (i4 == i8) {
                    obj14 = new z0(object2Arr2[i7], i6);
                    return obj14;
                }
                if (z.p(i4) < i9 /= 2) {
                    return z.q(i4, object2Arr2);
                }
                if (z.B(i4, object2Arr2.length)) {
                    obj14 = Arrays.copyOf(object2Arr2, i4);
                }
                super(obj14, i6, arr, i12, i4);
                return obj13;
            }
            return z.y(object2Arr2[i7]);
        }
        return z.w();
    }

    public static <E> com.google.common.collect.z<E> s(Collection<? extends E> collection) {
        boolean obj;
        boolean z;
        obj = collection;
        if (collection instanceof z && collection instanceof SortedSet == null && !(z)obj.l()) {
            if (collection instanceof SortedSet == null) {
                obj = collection;
                if (!(z)obj.l()) {
                    return obj;
                }
            }
        }
        Object[] obj2 = collection.toArray();
        return z.q(obj2.length, obj2);
    }

    public static <E> com.google.common.collect.z<E> t(E[] eArr) {
        int length = eArr.length;
        if (length != 0 && length != 1) {
            if (length != 1) {
                return z.q(eArr.length, (Object[])eArr.clone());
            }
            return z.y(eArr[0]);
        }
        return z.w();
    }

    public static <E> com.google.common.collect.z<E> w() {
        return t0.z;
    }

    public static <E> com.google.common.collect.z<E> y(E e) {
        z0 z0Var = new z0(e);
        return z0Var;
    }

    public static <E> com.google.common.collect.z<E> z(E e, E e2) {
        final int i = 2;
        final Object[] arr = new Object[i];
        arr[0] = e;
        arr[1] = e2;
        return z.q(i, arr);
    }

    public com.google.common.collect.v<E> b() {
        com.google.common.collect.v vVar;
        if (this.b == null) {
            this.b = u();
        }
        return vVar;
    }

    @Override // com.google.common.collect.t
    public boolean equals(Object object) {
        boolean z;
        int i;
        if (object == this) {
            return 1;
        }
        if (object instanceof z && v() && (z)object.v() && hashCode() != object.hashCode()) {
            if (v()) {
                if ((z)object.v()) {
                    if (hashCode() != object.hashCode()) {
                        return 0;
                    }
                }
            }
        }
        return y0.a(this, object);
    }

    @Override // com.google.common.collect.t
    public int hashCode() {
        return y0.b(this);
    }

    @Override // com.google.common.collect.t
    public Iterator iterator() {
        return m();
    }

    com.google.common.collect.v<E> u() {
        return v.p(toArray());
    }

    @Override // com.google.common.collect.t
    boolean v() {
        return 0;
    }

    @Override // com.google.common.collect.t
    Object writeReplace() {
        z.a aVar = new z.a(toArray());
        return aVar;
    }
}
