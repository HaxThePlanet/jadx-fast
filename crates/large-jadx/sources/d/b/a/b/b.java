package d.b.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    b.c<K, V> a;
    private b.c<K, V> b;
    private WeakHashMap<b.f<K, V>, Boolean> c = new WeakHashMap<>();
    private int v = 0;

    static class c<K, V> implements Map.Entry<K, V> {

        final K a;
        final V b;
        b.c<K, V> c;
        b.c<K, V> v;
        c(K k, V v) {
            super();
            this.a = k;
            this.b = v;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object object) {
            boolean z = true;
            boolean equals;
            boolean equals2;
            z = true;
            if (object == this) {
                return true;
            }
            final int i = 0;
            if (!(object instanceof b.c)) {
                return false;
            }
            if (this.a.equals(object.a)) {
                if (!(this.b.equals(object.b))) {
                }
            }
            return z;
        }

        @Override // java.util.Map$Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map$Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map$Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "=";
            str = this.a + str2 + this.b;
            return str;
        }
    }

    interface f<K, V> {
        void b(b.c<K, V> cVar);
    }

    private class d implements Iterator<Map.Entry<K, V>>, b.f<K, V> {

        private b.c<K, V> a;
        private boolean b = true;
        final /* synthetic */ b c;
        d() {
            this.c = bVar;
            super();
        }

        public void b(b.c<K, V> cVar) {
            int i = 0;
            if (cVar == this.a) {
                this.a = cVar2.v;
                cVar = cVar2.v == null ? 1 : 0;
                this.b = (cVar2.v == null ? 1 : 0);
            }
        }

        public Map.Entry<K, V> c() {
            d.b.a.b.b.c cVar = null;
            if (this.b) {
                this.b = false;
                this.a = this.c.a;
            } else {
                d.b.a.b.b.c r0 = this.a != null ? cVar3.c : 0;
                this.a = (this.a != null ? cVar3.c : 0);
            }
            return this.a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            d.b.a.b.b.c cVar;
            boolean z2 = true;
            boolean z3 = true;
            int i2 = 1;
            final int i = 0;
            if (this.b) {
                if (this.c.a == null) {
                }
                return z3;
            }
            if (this.a == null || cVar.c == null) {
            }
            return z2;
        }
    }

    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, b.f<K, V> {

        b.c<K, V> a;
        b.c<K, V> b;
        e(b.c<K, V> cVar, b.c<K, V> cVar2) {
            super();
            this.a = cVar2;
            this.b = cVar;
        }

        private b.c<K, V> f() {
            return null;
        }

        public void b(b.c<K, V> cVar) {
            if (this.a == cVar && cVar == this.b) {
                d.b.a.b.b.c cVar2 = null;
                this.b = cVar2;
                this.a = cVar2;
            }
            if (this.a == cVar) {
                this.a = c(this.a);
            }
            if (this.b == cVar) {
                this.b = f();
            }
        }

        public Map.Entry<K, V> e() {
            this.b = f();
            return this.b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z = true;
            int r0 = this.b != null ? 1 : 0;
            return (this.b != null ? 1 : 0);
        }

        abstract b.c<K, V> c(b.c<K, V> cVar);

        abstract b.c<K, V> d(b.c<K, V> cVar);
    }

    static class a<K, V> extends b.e<K, V> {
        a(b.c<K, V> cVar, b.c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // d.b.a.b.b$e
        b.c<K, V> c(b.c<K, V> cVar) {
            return cVar.v;
        }

        @Override // d.b.a.b.b$e
        b.c<K, V> d(b.c<K, V> cVar) {
            return cVar.c;
        }
    }

    private static class b<K, V> extends b.e<K, V> {
        b(b.c<K, V> cVar, b.c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // d.b.a.b.b$e
        b.c<K, V> c(b.c<K, V> cVar) {
            return cVar.c;
        }

        @Override // d.b.a.b.b$e
        b.c<K, V> d(b.c<K, V> cVar) {
            return cVar.v;
        }
    }
    public b() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
    }

    public Map.Entry<K, V> b() {
        return this.a;
    }

    protected b.c<K, V> d(K k) {
        d.b.a.b.b.c cVar;
        boolean equals;
        while (this.a != null) {
            if (cVar.a.equals(k)) {
                break;
            }
        }
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        final d.b.a.b.b.b bVar = new b.b(this.b, this.a);
        this.c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        Iterator it;
        z = true;
        if (object == this) {
            return true;
        }
        final int i = 0;
        if (!(object instanceof b)) {
            return false;
        }
        if (size() != object.size()) {
            return false;
        }
        Iterator it2 = iterator();
        it = object.iterator();
        while (it2.hasNext()) {
            Object item2 = it2.next();
            Object item = it.next();
            if (item2 != null && !item2.equals(item)) {
            }
            if (item != null) {
                return false;
            }
        }
        if (it2.hasNext() || it.hasNext()) {
        }
        return z;
    }

    public b.d<K, V> g() {
        final d.b.a.b.b.d dVar = new b.d(this);
        this.c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> h() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        final Iterator it = iterator();
        i = 0;
        while (it.hasNext()) {
            i = i + (Map.Entry)it.next().hashCode();
        }
        return i;
    }

    protected b.c<K, V> i(K k, V v) {
        final d.b.a.b.b.c cVar = new b.c(k, v);
        this.v++;
        if (this.b == null) {
            this.a = cVar;
            this.b = cVar;
            return cVar;
        }
        this.b.c = cVar;
        cVar.v = this.b;
        this.b = cVar;
        return cVar;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        final d.b.a.b.b.a aVar = new b.a(this.a, this.b);
        this.c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V l(K k, V v) {
        final d.b.a.b.b.c cVar = d(k);
        if (cVar != null) {
            return cVar.b;
        }
        i(k, v);
        return null;
    }

    public V m(K k) {
        d.b.a.b.b.c cVar5 = d(k);
        final d.b.a.b.b.c cVar2 = null;
        if (cVar5 == null) {
            return cVar2;
        }
        this.v--;
        if (!this.c.isEmpty()) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                (b.f)it.next().b(cVar5);
            }
        }
        if (cVar5.v != null) {
            cVar5.v.c = cVar5.c;
        } else {
            this.a = cVar5.c;
        }
        if (cVar5.c != null) {
            cVar5.c.v = cVar5.v;
        } else {
            this.b = cVar5.v;
        }
        cVar5.c = cVar2;
        cVar5.v = cVar2;
        return cVar5.b;
    }

    public int size() {
        return this.v;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append((Map.Entry)it.next().toString());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
