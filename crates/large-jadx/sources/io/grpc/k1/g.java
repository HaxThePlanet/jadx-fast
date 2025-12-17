package io.grpc.k1;

import com.google.common.base.n;
import com.google.common.io.BaseEncoding;
import i.a.c;
import i.a.d;
import io.grpc.a;
import io.grpc.d;
import io.grpc.d1;
import io.grpc.j1.a;
import io.grpc.j1.a.b;
import io.grpc.j1.a.c;
import io.grpc.j1.d;
import io.grpc.j1.d.a;
import io.grpc.j1.i2;
import io.grpc.j1.o2;
import io.grpc.j1.p2;
import io.grpc.j1.r.a;
import io.grpc.j1.u0;
import io.grpc.k1.r.j.a;
import io.grpc.k1.r.j.d;
import io.grpc.t0;
import io.grpc.u0;
import io.grpc.u0.d;
import java.util.List;
import l.f;

/* loaded from: classes3.dex */
class g extends a {

    private static final f r;
    private final u0<?, ?> h;
    private final String i;
    private final i2 j;
    private String k;
    private Object l;
    private volatile int m;
    private final io.grpc.k1.g.b n;
    private final io.grpc.k1.g.a o;
    private final a p;
    private boolean q;

    class a implements a.b {

        final io.grpc.k1.g a;
        a(io.grpc.k1.g g) {
            this.a = g;
            super();
        }

        @Override // io.grpc.j1.a$b
        public void c(d1 d1) {
            c.f("OkHttpClientStream$Sink.cancel");
            Object obj = g.b.W(g.K(this.a));
            g.b.Z(g.K(this.a), d1, true, 0);
            c.h("OkHttpClientStream$Sink.cancel");
            return;
            synchronized (obj) {
                c.f("OkHttpClientStream$Sink.cancel");
                obj = g.b.W(g.K(this.a));
                g.b.Z(g.K(this.a), d1, true, 0);
                c.h("OkHttpClientStream$Sink.cancel");
            }
        }

        @Override // io.grpc.j1.a$b
        public void d(p2 p2, boolean z2, boolean z3, int i4) {
            String str;
            io.grpc.k1.g gVar;
            f obj3;
            c.f("OkHttpClientStream$Sink.writeFrame");
            if (p2 == null) {
                obj3 = g.L();
            } else {
                str = (int)size;
                if (str > 0) {
                    g.M(this.a, str);
                }
            }
            Object obj = g.b.W(g.K(this.a));
            g.b.Y(g.K(this.a), obj3, z2, z3);
            g.N(this.a).e(i4);
            c.h("OkHttpClientStream$Sink.writeFrame");
            return;
            synchronized (obj) {
                obj = g.b.W(g.K(this.a));
                g.b.Y(g.K(this.a), obj3, z2, z3);
                g.N(this.a).e(i4);
                c.h("OkHttpClientStream$Sink.writeFrame");
            }
        }

        @Override // io.grpc.j1.a$b
        public void e(t0 t0, byte[] b2Arr2) {
            String string;
            Object stringBuilder;
            int i;
            byte[] obj5;
            c.f("OkHttpClientStream$Sink.writeHeaders");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("/");
            stringBuilder2.append(g.B(this.a).c());
            if (b2Arr2 != null) {
                g.E(this.a, true);
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder.append("?");
                stringBuilder.append(BaseEncoding.b().f(b2Arr2));
                string = stringBuilder.toString();
            }
            obj5 = g.b.W(g.K(this.a));
            g.b.X(g.K(this.a), t0, string);
            c.h("OkHttpClientStream$Sink.writeHeaders");
            return;
            synchronized (obj5) {
                obj5 = g.b.W(g.K(this.a));
                g.b.X(g.K(this.a), t0, string);
                c.h("OkHttpClientStream$Sink.writeHeaders");
            }
        }
    }

    class b extends u0 {

