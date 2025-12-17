package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.base.q;
import com.google.common.util.concurrent.d;
import io.grpc.d1;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class c1 {

    private static final long l;
    private final ScheduledExecutorService a;
    private final q b;
    private final io.grpc.j1.c1.d c;
    private final boolean d;
    private io.grpc.j1.c1.e e;
    private ScheduledFuture<?> f;
    private ScheduledFuture<?> g;
    private final Runnable h;
    private final Runnable i;
    private final long j;
    private final long k;

    class a implements Runnable {

        final io.grpc.j1.c1 a;
        a(io.grpc.j1.c1 c1) {
            this.a = c1;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object c1Var;
            int i;
            c1Var = this.a;
            final io.grpc.j1.c1.e dISCONNECTED = c1.e.DISCONNECTED;
            synchronized (c1Var) {
                c1.b(this.a, dISCONNECTED);
                i = 1;
                try {
                    if (i != 0) {
                    }
                    c1.c(this.a).a();
                    throw th;
                }
            }
        }
    }

    class b implements Runnable {

        final io.grpc.j1.c1 a;
        b(io.grpc.j1.c1 c1) {
            this.a = c1;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object c1Var;
            Object eVar;
            int i2;
            Object pING_SCHEDULED;
            Object pING_DELAYED;
            Runnable runnable;
            int i;
            q nANOSECONDS2;
            TimeUnit nANOSECONDS;
            long l;
            c1Var = this.a;
            c1.d(this.a, 0);
            pING_SCHEDULED = c1.e.PING_SCHEDULED;
            synchronized (c1Var) {
                i2 = 1;
                c1.b(this.a, c1.e.PING_SENT);
                pING_SCHEDULED = this.a;
                c1.e(pING_SCHEDULED, c1.h(pING_SCHEDULED).schedule(c1.f(this.a), c1.g(this.a), obj6));
                if (i2 != 0) {
                }
            }
            c1.c(this.a).b();
        }
    }

    public interface d {
        public abstract void a();

        public abstract void b();
    }

    private static enum e {

        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED;
    }

    public static final class c implements io.grpc.j1.c1.d {

        private final io.grpc.j1.v a;
        public c(io.grpc.j1.v v) {
            super();
            this.a = v;
        }

        static io.grpc.j1.v c(io.grpc.j1.c1.c c1$c) {
            return c.a;
        }

        @Override // io.grpc.j1.c1$d
        public void a() {
            this.a.d(d1.n.r("Keepalive failed. The connection is likely gone"));
        }

        @Override // io.grpc.j1.c1$d
        public void b() {
            c1.c.a aVar = new c1.c.a(this);
            this.a.g(aVar, d.a());
        }
    }
    static {
        final int i = 10;
        c1.l = TimeUnit.SECONDS.toNanos(i);
        TimeUnit.MILLISECONDS.toNanos(i);
    }

    public c1(io.grpc.j1.c1.d c1$d, ScheduledExecutorService scheduledExecutorService2, long l3, long l4, boolean z5) {
        super(d, scheduledExecutorService2, q.c(), l3, obj5, z5, obj7, obj16);
    }

    c1(io.grpc.j1.c1.d c1$d, ScheduledExecutorService scheduledExecutorService2, q q3, long l4, long l5, boolean z6) {
        super();
        this.e = c1.e.IDLE;
        c1.a aVar = new c1.a(this);
        d1 d1Var = new d1(aVar);
        this.h = d1Var;
        c1.b bVar = new c1.b(this);
        d1 d1Var2 = new d1(bVar);
        this.i = d1Var2;
        n.p(d, "keepAlivePinger");
        this.c = (c1.d)d;
        n.p(scheduledExecutorService2, "scheduler");
        this.a = (ScheduledExecutorService)scheduledExecutorService2;
        n.p(q3, "stopwatch");
        this.b = (q)q3;
        this.j = l4;
        this.k = z6;
        this.d = obj10;
        q3.f();
        q3.g();
    }

    static io.grpc.j1.c1.e a(io.grpc.j1.c1 c1) {
        return c1.e;
    }

    static io.grpc.j1.c1.e b(io.grpc.j1.c1 c1, io.grpc.j1.c1.e c1$e2) {
        c1.e = e2;
        return e2;
    }

    static io.grpc.j1.c1.d c(io.grpc.j1.c1 c1) {
        return c1.c;
    }

    static ScheduledFuture d(io.grpc.j1.c1 c1, ScheduledFuture scheduledFuture2) {
        c1.g = scheduledFuture2;
        return scheduledFuture2;
    }

    static ScheduledFuture e(io.grpc.j1.c1 c1, ScheduledFuture scheduledFuture2) {
        c1.f = scheduledFuture2;
        return scheduledFuture2;
    }

    static Runnable f(io.grpc.j1.c1 c1) {
        return c1.h;
    }

    static long g(io.grpc.j1.c1 c1) {
        return c1.k;
    }

    static ScheduledExecutorService h(io.grpc.j1.c1 c1) {
        return c1.a;
    }

    static Runnable i(io.grpc.j1.c1 c1) {
        return c1.i;
    }

    static long j(io.grpc.j1.c1 c1) {
        return c1.j;
    }

    static q k(io.grpc.j1.c1 c1) {
        return c1.b;
    }

    public static long l(long l) {
        return Math.max(l, obj3);
    }

    public void m() {
        Object pING_DELAYED;
        Object pING_SCHEDULED;
        io.grpc.j1.c1.e iDLE_AND_PING_SENT;
        int i;
        io.grpc.j1.c1.e iDLE_AND_PING_SENT2;
        TimeUnit nANOSECONDS;
        q qVar = this.b;
        qVar.f();
        qVar.g();
        pING_DELAYED = this.e;
        pING_SCHEDULED = c1.e.PING_SCHEDULED;
        synchronized (this) {
            try {
                this.e = c1.e.PING_DELAYED;
                if (pING_DELAYED != c1.e.PING_SENT) {
                } else {
                }
                ScheduledFuture future = this.f;
                if (pING_DELAYED == c1.e.IDLE_AND_PING_SENT && future != null) {
                }
                future = this.f;
                if (future != null) {
                }
                future.cancel(false);
                iDLE_AND_PING_SENT2 = c1.e.IDLE_AND_PING_SENT;
                if (this.e == iDLE_AND_PING_SENT2) {
                }
                this.e = c1.e.IDLE;
                this.e = pING_SCHEDULED;
                if (this.g == null) {
                }
                i = 1;
                n.v(i, "There should be no outstanding pingFuture");
                this.g = this.a.schedule(this.i, this.j, iDLE_AND_PING_SENT2);
                throw th;
            }
        }
    }

    public void n() {
        Object pING_SENT;
        Object iDLE_AND_PING_SENT;
        int i;
        q qVar;
        TimeUnit nANOSECONDS;
        long l;
        pING_SENT = this.e;
        synchronized (this) {
            try {
                this.e = c1.e.PING_SCHEDULED;
                if (this.g == null) {
                }
                nANOSECONDS = TimeUnit.NANOSECONDS;
                this.g = this.a.schedule(this.i, l2 -= l, obj3);
                if (pING_SENT == c1.e.IDLE_AND_PING_SENT) {
                }
                this.e = c1.e.PING_SENT;
                throw th;
            }
        }
    }

    public void o() {
        io.grpc.j1.c1.e iDLE;
        io.grpc.j1.c1.e iDLE_AND_PING_SENT;
        io.grpc.j1.c1.e pING_SCHEDULED;
        synchronized (this) {
            try {
                iDLE = this.e;
            }
            if (iDLE == c1.e.PING_DELAYED) {
                this.e = c1.e.IDLE;
            }
            if (this.e == c1.e.PING_SENT) {
                this.e = c1.e.IDLE_AND_PING_SENT;
            }
            try {
                throw th;
            }
        }
    }

    public void p() {
        synchronized (this) {
            try {
                n();
                throw th;
            }
        }
    }

    public void q() {
        io.grpc.j1.c1.e eVar;
        io.grpc.j1.c1.e dISCONNECTED;
        dISCONNECTED = c1.e.DISCONNECTED;
        synchronized (this) {
            try {
                this.e = dISCONNECTED;
                ScheduledFuture future = this.f;
                dISCONNECTED = 0;
                if (future != null) {
                }
                future.cancel(dISCONNECTED);
                eVar = this.g;
                if (eVar != null) {
                }
                eVar.cancel(dISCONNECTED);
                this.g = 0;
                throw th;
            }
        }
    }
}
