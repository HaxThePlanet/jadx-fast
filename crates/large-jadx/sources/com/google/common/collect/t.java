package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class t<E>  extends AbstractCollection<E> implements Serializable {

    private static final Object[] a;

    public static abstract class b {
        static int a(int i, int i2) {
            int obj1;
            int obj2;
            if (i2 < 0) {
            } else {
                if (obj1++ < i2) {
                    obj1 <<= 1;
                }
                if (obj1 < 0) {
                    obj1 = Integer.MAX_VALUE;
                }
                return obj1;
            }
            obj1 = new AssertionError("cannot store more than MAX_VALUE elements");
            throw obj1;
        }
    }

    static abstract class a extends com.google.common.collect.t.b<E> {

        Object[] a;
        int b = 0;
        boolean c;
        a(int i) {
            super();
            i.b(i, "initialCapacity");
            this.a = new Object[i];
            int obj2 = 0;
        }

        private void c(int i) {
            int length;
            Object[] obj4;
            final Object[] objArr = this.a;
            final int i2 = 0;
            if (objArr.length < i) {
                this.a = Arrays.copyOf(objArr, t.b.a(objArr.length, i));
                this.c = i2;
            } else {
                if (this.c) {
                    this.a = (Object[])objArr.clone();
                    this.c = i2;
                }
            }
        }

        public com.google.common.collect.t.a<E> b(E e) {
            n.o(e);
            c(i++);
            final int i3 = this.b;
            this.b = i3 + 1;
            this.a[i3] = e;
            return this;
        }
    }
    static {
        t.a = new Object[0];
    }

    @Deprecated
    public final boolean add(E e) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    public com.google.common.collect.v<E> b() {
        com.google.common.collect.v vVar;
        if (isEmpty()) {
            vVar = v.z();
        } else {
            vVar = v.p(toArray());
        }
        return vVar;
    }

    @Deprecated
    public final void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // java.util.AbstractCollection
    public abstract boolean contains(Object object);

    @Override // java.util.AbstractCollection
    int d(Object[] objectArr, int i2) {
        Object next;
        int i;
        int obj5;
        final com.google.common.collect.b1 b1Var = m();
        for (Object next : b1Var) {
            objectArr[obj5] = next;
            obj5 = i;
        }
        return obj5;
    }

    @Override // java.util.AbstractCollection
    Object[] g() {
        return null;
    }

    @Override // java.util.AbstractCollection
    int h() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // java.util.AbstractCollection
    int i() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // java.util.AbstractCollection
    public Iterator iterator() {
        return m();
    }

    @Override // java.util.AbstractCollection
    abstract boolean l();

    public abstract com.google.common.collect.b1<E> m();

    @Deprecated
    public final boolean remove(Object object) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // java.util.AbstractCollection
    public final Object[] toArray() {
        return toArray(t.a);
    }

    public final <T> T[] toArray(T[] tArr) {
        Object[] length;
        Object[] obj4;
        n.o(tArr);
        int size = size();
        if (tArr.length < size) {
            length = g();
            if (length != null) {
                return q0.a(length, i(), h(), tArr);
            }
            obj4 = o0.d(tArr, size);
        } else {
            if (tArr.length > size) {
                tArr[size] = 0;
            }
        }
        d(obj4, 0);
        return obj4;
    }

    @Override // java.util.AbstractCollection
    Object writeReplace() {
        v.c cVar = new v.c(toArray());
        return cVar;
    }
}