        private f A;
        private boolean B = false;
        private boolean C = false;
        private boolean D = false;
        private int E;
        private int F;
        private final io.grpc.k1.b G;
        private final io.grpc.k1.p H;
        private final io.grpc.k1.h I;
        private boolean J = true;
        private final d K;
        final io.grpc.k1.g L;
        private final int x;
        private final Object y;
        private List<d> z;
        public b(io.grpc.k1.g g, int i2, i2 i23, Object object4, io.grpc.k1.b b5, io.grpc.k1.p p6, io.grpc.k1.h h7, int i8, String string9) {
            this.L = g;
            super(i2, i23, g.D(g));
            f obj1 = new f();
            this.A = obj1;
            obj1 = 0;
            obj1 = 1;
            n.p(object4, "lock");
            this.y = object4;
            this.G = b5;
            this.H = p6;
            this.I = h7;
            this.E = i8;
            this.F = i8;
            this.x = i8;
            this.K = c.a(string9);
        }

        static Object W(io.grpc.k1.g.b g$b) {
            return b.y;
        }

        static void X(io.grpc.k1.g.b g$b, t0 t02, String string3) {
            b.e0(t02, string3);
        }

        static void Y(io.grpc.k1.g.b g$b, f f2, boolean z3, boolean z4) {
            b.c0(f2, z3, z4);
        }

        static void Z(io.grpc.k1.g.b g$b, d1 d12, boolean z3, t0 t04) {
            b.a0(d12, z3, t04);
        }

        private void a0(d1 d1, boolean z2, t0 t03) {
            io.grpc.k1.g i;
            Object hVar;
            int i2;
            d1 d1Var;
            r.a pROCESSED;
            boolean z;
            a cANCEL;
            t0 t0Var;
            int obj10;
            t0 obj11;
            if (this.D) {
            }
            i = 1;
            this.D = i;
            if (this.J) {
                this.I.j0(this.L);
                this.z = 0;
                this.A.a();
                this.J = false;
                if (t03 != null) {
                } else {
                    obj11 = new t0();
                }
                N(d1, i, obj11);
            } else {
                this.I.U(this.L.Q(), d1, r.a.PROCESSED, z2, a.CANCEL, t03);
            }
        }

        private void b0() {
            io.grpc.k1.g gVar;
            io.grpc.k1.h hVar;
            int i9;
            int i8;
            r.a pROCESSED2;
            int i6;
            a cANCEL;
            int i5;
            io.grpc.k1.h hVar2;
            int i4;
            int i;
            r.a pROCESSED;
            int i3;
            int i2;
            int i7;
            if (!G()) {
                this.I.U(this.L.Q(), 0, r.a.PROCESSED, false, a.CANCEL, 0);
            } else {
                this.I.U(this.L.Q(), 0, r.a.PROCESSED, false, 0, 0);
            }
        }

        private void c0(f f, boolean z2, boolean z3) {
            int i;
            int i2;
            f fVar;
            long l;
            int obj5;
            if (this.D) {
            }
            if (this.J) {
                this.A.write(f, (long)i);
                this.B = obj5 |= z2;
                this.C = obj5 |= z3;
            } else {
                i2 = this.L.Q() != -1 ? 1 : 0;
                n.v(i2, "streamId should be set");
                this.H.c(z2, this.L.Q(), f, z3);
            }
        }

        private void e0(t0 t0, String string2) {
            this.z = c.a(t0, string2, g.I(this.L), g.J(this.L), g.C(this.L), this.I.d0());
            this.I.q0(this.L);
        }

        @Override // io.grpc.j1.u0
        protected void P(d1 d1, boolean z2, t0 t03) {
            a0(d1, z2, t03);
        }

        @Override // io.grpc.j1.u0
        public void b(boolean z) {
            b0();
            super.b(z);
        }

        @Override // io.grpc.j1.u0
        public void c(int i) {
            int i3;
            int i2;
            int obj5;
            i4 -= i;
            this.F = i3;
            i2 = this.x;
            f *= i8;
            if (Float.compare(obj5, i7) <= 0) {
                i2 -= i3;
                this.E = obj5 += i6;
                this.F = i3 += i6;
                this.G.windowUpdate(this.L.Q(), (long)i6);
            }
        }

        @Override // io.grpc.j1.u0
        public void d(Throwable throwable) {
            t0 t0Var = new t0();
            P(d1.l(throwable), true, t0Var);
        }

