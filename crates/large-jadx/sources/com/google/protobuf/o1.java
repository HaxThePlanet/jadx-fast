package com.google.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes2.dex */
class o1<K extends Comparable<K>, V>  extends AbstractMap<K, V> {

    private final int a;
    private List<com.google.protobuf.o1.e<K, V>> b;
    private Map<K, V> c;
    private boolean v;
    private volatile com.google.protobuf.o1.g<K, V> w;
    private Map<K, V> x;
    private volatile com.google.protobuf.o1.c<K, V> y;

    private class b implements Iterator<Map.Entry<K, V>> {

        private int a;
        private Iterator<Map.Entry<K, V>> b;
        final com.google.protobuf.o1 c;
        private b(com.google.protobuf.o1 o1) {
            this.c = o1;
            super();
            this.a = o1.c(o1).size();
        }

        b(com.google.protobuf.o1 o1, com.google.protobuf.o1.a o1$a2) {
            super(o1);
        }

        private Iterator<Map.Entry<K, V>> b() {
            Iterator iterator;
            if (this.b == null) {
                this.b = o1.f(this.c).entrySet().iterator();
            }
            return this.b;
        }

        public Map.Entry<K, V> c() {
            if (b().hasNext()) {
                return (Map.Entry)b().next();
            }
            i--;
            this.a = i2;
            return (Map.Entry)o1.c(this.c).get(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int next;
            int i;
            int size;
            next = this.a;
            if (next > 0) {
                if (next > o1.c(this.c).size()) {
                    i = b().hasNext() ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }

    private static class d {

        private static final Iterator<Object> a;
        private static final Iterable<Object> b;
        static {
            o1.d.a aVar = new o1.d.a();
            o1.d.a = aVar;
            o1.d.b bVar = new o1.d.b();
            o1.d.b = bVar;
        }

        static Iterator a() {
            return o1.d.a;
        }

        static <T> Iterable<T> b() {
            return o1.d.b;
        }
    }

    private class e implements Map.Entry<K, V>, Comparable<com.google.protobuf.o1.e<K, V>> {

        private final K a;
        private V b;
        final com.google.protobuf.o1 c;
        e(com.google.protobuf.o1 o1, Comparable comparable2, Object object3) {
            this.c = o1;
            super();
            this.a = comparable2;
            this.b = object3;
        }

        e(com.google.protobuf.o1 o1, Map.Entry map$Entry2) {
            super(o1, (Comparable)entry2.getKey(), entry2.getValue());
        }

        private boolean c(Object object, Object object2) {
            int obj1;
            if (object == null) {
                obj1 = object2 == null ? 1 : 0;
            } else {
                obj1 = object.equals(object2);
            }
            return obj1;
        }

        public int a(com.google.protobuf.o1.e<K, V> o1.e) {
            return e().compareTo(o1.e.e());
        }

        @Override // java.util.Map$Entry
        public int compareTo(Object object) {
            return a((o1.e)object);
        }

        public K e() {
            return this.a;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object object) {
            int i;
            boolean z;
            Object obj5;
            if (object == this) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof Map.Entry) {
                return i2;
            }
            if (c(this.a, (Map.Entry)object.getKey()) && c(this.b, object.getValue())) {
                if (c(this.b, object.getValue())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        @Override // java.util.Map$Entry
        public Object getKey() {
            return e();
        }

        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            int i;
            int i2;
            Comparable comparable = this.a;
            if (comparable == null) {
                i = i2;
            } else {
                i = comparable.hashCode();
            }
            final Object obj = this.b;
            if (obj == null) {
            } else {
                i2 = obj.hashCode();
            }
            return i ^= i2;
        }

        public V setValue(V v) {
            o1.a(this.c);
            this.b = v;
            return this.b;
        }

        @Override // java.util.Map$Entry
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("=");
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }
    }

    private class f implements Iterator<Map.Entry<K, V>> {

        private int a;
        private boolean b;
        private Iterator<Map.Entry<K, V>> c;
        final com.google.protobuf.o1 v;
        private f(com.google.protobuf.o1 o1) {
            this.v = o1;
            super();
            this.a = -1;
        }

        f(com.google.protobuf.o1 o1, com.google.protobuf.o1.a o1$a2) {
            super(o1);
        }

        private Iterator<Map.Entry<K, V>> b() {
            Iterator iterator;
            if (this.c == null) {
                this.c = o1.d(this.v).entrySet().iterator();
            }
            return this.c;
        }

        public Map.Entry<K, V> c() {
            int i = 1;
            this.b = i;
            i2 += i;
            this.a = i3;
            if (i3 < o1.c(this.v).size()) {
                return (Map.Entry)o1.c(this.v).get(this.a);
            }
            return (Map.Entry)b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean empty;
            int i;
            if (i2 += i >= o1.c(this.v).size()) {
                if (!o1.d(this.v).isEmpty() && b().hasNext()) {
                    if (b().hasNext()) {
                    } else {
                        i = 0;
                    }
                } else {
                }
            }
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }

        @Override // java.util.Iterator
        public void remove() {
            Object it;
            int size;
            int i;
            if (!this.b) {
            } else {
                this.b = false;
                o1.a(this.v);
                if (this.a < o1.c(this.v).size()) {
                    size = this.a;
                    this.a = size + -1;
                    o1.e(this.v, size);
                } else {
                    b().remove();
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
            throw illegalStateException;
        }
    }

    private class g extends AbstractSet<Map.Entry<K, V>> {

        final com.google.protobuf.o1 a;
        private g(com.google.protobuf.o1 o1) {
            this.a = o1;
            super();
        }

        g(com.google.protobuf.o1 o1, com.google.protobuf.o1.a o1$a2) {
            super(o1);
        }

        @Override // java.util.AbstractSet
        public boolean add(Object object) {
            return b((Map.Entry)object);
        }

        public boolean b(Map.Entry<K, V> map$Entry) {
            if (!contains(entry)) {
                this.a.s((Comparable)entry.getKey(), entry.getValue());
                return 1;
            }
            return 0;
        }

        @Override // java.util.AbstractSet
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractSet
        public boolean contains(Object object) {
            Object obj3;
            Object obj = this.a.get((Map.Entry)object.getKey());
            obj3 = object.getValue();
            if (obj != obj3) {
                if (obj != null && obj.equals(obj3)) {
                    if (obj.equals(obj3)) {
                        obj3 = 1;
                    } else {
                        obj3 = 0;
                    }
                } else {
                }
            } else {
            }
            return obj3;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            o1.f fVar = new o1.f(this.a, 0);
            return fVar;
        }

        @Override // java.util.AbstractSet
        public boolean remove(Object object) {
            if (contains((Map.Entry)object)) {
                this.a.remove(object.getKey());
                return 1;
            }
            return 0;
        }

        @Override // java.util.AbstractSet
        public int size() {
            return this.a.size();
        }
    }

    static class a extends com.google.protobuf.o1<FieldDescriptorType, Object> {
        a(int i) {
            super(i, 0);
        }

        @Override // com.google.protobuf.o1
        public Object put(Object object, Object object2) {
            return super.s((v.b)object, object2);
        }

        @Override // com.google.protobuf.o1
        public void q() {
            boolean iterator;
            int i;
            boolean next;
            int next2;
            boolean unmodifiableList;
            if (!p()) {
                i = 0;
                while (i < l()) {
                    next = k(i);
                    if ((v.b)next.getKey().b()) {
                    }
                    i++;
                    next.setValue(Collections.unmodifiableList((List)next.getValue()));
                }
                iterator = n().iterator();
                while (iterator.hasNext()) {
                    next2 = iterator.next();
                    if ((v.b)(Map.Entry)next2.getKey().b()) {
                    }
                    next2.setValue(Collections.unmodifiableList((List)next2.getValue()));
                }
            }
            super.q();
        }
    }

    private class c extends com.google.protobuf.o1.g<K, V> {

        final com.google.protobuf.o1 b;
        private c(com.google.protobuf.o1 o1) {
            this.b = o1;
            super(o1, 0);
        }

        c(com.google.protobuf.o1 o1, com.google.protobuf.o1.a o1$a2) {
            super(o1);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            o1.b bVar = new o1.b(this.b, 0);
            return bVar;
        }
    }
    private o1(int i) {
        super();
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.x = Collections.emptyMap();
    }

    o1(int i, com.google.protobuf.o1.a o1$a2) {
        super(i);
    }

    static void a(com.google.protobuf.o1 o1) {
        o1.h();
    }

    static List c(com.google.protobuf.o1 o1) {
        return o1.b;
    }

    static Map d(com.google.protobuf.o1 o1) {
        return o1.c;
    }

    static Object e(com.google.protobuf.o1 o1, int i2) {
        return o1.t(i2);
    }

    static Map f(com.google.protobuf.o1 o1) {
        return o1.x;
    }

    private int g(K k) {
        int i;
        int compareTo;
        int i2;
        int i3;
        int compareTo2;
        size--;
        compareTo = k.compareTo((o1.e)this.b.get(i).e());
        if (i >= 0 && compareTo > 0) {
            compareTo = k.compareTo((o1.e)this.b.get(i).e());
            if (compareTo > 0) {
                return -i4;
            }
            if (compareTo == 0) {
                return i;
            }
        }
        i2 = 0;
        while (i2 <= i) {
            i6 /= 2;
            compareTo2 = k.compareTo((o1.e)this.b.get(i7).e());
            i2 = i3;
            i = i3;
        }
        return -i5;
    }

    private void h() {
        if (this.v) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private void j() {
        boolean arrayList;
        int i;
        h();
        if (this.b.isEmpty() && list2 instanceof ArrayList == null) {
            if (list2 instanceof ArrayList == null) {
                arrayList = new ArrayList(this.a);
                this.b = arrayList;
            }
        }
    }

    private SortedMap<K, V> o() {
        boolean descendingMap;
        h();
        if (this.c.isEmpty() && map3 instanceof TreeMap == null) {
            if (map3 instanceof TreeMap == null) {
                TreeMap treeMap = new TreeMap();
                this.c = treeMap;
                this.x = (TreeMap)treeMap.descendingMap();
            }
        }
        return (SortedMap)this.c;
    }

    static <FieldDescriptorType extends com.google.protobuf.v.b<FieldDescriptorType>> com.google.protobuf.o1<FieldDescriptorType, Object> r(int i) {
        o1.a aVar = new o1.a(i);
        return aVar;
    }

    private V t(int i) {
        boolean iterator;
        List list;
        com.google.protobuf.o1.e eVar;
        Object next;
        h();
        if (!this.c.isEmpty()) {
            iterator = o().entrySet().iterator();
            eVar = new o1.e(this, (Map.Entry)iterator.next());
            this.b.add(eVar);
            iterator.remove();
        }
        return (o1.e)this.b.remove(i).getValue();
    }

    @Override // java.util.AbstractMap
    public void clear() {
        boolean empty2;
        boolean empty;
        h();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    @Override // java.util.AbstractMap
    public boolean containsKey(Object object) {
        Map i;
        int obj2;
        if (g((Comparable)object) < 0) {
            if (this.c.containsKey(object)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        com.google.protobuf.o1.g gVar;
        int i;
        if (this.w == null) {
            gVar = new o1.g(this, 0);
            this.w = gVar;
        }
        return this.w;
    }

    @Override // java.util.AbstractMap
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Map.Entry map;
        int i2 = 1;
        if (this == object) {
            return i2;
        }
        if (!object instanceof o1) {
            return super.equals(object);
        }
        int size = size();
        final int i4 = 0;
        if (size != (o1)object.size()) {
            return i4;
        }
        int i3 = l();
        if (i3 != object.l()) {
            return entrySet().equals(object.entrySet());
        }
        i = i4;
        while (i < i3) {
            i++;
        }
        if (i3 != size) {
            return this.c.equals(object.c);
        }
        return i2;
    }

    public V get(Object object) {
        int i = g((Comparable)object);
        if (i >= 0) {
            return (o1.e)this.b.get(i).getValue();
        }
        return this.c.get(object);
    }

    @Override // java.util.AbstractMap
    public int hashCode() {
        int i4;
        int i3;
        int i;
        int i2;
        i = i3;
        while (i3 < l()) {
            i += i2;
            i3++;
        }
        if (m() > 0) {
            i += i4;
        }
        return i;
    }

    Set<Map.Entry<K, V>> i() {
        com.google.protobuf.o1.c cVar;
        int i;
        if (this.y == null) {
            cVar = new o1.c(this, 0);
            this.y = cVar;
        }
        return this.y;
    }

    public Map.Entry<K, V> k(int i) {
        return (Map.Entry)this.b.get(i);
    }

    @Override // java.util.AbstractMap
    public int l() {
        return this.b.size();
    }

    @Override // java.util.AbstractMap
    public int m() {
        return this.c.size();
    }

    public Iterable<Map.Entry<K, V>> n() {
        Object entrySet;
        if (this.c.isEmpty()) {
            entrySet = o1.d.b();
        } else {
            entrySet = this.c.entrySet();
        }
        return entrySet;
    }

    @Override // java.util.AbstractMap
    public boolean p() {
        return this.v;
    }

    @Override // java.util.AbstractMap
    public Object put(Object object, Object object2) {
        return s((Comparable)object, object2);
    }

    @Override // java.util.AbstractMap
    public void q() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        boolean z;
        if (!this.v) {
            if (this.c.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.c);
            }
            this.c = unmodifiableMap;
            if (this.x.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.x);
            }
            this.x = unmodifiableMap2;
            this.v = true;
        }
    }

    public V remove(Object object) {
        h();
        int i = g((Comparable)object);
        if (i >= 0) {
            return t(i);
        }
        if (this.c.isEmpty()) {
            return 0;
        }
        return this.c.remove(object);
    }

    public V s(K k, V v2) {
        int value;
        int i;
        Comparable comparable;
        h();
        int i2 = g(k);
        if (i2 >= 0) {
            return (o1.e)this.b.get(i2).setValue(v2);
        }
        j();
        int i4 = -i3;
        if (i4 >= this.a) {
            return o().put(k, v2);
        }
        i = this.a;
        if (this.b.size() == i) {
            Object remove = this.b.remove(i--);
            o().put((o1.e)remove.e(), remove.getValue());
        }
        o1.e eVar = new o1.e(this, k, v2);
        this.b.add(i4, eVar);
        return 0;
    }

    @Override // java.util.AbstractMap
    public int size() {
        return size += size2;
    }
}
