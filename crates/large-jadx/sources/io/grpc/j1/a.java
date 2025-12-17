package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.io.a;
import io.grpc.a;
import io.grpc.b0;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.m.b;
import io.grpc.o;
import io.grpc.t0;
import io.grpc.u;
import io.grpc.w;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class a extends io.grpc.j1.d implements io.grpc.j1.q, io.grpc.j1.m1.d {

    private static final Logger g;
    private final io.grpc.j1.o2 a;
    private final io.grpc.j1.p0 b;
    private boolean c;
    private boolean d;
    private t0 e;
    private volatile boolean f;

    protected interface b {
        public abstract void c(d1 d1);

        public abstract void d(io.grpc.j1.p2 p2, boolean z2, boolean z3, int i4);

        public abstract void e(t0 t0, byte[] b2Arr2);
    }

    private class a implements io.grpc.j1.p0 {

        private t0 a;
        private boolean b;
        private final io.grpc.j1.i2 c;
        private byte[] d;
        final io.grpc.j1.a e;
        public a(io.grpc.j1.a a, t0 t02, io.grpc.j1.i2 i23) {
            this.e = a;
            super();
            n.p(t02, "headers");
            this.a = (t0)t02;
            n.p(i23, "statsTraceCtx");
            this.c = (i2)i23;
        }

        @Override // io.grpc.j1.p0
        public io.grpc.j1.p0 b(boolean z) {
            return this;
        }

        @Override // io.grpc.j1.p0
        public void close() {
            int i;
            this.b = true;
            if (this.d != null) {
            } else {
                i = 0;
            }
            n.v(i, "Lack of request message. GET request is only supported for unary requests");
            this.e.v().e(this.a, this.d);
            int i2 = 0;
            this.d = i2;
            this.a = i2;
        }

        @Override // io.grpc.j1.p0
        public io.grpc.j1.p0 d(o o) {
            return this;
        }

        @Override // io.grpc.j1.p0
        public void e(InputStream inputStream) {
            int i;
            final int i2 = 0;
            i = this.d == null ? 1 : i2;
            n.v(i, "writePayload should not be called multiple times");
            this.d = a.d(inputStream);
            this.c.i(i2);
            byte[] obj9 = this.d;
            this.c.j(0, (long)length, obj5);
            this.c.k((long)length2);
            this.c.l((long)length3);
        }

        @Override // io.grpc.j1.p0
        public void flush() {
        }

        @Override // io.grpc.j1.p0
        public void g(int i) {
        }

        @Override // io.grpc.j1.p0
        public boolean isClosed() {
            return this.b;
        }
    }

    protected static abstract class c extends io.grpc.j1.d.a {

        private final io.grpc.j1.i2 h;
        private boolean i;
        private io.grpc.j1.r j;
        private boolean k;
        private w l;
        private boolean m = false;
        private Runnable n;
        private volatile boolean o;
        private boolean p;
        private boolean q;
        protected c(int i, io.grpc.j1.i2 i22, io.grpc.j1.o2 o23) {
            super(i, i22, o23);
            this.l = w.c();
            int obj1 = 0;
            n.p(i22, "statsTraceCtx");
            this.h = (i2)i22;
        }

        static void A(io.grpc.j1.a.c a$c) {
            c.L();
        }

        static void B(io.grpc.j1.a.c a$c, d1 d12, io.grpc.j1.r.a r$a3, t0 t04) {
            c.C(d12, a3, t04);
        }

        private void C(d1 d1, io.grpc.j1.r.a r$a2, t0 t03) {
            boolean z;
            d1 obj2;
            Object obj3;
            this.i = true;
            this.h.m(d1);
            H().d(d1, a2, t03);
            if (!this.i && l() != null) {
                this.i = true;
                this.h.m(d1);
                H().d(d1, a2, t03);
                if (l() != null) {
                    l().f(d1.p());
                }
            }
        }

        private void I(w w) {
            int i;
            i = this.j == null ? 1 : 0;
            n.v(i, "Already called start");
            n.p(w, "decompressorRegistry");
            this.l = (w)w;
        }

        private void J(boolean z) {
            this.k = z;
        }

        private final void L() {
            this.o = true;
        }

        static void y(io.grpc.j1.a.c a$c, boolean z2) {
            c.J(z2);
        }

        static void z(io.grpc.j1.a.c a$c, w w2) {
            c.I(w2);
        }

        @Override // io.grpc.j1.d$a
        protected void D(io.grpc.j1.v1 v1) {
            Throwable th;
            n.p(v1, "frame");
            int i = 1;
            if (this.p) {
                a.w().log(Level.INFO, "Received data on closed stream");
                v1.close();
            }
            int i2 = 0;
            k(v1);
        }

        @Override // io.grpc.j1.d$a
        protected void E(t0 t0) {
            int i2;
            int i;
            boolean equalsIgnoreCase;
            io.grpc.v vVar;
            i = 1;
            n.v(z ^= i, "Received headers on closed stream");
            this.h.a();
            Object obj = t0.f(r0.e);
            final int i4 = 0;
            if (this.k && (String)obj != null) {
                if ((String)obj != null) {
                    if ((String)obj.equalsIgnoreCase("gzip")) {
                        s0 s0Var = new s0();
                        w(s0Var);
                        i2 = i;
                    } else {
                        if (!obj.equalsIgnoreCase("identity")) {
                            Object[] arr3 = new Object[i];
                            arr3[i4] = obj;
                            d(d1.m.r(String.format("Can't find full stream decompressor for %s", arr3)).d());
                        }
                        i2 = i4;
                    }
                } else {
                }
            } else {
            }
            Object obj2 = t0.f(r0.c);
            vVar = this.l.e((String)obj2);
            if (obj2 != null && vVar == null) {
                vVar = this.l.e(obj2);
                if (vVar == null) {
                    Object[] arr = new Object[i];
                    arr[i4] = obj2;
                    d(d1.m.r(String.format("Can't find decompressor for %s", arr)).d());
                }
                if (vVar != m.b.a && i2 != 0) {
                    if (i2 != 0) {
                        d(d1.m.r(String.format("Full stream and gRPC message encoding cannot both be set", new Object[i4])).d());
                    }
                    v(vVar);
                }
            }
            H().b(t0);
        }

        @Override // io.grpc.j1.d$a
        protected void F(t0 t0, d1 d12) {
            n.p(d12, "status");
            n.p(t0, "trailers");
            final int i = 0;
            if (this.p) {
                Object[] arr = new Object[2];
                arr[i] = d12;
                arr[1] = t0;
                a.w().log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", arr);
            }
            this.h.b(t0);
            N(d12, i, t0);
        }

        @Override // io.grpc.j1.d$a
        protected final boolean G() {
            return this.o;
        }

        @Override // io.grpc.j1.d$a
        protected final io.grpc.j1.r H() {
            return this.j;
        }

        @Override // io.grpc.j1.d$a
        public final void K(io.grpc.j1.r r) {
            int i;
            i = this.j == null ? 1 : 0;
            n.v(i, "Already called setListener");
            n.p(r, "listener");
            this.j = (r)r;
        }

        @Override // io.grpc.j1.d$a
        public final void M(d1 d1, io.grpc.j1.r.a r$a2, boolean z3, t0 t04) {
            io.grpc.j1.a.c.a aVar;
            boolean obj4;
            n.p(d1, "status");
            n.p(t04, "trailers");
            if (this.p && !z3) {
                if (!z3) {
                }
            }
            this.p = true;
            this.q = d1.p();
            s();
            if (this.m) {
                this.n = 0;
                C(d1, a2, t04);
            } else {
                aVar = new a.c.a(this, d1, a2, t04);
                this.n = aVar;
                j(z3);
            }
        }

        @Override // io.grpc.j1.d$a
        public final void N(d1 d1, boolean z2, t0 t03) {
            M(d1, r.a.PROCESSED, z2, t03);
        }

        @Override // io.grpc.j1.d$a
        public void b(boolean z) {
            boolean t0Var;
            d1 obj3;
            n.v(this.p, "status should have been reported on deframer closed");
            int i = 1;
            this.m = i;
            if (this.q && z != null) {
                if (z != null) {
                    t0Var = new t0();
                    N(d1.m.r("Encountered end-of-stream mid-frame"), i, t0Var);
                }
            }
            obj3 = this.n;
            if (obj3 != null) {
                obj3.run();
                this.n = 0;
            }
        }

        @Override // io.grpc.j1.d$a
        protected io.grpc.j1.k2 n() {
            return H();
        }
    }
    static {
        a.g = Logger.getLogger(a.class.getName());
    }

    protected a(io.grpc.j1.q2 q2, io.grpc.j1.i2 i22, io.grpc.j1.o2 o23, t0 t04, d d5, boolean z6) {
        Object obj2;
        io.grpc.j1.m1 obj4;
        super();
        n.p(t04, "headers");
        n.p(o23, "transportTracer");
        this.a = (o2)o23;
        this.c = r0.o(d5);
        this.d = z6;
        if (!z6) {
            obj4 = new m1(this, q2, i22);
            this.b = obj4;
            this.e = t04;
        } else {
            obj2 = new a.a(this, t04, i22);
            this.b = obj2;
        }
    }

    static Logger w() {
        return a.g;
    }

    @Override // io.grpc.j1.d
    public final boolean a() {
        boolean z;
        int i;
        if (super.a() && !this.f) {
            i = !this.f ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // io.grpc.j1.d
    public final void c(d1 d1) {
        final int i2 = 1;
        n.e(z ^= i2, "Should not cancel with OK status");
        this.f = i2;
        v().c(d1);
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
    public final void h(w w) {
        a.c.z(z(), w);
    }

    @Override // io.grpc.j1.d
    public final void j(io.grpc.j1.x0 x0) {
        x0.b("remote_addr", getAttributes().b(b0.a));
    }

    @Override // io.grpc.j1.d
    public final void k() {
        boolean z;
        if (!z().G()) {
            a.c.A(z());
            r();
        }
    }

    @Override // io.grpc.j1.d
    public void l(u u) {
        final io.grpc.t0.f fVar = r0.b;
        this.e.d(fVar);
        this.e.o(fVar, Long.valueOf(Math.max(0, obj5)));
    }

    @Override // io.grpc.j1.d
    public final void m(io.grpc.j1.r r) {
        Object cVar;
        int i;
        boolean obj3;
        z().K(r);
        if (!this.d) {
            i = 0;
            v().e(this.e, i);
            this.e = i;
        }
    }

    @Override // io.grpc.j1.d
    public final void p(io.grpc.j1.p2 p2, boolean z2, boolean z3, int i4) {
        int i;
        if (p2 == null) {
            if (z2) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        n.e(i, "null frame before EOS");
        v().d(p2, z2, z3, i4);
    }

    @Override // io.grpc.j1.d
    public final void q(boolean z) {
        a.c.y(z(), z);
    }

    @Override // io.grpc.j1.d
    protected final io.grpc.j1.p0 s() {
        return this.b;
    }

    @Override // io.grpc.j1.d
    protected io.grpc.j1.d.a u() {
        return z();
    }

    @Override // io.grpc.j1.d
    protected abstract io.grpc.j1.a.b v();

    @Override // io.grpc.j1.d
    protected io.grpc.j1.o2 x() {
        return this.a;
    }

    @Override // io.grpc.j1.d
    public final boolean y() {
        return this.c;
    }

    @Override // io.grpc.j1.d
    protected abstract io.grpc.j1.a.c z();
}
