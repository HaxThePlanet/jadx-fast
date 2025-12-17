package net.time4j;

import android.app.ActivityManager.MemoryInfo;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.time4j.engine.ChronoException;
import net.time4j.engine.b0;
import net.time4j.engine.c0;
import net.time4j.engine.d;
import net.time4j.engine.d0;
import net.time4j.engine.f0;
import net.time4j.engine.f0.b;
import net.time4j.engine.g;
import net.time4j.engine.i0;
import net.time4j.engine.k;
import net.time4j.engine.l0;
import net.time4j.engine.m;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.r;
import net.time4j.engine.t;
import net.time4j.engine.w;
import net.time4j.engine.x;
import net.time4j.engine.y;
import net.time4j.engine.z;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.f1.c;
import net.time4j.f1.d;
import net.time4j.g1.b;
import net.time4j.g1.c;
import net.time4j.g1.e;
import net.time4j.g1.h;

/* loaded from: classes3.dex */
@c("iso8601")
public final class g0 extends m<net.time4j.v, net.time4j.g0> implements a, c0<net.time4j.f>, h {

    private static final Integer A = null;
    private static final Integer B = null;
    private static final Integer C = null;
    private static final int[] D = null;
    private static final int[] E = null;
    static final p<net.time4j.g0> F = null;
    public static final net.time4j.e G = null;
    public static final net.time4j.c<Integer, net.time4j.g0> H = null;
    public static final net.time4j.c<Integer, net.time4j.g0> I = null;
    public static final net.time4j.d0<net.time4j.m0> J = null;
    public static final net.time4j.d0<net.time4j.c0> K = null;
    public static final net.time4j.l0<Integer, net.time4j.g0> L = null;
    public static final net.time4j.l0<Integer, net.time4j.g0> M = null;
    public static final net.time4j.d0<net.time4j.x0> N = null;
    public static final net.time4j.l0<Integer, net.time4j.g0> O = null;
    public static final net.time4j.l0<Integer, net.time4j.g0> P = null;
    public static final net.time4j.e0 Q = null;
    private static final Map<String, Object> R = null;
    private static final k<net.time4j.g0> S = null;
    private static final f0<net.time4j.v, net.time4j.g0> T = null;
    private static final long serialVersionUID = -6698431452072325688L;
    static final net.time4j.g0 v;
    static final net.time4j.g0 w;
    static final Integer x;
    static final Integer y;
    private static final Integer z;
    private final transient int a;
    private final transient byte b;
    private final transient byte c;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            g0.a.b = iArr;
            int i2 = 1;
            iArr[m0.Q1.ordinal()] = i2;
            int i = 2;
            g0.a.b[m0.Q2.ordinal()] = i;
            int[] iArr10 = new int[values2.length];
            g0.a.a = iArr10;
            iArr10[f.MILLENNIA.ordinal()] = i2;
            g0.a.a[f.CENTURIES.ordinal()] = i;
            g0.a.a[f.DECADES.ordinal()] = 3;
            g0.a.a[f.YEARS.ordinal()] = 4;
            g0.a.a[f.QUARTERS.ordinal()] = 5;
            g0.a.a[f.MONTHS.ordinal()] = 6;
            g0.a.a[f.WEEKS.ordinal()] = 7;
            g0.a.a[f.DAYS.ordinal()] = 8;
        }
    }

    private static class b implements y<net.time4j.g0, net.time4j.g0> {
        b(net.time4j.g0.a g0$a) {
            super();
        }

        public p<?> b(net.time4j.g0 g0) {
            return 0;
        }

        public p<?> d(net.time4j.g0 g0) {
            return 0;
        }

        @Override // net.time4j.engine.y
        public net.time4j.g0 e(net.time4j.g0 g0) {
            return g0.w;
        }

        @Override // net.time4j.engine.y
        public net.time4j.g0 f(net.time4j.g0 g0) {
            return g0.v;
        }

        @Override // net.time4j.engine.y
        public net.time4j.g0 g(net.time4j.g0 g0) {
            return g0;
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return b((g0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return d((g0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((g0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((g0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            g((g0)object);
            return object;
        }

        @Override // net.time4j.engine.y
        public boolean h(net.time4j.g0 g0, net.time4j.g0 g02) {
            int obj1;
            obj1 = g02 != null ? 1 : 0;
            return obj1;
        }

        @Override // net.time4j.engine.y
        public net.time4j.g0 i(net.time4j.g0 g0, net.time4j.g0 g02, boolean z3) {
            if (g02 == null) {
            } else {
                return g02;
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("Missing date value.");
            throw obj1;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((g0)object, (g0)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            i((g0)object, (g0)object2, z3);
            return object2;
        }
    }

    private static class c implements y<net.time4j.g0, V> {

        private final String a;
        private final Class<V> b;
        private final V c;
        private final V v;
        private final int w;
        c(String string, Class<V> class2, V v3, V v4, int i5) {
            super();
            this.a = string;
            this.b = class2;
            this.c = v3;
            this.v = v4;
            this.w = i5;
        }

        private p<?> b() {
            switch (i) {
                case 101:
                    return g0.M;
                case 102:
                    return 0;
                case 103:
                    return g0.P;
                default:
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.a);
                    throw unsupportedOperationException;
            }
        }

        static <V extends Enum<V>> net.time4j.g0.c<V> j(p<V> p) {
            super(p.name(), p.getType(), (Enum)p.getDefaultMinimum(), (Enum)p.getDefaultMaximum(), (q)p.r());
            return cVar2;
        }

        public p<?> d(net.time4j.g0 g0) {
            return b();
        }

        public p<?> e(net.time4j.g0 g0) {
            return b();
        }

        public V f(net.time4j.g0 g0) {
            int i;
            int i2;
            net.time4j.g0 obj3;
            if (this.w == 102 && g0.o0(g0) == 999999999 && g0.p0(g0) == 12 && g0.X(g0) >= 27) {
                if (g0.o0(g0) == 999999999) {
                    if (g0.p0(g0) == 12) {
                        if (g0.X(g0) >= 27) {
                            return (Enum)this.b.cast(x0.FRIDAY);
                        }
                    }
                }
            }
            return this.v;
        }

        public V g(net.time4j.g0 g0) {
            return this.c;
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return d((g0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return e((g0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return f((g0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return g((g0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return h((g0)object);
        }

        public V h(net.time4j.g0 g0) {
            Enum obj2;
            switch (i) {
                case 101:
                    obj2 = c0.valueOf(g0.p0(g0));
                    break;
                case 102:
                    obj2 = g0.C0();
                    break;
                case 103:
                    obj2 = m0.valueOf(obj2++);
                    break;
                default:
                    obj2 = new UnsupportedOperationException(this.a);
                    throw obj2;
            }
            return (Enum)this.b.cast(obj2);
        }

        public boolean i(net.time4j.g0 g0, V v2) {
            int i;
            int i2;
            final int i3 = 0;
            if (v2 == null) {
                return i3;
            }
            if (this.w == 102 && g0.o0(g0) == 999999999) {
                if (g0.o0(g0) == 999999999) {
                    k(g0, v2, i3);
                }
            }
            return 1;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return i((g0)object, (Enum)object2);
        }

        public net.time4j.g0 k(net.time4j.g0 g0, V v2, boolean z3) {
            if (v2 == null) {
            } else {
                switch (obj4) {
                    case 101:
                        return g0.b0(g0, (c0)c0.class.cast(v2).getValue());
                    case 102:
                        return g0.i0(g0, (x0)x0.class.cast(v2));
                    case 103:
                        obj4++;
                        return (g0)g0.M((long)obj3, obj4);
                    default:
                        UnsupportedOperationException obj2 = new UnsupportedOperationException(this.a);
                        throw obj2;
                }
            }
            obj2 = new IllegalArgumentException("Missing element value.");
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return k((g0)object, (Enum)object2, z3);
        }
    }

    private static class e implements t<net.time4j.g0> {

        private static final int a;
        static {
            long l2 = c.b(System.currentTimeMillis(), obj2);
            g0.e.a = i += 20;
        }

        e(net.time4j.g0.a g0$a) {
            super();
        }

        private static void h(q<?> q, String string2) {
            final l0 eRROR_MESSAGE = l0.ERROR_MESSAGE;
            if (q.D(eRROR_MESSAGE, string2)) {
                q.G(eRROR_MESSAGE, string2);
            }
        }

        private static boolean j(q<?> q, int i2, int i3, int i4) {
            int i;
            int obj3;
            final int i5 = 1;
            if (i4 >= i5 && i4 > 28 && i4 > b.d(i2, i3)) {
                if (i4 > 28) {
                    if (i4 > b.d(i2, i3)) {
                    }
                }
                return i5;
            }
            obj3 = new StringBuilder();
            obj3.append("DAY_OF_MONTH out of range: ");
            obj3.append(i4);
            g0.e.h(q, obj3.toString());
            return 0;
        }

        private static boolean k(q<?> q, boolean z2, net.time4j.m0 m03, int i4) {
            int i;
            int obj3;
            int obj4 = g0.a.b[m03.ordinal()];
            i = 91;
            final int i2 = 1;
            if (obj4 != i2) {
                if (obj4 != 2) {
                    i = 92;
                }
            } else {
                if (z2 != 0) {
                } else {
                    i = obj3;
                }
            }
            if (i4 >= i2 && i4 > i) {
                if (i4 > i) {
                }
                return i2;
            }
            obj3 = new StringBuilder();
            obj3.append("DAY_OF_QUARTER out of range: ");
            obj3.append(i4);
            g0.e.h(q, obj3.toString());
            return 0;
        }

        private static boolean l(q<?> q, int i2, int i3) {
            int i;
            int obj3;
            int i4 = 1;
            if (i3 >= i4 && i3 > 365 && b.e(i2)) {
                if (i3 > 365) {
                    if (b.e(i2)) {
                        i = 366;
                    }
                    if (i3 > i) {
                    }
                }
                return i4;
            }
            obj3 = new StringBuilder();
            obj3.append("DAY_OF_YEAR out of range: ");
            obj3.append(i3);
            g0.e.h(q, obj3.toString());
            return 0;
        }

        private static boolean m(q<?> q, int i2) {
            int i;
            int i3 = 1;
            if (i2 >= i3 && i2 > 12) {
                if (i2 > 12) {
                }
                return i3;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MONTH_OF_YEAR out of range: ");
            stringBuilder.append(i2);
            g0.e.h(q, stringBuilder.toString());
            return 0;
        }

        private static boolean n(q<?> q, int i2) {
            int i;
            if (i2 >= -999999999 && i2 > 999999999) {
                if (i2 > 999999999) {
                }
                return 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("YEAR out of range: ");
            stringBuilder.append(i2);
            g0.e.h(q, stringBuilder.toString());
            return 0;
        }

        @Override // net.time4j.engine.t
        public d0 a() {
            return d0.a;
        }

        public w<?> b() {
            return 0;
        }

        @Override // net.time4j.engine.t
        public Object c(q q, d d2, boolean z3, boolean z4) {
            return g(q, d2, z3, z4);
        }

        @Override // net.time4j.engine.t
        public int d() {
            return g0.e.a;
        }

        @Override // net.time4j.engine.t
        public o e(Object object, d d2) {
            i((g0)object, d2);
            return object;
        }

        @Override // net.time4j.engine.t
        public String f(x x, Locale locale2) {
            return b.r(e.ofStyle(x.getStyleValue()), locale2);
        }

        public net.time4j.g0 g(q<?> q, d d2, boolean z3, boolean z4) {
            int i4;
            int i5;
            net.time4j.m0 m0Var;
            int i2;
            net.time4j.l0 l0Var;
            int value;
            int i;
            net.time4j.d0 d0Var;
            boolean z;
            int i3;
            q obj10;
            boolean obj11;
            boolean obj12;
            boolean obj13;
            p pVar = g0.F;
            if (q.v(pVar)) {
                return (g0)q.p(pVar);
            }
            int i6 = q.e(g0.H);
            int i8 = 0;
            final int i9 = 0;
            i2 = Integer.MIN_VALUE;
            net.time4j.l0 l0Var2 = g0.L;
            d0Var = g0.K;
            if (i6 != i2 && q.e(l0Var2) == i2 && q.v(d0Var)) {
                l0Var2 = g0.L;
                if (q.e(l0Var2) == i2) {
                    d0Var = g0.K;
                    if (q.v(d0Var)) {
                        value = (c0)q.p(d0Var).getValue();
                    }
                }
                d0Var = 1;
                z = g0.M;
                i3 = q.e(z);
                if (value != i2 && i3 != i2 && z3) {
                    z = g0.M;
                    i3 = q.e(z);
                    if (i3 != i2) {
                        if (z3) {
                            return (g0)(g0)g0.K0(i6, d0Var, d0Var).H(l0Var2.i(Integer.valueOf(value))).H(z.i(Integer.valueOf(i3)));
                        }
                        if (g0.e.n(q, i6) && g0.e.m(q, value) && g0.e.j(q, i6, value, i3)) {
                            if (g0.e.m(q, value)) {
                                if (g0.e.j(q, i6, value, i3)) {
                                    return g0.j0(i6, value, i3, i8);
                                }
                            }
                        }
                        return i9;
                    }
                }
                l0Var = g0.O;
                int i10 = q.e(l0Var);
                if (i10 != i2 && z3) {
                    if (z3) {
                        return (g0)g0.J0(i6, d0Var).H(l0Var.i(Integer.valueOf(i10)));
                    }
                    if (g0.e.n(q, i6) && g0.e.l(q, i6, i10)) {
                        if (g0.e.l(q, i6, i10)) {
                            return g0.J0(i6, i10);
                        }
                    }
                    return i9;
                }
                i = q.e(g0.P);
                z = g0.J;
                if (i != i2 && q.v(z)) {
                    z = g0.J;
                    if (q.v(z)) {
                        obj11 = q.p(z);
                        obj13 = b.e(i6);
                        i4 = obj13 != null ? 91 : 90;
                        i4 += i;
                        if ((m0)obj11 == m0.Q1) {
                            i5 = i;
                        } else {
                            if ((m0)obj11 == m0.Q3) {
                                i5 += 91;
                            } else {
                                if ((m0)obj11 == m0.Q4) {
                                    i5 += 183;
                                }
                            }
                        }
                        if (z3) {
                            return (g0)g0.J0(i6, d0Var).H(l0Var.i(Integer.valueOf(i5)));
                        }
                        if (g0.e.n(q, i6) && g0.e.k(q, obj13, (m0)obj11, i)) {
                            if (g0.e.k(q, obj13, obj11, i)) {
                                return g0.J0(i6, i5);
                            }
                        }
                        return i9;
                    }
                }
            }
            int i7 = q.e(g0.I);
            i2 = z0.D;
            if (i7 != i2 && q.v(i2.n())) {
                i2 = z0.D;
                if (q.v(i2.n())) {
                    obj11 = (Integer)q.p(i2.n()).intValue();
                    obj12 = g0.N;
                    if (q.v(obj12)) {
                        obj12 = q.p(obj12);
                        if (i7 >= -999999999) {
                            if (i7 > 999999999) {
                            } else {
                                obj12 = g0.l0(i7, obj11, obj12, i8);
                                if (obj12 == null) {
                                    g0.e.h(q, g0.m0(obj11));
                                }
                            }
                            return obj12;
                        }
                        g0.e.h(q, g0.k0(i7));
                    } else {
                        if (q.v(i2.i())) {
                            obj12 = q.p(i2.i());
                        }
                    }
                    return i9;
                }
            }
            z mODIFIED_JULIAN_DATE = z.MODIFIED_JULIAN_DATE;
            if (q.v(mODIFIED_JULIAN_DATE)) {
                obj11 = z.UTC;
                return (g0)g0.n0().a(obj11.transform((Long)q.p(mODIFIED_JULIAN_DATE).longValue(), z4));
            }
            if (q instanceof f) {
                return (i0)i0.U().D(q, d2, z3, z4).X();
            }
            return i9;
        }

        @Override // net.time4j.engine.t
        public o i(net.time4j.g0 g0, d d2) {
            return g0;
        }
    }

    private static class f implements k<net.time4j.g0> {
        f(net.time4j.g0.a g0$a) {
            super();
        }

        @Override // net.time4j.engine.k
        public Object a(long l) {
            return f(l);
        }

        @Override // net.time4j.engine.k
        public long b(Object object) {
            return e((g0)object);
        }

        @Override // net.time4j.engine.k
        public long c() {
            return 365241779741L;
        }

        @Override // net.time4j.engine.k
        public long d() {
            return -365243219892L;
        }

        @Override // net.time4j.engine.k
        public long e(net.time4j.g0 g0) {
            return z.UTC.transform(b.k(g0), obj2);
        }

        @Override // net.time4j.engine.k
        public net.time4j.g0 f(long l) {
            if (Long.compare(l, l2) == 0) {
                return g0.v;
            }
            if (Long.compare(l, l3) == 0) {
                return g0.w;
            }
            long obj3 = b.l(z.MODIFIED_JULIAN_DATE.transform(l, obj4));
            return g0.K0(b.i(obj3), b.h(obj3), b.g(obj3));
        }
    }

    private static class d implements b0<net.time4j.g0> {

        private final p<?> a;
        private final String b;
        private final int c;
        d(int i, p<?> p2) {
            super();
            this.a = p2;
            this.b = p2.name();
            this.c = i;
        }

        d(p<Integer> p) {
            super((t)p.r(), p);
        }

        private p<?> b() {
            switch (i) {
                case 14:
                    return g0.L;
                case 15:
                    return g0.M;
                case 16:
                    return 0;
                default:
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.b);
                    throw unsupportedOperationException;
            }
        }

        private static int h(net.time4j.g0 g0) {
            int i;
            final int i5 = 1;
            i3 += i5;
            if (i4 == i5) {
                if (b.e(g0.o0(g0))) {
                } else {
                    i = 90;
                }
                return i;
            }
            if (i4 == 2) {
                return 91;
            }
            return 92;
        }

        private int i(net.time4j.g0 g0) {
            int i;
            int i2;
            int i3;
            byte obj5 = g0.X(g0);
            i = 0;
            i2 = i + 1;
            while (i7 += obj5 <= b.d(g0.o0(g0), g0.p0(g0))) {
                i = i2;
                i2 = i + 1;
            }
            return obj5++;
        }

        @Override // net.time4j.engine.b0
        public Object a(Object object, int i2, boolean z3) {
            return n((g0)object, i2, z3);
        }

        @Override // net.time4j.engine.b0
        public int c(Object object) {
            return f((g0)object);
        }

        public p<?> d(net.time4j.g0 g0) {
            return b();
        }

        public p<?> e(net.time4j.g0 g0) {
            return b();
        }

        @Override // net.time4j.engine.b0
        public int f(net.time4j.g0 g0) {
            switch (i) {
                case 14:
                    return g0.o0(g0);
                case 15:
                    return g0.p0(g0);
                case 16:
                    return g0.X(g0);
                case 17:
                    return g0.D0();
                case 18:
                    return g0.Y(g0);
                case 19:
                    return obj2++;
                default:
                    UnsupportedOperationException obj2 = new UnsupportedOperationException(this.b);
                    throw obj2;
            }
        }

        @Override // net.time4j.engine.b0
        public Integer g(net.time4j.g0 g0) {
            Integer obj2;
            switch (i2) {
                case 14:
                    return g0.y;
                case 15:
                    return g0.f0();
                case 16:
                    return Integer.valueOf(b.d(g0.o0(g0), g0.p0(g0)));
                case 17:
                    obj2 = g0.h0();
                    return obj2;
                case 18:
                    return Integer.valueOf(g0.d.h(g0));
                case 19:
                    return Integer.valueOf(i(g0));
                default:
                    obj2 = new UnsupportedOperationException(this.b);
                    throw obj2;
            }
            obj2 = g0.g0();
        }

        @Override // net.time4j.engine.b0
        public p getChildAtCeiling(Object object) {
            return d((g0)object);
        }

        @Override // net.time4j.engine.b0
        public p getChildAtFloor(Object object) {
            return e((g0)object);
        }

        @Override // net.time4j.engine.b0
        public Object getMaximum(Object object) {
            return g((g0)object);
        }

        @Override // net.time4j.engine.b0
        public Object getMinimum(Object object) {
            return j((g0)object);
        }

        @Override // net.time4j.engine.b0
        public Object getValue(Object object) {
            return k((g0)object);
        }

        @Override // net.time4j.engine.b0
        public boolean isValid(Object object, Object object2) {
            return m((g0)object, (Integer)object2);
        }

        @Override // net.time4j.engine.b0
        public Integer j(net.time4j.g0 g0) {
            switch (obj2) {
                case 14:
                    return g0.x;
                case 15:
                    return g0.e0();
                default:
                    UnsupportedOperationException obj2 = new UnsupportedOperationException(this.b);
                    throw obj2;
            }
        }

        @Override // net.time4j.engine.b0
        public Integer k(net.time4j.g0 g0) {
            return Integer.valueOf(f(g0));
        }

        @Override // net.time4j.engine.b0
        public boolean l(net.time4j.g0 g0, int i2) {
            int i3;
            int i;
            int obj4;
            i = 0;
            final int i5 = 1;
            switch (i3) {
                case 14:
                    i = i5;
                    return i;
                case 15:
                    i = i5;
                    return i;
                case 16:
                    i = i5;
                    return i;
                case 17:
                    obj4 = 366;
                    obj4 = 365;
                    i = i5;
                    return i;
                case 18:
                    i = i5;
                    return i;
                case 19:
                    i = i5;
                    return i;
                default:
                    obj4 = new UnsupportedOperationException(this.b);
                    throw obj4;
            }
        }

        @Override // net.time4j.engine.b0
        public boolean m(net.time4j.g0 g0, Integer integer2) {
            net.time4j.g0 obj1;
            int obj2;
            if (integer2 != 0 && l(g0, integer2.intValue())) {
                obj1 = l(g0, integer2.intValue()) ? 1 : 0;
            } else {
            }
            return obj1;
        }

        @Override // net.time4j.engine.b0
        public net.time4j.g0 n(net.time4j.g0 g0, int i2, boolean z3) {
            int obj6;
            if (z3 != 0) {
                return (g0)g0.M((long)obj5, obj1);
            }
            final String str = "Out of range: ";
            final int i4 = 1;
            switch (i3) {
                case 14:
                    return g0.a0(g0, i2);
                case 15:
                    return g0.b0(g0, i2);
                case 16:
                    return g0.c0(g0, i2);
                case 17:
                    return g0.d0(g0, i2);
                case 18:
                    obj6 = g0.Y(g0);
                    return (g0)g0.M((long)obj5, obj6);
                    obj6 = new StringBuilder();
                    obj6.append(str);
                    obj6.append(i2);
                    IllegalArgumentException obj4 = new IllegalArgumentException(obj6.toString());
                    throw obj4;
                case 19:
                    obj6 = new StringBuilder();
                    obj6.append(str);
                    obj6.append(i2);
                    obj4 = new IllegalArgumentException(obj6.toString());
                    throw obj4;
                    obj6 += i4;
                    return (g0)g0.M((long)obj5, obj6);
                default:
                    obj4 = new UnsupportedOperationException(this.b);
                    throw obj4;
            }
        }

        @Override // net.time4j.engine.b0
        public net.time4j.g0 o(net.time4j.g0 g0, Integer integer2, boolean z3) {
            if (integer2 == null) {
            } else {
                return n(g0, integer2.intValue(), z3);
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("Missing element value.");
            throw obj1;
        }

        @Override // net.time4j.engine.b0
        public Object withValue(Object object, Object object2, boolean z3) {
            return o((g0)object, (Integer)object2, z3);
        }
    }
    static {
        int i2 = -999999999;
        int i4 = 1;
        g0 g0Var = new g0(i2, i4, i4);
        g0.v = g0Var;
        int i5 = 999999999;
        int i6 = 12;
        int i7 = 31;
        g0 g0Var2 = new g0(i5, i6, i7);
        g0.w = g0Var2;
        g0.x = Integer.valueOf(i2);
        g0.y = Integer.valueOf(i5);
        g0.z = Integer.valueOf(i4);
        g0.A = Integer.valueOf(i6);
        int i = 365;
        g0.B = Integer.valueOf(i);
        int i8 = 366;
        g0.C = Integer.valueOf(i8);
        int[] iArr = new int[i6];
        g0.D = iArr;
        int[] iArr2 = new int[i6];
        g0.E = iArr2;
        int i20 = 0;
        iArr[i20] = i7;
        iArr[i4] = 59;
        int i33 = 2;
        iArr[i33] = 90;
        int i38 = 3;
        iArr[i38] = 120;
        int i44 = 4;
        iArr[i44] = 151;
        int i46 = 5;
        iArr[i46] = 181;
        int i47 = 6;
        iArr[i47] = 212;
        int i50 = 7;
        iArr[i50] = 243;
        int i54 = 8;
        iArr[i54] = 273;
        int i56 = 9;
        iArr[i56] = 304;
        int i57 = 10;
        iArr[i57] = 334;
        int i31 = 11;
        iArr[i31] = i;
        iArr2[i20] = i7;
        iArr2[i4] = 60;
        iArr2[i33] = 91;
        iArr2[i38] = 121;
        iArr2[i44] = 152;
        iArr2[i46] = 182;
        iArr2[i47] = 213;
        iArr2[i50] = 244;
        iArr2[i54] = 274;
        iArr2[i56] = 305;
        iArr2[i57] = 335;
        iArr2[i31] = i8;
        net.time4j.i iVar = i.a;
        g0.F = iVar;
        g0.G = iVar;
        net.time4j.t tVar2 = t.l("YEAR", 14, i2, i5, 'u');
        g0.H = tVar2;
        net.time4j.a1 a1Var = a1.c;
        g0.I = a1Var;
        super("QUARTER_OF_YEAR", m0.class, m0.Q1, m0.Q4, 103, 81);
        g0.J = qVar;
        super("MONTH_OF_YEAR", c0.class, c0.JANUARY, c0.DECEMBER, 101, 77);
        g0.K = qVar2;
        net.time4j.t tVar4 = t.l("MONTH_AS_NUMBER", 15, i4, i6, 'M');
        g0.L = tVar4;
        net.time4j.t tVar5 = t.l("DAY_OF_MONTH", 16, i4, i7, 'd');
        g0.M = tVar5;
        net.time4j.q qVar3 = qVar6;
        super("DAY_OF_WEEK", x0.class, x0.MONDAY, x0.SUNDAY, 102, 69);
        g0.N = qVar3;
        net.time4j.t tVar = t.l("DAY_OF_YEAR", 17, i4, i, 'D');
        g0.O = tVar;
        net.time4j.t tVar3 = t.l("DAY_OF_QUARTER", 18, i4, 92, '\0');
        g0.P = tVar3;
        net.time4j.y0 y0Var = y0.b;
        g0.Q = y0Var;
        HashMap hashMap = new HashMap();
        g0.v0(hashMap, iVar);
        g0.v0(hashMap, tVar2);
        g0.v0(hashMap, a1Var);
        g0.v0(hashMap, qVar);
        g0.v0(hashMap, qVar2);
        g0.v0(hashMap, tVar4);
        g0.v0(hashMap, tVar5);
        g0.v0(hashMap, qVar3);
        g0.v0(hashMap, tVar);
        g0.v0(hashMap, tVar3);
        g0.v0(hashMap, y0Var);
        g0.R = Collections.unmodifiableMap(hashMap);
        int i43 = 0;
        g0.f fVar = new g0.f(i43);
        g0.S = fVar;
        g0.e eVar = new g0.e(i43);
        f0.b bVar = f0.b.j(v.class, g0.class, eVar, fVar);
        g0.b bVar2 = new g0.b(i43);
        net.time4j.f dAYS = f.DAYS;
        bVar.e(iVar, bVar2, dAYS);
        g0.d dVar6 = new g0.d(tVar2);
        bVar.e(tVar2, dVar6, f.YEARS);
        bVar.e(a1Var, a1.u(g0.class), w0.a);
        bVar.e(qVar, g0.c.j(qVar), f.QUARTERS);
        net.time4j.f mONTHS = f.MONTHS;
        bVar.e(qVar2, g0.c.j(qVar2), mONTHS);
        g0.d dVar3 = new g0.d(tVar4);
        bVar.e(tVar4, dVar3, mONTHS);
        g0.d dVar4 = new g0.d(tVar5);
        bVar.e(tVar5, dVar4, dAYS);
        bVar.e(qVar3, g0.c.j(qVar3), dAYS);
        g0.d dVar5 = new g0.d(tVar);
        bVar.e(tVar, dVar5, dAYS);
        g0.d dVar = new g0.d(tVar3);
        bVar.e(tVar3, dVar, dAYS);
        g0.d dVar2 = new g0.d(19, y0Var);
        bVar.e(y0Var, dVar2, f.WEEKS);
        g0.R0(bVar);
        g0.Q0(bVar);
        g0.T = bVar.h();
    }

    private g0(int i, int i2, int i3) {
        super();
        this.a = i;
        this.b = (byte)i2;
        this.c = (byte)i3;
    }

    private int B0() {
        int i;
        switch (b) {
            case 1:
                return this.c;
            case 2:
                return b5 += 31;
            case 3:
                i = 59;
                return i += b7;
            case 4:
                return b6 += 30;
            case 5:
                return b2 += 61;
            case 6:
                return b4 += 62;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown month: ");
                stringBuilder.append(this.b);
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
        }
        i = 60;
    }

    static Object I0(String string) {
        return g0.R.get(string);
    }

    public static net.time4j.g0 J0(int i, int i2) {
        int[] iArr;
        int i3;
        int i4;
        String str = "Day of year out of range: ";
        int i8 = 1;
        if (i2 < i8) {
        } else {
            if (i2 <= 31) {
                return g0.K0(i, i8, i2);
            }
            iArr = b.e(i) ? g0.E : g0.D;
            i3 = i2 > iArr[6] ? 7 : i8;
            while (i3 < 12) {
                i3++;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(i2);
            IllegalArgumentException obj5 = new IllegalArgumentException(stringBuilder2.toString());
            throw obj5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(i2);
        obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    public static net.time4j.g0 K0(int i, int i2, int i3) {
        return g0.L0(i, i2, i3, true);
    }

    private static net.time4j.g0 L0(int i, int i2, int i3, boolean z4) {
        if (z4) {
            b.a(i, i2, i3);
        }
        g0 obj3 = new g0(i, i2, i3);
        return obj3;
    }

    public static net.time4j.g0 M0(int i, int i2, net.time4j.x0 x03) {
        return g0.N0(i, i2, x03, true);
    }

    private static net.time4j.g0 N0(int i, int i2, net.time4j.x0 x03, boolean z4) {
        int i3;
        int intValue;
        int i4;
        int i5;
        boolean z;
        int obj5;
        int obj7;
        final int i6 = 0;
        int i7 = 1;
        if (i2 >= i7) {
            i3 = 53;
            if (i2 > i3) {
            } else {
                if (z4) {
                    if (i < g0.x.intValue()) {
                    } else {
                        if (i > g0.y.intValue()) {
                        } else {
                        }
                    }
                    IllegalArgumentException obj6 = new IllegalArgumentException(g0.Z0(i));
                    throw obj6;
                }
                int value = x0.valueOf(b.c(i, i7, i7)).getValue();
                i4 = value <= 4 ? value - 2 : value - 9;
                i11 -= i7;
                obj7 = 366;
                int i8 = 365;
                if (i5 <= 0) {
                    if (b.e(i--)) {
                    } else {
                        obj7 = i8;
                    }
                    i5 += obj7;
                } else {
                    if (b.e(i)) {
                    } else {
                        obj7 = i8;
                    }
                    if (i5 > obj7) {
                        i5 -= obj7;
                        i++;
                    }
                }
                obj5 = g0.J0(obj5, i5);
                if (i2 == i3 && obj5.G0() != i3) {
                    if (obj5.G0() != i3) {
                        if (z4) {
                        } else {
                            return i6;
                        }
                        obj5 = new IllegalArgumentException(g0.Y0(i2));
                        throw obj5;
                    }
                }
            }
            return obj5;
        }
        if (z4) {
        } else {
            return i6;
        }
        obj5 = new IllegalArgumentException(g0.Y0(i2));
        throw obj5;
    }

    public static net.time4j.g0 O0(int i, net.time4j.c0 c02, int i3) {
        return g0.L0(i, c02.getValue(), i3, true);
    }

    public static net.time4j.g0 P0(long l, z z2) {
        return (g0)g0.S.a(z.UTC.transform(l, z2));
    }

    private static void Q0(f0.b<net.time4j.v, net.time4j.g0> f0$b) {
        Class<r> next;
        boolean z;
        Iterator iterator = d.c().g(r.class).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((r)next.d(g0.class)) {
            }
            b.f(next);
        }
        v0 v0Var = new v0();
        b.f(v0Var);
    }

    private static void R0(f0.b<net.time4j.v, net.time4j.g0> f0$b) {
        int i;
        Object obj;
        net.time4j.f fVar;
        net.time4j.f.j jVar;
        double length;
        EnumSet set;
        net.time4j.f[] values = f.values();
        i = 0;
        while (i < values.length) {
            fVar = values[i];
            jVar = new f.j(fVar);
            if (fVar.compareTo(f.WEEKS) < 0) {
            } else {
            }
            set = range2;
            b.g(fVar, jVar, fVar.getLength(), obj9);
            i++;
            set = range;
        }
    }

    private net.time4j.g0 S0(int i) {
        if (this.c == i) {
            return this;
        }
        return g0.K0(this.a, this.b, i);
    }

    private net.time4j.g0 T0(net.time4j.x0 x0) {
        net.time4j.x0 x0Var = C0();
        if (x0Var == x0) {
            return this;
        }
        return (g0)g0.S.a(c.f(E0(), obj3));
    }

    private net.time4j.g0 U0(int i) {
        if (D0() == i) {
            return this;
        }
        return g0.J0(this.a, i);
    }

    private net.time4j.g0 W0(int i) {
        if (this.b == i) {
            return this;
        }
        return g0.K0(this.a, i, Math.min(b.d(this.a, i), this.c));
    }

    static byte X(net.time4j.g0 g0) {
        return g0.c;
    }

    private net.time4j.g0 X0(int i) {
        if (this.a == i) {
            return this;
        }
        return g0.K0(i, this.b, Math.min(b.d(i, this.b), this.c));
    }

    static int Y(net.time4j.g0 g0) {
        return g0.B0();
    }

    private static String Y0(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WEEK_OF_YEAR (ISO) out of range: ");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    static f0 Z() {
        return g0.T;
    }

    private static String Z0(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("YEAR_OF_WEEKDATE (ISO) out of range: ");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    static net.time4j.g0 a0(net.time4j.g0 g0, int i2) {
        return g0.X0(i2);
    }

    static net.time4j.g0 b0(net.time4j.g0 g0, int i2) {
        return g0.W0(i2);
    }

    static net.time4j.g0 c0(net.time4j.g0 g0, int i2) {
        return g0.S0(i2);
    }

    static net.time4j.g0 d0(net.time4j.g0 g0, int i2) {
        return g0.U0(i2);
    }

    static Integer e0() {
        return g0.z;
    }

    static Integer f0() {
        return g0.A;
    }

    static Integer g0() {
        return g0.C;
    }

    static Integer h0() {
        return g0.B;
    }

    static net.time4j.g0 i0(net.time4j.g0 g0, net.time4j.x0 x02) {
        return g0.T0(x02);
    }

    static net.time4j.g0 j0(int i, int i2, int i3, boolean z4) {
        return g0.L0(i, i2, i3, z4);
    }

    static String k0(int i) {
        return g0.Z0(i);
    }

    static net.time4j.g0 l0(int i, int i2, net.time4j.x0 x03, boolean z4) {
        return g0.N0(i, i2, x03, z4);
    }

    static String m0(int i) {
        return g0.Y0(i);
    }

    static k n0() {
        return g0.S;
    }

    static int o0(net.time4j.g0 g0) {
        return g0.a;
    }

    static byte p0(net.time4j.g0 g0) {
        return g0.b;
    }

    private static net.time4j.g0 q0(net.time4j.g0 g0, long l2) {
        int cmp2;
        int cmp;
        long l3 = c.f((long)b, obj1);
        int i2 = 1;
        if (Long.compare(l3, i2) >= 0 && Long.compare(l3, i4) <= 0) {
            if (Long.compare(l3, i4) <= 0) {
                return g0.K0(g0.a, g0.b, (int)l3);
            }
        }
        long l5 = c.f((long)i, obj1);
        if (Long.compare(l5, i2) >= 0 && Long.compare(l5, i3) <= 0) {
            if (Long.compare(l5, i3) <= 0) {
                return g0.J0(g0.a, (int)l5);
            }
        }
        return (g0)g0.S.a(c.f(g0.E0(), obj1));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    public static f0<net.time4j.v, net.time4j.g0> t0() {
        return g0.T;
    }

    static net.time4j.g0 u0(net.time4j.f f, net.time4j.g0 g02, long l3, int i4) {
        final int ordinal = f.ordinal();
        switch (i) {
            case 1:
                return g0.u0(f.MONTHS, g02, c.i(l3, i4), i4);
            case 2:
                return g0.u0(f.MONTHS, g02, c.i(l3, i4), i4);
            case 3:
                return g0.u0(f.MONTHS, g02, c.i(l3, i4), i4);
            case 4:
                return g0.u0(f.MONTHS, g02, c.i(l3, i4), i4);
            case 5:
                return g0.u0(f.MONTHS, g02, c.i(l3, i4), i4);
            case 6:
                return g0.z0(g02, c.f(g02.F0(), ordinal), i4, g02.c);
            case 7:
                return g0.u0(f.DAYS, g02, c.i(l3, i4), i4);
            case 8:
                return g0.q0(g02, l3);
            default:
                UnsupportedOperationException obj3 = new UnsupportedOperationException(f.name());
                throw obj3;
        }
    }

    private static void v0(Map<String, Object> map, p<?> p2) {
        map.put(p2.name(), p2);
    }

    private static void w0(StringBuilder stringBuilder, int i2) {
        int i;
        stringBuilder.append('-');
        if (i2 < 10) {
            stringBuilder.append('0');
        }
        stringBuilder.append(i2);
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 1);
        return spx;
    }

    private static void x0(StringBuilder stringBuilder, int i2) {
        int i;
        int i3;
        int obj3;
        if (i2 < 0) {
            stringBuilder.append('-');
            i = c.j(i2);
        } else {
            i = i2;
        }
        if (i >= 10000) {
            if (i2 > 0) {
                stringBuilder.append('+');
            }
        } else {
            obj3 = 48;
            stringBuilder.append(obj3);
            stringBuilder.append(obj3);
            if (i < 1000 && i < 100 && i < 10) {
                obj3 = 48;
                stringBuilder.append(obj3);
                if (i < 100) {
                    stringBuilder.append(obj3);
                    if (i < 10) {
                        stringBuilder.append(obj3);
                    }
                }
            }
        }
        stringBuilder.append(i);
    }

    public static net.time4j.g0 y0(a a) {
        if (a instanceof g0) {
            return (g0)a;
        }
        return g0.K0(a.m(), a.o(), a.q());
    }

    private static net.time4j.g0 z0(net.time4j.g0 g0, long l2, int i3, int i4) {
        int i5;
        int i2;
        int i;
        int obj10;
        int obj11;
        final int i6 = 2;
        if (obj11 == 5 && g0.c == g0.H0()) {
            if (g0.c == g0.H0()) {
                obj11 = i6;
            }
        }
        int i7 = 12;
        int i10 = c.g(c.f(c.b(l2, i3), obj3));
        final int i11 = 1;
        i8 += i11;
        int i13 = b.d(i10, i9);
        if (i4 > i13) {
            i = 1;
            switch (obj11) {
                case 0:
                    obj10 = i13;
                    break;
                case 1:
                    return g0.z0(g0, c.f(l2, i3), i3, i11);
                case 2:
                    return g0.z0(g0, c.f(l2, i3), i3, i4 -= i13);
                case 3:
                    StringBuilder obj7 = new StringBuilder(32);
                    obj7.append("Day of month out of range: ");
                    g0.x0(obj7, i10);
                    g0.w0(obj7, i9);
                    g0.w0(obj7, i4);
                    ChronoException obj8 = new ChronoException(obj7.toString());
                    throw obj8;
                default:
                    obj8 = new StringBuilder();
                    obj8.append("Overflow policy not implemented: ");
                    obj8.append(obj11);
                    obj7 = new UnsupportedOperationException(obj8.toString());
                    throw obj7;
            }
            return g0.K0(i10, i9, obj10);
        }
        if (i4 < i13 && obj11 == i6) {
            if (obj11 == i6) {
            }
        }
    }

    @Override // net.time4j.engine.m
    protected net.time4j.g0 A0() {
        return this;
    }

    @Override // net.time4j.engine.m
    public net.time4j.x0 C0() {
        return x0.valueOf(b.c(this.a, this.b, this.c));
    }

    @Override // net.time4j.engine.m
    public int D0() {
        byte b = this.b;
        int i7 = 2;
        if (b != 1 && b != i7) {
            i7 = 2;
            if (b != i7) {
                return i4 += z;
            }
            return b2 += 31;
        }
        return this.c;
    }

    @Override // net.time4j.engine.m
    long E0() {
        return g0.S.b(this);
    }

    @Override // net.time4j.engine.m
    long F0() {
        return i4 -= i7;
    }

    @Override // net.time4j.engine.m
    int G0() {
        return (Integer)p(z0.D.n()).intValue();
    }

    @Override // net.time4j.engine.m
    public int H0() {
        return b.d(this.a, this.b);
    }

    protected f0<net.time4j.v, net.time4j.g0> J() {
        return g0.T;
    }

    @Override // net.time4j.engine.m
    protected int O(g g) {
        int i;
        int i2;
        Object obj3;
        if (g instanceof g0 && i3 -= i2 == 0 && b -= i2 == 0) {
            if (i3 -= i2 == 0) {
                if (b -= i2 == 0) {
                    b2 -= obj3;
                }
            }
            return i;
        }
        return super.O((g0)(g0)g);
    }

    @Override // net.time4j.engine.m
    net.time4j.g0 V0(long l) {
        return (g0)g0.S.a(l);
    }

    @Override // net.time4j.engine.m
    public boolean equals(Object object) {
        int i;
        byte b2;
        byte b;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof g0) {
            if (this.c == object.c && this.b == object.b && this.a == object.a) {
                if (this.b == object.b) {
                    if (this.a == object.a) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.engine.m
    public int hashCode() {
        int i = this.a;
        return i4 ^= i6;
    }

    @Override // net.time4j.engine.m
    public int m() {
        return this.a;
    }

    @Override // net.time4j.engine.m
    public int o() {
        return this.b;
    }

    @Override // net.time4j.engine.m
    public int q() {
        return this.c;
    }

    @Override // net.time4j.engine.m
    public net.time4j.i0 r0(net.time4j.h0 h0) {
        return i0.d0(this, h0);
    }

    @Override // net.time4j.engine.m
    public net.time4j.i0 s0() {
        return r0(h0.E);
    }

    @Override // net.time4j.engine.m
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        g0.x0(stringBuilder, this.a);
        g0.w0(stringBuilder, this.b);
        g0.w0(stringBuilder, this.c);
        return stringBuilder.toString();
    }

    @Override // net.time4j.engine.m
    protected w y() {
        return J();
    }

    @Override // net.time4j.engine.m
    protected q z() {
        A0();
        return this;
    }
}
