package androidx.arch.core.internal;

import java.util.HashMap;
import java.util.Map.Entry;

/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V>  extends androidx.arch.core.internal.SafeIterableMap<K, V> {

    private final HashMap<K, androidx.arch.core.internal.SafeIterableMap.Entry<K, V>> mHashMap;
    public FastSafeIterableMap() {
        super();
        HashMap hashMap = new HashMap();
        this.mHashMap = hashMap;
    }

    public Map.Entry<K, V> ceil(K k) {
        if (contains(k)) {
            return obj.mPrevious;
        }
        return 0;
    }

    public boolean contains(K k) {
        return this.mHashMap.containsKey(k);
    }

    protected androidx.arch.core.internal.SafeIterableMap.Entry<K, V> get(K k) {
        return (SafeIterableMap.Entry)this.mHashMap.get(k);
    }

    public V putIfAbsent(K k, V v2) {
        final androidx.arch.core.internal.SafeIterableMap.Entry map = get(k);
        if (map != null) {
            return map.mValue;
        }
        this.mHashMap.put(k, put(k, v2));
        return 0;
    }

    public V remove(K k) {
        this.mHashMap.remove(k);
        return super.remove(k);
    }
}
