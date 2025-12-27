package d.b.a.b;

import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    private HashMap<K, b.c<K, V>> w = new HashMap<>();
    public a() {
        super();
        final HashMap hashMap = new HashMap();
    }

    @Override // d.b.a.b.b
    public boolean contains(K k) {
        return this.w.containsKey(k);
    }

    @Override // d.b.a.b.b
    protected b.c<K, V> d(K k) {
        return (b.c)this.w.get(k);
    }

    @Override // d.b.a.b.b
    public V l(K k, V v) {
        d.b.a.b.b.c cVar = d(k);
        if (cVar != null) {
            return cVar.b;
        }
        this.w.put(k, i(k, v));
        return null;
    }

    @Override // d.b.a.b.b
    public V m(K k) {
        this.w.remove(k);
        return super.m(k);
    }

    @Override // d.b.a.b.b
    public Map.Entry<K, V> p(K k) {
        if (contains(k)) {
            return (b.c)this.w.get(k).v;
        }
        return null;
    }
}
