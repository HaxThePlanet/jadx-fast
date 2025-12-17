package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotThreadLocal;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000 T2\u00020\u0001:\u0001TB\u0017\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u00101\u001a\u00020\"H\u0000¢\u0006\u0002\u00082J\r\u00103\u001a\u00020\"H\u0010¢\u0006\u0002\u00084J\u0008\u00105\u001a\u00020\"H\u0016J\"\u00106\u001a\u0002H7\"\u0004\u0008\u0000\u001072\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u0002H709H\u0086\u0008¢\u0006\u0002\u0010:J\u0008\u0010;\u001a\u00020\u0008H&J\n\u0010<\u001a\u0004\u0018\u00010\u0000H\u0011J\u0015\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u0000H ¢\u0006\u0002\u0008?J\u0015\u0010@\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u0000H ¢\u0006\u0002\u0008AJ\r\u0010B\u001a\u00020\"H ¢\u0006\u0002\u0008CJ\u0015\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\u001aH ¢\u0006\u0002\u0008FJ\r\u0010G\u001a\u00020\"H\u0000¢\u0006\u0002\u0008HJ\r\u0010I\u001a\u00020\"H\u0010¢\u0006\u0002\u0008JJ\u0012\u0010K\u001a\u00020\"2\u0008\u0010>\u001a\u0004\u0018\u00010\u0000H\u0011J \u0010L\u001a\u00020\u00002\u0016\u0008\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!H&J\r\u0010M\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0008NJ\n\u0010O\u001a\u0004\u0018\u00010\u0000H\u0007J\u0012\u0010P\u001a\u00020\"2\u0008\u0010Q\u001a\u0004\u0018\u00010\u0000H\u0007J\r\u0010R\u001a\u00020\"H\u0000¢\u0006\u0002\u0008SR\u001a\u0010\u0007\u001a\u00020\u0008X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u00020\u00088À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\nR\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X \u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u001e\u0010\u001fR(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!8 X¡\u0004¢\u0006\u000c\u0012\u0004\u0008#\u0010\u001f\u001a\u0004\u0008$\u0010%R\u0012\u0010&\u001a\u00020\u0008X¦\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010\nR\u0012\u0010(\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010*R$\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00038P@PX\u0090\u000e¢\u0006\u000c\u001a\u0004\u0008-\u0010\u000f\"\u0004\u0008.\u0010\u0011R \u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!X \u0004¢\u0006\u0006\u001a\u0004\u00080\u0010%\u0082\u0001\u0004UVWX¨\u0006Y", d2 = {"Landroidx/compose/runtime/snapshots/Snapshot;", "", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "disposed", "", "getDisposed$runtime_release", "()Z", "setDisposed$runtime_release", "(Z)V", "<set-?>", "getId", "()I", "setId$runtime_release", "(I)V", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "isPinned", "isPinned$runtime_release", "modified", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "pinningTrackingHandle", "getPinningTrackingHandle$annotations", "()V", "readObserver", "Lkotlin/Function1;", "", "getReadObserver$annotations", "getReadObserver", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "value", "writeCount", "getWriteCount$runtime_release", "setWriteCount$runtime_release", "writeObserver", "getWriteObserver$runtime_release", "closeAndReleasePinning", "closeAndReleasePinning$runtime_release", "closeLocked", "closeLocked$runtime_release", "dispose", "enter", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasPendingChanges", "makeCurrent", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "releasePinnedSnapshotLocked", "releasePinnedSnapshotLocked$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "restoreCurrent", "takeNestedSnapshot", "takeoverPinnedSnapshot", "takeoverPinnedSnapshot$runtime_release", "unsafeEnter", "unsafeLeave", "oldSnapshot", "validateNotDisposed", "validateNotDisposed$runtime_release", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Snapshot {

    public static final int $stable = 0;
    public static final androidx.compose.runtime.snapshots.Snapshot.Companion Companion = null;
    public static final int PreexistingSnapshotId = 1;
    private boolean disposed;
    private int id;
    private androidx.compose.runtime.snapshots.SnapshotIdSet invalid;
    private int pinningTrackingHandle;

    @Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0017\u001a\u00020\u0007H\u0001J\"\u0010\u0018\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u00192\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u001bH\u0086\u0008¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u00072\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0001J\u0006\u0010\u001f\u001a\u00020 JO\u0010!\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u00192\u0016\u0008\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#2\u0016\u0008\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#2\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u001b¢\u0006\u0002\u0010%J\u0008\u0010&\u001a\u00020\u0004H\u0007J&\u0010'\u001a\u00020(2\u001e\u0010)\u001a\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010+\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0*J\u001a\u0010,\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 0#J\n\u0010-\u001a\u0004\u0018\u00010\u0007H\u0001J\u0012\u0010.\u001a\u00020 2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0001J0\u0010/\u001a\u00020 2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020\u00072\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#H\u0001J\u0006\u00101\u001a\u00020 J6\u00102\u001a\u0002032\u0016\u0008\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#2\u0016\u0008\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#J\u001e\u00104\u001a\u00020\u00072\u0016\u0008\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010#J\"\u00105\u001a\u0002H6\"\u0004\u0008\u0000\u001062\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H60\u001bH\u0086\u0008¢\u0006\u0002\u0010\u001cJ4\u00107\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u0002H\u00190\u001b¢\u0006\u0002\u00088H\u0086\u0008\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00078@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u0002\u001a\u0004\u0008\u000c\u0010\tR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u000e*\u00020\u00128Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0019\u0010\u0011\u001a\u00020\u000e*\u00020\u00158Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0016¨\u00069", d2 = {"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "", "()V", "PreexistingSnapshotId", "", "getPreexistingSnapshotId$annotations", "current", "Landroidx/compose/runtime/snapshots/Snapshot;", "getCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "currentThreadSnapshot", "getCurrentThreadSnapshot$annotations", "getCurrentThreadSnapshot", "isApplyObserverNotificationPending", "", "()Z", "isInSnapshot", "canBeReused", "Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "getCanBeReused", "(Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;)Z", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "(Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;)Z", "createNonObservableSnapshot", "global", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "makeCurrentNonObservable", "previous", "notifyObjectsInitialized", "", "observe", "readObserver", "Lkotlin/Function1;", "writeObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "openSnapshotCount", "registerApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "observer", "Lkotlin/Function2;", "", "registerGlobalWriteObserver", "removeCurrent", "restoreCurrent", "restoreNonObservable", "nonObservable", "sendApplyNotifications", "takeMutableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "takeSnapshot", "withMutableSnapshot", "R", "withoutReadObservation", "Landroidx/compose/runtime/DisallowComposableCalls;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public static void $r8$lambda$Bb0cCydqw6jHa8lL87_KyHycPgI(Function1 function1) {
            Snapshot.Companion.registerGlobalWriteObserver$lambda$9(function1);
        }

        public static void $r8$lambda$GEUC571cySCO9vsVP4XWU3olfh0(Function2 function2) {
            Snapshot.Companion.registerApplyObserver$lambda$6(function2);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private final boolean getCanBeReused(androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot $this$canBeReused) {
            int i;
            final int i2 = 0;
            i = Long.compare(threadId$runtime_release, currentThreadId) == 0 ? 1 : 0;
            return i;
        }

        private final boolean getCanBeReused(androidx.compose.runtime.snapshots.TransparentObserverSnapshot $this$canBeReused) {
            int i;
            final int i2 = 0;
            i = Long.compare(threadId$runtime_release, currentThreadId) == 0 ? 1 : 0;
            return i;
        }

        public static void getCurrentThreadSnapshot$annotations() {
        }

        public static void getPreexistingSnapshotId$annotations() {
        }

        public static Object observe$default(androidx.compose.runtime.snapshots.Snapshot.Companion snapshot$Companion, Function1 function12, Function1 function13, Function0 function04, int i5, Object object6) {
            int obj2;
            int obj3;
            final int i = 0;
            if (i5 & 1 != 0) {
                obj2 = i;
            }
            if (i5 &= 2 != 0) {
                obj3 = i;
            }
            return companion.observe(obj2, obj3, function04);
        }

        private static final void registerApplyObserver$lambda$6(Function2 $observer) {
            final int i = 0;
            final Object lock = SnapshotKt.getLock();
            final int i2 = 0;
            int i3 = 0;
            SnapshotKt.access$setApplyObservers$p(CollectionsKt.minus((Iterable)SnapshotKt.access$getApplyObservers$p(), $observer));
            Unit iNSTANCE = Unit.INSTANCE;
            return;
            synchronized (lock) {
                i = 0;
                lock = SnapshotKt.getLock();
                i2 = 0;
                i3 = 0;
                SnapshotKt.access$setApplyObservers$p(CollectionsKt.minus((Iterable)SnapshotKt.access$getApplyObservers$p(), $observer));
                iNSTANCE = Unit.INSTANCE;
            }
        }

        private static final void registerGlobalWriteObserver$lambda$9(Function1 $observer) {
            final int i = 0;
            final Object lock = SnapshotKt.getLock();
            final int i2 = 0;
            int i3 = 0;
            SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.minus((Iterable)SnapshotKt.access$getGlobalWriteObservers$p(), $observer));
            Unit iNSTANCE = Unit.INSTANCE;
            SnapshotKt.access$advanceGlobalSnapshot();
            return;
            synchronized (lock) {
                i = 0;
                lock = SnapshotKt.getLock();
                i2 = 0;
                i3 = 0;
                SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.minus((Iterable)SnapshotKt.access$getGlobalWriteObservers$p(), $observer));
                iNSTANCE = Unit.INSTANCE;
                SnapshotKt.access$advanceGlobalSnapshot();
            }
        }

        public static androidx.compose.runtime.snapshots.MutableSnapshot takeMutableSnapshot$default(androidx.compose.runtime.snapshots.Snapshot.Companion snapshot$Companion, Function1 function12, Function1 function13, int i4, Object object5) {
            int obj2;
            int obj3;
            final int i = 0;
            if (i4 & 1 != 0) {
                obj2 = i;
            }
            if (i4 &= 2 != 0) {
                obj3 = i;
            }
            return companion.takeMutableSnapshot(obj2, obj3);
        }

        public static androidx.compose.runtime.snapshots.Snapshot takeSnapshot$default(androidx.compose.runtime.snapshots.Snapshot.Companion snapshot$Companion, Function1 function12, int i3, Object object4) {
            int obj1;
            if (i3 &= 1 != 0) {
                obj1 = 0;
            }
            return companion.takeSnapshot(obj1);
        }

        public final androidx.compose.runtime.snapshots.Snapshot createNonObservableSnapshot() {
            final int i3 = 0;
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default((Snapshot)SnapshotKt.access$getThreadSnapshot$p().get(), i3, false, 6, i3);
        }

        public final androidx.compose.runtime.snapshots.Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final androidx.compose.runtime.snapshots.Snapshot getCurrentThreadSnapshot() {
            return (Snapshot)SnapshotKt.access$getThreadSnapshot$p().get();
        }

        public final <T> T global(Function0<? extends T> block) {
            final int i = 0;
            final Object invoke = block.invoke();
            final Object obj = invoke;
            final int i2 = 0;
            Snapshot.Companion.restoreCurrent(removeCurrent());
            return invoke;
        }

        public final boolean isApplyObserverNotificationPending() {
            int i;
            i = SnapshotKt.access$getPendingApplyObserverCount$p().get() > 0 ? 1 : 0;
            return i;
        }

        public final boolean isInSnapshot() {
            int i;
            i = SnapshotKt.access$getThreadSnapshot$p().get() != null ? 1 : 0;
            return i;
        }

        public final androidx.compose.runtime.snapshots.Snapshot makeCurrentNonObservable(androidx.compose.runtime.snapshots.Snapshot previous) {
            Object transparentSnapshotWithNoParentReadObserver$default;
            boolean $this$canBeReused$iv;
            boolean obj;
            Object obj2;
            int i2;
            Object obj4;
            int i;
            int cmp;
            long currentThreadId;
            final int i4 = 0;
            final int i5 = 0;
            if (previous instanceof TransparentObserverMutableSnapshot) {
                obj4 = this;
                i = 0;
                $this$canBeReused$iv = Long.compare(threadId$runtime_release2, currentThreadId) == 0 ? i2 : i4;
                if ($this$canBeReused$iv != 0) {
                    (TransparentObserverMutableSnapshot)previous.setReadObserver(i5);
                    transparentSnapshotWithNoParentReadObserver$default = previous;
                } else {
                    if (previous instanceof TransparentObserverSnapshot) {
                        obj4 = this;
                        i = 0;
                        if (Long.compare(threadId$runtime_release, currentThreadId) == 0) {
                        } else {
                            i2 = i4;
                        }
                        if (i2 != 0) {
                            (TransparentObserverSnapshot)previous.setReadObserver(i5);
                        } else {
                            SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default(previous, i5, i4, 6, i5).makeCurrent();
                        }
                    } else {
                    }
                }
            } else {
            }
            return transparentSnapshotWithNoParentReadObserver$default;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
        }

        public final <T> T observe(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver, Function0<? extends T> block) {
            boolean obj;
            int i4;
            androidx.compose.runtime.snapshots.Snapshot takeNestedSnapshot;
            int transparentObserverMutableSnapshot;
            Function1 function13;
            Function1 i;
            Function1 function1;
            int i2;
            Function1 function12;
            int i3;
            long currentThreadId;
            if (readObserver == null && writeObserver == null) {
                if (writeObserver == null) {
                    return block.invoke();
                }
            }
            final Object obj7 = obj2;
            transparentObserverMutableSnapshot = 0;
            if (obj7 instanceof TransparentObserverMutableSnapshot) {
                function13 = this;
                i = 0;
                i3 = 0;
                i2 = Long.compare(threadId$runtime_release, currentThreadId) == 0 ? 1 : i3;
                if (i2 != 0) {
                    Function1 readObserver$runtime_release = (TransparentObserverMutableSnapshot)obj7.getReadObserver$runtime_release();
                    Function1 writeObserver$runtime_release = (TransparentObserverMutableSnapshot)obj7.getWriteObserver$runtime_release();
                    (TransparentObserverMutableSnapshot)obj7.setReadObserver(SnapshotKt.mergedReadObserver$default(readObserver, readObserver$runtime_release, i3, 4, transparentObserverMutableSnapshot));
                    (TransparentObserverMutableSnapshot)obj7.setWriteObserver(SnapshotKt.access$mergedWriteObserver(writeObserver, writeObserver$runtime_release));
                    (TransparentObserverMutableSnapshot)obj7.setReadObserver(readObserver$runtime_release);
                    (TransparentObserverMutableSnapshot)obj7.setWriteObserver(writeObserver$runtime_release);
                    return block.invoke();
                }
            }
            if (obj7 != null) {
                if (obj7 instanceof MutableSnapshot) {
                    i4 = transparentObserverMutableSnapshot;
                    if (obj7 instanceof MutableSnapshot) {
                        i4 = obj7;
                    }
                    transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(i4, readObserver, writeObserver, 1, 0);
                    takeNestedSnapshot = transparentObserverMutableSnapshot;
                } else {
                    if (readObserver == null) {
                        return block.invoke();
                    }
                    takeNestedSnapshot = obj7.takeNestedSnapshot(readObserver);
                    function1 = readObserver;
                    function12 = writeObserver;
                }
            } else {
            }
            final androidx.compose.runtime.snapshots.Snapshot obj10 = takeNestedSnapshot;
            final androidx.compose.runtime.snapshots.Snapshot obj11 = obj10;
            int i5 = 0;
            obj11.restoreCurrent(obj11.makeCurrent());
            obj10.dispose();
            return block.invoke();
        }

        public final int openSnapshotCount() {
            return CollectionsKt.toList((Iterable)SnapshotKt.access$getOpenSnapshots$p()).size();
        }

        public final androidx.compose.runtime.snapshots.ObserverHandle registerApplyObserver(Function2<? super Set<? extends Object>, ? super androidx.compose.runtime.snapshots.Snapshot, Unit> observer) {
            SnapshotKt.access$advanceGlobalSnapshot(SnapshotKt.access$getEmptyLambda$p());
            int i = 0;
            final Object lock = SnapshotKt.getLock();
            final int i2 = 0;
            int i3 = 0;
            SnapshotKt.access$setApplyObservers$p(CollectionsKt.plus((Collection)SnapshotKt.access$getApplyObservers$p(), observer));
            Unit iNSTANCE = Unit.INSTANCE;
            Snapshot.Companion$$ExternalSyntheticLambda0 $i$f$sync = new Snapshot.Companion$$ExternalSyntheticLambda0(observer);
            return $i$f$sync;
            synchronized (lock) {
                SnapshotKt.access$advanceGlobalSnapshot(SnapshotKt.access$getEmptyLambda$p());
                i = 0;
                lock = SnapshotKt.getLock();
                i2 = 0;
                i3 = 0;
                SnapshotKt.access$setApplyObservers$p(CollectionsKt.plus((Collection)SnapshotKt.access$getApplyObservers$p(), observer));
                iNSTANCE = Unit.INSTANCE;
                $i$f$sync = new Snapshot.Companion$$ExternalSyntheticLambda0(observer);
                return $i$f$sync;
            }
        }

        public final androidx.compose.runtime.snapshots.ObserverHandle registerGlobalWriteObserver(Function1<Object, Unit> observer) {
            int i = 0;
            final Object lock = SnapshotKt.getLock();
            final int i2 = 0;
            int i3 = 0;
            SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.plus((Collection)SnapshotKt.access$getGlobalWriteObservers$p(), observer));
            Unit iNSTANCE = Unit.INSTANCE;
            SnapshotKt.access$advanceGlobalSnapshot();
            Snapshot.Companion$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new Snapshot.Companion$$ExternalSyntheticLambda1(observer);
            return externalSyntheticLambda1;
            synchronized (lock) {
                i = 0;
                lock = SnapshotKt.getLock();
                i2 = 0;
                i3 = 0;
                SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.plus((Collection)SnapshotKt.access$getGlobalWriteObservers$p(), observer));
                iNSTANCE = Unit.INSTANCE;
                SnapshotKt.access$advanceGlobalSnapshot();
                externalSyntheticLambda1 = new Snapshot.Companion$$ExternalSyntheticLambda1(observer);
                return externalSyntheticLambda1;
            }
        }

        public final androidx.compose.runtime.snapshots.Snapshot removeCurrent() {
            SnapshotThreadLocal snapshotThreadLocal;
            int i;
            Object obj = SnapshotKt.access$getThreadSnapshot$p().get();
            if ((Snapshot)obj != null) {
                SnapshotKt.access$getThreadSnapshot$p().set(0);
            }
            return (Snapshot)obj;
        }

        public final void restoreCurrent(androidx.compose.runtime.snapshots.Snapshot previous) {
            SnapshotThreadLocal snapshotThreadLocal;
            if (previous != null) {
                SnapshotKt.access$getThreadSnapshot$p().set(previous);
            }
        }

        public final void restoreNonObservable(androidx.compose.runtime.snapshots.Snapshot previous, androidx.compose.runtime.snapshots.Snapshot nonObservable, Function1<Object, Unit> observer) {
            Object obj;
            if (previous == nonObservable) {
                if (previous instanceof TransparentObserverMutableSnapshot) {
                    (TransparentObserverMutableSnapshot)previous.setReadObserver(observer);
                } else {
                    if (!previous instanceof TransparentObserverSnapshot) {
                    } else {
                        (TransparentObserverSnapshot)previous.setReadObserver(observer);
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Non-transparent snapshot was reused: ").append(previous).toString().toString());
                throw illegalStateException;
            }
            nonObservable.restoreCurrent(previous);
            nonObservable.dispose();
        }

        public final void sendApplyNotifications() {
            MutableScatterSet modified$runtime_release;
            int i2;
            int i;
            final int i3 = 0;
            final Object lock = SnapshotKt.getLock();
            final int i4 = 0;
            final int i5 = 0;
            modified$runtime_release = (GlobalSnapshot)SnapshotKt.access$getCurrentGlobalSnapshot$p().get().getModified$runtime_release();
            i2 = 0;
            synchronized (lock) {
                i = 1;
                if (modified$runtime_release.isNotEmpty() == i) {
                    i2 = i;
                }
                if (i2 != 0) {
                }
            }
            SnapshotKt.access$advanceGlobalSnapshot();
        }

        public final androidx.compose.runtime.snapshots.MutableSnapshot takeMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
            androidx.compose.runtime.snapshots.Snapshot takeNestedMutableSnapshot;
            if (takeNestedMutableSnapshot instanceof MutableSnapshot) {
            } else {
                takeNestedMutableSnapshot = 0;
            }
            if (takeNestedMutableSnapshot == null) {
            } else {
                takeNestedMutableSnapshot = takeNestedMutableSnapshot.takeNestedMutableSnapshot(readObserver, writeObserver);
                if (takeNestedMutableSnapshot == null) {
                } else {
                    return takeNestedMutableSnapshot;
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
            throw illegalStateException;
        }

        public final androidx.compose.runtime.snapshots.Snapshot takeSnapshot(Function1<Object, Unit> readObserver) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(readObserver);
        }

        public final <R> R withMutableSnapshot(Function0<? extends R> block) {
            final int i = 0;
            int i2 = 0;
            androidx.compose.runtime.snapshots.MutableSnapshot takeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(this, i2, i2, 3, i2);
            int i4 = 0;
            androidx.compose.runtime.snapshots.MutableSnapshot mutableSnapshot = takeMutableSnapshot$default;
            int i5 = 0;
            final Object invoke = block.invoke();
            mutableSnapshot.restoreCurrent((Snapshot)mutableSnapshot.makeCurrent());
            Object this_$iv2 = invoke;
            int i6 = 0;
            takeMutableSnapshot$default.apply().check();
            takeMutableSnapshot$default.dispose();
            return invoke;
        }

        public final <T> T withoutReadObservation(Function0<? extends T> block) {
            Function1 readObserver;
            final int i = 0;
            final androidx.compose.runtime.snapshots.Snapshot currentThreadSnapshot = getCurrentThreadSnapshot();
            if (currentThreadSnapshot != null) {
                readObserver = currentThreadSnapshot.getReadObserver();
            } else {
                readObserver = 0;
            }
            restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable(currentThreadSnapshot), readObserver);
            return block.invoke();
        }
    }
    static {
        Snapshot.Companion companion = new Snapshot.Companion(0);
        Snapshot.Companion = companion;
        Snapshot.$stable = 8;
    }

    private Snapshot(int id, androidx.compose.runtime.snapshots.SnapshotIdSet invalid) {
        int trackPinning;
        super();
        this.invalid = invalid;
        this.id = id;
        if (id != 0) {
            trackPinning = SnapshotKt.trackPinning(id, getInvalid$runtime_release());
        } else {
            trackPinning = -1;
        }
        this.pinningTrackingHandle = trackPinning;
    }

    public Snapshot(int i, androidx.compose.runtime.snapshots.SnapshotIdSet snapshotIdSet2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(i, snapshotIdSet2);
    }

    public static final int access$getPinningTrackingHandle$p(androidx.compose.runtime.snapshots.Snapshot $this) {
        return $this.pinningTrackingHandle;
    }

    private static void getPinningTrackingHandle$annotations() {
    }

    public static void getReadObserver$annotations() {
    }

    public static androidx.compose.runtime.snapshots.Snapshot takeNestedSnapshot$default(androidx.compose.runtime.snapshots.Snapshot snapshot, Function1 function12, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            if (i3 &= 1 != 0) {
                obj1 = 0;
            }
            return snapshot.takeNestedSnapshot(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
        throw obj0;
    }

    public final void closeAndReleasePinning$runtime_release() {
        final int i = 0;
        final Object lock = SnapshotKt.getLock();
        final int i2 = 0;
        int i3 = 0;
        closeLocked$runtime_release();
        releasePinnedSnapshotsForCloseLocked$runtime_release();
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lock) {
            i = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            i3 = 0;
            closeLocked$runtime_release();
            releasePinnedSnapshotsForCloseLocked$runtime_release();
            iNSTANCE = Unit.INSTANCE;
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().clear(getId()));
    }

    public void dispose() {
        this.disposed = true;
        int i2 = 0;
        final Object lock = SnapshotKt.getLock();
        final int i3 = 0;
        int i4 = 0;
        releasePinnedSnapshotLocked$runtime_release();
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lock) {
            this.disposed = true;
            i2 = 0;
            lock = SnapshotKt.getLock();
            i3 = 0;
            i4 = 0;
            releasePinnedSnapshotLocked$runtime_release();
            iNSTANCE = Unit.INSTANCE;
        }
    }

    public final <T> T enter(Function0<? extends T> block) {
        final int i = 0;
        restoreCurrent(makeCurrent());
        return block.invoke();
    }

    public final boolean getDisposed$runtime_release() {
        return this.disposed;
    }

    public int getId() {
        return this.id;
    }

    public androidx.compose.runtime.snapshots.SnapshotIdSet getInvalid$runtime_release() {
        return this.invalid;
    }

    public abstract MutableScatterSet<androidx.compose.runtime.snapshots.StateObject> getModified$runtime_release();

    public abstract Function1<Object, Unit> getReadObserver();

    public abstract boolean getReadOnly();

    public abstract androidx.compose.runtime.snapshots.Snapshot getRoot();

    public int getWriteCount$runtime_release() {
        return 0;
    }

    public abstract Function1<Object, Unit> getWriteObserver$runtime_release();

    public abstract boolean hasPendingChanges();

    public final boolean isPinned$runtime_release() {
        int i;
        final int i2 = 0;
        i = Snapshot.access$getPinningTrackingHandle$p(this) >= 0 ? 1 : 0;
        return i;
    }

    public androidx.compose.runtime.snapshots.Snapshot makeCurrent() {
        SnapshotKt.access$getThreadSnapshot$p().set(this);
        return (Snapshot)SnapshotKt.access$getThreadSnapshot$p().get();
    }

    public abstract void nestedActivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot);

    public abstract void nestedDeactivated$runtime_release(androidx.compose.runtime.snapshots.Snapshot snapshot);

    public abstract void notifyObjectsInitialized$runtime_release();

    public abstract void recordModified$runtime_release(androidx.compose.runtime.snapshots.StateObject stateObject);

    public final void releasePinnedSnapshotLocked$runtime_release() {
        int pinningTrackingHandle;
        if (this.pinningTrackingHandle >= 0) {
            SnapshotKt.releasePinningLocked(this.pinningTrackingHandle);
            this.pinningTrackingHandle = -1;
        }
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePinnedSnapshotLocked$runtime_release();
    }

    public void restoreCurrent(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        SnapshotKt.access$getThreadSnapshot$p().set(snapshot);
    }

    public final void setDisposed$runtime_release(boolean <set-?>) {
        this.disposed = <set-?>;
    }

    public void setId$runtime_release(int <set-?>) {
        this.id = <set-?>;
    }

    public void setInvalid$runtime_release(androidx.compose.runtime.snapshots.SnapshotIdSet <set-?>) {
        this.invalid = <set-?>;
    }

    public void setWriteCount$runtime_release(int value) {
        IllegalStateException illegalStateException = new IllegalStateException("Updating write count is not supported for this snapshot".toString());
        throw illegalStateException;
    }

    public abstract androidx.compose.runtime.snapshots.Snapshot takeNestedSnapshot(Function1<Object, Unit> function1);

    public final int takeoverPinnedSnapshot$runtime_release() {
        final int pinningTrackingHandle = this.pinningTrackingHandle;
        final int i = pinningTrackingHandle;
        final int i2 = 0;
        this.pinningTrackingHandle = -1;
        return pinningTrackingHandle;
    }

    public final androidx.compose.runtime.snapshots.Snapshot unsafeEnter() {
        return makeCurrent();
    }

    public final void unsafeLeave(androidx.compose.runtime.snapshots.Snapshot oldSnapshot) {
        int i;
        String string;
        StringBuilder append;
        String str;
        i = SnapshotKt.access$getThreadSnapshot$p().get() == this ? 1 : 0;
        final int i2 = 0;
        if (i == 0) {
            int i3 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder.append("Cannot leave snapshot; ").append(this).append(" is not the current snapshot").toString());
        }
        restoreCurrent(oldSnapshot);
    }

    public final void validateNotDisposed$runtime_release() {
        String str;
        final int i2 = 0;
        if (disposed ^= 1 == 0) {
            int i3 = 0;
            PreconditionsKt.throwIllegalArgumentException("Cannot use a disposed snapshot");
        }
    }
}
