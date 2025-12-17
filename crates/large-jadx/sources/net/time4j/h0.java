package net.time4j;

import android.app.ActivityManager.MemoryInfo;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.time4j.engine.d;
import net.time4j.engine.d0;
import net.time4j.engine.f0;
import net.time4j.engine.f0.b;
import net.time4j.engine.i0;
import net.time4j.engine.k0;
import net.time4j.engine.l0;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.r;
import net.time4j.engine.t;
import net.time4j.engine.w;
import net.time4j.engine.x;
import net.time4j.engine.y;
import net.time4j.f1.c;
import net.time4j.f1.d;
import net.time4j.f1.g;
import net.time4j.g1.b;
import net.time4j.g1.c;
import net.time4j.g1.e;
import net.time4j.g1.h;

/* loaded from: classes3.dex */
@c("iso8601")
public final class h0 extends i0<net.time4j.w, net.time4j.h0> implements g, h {

    private static final BigDecimal A = null;
    private static final BigDecimal B = null;
    private static final BigDecimal C = null;
    private static final net.time4j.h0[] D = null;
    static final net.time4j.h0 E = null;
    static final net.time4j.h0 F = null;
    static final p<net.time4j.h0> G = null;
    public static final net.time4j.u0 H = null;
    public static final net.time4j.c1<net.time4j.a0> I = null;
    public static final net.time4j.c<Integer, net.time4j.h0> J = null;
    public static final net.time4j.c<Integer, net.time4j.h0> K = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> L = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> M = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> N = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> O = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> P = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> Q = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> R = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> S = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> T = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> U = null;
    public static final net.time4j.l0<Integer, net.time4j.h0> V = null;
    public static final net.time4j.l0<Long, net.time4j.h0> W = null;
    public static final net.time4j.l0<Long, net.time4j.h0> X = null;
    public static final net.time4j.c1<BigDecimal> Y = null;
    public static final net.time4j.c1<BigDecimal> Z = null;
    public static final net.time4j.c1<BigDecimal> a0 = null;
    public static final p<net.time4j.h> b0 = null;
    private static final Map<String, Object> c0 = null;
    private static final y<net.time4j.h0, BigDecimal> d0 = null;
    private static final y<net.time4j.h0, BigDecimal> e0 = null;
    private static final y<net.time4j.h0, BigDecimal> f0 = null;
    private static final f0<net.time4j.w, net.time4j.h0> g0 = null;
    private static final long serialVersionUID = 2780881537313863339L;
    static final char w = 44;
    private static final BigDecimal x;
    private static final BigDecimal y;
    private static final BigDecimal z;
    private final transient byte a;
    private final transient byte b;
    private final transient byte c;
    private final transient int v;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            h0.a.a = iArr;
            iArr[h.HOURS.ordinal()] = 1;
            h0.a.a[h.MINUTES.ordinal()] = 2;
            h0.a.a[h.SECONDS.ordinal()] = 3;
            h0.a.a[h.MILLIS.ordinal()] = 4;
            h0.a.a[h.MICROS.ordinal()] = 5;
            h0.a.a[h.NANOS.ordinal()] = 6;
        }
    }

    private static class b implements y<net.time4j.h0, BigDecimal> {

        private final p<BigDecimal> a;
        private final BigDecimal b;
        b(p<BigDecimal> p, BigDecimal bigDecimal2) {
            super();
            this.a = p;
            this.b = bigDecimal2;
        }

        private static BigDecimal b(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.divide(bigDecimal2, 16, RoundingMode.FLOOR);
        }

        private static int j(BigDecimal bigDecimal) {
            return Math.min(999999999, bigDecimal.movePointRight(9).setScale(0, RoundingMode.HALF_UP).intValue());
        }

        public p<?> d(net.time4j.h0 h0) {
            return 0;
        }

        public p<?> e(net.time4j.h0 h0) {
            return 0;
        }

        @Override // net.time4j.engine.y
        public BigDecimal f(net.time4j.h0 h0) {
            net.time4j.c1 i;
            byte obj2;
            obj2 = this.a;
            if (h0.g0(h0) == 24 && obj2 != h0.Z && obj2 == h0.a0) {
                obj2 = this.a;
                if (obj2 != h0.Z) {
                    if (obj2 == h0.a0) {
                    }
                }
                return BigDecimal.ZERO;
            }
            return this.b;
        }

        @Override // net.time4j.engine.y
        public BigDecimal g(net.time4j.h0 h0) {
            return BigDecimal.ZERO;
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return d((h0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return e((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return f((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return g((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return h((h0)object);
        }

        @Override // net.time4j.engine.y
        public BigDecimal h(net.time4j.h0 h0) {
            BigDecimal valueOf;
            BigDecimal multiply;
            BigDecimal num;
            BigDecimal obj4;
            p pVar = this.a;
            if (pVar == h0.Y) {
                if (h0.equals(h0.E)) {
                    return BigDecimal.ZERO;
                }
                int i2 = 24;
                if (h0.g0(h0) == i2) {
                    return h0.V();
                }
                BigDecimal num9 = h0.Y();
                BigDecimal num10 = h0.X();
                obj4 = BigDecimal.valueOf((long)b4).add(h0.b.b(BigDecimal.valueOf((long)b6), num9)).add(h0.b.b(BigDecimal.valueOf((long)b7), num10)).add(h0.b.b(BigDecimal.valueOf((long)obj4), h0.X().multiply(h0.W())));
                return obj4.setScale(15, RoundingMode.FLOOR).stripTrailingZeros();
            } else {
                net.time4j.c1 c1Var2 = h0.Z;
                if (pVar == c1Var2) {
                    if (h0.Q(h0)) {
                        return BigDecimal.ZERO;
                    }
                    BigDecimal num8 = h0.Y();
                    obj4 = BigDecimal.valueOf((long)b).add(h0.b.b(BigDecimal.valueOf((long)b5), num8)).add(h0.b.b(BigDecimal.valueOf((long)obj4), h0.Y().multiply(h0.W())));
                } else {
                    net.time4j.c1 c1Var3 = h0.a0;
                    if (pVar != c1Var3) {
                    } else {
                        if (h0.R(h0)) {
                            return BigDecimal.ZERO;
                        }
                        obj4 = BigDecimal.valueOf((long)b2).add(h0.b.b(BigDecimal.valueOf((long)obj4), h0.W()));
                    }
                }
            }
            obj4 = new UnsupportedOperationException(this.a.name());
            throw obj4;
        }

        @Override // net.time4j.engine.y
        public boolean i(net.time4j.h0 h0, BigDecimal bigDecimal2) {
            int i2;
            net.time4j.c1 i;
            byte obj4;
            if (bigDecimal2 == null) {
                return 0;
            }
            final int i3 = 1;
            if (h0.g0(h0) == 24) {
                obj4 = this.a;
                if (obj4 != h0.Z) {
                    if (obj4 == h0.a0 && BigDecimal.ZERO.compareTo(bigDecimal2) == 0) {
                        if (BigDecimal.ZERO.compareTo(bigDecimal2) == 0) {
                            i2 = i3;
                        }
                    }
                } else {
                }
                return i2;
            }
            if (BigDecimal.ZERO.compareTo(bigDecimal2) <= 0 && this.b.compareTo(bigDecimal2) >= 0) {
                if (this.b.compareTo(bigDecimal2) >= 0) {
                    i2 = i3;
                }
            }
            return i2;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return i((h0)object, (BigDecimal)object2);
        }

        @Override // net.time4j.engine.y
        public net.time4j.h0 k(net.time4j.h0 h0, BigDecimal bigDecimal2, boolean z3) {
            int i5;
            int i;
            int intValue;
            BigDecimal scale;
            long longValueExact;
            long longValueExact3;
            long longValueExact2;
            int i2;
            long l3;
            long l2;
            int i3;
            long l;
            int i4;
            int obj13;
            int obj14;
            int obj15;
            if (bigDecimal2 == null) {
            } else {
                p pVar = this.a;
                scale = 0;
                if (pVar == h0.Y) {
                    obj13 = bigDecimal2.setScale(scale, RoundingMode.FLOOR);
                    BigDecimal multiply = bigDecimal2.subtract(obj13).multiply(h0.Y());
                    BigDecimal scale4 = multiply.setScale(scale, RoundingMode.FLOOR);
                    BigDecimal multiply2 = multiply.subtract(scale4).multiply(h0.Y());
                    scale = multiply2.setScale(scale, RoundingMode.FLOOR);
                    longValueExact = obj13.longValueExact();
                    obj13 = scale4.intValue();
                    intValue = scale.intValue();
                    i = h0.b.j(multiply2.subtract(scale));
                    i2 = 0;
                    if (z3) {
                        if (Long.compare(longValueExact, i2) > 0 && obj15 |= i == 0) {
                            if (obj15 |= i == 0) {
                                return h0.F;
                            }
                        }
                        return h0.L0(obj14, obj13, intValue, i);
                    } else {
                        if (Long.compare(longValueExact, i2) < 0) {
                        } else {
                            if (Long.compare(longValueExact, i2) > 0) {
                            } else {
                                obj14 = (int)longValueExact;
                            }
                        }
                    }
                    obj15 = new StringBuilder();
                    obj15.append("Value out of range: ");
                    obj15.append(bigDecimal2);
                    obj13 = new IllegalArgumentException(obj15.toString());
                    throw obj13;
                } else {
                    int i8 = 60;
                    if (pVar == h0.Z) {
                        BigDecimal scale2 = bigDecimal2.setScale(scale, RoundingMode.FLOOR);
                        BigDecimal multiply3 = bigDecimal2.subtract(scale2).multiply(h0.Y());
                        scale = multiply3.setScale(scale, RoundingMode.FLOOR);
                        longValueExact2 = scale2.longValueExact();
                        if (z3) {
                            l2 += l;
                            obj13 = c.d(longValueExact2, obj6);
                        } else {
                            h0.Z(longValueExact2);
                            obj13 = (int)longValueExact2;
                        }
                        i = i6;
                        intValue = longValueExact3;
                        longValueExact = l2;
                    } else {
                        if (pVar != h0.a0) {
                        } else {
                            BigDecimal scale3 = bigDecimal2.setScale(scale, RoundingMode.FLOOR);
                            longValueExact3 = scale3.longValueExact();
                            if (z3) {
                                i5 = c.d(longValueExact3, obj5);
                                l5 += l4;
                                l3 += longValueExact3;
                                obj13 = c.d(i3, obj9);
                            } else {
                                h0.a0(longValueExact3);
                                i5 = (int)longValueExact3;
                            }
                            longValueExact = l3;
                            intValue = i5;
                            i = i4;
                        }
                    }
                }
                obj13 = new UnsupportedOperationException(this.a.name());
                throw obj13;
            }
            obj13 = new IllegalArgumentException("Missing element value.");
            throw obj13;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return k((h0)object, (BigDecimal)object2, z3);
        }
    }

    private static class c implements k0<net.time4j.h0> {

        private final net.time4j.h a;
        private c(net.time4j.h h) {
            super();
            this.a = h;
        }

        c(net.time4j.h h, net.time4j.h0.a h0$a2) {
            super(h);
        }

        static net.time4j.k c(net.time4j.h0 h0, long l2, net.time4j.h h3) {
            return h0.c.e(h0, l2, h3);
        }

        private static net.time4j.k e(net.time4j.h0 h0, long l2, net.time4j.h h3) {
            int cmp;
            int i;
            int i2 = 0;
            if (Long.compare(l2, i2) == 0 && h0.g0(h0) < 24) {
                if (h0.g0(h0) < 24) {
                    k obj5 = new k(i2, obj1, h0);
                    return obj5;
                }
            }
            return (k)h0.c.g(k.class, obj7, h0, l2);
        }

        private static <R> R g(Class<R> class, net.time4j.h h2, net.time4j.h0 h03, long l4) {
            int b;
            byte b2;
            int i;
            long l;
            long l2;
            long l3;
            long obj12;
            net.time4j.h0 obj13;
            b = h0.h0(h03);
            b2 = h0.i0(h03);
            i = h0.O(h03);
            int i7 = h0.a.a[h2.ordinal()];
            int i11 = 60;
            switch (i7) {
                case 1:
                    l2 = c.f((long)obj12, h03);
                    break;
                case 2:
                    l = c.f((long)obj12, obj6);
                    l2 = c.f((long)obj12, h03);
                    b = c.d(l, obj6);
                    break;
                case 3:
                    long l8 = c.f((long)obj12, b2);
                    l = c.f((long)obj12, obj6);
                    l2 = c.f((long)obj12, h03);
                    b2 = c.d(l8, b2);
                    b = obj12;
                    break;
                case 4:
                    return h0.c.g(class, h.NANOS, h03, c.i(l4, obj15));
                case 5:
                    return h0.c.g(class, h.NANOS, h03, c.i(l4, obj15));
                case 6:
                    long l6 = c.f((long)obj12, b2);
                    obj12 = 1000000000;
                    long l10 = c.f((long)obj12, i7);
                    l = c.f((long)b3, obj6);
                    l2 = c.f((long)obj13, obj8);
                    b = obj13;
                    b2 = i6;
                    i = obj12;
                    break;
                default:
                    UnsupportedOperationException obj11 = new UnsupportedOperationException(h2.name());
                    throw obj11;
            }
            obj12 = 24;
            obj13 = c.d(l2, obj8);
            if (i9 |= i == 0) {
                if (Long.compare(l4, b) > 0 && class == h0.class) {
                    obj13 = class == h0.class ? h0.F : h0.E;
                } else {
                }
            } else {
                obj13 = h0.L0(obj13, b, b2, i);
            }
            if (class == h0.class) {
                return class.cast(obj13);
            }
            obj12 = new k(c.b(l2, obj8), obj15, obj13);
            return class.cast(obj12);
        }

        @Override // net.time4j.engine.k0
        public long a(Object object, Object object2) {
            return f((h0)object, (h0)object2);
        }

        @Override // net.time4j.engine.k0
        public Object b(Object object, long l2) {
            return d((h0)object, l2);
        }

        @Override // net.time4j.engine.k0
        public net.time4j.h0 d(net.time4j.h0 h0, long l2) {
            if (Long.compare(l2, i) == 0) {
                return h0;
            }
            return (h0)h0.c.g(h0.class, this.a, h0, l2);
        }

        @Override // net.time4j.engine.k0
        public long f(net.time4j.h0 h0, net.time4j.h0 h02) {
            long obj3;
            switch (obj3) {
                case 1:
                    obj3 = 3600000000000L;
                    break;
                case 2:
                    obj3 = 60000000000L;
                    break;
                case 3:
                    obj3 = 1000000000;
                    break;
                case 4:
                    obj3 = 1000000;
                    break;
                case 5:
                    obj3 = 1000;
                    break;
                case 6:
                    obj3 = 1;
                    break;
                default:
                    obj3 = new UnsupportedOperationException(this.a.name());
                    throw obj3;
            }
            return i2 /= obj3;
        }
    }

    private static class d implements y<net.time4j.h0, Integer> {

        private final p<Integer> a;
        private final int b = -1;
        private final int c;
        private final int v;
        d(p<Integer> p, int i2, int i3) {
            int obj2;
            super();
            this.a = p;
            if (p instanceof u) {
                this.b = (u)p.u();
            } else {
                obj2 = -1;
            }
            this.c = i2;
            this.v = i3;
        }

        private p<?> b(net.time4j.h0 h0) {
            switch (obj1) {
                case 1:
                    return h0.O;
                case 2:
                    return h0.Q;
                case 3:
                    return h0.U;
                default:
                    return 0;
            }
        }

        private static boolean i(net.time4j.h0 h0) {
            int b;
            int obj2;
            if (h0.g0(h0) >= 12) {
                if (h0.g0(h0) == 24) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }

        private net.time4j.h0 l(net.time4j.h0 h0, int i2) {
            net.time4j.l0 l0Var;
            net.time4j.l0 l0Var3;
            net.time4j.l0 l0Var2;
            net.time4j.h0 obj4;
            p pVar = this.a;
            if (pVar != h0.N && pVar != h0.M) {
                if (pVar != h0.M) {
                    if (pVar == h0.L) {
                    } else {
                        net.time4j.l0 l0Var4 = h0.O;
                        if (pVar == l0Var4) {
                            return (h0)h0.M((long)obj5, l0Var4);
                        }
                        net.time4j.l0 l0Var5 = h0.Q;
                        if (pVar == l0Var5) {
                            return (h0)h0.M((long)obj5, l0Var5);
                        }
                        net.time4j.l0 l0Var6 = h0.S;
                        if (pVar == l0Var6) {
                            return (h0)h0.M((long)obj5, l0Var6);
                        }
                        net.time4j.l0 l0Var7 = h0.T;
                        if (pVar == l0Var7) {
                            return (h0)h0.M((long)obj5, l0Var7);
                        }
                        net.time4j.l0 l0Var8 = h0.U;
                        if (pVar == l0Var8) {
                            return (h0)h0.M((long)obj5, l0Var8);
                        }
                        int i7 = c.c(i2, 86400000);
                        obj4 %= i9;
                        if (pVar == h0.V && i7 == 0 && obj4 == null) {
                            i7 = c.c(i2, 86400000);
                            obj4 %= i9;
                            if (i7 == 0) {
                                if (obj4 == null) {
                                    obj4 = i2 > 0 ? h0.F : h0.E;
                                    return obj4;
                                }
                            }
                            return h0.P(i7, obj4);
                        }
                        final int i10 = 0;
                        int i5 = c.c(i2, 1440);
                        if (pVar == h0.P && i5 == 0 && h0.R(h0)) {
                            i5 = c.c(i2, 1440);
                            if (i5 == 0) {
                                if (h0.R(h0)) {
                                    obj4 = i2 > 0 ? h0.F : h0.E;
                                    return obj4;
                                }
                            }
                            return k(h0, Integer.valueOf(i5), i10);
                        }
                        if (pVar != h0.R) {
                        } else {
                            int i3 = c.c(i2, 86400);
                            if (i3 == 0 && h0.O(h0) == 0) {
                                if (h0.O(h0) == 0) {
                                    obj4 = i2 > 0 ? h0.F : h0.E;
                                    return obj4;
                                }
                            }
                            return k(h0, Integer.valueOf(i3), i10);
                        }
                    }
                    obj4 = new UnsupportedOperationException(this.a.name());
                    throw obj4;
                }
            }
            return (h0)h0.M((long)obj5, l0Var);
        }

        public p<?> d(net.time4j.h0 h0) {
            return b(h0);
        }

        public p<?> e(net.time4j.h0 h0) {
            return b(h0);
        }

        @Override // net.time4j.engine.y
        public Integer f(net.time4j.h0 h0) {
            byte b;
            if (h0.g0(h0) == 24 && /* condition */) {
                if (/* condition */) {
                    return null;
                }
            }
            if (h0.y0(this.a)) {
                return Integer.valueOf(obj3--);
            }
            return Integer.valueOf(this.v);
        }

        @Override // net.time4j.engine.y
        public Integer g(net.time4j.h0 h0) {
            return Integer.valueOf(this.c);
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return d((h0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return e((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return f((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return g((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return h((h0)object);
        }

        @Override // net.time4j.engine.y
        public Integer h(net.time4j.h0 h0) {
            int i3;
            int i2;
            int i;
            byte obj5;
            switch (i3) {
                case 1:
                    i2 = i;
                    return Integer.valueOf(i2);
                case 2:
                    obj5 %= i2;
                    i2 = obj5;
                    return Integer.valueOf(i2);
                case 3:
                    i2 = obj5 % 12;
                    return Integer.valueOf(i2);
                case 4:
                    i2 = obj5 % 24;
                    return Integer.valueOf(i2);
                case 5:
                    i2 = h0.g0(h0);
                    return Integer.valueOf(i2);
                case 6:
                    i2 = h0.h0(h0);
                    return Integer.valueOf(i2);
                case 7:
                    b2 *= 60;
                    obj5 = h0.h0(h0);
                    break;
                case 8:
                    i2 = h0.i0(h0);
                    return Integer.valueOf(i2);
                case 9:
                    i4 += i2;
                    obj5 = h0.i0(h0);
                    break;
                case 10:
                    i2 = obj5 / i3;
                    return Integer.valueOf(i2);
                case 11:
                    i2 = obj5 / 1000;
                    return Integer.valueOf(i2);
                case 12:
                    i2 = h0.O(h0);
                    return Integer.valueOf(i2);
                case 13:
                    i2 = (int)i3;
                    return Integer.valueOf(i2);
                default:
                    obj5 = new UnsupportedOperationException(this.a.name());
                    throw obj5;
            }
            i2 = i3 + obj5;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return j((h0)object, (Integer)object2);
        }

        @Override // net.time4j.engine.y
        public boolean j(net.time4j.h0 h0, Integer integer2) {
            int i3;
            int i;
            int i2;
            byte obj5;
            i3 = 0;
            if (integer2 == null) {
                return i3;
            }
            int obj6 = integer2.intValue();
            if (obj6 >= this.c) {
                i = this.v;
                if (obj6 > i) {
                } else {
                    final int i5 = 1;
                    i = this.b;
                    if (obj6 == i && i != 5 && i != 7 && i != 9) {
                        i = this.b;
                        if (i != 5) {
                            if (i != 7) {
                                if (i != 9) {
                                    if (i != 13) {
                                    } else {
                                        if (obj5 %= obj6 == 0) {
                                            i3 = i5;
                                        }
                                    }
                                    return i3;
                                }
                                if (h0.O(h0) == 0) {
                                    i3 = i5;
                                }
                                return i3;
                            }
                            return h0.R(h0);
                        }
                        return h0.Q(h0);
                    }
                    if (h0.g0(h0) == 24 && /* condition */ && obj6 == null) {
                        if (/* condition */) {
                            if (obj6 == null) {
                                i3 = i5;
                            }
                            return i3;
                        }
                    }
                }
                return i5;
            }
            return i3;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h0 k(net.time4j.h0 h0, Integer integer2, boolean z3) {
            int b2;
            int b;
            int i;
            net.time4j.h0 obj7;
            int obj8;
            int obj9;
            if (integer2 == null) {
            } else {
                if (z3) {
                    return l(h0, integer2.intValue());
                }
                if (!j(h0, integer2)) {
                } else {
                    obj9 = h0.g0(h0);
                    b2 = h0.h0(h0);
                    b = h0.i0(h0);
                    i = h0.O(h0);
                    obj8 = integer2.intValue();
                    final int i3 = 0;
                    final int i4 = 1000000;
                    switch (i2) {
                        case 1:
                            obj9 = obj8;
                            obj8 += 12;
                            obj8 = i3;
                            return h0.L0(obj9, b2, b, i);
                        case 2:
                            obj9 = obj8;
                            obj9 = i3;
                            return h0.L0(obj9, b2, b, i);
                        case 3:
                            obj9 = obj8;
                            obj8 += 12;
                            return h0.L0(obj9, b2, b, i);
                        case 4:
                            obj9 = obj8;
                            return h0.L0(obj9, b2, b, i);
                        case 5:
                            b2 = obj8;
                            return h0.L0(obj9, b2, b, i);
                        case 6:
                            obj9 = obj8 / 60;
                            b2 = obj8 % 60;
                            return h0.L0(obj9, b2, b, i);
                        case 7:
                            b = obj8;
                            return h0.L0(obj9, b2, b, i);
                        case 8:
                            obj9 = obj8 / 3600;
                            obj8 %= 3600;
                            b2 = obj8 / 60;
                            b = obj8 % 60;
                            return h0.L0(obj9, b2, b, i);
                        case 9:
                            obj8 *= i4;
                            obj7 %= i4;
                            break;
                        case 10:
                            obj8 *= 1000;
                            obj7 %= 1000;
                            break;
                        case 11:
                            i = obj8;
                            return h0.L0(obj9, b2, b, i);
                        case 12:
                            return h0.P(obj8, obj7 %= i4);
                        default:
                            obj7 = new UnsupportedOperationException(this.a.name());
                            throw obj7;
                    }
                    i = obj8 + obj7;
                }
                obj9 = new StringBuilder();
                obj9.append("Value out of range: ");
                obj9.append(integer2);
                obj7 = new IllegalArgumentException(obj9.toString());
                throw obj7;
            }
            obj7 = new IllegalArgumentException("Missing element value.");
            throw obj7;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return k((h0)object, (Integer)object2, z3);
        }
    }

    private static class e implements y<net.time4j.h0, Long> {

        private final p<Long> a;
        private final long b;
        private final long c;
        e(p<Long> p, long l2, long l3) {
            super();
            this.a = p;
            this.b = l2;
            this.c = obj4;
        }

        private net.time4j.h0 j(net.time4j.h0 h0, long l2) {
            net.time4j.h0 obj6;
            int obj7;
            final net.time4j.l0 l0Var = h0.W;
            final int i = 0;
            if (this.a == l0Var) {
                long l5 = h0.U(l2, obj8);
                obj6 %= 1000;
                if (Long.compare(l5, i) == 0 && obj6 == null && Long.compare(l2, i) > 0) {
                    if (obj6 == null) {
                        if (Long.compare(l2, i) > 0) {
                            obj6 = h0.F;
                        } else {
                            obj6 = h0.S(l5, l0Var);
                        }
                    } else {
                    }
                } else {
                }
                return obj6;
            }
            long l3 = h0.U(l2, obj8);
            if (Long.compare(l3, i) == 0 && Long.compare(l2, i) > 0) {
                if (Long.compare(l2, i) > 0) {
                    obj6 = h0.F;
                } else {
                    obj6 = h0.T(l3);
                }
            } else {
            }
            return obj6;
        }

        public p<?> b(net.time4j.h0 h0) {
            return 0;
        }

        public p<?> d(net.time4j.h0 h0) {
            return 0;
        }

        @Override // net.time4j.engine.y
        public Long e(net.time4j.h0 h0) {
            net.time4j.h0 obj5;
            final net.time4j.l0 l0Var = h0.W;
            if (this.a == l0Var && obj5 %= 1000 != 0) {
                if (obj5 %= 1000 != 0) {
                    return Long.valueOf(l2 -= i2);
                }
            }
            return Long.valueOf(this.c);
        }

        @Override // net.time4j.engine.y
        public Long f(net.time4j.h0 h0) {
            return Long.valueOf(this.b);
        }

        @Override // net.time4j.engine.y
        public Long g(net.time4j.h0 h0) {
            int i;
            int i2;
            final net.time4j.l0 l0Var = h0.W;
            if (this.a == l0Var) {
                l /= i2;
            } else {
                i = h0.f0(h0);
            }
            return Long.valueOf(i);
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return b((h0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return d((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((h0)object);
        }

        @Override // net.time4j.engine.y
        public boolean h(net.time4j.h0 h0, Long long2) {
            int i;
            p cmp;
            long l2;
            long l;
            int obj7;
            if (long2 == null) {
                return 0;
            }
            final int i2 = 1;
            if (this.a == h0.W && Long.compare(longValue, l) == 0 && obj7 %= 1000 == 0) {
                if (Long.compare(longValue, l) == 0) {
                    if (obj7 %= 1000 == 0) {
                        i = i2;
                    }
                    return i;
                }
            }
            if (Long.compare(l2, longValue2) <= 0 && Long.compare(obj7, l2) <= 0) {
                if (Long.compare(obj7, l2) <= 0) {
                    i = i2;
                }
            }
            return i;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h0 i(net.time4j.h0 h0, Long long2, boolean z3) {
            if (long2 == null) {
            } else {
                if (z3) {
                    return j(h0, long2.longValue());
                }
                boolean obj5 = h(h0, long2);
                if (obj5 == null) {
                } else {
                    long obj4 = long2.longValue();
                    if (this.a == h0.W) {
                        return h0.S(obj4, obj5);
                    }
                    return h0.T(obj4);
                }
                obj5 = new StringBuilder();
                obj5.append("Value out of range: ");
                obj5.append(long2);
                IllegalArgumentException obj3 = new IllegalArgumentException(obj5.toString());
                throw obj3;
            }
            obj3 = new IllegalArgumentException("Missing element value.");
            throw obj3;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((h0)object, (Long)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return i((h0)object, (Long)object2, z3);
        }
    }

    private static class f implements t<net.time4j.h0> {
        f(net.time4j.h0.a h0$a) {
            super();
        }

        private static void h(q<?> q, String string2) {
            final l0 eRROR_MESSAGE = l0.ERROR_MESSAGE;
            if (q.D(eRROR_MESSAGE, string2)) {
                q.G(eRROR_MESSAGE, string2);
            }
        }

        private static int j(q<?> q) {
            Object c1Var;
            int i;
            boolean z;
            int i2;
            int obj5;
            int i3 = q.e(h0.M);
            int i5 = Integer.MIN_VALUE;
            if (i3 != i5) {
                return i3;
            }
            int i4 = q.e(h0.K);
            if (i4 == 0) {
                return -1;
            }
            if (i4 == 24) {
                return 0;
            }
            if (i4 != i5) {
                return i4;
            }
            c1Var = h0.I;
            c1Var = q.p(c1Var);
            z = q.e(h0.J);
            if (q.v(c1Var) && z != i5 && z == 0) {
                c1Var = q.p(c1Var);
                z = q.e(h0.J);
                if (z != i5) {
                    if (z == 0) {
                        if ((a0)(a0)c1Var == a0.AM) {
                        } else {
                            i = -2;
                        }
                        return i;
                    }
                    if (z == 12) {
                    } else {
                        i2 = z;
                    }
                    if ((a0)(a0)c1Var == a0.AM) {
                    } else {
                        i2 += 12;
                    }
                    return i2;
                }
                obj5 = q.e(h0.L);
                if (obj5 != i5) {
                    if ((a0)(a0)c1Var == a0.AM) {
                    } else {
                        obj5 += 12;
                    }
                    return obj5;
                }
            }
            return i5;
        }

        private static net.time4j.h0 k(q<?> q) {
            net.time4j.l0 intValue2;
            int intValue4;
            int intValue3;
            int intValue;
            boolean z2;
            int intValue5;
            boolean z3;
            int i;
            int cmp;
            boolean z;
            net.time4j.l0 l0Var = h0.X;
            boolean z4 = q.v(l0Var);
            int i2 = 0;
            long longValue2 = (Long)q.p(l0Var).longValue();
            if (z4 && Long.compare(longValue2, i3) >= 0 && Long.compare(longValue2, l) > 0) {
                longValue2 = (Long)q.p(l0Var).longValue();
                if (Long.compare(longValue2, i3) >= 0) {
                    if (Long.compare(longValue2, l) > 0) {
                    }
                    return h0.T(longValue2);
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("NANO_OF_DAY out of range: ");
                stringBuilder4.append(longValue2);
                h0.f.h(q, stringBuilder4.toString());
                return i2;
            }
            net.time4j.l0 l0Var2 = h0.W;
            i = 0;
            intValue2 = h0.U;
            if (q.v(l0Var2) && q.v(intValue2)) {
                intValue2 = h0.U;
                if (q.v(intValue2)) {
                    i = intValue2 % 1000;
                }
                return h0.S((Long)q.p(l0Var2).longValue(), intValue2);
            }
            net.time4j.l0 l0Var3 = h0.V;
            int i4 = 1000000;
            net.time4j.l0 l0Var12 = h0.U;
            intValue = (Integer)q.p(l0Var12).intValue();
            if (q.v(l0Var3) && q.v(l0Var12) && intValue >= 0 && intValue >= 1000000000) {
                l0Var12 = h0.U;
                if (q.v(l0Var12)) {
                    intValue = (Integer)q.p(l0Var12).intValue();
                    if (intValue >= 0) {
                        if (intValue >= 1000000000) {
                        }
                        i = intValue % i4;
                        int intValue6 = (Integer)q.p(l0Var3).intValue();
                        if (intValue6 >= 0 && intValue6 > 86400000) {
                            if (intValue6 > 86400000) {
                            }
                            return h0.P(intValue6, i);
                        }
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("MILLI_OF_DAY out of range: ");
                        stringBuilder3.append(intValue6);
                        h0.f.h(q, stringBuilder3.toString());
                        return i2;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("NANO_OF_SECOND out of range: ");
                    stringBuilder.append(intValue);
                    h0.f.h(q, stringBuilder.toString());
                    return i2;
                }
                intValue = h0.T;
                intValue = (Integer)q.p(intValue).intValue();
                if (q.v(intValue) && intValue >= 0 && intValue >= i4) {
                    intValue = (Integer)q.p(intValue).intValue();
                    if (intValue >= 0) {
                        if (intValue >= i4) {
                        }
                        i = intValue % 1000;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("MICRO_OF_SECOND out of range: ");
                    stringBuilder2.append(intValue);
                    h0.f.h(q, stringBuilder2.toString());
                    return i2;
                }
            }
            net.time4j.l0 l0Var4 = h0.R;
            if (q.v(l0Var4)) {
                net.time4j.l0 l0Var9 = h0.U;
                if (q.v(l0Var9)) {
                    intValue3 = (Integer)q.p(l0Var9).intValue();
                } else {
                    net.time4j.l0 l0Var10 = h0.T;
                    if (q.v(l0Var10)) {
                        intValue10 *= 1000;
                    } else {
                        net.time4j.l0 l0Var11 = h0.S;
                        if (q.v(l0Var11)) {
                            intValue9 *= i4;
                        } else {
                            intValue3 = i;
                        }
                    }
                }
                return (h0)h0.L0(i, i, i, intValue3).G(l0Var4, q.p(l0Var4));
            }
            net.time4j.l0 l0Var5 = h0.P;
            if (q.v(l0Var5)) {
                net.time4j.l0 l0Var6 = h0.U;
                if (q.v(l0Var6)) {
                    intValue4 = (Integer)q.p(l0Var6).intValue();
                } else {
                    net.time4j.l0 l0Var7 = h0.T;
                    if (q.v(l0Var7)) {
                        intValue8 *= 1000;
                    } else {
                        net.time4j.l0 l0Var8 = h0.S;
                        if (q.v(l0Var8)) {
                            intValue7 *= i4;
                        } else {
                            intValue4 = i;
                        }
                    }
                }
                net.time4j.l0 l0Var13 = h0.Q;
                if (q.v(l0Var13)) {
                    intValue5 = (Integer)q.p(l0Var13).intValue();
                } else {
                    intValue5 = i;
                }
                return (h0)h0.L0(i, i, intValue5, intValue4).G(l0Var5, q.p(l0Var5));
            }
            return i2;
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
            i((h0)object, d2);
            return object;
        }

        @Override // net.time4j.engine.t
        public String f(x x, Locale locale2) {
            return b.t(e.ofStyle(x.getStyleValue()), locale2);
        }

        public net.time4j.h0 g(q<?> q, d d2, boolean z3, boolean z4) {
            int i6;
            int i5;
            int i;
            int i2;
            int i3;
            int i4;
            int obj8;
            int obj9;
            if (q instanceof f) {
                return (i0)i0.U().D(q, d2, z3, z4).Z();
            }
            obj8 = h0.G;
            if (q.v(obj8)) {
                return (h0)q.p(obj8);
            }
            obj8 = h0.Y;
            if (q.v(obj8)) {
                return h0.N0((BigDecimal)q.p(obj8));
            }
            int obj10 = 24;
            int i7 = 0;
            final int i11 = 0;
            i6 = Integer.MIN_VALUE;
            obj8 = h0.f.j(q);
            if (q.e(h0.N) == i6 && obj8 == i6) {
                obj8 = h0.f.j(q);
                if (obj8 == i6) {
                    return h0.f.k(q);
                }
                i5 = -1;
                if (obj8 != i5) {
                    if (obj8 == -2) {
                        if (z3) {
                            obj8 = obj8 == i5 ? i11 : 12;
                        }
                    } else {
                        if (obj8 == obj10 && !z3) {
                            if (!z3) {
                                h0.f.h(q, "Time 24:00 not allowed, use lax mode or element HOUR_FROM_0_TO_24 instead.");
                                return i7;
                            }
                        }
                    }
                } else {
                }
                h0.f.h(q, "Clock hour cannot be zero.");
                return i7;
            }
            net.time4j.c1 c1Var = h0.Z;
            if (q.v(c1Var)) {
                return (h0)h0.b0().withValue(h0.I0(obj8), q.p(c1Var), i11);
            }
            if (q.e(h0.O) == i6) {
                i = i11;
            }
            net.time4j.c1 c1Var2 = h0.a0;
            if (q.v(c1Var2)) {
                return (h0)h0.c0().withValue(h0.J0(obj8, i), q.p(c1Var2), i11);
            }
            if (q.e(h0.Q) == i6) {
                i3 = i11;
            }
            if (q.e(h0.U) == i6) {
                int i13 = q.e(h0.T);
                if (i13 == i6) {
                    int i14 = q.e(h0.S);
                    if (i14 == i6) {
                        i4 = i11;
                    } else {
                        i4 = c.h(i14, 1000000);
                    }
                } else {
                    i4 = c.h(i13, 1000);
                }
            }
            obj8 = c.f(c.i(c.f(c.f(c.i((long)obj8, z3), z3), z3), z3), z3);
            long l5 = 86400000000000L;
            long l6 = h0.U(obj8, z3);
            obj8 = h0.d0(obj8, z3);
            int i10 = 0;
            obj10 = Long.compare(obj8, i10);
            i3 = y.v;
            if (z3 && obj10 != null && q.C(i3, obj8)) {
                obj8 = c.f(c.i(c.f(c.f(c.i((long)obj8, z3), z3), z3), z3), z3);
                l5 = 86400000000000L;
                l6 = h0.U(obj8, z3);
                obj8 = h0.d0(obj8, z3);
                i10 = 0;
                obj10 = Long.compare(obj8, i10);
                if (obj10 != null) {
                    i3 = y.v;
                    if (q.C(i3, obj8)) {
                        q.F(i3, obj8);
                    }
                }
                if (Long.compare(l6, i10) == 0 && obj10 > 0) {
                    if (obj10 > 0) {
                        return h0.F;
                    }
                }
                return h0.T(l6);
            }
            if (obj8 >= 0 && i >= 0 && i3 >= 0 && i4 >= 0 && obj8 == obj10) {
                if (i >= 0) {
                    if (i3 >= 0) {
                        if (i4 >= 0) {
                            if (obj8 == obj10) {
                                obj9 = 59;
                                if (obj9 |= i4 != 0 && obj8 < obj10 && i <= obj9 && i3 <= obj9 && i4 <= 1000000000) {
                                    if (obj8 < obj10) {
                                        obj9 = 59;
                                        if (i <= obj9) {
                                            if (i3 <= obj9) {
                                                if (i4 <= 1000000000) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return h0.e0(obj8, i, i3, i4, i11);
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            h0.f.h(q, "Time component out of range.");
            return i7;
        }

        @Override // net.time4j.engine.t
        public o i(net.time4j.h0 h0, d d2) {
            return h0;
        }
    }

    private static class g implements y<net.time4j.h0, net.time4j.a0> {
        g(net.time4j.h0.a h0$a) {
            super();
        }

        public p<?> b(net.time4j.h0 h0) {
            return h0.L;
        }

        public p<?> d(net.time4j.h0 h0) {
            return h0.L;
        }

        @Override // net.time4j.engine.y
        public net.time4j.a0 e(net.time4j.h0 h0) {
            return a0.PM;
        }

        @Override // net.time4j.engine.y
        public net.time4j.a0 f(net.time4j.h0 h0) {
            return a0.AM;
        }

        @Override // net.time4j.engine.y
        public net.time4j.a0 g(net.time4j.h0 h0) {
            return a0.ofHour(h0.g0(h0));
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return b((h0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return d((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((h0)object);
        }

        @Override // net.time4j.engine.y
        public boolean h(net.time4j.h0 h0, net.time4j.a0 a02) {
            int obj1;
            obj1 = a02 != null ? 1 : 0;
            return obj1;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h0 i(net.time4j.h0 h0, net.time4j.a0 a02, boolean z3) {
            net.time4j.a0 a0Var;
            byte obj5;
            if (h0.g0(h0) == 24) {
                obj5 = 0;
            } else {
                obj5 = h0.g0(h0);
            }
            if (a02 == null) {
            } else {
                final int i2 = 12;
                if (a02 == a0.AM) {
                    if (obj5 >= i2) {
                        obj5 += -12;
                    }
                } else {
                    if (a02 == a0.PM && obj5 < i2) {
                        if (obj5 < i2) {
                            obj5 += 12;
                        }
                    }
                }
                return h0.L0(obj5, h0.h0(h0), h0.i0(h0), h0.O(h0));
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("Missing am/pm-value.");
            throw obj3;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((h0)object, (a0)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return i((h0)object, (a0)object2, z3);
        }
    }

    private static class h implements y<net.time4j.h0, net.time4j.h> {
        h(net.time4j.h0.a h0$a) {
            super();
        }

        public p<?> b(net.time4j.h0 h0) {
            return 0;
        }

        public p<?> d(net.time4j.h0 h0) {
            return 0;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h e(net.time4j.h0 h0) {
            return h.NANOS;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h f(net.time4j.h0 h0) {
            return h.HOURS;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h g(net.time4j.h0 h0) {
            if (h0.O(h0) != 0 && i2 %= i4 == 0) {
                if (i2 %= i4 == 0) {
                    return h.MILLIS;
                }
                if (obj3 %= 1000 == 0) {
                    return h.MICROS;
                }
                return h.NANOS;
            }
            if (h0.i0(h0) != 0) {
                return h.SECONDS;
            }
            if (h0.h0(h0) != 0) {
                return h.MINUTES;
            }
            return h.HOURS;
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return b((h0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return d((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((h0)object);
        }

        @Override // net.time4j.engine.y
        public boolean h(net.time4j.h0 h0, net.time4j.h h2) {
            int obj1;
            obj1 = h2 != null ? 1 : 0;
            return obj1;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h0 i(net.time4j.h0 h0, net.time4j.h h2, boolean z3) {
            if (h2 == null) {
            } else {
                if (h2.ordinal() >= g(h0).ordinal()) {
                    return h0;
                }
                switch (obj5) {
                    case 1:
                        return h0.I0(h0.g0(h0));
                    case 2:
                        return h0.J0(h0.g0(h0), h0.h0(h0));
                    case 3:
                        return h0.K0(h0.g0(h0), h0.h0(h0), h0.i0(h0));
                    case 4:
                        final int i = 1000000;
                        return h0.L0(h0.g0(h0), h0.h0(h0), h0.i0(h0), obj3 *= i);
                    case 5:
                        return h0.L0(h0.g0(h0), h0.h0(h0), h0.i0(h0), obj3 *= 1000);
                    case 6:
                        return h0;
                    default:
                        UnsupportedOperationException obj3 = new UnsupportedOperationException(h2.name());
                        throw obj3;
                }
            }
            obj3 = new IllegalArgumentException("Missing precision value.");
            throw obj3;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((h0)object, (h)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return i((h0)object, (h)object2, z3);
        }
    }

    private static class i implements y<net.time4j.h0, net.time4j.h0> {
        i(net.time4j.h0.a h0$a) {
            super();
        }

        public p<?> b(net.time4j.h0 h0) {
            return 0;
        }

        public p<?> d(net.time4j.h0 h0) {
            return 0;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h0 e(net.time4j.h0 h0) {
            return h0.F;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h0 f(net.time4j.h0 h0) {
            return h0.E;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h0 g(net.time4j.h0 h0) {
            return h0;
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return b((h0)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return d((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((h0)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            g((h0)object);
            return object;
        }

        @Override // net.time4j.engine.y
        public boolean h(net.time4j.h0 h0, net.time4j.h0 h02) {
            int obj1;
            obj1 = h02 != null ? 1 : 0;
            return obj1;
        }

        @Override // net.time4j.engine.y
        public net.time4j.h0 i(net.time4j.h0 h0, net.time4j.h0 h02, boolean z3) {
            if (h02 == null) {
            } else {
                return h02;
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("Missing time value.");
            throw obj1;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((h0)object, (h0)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            i((h0)object, (h0)object2, z3);
            return object2;
        }
    }
    static {
        String str;
        int i;
        int i3;
        int i4;
        int i2;
        int i5;
        int i6;
        net.time4j.h0[] objArr;
        net.time4j.h0 h0Var;
        if (Boolean.getBoolean("net.time4j.format.iso.decimal.dot")) {
            int i7 = 46;
        }
        int i8 = 44;
        BigDecimal bigDecimal = new BigDecimal(60);
        h0.x = bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal(3600);
        h0.y = bigDecimal2;
        BigDecimal bigDecimal3 = new BigDecimal(1000000000);
        h0.z = bigDecimal3;
        BigDecimal bigDecimal4 = new BigDecimal("24");
        h0.A = bigDecimal4;
        BigDecimal bigDecimal5 = new BigDecimal("23.999999999999999");
        h0.B = bigDecimal5;
        BigDecimal bigDecimal6 = new BigDecimal("59.999999999999999");
        h0.C = bigDecimal6;
        h0.D = new h0[25];
        int i10 = 0;
        i6 = i10;
        int i15 = 24;
        while (i6 <= i15) {
            super(i6, 0, 0, 0, 0);
            h0.D[i6] = h0Var;
            i6++;
            i15 = 24;
        }
        net.time4j.h0[] objArr2 = h0.D;
        net.time4j.h0 h0Var5 = objArr2[i10];
        h0.E = h0Var5;
        net.time4j.h0 h0Var3 = objArr2[i15];
        h0.F = h0Var3;
        net.time4j.q0 q0Var = q0.a;
        h0.G = q0Var;
        h0.H = q0Var;
        net.time4j.d aM_PM_OF_DAY = d.AM_PM_OF_DAY;
        h0.I = aM_PM_OF_DAY;
        net.time4j.u uVar8 = u.l("CLOCK_HOUR_OF_AMPM", i10);
        h0.J = uVar8;
        net.time4j.u uVar9 = u.l("CLOCK_HOUR_OF_DAY", true);
        h0.K = uVar9;
        net.time4j.u uVar12 = u.n("DIGITAL_HOUR_OF_AMPM", 3, i10, 11, 'K');
        h0.L = uVar12;
        int i44 = 23;
        int i45 = 72;
        net.time4j.u uVar13 = u.n("DIGITAL_HOUR_OF_DAY", 4, i10, i44, i45);
        h0.M = uVar13;
        net.time4j.u uVar14 = u.n("HOUR_FROM_0_TO_24", 5, i10, i44, i45);
        h0.N = uVar14;
        int i16 = 59;
        net.time4j.u uVar20 = u.n("MINUTE_OF_HOUR", 6, i10, i16, 'm');
        h0.O = uVar20;
        net.time4j.u uVar10 = u.n("MINUTE_OF_DAY", 7, i10, 1439, i10);
        h0.P = uVar10;
        net.time4j.u uVar15 = u.n("SECOND_OF_MINUTE", 8, i10, i16, 's');
        h0.Q = uVar15;
        net.time4j.u uVar = u.n("SECOND_OF_DAY", 9, i10, 86399, i10);
        h0.R = uVar;
        net.time4j.u uVar21 = u.n("MILLI_OF_SECOND", 10, i10, 999, i10);
        h0.S = uVar21;
        net.time4j.u uVar22 = u.n("MICRO_OF_SECOND", 11, i10, 999999, i10);
        h0.T = uVar22;
        final net.time4j.u uVar23 = uVar22;
        final net.time4j.u uVar24 = uVar21;
        net.time4j.u uVar2 = u.n("NANO_OF_SECOND", 12, i10, 999999999, 'S');
        h0.U = uVar2;
        int i58 = 65;
        net.time4j.u uVar3 = u.n("MILLI_OF_DAY", 13, i10, 86399999, i58);
        h0.V = uVar3;
        final net.time4j.u uVar27 = uVar;
        int i11 = 0;
        net.time4j.y yVar3 = y.l("MICRO_OF_DAY", i11, uVar);
        h0.W = yVar3;
        net.time4j.y yVar = y.l("NANO_OF_DAY", i11, uVar);
        h0.X = yVar;
        m mVar2 = new m("DECIMAL_HOUR", h0.B);
        h0.Y = mVar2;
        BigDecimal num3 = h0.C;
        m mVar6 = new m("DECIMAL_MINUTE", num3);
        h0.Z = mVar6;
        m mVar7 = new m("DECIMAL_SECOND", num3);
        h0.a0 = mVar7;
        p pVar2 = j0.v;
        h0.b0 = pVar2;
        HashMap hashMap = new HashMap();
        h0.t0(hashMap, q0Var);
        h0.t0(hashMap, aM_PM_OF_DAY);
        h0.t0(hashMap, uVar8);
        h0.t0(hashMap, uVar9);
        h0.t0(hashMap, uVar12);
        h0.t0(hashMap, uVar13);
        h0.t0(hashMap, uVar14);
        h0.t0(hashMap, uVar20);
        h0.t0(hashMap, uVar10);
        h0.t0(hashMap, uVar15);
        h0.t0(hashMap, uVar27);
        h0.t0(hashMap, uVar24);
        h0.t0(hashMap, uVar23);
        net.time4j.u uVar19 = uVar25;
        h0.t0(hashMap, uVar19);
        h0.t0(hashMap, uVar3);
        net.time4j.y yVar2 = yVar8;
        h0.t0(hashMap, yVar2);
        h0.t0(hashMap, yVar);
        h0.t0(hashMap, mVar2);
        net.time4j.y yVar9 = yVar;
        net.time4j.m mVar = mVar9;
        h0.t0(hashMap, mVar);
        h0.t0(hashMap, mVar7);
        h0.c0 = Collections.unmodifiableMap(hashMap);
        net.time4j.y yVar10 = yVar2;
        h0.b bVar6 = new h0.b(mVar2, h0.A);
        h0.d0 = bVar6;
        h0.b bVar3 = new h0.b(mVar, num3);
        h0.e0 = bVar3;
        h0.b bVar = new h0.b(mVar7, num3);
        h0.f0 = bVar;
        h0.f fVar = new h0.f(0);
        f0.b bVar2 = f0.b.k(w.class, h0.class, fVar, h0Var5, h0Var3);
        int i20 = 0;
        h0.i iVar = new h0.i(i20);
        bVar2.d(q0Var, iVar);
        h0.g gVar = new h0.g(i20);
        bVar2.d(aM_PM_OF_DAY, gVar);
        int i28 = 1;
        h0.d dVar = new h0.d(uVar8, i28, 12);
        net.time4j.h hOURS = h.HOURS;
        bVar2.e(uVar8, dVar, hOURS);
        int i33 = 24;
        h0.d dVar2 = new h0.d(uVar9, i28, i33);
        bVar2.e(uVar9, dVar2, hOURS);
        int i36 = 0;
        h0.d dVar3 = new h0.d(uVar12, i36, 11);
        bVar2.e(uVar12, dVar3, hOURS);
        h0.d dVar4 = new h0.d(uVar13, i36, 23);
        bVar2.e(uVar13, dVar4, hOURS);
        h0.d dVar5 = new h0.d(uVar14, i36, i33);
        bVar2.e(uVar14, dVar5, hOURS);
        int i22 = 59;
        h0.d dVar6 = new h0.d(uVar20, i36, i22);
        net.time4j.h mINUTES = h.MINUTES;
        bVar2.e(uVar20, dVar6, mINUTES);
        h0.d dVar7 = new h0.d(uVar10, i36, 1440);
        bVar2.e(uVar10, dVar7, mINUTES);
        net.time4j.u uVar6 = uVar28;
        h0.d dVar8 = new h0.d(uVar6, i36, i22);
        net.time4j.h sECONDS = h.SECONDS;
        bVar2.e(uVar6, dVar8, sECONDS);
        net.time4j.u uVar7 = uVar27;
        h0.d dVar9 = new h0.d(uVar7, i36, 86400);
        bVar2.e(uVar7, dVar9, sECONDS);
        net.time4j.u uVar4 = uVar24;
        h0.d dVar10 = new h0.d(uVar4, i36, 999);
        net.time4j.h mILLIS = h.MILLIS;
        bVar2.e(uVar4, dVar10, mILLIS);
        net.time4j.u uVar5 = uVar23;
        h0.d dVar11 = new h0.d(uVar5, i36, 999999);
        net.time4j.h mICROS = h.MICROS;
        bVar2.e(uVar5, dVar11, mICROS);
        h0.d dVar12 = new h0.d(uVar19, i36, 999999999);
        net.time4j.h nANOS = h.NANOS;
        bVar2.e(uVar19, dVar12, nANOS);
        net.time4j.u uVar11 = uVar26;
        h0.d dVar13 = new h0.d(uVar11, i36, 86400000);
        bVar2.e(uVar11, dVar13, mILLIS);
        final int i59 = 0;
        super(yVar10, i59, obj25, 86400000000L, obj27);
        bVar2.e(yVar10, eVar, mICROS);
        super(yVar9, i59, obj25, 86400000000000L, obj27);
        bVar2.e(yVar9, eVar2, nANOS);
        bVar2.d(mVar2, bVar6);
        bVar2.d(mVar, bVar3);
        bVar2.d(mVar7, bVar);
        h0.h hVar = new h0.h(0);
        bVar2.d(pVar2, hVar);
        h0.P0(bVar2);
        h0.Q0(bVar2);
        h0.g0 = bVar2.h();
    }

    private h0(int i, int i2, int i3, int i4, boolean z5) {
        long l;
        int obj7;
        super();
        h0.l0((long)i);
        h0.m0((long)i2);
        h0.o0((long)i3);
        h0.n0(i4);
        if (z5 != 0 && i == 24) {
            h0.l0((long)i);
            h0.m0((long)i2);
            h0.o0((long)i3);
            h0.n0(i4);
            if (i == 24) {
                if (obj7 |= i4 != 0) {
                } else {
                }
                IllegalArgumentException obj3 = new IllegalArgumentException("T24:00:00 exceeded.");
                throw obj3;
            }
        }
        this.a = (byte)i;
        this.b = (byte)i2;
        this.c = (byte)i3;
        this.v = i4;
    }

    private boolean B0() {
        int i;
        i = i2 |= i4 == 0 ? 1 : 0;
        return i;
    }

    private boolean C0() {
        int i;
        i = b |= i3 == 0 ? 1 : 0;
        return i;
    }

    static Object F0(String string) {
        return h0.c0.get(string);
    }

    public static net.time4j.h0 G0() {
        return h0.F;
    }

    public static net.time4j.h0 H0() {
        return h0.E;
    }

    public static net.time4j.h0 I0(int i) {
        h0.l0((long)i);
        return h0.D[i];
    }

    public static net.time4j.h0 J0(int i, int i2) {
        if (i2 == 0) {
            return h0.I0(i);
        }
        super(i, i2, 0, 0, 1);
        return h0Var2;
    }

    public static net.time4j.h0 K0(int i, int i2, int i3) {
        if (i2 | i3 == 0) {
            return h0.I0(i);
        }
        super(i, i2, i3, 0, 1);
        return h0Var2;
    }

    public static net.time4j.h0 L0(int i, int i2, int i3, int i4) {
        return h0.M0(i, i2, i3, i4, true);
    }

    private static net.time4j.h0 M0(int i, int i2, int i3, int i4, boolean z5) {
        if (i5 |= i4 == 0 && z5) {
            if (z5) {
                return h0.I0(i);
            }
            return h0.D[i];
        }
        super(i, i2, i3, i4, z5);
        return h0Var2;
    }

    public static net.time4j.h0 N0(BigDecimal bigDecimal) {
        return (h0)h0.d0.withValue(0, bigDecimal, false);
    }

    static int O(net.time4j.h0 h0) {
        return h0.v;
    }

    static void O0(StringBuilder stringBuilder, int i2) {
        int length;
        int i3;
        int charAt;
        int i;
        int obj5;
        stringBuilder.append(h0.w);
        String string = Integer.toString(i2);
        charAt = 9;
        obj5 = i2 % i4 == 0 ? 3 : obj5 == null ? 6 : charAt;
        length = string.length();
        while (length < charAt) {
            stringBuilder.append('0');
            length++;
        }
        i3 = 0;
        while (i3 < obj5 -= charAt) {
            stringBuilder.append(string.charAt(i3));
            i3++;
        }
    }

    static net.time4j.h0 P(int i, int i2) {
        return h0.r0(i, i2);
    }

    private static void P0(f0.b<net.time4j.w, net.time4j.h0> f0$b) {
        Class<r> next;
        boolean z;
        Iterator iterator = d.c().g(r.class).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((r)next.d(h0.class)) {
            }
            b.f(next);
        }
        l.c cVar = new l.c();
        b.f(cVar);
    }

    static boolean Q(net.time4j.h0 h0) {
        return h0.B0();
    }

    private static void Q0(f0.b<net.time4j.w, net.time4j.h0> f0$b) {
        int i2;
        net.time4j.h hVar;
        net.time4j.h0.c cVar;
        double length;
        EnumSet set;
        int i;
        final net.time4j.h[] values = h.values();
        i = i2;
        while (i < values.length) {
            hVar = values[i];
            cVar = new h0.c(hVar, 0);
            b.g(hVar, cVar, hVar.getLength(), obj5);
            i++;
        }
    }

    static boolean R(net.time4j.h0 h0) {
        return h0.C0();
    }

    static net.time4j.h0 S(long l, int i2) {
        return h0.q0(l, i2);
    }

    static net.time4j.h0 T(long l) {
        return h0.s0(l);
    }

    static long U(long l, long l2) {
        return h0.v0(l, l2);
    }

    static BigDecimal V() {
        return h0.A;
    }

    static BigDecimal W() {
        return h0.z;
    }

    static BigDecimal X() {
        return h0.y;
    }

    static BigDecimal Y() {
        return h0.x;
    }

    static void Z(long l) {
        h0.m0(l);
    }

    static void a0(long l) {
        h0.o0(l);
    }

    static y b0() {
        return h0.e0;
    }

    static y c0() {
        return h0.f0;
    }

    static long d0(long l, long l2) {
        return h0.u0(l, l2);
    }

    static net.time4j.h0 e0(int i, int i2, int i3, int i4, boolean z5) {
        return h0.M0(i, i2, i3, i4, z5);
    }

    static long f0(net.time4j.h0 h0) {
        return h0.x0();
    }

    static byte g0(net.time4j.h0 h0) {
        return h0.a;
    }

    static byte h0(net.time4j.h0 h0) {
        return h0.b;
    }

    static byte i0(net.time4j.h0 h0) {
        return h0.c;
    }

    private static void j0(int i, StringBuilder stringBuilder2) {
        int i2;
        if (i < 10) {
            stringBuilder2.append('0');
        }
        stringBuilder2.append(i);
    }

    public static f0<net.time4j.w, net.time4j.h0> k0() {
        return h0.g0;
    }

    private static void l0(long l) {
        int cmp;
        if (Long.compare(l, i) < 0) {
        } else {
            if (Long.compare(l, i2) > 0) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HOUR_OF_DAY out of range: ");
        stringBuilder.append(l);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static void m0(long l) {
        int cmp;
        if (Long.compare(l, i) < 0) {
        } else {
            if (Long.compare(l, i2) > 0) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MINUTE_OF_HOUR out of range: ");
        stringBuilder.append(l);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static void n0(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= 1000000000) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NANO_OF_SECOND out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static void o0(long l) {
        int cmp;
        if (Long.compare(l, i) < 0) {
        } else {
            if (Long.compare(l, i2) > 0) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SECOND_OF_MINUTE out of range: ");
        stringBuilder.append(l);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static net.time4j.h0 q0(long l, int i2) {
        final int i = 1000000;
        int obj4 = (int)obj4;
        obj4 /= 60;
        return h0.L0(obj4 /= 60, obj4 % 60, obj4 % 60, i5 += obj6);
    }

    private static net.time4j.h0 r0(int i, int i2) {
        i /= 1000;
        obj2 /= 60;
        return h0.L0(obj2 /= 60, obj2 % 60, obj2 % 60, i4 += i2);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private static net.time4j.h0 s0(long l) {
        int i = 1000000000;
        int obj4 = (int)obj4;
        obj4 /= 60;
        return h0.L0(obj4 /= 60, obj4 % 60, obj4 % 60, (int)i3);
    }

    private static void t0(Map<String, Object> map, p<?> p2) {
        map.put(p2.name(), p2);
    }

    private static long u0(long l, long l2) {
        if (Long.compare(l, i) >= 0) {
            return l /= obj4;
        }
        int i2 = 1;
        return obj2 -= i2;
    }

    private static long v0(long l, long l2) {
        int i;
        int i2;
        if (Long.compare(l, i3) >= 0) {
            i = l / obj6;
        } else {
            int i4 = 1;
            i = i2 - i4;
        }
        return l -= obj6;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 2);
        return spx;
    }

    private long x0() {
        final int i10 = 1000000000;
        return i3 += i9;
    }

    @Override // net.time4j.engine.i0
    public boolean A0(net.time4j.h0 h0) {
        int obj1;
        obj1 = p0(h0) < 0 ? 1 : 0;
        return obj1;
    }

    @Override // net.time4j.engine.i0
    public boolean D0() {
        boolean z;
        int i;
        if (B0() && b %= 24 == 0) {
            i = b %= 24 == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // net.time4j.engine.i0
    public boolean E0(net.time4j.h0 h0) {
        int obj1;
        obj1 = p0(h0) == 0 ? 1 : 0;
        return obj1;
    }

    @Override // net.time4j.engine.i0
    public int I(i0 i0) {
        return p0((h0)i0);
    }

    protected f0<net.time4j.w, net.time4j.h0> J() {
        return h0.g0;
    }

    @Override // net.time4j.engine.i0
    public net.time4j.k R0(long l, net.time4j.h h2) {
        return h0.c.c(this, l, h2);
    }

    @Override // net.time4j.engine.i0
    public int a() {
        return this.v;
    }

    @Override // net.time4j.engine.i0
    public int compareTo(Object object) {
        return p0((h0)object);
    }

    @Override // net.time4j.engine.i0
    public boolean equals(Object object) {
        int i;
        byte b;
        byte b2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof h0) {
            if (this.a == object.a && this.b == object.b && this.c == object.c && this.v == object.v) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.v == object.v) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.engine.i0
    public int hashCode() {
        return i2 += i7;
    }

    @Override // net.time4j.engine.i0
    public int i() {
        return this.b;
    }

    @Override // net.time4j.engine.i0
    public int p0(net.time4j.h0 h0) {
        int i;
        byte b;
        Object obj3;
        if (b2 -= b == 0 && b3 -= b == 0 && b4 -= b == 0) {
            if (b3 -= b == 0) {
                if (b4 -= b == 0) {
                    i2 -= obj3;
                }
            }
        }
        obj3 = i < 0 ? -1 : i == 0 ? 0 : 1;
        return obj3;
    }

    @Override // net.time4j.engine.i0
    public int s() {
        return this.a;
    }

    @Override // net.time4j.engine.i0
    public String toString() {
        int i2;
        int i;
        int i3;
        StringBuilder stringBuilder = new StringBuilder(19);
        stringBuilder.append('T');
        h0.j0(this.a, stringBuilder);
        i2 = 58;
        stringBuilder.append(i2);
        h0.j0(this.b, stringBuilder);
        stringBuilder.append(i2);
        h0.j0(this.c, stringBuilder);
        i2 = this.v;
        if (i6 |= i != 0 && b6 |= i3 != 0 && i2 != 0) {
            i2 = 58;
            stringBuilder.append(i2);
            h0.j0(this.b, stringBuilder);
            if (b6 |= i3 != 0) {
                stringBuilder.append(i2);
                h0.j0(this.c, stringBuilder);
                i2 = this.v;
                if (i2 != 0) {
                    h0.O0(stringBuilder, i2);
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override // net.time4j.engine.i0
    public int u() {
        return this.c;
    }

    @Override // net.time4j.engine.i0
    protected net.time4j.h0 w0() {
        return this;
    }

    @Override // net.time4j.engine.i0
    protected w y() {
        return J();
    }

    boolean y0(p<?> p) {
        boolean l0Var;
        int i;
        net.time4j.l0 obj3;
        if (p == h0.V) {
            if (i2 %= i == 0) {
                if (p == h0.N) {
                    if (B0()) {
                        if (p == h0.P) {
                            if (C0()) {
                                if (p == h0.R) {
                                    if (this.v == 0) {
                                        if (p == h0.W && obj3 %= 1000 != 0) {
                                            obj3 = obj3 %= 1000 != 0 ? 1 : 0;
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // net.time4j.engine.i0
    protected q z() {
        w0();
        return this;
    }

    @Override // net.time4j.engine.i0
    public boolean z0(net.time4j.h0 h0) {
        int obj1;
        obj1 = p0(h0) > 0 ? 1 : 0;
        return obj1;
    }
}
