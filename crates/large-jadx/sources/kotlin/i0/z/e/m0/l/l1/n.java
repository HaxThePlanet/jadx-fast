package kotlin.i0.z.e.m0.l.l1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public interface n extends kotlin.i0.z.e.m0.l.l1.q {

    public static final class a {
        public static List<kotlin.i0.z.e.m0.l.l1.i> a(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.i i2, kotlin.i0.z.e.m0.l.l1.l l3) {
            n.f(n, "this");
            n.f(i2, "receiver");
            n.f(l3, "constructor");
            return 0;
        }

        public static kotlin.i0.z.e.m0.l.l1.k b(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.j j2, int i3) {
            Object obj1;
            Object obj2;
            n.f(n, "this");
            n.f(j2, "receiver");
            if (j2 instanceof i) {
                obj1 = n.P((h)j2, i3);
                return obj1;
            } else {
                if (!j2 instanceof a) {
                } else {
                    n.e((a)j2.get(i3), "get(index)");
                }
            }
            obj1 = new StringBuilder();
            obj1.append("unknown type argument list type: ");
            obj1.append(j2);
            obj1.append(", ");
            obj1.append(c0.b(j2.getClass()));
            obj2 = new IllegalStateException(obj1.toString().toString());
            throw obj2;
        }

        public static kotlin.i0.z.e.m0.l.l1.k c(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.i i2, int i3) {
            int i4;
            int i;
            n.f(n, "this");
            n.f(i2, "receiver");
            i4 = 0;
            if (i3 >= 0 && i3 < n.h(i2)) {
                if (i3 < n.h(i2)) {
                    i4 = 1;
                }
            }
            if (i4 != 0) {
                return n.P(i2, i3);
            }
            return null;
        }

        public static boolean d(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.h h2) {
            int obj1;
            n.f(n, "this");
            n.f(h2, "receiver");
            obj1 = n.I(n.Q(h2)) != n.I(n.F(h2)) ? 1 : 0;
            return obj1;
        }

        public static boolean e(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.i i2) {
            n.f(n, "this");
            n.f(i2, "receiver");
            return n.H(n.b(i2));
        }

        public static boolean f(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.h h2) {
            int obj1;
            n.f(n, "this");
            n.f(h2, "receiver");
            final kotlin.i0.z.e.m0.l.l1.i obj2 = n.a(h2);
            if (obj2 == null) {
                obj1 = 0;
            } else {
                obj1 = n.a0(obj2);
            }
            obj1 = obj1 != null ? 1 : 0;
            return obj1;
        }

        public static boolean g(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.h h2) {
            int obj1;
            n.f(n, "this");
            n.f(h2, "receiver");
            final kotlin.i0.z.e.m0.l.l1.f obj2 = n.z(h2);
            if (obj2 == null) {
                obj1 = 0;
            } else {
                obj1 = n.e0(obj2);
            }
            obj1 = obj1 != null ? 1 : 0;
            return obj1;
        }

        public static boolean h(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.i i2) {
            n.f(n, "this");
            n.f(i2, "receiver");
            return n.Y(n.b(i2));
        }

        public static boolean i(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.h h2) {
            Object obj1;
            n.f(n, "this");
            n.f(h2, "receiver");
            if (h2 instanceof i && n.I((i)h2)) {
                obj1 = n.I((i)h2) ? 1 : 0;
            } else {
            }
            return obj1;
        }

        public static boolean j(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.h h2) {
            Object obj1;
            n.f(n, "this");
            n.f(h2, "receiver");
            if (n.l(n.q(h2)) && !n.X(h2)) {
                obj1 = !n.X(h2) ? 1 : 0;
            } else {
            }
            return obj1;
        }

        public static kotlin.i0.z.e.m0.l.l1.i k(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.h h2) {
            kotlin.i0.z.e.m0.l.l1.i obj1;
            n.f(n, "this");
            n.f(h2, "receiver");
            kotlin.i0.z.e.m0.l.l1.f fVar = n.z(h2);
            if (fVar == null) {
                n.d(n.a(h2));
            } else {
                obj1 = n.e(fVar);
            }
            return obj1;
        }

        public static int l(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.j j2) {
            int obj1;
            n.f(n, "this");
            n.f(j2, "receiver");
            if (j2 instanceof i) {
                obj1 = n.h((h)j2);
                return obj1;
            } else {
                if (!j2 instanceof a) {
                } else {
                    obj1 = (a)j2.size();
                }
            }
            obj1 = new StringBuilder();
            obj1.append("unknown type argument list type: ");
            obj1.append(j2);
            obj1.append(", ");
            obj1.append(c0.b(j2.getClass()));
            IllegalStateException obj2 = new IllegalStateException(obj1.toString().toString());
            throw obj2;
        }

        public static kotlin.i0.z.e.m0.l.l1.l m(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.h h2) {
            kotlin.i0.z.e.m0.l.l1.i iVar;
            n.f(n, "this");
            n.f(h2, "receiver");
            if (n.a(h2) == null) {
                iVar = n.Q(h2);
            }
            return n.b(iVar);
        }

        public static kotlin.i0.z.e.m0.l.l1.i n(kotlin.i0.z.e.m0.l.l1.n n, kotlin.i0.z.e.m0.l.l1.h h2) {
            kotlin.i0.z.e.m0.l.l1.i obj1;
            n.f(n, "this");
            n.f(h2, "receiver");
            kotlin.i0.z.e.m0.l.l1.f fVar = n.z(h2);
            if (fVar == null) {
                n.d(n.a(h2));
            } else {
                obj1 = n.d(fVar);
            }
            return obj1;
        }
    }
    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.r A(kotlin.i0.z.e.m0.l.l1.m m);

    public abstract kotlin.i0.z.e.m0.l.l1.h B(List<? extends kotlin.i0.z.e.m0.l.l1.h> list);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean C(kotlin.i0.z.e.m0.l.l1.i i);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.h D(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract int E(kotlin.i0.z.e.m0.l.l1.j j);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.i F(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.h G(kotlin.i0.z.e.m0.l.l1.c c);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean H(kotlin.i0.z.e.m0.l.l1.l l);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean I(kotlin.i0.z.e.m0.l.l1.i i);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean J(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean K(kotlin.i0.z.e.m0.l.l1.l l);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.k N(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.c O(kotlin.i0.z.e.m0.l.l1.i i);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.k P(kotlin.i0.z.e.m0.l.l1.h h, int i2);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.i Q(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.r S(kotlin.i0.z.e.m0.l.l1.k k);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean T(kotlin.i0.z.e.m0.l.l1.l l);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean V(kotlin.i0.z.e.m0.l.l1.i i);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean W(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean X(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean Y(kotlin.i0.z.e.m0.l.l1.l l);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.i Z(kotlin.i0.z.e.m0.l.l1.i i, kotlin.i0.z.e.m0.l.l1.b b2);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.i a(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.d a0(kotlin.i0.z.e.m0.l.l1.i i);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.l b(kotlin.i0.z.e.m0.l.l1.i i);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.i c(kotlin.i0.z.e.m0.l.l1.i i, boolean z2);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean c0(kotlin.i0.z.e.m0.l.l1.l l);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.i d(kotlin.i0.z.e.m0.l.l1.f f);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.h d0(kotlin.i0.z.e.m0.l.l1.k k);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.i e(kotlin.i0.z.e.m0.l.l1.f f);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.e e0(kotlin.i0.z.e.m0.l.l1.f f);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract int f(kotlin.i0.z.e.m0.l.l1.l l);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean f0(kotlin.i0.z.e.m0.l.l1.l l, kotlin.i0.z.e.m0.l.l1.l l2);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract int h(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean h0(kotlin.i0.z.e.m0.l.l1.i i);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean i(kotlin.i0.z.e.m0.l.l1.c c);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean l(kotlin.i0.z.e.m0.l.l1.l l);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.j m(kotlin.i0.z.e.m0.l.l1.i i);

    public abstract Collection<kotlin.i0.z.e.m0.l.l1.h> n(kotlin.i0.z.e.m0.l.l1.l l);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.k o(kotlin.i0.z.e.m0.l.l1.j j, int i2);

    public abstract Collection<kotlin.i0.z.e.m0.l.l1.h> p(kotlin.i0.z.e.m0.l.l1.i i);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.l q(kotlin.i0.z.e.m0.l.l1.h h);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean r(kotlin.i0.z.e.m0.l.l1.l l);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.m s(kotlin.i0.z.e.m0.l.l1.l l, int i2);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.h v(kotlin.i0.z.e.m0.l.l1.h h, boolean z2);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.i w(kotlin.i0.z.e.m0.l.l1.d d);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract boolean y(kotlin.i0.z.e.m0.l.l1.k k);

    @Override // kotlin.i0.z.e.m0.l.l1.q
    public abstract kotlin.i0.z.e.m0.l.l1.f z(kotlin.i0.z.e.m0.l.l1.h h);
}
