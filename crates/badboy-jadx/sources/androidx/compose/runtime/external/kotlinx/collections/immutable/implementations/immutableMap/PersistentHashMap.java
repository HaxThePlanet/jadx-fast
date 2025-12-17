package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\"\n\u0002\u0008\u0005\n\u0002\u0010$\n\u0002\u0008\u0004\u0008\u0010\u0018\u0000 ,*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001,B!\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000c0\u000bH\u0002J\u0018\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\"J\u001a\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000c0#H\u0001J)\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010%\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010&J*\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\u0010(\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)H\u0016J!\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010+J)\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010%\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010&R&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000c0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006-", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "K", "V", "Lkotlin/collections/AbstractMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "size", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "keys", "getKeys", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "getSize", "()I", "values", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "clear", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "createEntries", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "putAll", "m", "", "remove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PersistentHashMap<K, V>  extends AbstractMap<K, V> implements PersistentMap<K, V> {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion Companion;
    private static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap EMPTY;
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> node;
    private final int size;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0005\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00080\u0004\"\u0004\u0008\u0002\u0010\u0007\"\u0004\u0008\u0003\u0010\u0008H\u0000¢\u0006\u0002\u0008\tR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "", "emptyOf", "K", "V", "emptyOf$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final <K, V> androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K, V> emptyOf$runtime_release() {
            final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap map = PersistentHashMap.access$getEMPTY$cp();
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            return map;
        }
    }
    static {
        PersistentHashMap.Companion companion = new PersistentHashMap.Companion(0);
        PersistentHashMap.Companion = companion;
        int i = 8;
        PersistentHashMap persistentHashMap = new PersistentHashMap(TrieNode.Companion.getEMPTY$runtime_release(), 0);
        PersistentHashMap.EMPTY = persistentHashMap;
    }

    public PersistentHashMap(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> node, int size) {
        super();
        this.node = node;
        this.size = size;
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap access$getEMPTY$cp() {
        return PersistentHashMap.EMPTY;
    }

    private final ImmutableSet<Map.Entry<K, V>> createEntries() {
        PersistentHashMapEntries persistentHashMapEntries = new PersistentHashMapEntries(this);
        return (ImmutableSet)persistentHashMapEntries;
    }

    @Override // kotlin.collections.AbstractMap
    public PersistentMap.Builder builder() {
        return (PersistentMap.Builder)builder();
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> builder() {
        PersistentHashMapBuilder persistentHashMapBuilder = new PersistentHashMapBuilder(this);
        return persistentHashMapBuilder;
    }

    public PersistentMap<K, V> clear() {
        return (PersistentMap)PersistentHashMap.Companion.emptyOf$runtime_release();
    }

    public boolean containsKey(K key) {
        int i;
        final int i2 = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = i2;
        }
        return this.node.containsKey(i, key, i2);
    }

    public final ImmutableSet<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public V get(K key) {
        int i;
        final int i2 = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = i2;
        }
        return this.node.get(i, key, i2);
    }

    public ImmutableSet<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    public final Set<Map.Entry<K, V>> getEntries() {
        return (Set)createEntries();
    }

    public ImmutableSet<K> getKeys() {
        PersistentHashMapKeys persistentHashMapKeys = new PersistentHashMapKeys(this);
        return (ImmutableSet)persistentHashMapKeys;
    }

    @Override // kotlin.collections.AbstractMap
    public Set getKeys() {
        return (Set)getKeys();
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> getNode$runtime_release() {
        return this.node;
    }

    @Override // kotlin.collections.AbstractMap
    public int getSize() {
        return this.size;
    }

    public ImmutableCollection<V> getValues() {
        PersistentHashMapValues persistentHashMapValues = new PersistentHashMapValues(this);
        return (ImmutableCollection)persistentHashMapValues;
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

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K, V> put(K key, V value) {
        int i;
        int i2 = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = i2;
        }
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult map = this.node.put(i, key, value, i2);
        if (map == null) {
            return this;
        }
        PersistentHashMap persistentHashMap = new PersistentHashMap(map.getNode(), size += sizeDelta);
        return persistentHashMap;
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

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K, V> remove(K key) {
        int i;
        int i2 = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = i2;
        }
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode remove = this.node.remove(i, key, i2);
        if (this.node == remove) {
            return this;
        }
        if (remove == null) {
            return PersistentHashMap.Companion.emptyOf$runtime_release();
        }
        PersistentHashMap persistentHashMap = new PersistentHashMap(remove, size--);
        return persistentHashMap;
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K, V> remove(K key, V value) {
        int i;
        int i2 = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = i2;
        }
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode remove = this.node.remove(i, key, value, i2);
        if (this.node == remove) {
            return this;
        }
        if (remove == null) {
            return PersistentHashMap.Companion.emptyOf$runtime_release();
        }
        PersistentHashMap persistentHashMap = new PersistentHashMap(remove, size--);
        return persistentHashMap;
    }

    public final ImmutableCollection<V> values() {
        return getValues();
    }
}
