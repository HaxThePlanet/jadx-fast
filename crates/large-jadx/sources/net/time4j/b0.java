package net.time4j;

import android.app.ActivityManager.MemoryInfo;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.time4j.engine.ChronoException;
import net.time4j.engine.a0;
import net.time4j.engine.d0;
import net.time4j.engine.f0;
import net.time4j.engine.f0.b;
import net.time4j.engine.g0;
import net.time4j.engine.i0;
import net.time4j.engine.j;
import net.time4j.engine.k0;
import net.time4j.engine.m;
import net.time4j.engine.q;
import net.time4j.engine.t;
import net.time4j.engine.w;
import net.time4j.engine.x;
import net.time4j.engine.y;
import net.time4j.engine.z;
import net.time4j.g1.a;
import net.time4j.g1.e;
import net.time4j.tz.k;

/* compiled from: Moment.java */
@c("iso8601")
/* loaded from: classes3.dex */
public final class b0 extends i0<TimeUnit, b0> implements net.time4j.i1.g {

    private static final f0<TimeUnit, b0> A;
    public static final b0 B = null;
    public static final net.time4j.engine.p<TimeUnit> C;
    private static final long c = 0L;
    private static final long serialVersionUID = -3192884724477742274L;
    private static final long v = 0L;
    private static final b0 w = new b0();
    private static final b0 x = new b0();
    private static final Map<net.time4j.engine.p<?>, Integer> y;
    private static final Map<TimeUnit, Double> z;
    private final transient long a;
    private final transient int b;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static {
            int[] iArr = new int[TimeUnit.values().length];
            b0.a.c = iArr;
            int i2 = 1;
            try {
                iArr[TimeUnit.DAYS.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int i4 = 4;
                int i5 = 5;
                int i6 = 6;
                int[] iArr13 = new int[n0.values().length];
                b0.a.b = iArr13;
                int[] iArr15 = new int[f.values().length];
                b0.a.a = iArr15;
                return;
            }
            int i = 2;
            try {
                b0.a.c[TimeUnit.HOURS.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                iArr13 = new int[n0.values().length];
                b0.a.b = iArr13;
                iArr15 = new int[f.values().length];
                b0.a.a = iArr15;
                return;
            }
        }
    }

    private static class b implements g0<b0> {
        private b() {
            super();
        }

        public int a(b0 b0Var, b0 b0Var2) {
            return b0Var.a0(b0Var2);
        }

        /* synthetic */ b(b0.a aVar) {
            this();
        }
    }

    private enum c implements net.time4j.engine.p<Integer>, y<b0, Integer> {

        FRACTION;
        @Override // java.lang.Enum
        public String getDisplayName(Locale locale) {
            return name();
        }

        @Override // java.lang.Enum
        public Class<Integer> getType() {
            return Integer.class;
        }

        @Override // java.lang.Enum
        public int compare(net.time4j.engine.o oVar, net.time4j.engine.o oVar2) {
            return (Integer)oVar.p(this).compareTo((Integer)oVar2.p(this));
        }

        @Override // java.lang.Enum
        public Integer getDefaultMaximum() {
            return 999999999;
        }

        @Override // java.lang.Enum
        public Integer getDefaultMinimum() {
            return null;
        }

        @Override // java.lang.Enum
        public Integer getMaximum(b0 b0Var) {
            return getDefaultMaximum();
        }

        @Override // java.lang.Enum
        public Integer getMinimum(b0 b0Var) {
            return getDefaultMinimum();
        }

        @Override // java.lang.Enum
        public Integer getValue(b0 b0Var) {
            return Integer.valueOf(b0Var.a());
        }

        @Override // java.lang.Enum
        public boolean isValid(b0 b0Var, Integer integer) {
            boolean z = false;
            z = false;
            if (integer == null) {
                return false;
            }
            final int value = integer.intValue();
            if (value >= 0 && value < 1000000000) {
                int i2 = 1;
            }
            return z;
        }

        @Override // java.lang.Enum
        public b0 withValue(b0 b0Var, Integer integer, boolean z) {
            if (integer == null) {
                throw new IllegalArgumentException("Missing fraction value.");
            } else {
                if (d.w().A()) {
                    net.time4j.i1.f uTC2 = f.UTC;
                    return b0.o0(b0Var.f(uTC2), integer.intValue(), uTC2);
                }
                return b0.o0(b0Var.x(), integer.intValue(), f.POSIX);
            }
        }

        @Override // java.lang.Enum
        public net.time4j.engine.p<?> getChildAtCeiling(b0 b0Var) {
            return null;
        }

        @Override // java.lang.Enum
        public net.time4j.engine.p<?> getChildAtFloor(b0 b0Var) {
            return null;
        }

        @Override // java.lang.Enum
        public char getSymbol() {
            return 0;
        }

        @Override // java.lang.Enum
        public boolean isDateElement() {
            return false;
        }

        @Override // java.lang.Enum
        public boolean isLenient() {
            return false;
        }

        @Override // java.lang.Enum
        public boolean isTimeElement() {
            return false;
        }
    }

    private enum d implements net.time4j.engine.p<Long>, y<b0, Long> {

        POSIX_TIME;
        @Override // java.lang.Enum
        public String getDisplayName(Locale locale) {
            return name();
        }

        @Override // java.lang.Enum
        public Class<Long> getType() {
            return Long.class;
        }

        @Override // java.lang.Enum
        public int compare(net.time4j.engine.o oVar, net.time4j.engine.o oVar2) {
            return (Long)oVar.p(this).compareTo((Long)oVar2.p(this));
        }

        @Override // java.lang.Enum
        public net.time4j.engine.p<?> getChildAtCeiling(b0 b0Var) {
            return b0.c.FRACTION;
        }

        @Override // java.lang.Enum
        public net.time4j.engine.p<?> getChildAtFloor(b0 b0Var) {
            return b0.c.FRACTION;
        }

        @Override // java.lang.Enum
        public Long getDefaultMaximum() {
            return Long.valueOf(b0.v);
        }

        @Override // java.lang.Enum
        public Long getDefaultMinimum() {
            return Long.valueOf(b0.c);
        }

        @Override // java.lang.Enum
        public Long getMaximum(b0 b0Var) {
            return Long.valueOf(b0.v);
        }

        @Override // java.lang.Enum
        public Long getMinimum(b0 b0Var) {
            return Long.valueOf(b0.c);
        }

        @Override // java.lang.Enum
        public Long getValue(b0 b0Var) {
            return Long.valueOf(b0Var.x());
        }

        @Override // java.lang.Enum
        public boolean isValid(b0 b0Var, Long long) {
            boolean z = false;
            z = false;
            if (long == null) {
                return false;
            }
            final long value = long.longValue();
            long l = b0.c;
            if (value >= l) {
                l = b0.v;
                if (value <= l) {
                    int i = 1;
                }
            }
            return z;
        }

        @Override // java.lang.Enum
        public b0 withValue(b0 b0Var, Long long, boolean z) {
            if (long == null) {
                throw new IllegalArgumentException("Missing elapsed seconds.");
            } else {
                return b0.o0(long.longValue(), b0Var.a(), f.POSIX);
            }
        }

        @Override // java.lang.Enum
        public char getSymbol() {
            return 0;
        }

        @Override // java.lang.Enum
        public boolean isDateElement() {
            return false;
        }

        @Override // java.lang.Enum
        public boolean isLenient() {
            return false;
        }

        @Override // java.lang.Enum
        public boolean isTimeElement() {
            return false;
        }
    }

    private static class e implements t<b0> {
        private e() {
            super();
        }

        public d0 a() {
            return d0.a;
        }

        public w<?> b() {
            return i0.U();
        }

        public int d() {
            return g0.t0().d();
        }

        public String f(x xVar, Locale locale) {
            e style = e.ofStyle(xVar.getStyleValue());
            return b.s(style, style, locale);
        }

        public b0 g(q<?> qVar, net.time4j.engine.d dVar, boolean z, boolean z2) {
            int value = 0;
            net.time4j.n0 n0Var = null;
            k kVar;
            Object obj;
            Object obj6;
            net.time4j.b0 dVar22;
            net.time4j.tz.g lATER_OFFSET2;
            net.time4j.tz.l lVar;
            boolean z6;
            Object obj3;
            int i4 = 1972;
            Object obj4 = dVar.a(a.w, f.UTC);
            if (qVar instanceof f) {
                return b0.c0((f)f.class.cast(qVar)).x0(obj4);
            }
            net.time4j.b0.d pOSIX_TIME2 = b0.d.POSIX_TIME;
            value = 0;
            if (qVar.v(pOSIX_TIME2)) {
                net.time4j.b0.c fRACTION2 = b0.c.FRACTION;
                if (qVar.v(fRACTION2)) {
                    value = (Integer)qVar.p(b0.c.FRACTION).intValue();
                }
                return b0.o0((Long)qVar.p(b0.d.POSIX_TIME).longValue(), value, f.POSIX).x0(obj4);
            }
            int i2 = 60;
            if (qVar.v(a0.LEAP_SECOND)) {
                int i5 = 1;
                qVar.E(h0.Q, i2);
            }
            net.time4j.engine.p pVar = i0.U().E();
            if (qVar.v(pVar)) {
                obj3 = qVar.p(pVar);
            } else {
                i0 i0Var = i0.U().D(qVar, dVar, z, z2);
            }
            int i = 0;
            if (b0.c.FRACTION == null) {
                return null;
            }
            if (qVar.j()) {
                kVar = qVar.t();
            } else {
                net.time4j.engine.c cVar2 = a.d;
                Object obj5 = dVar.c(cVar2) ? (k)obj5 : i;
            }
            if (a.d == null) {
            } else {
                a0 dAYLIGHT_SAVING2 = a0.DAYLIGHT_SAVING;
                if (qVar.v(dAYLIGHT_SAVING2)) {
                    qVar = (Boolean)qVar.p(a0.DAYLIGHT_SAVING).booleanValue() ? g.EARLIER_OFFSET : g.LATER_OFFSET;
                    dVar22 = obj3.a0(((Boolean)qVar.p(a0.DAYLIGHT_SAVING).booleanValue() ? g.EARLIER_OFFSET : g.LATER_OFFSET));
                } else {
                    net.time4j.engine.c cVar4 = a.e;
                    if (dVar.c(cVar4)) {
                        dVar22 = obj3.a0(l.N(kVar).Q((o)dVar.b(a.e)));
                    } else {
                        dVar22 = obj3.b0(kVar);
                    }
                }
            }
            if (a.e == null) {
                return i;
            }
            if (n0Var != null) {
                if (kVar instanceof p) {
                } else {
                    net.time4j.tz.p pVar2 = l.N(kVar).B(dVar22);
                }
                if (obj.n() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Leap second is only allowed  with timezone-offset in full minutes: ";
                    dVar = str + obj;
                    throw new IllegalArgumentException(dVar);
                } else {
                    i3 = obj.m() % i2;
                    if (a.d.m() % i2 == 0) {
                        i4 = 1972;
                        long l = 1L;
                        if (dVar22.e0().m() >= 1972) {
                            dVar22 = dVar22.q0(l, n0.SECONDS);
                        } else {
                            dVar22 = new b0(dVar22.a(), dVar22.x() + 1L, obj6, i);
                        }
                        if (z != 0) {
                        }
                    }
                }
            }
            return dVar22.x0(obj4);
        }

        public net.time4j.engine.o h(b0 b0Var, net.time4j.engine.d dVar) {
            net.time4j.engine.c cVar = a.d;
            if (!dVar.c(cVar)) {
                throw new IllegalArgumentException("Cannot print moment without timezone.");
            } else {
                return b0Var.y0((f)dVar.a(a.w, f.UTC)).j0((k)dVar.b(a.d));
            }
        }

        /* synthetic */ e(b0.a aVar) {
            this();
        }
    }

    private static class f implements y<b0, TimeUnit> {
        private f() {
            super();
        }

        public TimeUnit e(b0 b0Var) {
            return TimeUnit.NANOSECONDS;
        }

        public TimeUnit f(b0 b0Var) {
            return TimeUnit.DAYS;
        }

        public TimeUnit g(b0 b0Var) {
            int i = b0Var.a();
            if (i != 0) {
                if (i % 1000000 == 0) {
                    return TimeUnit.MILLISECONDS;
                }
                if (i % 1000 == 0) {
                    return TimeUnit.MICROSECONDS;
                }
                return TimeUnit.NANOSECONDS;
            }
            long l = b0Var.a;
            if (c.d(l, 86400) == 0) {
                return TimeUnit.DAYS;
            }
            if (c.d(l, 3600) == 0) {
                return TimeUnit.HOURS;
            }
            if (c.d(l, 60) == 0) {
                return TimeUnit.MINUTES;
            }
            return TimeUnit.SECONDS;
        }

        public b0 i(b0 b0Var, TimeUnit timeUnit, boolean z) {
            Enum obj;
            net.time4j.b0 b0Var2;
            if (timeUnit == 0) {
                throw new IllegalArgumentException("Missing precision.");
            } else {
                int i2 = b0.a.c[timeUnit.ordinal()];
                switch (i2) {
                    case 1:
                        return b0.p0(c.b(b0.U(b0Var), timeUnit, 86400) * 86400, timeUnit, f.POSIX);
                    case 2:
                        return b0.p0(c.b(b0.U(b0Var), timeUnit, 3600) * 3600, timeUnit, f.POSIX);
                    case 3:
                        return b0.p0(c.b(b0.U(b0Var), timeUnit, 60) * 60, timeUnit, f.POSIX);
                    case 4:
                        int i = 0;
                        b0Var2 = b0.o0(b0.U(b0Var), 0, f.POSIX);
                        break;
                    case 5:
                        int i16 = 1000000;
                        b0Var2 = b0.o0(b0.U(b0Var), b0Var.a() / i16 * i16, f.POSIX);
                        break;
                    case 6:
                        b0Var2 = b0.o0(b0.U(b0Var), b0Var.a() / 1000 * 1000, f.POSIX);
                        break;
                    case 7:
                        return b0Var;
                    default:
                        throw new UnsupportedOperationException(timeUnit.name());
                }
                if (b0Var.m0()) {
                    if (d.w().A()) {
                        return b0Var2.q0(1L, n0.SECONDS);
                    }
                }
                return b0Var2;
            }
        }

        /* synthetic */ f(b0.a aVar) {
            this();
        }

        public net.time4j.engine.p<?> b(b0 b0Var) {
            return null;
        }

        public net.time4j.engine.p<?> d(b0 b0Var) {
            return null;
        }

        public boolean h(b0 b0Var, TimeUnit timeUnit) {
            boolean z = true;
            b0Var = timeUnit != null ? 1 : 0;
            return (timeUnit != null ? 1 : 0);
        }
    }

    private static class g implements k0<b0> {

        private final TimeUnit a;
        g(TimeUnit timeUnit) {
            super();
            this.a = timeUnit;
        }

        public b0 c(b0 b0Var, long j) {
            long l3 = 1L;
            if (this.a.compareTo(TimeUnit.SECONDS) >= 0) {
                return b0.o0(c.f(b0Var.x(), c.i(j, this.a.toSeconds(l3))), b0Var.a(), f.POSIX);
            }
            long l10 = c.f((long)b0Var.a(), c.i(j, this.a.toNanos(l3)));
            int i2 = 1000000000;
            long l11 = c.b(l10, i2);
            return b0.o0(c.f(b0Var.x(), l11), c.d(l10, i2), f.POSIX);
        }

        public long d(b0 b0Var, b0 b0Var2) {
            long l2;
            final TimeUnit sECONDS2 = TimeUnit.SECONDS;
            if (this.a.compareTo(sECONDS2) < 0) {
                i3 = b0Var2.a() - b0Var.a();
                l2 = c.f(c.i(c.m(b0Var2.x(), b0Var.x()), 1000000000L), (long)i3);
            } else {
                l2 = b0Var2.x() - b0Var.x();
                long l3 = 1L;
                if (this.a < 0) {
                    if (b0Var2.a() > b0Var.a()) {
                        l2 = l2 + 1L;
                    }
                } else {
                    if (this.a > 0 && b0Var2.a() < b0Var.a()) {
                        l2 = l2 - 1L;
                    }
                }
            }
            switch (b0.a.c[this.a.ordinal()]) {
                case 1: /* ordinal */
                    l2 = l2 / 86400L;
                    return l2;
                case 2: /* ordinal */
                    l2 = l2 / 3600L;
                    return l2;
                case 3: /* ordinal */
                    l2 = l2 / 60L;
                    return l2;
                case 4: /* ordinal */
                    return l2;
                case 5: /* ordinal */
                    l2 = l2 / 1000000L;
                    return l2;
                case 6: /* ordinal */
                    l2 = l2 / 1000L;
                    return l2;
                default:
                    throw new UnsupportedOperationException(this.a.name());
            }
        }
    }
    static {
        int i;
        int i4 = 1;
        Integer num = Integer.valueOf(i4);
        int i2 = 31;
        z uNIX2 = z.UNIX;
        z mODIFIED_JULIAN_DATE2 = z.MODIFIED_JULIAN_DATE;
        long l14 = 86400L;
        long l3 = (uNIX2.transform(b.j(-999999999, i4, i4), mODIFIED_JULIAN_DATE2)) * l14;
        b0.c = l3;
        long l = 86399L;
        long l13 = (uNIX2.transform(b.j(999999999, 12, i2), mODIFIED_JULIAN_DATE2)) * l14 + l;
        b0.v = l13;
        net.time4j.i1.f fVar = null;
        net.time4j.b0 b0Var2 = new b0(63158400L, l13, fVar, f.POSIX);
        HashSet hashSet = new HashSet();
        hashSet.add(h0.N);
        hashSet.add(h0.M);
        hashSet.add(h0.L);
        hashSet.add(h0.K);
        hashSet.add(h0.J);
        hashSet.add(h0.I);
        hashSet.add(h0.O);
        hashSet.add(h0.P);
        Collections.unmodifiableSet(hashSet);
        HashMap hashMap = new HashMap();
        hashMap.put(h0.Q, num);
        hashMap.put(h0.R, num);
        Integer num2 = 1000;
        hashMap.put(h0.S, num2);
        hashMap.put(h0.V, num2);
        Integer num3 = 1000000;
        hashMap.put(h0.T, num3);
        hashMap.put(h0.W, num3);
        Integer num4 = 1000000000;
        hashMap.put(h0.U, num4);
        hashMap.put(h0.X, num4);
        b0.y = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(TimeUnit.class);
        enumMap.put(TimeUnit.DAYS, Double.valueOf(86400d));
        enumMap.put(TimeUnit.HOURS, Double.valueOf(3600d));
        enumMap.put(TimeUnit.MINUTES, Double.valueOf(60d));
        enumMap.put(TimeUnit.SECONDS, Double.valueOf(1d));
        enumMap.put(TimeUnit.MILLISECONDS, Double.valueOf(0.001d));
        enumMap.put(TimeUnit.MICROSECONDS, Double.valueOf(0.000001d));
        enumMap.put(TimeUnit.NANOSECONDS, Double.valueOf(0.000000001d));
        b0.z = Collections.unmodifiableMap(enumMap);
        net.time4j.b0.a aVar = null;
        f0.b bVar = f0.b.k(TimeUnit.class, b0.class, new b0.e(aVar), l, l3);
        TimeUnit[] values = TimeUnit.values();
        for (TimeUnit timeUnit : values) {
            Map map = b0.z;
            bVar.g(timeUnit, new b0.g(timeUnit), (Double)map.get(timeUnit).doubleValue(), map.keySet());
        }
        net.time4j.b0.d pOSIX_TIME2 = b0.d.POSIX_TIME;
        bVar.e(pOSIX_TIME2, pOSIX_TIME2, TimeUnit.SECONDS);
        net.time4j.b0.c fRACTION2 = b0.c.FRACTION;
        bVar.e(fRACTION2, fRACTION2, TimeUnit.NANOSECONDS);
        net.time4j.engine.p pVar = j0.w;
        bVar.d(pVar, new b0.f(aVar));
        bVar.l(new b0.b(aVar));
        b0.A = bVar.h();
        b0.B = new b0(0L, i, fVar, f.POSIX);
        b0.C = pVar;
    }

    /* synthetic */ b0(int i, long j, b0.a aVar) {
        this(i, j, r3);
    }

    static /* synthetic */ long O() {
        return b0.c;
    }

    static /* synthetic */ long P() {
        return b0.v;
    }

    static /* synthetic */ b0 Q(b0 b0Var, net.time4j.i1.f fVar) {
        return b0Var.x0(fVar);
    }

    static /* synthetic */ g0 R(b0 b0Var) {
        return b0Var.e0();
    }

    static /* synthetic */ boolean S(b0 b0Var) {
        return b0Var.n0();
    }

    static /* synthetic */ b0 T(b0 b0Var, net.time4j.i1.f fVar) {
        return b0Var.y0(fVar);
    }

    static /* synthetic */ long U(b0 b0Var) {
        return b0Var.a;
    }

    public static f0<TimeUnit, b0> V() {
        return b0.A;
    }

    static void W(b0 b0Var) {
        if (b0Var.a < 63072000) {
            throw new UnsupportedOperationException("Cannot calculate SI-duration before 1972-01-01.");
        }
    }

    private static void X(int i) {
        if (i >= 1000000000) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Nanosecond out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            if (i >= 0) {
                return;
            }
        }
    }

