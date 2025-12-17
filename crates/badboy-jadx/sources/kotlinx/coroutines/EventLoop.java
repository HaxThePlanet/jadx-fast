package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008 \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\n\u0010\u0017\u001a\u0006\u0012\u0002\u0008\u00030\u0010J\u0010\u0010\u0018\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ\u0008\u0010\u001c\u001a\u00020\nH\u0016J\u0006\u0010\u001d\u001a\u00020\u0004J\u0008\u0010\u001e\u001a\u00020\u0004H\u0016J\u0008\u0010\u001f\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u0011\u0010\u0008\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0005R\u0014\u0010\t\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlin/collections/ArrayDeque;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "limitedParallelism", "parallelism", "", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class EventLoop extends kotlinx.coroutines.CoroutineDispatcher {

    private boolean shared;
    private ArrayDeque<kotlinx.coroutines.DispatchedTask<?>> unconfinedQueue;
    private long useCount;
    public static void decrementUseCount$default(kotlinx.coroutines.EventLoop eventLoop, boolean z2, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            if (i3 &= 1 != 0) {
                obj1 = 0;
            }
            eventLoop.decrementUseCount(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        throw obj0;
    }

    private final long delta(boolean unconfined) {
        long l;
        l = unconfined ? 4294967296L : 1;
        return l;
    }

    public static void incrementUseCount$default(kotlinx.coroutines.EventLoop eventLoop, boolean z2, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            if (i3 &= 1 != 0) {
                obj1 = 0;
            }
            eventLoop.incrementUseCount(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        throw obj0;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void decrementUseCount(boolean unconfined) {
        boolean aSSERTIONS_ENABLED;
        int i;
        long useCount;
        this.useCount = useCount2 -= delta;
        int i3 = 0;
        if (Long.compare(useCount3, i3) > 0) {
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = Long.compare(useCount, i3) == 0 ? 1 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (this.shared) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(kotlinx.coroutines.DispatchedTask<?> task) {
        ArrayDeque unconfinedQueue;
        ArrayDeque queue;
        int i;
        if (this.unconfinedQueue == null) {
            unconfinedQueue = new ArrayDeque();
            i = 0;
            this.unconfinedQueue = unconfinedQueue;
        }
        unconfinedQueue.addLast(task);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    protected long getNextTime() {
        long l;
        final ArrayDeque unconfinedQueue = this.unconfinedQueue;
        if (unconfinedQueue == null) {
            return Long.MAX_VALUE;
        }
        if (unconfinedQueue.isEmpty()) {
        } else {
            l = 0;
        }
        return l;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void incrementUseCount(boolean unconfined) {
        int i;
        this.useCount = useCount += delta;
        if (!unconfined) {
            this.shared = true;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isActive() {
        int i;
        i = Long.compare(useCount, i2) > 0 ? 1 : 0;
        return i;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    protected boolean isEmpty() {
        return isUnconfinedQueueEmpty();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isUnconfinedLoopActive() {
        int i;
        if (Long.compare(useCount, delta) >= 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isUnconfinedQueueEmpty() {
        boolean empty;
        ArrayDeque unconfinedQueue = this.unconfinedQueue;
        if (unconfinedQueue != null) {
            empty = unconfinedQueue.isEmpty();
        } else {
            empty = 1;
        }
        return empty;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final kotlinx.coroutines.CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        return (CoroutineDispatcher)this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public long processNextEvent() {
        if (!processUnconfinedEvent()) {
            return Long.MAX_VALUE;
        }
        return 0;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean processUnconfinedEvent() {
        final ArrayDeque unconfinedQueue = this.unconfinedQueue;
        int i = 0;
        if (unconfinedQueue == null) {
            return i;
        }
        final Object firstOrNull = unconfinedQueue.removeFirstOrNull();
        if ((DispatchedTask)firstOrNull == null) {
            return i;
        }
        (DispatchedTask)firstOrNull.run();
        return 1;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean shouldBeProcessedFromContext() {
        return 0;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void shutdown() {
    }
}
