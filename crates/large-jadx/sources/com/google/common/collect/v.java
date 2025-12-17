package com.google.common.collect;

import com.google.common.base.n;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public abstract class v<E>  extends com.google.common.collect.t<E> implements List<E>, RandomAccess {

    private static final com.google.common.collect.c1<Object> b;

    static class c implements Serializable {

        private static final long serialVersionUID;
        final Object[] elements;
        c(Object[] objectArr) {
            super();
            this.elements = objectArr;
        }

        @Override // java.io.Serializable
        Object readResolve() {
            return v.v(this.elements);
        }
    }

    public static final class a extends com.google.common.collect.t.a<E> {
        public a() {
            super(4);
        }

        a(int i) {
            super(i);
        }

        public com.google.common.collect.v.a<E> d(E e) {
            super.b(e);
            return this;
        }

        public com.google.common.collect.v<E> e() {
            this.c = true;
            return v.q(this.a, this.b);
        }
    }

    class d extends com.google.common.collect.v<E> {

        final transient int c;
        final com.google.common.collect.v this$0;
        final transient int v;
        d(com.google.common.collect.v v, int i2, int i3) {
            this.this$0 = v;
            super();
            this.c = i2;
            this.v = i3;
        }

        public com.google.common.collect.v<E> E(int i, int i2) {
            n.t(i, i2, this.v);
            final int i4 = this.c;
            return this.this$0.E(i += i4, i2 += i4);
        }

        @Override // com.google.common.collect.v
        Object[] g() {
            return this.this$0.g();
        }

        public E get(int i) {
            n.m(i, this.v);
            return this.this$0.get(i += i3);
        }

        @Override // com.google.common.collect.v
        int h() {
            return i2 += i5;
        }

        @Override // com.google.common.collect.v
        int i() {
            return i += i3;
        }

        @Override // com.google.common.collect.v
        public Iterator iterator() {
            return super.m();
        }

        @Override // com.google.common.collect.v
        boolean l() {
            return 1;
        }

        @Override // com.google.common.collect.v
        public ListIterator listIterator() {
            return super.w();
        }

        @Override // com.google.common.collect.v
        public ListIterator listIterator(int i) {
            return super.y(i);
        }

        @Override // com.google.common.collect.v
        public int size() {
            return this.v;
        }

        @Override // com.google.common.collect.v
        public List subList(int i, int i2) {
            return E(i, i2);
        }
    }

    static class b extends com.google.common.collect.a<E> {

        private final com.google.common.collect.v<E> c;
        b(com.google.common.collect.v<E> v, int i2) {
            super(v.size(), i2);
            this.c = v;
        }

        protected E b(int i) {
            return this.c.get(i);
        }
    }
    static {
        v.b bVar = new v.b(r0.w, 0);
        v.b = bVar;
    }

    public static <E> com.google.common.collect.v<E> A(E e) {
        Object[] arr = new Object[1];
        return v.t(e);
    }

    public static <E> com.google.common.collect.v<E> B(E e, E e2, E e3, E e4, E e5) {
        Object[] arr = new Object[5];
        return v.t(e, e2, e3, e4, e5);
    }

    public static <E> com.google.common.collect.v<E> C(E e, E e2, E e3, E e4, E e5, E e6) {
        Object[] arr = new Object[6];
        return v.t(e, e2, e3, e4, e5, e6);
    }

    public static <E> com.google.common.collect.v<E> D(Comparator<? super E> comparator, Iterable<? extends E> iterable2) {
        n.o(comparator);
        final Object[] obj1 = a0.f(iterable2);
        o0.b(obj1);
        Arrays.sort(obj1, comparator);
        return v.p(obj1);
    }

    static <E> com.google.common.collect.v<E> p(Object[] objectArr) {
        return v.q(objectArr, objectArr.length);
    }

    static <E> com.google.common.collect.v<E> q(Object[] objectArr, int i2) {
        if (i2 == 0) {
            return v.z();
        }
        r0 r0Var = new r0(objectArr, i2);
        return r0Var;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Use SerializedForm");
        throw obj2;
    }

    public static <E> com.google.common.collect.v.a<E> s() {
        v.a aVar = new v.a();
        return aVar;
    }

    private static <E> com.google.common.collect.v<E> t(Object... objectArr) {
        o0.b(objectArr);
        return v.p(objectArr);
    }

    public static <E> com.google.common.collect.v<E> u(Collection<? extends E> collection) {
        com.google.common.collect.v obj1;
        obj1 = (t)collection.b();
        if (collection instanceof t && obj1.l()) {
            obj1 = (t)collection.b();
            if (obj1.l()) {
                obj1 = v.p(obj1.toArray());
            }
            return obj1;
        }
        return v.t(collection.toArray());
    }

    public static <E> com.google.common.collect.v<E> v(E[] eArr) {
        com.google.common.collect.v obj1;
        if (eArr.length == 0) {
            obj1 = v.z();
        } else {
            obj1 = v.t((Object[])eArr.clone());
        }
        return obj1;
    }

    public static <E> com.google.common.collect.v<E> z() {
        return r0.w;
    }

    public com.google.common.collect.v<E> E(int i, int i2) {
        n.t(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return v.z();
        }
        return G(i, i2);
    }

    com.google.common.collect.v<E> G(int i, int i2) {
        v.d dVar = new v.d(this, i, i2 -= i);
        return dVar;
    }

    @Deprecated
    public final void add(int i, E e2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    public final com.google.common.collect.v<E> b() {
        return this;
    }

    @Override // com.google.common.collect.t
    public boolean contains(Object object) {
        int obj1;
        obj1 = indexOf(object) >= 0 ? 1 : 0;
        return obj1;
    }

    @Override // com.google.common.collect.t
    int d(Object[] objectArr, int i2) {
        int i;
        int i3;
        Object obj;
        final int size = size();
        i = 0;
        while (i < size) {
            objectArr[i2 + i] = get(i);
            i++;
        }
        return i2 += size;
    }

    @Override // com.google.common.collect.t
    public boolean equals(Object object) {
        return d0.c(this, object);
    }

    @Override // com.google.common.collect.t
    public int hashCode() {
        int i;
        int i3;
        int i2;
        i = 1;
        i3 = 0;
        while (i3 < size()) {
            i = ~i6;
            i3++;
        }
        return i;
    }

    @Override // com.google.common.collect.t
    public int indexOf(Object object) {
        int obj1;
        if (object == null) {
            obj1 = -1;
        } else {
            obj1 = d0.d(this, object);
        }
        return obj1;
    }

    @Override // com.google.common.collect.t
    public Iterator iterator() {
        return m();
    }

    @Override // com.google.common.collect.t
    public int lastIndexOf(Object object) {
        int obj1;
        if (object == null) {
            obj1 = -1;
        } else {
            obj1 = d0.f(this, object);
        }
        return obj1;
    }

    @Override // com.google.common.collect.t
    public ListIterator listIterator() {
        return w();
    }

    @Override // com.google.common.collect.t
    public ListIterator listIterator(int i) {
        return y(i);
    }

    public com.google.common.collect.b1<E> m() {
        return w();
    }

    @Deprecated
    public final E remove(int i) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Deprecated
    public final E set(int i, E e2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // com.google.common.collect.t
    public List subList(int i, int i2) {
        return E(i, i2);
    }

    public com.google.common.collect.c1<E> w() {
        return y(0);
    }

    @Override // com.google.common.collect.t
    Object writeReplace() {
        v.c cVar = new v.c(toArray());
        return cVar;
    }

    public com.google.common.collect.c1<E> y(int i) {
        n.r(i, size());
        if (isEmpty()) {
            return v.b;
        }
        v.b bVar = new v.b(this, i);
        return bVar;
    }
}
