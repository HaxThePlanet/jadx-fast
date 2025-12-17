package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0015\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderEntriesIterator;", "K", "V", "", "", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;)V", "internal", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderLinksIterator;", "hasNext", "", "next", "remove", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentOrderedMapBuilderEntriesIterator<K, V>  implements Iterator<Map.Entry<K, V>>, KMutableIterator {

    public static final int $stable = 8;
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilderLinksIterator<K, V> internal;
    static {
        final int i = 8;
    }

    public PersistentOrderedMapBuilderEntriesIterator(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder<K, V> map) {
        super();
        PersistentOrderedMapBuilderLinksIterator persistentOrderedMapBuilderLinksIterator = new PersistentOrderedMapBuilderLinksIterator(map.getFirstKey$runtime_release(), map);
        this.internal = persistentOrderedMapBuilderLinksIterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.internal.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return next();
    }

    public Map.Entry<K, V> next() {
        MutableMapEntry mutableMapEntry = new MutableMapEntry((Map)this.internal.getBuilder$runtime_release().getHashMapBuilder$runtime_release(), this.internal.getLastIteratedKey$runtime_release(), this.internal.next());
        return (Map.Entry)mutableMapEntry;
    }

    @Override // java.util.Iterator
    public void remove() {
        this.internal.remove();
    }
}
