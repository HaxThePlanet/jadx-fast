package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class y<K, V>  extends com.google.common.collect.g<K, V> implements Serializable {

    private static final long serialVersionUID;
    final transient com.google.common.collect.x<K, ? extends com.google.common.collect.t<V>> v;
    final transient int w;

    public static class b {

        Map<K, Collection<V>> a;
        Comparator<? super K> b;
        Comparator<? super V> c;
        public b() {
            super();
            this.a = q0.c();
        }

        public com.google.common.collect.y<K, V> a() {
            Object entrySet;
            Comparator comparator;
            comparator = this.b;
            if (comparator != null) {
                entrySet = p0.a(comparator).d().b(this.a.entrySet());
            }
            return w.m(entrySet, this.c);
        }

        Collection<V> b() {
            ArrayList arrayList = new ArrayList();
            return arrayList;
        }

        public com.google.common.collect.y.b<K, V> c(K k, Iterable<? extends V> iterable2) {
            Object next;
            String obj4;
            if (k == null) {
                String str = "null key in entry: null=";
                obj4 = String.valueOf(a0.g(iterable2));
                if (obj4.length() != 0) {
                    obj4 = str.concat(obj4);
                } else {
                    obj4 = new String(str);
                }
                NullPointerException obj3 = new NullPointerException(obj4);
                throw obj3;
            }
            Object obj = this.a.get(k);
            if ((Collection)obj != null) {
                obj4 = iterable2.iterator();
                for (Object next : obj4) {
                    i.a(k, next);
                    (Collection)obj.add(next);
                }
                return this;
            }
            obj4 = iterable2.iterator();
            if (!obj4.hasNext()) {
                return this;
            }
            Collection collection = b();
            for (Object next : obj4) {
                i.a(k, next);
                collection.add(next);
            }
            this.a.put(k, collection);
            return this;
        }

        public com.google.common.collect.y.b<K, V> d(K k, V... v2Arr2) {
            c(k, Arrays.asList(v2Arr2));
            return this;
        }
    }

    static class c {

        static final com.google.common.collect.w0.b<com.google.common.collect.y> a;
        static final com.google.common.collect.w0.b<com.google.common.collect.y> b;
        static {
            y.c.a = w0.a(y.class, "map");
            y.c.b = w0.a(y.class, "size");
        }
    }

    class a extends com.google.common.collect.b1<V> {

        Iterator<? extends com.google.common.collect.t<V>> a;
        Iterator<V> b;
        final com.google.common.collect.y c;
        a(com.google.common.collect.y y) {
            this.c = y;
            super();
            this.a = y.v.l().m();
            this.b = b0.d();
        }

        @Override // com.google.common.collect.b1
        public boolean hasNext() {
            int i;
            boolean next;
            if (!this.b.hasNext()) {
                if (this.a.hasNext()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public V next() {
            boolean next;
            if (!this.b.hasNext()) {
                this.b = (t)this.a.next().m();
            }
            return this.b.next();
        }
    }

    private static final class d extends com.google.common.collect.t<V> {

        private static final long serialVersionUID;
        private final transient com.google.common.collect.y<K, V> b;
        d(com.google.common.collect.y<K, V> y) {
            super();
            this.b = y;
        }

        @Override // com.google.common.collect.t
        public boolean contains(Object object) {
            return this.b.b(object);
        }

        @Override // com.google.common.collect.t
        int d(Object[] objectArr, int i2) {
            Object next;
            int obj4;
            com.google.common.collect.b1 b1Var = yVar.v.l().m();
            for (t next : b1Var) {
                obj4 = next.d(objectArr, obj4);
            }
            return obj4;
        }

        @Override // com.google.common.collect.t
        public Iterator iterator() {
            return m();
        }

        public com.google.common.collect.b1<V> m() {
            return this.b.j();
        }

        @Override // com.google.common.collect.t
        public int size() {
            return this.b.size();
        }
    }
    y(com.google.common.collect.x<K, ? extends com.google.common.collect.t<V>> x, int i2) {
        super();
        this.v = x;
        this.w = i2;
    }

    @Override // com.google.common.collect.g
    public Map a() {
        return h();
    }

    @Override // com.google.common.collect.g
    public boolean b(Object object) {
        Object obj1;
        if (object != null && super.b(object)) {
            obj1 = super.b(object) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    Map<K, Collection<V>> c() {
        AssertionError assertionError = new AssertionError("should never be called");
        throw assertionError;
    }

    @Deprecated
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    Set<K> d() {
        AssertionError assertionError = new AssertionError("unreachable");
        throw assertionError;
    }

    @Override // com.google.common.collect.g
    Collection e() {
        return i();
    }

    @Override // com.google.common.collect.g
    Iterator g() {
        return j();
    }

    public com.google.common.collect.x<K, Collection<V>> h() {
        return this.v;
    }

    com.google.common.collect.t<V> i() {
        y.d dVar = new y.d(this);
        return dVar;
    }

    com.google.common.collect.b1<V> j() {
        y.a aVar = new y.a(this);
        return aVar;
    }

    public com.google.common.collect.t<V> k() {
        return (t)super.values();
    }

    @Deprecated
    public boolean put(K k, V v2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // com.google.common.collect.g
    public int size() {
        return this.w;
    }

    @Override // com.google.common.collect.g
    public Collection values() {
        return k();
    }
}
