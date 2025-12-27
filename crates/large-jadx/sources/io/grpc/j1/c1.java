package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.base.q;
import com.google.common.util.concurrent.d;
import io.grpc.d1;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: KeepAliveManager.java */
/* loaded from: classes3.dex */
public class c1 {

    private static final long l = 0L;
    private final ScheduledExecutorService a;
    private final q b;
    private final c1.d c;
    private final boolean d;
    private c1.e e;
    private ScheduledFuture<?> f;
    private ScheduledFuture<?> g;
    private final Runnable h;
    private final Runnable i;
    private final long j;
    private final long k;

    class a implements Runnable {

        final /* synthetic */ c1 a;
        a() {
            this.a = c1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            synchronized (c1Var) {
                try {
                    final io.grpc.j1.c1.e dISCONNECTED2 = c1.e.DISCONNECTED;
                    if (this.a.e != c1.e.DISCONNECTED) {
                        this.a.e = c1.e.DISCONNECTED;
                        i = 1;
                    } else {
                        i = 0;
                    }
                } catch (Throwable th) {
                }
            }
            if (this.a != 0) {
                this.a.c.a();
            }
        }
    }

    class b implements Runnable {

        final /* synthetic */ c1 a;
        b() {
            this.a = c1Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            io.grpc.j1.c1.e pING_DELAYED2;
            Runnable runnable;
            long l;
            q qVar;
            TimeUnit nANOSECONDS2;
            long l2;
            synchronized (c1Var) {
                try {
                    this.a.g = 0;
                    pING_SCHEDULED2 = c1.e.PING_SCHEDULED;
                    if (this.a.e == c1.e.PING_SCHEDULED) {
                        i = 1;
                        this.a.e = c1.e.PING_SENT;
                        this.a.f = this.a.a.schedule(this.a.h, this.a.k, TimeUnit.NANOSECONDS);
                    } else {
                        if (this.a.e == c1.e.PING_DELAYED) {
                            nANOSECONDS2 = TimeUnit.NANOSECONDS;
                            l = this.a.j - this.a.b.d(nANOSECONDS2);
                            this.a.g = this.a.a.schedule(this.a.i, l, nANOSECONDS2);
                            this.a.e = c1.e.PING_SCHEDULED;
                        }
                        i = 0;
                    }
                } catch (Throwable th) {
                }
            }
            if (this.a != 0) {
                this.a.c.b();
            }
        }
    }

    public interface d {
        void a();

        void b();
    }

    private enum e {

        DISCONNECTED,
        IDLE,
        IDLE_AND_PING_SENT,
        PING_DELAYED,
        PING_SCHEDULED,
        PING_SENT;
    }

    public static final class c implements c1.d {

        private final v a;
        public c(v vVar) {
            super();
            this.a = vVar;
        }

        static /* synthetic */ v c(c1.c cVar) {
            return cVar.a;
        }

        public void a() {
            this.a.d(d1.n.r("Keepalive failed. The connection is likely gone"));
        }

        public void b() {
            this.a.g(new c1.c.a(this), d.a());
        }
    }
    static {
        final long l = 10L;
        c1.l = TimeUnit.SECONDS.toNanos(l);
        TimeUnit.MILLISECONDS.toNanos(l);
    }

    public c1(c1.d dVar, ScheduledExecutorService scheduledExecutorService, long j, long j2, boolean z) {
        this(dVar, scheduledExecutorService, q.c(), j, l, j2, obj, z);
    }

    static /* synthetic */ c1.e a(c1 c1Var) {
        return c1Var.e;
    }

    static /* synthetic */ c1.e b(c1 c1Var, c1.e eVar) {
        c1Var.e = eVar;
        return eVar;
    }

    static /* synthetic */ c1.d c(c1 c1Var) {
        return c1Var.c;
    }

    static /* synthetic */ ScheduledFuture d(c1 c1Var, ScheduledFuture scheduledFuture) {
        c1Var.g = scheduledFuture;
        return scheduledFuture;
    }

    static /* synthetic */ ScheduledFuture e(c1 c1Var, ScheduledFuture scheduledFuture) {
        c1Var.f = scheduledFuture;
        return scheduledFuture;
    }

    static /* synthetic */ Runnable f(c1 c1Var) {
        return c1Var.h;
    }

    static /* synthetic */ long g(c1 c1Var) {
        return c1Var.k;
    }

    static /* synthetic */ ScheduledExecutorService h(c1 c1Var) {
        return c1Var.a;
    }

    static /* synthetic */ Runnable i(c1 c1Var) {
        return c1Var.i;
    }

    static /* synthetic */ long j(c1 c1Var) {
        return c1Var.j;
    }

    static /* synthetic */ q k(c1 c1Var) {
        return c1Var.b;
    }

    public static long l(long j) {
        return Math.max(j, c1.l);
    }

    public synchronized void m() {
        boolean z = false;
        this.b.f();
        this.b.g();
        io.grpc.j1.c1.e pING_SCHEDULED2 = c1.e.PING_SCHEDULED;
        this.e = c1.e.PING_DELAYED;
        z = false;
        if (this.f != null) {
            this.f.cancel(false);
        }
        iDLE_AND_PING_SENT2 = c1.e.IDLE_AND_PING_SENT;
        this.e = c1.e.IDLE;
    }

    public synchronized void n() {
        if (this.e == c1.e.IDLE) {
            this.e = c1.e.PING_SCHEDULED;
            if (this.g == null) {
                nANOSECONDS2 = TimeUnit.NANOSECONDS;
                l = this.j - this.b.d(nANOSECONDS2);
                this.g = this.a.schedule(this.i, l, nANOSECONDS2);
            }
        } else {
            if (this.e == c1.e.IDLE_AND_PING_SENT) {
                this.e = c1.e.PING_SENT;
            }
        }
    }

    public synchronized void o() {
        io.grpc.j1.c1.e pING_SCHEDULED2;
        if (this.d) {
            return;
        }
        if (this.e == c1.e.PING_SCHEDULED || this.e == c1.e.PING_DELAYED) {
            this.e = c1.e.IDLE;
        }
        if (this.e == c1.e.PING_SENT) {
            this.e = c1.e.IDLE_AND_PING_SENT;
        }
    }

    public synchronized void p() {
        if (this.d) {
            n();
        }
    }

    public synchronized void q() {
        dISCONNECTED2 = c1.e.DISCONNECTED;
        this.e = dISCONNECTED2;
        boolean z = false;
        if (this.f != null) {
            this.f.cancel(z);
        }
        if (this.g != null) {
            this.g.cancel(z);
            this.g = null;
        }
    }

    c1(c1.d dVar, ScheduledExecutorService scheduledExecutorService, q qVar, long j, long j2, boolean z) {
        super();
        this.e = c1.e.IDLE;
        this.h = new d1(new c1.a(this));
        this.i = new d1(new c1.b(this));
        n.p(dVar, "keepAlivePinger");
        this.c = dVar;
        n.p(scheduledExecutorService, "scheduler");
        this.a = scheduledExecutorService;
        n.p(qVar, "stopwatch");
        this.b = (q)qVar;
        this.j = j;
        this.k = j2;
        this.d = z;
        qVar.f();
        qVar.g();
    }
}
