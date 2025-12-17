package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import com.google.common.util.concurrent.d;
import i.a.c;
import i.a.d;
import io.grpc.a;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.d1.b;
import io.grpc.f0;
import io.grpc.g0;
import io.grpc.h;
import io.grpc.h.a;
import io.grpc.m.b;
import io.grpc.o;
import io.grpc.p;
import io.grpc.s;
import io.grpc.s.b;
import io.grpc.t;
import io.grpc.t0;
import io.grpc.u;
import io.grpc.u0;
import io.grpc.u0.d;
import io.grpc.w;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
final class p<ReqT, RespT>  extends h<ReqT, RespT> {

    private static final Logger t;
    private static final byte[] u;
    private final u0<ReqT, RespT> a;
    private final d b;
    private final Executor c;
    private final boolean d;
    private final io.grpc.j1.m e;
    private final s f;
    private volatile ScheduledFuture<?> g;
    private final boolean h = false;
    private d i;
    private io.grpc.j1.q j;
    private volatile boolean k;
    private boolean l;
    private boolean m;
    private final io.grpc.j1.p.e n;
    private final io.grpc.j1.p.f<ReqT, RespT> o;
    private final ScheduledExecutorService p;
    private boolean q;
    private w r;
    private p s;

    static class a {
    }

    interface e {
        public abstract io.grpc.j1.q a(u0<?, ?> u0, d d2, t0 t03, s s4);
    }

    private class g implements Runnable {

        private final long a;
        final io.grpc.j1.p b;
        g(io.grpc.j1.p p, long l2) {
            this.b = p;
            super();
            this.a = l2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int cmp;
            x0 x0Var = new x0();
            p.a(this.b).j(x0Var);
            TimeUnit sECONDS = TimeUnit.SECONDS;
            int i3 = 1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("deadline exceeded after ");
            if (Long.compare(l3, i6) < 0) {
                stringBuilder.append('-');
            }
            stringBuilder.append(l2 /= nanos2);
            Object[] arr = new Object[1];
            stringBuilder.append(String.format(Locale.US, ".%09d", Long.valueOf(l5 %= nanos)));
            stringBuilder.append("s. ");
            stringBuilder.append(x0Var);
            p.a(this.b).c(d1.i.f(stringBuilder.toString()));
        }
    }

    class b extends io.grpc.j1.x {

        final h.a b;
        final io.grpc.j1.p c;
        b(io.grpc.j1.p p, h.a h$a2) {
            this.c = p;
            this.b = a2;
            super(p.f(p));
        }

        @Override // io.grpc.j1.x
        public void a() {
            final io.grpc.j1.p pVar = this.c;
            t0 t0Var = new t0();
            p.g(pVar, this.b, t.a(p.f(pVar)), t0Var);
        }
    }

    class c extends io.grpc.j1.x {

        final h.a b;
        final String c;
        final io.grpc.j1.p v;
        c(io.grpc.j1.p p, h.a h$a2, String string3) {
            this.v = p;
            this.b = a2;
            this.c = string3;
            super(p.f(p));
        }

        @Override // io.grpc.j1.x
        public void a() {
            Object[] arr = new Object[1];
            t0 t0Var = new t0();
            p.g(this.v, this.b, d1.m.r(String.format("Unable to find compressor by name %s", this.c)), t0Var);
        }
    }

    private final class f implements s.b {

        final io.grpc.j1.p a;
        private f(io.grpc.j1.p p) {
            this.a = p;
            super();
        }

        f(io.grpc.j1.p p, io.grpc.j1.p.a p$a2) {
            super(p);
        }

        @Override // io.grpc.s$b
        public void a(s s) {
            p.a(this.a).c(t.a(s));
        }
    }

    private class d implements io.grpc.j1.r {

        private final h.a<RespT> a;
        private d1 b;
        final io.grpc.j1.p c;
        public d(io.grpc.j1.p p, h.a h$a2) {
            this.c = p;
            super();
            n.p(a2, "observer");
            this.a = (h.a)a2;
        }

        static d1 e(io.grpc.j1.p.d p$d) {
            return d.b;
        }

        static h.a f(io.grpc.j1.p.d p$d) {
            return d.a;
        }

        static void g(io.grpc.j1.p.d p$d, d1 d12) {
            d.i(d12);
        }

