package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.scheduling.CoroutineScheduler.Worker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0004\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005H\u0080\u0008\u001a\u0008\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0008\u0010\u0008\u001a\u00020\u0007H\u0001\u001a\u000c\u0010\t\u001a\u00020\n*\u00020\u000bH\u0001¨\u0006\u000c", d2 = {"createEventLoop", "Lkotlinx/coroutines/EventLoop;", "platformAutoreleasePool", "", "block", "Lkotlin/Function0;", "processNextEventInCurrentThread", "", "runSingleTaskFromCurrentSystemDispatcher", "isIoDispatcherThread", "", "Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EventLoopKt {
    public static final kotlinx.coroutines.EventLoop createEventLoop() {
        BlockingEventLoop blockingEventLoop = new BlockingEventLoop(Thread.currentThread());
        return (EventLoop)blockingEventLoop;
    }

    public static final boolean isIoDispatcherThread(Thread $this$isIoDispatcherThread) {
        if (!$this$isIoDispatcherThread instanceof CoroutineScheduler.Worker) {
            return 0;
        }
        return (CoroutineScheduler.Worker)$this$isIoDispatcherThread.isIo();
    }

    public static final void platformAutoreleasePool(Function0<Unit> block) {
        final int i = 0;
        block.invoke();
    }

    public static final long processNextEventInCurrentThread() {
        long nextEvent;
        kotlinx.coroutines.EventLoop currentOrNull$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
        if (currentOrNull$kotlinx_coroutines_core != null) {
            nextEvent = currentOrNull$kotlinx_coroutines_core.processNextEvent();
        } else {
            nextEvent = Long.MAX_VALUE;
        }
        return nextEvent;
    }

    public static final long runSingleTaskFromCurrentSystemDispatcher() {
        final Thread currentThread = Thread.currentThread();
        if (!currentThread instanceof CoroutineScheduler.Worker) {
        } else {
            return (CoroutineScheduler.Worker)currentThread.runSingleTask();
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Expected CoroutineScheduler.Worker, but got ").append(currentThread).toString());
        throw illegalStateException;
    }
}
