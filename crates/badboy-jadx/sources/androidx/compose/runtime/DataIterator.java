package androidx.compose.runtime;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\u0011\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0096\u0002J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000b\"\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u0018", d2 = {"Landroidx/compose/runtime/DataIterator;", "", "", "", "table", "Landroidx/compose/runtime/SlotTable;", "group", "", "(Landroidx/compose/runtime/SlotTable;I)V", "end", "getEnd", "()I", "index", "getIndex", "setIndex", "(I)V", "start", "getStart", "getTable", "()Landroidx/compose/runtime/SlotTable;", "hasNext", "", "iterator", "next", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {

    private final int end;
    private int index;
    private final int start;
    private final androidx.compose.runtime.SlotTable table;
    public DataIterator(androidx.compose.runtime.SlotTable table, int group) {
        int slotsSize;
        int groupsSize;
        super();
        this.table = table;
        this.start = SlotTableKt.access$dataAnchor(this.table.getGroups(), group);
        if (group + 1 < this.table.getGroupsSize()) {
            slotsSize = SlotTableKt.access$dataAnchor(this.table.getGroups(), group + 1);
        } else {
            slotsSize = this.table.getSlotsSize();
        }
        this.end = slotsSize;
        this.index = this.start;
    }

    @Override // java.lang.Iterable
    public final int getEnd() {
        return this.end;
    }

    @Override // java.lang.Iterable
    public final int getIndex() {
        return this.index;
    }

    @Override // java.lang.Iterable
    public final int getStart() {
        return this.start;
    }

    @Override // java.lang.Iterable
    public final androidx.compose.runtime.SlotTable getTable() {
        return this.table;
    }

    @Override // java.lang.Iterable
    public boolean hasNext() {
        int i;
        i = this.index < this.end ? 1 : 0;
        return i;
    }

    public Iterator<Object> iterator() {
        return (Iterator)this;
    }

    @Override // java.lang.Iterable
    public Object next() {
        int index;
        int i;
        int length;
        if (this.index >= 0 && this.index < slots2.length) {
            if (this.index < slots2.length) {
                i = this.table.getSlots()[this.index];
            } else {
                i = 0;
            }
        } else {
        }
        int i2 = i;
        final int i3 = 0;
        this.index = index2++;
        return i;
    }

    @Override // java.lang.Iterable
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.lang.Iterable
    public final void setIndex(int <set-?>) {
        this.index = <set-?>;
    }
}
