package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0097Aø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\tj\u0002`\nH\u0016J-\u0010\u0019\u001a\u00020\u00112\n\u0010\u0018\u001a\u00060\tj\u0002`\n2\u0016\u0010\u001a\u001a\u0012\u0012\u0008\u0012\u00060\u001cR\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u001bH\u0082\u0008J\u001c\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\tj\u0002`\nH\u0017J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00132\n\u0010\u0018\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001J\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\"\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002J\u001f\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00132\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00110%H\u0096\u0001J\u0008\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u000c\u0012\u0008\u0012\u00060\tj\u0002`\n0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u000b\u001a\u00020\u000cX\u0082\u0004R\u0012\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006)", d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", "", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "runningWorkers", "Lkotlinx/atomicfu/AtomicInt;", "workerAllocationLock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "dispatchInternal", "startWorker", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "dispatchYield", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "limitedParallelism", "obtainTaskOrDeallocateWorker", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryAllocateWorker", "", "Worker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {

    private static final AtomicIntegerFieldUpdater runningWorkers$FU;
    private final Delay $$delegate_0;
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    private final kotlinx.coroutines.internal.LockFreeTaskQueue<Runnable> queue;
    @Volatile
    private volatile int runningWorkers;
    private final Object workerAllocationLock;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0008\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "run", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class Worker implements Runnable {

        private Runnable currentTask;
        final kotlinx.coroutines.internal.LimitedDispatcher this$0;
        public Worker(kotlinx.coroutines.internal.LimitedDispatcher this$0, Runnable currentTask) {
            this.this$0 = this$0;
            super();
            this.currentTask = currentTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            int fairnessCounter;
            Throwable dispatchNeeded;
            Runnable currentTask;
            Object iNSTANCE;
            fairnessCounter = 0;
            while (/* condition */) {
                Runnable runnable = LimitedDispatcher.access$obtainTaskOrDeallocateWorker(this.this$0);
                this.currentTask = runnable;
                this.currentTask.run();
                CoroutineExceptionHandlerKt.handleCoroutineException((CoroutineContext)EmptyCoroutineContext.INSTANCE, dispatchNeeded);
            }
        }
    }
    static {
        LimitedDispatcher.runningWorkers$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");
    }

    public LimitedDispatcher(CoroutineDispatcher dispatcher, int parallelism) {
        CoroutineDispatcher defaultDelay;
        super();
        this.dispatcher = dispatcher;
        this.parallelism = parallelism;
        if (dispatcher instanceof Delay) {
            defaultDelay = dispatcher;
        } else {
            defaultDelay = 0;
        }
        if (defaultDelay == null) {
            defaultDelay = DefaultExecutorKt.getDefaultDelay();
        }
        this.$$delegate_0 = defaultDelay;
        LockFreeTaskQueue lockFreeTaskQueue = new LockFreeTaskQueue(0);
        this.queue = lockFreeTaskQueue;
        Object object = new Object();
        this.workerAllocationLock = object;
    }

    public static final CoroutineDispatcher access$getDispatcher$p(kotlinx.coroutines.internal.LimitedDispatcher $this) {
        return $this.dispatcher;
    }

    public static final Runnable access$obtainTaskOrDeallocateWorker(kotlinx.coroutines.internal.LimitedDispatcher $this) {
        return $this.obtainTaskOrDeallocateWorker();
    }

    private final void dispatchInternal(Runnable block, Function1<? super kotlinx.coroutines.internal.LimitedDispatcher.Worker, Unit> startWorker) {
        final int i = 0;
        this.queue.addLast(block);
        if (LimitedDispatcher.runningWorkers$FU.get(this) >= this.parallelism) {
        }
        if (!tryAllocateWorker()) {
        }
        Runnable taskOrDeallocateWorker = obtainTaskOrDeallocateWorker();
        if (taskOrDeallocateWorker == null) {
        }
        LimitedDispatcher.Worker worker = new LimitedDispatcher.Worker(this, taskOrDeallocateWorker);
        startWorker.invoke(worker);
    }

    private final Runnable obtainTaskOrDeallocateWorker() {
        Object firstOrNull;
        Object workerAllocationLock;
        int i2;
        int i;
        Throwable th;
        AtomicIntegerFieldUpdater runningWorkers$FU;
        firstOrNull = this.queue.removeFirstOrNull();
        while ((Runnable)firstOrNull == null) {
            workerAllocationLock = this.workerAllocationLock;
            i2 = 0;
            i = 0;
            th = 0;
            LimitedDispatcher.runningWorkers$FU.decrementAndGet(this);
            LimitedDispatcher.runningWorkers$FU.incrementAndGet(this);
            firstOrNull = this.queue.removeFirstOrNull();
        }
        return (Runnable)(Runnable)firstOrNull;
    }

    private final boolean tryAllocateWorker() {
        Object workerAllocationLock = this.workerAllocationLock;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        synchronized (workerAllocationLock) {
            return 0;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long l, Continuation<? super Unit> continuation2) {
        return this.$$delegate_0.delay(l, continuation2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        int taskOrDeallocateWorker;
        int parallelism;
        int i;
        CoroutineDispatcher dispatcher;
        Object obj;
        kotlinx.coroutines.internal.LimitedDispatcher.Worker worker;
        final Object obj2 = this;
        final int i2 = 0;
        obj2.queue.addLast(block);
        if (LimitedDispatcher.runningWorkers$FU.get(obj2) < obj2.parallelism && obj2.tryAllocateWorker()) {
            if (obj2.tryAllocateWorker()) {
                taskOrDeallocateWorker = obj2.obtainTaskOrDeallocateWorker();
                if (taskOrDeallocateWorker == null) {
                } else {
                    parallelism = new LimitedDispatcher.Worker(obj2, taskOrDeallocateWorker);
                    i = 0;
                    this.dispatcher.dispatch((CoroutineContext)this, (Runnable)parallelism);
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext context, Runnable block) {
        int taskOrDeallocateWorker;
        int parallelism;
        int i;
        CoroutineDispatcher dispatcher;
        Object obj;
        kotlinx.coroutines.internal.LimitedDispatcher.Worker worker;
        final Object obj2 = this;
        final int i2 = 0;
        obj2.queue.addLast(block);
        if (LimitedDispatcher.runningWorkers$FU.get(obj2) < obj2.parallelism && obj2.tryAllocateWorker()) {
            if (obj2.tryAllocateWorker()) {
                taskOrDeallocateWorker = obj2.obtainTaskOrDeallocateWorker();
                if (taskOrDeallocateWorker == null) {
                } else {
                    parallelism = new LimitedDispatcher.Worker(obj2, taskOrDeallocateWorker);
                    i = 0;
                    this.dispatcher.dispatchYield((CoroutineContext)this, (Runnable)parallelism);
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public DisposableHandle invokeOnTimeout(long l, Runnable runnable2, CoroutineContext coroutineContext3) {
        return this.$$delegate_0.invokeOnTimeout(l, runnable2, coroutineContext3);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        if (parallelism >= this.parallelism) {
            return (CoroutineDispatcher)this;
        }
        return super.limitedParallelism(parallelism);
    }

    public void scheduleResumeAfterDelay(long l, CancellableContinuation<? super Unit> cancellableContinuation2) {
        this.$$delegate_0.scheduleResumeAfterDelay(l, cancellableContinuation2);
    }
}
