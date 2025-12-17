package d.b.a.b;

import java.util.HashMap;
import java.util.Map.Entry;

/* loaded from: classes.dex */
public class a<K, V>  extends d.b.a.b.b<K, V> {

    private HashMap<K, d.b.a.b.b.c<K, V>> w;
    public a() {
        super();
        HashMap hashMap = new HashMap();
        this.w = hashMap;
    }

    public boolean contains(K k) {
        return this.w.containsKey(k);
    }

    protected d.b.a.b.b.c<K, V> d(K k) {
        return (b.c)this.w.get(k);
    }

    public V l(K k, V v2) {
        d.b.a.b.b.c cVar = d(k);
        if (cVar != null) {
            return cVar.b;
        }
        this.w.put(k, i(k, v2));
        return 0;
    }

    public V m(K k) {
        this.w.remove(k);
        return super.m(k);
    }

    public Map.Entry<K, V> p(K k) {
        if (contains(k)) {
            return obj2.v;
        }
        return 0;
    }
}
