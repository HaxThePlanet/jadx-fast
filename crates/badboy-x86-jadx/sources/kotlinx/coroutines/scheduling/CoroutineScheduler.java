package kotlinx.coroutines.scheduling;

import android.app.Notification.Action;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008!\u0008\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003IJKB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0011\u0010\r\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0086\u0008J\u0011\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\u0008J\u0008\u0010#\u001a\u00020$H\u0016J\u0008\u0010%\u001a\u00020\u0004H\u0002J\u001a\u0010&\u001a\u00020 2\n\u0010'\u001a\u00060(j\u0002`)2\u0006\u0010*\u001a\u00020+J\u0011\u0010\u0012\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0082\u0008J\u000e\u0010,\u001a\u0008\u0018\u00010\u001dR\u00020\u0000H\u0002J\t\u0010-\u001a\u00020$H\u0082\u0008J\t\u0010.\u001a\u00020\u0004H\u0082\u0008J&\u0010/\u001a\u00020$2\n\u0010'\u001a\u00060(j\u0002`)2\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u00100\u001a\u00020\u0018J\u0014\u00101\u001a\u00020$2\n\u00102\u001a\u00060(j\u0002`)H\u0016J\t\u00103\u001a\u00020\u0007H\u0082\u0008J\t\u00104\u001a\u00020\u0004H\u0082\u0008J\u0014\u00105\u001a\u00020\u00042\n\u00106\u001a\u00060\u001dR\u00020\u0000H\u0002J\u000e\u00107\u001a\u0008\u0018\u00010\u001dR\u00020\u0000H\u0002J\u0012\u00108\u001a\u00020\u00182\n\u00106\u001a\u00060\u001dR\u00020\u0000J\"\u00109\u001a\u00020$2\n\u00106\u001a\u00060\u001dR\u00020\u00002\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004J\t\u0010<\u001a\u00020\u0007H\u0082\u0008J\u000e\u0010=\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u0007J\u0018\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0018H\u0002J\u0006\u0010C\u001a\u00020$J\u0008\u0010D\u001a\u00020\tH\u0016J\t\u0010E\u001a\u00020\u0018H\u0082\u0008J\u0012\u0010F\u001a\u00020\u00182\u0008\u0008\u0002\u0010!\u001a\u00020\u0007H\u0002J\u0008\u0010G\u001a\u00020\u0018H\u0002J$\u0010H\u001a\u0004\u0018\u00010 *\u0008\u0018\u00010\u001dR\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u00100\u001a\u00020\u0018H\u0002R\t\u0010\u000b\u001a\u00020\u000cX\u0082\u0004R\u0015\u0010\r\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\t\u0010\u0010\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0012\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000fR\u0010\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0019R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\u001a\u001a\u00020\u0011X\u0082\u0004R\u0010\u0010\u0008\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000c\u0012\u0008\u0012\u00060\u001dR\u00020\u00000\u001c8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006L", d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "_isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "availableCpuPermits", "getAvailableCpuPermits", "()I", "controlState", "Lkotlinx/atomicfu/AtomicLong;", "createdWorkers", "getCreatedWorkers", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "isTerminated", "", "()Z", "parkedWorkersStack", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "addToGlobalQueue", "task", "Lkotlinx/coroutines/scheduling/Task;", "state", "blockingTasks", "close", "", "createNewWorker", "createTask", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "currentWorker", "decrementBlockingTasks", "decrementCreatedWorkers", "dispatch", "tailDispatch", "execute", "command", "incrementBlockingTasks", "incrementCreatedWorkers", "parkedWorkersStackNextIndex", "worker", "parkedWorkersStackPop", "parkedWorkersStackPush", "parkedWorkersStackTopUpdate", "oldIndex", "newIndex", "releaseCpuPermit", "runSafely", "shutdown", "timeout", "signalBlockingWork", "stateSnapshot", "skipUnpark", "signalCpuWork", "toString", "tryAcquireCpuPermit", "tryCreateWorker", "tryUnpark", "submitToLocalQueue", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoroutineScheduler implements Executor, Closeable {

    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int BLOCKING_SHIFT = 21;
    private static final int CLAIMED = 0;
    private static final long CPU_PERMITS_MASK = 9223367638808264704L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CREATED_MASK = 2097151L;
    public static final kotlinx.coroutines.scheduling.CoroutineScheduler.Companion Companion = null;
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    public static final Symbol NOT_IN_STACK = null;
    private static final int PARKED = -1;
    private static final long PARKED_INDEX_MASK = 2097151L;
    private static final long PARKED_VERSION_INC = 2097152L;
    private static final long PARKED_VERSION_MASK = -2097152L;
    private static final int TERMINATED = 1;
    private static final AtomicIntegerFieldUpdater _isTerminated$FU;
    private static final AtomicLongFieldUpdater controlState$FU;
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU;
    @Volatile
    private volatile int _isTerminated;
    @Volatile
    private volatile long controlState;
    public final int corePoolSize;
    public final kotlinx.coroutines.scheduling.GlobalQueue globalBlockingQueue;
    public final kotlinx.coroutines.scheduling.GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    @Volatile
    private volatile long parkedWorkersStack;
    public final String schedulerName;
    public final ResizableAtomicArray<kotlinx.coroutines.scheduling.CoroutineScheduler.Worker> workers;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal5;
            int ordinal2;
            int ordinal3;
            int ordinal4;
            int[] iArr = new int[values.length];
            iArr[CoroutineScheduler.WorkerState.PARKING.ordinal()] = 1;
            iArr[CoroutineScheduler.WorkerState.BLOCKING.ordinal()] = 2;
            iArr[CoroutineScheduler.WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[CoroutineScheduler.WorkerState.DORMANT.ordinal()] = 4;
            iArr[CoroutineScheduler.WorkerState.TERMINATED.ordinal()] = 5;
            CoroutineScheduler.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020 H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020\u000eH\u0002J\n\u0010,\u001a\u0004\u0018\u00010 H\u0002J\n\u0010-\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u0003H\u0002J\u0008\u00101\u001a\u00020\u000eH\u0002J\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003J\u0008\u00105\u001a\u00020%H\u0002J\n\u00106\u001a\u0004\u0018\u00010 H\u0002J\u0008\u00107\u001a\u00020%H\u0016J\u0006\u00108\u001a\u00020\u0010J\u0008\u00109\u001a\u00020%H\u0002J\u0008\u0010:\u001a\u00020\u000eH\u0002J\u0008\u0010;\u001a\u00020%H\u0002J\u000e\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001dJ\u0016\u0010>\u001a\u0004\u0018\u00010 2\n\u0010?\u001a\u00060\u0003j\u0002`@H\u0002J\u0008\u0010A\u001a\u00020%H\u0002R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u000c8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0006\u0010\"\u001a\u00020#¨\u0006B", d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "", "minDelayUntilStealableTaskNs", "", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlinx/coroutines/scheduling/Task;", "terminationDeadline", "workerCtl", "Lkotlinx/atomicfu/AtomicInt;", "afterTask", "", "taskMode", "beforeTask", "executeTask", "task", "findAnyTask", "scanLocalQueue", "findBlockingTask", "findCpuTask", "findTask", "idleReset", "mode", "inStack", "isIo", "nextInt", "upperBound", "park", "pollGlobalQueues", "run", "runSingleTask", "runWorker", "tryAcquireCpuPermit", "tryPark", "tryReleaseCpu", "newState", "trySteal", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryTerminateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class Worker extends Thread {

        private static final AtomicIntegerFieldUpdater workerCtl$FU;
        private volatile int indexInArray;
        public final kotlinx.coroutines.scheduling.WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState state;
        private final Ref.ObjectRef<kotlinx.coroutines.scheduling.Task> stolenTask;
        private long terminationDeadline;
        final kotlinx.coroutines.scheduling.CoroutineScheduler this$0;
        @Volatile
        private volatile int workerCtl;
        static {
            CoroutineScheduler.Worker.workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.Worker.class, "workerCtl");
        }

        private Worker(kotlinx.coroutines.scheduling.CoroutineScheduler this$0) {
            this.this$0 = this$0;
            super();
            setDaemon(true);
            WorkQueue workQueue = new WorkQueue();
            this.localQueue = workQueue;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            this.stolenTask = objectRef;
            this.state = CoroutineScheduler.WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
        }

        public Worker(kotlinx.coroutines.scheduling.CoroutineScheduler this$0, int index) {
            super(this$0);
            setIndexInArray(index);
        }

        public static final kotlinx.coroutines.scheduling.CoroutineScheduler access$getThis$0$p(kotlinx.coroutines.scheduling.CoroutineScheduler.Worker $this) {
            return $this.this$0;
        }

        private final void afterTask(int taskMode) {
            boolean aSSERTIONS_ENABLED;
            kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState tERMINATED;
            AtomicLongFieldUpdater num;
            if (taskMode == 0) {
            }
            int i = 0;
            CoroutineScheduler.access$getControlState$FU$p().addAndGet(this.this$0, -2097152);
            kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState this_$iv = this.state;
            if (this_$iv != CoroutineScheduler.WorkerState.TERMINATED && DebugKt.getASSERTIONS_ENABLED()) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    aSSERTIONS_ENABLED = 0;
                    num = this_$iv == CoroutineScheduler.WorkerState.BLOCKING ? 1 : 0;
                    if (num == 0) {
                    } else {
                    }
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
                this.state = CoroutineScheduler.WorkerState.DORMANT;
            }
        }

        private final void beforeTask(int taskMode) {
            boolean tryReleaseCpu;
            if (taskMode == 0) {
            }
            if (tryReleaseCpu(CoroutineScheduler.WorkerState.BLOCKING)) {
                this.this$0.signalCpuWork();
            }
        }

        private final void executeTask(kotlinx.coroutines.scheduling.Task task) {
            int i = 0;
            int this_$iv = obj.taskContext.getTaskMode();
            idleReset(this_$iv);
            beforeTask(this_$iv);
            this.this$0.runSafely(task);
            afterTask(this_$iv);
        }

        private final kotlinx.coroutines.scheduling.Task findAnyTask(boolean scanLocalQueue) {
            kotlinx.coroutines.scheduling.Task pollGlobalQueues2;
            kotlinx.coroutines.scheduling.Task pollGlobalQueues;
            if (scanLocalQueue) {
                pollGlobalQueues2 = nextInt(corePoolSize *= 2) == 0 ? 1 : 0;
                pollGlobalQueues = pollGlobalQueues();
                if (pollGlobalQueues2 != 0 && pollGlobalQueues != null) {
                    pollGlobalQueues = pollGlobalQueues();
                    if (pollGlobalQueues != null) {
                        int i5 = 0;
                        return pollGlobalQueues;
                    }
                }
                pollGlobalQueues = this.localQueue.poll();
                if (pollGlobalQueues != null) {
                    int i4 = 0;
                    return pollGlobalQueues;
                }
                pollGlobalQueues = pollGlobalQueues();
                if (pollGlobalQueues2 == 0 && pollGlobalQueues != null) {
                    pollGlobalQueues = pollGlobalQueues();
                    if (pollGlobalQueues != null) {
                        int i3 = 0;
                        return pollGlobalQueues;
                    }
                }
            } else {
                pollGlobalQueues2 = pollGlobalQueues();
                if (pollGlobalQueues2 != null) {
                    int i2 = 0;
                    return pollGlobalQueues2;
                }
            }
            return trySteal(3);
        }

        private final kotlinx.coroutines.scheduling.Task findBlockingTask() {
            Object pollBlocking;
            if (this.localQueue.pollBlocking() == null && (Task)this$0.globalBlockingQueue.removeFirstOrNull() == null) {
                if ((Task)this$0.globalBlockingQueue.removeFirstOrNull() == null) {
                    pollBlocking = trySteal(1);
                }
            }
            return pollBlocking;
        }

        private final kotlinx.coroutines.scheduling.Task findCpuTask() {
            Object firstOrNull;
            if (this.localQueue.pollCpu() == null && (Task)this$0.globalBlockingQueue.removeFirstOrNull() == null) {
                if ((Task)this$0.globalBlockingQueue.removeFirstOrNull() == null) {
                    firstOrNull = trySteal(2);
                }
            }
            return firstOrNull;
        }

        public static final AtomicIntegerFieldUpdater getWorkerCtl$FU() {
            return CoroutineScheduler.Worker.workerCtl$FU;
        }

        private final void idleReset(int mode) {
            kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState bLOCKING;
            boolean aSSERTIONS_ENABLED;
            kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState pARKING;
            this.terminationDeadline = 0;
            if (this.state == CoroutineScheduler.WorkerState.PARKING && DebugKt.getASSERTIONS_ENABLED()) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    aSSERTIONS_ENABLED = 0;
                    if (mode == 1) {
                    } else {
                        pARKING = 0;
                    }
                    if (pARKING == 0) {
                    } else {
                    }
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
                this.state = CoroutineScheduler.WorkerState.BLOCKING;
            }
        }

        private final boolean inStack() {
            int i;
            i = this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK ? 1 : 0;
            return i;
        }

        private final void park() {
            int cmp;
            long idleWorkerKeepAliveNs;
            final int i2 = 0;
            if (Long.compare(terminationDeadline, i2) == 0) {
                this.terminationDeadline = nanoTime += idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(this$0.idleWorkerKeepAliveNs);
            if (Long.compare(i, i2) >= 0) {
                this.terminationDeadline = i2;
                tryTerminateWorker();
            }
        }

        private final kotlinx.coroutines.scheduling.Task pollGlobalQueues() {
            Object firstOrNull = this$0.globalCpuQueue.removeFirstOrNull();
            if (nextInt(2) == 0 && (Task)firstOrNull != null) {
                firstOrNull = this$0.globalCpuQueue.removeFirstOrNull();
                if ((Task)(Task)firstOrNull != null) {
                    int i2 = 0;
                    return (Task)(Task)firstOrNull;
                }
                return (Task)it.globalBlockingQueue.removeFirstOrNull();
            }
            Object firstOrNull3 = this$02.globalBlockingQueue.removeFirstOrNull();
            if ((Task)firstOrNull3 != null) {
                int i3 = 0;
                return (Task)firstOrNull3;
            }
            return (Task)it2.globalCpuQueue.removeFirstOrNull();
        }

        private final void runWorker() {
            int rescanned;
            kotlinx.coroutines.scheduling.Task task;
            boolean terminated;
            int tERMINATED;
            int minDelayUntilStealableTaskNs;
            rescanned = 0;
            while (!this.this$0.isTerminated()) {
                if (this.state != CoroutineScheduler.WorkerState.TERMINATED) {
                }
                task = findTask(this.mayHaveLocalTasks);
                tERMINATED = 0;
                if (task != null) {
                } else {
                }
                this.mayHaveLocalTasks = false;
                if (Long.compare(minDelayUntilStealableTaskNs2, tERMINATED) != 0) {
                } else {
                }
                tryPark();
                if (rescanned == 0) {
                } else {
                }
                rescanned = 0;
                tryReleaseCpu(CoroutineScheduler.WorkerState.PARKING);
                Thread.interrupted();
                LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                this.minDelayUntilStealableTaskNs = tERMINATED;
                rescanned = 1;
                rescanned = 0;
                this.minDelayUntilStealableTaskNs = tERMINATED;
                executeTask(task);
            }
            tryReleaseCpu(CoroutineScheduler.WorkerState.TERMINATED);
        }

        private final boolean tryAcquireCpuPermit() {
            int $i$f$tryAcquireCpuPermit;
            Object cPU_ACQUIRED;
            int i3;
            boolean this_$iv$iv;
            kotlinx.coroutines.scheduling.CoroutineScheduler this$0;
            long l;
            int i;
            int i4;
            kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler;
            int i5;
            int i6;
            int i2;
            int i7;
            if (this.state == CoroutineScheduler.WorkerState.CPU_ACQUIRED) {
            } else {
                this$0 = this.this$0;
                int i8 = 0;
                coroutineScheduler = this$0;
                i5 = 0;
                l = CoroutineScheduler.access$getControlState$FU$p().get(this$0);
                i6 = 0;
                kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler2 = this$0;
                i = 0;
                i4 = 42;
                i7 = 0;
                while ((int)i10 == 0) {
                    l = cPU_ACQUIRED.get(this$0);
                    i6 = 0;
                    coroutineScheduler2 = this$0;
                    i = 0;
                    i4 = 42;
                    i7 = 0;
                }
                $i$f$tryAcquireCpuPermit = i7;
                if ($i$f$tryAcquireCpuPermit != 0) {
                    this.state = CoroutineScheduler.WorkerState.CPU_ACQUIRED;
                } else {
                    i3 = i7;
                }
            }
            return i3;
        }

        private final void tryPark() {
            AtomicIntegerFieldUpdater workerCtl$FU;
            boolean inStack;
            kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState tERMINATED;
            if (!inStack()) {
                this.this$0.parkedWorkersStackPush(this);
            }
            final int i = -1;
            CoroutineScheduler.Worker.workerCtl$FU.set(this, i);
            while (inStack()) {
                if (CoroutineScheduler.Worker.workerCtl$FU.get(this) == i) {
                    break;
                }
                if (!this.this$0.isTerminated()) {
                    break;
                }
                if (this.state == CoroutineScheduler.WorkerState.TERMINATED) {
                    break;
                } else {
                }
                tryReleaseCpu(CoroutineScheduler.WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final kotlinx.coroutines.scheduling.Task trySteal(int stealingMode) {
            int currentIndex;
            long minDelay;
            int i;
            int cmp;
            int i2;
            int i4;
            Object obj;
            long trySteal;
            Ref.ObjectRef stolenTask;
            int i3;
            int cmp2;
            final Object obj2 = this;
            int i5 = 0;
            final int i11 = 2097151;
            int this_$iv = (int)i8;
            int i9 = 0;
            if (this_$iv < 2) {
                return i9;
            }
            int i7 = 0;
            currentIndex = obj2.nextInt(this_$iv);
            int i10 = 0;
            minDelay = Long.MAX_VALUE;
            i = 0;
            while (i < this_$iv) {
                i2 = i;
                i4 = 0;
                if (currentIndex++ > this_$iv) {
                }
                obj = this$02.workers.get(currentIndex);
                i3 = stealingMode;
                i++;
                stolenTask = obj2.stolenTask;
                trySteal = obj.localQueue.trySteal(stealingMode, stolenTask);
                if (Long.compare(trySteal, cmp) > 0) {
                }
                minDelay = Math.min(minDelay, i11);
                currentIndex = 1;
            }
            int i12 = stealingMode;
            if (Long.compare(minDelay, l2) != 0) {
                cmp = minDelay;
            }
            obj2.minDelayUntilStealableTaskNs = cmp;
            return i9;
        }

        private final void tryTerminateWorker() {
            Object coroutineScheduler;
            int workers;
            ResizableAtomicArray workers2 = this$0.workers;
            kotlinx.coroutines.scheduling.CoroutineScheduler this$02 = this.this$0;
            final int i = 0;
            final int i2 = 0;
            final int i3 = 0;
            synchronized (workers2) {
            }
        }

        @Override // java.lang.Thread
        public final kotlinx.coroutines.scheduling.Task findTask(boolean mayHaveLocalTasks) {
            if (tryAcquireCpuPermit()) {
                return findAnyTask(mayHaveLocalTasks);
            }
            return findBlockingTask();
        }

        @Override // java.lang.Thread
        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @Override // java.lang.Thread
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        @Override // java.lang.Thread
        public final kotlinx.coroutines.scheduling.CoroutineScheduler getScheduler() {
            final int i = 0;
            return CoroutineScheduler.Worker.access$getThis$0$p(this);
        }

        @Override // java.lang.Thread
        public final int getWorkerCtl() {
            return this.workerCtl;
        }

        @Override // java.lang.Thread
        public final boolean isIo() {
            int i;
            i = this.state == CoroutineScheduler.WorkerState.BLOCKING ? 1 : 0;
            return i;
        }

        @Override // java.lang.Thread
        public final int nextInt(int upperBound) {
            int rngState = this.rngState;
            rngState ^= i;
            r ^= i2;
            r2 ^= i3;
            this.rngState = r3;
            int i4 = upperBound + -1;
            if (i4 & upperBound == 0) {
                return r3 & i4;
            }
            return i8 %= upperBound;
        }

        @Override // java.lang.Thread
        public void run() {
            runWorker();
        }

        @Override // java.lang.Thread
        public final long runSingleTask() {
            int i;
            kotlinx.coroutines.scheduling.Task blockingTask;
            int i3;
            kotlinx.coroutines.scheduling.CoroutineScheduler this$0;
            boolean aSSERTIONS_ENABLED;
            int state;
            AtomicLongFieldUpdater num;
            int i2;
            final int i5 = 0;
            i = this.state == CoroutineScheduler.WorkerState.CPU_ACQUIRED ? i3 : i5;
            if (i != 0) {
                blockingTask = findCpuTask();
            } else {
                blockingTask = findBlockingTask();
            }
            final int i6 = 0;
            if (blockingTask == null && Long.compare(minDelayUntilStealableTaskNs, i6) == 0) {
                if (Long.compare(minDelayUntilStealableTaskNs, i6) == 0) {
                    return -1;
                }
                return this.minDelayUntilStealableTaskNs;
            }
            this.this$0.runSafely(blockingTask);
            if (i == 0) {
                state = 0;
                CoroutineScheduler.access$getControlState$FU$p().addAndGet(this.this$0, -2097152);
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
                if (this.state == this.state) {
                } else {
                    i3 = i5;
                }
                if (i3 == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            return i6;
        }

        @Override // java.lang.Thread
        public final void setIndexInArray(int index) {
            String valueOf;
            StringBuilder stringBuilder = new StringBuilder();
            if (index == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(index);
            }
            setName(stringBuilder.append(this$0.schedulerName).append("-worker-").append(valueOf).toString());
            this.indexInArray = index;
        }

        @Override // java.lang.Thread
        public final void setNextParkedWorker(Object <set-?>) {
            this.nextParkedWorker = <set-?>;
        }

        @Override // java.lang.Thread
        public final boolean tryReleaseCpu(kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState newState) {
            int i;
            kotlinx.coroutines.scheduling.CoroutineScheduler this$0;
            int i2;
            AtomicLongFieldUpdater num;
            long l;
            final kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState state = this.state;
            i = state == CoroutineScheduler.WorkerState.CPU_ACQUIRED ? 1 : 0;
            if (i != 0) {
                i2 = 0;
                CoroutineScheduler.access$getControlState$FU$p().addAndGet(this.this$0, 4398046511104L);
            }
            if (state != newState) {
                this.state = newState;
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0007\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007¨\u0006\u0008", d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum WorkerState {

        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;
        private static final kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState[] $values() {
            return /* result */;
        }
    }
    static {
        CoroutineScheduler.Companion companion = new CoroutineScheduler.Companion(0);
        CoroutineScheduler.Companion = companion;
        Class<kotlinx.coroutines.scheduling.CoroutineScheduler> obj = CoroutineScheduler.class;
        CoroutineScheduler.parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(obj, "parkedWorkersStack");
        CoroutineScheduler.controlState$FU = AtomicLongFieldUpdater.newUpdater(obj, "controlState");
        CoroutineScheduler._isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(obj, "_isTerminated");
        Symbol symbol = new Symbol("NOT_IN_STACK");
        CoroutineScheduler.NOT_IN_STACK = symbol;
    }

    public CoroutineScheduler(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, String schedulerName) {
        int i;
        int i2;
        int i3;
        int i4;
        super();
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.idleWorkerKeepAliveNs = idleWorkerKeepAliveNs;
        this.schedulerName = obj12;
        int i10 = 0;
        int i11 = 1;
        i = this.corePoolSize >= i11 ? i11 : i10;
        if (i == 0) {
        } else {
            i2 = this.maxPoolSize >= this.corePoolSize ? i11 : i10;
            String str7 = "Max pool size ";
            if (i2 == 0) {
            } else {
                i3 = this.maxPoolSize <= 2097150 ? i11 : i10;
                if (i3 == 0) {
                } else {
                    long idleWorkerKeepAliveNs3 = this.idleWorkerKeepAliveNs;
                    i4 = Long.compare(idleWorkerKeepAliveNs3, i16) > 0 ? i11 : i10;
                    if (i4 == 0) {
                    } else {
                        GlobalQueue globalQueue = new GlobalQueue();
                        this.globalCpuQueue = globalQueue;
                        GlobalQueue globalQueue2 = new GlobalQueue();
                        this.globalBlockingQueue = globalQueue2;
                        ResizableAtomicArray resizableAtomicArray = new ResizableAtomicArray(i13 *= 2);
                        this.workers = resizableAtomicArray;
                        this.controlState = l <<= i8;
                        this._isTerminated = i10;
                    }
                    int i7 = 0;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.append("Idle worker keep alive time ").append(this.idleWorkerKeepAliveNs).append(" must be positive").toString().toString());
                    throw illegalArgumentException3;
                }
                int i9 = 0;
                StringBuilder stringBuilder4 = new StringBuilder();
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(stringBuilder4.append(str7).append(this.maxPoolSize).append(" should not exceed maximal supported number of threads 2097150").toString().toString());
                throw illegalArgumentException4;
            }
            int i6 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append(str7).append(this.maxPoolSize).append(" should be greater than or equals to core pool size ").append(this.corePoolSize).toString().toString());
            throw illegalArgumentException2;
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Core pool size ").append(this.corePoolSize).append(" should be at least 1").toString().toString());
        throw illegalArgumentException;
    }

    public CoroutineScheduler(int i, int i2, long l3, String string4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        long l;
        String str;
        long obj9;
        String obj11;
        l = defaultConstructorMarker6 & 4 != 0 ? obj9 : l3;
        str = defaultConstructorMarker6 & 8 != 0 ? obj11 : i5;
        super(i, i2, l, obj4, str);
    }

    public static final AtomicLongFieldUpdater access$getControlState$FU$p() {
        return CoroutineScheduler.controlState$FU;
    }

    private final boolean addToGlobalQueue(kotlinx.coroutines.scheduling.Task task) {
        boolean last;
        int i;
        final int i2 = 0;
        if (obj.taskContext.getTaskMode() == 1) {
        } else {
            i = 0;
        }
        if (i != 0) {
            last = this.globalBlockingQueue.addLast(task);
        } else {
            last = this.globalCpuQueue.addLast(task);
        }
        return last;
    }

    private final int blockingTasks(long state) {
        final int i = 0;
        return (int)i3;
    }

    private final int createNewWorker() {
        int i2;
        Object obj;
        int i;
        final Object obj2 = this;
        int i6 = 0;
        ResizableAtomicArray workers = obj2.workers;
        final int i8 = 0;
        final int i9 = 0;
        int i3 = 0;
        synchronized (workers) {
            return -1;
        }
    }

    private final int createdWorkers(long state) {
        final int i = 0;
        return (int)i3;
    }

    private final kotlinx.coroutines.scheduling.CoroutineScheduler.Worker currentWorker() {
        Thread currentThread;
        boolean it;
        int i3;
        int i2;
        kotlinx.coroutines.scheduling.CoroutineScheduler this_$iv;
        int i;
        if (currentThread instanceof CoroutineScheduler.Worker) {
        } else {
            currentThread = i3;
        }
        i2 = 0;
        i = 0;
        if (currentThread != null && Intrinsics.areEqual(CoroutineScheduler.Worker.access$getThis$0$p(currentThread), this)) {
            i2 = 0;
            i = 0;
            if (Intrinsics.areEqual(CoroutineScheduler.Worker.access$getThis$0$p(currentThread), this)) {
                i3 = currentThread;
            }
        }
        return i3;
    }

    private final void decrementBlockingTasks() {
        final int i = 0;
        CoroutineScheduler.access$getControlState$FU$p().addAndGet(this, -2097152);
    }

    private final int decrementCreatedWorkers() {
        final int i = 0;
        final Object obj = this;
        final int i2 = 0;
        return (int)i4;
    }

    public static void dispatch$default(kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler, Runnable runnable2, kotlinx.coroutines.scheduling.TaskContext taskContext3, boolean z4, int i5, Object object6) {
        kotlinx.coroutines.scheduling.TaskContext obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = TasksKt.NonBlockingContext;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        coroutineScheduler.dispatch(runnable2, obj2, obj3);
    }

    private final int getAvailableCpuPermits() {
        final int i = 0;
        final Object obj = this;
        final int i2 = 0;
        return (int)i4;
    }

    private final int getCreatedWorkers() {
        final int i = 0;
        return (int)i2;
    }

    private final long incrementBlockingTasks() {
        final int i = 0;
        return CoroutineScheduler.controlState$FU.addAndGet(this, 2097152);
    }

    private final int incrementCreatedWorkers() {
        final int i = 0;
        final Object obj = this;
        final int i2 = 0;
        return (int)i4;
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function12, Object object3) {
        Long valueOf;
        final int i = 0;
        while (true) {
            function12.invoke(Long.valueOf(atomicLongFieldUpdater.get(object3)));
        }
    }

    private final int parkedWorkersStackNextIndex(kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker) {
        Object next;
        Object obj;
        int indexInArray;
        next = worker.getNextParkedWorker();
        while (next == CoroutineScheduler.NOT_IN_STACK) {
            obj = next;
            indexInArray = (CoroutineScheduler.Worker)obj.getIndexInArray();
            next = obj.getNextParkedWorker();
        }
        return -1;
    }

    private final kotlinx.coroutines.scheduling.CoroutineScheduler.Worker parkedWorkersStackPop() {
        int compareAndSet;
        Object obj;
        long l;
        int i;
        int i2;
        int i3;
        Object obj2;
        int i4;
        int parkedWorkersStackNextIndex;
        final Object obj3 = this;
        final int i5 = 0;
        l = CoroutineScheduler.parkedWorkersStack$FU.get(this);
        i2 = 0;
        Object obj4 = this.workers.get((int)i7);
        while ((CoroutineScheduler.Worker)obj4 == null) {
            obj2 = obj4;
            parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(obj2);
            l = parkedWorkersStack$FU.get(this);
            i2 = 0;
            obj4 = this.workers.get((int)i7);
        }
        return null;
    }

    private final long releaseCpuPermit() {
        final int i = 0;
        return CoroutineScheduler.access$getControlState$FU$p().addAndGet(this, 4398046511104L);
    }

    private final void signalBlockingWork(long stateSnapshot, boolean skipUnpark) {
        if (obj4 != null) {
        }
        if (tryUnpark()) {
        }
        if (tryCreateWorker(stateSnapshot)) {
        }
        tryUnpark();
    }

    private final kotlinx.coroutines.scheduling.Task submitToLocalQueue(kotlinx.coroutines.scheduling.CoroutineScheduler.Worker $this$submitToLocalQueue, kotlinx.coroutines.scheduling.Task task, boolean tailDispatch) {
        int this_$iv;
        int bLOCKING;
        if ($this$submitToLocalQueue == null) {
            return task;
        }
        if ($this$submitToLocalQueue.state == CoroutineScheduler.WorkerState.TERMINATED) {
            return task;
        }
        bLOCKING = 0;
        if (obj.taskContext.getTaskMode() == 0 && $this$submitToLocalQueue.state == CoroutineScheduler.WorkerState.BLOCKING) {
            if ($this$submitToLocalQueue.state == CoroutineScheduler.WorkerState.BLOCKING) {
                return task;
            }
        }
        $this$submitToLocalQueue.mayHaveLocalTasks = true;
        return $this$submitToLocalQueue.localQueue.add(task, tailDispatch);
    }

    private final boolean tryAcquireCpuPermit() {
        boolean compareAndSet;
        Object obj;
        long l;
        int i;
        int i3;
        int i2;
        final int i4 = 0;
        final Object obj2 = this;
        final int i5 = 0;
        l = CoroutineScheduler.access$getControlState$FU$p().get(this);
        i3 = 0;
        Object obj3 = this;
        int i8 = 0;
        while ((int)i10 == 0) {
            l = num.get(this);
            i3 = 0;
            obj3 = this;
            i8 = 0;
        }
        return 0;
    }

    private final boolean tryCreateWorker(long state) {
        int corePoolSize2;
        int i;
        int corePoolSize;
        Object obj = this;
        int i2 = 0;
        Object obj2 = this;
        int i5 = 0;
        int i9 = 0;
        corePoolSize2 = createNewWorker();
        i = 1;
        if (RangesKt.coerceAtLeast(this_$iv - this_$iv2, i9) < this.corePoolSize && corePoolSize2 == i && this.corePoolSize > i) {
            corePoolSize2 = createNewWorker();
            i = 1;
            if (corePoolSize2 == i) {
                if (this.corePoolSize > i) {
                    createNewWorker();
                }
            }
            if (corePoolSize2 > 0) {
                return i;
            }
        }
        return i9;
    }

    static boolean tryCreateWorker$default(kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler, long l2, int i3, Object object4) {
        long obj1;
        if (object4 &= 1 != 0) {
            obj1 = CoroutineScheduler.controlState$FU.get(coroutineScheduler);
        }
        return coroutineScheduler.tryCreateWorker(obj1);
    }

    private final boolean tryUnpark() {
        kotlinx.coroutines.scheduling.CoroutineScheduler.Worker parkedWorkersStackPop;
        boolean compareAndSet;
        AtomicIntegerFieldUpdater workerCtl$FU;
        int i;
        parkedWorkersStackPop = parkedWorkersStackPop();
        int i2 = 0;
        while (parkedWorkersStackPop == null) {
            parkedWorkersStackPop = parkedWorkersStackPop();
            i2 = 0;
        }
        return i2;
    }

    @Override // java.util.concurrent.Executor
    public final int availableCpuPermits(long state) {
        final int i = 0;
        return (int)i3;
    }

    @Override // java.util.concurrent.Executor
    public void close() {
        shutdown(10000);
    }

    @Override // java.util.concurrent.Executor
    public final kotlinx.coroutines.scheduling.Task createTask(Runnable block, kotlinx.coroutines.scheduling.TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (block instanceof Task) {
            obj.submissionTime = nanoTime;
            obj2.taskContext = taskContext;
            return (Task)block;
        }
        TaskImpl taskImpl = new TaskImpl(block, nanoTime, obj1, taskContext);
        return (Task)taskImpl;
    }

    @Override // java.util.concurrent.Executor
    public final void dispatch(Runnable block, kotlinx.coroutines.scheduling.TaskContext taskContext, boolean tailDispatch) {
        int $this$isBlocking$iv;
        long this_$iv;
        int taskMode;
        int i;
        AtomicLongFieldUpdater controlState$FU;
        int i2;
        boolean toGlobalQueue;
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
        kotlinx.coroutines.scheduling.Task task = createTask(block, taskContext);
        int i3 = 0;
        int i4 = 1;
        $this$isBlocking$iv = task2.taskContext.getTaskMode() == i4 ? i4 : i;
        if ($this$isBlocking$iv != 0) {
            taskMode = 0;
            this_$iv = CoroutineScheduler.controlState$FU.addAndGet(this, 2097152);
        } else {
            this_$iv = 0;
        }
        kotlinx.coroutines.scheduling.CoroutineScheduler.Worker currentWorker = currentWorker();
        kotlinx.coroutines.scheduling.Task submitToLocalQueue = submitToLocalQueue(currentWorker, task, tailDispatch);
        if (submitToLocalQueue != null) {
            if (!addToGlobalQueue(submitToLocalQueue)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(stringBuilder.append(this.schedulerName).append(" was terminated").toString());
            throw rejectedExecutionException;
        }
        if (tailDispatch && currentWorker != null) {
            if (currentWorker != null) {
                i = i4;
            }
        }
        if ($this$isBlocking$iv != 0) {
            signalBlockingWork(this_$iv, taskMode);
        } else {
            if (i != 0) {
            }
            signalCpuWork();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        CoroutineScheduler.dispatch$default(this, command, 0, false, 6, 0);
    }

    @Override // java.util.concurrent.Executor
    public final boolean isTerminated() {
        int i;
        i = CoroutineScheduler._isTerminated$FU.get(this) != 0 ? 1 : 0;
        return i;
    }

    @Override // java.util.concurrent.Executor
    public final boolean parkedWorkersStackPush(kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker) {
        AtomicLongFieldUpdater parkedWorkersStack$FU;
        boolean $i$a$AssertCoroutineScheduler$parkedWorkersStackPush$1$1;
        Object obj3;
        Symbol nOT_IN_STACK;
        int i;
        int i2;
        int i5;
        Object obj;
        int i6;
        int i7;
        int i3;
        int indexInArray;
        int i4;
        Object obj2;
        obj3 = this;
        if (worker.getNextParkedWorker() != CoroutineScheduler.NOT_IN_STACK) {
            return 0;
        }
        obj = this;
        final int i13 = 0;
        nOT_IN_STACK = CoroutineScheduler.parkedWorkersStack$FU.get(obj3);
        i6 = 0;
        indexInArray = worker.getIndexInArray();
        i4 = 1;
        while (DebugKt.getASSERTIONS_ENABLED()) {
            int i8 = 0;
            if (indexInArray != null) {
            } else {
            }
            $i$a$AssertCoroutineScheduler$parkedWorkersStackPush$1$1 = i5;
            worker.setNextParkedWorker(obj3.workers.get((int)i10));
            i2 = i3 | l;
            i5 = 0;
            obj3 = this;
            obj = obj2;
            nOT_IN_STACK = num.get(obj3);
            i6 = 0;
            indexInArray = worker.getIndexInArray();
            i4 = 1;
            $i$a$AssertCoroutineScheduler$parkedWorkersStackPush$1$1 = i4;
        }
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    @Override // java.util.concurrent.Executor
    public final void parkedWorkersStackTopUpdate(kotlinx.coroutines.scheduling.CoroutineScheduler.Worker worker, int oldIndex, int newIndex) {
        int parkedWorkersStackNextIndex;
        Object obj;
        long l;
        int i;
        int i6;
        int i2;
        int i3;
        int i5;
        int i4;
        final Object obj2 = this;
        final int i7 = 0;
        l = CoroutineScheduler.parkedWorkersStack$FU.get(this);
        i6 = 0;
        i2 = (int)i9;
        while (i2 == oldIndex) {
            if (newIndex == 0) {
            } else {
            }
            parkedWorkersStackNextIndex = newIndex;
            i4 = parkedWorkersStackNextIndex;
            if (i4 < 0) {
            }
            l = parkedWorkersStack$FU.get(this);
            i6 = 0;
            i2 = (int)i9;
            parkedWorkersStackNextIndex = i2;
            if (!CoroutineScheduler.parkedWorkersStack$FU.compareAndSet(this, l, obj6)) {
            }
            parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void runSafely(kotlinx.coroutines.scheduling.Task task) {
        AbstractTimeSource timeSource2;
        Thread timeSource;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        task.run();
        timeSource2 = AbstractTimeSourceKt.getTimeSource();
        if (timeSource2 != null) {
            try {
                timeSource2.unTrackTask();
                timeSource = Thread.currentThread();
                timeSource.getUncaughtExceptionHandler().uncaughtException(timeSource, th);
                Throwable th = AbstractTimeSourceKt.getTimeSource();
            } catch (Throwable th) {
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void shutdown(long timeout) {
        int i4;
        kotlinx.coroutines.scheduling.GlobalQueue globalCpuQueue;
        boolean aSSERTIONS_ENABLED;
        int i5;
        ResizableAtomicArray this_$iv;
        int state;
        int this_$iv$iv;
        int $i$a$AssertCoroutineScheduler$shutdown$1;
        int i;
        kotlinx.coroutines.scheduling.GlobalQueue globalBlockingQueue;
        int i2;
        int i3;
        int i6;
        final Object obj = this;
        i5 = 0;
        final int i10 = 1;
        if (!CoroutineScheduler._isTerminated$FU.compareAndSet(obj, i5, i10)) {
        }
        final kotlinx.coroutines.scheduling.CoroutineScheduler.Worker currentWorker = obj.currentWorker();
        this_$iv = obj.workers;
        state = 0;
        this_$iv$iv = 0;
        int i7 = 0;
        i = 0;
        l &= i14;
        int this_$iv2 = (int)i13;
        synchronized (this_$iv) {
            currentWorker = obj.currentWorker();
            this_$iv = obj.workers;
            state = 0;
            this_$iv$iv = 0;
            i7 = 0;
            i = 0;
            l &= i14;
            this_$iv2 = (int)i13;
        }
        this_$iv = obj.workers.get(i4);
        Intrinsics.checkNotNull(this_$iv);
        while ((CoroutineScheduler.Worker)this_$iv != currentWorker) {
            while ((CoroutineScheduler.Worker)this_$iv.isAlive()) {
                LockSupport.unpark((Thread)this_$iv);
                this_$iv.join(timeout);
            }
            i = timeout;
            this_$iv.localQueue.offloadAllWorkTo(obj.globalBlockingQueue);
            if (i4 != this_$iv2) {
            }
            i4++;
            this_$iv = obj.workers.get(i4);
            Intrinsics.checkNotNull(this_$iv);
            i = timeout;
            int i11 = 0;
            if (this_$iv.state == CoroutineScheduler.WorkerState.TERMINATED) {
            } else {
            }
            $i$a$AssertCoroutineScheduler$shutdown$1 = i5;
            $i$a$AssertCoroutineScheduler$shutdown$1 = i10;
            LockSupport.unpark((Thread)(CoroutineScheduler.Worker)this_$iv);
            this_$iv.join(timeout);
        }
        AssertionError assertionError2 = new AssertionError();
        throw assertionError2;
    }

    @Override // java.util.concurrent.Executor
    public final void signalCpuWork() {
        if (tryUnpark()) {
        }
        if (CoroutineScheduler.tryCreateWorker$default(this, 0, obj3, 1)) {
        }
        tryUnpark();
    }

    @Override // java.util.concurrent.Executor
    public String toString() {
        int parkedWorkers;
        int blockingWorkers;
        int cpuWorkers;
        int dormant;
        int terminated;
        int index;
        Object obj;
        int size$kotlinx_coroutines_core;
        int i2;
        int[] string;
        int i;
        final Object obj2 = this;
        parkedWorkers = 0;
        blockingWorkers = 0;
        cpuWorkers = 0;
        dormant = 0;
        terminated = 0;
        ArrayList arrayList = new ArrayList();
        index = 1;
        while (index < obj2.workers.currentLength()) {
            obj = obj2.workers.get(index);
            if ((CoroutineScheduler.Worker)obj == null) {
            } else {
            }
            size$kotlinx_coroutines_core = obj.localQueue.getSize$kotlinx_coroutines_core();
            index++;
            terminated++;
            dormant++;
            if (size$kotlinx_coroutines_core > 0) {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            (Collection)arrayList.add(stringBuilder2.append(size$kotlinx_coroutines_core).append('d').toString());
            cpuWorkers++;
            StringBuilder stringBuilder4 = new StringBuilder();
            (Collection)arrayList.add(stringBuilder4.append(size$kotlinx_coroutines_core).append('c').toString());
            blockingWorkers++;
            StringBuilder stringBuilder3 = new StringBuilder();
            (Collection)arrayList.add(stringBuilder3.append(size$kotlinx_coroutines_core).append('b').toString());
            parkedWorkers++;
        }
        long l = CoroutineScheduler.controlState$FU.get(obj2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj2.schedulerName).append('@').append(DebugStringsKt.getHexAddress(obj2)).append("[Pool Size {core = ").append(obj2.corePoolSize).append(", max = ").append(obj2.maxPoolSize).append("}, Worker States {CPU = ").append(cpuWorkers).append(", blocking = ").append(blockingWorkers).append(", parked = ").append(parkedWorkers).append(", dormant = ").append(dormant).append(", terminated = ").append(terminated).append("}, running workers queues = ").append(arrayList).append(", global CPU queue size = ").append(obj2.globalCpuQueue.getSize()).append(", global blocking queue size = ").append(obj2.globalBlockingQueue.getSize());
        Object obj3 = this;
        int i5 = 0;
        Object obj4 = this;
        int i6 = 0;
        Object obj5 = this;
        int i11 = 0;
        stringBuilder.append(", Control State {created workers= ").append((int)i8).append(", blocking tasks = ").append((int)i10).append(", CPUs acquired = ").append(corePoolSize2 -= this_$iv3).append("}]");
        return stringBuilder.toString();
    }
}
