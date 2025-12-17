package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0002J\t\u0010\u0018\u001a\u00020\u0002H\u0096\u0002R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/SourceInformationGroupIterator;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "table", "Landroidx/compose/runtime/SlotTable;", "parent", "", "group", "Landroidx/compose/runtime/GroupSourceInformation;", "path", "Landroidx/compose/runtime/SourceInformationGroupPath;", "(Landroidx/compose/runtime/SlotTable;ILandroidx/compose/runtime/GroupSourceInformation;Landroidx/compose/runtime/SourceInformationGroupPath;)V", "getGroup", "()Landroidx/compose/runtime/GroupSourceInformation;", "index", "getParent", "()I", "getPath", "()Landroidx/compose/runtime/SourceInformationGroupPath;", "getTable", "()Landroidx/compose/runtime/SlotTable;", "version", "hasNext", "", "next", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SourceInformationGroupIterator implements Iterator<CompositionGroup>, KMappedMarker {

    private final androidx.compose.runtime.GroupSourceInformation group;
    private int index;
    private final int parent;
    private final androidx.compose.runtime.SourceInformationGroupPath path;
    private final androidx.compose.runtime.SlotTable table;
    private final int version;
    public SourceInformationGroupIterator(androidx.compose.runtime.SlotTable table, int parent, androidx.compose.runtime.GroupSourceInformation group, androidx.compose.runtime.SourceInformationGroupPath path) {
        super();
        this.table = table;
        this.parent = parent;
        this.group = group;
        this.path = path;
        this.version = this.table.getVersion$runtime_release();
    }

    @Override // java.util.Iterator
    public final androidx.compose.runtime.GroupSourceInformation getGroup() {
        return this.group;
    }

    @Override // java.util.Iterator
    public final int getParent() {
        return this.parent;
    }

    @Override // java.util.Iterator
    public final androidx.compose.runtime.SourceInformationGroupPath getPath() {
        return this.path;
    }

    @Override // java.util.Iterator
    public final androidx.compose.runtime.SlotTable getTable() {
        return this.table;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i2;
        int i;
        int index;
        int size;
        ArrayList groups = this.group.getGroups();
        i2 = 0;
        i = 0;
        if (groups != null && this.index < groups.size()) {
            i = 0;
            if (this.index < groups.size()) {
                i2 = 1;
            }
        }
        return i2;
    }

    @Override // java.util.Iterator
    public CompositionGroup next() {
        int i2;
        int index;
        Object sourceInformationSlotTableGroup;
        int i;
        androidx.compose.runtime.SlotTable table;
        int location$runtime_release;
        int version;
        androidx.compose.runtime.RelativeGroupPath relativeGroupPath;
        androidx.compose.runtime.SourceInformationGroupPath path;
        int i3;
        ArrayList groups = this.group.getGroups();
        if (groups != null) {
            index = this.index;
            this.index = index + 1;
            i2 = groups.get(index);
        } else {
            i2 = 0;
        }
        if (i2 instanceof Anchor) {
            sourceInformationSlotTableGroup = new SlotTableGroup(this.table, (Anchor)i2.getLocation$runtime_release(), this.version);
            return sourceInformationSlotTableGroup;
        } else {
            if (!i2 instanceof GroupSourceInformation) {
            } else {
                relativeGroupPath = new RelativeGroupPath(this.path, index2--);
                sourceInformationSlotTableGroup = new SourceInformationSlotTableGroup(this.table, this.parent, (GroupSourceInformation)i2, (SourceInformationGroupPath)relativeGroupPath);
            }
        }
        ComposerKt.composeRuntimeError("Unexpected group information structure");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // java.util.Iterator
    public Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}
