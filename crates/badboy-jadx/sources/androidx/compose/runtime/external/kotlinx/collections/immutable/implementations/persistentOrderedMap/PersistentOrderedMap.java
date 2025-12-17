package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\"\n\u0002\u0008\u0005\n\u0002\u0010$\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 3*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u00013B3\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0018\u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\u0002\u0010\u000bJ\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u0015\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010&J\u001a\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\rH\u0002J\u0018\u0010(\u001a\u0004\u0018\u00018\u00012\u0006\u0010%\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010)J\u001a\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0*H\u0001J)\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001a\u00028\u00002\u0006\u0010,\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010-J*\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\u0010/\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0016J!\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00102J)\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001a\u00028\u00002\u0006\u0010,\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010-R&\u0010\u000c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R&\u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00010\n0\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0010R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001f¨\u00064", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "K", "V", "Lkotlin/collections/AbstractMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "firstKey", "", "lastKey", "hashMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "getFirstKey$runtime_release", "()Ljava/lang/Object;", "getHashMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "keys", "getKeys", "getLastKey$runtime_release", "size", "", "getSize", "()I", "values", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "clear", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "createEntries", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "putAll", "m", "", "remove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentOrderedMap<K, V>  extends AbstractMap<K, V> implements PersistentMap<K, V> {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion Companion;
    private static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap EMPTY;
    private final Object firstKey;
    private final PersistentHashMap<K, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V>> hashMap;
    private final Object lastKey;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0005\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u0004\"\u0004\u0008\u0002\u0010\u0007\"\u0004\u0008\u0003\u0010\u0008H\u0000¢\u0006\u0002\u0008\tR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "", "emptyOf", "K", "V", "emptyOf$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K, V> emptyOf$runtime_release() {
            final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap map = PersistentOrderedMap.access$getEMPTY$cp();
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf>");
            return map;
        }
    }
    static {
        PersistentOrderedMap.Companion companion = new PersistentOrderedMap.Companion(0);
        PersistentOrderedMap.Companion = companion;
        int i = 8;
        PersistentOrderedMap persistentOrderedMap = new PersistentOrderedMap(EndOfChain.INSTANCE, EndOfChain.INSTANCE, PersistentHashMap.Companion.emptyOf$runtime_release());
        PersistentOrderedMap.EMPTY = persistentOrderedMap;
    }

    public PersistentOrderedMap(Object firstKey, Object lastKey, PersistentHashMap<K, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V>> hashMap) {
        super();
        this.firstKey = firstKey;
        this.lastKey = lastKey;
        this.hashMap = hashMap;
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap access$getEMPTY$cp() {
        return PersistentOrderedMap.EMPTY;
    }

    private final ImmutableSet<Map.Entry<K, V>> createEntries() {
        PersistentOrderedMapEntries persistentOrderedMapEntries = new PersistentOrderedMapEntries(this);
        return (ImmutableSet)persistentOrderedMapEntries;
    }

    public PersistentMap.Builder<K, V> builder() {
        PersistentOrderedMapBuilder persistentOrderedMapBuilder = new PersistentOrderedMapBuilder(this);
        return (PersistentMap.Builder)persistentOrderedMapBuilder;
    }

    public PersistentMap<K, V> clear() {
        return (PersistentMap)PersistentOrderedMap.Companion.emptyOf$runtime_release();
    }

    @Override // kotlin.collections.AbstractMap
    public boolean containsKey(Object key) {
        return this.hashMap.containsKey(key);
    }

    public final ImmutableSet<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public V get(Object key) {
        Object value;
        Object obj = this.hashMap.get(key);
        if ((LinkedValue)obj != null) {
            value = (LinkedValue)obj.getValue();
        } else {
            value = 0;
        }
        return value;
    }

    public ImmutableSet<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    public final Set<Map.Entry<K, V>> getEntries() {
        return (Set)createEntries();
    }

    @Override // kotlin.collections.AbstractMap
    public final Object getFirstKey$runtime_release() {
        return this.firstKey;
    }

    public final PersistentHashMap<K, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V>> getHashMap$runtime_release() {
        return this.hashMap;
    }

    public ImmutableSet<K> getKeys() {
        PersistentOrderedMapKeys persistentOrderedMapKeys = new PersistentOrderedMapKeys(this);
        return (ImmutableSet)persistentOrderedMapKeys;
    }

    @Override // kotlin.collections.AbstractMap
    public Set getKeys() {
        return (Set)getKeys();
    }

    @Override // kotlin.collections.AbstractMap
    public final Object getLastKey$runtime_release() {
        return this.lastKey;
    }

    @Override // kotlin.collections.AbstractMap
    public int getSize() {
        return this.hashMap.size();
    }

    public ImmutableCollection<V> getValues() {
        PersistentOrderedMapValues persistentOrderedMapValues = new PersistentOrderedMapValues(this);
        return (ImmutableCollection)persistentOrderedMapValues;
    }

    @Override // kotlin.collections.AbstractMap
    public Collection getValues() {
        return (Collection)getValues();
    }

    public final ImmutableSet<K> keySet() {
        return getKeys();
    }

    @Override // kotlin.collections.AbstractMap
    public PersistentMap put(Object key, Object value) {
        return (PersistentMap)put(key, value);
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K, V> put(K key, V value) {
        if (isEmpty()) {
            LinkedValue linkedValue = new LinkedValue(value);
            PersistentOrderedMap persistentOrderedMap = new PersistentOrderedMap(key, key, this.hashMap.put(key, linkedValue));
            return persistentOrderedMap;
        }
        Object obj = this.hashMap.get(key);
        if (obj != null && (LinkedValue)obj.getValue() == value) {
            if (obj.getValue() == value) {
                return this;
            }
            PersistentOrderedMap persistentOrderedMap2 = new PersistentOrderedMap(this.firstKey, this.lastKey, this.hashMap.put(key, obj.withValue(value)));
            return persistentOrderedMap2;
        }
        Object newMap2 = this.lastKey;
        Object obj2 = this.hashMap.get(newMap2);
        Intrinsics.checkNotNull(obj2);
        LinkedValue linkedValue2 = new LinkedValue(value, newMap2);
        PersistentOrderedMap persistentOrderedMap3 = new PersistentOrderedMap(this.firstKey, key, this.hashMap.put(newMap2, (LinkedValue)obj2.withNext(key)).put(key, linkedValue2));
        return persistentOrderedMap3;
    }

    public PersistentMap<K, V> putAll(Map<? extends K, ? extends V> m) {
        Object obj = this;
        final int i = 0;
        Intrinsics.checkNotNull((PersistentMap)obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder builder = obj.builder();
        final int i2 = 0;
        (Map)builder.putAll(m);
        return builder.build();
    }

    @Override // kotlin.collections.AbstractMap
    public PersistentMap remove(Object key) {
        return (PersistentMap)remove(key);
    }

    @Override // kotlin.collections.AbstractMap
    public PersistentMap remove(Object key, Object value) {
        return (PersistentMap)remove(key, value);
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K, V> remove(K key) {
        PersistentHashMap newMap;
        boolean hasPrevious;
        boolean hasNext;
        Object firstKey;
        Object previous;
        Object lastKey;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue previous2;
        Object obj = this.hashMap.get(key);
        if ((LinkedValue)obj == null) {
            return this;
        }
        newMap = this.hashMap.remove(key);
        if ((LinkedValue)obj.getHasPrevious()) {
            hasPrevious = (Map)newMap.get(obj.getPrevious());
            Intrinsics.checkNotNull(hasPrevious);
            newMap = newMap.put(obj.getPrevious(), (LinkedValue)hasPrevious.withNext(obj.getNext()));
        }
        if (obj.getHasNext()) {
            hasNext = (Map)newMap.get(obj.getNext());
            Intrinsics.checkNotNull(hasNext);
            newMap = newMap.put(obj.getNext(), (LinkedValue)hasNext.withPrevious(obj.getPrevious()));
        }
        if (!obj.getHasPrevious()) {
            firstKey = obj.getNext();
        } else {
            firstKey = this.firstKey;
        }
        if (!obj.getHasNext()) {
            lastKey = obj.getPrevious();
        } else {
            lastKey = this.lastKey;
        }
        PersistentOrderedMap persistentOrderedMap = new PersistentOrderedMap(firstKey, lastKey, newMap);
        return persistentOrderedMap;
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K, V> remove(K key, V value) {
        Object remove;
        Object obj = this.hashMap.get(key);
        if ((LinkedValue)obj == null) {
            return this;
        }
        if (Intrinsics.areEqual((LinkedValue)obj.getValue(), value)) {
            remove = remove(key);
        } else {
            remove = this;
        }
        return remove;
    }

    public final ImmutableCollection<V> values() {
        return getValues();
    }
}
