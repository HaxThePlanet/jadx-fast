package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008 \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0014J\u0008\u0010\r\u001a\u00020\u0008H\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class EventLoopImplPlatform extends kotlinx.coroutines.EventLoop {
    @Override // kotlinx.coroutines.EventLoop
    protected abstract Thread getThread();

    @Override // kotlinx.coroutines.EventLoop
    protected void reschedule(long now, kotlinx.coroutines.EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(now, delayedTask);
    }

    @Override // kotlinx.coroutines.EventLoop
    protected final void unpark() {
        int currentThread;
        final Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            currentThread = timeSource != null ? Unit.INSTANCE : 0;
            if (currentThread == 0) {
                LockSupport.unpark(thread);
            }
        }
    }
}
