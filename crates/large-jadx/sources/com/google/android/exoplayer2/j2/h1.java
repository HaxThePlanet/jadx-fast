package com.google.android.exoplayer2.j2;

import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.s;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.g2.b;
import com.google.android.exoplayer2.g2.c;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.n2.k;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.g.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.u.a;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.v1.b;
import com.google.android.exoplayer2.v1.e;
import com.google.android.exoplayer2.v1.f;
import com.google.android.exoplayer2.video.a0;
import com.google.android.exoplayer2.video.z;
import com.google.android.exoplayer2.w0;
import com.google.common.base.k;
import com.google.common.collect.a0;
import com.google.common.collect.v;
import com.google.common.collect.x;
import com.google.common.collect.x.a;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public class h1 implements v1.e, s, z, z, g.a, u {

    private boolean A;
    private final i a;
    private final g2.b b;
    private final g2.c c;
    private final com.google.android.exoplayer2.j2.h1.a v;
    private final SparseArray<com.google.android.exoplayer2.j2.i1.a> w;
    private u<com.google.android.exoplayer2.j2.i1> x;
    private v1 y;
    private s z;

    private static final class a {

        private final g2.b a;
        private v<y.a> b;
        private x<y.a, g2> c;
        private y.a d;
        private y.a e;
        private y.a f;
        public a(g2.b g2$b) {
            super();
            this.a = b;
            this.b = v.z();
            this.c = x.k();
        }

        static v a(com.google.android.exoplayer2.j2.h1.a h1$a) {
            return a.b;
        }

        private void b(x.a<y.a, g2> x$a, y.a y$a2, g2 g23) {
            Object obj5;
            if (a2 == null) {
            }
            if (g23.b(a2.a) != -1) {
                a.c(a2, g23);
            } else {
                obj5 = this.c.get(a2);
                if ((g2)obj5 != null) {
                    a.c(a2, (g2)obj5);
                }
            }
        }

        private static y.a c(v1 v1, v<y.a> v2, y.a y$a3, g2.b g2$b4) {
            Object g2Var;
            int i5;
            int i6;
            int i2;
            boolean z;
            long l2;
            long l;
            int i;
            int i3;
            int i4;
            boolean obj10;
            int obj13;
            g2Var = v1.O();
            i6 = v1.p();
            final int i7 = 0;
            if (g2Var.q()) {
                i2 = i7;
            } else {
                i2 = g2Var.m(i6);
            }
            if (!v1.h()) {
                if (g2Var.q()) {
                    obj13 = -1;
                } else {
                    obj13 = g2Var.f(i6, b4).d(l4 -= l);
                }
            } else {
            }
            i5 = 0;
            while (i5 < v2.size()) {
                i6 = v2.get(i5);
                i5++;
            }
            if (v2.isEmpty() && a3 != null && h1.a.i(a3, i2, v1.h(), v1.H(), v1.u(), obj13)) {
                if (a3 != null) {
                    if (h1.a.i(a3, i2, v1.h(), v1.H(), v1.u(), obj13)) {
                        return a3;
                    }
                }
            }
            return i7;
        }

        private static boolean i(y.a y$a, Object object2, boolean z3, int i4, int i5, int i6) {
            int i;
            Object obj1;
            boolean obj2;
            int obj3;
            if (!a.a.equals(object2)) {
                return 0;
            }
            if (z3 != 0 && a.b == i4) {
                if (a.b == i4) {
                    if (a.c != i5) {
                        if (z3 == 0 && a.b == -1 && a.e == i6) {
                            if (a.b == -1) {
                                if (a.e == i6) {
                                    i = 1;
                                }
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        private void m(g2 g2) {
            boolean contains;
            int i;
            boolean z;
            y.a aVar;
            Object obj;
            final x.a aVar2 = x.a();
            if (this.b.isEmpty()) {
                b(aVar2, this.e, g2);
                if (!k.a(this.f, this.e)) {
                    b(aVar2, this.f, g2);
                }
                if (!k.a(this.d, this.e) && !k.a(this.d, this.f)) {
                    if (!k.a(this.d, this.f)) {
                        b(aVar2, this.d, g2);
                    }
                }
            } else {
                i = 0;
                while (i < this.b.size()) {
                    b(aVar2, (y.a)this.b.get(i), g2);
                    i++;
                }
                if (!this.b.contains(this.d)) {
                    b(aVar2, this.d, g2);
                }
            }
            this.c = aVar2.a();
        }

        public y.a d() {
            return this.d;
        }

        public y.a e() {
            int i;
            if (this.b.isEmpty()) {
                i = 0;
            } else {
                i = a0.c(this.b);
            }
            return i;
        }

        public g2 f(y.a y$a) {
            return (g2)this.c.get(a);
        }

        public y.a g() {
            return this.e;
        }

        public y.a h() {
            return this.f;
        }

        public void j(v1 v1) {
            this.d = h1.a.c(v1, this.b, this.e, this.a);
        }

        public void k(List<y.a> list, y.a y$a2, v1 v13) {
            boolean empty;
            Object obj2;
            Object obj3;
            this.b = v.u(list);
            if (!list.isEmpty()) {
                this.e = (y.a)list.get(0);
                g.e(a2);
                this.f = (y.a)a2;
            }
            if (this.d == null) {
                this.d = h1.a.c(v13, this.b, this.e, this.a);
            }
            m(v13.O());
        }

        public void l(v1 v1) {
            this.d = h1.a.c(v1, this.b, this.e, this.a);
            m(v1.O());
        }
    }
    public h1(i i) {
        super();
        g.e(i);
        this.a = (i)i;
        u uVar = new u(p0.J(), i, m0.a);
        this.x = uVar;
        g2.b obj4 = new g2.b();
        this.b = obj4;
        g2.c cVar = new g2.c();
        this.c = cVar;
        h1.a aVar = new h1.a(obj4);
        this.v = aVar;
        obj4 = new SparseArray();
        this.w = obj4;
    }

    static void A0(com.google.android.exoplayer2.j2.i1.a i1$a, d d2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.t(a, d2);
        i13.l0(a, 1, d2);
    }

    private void A1() {
        this.x.h();
    }

    static void B0(com.google.android.exoplayer2.j2.i1.a i1$a, d d2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.u(a, d2);
        i13.w(a, 1, d2);
    }

    static void C0(com.google.android.exoplayer2.j2.i1.a i1$a, i1 i12, e e3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.H(a, i12);
        i14.i0(a, i12, e3);
        i14.d(a, 1, i12);
    }

    private void C1(v1 v1, com.google.android.exoplayer2.j2.i1 i12, q q3) {
        i1.b bVar = new i1.b(q3, this.w);
        i12.D(v1, bVar);
    }

    static void D0(com.google.android.exoplayer2.j2.i1.a i1$a, long l2, com.google.android.exoplayer2.j2.i1 i13) {
        obj3.N(a, l2);
    }

    static void E0(com.google.android.exoplayer2.j2.i1.a i1$a, Exception exception2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.X(a, exception2);
    }

    static void F0(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, long l3, long l4, com.google.android.exoplayer2.j2.i1 i15) {
        obj13.r(a, i2, l3, obj4);
    }

    static void G0(com.google.android.exoplayer2.j2.i1.a i1$a, v1.b v1$b2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.j0(a, b2);
    }

    static void H0(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, long l3, long l4, com.google.android.exoplayer2.j2.i1 i15) {
        obj13.a(a, i2, l3, obj4);
    }

    static void I0(com.google.android.exoplayer2.j2.i1.a i1$a, v v2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.S(a, v2);
    }

    static void J0(com.google.android.exoplayer2.j2.i1.a i1$a, com.google.android.exoplayer2.j2.i1 i12) {
        i12.I(a);
    }

    static void K0(com.google.android.exoplayer2.j2.i1.a i1$a, com.google.android.exoplayer2.j2.i1 i12) {
        i12.q0(a);
    }

    static void L0(com.google.android.exoplayer2.j2.i1.a i1$a, com.google.android.exoplayer2.j2.i1 i12) {
        i12.n(a);
    }

    static void M0(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.n0(a);
        i13.f(a, i2);
    }

    static void N0(com.google.android.exoplayer2.j2.i1.a i1$a, Exception exception2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.l(a, exception2);
    }

    static void O0(com.google.android.exoplayer2.j2.i1.a i1$a, com.google.android.exoplayer2.j2.i1 i12) {
        i12.m(a);
    }

    static void P0(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, long l3, com.google.android.exoplayer2.j2.i1 i14) {
        obj4.V(a, i2, l3);
    }

    static void Q0(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.q(a, z2);
        i13.o0(a, z2);
    }

    static void R0(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.Q(a, z2);
    }

    static void S0(com.google.android.exoplayer2.j2.i1.a i1$a, s s2, v v3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.L(a, s2, v3);
    }

    static void T0(com.google.android.exoplayer2.j2.i1.a i1$a, s s2, v v3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.T(a, s2, v3);
    }

    static void U0(com.google.android.exoplayer2.j2.i1.a i1$a, s s2, v v3, IOException iOException4, boolean z5, com.google.android.exoplayer2.j2.i1 i16) {
        i16.v(a, s2, v3, iOException4, z5);
    }

    static void V0(com.google.android.exoplayer2.j2.i1.a i1$a, s s2, v v3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.h(a, s2, v3);
    }

    static void W0(com.google.android.exoplayer2.j2.i1.a i1$a, m1 m12, int i3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.h0(a, m12, i3);
    }

    static void X0(com.google.android.exoplayer2.j2.i1.a i1$a, n1 n12, com.google.android.exoplayer2.j2.i1 i13) {
        i13.s(a, n12);
    }

    static void Y0(com.google.android.exoplayer2.j2.i1.a i1$a, a a2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.A(a, a2);
    }

    static void Z0(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2, int i3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.a0(a, z2, i3);
    }

    static void a1(com.google.android.exoplayer2.j2.i1.a i1$a, u1 u12, com.google.android.exoplayer2.j2.i1 i13) {
        i13.p(a, u12);
    }

    static void b1(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.G(a, i2);
    }

    static void c1(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.o(a, i2);
    }

    static void d1(com.google.android.exoplayer2.j2.i1.a i1$a, PlaybackException playbackException2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.j(a, playbackException2);
    }

    static void e1(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2, int i3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.E(a, z2, i3);
    }

    static void f1(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, v1.f v1$f3, v1.f v1$f4, com.google.android.exoplayer2.j2.i1 i15) {
        i15.k(a, i2);
        i15.W(a, f3, f4, i2);
    }

    static void g1(com.google.android.exoplayer2.j2.i1.a i1$a, Object object2, long l3, com.google.android.exoplayer2.j2.i1 i14) {
        obj4.k0(a, object2, l3);
    }

    static void h1(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.B(a, i2);
    }

    static void i1(com.google.android.exoplayer2.j2.i1.a i1$a, com.google.android.exoplayer2.j2.i1 i12) {
        i12.g(a);
    }

    static void j1(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.P(a, z2);
    }

    static void k1(com.google.android.exoplayer2.j2.i1.a i1$a, boolean z2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.Y(a, z2);
    }

    static void l1(com.google.android.exoplayer2.j2.i1.a i1$a, List list2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.m0(a, list2);
    }

    static void m1(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, int i3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.O(a, i2, i3);
    }

    static void n1(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.e0(a, i2);
    }

    static void o1(com.google.android.exoplayer2.j2.i1.a i1$a, l0 l02, k k3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.M(a, l02, k3);
    }

    static void p1(com.google.android.exoplayer2.j2.i1.a i1$a, v v2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.U(a, v2);
    }

    private com.google.android.exoplayer2.j2.i1.a q0(y.a y$a) {
        g2 g2Var;
        g2 g2Var2;
        int i;
        g.e(this.y);
        int i2 = 0;
        if (a == null) {
            g2Var = i2;
        } else {
            g2Var = this.v.f(a);
        }
        if (a != null && g2Var == null) {
            if (g2Var == null) {
            }
            return p0(g2Var, bVar.c, a);
        }
        int obj4 = this.y.x();
        i = obj4 < this.y.O().p() ? 1 : 0;
        if (i != 0) {
        } else {
            g2Var2 = g2.a;
        }
        return p0(g2Var2, obj4, i2);
    }

    static void q1(com.google.android.exoplayer2.j2.i1.a i1$a, Exception exception2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.d0(a, exception2);
    }

    private com.google.android.exoplayer2.j2.i1.a r0() {
        return q0(this.v.e());
    }

    static void r1(com.google.android.exoplayer2.j2.i1.a i1$a, String string2, long l3, long l4, com.google.android.exoplayer2.j2.i1 i15) {
        obj13.f0(a, string2, l3);
        final long l2 = l3;
        obj13.b0(a, string2, i15, obj4);
        obj13.i(a, 2, string2, l2);
    }

    private com.google.android.exoplayer2.j2.i1.a s0(int i, y.a y$a2) {
        int i2;
        com.google.android.exoplayer2.j2.i1.a obj4;
        g2 obj5;
        g.e(this.y);
        i2 = 1;
        final int i4 = 0;
        if (a2 != null) {
            if (this.v.f(a2) != null) {
            } else {
                i2 = i4;
            }
            if (i2 != 0) {
                obj4 = q0(a2);
            } else {
                obj4 = p0(g2.a, i, a2);
            }
            return obj4;
        }
        if (i < this.y.O().p()) {
        } else {
            i2 = i4;
        }
        if (i2 != 0) {
        } else {
            obj5 = g2.a;
        }
        return p0(obj5, i, 0);
    }

    static void s1(com.google.android.exoplayer2.j2.i1.a i1$a, String string2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.c(a, string2);
    }

    private com.google.android.exoplayer2.j2.i1.a t0() {
        return q0(this.v.g());
    }

    static void t1(com.google.android.exoplayer2.j2.i1.a i1$a, d d2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.p0(a, d2);
        i13.l0(a, 2, d2);
    }

    private com.google.android.exoplayer2.j2.i1.a u0() {
        return q0(this.v.h());
    }

    static void u1(com.google.android.exoplayer2.j2.i1.a i1$a, d d2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.x(a, d2);
        i13.w(a, 2, d2);
    }

    static void v0(com.google.android.exoplayer2.j2.i1 i1, q q2) {
    }

    static void v1(com.google.android.exoplayer2.j2.i1.a i1$a, long l2, int i3, com.google.android.exoplayer2.j2.i1 i14) {
        obj4.e(a, l2, i3);
    }

    static void w0(com.google.android.exoplayer2.j2.i1.a i1$a, com.google.android.exoplayer2.j2.i1 i12) {
        i12.g0(a);
    }

    static void w1(com.google.android.exoplayer2.j2.i1.a i1$a, i1 i12, e e3, com.google.android.exoplayer2.j2.i1 i14) {
        i14.J(a, i12);
        i14.c0(a, i12, e3);
        i14.d(a, 2, i12);
    }

    static void x0(com.google.android.exoplayer2.j2.i1.a i1$a, Exception exception2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.R(a, exception2);
    }

    static void x1(com.google.android.exoplayer2.j2.i1.a i1$a, a0 a02, com.google.android.exoplayer2.j2.i1 i13) {
        i13.F(a, a02);
        i13.b(a, a02.a, a02.b, a02.c, a02.d);
    }

    static void y0(com.google.android.exoplayer2.j2.i1.a i1$a, String string2, long l3, long l4, com.google.android.exoplayer2.j2.i1 i15) {
        obj13.z(a, string2, l3);
        final long l2 = l3;
        obj13.y(a, string2, i15, obj4);
        obj13.i(a, 1, string2, l2);
    }

    static void y1(com.google.android.exoplayer2.j2.i1.a i1$a, float f2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.K(a, f2);
    }

    static void z0(com.google.android.exoplayer2.j2.i1.a i1$a, String string2, com.google.android.exoplayer2.j2.i1 i13) {
        i13.Z(a, string2);
    }

    static void z1(com.google.android.exoplayer2.j2.i1.a i1$a, com.google.android.exoplayer2.j2.i1 i12) {
        i12.C(a);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public void A(boolean z) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        l0 l0Var = new l0(aVar, z);
        G1(aVar, 8, l0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public void B1() {
        A1();
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void D(d d) {
        final com.google.android.exoplayer2.j2.i1.a aVar = t0();
        q qVar = new q(aVar, d);
        G1(aVar, 1014, qVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public void D1(v1 v1, com.google.android.exoplayer2.j2.i1 i12, q q3) {
        C1(v1, i12, q3);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void E(String string) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        n0 n0Var = new n0(aVar, string);
        G1(aVar, 1024, n0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void E1() {
        boolean z;
        int i;
        com.google.android.exoplayer2.j2.o oVar;
        if (!this.A) {
            z = o0();
            this.A = true;
            oVar = new o(z);
            G1(z, -1, oVar);
        }
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void F(d d) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        n nVar = new n(aVar, d);
        G1(aVar, 1008, nVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public void F1() {
        com.google.android.exoplayer2.j2.i1.a aVar = o0();
        final int i = 1036;
        this.w.put(i, aVar);
        y yVar = new y(aVar);
        G1(aVar, i, yVar);
        s sVar = this.z;
        g.h(sVar);
        v vVar = new v(this);
        (s)sVar.b(vVar);
    }

    @Deprecated
    public final void G(List<a> list) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        t tVar = new t(aVar, list);
        G1(aVar, 3, tVar);
    }

    protected final void G1(com.google.android.exoplayer2.j2.i1.a i1$a, int i2, u.a<com.google.android.exoplayer2.j2.i1> u$a3) {
        this.w.put(i2, a);
        this.x.j(i2, a3);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void H(String string, long l2, long l3) {
        final com.google.android.exoplayer2.j2.i1.a aVar2 = u0();
        super(aVar2, string, obj13, obj4, l2, obj6);
        G1(aVar2, 1021, bVar2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public void H1(v1 v1, Looper looper2) {
        int i;
        v1 empty;
        if (this.y != null) {
            if (h1.a.a(this.v).isEmpty()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        g.f(i);
        g.e(v1);
        this.y = (v1)v1;
        this.z = this.a.c(looper2, 0);
        f fVar = new f(this, v1);
        this.x = this.x.b(looper2, fVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void I(int i, y.a y$a2, v v3) {
        final com.google.android.exoplayer2.j2.i1.a obj1 = s0(i, a2);
        d1 obj2 = new d1(obj1, v3);
        G1(obj1, 1004, obj2);
    }

    public final void I1(List<y.a> list, y.a y$a2) {
        final v1 v1Var = this.y;
        g.e(v1Var);
        this.v.k(list, a2, (v1)v1Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void J(int i, y.a y$a2, s s3, v v4) {
        final com.google.android.exoplayer2.j2.i1.a obj1 = s0(i, a2);
        q0 obj2 = new q0(obj1, s3, v4);
        G1(obj1, 1002, obj2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void K(int i, y.a y$a2, v v3) {
        final com.google.android.exoplayer2.j2.i1.a obj1 = s0(i, a2);
        w0 obj2 = new w0(obj1, v3);
        G1(obj1, 1005, obj2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void L() {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        r0 r0Var = new r0(aVar);
        G1(aVar, -1, r0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void M(int i, y.a y$a2, Exception exception3) {
        final com.google.android.exoplayer2.j2.i1.a obj1 = s0(i, a2);
        w obj2 = new w(obj1, exception3);
        G1(obj1, 1032, obj2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void N(int i, y.a y$a2, s s3, v v4) {
        final com.google.android.exoplayer2.j2.i1.a obj1 = s0(i, a2);
        s obj2 = new s(obj1, s3, v4);
        G1(obj1, 1000, obj2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void O(int i, long l2, long l3) {
        final com.google.android.exoplayer2.j2.i1.a aVar2 = r0();
        super(aVar2, i, l2, obj4, obj13, obj6);
        G1(aVar2, 1006, c0Var2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void P(String string) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        e eVar = new e(aVar, string);
        G1(aVar, 1013, eVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void Q(String string, long l2, long l3) {
        final com.google.android.exoplayer2.j2.i1.a aVar2 = u0();
        super(aVar2, string, obj13, obj4, l2, obj6);
        G1(aVar2, 1009, g0Var2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void R(int i, long l2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = t0();
        z zVar = new z(aVar, i, l2, obj5);
        G1(aVar, 1023, zVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void S(boolean z, int i2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        a0 a0Var = new a0(aVar, z, i2);
        G1(aVar, -1, a0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void T(i1 i1, e e2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        e0 e0Var = new e0(aVar, i1, e2);
        G1(aVar, 1010, e0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void U(int i, y.a y$a2) {
        final com.google.android.exoplayer2.j2.i1.a obj2 = s0(i, a2);
        x obj3 = new x(obj2);
        G1(obj2, 1034, obj3);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void W(Object object, long l2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        j0 j0Var = new j0(aVar, object, l2, obj5);
        G1(aVar, 1027, j0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void Z(d d) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        j jVar = new j(aVar, d);
        G1(aVar, 1020, jVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void a(boolean z) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        d0 d0Var = new d0(aVar, z);
        G1(aVar, 1017, d0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void a0(i1 i1, e e2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        t0 t0Var = new t0(aVar, i1, e2);
        G1(aVar, 1022, t0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void b(a0 a0) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        g1 g1Var = new g1(aVar, a0);
        G1(aVar, 1028, g1Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void b0(long l) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        x0 x0Var = new x0(aVar, l, obj4);
        G1(aVar, 1011, x0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void c(u1 u1) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        r rVar = new r(aVar, u1);
        G1(aVar, 13, rVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void c0(int i, y.a y$a2) {
        final com.google.android.exoplayer2.j2.i1.a obj2 = s0(i, a2);
        p obj3 = new p(obj2);
        G1(obj2, 1031, obj3);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void d(v1.f v1$f, v1.f v1$f2, int i3) {
        int i;
        if (i3 == 1) {
            this.A = false;
        }
        v1 v1Var = this.y;
        g.e(v1Var);
        this.v.j((v1)v1Var);
        com.google.android.exoplayer2.j2.i1.a aVar2 = o0();
        c1 c1Var = new c1(aVar2, i3, f, f2);
        G1(aVar2, 12, c1Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void d0(Exception exception) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        a1 a1Var = new a1(aVar, exception);
        G1(aVar, 1037, a1Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void e(int i) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        a aVar2 = new a(aVar, i);
        G1(aVar, 7, aVar2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void f(boolean z) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        k kVar = new k(aVar, z);
        G1(aVar, 4, kVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void f0(Exception exception) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        d dVar = new d(aVar, exception);
        G1(aVar, 1038, dVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void g(PlaybackException playbackException) {
        boolean mediaPeriodId;
        int i;
        y.a aVar;
        mediaPeriodId = obj.mediaPeriodId;
        if (playbackException instanceof ExoPlaybackException != null && mediaPeriodId != null) {
            mediaPeriodId = obj.mediaPeriodId;
            if (mediaPeriodId != null) {
                aVar = new y.a(mediaPeriodId);
                i = q0(aVar);
            } else {
                i = 0;
            }
        } else {
        }
        if (i == 0) {
            i = o0();
        }
        p0 p0Var = new p0(i, playbackException);
        G1(i, 11, p0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void g0(int i, y.a y$a2, s s3, v v4) {
        final com.google.android.exoplayer2.j2.i1.a obj1 = s0(i, a2);
        m obj2 = new m(obj1, s3, v4);
        G1(obj1, 1001, obj2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public void h(v1.b v1$b) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        c cVar = new c(aVar, b);
        G1(aVar, 14, cVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void h0(d d) {
        final com.google.android.exoplayer2.j2.i1.a aVar = t0();
        o0 o0Var = new o0(aVar, d);
        G1(aVar, 1025, o0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void i(int i) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        f1 f1Var = new f1(aVar, i);
        G1(aVar, 9, f1Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void i0(int i, y.a y$a2, int i3) {
        final com.google.android.exoplayer2.j2.i1.a obj1 = s0(i, a2);
        i0 obj2 = new i0(obj1, i3);
        G1(obj1, 1030, obj2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void j(g2 g2, int i2) {
        v1 v1Var = this.y;
        g.e(v1Var);
        this.v.l((v1)v1Var);
        com.google.android.exoplayer2.j2.i1.a obj2 = o0();
        u0 u0Var = new u0(obj2, i2);
        G1(obj2, 0, u0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void j0(int i, y.a y$a2) {
        final com.google.android.exoplayer2.j2.i1.a obj2 = s0(i, a2);
        u obj3 = new u(obj2);
        G1(obj2, 1035, obj3);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void k(float f) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        e1 e1Var = new e1(aVar, f);
        G1(aVar, 1019, e1Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void k0(int i, long l2, long l3) {
        final com.google.android.exoplayer2.j2.i1.a aVar2 = u0();
        super(aVar2, i, l2, obj4, obj13, obj6);
        G1(aVar2, 1012, b1Var2);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void l(int i) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        s0 s0Var = new s0(aVar, i);
        G1(aVar, 5, s0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void l0(int i, y.a y$a2, s s3, v v4, IOException iOException5, boolean z6) {
        final com.google.android.exoplayer2.j2.i1.a obj7 = s0(i, a2);
        super(obj7, s3, v4, iOException5, z6);
        G1(obj7, 1003, obj8);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public void m(n1 n1) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        h0 h0Var = new h0(aVar, n1);
        G1(aVar, 15, h0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void m0(long l, int i2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = t0();
        z0 z0Var = new z0(aVar, l, i2, obj5);
        G1(aVar, 1026, z0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void n(boolean z) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        b0 b0Var = new b0(aVar, z);
        G1(aVar, 10, b0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void n0(int i, y.a y$a2) {
        final com.google.android.exoplayer2.j2.i1.a obj2 = s0(i, a2);
        i obj3 = new i(obj2);
        G1(obj2, 1033, obj3);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void o(a a) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        k0 k0Var = new k0(aVar, a);
        G1(aVar, 1007, k0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    protected final com.google.android.exoplayer2.j2.i1.a o0() {
        return q0(this.v.d());
    }

    @RequiresNonNull("player")
    protected final com.google.android.exoplayer2.j2.i1.a p0(g2 g2, int i2, y.a y$a3) {
        int z2;
        boolean equals;
        int i;
        int i5;
        long l;
        int i3;
        long i4;
        boolean z;
        final Object obj = this;
        int i6 = g2;
        int i8 = i2;
        i5 = g2.q() ? z2 : a3;
        final int i9 = 0;
        if (i6.equals(obj.y.O()) && i8 == obj.y.x()) {
            i = i8 == obj.y.x() ? i3 : i9;
        } else {
        }
        i4 = 0;
        if (i5 != 0 && i5.b()) {
            if (i5.b()) {
                if (i != 0 && obj.y.H() == i5.b && obj.y.u() == i5.c) {
                    if (obj.y.H() == i5.b) {
                        if (obj.y.u() == i5.c) {
                        } else {
                            i3 = i9;
                        }
                    } else {
                    }
                } else {
                }
                if (i3 != 0) {
                    i4 = obj.y.Y();
                }
                l = i4;
            } else {
                if (i != 0) {
                    l = obj.y.C();
                } else {
                    if (g2.q()) {
                    } else {
                        i4 = i6.n(i8, obj.c).b();
                    }
                }
            }
        } else {
        }
        super(obj.a.a(), obj3, g2, i2, i5, l, i9, obj.y.O(), obj.y.x(), obj.v.d(), obj.y.Y(), obj13, obj.y.i(), obj15);
        return aVar5;
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void s(m1 m1, int i2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        v0 v0Var = new v0(aVar, m1, i2);
        G1(aVar, 1, v0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void t(Exception exception) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        g gVar = new g(aVar, exception);
        G1(aVar, 1018, gVar);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void v(boolean z, int i2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        y0 y0Var = new y0(aVar, z, i2);
        G1(aVar, 6, y0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public final void w(l0 l0, k k2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = o0();
        f0 f0Var = new f0(aVar, l0, k2);
        G1(aVar, 2, f0Var);
    }

    @Override // com.google.android.exoplayer2.v1$e
    public void x(int i, int i2) {
        final com.google.android.exoplayer2.j2.i1.a aVar = u0();
        h hVar = new h(aVar, i, i2);
        G1(aVar, 1029, hVar);
    }
}
