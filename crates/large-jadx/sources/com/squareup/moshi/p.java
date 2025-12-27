package com.squareup.moshi;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* compiled from: LinkedHashTreeMap.java */
/* loaded from: classes2.dex */
final class p<K, V> extends AbstractMap<K, V> implements Serializable {

    private static final Comparator<Comparable> a = new p$a<>();
    Comparator<? super K> comparator;
    private p.d<K, V> entrySet;
    final p.g<K, V> header;
    private p.e<K, V> keySet;
    int modCount;
    int size;
    p.g<K, V>[] table;
    int threshold;

    class a implements Comparator<Comparable> {
        a() {
            super();
        }

        public int a(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    static final class b<K, V> {

        private p.g<K, V> a;
        private int b;
        private int c;
        private int d;
        b() {
            super();
        }

        void a(p.g<K, V> gVar) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i7 = 4;
            com.squareup.moshi.p.g gVar2 = null;
            gVar.c = gVar2;
            gVar.a = gVar2;
            gVar.b = gVar2;
            int i8 = 1;
            gVar.A = i8;
            if (this.b > 0 && i3 & 1 == 0) {
                this.d += i8;
                this.b -= i8;
                this.c += i8;
            }
            gVar.a = this.a;
            this.a = gVar;
            this.d += i8;
            if (this.b > 0) {
                i3 = i6 & 1;
                if (i6 & 1 == 0) {
                    this.d = i6 + i8;
                    this.b -= i8;
                    this.c += i8;
                }
            }
            i7 = 4;
            int i13 = i7 - 1;
            while ((this.d & i13) == this.d) {
                i7 = i7 * 2;
            }
        }

        void b(int i) {
            this.b = (Integer.highestOneBit(i) * 2) - 1 - i;
            int i5 = 0;
            this.d = i5;
            this.c = i5;
            this.a = null;
        }

        p.g<K, V> c() {
            if (gVar.a != null) {
                throw new IllegalStateException();
            } else {
                return this.a;
            }
        }
    }

    static class c<K, V> {

        private p.g<K, V> a;
        c() {
            super();
        }

        public p.g<K, V> a() {
            com.squareup.moshi.p.g gVar;
            com.squareup.moshi.p.g gVar3 = null;
            if (this.a == null) {
                return gVar3;
            }
            this.a.a = gVar3;
            while (gVar2.a != null) {
                gVar.a = gVar;
            }
            this.a = gVar;
            return this.a;
        }

        void b(p.g<K, V> gVar) {
            int gVar2 = 0;
            Object obj;
            gVar2 = 0;
            while (obj != null) {
                obj.a = gVar2;
                gVar2 = obj;
            }
            this.a = gVar2;
        }
    }

    final class d extends AbstractSet<Map.Entry<K, V>> {

        final /* synthetic */ p a;
        d() {
            this.a = pVar;
            super();
        }

        @Override // java.util.AbstractSet
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractSet
        public boolean contains(Object object) {
            boolean z;
            boolean z2 = false;
            z = object instanceof Map.Entry;
            if (object instanceof Map.Entry) {
                object = this.a.f(object) != null ? 1 : 0;
            }
            return (this.a.f(object) != null ? 1 : 0);
        }

        @Override // java.util.AbstractSet
        public Iterator<Map.Entry<K, V>> iterator() {
            return new p.d.a(this);
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            boolean z2 = false;
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            final com.squareup.moshi.p.g gVar = this.a.f(object);
            if (gVar == null) {
                return false;
            }
            boolean z3 = true;
            this.a.i(gVar, z3);
            return true;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this.a.size;
        }
    }

    final class e extends AbstractSet<K> {

        final /* synthetic */ p a;
        e() {
            this.a = pVar;
            super();
        }

        @Override // java.util.AbstractSet
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractSet
        public boolean contains(Object object) {
            return this.a.containsKey(object);
        }

        @Override // java.util.AbstractSet
        public Iterator<K> iterator() {
            return new p.e.a(this);
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            boolean z = true;
            object = this.a.j(object) != null ? 1 : 0;
            return (this.a.j(object) != null ? 1 : 0);
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this.a.size;
        }
    }

    abstract class f<T> implements Iterator<T> {

