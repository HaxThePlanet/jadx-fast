package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0017J\r\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\nJ\u0008\u0010\u000b\u001a\u00020\u000cH\u0016¨\u0006\r", d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "()V", "close", "", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "shutdown", "shutdown$kotlinx_coroutines_core", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultScheduler extends kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher {

    public static final kotlinx.coroutines.scheduling.DefaultScheduler INSTANCE;
    static {
        DefaultScheduler defaultScheduler = new DefaultScheduler();
        DefaultScheduler.INSTANCE = defaultScheduler;
    }

    private DefaultScheduler() {
        super(TasksKt.CORE_POOL_SIZE, TasksKt.MAX_POOL_SIZE, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, obj4, TasksKt.DEFAULT_SCHEDULER_NAME);
    }

    @Override // kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher
    public void close() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Dispatchers.Default cannot be closed");
        throw unsupportedOperationException;
    }

    @Override // kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        if (parallelism >= TasksKt.CORE_POOL_SIZE) {
            return (CoroutineDispatcher)this;
        }
        return super.limitedParallelism(parallelism);
    }

    @Override // kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher
    public final void shutdown$kotlinx_coroutines_core() {
        super.close();
    }

    @Override // kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
