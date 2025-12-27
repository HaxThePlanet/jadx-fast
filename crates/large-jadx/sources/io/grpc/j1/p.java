package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import i.a.c;
import io.grpc.a;
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

/* compiled from: ClientCallImpl.java */
/* loaded from: classes3.dex */
final class p<ReqT, RespT> extends h<ReqT, RespT> {

    private static final Logger t;
    private static final byte[] u;
    private final u0<ReqT, RespT> a;
    private final i.a.d b;
    private final Executor c;
    private final boolean d;
    private final m e;
    private final s f;
    private volatile ScheduledFuture<?> g;
    private final boolean h = false;
    private io.grpc.d i;
    private q j;
    private volatile boolean k;
    private boolean l;
    private boolean m;
    private final p.e n;
    private final p.f<ReqT, RespT> o = new p$f<>();
    private final ScheduledExecutorService p;
    private boolean q;
    private w r;
    private p s;

    static class a {
    }

    interface e {
        q a(u0<?, ?> u0Var, io.grpc.d dVar, t0 t0Var, s sVar);
    }

    private class g implements Runnable {

        private final long a;
        final /* synthetic */ p b;
        g(long j) {
            this.b = pVar;
            super();
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.grpc.j1.x0 x0Var = new x0();
            this.b.j.j(x0Var);
            TimeUnit sECONDS2 = TimeUnit.SECONDS;
            long l4 = 1L;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("deadline exceeded after ");
            if (this.a < 0) {
                stringBuilder.append('-');
            }
            stringBuilder.append(Math.abs(this.a) / sECONDS2.toNanos(l4));
            Object[] arr = new Object[1];
            stringBuilder.append(String.format(Locale.US, ".%09d", new Object[] { Long.valueOf(Math.abs(this.a) % sECONDS2.toNanos(l4)) }));
            stringBuilder.append("s. ");
            stringBuilder.append(x0Var);
            this.b.j.c(d1.i.f(stringBuilder.toString()));
        }
    }

    class b extends x {

        final /* synthetic */ h.a b;
        final /* synthetic */ p c;
        b(h.a aVar) {
            this.c = pVar;
            this.b = aVar;
            super(pVar.f);
        }

        @Override // io.grpc.j1.x
        public void a() {
            this.c.m(this.b, t.a(this.c.f), new t0());
        }
    }

    class c extends x {

        final /* synthetic */ h.a b;
        final /* synthetic */ String c;
        final /* synthetic */ p v;
        c(h.a aVar, String str) {
            this.v = pVar;
            this.b = aVar;
            this.c = str;
            super(pVar.f);
        }

        @Override // io.grpc.j1.x
        public void a() {
            Object[] arr = new Object[1];
            this.v.m(this.b, d1.m.r(String.format("Unable to find compressor by name %s", new Object[] { this.c })), new t0());
        }
    }

    private final class f implements s.b {

        final /* synthetic */ p a;
        private f() {
            this.a = pVar;
            super();
        }

        public void a(s sVar) {
            this.a.j.c(t.a(sVar));
        }

        /* synthetic */ f(p.a aVar) {
            this(pVar);
        }
    }

    private class d implements r {

        private final h.a<RespT> a;
        private d1 b;
        final /* synthetic */ p c;
        public d(h.a aVar) {
            this.c = pVar;
            super();
            n.p(aVar, "observer");
            this.a = aVar;
        }

        static /* synthetic */ d1 e(p.d dVar) {
            return dVar.b;
        }

        static /* synthetic */ h.a f(p.d dVar) {
            return dVar.a;
        }

        static /* synthetic */ void g(p.d dVar, d1 d1Var) {
            dVar.i(d1Var);
        }

        private void h(d1 d1Var, r.a aVar, t0 t0Var) {
            d1 d1Var2;
            u uVar = this.c.n();
            if (d1Var.n() == d1.b.CANCELLED && uVar != null && uVar.k()) {
                io.grpc.j1.x0 x0Var = new x0();
                this.c.j.j(x0Var);
                StringBuilder stringBuilder = new StringBuilder();
                String str = "ClientCall was cancelled at or after deadline. ";
                str2 = str + x0Var;
                d1Var2 = d1.i.f(str2);
                t0Var = new t0();
            }
            this.c.c.execute(new p.d.c(this, c.e(), d1Var2, t0Var));
        }

