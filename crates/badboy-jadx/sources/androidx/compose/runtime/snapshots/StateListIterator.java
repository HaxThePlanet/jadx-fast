package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\n\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015J\u0008\u0010\u0016\u001a\u00020\u0006H\u0016J\r\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0008\u0010\u0018\u001a\u00020\u0006H\u0016J\u0008\u0010\u0019\u001a\u00020\u000eH\u0016J\u0015\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0008\u0010\u001b\u001a\u00020\u000eH\u0002R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Landroidx/compose/runtime/snapshots/StateListIterator;", "T", "", "list", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "offset", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;I)V", "index", "lastRequested", "getList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "structure", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "validateModification", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StateListIterator<T>  implements ListIterator<T>, KMutableListIterator {

    private int index;
    private int lastRequested = -1;
    private final androidx.compose.runtime.snapshots.SnapshotStateList<T> list;
    private int structure;
    public StateListIterator(androidx.compose.runtime.snapshots.SnapshotStateList<T> list, int offset) {
        super();
        this.list = list;
        this.index = offset + -1;
        int i2 = -1;
        this.structure = this.list.getStructure$runtime_release();
    }

    private final void validateModification() {
        if (this.list.getStructure$runtime_release() != this.structure) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public void add(T element) {
        validateModification();
        this.list.add(index2++, element);
        this.lastRequested = -1;
        this.index = index++;
        this.structure = this.list.getStructure$runtime_release();
    }

    public final androidx.compose.runtime.snapshots.SnapshotStateList<T> getList() {
        return this.list;
    }

    @Override // java.util.ListIterator
    public boolean hasNext() {
        int i;
        if (this.index < size -= i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        int i;
        i = this.index >= 0 ? 1 : 0;
        return i;
    }

    public T next() {
        validateModification();
        index++;
        this.lastRequested = i;
        SnapshotStateListKt.access$validateRange(i, this.list.size());
        Object obj = this.list.get(i);
        final Object obj2 = obj;
        final int i2 = 0;
        this.index = i;
        return obj;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return index++;
    }

    public T previous() {
        validateModification();
        SnapshotStateListKt.access$validateRange(this.index, this.list.size());
        this.lastRequested = this.index;
        Object obj = this.list.get(this.index);
        Object obj2 = obj;
        final int i = 0;
        this.index = index4--;
        return obj;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator
    public void remove() {
        validateModification();
        this.list.remove(this.index);
        int i2 = -1;
        this.index = index += i2;
        this.lastRequested = i2;
        this.structure = this.list.getStructure$runtime_release();
    }

    public void set(T element) {
        validateModification();
        if (this.lastRequested < 0) {
        } else {
            this.list.set(this.lastRequested, element);
            this.structure = this.list.getStructure$runtime_release();
        }
        SnapshotStateListKt.access$invalidIteratorSet();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }
}
