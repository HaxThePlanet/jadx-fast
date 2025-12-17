package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.w;
import kotlinx.coroutines.internal.e;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0008\u0010\u000e\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\t0\u001fH\u0016J\u0008\u0010 \u001a\u00020!H\u0016J.\u0010\"\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010#*\u00020$2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006%", d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "cancelJobOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "Ljava/util/concurrent/RejectedExecutionException;", "close", "dispatch", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p1 extends kotlinx.coroutines.o1 implements kotlinx.coroutines.w0 {

    private final Executor b;
    public p1(Executor executor) {
        super();
        this.b = executor;
        e.a(T());
    }

    private final void M(g g, RejectedExecutionException rejectedExecutionException2) {
        b2.c(g, n1.a("The task was rejected", rejectedExecutionException2));
    }

    private final ScheduledFuture<?> U(ScheduledExecutorService scheduledExecutorService, Runnable runnable2, g g3, long l4) {
        ScheduledFuture obj2;
        try {
            obj2 = scheduledExecutorService.schedule(runnable2, l4, obj6);
            M(g3, scheduledExecutorService);
            scheduledExecutorService = null;
            return obj2;
        }
    }

    @Override // kotlinx.coroutines.o1
    public void K(g g, Runnable runnable2) {
        Executor executor;
        Runnable runnable;
        try {
            kotlinx.coroutines.d dVar2 = e.a();
            if (dVar2 == null) {
            } else {
            }
            runnable = runnable2;
            runnable = dVar2.h(runnable2);
            T().execute(runnable);
            kotlinx.coroutines.d dVar = e.a();
            if (dVar == null) {
            } else {
            }
            dVar.e();
            M(g, th);
            Throwable th = c1.b();
            th.K(g, runnable2);
        }
    }

    @Override // kotlinx.coroutines.o1
    public Executor T() {
        return this.b;
    }

    @Override // kotlinx.coroutines.o1
    public void close() {
        Executor executor;
        if (executor instanceof ExecutorService != null) {
        } else {
            executor = 0;
        }
        if (executor == null) {
        } else {
            executor.shutdown();
        }
    }

    @Override // kotlinx.coroutines.o1
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof p1 && (p1)object.T() == T()) {
            obj2 = (p1)object.T() == T() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlinx.coroutines.o1
    public int hashCode() {
        return System.identityHashCode(T());
    }

    public void j(long l, kotlinx.coroutines.p<? super w> p2) {
        ScheduledFuture i;
        kotlinx.coroutines.h0 h0Var;
        int i2;
        kotlinx.coroutines.p2 p2Var;
        g context;
        long l2;
        Executor executor = T();
        i2 = executor instanceof ScheduledExecutorService != null ? executor : i;
        if (i2 == 0) {
        } else {
            p2Var = new p2(this, obj12);
            i = this.U(i2, p2Var, obj12.getContext(), l);
        }
        if (i != null) {
            b2.e(obj12, i);
        }
        s0.y.j(l, p2);
    }

    @Override // kotlinx.coroutines.o1
    public String toString() {
        return T().toString();
    }

    @Override // kotlinx.coroutines.o1
    public kotlinx.coroutines.e1 x(long l, Runnable runnable2, g g3) {
        Object executor;
        ScheduledFuture i;
        Object obj;
        int i2;
        Runnable runnable;
        g gVar;
        long l2;
        kotlinx.coroutines.e1 obj10;
        executor = T();
        i2 = executor instanceof ScheduledExecutorService != null ? executor : i;
        if (i2 == 0) {
        } else {
            i = this.U(i2, g3, obj13, l);
        }
        if (i != null) {
            obj10 = new d1(i);
        } else {
            obj10 = s0.y.x(l, runnable2, g3);
        }
        return obj10;
    }
}
