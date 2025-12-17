package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.Sequence;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0012\u0010\u0008\u001a\u00020\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u001a\u0019\u0010\u000b\u001a\u00020\u00052\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0008\u0008\u001a\u000c\u0010\u000c\u001a\u00020\r*\u00020\u0002H\u0007\u001a\u0018\u0010\u000c\u001a\u00020\u0001*\u00020\u00022\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\u000c\u001a\u00020\r*\u00020\u00022\u0010\u0008\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\u001e\u0010\u000c\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u000c\u0010\u0016\u001a\u00020\r*\u00020\u0002H\u0007\u001a\u0018\u0010\u0016\u001a\u00020\r*\u00020\u00022\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00022\u0010\u0008\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\u000c\u0010\u0016\u001a\u00020\r*\u00020\u0005H\u0007\u001a\u0018\u0010\u0016\u001a\u00020\r*\u00020\u00052\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00052\u0010\u0008\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0000\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u0005\u001a\u001b\u0010\u001b\u001a\u00020\u000f*\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0008\u001c\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001d", d2 = {"isActive", "", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "job", "Lkotlinx/coroutines/Job;", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "disposeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handle", "ensureActive", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/JobKt")
final class JobKt__JobKt {
    public static final kotlinx.coroutines.CompletableJob Job(kotlinx.coroutines.Job parent) {
        JobImpl jobImpl = new JobImpl(parent);
        return (CompletableJob)jobImpl;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final kotlinx.coroutines.Job Job(kotlinx.coroutines.Job parent) {
        return (Job)JobKt.Job(parent);
    }

    public static kotlinx.coroutines.CompletableJob Job$default(kotlinx.coroutines.Job job, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return JobKt.Job(obj0);
    }

    public static kotlinx.coroutines.Job Job$default(kotlinx.coroutines.Job job, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return JobKt.Job(obj0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancel(CoroutineContext $this$cancel) {
        JobKt.cancel($this$cancel, 0);
    }

    public static final void cancel(CoroutineContext $this$cancel, CancellationException cause) {
        kotlin.coroutines.CoroutineContext.Element context = $this$cancel.get((CoroutineContext.Key)Job.Key);
        if ((Job)context != null) {
            (Job)context.cancel(cause);
        }
    }

    public static final void cancel(kotlinx.coroutines.Job $this$cancel, String message, Throwable cause) {
        $this$cancel.cancel(ExceptionsKt.CancellationException(message, cause));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final boolean cancel(CoroutineContext $this$cancel, Throwable cause) {
        kotlin.coroutines.CoroutineContext.Element context;
        if (context instanceof JobSupport) {
        } else {
            context = 0;
        }
        if (context == null) {
            return 0;
        }
        context.cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(cause, (Job)context));
        return 1;
    }

    public static void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        JobKt.cancel(coroutineContext, obj1);
    }

    public static void cancel$default(kotlinx.coroutines.Job job, String string2, Throwable throwable3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        JobKt.cancel(job, string2, obj2);
    }

    public static boolean cancel$default(CoroutineContext coroutineContext, Throwable throwable2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return JobKt.cancel(coroutineContext, obj1);
    }

    public static final Object cancelAndJoin(kotlinx.coroutines.Job $this$cancelAndJoin, Continuation<? super Unit> $completion) {
        int i = 0;
        Job.DefaultImpls.cancel$default($this$cancelAndJoin, i, 1, i);
        Object join = $this$cancelAndJoin.join($completion);
        if (join == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return join;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(CoroutineContext $this$cancelChildren) {
        JobKt.cancelChildren($this$cancelChildren, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(CoroutineContext $this$cancelChildren, Throwable cause) {
        Object next;
        Object obj;
        int i;
        int i2;
        Throwable orCancellation$JobKt__JobKt;
        kotlin.coroutines.CoroutineContext.Element context = $this$cancelChildren.get((CoroutineContext.Key)Job.Key);
        if ((Job)context == null) {
        }
        final int i3 = 0;
        final Iterator iterator = (Job)context.getChildren().iterator();
        while (iterator.hasNext()) {
            obj = next;
            i = 0;
            if (obj instanceof JobSupport) {
            } else {
            }
            i2 = 0;
            if (i2 != 0) {
            }
            i2.cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(cause, context));
            i2 = obj;
        }
    }

    public static final void cancelChildren(CoroutineContext $this$cancelChildren, CancellationException cause) {
        Object children;
        int i2;
        Iterator iterator;
        Object next;
        Object obj;
        int i;
        children = $this$cancelChildren.get((CoroutineContext.Key)Job.Key);
        children = (Job)children.getChildren();
        if (children != null && children != null) {
            children = children.getChildren();
            if (children != null) {
                i2 = 0;
                iterator = children.iterator();
                for (Object next : iterator) {
                    i = 0;
                    (Job)next.cancel(cause);
                }
            }
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(kotlinx.coroutines.Job $this$cancelChildren) {
        JobKt.cancelChildren($this$cancelChildren, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final void cancelChildren(kotlinx.coroutines.Job $this$cancelChildren, Throwable cause) {
        Object next;
        Object obj2;
        int i;
        Object obj;
        Throwable orCancellation$JobKt__JobKt;
        final int i2 = 0;
        final Iterator iterator = $this$cancelChildren.getChildren().iterator();
        while (iterator.hasNext()) {
            obj2 = next;
            i = 0;
            if (obj2 instanceof JobSupport) {
            } else {
            }
            obj = 0;
            if (obj != null) {
            }
            obj.cancelInternal(JobKt__JobKt.orCancellation$JobKt__JobKt(cause, $this$cancelChildren));
            obj = obj2;
        }
    }

    public static final void cancelChildren(kotlinx.coroutines.Job $this$cancelChildren, CancellationException cause) {
        Object next;
        Object obj;
        int i;
        final int i2 = 0;
        final Iterator iterator = $this$cancelChildren.getChildren().iterator();
        for (Object next : iterator) {
            i = 0;
            (Job)next.cancel(cause);
        }
    }

    public static void cancelChildren$default(CoroutineContext coroutineContext, Throwable throwable2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        JobKt.cancelChildren(coroutineContext, obj1);
    }

    public static void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        JobKt.cancelChildren(coroutineContext, obj1);
    }

    public static void cancelChildren$default(kotlinx.coroutines.Job job, Throwable throwable2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        JobKt.cancelChildren(job, obj1);
    }

    public static void cancelChildren$default(kotlinx.coroutines.Job job, CancellationException cancellationException2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        JobKt.cancelChildren(job, obj1);
    }

    public static final kotlinx.coroutines.DisposableHandle disposeOnCompletion(kotlinx.coroutines.Job $this$disposeOnCompletion, kotlinx.coroutines.DisposableHandle handle) {
        DisposeOnCompletion disposeOnCompletion = new DisposeOnCompletion(handle);
        final int i = 0;
        return $this$disposeOnCompletion.invokeOnCompletion((Function1)(CompletionHandlerBase)disposeOnCompletion);
    }

    public static final void ensureActive(CoroutineContext $this$ensureActive) {
        kotlin.coroutines.CoroutineContext.Element context = $this$ensureActive.get((CoroutineContext.Key)Job.Key);
        if ((Job)context != null) {
            JobKt.ensureActive((Job)context);
        }
    }

    public static final void ensureActive(kotlinx.coroutines.Job $this$ensureActive) {
        if (!$this$ensureActive.isActive()) {
        } else {
        }
        throw $this$ensureActive.getCancellationException();
    }

    public static final kotlinx.coroutines.Job getJob(CoroutineContext $this$job) {
        kotlin.coroutines.CoroutineContext.Element context = $this$job.get((CoroutineContext.Key)Job.Key);
        if ((Job)context == null) {
        } else {
            return (Job)context;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Current context doesn't contain Job in it: ").append($this$job).toString().toString());
        throw illegalStateException;
    }

    public static final boolean isActive(CoroutineContext $this$isActive) {
        boolean active;
        kotlin.coroutines.CoroutineContext.Element context = $this$isActive.get((CoroutineContext.Key)Job.Key);
        if ((Job)context != null) {
            active = (Job)context.isActive();
        } else {
            active = 1;
        }
        return active;
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable $this$orCancellation, kotlinx.coroutines.Job job) {
        kotlinx.coroutines.JobCancellationException jobCancellationException;
        String str;
        int i;
        if ($this$orCancellation == null) {
            jobCancellationException = new JobCancellationException("Job was cancelled", 0, job);
        } else {
            jobCancellationException = $this$orCancellation;
        }
        return jobCancellationException;
    }
}
