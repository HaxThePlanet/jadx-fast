package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008 \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0004J\u0008\u0010\r\u001a\u00020\u0008H\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class k1 extends kotlinx.coroutines.i1 {
    @Override // kotlinx.coroutines.i1
    protected abstract Thread m0();

    @Override // kotlinx.coroutines.i1
    protected final void t0(long l, kotlinx.coroutines.j1.c j1$c2) {
        boolean z;
        if (q0.a()) {
            z = this != s0.y ? 1 : 0;
            if (z == 0) {
            } else {
            }
            AssertionError obj2 = new AssertionError();
            throw obj2;
        }
        s0.y.a1(l, c2);
    }

    @Override // kotlinx.coroutines.i1
    protected final void v0() {
        Object currentThread;
        final Thread thread = m0();
        if (Thread.currentThread() != thread) {
            currentThread = e.a();
            if (currentThread == null) {
                LockSupport.unpark(thread);
            } else {
                currentThread.f(thread);
            }
        }
    }
}
