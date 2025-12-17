package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0010\u0001\n\u0002\u0008\u000b\u0008\u0000\u0018\u00002\u00020\u0001B5\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008¢\u0006\u0002\u0010\nJ\u0008\u00103\u001a\u00020\u0006H\u0016J\u0008\u00104\u001a\u00020\u0008H\u0016J\u0015\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0001H\u0010¢\u0006\u0002\u00088J\u0015\u00109\u001a\u0002062\u0006\u00107\u001a\u00020\u0001H\u0010¢\u0006\u0002\u0008:J\r\u0010;\u001a\u00020\u0006H\u0010¢\u0006\u0002\u0008<J\u0015\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u001cH\u0010¢\u0006\u0002\u0008?J\u001e\u0010@\u001a\u00020\u00012\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8V@PX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00158P@PX\u0090\u000e¢\u0006\u000c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8P@VX\u0090\u000e¢\u0006\u000c\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\u000e\u0010\t\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u0014\u0010(\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010*R\u0014\u0010+\u001a\u00020\u0001X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\rR\u0014\u0010-\u001a\u00020.X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\"\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010%¨\u0006A", d2 = {"Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "previousSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "mergeParentObservers", "", "ownsPreviousSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;ZZ)V", "currentSnapshot", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "value", "", "id", "getId", "()I", "setId$runtime_release", "(I)V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "<set-?>", "readObserver", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "setReadObserver", "(Lkotlin/jvm/functions/Function1;)V", "readOnly", "getReadOnly", "()Z", "root", "getRoot", "threadId", "", "getThreadId$runtime_release", "()J", "writeObserver", "getWriteObserver$runtime_release", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransparentObserverSnapshot extends androidx.compose.runtime.snapshots.Snapshot {

    public static final int $stable = 8;
    private final boolean mergeParentObservers;
    private final boolean ownsPreviousSnapshot;
    private final androidx.compose.runtime.snapshots.Snapshot previousSnapshot;
    private Function1<Object, Unit> readObserver;
    private final androidx.compose.runtime.snapshots.Snapshot root;
    private final long threadId;
    private final Function1<Object, Unit> writeObserver;
    static {
        final int i = 8;
    }

    public TransparentObserverSnapshot(androidx.compose.runtime.snapshots.Snapshot previousSnapshot, Function1<Object, Unit> specifiedReadObserver, boolean mergeParentObservers, boolean ownsPreviousSnapshot) {
        Function1 readObserver$runtime_release;
        super(0, SnapshotIdSet.Companion.getEMPTY(), 0);
        this.previousSnapshot = previousSnapshot;
        this.mergeParentObservers = mergeParentObservers;
        this.ownsPreviousSnapshot = ownsPreviousSnapshot;
        readObserver$runtime_release = this.previousSnapshot;
        if (readObserver$runtime_release != null) {
            if (readObserver$runtime_release.getReadObserver() == null) {
                readObserver$runtime_release = (GlobalSnapshot)SnapshotKt.access$getCurrentGlobalSnapshot$p().get().getReadObserver$runtime_release();
            }
        } else {
        }
        this.readObserver = SnapshotKt.access$mergedReadObserver(specifiedReadObserver, readObserver$runtime_release, this.mergeParentObservers);
        this.threadId = ActualJvm_jvmKt.currentThreadId();
        this.root = (Snapshot)this;
    }

    private final androidx.compose.runtime.snapshots.Snapshot getCurrentSnapshot() {
        Object previousSnapshot;
        if (this.previousSnapshot == null) {
            previousSnapshot = SnapshotKt.access$getCurrentGlobalSnapshot$p().get();
        }
        return previousSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        boolean ownsPreviousSnapshot;
        setDisposed$runtime_release(true);
        ownsPreviousSnapshot = this.previousSnapshot;
        if (this.ownsPreviousSnapshot && ownsPreviousSnapshot != null) {
            ownsPreviousSnapshot = this.previousSnapshot;
            if (ownsPreviousSnapshot != null) {
                ownsPreviousSnapshot.dispose();
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getId() {
        return getCurrentSnapshot().getId();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public androidx.compose.runtime.snapshots.SnapshotIdSet getInvalid$runtime_release() {
        return getCurrentSnapshot().getInvalid$runtime_release();
    }

    public MutableScatterSet<androidx.compose.runtime.snapshots.StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
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
        return getCurrentSnapshot().getReadOnly();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public androidx.compose.runtime.snapshots.Snapshot getRoot() {
        return this.root;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final long getThreadId$runtime_release() {
        return this.threadId;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Void nestedActivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedActivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        nestedActivated$runtime_release(snapshot);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Void nestedDeactivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedDeactivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        nestedDeactivated$runtime_release(snapshot);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void recordModified$runtime_release(androidx.compose.runtime.snapshots.StateObject state) {
        getCurrentSnapshot().recordModified$runtime_release(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setId$runtime_release(int value) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setInvalid$runtime_release(androidx.compose.runtime.snapshots.SnapshotIdSet value) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public void setModified(MutableScatterSet<androidx.compose.runtime.snapshots.StateObject> value) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public void setReadObserver(Function1<Object, Unit> <set-?>) {
        this.readObserver = <set-?>;
    }

    public androidx.compose.runtime.snapshots.Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        androidx.compose.runtime.snapshots.Snapshot takeNestedSnapshot;
        int i;
        final int i3 = 0;
        Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, i3);
        if (!this.mergeParentObservers) {
            takeNestedSnapshot = SnapshotKt.access$createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(i3), mergedReadObserver$default, true);
        } else {
            takeNestedSnapshot = getCurrentSnapshot().takeNestedSnapshot(mergedReadObserver$default);
        }
        return takeNestedSnapshot;
    }
}
