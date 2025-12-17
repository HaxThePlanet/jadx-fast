package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes2.dex */
abstract class d<K, V>  extends com.google.common.collect.f<K, V> implements Serializable {

    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> v;
    private transient int w;

    private abstract class c implements Iterator<T> {

        final Iterator<Map.Entry<K, Collection<V>>> a;
        K b = 0;
        Collection<V> c = null;
        Iterator<V> v;
        final com.google.common.collect.d w;
        c(com.google.common.collect.d d) {
            this.w = d;
            super();
            this.a = d.h(d).entrySet().iterator();
            int obj1 = 0;
            this.v = b0.f();
        }

        abstract T b(K k, V v2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            boolean next;
            if (!this.a.hasNext()) {
                if (this.v.hasNext()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public T next() {
            boolean iterator;
            Object key;
            if (!this.v.hasNext()) {
                Object next = this.a.next();
                this.b = (Map.Entry)next.getKey();
                Object value = next.getValue();
                this.c = (Collection)value;
                this.v = value.iterator();
            }
            Object next2 = this.v.next();
            b(this.b, next2);
            return next2;
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean empty;
            this.v.remove();
            if (this.c.isEmpty()) {
                this.a.remove();
            }
            d.k(this.w);
        }
    }

    class j extends AbstractCollection<V> {

        final K a;
        Collection<V> b;
        final com.google.common.collect.d.j<K, V> c;
        final Collection<V> v;
        final com.google.common.collect.d w;
        j(com.google.common.collect.d d, Object object2, Collection collection3, com.google.common.collect.d.j d$j4) {
            int obj1;
            this.w = d;
            super();
            this.a = object2;
            this.b = collection3;
            this.c = j4;
            if (j4 == null) {
                obj1 = 0;
            } else {
                obj1 = j4.g();
            }
            this.v = obj1;
        }

        public boolean add(V v) {
            Object collection;
            i();
            final boolean obj3 = this.b.add(v);
            d.j(this.w);
            if (obj3 != null && this.b.isEmpty()) {
                d.j(this.w);
                if (this.b.isEmpty()) {
                    b();
                }
            }
            return obj3;
        }

        public boolean addAll(Collection<? extends V> collection) {
            Collection collection2;
            com.google.common.collect.d dVar;
            if (collection.isEmpty()) {
                return 0;
            }
            int size = size();
            boolean obj4 = this.b.addAll(collection);
            d.l(this.w, size2 -= size);
            if (obj4 != null && size == 0) {
                d.l(this.w, size2 -= size);
                if (size == 0) {
                    b();
                }
            }
            return obj4;
        }

        @Override // java.util.AbstractCollection
        void b() {
            Object jVar;
            Object obj;
            Collection collection;
            jVar = this.c;
            if (jVar != null) {
                jVar.b();
            } else {
                d.h(this.w).put(this.a, this.b);
            }
        }

        @Override // java.util.AbstractCollection
        public void clear() {
            final int size = size();
            if (size == 0) {
            }
            this.b.clear();
            d.m(this.w, size);
            l();
        }

        @Override // java.util.AbstractCollection
        public boolean contains(Object object) {
            i();
            return this.b.contains(object);
        }

        public boolean containsAll(Collection<?> collection) {
            i();
            return this.b.containsAll(collection);
        }

        com.google.common.collect.d.j<K, V> d() {
            return this.c;
        }

        @Override // java.util.AbstractCollection
        public boolean equals(Object object) {
            if (object == this) {
                return 1;
            }
            i();
            return this.b.equals(object);
        }

        Collection<V> g() {
            return this.b;
        }

        K h() {
            return this.a;
        }

        @Override // java.util.AbstractCollection
        public int hashCode() {
            i();
            return this.b.hashCode();
        }

        @Override // java.util.AbstractCollection
        void i() {
            Collection empty;
            Object obj;
            com.google.common.collect.d.j jVar = this.c;
            if (jVar != null) {
                jVar.i();
                if (this.c.g() != this.v) {
                } else {
                }
                ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
                throw concurrentModificationException;
            }
            empty = d.h(this.w).get(this.a);
            if (this.b.isEmpty() && (Collection)empty != null) {
                empty = d.h(this.w).get(this.a);
                if ((Collection)(Collection)empty != null) {
                    this.b = (Collection)(Collection)empty;
                }
            }
        }

        public Iterator<V> iterator() {
            i();
            d.j.a aVar = new d.j.a(this);
            return aVar;
        }

        @Override // java.util.AbstractCollection
        void l() {
            com.google.common.collect.d.j empty;
            Object obj;
            empty = this.c;
            if (empty != null) {
                empty.l();
            } else {
                if (this.b.isEmpty()) {
                    d.h(this.w).remove(this.a);
                }
            }
        }

        @Override // java.util.AbstractCollection
        public boolean remove(Object object) {
            Object collection;
            i();
            final boolean obj2 = this.b.remove(object);
            if (obj2 != null) {
                d.k(this.w);
                l();
            }
            return obj2;
        }

        public boolean removeAll(Collection<?> collection) {
            Collection collection2;
            com.google.common.collect.d dVar;
            if (collection.isEmpty()) {
                return 0;
            }
            boolean obj4 = this.b.removeAll(collection);
            if (obj4 != null) {
                d.l(this.w, size2 -= size);
                l();
            }
            return obj4;
        }

        public boolean retainAll(Collection<?> collection) {
            Collection collection2;
            com.google.common.collect.d dVar;
            n.o(collection);
            final boolean obj4 = this.b.retainAll(collection);
            if (obj4 != null) {
                d.l(this.w, size2 -= size);
                l();
            }
            return obj4;
        }

        @Override // java.util.AbstractCollection
        public int size() {
            i();
            return this.b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            i();
            return this.b.toString();
        }
    }

    class a extends com.google.common.collect.d.c<K, V, V> {
        a(com.google.common.collect.d d) {
            super(d);
        }

        V b(K k, V v2) {
            return v2;
        }
    }

    private class b extends com.google.common.collect.h0.f<K, Collection<V>> {

        final transient Map<K, Collection<V>> c;
        final com.google.common.collect.d v;
        b(com.google.common.collect.d d, Map map2) {
            this.v = d;
            super();
            this.c = map2;
        }

        protected Set<Map.Entry<K, Collection<V>>> a() {
            d.b.a aVar = new d.b.a(this);
            return aVar;
        }

        @Override // com.google.common.collect.h0$f
        public void clear() {
            Object bVar;
            if (this.c == d.h(this.v)) {
                this.v.clear();
            } else {
                bVar = new d.b.b(this);
                b0.b(bVar);
            }
        }

        @Override // com.google.common.collect.h0$f
        public boolean containsKey(Object object) {
            return h0.f(this.c, object);
        }

        public Collection<V> d(Object object) {
            Object obj = h0.g(this.c, object);
            if ((Collection)obj == null) {
                return 0;
            }
            return this.v.x(object, (Collection)obj);
        }

        public Collection<V> e(Object object) {
            Object obj4 = this.c.remove(object);
            if ((Collection)obj4 == null) {
                return 0;
            }
            Collection collection = this.v.p();
            collection.addAll((Collection)obj4);
            d.m(this.v, obj4.size());
            obj4.clear();
            return collection;
        }

        @Override // com.google.common.collect.h0$f
        public boolean equals(Object object) {
            Map map;
            int obj2;
            if (this != object) {
                if (this.c.equals(object)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }

        Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> map$Entry) {
            final Object key = entry.getKey();
            return h0.c(key, this.v.x(key, (Collection)entry.getValue()));
        }

        @Override // com.google.common.collect.h0$f
        public Object get(Object object) {
            return d(object);
        }

        @Override // com.google.common.collect.h0$f
        public int hashCode() {
            return this.c.hashCode();
        }

        public Set<K> keySet() {
            return this.v.f();
        }

        @Override // com.google.common.collect.h0$f
        public Object remove(Object object) {
            return e(object);
        }

        @Override // com.google.common.collect.h0$f
        public int size() {
            return this.c.size();
        }

        @Override // com.google.common.collect.h0$f
        public String toString() {
            return this.c.toString();
        }
    }

    class k extends com.google.common.collect.d.j<K, V> implements List<V> {

        final com.google.common.collect.d x;
        k(com.google.common.collect.d d, Object object2, List list3, com.google.common.collect.d.j d$j4) {
            this.x = d;
            super(d, object2, list3, j4);
        }

        public void add(int i, V v2) {
            i();
            m().add(i, v2);
            d.j(this.x);
            if (g().isEmpty()) {
                b();
            }
        }

        public boolean addAll(int i, Collection<? extends V> collection2) {
            Object list;
            Collection obj4;
            if (collection2.isEmpty()) {
                return 0;
            }
            int size = size();
            boolean obj3 = m().addAll(i, collection2);
            d.l(this.x, obj4 -= size);
            if (obj3 != null && size == 0) {
                d.l(this.x, obj4 -= size);
                if (size == 0) {
                    b();
                }
            }
            return obj3;
        }

        public V get(int i) {
            i();
            return m().get(i);
        }

        @Override // com.google.common.collect.d$j
        public int indexOf(Object object) {
            i();
            return m().indexOf(object);
        }

        @Override // com.google.common.collect.d$j
        public int lastIndexOf(Object object) {
            i();
            return m().lastIndexOf(object);
        }

        public ListIterator<V> listIterator() {
            i();
            d.k.a aVar = new d.k.a(this);
            return aVar;
        }

        public ListIterator<V> listIterator(int i) {
            i();
            d.k.a aVar = new d.k.a(this, i);
            return aVar;
        }

        List<V> m() {
            return (List)g();
        }

        public V remove(int i) {
            i();
            d.k(this.x);
            l();
            return m().remove(i);
        }

        public V set(int i, V v2) {
            i();
            return m().set(i, v2);
        }

        public List<V> subList(int i, int i2) {
            Object obj5;
            i();
            if (d() == null) {
                obj5 = this;
            } else {
                obj5 = d();
            }
            return this.x.y(h(), m().subList(i, i2), obj5);
        }
    }

    private class d extends com.google.common.collect.h0.d<K, Collection<V>> {

        final com.google.common.collect.d b;
        d(com.google.common.collect.d d, Map map2) {
            this.b = d;
            super(map2);
        }

        @Override // com.google.common.collect.h0$d
        public void clear() {
            b0.b(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return b().keySet().containsAll(collection);
        }

        @Override // com.google.common.collect.h0$d
        public boolean equals(Object object) {
            Set keySet;
            int obj2;
            if (this != object) {
                if (b().keySet().equals(object)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }

        @Override // com.google.common.collect.h0$d
        public int hashCode() {
            return b().keySet().hashCode();
        }

        public Iterator<K> iterator() {
            d.d.a aVar = new d.d.a(this, b().entrySet().iterator());
            return aVar;
        }

        @Override // com.google.common.collect.h0$d
        public boolean remove(Object object) {
            int i;
            int size;
            Object obj3;
            obj3 = b().remove(object);
            if ((Collection)obj3 != null) {
                obj3.clear();
                d.m(this.b, (Collection)obj3.size());
            } else {
                size = i;
            }
            if (size > 0) {
                i = 1;
            }
            return i;
        }
    }

    private class g extends com.google.common.collect.d.k<K, V> implements RandomAccess {
        g(com.google.common.collect.d d, Object object2, List list3, com.google.common.collect.d.j d$j4) {
            super(d, object2, list3, j4);
        }
    }

    private class h extends com.google.common.collect.d.b<K, V> implements SortedMap<K, Collection<V>> {

        SortedSet<K> w;
        final com.google.common.collect.d x;
        h(com.google.common.collect.d d, SortedMap sortedMap2) {
            this.x = d;
            super(d, sortedMap2);
        }

        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        public K firstKey() {
            return i().firstKey();
        }

        SortedSet<K> g() {
            d.i iVar = new d.i(this.x, i());
            return iVar;
        }

        public SortedSet<K> h() {
            SortedSet set;
            if (this.w == null) {
                this.w = g();
            }
            return set;
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            d.h hVar = new d.h(this.x, i().headMap(k));
            return hVar;
        }

        SortedMap<K, Collection<V>> i() {
            return (SortedMap)this.c;
        }

        @Override // com.google.common.collect.d$b
        public Set keySet() {
            return h();
        }

        public K lastKey() {
            return i().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            d.h hVar = new d.h(this.x, i().subMap(k, k2));
            return hVar;
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            d.h hVar = new d.h(this.x, i().tailMap(k));
            return hVar;
        }
    }

    class e extends com.google.common.collect.d.h<K, V> implements NavigableMap<K, Collection<V>> {

        final com.google.common.collect.d y;
        e(com.google.common.collect.d d, NavigableMap navigableMap2) {
            this.y = d;
            super(d, navigableMap2);
        }

        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            int obj2;
            obj2 = n().ceilingEntry(k);
            if (obj2 == null) {
                obj2 = 0;
            } else {
                obj2 = f(obj2);
            }
            return obj2;
        }

        public K ceilingKey(K k) {
            return n().ceilingKey(k);
        }

        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        public NavigableMap<K, Collection<V>> descendingMap() {
            d.e eVar = new d.e(this.y, n().descendingMap());
            return eVar;
        }

        public Map.Entry<K, Collection<V>> firstEntry() {
            int i;
            Map.Entry firstEntry = n().firstEntry();
            if (firstEntry == null) {
                i = 0;
            } else {
                i = f(firstEntry);
            }
            return i;
        }

        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            int obj2;
            obj2 = n().floorEntry(k);
            if (obj2 == null) {
                obj2 = 0;
            } else {
                obj2 = f(obj2);
            }
            return obj2;
        }

        public K floorKey(K k) {
            return n().floorKey(k);
        }

        @Override // com.google.common.collect.d$h
        SortedSet g() {
            return j();
        }

        @Override // com.google.common.collect.d$h
        public SortedSet h() {
            return l();
        }

        public NavigableMap<K, Collection<V>> headMap(K k, boolean z2) {
            d.e eVar = new d.e(this.y, n().headMap(k, z2));
            return eVar;
        }

        @Override // com.google.common.collect.d$h
        public SortedMap headMap(Object object) {
            return k(object);
        }

        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            int obj2;
            obj2 = n().higherEntry(k);
            if (obj2 == null) {
                obj2 = 0;
            } else {
                obj2 = f(obj2);
            }
            return obj2;
        }

        public K higherKey(K k) {
            return n().higherKey(k);
        }

        @Override // com.google.common.collect.d$h
        SortedMap i() {
            return n();
        }

        NavigableSet<K> j() {
            d.f fVar = new d.f(this.y, n());
            return fVar;
        }

        public NavigableMap<K, Collection<V>> k(K k) {
            return headMap(k, false);
        }

        @Override // com.google.common.collect.d$h
        public Set keySet() {
            return l();
        }

        public NavigableSet<K> l() {
            return (NavigableSet)super.h();
        }

        public Map.Entry<K, Collection<V>> lastEntry() {
            int i;
            Map.Entry lastEntry = n().lastEntry();
            if (lastEntry == null) {
                i = 0;
            } else {
                i = f(lastEntry);
            }
            return i;
        }

        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            int obj2;
            obj2 = n().lowerEntry(k);
            if (obj2 == null) {
                obj2 = 0;
            } else {
                obj2 = f(obj2);
            }
            return obj2;
        }

        public K lowerKey(K k) {
            return n().lowerKey(k);
        }

        Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> iterator) {
            if (!iterator.hasNext()) {
                return 0;
            }
            Object next2 = iterator.next();
            Collection collection2 = this.y.p();
            collection2.addAll((Collection)(Map.Entry)next2.getValue());
            iterator.remove();
            return h0.c(next2.getKey(), this.y.w(collection2));
        }

        NavigableMap<K, Collection<V>> n() {
            return (NavigableMap)super.i();
        }

        public NavigableSet<K> navigableKeySet() {
            return l();
        }

        public NavigableMap<K, Collection<V>> o(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, Collection<V>> p(K k) {
            return tailMap(k, true);
        }

        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        public NavigableMap<K, Collection<V>> subMap(K k, boolean z2, K k3, boolean z4) {
            d.e eVar = new d.e(this.y, n().subMap(k, z2, k3, z4));
            return eVar;
        }

        @Override // com.google.common.collect.d$h
        public SortedMap subMap(Object object, Object object2) {
            return o(object, object2);
        }

        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z2) {
            d.e eVar = new d.e(this.y, n().tailMap(k, z2));
            return eVar;
        }

        @Override // com.google.common.collect.d$h
        public SortedMap tailMap(Object object) {
            return p(object);
        }
    }

    private class i extends com.google.common.collect.d.d<K, V> implements SortedSet<K> {

        final com.google.common.collect.d c;
        i(com.google.common.collect.d d, SortedMap sortedMap2) {
            this.c = d;
            super(d, sortedMap2);
        }

        public Comparator<? super K> comparator() {
            return d().comparator();
        }

        SortedMap<K, Collection<V>> d() {
            return (SortedMap)super.b();
        }

        public K first() {
            return d().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            d.i iVar = new d.i(this.c, d().headMap(k));
            return iVar;
        }

        public K last() {
            return d().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            d.i iVar = new d.i(this.c, d().subMap(k, k2));
            return iVar;
        }

        public SortedSet<K> tailSet(K k) {
            d.i iVar = new d.i(this.c, d().tailMap(k));
            return iVar;
        }
    }

    class f extends com.google.common.collect.d.i<K, V> implements NavigableSet<K> {

        final com.google.common.collect.d v;
        f(com.google.common.collect.d d, NavigableMap navigableMap2) {
            this.v = d;
            super(d, navigableMap2);
        }

        public K ceiling(K k) {
            return h().ceilingKey(k);
        }

        @Override // com.google.common.collect.d$i
        SortedMap d() {
            return h();
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> descendingSet() {
            d.f fVar = new d.f(this.v, h().descendingMap());
            return fVar;
        }

        public K floor(K k) {
            return h().floorKey(k);
        }

        public NavigableSet<K> g(K k) {
            return headSet(k, false);
        }

        NavigableMap<K, Collection<V>> h() {
            return (NavigableMap)super.d();
        }

        public NavigableSet<K> headSet(K k, boolean z2) {
            d.f fVar = new d.f(this.v, h().headMap(k, z2));
            return fVar;
        }

        @Override // com.google.common.collect.d$i
        public SortedSet headSet(Object object) {
            return g(object);
        }

        public K higher(K k) {
            return h().higherKey(k);
        }

        public NavigableSet<K> i(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        public NavigableSet<K> l(K k) {
            return tailSet(k, true);
        }

        public K lower(K k) {
            return h().lowerKey(k);
        }

        public K pollFirst() {
            return b0.j(iterator());
        }

        public K pollLast() {
            return b0.j(descendingIterator());
        }

        public NavigableSet<K> subSet(K k, boolean z2, K k3, boolean z4) {
            d.f fVar = new d.f(this.v, h().subMap(k, z2, k3, z4));
            return fVar;
        }

        @Override // com.google.common.collect.d$i
        public SortedSet subSet(Object object, Object object2) {
            return i(object, object2);
        }

        public NavigableSet<K> tailSet(K k, boolean z2) {
            d.f fVar = new d.f(this.v, h().tailMap(k, z2));
            return fVar;
        }

        @Override // com.google.common.collect.d$i
        public SortedSet tailSet(Object object) {
            return l(object);
        }
    }
    protected d(Map<K, Collection<V>> map) {
        super();
        n.d(map.isEmpty());
        this.v = map;
    }

    static Map h(com.google.common.collect.d d) {
        return d.v;
    }

    static Iterator i(Collection collection) {
        return d.t(collection);
    }

    static int j(com.google.common.collect.d d) {
        final int i = d.w;
        d.w = i + 1;
        return i;
    }

    static int k(com.google.common.collect.d d) {
        final int i = d.w;
        d.w = i + -1;
        return i;
    }

    static int l(com.google.common.collect.d d, int i2) {
        i += i2;
        d.w = i3;
        return i3;
    }

    static int m(com.google.common.collect.d d, int i2) {
        i -= i2;
        d.w = i3;
        return i3;
    }

    static void n(com.google.common.collect.d d, Object object2) {
        d.u(object2);
    }

    private static <E> Iterator<E> t(Collection<E> collection) {
        Object obj1;
        if (collection instanceof List != null) {
            obj1 = (List)collection.listIterator();
        } else {
            obj1 = collection.iterator();
        }
        return obj1;
    }

    private void u(Object object) {
        Map size;
        Object obj2;
        obj2 = h0.h(this.v, object);
        if ((Collection)obj2 != null) {
            obj2.clear();
            this.w = obj2 -= size;
        }
    }

    @Override // com.google.common.collect.f
    public void clear() {
        Object next;
        Iterator iterator = this.v.values().iterator();
        for (Collection next : iterator) {
            next.clear();
        }
        this.v.clear();
        this.w = 0;
    }

    Collection<V> e() {
        f.a aVar = new f.a(this);
        return aVar;
    }

    Iterator<V> g() {
        d.a aVar = new d.a(this);
        return aVar;
    }

    Map<K, Collection<V>> o() {
        return this.v;
    }

    abstract Collection<V> p();

    public boolean put(K k, V v2) {
        Object obj = this.v.get(k);
        final int i = 1;
        if ((Collection)obj == null) {
            Collection collection = q(k);
            if (!collection.add(v2)) {
            } else {
                this.w = obj4 += i;
                this.v.put(k, collection);
                return i;
            }
            AssertionError obj3 = new AssertionError("New Collection violated the Collection spec");
            throw obj3;
        }
        if ((Collection)obj.add(v2)) {
            this.w = obj3 += i;
            return i;
        }
        return 0;
    }

    Collection<V> q(K k) {
        return p();
    }

    final Map<K, Collection<V>> r() {
        Map map = this.v;
        if (map instanceof NavigableMap != null) {
            d.e eVar = new d.e(this, (NavigableMap)this.v);
            return eVar;
        }
        if (map instanceof SortedMap != null) {
            d.h hVar = new d.h(this, (SortedMap)this.v);
            return hVar;
        }
        d.b bVar = new d.b(this, this.v);
        return bVar;
    }

    final Set<K> s() {
        Map map = this.v;
        if (map instanceof NavigableMap != null) {
            d.f fVar = new d.f(this, (NavigableMap)this.v);
            return fVar;
        }
        if (map instanceof SortedMap != null) {
            d.i iVar = new d.i(this, (SortedMap)this.v);
            return iVar;
        }
        d.d dVar = new d.d(this, this.v);
        return dVar;
    }

    @Override // com.google.common.collect.f
    public int size() {
        return this.w;
    }

    final void v(Map<K, Collection<V>> map) {
        int size;
        int i;
        this.v = map;
        this.w = 0;
        Iterator obj3 = map.values().iterator();
        for (Collection next2 : obj3) {
            n.d(empty ^= 1);
            this.w = i3 += size;
        }
    }

    public Collection<V> values() {
        return super.values();
    }

    abstract <E> Collection<E> w(Collection<E> collection);

    abstract Collection<V> x(K k, Collection<V> collection2);

    final List<V> y(K k, List<V> list2, com.google.common.collect.d.j<K, V> d.j3) {
        com.google.common.collect.d.k gVar;
        if (list2 instanceof RandomAccess) {
            gVar = new d.g(this, k, list2, d.j3);
        } else {
            gVar = new d.k(this, k, list2, d.j3);
        }
        return gVar;
    }
}
