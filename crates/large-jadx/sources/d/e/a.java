package d.e;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public class a<K, V>  extends d.e.g<K, V> implements Map<K, V> {

    d.e.f<K, V> z;

    class a extends d.e.f<K, V> {

        final d.e.a d;
        a(d.e.a a) {
            this.d = a;
            super();
        }

        @Override // d.e.f
        protected void a() {
            this.d.clear();
        }

        @Override // d.e.f
        protected Object b(int i, int i2) {
            return aVar.b[obj2 += i2];
        }

        protected Map<K, V> c() {
            return this.d;
        }

        @Override // d.e.f
        protected int d() {
            return aVar.c;
        }

        @Override // d.e.f
        protected int e(Object object) {
            return this.d.g(object);
        }

        @Override // d.e.f
        protected int f(Object object) {
            return this.d.i(object);
        }

        protected void g(K k, V v2) {
            this.d.put(k, v2);
        }

        @Override // d.e.f
        protected void h(int i) {
            this.d.l(i);
        }

        protected V i(int i, V v2) {
            return this.d.m(i, v2);
        }
    }
    public a(int i) {
        super(i);
    }

    public a(d.e.g g) {
        super(g);
    }

    private d.e.f<K, V> o() {
        d.e.f aVar;
        if (this.z == null) {
            aVar = new a.a(this);
            this.z = aVar;
        }
        return this.z;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return o().l();
    }

    public Set<K> keySet() {
        return o().m();
    }

    public boolean p(Collection<?> collection) {
        return f.p(this, collection);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int value;
        int size;
        d(i += size);
        Iterator obj3 = map.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            put(next2.getKey(), next2.getValue());
        }
    }

    public Collection<V> values() {
        return o().n();
    }
}
