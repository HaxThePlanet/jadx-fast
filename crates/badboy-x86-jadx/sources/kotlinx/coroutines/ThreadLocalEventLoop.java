package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadLocalKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\u0008\u000bJ\r\u0010\u000c\u001a\u00020\rH\u0000¢\u0006\u0002\u0008\u000eJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\u0010R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0008j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThreadLocalEventLoop {

    public static final kotlinx.coroutines.ThreadLocalEventLoop INSTANCE;
    private static final java.lang.ThreadLocal<kotlinx.coroutines.EventLoop> ref;
    static {
        ThreadLocalEventLoop threadLocalEventLoop = new ThreadLocalEventLoop();
        ThreadLocalEventLoop.INSTANCE = threadLocalEventLoop;
        Symbol symbol = new Symbol("ThreadLocalEventLoop");
        ThreadLocalEventLoop.ref = ThreadLocalKt.commonThreadLocal(symbol);
    }

    public final kotlinx.coroutines.EventLoop currentOrNull$kotlinx_coroutines_core() {
        return (EventLoop)ThreadLocalEventLoop.ref.get();
    }

    public final kotlinx.coroutines.EventLoop getEventLoop$kotlinx_coroutines_core() {
        Object eventLoop;
        kotlinx.coroutines.EventLoop eventLoop2;
        int i;
        java.lang.ThreadLocal ref;
        if ((EventLoop)ThreadLocalEventLoop.ref.get() == null) {
            i = 0;
            ThreadLocalEventLoop.ref.set(EventLoopKt.createEventLoop());
        }
        return eventLoop;
    }

    public final void resetEventLoop$kotlinx_coroutines_core() {
        ThreadLocalEventLoop.ref.set(0);
    }

    public final void setEventLoop$kotlinx_coroutines_core(kotlinx.coroutines.EventLoop eventLoop) {
        ThreadLocalEventLoop.ref.set(eventLoop);
    }
}
