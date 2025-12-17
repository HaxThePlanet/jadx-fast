package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0001\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a\u0008\u0010)\u001a\u00020\u0008H\u0002\u001a6\u0010)\u001a\u0002H*\"\u0004\u0008\u0000\u0010*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010,\u001a\u0008\u0010-\u001a\u00020\u0008H\u0002\u001a4\u0010.\u001a\u00020\u00072\u0008\u0010/\u001a\u0004\u0018\u00010\u00072\u0016\u0008\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000f2\u0008\u0008\u0002\u00101\u001a\u000202H\u0002\u001a\u001f\u00103\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*H\u0001¢\u0006\u0002\u00106\u001a'\u00103\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u00108\u001a\u0008\u00109\u001a\u00020\u0007H\u0000\u001aL\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000f2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000f2\u0008\u0008\u0002\u0010<\u001a\u000202H\u0002\u001aB\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000f2\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000fH\u0002\u001a\u0018\u0010?\u001a\u00020\u00082\u0006\u00107\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0016H\u0001\u001a.\u0010A\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000204\u0018\u00010B2\u0006\u00109\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0010H\u0002\u001a\u0010\u0010F\u001a\u0002022\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\u0010\u0010G\u001a\u00020\u00082\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\u0008\u0010H\u001a\u00020IH\u0002\u001a1\u0010J\u001a\u0004\u0018\u0001H*\"\u0008\u0008\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010L\u001a\u0010\u0010M\u001a\u00020\u00082\u0006\u0010N\u001a\u00020\u0001H\u0000\u001a\u0008\u0010O\u001a\u00020IH\u0002\u001a\"\u0010P\u001a\u0002H*\"\u0004\u0008\u0000\u0010*2\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u0002H*0QH\u0081\u0008¢\u0006\u0002\u0010R\u001a>\u0010S\u001a\u0002H*\"\u0004\u0008\u0000\u0010*2\u0006\u0010T\u001a\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010U\u001a:\u0010V\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010W\u001a\u0018\u0010X\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0000\u001a\u0012\u0010Y\u001a\u0004\u0018\u0001042\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u0010[\u001a\u0002042\u0006\u00107\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u00109\u001a\u00020\u00012\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a\u0010\u0010]\u001a\u00020\u00082\u0006\u00107\u001a\u00020\u0007H\u0002\u001a\u001c\u0010^\u001a\u00020\u0010*\u00020\u00102\u0006\u0010_\u001a\u00020\u00012\u0006\u0010`\u001a\u00020\u0001H\u0000\u001a!\u0010a\u001a\u000204*\u0002042\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002020\u000fH\u0082\u0008\u001a#\u0010c\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016H\u0000¢\u0006\u0002\u0010d\u001a+\u0010e\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010f\u001a+\u0010g\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010f\u001aK\u0010h\u001a\u0002Hi\"\u0008\u0008\u0000\u0010**\u000204\"\u0004\u0008\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010j\u001a\u0002H*2\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\u0008kH\u0080\u0008¢\u0006\u0002\u0010l\u001a3\u0010m\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0006\u0010j\u001a\u0002H*H\u0000¢\u0006\u0002\u0010n\u001a!\u0010J\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016¢\u0006\u0002\u0010d\u001a)\u0010J\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007¢\u0006\u0002\u0010f\u001aE\u0010o\u001a\u0002Hi\"\u0008\u0008\u0000\u0010**\u000204\"\u0004\u0008\u0001\u0010i*\u0002H*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u0011H*¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(5\u0012\u0004\u0012\u0002Hi0\u000fH\u0086\u0008¢\u0006\u0002\u0010p\u001aC\u0010q\u001a\u0002Hi\"\u0008\u0008\u0000\u0010**\u000204\"\u0004\u0008\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\u0008kH\u0086\u0008¢\u0006\u0002\u0010r\u001aK\u0010q\u001a\u0002Hi\"\u0008\u0008\u0000\u0010**\u000204\"\u0004\u0008\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\u0008kH\u0086\u0008¢\u0006\u0002\u0010s\u001a+\u0010t\u001a\u0002H*\"\u0008\u0008\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\",\u0010\u0002\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u00040\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\".\u0010\t\u001a\"\u0012\u000c\u0012\n \u000c*\u0004\u0018\u00010\u000b0\u000b0\nj\u0010\u0012\u000c\u0012\n \u000c*\u0004\u0018\u00010\u000b0\u000b`\rX\u0082\u0004¢\u0006\u0002\n\u0000\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00080\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00080\u000f0\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010\u0018\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0019\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u001c\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010#\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008$\u0010\u001a\u001a\u0004\u0008%\u0010&\"\u0014\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00070(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u", d2 = {"INVALID_SNAPSHOT", "", "applyObservers", "", "Lkotlin/Function2;", "", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "emptyLambda", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "Lkotlin/ParameterName;", "name", "invalid", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "globalWriteObservers", "lock", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "nextSnapshotId", "openSnapshots", "pendingApplyObserverCount", "Landroidx/compose/runtime/AtomicInt;", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "advanceGlobalSnapshot", "T", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "checkAndOverwriteUnusedRecordsLocked", "createTransparentSnapshotWithNoParentReadObserver", "previousSnapshot", "readObserver", "ownsPreviousSnapshot", "", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "r", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "snapshot", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "currentSnapshot", "mergedReadObserver", "parentObserver", "mergeReadObserver", "mergedWriteObserver", "writeObserver", "notifyWrite", "state", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "overwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "readError", "", "readable", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "releasePinningLocked", "handle", "reportReadonlySnapshotWrite", "sync", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeNewGlobalSnapshot", "previousGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "trackPinning", "usedLocked", "valid", "data", "candidateSnapshot", "validateOpen", "addRange", "from", "until", "findYoungestOr", "predicate", "newOverwritableRecordLocked", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecordLocked", "overwritable", "R", "candidate", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableRecord", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnapshotKt {

    private static final int INVALID_SNAPSHOT;
    private static List<? extends Function2<? super Set<? extends Object>, ? super androidx.compose.runtime.snapshots.Snapshot, Unit>> applyObservers;
    private static final AtomicReference<androidx.compose.runtime.snapshots.GlobalSnapshot> currentGlobalSnapshot;
    private static final Function1<androidx.compose.runtime.snapshots.SnapshotIdSet, Unit> emptyLambda;
    private static final androidx.compose.runtime.snapshots.SnapshotWeakSet<androidx.compose.runtime.snapshots.StateObject> extraStateObjects;
    private static List<? extends Function1<Object, Unit>> globalWriteObservers;
    private static final Object lock;
    private static int nextSnapshotId;
    private static androidx.compose.runtime.snapshots.SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final androidx.compose.runtime.snapshots.SnapshotDoubleIndexHeap pinningTable;
    private static final androidx.compose.runtime.snapshots.Snapshot snapshotInitializer;
    private static final SnapshotThreadLocal<androidx.compose.runtime.snapshots.Snapshot> threadSnapshot;
    static {
        SnapshotKt.emptyLambda = (Function1)SnapshotKt.emptyLambda.1.INSTANCE;
        SnapshotThreadLocal snapshotThreadLocal = new SnapshotThreadLocal();
        SnapshotKt.threadSnapshot = snapshotThreadLocal;
        Object object = new Object();
        SnapshotKt.lock = object;
        SnapshotKt.openSnapshots = SnapshotIdSet.Companion.getEMPTY();
        SnapshotKt.nextSnapshotId = 2;
        SnapshotDoubleIndexHeap snapshotDoubleIndexHeap = new SnapshotDoubleIndexHeap();
        SnapshotKt.pinningTable = snapshotDoubleIndexHeap;
        SnapshotWeakSet snapshotWeakSet = new SnapshotWeakSet();
        SnapshotKt.extraStateObjects = snapshotWeakSet;
        SnapshotKt.applyObservers = CollectionsKt.emptyList();
        SnapshotKt.globalWriteObservers = CollectionsKt.emptyList();
        int nextSnapshotId = SnapshotKt.nextSnapshotId;
        SnapshotKt.nextSnapshotId = nextSnapshotId + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(nextSnapshotId, SnapshotIdSet.Companion.getEMPTY());
        int i4 = 0;
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(globalSnapshot.getId());
        AtomicReference atomicReference = new AtomicReference(globalSnapshot);
        SnapshotKt.currentGlobalSnapshot = atomicReference;
        SnapshotKt.snapshotInitializer = (Snapshot)SnapshotKt.currentGlobalSnapshot.get();
        AtomicInt atomicInt = new AtomicInt(0);
        SnapshotKt.pendingApplyObserverCount = atomicInt;
    }

    public static final Object access$advanceGlobalSnapshot(Function1 block) {
        return SnapshotKt.advanceGlobalSnapshot(block);
    }

    public static final void access$advanceGlobalSnapshot() {
        SnapshotKt.advanceGlobalSnapshot();
    }

    public static final void access$checkAndOverwriteUnusedRecordsLocked() {
        SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
    }

    public static final androidx.compose.runtime.snapshots.Snapshot access$createTransparentSnapshotWithNoParentReadObserver(androidx.compose.runtime.snapshots.Snapshot previousSnapshot, Function1 readObserver, boolean ownsPreviousSnapshot) {
        return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(previousSnapshot, readObserver, ownsPreviousSnapshot);
    }

    public static final List access$getApplyObservers$p() {
        return SnapshotKt.applyObservers;
    }

    public static final AtomicReference access$getCurrentGlobalSnapshot$p() {
        return SnapshotKt.currentGlobalSnapshot;
    }

    public static final Function1 access$getEmptyLambda$p() {
        return SnapshotKt.emptyLambda;
    }

    public static final List access$getGlobalWriteObservers$p() {
        return SnapshotKt.globalWriteObservers;
    }

    public static final int access$getNextSnapshotId$p() {
        return SnapshotKt.nextSnapshotId;
    }

    public static final androidx.compose.runtime.snapshots.SnapshotIdSet access$getOpenSnapshots$p() {
        return SnapshotKt.openSnapshots;
    }

    public static final AtomicInt access$getPendingApplyObserverCount$p() {
        return SnapshotKt.pendingApplyObserverCount;
    }

    public static final SnapshotThreadLocal access$getThreadSnapshot$p() {
        return SnapshotKt.threadSnapshot;
    }

    public static final Function1 access$mergedReadObserver(Function1 readObserver, Function1 parentObserver, boolean mergeReadObserver) {
        return SnapshotKt.mergedReadObserver(readObserver, parentObserver, mergeReadObserver);
    }

    public static final Function1 access$mergedWriteObserver(Function1 writeObserver, Function1 parentObserver) {
        return SnapshotKt.mergedWriteObserver(writeObserver, parentObserver);
    }

    public static final Map access$optimisticMerges(androidx.compose.runtime.snapshots.MutableSnapshot currentSnapshot, androidx.compose.runtime.snapshots.MutableSnapshot applyingSnapshot, androidx.compose.runtime.snapshots.SnapshotIdSet invalidSnapshots) {
        return SnapshotKt.optimisticMerges(currentSnapshot, applyingSnapshot, invalidSnapshots);
    }

    public static final void access$processForUnusedRecordsLocked(androidx.compose.runtime.snapshots.StateObject state) {
        SnapshotKt.processForUnusedRecordsLocked(state);
    }

    public static final Void access$readError() {
        return SnapshotKt.readError();
    }

    public static final androidx.compose.runtime.snapshots.StateRecord access$readable(androidx.compose.runtime.snapshots.StateRecord r, int id, androidx.compose.runtime.snapshots.SnapshotIdSet invalid) {
        return SnapshotKt.readable(r, id, invalid);
    }

    public static final Void access$reportReadonlySnapshotWrite() {
        return SnapshotKt.reportReadonlySnapshotWrite();
    }

    public static final void access$setApplyObservers$p(List <set-?>) {
        SnapshotKt.applyObservers = <set-?>;
    }

    public static final void access$setGlobalWriteObservers$p(List <set-?>) {
        SnapshotKt.globalWriteObservers = <set-?>;
    }

    public static final void access$setNextSnapshotId$p(int <set-?>) {
        SnapshotKt.nextSnapshotId = <set-?>;
    }

    public static final void access$setOpenSnapshots$p(androidx.compose.runtime.snapshots.SnapshotIdSet <set-?>) {
        SnapshotKt.openSnapshots = <set-?>;
    }

    public static final Object access$takeNewGlobalSnapshot(androidx.compose.runtime.snapshots.Snapshot previousGlobalSnapshot, Function1 block) {
        return SnapshotKt.takeNewGlobalSnapshot(previousGlobalSnapshot, block);
    }

    public static final androidx.compose.runtime.snapshots.Snapshot access$takeNewSnapshot(Function1 block) {
        return SnapshotKt.takeNewSnapshot(block);
    }

    public static final void access$validateOpen(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        SnapshotKt.validateOpen(snapshot);
    }

    public static final androidx.compose.runtime.snapshots.SnapshotIdSet addRange(androidx.compose.runtime.snapshots.SnapshotIdSet $this$addRange, int from, int until) {
        androidx.compose.runtime.snapshots.SnapshotIdSet result;
        int invalidId;
        result = $this$addRange;
        invalidId = from;
        while (invalidId < until) {
            result = result.set(invalidId);
            invalidId++;
        }
        return result;
    }

    private static final <T> T advanceGlobalSnapshot(Function1<? super androidx.compose.runtime.snapshots.SnapshotIdSet, ? extends T> block) {
        int observers;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object previousGlobalSnapshot;
        androidx.collection.MutableScatterSet modified;
        int i3;
        int it;
        Object lock;
        int i;
        int i2;
        AtomicInt pendingApplyObserverCount;
        Function1 function1;
        List list;
        int elements;
        int index$iv;
        int size;
        Object metadata;
        Object obj3;
        int i$iv$iv;
        androidx.collection.MutableScatterSet set;
        long slot$iv$iv;
        androidx.collection.MutableScatterSet $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i4;
        Object obj2;
        int i5;
        long l;
        Object obj;
        int i6;
        int i7 = 0;
        Intrinsics.checkNotNull(SnapshotKt.snapshotInitializer, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        int i11 = 0;
        i3 = 0;
        lock = SnapshotKt.getLock();
        i = 0;
        observers = 0;
        previousGlobalSnapshot = obj4;
        modified = modified$runtime_release;
        synchronized (lock) {
            SnapshotKt.pendingApplyObserverCount.add(1);
            if (modified != null) {
            }
            it = 0;
            Object lock2 = SnapshotKt.getLock();
            int i14 = 0;
            $this$maskEmptyOrDeleted$iv$iv$iv = 0;
            SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
            synchronized (lock2) {
                i2 = modified;
                list = 0;
                size = 0;
                metadata = index$iv.metadata;
                length += -2;
                if (0 <= obj3) {
                } else {
                    i5 = $this$maskEmptyOrDeleted$iv$iv$iv;
                    obj2 = previousGlobalSnapshot;
                    $this$maskEmptyOrDeleted$iv$iv$iv2 = modified;
                    i4 = it;
                }
                $this$maskEmptyOrDeleted$iv$iv$iv = Unit.INSTANCE;
                try {
                    return SnapshotKt.takeNewGlobalSnapshot((Snapshot)previousGlobalSnapshot, block);
                    obj2 = obj1;
                    $this$maskEmptyOrDeleted$iv$iv$iv2 = obj2;
                    i4 = obj3;
                    throw th;
                    function1 = block;
                    obj2 = obj1;
                    $this$maskEmptyOrDeleted$iv$iv$iv2 = obj2;
                    function1 = block;
                    obj2 = obj1;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        lock = 0;
        list = applyObservers;
        elements = 0;
        index$iv = 0;
        while (index$iv < list.size()) {
            i$iv$iv = 0;
            (Function2)list.get(index$iv).invoke(ScatterSetWrapperKt.wrapIntoSet((ScatterSet)modified), previousGlobalSnapshot);
            index$iv++;
            i2 = 1;
        }
        SnapshotKt.pendingApplyObserverCount.add(-1);
    }

    private static final void advanceGlobalSnapshot() {
        SnapshotKt.advanceGlobalSnapshot((Function1)SnapshotKt.advanceGlobalSnapshot.3.INSTANCE);
    }

    private static final void checkAndOverwriteUnusedRecordsLocked() {
        int currentUsed$iv;
        int i$iv2;
        int i$iv;
        int i;
        WeakReference hashes$runtime_release2;
        int hashes$runtime_release;
        int i2;
        boolean overwriteUnusedRecordsLocked;
        final androidx.compose.runtime.snapshots.SnapshotWeakSet extraStateObjects = SnapshotKt.extraStateObjects;
        final int i3 = 0;
        final int size$runtime_release = extraStateObjects.getSize$runtime_release();
        currentUsed$iv = 0;
        i$iv2 = 0;
        while (i$iv2 < size$runtime_release) {
            hashes$runtime_release2 = extraStateObjects.getValues$runtime_release()[i$iv2];
            if (hashes$runtime_release2 != null) {
            }
            i2 = 0;
            if (i != 0 && SnapshotKt.overwriteUnusedRecordsLocked((StateObject)i) && currentUsed$iv != i$iv2) {
            }
            i$iv2++;
            i2 = 0;
            if (SnapshotKt.overwriteUnusedRecordsLocked((StateObject)i)) {
            }
            if (currentUsed$iv != i$iv2) {
            }
            currentUsed$iv++;
            extraStateObjects.getValues$runtime_release()[currentUsed$iv] = hashes$runtime_release2;
            extraStateObjects.getHashes$runtime_release()[currentUsed$iv] = extraStateObjects.getHashes$runtime_release()[i$iv2];
            i = hashes$runtime_release2.get();
        }
        i$iv = currentUsed$iv;
        while (i$iv < size$runtime_release) {
            extraStateObjects.getValues$runtime_release()[i$iv] = 0;
            extraStateObjects.getHashes$runtime_release()[i$iv] = 0;
            i$iv++;
        }
        if (currentUsed$iv != size$runtime_release) {
            extraStateObjects.setSize$runtime_release(currentUsed$iv);
        }
    }

    private static final androidx.compose.runtime.snapshots.Snapshot createTransparentSnapshotWithNoParentReadObserver(androidx.compose.runtime.snapshots.Snapshot previousSnapshot, Function1<Object, Unit> readObserver, boolean ownsPreviousSnapshot) {
        androidx.compose.runtime.snapshots.Snapshot transparentObserverSnapshot;
        int i2;
        int transparentObserverMutableSnapshot;
        int i;
        Function1 function1;
        int i3;
        int i4;
        boolean z;
        if (!previousSnapshot instanceof MutableSnapshot) {
            if (previousSnapshot == null) {
                if (previousSnapshot instanceof MutableSnapshot) {
                    i2 = previousSnapshot;
                } else {
                    i2 = 0;
                }
                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(i2, readObserver, 0, 0, ownsPreviousSnapshot);
                transparentObserverSnapshot = transparentObserverMutableSnapshot;
            } else {
                transparentObserverSnapshot = new TransparentObserverSnapshot(previousSnapshot, readObserver, 0, ownsPreviousSnapshot);
                function1 = readObserver;
                z = ownsPreviousSnapshot;
            }
        } else {
        }
        return transparentObserverSnapshot;
    }

    static androidx.compose.runtime.snapshots.Snapshot createTransparentSnapshotWithNoParentReadObserver$default(androidx.compose.runtime.snapshots.Snapshot snapshot, Function1 function12, boolean z3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 2 != 0) {
            obj1 = 0;
        }
        if (i4 &= 4 != 0) {
            obj2 = 0;
        }
        return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(snapshot, obj1, obj2);
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord> T current(T r) {
        androidx.compose.runtime.snapshots.StateRecord readable;
        Object invalid$runtime_release2;
        int i;
        Throwable th;
        androidx.compose.runtime.snapshots.Snapshot current;
        int i2;
        androidx.compose.runtime.snapshots.StateRecord readable2;
        androidx.compose.runtime.snapshots.SnapshotIdSet invalid$runtime_release;
        androidx.compose.runtime.snapshots.Snapshot current2 = Snapshot.Companion.getCurrent();
        final int i3 = 0;
        if (SnapshotKt.readable(r, current2.getId(), current2.getInvalid$runtime_release()) == null) {
            int i4 = 0;
            invalid$runtime_release2 = SnapshotKt.getLock();
            i = 0;
            th = 0;
            current = Snapshot.Companion.getCurrent();
            i2 = 0;
            readable2 = SnapshotKt.readable(r, current.getId(), current.getInvalid$runtime_release());
            synchronized (invalid$runtime_release2) {
                i4 = 0;
                invalid$runtime_release2 = SnapshotKt.getLock();
                i = 0;
                th = 0;
                current = Snapshot.Companion.getCurrent();
                i2 = 0;
                readable2 = SnapshotKt.readable(r, current.getId(), current.getInvalid$runtime_release());
            }
            readable = readable2;
        }
        return readable;
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord> T current(T r, androidx.compose.runtime.snapshots.Snapshot snapshot) {
        androidx.compose.runtime.snapshots.StateRecord readable = SnapshotKt.readable(r, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable == null) {
        } else {
            return readable;
        }
        SnapshotKt.readError();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final androidx.compose.runtime.snapshots.Snapshot currentSnapshot() {
        Object obj;
        if ((Snapshot)SnapshotKt.threadSnapshot.get() == null) {
            obj = SnapshotKt.currentGlobalSnapshot.get();
        }
        return obj;
    }

    private static final androidx.compose.runtime.snapshots.StateRecord findYoungestOr(androidx.compose.runtime.snapshots.StateRecord $this$findYoungestOr, Function1<? super androidx.compose.runtime.snapshots.StateRecord, Boolean> predicate) {
        Object current;
        Object youngest;
        int snapshotId$runtime_release;
        int snapshotId$runtime_release2;
        final int i = 0;
        current = $this$findYoungestOr;
        youngest = $this$findYoungestOr;
        while (current != null) {
            if (youngest.getSnapshotId$runtime_release() < current.getSnapshotId$runtime_release()) {
            }
            current = current.getNext$runtime_release();
            youngest = current;
        }
        return youngest;
    }

    public static final Object getLock() {
        return SnapshotKt.lock;
    }

    public static void getLock$annotations() {
    }

    public static final androidx.compose.runtime.snapshots.Snapshot getSnapshotInitializer() {
        return SnapshotKt.snapshotInitializer;
    }

    public static void getSnapshotInitializer$annotations() {
    }

    private static final Function1<Object, Unit> mergedReadObserver(Function1<Object, Unit> readObserver, Function1<Object, Unit> parentObserver, boolean mergeReadObserver) {
        int i;
        int anon;
        i = mergeReadObserver ? parentObserver : 0;
        if (readObserver != 0 && i != 0 && readObserver != i) {
            if (i != 0) {
                if (readObserver != i) {
                    anon = new SnapshotKt.mergedReadObserver.1(readObserver, i);
                } else {
                    anon = readObserver == 0 ? i : readObserver;
                }
            } else {
            }
        } else {
        }
        return anon;
    }

    static Function1 mergedReadObserver$default(Function1 function1, Function1 function12, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 4 != 0) {
            obj2 = 1;
        }
        return SnapshotKt.mergedReadObserver(function1, function12, obj2);
    }

    private static final Function1<Object, Unit> mergedWriteObserver(Function1<Object, Unit> writeObserver, Function1<Object, Unit> parentObserver) {
        Function1 anon;
        if (writeObserver != null && parentObserver != null && writeObserver != parentObserver) {
            if (parentObserver != null) {
                if (writeObserver != parentObserver) {
                    anon = new SnapshotKt.mergedWriteObserver.1(writeObserver, parentObserver);
                } else {
                    anon = writeObserver == null ? parentObserver : writeObserver;
                }
            } else {
            }
        } else {
        }
        return anon;
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord> T newOverwritableRecordLocked(T $this$newOverwritableRecordLocked, androidx.compose.runtime.snapshots.StateObject state) {
        androidx.compose.runtime.snapshots.StateRecord usedLocked;
        int str;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int i;
        usedLocked = SnapshotKt.usedLocked(state);
        str = Integer.MAX_VALUE;
        if (usedLocked != null) {
            i = 0;
            usedLocked.setSnapshotId$runtime_release(str);
        } else {
            usedLocked = $this$newOverwritableRecordLocked.create();
            stateRecord = usedLocked;
            i = 0;
            stateRecord.setSnapshotId$runtime_release(str);
            stateRecord.setNext$runtime_release(state.getFirstStateRecord());
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$16");
            state.prependStateRecord(stateRecord);
            Intrinsics.checkNotNull(usedLocked, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        }
        return usedLocked;
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord> T newWritableRecord(T $this$newWritableRecord, androidx.compose.runtime.snapshots.StateObject state, androidx.compose.runtime.snapshots.Snapshot snapshot) {
        final int i = 0;
        final Object lock = SnapshotKt.getLock();
        final int i2 = 0;
        final int i3 = 0;
        return SnapshotKt.newWritableRecordLocked($this$newWritableRecord, state, snapshot);
        synchronized (lock) {
            i = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            i3 = 0;
            return SnapshotKt.newWritableRecordLocked($this$newWritableRecord, state, snapshot);
        }
    }

    private static final <T extends androidx.compose.runtime.snapshots.StateRecord> T newWritableRecordLocked(T $this$newWritableRecordLocked, androidx.compose.runtime.snapshots.StateObject state, androidx.compose.runtime.snapshots.Snapshot snapshot) {
        final androidx.compose.runtime.snapshots.StateRecord overwritableRecordLocked = SnapshotKt.newOverwritableRecordLocked($this$newWritableRecordLocked, state);
        overwritableRecordLocked.assign($this$newWritableRecordLocked);
        overwritableRecordLocked.setSnapshotId$runtime_release(snapshot.getId());
        return overwritableRecordLocked;
    }

    public static final void notifyWrite(androidx.compose.runtime.snapshots.Snapshot snapshot, androidx.compose.runtime.snapshots.StateObject state) {
        snapshot.setWriteCount$runtime_release(writeCount$runtime_release++);
        Function1 writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(state);
        }
    }

    private static final Map<androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateRecord> optimisticMerges(androidx.compose.runtime.snapshots.MutableSnapshot currentSnapshot, androidx.compose.runtime.snapshots.MutableSnapshot applyingSnapshot, androidx.compose.runtime.snapshots.SnapshotIdSet invalidSnapshots) {
        androidx.collection.MutableScatterSet first;
        int id;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        androidx.compose.runtime.snapshots.SnapshotIdSet set;
        int start;
        androidx.collection.MutableScatterSet readable;
        int mergeRecords;
        int i$iv$iv;
        long slot$iv$iv;
        androidx.collection.MutableScatterSet $this$maskEmptyOrDeleted$iv$iv$iv2;
        int result;
        int i7;
        int i6;
        int start2;
        androidx.compose.runtime.snapshots.SnapshotIdSet id2;
        int start3;
        long l;
        int i;
        int i4;
        androidx.collection.MutableScatterSet modified;
        int i5;
        androidx.compose.runtime.snapshots.SnapshotIdSet previous;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int i2;
        androidx.compose.runtime.snapshots.StateRecord first2;
        int hashMap;
        HashMap map;
        int i8;
        int i3;
        first = applyingSnapshot.getModified$runtime_release();
        if (first == null) {
            return 0;
        }
        readable = first;
        final int i16 = 0;
        final long[] metadata = set3.metadata;
        length += -2;
        if (0 <= i17) {
        } else {
            modified = first;
            start2 = id;
            previous = set;
            first = start;
            $this$maskEmptyOrDeleted$iv$iv$iv2 = readable;
            i2 = mergeRecords;
            result = start;
        }
        return (Map)result;
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord, R> R overwritable(T $this$overwritable, androidx.compose.runtime.snapshots.StateObject state, T candidate, Function1<? super T, ? extends R> block) {
        final int i = 0;
        int i2 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshot = SnapshotKt.getSnapshotInitializer();
        int i3 = 0;
        Object lock = SnapshotKt.getLock();
        final int i5 = 0;
        final int i6 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshot2 = current;
        Object invoke = block.invoke(SnapshotKt.overwritableRecord($this$overwritable, state, snapshot2, candidate));
        Object $i$f$sync = invoke;
        int i4 = 0;
        SnapshotKt.notifyWrite(snapshot2, state);
        return invoke;
        synchronized (lock) {
            i = 0;
            i2 = 0;
            snapshot = SnapshotKt.getSnapshotInitializer();
            i3 = 0;
            lock = SnapshotKt.getLock();
            i5 = 0;
            i6 = 0;
            snapshot2 = current;
            invoke = block.invoke(SnapshotKt.overwritableRecord($this$overwritable, state, snapshot2, candidate));
            $i$f$sync = invoke;
            i4 = 0;
            SnapshotKt.notifyWrite(snapshot2, state);
            return invoke;
        }
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord> T overwritableRecord(T $this$overwritableRecord, androidx.compose.runtime.snapshots.StateObject state, androidx.compose.runtime.snapshots.Snapshot snapshot, T candidate) {
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(state);
        }
        int id = snapshot.getId();
        if (candidate.getSnapshotId$runtime_release() == id) {
            return candidate;
        }
        int i = 0;
        Object lock = SnapshotKt.getLock();
        final int i3 = 0;
        final int i4 = 0;
        final androidx.compose.runtime.snapshots.StateRecord overwritableRecordLocked = SnapshotKt.newOverwritableRecordLocked($this$overwritableRecord, state);
        overwritableRecordLocked.setSnapshotId$runtime_release(id);
        synchronized (lock) {
            i = 0;
            lock = SnapshotKt.getLock();
            i3 = 0;
            i4 = 0;
            overwritableRecordLocked = SnapshotKt.newOverwritableRecordLocked($this$overwritableRecord, state);
            overwritableRecordLocked.setSnapshotId$runtime_release(id);
        }
        snapshot.recordModified$runtime_release(state);
        return overwritableRecordLocked;
    }

    private static final boolean overwriteUnusedRecordsLocked(androidx.compose.runtime.snapshots.StateObject state) {
        androidx.compose.runtime.snapshots.StateRecord current;
        int overwriteRecord;
        int validRecord;
        int retainedRecords;
        int i;
        int i2;
        int snapshotId$runtime_release4;
        androidx.compose.runtime.snapshots.StateRecord stateRecord;
        int snapshotId$runtime_release;
        int i3;
        androidx.compose.runtime.snapshots.StateRecord current$iv;
        androidx.compose.runtime.snapshots.StateRecord youngest$iv;
        int it;
        int snapshotId$runtime_release3;
        int snapshotId$runtime_release2;
        current = state.getFirstStateRecord();
        overwriteRecord = 0;
        validRecord = 0;
        int lowestOrDefault = SnapshotKt.pinningTable.lowestOrDefault(SnapshotKt.nextSnapshotId);
        retainedRecords = 0;
        i = 0;
        i2 = 1;
        while (current != null) {
            snapshotId$runtime_release4 = current.getSnapshotId$runtime_release();
            if (snapshotId$runtime_release4 != 0) {
            }
            current = current.getNext$runtime_release();
            i = 0;
            i2 = 1;
            if (snapshotId$runtime_release4 < lowestOrDefault) {
            } else {
            }
            retainedRecords++;
            if (validRecord == 0) {
            } else {
            }
            if (current.getSnapshotId$runtime_release() < validRecord.getSnapshotId$runtime_release()) {
            } else {
            }
            stateRecord = validRecord;
            validRecord = current;
            if (overwriteRecord == 0) {
            }
            stateRecord.setSnapshotId$runtime_release(i);
            stateRecord.assign(overwriteRecord);
            snapshotId$runtime_release = state.getFirstStateRecord();
            i3 = 0;
            current$iv = snapshotId$runtime_release;
            youngest$iv = snapshotId$runtime_release;
            while (current$iv != null) {
                snapshotId$runtime_release3 = 0;
                if (current$iv.getSnapshotId$runtime_release() >= lowestOrDefault) {
                } else {
                }
                it = i;
                if (youngest$iv.getSnapshotId$runtime_release() < current$iv.getSnapshotId$runtime_release()) {
                }
                current$iv = current$iv.getNext$runtime_release();
                youngest$iv = current$iv;
                it = i2;
            }
            current$iv = youngest$iv;
            overwriteRecord = current$iv;
            snapshotId$runtime_release3 = 0;
            if (current$iv.getSnapshotId$runtime_release() >= lowestOrDefault) {
            } else {
            }
            it = i;
            if (it != 0) {
            } else {
            }
            if (youngest$iv.getSnapshotId$runtime_release() < current$iv.getSnapshotId$runtime_release()) {
            }
            current$iv = current$iv.getNext$runtime_release();
            youngest$iv = current$iv;
            it = i2;
            stateRecord = current;
            validRecord = current;
            retainedRecords++;
        }
        if (retainedRecords > i2) {
            i = i2;
        }
        return i;
    }

    private static final void processForUnusedRecordsLocked(androidx.compose.runtime.snapshots.StateObject state) {
        boolean overwriteUnusedRecordsLocked;
        if (SnapshotKt.overwriteUnusedRecordsLocked(state)) {
            SnapshotKt.extraStateObjects.add(state);
        }
    }

    private static final Void readError() {
        IllegalStateException illegalStateException = new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
        throw illegalStateException;
    }

    private static final <T extends androidx.compose.runtime.snapshots.StateRecord> T readable(T r, int id, androidx.compose.runtime.snapshots.SnapshotIdSet invalid) {
        androidx.compose.runtime.snapshots.StateRecord current;
        int candidate;
        boolean snapshotId$runtime_release;
        int snapshotId$runtime_release2;
        current = r;
        candidate = 0;
        while (current != null) {
            if (SnapshotKt.valid(current, id, invalid)) {
            }
            current = current.getNext$runtime_release();
            if (candidate == 0) {
            } else {
            }
            if (candidate.getSnapshotId$runtime_release() < current.getSnapshotId$runtime_release()) {
            } else {
            }
            snapshotId$runtime_release = candidate;
            candidate = snapshotId$runtime_release;
            snapshotId$runtime_release = current;
        }
        if (candidate != 0) {
            return candidate;
        }
        return 0;
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord> T readable(T $this$readable, androidx.compose.runtime.snapshots.StateObject state) {
        androidx.compose.runtime.snapshots.StateRecord $i$f$sync;
        Object invalid$runtime_release;
        int i2;
        Throwable th;
        androidx.compose.runtime.snapshots.Snapshot current;
        androidx.compose.runtime.snapshots.StateRecord readable;
        int i;
        androidx.compose.runtime.snapshots.SnapshotIdSet invalid$runtime_release2;
        androidx.compose.runtime.snapshots.Snapshot current2 = Snapshot.Companion.getCurrent();
        Function1 readObserver = current2.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(state);
        }
        if (SnapshotKt.readable($this$readable, current2.getId(), current2.getInvalid$runtime_release()) == null) {
            int i3 = 0;
            invalid$runtime_release = SnapshotKt.getLock();
            i2 = 0;
            th = 0;
            current = Snapshot.Companion.getCurrent();
            androidx.compose.runtime.snapshots.StateRecord firstStateRecord = state.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            readable = SnapshotKt.readable(firstStateRecord, current.getId(), current.getInvalid$runtime_release());
            synchronized (invalid$runtime_release) {
                $i$f$sync = readable;
            }
        }
        return $i$f$sync;
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord> T readable(T $this$readable, androidx.compose.runtime.snapshots.StateObject state, androidx.compose.runtime.snapshots.Snapshot snapshot) {
        Function1 readObserver = snapshot.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(state);
        }
        androidx.compose.runtime.snapshots.StateRecord readable = SnapshotKt.readable($this$readable, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable == null) {
        } else {
            return readable;
        }
        SnapshotKt.readError();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final void releasePinningLocked(int handle) {
        SnapshotKt.pinningTable.remove(handle);
    }

    private static final Void reportReadonlySnapshotWrite() {
        IllegalStateException illegalStateException = new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
        throw illegalStateException;
    }

    public static final <T> T sync(Function0<? extends T> block) {
        final int i = 0;
        final Object lock = SnapshotKt.getLock();
        final int i2 = 0;
        return block.invoke();
        synchronized (lock) {
            i = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            return block.invoke();
        }
    }

    private static final <T> T takeNewGlobalSnapshot(androidx.compose.runtime.snapshots.Snapshot previousGlobalSnapshot, Function1<? super androidx.compose.runtime.snapshots.SnapshotIdSet, ? extends T> block) {
        int i = 0;
        final Object lock = SnapshotKt.getLock();
        final int i2 = 0;
        int i3 = 0;
        final int nextSnapshotId = SnapshotKt.nextSnapshotId;
        SnapshotKt.nextSnapshotId = nextSnapshotId + 1;
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(previousGlobalSnapshot.getId());
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(nextSnapshotId, SnapshotKt.openSnapshots);
        SnapshotKt.currentGlobalSnapshot.set(globalSnapshot);
        previousGlobalSnapshot.dispose();
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(nextSnapshotId);
        Unit iNSTANCE = Unit.INSTANCE;
        return block.invoke(SnapshotKt.openSnapshots.clear(previousGlobalSnapshot.getId()));
        synchronized (lock) {
            i = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            i3 = 0;
            nextSnapshotId = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = nextSnapshotId + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(previousGlobalSnapshot.getId());
            globalSnapshot = new GlobalSnapshot(nextSnapshotId, SnapshotKt.openSnapshots);
            SnapshotKt.currentGlobalSnapshot.set(globalSnapshot);
            previousGlobalSnapshot.dispose();
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(nextSnapshotId);
            iNSTANCE = Unit.INSTANCE;
            return block.invoke(SnapshotKt.openSnapshots.clear(previousGlobalSnapshot.getId()));
        }
    }

    private static final <T extends androidx.compose.runtime.snapshots.Snapshot> T takeNewSnapshot(Function1<? super androidx.compose.runtime.snapshots.SnapshotIdSet, ? extends T> block) {
        SnapshotKt.takeNewSnapshot.1 anon = new SnapshotKt.takeNewSnapshot.1(block);
        return (Snapshot)SnapshotKt.advanceGlobalSnapshot((Function1)anon);
    }

    public static final int trackPinning(int id, androidx.compose.runtime.snapshots.SnapshotIdSet invalid) {
        final int i = 0;
        final Object lock = SnapshotKt.getLock();
        final int i2 = 0;
        final int i3 = 0;
        return SnapshotKt.pinningTable.add(invalid.lowest(id));
        synchronized (lock) {
            i = 0;
            lock = SnapshotKt.getLock();
            i2 = 0;
            i3 = 0;
            return SnapshotKt.pinningTable.add(invalid.lowest(id));
        }
    }

    private static final androidx.compose.runtime.snapshots.StateRecord usedLocked(androidx.compose.runtime.snapshots.StateObject state) {
        androidx.compose.runtime.snapshots.StateRecord current;
        int validRecord;
        int snapshotId$runtime_release;
        boolean valid;
        int i;
        current = state.getFirstStateRecord();
        validRecord = 0;
        while (current != null) {
            current = current.getNext$runtime_release();
            validRecord = current;
        }
        return null;
    }

    private static final boolean valid(int currentSnapshot, int candidateSnapshot, androidx.compose.runtime.snapshots.SnapshotIdSet invalid) {
        int i;
        boolean z;
        if (candidateSnapshot != 0 && candidateSnapshot <= currentSnapshot && !invalid.get(candidateSnapshot)) {
            if (candidateSnapshot <= currentSnapshot) {
                i = !invalid.get(candidateSnapshot) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private static final boolean valid(androidx.compose.runtime.snapshots.StateRecord data, int snapshot, androidx.compose.runtime.snapshots.SnapshotIdSet invalid) {
        return SnapshotKt.valid(snapshot, data.getSnapshotId$runtime_release(), invalid);
    }

    private static final void validateOpen(androidx.compose.runtime.snapshots.Snapshot snapshot) {
        int i;
        Object valueOf;
        if (!SnapshotKt.openSnapshots.get(snapshot.getId())) {
            StringBuilder stringBuilder = new StringBuilder();
            if (snapshot instanceof MutableSnapshot) {
                i = snapshot;
            } else {
                i = 0;
            }
            if (i != 0) {
                valueOf = Boolean.valueOf(i.getApplied$runtime_release());
            } else {
                valueOf = "read-only";
            }
            int i2 = 0;
            final Object lock = SnapshotKt.getLock();
            final int i3 = 0;
            final int i4 = 0;
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Snapshot is not open: id=").append(snapshot.getId()).append(", disposed=").append(snapshot.getDisposed$runtime_release()).append(", applied=").append(valueOf).append(", lowestPin=").append(SnapshotKt.pinningTable.lowestOrDefault(-1)).toString().toString());
            throw illegalStateException;
            synchronized (lock) {
                i2 = 0;
                lock = SnapshotKt.getLock();
                i3 = 0;
                i4 = 0;
                illegalStateException = new IllegalStateException(append5.append(valueOf).append(", lowestPin=").append(SnapshotKt.pinningTable.lowestOrDefault(-1)).toString().toString());
                throw illegalStateException;
            }
        }
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord, R> R withCurrent(T $this$withCurrent, Function1<? super T, ? extends R> block) {
        final int i = 0;
        return block.invoke(SnapshotKt.current($this$withCurrent));
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord, R> R writable(T $this$writable, androidx.compose.runtime.snapshots.StateObject state, androidx.compose.runtime.snapshots.Snapshot snapshot, Function1<? super T, ? extends R> block) {
        final int i = 0;
        int i2 = 0;
        Object lock = SnapshotKt.getLock();
        final int i4 = 0;
        final int i5 = 0;
        Object invoke = block.invoke(SnapshotKt.writableRecord($this$writable, state, snapshot));
        Object $i$f$sync = invoke;
        int i3 = 0;
        SnapshotKt.notifyWrite(snapshot, state);
        return invoke;
        synchronized (lock) {
            i = 0;
            i2 = 0;
            lock = SnapshotKt.getLock();
            i4 = 0;
            i5 = 0;
            invoke = block.invoke(SnapshotKt.writableRecord($this$writable, state, snapshot));
            $i$f$sync = invoke;
            i3 = 0;
            SnapshotKt.notifyWrite(snapshot, state);
            return invoke;
        }
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord, R> R writable(T $this$writable, androidx.compose.runtime.snapshots.StateObject state, Function1<? super T, ? extends R> block) {
        final int i = 0;
        int i2 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshot = SnapshotKt.getSnapshotInitializer();
        int i3 = 0;
        Object lock = SnapshotKt.getLock();
        final int i5 = 0;
        final int i6 = 0;
        androidx.compose.runtime.snapshots.Snapshot snapshot2 = current;
        Object invoke = block.invoke(SnapshotKt.writableRecord($this$writable, state, snapshot2));
        Object $i$f$sync = invoke;
        int i4 = 0;
        SnapshotKt.notifyWrite(snapshot2, state);
        return invoke;
        synchronized (lock) {
            i = 0;
            i2 = 0;
            snapshot = SnapshotKt.getSnapshotInitializer();
            i3 = 0;
            lock = SnapshotKt.getLock();
            i5 = 0;
            i6 = 0;
            snapshot2 = current;
            invoke = block.invoke(SnapshotKt.writableRecord($this$writable, state, snapshot2));
            $i$f$sync = invoke;
            i4 = 0;
            SnapshotKt.notifyWrite(snapshot2, state);
            return invoke;
        }
    }

    public static final <T extends androidx.compose.runtime.snapshots.StateRecord> T writableRecord(T $this$writableRecord, androidx.compose.runtime.snapshots.StateObject state, androidx.compose.runtime.snapshots.Snapshot snapshot) {
        androidx.compose.runtime.snapshots.StateRecord writableRecordLocked;
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(state);
        }
        int id = snapshot.getId();
        androidx.compose.runtime.snapshots.StateRecord readable = SnapshotKt.readable($this$writableRecord, id, snapshot.getInvalid$runtime_release());
        if (readable == null) {
        } else {
            if (readable.getSnapshotId$runtime_release() == snapshot.getId()) {
                return readable;
            }
            int i = 0;
            Object lock = SnapshotKt.getLock();
            final int i3 = 0;
            final int i4 = 0;
            androidx.compose.runtime.snapshots.StateRecord readable2 = SnapshotKt.readable(state.getFirstStateRecord(), id, snapshot.getInvalid$runtime_release());
            synchronized (lock) {
                if (readable2.getSnapshotId$runtime_release() == id) {
                    writableRecordLocked = readable2;
                } else {
                    writableRecordLocked = SnapshotKt.newWritableRecordLocked(readable2, state, snapshot);
                }
                Intrinsics.checkNotNull(writableRecordLocked, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
                if (readable.getSnapshotId$runtime_release() != 1) {
                }
                return writableRecordLocked;
            }
            snapshot.recordModified$runtime_release(state);
        }
        SnapshotKt.readError();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }
}
