package io.grpc.k1;

import com.google.common.base.n;
import com.google.common.io.BaseEncoding;
import i.a.c;
import io.grpc.d1;
import io.grpc.j1.a.b;
import io.grpc.j1.a.c;
import io.grpc.j1.d.a;
import io.grpc.j1.i2;
import io.grpc.j1.o2;
import io.grpc.j1.p2;
import io.grpc.j1.r.a;
import io.grpc.t0;
import io.grpc.u0.d;
import java.util.List;
import l.f;

/* compiled from: OkHttpClientStream.java */
/* loaded from: classes3.dex */
class g extends io.grpc.j1.a {

    private static final f r = new f();
    private final io.grpc.u0<?, ?> h;
    private final String i;
    private final i2 j;
    private String k;
    private Object l;
    private volatile int m;
    private final g.b n;
    private final g.a o;
    private final io.grpc.a p;
    private boolean q;

    class a implements a.b {

        final /* synthetic */ g a;
        a() {
            this.a = gVar;
            super();
        }

        public void c(d1 d1Var) {
            c.f("OkHttpClientStream$Sink.cancel");
            Object obj = this.a.n.y;
            synchronized (obj) {
                try {
                    this.a.n.a0(d1Var, 1, 0);
                } catch (Throwable th) {
                }
            }
            c.h("OkHttpClientStream$Sink.cancel");
        }

        public void d(p2 p2Var, boolean z, boolean z2, int i) {
            f fVar;
            str = "OkHttpClientStream$Sink.writeFrame";
            c.f(str);
            if (p2Var == null) {
                fVar = g.r;
            } else {
                i = (int)p2Var.e().size();
                if ("OkHttpClientStream$Sink.writeFrame" > 0) {
                    this.a.t(i);
                }
            }
            Object obj2 = this.a.n.y;
            synchronized (obj2) {
                try {
                    this.a.n.c0(fVar, z, z2);
                    this.a.x().e(i);
                } catch (Throwable th) {
                }
            }
            c.h("OkHttpClientStream$Sink.writeFrame");
        }

        public void e(t0 t0Var, byte[] bArr) {
            String str;
            c.f("OkHttpClientStream$Sink.writeHeaders");
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "/";
            String str2 = this.a.h.c();
            str = str6 + str2;
            if (bArr != null) {
                boolean z = true;
                this.a.q = z;
                StringBuilder stringBuilder2 = new StringBuilder();
                String str5 = "?";
                String str3 = BaseEncoding.b().f(bArr);
                str = str + str5 + str3;
            }
            Object obj = this.a.n.y;
            synchronized (obj) {
                try {
                    this.a.n.e0(t0Var, str);
                } catch (Throwable th) {
                }
            }
            c.h("OkHttpClientStream$Sink.writeHeaders");
        }
    }

    class b extends io.grpc.j1.u0 {

        private f A = new f();
        private boolean B = false;
        private boolean C = false;
        private boolean D = false;
        private int E;
        private int F;
        private final b G;
        private final p H;
        private final h I;
        private boolean J = true;
        private final i.a.d K;
        final /* synthetic */ g L;
        private final int x;
        private final Object y;
        private List<io.grpc.k1.r.j.d> z;
        public b(int i, i2 i2Var, Object object, b bVar, p pVar, h hVar, int i2, String str) {
            this.L = gVar;
            super(i, i2Var, gVar.x());
            f fVar = new f();
            n.p(object, "lock");
            this.y = object;
            this.G = bVar;
            this.H = pVar;
            this.I = hVar;
            this.E = i2;
            this.F = i2;
            this.x = i2;
            this.K = c.a(str);
        }

        static /* synthetic */ Object W(g.b bVar) {
            return bVar.y;
        }

        static /* synthetic */ void X(g.b bVar, t0 t0Var, String str) {
            bVar.e0(t0Var, str);
        }

