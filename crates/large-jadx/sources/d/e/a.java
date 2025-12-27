package d.e;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    f<K, V> z;

    class a extends f<K, V> {

        final /* synthetic */ a d;
        a() {
            this.d = aVar;
            super();
        }

        @Override // d.e.f
        protected void a() {
            this.d.clear();
        }

        @Override // d.e.f
        protected Object b(int i, int i2) {
            return this.d.b[(i << 1) + i2];
        }

        @Override // d.e.f
        protected Map<K, V> c() {
            return this.d;
        }

        @Override // d.e.f
        protected int d() {
            return this.d.c;
        }

        @Override // d.e.f
        protected int e(Object object) {
            return this.d.g(object);
        }

        @Override // d.e.f
        protected int f(Object object) {
            return this.d.i(object);
        }

        @Override // d.e.f
        protected void g(K k, V v) {
            this.d.put(k, v);
        }

        @Override // d.e.f
        protected void h(int i) {
            this.d.l(i);
        }

        @Override // d.e.f
        protected V i(int i, V v) {
            return this.d.m(i, v);
        }
    }
    private f<K, V> o() {
        if (this.z == null) {
            this.z = new a.a(this);
        }
        return this.z;
    }

    @Override // d.e.g
    public Set<Map.Entry<K, V>> entrySet() {
        return o().l();
    }

    @Override // d.e.g
    public Set<K> keySet() {
        return o().m();
    }

    @Override // d.e.g
    public boolean p(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // d.e.g
    public void putAll(Map<? extends K, ? extends V> map) {
        i = this.c + map.size();
        d(i);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            put(item.getKey(), item.getValue());
        }
    }

    @Override // d.e.g
    public Collection<V> values() {
        return o().n();
    }

    public a(int i) {
        super(i);
    }

    public a(g gVar) {
        super(gVar);
    }
}