        p.g<K, V> a;
        p.g<K, V> b = null;
        int c;
        final /* synthetic */ p v;
        f() {
            this.v = pVar;
            super();
            this.a = pVar.header.v;
            this.c = pVar.modCount;
        }

        final p.g<K, V> b() {
            if (this.a == pVar.header) {
                throw new NoSuchElementException();
            } else {
                if (pVar.modCount != this.c) {
                    throw new ConcurrentModificationException();
                } else {
                    this.a = gVar.v;
                    this.b = this.a;
                    return this.a;
                }
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            boolean z = true;
            int r0 = this.a != this.v.header ? 1 : 0;
            return (this.a != this.v.header ? 1 : 0);
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.b == null) {
                throw new IllegalStateException();
            } else {
                this.v.i(this.b, true);
                this.b = null;
                this.c = this.v.modCount;
                return;
            }
        }
    }

    static final class g<K, V> implements Map.Entry<K, V> {

        int A;
        p.g<K, V> a;
        p.g<K, V> b;
        p.g<K, V> c;
        p.g<K, V> v;
        p.g<K, V> w;
        final K x;
        final int y;
        V z;
        g() {
            super();
            this.x = null;
            this.y = -1;
            this.w = this;
            this.v = this;
        }

        public p.g<K, V> a() {
            com.squareup.moshi.p.g gVar;
            Object obj;
            obj = this;
            while (this.b != null) {
                obj = gVar;
            }
            return obj;
        }

        public p.g<K, V> b() {
            com.squareup.moshi.p.g gVar;
            Object obj;
            obj = this;
            while (this.c != null) {
                obj = gVar;
            }
            return obj;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object object) {
            boolean z = false;
            Object key2;
            Object value;
            equals = object instanceof Map.Entry;
            int i = 0;
            if (object instanceof Map.Entry) {
                if (this.x == null) {
                    if (object.getKey() == null) {
                        if (this.z == null) {
                            if (object.getValue() == null) {
                                int i2 = 1;
                            }
                        }
                    }
                }
            }
            return z;
        }

        @Override // java.util.Map$Entry
        public K getKey() {
            return this.x;
        }

        @Override // java.util.Map$Entry
        public V getValue() {
            return this.z;
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            int i;
            i = 0;
            if (this.x == null) {
            } else {
                i = this.x.hashCode();
            }
            if (this.z != null) {
                i = this.z.hashCode();
            }
            return i ^ i;
        }

        @Override // java.util.Map$Entry
        public V setValue(V v) {
            this.z = v;
            return this.z;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "=";
            str = this.x + str2 + this.z;
            return str;
        }

        g(p.g<K, V> gVar, K k, int i, p.g<K, V> gVar2, p.g<K, V> gVar3) {
            super();
            this.a = gVar;
            this.x = k;
            this.y = i;
            this.A = 1;
            this.v = gVar2;
            this.w = gVar3;
            gVar3.v = this;
            gVar2.w = this;
        }
    }

    p() {
        this(null);
    }

    private void a() {
        com.squareup.moshi.p.g[] objArr = p.c(this.table);
        this.table = objArr;
        this.threshold = (objArr.length / 2) + (objArr.length / 4);
    }

    static <K, V> p.g<K, V>[] c(p.g<K, V>[] gVarArr) {
        int i;
        Object obj;
        int i2 = 0;
        int i3;
        com.squareup.moshi.p.g gVar;
        com.squareup.moshi.p.g gVar2;
        final int length = gVarArr.length;
        com.squareup.moshi.p.g[] arr = new p.g[length * 2];
        final com.squareup.moshi.p.c cVar = new p.c();
        final com.squareup.moshi.p.b bVar = new p.b();
        final com.squareup.moshi.p.b bVar2 = new p.b();
        i = 0;
        for (Object obj : gVarArr) {
        }
        return arr;
    }

    private boolean d(Object object, Object object2) {
        boolean z = false;
        if (object == object2 || object != null) {
            int i2 = 1;
        } else {
            if (!(object.equals(object2))) {
                int i = 0;
            }
        }
        return z;
    }