    static void Y(long j, i0 i0Var) throws ChronoException {
        net.time4j.i1.d dVar = d.w();
        if (dVar.D()) {
            long l = dVar.C(dVar.g(j));
            if (l > j) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Illegal local timestamp due to negative leap second: ";
                r4 = str + i0Var;
                throw new ChronoException(r4);
            }
        }
    }

    private static void Z(long j) {
        long l = b0.v;
        if (j > b0.v) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "UNIX time (UT) out of supported range: ";
            j = str + j;
            throw new IllegalArgumentException(j);
        } else {
            long l2 = b0.c;
            if (j >= b0.c) {
                return;
            }
        }
    }

    private static void b0(int i, int i2, StringBuilder sb) {
        int i3 = 0;
        int i4;
        char c = 48;
        i3 = 0;
        i4 = 1;
        i5 = i2 - 1;
        while (i3 < i2 - 1) {
            i4 = i4 * 10;
            i3 = i3 + 1;
            i5 = i2 - 1;
        }
        while (i < i4) {
        }
        sb.append(String.valueOf(i));
    }

    public static b0 c0(net.time4j.f1.f fVar) {
        if (fVar instanceof b0) {
            return (b0)b0.class.cast(fVar);
        }
        z = fVar instanceof g;
        if (fVar instanceof g) {
            if (d.w().A()) {
                Object cast2 = g.class.cast(fVar);
                net.time4j.i1.f uTC2 = f.UTC;
                return b0.o0(cast2.f(uTC2), cast2.n(uTC2), uTC2);
            }
        }
        return b0.o0(fVar.x(), fVar.a(), f.POSIX);
    }

    private g0 e0() {
        return g0.P0(c.b(this.a, 86400), z.UNIX);
    }

    private long f0() {
        long l;
        if (d.w().A()) {
            if (n0()) {
                l = d.w().g(this.a) + 1L;
            }
            return l;
        }
        return this.a - 63072000L;
    }

    private double g0() {
        double d9 = 1000000000d;
        double d5 = (double)f0() + 42.184d + (double)a() / d9 - f.deltaT(e0());
        double floored = Math.floor(d5);
        if (Double.compare(d9 - (d5 - floored) * d9, 1d) < 0) {
            return (double)(long)floored + 1L;
        }
        return d5;
    }

    private static int h0(b0 b0Var) {
        return c.d(b0Var.a, 86400);
    }

    private i0 i0(net.time4j.tz.l lVar) {
        return i0.W(this, lVar.B(this));
    }

    private boolean n0() {
        boolean z = true;
        int r0 = this.b >>> 30 != 0 ? 1 : 0;
        return (this.b >>> 30 != 0 ? 1 : 0);
    }

    public static b0 o0(long j, int i, net.time4j.i1.f fVar) {
        if (j == 0 && i == null && fVar == f.POSIX) {
            return b0.B;
        }
        return new b0(j, r3, i, fVar);
    }

    public static b0 p0(long j, net.time4j.i1.f fVar) {
        return b0.o0(j, 0, fVar);
    }

    static b0 r0(DataInput dataInput, boolean z, boolean z2) throws InvalidObjectException, java.io.IOException {
        long l;
        String z22;
        long l2 = 1;
        int _int = 0;
        int cmp = 999999999;
        long _long = dataInput.readLong();
        if (z2) {
            _int = dataInput.readInt();
        } else {
            _int = 0;
        }
        if (_long == 0) {
            if (z) {
                throw new InvalidObjectException("UTC epoch is no leap second.");
            } else {
                if (_int == 0) {
                    return b0.B;
                }
            }
        }
        long l4 = b0.c;
        if (_long == b0.c && b0.B == 0) {
            if (z) {
                throw new InvalidObjectException("Minimum is no leap second.");
            } else {
                return b0.w;
            }
        }
        l = b0.v;
        if (_long == b0.v && b0.B == 999999999) {
            if (z) {
                throw new InvalidObjectException("Maximum is no leap second.");
            } else {
                return b0.x;
            }
        }
        b0.X(_int);
        if (z) {
            net.time4j.i1.d dVar = d.w();
            if (dVar.A()) {
                l2 = 1L;
                l = dVar.g(_long) + l2;
                z = dVar.B(l);
                if (!(z)) {
                    long l6 = b.l(_long);
                    int i6 = b.h(l6);
                    int i2 = b.g(l6);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Not registered as leap second event: ");
                    stringBuilder.append(b.i(l6));
                    stringBuilder.append("-");
                    z22 = "0";
                    z22 = "";
                    int i4 = 10;
                    String r4 = i6 < i4 ? "0" : z22;
                    stringBuilder.append((i6 < i4 ? "0" : z22));
                    stringBuilder.append(i6);
                    if (i2 >= i4) {
                    }
                }
                stringBuilder.append(z22);
                stringBuilder.append(i2);
                stringBuilder.append(" [Please check leap second configurations ");
                stringBuilder.append("either of emitter vm or this target vm]");
                InvalidObjectException invalidObjectException = new InvalidObjectException(stringBuilder.toString());
                throw invalidObjectException;
            }
            int i = 1073741824;
            _int = _int | i;
        }
        return new b0(_int, _long, l3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static int u0(double d, long j) {
        try {
        } catch (java.lang.ArithmeticException unused) {
            j = (double)j;
            d -= j;
            d *= d2;
            d = (int)d;
            return d;
        }
        return (int)(d * 1000000000d) - (double)(c.i(j, 1000000000L));
    }

    private String v0(boolean z) {
        int i2;
        int i5 = b0.h0(this);
        int i8 = i5 / 60;
        i = i8 / 60;
        i8 %= 60;
        int i7 = (i5 % 60) + d.w().y(f0());
        int i12 = a();
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append(e0());
        stringBuilder.append('T');
        int i4 = 2;
        b0.b0(i, i4, stringBuilder);
        if (!z) {
            i = (i9 | i7) | i12;
            if (i9 | i7 | i12 != 0) {
                char c = ':';
                stringBuilder.append(c);
                b0.b0(i9, i4, stringBuilder);
                if (!z) {
                    i2 = i7 | i12;
                    if (i7 | i12 != 0) {
                        stringBuilder.append(c);
                        b0.b0(i7, i4, stringBuilder);
                        if (i12 > 0) {
                            stringBuilder.append(',');
                            i2 = 9;
                            b0.b0(i12, i2, stringBuilder);
                        }
                    }
                }
            }
        }
        stringBuilder.append('Z');
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        return new SPX(this, 4);
    }

    private b0 x0(net.time4j.i1.f fVar) {
        if (fVar == f.UTC) {
            return this;
        }
        if (m0()) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Leap seconds do not exist on continuous time scale: ";
            fVar = str + fVar;
            throw new IllegalArgumentException(fVar);
        } else {
            int i2 = b0.a.a[fVar.ordinal()];
            if (b0.a.a != 1 && b0.a.a != 3) {
                if (b0.a.a != 4 && b0.a.a != 5) {
                    int i = 6;
                    if (b0.a.a != 6) {
                        throw new UnsupportedOperationException(fVar.name());
                    } else {
                        return new b0(c.m(this.a, 63072000L), l7, a(), fVar);
                    }
                }
                return new b0(c.m(this.a, 315964800L), l7, a(), fVar);
            }
            return this;
        }
    }

    private b0 y0(net.time4j.i1.f fVar) {
        switch (b0.a.a[fVar.ordinal()]) {
            case 1: /* ordinal */
                return new b0(this.a(), this.a, l4);
            case 2: /* ordinal */
                return this;
            case 3: /* ordinal */
                return new b0(this.n(fVar), c.f(this.f(fVar), l9, -378691200, obj3), l9);
            case 4: /* ordinal */
                return new b0(this.a(), c.f(this.f(f.GPS), l4, 315964800, obj2), l4);
            case 5: /* ordinal */
                return new b0(this.n(fVar), c.f(this.f(fVar), l9, 63072000, obj3), l9);
            default:
                throw new UnsupportedOperationException(fVar.name());
        }
    }

    @Override // net.time4j.engine.i0
    protected f0<TimeUnit, b0> J() {
        return b0.A;
    }

    @Override // net.time4j.engine.i0
    public int a() {
        return this.b & (-1073741825);
    }

    @Override // net.time4j.engine.i0
    public int a0(b0 b0Var) {
        int i = -1;
        long l = f0();
        long l2 = b0Var.f0();
        i = -1;
        if (l < l2) {
            return -1;
        }
        i = 1;
        if (l > l2) {
            return i;
        }
        int i3 = a() - b0Var.a();
        if (i3 > 0) {
        } else {
            if (i3 >= 0) {
                i = 0;
            }
        }
        return i;
    }

    @Override // net.time4j.engine.i0
    public boolean equals(Object object) {
        boolean z = true;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof b0) {
            if (this.a != object.a) {
                return false;
            }
            if (d.w().A()) {
                if (this.b != object.b) {
                }
                return z;
            }
            if (a() != object.a()) {
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.engine.i0
    public long f(net.time4j.i1.f fVar) {
        long l;
        int i = 0;
        long l5;
        long l7;
        long l9;
        long l10;
        final Object fVar3 = this;
        double d8 = 0.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000090908079d;
        double d9 = 1d;
        long l21 = 1L;
        long l6 = 63072000L;
        double d = 1000000000d;
        switch (b0.a.a[fVar.ordinal()]) {
            case 1: /* ordinal */
                return fVar3.a;
            case 2: /* ordinal */
                return this.f0();
            case 3: /* ordinal */
                long l8 = f0();
                d2 = f.deltaT(this.e0()) + (double)fVar3.a - l6;
                double d13 = (double)this.a() / d + (f.deltaT(this.e0()) + (double)fVar3.a - l6);
                double floored2 = Math.floor(d13);
                l10 = (long)floored2;
                d = d - (d13 - floored2 * d);
                l10 = l10 + l21;
                i = 0;
                i = b0.u0(d13, l10);
                long l4 = 441763200L;
                l9 = (l10 - 32) + 441763200L;
                l9 = (l10 - 32 + 441763200L) - l21;
                l2 = this.f0() + 441763200L;
                l4 = 10L;
                l9 = (this.f0() + 441763200) + 10L;
                return l9;
            case 4: /* ordinal */
                l = f0();
                long l19 = d.w().C(l);
                long l3 = 9L;
                l = l + 9L;
                return l - 252892809;
            case 5: /* ordinal */
                double d5 = (f.deltaT(this.e0()) + (double)fVar3.a - l6) + (double)this.a() / d;
                double floored = Math.floor(d5);
                l7 = (long)floored;
                l7 = (long)floored + l21;
                return l7;
            case 6: /* ordinal */
                return l15 - l6;
            default:
                StringBuilder stringBuilder3 = new StringBuilder();
                String str3 = "Not yet implemented: ";
                String fVar2 = fVar;
                r2 = str3 + fVar2;
                throw new UnsupportedOperationException(str3 + fVar2);
        }
    }

    @Override // net.time4j.engine.i0
    public int hashCode() {
        return (int)(l ^ (l >>> 32L)) * 19 + (a() * 37);
    }

    @Override // net.time4j.engine.i0
    public b1 j0(k kVar) {
        return b1.d(this, l.N(kVar));
    }

    @Override // net.time4j.engine.i0
    public boolean k0(net.time4j.i1.g gVar) {
        boolean z = true;
        gVar = a0(b0.c0(gVar)) > 0 ? 1 : 0;
        return (a0(b0.c0(gVar)) > 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    public boolean l0(net.time4j.i1.g gVar) {
        boolean z = true;
        gVar = a0(b0.c0(gVar)) < 0 ? 1 : 0;
        return (a0(b0.c0(gVar)) < 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    public boolean m0() {
        boolean z2 = false;
        if (n0()) {
            int r0 = d.w().A() ? 1 : 0;
        }
        return (d.w().A() ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    public int n(net.time4j.i1.f fVar) {
        int i;
        int i2 = 0;
        int i3 = 0;
        long l4;
        long l5;
        final Object fVar3 = this;
        int ordinal = fVar.ordinal();
        int i4 = 184000000;
        final double d8 = 1d;
        int i15 = 1000000000;
        long l3 = 63072000L;
        double d = 1000000000d;
        switch (b0.a.a[ordinal]) {
            case 1:
                return this.a();
            case 2:
                long l12 = f0();
                long l13 = 441763200L;
                d4 = f.deltaT(this.e0()) + (double)fVar3.a - l3;
                double d15 = (double)this.a() / d + (f.deltaT(this.e0()) + (double)fVar3.a - l3);
                double floored = Math.floor(d15);
                l5 = (long)floored;
                d = d - (d15 - floored * d);
                long l10 = 1L;
                l5 = l5 + 1L;
                i2 = 0;
                i2 = b0.u0(d15, l5);
                l3 = 32L;
                l4 = (l5 - 32L) + 441763200L;
                i = i2 - 184000000;
                l4 = (l5 - 32L + l13) - 1L;
                i = i + i15;
                l4 = this.f0() + 441763200L;
                i = a();
                return i;
            case 3:
                long l8 = d.w().C(this.f0());
                return this.a();
            case 4:
                d2 = (f.deltaT(this.e0()) + (double)fVar3.a - l3) + (double)this.a() / d;
                double floored2 = Math.floor(d2);
                l2 = (long)floored2;
                d3 = (d2 - floored2) * d;
                d = d - (d2 - floored2 * d);
                i3 = 0;
                i3 = b0.u0(d2, (long)floored2);
                i3 = this.a() + i4;
                i3 = i3 - i15;
                return i3;
            case 5:
                return this.a();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Not yet implemented: ";
                String fVar2 = fVar;
                r2 = str + fVar2;
                throw new UnsupportedOperationException(str + fVar2);
        }
    }

    @Override // net.time4j.engine.i0
    public b0 q0(long j, n0 n0Var) {
        net.time4j.b0 b0Var;
        b0.W(this);
        if (j == 0) {
            return this;
        }
        try {
            int i5 = b0.a.b[n0Var.ordinal()];
            long l9 = c.f((long)a(), j);
            int i7 = 1000000000;
            int i = c.d(l9, i7);
            long l10 = c.b(l9, i7);
            if (d.w().A()) {
                b0Var = new b0(c.f(f0(), l10), r6, i, f.UTC);
            } else {
                b0Var = b0.o0(c.f(this.a, l10), i, f.POSIX);
            }
            throw new UnsupportedOperationException();
        } catch (java.lang.IllegalArgumentException iae) {
            n0Var = "Result beyond boundaries of time axis.";
            r6 = new ArithmeticException(n0Var);
            r6.initCause(iae);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) r6;
        }
        if (iae < 0) {
            b0.W(b0Var);
        }
        return b0Var;
    }

    @Override // net.time4j.engine.i0
    public <C extends net.time4j.engine.l<C>> s<C> s0(j<C> jVar, String str, k kVar, d0 d0Var) {
        final net.time4j.i0 i0Var = w0(kVar);
        return s.b((i0)i0Var.L((long)(d0Var.b(i0Var.X(), kVar)), h.SECONDS).X().V(jVar.l(), str), i0Var.Z());
    }

    @Override // net.time4j.engine.i0
    public <C extends m<?, C>> s<C> t0(w<C> wVar, k kVar, d0 d0Var) {
        final net.time4j.i0 i0Var = w0(kVar);
        return s.c((i0)i0Var.L((long)(d0Var.b(i0Var.X(), kVar)), h.SECONDS).X().W(wVar.l()), i0Var.Z());
    }

    @Override // net.time4j.engine.i0
    public String toString() {
        return v0(true);
    }

    @Override // net.time4j.engine.i0
    public i0 w0(k kVar) {
        return i0(l.N(kVar));
    }

    @Override // net.time4j.engine.i0
    public long x() {
        return this.a;
    }

    @Override // net.time4j.engine.i0
    void z0(DataOutput dataOutput) throws java.io.IOException {
        int i = 64;
        int r0 = n0() ? 65 : 64;
        final int i2 = a();
        if (i2 > 0) {
            i = i | 2;
        }
        dataOutput.writeByte(i);
        dataOutput.writeLong(this.a);
        if (i2 > 0) {
            dataOutput.writeInt(i2);
        }
    }

    private b0(long j, int i, net.time4j.i1.f fVar) {
        long j2;
        int fVar32;
        int i3;
        int cmp2;
        int cmp3;
        long l4;
        long l3 = 0;
        int i4 = 1000000000;
        long l5;
        int i5 = 184000000;
        double d2 = 4741671816366391296L;
        long l6 = 441763200;
        final Object j3 = this;
        j2 = j;
        fVar32 = i;
        super();
        if (fVar == f.POSIX) {
            j3.a = j2;
            j3.b = fVar32;
            b0.Z(j3.a);
            b0.X(fVar32);
            return;
        } else {
            net.time4j.i1.d dVar = d.w();
            if (dVar.A()) {
                long l = 1L;
                l3 = 0L;
                if (fVar == f.UTC) {
                    long l2 = dVar.C(j2);
                    j2 -= l20;
                    j3.a = l2;
                    l5 = 0L;
                    if (l16 != l5) {
                        l5 = b0.v;
                        if (l2 != b0.v) {
                            if (l16 == l) {
                                i = 1073741824 | fVar32;
                                j3.b = i;
                            }
                        }
                        StringBuilder stringBuilder4 = new StringBuilder();
                        String str6 = "Cannot handle leap shift of ";
                        String str = ".";
                        r1 = str6 + j2 + str;
                        throw new IllegalStateException(r1);
                    }
                    j3.b = fVar32;
                } else {
                    d2 = 1000000000d;
                    i4 = 1000000000;
                    i5 = 184000000;
                    if (fVar == f.TAI) {
                        if (j3.a < l3) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            String str4 = "TAI not supported before 1958-01-01: ";
                            r1 = str4 + j2;
                            throw new IllegalArgumentException(r1);
                        } else {
                            l6 = 441763200L;
                            cmp2 = (j2 > l6 ? 1 : (j2 == l6 ? 0 : -1));
                            if (j3.a < l6) {
                                i3 = c.e(fVar32, i5);
                                if (i3 >= i4) {
                                    l4 = c.f(c.f(j2, -441763168L), l);
                                    i3 = c.l(i3, i4);
                                }
                                double d10 = (double)l4 + (double)i3 / d2;
                                d = d10 - (f.deltaT(g0.P0(c.b((long)(d10 - 42.184d), 86400), z.UTC)));
                                j2 = (long)Math.floor(d);
                                fVar32 = b0.u0(d, j2);
                            } else {
                            }
                        }
                    }
                    if (fVar == f.GPS) {
                        long l17 = 252892809L;
                        j2 = c.f(j2, l17);
                        if (j2 < l17) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            String str5 = "GPS not supported before 1980-01-06: ";
                            r1 = str5 + j2;
                            throw new IllegalArgumentException(r1);
                        } else {
                        }
                    }
                    if (fVar == f.TT) {
                        l3 = 42L;
                        cmp2 = (j2 > l3 ? 1 : (j2 == l3 ? 0 : -1));
                        if (j3.a < l3 || j3.a == l3) {
                            double d15 = (double)j2 + (double)fVar32 / d2;
                            d = d15 - (f.deltaT(g0.P0(c.b((long)(d15 - 42.184d), 86400), z.UTC)));
                            j2 = (long)Math.floor(d);
                            fVar32 = b0.u0(d, j2);
                        } else {
                            if (fVar32 >= i5) {
                                fVar32 = c.l(fVar32, i5);
                                if (fVar32 < 0) {
                                    j2 = c.m(c.m(j2, l3), l);
                                    fVar32 = c.e(fVar32, i4);
                                }
                            }
                        }
                    } else {
                        if (fVar == f.UT) {
                            l3 = 0L;
                            if (j3.a >= l3) {
                                net.time4j.g0 g0Var3 = g0.P0(c.b(j2, 86400), z.UTC);
                                d = (double)j2 + (double)fVar32 / d2 + f.deltaT(g0Var3) - 42.184d;
                                j2 = (long)Math.floor(d);
                                fVar32 = b0.u0(d, j2);
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "Not yet implemented: ";
                String name = fVar.name();
                r2 = str3 + name;
                throw new UnsupportedOperationException(r2);
            }
        }
        throw new IllegalStateException("Leap seconds are not supported by configuration.");
    }

    private b0(int i, long j) {
        super();
        b0.Z(j);
        this.a = j;
        this.b = i;
    }

    @Override // net.time4j.engine.i0
    protected b0 d0() {
        return this;
    }
}
