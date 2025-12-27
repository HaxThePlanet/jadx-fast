package net.time4j;

import net.time4j.engine.k0;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.y;
import net.time4j.engine.z;
import net.time4j.f1.b;
import net.time4j.f1.c;

/* compiled from: YOWElement.java */
/* loaded from: classes3.dex */
final class a1 extends a<Integer> {

    private static final k0 b = null;
    static final a1 c = null;
    private static final long serialVersionUID = -6907291758376370420L;

    static class a {
    }

    private static class b<T extends q<T>> implements y<T, Integer> {
        private b() {
            super();
        }

        private p<?> b() {
            return z0.D.n();
        }

        private static g0 j(g0 g0Var, int i) {
            long l;
            int i4 = 365;
            i = a1.x(i);
            int i3 = a1.A(g0Var);
            final int i15 = 1;
            l = (z.UNIX.transform(b.j(i, i15, i15), z.MODIFIED_JULIAN_DATE)) + (long)(i - 1) + (long)(i3 - 1) * 7 + (long)(g0Var.C0().getValue(z0.D) - i15);
            int i11 = 53;
            if (i3 == i11) {
                i = b.e(i) ? 366 : 365;
                i3 = (a1.x(i + 1)) + (b.e(i) ? 366 : 365) - i / 7;
                if (i7 + i - i / 7 < i11) {
                    l = (z.UNIX.transform(b.j(i, i15, i15), zVar, z.MODIFIED_JULIAN_DATE) + (long)i - 1 + (long)i3 - 1 * 7 + (long)g0Var.C0().getValue(z0.D) - i15) - 7L;
                }
            }
            return g0Var.V0(l - 730L);
        }

        public p<?> d(T t) {
            return b();
        }

        public p<?> e(T t) {
            return b();
        }

        public Integer f(T t) {
            return a1.c.v();
        }

        public Integer g(T t) {
            return a1.c.w();
        }

        public Integer h(T t) {
            int i;
            Object obj = t.p(g0.F);
            i = obj.m();
            final int i5 = obj.D0();
            final int i6 = 0;
            int i2 = a1.y(obj, i6);
            if (i2 > i5) {
                i = i - 1;
            } else {
                int i3 = 1;
                i2 = (i5 - i2) / 7 + i3;
                int i4 = 53;
                if (i5 - i2 / 7 + i3 >= 53) {
                    i2 = (a1.y(obj, i3)) + (a1.z(obj, i6));
                    if (a1.n(obj, i3) + a1.o(obj, i6) <= i5) {
                        i = i + 1;
                    }
                }
            }
            return Integer.valueOf(i);
        }

        public boolean i(T t, Integer integer) {
            boolean z = false;
            z = false;
            if (integer == null) {
                return false;
            }
            final int value = integer.intValue();
            int i = -999999999;
            if (value >= -999999999 && value <= 999999999) {
                int i2 = 1;
            }
            return z;
        }

        public T k(T t, Integer integer, boolean z) {
            if (integer == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else {
                final p pVar = g0.F;
                return t.G(pVar, a1.b.j((g0)t.p(pVar), integer.intValue()));
            }
        }

        /* synthetic */ b(a1.a aVar) {
            this();
        }
    }

    private static class c<T extends q<T>> implements k0<T> {
        private c() {
            super();
        }

        public T c(T t, long j) {
            int value;
            if (j == 0) {
                return t;
            }
            int i4 = c.g(c.f((long)(Integer)t.p(a1.c).intValue(), j));
            final p pVar = g0.F;
            Object obj2 = t.p(pVar);
            net.time4j.x0 x0Var = obj2.C0();
            int i = 53;
            if (obj2.G0() == 53) {
                value = (Integer)g0.M0(i4, 26, x0Var).r(z0.D.n()).intValue();
            }
            return t.G(g0.F, g0.M0(i4, value, x0Var));
        }

