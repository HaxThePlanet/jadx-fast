package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ConcurrentKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0008\u0010\u000e\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\t0\u001fH\u0016J\u0008\u0010 \u001a\u00020!H\u0016J.\u0010\"\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010#*\u00020$2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006%", d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "cancelJobOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "Ljava/util/concurrent/RejectedExecutionException;", "close", "dispatch", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExecutorCoroutineDispatcherImpl extends kotlinx.coroutines.ExecutorCoroutineDispatcher implements kotlinx.coroutines.Delay {

    private final Executor executor;
    public ExecutorCoroutineDispatcherImpl(Executor executor) {
        super();
        this.executor = executor;
        ConcurrentKt.removeFutureOnCancel(getExecutor());
    }

    private final void cancelJobOnRejection(CoroutineContext context, RejectedExecutionException exception) {
        JobKt.cancel(context, ExceptionsKt.CancellationException("The task was rejected", (Throwable)exception));
    }

    private final ScheduledFuture<?> scheduleBlock(ScheduledExecutorService $this$scheduleBlock, Runnable block, CoroutineContext context, long timeMillis) {
        ScheduledFuture schedule;
        int i;
        schedule = $this$scheduleBlock.schedule(block, timeMillis, obj7);
        return schedule;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public void close() {
        Executor executor;
        if (executor instanceof ExecutorService != null) {
        } else {
            executor = 0;
        }
        if (executor != null) {
            executor.shutdown();
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long time, Continuation<? super Unit> $completion) {
        return Delay.DefaultImpls.delay(this, time, $completion);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        Executor executor;
        kotlinx.coroutines.AbstractTimeSource iO;
        Runnable timeSource;
        timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            try {
                if (timeSource.wrapTask(block) == null) {
                }
                timeSource = block;
                getExecutor().execute(timeSource);
                iO = AbstractTimeSourceKt.getTimeSource();
                if (iO != null) {
                }
                iO.unTrackTask();
                cancelJobOnRejection(context, th);
                iO = Dispatchers.getIO();
                iO.dispatch(context, block);
            }
        } else {
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public boolean equals(Object other) {
        boolean executor2;
        int i;
        Executor executor;
        if (other instanceof ExecutorCoroutineDispatcherImpl && (ExecutorCoroutineDispatcherImpl)other.getExecutor() == getExecutor()) {
            i = (ExecutorCoroutineDispatcherImpl)other.getExecutor() == getExecutor() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public int hashCode() {
        return System.identityHashCode(getExecutor());
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        int scheduleBlock;
        Object obj;
        int i;
        Runnable runnable;
        CoroutineContext context2;
        long timeMillis2;
        kotlinx.coroutines.DisposableHandle obj10;
        int obj11;
        final Executor executor = getExecutor();
        i = executor instanceof ScheduledExecutorService != null ? executor : scheduleBlock;
        if (i != 0) {
            scheduleBlock = this.scheduleBlock(i, context, obj13, timeMillis);
        } else {
            timeMillis2 = timeMillis;
            runnable = context;
            context2 = obj13;
        }
        if (scheduleBlock != 0) {
            obj10 = new DisposableFutureHandle((Future)scheduleBlock);
        } else {
            obj10 = DefaultExecutor.INSTANCE.invokeOnTimeout(timeMillis2, obj8, runnable);
        }
        return obj10;
    }

    public void scheduleResumeAfterDelay(long timeMillis, kotlinx.coroutines.CancellableContinuation<? super Unit> continuation) {
        Object resumeUndispatchedRunnable;
        boolean z;
        int scheduleBlock;
        kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher;
        int i;
        kotlinx.coroutines.ResumeUndispatchedRunnable runnable;
        CoroutineContext context;
        long timeMillis2;
        resumeUndispatchedRunnable = getExecutor();
        i = resumeUndispatchedRunnable instanceof ScheduledExecutorService != null ? resumeUndispatchedRunnable : scheduleBlock;
        if (i != 0) {
            resumeUndispatchedRunnable = new ResumeUndispatchedRunnable((CoroutineDispatcher)this, obj12);
            scheduleBlock = this.scheduleBlock(i, (Runnable)resumeUndispatchedRunnable, obj12.getContext(), timeMillis);
        } else {
            timeMillis2 = timeMillis;
        }
        if (scheduleBlock != 0) {
            JobKt.cancelFutureOnCancellation(obj12, (Future)scheduleBlock);
        }
        DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(timeMillis2, obj8);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public String toString() {
        return getExecutor().toString();
    }
}
