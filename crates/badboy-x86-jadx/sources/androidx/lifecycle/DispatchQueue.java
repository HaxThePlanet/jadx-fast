package androidx.lifecycle;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0008\u0010\u000b\u001a\u00020\u000cH\u0007J\u0008\u0010\r\u001a\u00020\u000cH\u0007J\u0008\u0010\u000e\u001a\u00020\u000cH\u0007J\u0008\u0010\u000f\u001a\u00020\u000cH\u0007J\u0008\u0010\u0010\u001a\u00020\u0005H\u0007J\u0018\u0010\u0011\u001a\u00020\u000c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\nH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "<init>", "()V", "paused", "", "finished", "isDraining", "queue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "pause", "", "resume", "finish", "drainQueue", "canRun", "dispatchAndEnqueue", "context", "Lkotlin/coroutines/CoroutineContext;", "runnable", "enqueue", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DispatchQueue {

    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue;
    public static void $r8$lambda$QTUwShsnwO8ux11W0m-zm9OKBq8(androidx.lifecycle.DispatchQueue dispatchQueue, Runnable runnable2) {
        DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1(dispatchQueue, runnable2);
    }

    public DispatchQueue() {
        super();
        int i = 1;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.queue = (Queue)arrayDeque;
    }

    private static final void dispatchAndEnqueue$lambda$2$lambda$1(androidx.lifecycle.DispatchQueue this$0, Runnable $runnable) {
        this$0.enqueue($runnable);
    }

    private final void enqueue(Runnable runnable) {
        if (!this.queue.offer(runnable)) {
        } else {
            drainQueue();
        }
        int i = 0;
        IllegalStateException illegalStateException = new IllegalStateException("cannot enqueue any more runnables".toString());
        throw illegalStateException;
    }

    public final boolean canRun() {
        int i;
        boolean finished;
        if (!this.finished) {
            if (!this.paused) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final void dispatchAndEnqueue(CoroutineContext context, Runnable runnable) {
        boolean dispatchNeeded;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        final int i = 0;
        if (!immediate.isDispatchNeeded(context)) {
            if (canRun()) {
                dispatchNeeded = new DispatchQueue$$ExternalSyntheticLambda0(this, runnable);
                immediate.dispatch(context, dispatchNeeded);
            } else {
                enqueue(runnable);
            }
        } else {
        }
    }

    public final void drainQueue() {
        int poll;
        boolean empty;
        if (this.isDraining) {
        }
        this.isDraining = true;
        while (!(Collection)this.queue.isEmpty()) {
            if (!canRun()) {
                break;
            } else {
            }
            poll = this.queue.poll();
            if ((Runnable)poll != 0) {
            }
            (Runnable)poll.run();
        }
        try {
            this.isDraining = false;
            this.isDraining = obj1;
            throw th;
        }
    }

    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    public final void pause() {
        this.paused = true;
    }

    public final void resume() {
        if (!this.paused) {
        }
        if (this.finished) {
        } else {
            this.paused = false;
            drainQueue();
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Cannot resume a finished dispatcher".toString());
        throw illegalStateException;
    }
}
