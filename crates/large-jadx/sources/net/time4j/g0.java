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
import net.time4j.g1.e;
import net.time4j.g1.h;

/* compiled from: PlainDate.java */
@c("iso8601")
/* loaded from: classes3.dex */
public final class g0 extends m<v, g0> implements a, c0<f>, h {

    private static final Integer A;
    private static final Integer B;
    private static final Integer C;
    private static final int[] D;
    private static final int[] E;
    static final p<g0> F;
    public static final e G;
    public static final c<Integer, g0> H;
    public static final c<Integer, g0> I;
    public static final d0<m0> J;
    public static final d0<c0> K;
    public static final l0<Integer, g0> L;
    public static final l0<Integer, g0> M;
    public static final d0<x0> N;
    public static final l0<Integer, g0> O;
    public static final l0<Integer, g0> P;
    public static final e0 Q;
    private static final Map<String, Object> R;
    private static final k<g0> S = null;
    private static final f0<v, g0> T;
    private static final long serialVersionUID = -6698431452072325688L;
    static final g0 v = new g0(-999999999, 1, 1);
    static final g0 w = new g0(999999999, 12, 31);
    static final Integer x;
    static final Integer y;
    private static final Integer z;
    private final transient int a;
    private final transient byte b;
    private final transient byte c;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[m0.values().length];
            g0.a.b = iArr;
            int i2 = 1;
            try {
                iArr[m0.Q1.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int[] iArr10 = new int[f.values().length];
                g0.a.a = iArr10;
                return;
            }
            int i = 2;
            try {
                g0.a.b[m0.Q2.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static class b implements y<g0, g0> {
        private b() {
            super();
        }

        public g0 e(g0 g0Var) {
            return g0.w;
        }

        public g0 f(g0 g0Var) {
            return g0.v;
        }

        public g0 i(g0 g0Var, g0 g0Var2, boolean z) {
            if (g0Var2 == null) {
                throw new IllegalArgumentException("Missing date value.");
            } else {
                return g0Var2;
            }
        }

        /* synthetic */ b(g0.a aVar) {
            this();
        }

        public p<?> b(g0 g0Var) {
            return null;
        }

        public p<?> d(g0 g0Var) {
            return null;
        }

        public g0 g(g0 g0Var) {
            return g0Var;
        }

        public boolean h(g0 g0Var, g0 g0Var2) {
            boolean z = true;
            g0Var = g0Var2 != null ? 1 : 0;
            return (g0Var2 != null ? 1 : 0);
        }
    }

    private static class c<V extends Enum<V>> implements y<g0, V> {

        private final String a;
        private final Class<V> b;
        private final V c;
        private final V v;
        private final int w;
        c(String str, Class<V> cls, V v, V v2, int i) {
            super();
            this.a = str;
            this.b = cls;
            this.c = v;
            this.v = v2;
            this.w = i;
        }

        private p<?> b() {
            switch (this.w) {
                case 101:
                    return g0.M;
                case 102:
                    return null;
                case 103:
                    return g0.P;
                default:
                    throw new UnsupportedOperationException(this.a);
            }
        }

        static <V extends Enum<V>> g0.c<V> j(p<V> pVar) {
            g0.c cVar = new g0.c(pVar.name(), pVar.getType(), (Enum)pVar.getDefaultMinimum(), (Enum)pVar.getDefaultMaximum(), pVar.r());
            return cVar;
        }

        public p<?> d(g0 g0Var) {
            return b();
        }

        public p<?> e(g0 g0Var) {
            return b();
        }

        public V f(g0 g0Var) {
            int i2 = 102;
            if (this.w == 102) {
                i2 = 999999999;
                if (g0Var.a == 999999999) {
                    if (g0Var.b == (byte) 12) {
                        if (g0Var.c >= (byte) 27) {
                            return (Enum)this.b.cast(x0.FRIDAY);
                        }
                    }
                }
            }
            return this.v;
        }

        public V g(g0 g0Var) {
            return this.c;
        }

        public V h(g0 g0Var) {
            net.time4j.x0 x0Var;
            switch (this.w) {
                case 101:
                    net.time4j.c0 str3 = c0.valueOf(g0.p0(g0Var));
                    break;
                case 102:
                    x0Var = g0Var.C0();
                    break;
                case 103:
                    net.time4j.m0 str4 = m0.valueOf(g0.p0(g0Var) - 1 / 3 + 1);
                    break;
                default:
                    throw new UnsupportedOperationException(this.a);
            }
            return (Enum)this.b.cast(x0Var);
        }

        public boolean i(g0 g0Var, V v) {
            final boolean z2 = false;
            if (v == null) {
                return false;
            }
            int i2 = 102;
            if (this.w == 102) {
                i2 = 999999999;
                if (g0Var.a == 999999999) {
                    try {
                        k(g0Var, v, z2);
                    } catch (java.lang.IllegalArgumentException unused) {
                        return z;
                    }
                }
            }
            return true;
        }

        public g0 k(g0 g0Var, V v, boolean z) {
            if (v == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else {
                switch (this.w) {
                    case 101:
                        return g0.b0(g0Var, obj3.cast(v).getValue());
                    case 102:
                        return g0.i0(g0Var, c0.class.cast(v));
                    case 103:
                        int i5 = (g0.p0(g0Var) - 1 / 3) + 1;
                        return (g0)g0Var.M((long)obj2.cast(v).getValue() - i5, x0.class, f.QUARTERS);
                    default:
                        throw new UnsupportedOperationException(this.a);
                }
            }
        }
    }

    private static class e implements t<g0> {

        private static final int a = 0;
        static {
            long l2 = c.b(System.currentTimeMillis(), 86400000);
            g0.e.a = (b.i(b.l(z.MODIFIED_JULIAN_DATE.transform(l2, z.UNIX)))) + 20;
        }

        private e() {
            super();
        }

        private static void h(q<?> qVar, String str) {
            final l0 eRROR_MESSAGE2 = l0.ERROR_MESSAGE;
            if (qVar.D(eRROR_MESSAGE2, str)) {
                qVar.G(l0.ERROR_MESSAGE, str);
            }
        }

        private static boolean j(q<?> qVar, int i, int i2, int i3) {
            final int i6 = 1;
            i = 28;
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "DAY_OF_MONTH out of range: ";
            str = str2 + i3;
            g0.e.h(qVar, str);
            return false;
        }

        private static boolean k(q<?> qVar, boolean z, m0 m0Var, int i) {
            int z22 = 91;
            int i3 = g0.a.b[m0Var.ordinal()];
            z22 = 91;
            i = 1;
            if (i3 != i) {
                z22 = 2;
                if (i3 != 2) {
                    z22 = 92;
                }
            } else {
                if (!(z)) {
                    z22 = 90;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "DAY_OF_QUARTER out of range: ";
            str = str2 + i;
            g0.e.h(qVar, str);
            return false;
        }

        private static boolean l(q<?> qVar, int i, int i2) {
            int i4 = 1;
            if (i2 >= i4 && i2 > 365) {
                if (b.e(i)) {
                    i = 366;
                }
                return true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str = "DAY_OF_YEAR out of range: ";
            str2 = str + i2;
            g0.e.h(qVar, str2);
            return false;
        }

        private static boolean m(q<?> qVar, int i) {
            int i3 = 1;
            StringBuilder stringBuilder = new StringBuilder();
            String str = "MONTH_OF_YEAR out of range: ";
            str2 = str + i;
            g0.e.h(qVar, str2);
            return false;
        }

        private static boolean n(q<?> qVar, int i) {
            i = -999999999;
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "YEAR out of range: ";
            str2 = str + i;
            g0.e.h(qVar, str2);
            return false;
        }

        public d0 a() {
            return d0.a;
        }

        public int d() {
            return g0.e.a;
        }

        public String f(x xVar, Locale locale) {
            return b.r(e.ofStyle(xVar.getStyleValue()), locale);
        }

        public g0 g(q<?> qVar, net.time4j.engine.d dVar, boolean z, boolean z2) {
            int i = 91;
            int i2;
            net.time4j.l0 l0Var;
            int value;
            int i5;
            net.time4j.x0 x0Var;
            int i6 = -999999999;
            p pVar = g0.F;
            if (qVar.v(pVar)) {
                return (g0)qVar.p(g0.F);
            }
            int i7 = qVar.e(g0.H);
            boolean z12 = false;
            final int i9 = 0;
            int i3 = Integer.MIN_VALUE;
            if (i7 != Integer.MIN_VALUE) {
                net.time4j.l0 l0Var2 = g0.L;
                if (qVar.e(l0Var2) == Integer.MIN_VALUE) {
                    d0Var = g0.K;
                    if (qVar.v(d0Var)) {
                        value = (c0)qVar.p(g0.K).getValue();
                    }
                }
                int i4 = 1;
                if (value != Integer.MIN_VALUE && i5 != Integer.MIN_VALUE && z) {
                    return (g0)(g0)g0.K0(i7, i4, i4).H(g0.L.i(Integer.valueOf(value))).H(g0.M.i(Integer.valueOf(i5)));
                }
                l0Var = g0.O;
                int i10 = qVar.e(l0Var);
                if (i10 != Integer.MIN_VALUE && z) {
                    return (g0)g0.J0(i7, i4).H(g0.O.i(Integer.valueOf(i10)));
                }
                i2 = qVar.e(g0.P);
                if (i2 != Integer.MIN_VALUE && qVar.v(g0.J)) {
                    Object obj5 = qVar.p(g0.J);
                    boolean z18 = b.e(i7);
                    int r1 = z18 ? 91 : 90;
                    i2 = (z18 ? 91 : 90) + i2;
                    if (obj5 == m0.Q1) {
                    } else {
                        if (obj5 == m0.Q3) {
                            i2 = i2 + 91;
                        } else {
                            if (obj5 == m0.Q4) {
                                i2 = i2 + 183;
                            }
                        }
                    }
                    if (z) {
                        return (g0)g0.J0(i7, i4).H(g0.O.i(Integer.valueOf(i2)));
                    }
                    if (g0.e.n(qVar, i7) && g0.e.k(qVar, z18, obj5, i2)) {
                        return g0.J0(i7, i2);
                    }
                    return null;
                }
            }
            int i8 = qVar.e(g0.I);
            if (i8 != Integer.MIN_VALUE && qVar.v(z0.D.n())) {
                int value2 = (Integer)qVar.p(z0.D.n()).intValue();
                net.time4j.d0 d0Var3 = g0.N;
                if (qVar.v(d0Var3)) {
                    Object obj8 = qVar.p(g0.N);
                    i6 = -999999999;
                    if (i8 >= -999999999) {
                        i6 = 999999999;
                        if (i8 <= 999999999) {
                            net.time4j.g0 g0Var8 = g0.N0(i8, value2, x0Var, z12);
                            if (g0Var8 == null) {
                                g0.e.h(qVar, g0.Y0(value2));
                            }
                        }
                        return g0Var8;
                    }
                    g0.e.h(qVar, g0.Z0(i8));
                } else {
                    if (qVar.v(z0.D.i())) {
                        Object obj7 = qVar.p(z0.D.i());
                    }
                }
                return i9;
            }
            z mODIFIED_JULIAN_DATE2 = z.MODIFIED_JULIAN_DATE;
            if (qVar.v(mODIFIED_JULIAN_DATE2)) {
                z uTC2 = z.UTC;
                return (g0)g0.S.a(uTC2.transform((Long)qVar.p(z.MODIFIED_JULIAN_DATE).longValue(), z.MODIFIED_JULIAN_DATE));
            }
            if (qVar instanceof f) {
                return (i0)i0.U().D(qVar, dVar, z, z2).X();
            }
            return i9;
        }

        /* synthetic */ e(g0.a aVar) {
            this();
        }

        public w<?> b() {
            return null;
        }

        public o i(g0 g0Var, net.time4j.engine.d dVar) {
            return g0Var;
        }
    }

    private static class f implements k<g0> {
        private f() {
            super();
        }

        public long e(g0 g0Var) {
            return z.UTC.transform(b.k(g0Var), z.MODIFIED_JULIAN_DATE);
        }

        public g0 f(long j) {
            if (j == -365243219892L) {
                return g0.v;
            }
            if (g0.v == 365241779741L) {
                return g0.w;
            }
            long l3 = b.l(z.MODIFIED_JULIAN_DATE.transform(j, z.UTC));
            return g0.K0(b.i(l3), b.h(l3), b.g(l3));
        }

        /* synthetic */ f(g0.a aVar) {
            this();
        }

        public long c() {
            return 365241779741L;
        }

        public long d() {
            return -365243219892L;
        }
    }

    private static class d implements b0<g0> {

        private final p<?> a;
        private final String b;
        private final int c;
        d(p<Integer> pVar) {
            this((t)pVar.r(), pVar);
        }

        private p<?> b() {
            switch (this.c) {
                case 14:
                    return g0.L;
                case 15:
                    return g0.M;
                case 16:
                    return null;
                default:
                    throw new UnsupportedOperationException(this.b);
            }
        }

        private static int h(g0 g0Var) {
            int i = 90;
            final int i5 = 1;
            int i4 = (g0Var.b - i5) / 3 + i5;
            i = 91;
            if (i4 == i5) {
                if (!(b.e(g0Var.a))) {
                    i = 90;
                }
                return i;
            }
            if (i4 == 2) {
                return 91;
            }
            return 92;
        }

        private int i(g0 g0Var) {
            int i = 0;
            byte b2 = g0Var.c;
            i = 0;
            i = i + 1;
            i2 = (i * 7) + b2;
            while (i * 7 + b2 <= b.d(g0Var.a, g0Var.b)) {
                i = i + 1;
                i2 = (i * 7) + b2;
            }
            return (b2 + (i * 7)) - 1 / 7 + 1;
        }

        public p<?> d(g0 g0Var) {
            return b();
        }

        public p<?> e(g0 g0Var) {
            return b();
        }

        public int f(g0 g0Var) {
            switch (this.c) {
                case 14:
                    return g0.o0(g0Var);
                case 15:
                    return g0.p0(g0Var);
                case 16:
                    return g0.X(g0Var);
                case 17:
                    return g0Var.D0();
                case 18:
                    return g0.Y(g0Var);
                case 19:
                    return g0.X(g0Var) - 1 / 7 + 1;
                default:
                    throw new UnsupportedOperationException(this.b);
            }
        }

        public Integer g(g0 g0Var) {
            Integer num;
            switch (this.c) {
                case 14:
                    return g0.y;
                case 15:
                    return g0.f0();
                case 16:
                    return Integer.valueOf(b.d(g0.o0(g0.y), g0.p0(g0.y)));
                case 17:
                    num = g0.B;
                    return num;
                case 18:
                    return Integer.valueOf(g0.d.h(g0.y));
                case 19:
                    return Integer.valueOf(this.i(g0.y));
                default:
                    throw new UnsupportedOperationException(this.b);
            }
            num = g0.C;
        }

        public Integer j(g0 g0Var) {
            switch (this.c) {
                case 14:
                    return g0.x;
                case 15:
                    return g0.e0();
                default:
                    throw new UnsupportedOperationException(this.b);
            }
        }

        public Integer k(g0 g0Var) {
            return Integer.valueOf(f(g0Var));
        }

        public boolean l(g0 g0Var, int i) {
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            int i9 = 366;
            int i11 = 0;
            final int i3 = 1;
            switch (this.c) {
                case 14:
                    int i4 = -999999999;
                    i4 = 999999999;
                    return z;
                case 15:
                    int i6 = 12;
                    return z3;
                case 16:
                    return z5;
                case 17:
                    i9 = 366;
                    i9 = 365;
                    return z6;
                case 18:
                    return z2;
                case 19:
                    return z4;
                default:
                    throw new UnsupportedOperationException(this.b);
            }
        }

        public boolean m(g0 g0Var, Integer integer) {
            boolean z2 = false;
            int value;
            if (integer != null) {
                g0Var = l(g0Var, integer.intValue()) ? 1 : 0;
            }
            return (l(g0Var, integer.intValue()) ? 1 : 0);
        }

        public g0 n(g0 g0Var, int i, boolean z) {
            if (z) {
                return (g0)g0Var.M((long)(c.l(i, f(g0Var))), (v)g0.T.F(this.a));
            }
            final String str = "Out of range: ";
            final int i6 = 1;
            switch (this.c) {
                case 14:
                    return g0.a0(g0Var, i);
                case 15:
                    return g0.b0(g0Var, i);
                case 16:
                    return g0.c0(g0Var, i);
                case 17:
                    return g0.d0(g0Var, i);
                case 18:
                    int i13 = g0Var.B0();
                    return (g0)g0Var.M((long)i - i13, i13, f.DAYS);
                case 19:
                    StringBuilder stringBuilder = new StringBuilder();
                    i = str + i;
                    throw new IllegalArgumentException(str + i);
                default:
                    throw new UnsupportedOperationException(this.b);
            }
        }

        public g0 o(g0 g0Var, Integer integer, boolean z) {
            if (integer == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else {
                return n(g0Var, integer.intValue(), z);
            }
        }

        d(int i, p<?> pVar) {
            super();
            this.a = pVar;
            this.b = pVar.name();
            this.c = i;
        }
    }
    static {
        int i2 = -999999999;
        int i4 = 1;
        int i5 = 999999999;
        int i6 = 12;
        int i7 = 31;
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
        int i43 = 4;
        iArr[i43] = 151;
        int i45 = 5;
        iArr[i45] = 181;
        int i46 = 6;
        iArr[i46] = 212;
        int i49 = 7;
        iArr[i49] = 243;
        int i53 = 8;
        iArr[i53] = 273;
        int i55 = 9;
        iArr[i55] = 304;
        int i56 = 10;
        iArr[i56] = 334;
        int i31 = 11;
        iArr[i31] = i;
        iArr2[i20] = i7;
        iArr2[i4] = 60;
        iArr2[i33] = 91;
        iArr2[i38] = 121;
        iArr2[i43] = 152;
        iArr2[i45] = 182;
        iArr2[i46] = 213;
        iArr2[i49] = 244;
        iArr2[i53] = 274;
        iArr2[i55] = 305;
        iArr2[i56] = 335;
        iArr2[i31] = i8;
        net.time4j.i iVar = i.a;
        g0.F = iVar;
        g0.G = iVar;
        net.time4j.t tVar2 = t.l("YEAR", 14, i2, i5, 'u');
        g0.H = tVar2;
        net.time4j.a1 a1Var = a1.c;
        g0.I = a1Var;
        q qVar = new q("QUARTER_OF_YEAR", m0.class, m0.Q1, m0.Q4, 103, 'Q');
        g0.J = qVar;
        q qVar2 = new q("MONTH_OF_YEAR", c0.class, c0.JANUARY, c0.DECEMBER, 101, 'M');
        g0.K = qVar2;
        net.time4j.t tVar4 = t.l("MONTH_AS_NUMBER", 15, i4, i6, 'M');
        g0.L = tVar4;
        net.time4j.t tVar5 = t.l("DAY_OF_MONTH", 16, i4, i7, 'd');
        g0.M = tVar5;
        q qVar3 = new q("DAY_OF_WEEK", x0.class, x0.MONDAY, x0.SUNDAY, 102, 'E');
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
        net.time4j.g0.a aVar = null;
        net.time4j.g0.f fVar = new g0.f(aVar);
        g0.S = fVar;
        f0.b bVar = f0.b.j(v.class, g0.class, new g0.e(aVar), fVar);
        net.time4j.f dAYS2 = f.DAYS;
        bVar.e(iVar, new g0.b(aVar), dAYS2);
        bVar.e(tVar2, new g0.d(tVar2), f.YEARS);
        bVar.e(a1Var, a1.u(g0.class), w0.a);
        bVar.e(qVar, g0.c.j(qVar), f.QUARTERS);
        net.time4j.f mONTHS2 = f.MONTHS;
        bVar.e(qVar2, g0.c.j(qVar2), mONTHS2);
        bVar.e(tVar4, new g0.d(tVar4), mONTHS2);
        bVar.e(tVar5, new g0.d(tVar5), dAYS2);
        bVar.e(qVar3, g0.c.j(qVar3), dAYS2);
        bVar.e(tVar, new g0.d(tVar), dAYS2);
        bVar.e(tVar3, new g0.d(tVar3), dAYS2);
        bVar.e(y0Var, new g0.d(19, y0Var), f.WEEKS);
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
        int i = 59;
        switch (this.b) {
            case 1:
                return this.c;
            case 2:
                return this.c + 31;
            case 3:
                i = 59;
                return i + this.c;
            case 4:
                return this.c + 30;
            case 5:
                return this.c + 61;
            case 6:
                return this.c + 62;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Unknown month: ";
                r1 = str + this.b;
                throw new AssertionError(str + b8);
        }
        i = 60;
    }

    static Object I0(String str) {
        return g0.R.get(str);
    }

    public static g0 J0(int i, int i2) {
        int[] iArr;
        int i3 = 7;
        String str = "Day of year out of range: ";
        i3 = 1;
        if (i2 < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            i2 = str + i2;
            throw new IllegalArgumentException(i2);
        } else {
            if (i2 <= 31) {
                return g0.K0(i, i3, i2);
            }
            int[] r2 = b.e(i) ? g0.E : g0.D;
            int r3 = i2 > (b.e(i) ? g0.E : g0.D)[6] ? 7 : i3;
            while (i3 < 12) {
                if (i2 <= r2[i3]) {
                    return g0.L0(i, i3 + i3, i2 - (r2[i3 - 1]), false);
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            i2 = str + i2;
            throw new IllegalArgumentException(i2);
        }
    }

    public static g0 K0(int i, int i2, int i3) {
        return g0.L0(i, i2, i3, true);
    }

    private static g0 L0(int i, int i2, int i3, boolean z) {
        if (z) {
            b.a(i, i2, i3);
        }
        return new g0(i, i2, i3);
    }

    public static g0 M0(int i, int i2, x0 x0Var) {
        return g0.N0(i, i2, x0Var, true);
    }

    private static g0 N0(int i, int i2, x0 x0Var, boolean z) {
        int i5;
        int i6;
        int i7;
        int i3 = 366;
        final int i8 = 0;
        int i9 = 1;
        if (i2 >= i9) {
            int i4 = 53;
            if (i2 <= i4) {
                if (z) {
                    if (i < g0.x.intValue()) {
                        throw new IllegalArgumentException(g0.Z0(i));
                    }
                }
                int value2 = x0.valueOf(b.c(i, i9, i9)).getValue();
                int r3 = value2 <= 4 ? value2 - 2 : value2 - 9;
                i6 = (value2 <= 4 ? value2 - 2 : value2 - 9) - i9;
                i3 = 366;
                i3 = 365;
                if (g0.x <= 0) {
                    i7 = i - 1;
                    if (!(b.e(i7))) {
                    }
                    i6 = i6 + i3;
                } else {
                    if (!(b.e(i))) {
                    }
                    if (g0.x > i3) {
                        i6 = i6 - i3;
                        i7 = i + 1;
                    }
                }
                net.time4j.g0 g0Var = g0.J0(i7, i6);
                if (i2 == i4 && g0Var.G0() != i4 && !z) {
                    return null;
                }
            }
            return g0Var;
        }
        if (z) {
            throw new IllegalArgumentException(g0.Y0(i2));
        } else {
            return i8;
        }
    }

    public static g0 O0(int i, c0 c0Var, int i2) {
        return g0.L0(i, c0Var.getValue(), i2, true);
    }

    public static g0 P0(long j, z zVar) {
        return (g0)g0.S.a(z.UTC.transform(j, zVar));
    }

    private static void Q0(f0.b<v, g0> bVar) {
        item = r.class;
        Iterator it = d.c().g(item).iterator();
        while (it.hasNext()) {
            Class<r> item = it.next();
        }
        bVar.f(new v0());
    }

    private static void R0(f0.b<v, g0> bVar) {
        int i = 0;
        EnumSet range;
        net.time4j.f[] values = f.values();
        i = 0;
        while (i < values.length) {
            net.time4j.f fVar = values[i];
            EnumSet r10 = fVar.compareTo(f.WEEKS) < 0 ? EnumSet.range(f.MILLENNIA, f.MONTHS) : EnumSet.range(f.WEEKS, f.DAYS);
            bVar.g(fVar, new f.j(fVar), fVar.getLength(), (fVar.compareTo(f.WEEKS) < 0 ? EnumSet.range(f.MILLENNIA, f.MONTHS) : EnumSet.range(f.WEEKS, f.DAYS)));
            i = i + 1;
        }
    }

    private g0 S0(int i) {
        if (this.c == i) {
            return this;
        }
        return g0.K0(this.a, this.b, i);
    }

    private g0 T0(x0 x0Var) {
        net.time4j.x0 x0Var2 = C0();
        if (x0Var2 == x0Var) {
            return this;
        }
        return (g0)g0.S.a(c.f(E0(), (long)(x0Var.getValue() - x0Var2.getValue())));
    }

    private g0 U0(int i) {
        if (D0() == i) {
            return this;
        }
        return g0.J0(this.a, i);
    }

    private g0 W0(int i) {
        if (this.b == i) {
            return this;
        }
        return g0.K0(this.a, i, Math.min(b.d(this.a, i), this.c));
    }

    static /* synthetic */ byte X(g0 g0Var) {
        return g0Var.c;
    }

    private g0 X0(int i) {
        if (this.a == i) {
            return this;
        }
        return g0.K0(i, this.b, Math.min(b.d(i, this.b), this.c));
    }

    static /* synthetic */ int Y(g0 g0Var) {
        return g0Var.B0();
    }

    private static String Y0(int i) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "WEEK_OF_YEAR (ISO) out of range: ";
        str2 = str + i;
        return str2;
    }

    static /* synthetic */ f0 Z() {
        return g0.T;
    }

    private static String Z0(int i) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "YEAR_OF_WEEKDATE (ISO) out of range: ";
        str2 = str + i;
        return str2;
    }

    static /* synthetic */ g0 a0(g0 g0Var, int i) {
        return g0Var.X0(i);
    }

    static /* synthetic */ g0 b0(g0 g0Var, int i) {
        return g0Var.W0(i);
    }

    static /* synthetic */ g0 c0(g0 g0Var, int i) {
        return g0Var.S0(i);
    }

    static /* synthetic */ g0 d0(g0 g0Var, int i) {
        return g0Var.U0(i);
    }

    static /* synthetic */ Integer e0() {
        return g0.z;
    }

    static /* synthetic */ Integer f0() {
        return g0.A;
    }

    static /* synthetic */ Integer g0() {
        return g0.C;
    }

    static /* synthetic */ Integer h0() {
        return g0.B;
    }

    static /* synthetic */ g0 i0(g0 g0Var, x0 x0Var) {
        return g0Var.T0(x0Var);
    }

    static /* synthetic */ g0 j0(int i, int i2, int i3, boolean z) {
        return g0.L0(i, i2, i3, z);
    }

    static /* synthetic */ String k0(int i) {
        return g0.Z0(i);
    }

    static /* synthetic */ g0 l0(int i, int i2, x0 x0Var, boolean z) {
        return g0.N0(i, i2, x0Var, z);
    }

    static /* synthetic */ String m0(int i) {
        return g0.Y0(i);
    }

    static /* synthetic */ k n0() {
        return g0.S;
    }

    static /* synthetic */ int o0(g0 g0Var) {
        return g0Var.a;
    }

    static /* synthetic */ byte p0(g0 g0Var) {
        return g0Var.b;
    }

    private static g0 q0(g0 g0Var, long j) {
        long l2 = c.f((long)g0Var.c, j);
        long l7 = 1L;
        if (l2 >= l7 && l2 <= 28) {
            return g0.K0(g0Var.a, g0Var.b, (int)l2);
        }
        long l4 = c.f((long)g0Var.D0(), j);
        if (l4 >= l7) {
            if (l4 <= 365) {
                return g0.J0(g0Var.a, (int)l4);
            }
        }
        return (g0)g0.S.a(c.f(g0Var.E0(), j));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public static f0<v, g0> t0() {
        return g0.T;
    }

    static g0 u0(f fVar, g0 g0Var, long j, int i) {
        final int ordinal = fVar.ordinal();
        switch (g0.a.a[ordinal]) {
            case 1:
                return g0.u0(f.MONTHS, g0Var, c.i(j, r5, 12000, ordinal), r5, i);
            case 2:
                return g0.u0(f.MONTHS, g0Var, c.i(j, r5, 1200, ordinal), r5, i);
            case 3:
                return g0.u0(f.MONTHS, g0Var, c.i(j, r5, 120, ordinal), r5, i);
            case 4:
                return g0.u0(f.MONTHS, g0Var, c.i(j, r5, 12, ordinal), r5, i);
            case 5:
                return g0.u0(f.MONTHS, g0Var, c.i(j, r5, 3, ordinal), r5, i);
            case 6:
                return g0.z0(g0Var, c.f(g0Var.F0(), ordinal, j, r5), r5, g0Var.c, i);
            case 7:
                return g0.u0(f.DAYS, g0Var, c.i(j, r5, 7, ordinal), r5, i);
            case 8:
                return g0.q0(g0Var, j, r5);
            default:
                throw new UnsupportedOperationException(f.MONTHS.name());
        }
    }

    private static void v0(Map<String, Object> map, p<?> pVar) {
        map.put(pVar.name(), pVar);
    }

    private static void w0(StringBuilder sb, int i) {
        sb.append('-');
        i = 10;
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
    }

    private Object writeReplace() {
        return new SPX(this, 1);
    }

    private static void x0(StringBuilder sb, int i) {
        int i22;
        if (i < 0) {
            sb.append('-');
            i22 = c.j(i);
        } else {
            i22 = i;
        }
        i = 10000;
        if (i22 >= 10000) {
            if (i > 0) {
                sb.append('+');
            }
        } else {
            int i3 = 1000;
            if (i22 < 1000) {
                char c = '0';
                sb.append(c);
                i = 100;
                if (i22 < 100) {
                    sb.append(c);
                    i = 10;
                    if (i22 < 10) {
                        sb.append(c);
                    }
                }
            }
        }
        sb.append(i22);
    }

    public static g0 y0(a aVar) {
        if (aVar instanceof g0) {
            return aVar;
        }
        return g0.K0(aVar.m(), aVar.o(), aVar.q());
    }

    private static g0 z0(g0 g0Var, long j, int i, int i2) throws ChronoException {
        long l = 1;
        int i6;
        i = 2;
        i2 = 5;
        if (i2 == 5) {
            if (g0Var.c == g0Var.H0()) {
            }
        }
        int i7 = 12;
        int i10 = c.g(c.f(c.b(j, i7), 1970L));
        final int i11 = 1;
        int i9 = (c.d(j, i7)) + i11;
        i6 = b.d(i10, i9);
        if (i > i6) {
            l = 1L;
            switch (i) {
                case 0:
                    break;
                case 1:
                    return g0.z0(g0Var, c.f(j, r9, l, obj2), r9, i11, i);
                case 2:
                    return g0.z0(g0Var, c.f(j, r9, l, obj2), r9, i - i6, i);
                case 3:
                    StringBuilder stringBuilder = new StringBuilder(32);
                    String str2 = "Day of month out of range: ";
                    g0.x0(stringBuilder, i10);
                    g0.w0(stringBuilder, i9);
                    g0.w0(stringBuilder, i);
                    g0Var = 32 + str2;
                    throw new ChronoException(32 + str2);
                default:
                    StringBuilder stringBuilder2 = new StringBuilder();
                    final String str3 = "Overflow policy not implemented: ";
                    j = str3 + i;
                    throw new UnsupportedOperationException(str3 + i);
            }
            return g0.K0(i10, i9, i6);
        }
    }

    @Override // net.time4j.engine.m
    public x0 C0() {
        return x0.valueOf(b.c(this.a, this.b, this.c));
    }

    @Override // net.time4j.engine.m
    public int D0() {
        if (this.b != 1 && this.b != b4) {
            return (g0.D[b - b4]) + this.c + b.e(this.a);
        }
        return this.c;
    }

    @Override // net.time4j.engine.m
    long E0() {
        return g0.S.b(this);
    }

    @Override // net.time4j.engine.m
    long F0() {
        return (long)(this.a - 1970) * 12L + (long)this.b - 1L;
    }

    @Override // net.time4j.engine.m
    int G0() {
        return (Integer)p(z0.D.n()).intValue();
    }

    @Override // net.time4j.engine.m
    public int H0() {
        return b.d(this.a, this.b);
    }

    @Override // net.time4j.engine.m
    protected f0<v, g0> J() {
        return g0.T;
    }

    @Override // net.time4j.engine.m
    protected int O(g gVar) {
        int i;
        if (gVar instanceof g0) {
            i = this.a - gVar.a;
            if (this.a - gVar.a == 0) {
                i = this.b - gVar.b;
                if (this.b - gVar.b == 0) {
                    i = this.c - gVar.c;
                }
            }
            return i;
        }
        return super.O(gVar);
    }

    @Override // net.time4j.engine.m
    g0 V0(long j) {
        return (g0)g0.S.a(j);
    }

    @Override // net.time4j.engine.m
    public boolean equals(Object object) {
        boolean z = true;
        byte b;
        byte b2;
        int i2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof g0) {
            if (this.c == object.c) {
                if (this.b == object.b) {
                    if (this.a != object.a) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.engine.m
    public int hashCode() {
        return (i << 11) + (this.b << 6) + this.c ^ (i & (-2048));
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
    public i0 r0(h0 h0Var) {
        return i0.d0(this, h0Var);
    }

    @Override // net.time4j.engine.m
    public i0 s0() {
        return r0(h0.E);
    }

    @Override // net.time4j.engine.m
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        g0.x0(stringBuilder, this.a);
        g0.w0(stringBuilder, this.b);
        g0.w0(stringBuilder, this.c);
        str = 32;
        return str;
    }

    @Override // net.time4j.engine.m
    protected g0 A0() {
        return this;
    }
}
