package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0000\u0018\u00002\u00020\u0001BK\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0008\u00106\u001a\u000207H\u0016J\u0008\u00108\u001a\u00020\u0006H\u0016J\u0008\u00109\u001a\u00020\tH\u0016J\u0015\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0010¢\u0006\u0002\u0008>J\u0015\u0010?\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0010¢\u0006\u0002\u0008@J\r\u0010A\u001a\u00020\u0006H\u0010¢\u0006\u0002\u0008BJ\u0015\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u001dH\u0010¢\u0006\u0002\u0008EJ4\u0010F\u001a\u00020\u00012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\u001e\u0010G\u001a\u00020=2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016R\u0014\u0010\u000c\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@PX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00168P@PX\u0090\u000e¢\u0006\u000c\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8P@VX\u0090\u000e¢\u0006\u000c\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(R\u0014\u0010)\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010+R\u0014\u0010,\u001a\u00020-X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R$\u00100\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108P@PX\u0090\u000e¢\u0006\u000c\u001a\u0004\u00081\u0010\u0013\"\u0004\u00082\u0010\u0015R@\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u0010&\"\u0004\u00085\u0010(¨\u0006H", d2 = {"Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "parentSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "specifiedWriteObserver", "mergeParentObservers", "", "ownsParentSnapshot", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZ)V", "currentSnapshot", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "value", "", "id", "getId", "()I", "setId$runtime_release", "(I)V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "<set-?>", "readObserver", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "setReadObserver", "(Lkotlin/jvm/functions/Function1;)V", "readOnly", "getReadOnly", "()Z", "threadId", "", "getThreadId$runtime_release", "()J", "writeCount", "getWriteCount$runtime_release", "setWriteCount$runtime_release", "writeObserver", "getWriteObserver$runtime_release", "setWriteObserver", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedMutableSnapshot", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransparentObserverMutableSnapshot extends androidx.compose.runtime.snapshots.MutableSnapshot {

    public static final int $stable = 8;
    private final boolean mergeParentObservers;
    private final boolean ownsParentSnapshot;
    private final androidx.compose.runtime.snapshots.MutableSnapshot parentSnapshot;
    private Function1<Object, Unit> readObserver;
    private final long threadId;
    private Function1<Object, Unit> writeObserver;
    static {
        final int i = 8;
    }

    public TransparentObserverMutableSnapshot(androidx.compose.runtime.snapshots.MutableSnapshot parentSnapshot, Function1<Object, Unit> specifiedReadObserver, Function1<Object, Unit> specifiedWriteObserver, boolean mergeParentObservers, boolean ownsParentSnapshot) {
        Function1 readObserver$runtime_release;
        Function1 writeObserver$runtime_release;
        if (parentSnapshot != null) {
            if (parentSnapshot.getReadObserver$runtime_release() == null) {
                readObserver$runtime_release = (GlobalSnapshot)SnapshotKt.access$getCurrentGlobalSnapshot$p().get().getReadObserver$runtime_release();
            }
        } else {
        }
        if (parentSnapshot != null) {
            if (parentSnapshot.getWriteObserver$runtime_release() == null) {
                writeObserver$runtime_release = (GlobalSnapshot)SnapshotKt.access$getCurrentGlobalSnapshot$p().get().getWriteObserver$runtime_release();
            }
        } else {
        }
        super(0, SnapshotIdSet.Companion.getEMPTY(), SnapshotKt.access$mergedReadObserver(specifiedReadObserver, readObserver$runtime_release, mergeParentObservers), SnapshotKt.access$mergedWriteObserver(specifiedWriteObserver, writeObserver$runtime_release));
        this.parentSnapshot = parentSnapshot;
        this.mergeParentObservers = mergeParentObservers;
        this.ownsParentSnapshot = ownsParentSnapshot;
        this.readObserver = super.getReadObserver$runtime_release();
        this.writeObserver = super.getWriteObserver$runtime_release();
        this.threadId = ActualJvm_jvmKt.currentThreadId();
    }

    private final androidx.compose.runtime.snapshots.MutableSnapshot getCurrentSnapshot() {
        Object parentSnapshot;
        if (this.parentSnapshot == null) {
            parentSnapshot = SnapshotKt.access$getCurrentGlobalSnapshot$p().get();
        }
        return parentSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        return getCurrentSnapshot().apply();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void dispose() {
        boolean ownsParentSnapshot;
        setDisposed$runtime_release(true);
        ownsParentSnapshot = this.parentSnapshot;
        if (this.ownsParentSnapshot && ownsParentSnapshot != null) {
            ownsParentSnapshot = this.parentSnapshot;
            if (ownsParentSnapshot != null) {
                ownsParentSnapshot.dispose();
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public int getId() {
        return getCurrentSnapshot().getId();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public androidx.compose.runtime.snapshots.SnapshotIdSet getInvalid$runtime_release() {
        return getCurrentSnapshot().getInvalid$runtime_release();
    }

    public MutableScatterSet<androidx.compose.runtime.snapshots.StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public Function1 getReadObserver() {
        return getReadObserver$runtime_release();
    }

    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public final long getThreadId$runtime_release() {
        return this.threadId;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public int getWriteCount$runtime_release() {
        return getCurrentSnapshot().getWriteCount$runtime_release();
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
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
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void recordModified$runtime_release(androidx.compose.runtime.snapshots.StateObject state) {
        getCurrentSnapshot().recordModified$runtime_release(state);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void setId$runtime_release(int value) {
        SnapshotStateMapKt.unsupported();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
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

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void setWriteCount$runtime_release(int value) {
        getCurrentSnapshot().setWriteCount$runtime_release(value);
    }

    public void setWriteObserver(Function1<Object, Unit> <set-?>) {
        this.writeObserver = <set-?>;
    }

    public androidx.compose.runtime.snapshots.MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        androidx.compose.runtime.snapshots.MutableSnapshot currentSnapshot;
        androidx.compose.runtime.snapshots.MutableSnapshot transparentObserverMutableSnapshot;
        androidx.compose.runtime.snapshots.MutableSnapshot takeNestedMutableSnapshot;
        int i2;
        int i;
        final int i5 = 0;
        final Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, i5);
        final Function1 function1 = SnapshotKt.access$mergedWriteObserver(writeObserver, getWriteObserver$runtime_release());
        if (!this.mergeParentObservers) {
            transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(getCurrentSnapshot().takeNestedMutableSnapshot(i5, function1), mergedReadObserver$default, function1, 0, 1);
        } else {
            transparentObserverMutableSnapshot = getCurrentSnapshot().takeNestedMutableSnapshot(mergedReadObserver$default, function1);
        }
        return transparentObserverMutableSnapshot;
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
