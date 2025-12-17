package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u0012\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\rH\u0016J\u000f\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00010)H\u0096\u0002J\u0008\u0010*\u001a\u00020+H\u0002R\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u001c\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0015R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u0010R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u0010¨\u0006,", d2 = {"Landroidx/compose/runtime/SlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "table", "Landroidx/compose/runtime/SlotTable;", "group", "", "version", "(Landroidx/compose/runtime/SlotTable;II)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "data", "", "getData", "getGroup", "()I", "groupSize", "getGroupSize", "identity", "getIdentity", "()Ljava/lang/Object;", "isEmpty", "", "()Z", "key", "getKey", "node", "getNode", "slotsSize", "getSlotsSize", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "getTable", "()Landroidx/compose/runtime/SlotTable;", "getVersion", "find", "identityToFind", "iterator", "", "validateRead", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {

    private final int group;
    private final androidx.compose.runtime.SlotTable table;
    private final int version;
    public SlotTableGroup(androidx.compose.runtime.SlotTable table, int group, int version) {
        super();
        this.table = table;
        this.group = group;
        this.version = version;
    }

    public SlotTableGroup(androidx.compose.runtime.SlotTable slotTable, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        if (i4 &= 4 != 0) {
            obj3 = slotTable.getVersion$runtime_release();
        }
        super(slotTable, i2, obj3);
    }

    private static final CompositionGroup find$findAnchoredGroup(androidx.compose.runtime.SlotTableGroup this$0, androidx.compose.runtime.Anchor anchor) {
        boolean anchorIndex;
        int group2;
        int i;
        int group;
        anchorIndex = this$0.table.anchorIndex(anchor);
        if (this$0.table.ownsAnchor(anchor) && anchorIndex >= this$0.group && anchorIndex - group3 < SlotTableKt.access$groupSize(this$0.table.getGroups(), this$0.group)) {
            anchorIndex = this$0.table.anchorIndex(anchor);
            if (anchorIndex >= this$0.group) {
                if (anchorIndex - group3 < SlotTableKt.access$groupSize(this$0.table.getGroups(), this$0.group)) {
                    SlotTableGroup slotTableGroup = new SlotTableGroup(this$0.table, anchorIndex, this$0.version);
                    return (CompositionGroup)slotTableGroup;
                }
            }
        }
        return null;
    }

    private static final CompositionGroup find$findRelativeGroup(CompositionGroup group, int index) {
        return (CompositionGroup)CollectionsKt.firstOrNull(CollectionsKt.drop(group.getCompositionGroups(), index));
    }

    private final void validateRead() {
        if (this.table.getVersion$runtime_release() != this.version) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public CompositionGroup find(Object identityToFind) {
        int it;
        int i;
        int index;
        if (identityToFind instanceof Anchor) {
            it = SlotTableGroup.find$findAnchoredGroup(this, (Anchor)identityToFind);
        } else {
            i = 0;
            if (identityToFind instanceof SourceInformationSlotTableGroupIdentity) {
                CompositionGroup find = find((SourceInformationSlotTableGroupIdentity)identityToFind.getParentIdentity());
                if (find != null) {
                    i = 0;
                    it = SlotTableGroup.find$findRelativeGroup(find, (SourceInformationSlotTableGroupIdentity)identityToFind.getIndex());
                } else {
                    it = i;
                }
            } else {
                it = i;
            }
        }
        return it;
    }

    public Iterable<CompositionGroup> getCompositionGroups() {
        return (Iterable)this;
    }

    public Iterable<Object> getData() {
        Object sourceInformationOf;
        int table;
        Object sourceInformationGroupDataIterator;
        androidx.compose.runtime.SlotTable table2;
        int group;
        sourceInformationOf = this.table.sourceInformationOf(this.group);
        if (sourceInformationOf != null) {
            table = 0;
            sourceInformationGroupDataIterator = new SourceInformationGroupDataIterator(this.table, this.group, sourceInformationOf);
        } else {
            sourceInformationOf = new DataIterator(this.table, this.group);
            sourceInformationGroupDataIterator = sourceInformationOf;
        }
        return sourceInformationGroupDataIterator;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public final int getGroup() {
        return this.group;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getGroupSize() {
        return SlotTableKt.access$groupSize(this.table.getGroups(), this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getIdentity() {
        validateRead();
        final int i = 0;
        final androidx.compose.runtime.SlotReader reader = this.table.openReader();
        final int i2 = 0;
        final int i3 = 0;
        reader.close();
        return reader.anchor(this.group);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getKey() {
        Object valueOf;
        int group2;
        int group;
        if (SlotTableKt.access$hasObjectKey(this.table.getGroups(), this.group)) {
            Intrinsics.checkNotNull(this.table.getSlots()[SlotTableKt.access$objectKeyIndex(this.table.getGroups(), this.group)]);
        } else {
            valueOf = Integer.valueOf(SlotTableKt.access$key(this.table.getGroups(), this.group));
        }
        return valueOf;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getNode() {
        Object obj;
        int group2;
        int group;
        if (SlotTableKt.access$isNode(this.table.getGroups(), this.group)) {
            obj = this.table.getSlots()[SlotTableKt.access$nodeIndex(this.table.getGroups(), this.group)];
        } else {
            obj = 0;
        }
        return obj;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public int getSlotsSize() {
        int slotsSize;
        group += groupSize;
        if (i < this.table.getGroupsSize()) {
            slotsSize = SlotTableKt.access$dataAnchor(this.table.getGroups(), i);
        } else {
            slotsSize = this.table.getSlotsSize();
        }
        return slotsSize - i2;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public String getSourceInfo() {
        Object sourceInformationOf;
        int sourceInformation;
        int group2;
        int group;
        sourceInformation = 0;
        if (SlotTableKt.access$hasAux(this.table.getGroups(), this.group)) {
            sourceInformationOf = this.table.getSlots()[SlotTableKt.access$auxIndex(this.table.getGroups(), this.group)];
            if (sourceInformationOf instanceof String != null) {
                sourceInformation = sourceInformationOf;
            }
        } else {
            sourceInformationOf = this.table.sourceInformationOf(this.group);
            if (sourceInformationOf != null) {
                sourceInformation = sourceInformationOf.getSourceInformation();
            }
        }
        return sourceInformation;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public final androidx.compose.runtime.SlotTable getTable() {
        return this.table;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public final int getVersion() {
        return this.version;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public boolean isEmpty() {
        int i;
        i = SlotTableKt.access$groupSize(this.table.getGroups(), this.group) == 0 ? 1 : 0;
        return i;
    }

    public Iterator<CompositionGroup> iterator() {
        Object sourceInformationOf;
        int table;
        Object sourceInformationGroupIterator;
        androidx.compose.runtime.SlotTable table2;
        int group;
        androidx.compose.runtime.AnchoredGroupPath anchoredGroupPath;
        int group2;
        validateRead();
        sourceInformationOf = this.table.sourceInformationOf(this.group);
        if (sourceInformationOf != null) {
            table = 0;
            anchoredGroupPath = new AnchoredGroupPath(this.group);
            sourceInformationGroupIterator = new SourceInformationGroupIterator(this.table, this.group, sourceInformationOf, (SourceInformationGroupPath)anchoredGroupPath);
        } else {
            sourceInformationOf = new GroupIterator(this.table, group4++, group5 += group);
            sourceInformationGroupIterator = sourceInformationOf;
        }
        return sourceInformationGroupIterator;
    }
}