        static /* synthetic */ void Y(g.b bVar, f fVar, boolean z, boolean z2) {
            bVar.c0(fVar, z, z2);
        }

        static /* synthetic */ void Z(g.b bVar, d1 d1Var, boolean z, t0 t0Var) {
            bVar.a0(d1Var, z, t0Var);
        }

        private void a0(d1 d1Var, boolean z, t0 t0Var) {
            if (this.D) {
                return;
            }
            boolean z4 = true;
            this.D = z4;
            if (this.J) {
                this.I.j0(this.L);
                this.z = null;
                this.A.a();
                z = false;
                this.J = z;
                if (t0Var == null) {
                    t0Var = new t0();
                }
                N(d1Var, z4, t0Var);
            } else {
                this.I.U(this.L.Q(), d1Var, r.a.PROCESSED, z, a.CANCEL, t0Var);
            }
        }

        private void b0() {
            if (!G()) {
                d1 d1Var = null;
                boolean z = false;
                t0 t0Var = null;
                this.I.U(this.L.Q(), d1Var, r.a.PROCESSED, z, a.CANCEL, t0Var);
            } else {
                d1 d1Var2 = null;
                boolean z2 = false;
                io.grpc.k1.r.j.a aVar = null;
                t0 t0Var2 = null;
                this.I.U(this.L.Q(), d1Var2, r.a.PROCESSED, z2, aVar, t0Var2);
            }
        }

        private void c0(f fVar, boolean z, boolean z2) {
            boolean z5 = false;
            if (this.D) {
                return;
            }
            if (this.J) {
                long size = fVar.size();
                i = (int)size;
                this.A.write(fVar, size);
                this.B |= z;
                this.C |= z2;
            } else {
                int r0 = this.L.Q() != -1 ? 1 : 0;
                n.v((this.L.Q() != -1 ? 1 : 0), "streamId should be set");
                (this.L.Q() != -1 ? 1 : 0).c(z, this.L.Q(), fVar, z2);
            }
        }

        private void e0(t0 t0Var, String str) {
            this.z = c.a(t0Var, str, this.L.k, this.L.i, this.L.q, this.I.d0());
            this.I.q0(this.L);
        }

        @Override // io.grpc.j1.u0
        protected void P(d1 d1Var, boolean z, t0 t0Var) {
            a0(d1Var, z, t0Var);
        }

        @Override // io.grpc.j1.u0
        public void b(boolean z) {
            b0();
            super.b(z);
        }

        @Override // io.grpc.j1.u0
        public void c(int i) {
            this.F -= i;
            float f3 = (float)i2;
            float f2 = (float)i3 * 0.5f;
            if (f3 <= f2) {
                int i6 = i3 - i2;
                this.E += i6;
                this.F = i2 + i6;
                this.G.windowUpdate(this.L.Q(), (long)i6);
            }
        }

        @Override // io.grpc.j1.u0
        public void d(Throwable th) {
            P(d1.l(th), true, new t0());
        }

        @Override // io.grpc.j1.u0
        public void d0(int i) {
            boolean z3 = true;
            io.grpc.k1.g gVar;
            long size;
            boolean z;
            long l = 0;
            int cmp;
            final boolean z5 = false;
            int r0 = this.L.m == -1 ? 1 : z5;
            str = "the stream has been started with id %s";
            n.w((this.L.m == -1 ? 1 : z5), "the stream has been started with id %s", i);
            (this.L.m == -1 ? 1 : z5).m = i;
            g.K(this.L).r();
            if (this.J) {
                int i3 = 0;
                this.G.T1(this.L.q, false, this.L.m, i3, this.z);
                this.L.j.c();
                this.z = null;
                size = this.A.size();
                l = 0L;
                if (size > l) {
                    this.H.c(this.B, this.L.m, this.A, this.C);
                }
                this.J = z5;
            }
        }

