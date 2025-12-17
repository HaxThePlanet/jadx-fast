package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import net.time4j.engine.ChronoException;
import net.time4j.engine.a0;
import net.time4j.engine.c0;
import net.time4j.engine.d;
import net.time4j.engine.d0;
import net.time4j.engine.f0;
import net.time4j.engine.f0.b;
import net.time4j.engine.i0;
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
import net.time4j.f1.a;
import net.time4j.f1.c;
import net.time4j.f1.f;
import net.time4j.f1.g;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.c;
import net.time4j.g1.e;
import net.time4j.g1.h;
import net.time4j.i1.f;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.o;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
@c("iso8601")
public final class i0 extends i0<net.time4j.x, net.time4j.i0> implements a, g, c0, h {

    private static final net.time4j.i0 c = null;
    private static final long serialVersionUID = 7458380065762437714L;
    private static final net.time4j.i0 v;
    private static final Map<Object, p<?>> w;
    private static final f0<net.time4j.x, net.time4j.i0> x;
    private final transient net.time4j.g0 a;
    private final transient net.time4j.h0 b;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            i0.a.a = iArr;
            iArr[h.HOURS.ordinal()] = 1;
            i0.a.a[h.MINUTES.ordinal()] = 2;
            i0.a.a[h.SECONDS.ordinal()] = 3;
            i0.a.a[h.MILLIS.ordinal()] = 4;
            i0.a.a[h.MICROS.ordinal()] = 5;
            i0.a.a[h.NANOS.ordinal()] = 6;
        }
    }

    private static class b implements k0<net.time4j.i0> {

        private final net.time4j.f a;
        private final net.time4j.h b;
        b(net.time4j.f f) {
            super();
            this.a = f;
            this.b = 0;
        }

        b(net.time4j.h h) {
            super();
            this.a = 0;
            this.b = h;
        }

        @Override // net.time4j.engine.k0
        public long a(Object object, Object object2) {
            return d((i0)object, (i0)object2);
        }

        @Override // net.time4j.engine.k0
        public Object b(Object object, long l2) {
            return c((i0)object, l2);
        }

        @Override // net.time4j.engine.k0
        public net.time4j.i0 c(net.time4j.i0 i0, long l2) {
            net.time4j.g0 g0Var;
            Enum obj;
            net.time4j.h0 h0Var;
            net.time4j.h0 obj4;
            i0 obj5;
            Object obj6;
            if (this.a != null) {
                obj5 = i0.O(i0).M(l2, obj6);
                obj4 = i0.P(i0);
            } else {
                obj = this.b;
                obj5 = i0.P(i0).R0(l2, obj6);
                obj5 = obj4;
                obj4 = h0Var;
            }
            return i0.d0(obj5, obj4);
        }

        @Override // net.time4j.engine.k0
        public long d(net.time4j.i0 i0, net.time4j.i0 i02) {
            long cmp;
            net.time4j.f sECONDS;
            Object dAYS;
            long longValue2;
            long between;
            net.time4j.f longValue;
            int i;
            long longValue3;
            long obj11;
            Object obj12;
            net.time4j.f fVar = this.a;
            sECONDS = 0;
            longValue2 = 1;
            if (fVar != null) {
                longValue = i0.O(i02);
                between = fVar.between(i0.O(i0), longValue);
                cmp = Long.compare(between, sECONDS);
                if (cmp != 0) {
                    i = 1;
                    if (this.a == f.DAYS) {
                    } else {
                        if ((g0)i0.O(i0).M(between, longValue).O(i0.O(i02)) == 0) {
                        } else {
                            i = sECONDS;
                        }
                    }
                    if (i != 0) {
                        obj11 = i0.P(i0);
                        obj12 = i0.P(i02);
                        if (cmp > 0 && obj11.z0(obj12)) {
                            if (obj11.z0(obj12)) {
                                between -= longValue2;
                            } else {
                                if (cmp < 0 && obj11.A0(obj12)) {
                                    if (obj11.A0(obj12)) {
                                        between += longValue2;
                                    }
                                }
                            }
                        } else {
                        }
                    }
                }
                return between;
            } else {
                if (i0.O(i0).R(i0.O(i02))) {
                    between = -obj11;
                } else {
                    longValue = f.DAYS;
                    long l3 = i0.O(i0).N(i0.O(i02), longValue);
                    if (Long.compare(l3, sECONDS) == 0) {
                        return this.b.between(i0.P(i0), i0.P(i02));
                    }
                    sECONDS = h.SECONDS;
                    if (this.b.compareTo(sECONDS) <= 0) {
                        net.time4j.l0 l0Var = h0.R;
                        longValue = (Integer)i0.P(i02).p(l0Var).longValue();
                        if (i0.P(i0).a() > i0.P(i02).a()) {
                            cmp -= longValue2;
                        }
                        between = cmp;
                    } else {
                        dAYS = h0.X;
                        obj12 = i0.P(i02).p(dAYS);
                        between = obj11;
                    }
                    switch (obj11) {
                        case 1:
                            between /= obj11;
                            return between;
                        case 2:
                            between /= obj11;
                            return between;
                        case 3:
                            return between;
                        case 4:
                            between /= obj11;
                            return between;
                        case 5:
                            between /= obj11;
                            return between;
                        default:
                            obj11 = new UnsupportedOperationException(this.b.name());
                            throw obj11;
                    }
                }
            }
        }
    }

    private static class d implements y<net.time4j.i0, V> {

        private final p<V> a;
        private d(p<V> p) {
            super();
            this.a = p;
        }

        d(p p, net.time4j.i0.a i0$a2) {
            super(p);
        }

        static p b(net.time4j.i0.d i0$d) {
            return d.a;
        }

        static <V> net.time4j.i0.d<V> j(p<V> p) {
            i0.d dVar = new i0.d(p);
            return dVar;
        }

        private long k(V v) {
            return (Number)Number.class.cast(v).longValue();
        }

        public p<?> d(net.time4j.i0 i0) {
            return (p)i0.R().get(this.a);
        }

        public p<?> e(net.time4j.i0 i0) {
            return (p)i0.R().get(this.a);
        }

        public V f(net.time4j.i0 i0) {
            if (this.a.isDateElement()) {
                return i0.O(i0).r(this.a);
            }
            if (!this.a.isTimeElement()) {
            } else {
                return this.a.getDefaultMaximum();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing rule for: ");
            stringBuilder.append(this.a.name());
            ChronoException obj3 = new ChronoException(stringBuilder.toString());
            throw obj3;
        }

        public V g(net.time4j.i0 i0) {
            if (this.a.isDateElement()) {
                return i0.O(i0).w(this.a);
            }
            if (!this.a.isTimeElement()) {
            } else {
                return this.a.getDefaultMinimum();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing rule for: ");
            stringBuilder.append(this.a.name());
            ChronoException obj3 = new ChronoException(stringBuilder.toString());
            throw obj3;
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return d((i0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return e((i0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return f((i0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return g((i0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return h((i0)object);
        }

        public V h(net.time4j.i0 i0) {
            if (this.a.isDateElement()) {
                return i0.O(i0).p(this.a);
            }
            if (!this.a.isTimeElement()) {
            } else {
                return i0.P(i0).p(this.a);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing rule for: ");
            stringBuilder.append(this.a.name());
            ChronoException obj3 = new ChronoException(stringBuilder.toString());
            throw obj3;
        }

        public boolean i(net.time4j.i0 i0, V v2) {
            int i;
            boolean equals;
            long obj6;
            i = 0;
            if (v2 == null) {
                return i;
            }
            if (this.a.isDateElement()) {
                return i0.O(i0).D(this.a, v2);
            }
            if (!this.a.isTimeElement()) {
            } else {
                obj6 = k(v2);
                if (Number.class.isAssignableFrom(this.a.getType()) && Long.compare(l, obj6) <= 0 && Long.compare(l2, obj6) >= 0) {
                    obj6 = k(v2);
                    if (Long.compare(l, obj6) <= 0) {
                        if (Long.compare(l2, obj6) >= 0) {
                            i = 1;
                        }
                    }
                    return i;
                }
                if (this.a.equals(h0.G) && h0.F.equals(v2)) {
                    if (h0.F.equals(v2)) {
                        return i;
                    }
                }
                return i0.P(i0).D(this.a, v2);
            }
            StringBuilder obj7 = new StringBuilder();
            obj7.append("Missing rule for: ");
            obj7.append(this.a.name());
            obj6 = new ChronoException(obj7.toString());
            throw obj6;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return i((i0)object, object2);
        }

        public net.time4j.i0 l(net.time4j.i0 i0, V v2, boolean z3) {
            long l;
            long l3;
            long l2;
            int obj10;
            if (v2 == null) {
            } else {
                if (v2.equals(h(i0))) {
                    return i0;
                }
                if (z3) {
                    return (i0)i0.M(c.m(k(v2), obj3), obj1);
                }
                if (this.a.isDateElement()) {
                    return i0.d0((g0)i0.O(i0).G(this.a, v2), i0.P(i0));
                }
                if (!this.a.isTimeElement()) {
                } else {
                    String str = "Out of range: ";
                    if (Number.class.isAssignableFrom(this.a.getType())) {
                        l2 = k(v2);
                        if (Long.compare(l, l2) > 0) {
                        } else {
                            if (Long.compare(l3, l2) < 0) {
                            } else {
                                return i0.d0(i0.O(i0), (h0)i0.P(i0).G(this.a, v2));
                            }
                        }
                        obj10 = new StringBuilder();
                        obj10.append(str);
                        obj10.append(v2);
                        IllegalArgumentException obj8 = new IllegalArgumentException(obj10.toString());
                        throw obj8;
                    }
                    if (this.a.equals(h0.G)) {
                        if (v2.equals(h0.F)) {
                        } else {
                        }
                        obj10 = new StringBuilder();
                        obj10.append(str);
                        obj10.append(v2);
                        obj8 = new IllegalArgumentException(obj10.toString());
                        throw obj8;
                    }
                }
                StringBuilder obj9 = new StringBuilder();
                obj9.append("Missing rule for: ");
                obj9.append(this.a.name());
                obj8 = new ChronoException(obj9.toString());
                throw obj8;
            }
            obj8 = new IllegalArgumentException("Missing element value.");
            throw obj8;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return l((i0)object, object2, z3);
        }
    }

    private static class e implements t<net.time4j.i0> {
        e(net.time4j.i0.a i0$a) {
            super();
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
            return g0.t0().d();
        }

        @Override // net.time4j.engine.t
        public o e(Object object, d d2) {
            h((i0)object, d2);
            return object;
        }

        @Override // net.time4j.engine.t
        public String f(x x, Locale locale2) {
            e obj1 = e.ofStyle(x.getStyleValue());
            return b.u(obj1, obj1, locale2);
        }

        public net.time4j.i0 g(q<?> q, d d2, boolean z3, boolean z4) {
            boolean z;
            int i2;
            Object i0Var;
            int i;
            int longValue;
            Object pVar;
            Object obj7;
            Object obj8;
            int obj9;
            if (q instanceof f) {
                obj9 = a.d;
                if (d2.c(obj9)) {
                    obj7 = d2.b(obj9);
                    return b0.c0((f)f.class.cast(q)).w0(obj7);
                } else {
                    if (!z3) {
                    } else {
                        obj7 = p.C;
                    }
                }
                IllegalArgumentException obj6 = new IllegalArgumentException("Missing timezone attribute for type conversion.");
                throw obj6;
            }
            int i3 = 0;
            if (z4 != 0 && q.e(h0.Q) == 60) {
                obj9 = q.e(h0.Q) == 60 ? 1 : i3;
            } else {
            }
            if (obj9 != null) {
                q.E(h0.Q, 59);
            }
            p pVar2 = g0.F;
            if (q.v(pVar2)) {
                i0Var = q.p(pVar2);
            } else {
                i0Var = g0.t0().D(q, d2, z3, i3);
            }
            longValue = 0;
            if (i0Var == null) {
                return longValue;
            }
            pVar = h0.G;
            if (q.v(pVar)) {
                obj7 = q.p(pVar);
            } else {
                if ((h0)h0.k0().D(q, d2, z3, i3) == null && z3) {
                    if (z3) {
                        obj7 = h0.E;
                    }
                }
            }
            if (obj7 == null) {
                return longValue;
            }
            obj8 = y.v;
            if (q.v(obj8)) {
                i0Var = obj8;
            }
            obj8 = a0.LEAP_SECOND;
            obj9 = Boolean.TRUE;
            if (obj9 != null && q.D(obj8, obj9)) {
                obj8 = a0.LEAP_SECOND;
                obj9 = Boolean.TRUE;
                if (q.D(obj8, obj9)) {
                    q.G(obj8, obj9);
                }
            }
            return i0.d0(i0Var, obj7);
        }

        @Override // net.time4j.engine.t
        public o h(net.time4j.i0 i0, d d2) {
            return i0;
        }
    }

    private static class c extends net.time4j.i0.d<BigDecimal> {
        c(p<BigDecimal> p) {
            super(p, 0);
        }

        @Override // net.time4j.i0$d
        public boolean i(net.time4j.i0 i0, Object object2) {
            return m(i0, (BigDecimal)object2);
        }

        @Override // net.time4j.i0$d
        public boolean isValid(Object object, Object object2) {
            return m((i0)object, (BigDecimal)object2);
        }

        @Override // net.time4j.i0$d
        public net.time4j.i0 l(net.time4j.i0 i0, Object object2, boolean z3) {
            return n(i0, (BigDecimal)object2, z3);
        }

        @Override // net.time4j.i0$d
        public boolean m(net.time4j.i0 i0, BigDecimal bigDecimal2) {
            int obj3;
            BigDecimal obj4;
            if (bigDecimal2 == null) {
                return 0;
            }
            if ((BigDecimal)i0.d.b(this).getDefaultMinimum().compareTo(bigDecimal2) <= 0 && bigDecimal2.compareTo((BigDecimal)i0.d.b(this).getDefaultMaximum()) <= 0) {
                if (bigDecimal2.compareTo(defaultMaximum) <= 0) {
                    obj3 = 1;
                }
            }
            return obj3;
        }

        @Override // net.time4j.i0$d
        public net.time4j.i0 n(net.time4j.i0 i0, BigDecimal bigDecimal2, boolean z3) {
            if (!m(i0, bigDecimal2)) {
            } else {
                return i0.d0(i0.O(i0), (h0)i0.P(i0).G(i0.d.b(this), bigDecimal2));
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Out of range: ");
            obj4.append(bigDecimal2);
            IllegalArgumentException obj2 = new IllegalArgumentException(obj4.toString());
            throw obj2;
        }

        @Override // net.time4j.i0$d
        public Object withValue(Object object, Object object2, boolean z3) {
            return n((i0)object, (BigDecimal)object2, z3);
        }
    }
    static {
        i0 i0Var = new i0(g0.v, h0.E);
        i0.c = i0Var;
        p pVar2 = h0.G;
        i0 i0Var2 = new i0(g0.w, (h0)pVar2.getDefaultMaximum());
        i0.v = i0Var2;
        HashMap hashMap = new HashMap();
        p pVar3 = g0.F;
        hashMap.put(pVar3, pVar2);
        net.time4j.c cVar = g0.H;
        net.time4j.l0 l0Var11 = g0.L;
        hashMap.put(cVar, l0Var11);
        net.time4j.c cVar4 = g0.I;
        hashMap.put(cVar4, z0.D.n());
        net.time4j.d0 d0Var = g0.J;
        net.time4j.l0 l0Var19 = g0.P;
        hashMap.put(d0Var, l0Var19);
        net.time4j.d0 d0Var2 = g0.K;
        net.time4j.l0 l0Var20 = g0.M;
        hashMap.put(d0Var2, l0Var20);
        hashMap.put(l0Var11, l0Var20);
        hashMap.put(l0Var20, pVar2);
        final net.time4j.d0 d0Var3 = g0.N;
        hashMap.put(d0Var3, pVar2);
        final net.time4j.l0 l0Var22 = g0.O;
        hashMap.put(l0Var22, pVar2);
        hashMap.put(l0Var19, pVar2);
        net.time4j.e0 e0Var2 = g0.Q;
        hashMap.put(e0Var2, pVar2);
        net.time4j.c1 c1Var5 = h0.I;
        final p pVar5 = pVar2;
        net.time4j.l0 l0Var6 = h0.L;
        hashMap.put(c1Var5, l0Var6);
        final net.time4j.c1 c1Var6 = c1Var5;
        net.time4j.c cVar9 = h0.J;
        final net.time4j.e0 e0Var3 = e0Var2;
        net.time4j.l0 l0Var23 = h0.O;
        hashMap.put(cVar9, l0Var23);
        final net.time4j.c cVar11 = cVar9;
        net.time4j.c cVar10 = h0.K;
        hashMap.put(cVar10, l0Var23);
        hashMap.put(l0Var6, l0Var23);
        final net.time4j.l0 l0Var26 = l0Var6;
        net.time4j.l0 l0Var7 = h0.M;
        hashMap.put(l0Var7, l0Var23);
        final net.time4j.l0 l0Var27 = l0Var7;
        net.time4j.l0 l0Var8 = h0.N;
        hashMap.put(l0Var8, l0Var23);
        final net.time4j.l0 l0Var28 = l0Var8;
        net.time4j.l0 l0Var9 = h0.Q;
        hashMap.put(l0Var23, l0Var9);
        final net.time4j.l0 l0Var29 = l0Var23;
        net.time4j.l0 l0Var24 = h0.P;
        hashMap.put(l0Var24, l0Var9);
        final net.time4j.l0 l0Var30 = l0Var24;
        net.time4j.l0 l0Var25 = h0.U;
        hashMap.put(l0Var9, l0Var25);
        final net.time4j.l0 l0Var31 = l0Var9;
        net.time4j.l0 l0Var10 = h0.R;
        hashMap.put(l0Var10, l0Var25);
        i0.w = Collections.unmodifiableMap(hashMap);
        final net.time4j.l0 l0Var32 = l0Var25;
        final net.time4j.l0 l0Var33 = l0Var10;
        final net.time4j.c cVar12 = cVar10;
        i0.e eVar = new i0.e(0);
        f0.b bVar = f0.b.k(x.class, i0.class, eVar, i0Var, i0Var2);
        net.time4j.f dAYS = f.DAYS;
        bVar.e(pVar3, i0.d.j(pVar3), dAYS);
        net.time4j.f yEARS = f.YEARS;
        bVar.e(cVar, i0.d.j(cVar), yEARS);
        bVar.e(cVar4, i0.d.j(cVar4), w0.a);
        bVar.e(d0Var, i0.d.j(d0Var), f.QUARTERS);
        net.time4j.f mONTHS = f.MONTHS;
        bVar.e(d0Var2, i0.d.j(d0Var2), mONTHS);
        bVar.e(l0Var11, i0.d.j(l0Var11), mONTHS);
        bVar.e(l0Var20, i0.d.j(l0Var20), dAYS);
        bVar.e(d0Var3, i0.d.j(d0Var3), dAYS);
        bVar.e(l0Var22, i0.d.j(l0Var22), dAYS);
        bVar.e(l0Var19, i0.d.j(l0Var19), dAYS);
        bVar.e(e0Var3, i0.d.j(e0Var3), f.WEEKS);
        bVar.d(pVar5, i0.d.j(pVar5));
        bVar.d(c1Var6, i0.d.j(c1Var6));
        net.time4j.h hOURS = h.HOURS;
        bVar.e(cVar11, i0.d.j(cVar11), hOURS);
        bVar.e(cVar12, i0.d.j(cVar12), hOURS);
        bVar.e(l0Var26, i0.d.j(l0Var26), hOURS);
        bVar.e(l0Var27, i0.d.j(l0Var27), hOURS);
        bVar.e(l0Var28, i0.d.j(l0Var28), hOURS);
        net.time4j.h mINUTES = h.MINUTES;
        bVar.e(l0Var29, i0.d.j(l0Var29), mINUTES);
        bVar.e(l0Var30, i0.d.j(l0Var30), mINUTES);
        net.time4j.h sECONDS = h.SECONDS;
        bVar.e(l0Var31, i0.d.j(l0Var31), sECONDS);
        bVar.e(l0Var33, i0.d.j(l0Var33), sECONDS);
        net.time4j.l0 l0Var = h0.S;
        net.time4j.h mILLIS = h.MILLIS;
        bVar.e(l0Var, i0.d.j(l0Var), mILLIS);
        net.time4j.l0 l0Var2 = h0.T;
        net.time4j.h mICROS = h.MICROS;
        bVar.e(l0Var2, i0.d.j(l0Var2), mICROS);
        net.time4j.h nANOS = h.NANOS;
        bVar.e(l0Var32, i0.d.j(l0Var32), nANOS);
        net.time4j.l0 l0Var3 = h0.V;
        bVar.e(l0Var3, i0.d.j(l0Var3), mILLIS);
        net.time4j.l0 l0Var4 = h0.W;
        bVar.e(l0Var4, i0.d.j(l0Var4), mICROS);
        net.time4j.l0 l0Var5 = h0.X;
        bVar.e(l0Var5, i0.d.j(l0Var5), nANOS);
        net.time4j.c1 c1Var = h0.Y;
        i0.c cVar6 = new i0.c(c1Var);
        bVar.d(c1Var, cVar6);
        net.time4j.c1 c1Var2 = h0.Z;
        i0.c cVar7 = new i0.c(c1Var2);
        bVar.d(c1Var2, cVar7);
        net.time4j.c1 c1Var3 = h0.a0;
        i0.c cVar8 = new i0.c(c1Var3);
        bVar.d(c1Var3, cVar8);
        p pVar = h0.b0;
        bVar.d(pVar, i0.d.j(pVar));
        i0.e0(bVar);
        i0.f0(bVar);
        i0.g0(bVar);
        i0.x = bVar.h();
        net.time4j.x[] arr = new x[7];
        o.g(yEARS, mONTHS, dAYS, hOURS, mINUTES, sECONDS, nANOS);
    }

    private i0(net.time4j.g0 g0, net.time4j.h0 h02) {
        int str;
        Object obj3;
        Object obj4;
        super();
        final int i2 = 24;
        if (h02.s() == i2) {
            this.a = (g0)g0.M(1, i2);
            this.b = h0.E;
        } else {
            Objects.requireNonNull(g0, "Missing date.");
            this.a = g0;
            this.b = h02;
        }
    }

    static net.time4j.g0 O(net.time4j.i0 i0) {
        return i0.a;
    }

    static net.time4j.h0 P(net.time4j.i0 i0) {
        return i0.b;
    }

    static f0 Q() {
        return i0.x;
    }

    static Map R() {
        return i0.w;
    }

    public static f0<net.time4j.x, net.time4j.i0> U() {
        return i0.x;
    }

    static net.time4j.i0 W(f f, p p2) {
        int i;
        int obj5;
        l += l2;
        obj5 += obj6;
        int i5 = 1;
        int obj6 = 1000000000;
        if (obj5 < 0) {
            obj5 += obj6;
            i -= i5;
        } else {
            if (obj5 >= obj6) {
                obj5 -= obj6;
                i += i5;
            }
        }
        obj6 = 86400;
        obj6 = c.d(i, obj1);
        obj6 /= 60;
        return i0.d0(g0.P0(c.b(i, obj1), obj3), h0.L0(obj6 /= 60, obj6 % 60, obj6 % 60, obj5));
    }

    public static net.time4j.i0 c0(int i, int i2, int i3, int i4, int i5, int i6) {
        return i0.d0(g0.K0(i, i2, i3), h0.K0(i4, i5, i6));
    }

    public static net.time4j.i0 d0(net.time4j.g0 g0, net.time4j.h0 h02) {
        i0 i0Var = new i0(g0, h02);
        return i0Var;
    }

    private static void e0(f0.b<net.time4j.x, net.time4j.i0> f0$b) {
        int i;
        Object obj;
        net.time4j.f fVar;
        net.time4j.i0.b bVar;
        double length;
        EnumSet set;
        net.time4j.f[] values = f.values();
        i = 0;
        while (i < values.length) {
            fVar = values[i];
            bVar = new i0.b(fVar);
            if (fVar.compareTo(f.WEEKS) < 0) {
            } else {
            }
            set = range2;
            b.g(fVar, bVar, fVar.getLength(), obj9);
            i++;
            set = range;
        }
    }

    private static void f0(f0.b<net.time4j.x, net.time4j.i0> f0$b) {
        int i;
        Object obj;
        net.time4j.h hVar;
        net.time4j.i0.b bVar;
        double length;
        EnumSet allOf;
        final net.time4j.h[] values = h.values();
        i = 0;
        while (i < values.length) {
            hVar = values[i];
            bVar = new i0.b(hVar);
            b.g(hVar, bVar, hVar.getLength(), obj7);
            i++;
        }
    }

    private static void g0(f0.b<net.time4j.x, net.time4j.i0> f0$b) {
        Object next2;
        boolean next;
        Iterator iterator = g0.t0().o().iterator();
        for (r next2 : iterator) {
            b.f(next2);
        }
        Iterator iterator2 = h0.k0().o().iterator();
        for (r next : iterator2) {
            b.f(next);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 8);
        return spx;
    }

    @Override // net.time4j.engine.i0
    public int I(i0 i0) {
        return V((i0)i0);
    }

    protected f0<net.time4j.x, net.time4j.i0> J() {
        return i0.x;
    }

    @Override // net.time4j.engine.i0
    public net.time4j.b0 S(p p) {
        int i;
        int i2;
        i6 -= l6;
        i14 -= obj6;
        int i16 = 1;
        int obj6 = 1000000000;
        if (i2 < 0) {
            i2 += obj6;
            i -= i16;
        } else {
            if (i2 >= obj6) {
                i2 -= obj6;
                i += i16;
            }
        }
        return b0.o0(i, obj1, i2);
    }

    @Override // net.time4j.engine.i0
    public net.time4j.b0 T() {
        return S(p.C);
    }

    @Override // net.time4j.engine.i0
    public int V(net.time4j.i0 i0) {
        if (this.a.R(i0.a)) {
            return 1;
        }
        if (this.a.S(i0.a)) {
            return -1;
        }
        return this.b.p0(i0.b);
    }

    @Override // net.time4j.engine.i0
    public net.time4j.g0 X() {
        return this.a;
    }

    @Override // net.time4j.engine.i0
    protected net.time4j.i0 Y() {
        return this;
    }

    @Override // net.time4j.engine.i0
    public net.time4j.h0 Z() {
        return this.b;
    }

    @Override // net.time4j.engine.i0
    public int a() {
        return this.b.a();
    }

    @Override // net.time4j.engine.i0
    public net.time4j.b0 a0(l l) {
        if (l.J()) {
            return S(l.A(this.a, this.b));
        }
        o oVar = l.E();
        final net.time4j.h0 h0Var2 = this.b;
        long l2 = oVar.b(this.a, h0Var2, l);
        if (oVar == l.v) {
            b0.Y(l2, h0Var2);
        }
        return b0.o0(l2, h0Var2, this.b.a());
    }

    @Override // net.time4j.engine.i0
    public net.time4j.b0 b0(k k) {
        return a0(l.N(k));
    }

    @Override // net.time4j.engine.i0
    public int compareTo(Object object) {
        return V((i0)object);
    }

    @Override // net.time4j.engine.i0
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof i0) {
            if (this.a.equals(object.a) && this.b.equals(object.b)) {
                if (this.b.equals(object.b)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.engine.i0
    public net.time4j.g0 h0() {
        return this.a;
    }

    @Override // net.time4j.engine.i0
    public int hashCode() {
        return i2 += i5;
    }

    @Override // net.time4j.engine.i0
    public int i() {
        return this.b.i();
    }

    @Override // net.time4j.engine.i0
    public int m() {
        return this.a.m();
    }

    @Override // net.time4j.engine.i0
    public int o() {
        return this.a.o();
    }

    @Override // net.time4j.engine.i0
    public int q() {
        return this.a.q();
    }

    @Override // net.time4j.engine.i0
    public int s() {
        return this.b.s();
    }

    @Override // net.time4j.engine.i0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.toString());
        stringBuilder.append(this.b.toString());
        return stringBuilder.toString();
    }

    @Override // net.time4j.engine.i0
    public int u() {
        return this.b.u();
    }

    @Override // net.time4j.engine.i0
    protected w y() {
        return J();
    }

    @Override // net.time4j.engine.i0
    protected q z() {
        Y();
        return this;
    }
}
