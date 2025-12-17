package d.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
abstract class f<K, V>  {

    d.e.f.b<K, V> a;
    d.e.f.c<K, V> b;
    d.e.f.e<K, V> c;

    final class a implements Iterator<T> {

        final int a;
        int b;
        int c;
        boolean v = false;
        final d.e.f w;
        a(d.e.f f, int i2) {
            this.w = f;
            super();
            final int i = 0;
            this.a = i2;
            this.b = f.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.c < this.b ? 1 : 0;
            return i;
        }

        public T next() {
            if (!hasNext()) {
            } else {
                int i5 = 1;
                this.c = i2 += i5;
                this.v = i5;
                return this.w.b(this.c, this.a);
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.v) {
            } else {
                i--;
                this.c = i2;
                this.b = i3--;
                this.v = false;
                this.w.h(i2);
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
    }

    final class b implements Set<Map.Entry<K, V>> {

        final d.e.f a;
        b(d.e.f f) {
            this.a = f;
            super();
        }

        @Override // java.util.Set
        public boolean add(Object object) {
            b((Map.Entry)object);
            throw 0;
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            Object value;
            d.e.f fVar;
            Object key;
            int obj5;
            obj5 = collection.iterator();
            for (Map.Entry next2 : obj5) {
                this.a.g(next2.getKey(), next2.getValue());
            }
            obj5 = this.a.d() != this.a.d() ? 1 : 0;
            return obj5;
        }

        public boolean b(Map.Entry<K, V> map$Entry) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // java.util.Set
        public void clear() {
            this.a.a();
        }

        @Override // java.util.Set
        public boolean contains(Object object) {
            int i2 = 0;
            if (!object instanceof Map.Entry) {
                return i2;
            }
            int i = this.a.e((Map.Entry)object.getKey());
            if (i < 0) {
                return i2;
            }
            return c.c(this.a.b(i, 1), object.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            boolean contains;
            Iterator obj2 = collection.iterator();
            for (Object next2 : obj2) {
            }
            return 1;
        }

        @Override // java.util.Set
        public boolean equals(Object object) {
            return f.k(this, object);
        }

        @Override // java.util.Set
        public int hashCode() {
            int i5;
            int i3;
            int i2;
            int i4;
            int i;
            final int i7 = 1;
            i6 -= i7;
            final int i8 = 0;
            i3 = i8;
            while (i5 >= 0) {
                Object obj = this.a.b(i5, i8);
                Object obj2 = this.a.b(i5, i7);
                if (obj == null) {
                } else {
                }
                i4 = obj.hashCode();
                if (obj2 == null) {
                } else {
                }
                i = obj2.hashCode();
                i3 += i2;
                i5--;
                i = i8;
                i4 = i8;
            }
            return i3;
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            int i;
            i = this.a.d() == 0 ? 1 : 0;
            return i;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            f.d dVar = new f.d(this.a);
            return dVar;
        }

        @Override // java.util.Set
        public boolean remove(Object object) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        public boolean removeAll(Collection<?> collection) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        public boolean retainAll(Collection<?> collection) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // java.util.Set
        public int size() {
            return this.a.d();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public <T> T[] toArray(T[] tArr) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }
    }

    final class c implements Set<K> {

        final d.e.f a;
        c(d.e.f f) {
            this.a = f;
            super();
        }

        public boolean add(K k) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        public boolean addAll(Collection<? extends K> collection) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // java.util.Set
        public void clear() {
            this.a.a();
        }

        @Override // java.util.Set
        public boolean contains(Object object) {
            int obj2;
            obj2 = this.a.e(object) >= 0 ? 1 : 0;
            return obj2;
        }

        public boolean containsAll(Collection<?> collection) {
            return f.j(this.a.c(), collection);
        }

        @Override // java.util.Set
        public boolean equals(Object object) {
            return f.k(this, object);
        }

        @Override // java.util.Set
        public int hashCode() {
            int i3;
            int i;
            int i2;
            i4--;
            final int i5 = 0;
            i = i5;
            while (i3 >= 0) {
                Object obj = this.a.b(i3, i5);
                if (obj == null) {
                } else {
                }
                i2 = obj.hashCode();
                i += i2;
                i3--;
                i2 = i5;
            }
            return i;
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            int i;
            i = this.a.d() == 0 ? 1 : 0;
            return i;
        }

        public Iterator<K> iterator() {
            f.a aVar = new f.a(this.a, 0);
            return aVar;
        }

        @Override // java.util.Set
        public boolean remove(Object object) {
            int obj2 = this.a.e(object);
            if (obj2 >= 0) {
                this.a.h(obj2);
                return 1;
            }
            return 0;
        }

        public boolean removeAll(Collection<?> collection) {
            return f.o(this.a.c(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return f.p(this.a.c(), collection);
        }

        @Override // java.util.Set
        public int size() {
            return this.a.d();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            return this.a.q(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.a.r(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        int a;
        int b = -1;
        boolean c = false;
        final d.e.f v;
        d(d.e.f f) {
            this.v = f;
            super();
            final int i = 0;
            this.a = obj2--;
            int obj2 = -1;
        }

        public Map.Entry<K, V> b() {
            if (!hasNext()) {
            } else {
                final int i3 = 1;
                this.b = i += i3;
                this.c = i3;
                return this;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public boolean equals(Object object) {
            boolean z;
            int i;
            int i2;
            Object obj5;
            if (!this.c) {
            } else {
                i = 0;
                if (!object instanceof Map.Entry) {
                    return i;
                }
                int i3 = 1;
                if (c.c((Map.Entry)object.getKey(), this.v.b(this.b, i)) && c.c(object.getValue(), this.v.b(this.b, i3))) {
                    if (c.c(object.getValue(), this.v.b(this.b, i3))) {
                        i = i3;
                    }
                }
                return i;
            }
            obj5 = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw obj5;
        }

        public K getKey() {
            if (!this.c) {
            } else {
                return this.v.b(this.b, 0);
            }
            IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw illegalStateException;
        }

        public V getValue() {
            if (!this.c) {
            } else {
                return this.v.b(this.b, 1);
            }
            IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw illegalStateException;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.b < this.a ? 1 : 0;
            return i;
        }

        @Override // java.util.Iterator
        public int hashCode() {
            int i2;
            int i;
            if (!this.c) {
            } else {
                i = 0;
                Object obj = this.v.b(this.b, i);
                Object obj2 = this.v.b(this.b, 1);
                if (obj == null) {
                    i2 = i;
                } else {
                    i2 = obj.hashCode();
                }
                if (obj2 == null) {
                } else {
                    i = obj2.hashCode();
                }
                return i2 ^= i;
            }
            IllegalStateException illegalStateException = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw illegalStateException;
        }

        @Override // java.util.Iterator
        public Object next() {
            b();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.c) {
            } else {
                this.v.h(this.b);
                this.b = i--;
                this.a = i3--;
                this.c = false;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }

        public V setValue(V v) {
            if (!this.c) {
            } else {
                return this.v.i(this.b, v);
            }
            IllegalStateException obj3 = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw obj3;
        }

        @Override // java.util.Iterator
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getKey());
            stringBuilder.append("=");
            stringBuilder.append(getValue());
            return stringBuilder.toString();
        }
    }

    final class e implements Collection<V> {

        final d.e.f a;
        e(d.e.f f) {
            this.a = f;
            super();
        }

        public boolean add(V v) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        public boolean addAll(Collection<? extends V> collection) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        @Override // java.util.Collection
        public void clear() {
            this.a.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object object) {
            int obj2;
            obj2 = this.a.f(object) >= 0 ? 1 : 0;
            return obj2;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean contains;
            Iterator obj2 = collection.iterator();
            for (Object next2 : obj2) {
            }
            return 1;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            int i;
            i = this.a.d() == 0 ? 1 : 0;
            return i;
        }

        public Iterator<V> iterator() {
            f.a aVar = new f.a(this.a, 1);
            return aVar;
        }

        @Override // java.util.Collection
        public boolean remove(Object object) {
            int obj2 = this.a.f(object);
            if (obj2 >= 0) {
                this.a.h(obj2);
                return 1;
            }
            return 0;
        }

        public boolean removeAll(Collection<?> collection) {
            int i3;
            int i2;
            int i;
            boolean contains;
            int i4;
            i3 = this.a.d();
            i = i2;
            while (i2 < i3) {
                i4 = 1;
                if (collection.contains(this.a.b(i2, i4))) {
                }
                i2 += i4;
                this.a.h(i2);
                i2--;
                i3--;
                i = i4;
            }
            return i;
        }

        public boolean retainAll(Collection<?> collection) {
            int i;
            int i3;
            int i4;
            boolean contains;
            int i2;
            i = this.a.d();
            i4 = i3;
            while (i3 < i) {
                i2 = 1;
                if (!collection.contains(this.a.b(i3, i2))) {
                }
                i3 += i2;
                this.a.h(i3);
                i3--;
                i--;
                i4 = i2;
            }
            return i4;
        }

        @Override // java.util.Collection
        public int size() {
            return this.a.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return this.a.q(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.a.r(tArr, 1);
        }
    }
    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection2) {
        boolean key;
        final Iterator obj2 = collection2.iterator();
        for (Object next2 : obj2) {
        }
        return 1;
    }

    public static <T> boolean k(Set<T> set, Object object2) {
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

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection2) {
        Object next;
        int obj2;
        final Iterator obj3 = collection2.iterator();
        for (Object next : obj3) {
            map.remove(next);
        }
        obj2 = map.size() != map.size() ? 1 : 0;
        return obj2;
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection2) {
        boolean contains;
        int obj3;
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (!collection2.contains(iterator.next())) {
            }
            iterator.remove();
        }
        obj3 = map.size() != map.size() ? 1 : 0;
        return obj3;
    }

    protected abstract void a();

    protected abstract Object b(int i, int i2);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object object);

    protected abstract int f(Object object);

    protected abstract void g(K k, V v2);

    protected abstract void h(int i);

    protected abstract V i(int i, V v2);

    public Set<Map.Entry<K, V>> l() {
        d.e.f.b bVar;
        if (this.a == null) {
            bVar = new f.b(this);
            this.a = bVar;
        }
        return this.a;
    }

    public Set<K> m() {
        d.e.f.c cVar;
        if (this.b == null) {
            cVar = new f.c(this);
            this.b = cVar;
        }
        return this.b;
    }

    public Collection<V> n() {
        d.e.f.e eVar;
        if (this.c == null) {
            eVar = new f.e(this);
            this.c = eVar;
        }
        return this.c;
    }

    public Object[] q(int i) {
        int i2;
        Object obj;
        final int i3 = d();
        final Object[] arr = new Object[i3];
        i2 = 0;
        while (i2 < i3) {
            arr[i2] = b(i2, i);
            i2++;
        }
        return arr;
    }

    public <T> T[] r(T[] tArr, int i2) {
        int i;
        Object obj;
        Object obj4;
        int obj5;
        final int i3 = d();
        if (tArr.length < i3) {
            obj4 = Array.newInstance(tArr.getClass().getComponentType(), i3);
        }
        i = 0;
        while (i < i3) {
            obj4[i] = b(i, i2);
            i++;
        }
        if (obj4.length > i3) {
            obj4[i3] = 0;
        }
        return obj4;
    }
}
