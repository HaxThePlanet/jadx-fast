package d.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: MapCollections.java */
/* loaded from: classes.dex */
abstract class f<K, V> {

    f.b<K, V> a;
    f.c<K, V> b;
    f.e<K, V> c;

    final class a<T> implements Iterator<T> {

        final int a;
        int b;
        int c;
        boolean v = false;
        final /* synthetic */ f w;
        a(int i) {
            this.w = fVar;
            super();
            this.a = i;
            this.b = fVar.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z = true;
            int r0 = this.c < this.b ? 1 : 0;
            return (this.c < this.b ? 1 : 0);
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                int i5 = 1;
                this.c += i5;
                this.v = true;
                return this.w.b(this.c, this.a);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.v) {
                throw new IllegalStateException();
            } else {
                this.c--;
                this.b--;
                this.v = false;
                this.w.h(i2);
                return;
            }
        }
    }

    final class b implements Set<Map.Entry<K, V>> {

        final /* synthetic */ f a;
        b() {
            this.a = fVar;
            super();
        }

        @Override // java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            boolean z = false;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                this.a.g(item.getKey(), item.getValue());
            }
            collection = this.a.d() != this.a.d() ? 1 : 0;
            return (this.a.d() != this.a.d() ? 1 : 0);
        }

        public boolean b(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public void clear() {
            this.a.a();
        }

        @Override // java.util.Set
        public boolean contains(Object object) {
            boolean z2 = false;
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            int i = this.a.e(object.getKey());
            if (i < 0) {
                return false;
            }
            return c.c(this.a.b(i, 1), object.getValue());
        }

        @Override // java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            return f.k(this, object);
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            int i2;
            final int i5 = 1;
            i = this.a.d() - i5;
            i2 = 0;
            while (this.a >= 0) {
                Object obj = this.a.b(i, i2);
                Object obj2 = this.a.b(i, i5);
                i3 = i2 ^ i2;
                i2 = i2 + i3;
                i = i - 1;
            }
            return i2;
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            boolean z = true;
            int r0 = this.a.d() == 0 ? 1 : 0;
            return (this.a.d() == 0 ? 1 : 0);
        }

        @Override // java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f.d(this.a);
        }

        @Override // java.util.Set
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public int size() {
            return this.a.d();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {

        final /* synthetic */ f a;
        c() {
            this.a = fVar;
            super();
        }

        @Override // java.util.Set
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public void clear() {
            this.a.a();
        }

        @Override // java.util.Set
        public boolean contains(Object object) {
            boolean z = true;
            object = this.a.e(object) >= 0 ? 1 : 0;
            return (this.a.e(object) >= 0 ? 1 : 0);
        }

        @Override // java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return f.j(this.a.c(), collection);
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            return f.k(this, object);
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            int i2;
            i = this.a.d() - 1;
            i2 = 0;
            while (this.a >= 0) {
                Object obj = this.a.b(i, i2);
                i2 = i2 + i2;
                i = i - 1;
            }
            return i2;
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            boolean z = true;
            int r0 = this.a.d() == 0 ? 1 : 0;
            return (this.a.d() == 0 ? 1 : 0);
        }

        @Override // java.util.Set
        public Iterator<K> iterator() {
            return new f.a(this.a, 0);
        }

        @Override // java.util.Set
        public boolean remove(Object object) {
            int i = this.a.e(object);
            if (i >= 0) {
                this.a.h(i);
                return true;
            }
            return false;
        }

        @Override // java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return f.o(this.a.c(), collection);
        }

        @Override // java.util.Set
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

        @Override // java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return this.a.r(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        int a;
        int b = -1;
        boolean c = false;
        final /* synthetic */ f v;
        d() {
            this.v = fVar;
            super();
            this.a = fVar.d() - 1;
        }

        public Map.Entry<K, V> b() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                final int i3 = 1;
                this.b += i3;
                this.c = true;
                return this;
            }
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object object) {
            boolean z5 = false;
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else {
                int i3 = 0;
                if (!(object instanceof Map.Entry)) {
                    return false;
                }
                int i = 1;
                if (c.c(object.getKey(), this.v.b(this.b, i3))) {
                    if (c.c(object.getValue(), this.v.b(this.b, i))) {
                    }
                }
                return z5;
            }
        }

        @Override // java.util.Map$Entry
        public K getKey() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else {
                return this.v.b(this.b, 0);
            }
        }

        @Override // java.util.Map$Entry
        public V getValue() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else {
                return this.v.b(this.b, 1);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z = true;
            int r0 = this.b < this.a ? 1 : 0;
            return (this.b < this.a ? 1 : 0);
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            int i;
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else {
                i = 0;
                Object obj = this.v.b(this.b, i);
                Object obj2 = this.v.b(this.b, 1);
                if (obj == null) {
                } else {
                    i = obj.hashCode();
                }
                if (obj2 != null) {
                    i = obj2.hashCode();
                }
                return i ^ i;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.c) {
                throw new IllegalStateException();
            } else {
                this.v.h(this.b);
                this.b--;
                this.a--;
                this.c = false;
                return;
            }
        }

        @Override // java.util.Map$Entry
        public V setValue(V v) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else {
                return this.v.i(this.b, v);
            }
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Object key = getKey();
            String str2 = "=";
            Object value = getValue();
            str = key + str2 + value;
            return str;
        }
    }

    final class e implements Collection<V> {

        final /* synthetic */ f a;
        e() {
            this.a = fVar;
            super();
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            this.a.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object object) {
            boolean z = true;
            object = this.a.f(object) >= 0 ? 1 : 0;
            return (this.a.f(object) >= 0 ? 1 : 0);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean z = true;
            int r0 = this.a.d() == 0 ? 1 : 0;
            return (this.a.d() == 0 ? 1 : 0);
        }

        @Override // java.util.Collection
        public Iterator<V> iterator() {
            return new f.a(this.a, 1);
        }

        @Override // java.util.Collection
        public boolean remove(Object object) {
            int i = this.a.f(object);
            if (i >= 0) {
                this.a.h(i);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int i;
            int i2 = 0;
            boolean z;
            i = this.a.d();
            i2 = 0;
            while (i2 < this.a) {
                int i3 = 1;
                i2 = i2 + i3;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int i;
            int i2 = 0;
            boolean z;
            i = this.a.d();
            i2 = 0;
            while (i2 < this.a) {
                int i3 = 1;
                i2 = i2 + i3;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return this.a.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return this.a.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return this.a.r(tArr, 1);
        }
    }
    f() {
        super();
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        final Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object object) {
        boolean z = true;
        boolean all;
        z = true;
        if (set == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof Set) {
            try {
            } catch (java.lang.NullPointerException | java.lang.ClassCastException unused) {
                return false;
            }
            return z;
        }
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        boolean z = false;
        final Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        map = map.size() != map.size() ? 1 : 0;
        return (map.size() != map.size() ? 1 : 0);
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        boolean z = false;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
        }
        map = map.size() != map.size() ? 1 : 0;
        return (map.size() != map.size() ? 1 : 0);
    }

    public Set<Map.Entry<K, V>> l() {
        if (this.a == null) {
            this.a = new f.b(this);
        }
        return this.a;
    }

    public Set<K> m() {
        if (this.b == null) {
            this.b = new f.c(this);
        }
        return this.b;
    }

    public Collection<V> n() {
        if (this.c == null) {
            this.c = new f.e(this);
        }
        return this.c;
    }

    public Object[] q(int i) {
        int i2 = 0;
        final int i3 = d();
        final Object[] arr = new Object[i3];
        i2 = 0;
        while (i2 < i3) {
            arr[i2] = b(i2, i);
            i2 = i2 + 1;
        }
        return arr;
    }

    public <T> T[] r(T[] tArr, int i) {
        Object array;
        final int i3 = d();
        if (tArr.length < i3) {
            array = Array.newInstance(tArr.getClass().getComponentType(), i3);
        }
        i = 0;
        while (tArr.length < i3) {
            array[i] = b(i, i);
            i = i + 1;
        }
        length = array.length;
        if (array.length > i3) {
            array[i3] = null;
        }
        return array;
    }

    protected abstract void a();

    protected abstract Object b(int i, int i2);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object object);

    protected abstract int f(Object object);

    protected abstract void g(K k, V v);

    protected abstract void h(int i);

    protected abstract V i(int i, V v);
}
