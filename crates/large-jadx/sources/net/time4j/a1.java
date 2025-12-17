package net.time4j;

import net.time4j.engine.k0;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.y;
import net.time4j.engine.z;
import net.time4j.f1.b;
import net.time4j.f1.c;

/* loaded from: classes3.dex */
final class a1 extends net.time4j.a<Integer> {

    private static final k0 b = null;
    static final net.time4j.a1 c = null;
    private static final long serialVersionUID = -6907291758376370420L;

    static class a {
    }

    private static class b implements y<T, Integer> {
        b(net.time4j.a1.a a1$a) {
            super();
        }

        private p<?> b() {
            return z0.D.n();
        }

        private static net.time4j.g0 j(net.time4j.g0 g0, int i2) {
            int i;
            int i4;
            int i3;
            int obj10;
            i = a1.r(i2);
            i4 = a1.l(g0);
            final int i15 = 1;
            int i11 = 53;
            if (i4 == i11) {
                obj10 = b.e(i2) ? 366 : 365;
                if (i9 /= 7 < i11) {
                    i3 -= i;
                }
            }
            return g0.V0(i3 -= i5);
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

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return d((q)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return e((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return f((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return g((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return h((q)object);
        }

        public Integer h(T t) {
            int i3;
            int i;
            int i2;
            int i4;
            Object obj7;
            obj7 = t.p(g0.F);
            i3 = (g0)obj7.m();
            final int i5 = obj7.D0();
            final int i6 = 0;
            i = a1.n(obj7, i6);
            if (i <= i5) {
                i2 = 1;
                if (i8 += i2 >= 53 && i9 += obj7 <= i5) {
                    if (i9 += obj7 <= i5) {
                        i3++;
                    }
                }
            } else {
                i3--;
            }
            return Integer.valueOf(i3);
        }

        public boolean i(T t, Integer integer2) {
            int i;
            int obj2;
            if (integer2 == null) {
                return 0;
            }
            final int obj3 = integer2.intValue();
            if (obj3 >= -999999999 && obj3 <= 999999999) {
                if (obj3 <= 999999999) {
                    obj2 = 1;
                }
            }
            return obj2;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return i((q)object, (Integer)object2);
        }

        public T k(T t, Integer integer2, boolean z3) {
            if (integer2 == null) {
            } else {
                final p obj4 = g0.F;
                return t.G(obj4, a1.b.j((g0)t.p(obj4), integer2.intValue()));
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Missing element value.");
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return k((q)object, (Integer)object2, z3);
        }
    }

    private static class c implements k0<T> {
        c(net.time4j.a1.a a1$a) {
            super();
        }

        @Override // net.time4j.engine.k0
        public long a(Object object, Object object2) {
            return d((q)object, (q)object2);
        }

        @Override // net.time4j.engine.k0
        public Object b(Object object, long l2) {
            return c((q)object, l2);
        }

        public T c(T t, long l2) {
            int intValue;
            int i;
            if (Long.compare(l2, i2) == 0) {
                return t;
            }
            int obj5 = c.g(c.f((long)intValue2, obj1));
            final p obj6 = g0.F;
            Object obj2 = t.p(obj6);
            net.time4j.x0 x0Var = obj2.C0();
            if ((g0)obj2.G0() == 53) {
                intValue = (Integer)g0.M0(obj5, 26, x0Var).r(z0.D.n()).intValue();
            }
            return t.G(obj6, g0.M0(obj5, intValue, x0Var));
        }

        public long d(T t, T t2) {
            Object value2;
            Object value;
            long l;
            int cmp2;
            int cmp;
            int i3;
            int i2;
            int i;
            Object obj12;
            Object obj13;
            p pVar = g0.F;
            value = t.p(pVar);
            value2 = t2.p(pVar);
            net.time4j.a1 a1Var = a1.c;
            l = (long)i4;
            cmp2 = 0;
            cmp = Long.compare(l, cmp2);
            if (cmp != 0) {
                i3 = a1.l(value);
                i2 = a1.l(value2);
                i = 1;
                if (cmp > 0 && i3 > i2) {
                    if (i3 > i2) {
                        l -= i;
                    } else {
                        if (cmp < 0 && i3 < i2) {
                            if (i3 < i2) {
                                l += i;
                            }
                        }
                    }
                } else {
                }
                cmp = Long.compare(l, cmp2);
                if (cmp != 0 && i3 == i2) {
                    if (i3 == i2) {
                        value = value.C0().getValue();
                        value2 = value2.C0().getValue();
                        if (cmp > 0 && value > value2) {
                            if (value > value2) {
                                l -= i;
                            } else {
                                if (cmp < 0 && value < value2) {
                                    if (value < value2) {
                                        l += i;
                                    }
                                }
                            }
                        } else {
                        }
                        cmp2 = Long.compare(l, cmp2);
                        value2 = h0.G;
                        if (cmp2 != 0 && value == value2 && t.v(value2) && t2.v(value2)) {
                            if (value == value2) {
                                value2 = h0.G;
                                if (t.v(value2)) {
                                    if (t2.v(value2)) {
                                        obj12 = t.p(value2);
                                        obj13 = t2.p(value2);
                                        if (cmp2 > 0 && (h0)obj12.z0((h0)obj13)) {
                                            if (obj12.z0(obj13)) {
                                                l -= i;
                                            } else {
                                                if (cmp2 < 0 && obj12.A0(obj13)) {
                                                    if (obj12.A0(obj13)) {
                                                        l += i;
                                                    }
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return l;
        }
    }

    private static class d extends net.time4j.p<net.time4j.g0> {

        private final long c;
        private d(long l) {
            super(a1.c, 8);
            this.c = l;
        }

        d(long l, net.time4j.a1.a a1$a2) {
            super(l, a2);
        }

        @Override // net.time4j.p
        public Object apply(Object object) {
            return b((g0)object);
        }

        @Override // net.time4j.p
        public net.time4j.g0 b(net.time4j.g0 g0) {
            return (g0)a1.B().b(g0, this.c);
        }
    }
    static {
        a1.c cVar = new a1.c(0);
        a1.b = cVar;
        a1 a1Var = new a1("YEAR_OF_WEEKDATE");
        a1.c = a1Var;
    }

    private a1(String string) {
        super(string);
        final int i3 = 0;
        a1.d obj4 = new a1.d(-1, obj1, i3);
        obj4 = new a1.d(1, obj1, i3);
    }

    private static int A(net.time4j.g0 g0) {
        int i;
        int i2;
        net.time4j.g0 obj5;
        int i3 = g0.D0();
        int i8 = 0;
        int i10 = a1.y(g0, i8);
        i = 1;
        if (i10 <= i3) {
            i12 += i;
            if (i13 >= 53 && i15 += obj5 <= i3) {
                if (i15 += obj5 <= i3) {
                } else {
                    i = i13;
                }
            } else {
            }
            return i;
        }
        int i9 = -1;
        return i6 += i;
    }

    static <T extends q<T>> k0<T> B() {
        return a1.b;
    }

    static int l(net.time4j.g0 g0) {
        return a1.A(g0);
    }

    static int n(net.time4j.g0 g0, int i2) {
        return a1.y(g0, i2);
    }

    static int o(net.time4j.g0 g0, int i2) {
        return a1.z(g0, i2);
    }

    static int r(int i) {
        return a1.x(i);
    }

    private Object readResolve() {
        return a1.c;
    }

    static <T extends q<T>> y<T, Integer> u(Class<T> class) {
        a1.b obj1 = new a1.b(0);
        return obj1;
    }

    private static int x(int i) {
        int obj1;
        int i2 = 1;
        net.time4j.z0 z0Var = z0.D;
        obj1 = x0.valueOf(b.c(i, i2, i2)).getValue(z0Var);
        obj1 = obj1 <= i3 - 8 ? obj1 - 2 : obj1 - 9;
        return obj1;
    }

    private static int y(net.time4j.g0 g0, int i2) {
        return a1.x(obj0 += i2);
    }

    private static int z(net.time4j.g0 g0, int i2) {
        int obj0;
        obj0 = b.e(obj0 += i2) ? 366 : 365;
        return obj0;
    }

    @Override // net.time4j.a
    public Object getDefaultMaximum() {
        return v();
    }

    @Override // net.time4j.a
    public Object getDefaultMinimum() {
        return w();
    }

    @Override // net.time4j.a
    public char getSymbol() {
        return 89;
    }

    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.a
    public boolean isDateElement() {
        return 1;
    }

    @Override // net.time4j.a
    public boolean isTimeElement() {
        return 0;
    }

    @Override // net.time4j.a
    protected boolean j() {
        return 1;
    }

    @Override // net.time4j.a
    public Integer v() {
        return g0.y;
    }

    @Override // net.time4j.a
    public Integer w() {
        return g0.x;
    }
}
