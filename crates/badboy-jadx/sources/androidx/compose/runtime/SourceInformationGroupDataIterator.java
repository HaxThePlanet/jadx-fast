package androidx.compose.runtime;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\u0011\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0096\u0002J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/SourceInformationGroupDataIterator;", "", "", "", "table", "Landroidx/compose/runtime/SlotTable;", "group", "", "sourceInformation", "Landroidx/compose/runtime/GroupSourceInformation;", "(Landroidx/compose/runtime/SlotTable;ILandroidx/compose/runtime/GroupSourceInformation;)V", "base", "end", "filter", "Landroidx/compose/runtime/BitVector;", "index", "start", "getTable", "()Landroidx/compose/runtime/SlotTable;", "hasNext", "", "iterator", "next", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SourceInformationGroupDataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {

    private final int base;
    private final int end;
    private final androidx.compose.runtime.BitVector filter;
    private int index;
    private final int start;
    private final androidx.compose.runtime.SlotTable table;
    public SourceInformationGroupDataIterator(androidx.compose.runtime.SlotTable table, int group, androidx.compose.runtime.GroupSourceInformation sourceInformation) {
        int it;
        int i2;
        int slotsSize;
        int base;
        int groupsSize;
        java.util.ArrayList list;
        int i3;
        int index$iv;
        int size;
        Object obj;
        Object obj2;
        int i;
        boolean dataStartOffset;
        int dataEndOffset;
        final Object obj3 = this;
        final int i4 = group;
        super();
        obj3.table = table;
        obj3.base = SlotTableKt.access$dataAnchor(obj3.table.getGroups(), i4);
        obj3.start = sourceInformation.getDataStartOffset();
        int i6 = 0;
        if (sourceInformation.getDataEndOffset() > 0) {
        } else {
            if (i4 + 1 < obj3.table.getGroupsSize()) {
                slotsSize = SlotTableKt.access$dataAnchor(obj3.table.getGroups(), i4 + 1);
            } else {
                slotsSize = obj3.table.getSlotsSize();
            }
            it = i2;
        }
        obj3.end = it;
        BitVector bitVector = new BitVector();
        int i7 = 0;
        java.util.ArrayList groups3 = sourceInformation.getGroups();
        if (groups3 == null) {
        } else {
            list = groups3;
            i3 = 0;
            index$iv = 0;
            while (index$iv < (List)list.size()) {
                obj2 = obj;
                i = 0;
                if (obj2 instanceof GroupSourceInformation) {
                }
                index$iv++;
                bitVector.setRange((GroupSourceInformation)obj2.getDataStartOffset(), (GroupSourceInformation)obj2.getDataEndOffset());
            }
        }
        obj3.filter = bitVector;
        obj3.index = obj3.filter.nextClear(obj3.start);
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
        int i;
        int index2;
        int index;
        index2 = this.index;
        int i3 = 1;
        index = 0;
        if (index2 >= 0 && index2 < this.end) {
            if (index2 < this.end) {
                index = i3;
            }
        }
        if (index != 0) {
            i = this.table.getSlots()[base += index];
        } else {
            i = 0;
        }
        int i2 = i;
        int i4 = 0;
        this.index = this.filter.nextClear(index3 += i3);
        return i;
    }

    @Override // java.lang.Iterable
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}
