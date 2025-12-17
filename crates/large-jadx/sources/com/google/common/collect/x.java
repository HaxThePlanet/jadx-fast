package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class x<K, V>  implements Map<K, V>, Serializable {

    private transient com.google.common.collect.z<Map.Entry<K, V>> a;
    private transient com.google.common.collect.z<K> b;
    private transient com.google.common.collect.t<V> c;

    public static class a {

        Comparator<? super V> a;
        Object[] b;
        int c;
        boolean d;
        public a() {
            super(4);
        }

        a(int i) {
            super();
            this.b = new Object[i *= 2];
            int obj1 = 0;
            this.c = obj1;
            this.d = obj1;
        }

        private void b(int i) {
            int length;
            int obj3;
            i *= 2;
            final Object[] objArr = this.b;
            if (obj3 > objArr.length) {
                this.b = Arrays.copyOf(objArr, t.b.a(objArr.length, obj3));
                this.d = false;
            }
        }

        public com.google.common.collect.x<K, V> a() {
            f();
            this.d = true;
            return s0.m(this.c, this.b);
        }

        public com.google.common.collect.x.a<K, V> c(K k, V v2) {
            b(i++);
            i.a(k, v2);
            Object[] objArr = this.b;
            int i3 = this.c;
            objArr[i3 * 2] = k;
            objArr[obj4++] = v2;
            this.c = i3++;
            return this;
        }

        public com.google.common.collect.x.a<K, V> d(Map.Entry<? extends K, ? extends V> map$Entry) {
            c(entry.getKey(), entry.getValue());
            return this;
        }

        public com.google.common.collect.x.a<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            boolean next;
            int size;
            if (iterable instanceof Collection != null) {
                b(i += size);
            }
            final Iterator obj3 = iterable.iterator();
            for (Map.Entry next : obj3) {
                d(next);
            }
            return this;
        }

        void f() {
            Comparator arr;
            boolean copyOf;
            int i2;
            int i3;
            int i;
            com.google.common.collect.p0 p0Var;
            int simpleImmutableEntry;
            com.google.common.base.g value;
            int i4;
            Object obj;
            if (this.a != null && this.d) {
                if (this.d) {
                    this.b = Arrays.copyOf(this.b, i6 *= 2);
                }
                arr = new Map.Entry[this.c];
                i2 = 0;
                i = i2;
                simpleImmutableEntry = this.c;
                while (i < simpleImmutableEntry) {
                    Object[] objArr3 = this.b;
                    int i8 = i * 2;
                    simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(objArr3[i8], objArr3[i8++]);
                    arr[i] = simpleImmutableEntry;
                    i++;
                    simpleImmutableEntry = this.c;
                }
                Arrays.sort(arr, i2, simpleImmutableEntry, p0.a(this.a).e(h0.j()));
                while (i2 < this.c) {
                    int i7 = i2 * 2;
                    this.b[i7] = arr[i2].getKey();
                    this.b[i7++] = arr[i2].getValue();
                    i2++;
                }
            }
        }
    }

    static class b implements Serializable {

        private static final long serialVersionUID;
        private final Object keys;
        private final Object values;
        b(com.google.common.collect.x<K, V> x) {
            int i;
            Object value;
            Object key;
            super();
            Object[] arr = new Object[x.size()];
            Object[] arr2 = new Object[x.size()];
            com.google.common.collect.b1 obj6 = x.h().m();
            i = 0;
            for (Map.Entry next2 : obj6) {
                arr[i] = next2.getKey();
                arr2[i] = next2.getValue();
                i++;
            }
            this.keys = arr;
            this.values = arr2;
        }

        @Override // java.io.Serializable
        final Object a() {
            int i;
            Object obj;
            Object obj2;
            Object keys = this.keys;
            com.google.common.collect.x.a aVar = b(keys.length);
            i = 0;
            for (Object obj : obj0) {
                aVar.c(obj, (Object[])this.values[i]);
            }
            return aVar.a();
        }

        com.google.common.collect.x.a<K, V> b(int i) {
            x.a aVar = new x.a(i);
            return aVar;
        }

        @Override // java.io.Serializable
        final Object readResolve() {
            Object next2;
            Object next;
            Object keys = this.keys;
            if (!keys instanceof z) {
                return a();
            }
            com.google.common.collect.x.a aVar = b((z)keys.size());
            com.google.common.collect.b1 b1Var = keys.m();
            for (Object next2 : b1Var) {
                aVar.c(next2, (t)this.values.m().next());
            }
            return aVar.a();
        }
    }
    static {
    }

    public static <K, V> com.google.common.collect.x.a<K, V> a() {
        x.a aVar = new x.a();
        return aVar;
    }

    public static <K, V> com.google.common.collect.x<K, V> c(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        int size;
        if (iterable instanceof Collection != null) {
            size = (Collection)iterable.size();
        } else {
            size = 4;
        }
        x.a aVar = new x.a(size);
        aVar.e(iterable);
        return aVar.a();
    }

    public static <K, V> com.google.common.collect.x<K, V> d(Map<? extends K, ? extends V> map) {
        boolean obj;
        boolean z;
        obj = map;
        if (map instanceof x && map instanceof SortedMap == null && !(x)obj.i()) {
            if (map instanceof SortedMap == null) {
                obj = map;
                if (!(x)obj.i()) {
                    return obj;
                }
            }
        }
        return x.c(map.entrySet());
    }

    public static <K, V> com.google.common.collect.x<K, V> k() {
        return s0.y;
    }

    @Deprecated
    public final void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // java.util.Map
    public boolean containsKey(Object object) {
        int obj1;
        obj1 = get(object) != null ? 1 : 0;
        return obj1;
    }

    @Override // java.util.Map
    public boolean containsValue(Object object) {
        return l().contains(object);
    }

    abstract com.google.common.collect.z<Map.Entry<K, V>> e();

    @Override // java.util.Map
    public Set entrySet() {
        return h();
    }

    @Override // java.util.Map
    public boolean equals(Object object) {
        return h0.b(this, object);
    }

    abstract com.google.common.collect.z<K> f();

    abstract com.google.common.collect.t<V> g();

    public abstract V get(Object object);

    public final V getOrDefault(Object object, V v2) {
        Object obj2;
        final Object obj1 = get(object);
        if (obj1 != null) {
            obj2 = obj1;
        }
        return obj2;
    }

    public com.google.common.collect.z<Map.Entry<K, V>> h() {
        com.google.common.collect.z zVar;
        if (this.a == null) {
            this.a = e();
        }
        return zVar;
    }

    @Override // java.util.Map
    public int hashCode() {
        return y0.b(h());
    }

    @Override // java.util.Map
    abstract boolean i();

    @Override // java.util.Map
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    public com.google.common.collect.z<K> j() {
        com.google.common.collect.z zVar;
        if (this.b == null) {
            this.b = f();
        }
        return zVar;
    }

    @Override // java.util.Map
    public Set keySet() {
        return j();
    }

    public com.google.common.collect.t<V> l() {
        com.google.common.collect.t tVar;
        if (this.c == null) {
            this.c = g();
        }
        return tVar;
    }

    @Deprecated
    public final V put(K k, V v2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Deprecated
    public final V remove(Object object) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // java.util.Map
    public String toString() {
        return h0.i(this);
    }

    @Override // java.util.Map
    public Collection values() {
        return l();
    }

    @Override // java.util.Map
    Object writeReplace() {
        x.b bVar = new x.b(this);
        return bVar;
    }
}
