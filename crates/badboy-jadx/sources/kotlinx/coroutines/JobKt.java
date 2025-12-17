package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes5.dex */
@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class JobKt {
    public static final kotlinx.coroutines.CompletableJob Job(kotlinx.coroutines.Job parent) {
        return JobKt__JobKt.Job(parent);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final kotlinx.coroutines.Job Job(kotlinx.coroutines.Job parent) {
        return JobKt__JobKt.Job(parent);
    }

    public static kotlinx.coroutines.CompletableJob Job$default(kotlinx.coroutines.Job job, int i2, Object object3) {
        return JobKt__JobKt.Job$default(job, i2, object3);
    }

    public static kotlinx.coroutines.Job Job$default(kotlinx.coroutines.Job job, int i2, Object object3) {
        return JobKt__JobKt.Job$default(job, i2, object3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancel(CoroutineContext $this$cancel) {
        JobKt__JobKt.cancel($this$cancel);
    }

    public static final void cancel(CoroutineContext $this$cancel, CancellationException cause) {
        JobKt__JobKt.cancel($this$cancel, cause);
    }

    public static final void cancel(kotlinx.coroutines.Job $this$cancel, String message, Throwable cause) {
        JobKt__JobKt.cancel($this$cancel, message, cause);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final boolean cancel(CoroutineContext $this$cancel, Throwable cause) {
        return JobKt__JobKt.cancel($this$cancel, cause);
    }

    public static void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException2, int i3, Object object4) {
        JobKt__JobKt.cancel$default(coroutineContext, cancellationException2, i3, object4);
    }

    public static void cancel$default(kotlinx.coroutines.Job job, String string2, Throwable throwable3, int i4, Object object5) {
        JobKt__JobKt.cancel$default(job, string2, throwable3, i4, object5);
    }

    public static boolean cancel$default(CoroutineContext coroutineContext, Throwable throwable2, int i3, Object object4) {
        return JobKt__JobKt.cancel$default(coroutineContext, throwable2, i3, object4);
    }

    public static final Object cancelAndJoin(kotlinx.coroutines.Job $this$cancelAndJoin, Continuation<? super Unit> $completion) {
        return JobKt__JobKt.cancelAndJoin($this$cancelAndJoin, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(CoroutineContext $this$cancelChildren) {
        JobKt__JobKt.cancelChildren($this$cancelChildren);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(CoroutineContext $this$cancelChildren, Throwable cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    public static final void cancelChildren(CoroutineContext $this$cancelChildren, CancellationException cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(kotlinx.coroutines.Job $this$cancelChildren) {
        JobKt__JobKt.cancelChildren($this$cancelChildren);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(kotlinx.coroutines.Job $this$cancelChildren, Throwable cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    public static final void cancelChildren(kotlinx.coroutines.Job $this$cancelChildren, CancellationException cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    public static void cancelChildren$default(CoroutineContext coroutineContext, Throwable throwable2, int i3, Object object4) {
        JobKt__JobKt.cancelChildren$default(coroutineContext, throwable2, i3, object4);
    }

    public static void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException2, int i3, Object object4) {
        JobKt__JobKt.cancelChildren$default(coroutineContext, cancellationException2, i3, object4);
    }

    public static void cancelChildren$default(kotlinx.coroutines.Job job, Throwable throwable2, int i3, Object object4) {
        JobKt__JobKt.cancelChildren$default(job, throwable2, i3, object4);
    }

    public static void cancelChildren$default(kotlinx.coroutines.Job job, CancellationException cancellationException2, int i3, Object object4) {
        JobKt__JobKt.cancelChildren$default(job, cancellationException2, i3, object4);
    }

    public static final void cancelFutureOnCancellation(kotlinx.coroutines.CancellableContinuation<?> $this$cancelFutureOnCancellation, Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation($this$cancelFutureOnCancellation, future);
    }

    public static final kotlinx.coroutines.DisposableHandle cancelFutureOnCompletion(kotlinx.coroutines.Job $this$cancelFutureOnCompletion, Future<?> future) {
        return JobKt__FutureKt.cancelFutureOnCompletion($this$cancelFutureOnCompletion, future);
    }

    public static final kotlinx.coroutines.DisposableHandle disposeOnCompletion(kotlinx.coroutines.Job $this$disposeOnCompletion, kotlinx.coroutines.DisposableHandle handle) {
        return JobKt__JobKt.disposeOnCompletion($this$disposeOnCompletion, handle);
    }

    public static final void ensureActive(CoroutineContext $this$ensureActive) {
        JobKt__JobKt.ensureActive($this$ensureActive);
    }

    public static final void ensureActive(kotlinx.coroutines.Job $this$ensureActive) {
        JobKt__JobKt.ensureActive($this$ensureActive);
    }

    public static final kotlinx.coroutines.Job getJob(CoroutineContext $this$job) {
        return JobKt__JobKt.getJob($this$job);
    }

    public static final boolean isActive(CoroutineContext $this$isActive) {
        return JobKt__JobKt.isActive($this$isActive);
    }
}
