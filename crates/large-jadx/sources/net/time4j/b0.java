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
import net.time4j.engine.d;
import net.time4j.engine.d0;
import net.time4j.engine.f0;
import net.time4j.engine.f0.b;
import net.time4j.engine.g0;
import net.time4j.engine.i0;
import net.time4j.engine.j;
import net.time4j.engine.k0;
import net.time4j.engine.m;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.t;
import net.time4j.engine.w;
import net.time4j.engine.x;
import net.time4j.engine.y;
import net.time4j.engine.z;
import net.time4j.f1.b;
import net.time4j.f1.c;
import net.time4j.f1.f;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.c;
import net.time4j.g1.e;
import net.time4j.i1.d;
import net.time4j.i1.f;
import net.time4j.i1.g;
import net.time4j.tz.g;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.o;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
@c("iso8601")
public final class b0 extends i0<TimeUnit, net.time4j.b0> implements g {

    private static final f0<TimeUnit, net.time4j.b0> A = null;
    public static final net.time4j.b0 B = null;
    public static final p<TimeUnit> C = null;
    private static final long c = 0L;
    private static final long serialVersionUID = -3192884724477742274L;
    private static final long v;
    private static final net.time4j.b0 w;
    private static final net.time4j.b0 x;
    private static final Map<p<?>, Integer> y;
    private static final Map<TimeUnit, Double> z;
    private final transient long a;
    private final transient int b;

    static class a {

        static final int[] a;
        static final int[] b;
        static final int[] c;
        static {
            int[] iArr = new int[values.length];
            b0.a.c = iArr;
            int i2 = 1;
            iArr[TimeUnit.DAYS.ordinal()] = i2;
            int i = 2;
            b0.a.c[TimeUnit.HOURS.ordinal()] = i;
            int i3 = 3;
            b0.a.c[TimeUnit.MINUTES.ordinal()] = i3;
            int i4 = 4;
            b0.a.c[TimeUnit.SECONDS.ordinal()] = i4;
            int i5 = 5;
            b0.a.c[TimeUnit.MILLISECONDS.ordinal()] = i5;
            int i6 = 6;
            b0.a.c[TimeUnit.MICROSECONDS.ordinal()] = i6;
            b0.a.c[TimeUnit.NANOSECONDS.ordinal()] = 7;
            int[] iArr13 = new int[values2.length];
            b0.a.b = iArr13;
            iArr13[n0.SECONDS.ordinal()] = i2;
            b0.a.b[n0.NANOSECONDS.ordinal()] = i;
            int[] iArr15 = new int[values3.length];
            b0.a.a = iArr15;
            iArr15[f.POSIX.ordinal()] = i2;
            b0.a.a[f.UTC.ordinal()] = i;
            b0.a.a[f.TAI.ordinal()] = i3;
            b0.a.a[f.GPS.ordinal()] = i4;
            b0.a.a[f.TT.ordinal()] = i5;
            b0.a.a[f.UT.ordinal()] = i6;
        }
    }

    private static class b implements g0<net.time4j.b0> {
        b(net.time4j.b0.a b0$a) {
            super();
        }

        @Override // net.time4j.engine.g0
        public int a(net.time4j.b0 b0, net.time4j.b0 b02) {
            return b0.a0(b02);
        }

        @Override // net.time4j.engine.g0
        public int compare(Object object, Object object2) {
            return a((b0)object, (b0)object2);
        }
    }

    private static enum c implements p<Integer>, y<net.time4j.b0, Integer> {

        FRACTION;
        @Override // java.lang.Enum
        public int compare(Object object, Object object2) {
            return compare((o)object, (o)object2);
        }

        @Override // java.lang.Enum
        public int compare(o o, o o2) {
            return (Integer)o.p(this).compareTo((Integer)o2.p(this));
        }

        @Override // java.lang.Enum
        public p getChildAtCeiling(Object object) {
            return getChildAtCeiling((b0)object);
        }

        public p<?> getChildAtCeiling(net.time4j.b0 b0) {
            return 0;
        }

        @Override // java.lang.Enum
        public p getChildAtFloor(Object object) {
            return getChildAtFloor((b0)object);
        }

        public p<?> getChildAtFloor(net.time4j.b0 b0) {
            return 0;
        }

        @Override // java.lang.Enum
        public Integer getDefaultMaximum() {
            return 999999999;
        }

        @Override // java.lang.Enum
        public Object getDefaultMaximum() {
            return getDefaultMaximum();
        }

        @Override // java.lang.Enum
        public Integer getDefaultMinimum() {
            return null;
        }

        @Override // java.lang.Enum
        public Object getDefaultMinimum() {
            return getDefaultMinimum();
        }

        @Override // java.lang.Enum
        public String getDisplayName(Locale locale) {
            return name();
        }

        @Override // java.lang.Enum
        public Integer getMaximum(net.time4j.b0 b0) {
            return getDefaultMaximum();
        }

        @Override // java.lang.Enum
        public Object getMaximum(Object object) {
            return getMaximum((b0)object);
        }

        @Override // java.lang.Enum
        public Integer getMinimum(net.time4j.b0 b0) {
            return getDefaultMinimum();
        }

        @Override // java.lang.Enum
        public Object getMinimum(Object object) {
            return getMinimum((b0)object);
        }

        @Override // java.lang.Enum
        public char getSymbol() {
            return 0;
        }

        public Class<Integer> getType() {
            return Integer.class;
        }

        @Override // java.lang.Enum
        public Integer getValue(net.time4j.b0 b0) {
            return Integer.valueOf(b0.a());
        }

        @Override // java.lang.Enum
        public Object getValue(Object object) {
            return getValue((b0)object);
        }

        @Override // java.lang.Enum
        public boolean isDateElement() {
            return 0;
        }

