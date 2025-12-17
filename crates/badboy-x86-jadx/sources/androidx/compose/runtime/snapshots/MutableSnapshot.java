package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0015\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u001e\u0008\u0017\u0018\u0000 g2\u00020\u0001:\u0001gBC\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0008\u00109\u001a\u00020\tH\u0002J\r\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\u0008;J$\u0010:\u001a\u0002H<\"\u0004\u0008\u0000\u0010<2\u000c\u0010=\u001a\u0008\u0012\u0004\u0012\u0002H<0>H\u0080\u0008¢\u0006\u0004\u0008;\u0010?J\u0008\u0010@\u001a\u00020AH\u0016J\r\u0010B\u001a\u00020\tH\u0010¢\u0006\u0002\u0008CJ\u0008\u0010D\u001a\u00020\tH\u0016J\u0008\u0010E\u001a\u00020\rH\u0016J3\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00032\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008LJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\u0008OJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\u0008QJ\r\u0010R\u001a\u00020\tH\u0010¢\u0006\u0002\u0008SJ\u0015\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0014H\u0010¢\u0006\u0002\u0008VJ\u0015\u0010W\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0008XJ\u0015\u0010Y\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008ZJ\u0015\u0010[\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0008\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020&H\u0000¢\u0006\u0002\u0008_J\r\u0010`\u001a\u00020\tH\u0010¢\u0006\u0002\u0008aJ\u0008\u0010b\u001a\u00020\tH\u0002J8\u0010c\u001a\u00020\u00002\u0016\u0008\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\u0008\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010d\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u0008\u0010e\u001a\u00020\tH\u0002J\u0008\u0010f\u001a\u00020\tH\u0002R\u001a\u0010\u000c\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\u001a\u0010%\u001a\u00020&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0014\u0010-\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008.\u0010\u000fR\u0014\u0010/\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00080\u00101R\u000e\u00102\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0003X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010,¨\u0006h", d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/collection/MutableScatterSet;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class MutableSnapshot extends androidx.compose.runtime.snapshots.Snapshot {

    public static final int $stable = 8;
    private static final androidx.compose.runtime.snapshots.MutableSnapshot.Companion Companion;
    private static final int[] EmptyIntArray;
    private boolean applied;
    private List<? extends androidx.compose.runtime.snapshots.StateObject> merged;
    private MutableScatterSet<androidx.compose.runtime.snapshots.StateObject> modified;
    private androidx.compose.runtime.snapshots.SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots = 1;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0000\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        MutableSnapshot.Companion companion = new MutableSnapshot.Companion(0);
        MutableSnapshot.Companion = companion;
        int i = 8;
        MutableSnapshot.EmptyIntArray = new int[0];
    }

    public MutableSnapshot(int id, androidx.compose.runtime.snapshots.SnapshotIdSet invalid, Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        super(id, invalid, 0);
        this.readObserver = readObserver;
        this.writeObserver = writeObserver;
        this.previousIds = SnapshotIdSet.Companion.getEMPTY();
        this.previousPinnedSnapshots = MutableSnapshot.EmptyIntArray;
        int i2 = 1;
    }

    private final void abandon() {
        Object contains;
        int i7;
        MutableScatterSet modified$runtime_release;
        int snapshotId$runtime_release2;
        int i;
        MutableScatterSet cmp;
        int current;
        Object[] elements;
        MutableScatterSet set2;
        int i2;
        long[] metadata;
        int i9;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i3;
        int i4;
        MutableScatterSet set;
        int i5;
        long l;
        Object obj;
        int i6;
        int i8;
        MutableScatterSet modified;
        androidx.compose.runtime.snapshots.StateRecord firstStateRecord;
        int snapshotId$runtime_release;
        contains = this;
        modified$runtime_release = contains.getModified$runtime_release();
        if (modified$runtime_release != null) {
            contains.validateNotApplied();
            contains.setModified(0);
            cmp = modified$runtime_release;
            i2 = 0;
            metadata = set2.metadata;
            length += -2;
            if (0 <= i9) {
            } else {
                modified = modified$runtime_release;
                set = cmp;
                i5 = current;
            }
        } else {
            modified = modified$runtime_release;
        }
        closeAndReleasePinning$runtime_release();
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int index;
        int i;
        index = 0;
        while (index < previousPinnedSnapshots.length) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[index]);
            index++;
        }
    }

    public static androidx.compose.runtime.snapshots.MutableSnapshot takeNestedMutableSnapshot$default(androidx.compose.runtime.snapshots.MutableSnapshot mutableSnapshot, Function1 function12, Function1 function13, int i4, Object object5) {
        int obj2;
        int obj3;
        if (object5 != null) {
        } else {
            final int i = 0;
            if (i4 & 1 != 0) {
                obj2 = i;
            }
            if (i4 &= 2 != 0) {
                obj3 = i;
            }
            return mutableSnapshot.takeNestedMutableSnapshot(obj2, obj3);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        throw obj1;
    }

    private final void validateNotApplied() {
        String str;
        final int i2 = 0;
        if (applied ^= 1 == 0) {
            int i3 = 0;
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void validateNotAppliedOrPinned() {
        boolean this_$iv;
        int i;
        int str;
        int i2;
        int i3;
        if (this.applied) {
            str = 0;
            i3 = 0;
            this_$iv = Snapshot.access$getPinningTrackingHandle$p((Snapshot)this) >= 0 ? i : i3;
            if (this_$iv != 0) {
            } else {
                i = i3;
            }
        } else {
        }
        int i4 = 0;
        if (i == 0) {
            int i5 = 0;
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
        }
    }

    public final <T> T advance$runtime_release(Function0<? extends T> block) {
        boolean applied$runtime_release;
        androidx.compose.runtime.snapshots.SnapshotIdSet range;
        int i2;
        int i3;
        Unit iNSTANCE;
        androidx.compose.runtime.snapshots.SnapshotIdSet set;
        int i;
        final int i4 = 0;
        recordPrevious$runtime_release(getId());
        Object invoke = block.invoke();
        final Object obj = invoke;
        final int i5 = 0;
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            if (!getDisposed$runtime_release()) {
                int i6 = 0;
                Object lock = SnapshotKt.getLock();
                int i7 = 0;
                int i8 = 0;
                int i9 = SnapshotKt.access$getNextSnapshotId$p();
                SnapshotKt.access$setNextSnapshotId$p(i9 + 1);
                setId$runtime_release(i9);
                SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(getId()));
                iNSTANCE = Unit.INSTANCE;
                setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), applied$runtime_release + 1, getId()));
                synchronized (lock) {
                    i6 = 0;
                    lock = SnapshotKt.getLock();
                    i7 = 0;
                    i8 = 0;
                    i9 = SnapshotKt.access$getNextSnapshotId$p();
                    SnapshotKt.access$setNextSnapshotId$p(i9 + 1);
                    setId$runtime_release(i9);
                    SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(getId()));
                    iNSTANCE = Unit.INSTANCE;
                    setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), applied$runtime_release + 1, getId()));
                }
            }
        }
        return invoke;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void advance$runtime_release() {
        boolean applied$runtime_release;
        androidx.compose.runtime.snapshots.SnapshotIdSet range;
        int i;
        int i2;
        Object iNSTANCE;
        androidx.compose.runtime.snapshots.SnapshotIdSet set;
        int i3;
        final Object obj = this;
        final int i4 = 0;
        obj.recordPrevious$runtime_release(obj.getId());
        int i5 = 0;
        Unit iNSTANCE2 = Unit.INSTANCE;
        final int i6 = 0;
        if (!obj.getApplied$runtime_release() && !obj.getDisposed$runtime_release()) {
            if (!obj.getDisposed$runtime_release()) {
                int i7 = 0;
                Object lock = SnapshotKt.getLock();
                int i8 = 0;
                int i9 = 0;
                int i10 = SnapshotKt.access$getNextSnapshotId$p();
                SnapshotKt.access$setNextSnapshotId$p(i10 + 1);
                obj.setId$runtime_release(i10);
                SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(obj.getId()));
                iNSTANCE = Unit.INSTANCE;
                obj.setInvalid$runtime_release(SnapshotKt.addRange(obj.getInvalid$runtime_release(), applied$runtime_release + 1, obj.getId()));
                synchronized (lock) {
                    i7 = 0;
                    lock = SnapshotKt.getLock();
                    i8 = 0;
                    i9 = 0;
                    i10 = SnapshotKt.access$getNextSnapshotId$p();
                    SnapshotKt.access$setNextSnapshotId$p(i10 + 1);
                    obj.setId$runtime_release(i10);
                    SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(obj.getId()));
                    iNSTANCE = Unit.INSTANCE;
                    obj.setInvalid$runtime_release(SnapshotKt.addRange(obj.getInvalid$runtime_release(), applied$runtime_release + 1, obj.getId()));
                }
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        int i$iv$iv2;
        MutableScatterSet $this$maskEmptyOrDeleted$iv$iv$iv;
        int j$iv$iv;
        int index$iv2;
        androidx.compose.runtime.snapshots.SnapshotIdSet clear;
        List observers;
        int index$iv$iv;
        int value$iv$iv$iv;
        int i5;
        MutableScatterSet globalModified;
        int $i$f$sync;
        Object wrapIntoSet;
        int modifiedSet;
        int empty;
        Unit iNSTANCE;
        androidx.compose.runtime.snapshots.MutableSnapshot size;
        Object index$iv;
        Object innerApplyLocked$runtime_release;
        MutableScatterSet modified$runtime_release;
        List i$iv$iv;
        int slot$iv$iv;
        int i8;
        androidx.compose.runtime.snapshots.SnapshotIdSet observers2;
        int i3;
        int i2;
        int i4;
        long slot$iv$iv2;
        int $i$f$forEach;
        MutableScatterSet modified;
        int i10;
        int i7;
        int i9;
        int i6;
        int cmp;
        int i;
        final androidx.compose.runtime.snapshots.MutableSnapshot mutableSnapshot = this;
        $this$maskEmptyOrDeleted$iv$iv$iv = mutableSnapshot.getModified$runtime_release();
        i$iv$iv2 = 0;
        if ($this$maskEmptyOrDeleted$iv$iv$iv != null) {
            index$iv2 = SnapshotKt.access$optimisticMerges((MutableSnapshot)SnapshotKt.access$getCurrentGlobalSnapshot$p().get(), mutableSnapshot, SnapshotKt.access$getOpenSnapshots$p().clear((GlobalSnapshot)SnapshotKt.access$getCurrentGlobalSnapshot$p().get().getId()));
        } else {
            index$iv2 = i$iv$iv2;
        }
        int i22 = 0;
        observers = CollectionsKt.emptyList();
        globalModified = 0;
        int i26 = 0;
        wrapIntoSet = SnapshotKt.getLock();
        empty = 0;
        int i27 = 0;
        SnapshotKt.access$validateOpen((Snapshot)mutableSnapshot);
        synchronized (wrapIntoSet) {
            if ($this$maskEmptyOrDeleted$iv$iv$iv.getSize() == 0) {
                mutableSnapshot.closeLocked$runtime_release();
                index$iv = SnapshotKt.access$getCurrentGlobalSnapshot$p().get();
                SnapshotKt.access$takeNewGlobalSnapshot((Snapshot)(GlobalSnapshot)index$iv, SnapshotKt.access$getEmptyLambda$p());
                innerApplyLocked$runtime_release = index$iv.getModified$runtime_release();
                if (innerApplyLocked$runtime_release != null && innerApplyLocked$runtime_release.isNotEmpty()) {
                    if (innerApplyLocked$runtime_release.isNotEmpty()) {
                        globalModified = innerApplyLocked$runtime_release;
                        observers = modified$runtime_release;
                    }
                }
            } else {
                index$iv = SnapshotKt.access$getCurrentGlobalSnapshot$p().get();
                innerApplyLocked$runtime_release = mutableSnapshot.innerApplyLocked$runtime_release(SnapshotKt.access$getNextSnapshotId$p(), index$iv2, SnapshotKt.access$getOpenSnapshots$p().clear((GlobalSnapshot)index$iv.getId()));
                if (!Intrinsics.areEqual(innerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                    return innerApplyLocked$runtime_release;
                }
                mutableSnapshot.closeLocked$runtime_release();
                SnapshotKt.access$takeNewGlobalSnapshot((Snapshot)index$iv, SnapshotKt.access$getEmptyLambda$p());
                mutableSnapshot.setModified(i$iv$iv2);
                index$iv.setModified(i$iv$iv2);
                globalModified = observers3;
                observers = i$iv$iv;
            }
            iNSTANCE = Unit.INSTANCE;
            mutableSnapshot.applied = true;
            wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet((ScatterSet)globalModified);
            if (globalModified != null && !(Collection)wrapIntoSet.isEmpty()) {
            }
            if ($this$maskEmptyOrDeleted$iv$iv$iv != null && $this$maskEmptyOrDeleted$iv$iv$iv.isNotEmpty()) {
                if ($this$maskEmptyOrDeleted$iv$iv$iv.isNotEmpty()) {
                    empty = observers;
                    iNSTANCE = 0;
                    index$iv = 0;
                    while (index$iv < empty.size()) {
                        slot$iv$iv = 0;
                        (Function2)empty.get(index$iv).invoke(ScatterSetWrapperKt.wrapIntoSet((ScatterSet)$this$maskEmptyOrDeleted$iv$iv$iv), mutableSnapshot);
                        index$iv++;
                    }
                }
            }
            modifiedSet = 0;
            Object lock = SnapshotKt.getLock();
            int i28 = 0;
            int i29 = 0;
            mutableSnapshot.releasePinnedSnapshotsForCloseLocked$runtime_release();
            SnapshotKt.access$checkAndOverwriteUnusedRecordsLocked();
            final int i31 = 7;
            final long l = -9187201950435737472L;
            synchronized (lock) {
                observers2 = 0;
                innerApplyLocked$runtime_release = set7;
                i3 = 0;
                slot$iv$iv = i$iv$iv.metadata;
                length2 += -2;
                if (0 <= i8) {
                } else {
                    modified = $this$maskEmptyOrDeleted$iv$iv$iv;
                    i10 = index$iv2;
                    i9 = modifiedSet;
                }
                if (modified != null) {
                    i$iv$iv2 = modified;
                    modifiedSet = 0;
                    innerApplyLocked$runtime_release = $i$f$sync.metadata;
                    length += -2;
                    if (0 <= modified$runtime_release) {
                    } else {
                        $i$f$forEach = $this$maskEmptyOrDeleted$iv$iv$iv;
                        i7 = index$iv2;
                        observers2 = observers;
                        i3 = globalModified;
                    }
                    try {
                        observers2 = obj4;
                        i3 = obj5;
                        observers2 = observers;
                        i3 = globalModified;
                        List merged = mutableSnapshot.merged;
                        if (merged != null) {
                        }
                        $this$maskEmptyOrDeleted$iv$iv$iv = 0;
                        index$iv2 = 0;
                    } catch (Throwable th) {
                    }
                    throw th;
                } else {
                }
            }
        }
        wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet((ScatterSet)globalModified);
        if (!(Collection)wrapIntoSet.isEmpty()) {
            empty = observers;
            iNSTANCE = 0;
            index$iv = 0;
            while (index$iv < empty.size()) {
                slot$iv$iv = 0;
                (Function2)empty.get(index$iv).invoke(wrapIntoSet, mutableSnapshot);
                index$iv++;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().clear(getId()).andNot(this.previousIds));
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        boolean disposed$runtime_release;
        if (!getDisposed$runtime_release()) {
            super.dispose();
            nestedDeactivated$runtime_release((Snapshot)this);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    public final List<androidx.compose.runtime.snapshots.StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    public MutableScatterSet<androidx.compose.runtime.snapshots.StateObject> getModified$runtime_release() {
        return this.modified;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final androidx.compose.runtime.snapshots.SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
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
        return 0;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public androidx.compose.runtime.snapshots.Snapshot getRoot() {
        return (Snapshot)this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getWriteCount$runtime_release() {
        return this.writeCount;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        MutableScatterSet modified$runtime_release;
        int i2;
        int i;
        modified$runtime_release = getModified$runtime_release();
        i2 = 0;
        i = 1;
        if (modified$runtime_release != null && modified$runtime_release.isNotEmpty() == i) {
            i = 1;
            if (modified$runtime_release.isNotEmpty() == i) {
                i2 = i;
            }
        }
        return i2;
    }

    public final androidx.compose.runtime.snapshots.SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, Map<androidx.compose.runtime.snapshots.StateRecord, ? extends androidx.compose.runtime.snapshots.StateRecord> optimisticMerges, androidx.compose.runtime.snapshots.SnapshotIdSet invalidSnapshots) {
        int first2;
        int arrayList2;
        ArrayList arrayList;
        int arrayList3;
        boolean firstStateRecord;
        ArrayList list;
        androidx.compose.runtime.snapshots.SnapshotIdSet $this$fastForEach$iv;
        int bitCount$iv$iv;
        int index$iv2;
        int j$iv$iv;
        Object[] index$iv;
        MutableScatterSet $this$innerApplyLocked_u24lambda_u2419_u24lambda_u2415;
        int i7;
        long[] metadata;
        int i8;
        int i$iv$iv;
        long slot$iv$iv;
        Object lock;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object[] objArr;
        int i;
        MutableScatterSet set2;
        int statesToRemove;
        long l;
        int i6;
        int i2;
        MutableScatterSet set;
        int mergedRecords;
        int i3;
        int i4;
        androidx.compose.runtime.snapshots.SnapshotIdSet start;
        androidx.compose.runtime.snapshots.StateRecord first;
        int i5;
        final Object obj = this;
        list = optimisticMerges;
        first2 = 0;
        MutableScatterSet modified$runtime_release = obj.getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        bitCount$iv$iv = 0;
        index$iv2 = modified$runtime_release;
        $this$innerApplyLocked_u24lambda_u2419_u24lambda_u2415 = index$iv2;
        i7 = 0;
        metadata = $this$innerApplyLocked_u24lambda_u2419_u24lambda_u2415.metadata;
        length += -2;
        if (0 <= i8) {
        } else {
            start = $this$fastForEach$iv;
            set2 = index$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = j$iv$iv;
            objArr = index$iv;
            set = $this$innerApplyLocked_u24lambda_u2419_u24lambda_u2415;
            mergedRecords = first2;
            statesToRemove = bitCount$iv$iv;
        }
        if (mergedRecords != 0) {
            $this$fastForEach$iv = 0;
            obj.advance$runtime_release();
            bitCount$iv$iv = list;
            index$iv2 = 0;
            index$iv = first2;
            while (index$iv < bitCount$iv$iv.size()) {
                i7 = $this$innerApplyLocked_u24lambda_u2419_u24lambda_u2415;
                metadata = null;
                i8 = component1;
                i$iv$iv = component2;
                (StateRecord)i$iv$iv.setSnapshotId$runtime_release(obj.getId());
                slot$iv$iv = 0L;
                lock = SnapshotKt.getLock();
                $this$maskEmptyOrDeleted$iv$iv$iv = 0;
                objArr = i9;
                i$iv$iv.setNext$runtime_release((StateObject)i8.getFirstStateRecord());
                i8.prependStateRecord(i$iv$iv);
                first2 = Unit.INSTANCE;
                index$iv++;
            }
        }
        if (statesToRemove != 0) {
            first2 = statesToRemove;
            list = 0;
            int i10 = first2;
            int i11 = 0;
            index$iv2 = 0;
            while (index$iv2 < i10.size()) {
                i7 = 0;
                modified$runtime_release.remove((StateObject)i10.get(index$iv2));
                index$iv2++;
            }
            $this$fastForEach$iv = obj.merged;
            if ($this$fastForEach$iv == null) {
                bitCount$iv$iv = first2;
            } else {
                bitCount$iv$iv = CollectionsKt.plus((Collection)$this$fastForEach$iv, (Iterable)first2);
            }
            obj.merged = bitCount$iv$iv;
        }
        return (SnapshotApplyResult)SnapshotApplyResult.Success.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedActivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        this.snapshots = snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void nestedDeactivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        int i;
        int snapshots;
        String str;
        i = this.snapshots > 0 ? 1 : 0;
        final int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        this.snapshots = value$iv--;
        if (this.snapshots == 0 && !this.applied) {
            if (!this.applied) {
                abandon();
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        boolean disposed$runtime_release;
        if (!this.applied && getDisposed$runtime_release()) {
            if (getDisposed$runtime_release()) {
            }
            advance$runtime_release();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void recordModified$runtime_release(androidx.compose.runtime.snapshots.StateObject state) {
        MutableScatterSet mutableScatterSetOf;
        MutableScatterSet set;
        int i;
        if (getModified$runtime_release() == null) {
            i = 0;
            setModified(ScatterSetKt.mutableScatterSetOf());
        }
        mutableScatterSetOf.add(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void recordPrevious$runtime_release(int id) {
        final int i = 0;
        final Object lock = SnapshotKt.getLock();
        final int i2 = 0;
        int i3 = 0;
        this.previousIds = this.previousIds.set(id);
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lock) {
            i = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            i3 = 0;
            this.previousIds = this.previousIds.set(id);
            iNSTANCE = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void recordPreviousList$runtime_release(androidx.compose.runtime.snapshots.SnapshotIdSet snapshots) {
        final int i = 0;
        final Object lock = SnapshotKt.getLock();
        final int i2 = 0;
        int i3 = 0;
        this.previousIds = this.previousIds.or(snapshots);
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lock) {
            i = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            i3 = 0;
            this.previousIds = this.previousIds.or(snapshots);
            iNSTANCE = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        int[] plus;
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        int i2;
        int i;
        int[] plus;
        final int i3 = 0;
        i2 = handles.length == 0 ? i : i3;
        if (i2 != 0) {
        }
        int[] previousPinnedSnapshots = this.previousPinnedSnapshots;
        if (previousPinnedSnapshots.length == 0) {
        } else {
            i = i3;
        }
        if (i != 0) {
            plus = handles;
        } else {
            plus = ArraysKt.plus(previousPinnedSnapshots, handles);
        }
        this.previousPinnedSnapshots = plus;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void setApplied$runtime_release(boolean <set-?>) {
        this.applied = <set-?>;
    }

    public final void setMerged$runtime_release(List<? extends androidx.compose.runtime.snapshots.StateObject> <set-?>) {
        this.merged = <set-?>;
    }

    public void setModified(MutableScatterSet<androidx.compose.runtime.snapshots.StateObject> <set-?>) {
        this.modified = <set-?>;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void setPreviousIds$runtime_release(androidx.compose.runtime.snapshots.SnapshotIdSet <set-?>) {
        this.previousIds = <set-?>;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public final void setPreviousPinnedSnapshots$runtime_release(int[] <set-?>) {
        this.previousPinnedSnapshots = <set-?>;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int <set-?>) {
        this.writeCount = <set-?>;
    }

    public androidx.compose.runtime.snapshots.MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        boolean applied$runtime_release;
        Function1 $i$f$advance$runtime_release;
        Object lock;
        int i;
        androidx.compose.runtime.snapshots.SnapshotIdSet invalid$runtime_release;
        Function1 writeObserver$runtime_release;
        int i2;
        androidx.compose.runtime.snapshots.SnapshotIdSet range;
        Function1 function1;
        Function1 function12;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        final androidx.compose.runtime.snapshots.MutableSnapshot mutableSnapshot = this;
        mutableSnapshot.recordPrevious$runtime_release(mutableSnapshot.getId());
        int i6 = 0;
        int i7 = 0;
        lock = SnapshotKt.getLock();
        i = 0;
        int i3 = 0;
        int i10 = SnapshotKt.access$getNextSnapshotId$p();
        SnapshotKt.access$setNextSnapshotId$p(i10 + 1);
        i2 = i10;
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(i2));
        invalid$runtime_release = getInvalid$runtime_release();
        final androidx.compose.runtime.snapshots.MutableSnapshot mutableSnapshot2 = this;
        mutableSnapshot2.setInvalid$runtime_release(invalid$runtime_release.set(i2));
        final int i18 = i5;
        NestedMutableSnapshot nestedMutableSnapshot2 = new NestedMutableSnapshot(i2, SnapshotKt.addRange(invalid$runtime_release, id2++, i2), SnapshotKt.mergedReadObserver$default(readObserver, mutableSnapshot2.getReadObserver$runtime_release(), false, 4, 0), SnapshotKt.access$mergedWriteObserver(writeObserver, mutableSnapshot2.getWriteObserver$runtime_release()), mutableSnapshot2);
        androidx.compose.runtime.snapshots.NestedMutableSnapshot nestedMutableSnapshot = nestedMutableSnapshot2;
        int i8 = 0;
        synchronized (lock) {
            validateNotDisposed$runtime_release();
            validateNotAppliedOrPinned();
            mutableSnapshot = this;
            mutableSnapshot.recordPrevious$runtime_release(mutableSnapshot.getId());
            i6 = 0;
            i7 = 0;
            lock = SnapshotKt.getLock();
            i = 0;
            i3 = 0;
            i10 = SnapshotKt.access$getNextSnapshotId$p();
            SnapshotKt.access$setNextSnapshotId$p(i10 + 1);
            i2 = i10;
            SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(i2));
            invalid$runtime_release = getInvalid$runtime_release();
            mutableSnapshot2 = this;
            mutableSnapshot2.setInvalid$runtime_release(invalid$runtime_release.set(i2));
            i18 = i5;
            nestedMutableSnapshot2 = new NestedMutableSnapshot(i2, SnapshotKt.addRange(invalid$runtime_release, id2++, i2), SnapshotKt.mergedReadObserver$default(readObserver, mutableSnapshot2.getReadObserver$runtime_release(), false, 4, 0), SnapshotKt.access$mergedWriteObserver(writeObserver, mutableSnapshot2.getWriteObserver$runtime_release()), mutableSnapshot2);
            nestedMutableSnapshot = nestedMutableSnapshot2;
            i8 = 0;
        }
        if (!mutableSnapshot.getDisposed$runtime_release()) {
            int i9 = 0;
            Object lock2 = SnapshotKt.getLock();
            writeObserver$runtime_release = 0;
            int i4 = 0;
            int i13 = SnapshotKt.access$getNextSnapshotId$p();
            SnapshotKt.access$setNextSnapshotId$p(i13 + 1);
            mutableSnapshot.setId$runtime_release(i13);
            SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(mutableSnapshot.getId()));
            Unit iNSTANCE = Unit.INSTANCE;
            mutableSnapshot.setInvalid$runtime_release(SnapshotKt.addRange(mutableSnapshot.getInvalid$runtime_release(), lock + 1, mutableSnapshot.getId()));
            synchronized (lock2) {
                i9 = 0;
                lock2 = SnapshotKt.getLock();
                writeObserver$runtime_release = 0;
                i4 = 0;
                i13 = SnapshotKt.access$getNextSnapshotId$p();
                SnapshotKt.access$setNextSnapshotId$p(i13 + 1);
                mutableSnapshot.setId$runtime_release(i13);
                SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(mutableSnapshot.getId()));
                iNSTANCE = Unit.INSTANCE;
                mutableSnapshot.setInvalid$runtime_release(SnapshotKt.addRange(mutableSnapshot.getInvalid$runtime_release(), lock + 1, mutableSnapshot.getId()));
            }
        }
        return (MutableSnapshot)nestedMutableSnapshot2;
    }

    public androidx.compose.runtime.snapshots.Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        boolean applied$runtime_release;
        Object lock;
        int i2;
        int i;
        androidx.compose.runtime.snapshots.SnapshotIdSet range;
        Object mergedReadObserver$default;
        androidx.compose.runtime.snapshots.Snapshot snapshot;
        Function1 function1;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        final androidx.compose.runtime.snapshots.Snapshot snapshot2 = this;
        final int i5 = 0;
        snapshot2.recordPrevious$runtime_release(snapshot2.getId());
        int i6 = 0;
        int i7 = 0;
        lock = SnapshotKt.getLock();
        i2 = 0;
        int i3 = 0;
        i = SnapshotKt.access$getNextSnapshotId$p();
        SnapshotKt.access$setNextSnapshotId$p(i + 1);
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(i));
        NestedReadonlySnapshot nestedReadonlySnapshot2 = new NestedReadonlySnapshot(i, SnapshotKt.addRange(getInvalid$runtime_release(), id2 + 1, i), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, 0), (Snapshot)this);
        androidx.compose.runtime.snapshots.NestedReadonlySnapshot nestedReadonlySnapshot = nestedReadonlySnapshot2;
        int i8 = 0;
        synchronized (lock) {
            validateNotDisposed$runtime_release();
            validateNotAppliedOrPinned();
            snapshot2 = this;
            i5 = 0;
            snapshot2.recordPrevious$runtime_release(snapshot2.getId());
            i6 = 0;
            i7 = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            i3 = 0;
            i = SnapshotKt.access$getNextSnapshotId$p();
            SnapshotKt.access$setNextSnapshotId$p(i + 1);
            SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(i));
            nestedReadonlySnapshot2 = new NestedReadonlySnapshot(i, SnapshotKt.addRange(getInvalid$runtime_release(), id2 + 1, i), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, 0), (Snapshot)this);
            nestedReadonlySnapshot = nestedReadonlySnapshot2;
            i8 = 0;
        }
        if (!snapshot2.getDisposed$runtime_release()) {
            int i9 = 0;
            Object lock2 = SnapshotKt.getLock();
            range = 0;
            int i4 = 0;
            int i12 = SnapshotKt.access$getNextSnapshotId$p();
            SnapshotKt.access$setNextSnapshotId$p(i12 + 1);
            snapshot2.setId$runtime_release(i12);
            SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(snapshot2.getId()));
            Unit iNSTANCE = Unit.INSTANCE;
            snapshot2.setInvalid$runtime_release(SnapshotKt.addRange(snapshot2.getInvalid$runtime_release(), lock + 1, snapshot2.getId()));
            synchronized (lock2) {
                i9 = 0;
                lock2 = SnapshotKt.getLock();
                range = 0;
                i4 = 0;
                i12 = SnapshotKt.access$getNextSnapshotId$p();
                SnapshotKt.access$setNextSnapshotId$p(i12 + 1);
                snapshot2.setId$runtime_release(i12);
                SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(snapshot2.getId()));
                iNSTANCE = Unit.INSTANCE;
                snapshot2.setInvalid$runtime_release(SnapshotKt.addRange(snapshot2.getInvalid$runtime_release(), lock + 1, snapshot2.getId()));
            }
        }
        return (Snapshot)nestedReadonlySnapshot2;
    }
}
