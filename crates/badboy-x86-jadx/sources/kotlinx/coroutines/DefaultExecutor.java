package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008À\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004J\u0008\u0010\u001d\u001a\u00020\u001eH\u0002J\u0008\u0010\u001f\u001a\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u001e2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\r\u0010\"\u001a\u00020\u001eH\u0000¢\u0006\u0002\u0008#J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00082\n\u0010'\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010(\u001a\u00020)H\u0016J\u0008\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u00082\u0006\u0010-\u001a\u00020.H\u0014J\u0008\u0010/\u001a\u00020\u001eH\u0016J\u0008\u00100\u001a\u00020\u001eH\u0016J\u0008\u00101\u001a\u00020\u001eH\u0002J\u000e\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u0008R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0012\u0010\u0004R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001c¨\u00064", d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE_MS", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutDown", "", "()Z", "isShutdownRequested", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "enqueue", "task", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "run", "shutdown", "shutdownError", "shutdownForTests", "timeout", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultExecutor extends kotlinx.coroutines.EventLoopImplBase implements Runnable {

    private static final int ACTIVE = 1;
    private static final long DEFAULT_KEEP_ALIVE_MS = 1000L;
    private static final int FRESH = 0;
    public static final kotlinx.coroutines.DefaultExecutor INSTANCE = null;
    private static final long KEEP_ALIVE_NANOS = 0L;
    private static final int SHUTDOWN = 4;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN_REQ = 2;
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    static {
        Long long;
        String str;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        DefaultExecutor.INSTANCE = defaultExecutor;
        final int i3 = 0;
        EventLoop.incrementUseCount$default((EventLoop)DefaultExecutor.INSTANCE, false, 1, i3);
        long = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        DefaultExecutor.KEEP_ALIVE_NANOS = TimeUnit.MILLISECONDS.toNanos(long.longValue());
    }

    private final void acknowledgeShutdownIfNeeded() {
        synchronized (this) {
            try {
                DefaultExecutor.debugStatus = 3;
                resetAll();
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                (Object)this.notifyAll();
                throw th;
            }
        }
    }

    private final Thread createThreadSync() {
        Thread _thread;
        Thread thread;
        int i;
        int i2;
        synchronized (this) {
            try {
                _thread = new Thread((Runnable)this, "kotlinx.coroutines.DefaultExecutor");
                thread = _thread;
                i = 0;
                DefaultExecutor._thread = thread;
                thread.setDaemon(true);
                thread.start();
                return _thread;
                throw th;
            }
        }
    }

    private static void get_thread$annotations() {
    }

    private final boolean isShutDown() {
        int i;
        i = DefaultExecutor.debugStatus == 4 ? 1 : 0;
        return i;
    }

    private final boolean isShutdownRequested() {
        int i2;
        int i;
        final int debugStatus = DefaultExecutor.debugStatus;
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

    private final boolean notifyStartup() {
        synchronized (this) {
            try {
                return 0;
                int i2 = 1;
                DefaultExecutor.debugStatus = i2;
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                (Object)this.notifyAll();
                return i2;
                throw th;
            }
        }
    }

    private final void shutdownError() {
        RejectedExecutionException rejectedExecutionException = new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        throw rejectedExecutionException;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void enqueue(Runnable task) {
        if (isShutDown()) {
            shutdownError();
        }
        super.enqueue(task);
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public final void ensureStarted$kotlinx_coroutines_core() {
        int aSSERTIONS_ENABLED;
        boolean aSSERTIONS_ENABLED2;
        int i2;
        Thread debugStatus;
        int i;
        final int i4 = 0;
        synchronized (this) {
            try {
                int i3 = 0;
                if (DefaultExecutor._thread == null) {
                } else {
                }
                aSSERTIONS_ENABLED = i2;
                aSSERTIONS_ENABLED = i4;
                if (aSSERTIONS_ENABLED == 0) {
                } else {
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
                aSSERTIONS_ENABLED2 = 0;
                if (DebugKt.getASSERTIONS_ENABLED() && DefaultExecutor.debugStatus != 0) {
                }
                aSSERTIONS_ENABLED2 = 0;
                if (DefaultExecutor.debugStatus != 0) {
                }
                if (DefaultExecutor.debugStatus == 3) {
                } else {
                }
                i2 = i4;
                if (i2 == 0) {
                } else {
                }
                AssertionError assertionError2 = new AssertionError();
                throw assertionError2;
                DefaultExecutor.debugStatus = i4;
                createThreadSync();
                while (DefaultExecutor.debugStatus == 0) {
                    Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                    (Object)this.wait();
                }
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                (Object)this.wait();
                throw th;
            }
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    protected Thread getThread() {
        Thread threadSync;
        if (DefaultExecutor._thread == null) {
            threadSync = createThreadSync();
        }
        return threadSync;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        return scheduleInvokeOnTimeout(timeMillis, block);
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        int i;
        i = DefaultExecutor._thread != null ? 1 : 0;
        return i;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    protected void reschedule(long now, kotlinx.coroutines.EventLoopImplBase.DelayedTask delayedTask) {
        shutdownError();
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void run() {
        long shutdownNanos2;
        kotlinx.coroutines.AbstractTimeSource empty;
        boolean parkNanos;
        int iNSTANCE;
        int l;
        int kEEP_ALIVE_NANOS;
        int cmp;
        int i;
        long nanoTime;
        long coerceAtMost;
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core((EventLoop)this);
        kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        shutdownNanos2 = Long.MAX_VALUE;
        int i2 = 0;
        DefaultExecutor._thread = i2;
        acknowledgeShutdownIfNeeded();
        kotlinx.coroutines.AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
        if (!notifyStartup() && timeSource2 != null) {
            DefaultExecutor._thread = i2;
            acknowledgeShutdownIfNeeded();
            timeSource2 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource2 != null) {
                timeSource2.unregisterTimeLoopThread();
            }
            if (!isEmpty()) {
                getThread();
            }
        }
        Thread.interrupted();
        parkNanos = processNextEvent();
        l = Long.MAX_VALUE;
        i = 0;
        while (Long.compare(parkNanos, l) == 0) {
            kotlinx.coroutines.AbstractTimeSource timeSource6 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource6 != null) {
            } else {
            }
            nanoTime = System.nanoTime();
            if (Long.compare(shutdownNanos2, l) == 0) {
            }
            l = shutdownNanos2 - nanoTime;
            parkNanos = coerceAtMost;
            Thread.interrupted();
            parkNanos = processNextEvent();
            l = Long.MAX_VALUE;
            i = 0;
            shutdownNanos2 = Long.MAX_VALUE;
            kotlinx.coroutines.AbstractTimeSource timeSource5 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource5 != null) {
            } else {
            }
            iNSTANCE = i2;
            if (iNSTANCE == null) {
            }
            LockSupport.parkNanos(this, parkNanos);
            timeSource5.parkNanos(this, parkNanos);
            iNSTANCE = Unit.INSTANCE;
            shutdownNanos2 = nanoTime + kEEP_ALIVE_NANOS;
            nanoTime = timeSource6.nanoTime();
        }
        DefaultExecutor._thread = i2;
        acknowledgeShutdownIfNeeded();
        kotlinx.coroutines.AbstractTimeSource timeSource4 = AbstractTimeSourceKt.getTimeSource();
        if (timeSource4 != null) {
            timeSource4.unregisterTimeLoopThread();
        }
        if (!isEmpty()) {
            getThread();
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void shutdown() {
        DefaultExecutor.debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public final void shutdownForTests(long timeout) {
        boolean shutdownRequested;
        int i;
        Object iNSTANCE;
        synchronized (this) {
            try {
                DefaultExecutor.debugStatus = 2;
                while (DefaultExecutor.debugStatus != 3) {
                    if (DefaultExecutor._thread != null) {
                    }
                    Thread _thread = DefaultExecutor._thread;
                    if (_thread != null) {
                    }
                    if (Long.compare(shutdownRequested, i4) > 0) {
                    }
                    Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                    (Object)this.wait(timeout);
                    i = 0;
                    kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource != null) {
                    } else {
                    }
                    iNSTANCE = 0;
                    if (iNSTANCE == null) {
                    }
                    LockSupport.unpark(_thread);
                    timeSource.unpark(_thread);
                    iNSTANCE = Unit.INSTANCE;
                }
                if (DefaultExecutor._thread != null) {
                }
                _thread = DefaultExecutor._thread;
                if (_thread != null) {
                }
                i = 0;
                timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource != null) {
                } else {
                }
                timeSource.unpark(_thread);
                iNSTANCE = Unit.INSTANCE;
                iNSTANCE = 0;
                if (iNSTANCE == null) {
                }
                LockSupport.unpark(_thread);
                if (Long.compare(shutdownRequested, i4) > 0) {
                }
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                (Object)this.wait(timeout);
                DefaultExecutor.debugStatus = 0;
                throw timeout;
            }
        }
    }
}
