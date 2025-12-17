package kotlin.i0.z.e.m0.l.j1;

import java.util.Collection;
import java.util.List;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.i;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.i.q.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.f;
import kotlin.i0.z.e.m0.l.f.b;
import kotlin.i0.z.e.m0.l.f.b.a;
import kotlin.i0.z.e.m0.l.l1.b;
import kotlin.i0.z.e.m0.l.l1.c;
import kotlin.i0.z.e.m0.l.l1.d;
import kotlin.i0.z.e.m0.l.l1.e;
import kotlin.i0.z.e.m0.l.l1.f;
import kotlin.i0.z.e.m0.l.l1.h;
import kotlin.i0.z.e.m0.l.l1.i;
import kotlin.i0.z.e.m0.l.l1.j;
import kotlin.i0.z.e.m0.l.l1.k;
import kotlin.i0.z.e.m0.l.l1.l;
import kotlin.i0.z.e.m0.l.l1.m;
import kotlin.i0.z.e.m0.l.l1.r;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.u0;
import kotlin.i0.z.e.m0.l.u0.a;
import kotlin.i0.z.e.m0.l.y0;

/* loaded from: classes3.dex */
public class a extends f implements kotlin.i0.z.e.m0.l.j1.c {

    public static final kotlin.i0.z.e.m0.l.j1.a.a i;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final kotlin.i0.z.e.m0.l.j1.g h;

    public static final class a {
        public a(g g) {
            super();
        }

        public final f.b.a a(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            n.f(c, "<this>");
            n.f(i2, "type");
            if (!i2 instanceof i0) {
            } else {
                a.a.a aVar2 = new a.a.a(c, u0.b.a((b0)i2).c());
                return aVar2;
            }
            IllegalArgumentException obj3 = new IllegalArgumentException(b.a(i2).toString());
            throw obj3;
        }
    }
    static {
        a.a aVar = new a.a(0);
        a.i = aVar;
    }

    public a(boolean z, boolean z2, boolean z3, kotlin.i0.z.e.m0.l.j1.g g4) {
        n.f(g4, "kotlinTypeRefiner");
        super();
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = g4;
    }

    public a(boolean z, boolean z2, boolean z3, kotlin.i0.z.e.m0.l.j1.g g4, int i5, g g6) {
        int obj3;
        int obj4;
        kotlin.i0.z.e.m0.l.j1.g.a obj5;
        final int i = 1;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? g.a.a : obj5;
        super(z, obj3, obj4, obj5);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public r A(m m) {
        return c.a.w(this, m);
    }

    public h B(List<? extends h> list) {
        return c.a.z(this, list);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean C(i i) {
        return c.a.O(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean C0() {
        return this.f;
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h D(h h) {
        return c.a.V(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h D0(h h) {
        n.f(h, "type");
        if (!h instanceof b0) {
        } else {
            return l.b.a().h((b0)h.O0());
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(b.a(h).toString());
        throw illegalArgumentException;
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h E0(h h) {
        n.f(h, "type");
        if (!h instanceof b0) {
        } else {
            return this.h.g((b0)h);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(b.a(h).toString());
        throw illegalArgumentException;
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public f.b F0(i i) {
        return H0(i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h G(c c) {
        return c.a.U(this, c);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean G0(t0 t0, t0 t02) {
        boolean z;
        boolean obj2;
        n.f(t0, "a");
        n.f(t02, "b");
        if (t0 instanceof n) {
            obj2 = (n)t0.j(t02);
        } else {
            if (t02 instanceof n) {
                obj2 = (n)t02.j(t0);
            } else {
                obj2 = n.b(t0, t02);
            }
        }
        return obj2;
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean H(l l) {
        return c.a.B(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public f.b.a H0(i i) {
        n.f(i, "type");
        return a.i.a(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean I(i i) {
        return c.a.J(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean J(h h) {
        return c.a.E(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean K(l l) {
        return c.a.H(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean L(l l) {
        return c.a.F(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h M(h h) {
        return c.a.s(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public k N(h h) {
        return c.a.i(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public c O(i i) {
        return c.a.d(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public k P(h h, int i2) {
        return c.a.m(this, h, i2);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public i R(l l) {
        return c.a.q(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public r S(k k) {
        return c.a.v(this, k);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean T(l l) {
        return c.a.A(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean U(h h, b b2) {
        return c.a.x(this, h, b2);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean V(i i) {
        return c.a.Q(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean X(h h) {
        return c.a.L(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean Y(l l) {
        return c.a.G(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public i Z(i i, b b2) {
        return c.a.j(this, i, b2);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public i a(h h) {
        return c.a.h(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public d a0(i i) {
        return c.a.e(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public l b(i i) {
        return c.a.e0(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean b0(i i, i i2) {
        return c.a.y(this, i, i2);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public i c(i i, boolean z2) {
        return c.a.i0(this, i, z2);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean c0(l l) {
        return c.a.C(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public i d(f f) {
        return c.a.f0(this, f);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h d0(k k) {
        return c.a.t(this, k);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public i e(f f) {
        return c.a.S(this, f);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public e e0(f f) {
        return c.a.f(this, f);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public int f(l l) {
        return c.a.Z(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean f0(l l, l l2) {
        n.f(l, "c1");
        n.f(l2, "c2");
        if (!l instanceof t0) {
        } else {
            if (!l2 instanceof t0) {
            } else {
                return G0((t0)l, (t0)l2);
            }
            IllegalArgumentException obj3 = new IllegalArgumentException(b.a(l2).toString());
            throw obj3;
        }
        obj3 = new IllegalArgumentException(b.a(l).toString());
        throw obj3;
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean g(l l) {
        return c.a.R(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h g0(h h) {
        return c.a.W(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public int h(h h) {
        return c.a.b(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean h0(i i) {
        return c.a.M(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean i(c c) {
        return c.a.N(this, c);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public i j(l l) {
        return c.a.p(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h k(m m) {
        return c.a.r(this, m);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean l(l l) {
        return c.a.K(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public j m(i i) {
        return c.a.c(this, i);
    }

    public Collection<h> n(l l) {
        return c.a.c0(this, l);
    }

    public Collection<h> p(i i) {
        return c.a.a0(this, i);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean r(l l) {
        return c.a.D(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public m s(l l, int i2) {
        return c.a.o(this, l, i2);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h t(i i, i i2) {
        return c.a.k(this, i, i2);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public m u(l l) {
        return c.a.u(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public h v(h h, boolean z2) {
        return c.a.h0(this, h, z2);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean v0(h h) {
        boolean z;
        n.f(h, "<this>");
        if (h instanceof g1 && this.g) {
            if (this.g) {
                (g1)h.L0();
            }
        }
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public i w(d d) {
        return c.a.Y(this, d);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public c x(l l) {
        return c.a.n(this, l);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean y(k k) {
        return c.a.P(this, k);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public f z(h h) {
        return c.a.g(this, h);
    }

    @Override // kotlin.i0.z.e.m0.l.f
    public boolean z0() {
        return this.e;
    }
}