        @Override // java.lang.Enum
        public boolean isLenient() {
            return 0;
        }

        @Override // java.lang.Enum
        public boolean isTimeElement() {
            return 0;
        }

        @Override // java.lang.Enum
        public boolean isValid(Object object, Object object2) {
            return isValid((b0)object, (Integer)object2);
        }

        @Override // java.lang.Enum
        public boolean isValid(net.time4j.b0 b0, Integer integer2) {
            int i;
            int obj2;
            if (integer2 == null) {
                return 0;
            }
            final int obj3 = integer2.intValue();
            if (obj3 >= 0 && obj3 < 1000000000) {
                if (obj3 < 1000000000) {
                    obj2 = 1;
                }
            }
            return obj2;
        }

        @Override // java.lang.Enum
        public Object withValue(Object object, Object object2, boolean z3) {
            return withValue((b0)object, (Integer)object2, z3);
        }

        @Override // java.lang.Enum
        public net.time4j.b0 withValue(net.time4j.b0 b0, Integer integer2, boolean z3) {
            if (integer2 == null) {
            } else {
                if (d.w().A()) {
                    f obj5 = f.UTC;
                    return b0.o0(b0.f(obj5), obj1, integer2.intValue());
                }
                return b0.o0(b0.x(), obj1, integer2.intValue());
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("Missing fraction value.");
            throw obj3;
        }
    }

    private static enum d implements p<Long>, y<net.time4j.b0, Long> {

        POSIX_TIME;
        @Override // java.lang.Enum
        public int compare(Object object, Object object2) {
            return compare((o)object, (o)object2);
        }

        @Override // java.lang.Enum
        public int compare(o o, o o2) {
            return (Long)o.p(this).compareTo((Long)o2.p(this));
        }

        @Override // java.lang.Enum
        public p getChildAtCeiling(Object object) {
            return getChildAtCeiling((b0)object);
        }

        public p<?> getChildAtCeiling(net.time4j.b0 b0) {
            return b0.c.FRACTION;
        }

        @Override // java.lang.Enum
        public p getChildAtFloor(Object object) {
            return getChildAtFloor((b0)object);
        }

        public p<?> getChildAtFloor(net.time4j.b0 b0) {
            return b0.c.FRACTION;
        }

        @Override // java.lang.Enum
        public Long getDefaultMaximum() {
            return Long.valueOf(b0.P());
        }

        @Override // java.lang.Enum
        public Object getDefaultMaximum() {
            return getDefaultMaximum();
        }

        @Override // java.lang.Enum
        public Long getDefaultMinimum() {
            return Long.valueOf(b0.O());
        }

        @Override // java.lang.Enum
        public Object getDefaultMinimum() {
            return getDefaultMinimum();
        }

        @Override // java.lang.Enum
        public String getDisplayName(Locale locale) {
            return name();
        }

        @Override // java.lang.Enum
        public Long getMaximum(net.time4j.b0 b0) {
            return Long.valueOf(b0.P());
        }

        @Override // java.lang.Enum
        public Object getMaximum(Object object) {
            return getMaximum((b0)object);
        }

        @Override // java.lang.Enum
        public Long getMinimum(net.time4j.b0 b0) {
            return Long.valueOf(b0.O());
        }

        @Override // java.lang.Enum
        public Object getMinimum(Object object) {
            return getMinimum((b0)object);
        }

        @Override // java.lang.Enum
        public char getSymbol() {
            return 0;
        }

        public Class<Long> getType() {
            return Long.class;
        }

        @Override // java.lang.Enum
        public Long getValue(net.time4j.b0 b0) {
            return Long.valueOf(b0.x());
        }

        @Override // java.lang.Enum
        public Object getValue(Object object) {
            return getValue((b0)object);
        }

        @Override // java.lang.Enum
        public boolean isDateElement() {
            return 0;
        }

        @Override // java.lang.Enum
        public boolean isLenient() {
            return 0;
        }

        @Override // java.lang.Enum
        public boolean isTimeElement() {
            return 0;
        }

        @Override // java.lang.Enum
        public boolean isValid(Object object, Object object2) {
            return isValid((b0)object, (Long)object2);
        }

        @Override // java.lang.Enum
        public boolean isValid(net.time4j.b0 b0, Long long2) {
            long l;
            int obj5;
            int obj6;
            if (long2 == null) {
                return 0;
            }
            final long longValue = long2.longValue();
            if (Long.compare(longValue, l) >= 0 && Long.compare(longValue, l) <= 0) {
                if (Long.compare(longValue, l) <= 0) {
                    obj5 = 1;
                }
            }
            return obj5;
        }

        @Override // java.lang.Enum
        public Object withValue(Object object, Object object2, boolean z3) {
            return withValue((b0)object, (Long)object2, z3);
        }

        @Override // java.lang.Enum
        public net.time4j.b0 withValue(net.time4j.b0 b0, Long long2, boolean z3) {
            if (long2 == null) {
            } else {
                return b0.o0(long2.longValue(), z3, b0.a());
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Missing elapsed seconds.");
            throw obj2;
        }
    }

    private static class e implements t<net.time4j.b0> {
        e(net.time4j.b0.a b0$a) {
            super();
        }

        @Override // net.time4j.engine.t
        public d0 a() {
            return d0.a;
        }

        public w<?> b() {
            return i0.U();
        }

        @Override // net.time4j.engine.t
        public Object c(q q, d d2, boolean z3, boolean z4) {
            return g(q, d2, z3, z4);
        }

        @Override // net.time4j.engine.t
        public int d() {
            return g0.t0().d();
        }

        @Override // net.time4j.engine.t
        public o e(Object object, d d2) {
            return h((b0)object, d2);
        }

