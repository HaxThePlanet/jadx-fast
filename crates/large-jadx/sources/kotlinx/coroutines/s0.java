package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.h0.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008À\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004J\u0008\u0010\u001b\u001a\u00020\u001cH\u0002J\u0008\u0010\u001d\u001a\u00020\u0010H\u0002J\r\u0010\u001e\u001a\u00020\u001cH\u0000¢\u0006\u0002\u0008\u001fJ$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00082\n\u0010#\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010$\u001a\u00020%H\u0016J\u0008\u0010&\u001a\u00020\u0014H\u0002J\u0008\u0010'\u001a\u00020\u001cH\u0016J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0008R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0011\u0010\u0004R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00108TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u0006*", d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutdownRequested", "", "()Z", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "run", "shutdown", "timeout", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s0 extends kotlinx.coroutines.j1 implements Runnable {

    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final kotlinx.coroutines.s0 y;
    private static final long z;
    static {
        Long long;
        s0 s0Var = new s0();
        s0.y = s0Var;
        final int i3 = 1;
        i1.e0(s0Var, false, i3, 0);
        long = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        s0.z = TimeUnit.MILLISECONDS.toNanos(long.longValue());
    }

    private final void l1() {
        synchronized (this) {
            try {
                s0.debugStatus = 3;
                V0();
                notifyAll();
                throw th;
            }
        }
    }

    private final Thread n1() {
        Thread _thread;
        int i;
        synchronized (this) {
            try {
                _thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                s0._thread = _thread;
                _thread.setDaemon(true);
                _thread.start();
                return _thread;
                throw th;
            }
        }
    }

    private final boolean o1() {
        int i2;
        int i;
        int debugStatus = s0.debugStatus;
        if (debugStatus != 2) {
            if (debugStatus == 3) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    private final boolean s1() {
        synchronized (this) {
            try {
                return 0;
                int i2 = 1;
                s0.debugStatus = i2;
                notifyAll();
                return i2;
                throw th;
            }
        }
    }

    @Override // kotlinx.coroutines.j1
    protected Thread m0() {
        Thread _thread;
        if (s0._thread == null) {
            _thread = n1();
        }
        return _thread;
    }

    @Override // kotlinx.coroutines.j1
    public void run() {
        long l2;
        long l;
        int cmp2;
        int cmp;
        int i;
        int i2;
        long nanoTime;
        u2.a.c(this);
        kotlinx.coroutines.d dVar = e.a();
        if (dVar == null) {
        } else {
            dVar.c();
        }
        int i3 = 0;
        if (!s1()) {
            s0._thread = i3;
            l1();
            kotlinx.coroutines.d dVar2 = e.a();
            if (dVar2 == null) {
            } else {
                dVar2.g();
            }
            if (!L0()) {
                m0();
            }
        }
        long l3 = Long.MAX_VALUE;
        l2 = l3;
        Thread.interrupted();
        l = N0();
        i = 0;
        while (Long.compare(l, l3) == 0) {
            kotlinx.coroutines.d dVar5 = e.a();
            if (dVar5 == null) {
            } else {
            }
            nanoTime = dVar5.a();
            if (Long.compare(l2, l3) == 0) {
            }
            i2 = l2 - nanoTime;
            l = g.f(l, obj6);
            Thread.interrupted();
            l = N0();
            i = 0;
            l2 = l3;
            cmp2 = e.a();
            if (cmp2 == null) {
            } else {
            }
            cmp2.b(this, l);
            LockSupport.parkNanos(this, l);
            l4 += nanoTime;
            nanoTime = System.nanoTime();
        }
        s0._thread = i3;
        l1();
        kotlinx.coroutines.d dVar3 = e.a();
        if (dVar3 == null) {
        } else {
            dVar3.g();
        }
        if (!L0()) {
            m0();
        }
    }

    @Override // kotlinx.coroutines.j1
    public kotlinx.coroutines.e1 x(long l, Runnable runnable2, g g3) {
        return e1(l, runnable2);
    }
}
