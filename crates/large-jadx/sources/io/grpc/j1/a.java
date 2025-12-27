package io.grpc.j1;

import com.google.common.base.n;
import io.grpc.b0;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.m.b;
import io.grpc.o;
import io.grpc.t0;
import io.grpc.u;
import io.grpc.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: AbstractClientStream.java */
/* loaded from: classes3.dex */
public abstract class a extends d implements q, m1.d {

    private static final Logger g;
    private final o2 a;
    private final p0 b;
    private boolean c;
    private boolean d;
    private t0 e;
    private volatile boolean f;

    protected interface b {
        void c(d1 d1Var);

        void d(p2 p2Var, boolean z, boolean z2, int i);

        void e(t0 t0Var, byte[] bArr);
    }

    private class a implements p0 {

        private t0 a;
        private boolean b;
        private final i2 c;
        private byte[] d;
        final /* synthetic */ a e;
        public a(t0 t0Var, i2 i2Var) {
            this.e = aVar;
            super();
            n.p(t0Var, "headers");
            this.a = t0Var;
            n.p(i2Var, "statsTraceCtx");
            this.c = i2Var;
        }

        public void close() {
            boolean z = true;
            z = true;
            this.b = z;
            if (this.d == null) {
                int i = 0;
            }
            n.v(z, "Lack of request message. GET request is only supported for unary requests");
            this.e.v().e(this.a, this.d);
            byte[] bArr = null;
            this.d = bArr;
            this.a = bArr;
        }

        public void e(InputStream inputStream) {
            boolean z = true;
            final int i = 0;
            RuntimeException runtimeException = this.d == null ? 1 : i;
            n.v((this.d == null ? 1 : i), "writePayload should not be called multiple times");
            try {
                this.d = a.d(inputStream);
            } catch (java.io.IOException ioException) {
                throw (this.d == null ? 1 : i);
            }
            this.c.i(i);
            this.c.j(0, (long)bArr5.length, (long)bArr5.length);
            this.c.k((long)this.d.length);
            this.c.l((long)this.d.length);
        }

        public boolean isClosed() {
            return this.b;
        }

        public p0 b(boolean z) {
            return this;
        }

        public p0 d(o oVar) {
            return this;
        }

        public void flush() {
        }

        public void g(int i) {
        }
    }

    protected static abstract class c extends d.a {

        private final i2 h;
        private boolean i;
        private r j;
        private boolean k;
        private w l;
        private boolean m = false;
        private Runnable n;
        private volatile boolean o;
        private boolean p;
        private boolean q;
        protected c(int i, i2 i2Var, o2 o2Var) {
            super(i, i2Var, o2Var);
            this.l = w.c();
            n.p(i2Var, "statsTraceCtx");
            this.h = i2Var;
        }

        static /* synthetic */ void A(a.c cVar) {
            cVar.L();
        }

        static /* synthetic */ void B(a.c cVar, d1 d1Var, r.a aVar, t0 t0Var) {
            cVar.C(d1Var, aVar, t0Var);
        }

        private void C(d1 d1Var, r.a aVar, t0 t0Var) {
            if (!this.i) {
                this.i = true;
                this.h.m(d1Var);
                H().d(d1Var, aVar, t0Var);
                if (l() != null) {
                    l().f(d1Var.p());
                }
            }
        }

        private void I(w wVar) {
            boolean z = true;
            int r0 = this.j == null ? 1 : 0;
            n.v((this.j == null ? 1 : 0), "Already called start");
            n.p(wVar, (this.j == null ? 1 : 0));
            this.l = wVar;
        }

        private void J(boolean z) {
            this.k = z;
        }

        private final void L() {
            this.o = true;
        }

        static /* synthetic */ void y(a.c cVar, boolean z) {
            cVar.J(z);
        }

        static /* synthetic */ void z(a.c cVar, w wVar) {
            cVar.I(wVar);
        }

        @Override // io.grpc.j1.d$a
        protected void D(v1 v1Var) {
            Throwable th;
            n.p(v1Var, "frame");
            try {
                a.g.log(Level.INFO, "Received data on closed stream");
            } catch (Throwable th) {
            }
            try {
                k(v1Var);
            } catch (Throwable th) {
            }
        }

        @Override // io.grpc.j1.d$a
        protected void E(t0 t0Var) {
            int i;
            boolean equalsIgnoreCase;
            i = 1;
            n.v(this.p ^ i, "Received headers on closed stream");
            this.h.a();
            Object obj = t0Var.f(r0.e);
            i = 0;
            if (this.k && obj != null) {
                if (!obj.equalsIgnoreCase("gzip")) {
                    if (!obj.equalsIgnoreCase("identity")) {
                        Object[] arr3 = new Object[i];
                        d(d1.m.r(String.format("Can't find full stream decompressor for %s", new Object[] { obj })).d());
                        return;
                    }
                } else {
                    w(new s0());
                }
            }
            Object obj2 = t0Var.f(r0.c);
            if (obj2 != null) {
                io.grpc.v vVar = this.l.e(obj2);
                if (vVar == null) {
                    Object[] arr = new Object[i];
                    d(d1.m.r(String.format("Can't find decompressor for %s", new Object[] { obj2 })).d());
                    return;
                }
                if (vVar != m.b.a && this.h != 0) {
                    d(d1.m.r(String.format("Full stream and gRPC message encoding cannot both be set", new Object[i])).d());
                    return;
                }
            }
            H().b(t0Var);
        }