        private void h(d1 d1, io.grpc.j1.r.a r$a2, t0 t03) {
            Object str;
            d1 obj3;
            u obj4;
            t0 obj5;
            obj4 = p.b(this.c);
            if (d1.n() == d1.b.CANCELLED && obj4 != null && obj4.k()) {
                if (obj4 != null) {
                    if (obj4.k()) {
                        obj3 = new x0();
                        p.a(this.c).j(obj3);
                        obj5 = new StringBuilder();
                        obj5.append("ClientCall was cancelled at or after deadline. ");
                        obj5.append(obj3);
                        obj3 = d1.i.f(obj5.toString());
                        obj5 = new t0();
                    }
                }
            }
            p.d.c cVar = new p.d.c(this, c.e(), obj3, obj5);
            p.i(this.c).execute(cVar);
        }

        private void i(d1 d1) {
            this.b = d1;
            p.a(this.c).c(d1);
        }

        @Override // io.grpc.j1.r
        public void a(io.grpc.j1.k2.a k2$a) {
            final String str = "ClientStreamListener.messagesAvailable";
            c.g(str, p.h(this.c));
            p.d.b bVar2 = new p.d.b(this, c.e(), a);
            p.i(this.c).execute(bVar2);
            c.i(str, p.h(this.c));
        }

        @Override // io.grpc.j1.r
        public void b(t0 t0) {
            final String str = "ClientStreamListener.headersRead";
            c.g(str, p.h(this.c));
            p.d.a aVar = new p.d.a(this, c.e(), t0);
            p.i(this.c).execute(aVar);
            c.i(str, p.h(this.c));
        }

        @Override // io.grpc.j1.r
        public void c() {
            if (p.j(this.c).e().clientSendsOneMessage()) {
            }
            final String str = "ClientStreamListener.onReady";
            c.g(str, p.h(this.c));
            p.d.d dVar4 = new p.d.d(this, c.e());
            p.i(this.c).execute(dVar4);
            c.i(str, p.h(this.c));
        }

        @Override // io.grpc.j1.r
        public void d(d1 d1, io.grpc.j1.r.a r$a2, t0 t03) {
            final String str = "ClientStreamListener.closed";
            c.g(str, p.h(this.c));
            h(d1, a2, t03);
            c.i(str, p.h(this.c));
        }
    }
    static {
        p.t = Logger.getLogger(p.class.getName());
        p.u = "gzip".getBytes(Charset.forName("US-ASCII"));
    }

    p(u0<ReqT, RespT> u0, Executor executor2, d d3, io.grpc.j1.p.e p$e4, ScheduledExecutorService scheduledExecutorService5, io.grpc.j1.m m6, f0 f07) {
        Executor d2Var;
        Executor obj5;
        super();
        p.f obj10 = new p.f(this, 0);
        this.o = obj10;
        this.r = w.c();
        this.s = p.a();
        this.a = u0;
        obj10 = c.b(u0.c(), (long)identityHashCode);
        this.b = obj10;
        final int i4 = 0;
        if (executor2 == d.a()) {
            obj5 = new c2();
            this.c = obj5;
            this.d = true;
        } else {
            d2Var = new d2(executor2);
            this.c = d2Var;
            this.d = i4;
        }
        this.e = m6;
        this.f = s.i();
        if (u0.e() == u0.d.SERVER_STREAMING) {
        }
        int i3 = i4;
        this.i = d3;
        this.n = e4;
        this.p = scheduledExecutorService5;
        c.c("ClientCall.<init>", obj10);
    }

    static io.grpc.j1.q a(io.grpc.j1.p p) {
        return p.j;
    }

    static u b(io.grpc.j1.p p) {
        return p.n();
    }

    static boolean c(io.grpc.j1.p p, boolean z2) {
        p.k = z2;
        return z2;
    }

    static void d(io.grpc.j1.p p) {
        p.s();
    }

    static io.grpc.j1.m e(io.grpc.j1.p p) {
        return p.e;
    }

    static s f(io.grpc.j1.p p) {
        return p.f;
    }

    static void g(io.grpc.j1.p p, h.a h$a2, d1 d13, t0 t04) {
        p.m(a2, d13, t04);
    }

    static d h(io.grpc.j1.p p) {
        return p.b;
    }

    static Executor i(io.grpc.j1.p p) {
        return p.c;
    }

    static u0 j(io.grpc.j1.p p) {
        return p.a;
    }

