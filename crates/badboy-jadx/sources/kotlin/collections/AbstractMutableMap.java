package kotlin.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008'\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0008\u001a\u00028\u0001H&¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"Lkotlin/collections/AbstractMutableMap;", "K", "V", "", "Ljava/util/AbstractMap;", "()V", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractMutableMap<K, V>  extends AbstractMap<K, V> implements Map<K, V>, KMutableMap {
    public final Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.AbstractMap
    public abstract Set getEntries();

    public Set<Object> getKeys() {
        return super.keySet();
    }

    @Override // java.util.AbstractMap
    public int getSize() {
        return super.size();
    }

    public Collection<Object> getValues() {
        return super.values();
    }

    public final Set<K> keySet() {
        return getKeys();
    }

    public abstract V put(K k, V v2);

    @Override // java.util.AbstractMap
    public final int size() {
        return getSize();
    }

    public final Collection<V> values() {
        return getValues();
    }
}
