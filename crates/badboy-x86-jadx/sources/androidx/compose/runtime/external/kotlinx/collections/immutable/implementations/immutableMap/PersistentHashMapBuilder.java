package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u001f\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010$\n\u0002\u0008\u0003\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0016J\u0008\u00101\u001a\u000202H\u0016J\u0015\u00103\u001a\u0002042\u0006\u00105\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J\u0018\u00107\u001a\u0004\u0018\u00018\u00012\u0006\u00105\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00108J\u001f\u00109\u001a\u0004\u0018\u00018\u00012\u0006\u00105\u001a\u00028\u00002\u0006\u0010(\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010:J\u001e\u0010;\u001a\u0002022\u0014\u0010<\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010=H\u0016J\u0017\u0010>\u001a\u0004\u0018\u00018\u00012\u0006\u00105\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00108J\u001b\u0010>\u001a\u0002042\u0006\u00105\u001a\u00028\u00002\u0006\u0010(\u001a\u00028\u0001¢\u0006\u0002\u0010?R&\u0010\u0008\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000cR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00018\u0001X\u0080\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR$\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R$\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008*\u0010\u0012\"\u0004\u0008+\u0010\u0014R\u001a\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008.\u0010/¨\u0006@", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Lkotlin/collections/AbstractMutableMap;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "modCount", "", "getModCount$runtime_release", "()I", "setModCount$runtime_release", "(I)V", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode$runtime_release", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "operationResult", "getOperationResult$runtime_release", "()Ljava/lang/Object;", "setOperationResult$runtime_release", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "<set-?>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnership", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "value", "size", "getSize", "setSize", "values", "", "getValues", "()Ljava/util/Collection;", "build", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PersistentHashMapBuilder<K, V>  extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {

    public static final int $stable = 8;
    private androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K, V> map;
    private int modCount;
    private androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> node;
    private V operationResult;
    private MutabilityOwnership ownership;
    private int size;
    static {
        final int i = 8;
    }

    public PersistentHashMapBuilder(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K, V> map) {
        super();
        this.map = map;
        MutabilityOwnership mutabilityOwnership = new MutabilityOwnership();
        this.ownership = mutabilityOwnership;
        this.node = this.map.getNode$runtime_release();
        this.size = this.map.size();
    }

    @Override // kotlin.collections.AbstractMutableMap
    public PersistentMap build() {
        return (PersistentMap)build();
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K, V> build() {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap persistentHashMap;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode node$runtime_release;
        int size;
        if (this.node == this.map.getNode$runtime_release()) {
            persistentHashMap = this.map;
        } else {
            MutabilityOwnership mutabilityOwnership = new MutabilityOwnership();
            this.ownership = mutabilityOwnership;
            persistentHashMap = new PersistentHashMap(this.node, size());
        }
        this.map = persistentHashMap;
        return this.map;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public void clear() {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode eMPTY$runtime_release = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = eMPTY$runtime_release;
        setSize(0);
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

    public Set<Map.Entry<K, V>> getEntries() {
        PersistentHashMapBuilderEntries persistentHashMapBuilderEntries = new PersistentHashMapBuilderEntries(this);
        return (Set)persistentHashMapBuilderEntries;
    }

    public Set<K> getKeys() {
        PersistentHashMapBuilderKeys persistentHashMapBuilderKeys = new PersistentHashMapBuilderKeys(this);
        return (Set)persistentHashMapBuilderKeys;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> getNode$runtime_release() {
        return this.node;
    }

    public final V getOperationResult$runtime_release() {
        return this.operationResult;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final MutabilityOwnership getOwnership() {
        return this.ownership;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        PersistentHashMapBuilderValues persistentHashMapBuilderValues = new PersistentHashMapBuilderValues(this);
        return (Collection)persistentHashMapBuilderValues;
    }

    public V put(K key, V value) {
        int i;
        this.operationResult = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = 0;
        }
        final Object obj3 = this;
        obj3.node = this.node.mutablePut(i, key, value, 0, obj3);
        return obj3.operationResult;
    }

    public void putAll(Map<? extends K, ? extends V> from) {
        Object build;
        int i;
        int size;
        DeltaCounter deltaCounter;
        int i2;
        int count;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode node$runtime_release;
        String str;
        size = 0;
        if (from instanceof PersistentHashMap != null) {
            build = from;
        } else {
            build = size;
        }
        if (build == null) {
            if (from instanceof PersistentHashMapBuilder != null) {
                i = from;
            } else {
                i = size;
            }
            if (i != 0) {
                build = i.build();
            } else {
                build = size;
            }
        }
        if (build != null) {
            int i5 = 0;
            deltaCounter = new DeltaCounter(i5, 1, size);
            size = size();
            node$runtime_release = build.getNode$runtime_release();
            Intrinsics.checkNotNull(node$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
            this.node = this.node.mutablePutAll(node$runtime_release, i5, deltaCounter, this);
            i4 -= count;
            if (size != i2) {
                setSize(i2);
            }
        } else {
            super.putAll(from);
        }
    }

    public V remove(K key) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode eMPTY$runtime_release;
        int str;
        int i;
        this.operationResult = 0;
        str = 0;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = str;
        }
        if (this.node.mutableRemove(i, key, str, this) == null) {
            Intrinsics.checkNotNull(TrieNode.Companion.getEMPTY$runtime_release(), "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.node = eMPTY$runtime_release;
        return this.operationResult;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final boolean remove(Object key, Object value) {
        int i2;
        int i;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode obj9;
        Object obj10;
        if (key != null) {
            i2 = key.hashCode();
        } else {
            i2 = i;
        }
        final Object obj3 = this;
        if (this.node.mutableRemove(i2, key, value, 0, obj3) == null) {
            Intrinsics.checkNotNull(TrieNode.Companion.getEMPTY$runtime_release(), "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        obj3.node = obj9;
        if (size() != size()) {
            i = 1;
        }
        return i;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public final void setModCount$runtime_release(int <set-?>) {
        this.modCount = <set-?>;
    }

    public final void setNode$runtime_release(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> <set-?>) {
        this.node = <set-?>;
    }

    public final void setOperationResult$runtime_release(V <set-?>) {
        this.operationResult = <set-?>;
    }

    @Override // kotlin.collections.AbstractMutableMap
    protected final void setOwnership(MutabilityOwnership <set-?>) {
        this.ownership = <set-?>;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public void setSize(int value) {
        this.size = value;
        this.modCount = modCount++;
    }
}
