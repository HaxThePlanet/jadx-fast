package d.b.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V>  implements Iterable<Map.Entry<K, V>> {

    d.b.a.b.b.c<K, V> a;
    private d.b.a.b.b.c<K, V> b;
    private WeakHashMap<d.b.a.b.b.f<K, V>, Boolean> c;
    private int v = 0;

    static class c implements Map.Entry<K, V> {

        final K a;
        final V b;
        d.b.a.b.b.c<K, V> c;
        d.b.a.b.b.c<K, V> v;
        c(K k, V v2) {
            super();
            this.a = k;
            this.b = v2;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object object) {
            int i;
            boolean equals;
            Object obj5;
            if (object == this) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof b.c) {
                return i2;
            }
            if (this.a.equals(object.a) && this.b.equals(object.b)) {
                if (this.b.equals(object.b)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        public K getKey() {
            return this.a;
        }

        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            return i ^= i3;
        }

        public V setValue(V v) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("An entry modification is not supported");
            throw obj2;
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

    interface f {
        public abstract void b(d.b.a.b.b.c<K, V> b$c);
    }

    private class d implements Iterator<Map.Entry<K, V>>, d.b.a.b.b.f<K, V> {

        private d.b.a.b.b.c<K, V> a;
        private boolean b = true;
        final d.b.a.b.b c;
        d(d.b.a.b.b b) {
            this.c = b;
            super();
            final int obj1 = 1;
        }

        public void b(d.b.a.b.b.c<K, V> b$c) {
            int obj2;
            final d.b.a.b.b.c cVar = this.a;
            if (c == cVar) {
                obj2 = cVar.v;
                this.a = obj2;
                obj2 = obj2 == null ? 1 : 0;
                this.b = obj2;
            }
        }

        public Map.Entry<K, V> c() {
            d.b.a.b.b.c cVar;
            if (this.b) {
                this.b = false;
                this.a = bVar.a;
            } else {
                d.b.a.b.b.c cVar3 = this.a;
                cVar = cVar3 != null ? cVar3.c : 0;
                this.a = cVar;
            }
            return this.a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            d.b.a.b.b.c cVar;
            int i;
            i = 1;
            final int i2 = 0;
            if (this.b) {
                if (bVar.a != null) {
                } else {
                    i = i2;
                }
                return i;
            }
            cVar = this.a;
            if (cVar != null && cVar.c != null) {
                if (cVar.c != null) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }
    }

    private static abstract class e implements Iterator<Map.Entry<K, V>>, d.b.a.b.b.f<K, V> {

        d.b.a.b.b.c<K, V> a;
        d.b.a.b.b.c<K, V> b;
        e(d.b.a.b.b.c<K, V> b$c, d.b.a.b.b.c<K, V> b$c2) {
            super();
            this.a = c2;
            this.b = c;
        }

        private d.b.a.b.b.c<K, V> f() {
            d.b.a.b.b.c cVar = this.b;
            final d.b.a.b.b.c cVar3 = this.a;
            if (cVar != cVar3 && cVar3 == null) {
                if (cVar3 == null) {
                }
                return d(cVar);
            }
            return 0;
        }

        public void b(d.b.a.b.b.c<K, V> b$c) {
            d.b.a.b.b.c cVar;
            d.b.a.b.b.c cVar2;
            d.b.a.b.b.c obj2;
            if (this.a == c && c == this.b) {
                if (c == this.b) {
                    cVar = 0;
                    this.b = cVar;
                    this.a = cVar;
                }
            }
            cVar2 = this.a;
            if (cVar2 == c) {
                this.a = c(cVar2);
            }
            if (this.b == c) {
                this.b = f();
            }
        }

        abstract d.b.a.b.b.c<K, V> c(d.b.a.b.b.c<K, V> b$c);

        abstract d.b.a.b.b.c<K, V> d(d.b.a.b.b.c<K, V> b$c);

        public Map.Entry<K, V> e() {
            this.b = f();
            return this.b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.b != null ? 1 : 0;
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return e();
        }
    }

    static class a extends d.b.a.b.b.e<K, V> {
        a(d.b.a.b.b.c<K, V> b$c, d.b.a.b.b.c<K, V> b$c2) {
            super(c, c2);
        }

        d.b.a.b.b.c<K, V> c(d.b.a.b.b.c<K, V> b$c) {
            return c.v;
        }

        d.b.a.b.b.c<K, V> d(d.b.a.b.b.c<K, V> b$c) {
            return c.c;
        }
    }

    private static class b extends d.b.a.b.b.e<K, V> {
        b(d.b.a.b.b.c<K, V> b$c, d.b.a.b.b.c<K, V> b$c2) {
            super(c, c2);
        }

        d.b.a.b.b.c<K, V> c(d.b.a.b.b.c<K, V> b$c) {
            return c.c;
        }

        d.b.a.b.b.c<K, V> d(d.b.a.b.b.c<K, V> b$c) {
            return c.v;
        }
    }
    public b() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
        this.c = weakHashMap;
        int i = 0;
    }

    public Map.Entry<K, V> b() {
        return this.a;
    }

    protected d.b.a.b.b.c<K, V> d(K k) {
        d.b.a.b.b.c cVar;
        boolean equals;
        cVar = this.a;
        while (cVar != null) {
            if (cVar.a.equals(k)) {
                break;
            } else {
            }
            cVar = cVar.c;
        }
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        b.b bVar = new b.b(this.b, this.a);
        this.c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        int i;
        int equals;
        boolean next2;
        Object next;
        Iterator obj6;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof b) {
            return i2;
        }
        if (size() != (b)object.size()) {
            return i2;
        }
        Iterator iterator = iterator();
        obj6 = object.iterator();
        while (iterator.hasNext()) {
            equals = iterator.next();
            next = obj6.next();
        }
        if (!iterator.hasNext() && !obj6.hasNext()) {
            if (!obj6.hasNext()) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public d.b.a.b.b.d<K, V> g() {
        b.d dVar = new b.d(this);
        this.c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> h() {
        return this.b;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int i2;
        int i;
        final Iterator iterator = iterator();
        i2 = 0;
        for (Map.Entry next2 : iterator) {
            i2 += i;
        }
        return i2;
    }

    protected d.b.a.b.b.c<K, V> i(K k, V v2) {
        b.c cVar = new b.c(k, v2);
        this.v = obj2++;
        d.b.a.b.b.c obj2 = this.b;
        if (obj2 == null) {
            this.a = cVar;
            this.b = cVar;
            return cVar;
        }
        obj2.c = cVar;
        cVar.v = obj2;
        this.b = cVar;
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        b.a aVar = new b.a(this.a, this.b);
        this.c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V l(K k, V v2) {
        final d.b.a.b.b.c cVar = d(k);
        if (cVar != null) {
            return cVar.b;
        }
        i(k, v2);
        return 0;
    }

    public V m(K k) {
        boolean iterator;
        Object next;
        d.b.a.b.b.c cVar;
        d.b.a.b.b.c obj4 = d(k);
        final int i = 0;
        if (obj4 == null) {
            return i;
        }
        this.v = i2--;
        if (!this.c.isEmpty()) {
            iterator = this.c.keySet().iterator();
            for (b.f next : iterator) {
                next.b(obj4);
            }
        }
        d.b.a.b.b.c cVar2 = obj4.v;
        if (cVar2 != null) {
            cVar2.c = obj4.c;
        } else {
            this.a = obj4.c;
        }
        d.b.a.b.b.c cVar3 = obj4.c;
        if (cVar3 != null) {
            cVar3.v = cVar2;
        } else {
            this.b = cVar2;
        }
        obj4.c = i;
        obj4.v = i;
        return obj4.b;
    }

    @Override // java.lang.Iterable
    public int size() {
        return this.v;
    }

    @Override // java.lang.Iterable
    public String toString() {
        boolean next;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            stringBuilder.append((Map.Entry)iterator.next().toString());
            if (iterator.hasNext()) {
            }
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
