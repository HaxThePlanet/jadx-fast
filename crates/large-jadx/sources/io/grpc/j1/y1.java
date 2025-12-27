package io.grpc.j1;

import com.google.common.base.q;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Rescheduler.java */
/* loaded from: classes3.dex */
final class y1 {

    private final ScheduledExecutorService a;
    private final Executor b;
    private final Runnable c;
    private final q d;
    private long e;
    private boolean f;
    private ScheduledFuture<?> g;

    static class a {
    }

    private final class b implements Runnable {

        final /* synthetic */ y1 a;
        private b() {
            this.a = y1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            ScheduledFuture schedule = null;
            if (!this.a.f) {
                this.a.g = schedule;
                return;
            }
            long l = this.a.j();
            long l4 = this.a.e - l;
            long l2 = 0L;
            if (l4 > l2) {
                l2 = this.a.e - l;
                this.a.g = this.a.a.schedule(new y1.c(y1Var9, schedule), l2, TimeUnit.NANOSECONDS);
            } else {
                this.a.f = false;
                this.a.g = schedule;
                this.a.c.run();
            }
        }

        /* synthetic */ b(y1.a aVar) {
            this(y1Var);
        }
    }

    private final class c implements Runnable {

        final /* synthetic */ y1 a;
        private c() {
            this.a = y1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b.execute(new y1.b(this.a, null));
        }

        /* synthetic */ c(y1.a aVar) {
            this(y1Var);
        }
    }
    y1(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, q qVar) {
        super();
        this.c = runnable;
        this.b = executor;
        this.a = scheduledExecutorService;
        this.d = qVar;
        qVar.g();
    }

    static /* synthetic */ Executor a(y1 y1Var) {
        return y1Var.b;
    }

    static /* synthetic */ boolean b(y1 y1Var) {
        return y1Var.f;
    }

    static /* synthetic */ boolean c(y1 y1Var, boolean z) {
        y1Var.f = z;
        return z;
    }

    static /* synthetic */ ScheduledFuture d(y1 y1Var, ScheduledFuture scheduledFuture) {
        y1Var.g = scheduledFuture;
        return scheduledFuture;
    }

    static /* synthetic */ long e(y1 y1Var) {
        return y1Var.j();
    }

    static /* synthetic */ long f(y1 y1Var) {
        return y1Var.e;
    }

    static /* synthetic */ ScheduledExecutorService g(y1 y1Var) {
        return y1Var.a;
    }

    static /* synthetic */ Runnable h(y1 y1Var) {
        return y1Var.c;
    }

    private long j() {
        return this.d.d(TimeUnit.NANOSECONDS);
    }

    void i(boolean z) {
        final boolean z2 = false;
        this.f = z2;
        if (this.g && this.g != null) {
            this.g.cancel(z2);
            ScheduledFuture scheduledFuture = null;
            this.g = scheduledFuture;
        }
    }

    void k(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        long l3 = j() + nanos;
        this.f = true;
        l = l3 - this.e;
        if (this.e < 0 || this.g == null) {
            if (this.g != null) {
                this.g.cancel(false);
            }
            this.g = this.a.schedule(new y1.c(this, null), nanos, TimeUnit.NANOSECONDS);
        }
        this.e = l3;
    }
}
