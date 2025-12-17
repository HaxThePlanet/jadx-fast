package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0016\u0008\u0000\u0018\u00002\u00020\u0001B-\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0008\u0010\u001f\u001a\u00020\tH\u0016J\u0008\u0010 \u001a\u00020\u0016H\u0016J\u0015\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0001H\u0010¢\u0006\u0002\u0008#J\u0015\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0001H\u0010¢\u0006\u0002\u0008%J\r\u0010&\u001a\u00020\tH\u0010¢\u0006\u0002\u0008'J\u0015\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\rH\u0010¢\u0006\u0002\u0008*J\u001e\u0010+\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016R4\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c8P@VX\u0090\u000e¢\u0006\u000c\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u0014¨\u0006,", d2 = {"Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;)V", "value", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "", "getReadOnly", "()Z", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeObserver", "getWriteObserver$runtime_release", "dispose", "hasPendingChanges", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReadonlySnapshot extends androidx.compose.runtime.snapshots.Snapshot {

    public static final int $stable = 8;
    private final Function1<Object, Unit> readObserver;
    private int snapshots = 1;
    static {
        final int i = 8;
    }

    public ReadonlySnapshot(int id, androidx.compose.runtime.snapshots.SnapshotIdSet invalid, Function1<Object, Unit> readObserver) {
        super(id, invalid, 0);
        this.readObserver = readObserver;
        int i2 = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        boolean disposed$runtime_release;
        if (!getDisposed$runtime_release()) {
            nestedDeactivated$runtime_release((Snapshot)this);
            super.dispose();
        }
    }

    public MutableScatterSet<androidx.compose.runtime.snapshots.StateObject> getModified$runtime_release() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1 getReadObserver() {
        return getReadObserver$runtime_release();
    }

    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public androidx.compose.runtime.snapshots.Snapshot getRoot() {
        return (Snapshot)this;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedActivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        this.snapshots = snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedDeactivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        this.snapshots = snapshots--;
        if (this.snapshots == 0) {
            closeAndReleasePinning$runtime_release();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void recordModified$runtime_release(androidx.compose.runtime.snapshots.StateObject state) {
        SnapshotKt.access$reportReadonlySnapshotWrite();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public void setModified(MutableScatterSet<androidx.compose.runtime.snapshots.StateObject> value) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public androidx.compose.runtime.snapshots.Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        SnapshotKt.access$validateOpen((Snapshot)this);
        NestedReadonlySnapshot nestedReadonlySnapshot = new NestedReadonlySnapshot(getId(), getInvalid$runtime_release(), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, 0), (Snapshot)this);
        return (Snapshot)nestedReadonlySnapshot;
    }
}
