package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u001f\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0016J\u0008\u0010$\u001a\u00020%H\u0016J\u0015\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010+J\u001f\u0010,\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010.J\u0017\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010+J\u001b\u0010/\u001a\u00020'2\u0006\u0010(\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u0001¢\u0006\u0002\u00100R&\u0010\u0008\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00010\u00140\u0013X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u000cR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!¨\u00061", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "K", "V", "Lkotlin/collections/AbstractMutableMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "", "firstKey", "getFirstKey$runtime_release", "()Ljava/lang/Object;", "hashMapBuilder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "getHashMapBuilder$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "keys", "getKeys", "lastKey", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentOrderedMapBuilder<K, V>  extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {

    public static final int $stable = 8;
    private Object firstKey;
    private final PersistentHashMapBuilder<K, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V>> hashMapBuilder;
    private Object lastKey;
    private androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K, V> map;
    static {
        final int i = 8;
    }

    public PersistentOrderedMapBuilder(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K, V> map) {
        super();
        this.map = map;
        this.firstKey = this.map.getFirstKey$runtime_release();
        this.lastKey = this.map.getLastKey$runtime_release();
        this.hashMapBuilder = this.map.getHashMap$runtime_release().builder();
    }

    public PersistentMap<K, V> build() {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap persistentOrderedMap;
        int i;
        Object lastKey$runtime_release;
        int lastKey;
        int i2;
        PersistentHashMap build = this.hashMapBuilder.build();
        if (build == this.map.getHashMap$runtime_release()) {
            i2 = 0;
            i = this.firstKey == this.map.getFirstKey$runtime_release() ? lastKey : i2;
            CommonFunctionsKt.assert(i);
            if (this.lastKey == this.map.getLastKey$runtime_release()) {
            } else {
                lastKey = i2;
            }
            CommonFunctionsKt.assert(lastKey);
            persistentOrderedMap = this.map;
        } else {
            persistentOrderedMap = new PersistentOrderedMap(this.firstKey, this.lastKey, build);
        }
        this.map = persistentOrderedMap;
        return (PersistentMap)this.map;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public void clear() {
        this.hashMapBuilder.clear();
        this.firstKey = EndOfChain.INSTANCE;
        this.lastKey = EndOfChain.INSTANCE;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public boolean containsKey(Object key) {
        return this.hashMapBuilder.containsKey(key);
    }

    public V get(Object key) {
        Object value;
        Object obj = this.hashMapBuilder.get(key);
        if ((LinkedValue)obj != null) {
            value = (LinkedValue)obj.getValue();
        } else {
            value = 0;
        }
        return value;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        PersistentOrderedMapBuilderEntries persistentOrderedMapBuilderEntries = new PersistentOrderedMapBuilderEntries(this);
        return (Set)persistentOrderedMapBuilderEntries;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final Object getFirstKey$runtime_release() {
        return this.firstKey;
    }

    public final PersistentHashMapBuilder<K, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V>> getHashMapBuilder$runtime_release() {
        return this.hashMapBuilder;
    }

    public Set<K> getKeys() {
        PersistentOrderedMapBuilderKeys persistentOrderedMapBuilderKeys = new PersistentOrderedMapBuilderKeys(this);
        return (Set)persistentOrderedMapBuilderKeys;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this.hashMapBuilder.size();
    }

    public Collection<V> getValues() {
        PersistentOrderedMapBuilderValues persistentOrderedMapBuilderValues = new PersistentOrderedMapBuilderValues(this);
        return (Collection)persistentOrderedMapBuilderValues;
    }

    public V put(K key, V value) {
        Object obj = this.hashMapBuilder.get(key);
        if (obj != null && (LinkedValue)obj.getValue() == value) {
            if (obj.getValue() == value) {
                return value;
            }
            (Map)this.hashMapBuilder.put(key, obj.withValue(value));
            return obj.getValue();
        }
        int i = 0;
        if (isEmpty()) {
            this.firstKey = key;
            this.lastKey = key;
            LinkedValue linkedValue = new LinkedValue(value);
            (Map)this.hashMapBuilder.put(key, linkedValue);
            return i;
        }
        Object lastKey = this.lastKey;
        Object obj2 = this.hashMapBuilder.get(lastKey);
        Intrinsics.checkNotNull(obj2);
        CommonFunctionsKt.assert(hasNext ^= 1);
        (Map)this.hashMapBuilder.put(lastKey, obj2.withNext(key));
        LinkedValue linkedValue2 = new LinkedValue(value, lastKey);
        (Map)this.hashMapBuilder.put(key, linkedValue2);
        this.lastKey = key;
        return i;
    }

    public V remove(Object key) {
        Object next;
        Object previous2;
        PersistentHashMapBuilder hashMapBuilder;
        Object previous3;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue previous;
        Object remove = this.hashMapBuilder.remove(key);
        if ((LinkedValue)remove == null) {
            return 0;
        }
        if ((LinkedValue)remove.getHasPrevious()) {
            next = (Map)this.hashMapBuilder.get(remove.getPrevious());
            Intrinsics.checkNotNull(next);
            (Map)this.hashMapBuilder.put(remove.getPrevious(), (LinkedValue)next.withNext(remove.getNext()));
        } else {
            this.firstKey = remove.getNext();
        }
        if (remove.getHasNext()) {
            previous2 = (Map)this.hashMapBuilder.get(remove.getNext());
            Intrinsics.checkNotNull(previous2);
            (Map)this.hashMapBuilder.put(remove.getNext(), (LinkedValue)previous2.withPrevious(remove.getPrevious()));
        } else {
            this.lastKey = remove.getPrevious();
        }
        return remove.getValue();
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final boolean remove(Object key, Object value) {
        int i;
        Object obj = this.hashMapBuilder.get(key);
        if ((LinkedValue)obj == null) {
            return 0;
        }
        if (!Intrinsics.areEqual((LinkedValue)obj.getValue(), value)) {
        } else {
            remove(key);
            i = 1;
        }
        return i;
    }
}