        @Override // io.grpc.j1.u0
        public void d0(int i) {
            int i4;
            io.grpc.k1.g gVar;
            String size;
            boolean z;
            int i5;
            int i2;
            int i3;
            List list;
            boolean obj9;
            final int i7 = 0;
            i4 = g.F(this.L) == -1 ? 1 : i7;
            n.w(i4, "the stream has been started with id %s", i);
            g.G(this.L, i);
            g.K(this.L).r();
            this.G.T1(g.C(this.L), false, g.F(this.L), 0, this.z);
            g.H(this.L).c();
            this.z = 0;
            if (this.J && Long.compare(size, i5) > 0) {
                this.G.T1(g.C(this.L), false, g.F(this.L), 0, this.z);
                g.H(this.L).c();
                this.z = 0;
                if (Long.compare(size, i5) > 0) {
                    this.H.c(this.B, g.F(this.L), this.A, this.C);
                }
                this.J = i7;
            }
        }

        @Override // io.grpc.j1.u0
        public void e(Runnable runnable) {
            final Object obj = this.y;
            runnable.run();
            return;
            synchronized (obj) {
                obj = this.y;
                runnable.run();
            }
        }

        @Override // io.grpc.j1.u0
        d f0() {
            return this.K;
        }

        @Override // io.grpc.j1.u0
        public void g0(f f, boolean z2) {
            i2 -= i;
            this.E = i3;
            if (i3 < 0) {
                this.G.p(this.L.Q(), a.FLOW_CONTROL_ERROR);
                this.I.U(this.L.Q(), d1.m.r("Received data size exceeded our receiving window size"), r.a.PROCESSED, false, 0, 0);
            }
            k kVar = new k(f);
            super.S(kVar, z2);
        }

        public void h0(List<d> list, boolean z2) {
            t0 obj1;
            if (z2) {
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
    static {
        f fVar = new f();
        g.r = fVar;
    }

    g(u0<?, ?> u0, t0 t02, io.grpc.k1.b b3, io.grpc.k1.h h4, io.grpc.k1.p p5, Object object6, int i7, int i8, String string9, String string10, i2 i211, o2 o212, d d13, boolean z14) {
        boolean z;
        int i;
        final Object obj4 = this;
        Object obj3 = i211;
        o oVar = new o();
        int i4 = 0;
        if (z14 && u0.f()) {
            i = u0.f() ? z : i4;
        } else {
        }
        super(oVar, i211, o212, t02, d13, i);
        obj4.m = -1;
        g.a aVar = new g.a(this);
        obj4.o = aVar;
        obj4.q = i4;
        n.p(obj3, "statsTraceCtx");
        obj4.j = (i2)obj3;
        obj4.h = u0;
        obj4.k = string9;
        obj4.i = string10;
        obj4.p = h4.W();
        super(this, i7, i211, object6, b3, p5, h4, i8, u0.c());
        obj4.n = bVar3;
    }

    static u0 B(io.grpc.k1.g g) {
        return g.h;
    }

    static boolean C(io.grpc.k1.g g) {
        return g.q;
    }

    static o2 D(io.grpc.k1.g g) {
        return g.x();
    }

    static boolean E(io.grpc.k1.g g, boolean z2) {
        g.q = z2;
        return z2;
    }

    static int F(io.grpc.k1.g g) {
        return g.m;
    }

    static int G(io.grpc.k1.g g, int i2) {
        g.m = i2;
        return i2;
    }

    static i2 H(io.grpc.k1.g g) {
        return g.j;
    }

    static String I(io.grpc.k1.g g) {
        return g.k;
    }

    static String J(io.grpc.k1.g g) {
        return g.i;
    }

    static io.grpc.k1.g.b K(io.grpc.k1.g g) {
        return g.n;
    }

    static f L() {
        return g.r;
    }

    static void M(io.grpc.k1.g g, int i2) {
        g.t(i2);
    }

    static o2 N(io.grpc.k1.g g) {
        return g.x();
    }

    @Override // io.grpc.j1.a
    protected io.grpc.k1.g.a A() {
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
    protected io.grpc.k1.g.b S() {
        return this.n;
    }

    @Override // io.grpc.j1.a
    boolean T() {
        return this.q;
    }

    @Override // io.grpc.j1.a
    public a getAttributes() {
        return this.p;
    }

    @Override // io.grpc.j1.a
    public void i(String string) {
        n.p(string, "authority");
        this.k = (String)string;
    }

    @Override // io.grpc.j1.a
    protected d.a u() {
        return S();
    }

    @Override // io.grpc.j1.a
    protected a.b v() {
        return A();
    }

    @Override // io.grpc.j1.a
    protected a.c z() {
        return S();
    }
}