        @Override // net.time4j.engine.t
        public String f(x x, Locale locale2) {
            e obj1 = e.ofStyle(x.getStyleValue());
            return b.s(obj1, obj1, locale2);
        }

        public net.time4j.b0 g(q<?> q, d d2, boolean z3, boolean z4) {
            boolean z2;
            Object pVar;
            int i;
            int intValue;
            int i2;
            boolean z5;
            boolean z;
            Object obj8;
            Object obj9;
            long obj10;
            Object obj11;
            Object obj = d2.a(a.w, f.UTC);
            if (q instanceof f) {
                return b0.Q(b0.c0((f)f.class.cast(q)), (f)obj);
            }
            net.time4j.b0.d pOSIX_TIME = b0.d.POSIX_TIME;
            intValue = 0;
            obj11 = b0.c.FRACTION;
            if (q.v(pOSIX_TIME) && q.v(obj11)) {
                obj11 = b0.c.FRACTION;
                if (q.v(obj11)) {
                    intValue = (Integer)q.p(obj11).intValue();
                }
                return b0.Q(b0.o0((Long)q.p(pOSIX_TIME).longValue(), z3, intValue), obj);
            }
            i = 60;
            if (q.v(a0.LEAP_SECOND)) {
                intValue = 1;
                q.E(h0.Q, i);
            }
            pVar = i0.U().E();
            if (q.v(pVar)) {
                obj11 = q.p(pVar);
            } else {
                obj11 = i0.U().D(q, d2, z3, z4);
            }
            int i3 = 0;
            if (obj11 == null) {
                return i3;
            }
            if (q.j()) {
                i2 = q.t();
            } else {
                net.time4j.engine.c cVar2 = a.d;
                if (d2.c(cVar2)) {
                    i2 = d2.b(cVar2);
                } else {
                    i2 = i3;
                }
            }
            if (i2 != 0) {
                a0 dAYLIGHT_SAVING = a0.DAYLIGHT_SAVING;
                if (q.v(dAYLIGHT_SAVING)) {
                    obj8 = (Boolean)q.p(dAYLIGHT_SAVING).booleanValue() ? g.EARLIER_OFFSET : g.LATER_OFFSET;
                    obj8 = obj11.a0(l.N(i2).Q((o)d2.a(a.e, l.c).a(obj8)));
                } else {
                    obj8 = a.e;
                    if (d2.c(obj8)) {
                        obj8 = obj11.a0(l.N(i2).Q((o)d2.b(obj8)));
                    } else {
                        obj8 = obj11.b0(i2);
                    }
                }
            } else {
                obj8 = i3;
            }
            if (obj8 == null) {
                return i3;
            }
            if (intValue != 0) {
                if (i2 instanceof p) {
                } else {
                    i2 = l.N((p)i2).B(obj8);
                }
                if (i2.n() != 0) {
                } else {
                    if (obj9 %= i != 0) {
                    } else {
                        i = 1;
                        if (b0.R(obj8).m() >= 1972) {
                            obj9 = obj8.q0(i, intValue);
                        } else {
                            obj9 = new b0(obj8.a(), l += i, z5, i3);
                        }
                        if (z3 != 0) {
                            obj8 = obj9;
                        } else {
                            if (d.w().A()) {
                                if (!b0.S(obj9)) {
                                } else {
                                }
                                obj10 = new StringBuilder();
                                obj10.append("SECOND_OF_MINUTE parsed as invalid leapsecond before ");
                                obj10.append(obj9);
                                obj8 = new IllegalArgumentException(obj10.toString());
                                throw obj8;
                            }
                        }
                    }
                }
                obj9 = new StringBuilder();
                obj9.append("Leap second is only allowed  with timezone-offset in full minutes: ");
                obj9.append(i2);
                obj8 = new IllegalArgumentException(obj9.toString());
                throw obj8;
            }
            return b0.Q(obj8, obj);
        }

        @Override // net.time4j.engine.t
        public o h(net.time4j.b0 b0, d d2) {
            net.time4j.engine.c cVar = a.d;
            if (!d2.c(cVar)) {
            } else {
                return b0.T(b0, (f)d2.a(a.w, f.UTC)).j0((k)d2.b(cVar));
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("Cannot print moment without timezone.");
            throw obj4;
        }
    }

    private static class f implements y<net.time4j.b0, TimeUnit> {
        f(net.time4j.b0.a b0$a) {
            super();
        }

        public p<?> b(net.time4j.b0 b0) {
            return 0;
        }

        public p<?> d(net.time4j.b0 b0) {
            return 0;
        }

        @Override // net.time4j.engine.y
        public TimeUnit e(net.time4j.b0 b0) {
            return TimeUnit.NANOSECONDS;
        }

        @Override // net.time4j.engine.y
        public TimeUnit f(net.time4j.b0 b0) {
            return TimeUnit.DAYS;
        }

