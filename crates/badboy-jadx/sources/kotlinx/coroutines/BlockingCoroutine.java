package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000c¨\u0006\u0013", d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BlockingCoroutine<T>  extends kotlinx.coroutines.AbstractCoroutine<T> {

    private final Thread blockedThread;
    private final kotlinx.coroutines.EventLoop eventLoop;
    public BlockingCoroutine(CoroutineContext parentContext, Thread blockedThread, kotlinx.coroutines.EventLoop eventLoop) {
        final int i = 1;
        super(parentContext, i, i);
        this.blockedThread = blockedThread;
        this.eventLoop = eventLoop;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void afterCompletion(Object state) {
        boolean blockedThread2;
        int blockedThread;
        if (!Intrinsics.areEqual(Thread.currentThread(), this.blockedThread)) {
            blockedThread2 = this.blockedThread;
            kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            blockedThread = timeSource != null ? Unit.INSTANCE : 0;
            if (blockedThread == 0) {
                LockSupport.unpark(blockedThread2);
            }
        }
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected boolean isScopedCoroutine() {
        return 1;
    }

    public final T joinBlocking() {
        kotlinx.coroutines.EventLoop eventLoop;
        int timeSource;
        int i;
        kotlinx.coroutines.EventLoop eventLoop2;
        kotlinx.coroutines.AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
        if (timeSource2 != null) {
            timeSource2.registerTimeLoopThread();
        }
        eventLoop = this.eventLoop;
        int i2 = 1;
        int i4 = 0;
        i = 0;
        if (eventLoop != null) {
            EventLoop.incrementUseCount$default(eventLoop, i4, i2, i);
        }
        while (!Thread.interrupted()) {
            kotlinx.coroutines.EventLoop eventLoop3 = this.eventLoop;
            if (eventLoop3 != null) {
            } else {
            }
            eventLoop2 = Long.MAX_VALUE;
            kotlinx.coroutines.AbstractTimeSource timeSource4 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource4 != null) {
            } else {
            }
            eventLoop = i;
            if (eventLoop == null) {
            }
            LockSupport.parkNanos(this, eventLoop2);
            timeSource4.parkNanos(this, eventLoop2);
            eventLoop = Unit.INSTANCE;
            eventLoop2 = eventLoop3.processNextEvent();
        }
        InterruptedException state = new InterruptedException();
        final int i5 = 0;
        cancelCoroutine((Throwable)state);
        throw (Throwable)state;
    }
}
