package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMutableSet;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008\"\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u00032\u0008\u0012\u0004\u0012\u0002H\u00030\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0012", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "K", "V", "E", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "getMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "size", "", "getSize", "()I", "clear", "", "isEmpty", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
abstract class SnapshotMapSet<K, V, E>  implements Set<E>, KMutableSet {

    private final androidx.compose.runtime.snapshots.SnapshotStateMap<K, V> map;
    public SnapshotMapSet(androidx.compose.runtime.snapshots.SnapshotStateMap<K, V> map) {
        super();
        this.map = map;
    }

    @Override // java.util.Set
    public void clear() {
        this.map.clear();
    }

    public final androidx.compose.runtime.snapshots.SnapshotStateMap<K, V> getMap() {
        return this.map;
    }

    @Override // java.util.Set
    public int getSize() {
        return this.map.size();
    }

    @Override // java.util.Set
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Set
    public final int size() {
        return getSize();
    }

    @Override // java.util.Set
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray((Collection)this, tArr);
    }
}
