package kotlin.i0.z.e.n0;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class a<E>  implements Iterable<E> {

    private static final kotlin.i0.z.e.n0.a<Object> v;
    final E a;
    final kotlin.i0.z.e.n0.a<E> b;
    private final int c;

    private static class a implements Iterator<E> {

        private kotlin.i0.z.e.n0.a<E> a;
        public a(kotlin.i0.z.e.n0.a<E> a) {
            super();
            this.a = a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = a.b(this.a) > 0 ? 1 : 0;
            return i;
        }

        public E next() {
            kotlin.i0.z.e.n0.a aVar = this.a;
            this.a = aVar.b;
            return aVar.a;
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }
    static {
        a aVar = new a();
        a.v = aVar;
    }

    private a() {
        super();
        this.c = 0;
        int i2 = 0;
        this.a = i2;
        this.b = i2;
    }

    private a(E e, kotlin.i0.z.e.n0.a<E> a2) {
        super();
        this.a = e;
        this.b = a2;
        this.c = obj1++;
    }

    static int b(kotlin.i0.z.e.n0.a a) {
        return a.c;
    }

    public static <E> kotlin.i0.z.e.n0.a<E> d() {
        return a.v;
    }

    private Iterator<E> g(int i) {
        a.a aVar = new a.a(m(i));
        return aVar;
    }

    private kotlin.i0.z.e.n0.a<E> i(Object object) {
        if (this.c == 0) {
            return this;
        }
        if (this.a.equals(object)) {
            return this.b;
        }
        kotlin.i0.z.e.n0.a obj3 = this.b.i(object);
        if (obj3 == this.b) {
            return this;
        }
        a aVar3 = new a(this.a, obj3);
        return aVar3;
    }

    private kotlin.i0.z.e.n0.a<E> m(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i > this.c) {
            } else {
                if (i == 0) {
                    return this;
                }
                return this.b.m(i--);
            }
        }
        IndexOutOfBoundsException obj2 = new IndexOutOfBoundsException();
        throw obj2;
    }

    public E get(int i) {
        java.lang.IndexOutOfBoundsException indexOutOfBoundsException;
        if (i < 0) {
        } else {
            if (i > this.c) {
            } else {
                return g(i).next();
            }
        }
        IndexOutOfBoundsException obj4 = new IndexOutOfBoundsException();
        throw obj4;
    }

    public kotlin.i0.z.e.n0.a<E> h(int i) {
        return i(get(i));
    }

    public Iterator<E> iterator() {
        return g(0);
    }

    public kotlin.i0.z.e.n0.a<E> l(E e) {
        a aVar = new a(e, this);
        return aVar;
    }

    @Override // java.lang.Iterable
    public int size() {
        return this.c;
    }
}