    private void h(p.g<K, V> gVar, boolean z) {
        int i = 0;
        while (gVar != null) {
            i = 0;
            int r3 = gVar.b != null ? gVar2.A : i;
            int r4 = gVar.c != null ? gVar3.A : i;
            i2 = i - (gVar.c != null ? gVar3.A : i);
            int i3 = -2;
            r3 = gVar3.c != null ? gVar6.A : i;
            if (z) {
                break;
            }
            i3 = 1;
            r3 = gVar2.c != null ? gVar5.A : i;
            i = i - i;
            if (z) {
                break;
            }
            i = i + 1;
            gVar.A = i;
            if (z) {
                break;
            }
            gVar.A = (Math.max(i, r4)) + i3;
            if (!z) {
                break;
            }
        }
    }

    private void k(p.g<K, V> gVar, p.g<K, V> gVar2) {
        gVar.a = null;
        if (gVar2 != null) {
            gVar2.a = gVar.a;
        }
        if (gVar.a == null) {
            i = gVar.y & (table2.length - 1);
            this.table[i] = gVar2;
        } else {
            if (gVar3.b == gVar) {
                gVar.a.b = gVar2;
            } else {
                gVar.a.c = gVar2;
            }
        }
    }

    private void l(p.g<K, V> gVar) {
        int i;
        gVar.c = gVar3.b;
        if (gVar3.b != null) {
            gVar3.b.a = gVar;
        }
        k(gVar, gVar.c);
        gVar.c.b = gVar;
        gVar.a = gVar.c;
        i = 0;
        int r0 = gVar.b != null ? gVar2.A : i;
        int r2 = gVar3.b != null ? gVar4.A : i;
        int i2 = (Math.max(gVar.b, (gVar3.b != null ? gVar4.A : i))) + 1;
        gVar.A = i2;
        if (gVar3.c != null) {
        }
        gVar.c.A = (Math.max(i2, i)) + 1;
    }

