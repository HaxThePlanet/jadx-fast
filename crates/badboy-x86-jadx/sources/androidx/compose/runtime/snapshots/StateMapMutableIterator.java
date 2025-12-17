package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\"\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u00020\u0003B3\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00080\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\u001c\u001a\u00020\u001dH\u0004J\u0006\u0010\u001e\u001a\u00020\u001fJ\"\u0010 \u001a\u0002H!\"\u0004\u0008\u0002\u0010!2\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H!0#H\u0084\u0008¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\u001dR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0008X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0008X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u000c\"\u0004\u0008\u001b\u0010\u000e¨\u0006&", d2 = {"Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "K", "V", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "current", "getCurrent", "()Ljava/util/Map$Entry;", "setCurrent", "(Ljava/util/Map$Entry;)V", "getIterator", "()Ljava/util/Iterator;", "getMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "modification", "", "getModification", "()I", "setModification", "(I)V", "next", "getNext", "setNext", "advance", "", "hasNext", "", "modify", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "remove", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
abstract class StateMapMutableIterator<K, V>  {

    private Map.Entry<? extends K, ? extends V> current;
    private final Iterator<Map.Entry<K, V>> iterator;
    private final androidx.compose.runtime.snapshots.SnapshotStateMap<K, V> map;
    private int modification;
    private Map.Entry<? extends K, ? extends V> next;
    public StateMapMutableIterator(androidx.compose.runtime.snapshots.SnapshotStateMap<K, V> map, Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator) {
        super();
        this.map = map;
        this.iterator = iterator;
        this.modification = this.map.getModification$runtime_release();
        advance();
    }

    public static final int access$getModification(androidx.compose.runtime.snapshots.StateMapMutableIterator $this) {
        return $this.modification;
    }

    public static final void access$setModification(androidx.compose.runtime.snapshots.StateMapMutableIterator $this, int <set-?>) {
        $this.modification = <set-?>;
    }

    protected final void advance() {
        Object next;
        this.current = this.next;
        if (this.iterator.hasNext()) {
            next = this.iterator.next();
        } else {
            next = 0;
        }
        this.next = next;
    }

    protected final Map.Entry<K, V> getCurrent() {
        return this.current;
    }

    public final Iterator<Map.Entry<K, V>> getIterator() {
        return this.iterator;
    }

    public final androidx.compose.runtime.snapshots.SnapshotStateMap<K, V> getMap() {
        return this.map;
    }

    protected final int getModification() {
        return this.modification;
    }

    protected final Map.Entry<K, V> getNext() {
        return this.next;
    }

    public final boolean hasNext() {
        int i;
        i = this.next != null ? 1 : 0;
        return i;
    }

    protected final <T> T modify(Function0<? extends T> block) {
        final int i = 0;
        if (getMap().getModification$runtime_release() != StateMapMutableIterator.access$getModification(this)) {
        } else {
            Object invoke = block.invoke();
            Object obj = invoke;
            final int i3 = 0;
            StateMapMutableIterator.access$setModification(this, getMap().getModification$runtime_release());
            return invoke;
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public final void remove() {
        final androidx.compose.runtime.snapshots.StateMapMutableIterator map = this;
        final int i = 0;
        if (map.getMap().getModification$runtime_release() != StateMapMutableIterator.access$getModification(map)) {
        } else {
            int i2 = 0;
            Map.Entry current = this.current;
            if (current == null) {
            } else {
                this.map.remove(current.getKey());
                this.current = 0;
                Unit iNSTANCE = Unit.INSTANCE;
                int i4 = 0;
                StateMapMutableIterator.access$setModification(map, map.getMap().getModification$runtime_release());
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    protected final void setCurrent(Map.Entry<? extends K, ? extends V> <set-?>) {
        this.current = <set-?>;
    }

    protected final void setModification(int <set-?>) {
        this.modification = <set-?>;
    }

    protected final void setNext(Map.Entry<? extends K, ? extends V> <set-?>) {
        this.next = <set-?>;
    }
}
