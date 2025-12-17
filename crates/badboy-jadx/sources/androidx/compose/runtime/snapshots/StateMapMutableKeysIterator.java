package androidx.compose.runtime.snapshots;

import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\u0008\u0004\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u0004B3\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\u0008¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000c¨\u0006\r", d2 = {"Landroidx/compose/runtime/snapshots/StateMapMutableKeysIterator;", "K", "V", "Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "next", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StateMapMutableKeysIterator<K, V>  extends androidx.compose.runtime.snapshots.StateMapMutableIterator<K, V> implements Iterator<K>, KMutableIterator {
    public StateMapMutableKeysIterator(androidx.compose.runtime.snapshots.SnapshotStateMap<K, V> map, Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator) {
        super(map, iterator);
    }

    public K next() {
        Map.Entry next = getNext();
        if (next == null) {
        } else {
            advance();
            return next.getKey();
        }
        IllegalStateException result = new IllegalStateException();
        throw result;
    }
}
