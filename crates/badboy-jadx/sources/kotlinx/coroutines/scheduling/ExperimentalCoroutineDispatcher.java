package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0011\u0018\u00002\u00020\u0001B%\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001b\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\rH\u0002J\u001c\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J)\u0010\u001e\u001a\u00020\u00162\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u0019\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\u0008\"J\u001c\u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J\u000e\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\u0008\u0010%\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "schedulerName", "", "(IILjava/lang/String;)V", "(II)V", "idleWorkerKeepAliveNs", "", "(IIJLjava/lang/String;)V", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "blocking", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "close", "", "createScheduler", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchWithContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "tailDispatch", "", "dispatchWithContext$kotlinx_coroutines_core", "dispatchYield", "limited", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ExperimentalCoroutineDispatcher extends ExecutorCoroutineDispatcher {

    private final int corePoolSize;
    private kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    private final String schedulerName;
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public ExperimentalCoroutineDispatcher(int corePoolSize, int maxPoolSize) {
        super(corePoolSize, maxPoolSize, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, obj4, 0, 8, 0);
    }

    public ExperimentalCoroutineDispatcher(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? TasksKt.CORE_POOL_SIZE : obj1;
        obj2 = i3 &= 2 != 0 ? TasksKt.MAX_POOL_SIZE : obj2;
        super(obj1, obj2);
    }

    public ExperimentalCoroutineDispatcher(int corePoolSize, int maxPoolSize, long idleWorkerKeepAliveNs, String schedulerName) {
        super();
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.idleWorkerKeepAliveNs = idleWorkerKeepAliveNs;
        this.schedulerName = obj6;
        this.coroutineScheduler = createScheduler();
    }

    public ExperimentalCoroutineDispatcher(int i, int i2, long l3, String string4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        String str;
        String obj11;
        str = defaultConstructorMarker6 &= 8 != 0 ? obj11 : i5;
        super(i, i2, l3, obj4, str);
    }

    public ExperimentalCoroutineDispatcher(int corePoolSize, int maxPoolSize, String schedulerName) {
        super(corePoolSize, maxPoolSize, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, obj4, schedulerName);
    }

    public ExperimentalCoroutineDispatcher(int i, int i2, String string3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj1;
        int obj2;
        String obj3;
        obj1 = i4 & 1 != 0 ? TasksKt.CORE_POOL_SIZE : obj1;
        obj2 = i4 & 2 != 0 ? TasksKt.MAX_POOL_SIZE : obj2;
        obj3 = i4 &= 4 != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : obj3;
        super(obj1, obj2, obj3);
    }

    public static CoroutineDispatcher blocking$default(kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i2, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            if (i3 &= 1 != 0) {
                obj1 = 16;
            }
            return experimentalCoroutineDispatcher.blocking(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
        throw obj0;
    }

    private final kotlinx.coroutines.scheduling.CoroutineScheduler createScheduler() {
        CoroutineScheduler coroutineScheduler = new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, obj4, this.schedulerName);
        return coroutineScheduler;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final CoroutineDispatcher blocking(int parallelism) {
        int i;
        int i2 = 1;
        i = parallelism > 0 ? i2 : 0;
        if (i == 0) {
        } else {
            LimitingDispatcher limitingDispatcher = new LimitingDispatcher(this, parallelism, 0, i2);
            return (CoroutineDispatcher)limitingDispatcher;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected positive parallelism level, but have ").append(parallelism).toString().toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public void close() {
        this.coroutineScheduler.close();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler;
        Throwable th;
        Runnable runnable;
        Throwable obj8;
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, 0, false, 6, 0);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final void dispatchWithContext$kotlinx_coroutines_core(Runnable block, kotlinx.coroutines.scheduling.TaskContext context, boolean tailDispatch) {
        kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler;
        DefaultExecutor iNSTANCE;
        kotlinx.coroutines.scheduling.CoroutineScheduler task;
        this.coroutineScheduler.dispatch(block, context, tailDispatch);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public void dispatchYield(CoroutineContext context, Runnable block) {
        kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler;
        Throwable th;
        Runnable runnable;
        Throwable obj8;
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, 0, true, 2, 0);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return (Executor)this.coroutineScheduler;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public final CoroutineDispatcher limited(int parallelism) {
        int i2;
        int i;
        int i5 = 0;
        i = parallelism > 0 ? i2 : i5;
        if (i == 0) {
        } else {
            if (parallelism <= this.corePoolSize) {
            } else {
                i2 = i5;
            }
            if (i2 == 0) {
            } else {
                LimitingDispatcher limitingDispatcher = new LimitingDispatcher(this, parallelism, 0, i5);
                return (CoroutineDispatcher)limitingDispatcher;
            }
            int i4 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Expected parallelism level lesser than core pool size (").append(this.corePoolSize).append("), but have ").append(parallelism).toString().toString());
            throw illegalArgumentException2;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected positive parallelism level, but have ").append(parallelism).toString().toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(super.toString()).append("[scheduler = ").append(this.coroutineScheduler).append(']').toString();
    }
}