        @Override // io.grpc.j1.u0
        public void e(Runnable runnable) {
            synchronized (obj2) {
                try {
                    runnable.run();
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }

        @Override // io.grpc.j1.u0
        i.a.d f0() {
            return this.K;
        }

        @Override // io.grpc.j1.u0
        public void g0(f fVar, boolean z) {
            this.E -= i;
            if (this.E < 0) {
                this.G.p(this.L.Q(), a.FLOW_CONTROL_ERROR);
                this.I.U(this.L.Q(), d1.m.r("Received data size exceeded our receiving window size"), r.a.PROCESSED, false, a.NO_ERROR, null);
                return;
            }
            super.S(new k(fVar), z);
        }

        @Override // io.grpc.j1.u0
        public void h0(List<io.grpc.k1.r.j.d> list, boolean z) {
            if (z) {
                U(q.c(list));
            } else {
                T(q.a(list));
            }
        }

        @Override // io.grpc.j1.u0
        protected void r() {
            super.r();
            l().c();
        }
    }

    g(io.grpc.u0<?, ?> u0Var, t0 t0Var, b bVar, h hVar, p pVar, Object object, int i, int i2, String str, String str2, i2 i2Var, o2 o2Var, io.grpc.d dVar, boolean z) {
        boolean z2;
        final io.grpc.k1.g u0Var3 = this;
        Object i2Var112 = i2Var;
        boolean z3 = false;
        int i3 = !z || !u0Var.f() ? z3 : i;
        super(new o(), i2Var, o2Var, t0Var, dVar, z2);
        u0Var3.m = -1;
        u0Var3.o = new g.a(this);
        u0Var3.q = z3;
        n.p(i2Var112, "statsTraceCtx");
        u0Var3.j = (i2)i2Var112;
        u0Var3.h = u0Var;
        u0Var3.k = str;
        u0Var3.i = str2;
        u0Var3.p = hVar.W();
        super(this, i, i2Var, object, bVar, pVar, hVar, i2, u0Var.c());
        u0Var3.n = bVar;
    }

    static /* synthetic */ io.grpc.u0 B(g gVar) {
        return gVar.h;
    }

    static /* synthetic */ boolean C(g gVar) {
        return gVar.q;
    }

    static /* synthetic */ o2 D(g gVar) {
        return gVar.x();
    }

    static /* synthetic */ boolean E(g gVar, boolean z) {
        gVar.q = z;
        return z;
    }

    static /* synthetic */ int F(g gVar) {
        return gVar.m;
    }

    static /* synthetic */ int G(g gVar, int i) {
        gVar.m = i;
        return i;
    }

    static /* synthetic */ i2 H(g gVar) {
        return gVar.j;
    }

    static /* synthetic */ String I(g gVar) {
        return gVar.k;
    }

    static /* synthetic */ String J(g gVar) {
        return gVar.i;
    }

    static /* synthetic */ g.b K(g gVar) {
        return gVar.n;
    }

    static /* synthetic */ f L() {
        return g.r;
    }

    static /* synthetic */ void M(g gVar, int i) {
        gVar.t(i);
    }

    static /* synthetic */ o2 N(g gVar) {
        return gVar.x();
    }

    @Override // io.grpc.j1.a
    protected g.a A() {
        return this.o;
    }

    @Override // io.grpc.j1.a
    Object O() {
        return this.l;
    }

    @Override // io.grpc.j1.a
    public u0.d P() {
        return this.h.e();
    }

    @Override // io.grpc.j1.a
    public int Q() {
        return this.m;
    }

    @Override // io.grpc.j1.a
    void R(Object object) {
        this.l = object;
    }

    @Override // io.grpc.j1.a
    protected g.b S() {
        return this.n;
    }

    @Override // io.grpc.j1.a
    boolean T() {
        return this.q;
    }

    @Override // io.grpc.j1.a
    public io.grpc.a getAttributes() {
        return this.p;
    }

    @Override // io.grpc.j1.a
    public void i(String str) {
        n.p(str, "authority");
        this.k = str;
    }
}
