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

/* loaded from: classes2.dex */
final class p<K, V>  extends AbstractMap<K, V> implements Serializable {

    private static final Comparator<Comparable> a;
    Comparator<? super K> comparator;
    private com.squareup.moshi.p.d<K, V> entrySet;
    final com.squareup.moshi.p.g<K, V> header;
    private com.squareup.moshi.p.e<K, V> keySet;
    int modCount;
    int size;
    com.squareup.moshi.p.g<K, V>[] table;
    int threshold;

    class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public int a(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((Comparable)object, (Comparable)object2);
        }
    }

    static final class b {

        private com.squareup.moshi.p.g<K, V> a;
        private int b;
        private int c;
        private int d;
        void a(com.squareup.moshi.p.g<K, V> p$g) {
            int i5;
            int i3;
            int i2;
            int i;
            int i4;
            int obj6;
            int i6 = 0;
            g.c = i6;
            g.a = i6;
            g.b = i6;
            int i7 = 1;
            g.A = i7;
            i5 = this.b;
            i2 = this.d;
            if (i5 > 0 && i2 & 1 == 0) {
                i2 = this.d;
                if (i2 & 1 == 0) {
                    this.d = i2 += i7;
                    this.b = i5 -= i7;
                    this.c = i11 += i7;
                }
            }
            g.a = this.a;
            this.a = g;
            obj6 += i7;
            this.d = obj6;
            i3 = this.b;
            if (i3 > 0 && obj6 & 1 == 0) {
                if (obj6 & 1 == 0) {
                    this.d = obj6 += i7;
                    this.b = i3 -= i7;
                    this.c = obj6 += i7;
                }
            }
            obj6 = 4;
            int i12 = obj6 + -1;
            while (i8 &= i12 == i12) {
                i3 = this.c;
                if (i3 == 0) {
                } else {
                }
                i2 = 0;
                if (i3 == i7) {
                } else {
                }
                if (i3 == 2) {
                }
                obj6 *= 2;
                i12 = obj6 + -1;
                this.c = i2;
                i3 = this.a;
                i = i3.a;
                this.a = i;
                i.c = i3;
                i.A = i14 += i7;
                i3.a = i;
                this.c = i2;
                i3 = this.a;
                i2 = i3.a;
                i = i2.a;
                i2.a = i.a;
                this.a = i2;
                i2.b = i;
                i2.c = i3;
                i2.A = i13 += i7;
                i.a = i2;
                i3.a = i2;
            }
        }

        void b(int i) {
            this.b = i3 -= i;
            int obj2 = 0;
            this.d = obj2;
            this.c = obj2;
            this.a = 0;
        }

        com.squareup.moshi.p.g<K, V> c() {
            com.squareup.moshi.p.g gVar = this.a;
            if (gVar.a != null) {
            } else {
                return gVar;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
    }

    static class c {

        private com.squareup.moshi.p.g<K, V> a;
        public com.squareup.moshi.p.g<K, V> a() {
            com.squareup.moshi.p.g gVar2;
            com.squareup.moshi.p.g gVar3;
            com.squareup.moshi.p.g gVar;
            final com.squareup.moshi.p.g gVar4 = this.a;
            int i = 0;
            if (gVar4 == null) {
                return i;
            }
            gVar3 = gVar4.a;
            gVar4.a = i;
            gVar2 = gVar4.c;
            gVar3 = gVar2;
            com.squareup.moshi.p.g gVar5 = gVar;
            while (gVar3 != null) {
                gVar3.a = gVar5;
                gVar2 = gVar3.b;
                gVar3 = gVar2;
                gVar5 = gVar;
            }
            this.a = gVar5;
            return gVar4;
        }

        void b(com.squareup.moshi.p.g<K, V> p$g) {
            int i;
            com.squareup.moshi.p.g gVar;
            Object obj3;
            i = 0;
            while (obj3 != null) {
                obj3.a = i;
                i = obj3;
                obj3 = gVar;
            }
            this.a = i;
        }
    }

    final class d extends AbstractSet<Map.Entry<K, V>> {

        final com.squareup.moshi.p a;
        d(com.squareup.moshi.p p) {
            this.a = p;
            super();
        }

        @Override // java.util.AbstractSet
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractSet
        public boolean contains(Object object) {
            boolean z;
            Object obj2;
            if (object instanceof Map.Entry && this.a.f((Map.Entry)object) != null) {
                obj2 = this.a.f((Map.Entry)object) != null ? 1 : 0;
            } else {
            }
            return obj2;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            p.d.a aVar = new p.d.a(this);
            return aVar;
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            int i = 0;
            if (!object instanceof Map.Entry) {
                return i;
            }
            final com.squareup.moshi.p.g obj3 = this.a.f((Map.Entry)object);
            if (obj3 == null) {
                return i;
            }
            int i2 = 1;
            this.a.i(obj3, i2);
            return i2;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return pVar.size;
        }
    }

    final class e extends AbstractSet<K> {

        final com.squareup.moshi.p a;
        e(com.squareup.moshi.p p) {
            this.a = p;
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

        public Iterator<K> iterator() {
            p.e.a aVar = new p.e.a(this);
            return aVar;
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            int obj2;
            obj2 = this.a.j(object) != null ? 1 : 0;
            return obj2;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return pVar.size;
        }
    }

    abstract class f implements Iterator<T> {

        com.squareup.moshi.p.g<K, V> a;
        com.squareup.moshi.p.g<K, V> b = null;
        int c;
        final com.squareup.moshi.p v;
        f(com.squareup.moshi.p p) {
            this.v = p;
            super();
            this.a = header.v;
            int i = 0;
            this.c = p.modCount;
        }

        final com.squareup.moshi.p.g<K, V> b() {
            com.squareup.moshi.p.g gVar = this.a;
            com.squareup.moshi.p pVar = this.v;
            if (gVar == pVar.header) {
            } else {
                if (pVar.modCount != this.c) {
                } else {
                    this.a = gVar.v;
                    this.b = gVar;
                    return gVar;
                }
                ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
                throw concurrentModificationException;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i;
            i = this.a != pVar.header ? 1 : 0;
            return i;
        }

        @Override // java.util.Iterator
        public final void remove() {
            com.squareup.moshi.p.g gVar = this.b;
            if (gVar == null) {
            } else {
                this.v.i(gVar, true);
                this.b = 0;
                this.c = pVar.modCount;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
    }

    static final class g implements Map.Entry<K, V> {

        int A;
        com.squareup.moshi.p.g<K, V> a;
        com.squareup.moshi.p.g<K, V> b;
        com.squareup.moshi.p.g<K, V> c;
        com.squareup.moshi.p.g<K, V> v;
        com.squareup.moshi.p.g<K, V> w;
        final K x;
        final int y;
        V z;
        g() {
            super();
            this.x = 0;
            this.y = -1;
            this.w = this;
            this.v = this;
        }

        g(com.squareup.moshi.p.g<K, V> p$g, K k2, int i3, com.squareup.moshi.p.g<K, V> p$g4, com.squareup.moshi.p.g<K, V> p$g5) {
            super();
            this.a = g;
            this.x = k2;
            this.y = i3;
            this.A = 1;
            this.v = g4;
            this.w = g5;
            g5.v = this;
            g4.w = this;
        }

        public com.squareup.moshi.p.g<K, V> a() {
            com.squareup.moshi.p.g gVar2;
            Object obj;
            com.squareup.moshi.p.g gVar;
            gVar2 = this.b;
            obj = this;
            while (gVar2 != null) {
                obj = gVar2;
                gVar2 = gVar;
            }
            return obj;
        }

        public com.squareup.moshi.p.g<K, V> b() {
            com.squareup.moshi.p.g gVar2;
            Object obj;
            com.squareup.moshi.p.g gVar;
            gVar2 = this.c;
            obj = this;
            while (gVar2 != null) {
                obj = gVar2;
                gVar2 = gVar;
            }
            return obj;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object object) {
            boolean equals;
            int i;
            Object key;
            Object obj4;
            i = 0;
            if (object instanceof Map.Entry) {
                Object obj = this.x;
                if (obj == null) {
                    if ((Map.Entry)object.getKey() == null) {
                        equals = this.z;
                        if (equals == null) {
                            if (object.getValue() == null) {
                                i = 1;
                            }
                        } else {
                            if (equals.equals(object.getValue())) {
                            }
                        }
                    }
                } else {
                    if (obj.equals(object.getKey())) {
                    }
                }
            }
            return i;
        }

        public K getKey() {
            return this.x;
        }

        public V getValue() {
            return this.z;
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            int i;
            int i2;
            Object obj = this.x;
            if (obj == null) {
                i = i2;
            } else {
                i = obj.hashCode();
            }
            final Object obj2 = this.z;
            if (obj2 == null) {
            } else {
                i2 = obj2.hashCode();
            }
            return i ^= i2;
        }

        public V setValue(V v) {
            this.z = v;
            return this.z;
        }

        @Override // java.util.Map$Entry
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.x);
            stringBuilder.append("=");
            stringBuilder.append(this.z);
            return stringBuilder.toString();
        }
    }
    static {
        Class<com.squareup.moshi.p> obj = p.class;
        p.a aVar = new p.a();
        p.a = aVar;
    }

    p() {
        super(0);
    }

    p(Comparator<? super K> comparator) {
        Comparator obj2;
        super();
        int i = 0;
        this.size = i;
        this.modCount = i;
        if (comparator != null) {
        } else {
            obj2 = p.a;
        }
        this.comparator = obj2;
        obj2 = new p.g();
        this.header = obj2;
        obj2 = new p.g[16];
        this.table = obj2;
        this.threshold = i2 += obj2;
    }

    private void a() {
        com.squareup.moshi.p.g[] objArr = p.c(this.table);
        this.table = objArr;
        this.threshold = i2 += i;
    }

    static <K, V> com.squareup.moshi.p.g<K, V>[] c(com.squareup.moshi.p.g<K, V>[] p$gArr) {
        int i;
        Object obj;
        int i3;
        int i2;
        com.squareup.moshi.p.g gVar;
        int i4;
        com.squareup.moshi.p.g gVar2;
        final int length = gArr.length;
        com.squareup.moshi.p.g[] arr = new p.g[length * 2];
        p.c cVar = new p.c();
        p.b bVar = new p.b();
        p.b bVar2 = new p.b();
        final int i6 = 0;
        i = i6;
        while (i < length) {
            obj = gArr[i];
            if (obj == null) {
            } else {
            }
            cVar.b(obj);
            i4 = i2;
            gVar2 = cVar.a();
            while (gVar2 != null) {
                if (i7 &= length == 0) {
                } else {
                }
                i4++;
                gVar2 = cVar.a();
                i2++;
            }
            bVar.b(i2);
            bVar2.b(i4);
            cVar.b(obj);
            obj = cVar.a();
            while (obj != null) {
                if (i8 &= length == null) {
                } else {
                }
                bVar2.a(obj);
                obj = cVar.a();
                bVar.a(obj);
            }
            if (i2 > 0) {
            } else {
            }
            gVar = obj;
            arr[i] = gVar;
            if (i4 > 0) {
            }
            arr[i + length] = obj;
            i++;
            obj = bVar2.c();
            gVar = bVar.c();
            if (i8 &= length == null) {
            } else {
            }
            bVar2.a(obj);
            bVar.a(obj);
            if (i7 &= length == 0) {
            } else {
            }
            i4++;
            i2++;
        }
        return arr;
    }

    private boolean d(Object object, Object object2) {
        boolean obj1;
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private void h(com.squareup.moshi.p.g<K, V> p$g, boolean z2) {
        com.squareup.moshi.p.g gVar;
        com.squareup.moshi.p.g gVar2;
        int i4;
        int i;
        int i3;
        int i5;
        int i2;
        while (g != null) {
            gVar = g.b;
            gVar2 = g.c;
            i4 = 0;
            if (gVar != null) {
            } else {
            }
            i = i4;
            if (gVar2 != null) {
            } else {
            }
            i3 = i4;
            i5 = i - i3;
            i2 = 1;
            g.A = i6 += i2;
            final com.squareup.moshi.p.g obj8 = g.a;
            g.A = i++;
            gVar2 = gVar.b;
            com.squareup.moshi.p.g gVar4 = gVar.c;
            if (gVar4 != null) {
            } else {
            }
            i = i4;
            if (gVar2 != null) {
            }
            i4 -= i;
            if (i4 != i2) {
            } else {
            }
            m(g);
            if (i4 == 0 && !z2) {
            } else {
            }
            l(gVar);
            m(g);
            if (!z2) {
            } else {
            }
            i4 = gVar2.A;
            i = gVar4.A;
            com.squareup.moshi.p.g gVar3 = gVar2.b;
            com.squareup.moshi.p.g gVar5 = gVar2.c;
            if (gVar5 != null) {
            } else {
            }
            i = i4;
            if (gVar3 != null) {
            }
            i4 -= i;
            if (i4 != -1) {
            } else {
            }
            l(g);
            if (i4 == 0 && !z2) {
            } else {
            }
            m(gVar2);
            l(g);
            if (!z2) {
            } else {
            }
            i4 = gVar3.A;
            i = gVar5.A;
            i3 = gVar2.A;
            i = gVar.A;
        }
    }

    private void k(com.squareup.moshi.p.g<K, V> p$g, com.squareup.moshi.p.g<K, V> p$g2) {
        com.squareup.moshi.p.g table;
        com.squareup.moshi.p.g gVar;
        Object obj3;
        table = g.a;
        g.a = 0;
        if (g2 != null) {
            g2.a = table;
        }
        if (table != null) {
            if (table.b == g) {
                table.b = g2;
            } else {
                table.c = g2;
            }
        } else {
            table = this.table;
            table[obj3 &= gVar] = g2;
        }
    }

    private void l(com.squareup.moshi.p.g<K, V> p$g) {
        int i3;
        int i;
        int i2;
        com.squareup.moshi.p.g gVar = g.b;
        final com.squareup.moshi.p.g gVar2 = g.c;
        com.squareup.moshi.p.g gVar3 = gVar2.b;
        final com.squareup.moshi.p.g gVar4 = gVar2.c;
        g.c = gVar3;
        if (gVar3 != null) {
            gVar3.a = g;
        }
        k(g, gVar2);
        gVar2.b = g;
        g.a = gVar2;
        i2 = 0;
        i3 = gVar != null ? gVar.A : i2;
        i = gVar3 != null ? gVar3.A : i2;
        i4++;
        g.A = i5;
        if (gVar4 != null) {
            i2 = gVar4.A;
        }
        gVar2.A = obj6++;
    }

    private void m(com.squareup.moshi.p.g<K, V> p$g) {
        int i3;
        int i;
        int i2;
        final com.squareup.moshi.p.g gVar = g.b;
        com.squareup.moshi.p.g gVar2 = g.c;
        final com.squareup.moshi.p.g gVar3 = gVar.b;
        com.squareup.moshi.p.g gVar4 = gVar.c;
        g.b = gVar4;
        if (gVar4 != null) {
            gVar4.a = g;
        }
        k(g, gVar);
        gVar.c = g;
        g.a = gVar;
        i2 = 0;
        i3 = gVar2 != null ? gVar2.A : i2;
        i = gVar4 != null ? gVar4.A : i2;
        i4++;
        g.A = i5;
        if (gVar3 != null) {
            i2 = gVar3.A;
        }
        gVar.A = obj6++;
    }

    private static int n(int i) {
        i ^= i3;
        return obj2 ^= i5;
    }

    private Object writeReplace() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this);
        return linkedHashMap;
    }

    @Override // java.util.AbstractMap
    public void clear() {
        com.squareup.moshi.p.g gVar2;
        com.squareup.moshi.p.g gVar;
        final int i3 = 0;
        Arrays.fill(this.table, i3);
        this.size = 0;
        this.modCount = modCount++;
        com.squareup.moshi.p.g header = this.header;
        gVar2 = header.v;
        while (gVar2 != header) {
            gVar2.w = i3;
            gVar2.v = i3;
            gVar2 = gVar;
        }
        header.w = header;
        header.v = header;
    }

    @Override // java.util.AbstractMap
    public boolean containsKey(Object object) {
        int obj1;
        obj1 = g(object) != null ? 1 : 0;
        return obj1;
    }

    com.squareup.moshi.p.g<K, V> e(K k, boolean z2) {
        com.squareup.moshi.p.g gVar;
        com.squareup.moshi.p.g gVar2;
        com.squareup.moshi.p.g gVar4;
        int i;
        Object obj;
        int compareTo;
        com.squareup.moshi.p.g gVar5;
        com.squareup.moshi.p.g gVar3;
        com.squareup.moshi.p.g obj14;
        Comparator comparator = this.comparator;
        final com.squareup.moshi.p.g[] table = this.table;
        final int i7 = p.n(k.hashCode());
        final int i8 = 1;
        i4 &= i7;
        int i6 = 0;
        if (table[i5] != null) {
            if (comparator == p.a) {
                i = k;
            } else {
                i = i6;
            }
            while (i != 0) {
                compareTo = i.compareTo(gVar.x);
                if (compareTo < 0) {
                } else {
                }
                gVar5 = gVar.c;
                gVar = gVar5;
                compareTo = comparator.compare(k, gVar.x);
                gVar5 = gVar.b;
            }
            return gVar;
        }
        compareTo = 0;
        final com.squareup.moshi.p.g gVar6 = gVar;
        if (!z2) {
            return i6;
        }
        com.squareup.moshi.p.g header = this.header;
        if (gVar6 == null) {
            if (comparator == p.a) {
                if (!k instanceof Comparable) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(k.getClass().getName());
                stringBuilder.append(" is not Comparable");
                obj14 = new ClassCastException(stringBuilder.toString());
                throw obj14;
            }
            super(gVar6, k, i7, header, header.w);
            table[i5] = obj14;
        } else {
            super(gVar6, k, i7, header, header.w);
            if (compareTo < 0) {
                gVar6.b = obj14;
            } else {
                gVar6.c = obj14;
            }
            h(gVar6, i8);
        }
        int obj13 = this.size;
        this.size = obj13 + 1;
        if (obj13 > this.threshold) {
            a();
        }
        this.modCount = obj13 += i8;
        return obj14;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        com.squareup.moshi.p.d entrySet;
        if (this.entrySet != null) {
        } else {
            entrySet = new p.d(this);
            this.entrySet = entrySet;
        }
        return entrySet;
    }

    com.squareup.moshi.p.g<K, V> f(Map.Entry<?, ?> map$Entry) {
        int gVar;
        Object obj;
        boolean obj3;
        gVar = g(entry.getKey());
        if (gVar != null && d(gVar.z, entry.getValue())) {
            obj3 = d(gVar.z, entry.getValue()) ? 1 : 0;
        } else {
        }
        if (obj3 != null) {
        } else {
            gVar = 0;
        }
        return gVar;
    }

    com.squareup.moshi.p.g<K, V> g(Object object) {
        int i;
        int i2;
        i = 0;
        if (object != null) {
            i = e(object, false);
        }
        return i;
    }

    public V get(Object object) {
        Object obj1;
        obj1 = g(object);
        obj1 = obj1 != null ? obj1.z : 0;
        return obj1;
    }

    void i(com.squareup.moshi.p.g<K, V> p$g, boolean z2) {
        com.squareup.moshi.p.g gVar;
        int i2;
        int i;
        com.squareup.moshi.p.g obj7;
        int i3 = 0;
        if (z2 != null) {
            obj7 = g.w;
            obj7.v = g.v;
            gVar.w = obj7;
            g.w = i3;
            g.v = i3;
        }
        obj7 = g.b;
        com.squareup.moshi.p.g gVar3 = g.c;
        i = 0;
        if (obj7 != null && gVar3 != null) {
            if (gVar3 != null) {
                if (obj7.A > gVar3.A) {
                    obj7 = obj7.b();
                } else {
                    obj7 = gVar3.a();
                }
                i(obj7, i);
                com.squareup.moshi.p.g gVar4 = g.b;
                if (gVar4 != null) {
                    i2 = gVar4.A;
                    obj7.b = gVar4;
                    gVar4.a = obj7;
                    g.b = i3;
                } else {
                    i2 = i;
                }
                com.squareup.moshi.p.g gVar5 = g.c;
                if (gVar5 != null) {
                    i = gVar5.A;
                    obj7.c = gVar5;
                    gVar5.a = obj7;
                    g.c = i3;
                }
                obj7.A = i4++;
                k(g, obj7);
            }
        }
        if (obj7 != null) {
            k(g, obj7);
            g.b = i3;
        } else {
            if (gVar3 != null) {
                k(g, gVar3);
                g.c = i3;
            } else {
                k(g, i3);
            }
        }
        h(g.a, i);
        this.size = obj6--;
        this.modCount = obj6++;
    }

    com.squareup.moshi.p.g<K, V> j(Object object) {
        int i;
        final com.squareup.moshi.p.g obj2 = g(object);
        if (obj2 != null) {
            i(obj2, true);
        }
        return obj2;
    }

    public Set<K> keySet() {
        com.squareup.moshi.p.e keySet;
        if (this.keySet != null) {
        } else {
            keySet = new p.e(this);
            this.keySet = keySet;
        }
        return keySet;
    }

    public V put(K k, V v2) {
        Objects.requireNonNull(k, "key == null");
        final com.squareup.moshi.p.g obj2 = e(k, true);
        obj2.z = v2;
        return obj2.z;
    }

    public V remove(Object object) {
        Object obj1;
        obj1 = j(object);
        obj1 = obj1 != null ? obj1.z : 0;
        return obj1;
    }

    @Override // java.util.AbstractMap
    public int size() {
        return this.size;
    }
}
