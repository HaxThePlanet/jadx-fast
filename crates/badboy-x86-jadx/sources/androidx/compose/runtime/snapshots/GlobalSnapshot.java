package androidx.compose.runtime.snapshots;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0015\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\u0008\u000fJ\u0015\u0010\u0010\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\u0008\u0011J\r\u0010\u0012\u001a\u00020\nH\u0010¢\u0006\u0002\u0008\u0013J4\u0010\u0014\u001a\u00020\u00012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u00162\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016J\u001e\u0010\u0019\u001a\u00020\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016¨\u0006\u001a", d2 = {"Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "", "nestedActivated", "", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "takeNestedMutableSnapshot", "readObserver", "Lkotlin/Function1;", "", "writeObserver", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlobalSnapshot extends androidx.compose.runtime.snapshots.MutableSnapshot {

    public static final int $stable;
    static {
    }

    public GlobalSnapshot(int id, androidx.compose.runtime.snapshots.SnapshotIdSet invalid) {
        Object singleOrNull;
        int i = 0;
        final Object lock = SnapshotKt.getLock();
        final int i2 = 0;
        final int i3 = 0;
        final java.util.List list = SnapshotKt.access$getGlobalWriteObservers$p();
        final int i4 = 0;
        synchronized (lock) {
            singleOrNull = new GlobalSnapshot.1.1.1(list);
            super(id, invalid, 0, singleOrNull);
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        IllegalStateException illegalStateException = new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void dispose() {
        final int i = 0;
        final Object lock = SnapshotKt.getLock();
        final int i2 = 0;
        int i3 = 0;
        releasePinnedSnapshotLocked$runtime_release();
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lock) {
            i = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            i3 = 0;
            releasePinnedSnapshotLocked$runtime_release();
            iNSTANCE = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public Void nestedActivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void nestedActivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        nestedActivated$runtime_release(snapshot);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public Void nestedDeactivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void nestedDeactivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        nestedDeactivated$runtime_release(snapshot);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void notifyObjectsInitialized$runtime_release() {
        SnapshotKt.access$advanceGlobalSnapshot();
    }

    public androidx.compose.runtime.snapshots.MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        GlobalSnapshot.takeNestedMutableSnapshot.1 anon = new GlobalSnapshot.takeNestedMutableSnapshot.1(readObserver, writeObserver);
        return (MutableSnapshot)SnapshotKt.access$takeNewSnapshot((Function1)anon);
    }

    public androidx.compose.runtime.snapshots.Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        GlobalSnapshot.takeNestedSnapshot.1 anon = new GlobalSnapshot.takeNestedSnapshot.1(readObserver);
        return SnapshotKt.access$takeNewSnapshot((Function1)anon);
    }
}
