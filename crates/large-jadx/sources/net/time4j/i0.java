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
import net.time4j.engine.q;
import net.time4j.engine.t;
import net.time4j.engine.w;
import net.time4j.engine.x;
import net.time4j.engine.y;
import net.time4j.engine.z;
import net.time4j.f1.g;
import net.time4j.g1.b;
import net.time4j.g1.e;
import net.time4j.g1.h;
import net.time4j.tz.k;
import net.time4j.tz.l;

/* compiled from: PlainTimestamp.java */
@c("iso8601")
/* loaded from: classes3.dex */
public final class i0 extends i0<x, i0> implements net.time4j.f1.a, g, c0, h {

    private static final i0 c = null;
    private static final long serialVersionUID = 7458380065762437714L;
    private static final i0 v = new i0();
    private static final Map<Object, net.time4j.engine.p<?>> w;
    private static final f0<x, i0> x;
    private final transient g0 a;
    private final transient h0 b;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[h.values().length];
            i0.a.a = iArr;
            try {
                iArr[h.HOURS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                i0.a.a[h.MINUTES.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                i0.a.a[h.SECONDS.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                i0.a.a[h.MILLIS.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                i0.a.a[h.MICROS.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                i0.a.a[h.NANOS.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static class b implements k0<i0> {

        private final f a;
        private final h b;
        b(f fVar) {
            super();
            this.a = fVar;
            this.b = h.HOURS;
        }

        public i0 c(i0 i0Var, long j) {
            net.time4j.h0 j22;
            net.time4j.g0 g0Var3;
            if (this.a != null) {
                i0 i0Var4 = i0Var.a.M(j, this.a);
                j22 = i0Var.b;
            } else {
                net.time4j.k kVar = i0Var.b.R0(j, this.b);
            }
            return i0.d0(g0Var3, j22);
        }

        public long d(i0 i0Var, i0 i0Var2) {
            long i0Var3;
            net.time4j.f fVar = null;
            net.time4j.l0 l0Var;
            net.time4j.f dAYS2;
            long value = 1;
            int i2;
            net.time4j.f dAYS22;
            int i = 1;
            long value2;
            long l = 0L;
            value = 1L;
            if (this.a != null) {
                net.time4j.g0 g0Var8 = i0Var2.a;
                long between = this.a.between(i0Var.a, g0Var8);
                if (between != l) {
                    i = 1;
                    if (this.a != f.DAYS) {
                        if ((g0)i0Var.a.M(between, this.a).O(i0Var2.a) != 0) {
                        }
                    }
                    if (i != 0) {
                        net.time4j.h0 h0Var6 = i0Var.b;
                        net.time4j.h0 h0Var10 = i0Var2.b;
                        if (between <= l || !h0Var6.z0(h0Var10)) {
                            if (between < l && h0Var6.A0(h0Var10)) {
                                between += value;
                            }
                        } else {
                            between -= value;
                        }
                    }
                }
                return i2;
            } else {
                if (!i0Var.a.R(i0Var2.a)) {
                    dAYS22 = f.DAYS;
                    long l6 = i0Var.a.N(i0Var2.a, dAYS22);
                    if (l6 == l) {
                        return this.b.between(i0Var.b, i0Var2.b);
                    }
                    net.time4j.h sECONDS2 = h.SECONDS;
                    if (this.b.compareTo(sECONDS2) <= 0) {
                        net.time4j.l0 l0Var2 = h0.R;
                        long value3 = (Integer)i0Var2.b.p(l0Var2).longValue();
                        if (i0Var.b.a() > i0Var2.b.a()) {
                            i0Var3 = (c.f(c.i(l6, 86400L), c.m(value3, (Integer)i0Var.b.p(l0Var2).longValue()))) - 1L;
                        }
                    } else {
                        l0Var = h0.X;
                        Object obj = i0Var2.b.p(l0Var);
                    }
                    switch (i0.a.a[this.b.ordinal()]) {
                        case 1: /* ordinal */
                            long l2 = 3600L;
                            i0Var3 /= l2;
                            return i2;
                        case 2: /* ordinal */
                            l2 = 60L;
                            i0Var3 /= l2;
                            return i2;
                        case 3: /* ordinal */
                            return i2;
                        case 4: /* ordinal */
                            l2 = 1000000L;
                            i0Var3 /= l2;
                            return i2;
                        case 5: /* ordinal */
                            l2 = 1000L;
                            i0Var3 /= l2;
                            return i2;
                        default:
                            throw new UnsupportedOperationException(this.b.name());
                    }
                } else {
                    i2 = -(d(i0Var2, i0Var));
                }
            }
        }

        b(h hVar) {
            super();
            this.a = f.MILLENNIA;
            this.b = hVar;
        }
    }

    private static class d<V> implements y<i0, V> {

        private final net.time4j.engine.p<V> a;
        /* synthetic */ d(net.time4j.engine.p pVar, i0.a aVar) {
            this(pVar);
        }

        static /* synthetic */ net.time4j.engine.p b(i0.d dVar) {
            return dVar.a;
        }

        static <V> i0.d<V> j(net.time4j.engine.p<V> pVar) {
            return new i0.d(pVar);
        }

        private long k(V v) {
            return (Number)Number.class.cast(v).longValue();
        }

        public net.time4j.engine.p<?> d(i0 i0Var) {
            return (p)i0.w.get(this.a);
        }

        public net.time4j.engine.p<?> e(i0 i0Var) {
            return (p)i0.w.get(this.a);
        }

        public V f(i0 i0Var) throws ChronoException {
            if (this.a.isDateElement()) {
                return i0Var.a.r(this.a);
            }
            if (!this.a.isTimeElement()) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Missing rule for: ";
                String name = this.a.name();
                r0 = str + name;
                throw new ChronoException(r0);
            } else {
                return this.a.getDefaultMaximum();
            }
        }

        public V g(i0 i0Var) throws ChronoException {
            if (this.a.isDateElement()) {
                return i0Var.a.w(this.a);
            }
            if (!this.a.isTimeElement()) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Missing rule for: ";
                String name = this.a.name();
                r0 = str + name;
                throw new ChronoException(r0);
            } else {
                return this.a.getDefaultMinimum();
            }
        }

        public V h(i0 i0Var) throws ChronoException {
            if (this.a.isDateElement()) {
                return i0Var.a.p(this.a);
            }
            if (!this.a.isTimeElement()) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Missing rule for: ";
                String name = this.a.name();
                r0 = str + name;
                throw new ChronoException(r0);
            } else {
                return i0Var.b.p(this.a);
            }
        }

        public boolean i(i0 i0Var, V v) throws ChronoException {
            boolean z = false;
            z = false;
            if (v == null) {
                return false;
            }
            if (this.a.isDateElement()) {
                return i0Var.a.D(this.a, v);
            }
            if (!this.a.isTimeElement()) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Missing rule for: ";
                String name = this.a.name();
                v = str + name;
                throw new ChronoException(v);
            } else {
                if (Number.class.isAssignableFrom(this.a.getType())) {
                    long l2 = k(this.a.getDefaultMinimum());
                    final long l3 = k(this.a.getDefaultMaximum());
                    long l = k(v);
                    if (l2 <= l) {
                        if (l3 >= l) {
                            int i = 1;
                        }
                    }
                    return z;
                }
                if (this.a.equals(h0.G)) {
                    if (h0.F.equals(v)) {
                        return false;
                    }
                }
                return i0Var.b.D(this.a, v);
            }
        }

        public i0 l(i0 i0Var, V v, boolean z) throws ChronoException {
            if (v == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else {
                if (v.equals(h(i0Var))) {
                    return i0Var;
                }
                if (z) {
                    return (i0)i0Var.M(c.m(k(v), k(h(i0Var))), (x)i0.x.F(this.a));
                }
                if (this.a.isDateElement()) {
                    return i0.d0((g0)i0Var.a.G(this.a, v), i0Var.b);
                }
                if (!this.a.isTimeElement()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str3 = "Missing rule for: ";
                    String name = this.a.name();
                    v = str3 + name;
                    throw new ChronoException(v);
                } else {
                    String str = "Out of range: ";
                    if (Number.class.isAssignableFrom(this.a.getType())) {
                        long l = k(this.a.getDefaultMinimum());
                        long l2 = k(this.a.getDefaultMaximum());
                        long l3 = k(v);
                        if (l > l3) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            v = str + v;
                            throw new IllegalArgumentException(v);
                        } else {
                            if (l2 >= l3) {
                                return i0.d0(i0Var.a, (h0)i0Var.b.G(this.a, v));
                            }
                        }
                    }
                    if (this.a.equals(h0.G)) {
                        if (v.equals(h0.F)) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            v = str + v;
                            throw new IllegalArgumentException(v);
                        }
                    }
                }
            }
        }

        private d(net.time4j.engine.p<V> pVar) {
            super();
            this.a = pVar;
        }
    }

    private static class e implements t<i0> {
        private e() {
            super();
        }

        public d0 a() {
            return d0.a;
        }

        public int d() {
            return g0.t0().d();
        }

        public String f(x xVar, Locale locale) {
            e style = e.ofStyle(xVar.getStyleValue());
            return b.u(style, style, locale);
        }

        public i0 g(q<?> qVar, d dVar, boolean z, boolean z2) {
            int i = 60;
            i0 i0Var;
            net.time4j.g0 g0Var;
            f0 f0Var;
            net.time4j.tz.p pVar;
            net.time4j.h0 h0Var;
            net.time4j.engine.p pVar2;
            int i5 = 1;
            if (qVar instanceof f) {
                net.time4j.engine.c cVar = a.d;
                if (dVar.c(cVar)) {
                    Object obj2 = dVar.b(a.d);
                    return b0.c0((f)f.class.cast(qVar)).w0(pVar);
                } else {
                    if (f.class) {
                        pVar = p.C;
                    }
                }
                throw new IllegalArgumentException("Missing timezone attribute for type conversion.");
            }
            boolean z6 = false;
            if (a.d) {
                i = 60;
                z2 = qVar.e(h0.Q) == 60 ? 1 : z6;
            }
            if (h0.Q != 0) {
                int i2 = 59;
                qVar.E(h0.Q, i2);
            }
            net.time4j.engine.p pVar3 = g0.F;
            if (qVar.v(pVar3)) {
                Object obj = qVar.p(g0.F);
            } else {
                i0Var = g0.t0().D(qVar, dVar, z, z6);
            }
            int i3 = 0;
            if (g0.F == null) {
                return null;
            }
            net.time4j.engine.p pVar4 = h0.G;
            if (qVar.v(pVar4)) {
                Object obj3 = qVar.p(h0.G);
            } else {
                if ((h0)h0.k0().D(qVar, dVar, z, z6) == null && f.class) {
                    h0Var = h0.E;
                }
            }
            if (h0Var == null) {
                return i3;
            }
            pVar2 = y.v;
            if (qVar.v(pVar2)) {
            }
            if (h0.Q != 0) {
                a0 lEAP_SECOND2 = a0.LEAP_SECOND;
                Boolean tRUE2 = Boolean.TRUE;
                if (qVar.D(lEAP_SECOND2, tRUE2)) {
                    qVar.G(a0.LEAP_SECOND, Boolean.TRUE);
                }
            }
            return i0.d0(g0Var, h0Var);
        }

        /* synthetic */ e(i0.a aVar) {
            this();
        }

        public w<?> b() {
            return null;
        }

        public net.time4j.engine.o h(i0 i0Var, d dVar) {
            return i0Var;
        }
    }

    private static class c extends i0.d<BigDecimal> {
        c(net.time4j.engine.p<BigDecimal> pVar) {
            super(pVar, null);
        }

        @Override // net.time4j.i0$d
        public boolean m(i0 i0Var, BigDecimal bigDecimal) {
            boolean z = false;
            z = false;
            if (bigDecimal == null) {
                return false;
            }
            if ((BigDecimal)this.a.getDefaultMinimum().compareTo(bigDecimal) <= 0 && bigDecimal.compareTo((BigDecimal)this.a.getDefaultMaximum()) <= 0) {
                int i = 1;
            }
            return z;
        }

        @Override // net.time4j.i0$d
        public i0 n(i0 i0Var, BigDecimal bigDecimal, boolean z) {
            if (!m(i0Var, bigDecimal)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Out of range: ";
                bigDecimal = str + bigDecimal;
                throw new IllegalArgumentException(bigDecimal);
            } else {
                return i0.d0(i0Var.a, (h0)i0Var.b.G(this.a, bigDecimal));
            }
        }
    }
    static {
        net.time4j.g0 g0Var = g0.v;
        net.time4j.i0 i0Var = new i0(g0Var, h0.E);
        i0.c = i0Var;
        net.time4j.engine.p pVar = h0.G;
        HashMap hashMap = new HashMap();
        net.time4j.engine.p pVar3 = g0.F;
        hashMap.put(pVar3, pVar);
        net.time4j.c cVar3 = g0.H;
        net.time4j.l0 l0Var14 = g0.L;
        hashMap.put(cVar3, l0Var14);
        net.time4j.c cVar4 = g0.I;
        hashMap.put(cVar4, z0.D.n());
        net.time4j.d0 d0Var = g0.J;
        net.time4j.l0 l0Var15 = g0.P;
        hashMap.put(d0Var, l0Var15);
        net.time4j.d0 d0Var2 = g0.K;
        net.time4j.l0 l0Var16 = g0.M;
        hashMap.put(d0Var2, l0Var16);
        hashMap.put(l0Var14, l0Var16);
        hashMap.put(l0Var16, pVar);
        final net.time4j.d0 d0Var3 = g0.N;
        hashMap.put(d0Var3, pVar);
        final net.time4j.l0 l0Var17 = g0.O;
        hashMap.put(l0Var17, pVar);
        hashMap.put(l0Var15, pVar);
        net.time4j.e0 e0Var = g0.Q;
        hashMap.put(e0Var, pVar);
        net.time4j.c1 c1Var = h0.I;
        net.time4j.l0 l0Var = h0.L;
        hashMap.put(c1Var, l0Var);
        net.time4j.c cVar = h0.J;
        net.time4j.l0 l0Var6 = h0.O;
        hashMap.put(cVar, l0Var6);
        net.time4j.c cVar2 = h0.K;
        hashMap.put(cVar2, l0Var6);
        hashMap.put(l0Var, l0Var6);
        net.time4j.l0 l0Var2 = h0.M;
        hashMap.put(l0Var2, l0Var6);
        net.time4j.l0 l0Var3 = h0.N;
        hashMap.put(l0Var3, l0Var6);
        net.time4j.l0 l0Var4 = h0.Q;
        hashMap.put(l0Var6, l0Var4);
        net.time4j.l0 l0Var7 = h0.P;
        hashMap.put(l0Var7, l0Var4);
        net.time4j.l0 l0Var8 = h0.U;
        hashMap.put(l0Var4, l0Var8);
        net.time4j.l0 l0Var5 = h0.R;
        hashMap.put(l0Var5, l0Var8);
        i0.w = Collections.unmodifiableMap(hashMap);
        f0.b bVar = f0.b.k(x.class, i0.class, new i0.e(null), i0Var, g0Var);
        net.time4j.f dAYS2 = f.DAYS;
        bVar.e(pVar3, i0.d.j(pVar3), dAYS2);
        net.time4j.f yEARS2 = f.YEARS;
        bVar.e(cVar3, i0.d.j(cVar3), yEARS2);
        bVar.e(cVar4, i0.d.j(cVar4), w0.a);
        bVar.e(d0Var, i0.d.j(d0Var), f.QUARTERS);
        net.time4j.f mONTHS2 = f.MONTHS;
        bVar.e(d0Var2, i0.d.j(d0Var2), mONTHS2);
        bVar.e(l0Var14, i0.d.j(l0Var14), mONTHS2);
        bVar.e(l0Var16, i0.d.j(l0Var16), dAYS2);
        bVar.e(d0Var3, i0.d.j(d0Var3), dAYS2);
        bVar.e(l0Var17, i0.d.j(l0Var17), dAYS2);
        bVar.e(l0Var15, i0.d.j(l0Var15), dAYS2);
        bVar.e(e0Var, i0.d.j(e0Var), f.WEEKS);
        bVar.d(pVar, i0.d.j(pVar));
        bVar.d(c1Var, i0.d.j(c1Var));
        net.time4j.h hOURS2 = h.HOURS;
        bVar.e(cVar, i0.d.j(cVar), hOURS2);
        bVar.e(cVar2, i0.d.j(cVar2), hOURS2);
        bVar.e(l0Var, i0.d.j(l0Var), hOURS2);
        bVar.e(l0Var2, i0.d.j(l0Var2), hOURS2);
        bVar.e(l0Var3, i0.d.j(l0Var3), hOURS2);
        net.time4j.h mINUTES2 = h.MINUTES;
        bVar.e(l0Var6, i0.d.j(l0Var6), mINUTES2);
        bVar.e(l0Var7, i0.d.j(l0Var7), mINUTES2);
        net.time4j.h sECONDS2 = h.SECONDS;
        bVar.e(l0Var4, i0.d.j(l0Var4), sECONDS2);
        bVar.e(l0Var5, i0.d.j(l0Var5), sECONDS2);
        net.time4j.l0 l0Var9 = h0.S;
        net.time4j.h mILLIS2 = h.MILLIS;
        bVar.e(l0Var9, i0.d.j(l0Var9), mILLIS2);
        net.time4j.l0 l0Var10 = h0.T;
        net.time4j.h mICROS2 = h.MICROS;
        bVar.e(l0Var10, i0.d.j(l0Var10), mICROS2);
        net.time4j.h nANOS2 = h.NANOS;
        bVar.e(l0Var8, i0.d.j(l0Var8), nANOS2);
        net.time4j.l0 l0Var11 = h0.V;
        bVar.e(l0Var11, i0.d.j(l0Var11), mILLIS2);
        net.time4j.l0 l0Var12 = h0.W;
        bVar.e(l0Var12, i0.d.j(l0Var12), mICROS2);
        net.time4j.l0 l0Var13 = h0.X;
        bVar.e(l0Var13, i0.d.j(l0Var13), nANOS2);
        net.time4j.c1 c1Var2 = h0.Y;
        bVar.d(c1Var2, new i0.c(c1Var2));
        net.time4j.c1 c1Var3 = h0.Z;
        bVar.d(c1Var3, new i0.c(c1Var3));
        net.time4j.c1 c1Var4 = h0.a0;
        bVar.d(c1Var4, new i0.c(c1Var4));
        net.time4j.engine.p pVar2 = h0.b0;
        bVar.d(pVar2, i0.d.j(pVar2));
        i0.e0(bVar);
        i0.f0(bVar);
        i0.g0(bVar);
        i0.x = bVar.h();
        net.time4j.x[] arr = new x[7];
        o.g(yEARS2, mONTHS2, dAYS2, hOURS2, mINUTES2, sECONDS2, nANOS2);
    }

    private i0(g0 g0Var, h0 h0Var) {
        super();
        final int i2 = 24;
        if (h0Var.s() == i2) {
            long l = 1L;
            this.a = (g0)g0Var.M(l, f.DAYS);
            this.b = h0.E;
        } else {
            Objects.requireNonNull(g0Var, "Missing date.");
            this.a = g0Var;
            this.b = h0Var;
        }
    }

    static /* synthetic */ g0 O(i0 i0Var) {
        return i0Var.a;
    }

    static /* synthetic */ h0 P(i0 i0Var) {
        return i0Var.b;
    }

    static /* synthetic */ f0 Q() {
        return i0.x;
    }

    static /* synthetic */ Map R() {
        return i0.w;
    }

    public static f0<x, i0> U() {
        return i0.x;
    }

    static i0 W(net.time4j.f1.f fVar, net.time4j.tz.p pVar) {
        long l;
        int i;
        l = fVar.x() + (long)pVar.o();
        i = fVar.a() + pVar.n();
        long l5 = 1L;
        int i7 = 1000000000;
        if (i < 0) {
            i = i + i7;
            l = l - 1L;
        } else {
            if (i >= i7) {
                i = i - i7;
                l = l + 1L;
            }
        }
        int i8 = 86400;
        int i9 = c.d(l, i8);
        i9 /= 60;
        return i0.d0(g0.P0(c.b(l, i8), z.UNIX), h0.L0(i10 / 60, i10 % 60, i9 % 60, i));
    }

    public static i0 c0(int i, int i2, int i3, int i4, int i5, int i6) {
        return i0.d0(g0.K0(i, i2, i3), h0.K0(i4, i5, i6));
    }

    public static i0 d0(g0 g0Var, h0 h0Var) {
        return new i0(g0Var, h0Var);
    }

    private static void e0(f0.b<x, i0> bVar) {
        int i = 0;
        EnumSet range;
        net.time4j.f[] values = f.values();
        i = 0;
        while (i < values.length) {
            net.time4j.f fVar = values[i];
            EnumSet r10 = fVar.compareTo(f.WEEKS) < 0 ? EnumSet.range(f.MILLENNIA, f.MONTHS) : EnumSet.range(f.WEEKS, f.DAYS);
            bVar.g(fVar, new i0.b(fVar), fVar.getLength(), (fVar.compareTo(f.WEEKS) < 0 ? EnumSet.range(f.MILLENNIA, f.MONTHS) : EnumSet.range(f.WEEKS, f.DAYS)));
            i = i + 1;
        }
    }

    private static void f0(f0.b<x, i0> bVar) {
        int i = 0;
        final net.time4j.h[] values = h.values();
        i = 0;
        for (net.time4j.h hVar : values) {
            bVar.g(hVar, new i0.b(hVar), hVar.getLength(), EnumSet.allOf(h.class));
        }
    }

    private static void g0(f0.b<x, i0> bVar) {
        Iterator it = g0.t0().o().iterator();
        while (it.hasNext()) {
            bVar.f((r)it.next());
        }
        Iterator it2 = h0.k0().o().iterator();
        while (it2.hasNext()) {
            bVar.f((r)it2.next());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private Object writeReplace() {
        return new SPX(this, 8);
    }

    @Override // net.time4j.engine.i0
    protected f0<x, i0> J() {
        return i0.x;
    }

    @Override // net.time4j.engine.i0
    public b0 S(net.time4j.tz.p pVar) {
        long l;
        int i;
        l = (c.i(this.a.E0() + 730L, 86400L)) + (long)(this.b.s() * 3600) + (long)(this.b.i() * 60) + (long)this.b.u() - (long)pVar.o();
        i = this.b.a() - pVar.n();
        long l13 = 1L;
        int i12 = 1000000000;
        if (this.b < 0) {
            i = i + i12;
            l = l - 1L;
        } else {
            if (this.b >= i12) {
                i = i - i12;
                l = l + 1L;
            }
        }
        return b0.o0(l, i, f.POSIX);
    }

    @Override // net.time4j.engine.i0
    public b0 T() {
        return S(p.C);
    }

    @Override // net.time4j.engine.i0
    public int V(i0 i0Var) {
        if (this.a.R(i0Var.a)) {
            return 1;
        }
        if (this.a.S(i0Var.a)) {
            return -1;
        }
        return this.b.p0(i0Var.b);
    }

    @Override // net.time4j.engine.i0
    public g0 X() {
        return this.a;
    }

    @Override // net.time4j.engine.i0
    public h0 Z() {
        return this.b;
    }

    @Override // net.time4j.engine.i0
    public int a() {
        return this.b.a();
    }

    @Override // net.time4j.engine.i0
    public b0 a0(l lVar) {
        if (lVar.J()) {
            return S(lVar.A(this.a, this.b));
        }
        net.time4j.tz.o oVar = lVar.E();
        long l = oVar.b(this.a, this.b, lVar);
        if (oVar == l.v) {
            b0.Y(l, this);
        }
        return b0.o0(l, this.b.a(), f.POSIX);
    }

    @Override // net.time4j.engine.i0
    public b0 b0(k kVar) {
        return a0(l.N(kVar));
    }

    @Override // net.time4j.engine.i0
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof i0) {
            if (this.a.equals(object.a)) {
                if (!(this.b.equals(object.b))) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.engine.i0
    public g0 h0() {
        return this.a;
    }

    @Override // net.time4j.engine.i0
    public int hashCode() {
        return (this.a.hashCode() * 13) + (this.b.hashCode() * 37);
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
        String g0Var2 = this.a.toString();
        String h0Var2 = this.b.toString();
        str = g0Var2 + h0Var2;
        return str;
    }

    @Override // net.time4j.engine.i0
    public int u() {
        return this.b.u();
    }

    @Override // net.time4j.engine.i0
    protected i0 Y() {
        return this;
    }
}
