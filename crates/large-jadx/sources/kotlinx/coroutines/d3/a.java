package kotlinx.coroutines.d3;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.g0.c;
import kotlin.g0.c.a;
import kotlin.h0.g;
import kotlin.w;
import kotlinx.coroutines.d;
import kotlinx.coroutines.e;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008-\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0008\u0000\u0018\u0000 X2\u00020\\2\u00020]:\u0003XYZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0086\u0008¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\u0008¢\u0006\u0004\u0008\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017J!\u0010\u001d\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\u0008¢\u0006\u0004\u0008\u001f\u0010\u0011J\u0015\u0010!\u001a\u0008\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\u0008!\u0010\"J\u0010\u0010#\u001a\u00020\u0013H\u0082\u0008¢\u0006\u0004\u0008#\u0010\u0015J\u0010\u0010$\u001a\u00020\u0001H\u0082\u0008¢\u0006\u0004\u0008$\u0010\u0017J-\u0010&\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001b2\u0008\u0008\u0002\u0010%\u001a\u00020\u000c¢\u0006\u0004\u0008&\u0010'J\u001b\u0010)\u001a\u00020\u00132\n\u0010(\u001a\u00060\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\u0008)\u0010*J\u0010\u0010+\u001a\u00020\u0004H\u0082\u0008¢\u0006\u0004\u0008+\u0010,J\u0010\u0010-\u001a\u00020\u0001H\u0082\u0008¢\u0006\u0004\u0008-\u0010\u0017J\u001b\u0010/\u001a\u00020\u00012\n\u0010.\u001a\u00060 R\u00020\u0000H\u0002¢\u0006\u0004\u0008/\u00100J\u0015\u00101\u001a\u0008\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\u00081\u0010\"J\u0019\u00102\u001a\u00020\u000c2\n\u0010.\u001a\u00060 R\u00020\u0000¢\u0006\u0004\u00082\u00103J)\u00106\u001a\u00020\u00132\n\u0010.\u001a\u00060 R\u00020\u00002\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001¢\u0006\u0004\u00086\u00107J\u0010\u00108\u001a\u00020\u0004H\u0082\u0008¢\u0006\u0004\u00088\u0010,J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u00089\u0010:J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0004¢\u0006\u0004\u0008<\u0010=J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008?\u0010@J\r\u0010A\u001a\u00020\u0013¢\u0006\u0004\u0008A\u0010\u0015J\u000f\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008B\u0010CJ\u0010\u0010D\u001a\u00020\u000cH\u0082\u0008¢\u0006\u0004\u0008D\u0010EJ\u0019\u0010F\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008F\u0010GJ\u000f\u0010H\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008H\u0010EJ+\u0010I\u001a\u0004\u0018\u00010\n*\u0008\u0018\u00010 R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008I\u0010JR\u0015\u0010\u0010\u001a\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008K\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0002\u0010LR\u0015\u0010\u001f\u001a\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008M\u0010\u0017R\u0014\u0010O\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008O\u0010PR\u0014\u0010Q\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008Q\u0010PR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0005\u0010RR\u0011\u0010S\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008S\u0010ER\u0014\u0010\u0003\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010LR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0007\u0010TR \u0010V\u001a\u000e\u0012\n\u0012\u0008\u0018\u00010 R\u00020\u00000U8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008V\u0010W¨\u0006[", d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a implements Executor, Closeable {

    static final AtomicLongFieldUpdater A;
    private static final AtomicIntegerFieldUpdater B;
    public static final z C;
    private static final AtomicLongFieldUpdater z;
    private volatile int _isTerminated = 0;
    public final int a;
    public final int b;
    public final long c;
    volatile long controlState;
    private volatile long parkedWorkersStack = 0;
    public final String v;
    public final kotlinx.coroutines.d3.d w;
    public final kotlinx.coroutines.d3.d x;
    public final AtomicReferenceArray<kotlinx.coroutines.d3.a.b> y;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[a.c.PARKING.ordinal()] = 1;
            iArr[a.c.BLOCKING.ordinal()] = 2;
            iArr[a.c.CPU_ACQUIRED.ordinal()] = 3;
            iArr[a.c.DORMANT.ordinal()] = 4;
            iArr[a.c.TERMINATED.ordinal()] = 5;
            a.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\u0008\u0080\u0004\u0018\u00002\u00020GB\u0011\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0003\u0010\u0004B\t\u0008\u0002¢\u0006\u0004\u0008\u0003\u0010\u0005J\u0017\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\u0008\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008 \u0010\u001cJ\u000f\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008!\u0010\u0017J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\"\u0010\u001cJ\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\u0008%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\u0008(\u0010\u0012J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008)\u0010\u001cR*\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00018\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008*\u0010+\u001a\u0004\u0008,\u0010-\"\u0004\u0008.\u0010\tR\u0014\u00100\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u00080\u00101R\u0016\u00102\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u00082\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00085\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u00088\u00109\u001a\u0004\u0008:\u0010;\"\u0004\u0008<\u0010=R\u0016\u0010>\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008>\u0010+R\u0012\u0010B\u001a\u00020?8Æ\u0002¢\u0006\u0006\u001a\u0004\u0008@\u0010AR\u0016\u0010C\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\u0008C\u0010DR\u0016\u0010E\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008E\u00106¨\u0006F", d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt", "(I)I", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends Thread {

        static final AtomicIntegerFieldUpdater z;
        public final kotlinx.coroutines.d3.m a;
        public kotlinx.coroutines.d3.a.c b;
        private long c;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private long v;
        private int w;
        volatile int workerCtl;
        public boolean x;
        final kotlinx.coroutines.d3.a y;
        static {
            a.b.z = AtomicIntegerFieldUpdater.newUpdater(a.b.class, "workerCtl");
        }

        private b(kotlinx.coroutines.d3.a a) {
            this.y = a;
            super();
            setDaemon(true);
            m obj1 = new m();
            this.a = obj1;
            this.b = a.c.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.C;
            this.w = c.b.d();
        }

        public b(kotlinx.coroutines.d3.a a, int i2) {
            this.y = a;
            super(a);
            n(i2);
        }

        private final void a(int i) {
            boolean tERMINATED;
            kotlinx.coroutines.d3.a.c obj4;
            if (i == 0) {
            }
            a.A.addAndGet(this.y, -2097152);
            obj4 = this.b;
            if (obj4 != a.c.TERMINATED && q0.a()) {
                if (q0.a()) {
                    obj4 = obj4 == a.c.BLOCKING ? 1 : 0;
                    if (obj4 == null) {
                    } else {
                    }
                    obj4 = new AssertionError();
                    throw obj4;
                }
                this.b = a.c.DORMANT;
            }
        }

        private final void b(int i) {
            boolean obj1;
            if (i == 0) {
            }
            if (r(a.c.BLOCKING)) {
                this.y.x();
            }
        }

        private final void c(kotlinx.coroutines.d3.i i) {
            int i2 = i.b.r();
            h(i2);
            b(i2);
            this.y.q(i);
            a(i2);
        }

        private final kotlinx.coroutines.d3.i d(boolean z) {
            kotlinx.coroutines.d3.i iVar;
            int obj3;
            final int i = 0;
            if (z) {
                obj3 = j(obj3 *= 2) == 0 ? 1 : i;
                iVar = l();
                if (obj3 != null && iVar == null) {
                    iVar = l();
                    if (iVar == null) {
                    }
                    return iVar;
                }
                iVar = this.a.h();
                obj3 = l();
                if (iVar == null && obj3 == null && obj3 == null) {
                    if (obj3 == null) {
                        obj3 = l();
                        if (obj3 == null) {
                        }
                        return obj3;
                    }
                    obj3 = s(i);
                    return obj3;
                }
                return iVar;
            }
            if (l() == null) {
            }
        }

        private final void h(int i) {
            kotlinx.coroutines.d3.a.c cVar;
            int obj3;
            this.c = 0;
            if (this.b == a.c.PARKING && q0.a()) {
                if (q0.a()) {
                    if (i == 1) {
                    } else {
                        cVar = 0;
                    }
                    if (cVar == 0) {
                    } else {
                    }
                    obj3 = new AssertionError();
                    throw obj3;
                }
                this.b = a.c.BLOCKING;
            }
        }

        private final boolean i() {
            int i;
            i = this.nextParkedWorker != a.C ? 1 : 0;
            return i;
        }

        private final void k() {
            int cmp;
            long l;
            final int i2 = 0;
            if (Long.compare(l2, i2) == 0) {
                this.c = nanoTime += l;
            }
            LockSupport.parkNanos(aVar.c);
            if (Long.compare(i, i2) >= 0) {
                this.c = i2;
                t();
            }
        }

        private final kotlinx.coroutines.d3.i l() {
            Object obj;
            Object obj2;
            if (j(2) == 0 && (i)aVar.w.d() == null) {
                if ((i)aVar.w.d() == null) {
                    obj = aVar2.x.d();
                }
                return obj;
            }
            if ((i)aVar3.x.d() == null) {
                obj2 = aVar4.w.d();
            }
            return obj2;
        }

        private final void m() {
            long l;
            int cmp;
            boolean terminated;
            int tERMINATED;
            long l2;
            int i = 0;
            while (/* condition */) {
                while (!this.y.isTerminated()) {
                    if (this.b != a.c.TERMINATED) {
                        break loop_2;
                    }
                    cmp = e(this.x);
                    tERMINATED = 0;
                    this.x = i;
                    cmp = Long.compare(l2, tERMINATED);
                    if (cmp != 0) {
                        break loop_2;
                    } else {
                    }
                    q();
                    if (l != 0) {
                        break loop_2;
                    } else {
                    }
                    l = 1;
                }
                if (this.b != a.c.TERMINATED) {
                }
                cmp = e(this.x);
                tERMINATED = 0;
                if (cmp != null) {
                } else {
                }
                this.x = i;
                cmp = Long.compare(l2, tERMINATED);
                if (cmp != 0) {
                } else {
                }
                q();
                if (l == 0) {
                } else {
                }
                r(a.c.PARKING);
                Thread.interrupted();
                LockSupport.parkNanos(this.v);
                this.v = tERMINATED;
                l = i;
                l = 1;
                this.v = tERMINATED;
                c(cmp);
            }
            r(a.c.TERMINATED);
        }

        private final boolean p() {
            int cPU_ACQUIRED;
            kotlinx.coroutines.d3.a.c compareAndSet;
            int i;
            AtomicLongFieldUpdater num;
            kotlinx.coroutines.d3.a aVar;
            long controlState;
            int i2;
            final int i4 = 1;
            if (this.b == a.c.CPU_ACQUIRED) {
                i = i4;
            } else {
                kotlinx.coroutines.d3.a aVar2 = this.y;
                controlState = aVar2.controlState;
                while ((int)num == 0) {
                    controlState = aVar2.controlState;
                }
                cPU_ACQUIRED = i;
                if (cPU_ACQUIRED != 0) {
                }
            }
            return i;
        }

        private final void q() {
            int z;
            kotlinx.coroutines.d3.a.c pARKING;
            boolean workerCtl;
            kotlinx.coroutines.d3.a.c tERMINATED;
            if (!i()) {
                this.y.n(this);
            }
            if (q0.a()) {
                z = this.a.f() == 0 ? 1 : 0;
                if (z == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            int i2 = -1;
            this.workerCtl = i2;
            while (i()) {
                if (this.workerCtl == i2) {
                    break;
                }
                if (!this.y.isTerminated()) {
                    break;
                }
                if (this.b == a.c.TERMINATED) {
                    break;
                } else {
                }
                r(a.c.PARKING);
                Thread.interrupted();
                k();
            }
        }

        private final kotlinx.coroutines.d3.i s(boolean z) {
            int z2;
            int i;
            int i2;
            long l;
            int cmp;
            Object obj;
            kotlinx.coroutines.d3.m mVar;
            boolean z3;
            int cmp2;
            final Object obj2 = this;
            final int i5 = 0;
            final int i6 = 1;
            if (q0.a()) {
                z2 = obj2.a.f() == 0 ? i6 : i5;
                if (z2 == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            int i4 = (int)i7;
            final int i9 = 0;
            if (i4 < 2) {
                return i9;
            }
            i = obj2.j(i4);
            final long l2 = Long.MAX_VALUE;
            i2 = i5;
            l = l2;
            cmp = 0;
            while (i2 < i4) {
                if (i += i6 > i4) {
                }
                obj = aVar2.y.get(i);
                i2++;
                cmp = 0;
                if (z) {
                } else {
                }
                obj = obj2.a.l(obj.a);
                if (Long.compare(obj, cmp) > 0) {
                }
                l = Math.min(l, obj11);
                obj = obj2.a.k(obj.a);
                if (obj2.a.f() == 0) {
                } else {
                }
                z3 = i5;
                z3 = i6;
                i = i6;
            }
            if (Long.compare(l, l2) != 0) {
            } else {
                l = cmp;
            }
            obj2.v = l;
            return i9;
        }

        private final void t() {
            int i;
            AtomicReferenceArray atomicReferenceArray;
            kotlinx.coroutines.d3.a aVar = this.y;
            final AtomicReferenceArray atomicReferenceArray3 = aVar.y;
            synchronized (atomicReferenceArray3) {
            }
        }

        @Override // java.lang.Thread
        public final kotlinx.coroutines.d3.i e(boolean z) {
            Object obj2;
            if (p()) {
                return d(z);
            }
            if (z) {
                if (this.a.h() == null) {
                    obj2 = obj2.x.d();
                }
            } else {
                obj2 = obj2.x.d();
            }
            if (obj2 == null) {
                obj2 = s(true);
            }
            return obj2;
        }

        @Override // java.lang.Thread
        public final int f() {
            return this.indexInArray;
        }

        @Override // java.lang.Thread
        public final Object g() {
            return this.nextParkedWorker;
        }

        @Override // java.lang.Thread
        public final int j(int i) {
            int i2 = this.w;
            i2 ^= i8;
            i3 ^= i9;
            i4 ^= i10;
            this.w = i5;
            int i11 = i + -1;
            if (i11 & i == 0) {
                return i5 & i11;
            }
            return i6 %= i;
        }

        @Override // java.lang.Thread
        public final void n(int i) {
            String valueOf;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(aVar.v);
            stringBuilder.append("-worker-");
            if (i == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(i);
            }
            stringBuilder.append(valueOf);
            setName(stringBuilder.toString());
            this.indexInArray = i;
        }

        @Override // java.lang.Thread
        public final void o(Object object) {
            this.nextParkedWorker = object;
        }

        @Override // java.lang.Thread
        public final boolean r(kotlinx.coroutines.d3.a.c a$c) {
            int i;
            kotlinx.coroutines.d3.a aVar;
            AtomicLongFieldUpdater num;
            long l;
            final kotlinx.coroutines.d3.a.c cVar = this.b;
            i = cVar == a.c.CPU_ACQUIRED ? 1 : 0;
            if (i != 0) {
                a.A.addAndGet(this.y, 4398046511104L);
            }
            if (cVar != c) {
                this.b = c;
            }
            return i;
        }

        @Override // java.lang.Thread
        public void run() {
            m();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0007\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007¨\u0006\u0008", d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum c {

        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;
        private static final kotlinx.coroutines.d3.a.c[] $values() {
            kotlinx.coroutines.d3.a.c[] arr = new a.c[5];
            return arr;
        }
    }
    static {
        z zVar = new z("NOT_IN_STACK");
        a.C = zVar;
        a.z = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
        a.A = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
        a.B = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");
    }

    public a(int i, int i2, long l3, String string4) {
        int i6;
        int i3;
        int i5;
        int i4;
        super();
        this.a = i;
        this.b = i2;
        this.c = l3;
        this.v = obj9;
        final int obj9 = 0;
        final int i7 = 1;
        i6 = i >= i7 ? i7 : obj9;
        if (i6 == 0) {
        } else {
            i3 = i2 >= i ? i7 : obj9;
            final String str = "Max pool size ";
            if (i3 == 0) {
            } else {
                i5 = i2 <= 2097150 ? i7 : obj9;
                if (i5 == 0) {
                } else {
                    i4 = Long.compare(l3, i9) > 0 ? i7 : obj9;
                    if (i4 == 0) {
                    } else {
                        d obj7 = new d();
                        this.w = obj7;
                        obj7 = new d();
                        this.x = obj7;
                        obj7 = new AtomicReferenceArray(i2 += i7);
                        this.y = obj7;
                        this.controlState = obj5 <<= obj7;
                    }
                    StringBuilder obj5 = new StringBuilder();
                    obj5.append("Idle worker keep alive time ");
                    obj5.append(l3);
                    obj5.append(" must be positive");
                    IllegalArgumentException obj6 = new IllegalArgumentException(obj5.toString().toString());
                    throw obj6;
                }
                obj5 = new StringBuilder();
                obj5.append(str);
                obj5.append(i2);
                obj5.append(" should not exceed maximal supported number of threads 2097150");
                obj6 = new IllegalArgumentException(obj5.toString().toString());
                throw obj6;
            }
            obj7 = new StringBuilder();
            obj7.append(str);
            obj7.append(i2);
            obj7.append(" should be greater than or equals to core pool size ");
            obj7.append(i);
            obj6 = new IllegalArgumentException(obj7.toString().toString());
            throw obj6;
        }
        obj6 = new StringBuilder();
        obj6.append("Core pool size ");
        obj6.append(i);
        obj6.append(" should be at least 1");
        obj6 = new IllegalArgumentException(obj6.toString().toString());
        throw obj6;
    }

    private final kotlinx.coroutines.d3.i E(kotlinx.coroutines.d3.a.b a$b, kotlinx.coroutines.d3.i i2, boolean z3) {
        int i;
        kotlinx.coroutines.d3.a.c tERMINATED;
        if (b == null) {
            return i2;
        }
        if (b.b == a.c.TERMINATED) {
            return i2;
        }
        if (i2.b.r() == 0 && b.b == a.c.BLOCKING) {
            if (b.b == a.c.BLOCKING) {
                return i2;
            }
        }
        b.x = true;
        return b.a.a(i2, z3);
    }

    private final boolean F(long l) {
        int i;
        int i2;
        int obj5;
        int obj4 = 0;
        obj5 = c();
        i = 1;
        if (g.b(i5 -= obj4, obj4) < this.a && obj5 == i && this.a > i) {
            obj5 = c();
            i = 1;
            if (obj5 == i) {
                if (this.a > i) {
                    c();
                }
            }
            if (obj5 > 0) {
                return i;
            }
        }
        return obj4;
    }

    static boolean H(kotlinx.coroutines.d3.a a, long l2, int i3, Object object4) {
        long obj1;
        if (object4 &= 1 != 0) {
            obj1 = a.controlState;
        }
        return a.F(obj1);
    }

    private final boolean J() {
        kotlinx.coroutines.d3.a.b bVar = m();
        int i2 = 0;
        while (bVar == null) {
            bVar = m();
            i2 = 0;
        }
        return i2;
    }

    private final boolean a(kotlinx.coroutines.d3.i i) {
        kotlinx.coroutines.d3.d dVar;
        int i2;
        boolean obj3;
        if (i.b.r() == 1) {
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            obj3 = this.x.a(i);
        } else {
            obj3 = this.w.a(i);
        }
        return obj3;
    }

    private final int c() {
        int i;
        Object obj;
        int i2;
        final AtomicReferenceArray atomicReferenceArray = this.y;
        synchronized (atomicReferenceArray) {
            return -1;
        }
    }

    private final kotlinx.coroutines.d3.a.b f() {
        int currentThread;
        boolean z;
        int i;
        if (currentThread instanceof a.b) {
        } else {
            currentThread = i;
        }
        if (currentThread == 0) {
        } else {
            if (n.b(currentThread.y, this)) {
                i = currentThread;
            }
        }
        return i;
    }

    public static void j(kotlinx.coroutines.d3.a a, Runnable runnable2, kotlinx.coroutines.d3.j j3, boolean z4, int i5, Object object6) {
        kotlinx.coroutines.d3.g obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = g.a;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        a.i(runnable2, obj2, obj3);
    }

    private final int k(kotlinx.coroutines.d3.a.b a$b) {
        int i;
        Object obj2;
        obj2 = b.g();
        while (obj2 == a.C) {
            i = (a.b)obj2.f();
            obj2 = obj2.g();
        }
        return -1;
    }

    private final kotlinx.coroutines.d3.a.b m() {
        int compareAndSet;
        Object obj;
        int i;
        AtomicLongFieldUpdater num;
        int i2;
        final long parkedWorkersStack = this.parkedWorkersStack;
        final Object obj3 = obj2;
        while ((a.b)obj3 == null) {
            i = k((a.b)obj3);
            num = a.z;
            parkedWorkersStack = this.parkedWorkersStack;
            obj3 = obj2;
        }
        return null;
    }

    private final void w(boolean z) {
        final int i = 2097152;
        if (z) {
        }
        if (J()) {
        }
        if (F(a.A.addAndGet(this, i))) {
        }
        J();
    }

    @Override // java.util.concurrent.Executor
    public void close() {
        r(10000);
    }

    @Override // java.util.concurrent.Executor
    public final kotlinx.coroutines.d3.i e(Runnable runnable, kotlinx.coroutines.d3.j j2) {
        long l = l.e.a();
        if (runnable instanceof i) {
            runnable.a = l;
            runnable.b = j2;
            return (i)runnable;
        }
        k kVar = new k(runnable, l, obj1, j2);
        return kVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        a.j(this, runnable, 0, false, 6, 0);
    }

    @Override // java.util.concurrent.Executor
    public final void i(Runnable runnable, kotlinx.coroutines.d3.j j2, boolean z3) {
        kotlinx.coroutines.d3.i iVar;
        int obj3;
        d dVar = e.a();
        if (dVar == null) {
        } else {
            dVar.d();
        }
        kotlinx.coroutines.d3.i obj2 = e(runnable, j2);
        obj3 = f();
        iVar = E(obj3, obj2, z3);
        if (iVar != null) {
            if (!a(iVar)) {
            } else {
            }
            obj2 = new RejectedExecutionException(n.o(this.v, " was terminated"));
            throw obj2;
        }
        if (z3 && obj3 != null) {
            obj3 = obj3 != null ? 1 : 0;
        } else {
        }
        if (obj2.b.r() == 0) {
            if (obj3 != null) {
            }
            x();
        } else {
            w(obj3);
        }
    }

    @Override // java.util.concurrent.Executor
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    @Override // java.util.concurrent.Executor
    public final boolean n(kotlinx.coroutines.d3.a.b a$b) {
        Object compareAndSet;
        z zVar;
        AtomicLongFieldUpdater num;
        Object obj;
        long parkedWorkersStack;
        int i;
        int z;
        int i2;
        final int i6 = 0;
        if (b.g() != a.C) {
            return i6;
        }
        parkedWorkersStack = this.parkedWorkersStack;
        zVar = b.f();
        i2 = 1;
        while (q0.a()) {
            if (zVar != null) {
            } else {
            }
            z = i6;
            b.o(this.y.get((int)i4));
            parkedWorkersStack = this.parkedWorkersStack;
            zVar = b.f();
            i2 = 1;
            z = i2;
        }
        AssertionError obj11 = new AssertionError();
        throw obj11;
    }

    @Override // java.util.concurrent.Executor
    public final void o(kotlinx.coroutines.d3.a.b a$b, int i2, int i3) {
        boolean compareAndSet;
        Object obj;
        int i;
        long l;
        final long parkedWorkersStack = this.parkedWorkersStack;
        do {
            parkedWorkersStack = this.parkedWorkersStack;
            if (compareAndSet < 0) {
            }
            if (!a.z.compareAndSet(this, parkedWorkersStack, obj3)) {
            }
            if (i3 == 0) {
            } else {
            }
            compareAndSet = i3;
            compareAndSet = k(b);
        } while ((int)i5 == i2);
    }

    @Override // java.util.concurrent.Executor
    public final void q(kotlinx.coroutines.d3.i i) {
        Thread thread;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        d obj3;
        try {
            i.run();
            if (e.a() == null) {
            } else {
            }
            obj3.e();
        } catch (Throwable th) {
        }
    }

    @Override // java.util.concurrent.Executor
    public final void r(long l) {
        kotlinx.coroutines.d3.a.b bVar;
        int i2;
        int atomicReferenceArray;
        int i;
        int i3;
        kotlinx.coroutines.d3.d alive;
        int cVar;
        boolean tERMINATED;
        kotlinx.coroutines.d3.d obj10;
        int obj11;
        i2 = 0;
        final int i4 = 1;
        if (!a.B.compareAndSet(this, i2, i4)) {
        }
        bVar = f();
        atomicReferenceArray = this.y;
        int i6 = (int)i5;
        synchronized (atomicReferenceArray) {
            bVar = f();
            atomicReferenceArray = this.y;
            i6 = (int)i5;
        }
        atomicReferenceArray = i4;
        i3 = this.y.get(atomicReferenceArray);
        n.d(i3);
        while ((a.b)i3 != bVar) {
            while ((a.b)i3.isAlive()) {
                LockSupport.unpark(i3);
                i3.join(l);
            }
            i3.a.g(this.x);
            if (atomicReferenceArray == i6) {
                break;
            } else {
            }
            atomicReferenceArray = i;
            i3 = this.y.get(atomicReferenceArray);
            n.d(i3);
            if (i3.b == a.c.TERMINATED) {
            } else {
            }
            cVar = i2;
            cVar = i4;
            LockSupport.unpark((a.b)i3);
            i3.join(l);
        }
        obj10 = new AssertionError();
        throw obj10;
    }

    @Override // java.util.concurrent.Executor
    public String toString() {
        int i4;
        int i2;
        int i8;
        int i6;
        int i5;
        int i3;
        Object string;
        int i;
        int i7;
        AtomicReferenceArray atomicReferenceArray;
        int[] iArr;
        ArrayList arrayList = new ArrayList();
        int length = this.y.length();
        i2 = 0;
        int i23 = 1;
        if (i23 < length) {
            i3 = i5;
            i = i23;
            i7 = i + 1;
            string = this.y.get(i);
            while ((a.b)string == null) {
                if (i7 < length) {
                }
                i = i7;
                i7 = i + 1;
                string = this.y.get(i);
                atomicReferenceArray = string.a.f();
                string = a.a.a[string.b.ordinal()];
                if (string != i23) {
                } else {
                }
                i2++;
                if (string != 2) {
                } else {
                }
                i8++;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(atomicReferenceArray);
                stringBuilder2.append('b');
                arrayList.add(stringBuilder2.toString());
                if (string != 3) {
                } else {
                }
                i6++;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(atomicReferenceArray);
                stringBuilder4.append('c');
                arrayList.add(stringBuilder4.toString());
                if (string != 4) {
                } else {
                }
                i5++;
                if (atomicReferenceArray > 0) {
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(atomicReferenceArray);
                stringBuilder3.append('d');
                arrayList.add(stringBuilder3.toString());
                if (string != 5) {
                } else {
                }
                i3++;
            }
            i4 = i2;
            i2 = i6;
        } else {
            i3 = i5;
        }
        long controlState = this.controlState;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.v);
        stringBuilder.append('@');
        stringBuilder.append(r0.b(this));
        stringBuilder.append("[Pool Size {core = ");
        stringBuilder.append(this.a);
        stringBuilder.append(", max = ");
        stringBuilder.append(this.b);
        stringBuilder.append("}, Worker States {CPU = ");
        stringBuilder.append(i2);
        stringBuilder.append(", blocking = ");
        stringBuilder.append(i8);
        stringBuilder.append(", parked = ");
        stringBuilder.append(i4);
        stringBuilder.append(", dormant = ");
        stringBuilder.append(i5);
        stringBuilder.append(", terminated = ");
        stringBuilder.append(i3);
        stringBuilder.append("}, running workers queues = ");
        stringBuilder.append(arrayList);
        stringBuilder.append(", global CPU queue size = ");
        stringBuilder.append(this.w.c());
        stringBuilder.append(", global blocking queue size = ");
        stringBuilder.append(this.x.c());
        stringBuilder.append(", Control State {created workers= ");
        stringBuilder.append((int)i12);
        stringBuilder.append(", blocking tasks = ");
        stringBuilder.append((int)i15);
        stringBuilder.append(", CPUs acquired = ");
        stringBuilder.append(i17 -= i21);
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    @Override // java.util.concurrent.Executor
    public final void x() {
        if (J()) {
        }
        if (a.H(this, 0, obj1, 1)) {
        }
        J();
    }
}
