package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class b0 {

    private static enum c implements Iterator<Object> {

        INSTANCE;
        private static com.google.common.collect.b0.c[] $values() {
            com.google.common.collect.b0.c[] arr = new b0.c[1];
            return arr;
        }

        @Override // java.lang.Enum
        public boolean hasNext() {
            return 0;
        }

        @Override // java.lang.Enum
        public Object next() {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.lang.Enum
        public void remove() {
            i.c(false);
        }
    }

    class a extends com.google.common.collect.b1<T> {

        boolean a;
        final Object b;
        a(Object object) {
            this.b = object;
            super();
        }

        @Override // com.google.common.collect.b1
        public boolean hasNext() {
            return z ^= 1;
        }

        public T next() {
            if (this.a) {
            } else {
                this.a = true;
                return this.b;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
    }

    private static final class b extends com.google.common.collect.a<T> {

        static final com.google.common.collect.c1<Object> w;
        private final T[] c;
        private final int v;
        static {
            final int i = 0;
            b0.b bVar = new b0.b(new Object[i], i, i, i);
            b0.b.w = bVar;
        }

        b(T[] tArr, int i2, int i3, int i4) {
            super(i3, i4);
            this.c = tArr;
            this.v = i2;
        }

        protected T b(int i) {
            return this.c[i2 += i];
        }
    }
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> iterator2) {
        int i;
        boolean z;
        n.o(collection);
        n.o(iterator2);
        i = 0;
        for (Object next2 : iterator2) {
            i |= z;
        }
        return i;
    }

    static void b(Iterator<?> iterator) {
        boolean next;
        n.o(iterator);
        for (Object item : iterator) {
            iterator.remove();
        }
    }

    public static boolean c(Iterator<?> iterator, Iterator<?> iterator2) {
        while (iterator.hasNext()) {
            final int i = 0;
        }
        return obj3 ^= 1;
    }

    static <T> com.google.common.collect.b1<T> d() {
        return b0.e();
    }

    static <T> com.google.common.collect.c1<T> e() {
        return b0.b.w;
    }

    static <T> Iterator<T> f() {
        return b0.c.INSTANCE;
    }

    public static <T> T g(Iterator<T> iterator) {
        while (!iterator.hasNext()) {
        }
        return iterator.next();
    }

    public static <T> T h(Iterator<? extends T> iterator, T t2) {
        Object obj2;
        if (iterator.hasNext()) {
            obj2 = b0.g(iterator);
        }
        return obj2;
    }

    public static <T> T i(Iterator<? extends T> iterator, T t2) {
        Object obj2;
        if (iterator.hasNext()) {
            obj2 = iterator.next();
        }
        return obj2;
    }

    static <T> T j(Iterator<T> iterator) {
        if (iterator.hasNext()) {
            iterator.remove();
            return iterator.next();
        }
        return 0;
    }

    public static boolean k(Iterator<?> iterator, Collection<?> collection2) {
        int i;
        boolean contains;
        n.o(collection2);
        i = 0;
        while (iterator.hasNext()) {
            if (collection2.contains(iterator.next())) {
            }
            iterator.remove();
            i = 1;
        }
        return i;
    }

    public static <T> com.google.common.collect.b1<T> l(T t) {
        b0.a aVar = new b0.a(t);
        return aVar;
    }

    public static String m(Iterator<?> iterator) {
        int str;
        Object next;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        str = 1;
        while (iterator.hasNext()) {
            if (str == null) {
            }
            str = 0;
            stringBuilder.append(iterator.next());
            stringBuilder.append(", ");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