        public long d(T t, T t2) {
            p pVar;
            long l;
            p pVar2 = g0.F;
            Object obj2 = t.p(pVar2);
            Object obj = t2.p(pVar2);
            net.time4j.a1 a1Var = a1.c;
            l = (long)(Integer)obj.p(a1Var).intValue() - (Integer)obj2.p(a1Var).intValue();
            long l2 = 0L;
            if (a1.c != l2) {
                int i = a1.A(obj2);
                int i2 = a1.A(obj);
                long l3 = 1L;
                if (a1.c <= l2 || i <= i2) {
                    if (a1.c < l2 && i < i2) {
                        l = l + 1L;
                    }
                } else {
                    l = l - 1L;
                }
                if (a1.c != l2 && i == i2) {
                    int value2 = obj2.C0().getValue();
                    int value = obj.C0().getValue();
                    if (a1.c <= l2 || value2 <= value) {
                        if (a1.c < l2 && value2 < value) {
                            l = l + 1L;
                        }
                    } else {
                        l = l - 1L;
                    }
                    if (a1.c != l2 && value2 == value) {
                        pVar = h0.G;
                        if (t.v(pVar) && t2.v(h0.G)) {
                            Object obj3 = t.p(h0.G);
                            Object obj4 = t2.p(h0.G);
                            if (a1.c <= l2 || !obj3.z0(obj4)) {
                                if (a1.c < l2 && obj3.A0(obj4)) {
                                    l = l + 1L;
                                }
                            } else {
                                l = l - 1L;
                            }
                        }
                    }
                }
            }
            return l;
        }

        /* synthetic */ c(a1.a aVar) {
            this();
        }
    }

    private static class d extends p<g0> {

        private final long c;
        /* synthetic */ d(long j, a1.a aVar) {
            this(j, r2);
        }

        @Override // net.time4j.p
        public g0 b(g0 g0Var) {
            return (g0)a1.B().b(g0Var, this.c);
        }

        private d(long j) {
            super(a1.c, 8);
            this.c = j;
        }
    }
    static {
        a1.b = new a1.c(null);
        a1.c = new a1("YEAR_OF_WEEKDATE");
    }

    private a1(String str) {
        super(str);
        final int i3 = 0;
        net.time4j.a1.d dVar = new a1.d(-1L, r1, i3);
        net.time4j.a1.d dVar2 = new a1.d(1L, r1, i3);
    }

    private static int A(g0 g0Var) {
        int i = 1;
        int i2 = 53;
        int i3;
        int i4 = g0Var.D0();
        int i9 = 0;
        int i11 = a1.y(g0Var, i9);
        i = 1;
        if (i11 <= i4) {
            i = (i4 - i11) / 7 + i;
            i2 = 53;
            if (i >= 53) {
                i2 = (a1.y(g0Var, i)) + (a1.z(g0Var, i9));
                if (a1.y(g0Var, i) + a1.z(g0Var, i9) > i4) {
                }
            }
            return i;
        }
        int i10 = -1;
        return (i4 + (a1.z(g0Var, i10))) - (a1.y(g0Var, i10)) / 7 + i;
    }

    static <T extends q<T>> k0<T> B() {
        return a1.b;
    }

    static /* synthetic */ int l(g0 g0Var) {
        return a1.A(g0Var);
    }

    static /* synthetic */ int n(g0 g0Var, int i) {
        return a1.y(g0Var, i);
    }

    static /* synthetic */ int o(g0 g0Var, int i) {
        return a1.z(g0Var, i);
    }

    static /* synthetic */ int r(int i) {
        return a1.x(i);
    }

    private Object readResolve() {
        return a1.c;
    }

    static <T extends q<T>> y<T, Integer> u(Class<T> cls) {
        return new a1.b(null);
    }

    private static int x(int i) {
        int i2;
        int i3 = 1;
        net.time4j.z0 z0Var = z0.D;
        int value = x0.valueOf(b.c(i, i3, i3)).getValue(z0Var);
        i = value <= z0Var.g() - 8 ? value - 2 : value - 9;
        return (value <= z0Var.g() - 8 ? value - 2 : value - 9);
    }

    private static int y(g0 g0Var, int i) {
        return a1.x(g0Var.m() + i);
    }

    private static int z(g0 g0Var, int i) {
        g0Var = b.e(g0Var.m() + i) ? 366 : 365;
        return (b.e(g0Var.m() + i) ? 366 : 365);
    }

    @Override // net.time4j.a
    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.a
    public Integer v() {
        return g0.y;
    }

    @Override // net.time4j.a
    public Integer w() {
        return g0.x;
    }

    @Override // net.time4j.a
    public char getSymbol() {
        return 89;
    }

    @Override // net.time4j.a
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.a
    public boolean isTimeElement() {
        return false;
    }

    @Override // net.time4j.a
    protected boolean j() {
        return true;
    }
}
