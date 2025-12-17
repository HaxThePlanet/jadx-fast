package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\tH\u0002J\u0008\u0010\u0018\u001a\u00020\tH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "deactivated", "", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "dispose", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NestedMutableSnapshot extends androidx.compose.runtime.snapshots.MutableSnapshot {

    public static final int $stable = 8;
    private boolean deactivated;
    private final androidx.compose.runtime.snapshots.MutableSnapshot parent;
    static {
        final int i = 8;
    }

    public NestedMutableSnapshot(int id, androidx.compose.runtime.snapshots.SnapshotIdSet invalid, Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver, androidx.compose.runtime.snapshots.MutableSnapshot parent) {
        super(id, invalid, readObserver, writeObserver);
        this.parent = parent;
        this.parent.nestedActivated$runtime_release((Snapshot)this);
    }

    private final void deactivate() {
        boolean deactivated;
        Object obj;
        if (!this.deactivated) {
            this.deactivated = true;
            this.parent.nestedDeactivated$runtime_release((Snapshot)this);
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        boolean applied$runtime_release;
        int parent2;
        java.util.Map map;
        Object obj;
        androidx.compose.runtime.snapshots.SnapshotIdSet invalid$runtime_release;
        Object innerApplyLocked$runtime_release;
        MutableScatterSet modified$runtime_release;
        MutableScatterSet set;
        int parent;
        MutableScatterSet set2;
        if (!this.parent.getApplied$runtime_release()) {
            if (this.parent.getDisposed$runtime_release()) {
            } else {
                MutableScatterSet modified$runtime_release2 = getModified$runtime_release();
                int id = getId();
                int i = 0;
                if (modified$runtime_release2 != null) {
                    map = SnapshotKt.access$optimisticMerges(this.parent, (MutableSnapshot)this, this.parent.getInvalid$runtime_release());
                } else {
                    map = i;
                }
                int i3 = 0;
                Object lock = SnapshotKt.getLock();
                final int i4 = 0;
                final int i5 = 0;
                SnapshotKt.access$validateOpen((Snapshot)this);
                synchronized (lock) {
                    if (modified$runtime_release2.getSize() == 0) {
                        closeAndReleasePinning$runtime_release();
                    } else {
                        innerApplyLocked$runtime_release = innerApplyLocked$runtime_release(this.parent.getId(), map, this.parent.getInvalid$runtime_release());
                        if (!Intrinsics.areEqual(innerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                            return innerApplyLocked$runtime_release;
                        }
                        modified$runtime_release = this.parent.getModified$runtime_release();
                        if (modified$runtime_release != null) {
                            parent = 0;
                            modified$runtime_release.addAll((ScatterSet)modified$runtime_release2);
                            if (modified$runtime_release == null) {
                                set = 0;
                                this.parent.setModified(modified$runtime_release2);
                                setModified(i);
                            }
                        } else {
                        }
                    }
                    if (this.parent.getId() < id) {
                        this.parent.advance$runtime_release();
                    }
                }
            }
        }
        SnapshotApplyResult.Failure modified = new SnapshotApplyResult.Failure((Snapshot)this);
        return (SnapshotApplyResult)modified;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void dispose() {
        if (!getDisposed$runtime_release()) {
            super.dispose();
            deactivate();
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final androidx.compose.runtime.snapshots.MutableSnapshot getParent() {
        return this.parent;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public androidx.compose.runtime.snapshots.Snapshot getRoot() {
        return this.parent.getRoot();
    }
}
