package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010(\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00010)H\u0096\u0002R\u001a\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0002X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0010X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0014R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'¨\u0006*", d2 = {"Landroidx/compose/runtime/SourceInformationSlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "table", "Landroidx/compose/runtime/SlotTable;", "parent", "", "sourceInformation", "Landroidx/compose/runtime/GroupSourceInformation;", "identityPath", "Landroidx/compose/runtime/SourceInformationGroupPath;", "(Landroidx/compose/runtime/SlotTable;ILandroidx/compose/runtime/GroupSourceInformation;Landroidx/compose/runtime/SourceInformationGroupPath;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "data", "", "getData", "identity", "getIdentity", "()Ljava/lang/Object;", "getIdentityPath", "()Landroidx/compose/runtime/SourceInformationGroupPath;", "isEmpty", "", "()Z", "key", "getKey", "node", "getNode", "getParent", "()I", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "getSourceInformation", "()Landroidx/compose/runtime/GroupSourceInformation;", "getTable", "()Landroidx/compose/runtime/SlotTable;", "iterator", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SourceInformationSlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {

    private final Iterable<CompositionGroup> compositionGroups;
    private final androidx.compose.runtime.SourceInformationGroupPath identityPath;
    private final Object key;
    private final int parent;
    private final androidx.compose.runtime.GroupSourceInformation sourceInformation;
    private final androidx.compose.runtime.SlotTable table;
    public SourceInformationSlotTableGroup(androidx.compose.runtime.SlotTable table, int parent, androidx.compose.runtime.GroupSourceInformation sourceInformation, androidx.compose.runtime.SourceInformationGroupPath identityPath) {
        super();
        this.table = table;
        this.parent = parent;
        this.sourceInformation = sourceInformation;
        this.identityPath = identityPath;
        this.key = Integer.valueOf(this.sourceInformation.getKey());
        this.compositionGroups = (Iterable)this;
    }

    public Iterable<CompositionGroup> getCompositionGroups() {
        return this.compositionGroups;
    }

    public Iterable<Object> getData() {
        SourceInformationGroupDataIterator sourceInformationGroupDataIterator = new SourceInformationGroupDataIterator(this.table, this.parent, this.sourceInformation);
        return (Iterable)sourceInformationGroupDataIterator;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getIdentity() {
        return this.identityPath.getIdentity(this.table);
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public final androidx.compose.runtime.SourceInformationGroupPath getIdentityPath() {
        return this.identityPath;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public Object getNode() {
        return null;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public final int getParent() {
        return this.parent;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public String getSourceInfo() {
        return this.sourceInformation.getSourceInformation();
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public final androidx.compose.runtime.GroupSourceInformation getSourceInformation() {
        return this.sourceInformation;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public final androidx.compose.runtime.SlotTable getTable() {
        return this.table;
    }

    @Override // androidx.compose.runtime.tooling.CompositionGroup
    public boolean isEmpty() {
        ArrayList groups;
        int i;
        groups = this.sourceInformation.getGroups();
        i = 0;
        if (groups != null && !groups.isEmpty()) {
            if (!groups.isEmpty()) {
                i = i3;
            }
        }
        return i ^ 1;
    }

    public Iterator<CompositionGroup> iterator() {
        SourceInformationGroupIterator sourceInformationGroupIterator = new SourceInformationGroupIterator(this.table, this.parent, this.sourceInformation, this.identityPath);
        return (Iterator)sourceInformationGroupIterator;
    }
}