        @Override // io.grpc.j1.d$a
        protected void F(t0 t0Var, d1 d1Var) {
            n.p(d1Var, "status");
            n.p(t0Var, "trailers");
            final int i = 0;
            if (this.p) {
                Object[] arr = new Object[2];
                a.g.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[] { d1Var, t0Var });
                return;
            }
            this.h.b(t0Var);
            N(d1Var, false, t0Var);
        }

        @Override // io.grpc.j1.d$a
        protected final boolean G() {
            return this.o;
        }

        @Override // io.grpc.j1.d$a
        protected final r H() {
            return this.j;
        }

        @Override // io.grpc.j1.d$a
        public final void K(r rVar) {
            boolean z = true;
            int r0 = this.j == null ? 1 : 0;
            n.v((this.j == null ? 1 : 0), "Already called setListener");
            n.p(rVar, (this.j == null ? 1 : 0));
            this.j = rVar;
        }

        @Override // io.grpc.j1.d$a
        public final void M(d1 d1Var, r.a aVar, boolean z, t0 t0Var) {
            n.p(d1Var, "status");
            n.p(t0Var, "trailers");
            if (this.p && !z) {
                return;
            }
            this.p = true;
            this.q = d1Var.p();
            s();
            if (this.m) {
                Runnable runnable = null;
                this.n = runnable;
                C(d1Var, aVar, t0Var);
            } else {
                this.n = new a.c.a(this, d1Var, aVar, t0Var);
                j(z);
            }
        }

        @Override // io.grpc.j1.d$a
        public final void N(d1 d1Var, boolean z, t0 t0Var) {
            M(d1Var, r.a.PROCESSED, z, t0Var);
        }

        @Override // io.grpc.j1.d$a
        public void b(boolean z) {
            n.v(this.p, "status should have been reported on deframer closed");
            boolean z4 = true;
            this.m = z4;
            if (this.q && z) {
                N(d1.m.r("Encountered end-of-stream mid-frame"), z4, new t0());
            }
            if (this.n != null) {
                this.n.run();
                Runnable runnable = null;
                this.n = runnable;
            }
        }
    }
    static {
        a.g = Logger.getLogger(a.class.getName());
    }

    protected a(q2 q2Var, i2 i2Var, o2 o2Var, t0 t0Var, d dVar, boolean z) {
        super();
        n.p(t0Var, "headers");
        n.p(o2Var, "transportTracer");
        this.a = o2Var;
        this.c = r0.o(dVar);
        this.d = z;
        if (!z) {
            this.b = new m1(this, q2Var, i2Var);
            this.e = t0Var;
        } else {
            this.b = new a.a(this, t0Var, i2Var);
        }
    }

    static /* synthetic */ Logger w() {
        return a.g;
    }

    @Override // io.grpc.j1.d
    public final boolean a() {
        boolean z2 = false;
        int r0 = super.a() && !this.f ? 1 : 0;
        return (super.a() && !this.f ? 1 : 0);
    }

    @Override // io.grpc.j1.d
    public final void c(d1 d1Var) {
        final boolean z2 = true;
        n.e(d1Var.p() ^ z2, "Should not cancel with OK status");
        this.f = z2;
        v().c(d1Var);
    }

    @Override // io.grpc.j1.d
    public void f(int i) {
        z().x(i);
    }

    @Override // io.grpc.j1.d
    public void g(int i) {
        this.b.g(i);
    }

    @Override // io.grpc.j1.d
    public final void h(w wVar) {
        z().I(wVar);
    }

    @Override // io.grpc.j1.d
    public final void j(x0 x0Var) {
        x0Var.b("remote_addr", getAttributes().b(b0.a));
    }

    @Override // io.grpc.j1.d
    public final void k() {
        if (!z().G()) {
            z().L();
            r();
        }
    }

    @Override // io.grpc.j1.d
    public void l(u uVar) {
        final io.grpc.t0.f fVar = r0.b;
        this.e.d(fVar);
        this.e.o(fVar, Long.valueOf(Math.max(0L, uVar.n(TimeUnit.NANOSECONDS))));
    }

    @Override // io.grpc.j1.d
    public final void m(r rVar) {
        z().K(rVar);
        if (!this.d) {
            byte[] bArr = null;
            v().e(this.e, bArr);
            this.e = bArr;
        }
    }

    @Override // io.grpc.j1.d
    public final void p(p2 p2Var, boolean z, boolean z2, int i) {
        if (p2Var != null || z) {
            int i2 = 1;
        }
        n.e(z, "null frame before EOS");
        v().d(p2Var, z, z2, i);
    }

    @Override // io.grpc.j1.d
    public final void q(boolean z) {
        z().J(z);
    }

    @Override // io.grpc.j1.d
    protected final p0 s() {
        return this.b;
    }

    @Override // io.grpc.j1.d
    protected o2 x() {
        return this.a;
    }

    @Override // io.grpc.j1.d
    public final boolean y() {
        return this.c;
    }

    @Override // io.grpc.j1.d
    protected abstract a.b v();

    @Override // io.grpc.j1.d
    protected abstract a.c z();
}
