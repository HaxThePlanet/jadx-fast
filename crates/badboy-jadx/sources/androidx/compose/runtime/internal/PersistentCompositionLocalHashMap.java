package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMapKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.PersistentCompositionLocalMap.Builder;
import androidx.compose.runtime.ValueHolder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.Companion;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u0000 \u00192\u001e\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005:\u0002\u0018\u0019B1\u0012\"\u0010\u0006\u001a\u001e\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u0002H\u0013\"\u0004\u0008\u0000\u0010\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\u00020\u00052\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004H\u0016R6\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\r0\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u001a", d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "size", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "builder", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "get", "T", "key", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "putValue", "value", "Builder", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentCompositionLocalHashMap extends PersistentHashMap<CompositionLocal<Object>, ValueHolder<Object>> implements PersistentCompositionLocalMap {

    public static final int $stable;
    public static final androidx.compose.runtime.internal.PersistentCompositionLocalHashMap.Companion Companion;
    private static final androidx.compose.runtime.internal.PersistentCompositionLocalHashMap Empty;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u001e\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000c\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u0008¨\u0006\r", d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "map", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "(Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "setMap$runtime_release", "build", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder extends PersistentHashMapBuilder<CompositionLocal<Object>, ValueHolder<Object>> implements PersistentCompositionLocalMap.Builder {

        public static final int $stable = 8;
        private androidx.compose.runtime.internal.PersistentCompositionLocalHashMap map;
        static {
            final int i = 8;
        }

        public Builder(androidx.compose.runtime.internal.PersistentCompositionLocalHashMap map) {
            super((PersistentHashMap)map);
            this.map = map;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public PersistentCompositionLocalMap build() {
            return (PersistentCompositionLocalMap)build();
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public PersistentMap build() {
            return (PersistentMap)build();
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public PersistentHashMap build() {
            return (PersistentHashMap)build();
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public androidx.compose.runtime.internal.PersistentCompositionLocalHashMap build() {
            androidx.compose.runtime.internal.PersistentCompositionLocalHashMap persistentCompositionLocalHashMap;
            TrieNode node$runtime_release;
            int size;
            if (getNode$runtime_release() == this.map.getNode$runtime_release()) {
                persistentCompositionLocalHashMap = this.map;
            } else {
                MutabilityOwnership mutabilityOwnership = new MutabilityOwnership();
                setOwnership(mutabilityOwnership);
                persistentCompositionLocalHashMap = new PersistentCompositionLocalHashMap(getNode$runtime_release(), size());
            }
            this.map = persistentCompositionLocalHashMap;
            return this.map;
        }

        public boolean containsKey(CompositionLocal<Object> key) {
            return super.containsKey(key);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public final boolean containsKey(Object key) {
            if (!key instanceof CompositionLocal) {
                return 0;
            }
            return containsKey((CompositionLocal)key);
        }

        public boolean containsValue(ValueHolder<Object> value) {
            return super.containsValue(value);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public final boolean containsValue(Object value) {
            if (!value instanceof ValueHolder) {
                return 0;
            }
            return containsValue((ValueHolder)value);
        }

        public ValueHolder<Object> get(CompositionLocal<Object> key) {
            return (ValueHolder)super.get(key);
        }

        public final ValueHolder<Object> get(Object key) {
            if (!key instanceof CompositionLocal) {
                return 0;
            }
            return get((CompositionLocal)key);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public final Object get(Object key) {
            if (!key instanceof CompositionLocal) {
                return null;
            }
            return get((CompositionLocal)key);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public final androidx.compose.runtime.internal.PersistentCompositionLocalHashMap getMap$runtime_release() {
            return this.map;
        }

        public ValueHolder<Object> getOrDefault(CompositionLocal<Object> key, ValueHolder<Object> defaultValue) {
            return (ValueHolder)super.getOrDefault(key, defaultValue);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public final ValueHolder getOrDefault(Object key, ValueHolder defaultValue) {
            if (!key instanceof CompositionLocal) {
                return defaultValue;
            }
            return getOrDefault((CompositionLocal)key, defaultValue);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public final Object getOrDefault(Object key, Object defaultValue) {
            if (!key instanceof CompositionLocal) {
                return defaultValue;
            }
            return getOrDefault((CompositionLocal)key, (ValueHolder)defaultValue);
        }

        public ValueHolder<Object> remove(CompositionLocal<Object> key) {
            return (ValueHolder)super.remove(key);
        }

        public final ValueHolder<Object> remove(Object key) {
            if (!key instanceof CompositionLocal) {
                return 0;
            }
            return remove((CompositionLocal)key);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public final Object remove(Object key) {
            if (!key instanceof CompositionLocal) {
                return null;
            }
            return remove((CompositionLocal)key);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder
        public final void setMap$runtime_release(androidx.compose.runtime.internal.PersistentCompositionLocalHashMap <set-?>) {
            this.map = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Companion;", "", "()V", "Empty", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "getEmpty$annotations", "getEmpty", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getEmpty$annotations() {
        }

        public final androidx.compose.runtime.internal.PersistentCompositionLocalHashMap getEmpty() {
            return PersistentCompositionLocalHashMap.access$getEmpty$cp();
        }
    }
    static {
        PersistentCompositionLocalHashMap.Companion companion = new PersistentCompositionLocalHashMap.Companion(0);
        PersistentCompositionLocalHashMap.Companion = companion;
        TrieNode eMPTY$runtime_release = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.ValueHolder<kotlin.Any?>>");
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = new PersistentCompositionLocalHashMap(eMPTY$runtime_release, 0);
        PersistentCompositionLocalHashMap.Empty = persistentCompositionLocalHashMap;
    }

    public PersistentCompositionLocalHashMap(TrieNode<CompositionLocal<Object>, ValueHolder<Object>> node, int size) {
        super(node, size);
    }

    public static final androidx.compose.runtime.internal.PersistentCompositionLocalHashMap access$getEmpty$cp() {
        return PersistentCompositionLocalHashMap.Empty;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    public PersistentCompositionLocalMap.Builder builder() {
        return (PersistentCompositionLocalMap.Builder)builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    public PersistentMap.Builder builder() {
        return (PersistentMap.Builder)builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    public PersistentHashMapBuilder builder() {
        return (PersistentHashMapBuilder)builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    public androidx.compose.runtime.internal.PersistentCompositionLocalHashMap.Builder builder() {
        PersistentCompositionLocalHashMap.Builder builder = new PersistentCompositionLocalHashMap.Builder(this);
        return builder;
    }

    public boolean containsKey(CompositionLocal<Object> key) {
        return super.containsKey(key);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    public final boolean containsKey(Object key) {
        if (!key instanceof CompositionLocal) {
            return 0;
        }
        return containsKey((CompositionLocal)key);
    }

    public boolean containsValue(ValueHolder<Object> value) {
        return super.containsValue(value);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    public final boolean containsValue(Object value) {
        if (!value instanceof ValueHolder) {
            return 0;
        }
        return containsValue((ValueHolder)value);
    }

    public ValueHolder<Object> get(CompositionLocal<Object> key) {
        return (ValueHolder)super.get(key);
    }

    public final ValueHolder<Object> get(Object key) {
        if (!key instanceof CompositionLocal) {
            return 0;
        }
        return get((CompositionLocal)key);
    }

    public <T> T get(CompositionLocal<T> key) {
        return CompositionLocalMapKt.read((PersistentCompositionLocalMap)this, key);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    public final Object get(Object key) {
        if (!key instanceof CompositionLocal) {
            return null;
        }
        return get((CompositionLocal)key);
    }

    public ImmutableSet<Map.Entry<CompositionLocal<Object>, ValueHolder<Object>>> getEntries() {
        return super.getEntries();
    }

    public ValueHolder<Object> getOrDefault(CompositionLocal<Object> key, ValueHolder<Object> defaultValue) {
        return (ValueHolder)super.getOrDefault(key, defaultValue);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    public final ValueHolder getOrDefault(Object key, ValueHolder defaultValue) {
        if (!key instanceof CompositionLocal) {
            return defaultValue;
        }
        return getOrDefault((CompositionLocal)key, defaultValue);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap
    public final Object getOrDefault(Object key, Object defaultValue) {
        if (!key instanceof CompositionLocal) {
            return defaultValue;
        }
        return getOrDefault((CompositionLocal)key, (ValueHolder)defaultValue);
    }

    public PersistentCompositionLocalMap putValue(CompositionLocal<Object> key, ValueHolder<Object> value) {
        TrieNode.ModificationResult map = getNode$runtime_release().put(key.hashCode(), key, value, 0);
        if (map == null) {
            return (PersistentCompositionLocalMap)this;
        }
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = new PersistentCompositionLocalHashMap(map.getNode(), size += sizeDelta);
        return (PersistentCompositionLocalMap)persistentCompositionLocalHashMap;
    }
}
