package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\u0008\u0010\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u000bH\u0002J\u001c\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0016J)\u0010\u0019\u001a\u00020\u00112\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\u0008\u001dJ\u001c\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0016J\r\u0010\u001f\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0008 J\u0015\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0008#J\r\u0010$\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0008%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "tailDispatch", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {

    private final int corePoolSize;
    private kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    private final String schedulerName;
    public SchedulerCoroutineDispatcher() {
        super(0, 0, 0, obj4, 0, 15, 0);
    }

    public SchedulerCoroutineDispatcher(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, String schedulerName) {
        super();
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.idleWorkerKeepAliveNs = idleWorkerKeepAliveNs;
        this.schedulerName = obj6;
        this.coroutineScheduler = createScheduler();
    }

    public SchedulerCoroutineDispatcher(int i, int i2, long l3, String string4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj1;
        int obj2;
        long obj3;
        String obj5;
        String obj7;
        obj1 = defaultConstructorMarker6 & 1 != 0 ? TasksKt.CORE_POOL_SIZE : obj1;
        obj2 = defaultConstructorMarker6 & 2 != 0 ? TasksKt.MAX_POOL_SIZE : obj2;
        obj3 = defaultConstructorMarker6 & 4 != 0 ? TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : obj3;
        defaultConstructorMarker6 &= 8;
        obj7 = obj6 != null ? obj5 : i5;
        super(obj1, obj2, obj3, obj6, obj7);
    }

    private final kotlinx.coroutines.scheduling.CoroutineScheduler createScheduler() {
        CoroutineScheduler coroutineScheduler = new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, obj4, this.schedulerName);
        return coroutineScheduler;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public void close() {
        this.coroutineScheduler.close();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, 0, false, 6, 0);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final void dispatchWithContext$kotlinx_coroutines_core(Runnable block, kotlinx.coroutines.scheduling.TaskContext context, boolean tailDispatch) {
        this.coroutineScheduler.dispatch(block, context, tailDispatch);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public void dispatchYield(CoroutineContext context, Runnable block) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, 0, true, 2, 0);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return (Executor)this.coroutineScheduler;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final void restore$kotlinx_coroutines_core() {
        usePrivateScheduler$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final void shutdown$kotlinx_coroutines_core(long timeout) {
        this.coroutineScheduler.shutdown(timeout);
        return;
        synchronized (this) {
            this.coroutineScheduler.shutdown(timeout);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final void usePrivateScheduler$kotlinx_coroutines_core() {
        this.coroutineScheduler.shutdown(1000);
        this.coroutineScheduler = createScheduler();
        return;
        synchronized (this) {
            this.coroutineScheduler.shutdown(1000);
            this.coroutineScheduler = createScheduler();
        }
    }
}
