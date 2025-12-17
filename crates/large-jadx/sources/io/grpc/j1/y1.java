package io.grpc.j1;

import com.google.common.base.q;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

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

        final io.grpc.j1.y1 a;
        private b(io.grpc.j1.y1 y1) {
            this.a = y1;
            super();
        }

        b(io.grpc.j1.y1 y1, io.grpc.j1.y1.a y1$a2) {
            super(y1);
        }

        @Override // java.lang.Runnable
        public void run() {
            Object y1Var;
            ScheduledFuture schedule;
            long l;
            ScheduledExecutorService i;
            io.grpc.j1.y1.c cVar;
            int i2;
            schedule = 0;
            if (!y1.b(this.a)) {
                y1.d(this.a, schedule);
            }
            l = y1.e(this.a);
            if (Long.compare(i, i2) > 0) {
                y1Var = this.a;
                io.grpc.j1.y1 y1Var9 = this.a;
                cVar = new y1.c(y1Var9, schedule);
                y1.d(y1Var, y1.g(y1Var).schedule(cVar, l3 -= l, obj7));
            } else {
                y1.c(this.a, false);
                y1.d(this.a, schedule);
                y1.h(this.a).run();
            }
        }
    }

    private final class c implements Runnable {

        final io.grpc.j1.y1 a;
        private c(io.grpc.j1.y1 y1) {
            this.a = y1;
            super();
        }

        c(io.grpc.j1.y1 y1, io.grpc.j1.y1.a y1$a2) {
            super(y1);
        }

        @Override // java.lang.Runnable
        public void run() {
            y1.b bVar = new y1.b(this.a, 0);
            y1.a(this.a).execute(bVar);
        }
    }
    y1(Runnable runnable, Executor executor2, ScheduledExecutorService scheduledExecutorService3, q q4) {
        super();
        this.c = runnable;
        this.b = executor2;
        this.a = scheduledExecutorService3;
        this.d = q4;
        q4.g();
    }

    static Executor a(io.grpc.j1.y1 y1) {
        return y1.b;
    }

    static boolean b(io.grpc.j1.y1 y1) {
        return y1.f;
    }

    static boolean c(io.grpc.j1.y1 y1, boolean z2) {
        y1.f = z2;
        return z2;
    }

    static ScheduledFuture d(io.grpc.j1.y1 y1, ScheduledFuture scheduledFuture2) {
        y1.g = scheduledFuture2;
        return scheduledFuture2;
    }

    static long e(io.grpc.j1.y1 y1) {
        return y1.j();
    }

    static long f(io.grpc.j1.y1 y1) {
        return y1.e;
    }

    static ScheduledExecutorService g(io.grpc.j1.y1 y1) {
        return y1.a;
    }

    static Runnable h(io.grpc.j1.y1 y1) {
        return y1.c;
    }

    private long j() {
        return this.d.d(TimeUnit.NANOSECONDS);
    }

    void i(boolean z) {
        ScheduledFuture obj2;
        final int i = 0;
        this.f = i;
        obj2 = this.g;
        if (z != null && obj2 != null) {
            obj2 = this.g;
            if (obj2 != null) {
                obj2.cancel(i);
                this.g = 0;
            }
        }
    }

    void k(long l, TimeUnit timeUnit2) {
        int cVar;
        TimeUnit nANOSECONDS;
        long obj7;
        Object obj9;
        obj7 = obj9.toNanos(l);
        l2 += obj7;
        this.f = true;
        if (Long.compare(cVar, i3) >= 0) {
            obj9 = this.g;
            if (this.g == null && obj9 != null) {
                obj9 = this.g;
                if (obj9 != null) {
                    obj9.cancel(false);
                }
                cVar = new y1.c(this, 0);
                this.g = this.a.schedule(cVar, obj7, timeUnit2);
            }
        } else {
        }
        this.e = i;
    }
}