    private void m(p.g<K, V> gVar) {
        int i;
        gVar.b = gVar2.c;
        if (gVar2.c != null) {
            gVar2.c.a = gVar;
        }
        k(gVar, gVar.b);
        gVar.b.c = gVar;
        gVar.a = gVar.b;
        i = 0;
        int r1 = gVar.c != null ? gVar3.A : i;
        int r3 = gVar2.c != null ? gVar5.A : i;
        int i2 = (Math.max(gVar.c, (gVar2.c != null ? gVar5.A : i))) + 1;
        gVar.A = i2;
        if (gVar2.b != null) {
        }
        gVar.b.A = (Math.max(i2, i)) + 1;
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap
    public void clear() {
        com.squareup.moshi.p.g gVar;
        final Object obj = null;
        Arrays.fill(this.table, obj);
        this.size = 0;
        this.modCount++;
        while (header2.v != this.header) {
            gVar.w = obj;
            gVar.v = obj;
        }
        this.header.w = this.header;
        this.header.v = this.header;
    }

    @Override // java.util.AbstractMap
    public boolean containsKey(Object object) {
        boolean z = true;
        object = g(object) != null ? 1 : 0;
        return (g(object) != null ? 1 : 0);
    }

    @Override // java.util.AbstractMap
    p.g<K, V> e(K k, boolean z) {
        com.squareup.moshi.p.g gVar;
        int i;
        int compareTo;
        com.squareup.moshi.p.g z22;
        final int i6 = p.n(k.hashCode());
        final int i7 = 1;
        int i5 = (table2.length - i7) & i6;
        i = 0;
        if (table2[i5] != null && this.comparator == p.a) {
            Object k2 = k;
            while (p.a != 0) {
                compareTo = i.compareTo(gVar.x);
                com.squareup.moshi.p.g r8 = gVar.x < 0 ? gVar.b : gVar.c;
                compareTo = this.comparator.compare(k, gVar.x);
            }
            return gVar;
        }
        compareTo = 0;
        if (!z) {
            return null;
        }
        if (gVar == null) {
            if (this.comparator == p.a) {
                if (!(k instanceof Comparable)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String name = k.getClass().getName();
                    String str = " is not Comparable";
                    k = name + str;
                    throw new ClassCastException(k);
                }
            }
            z22 = new p.g(gVar, k, i6, header2, header2.w);
            this.table[i5] = z22;
        } else {
            z22 = new p.g(gVar, k, i6, header2, header2.w);
            if (compareTo < 0) {
                gVar.b = z22;
            } else {
                gVar.c = z22;
            }
            h(gVar, true);
        }
        this.size++;
        if (this.size > this.threshold) {
            a();
        }
        this.modCount += i7;
        return z22;
    }

    @Override // java.util.AbstractMap
    public Set<Map.Entry<K, V>> entrySet() {
        com.squareup.moshi.p.d dVar;
        if (this.entrySet == null) {
            this.entrySet = new p.d(this);
        }
        return dVar;
    }

    @Override // java.util.AbstractMap
    p.g<K, V> f(Map.Entry<?, ?> entry) {
        int i = 0;
        Object obj;
        int i2 = 0;
        com.squareup.moshi.p.g gVar = g(entry.getKey());
        if (gVar != null) {
            entry = d(gVar.z, entry.getValue()) ? 1 : 0;
        }
        if (i2 == 0) {
            i = 0;
        }
        return i;
    }

    @Override // java.util.AbstractMap
    p.g<K, V> g(Object object) {
        int i = 0;
        if (object != null) {
            try {
                com.squareup.moshi.p.g gVar = e(object, false);
            } catch (java.lang.ClassCastException unused) {
                return i;
            }
        }
    }

    @Override // java.util.AbstractMap
    public V get(Object object) {
        Object obj = null;
        com.squareup.moshi.p.g gVar = g(object);
        object = gVar != null ? gVar.z : 0;
        return (gVar != null ? gVar.z : 0);
    }

    @Override // java.util.AbstractMap
    void i(p.g<K, V> gVar, boolean z) {
        int i;
        int i2 = 0;
        com.squareup.moshi.p.g gVar4;
        com.squareup.moshi.p.g gVar5 = null;
        if (z) {
            gVar.w.v = gVar.v;
            gVar.v.w = gVar.w;
            gVar.w = gVar5;
            gVar.v = gVar5;
        }
        z = false;
        if (gVar.b != null && gVar.c != null) {
            if (gVar11.A > gVar7.A) {
                gVar4 = gVar.b.b();
            } else {
                gVar4 = gVar.c.a();
            }
            i(gVar4, z);
            if (gVar.b != null) {
                gVar4.b = gVar.b;
                gVar.b.a = gVar4;
                gVar.b = gVar5;
            } else {
            }
            if (gVar.c != null) {
                gVar4.c = gVar.c;
                gVar.c.a = gVar4;
                gVar.c = gVar5;
            }
            gVar4.A = (Math.max(i, i2)) + 1;
            k(gVar, gVar4);
            return;
        }
        if (gVar.b != null) {
            k(gVar, gVar.b);
            gVar.b = gVar5;
        } else {
            if (gVar.c != null) {
                k(gVar, gVar.c);
                gVar.c = gVar5;
            } else {
                k(gVar, gVar5);
            }
        }
        h(gVar.a, z);
        this.size--;
        this.modCount++;
    }

    @Override // java.util.AbstractMap
    p.g<K, V> j(Object object) {
        final com.squareup.moshi.p.g gVar = g(object);
        if (gVar != null) {
            boolean z = true;
            i(gVar, z);
        }
        return gVar;
    }

    @Override // java.util.AbstractMap
    public Set<K> keySet() {
        com.squareup.moshi.p.e eVar;
        if (this.keySet == null) {
            this.keySet = new p.e(this);
        }
        return eVar;
    }

    @Override // java.util.AbstractMap
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        final com.squareup.moshi.p.g gVar = e(k, true);
        gVar.z = v;
        return gVar.z;
    }

    @Override // java.util.AbstractMap
    public V remove(Object object) {
        Object obj = null;
        com.squareup.moshi.p.g gVar = j(object);
        object = gVar != null ? gVar.z : 0;
        return (gVar != null ? gVar.z : 0);
    }

    @Override // java.util.AbstractMap
    public int size() {
        return this.size;
    }

    p(Comparator<? super K> comparator) {
        Comparator comparator2;
        super();
        int i = 0;
        this.size = i;
        this.modCount = i;
        if (comparator == null) {
            comparator2 = p.a;
        }
        this.comparator = comparator2;
        this.header = new p.g();
        com.squareup.moshi.p.g[] arr = new p.g[16];
        this.table = arr;
        this.threshold = (arr.length / 2) + (arr.length / 4);
    }

    private static int n(int i) {
        i ^= i3;
        return (i7 >>> 4) ^ (i7 >>> 7) ^ i7;
    }
}