        private void i(d1 d1Var) {
            this.b = d1Var;
            this.c.j.c(d1Var);
        }

        public void a(k2.a aVar) {
            final String str2 = "ClientStreamListener.messagesAvailable";
            c.g(str2, this.c.b);
            try {
                this.c.c.execute(new p.d.b(this, c.e(), aVar));
            } finally {
                io.grpc.j1.p pVar = this.c.b;
                c.i(str, this.c);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) aVar;
            }
            c.i(str2, this.c.b);
        }

        public void b(t0 t0Var) {
            final String str2 = "ClientStreamListener.headersRead";
            c.g(str2, this.c.b);
            try {
                this.c.c.execute(new p.d.a(this, c.e(), t0Var));
            } finally {
                io.grpc.j1.p pVar = this.c.b;
                c.i(str, this.c);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) t0Var;
            }
            c.i(str2, this.c.b);
        }

        public void c() {
            if (this.c.a.e().clientSendsOneMessage()) {
                return;
            }
            final String str2 = "ClientStreamListener.onReady";
            c.g(str2, this.c.b);
            try {
                this.c.c.execute(new p.d.d(this, c.e()));
            } finally {
                io.grpc.j1.p pVar4 = this.c.b;
                c.i(str, this.c);
                throw th;
            }
            c.i(str2, this.c.b);
        }

        public void d(d1 d1Var, r.a aVar, t0 t0Var) {
            final String str2 = "ClientStreamListener.closed";
            c.g(str2, this.c.b);
            try {
                h(d1Var, aVar, t0Var);
            } finally {
                aVar = this.c.b;
                c.i(str, this.c);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) d1Var;
            }
            c.i(str2, this.c.b);
        }
    }
    static {
        p.t = Logger.getLogger(p.class.getName());
        p.u = "gzip".getBytes(Charset.forName("US-ASCII"));
    }

    p(u0<ReqT, RespT> u0Var, Executor executor, io.grpc.d dVar, p.e eVar, ScheduledExecutorService scheduledExecutorService, m mVar, f0 f0Var) {
        super();
        io.grpc.j1.p.f fVar = new p.f(this, null);
        this.r = w.c();
        this.s = p.a();
        this.a = u0Var;
        i.a.d dVar4 = c.b(u0Var.c(), (long)System.identityHashCode(this));
        this.b = dVar4;
        if (executor == d.a()) {
            this.c = new c2();
            this.d = true;
        } else {
            this.c = new d2(executor);
            this.d = false;
        }
        this.e = mVar;
        this.f = s.i();
        this.i = dVar;
        this.n = eVar;
        this.p = scheduledExecutorService;
        c.c("ClientCall.<init>", dVar4);
    }

    static /* synthetic */ q a(p pVar) {
        return pVar.j;
    }

    static /* synthetic */ u b(p pVar) {
        return pVar.n();
    }

    static /* synthetic */ boolean c(p pVar, boolean z) {
        pVar.k = z;
        return z;
    }

    static /* synthetic */ void d(p pVar) {
        pVar.s();
    }

    static /* synthetic */ m e(p pVar) {
        return pVar.e;
    }

    static /* synthetic */ s f(p pVar) {
        return pVar.f;
    }

    static /* synthetic */ void g(p pVar, h.a aVar, d1 d1Var, t0 t0Var) {
        pVar.m(aVar, d1Var, t0Var);
    }

    static /* synthetic */ i.a.d h(p pVar) {
        return pVar.b;
    }

    static /* synthetic */ Executor i(p pVar) {
        return pVar.c;
    }

    static /* synthetic */ u0 j(p pVar) {
        return pVar.a;
    }

    private void k() {
        io.grpc.d dVar;
        int value;
        TimeUnit nANOSECONDS2;
        Object obj = this.i.h(j1.b.g);
        if (obj == null) {
            return;
        }
        if (obj.a != null) {
            u uVar2 = u.a(obj.a.longValue(), TimeUnit.NANOSECONDS);
            u uVar = this.i.d();
            if (uVar == null || uVar2.i(uVar) < 0) {
                this.i = this.i.l(uVar2);
            }
        }
        if (obj.b != null) {
            if (obj.b.booleanValue()) {
                dVar = this.i.s();
            } else {
                dVar = this.i.t();
            }
            this.i = dVar;
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

    private void l(String str, Throwable th) {
        d1 d1Var;
        Object obj;
        if (str == null && th == null) {
            str2 = "Cancelling without a message or cause is suboptimal";
            p.t.log(Level.WARNING, str2, new CancellationException("Cancelled without a message or cause"));
        }
        if (this.l) {
            return;
        }
        this.l = true;
        try {
            d1 d1Var2 = d1.g;
            if (str != null) {
                d1Var = d1.g.r(str);
            } else {
                d1Var = d1.g.r("Call cancelled without message");
            }
            if (obj != null) {
                d1Var = d1Var.q(obj);
            }
            this.j.c(d1Var);
        } finally {
            s();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str;
        }
        s();
    }

    private void m(h.a<RespT> aVar, d1 d1Var, t0 t0Var) {
        aVar.onClose(d1Var, t0Var);
    }

    private u n() {
        return p.q(this.i.d(), this.f.k());
    }

    private void o() {
        boolean z = false;
        final boolean z4 = true;
        boolean r0 = this.j != null ? z4 : 0;
        n.v((this.j != null ? z4 : 0), "Not started");
        n.v((this.j != null ? z4 : 0), "call was cancelled");
        n.v((this.j != null ? z4 : 0), "call already half-closed");
        this.m = z4;
        (this.j != null ? z4 : 0).k();
    }

    private static void p(u uVar, u uVar2, u uVar3) {
        Object[] arr;
        String formatted;
        final Logger logger = p.t;
    }

    private static u q(u uVar, u uVar2) {
        if (uVar == null) {
            return uVar2;
        }
        if (uVar2 == null) {
            return uVar;
        }
        return uVar.m(uVar2);
    }

    static void r(t0 t0Var, w wVar, o oVar, boolean z) {
        io.grpc.t0.f fVar2 = r0.c;
        t0Var.d(fVar2);
        if (oVar != m.b.a) {
            t0Var.o(r0.c, oVar.a());
        }
        fVar = r0.d;
        t0Var.d(fVar);
        byte[] bArr = g0.a(wVar);
        if (bArr.length != 0) {
            t0Var.o(r0.d, bArr);
        }
        t0Var.d(r0.e);
        io.grpc.t0.f fVar4 = r0.f;
        t0Var.d(fVar4);
        if (z) {
            t0Var.o(r0.f, p.u);
        }
    }

    private void s() {
        this.f.n(this.o);
        if (this.g != null) {
            this.g.cancel(false);
        }
    }

    private void t(ReqT reqt) {
        boolean z2 = false;
        int i = 1;
        io.grpc.j1.q qVar = this.j != null ? i : 0;
        n.v((this.j != null ? i : 0), "Not started");
        n.v((this.j != null ? i : 0), "call was cancelled");
        n.v((this.j != null ? i : 0), "call was half-closed");
        try {
            if (qVar3 instanceof z1) {
                qVar3.j0(reqt);
            } else {
                qVar3.n(this.a.j(reqt));
            }
        } catch (Error e) {
            d1 str = d1.g;
            str = str.r("Client sendMessage() failed with Error");
            qVar.c(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) e;
        } catch (RuntimeException e1) {
            str = d1.g;
            e1 = str.q(e1);
            str = "Failed to stream message";
            e1 = e1.r(str);
            qVar.c(e1);
            return;
        }
        if (!this.h) {
            this.j.flush();
        }
    }

    private ScheduledFuture<?> x(u uVar) {
        final TimeUnit nANOSECONDS2 = TimeUnit.NANOSECONDS;
        final long l = uVar.n(nANOSECONDS2);
        return this.p.schedule(new d1(new p.g(this, l, timeUnit)), l, nANOSECONDS2);
    }

    private void y(h.a<RespT> aVar, t0 t0Var) {
        boolean z3;
        int i = 1;
        io.grpc.j1.f0 f0Var;
        o oVar;
        boolean z;
        Integer num2;
        i = 1;
        i = 0;
        int r0 = i;
        n.v(i, "Already started");
        n.v(i, "call was cancelled");
        n.p(aVar, i);
        n.p(t0Var, i);
        if (i.m()) {
            this.j = o1.a;
            this.c.execute(new p.b(this, aVar));
            return;
        }
        k();
        String str6 = this.i.b();
        if (str6 != null) {
            if (this.s.b(str6) == null) {
                this.j = o1.a;
                this.c.execute(new p.c(this, aVar, str6));
                return;
            }
        } else {
            io.grpc.m mVar = m.b.a;
        }
        p.r(t0Var, this.r, oVar, this.q);
        u uVar = n();
        if (uVar == null || !uVar.k()) {
        }
        if (i == 0) {
            p.p(uVar, this.f.k(), this.i.d());
            this.j = this.n.a(this.a, this.i, t0Var, this.f);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            str2 = "ClientCall started after deadline exceeded: ";
            str = str2 + uVar;
            this.j = new f0(d1.i.r(str), r0.f(this.i, t0Var, i, false));
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
        if (this.q) {
            this.j.q(this.q);
        }
        this.j.h(this.r);
        this.e.b();
        this.j.m(new p.d(this, aVar));
        this.f.a(this.o, d.a());
        if (uVar != null && !uVar.equals(this.f.k()) && this.p != null) {
            this.g = x(uVar);
        }
        if (this.k) {
            s();
        }
    }

    @Override // io.grpc.h
    public void cancel(String str, Throwable th) {
        final String str3 = "ClientCall.cancel";
        c.g(str3, this.b);
        try {
            l(str, th);
        } finally {
            c.i(str2, this.b);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str;
        }
        c.i(str3, this.b);
    }

    @Override // io.grpc.h
    public a getAttributes() {
        if (this.j != null) {
            return this.j.getAttributes();
        }
        return a.b;
    }

    @Override // io.grpc.h
    public void halfClose() {
        final String str2 = "ClientCall.halfClose";
        c.g(str2, this.b);
        try {
            o();
        } finally {
            c.i(str, this.b);
            throw th;
        }
        c.i(str2, this.b);
    }

    @Override // io.grpc.h
    public boolean isReady() {
        return this.j.a();
    }

    @Override // io.grpc.h
    public void request(int i) {
        boolean z;
        boolean z2 = true;
        final String str3 = "ClientCall.request";
        c.g(str3, this.b);
        try {
            final int i2 = 0;
            i.a.d dVar = this.j != null ? 1 : i2;
            n.v((this.j != null ? 1 : i2), "Not started");
            if (i < 0) {
            }
            n.e(z2, "Number requested must be non-negative");
            this.j.e(i);
        } finally {
            c.i(str2, (this.j != null ? 1 : i2));
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        }
        c.i(str3, this.b);
    }

    @Override // io.grpc.h
    public void sendMessage(ReqT reqt) {
        final String str2 = "ClientCall.sendMessage";
        c.g(str2, this.b);
        try {
            t(reqt);
        } finally {
            c.i(str, this.b);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) reqt;
        }
        c.i(str2, this.b);
    }

    @Override // io.grpc.h
    public void setMessageCompression(boolean z) {
        boolean z2 = true;
        int r0 = this.j != null ? 1 : 0;
        n.v((this.j != null ? 1 : 0), "Not started");
        (this.j != null ? 1 : 0).b(z);
    }

    @Override // io.grpc.h
    public void start(h.a<RespT> aVar, t0 t0Var) {
        final String str2 = "ClientCall.start";
        c.g(str2, this.b);
        try {
            y(aVar, t0Var);
        } finally {
            c.i(str, this.b);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) aVar;
        }
        c.i(str2, this.b);
    }

    @Override // io.grpc.h
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("method", this.a);
        return bVar.toString();
    }

    @Override // io.grpc.h
    p<ReqT, RespT> u(p pVar) {
        this.s = pVar;
        return this;
    }

    @Override // io.grpc.h
    p<ReqT, RespT> v(w wVar) {
        this.r = wVar;
        return this;
    }

    @Override // io.grpc.h
    p<ReqT, RespT> w(boolean z) {
        this.q = z;
        return this;
    }
}
