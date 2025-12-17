package com.google.common.collect;

import com.google.common.base.n;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class y0 {

    static abstract class b extends AbstractSet<E> {
        public boolean removeAll(Collection<?> collection) {
            return y0.g(this, collection);
        }

        public boolean retainAll(Collection<?> collection) {
            n.o(collection);
            return super.retainAll((Collection)collection);
        }
    }

    public static abstract class c extends AbstractSet<E> {
        c(com.google.common.collect.x0 x0) {
            super();
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

        @Deprecated
        public final void clear() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

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
    }

    class a extends com.google.common.collect.y0.c<E> {

        final Set a;
        final Set b;
        a(Set set, Set set2) {
            this.a = set;
            this.b = set2;
            super(0);
        }

        public com.google.common.collect.b1<E> b() {
            y0.a.a aVar = new y0.a.a(this);
            return aVar;
        }

        @Override // com.google.common.collect.y0$c
        public boolean contains(Object object) {
            boolean contains;
            Object obj2;
            if (this.a.contains(object) && this.b.contains(object)) {
                obj2 = this.b.contains(object) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean all;
            Collection obj2;
            if (this.a.containsAll(collection) && this.b.containsAll(collection)) {
                obj2 = this.b.containsAll(collection) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // com.google.common.collect.y0$c
        public boolean isEmpty() {
            return Collections.disjoint(this.b, this.a);
        }

        @Override // com.google.common.collect.y0$c
        public Iterator iterator() {
            return b();
        }

        @Override // com.google.common.collect.y0$c
        public int size() {
            int i;
            boolean contains;
            Set set;
            Iterator iterator = this.a.iterator();
            i = 0;
            while (iterator.hasNext()) {
                if (this.b.contains(iterator.next())) {
                }
                i++;
            }
            return i;
        }
    }
    static boolean a(Set<?> set, Object object2) {
        int i;
        boolean obj4;
        if (set == object2) {
            return 1;
        }
        final int i2 = 0;
        if (object2 instanceof Set != null) {
            if (set.size() == (Set)object2.size() && set.containsAll(object2)) {
                if (set.containsAll(object2)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    static int b(Set<?> set) {
        int i2;
        int i;
        final Iterator obj3 = set.iterator();
        final int i3 = 0;
        i2 = i3;
        while (obj3.hasNext()) {
            Object next2 = obj3.next();
            if (next2 != null) {
            } else {
            }
            i = i3;
            i2 = ~i5;
            i = next2.hashCode();
        }
        return i2;
    }

    public static <E> com.google.common.collect.y0.c<E> c(Set<E> set, Set<?> set2) {
        n.p(set, "set1");
        n.p(set2, "set2");
        y0.a aVar = new y0.a(set, set2);
        return aVar;
    }

    public static <E> HashSet<E> d() {
        HashSet hashSet = new HashSet();
        return hashSet;
    }

    public static <E> HashSet<E> e(int i) {
        HashSet hashSet = new HashSet(h0.a(i));
        return hashSet;
    }

    public static <E> Set<E> f() {
        return Collections.newSetFromMap(h0.e());
    }

    static boolean g(Set<?> set, Collection<?> collection2) {
        boolean size2;
        int size;
        Object obj3;
        n.o(collection2);
        if (collection2 instanceof m0) {
            obj3 = (m0)collection2.H();
        }
        if (obj3 instanceof Set != null && obj3.size() > set.size()) {
            if (obj3.size() > set.size()) {
                return b0.k(set.iterator(), obj3);
            }
        }
        return y0.h(set, obj3.iterator());
    }

    static boolean h(Set<?> set, Iterator<?> iterator2) {
        int i;
        boolean remove;
        i = 0;
        for (Object next2 : iterator2) {
            i |= remove;
        }
        return i;
    }
}