    private void k() {
        Object obj;
        Object num2;
        Object bool;
        Object num;
        Integer intValue;
        u intValue2;
        TimeUnit nANOSECONDS;
        obj = this.i.h(j1.b.g);
        if ((j1.b)obj == null) {
        }
        num2 = obj.a;
        if (num2 != null) {
            num2 = u.a(num2.longValue(), obj2);
            intValue2 = this.i.d();
            if (intValue2 != null) {
                if (num2.i(intValue2) < 0) {
                    this.i = this.i.l(num2);
                }
            } else {
            }
        }
        bool = obj.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                bool = this.i.s();
            } else {
                bool = this.i.t();
            }
            this.i = bool;
        }
        if (obj.c != null) {
            Integer num5 = this.i.f();
            if (num5 != null) {
                this.i = this.i.o(Math.min(num5.intValue(), obj.c.intValue()));
            } else {
                this.i = this.i.o(obj.c.intValue());
            }
        }
        if (obj.d != null) {
            Integer num6 = this.i.g();
            if (num6 != null) {
                this.i = this.i.p(Math.min(num6.intValue(), obj.d.intValue()));
            } else {
                this.i = this.i.p(obj.d.intValue());
            }
        }
    }

    private void l(String string, Throwable throwable2) {
        Logger logger;
        Object qVar;
        Level wARNING;
        String str;
        d1 obj4;
        CancellationException obj5;
        if (string == null && throwable2 == null) {
            if (throwable2 == null) {
                obj5 = new CancellationException("Cancelled without a message or cause");
                p.t.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", obj5);
            }
        }
        if (this.l) {
        }
        this.l = true;
        if (this.j != null) {
            qVar = d1.g;
            if (string != null) {
                obj4 = qVar.r(string);
            } else {
                obj4 = qVar.r("Call cancelled without message");
            }
            if (obj5 != null) {
                obj4 = obj4.q(obj5);
            }
            this.j.c(obj4);
        }
        s();
    }

    private void m(h.a<RespT> h$a, d1 d12, t0 t03) {
        a.onClose(d12, t03);
    }

    private u n() {
        return p.q(this.i.d(), this.f.k());
    }

    private void o() {
        int i;
        final int i4 = 1;
        i = this.j != null ? i4 : 0;
        n.v(i, "Not started");
        n.v(z ^= i4, "call was cancelled");
        n.v(z2 ^= i4, "call already half-closed");
        this.m = i4;
        this.j.k();
    }

    private static void p(u u, u u2, u u3) {
        Object[] loggable;
        long i2;
        int i;
        Object[] arr;
        String obj5;
        String obj6;
        final Logger logger = p.t;
        if (logger.isLoggable(Level.FINE) && u != null) {
            if (u != null) {
                if (!u.equals(u2)) {
                } else {
                    obj6 = TimeUnit.NANOSECONDS;
                    i = 1;
                    arr = new Object[i];
                    i2 = 0;
                    arr[i2] = Long.valueOf(Math.max(0, obj2));
                    obj5 = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", arr));
                    if (u3 == 0) {
                        obj5.append(" Explicit call timeout was not set.");
                    } else {
                        loggable = new Object[i];
                        loggable[i2] = Long.valueOf(u3.n(obj6));
                        obj5.append(String.format(" Explicit call timeout was '%d' ns.", loggable));
                    }
                    logger.fine(obj5.toString());
                }
            }
        }
    }

    private static u q(u u, u u2) {
        if (u == null) {
            return u2;
        }
        if (u2 == null) {
            return u;
        }
        return u.m(u2);
    }

    static void r(t0 t0, w w2, o o3, boolean z4) {
        Object obj4;
        io.grpc.t0.f fVar = r0.c;
        t0.d(fVar);
        if (o3 != m.b.a) {
            t0.o(fVar, o3.a());
        }
        obj4 = r0.d;
        t0.d(obj4);
        byte[] obj3 = g0.a(w2);
        if (obj3.length != 0) {
            t0.o(obj4, obj3);
        }
        t0.d(r0.e);
        obj3 = r0.f;
        t0.d(obj3);
        if (z4) {
            t0.o(obj3, p.u);
        }
    }

    private void s() {
        io.grpc.j1.p.f fVar;
        this.f.n(this.o);
        ScheduledFuture future = this.g;
        if (future != null) {
            future.cancel(false);
        }
    }

    private void t(ReqT reqt) {
        int i;
        u0 u0Var;
        Object obj4;
        int i4 = 1;
        i = this.j != null ? i4 : 0;
        n.v(i, "Not started");
        n.v(z ^= i4, "call was cancelled");
        n.v(z2 ^= i4, "call was half-closed");
        io.grpc.j1.q qVar3 = this.j;
        if (qVar3 instanceof z1) {
            (z1)qVar3.j0(reqt);
        } else {
            qVar3.n(this.a.j(reqt));
        }
        if (!this.h) {
            this.j.flush();
        }
    }

    private ScheduledFuture<?> x(u u) {
        final TimeUnit nANOSECONDS = TimeUnit.NANOSECONDS;
        final long l = u.n(nANOSECONDS);
        p.g gVar = new p.g(this, l, obj2);
        d1 d1Var = new d1(gVar);
        return this.p.schedule(d1Var, l, obj2);
    }

    private void y(h.a<RespT> h$a, t0 t02) {
        int i2;
        int i;
        Object intValue;
        Object d1Var;
        Object oVar;
        boolean z;
        Object string;
        Object str;
        s obj7;
        io.grpc.l[] obj8;
        i = 1;
        int i4 = 0;
        i2 = this.j == null ? i : i4;
        n.v(i2, "Already started");
        n.v(z2 ^= i, "call was cancelled");
        n.p(a, "observer");
        n.p(t02, "headers");
        if (this.f.m()) {
            this.j = o1.a;
            p.b bVar = new p.b(this, a);
            this.c.execute(bVar);
        }
        k();
        String str4 = this.i.b();
        if (str4 != null) {
            if (this.s.b(str4) == null) {
                this.j = o1.a;
                p.c cVar = new p.c(this, a, str4);
                this.c.execute(cVar);
            }
        } else {
            oVar = m.b.a;
        }
        p.r(t02, this.r, oVar, this.q);
        u uVar = n();
        if (uVar != null && uVar.k()) {
            if (uVar.k()) {
            } else {
                i = i4;
            }
        } else {
        }
        if (i == 0) {
            p.p(uVar, this.f.k(), this.i.d());
            this.j = this.n.a(this.a, this.i, t02, this.f);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ClientCall started after deadline exceeded: ");
            stringBuilder.append(uVar);
            intValue = new f0(d1.i.r(stringBuilder.toString()), r0.f(this.i, t02, i4, i4));
            this.j = intValue;
        }
        if (this.d) {
            this.j.o();
        }
        if (this.i.a() != null) {
            this.j.i(this.i.a());
        }
        if (this.i.f() != null) {
            this.j.f(this.i.f().intValue());
        }
        if (this.i.g() != null) {
            this.j.g(this.i.g().intValue());
        }
        if (uVar != null) {
            this.j.l(uVar);
        }
        this.j.d(oVar);
        obj8 = this.q;
        if (obj8 != null) {
            this.j.q(obj8);
        }
        this.j.h(this.r);
        this.e.b();
        p.d dVar3 = new p.d(this, a);
        this.j.m(dVar3);
        this.f.a(this.o, d.a());
        if (uVar != null && !uVar.equals(this.f.k()) && this.p != null) {
            if (!uVar.equals(this.f.k())) {
                if (this.p != null) {
                    this.g = x(uVar);
                }
            }
        }
        if (this.k) {
            s();
        }
    }

    @Override // io.grpc.h
    public void cancel(String string, Throwable throwable2) {
        final String str = "ClientCall.cancel";
        c.g(str, this.b);
        l(string, throwable2);
        c.i(str, this.b);
    }

    @Override // io.grpc.h
    public a getAttributes() {
        io.grpc.j1.q qVar = this.j;
        if (qVar != null) {
            return qVar.getAttributes();
        }
        return a.b;
    }

    @Override // io.grpc.h
    public void halfClose() {
        final String str = "ClientCall.halfClose";
        c.g(str, this.b);
        o();
        c.i(str, this.b);
    }

    @Override // io.grpc.h
    public boolean isReady() {
        return this.j.a();
    }

    @Override // io.grpc.h
    public void request(int i) {
        int i2;
        int i3;
        final String str2 = "ClientCall.request";
        c.g(str2, this.b);
        final int i4 = 0;
        i2 = this.j != null ? i3 : i4;
        n.v(i2, "Not started");
        if (i >= 0) {
        } else {
            i3 = i4;
        }
        n.e(i3, "Number requested must be non-negative");
        this.j.e(i);
        c.i(str2, this.b);
    }

    public void sendMessage(ReqT reqt) {
        final String str = "ClientCall.sendMessage";
        c.g(str, this.b);
        t(reqt);
        c.i(str, this.b);
    }

    @Override // io.grpc.h
    public void setMessageCompression(boolean z) {
        int i;
        i = this.j != null ? 1 : 0;
        n.v(i, "Not started");
        this.j.b(z);
    }

    public void start(h.a<RespT> h$a, t0 t02) {
        final String str = "ClientCall.start";
        c.g(str, this.b);
        y(a, t02);
        c.i(str, this.b);
    }

    @Override // io.grpc.h
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("method", this.a);
        return bVar.toString();
    }

    io.grpc.j1.p<ReqT, RespT> u(p p) {
        this.s = p;
        return this;
    }

    io.grpc.j1.p<ReqT, RespT> v(w w) {
        this.r = w;
        return this;
    }

    io.grpc.j1.p<ReqT, RespT> w(boolean z) {
        this.q = z;
        return this;
    }
}