        @Override // net.time4j.engine.y
        public TimeUnit g(net.time4j.b0 b0) {
            int i = b0.a();
            if (i != 0 && i % obj3 == 0) {
                if (i % obj3 == 0) {
                    return TimeUnit.MILLISECONDS;
                }
                if (i %= 1000 == 0) {
                    return TimeUnit.MICROSECONDS;
                }
                return TimeUnit.NANOSECONDS;
            }
            long l = b0.U(b0);
            if (c.d(l, obj1) == 0) {
                return TimeUnit.DAYS;
            }
            if (c.d(l, obj1) == 0) {
                return TimeUnit.HOURS;
            }
            if (c.d(l, obj1) == 0) {
                return TimeUnit.MINUTES;
            }
            return TimeUnit.SECONDS;
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return b((b0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return d((b0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((b0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((b0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((b0)object);
        }

        @Override // net.time4j.engine.y
        public boolean h(net.time4j.b0 b0, TimeUnit timeUnit2) {
            int obj1;
            obj1 = timeUnit2 != null ? 1 : 0;
            return obj1;
        }

        @Override // net.time4j.engine.y
        public net.time4j.b0 i(net.time4j.b0 b0, TimeUnit timeUnit2, boolean z3) {
            int i;
            f pOSIX;
            boolean obj3;
            net.time4j.b0 obj4;
            int obj5;
            if (timeUnit2 == 0) {
            } else {
                obj5 = b0.a.c[timeUnit2.ordinal()];
                switch (obj5) {
                    case 1:
                        return b0.p0(obj3 *= i5, timeUnit2);
                    case 2:
                        return b0.p0(obj3 *= i3, timeUnit2);
                    case 3:
                        return b0.p0(obj3 *= i2, timeUnit2);
                    case 4:
                        obj4 = b0.o0(b0.U(b0), obj5, 0);
                        break;
                    case 5:
                        obj5 = 1000000;
                        obj4 = b0.o0(b0.U(b0), obj1, obj4 *= obj5);
                        break;
                    case 6:
                        obj4 = b0.o0(b0.U(b0), obj1, obj4 *= 1000);
                        break;
                    case 7:
                        return b0;
                    default:
                        obj3 = new UnsupportedOperationException(timeUnit2.name());
                        throw obj3;
                }
                if (b0.m0() && d.w().A()) {
                    if (d.w().A()) {
                        return obj4.q0(1, pOSIX);
                    }
                }
                return obj4;
            }
            obj3 = new IllegalArgumentException("Missing precision.");
            throw obj3;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((b0)object, (TimeUnit)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return i((b0)object, (TimeUnit)object2, z3);
        }
    }

    private static class g implements k0<net.time4j.b0> {

        private final TimeUnit a;
        g(TimeUnit timeUnit) {
            super();
            this.a = timeUnit;
        }

        @Override // net.time4j.engine.k0
        public long a(Object object, Object object2) {
            return d((b0)object, (b0)object2);
        }

        @Override // net.time4j.engine.k0
        public Object b(Object object, long l2) {
            return c((b0)object, l2);
        }

        @Override // net.time4j.engine.k0
        public net.time4j.b0 c(net.time4j.b0 b0, long l2) {
            int i3 = 1;
            if (this.a.compareTo(TimeUnit.SECONDS) >= 0) {
                return b0.o0(c.f(b0.x(), i3), obj7, b0.a());
            }
            long obj6 = c.f((long)i, i3);
            int i2 = 1000000000;
            obj6 = c.b(obj6, obj7);
            return b0.o0(c.f(b0.x(), obj3), obj6, c.d(obj6, obj7));
        }

        @Override // net.time4j.engine.k0
        public long d(net.time4j.b0 b0, net.time4j.b0 b02) {
            int i;
            int cmp;
            int i2;
            int obj6;
            int obj7;
            final TimeUnit sECONDS = TimeUnit.SECONDS;
            if (this.a.compareTo(sECONDS) >= 0) {
                l -= l5;
                cmp = Long.compare(i, i3);
                i2 = 1;
                if (cmp < 0) {
                    if (b02.a() > b0.a()) {
                        i += i2;
                    }
                } else {
                    if (cmp > 0 && b02.a() < b0.a()) {
                        if (b02.a() < b0.a()) {
                            i -= i2;
                        }
                    }
                }
            } else {
                obj7 -= obj6;
                i = c.f(c.i(c.m(b02.x(), sECONDS), sECONDS), sECONDS);
            }
            switch (obj6) {
                case 1:
                    i /= obj6;
                    return i;
                case 2:
                    i /= obj6;
                    return i;
                case 3:
                    i /= obj6;
                    return i;
                case 4:
                    return i;
                case 5:
                    i /= obj6;
                    return i;
                case 6:
                    i /= obj6;
                    return i;
                default:
                    obj6 = new UnsupportedOperationException(this.a.name());
                    throw obj6;
            }
        }
    }
    static {
        int i;
        int i2;
        net.time4j.b0 b0Var;
        f0.b bVar;
        TimeUnit time;
        net.time4j.b0.g gVar;
        double doubleValue;
        Set keySet;
        int i5 = 1;
        Integer valueOf = Integer.valueOf(i5);
        int i7 = 999999999;
        i2 = 31;
        z uNIX = z.UNIX;
        z mODIFIED_JULIAN_DATE = z.MODIFIED_JULIAN_DATE;
        int i17 = 86400;
        transform *= i17;
        b0.c = i4;
        i13 += i16;
        b0.v = i14;
        f pOSIX2 = f.POSIX;
        int i18 = 0;
        b0Var = new b0(i4, i5, i18, pOSIX2);
        b0.w = b0Var;
        b0 b0Var2 = new b0(i14, i2, i7, pOSIX2);
        b0.x = b0Var2;
        b0 b0Var4 = new b0(63158400, i14, i18, pOSIX2);
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
        hashMap.put(h0.Q, valueOf);
        hashMap.put(h0.R, valueOf);
        Integer valueOf2 = 1000;
        hashMap.put(h0.S, valueOf2);
        hashMap.put(h0.V, valueOf2);
        Integer valueOf3 = 1000000;
        hashMap.put(h0.T, valueOf3);
        hashMap.put(h0.W, valueOf3);
        Integer valueOf4 = 1000000000;
        hashMap.put(h0.U, valueOf4);
        hashMap.put(h0.X, valueOf4);
        b0.y = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(TimeUnit.class);
        enumMap.put(TimeUnit.DAYS, Double.valueOf(4680673776000565248L));
        enumMap.put(TimeUnit.HOURS, Double.valueOf(4660134898793709568L));
        enumMap.put(TimeUnit.MINUTES, Double.valueOf(4633641066610819072L));
        enumMap.put(TimeUnit.SECONDS, Double.valueOf(4607182418800017408L));
        enumMap.put(TimeUnit.MILLISECONDS, Double.valueOf(4562254508917369340L));
        enumMap.put(TimeUnit.MICROSECONDS, Double.valueOf(4517329193108106637L));
        enumMap.put(TimeUnit.NANOSECONDS, Double.valueOf(4472406533629990549L));
        b0.z = Collections.unmodifiableMap(enumMap);
        int i15 = 0;
        b0.e eVar = new b0.e(i15);
        f0.b bVar2 = f0.b.k(TimeUnit.class, b0.class, eVar, b0Var, b0Var2);
        TimeUnit[] values = TimeUnit.values();
        i = i18;
        while (i < values.length) {
            time = values[i];
            gVar = new b0.g(time);
            i2 = b0.z;
            bVar2.g(time, gVar, (Double)i2.get(time).doubleValue(), obj13);
            i++;
        }
        net.time4j.b0.d pOSIX_TIME = b0.d.POSIX_TIME;
        bVar2.e(pOSIX_TIME, pOSIX_TIME, TimeUnit.SECONDS);
        net.time4j.b0.c fRACTION = b0.c.FRACTION;
        bVar2.e(fRACTION, fRACTION, TimeUnit.NANOSECONDS);
        p pVar = j0.w;
        b0.f fVar = new b0.f(i15);
        bVar2.d(pVar, fVar);
        b0.b bVar3 = new b0.b(i15);
        bVar2.l(bVar3);
        b0.A = bVar2.h();
        b0 b0Var3 = new b0(0, i, i18, f.POSIX);
        b0.B = b0Var3;
        b0.C = pVar;
    }

    private b0(int i, long l2) {
        super();
        b0.Z(l2);
        this.a = l2;
        this.b = i;
    }

    b0(int i, long l2, net.time4j.b0.a b0$a3) {
        super(i, l2, a3);
    }

    private b0(long l, int i2, f f3) {
        int l6;
        int i;
        int i7;
        long l7;
        int cmp2;
        int cmp;
        int pOSIX;
        int i5;
        f uTC;
        int i4;
        long l4;
        long l3;
        int i6;
        long l2;
        int i8;
        long l5;
        int i3;
        final Object obj = this;
        l6 = l;
        i = f3;
        cmp = obj21;
        super();
        if (cmp == f.POSIX) {
            obj.a = l6;
            obj.b = i;
            b0.Z(obj.a);
            b0.X(i);
        } else {
            d dVar = d.w();
            if (!dVar.A()) {
            } else {
                i4 = 1;
                if (cmp == f.UTC) {
                    i5 = i;
                    l7 = l6;
                    l4 = dVar.C(l7);
                    l7 -= l17;
                    obj.a = l4;
                    if (Long.compare(cmp2, l2) != 0) {
                        if (Long.compare(l4, l2) == 0) {
                        } else {
                            if (Long.compare(cmp2, i4) != 0) {
                            } else {
                                obj.b = i9 |= i5;
                                i = i5;
                            }
                        }
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Cannot handle leap shift of ");
                        stringBuilder4.append(l6);
                        stringBuilder4.append(".");
                        IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder4.toString());
                        throw illegalStateException2;
                    }
                    obj.b = i5;
                } else {
                    l5 = 4741671816366391296L;
                    l2 = 1000000000;
                    i8 = 184000000;
                    if (cmp == f.TAI) {
                        if (Long.compare(l6, i6) < 0) {
                        } else {
                            cmp = Long.compare(l6, i3);
                            if (cmp < 0) {
                                i7 = c.e(i, i8);
                                if (i7 >= l2) {
                                    l3 = c.f(c.f(l6, obj2), obj10);
                                    i7 = c.l(i7, l2);
                                }
                                d3 += i10;
                                i18 -= deltaT;
                                i5 = b0.u0(i6, obj10);
                            } else {
                                i5 = i;
                                l7 = i6;
                            }
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("TAI not supported before 1958-01-01: ");
                        stringBuilder2.append(l6);
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
                        throw illegalArgumentException;
                    }
                    if (cmp == f.GPS) {
                        i6 = 252892809;
                        l2 = c.f(l6, obj2);
                        if (Long.compare(l2, i6) < 0) {
                        } else {
                            i5 = i;
                            l7 = l2;
                        }
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("GPS not supported before 1980-01-06: ");
                        stringBuilder3.append(l6);
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder3.toString());
                        throw illegalArgumentException2;
                    }
                    if (cmp == f.TT) {
                        i6 = 42;
                        cmp = Long.compare(l6, i6);
                        if (cmp >= 0) {
                            if (cmp == 0 && i < i8) {
                                if (i < i8) {
                                    d5 += i12;
                                    i22 -= deltaT3;
                                    i5 = b0.u0(i6, obj10);
                                } else {
                                    i = c.l(i, i8);
                                    if (i < 0) {
                                        l6 = c.m(c.m(l6, obj2), obj2);
                                        i = c.e(i, l2);
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                        if (cmp != f.UT) {
                        } else {
                            if (Long.compare(l6, i6) < 0) {
                            } else {
                                cmp = g0.P0(c.b(l6, obj2), obj10);
                                i21 -= l12;
                                i5 = b0.u0(i6, obj10);
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Not yet implemented: ");
                stringBuilder.append(obj21.name());
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
                throw unsupportedOperationException;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Leap seconds are not supported by configuration.");
        throw illegalStateException;
    }

    static long O() {
        return b0.c;
    }

    static long P() {
        return b0.v;
    }

    static net.time4j.b0 Q(net.time4j.b0 b0, f f2) {
        return b0.x0(f2);
    }

    static net.time4j.g0 R(net.time4j.b0 b0) {
        return b0.e0();
    }

    static boolean S(net.time4j.b0 b0) {
        return b0.n0();
    }

    static net.time4j.b0 T(net.time4j.b0 b0, f f2) {
        return b0.y0(f2);
    }

    static long U(net.time4j.b0 b0) {
        return b0.a;
    }

    public static f0<TimeUnit, net.time4j.b0> V() {
        return b0.A;
    }

    static void W(net.time4j.b0 b0) {
        if (Long.compare(l, i) < 0) {
        } else {
        }
        UnsupportedOperationException obj4 = new UnsupportedOperationException("Cannot calculate SI-duration before 1972-01-01.");
        throw obj4;
    }

    private static void X(int i) {
        if (i >= 1000000000) {
        } else {
            if (i < 0) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nanosecond out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    static void Y(long l, net.time4j.i0 i02) {
        d dVar;
        boolean z;
        long obj3;
        dVar = d.w();
        if (dVar.D()) {
            if (Long.compare(dVar, l) > 0) {
            } else {
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Illegal local timestamp due to negative leap second: ");
            obj4.append(obj5);
            obj3 = new ChronoException(obj4.toString());
            throw obj3;
        }
    }

    private static void Z(long l) {
        int cmp;
        if (Long.compare(l, l2) > 0) {
        } else {
            if (Long.compare(l, l3) < 0) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UNIX time (UT) out of supported range: ");
        stringBuilder.append(l);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static void b0(int i, int i2, StringBuilder stringBuilder3) {
        int i5;
        int i3;
        int i4;
        int obj5;
        i5 = 0;
        i3 = i6;
        while (i5 < i2 + -1) {
            i3 *= 10;
            i5++;
        }
        while (i < i3) {
            if (i3 >= 10) {
            }
            stringBuilder3.append('0');
            i3 /= 10;
        }
        stringBuilder3.append(String.valueOf(i));
    }

    public static net.time4j.b0 c0(f f) {
        boolean z;
        if (f instanceof b0) {
            return (b0)b0.class.cast(f);
        }
        if (f instanceof g && d.w().A()) {
            if (d.w().A()) {
                Object obj3 = g.class.cast(f);
                f uTC = f.UTC;
                return b0.o0((g)obj3.f(uTC), obj2, obj3.n(uTC));
            }
        }
        return b0.o0(f.x(), obj1, f.a());
    }

    private net.time4j.g0 e0() {
        return g0.P0(c.b(this.a, obj1), obj1);
    }

    private long f0() {
        long l;
        boolean z;
        if (d.w().A() && n0()) {
            if (n0()) {
                l += z;
            }
            return l;
        }
        return l2 -= i2;
    }

    private double g0() {
        long l4 = 4741671816366391296L;
        i3 -= deltaT;
        long l3 = (long)floor;
        if (Double.compare(l4 -= i10, obj6) < 0) {
            return (double)i7;
        }
        return i4;
    }

    private static int h0(net.time4j.b0 b0) {
        return c.d(b0.a, obj1);
    }

    private net.time4j.i0 i0(l l) {
        return i0.W(this, l.B(this));
    }

    private boolean n0() {
        int i;
        i = i2 >>>= 30 != 0 ? 1 : 0;
        return i;
    }

    public static net.time4j.b0 o0(long l, int i2, f f3) {
        int pOSIX;
        if (Long.compare(l, i) == 0 && f3 == null && obj5 == f.POSIX) {
            if (f3 == null) {
                if (obj5 == f.POSIX) {
                    return b0.B;
                }
            }
        }
        b0 b0Var = new b0(l, i2, f3, obj5);
        return b0Var;
    }

    public static net.time4j.b0 p0(long l, f f2) {
        return b0.o0(l, f2, 0);
    }

    static net.time4j.b0 r0(DataInput dataInput, boolean z2, boolean z3) {
        long l;
        int i;
        String str;
        int obj6;
        int obj7;
        int obj8;
        long long = dataInput.readLong();
        if (z3) {
            obj6 = dataInput.readInt();
        } else {
            obj6 = 0;
        }
        if (Long.compare(long, i3) == 0) {
            if (z2 != 0) {
            } else {
                if (obj6 == null) {
                    return b0.B;
                }
            }
            obj6 = new InvalidObjectException("UTC epoch is no leap second.");
            throw obj6;
        }
        if (Long.compare(long, l2) == 0 && obj6 == null) {
            if (obj6 == null) {
                if (z2 != 0) {
                } else {
                    return b0.w;
                }
                obj6 = new InvalidObjectException("Minimum is no leap second.");
                throw obj6;
            }
        }
        if (Long.compare(long, l) == 0 && obj6 == 999999999) {
            if (obj6 == 999999999) {
                if (z2 != 0) {
                } else {
                    return b0.x;
                }
                obj6 = new InvalidObjectException("Maximum is no leap second.");
                throw obj6;
            }
        }
        b0.X(obj6);
        obj7 = d.w();
        if (z2 != 0 && obj7.A()) {
            obj7 = d.w();
            if (obj7.A()) {
                obj7 = obj7.B(l3 += i);
                if (obj7 != null) {
                } else {
                    obj6 = b.l(long);
                    obj8 = b.h(obj6);
                    int i2 = b.g(obj6);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Not registered as leap second event: ");
                    stringBuilder.append(b.i(obj6));
                    stringBuilder.append("-");
                    obj7 = "";
                    int i4 = 10;
                    str = obj8 < i4 ? obj6 : obj7;
                    stringBuilder.append(str);
                    stringBuilder.append(obj8);
                    if (i2 < i4) {
                    } else {
                        obj6 = obj7;
                    }
                }
                stringBuilder.append(obj6);
                stringBuilder.append(i2);
                stringBuilder.append(" [Please check leap second configurations ");
                stringBuilder.append("either of emitter vm or this target vm]");
                InvalidObjectException invalidObjectException = new InvalidObjectException(stringBuilder.toString());
                throw invalidObjectException;
            }
            obj6 |= obj7;
        }
        obj7 = new b0(obj6, long, obj1);
        return obj7;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private static int u0(double d, long l2) {
        return (int)i2;
    }

    private String v0(boolean z) {
        int i;
        int obj8;
        int i4 = b0.h0(this);
        int i7 = i4 / 60;
        i7 %= 60;
        i5 += i10;
        int i11 = a();
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append(e0());
        stringBuilder.append('T');
        int i3 = 2;
        b0.b0(i7 / 60, i3, stringBuilder);
        if (z == 0) {
            if (i9 |= i11 != 0) {
                i = 58;
                stringBuilder.append(i);
                b0.b0(i8, i3, stringBuilder);
                if (z == 0) {
                    stringBuilder.append(i);
                    b0.b0(i6, i3, stringBuilder);
                    if (i6 | i11 != 0 && i11 > 0) {
                        stringBuilder.append(i);
                        b0.b0(i6, i3, stringBuilder);
                        if (i11 > 0) {
                            stringBuilder.append(',');
                            b0.b0(i11, 9, stringBuilder);
                        }
                    }
                } else {
                }
            }
        } else {
        }
        stringBuilder.append('Z');
        return stringBuilder.toString();
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 4);
        return spx;
    }

    private net.time4j.b0 x0(f f) {
        int i;
        if (f == f.UTC) {
            return this;
        }
        if (m0()) {
        } else {
            int i2 = b0.a.a[f.ordinal()];
            if (i2 != 1 && i2 != 3 && i2 != 4 && i2 != 5) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                            } else {
                            }
                            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(f.name());
                            throw unsupportedOperationException;
                        }
                        b0 b0Var3 = new b0(c.m(this.a, obj2), obj2, a(), f);
                        return b0Var3;
                    }
                    b0 b0Var2 = new b0(c.m(this.a, obj2), obj2, a(), f);
                    return b0Var2;
                }
                b0 b0Var = new b0(c.m(this.a, obj2), obj2, a(), f);
                return b0Var;
            }
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Leap seconds do not exist on continuous time scale: ");
        stringBuilder.append(f);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private net.time4j.b0 y0(f f) {
        int i;
        switch (i3) {
            case 1:
                b0 obj7 = new b0(a(), this.a, obj2);
                return obj7;
                return this;
            case 2:
                return this;
            case 3:
                b0 b0Var2 = new b0(n(f), c.f(f(f), obj3), obj3);
                return b0Var2;
            case 4:
                obj7 = new b0(a(), c.f(f(f.GPS), obj2), obj2);
                return obj7;
            case 5:
                b0 b0Var = new b0(n(f), c.f(f(f), obj3), obj3);
                return b0Var;
            default:
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(f.name());
                throw unsupportedOperationException;
        }
    }

    @Override // net.time4j.engine.i0
    public int I(i0 i0) {
        return a0((b0)i0);
    }

    protected f0<TimeUnit, net.time4j.b0> J() {
        return b0.A;
    }

    @Override // net.time4j.engine.i0
    public int a() {
        return i &= i3;
    }

    @Override // net.time4j.engine.i0
    public int a0(net.time4j.b0 b0) {
        int i;
        int cmp = Long.compare(l, l2);
        if (cmp < 0) {
            return -1;
        }
        int i4 = 1;
        if (cmp > 0) {
            return i4;
        }
        i2 -= obj5;
        if (i3 > 0) {
            i = i4;
        } else {
            if (i3 < 0) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    @Override // net.time4j.engine.i0
    public int compareTo(Object object) {
        return a0((b0)object);
    }

    @Override // net.time4j.engine.i0
    protected net.time4j.b0 d0() {
        return this;
    }

    @Override // net.time4j.engine.i0
    public boolean equals(Object object) {
        int i;
        if (this == object) {
            return 1;
        }
        final int i4 = 0;
        if (object instanceof b0 && Long.compare(l, l2) != 0) {
            if (Long.compare(l, l2) != 0) {
                return i4;
            }
            if (d.w().A()) {
                if (this.b == object.b) {
                } else {
                    i = i4;
                }
                return i;
            }
            if (a() == (b0)(b0)object.a()) {
            } else {
                i = i4;
            }
            return i;
        }
        return i4;
    }

    @Override // net.time4j.engine.i0
    public long f(f f) {
        int l4;
        int i5;
        int i2;
        int z;
        int i;
        int i6;
        int i4;
        long l5;
        long l;
        long l2;
        int i7;
        long l3;
        int i3;
        final Object obj = this;
        int i20 = 184000000;
        long l12 = 4607182418800017408L;
        int i25 = 1;
        i4 = 63072000;
        l = 4741671816366391296L;
        switch (i9) {
            case 1:
                return obj.a;
            case 2:
                return f0();
            case 3:
                i27 += i3;
                l3 = (long)floor3;
                l3 += i25;
                i2 = 0;
                i2 = b0.u0(i4, obj8);
                i7 -= i25;
                i7 = i5 + i;
                return i7;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("TAI not supported before 1958-01-01: ");
                stringBuilder2.append(obj);
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
                throw illegalArgumentException2;
            case 4:
                l4 = f0();
                l4 += z;
                return l4 -= i22;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("GPS not supported before 1980-01-06: ");
                stringBuilder.append(obj);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            case 5:
                i14 += i29;
                l5 = (long)floor2;
                l5 += i25;
                return l5;
                i6 += i25;
                return i6;
            case 6:
                long l9 = obj.a;
                return l9 -= i4;
                return (long)floor;
            default:
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Not yet implemented: ");
                stringBuilder3.append(f);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder3.toString());
                throw unsupportedOperationException;
        }
    }

    @Override // net.time4j.engine.i0
    public int hashCode() {
        long l = this.a;
        return i3 += i6;
    }

    @Override // net.time4j.engine.i0
    public net.time4j.b1 j0(k k) {
        return b1.d(this, l.N(k));
    }

    @Override // net.time4j.engine.i0
    public boolean k0(g g) {
        int obj1;
        obj1 = a0(b0.c0(g)) > 0 ? 1 : 0;
        return obj1;
    }

    @Override // net.time4j.engine.i0
    public boolean l0(g g) {
        int obj1;
        obj1 = a0(b0.c0(g)) < 0 ? 1 : 0;
        return obj1;
    }

    @Override // net.time4j.engine.i0
    public boolean m0() {
        boolean z;
        int i;
        if (n0() && d.w().A()) {
            i = d.w().A() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // net.time4j.engine.i0
    public int n(f f) {
        long l3;
        int compare;
        int i10;
        int i5;
        int i9;
        int i;
        long i2;
        int i3;
        long l;
        int l2;
        int i6;
        int i4;
        int i7;
        int i8;
        final Object obj = this;
        int ordinal = f.ordinal();
        final long l8 = 4607182418800017408L;
        i2 = 1000000000;
        i3 = 63072000;
        l = 4741671816366391296L;
        switch (i13) {
            case 1:
                return a();
            case 2:
                int i27 = 441763200;
                i25 += i8;
                i4 = (long)floor3;
                i = 1;
                i4 += i;
                i5 = 0;
                i5 = b0.u0(i26, obj8);
                i5 -= l3;
                i6 -= i;
                i10 += i2;
                i6 = l3 + i27;
                i10 = a();
                return i10;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("TAI not supported before 1958-01-01: ");
                stringBuilder3.append(obj);
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder3.toString());
                throw illegalArgumentException2;
            case 3:
                return a();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("GPS not supported before 1980-01-06: ");
                stringBuilder2.append(obj);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
                throw illegalArgumentException;
            case 4:
                i28 += i24;
                i2 = (long)floor2;
                i9 = 0;
                i9 = b0.u0(l2, obj12);
                i9 = compare + i;
                i9 -= i2;
                return i9;
            case 5:
                return a();
                double d = g0();
                return b0.u0(d, ordinal);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Not yet implemented: ");
                stringBuilder.append(f);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
                throw unsupportedOperationException;
        }
    }

    @Override // net.time4j.engine.i0
    public net.time4j.b0 q0(long l, net.time4j.n0 n02) {
        int pOSIX;
        long uTC;
        long obj5;
        net.time4j.b0 obj7;
        b0.W(this);
        int cmp = Long.compare(l, i);
        if (cmp == 0) {
            return this;
        }
        obj7 = b0.a.b[obj7.ordinal()];
        if (obj7 != 1) {
            if (obj7 != 2) {
            } else {
                obj5 = c.f((long)obj7, obj2);
                obj7 = 1000000000;
                pOSIX = c.d(obj5, n02);
                obj5 = c.b(obj5, n02);
                if (d.w().A()) {
                    obj7 = new b0(c.f(f0(), obj3), n02, pOSIX, f.UTC);
                } else {
                    obj7 = b0.o0(c.f(this.a, obj3), n02, pOSIX);
                }
                if (cmp < 0) {
                    b0.W(obj7);
                }
                return obj7;
            }
            obj5 = new UnsupportedOperationException();
            throw obj5;
        }
        if (d.w().A()) {
            obj7 = new b0(c.f(f0(), obj2), n02, a(), f.UTC);
        } else {
            try {
                obj7 = b0.o0(c.f(this.a, obj2), n02, a());
                if (cmp < 0) {
                }
                b0.W(obj7);
                return obj7;
                obj7 = "Result beyond boundaries of time axis.";
                n02 = new ArithmeticException(obj7);
                n02.initCause(l);
                throw n02;
            }
        }
    }

    public <C extends net.time4j.engine.l<C>> net.time4j.s<C> s0(j<C> j, String string2, k k3, d0 d04) {
        final net.time4j.i0 i0Var = w0(k3);
        return s.b((i0)i0Var.L((long)obj6, d04).X().V(j.l(), string2), i0Var.Z());
    }

    public <C extends m<?, C>> net.time4j.s<C> t0(w<C> w, k k2, d0 d03) {
        final net.time4j.i0 i0Var = w0(k2);
        return s.c((i0)i0Var.L((long)obj5, d03).X().W(w.l()), i0Var.Z());
    }

    @Override // net.time4j.engine.i0
    public String toString() {
        return v0(true);
    }

    @Override // net.time4j.engine.i0
    public net.time4j.i0 w0(k k) {
        return i0(l.N(k));
    }

    @Override // net.time4j.engine.i0
    public long x() {
        return this.a;
    }

    @Override // net.time4j.engine.i0
    protected w y() {
        return J();
    }

    @Override // net.time4j.engine.i0
    protected q z() {
        d0();
        return this;
    }

    @Override // net.time4j.engine.i0
    void z0(DataOutput dataOutput) {
        int i;
        i = n0() ? 65 : 64;
        final int i2 = a();
        if (i2 > 0) {
            i |= 2;
        }
        dataOutput.writeByte(i);
        dataOutput.writeLong(this.a);
        if (i2 > 0) {
            dataOutput.writeInt(i2);
        }
    }
}
