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
import net.time4j.f1.g;
import net.time4j.g1.b;
import net.time4j.g1.e;
import net.time4j.g1.h;

/* compiled from: PlainTime.java */
@c("iso8601")
/* loaded from: classes3.dex */
public final class h0 extends i0<w, h0> implements g, h {

    private static final BigDecimal A = null;
    private static final BigDecimal B = null;
    private static final BigDecimal C = null;
    private static final h0[] D;
    static final h0 E;
    static final h0 F;
    static final p<h0> G;
    public static final u0 H;
    public static final c1<a0> I;
    public static final c<Integer, h0> J;
    public static final c<Integer, h0> K;
    public static final l0<Integer, h0> L;
    public static final l0<Integer, h0> M;
    public static final l0<Integer, h0> N;
    public static final l0<Integer, h0> O;
    public static final l0<Integer, h0> P;
    public static final l0<Integer, h0> Q;
    public static final l0<Integer, h0> R;
    public static final l0<Integer, h0> S;
    public static final l0<Integer, h0> T;
    public static final l0<Integer, h0> U;
    public static final l0<Integer, h0> V;
    public static final l0<Long, h0> W;
    public static final l0<Long, h0> X;
    public static final c1<BigDecimal> Y = null;
    public static final c1<BigDecimal> Z = null;
    public static final c1<BigDecimal> a0 = null;
    public static final p<h> b0;
    private static final Map<String, Object> c0;
    private static final y<h0, BigDecimal> d0 = null;
    private static final y<h0, BigDecimal> e0 = null;
    private static final y<h0, BigDecimal> f0 = null;
    private static final f0<w, h0> g0;
    private static final long serialVersionUID = 2780881537313863339L;
    static final char w = 44;
    private static final BigDecimal x = new BigDecimal(60);
    private static final BigDecimal y = new BigDecimal(3600);
    private static final BigDecimal z = new BigDecimal(1000000000);
    private final transient byte a;
    private final transient byte b;
    private final transient byte c;
    private final transient int v;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[h.values().length];
            h0.a.a = iArr;
            try {
                iArr[h.HOURS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h0.a.a[h.MINUTES.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h0.a.a[h.SECONDS.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h0.a.a[h.MILLIS.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h0.a.a[h.MICROS.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                h0.a.a[h.NANOS.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static class b implements y<h0, BigDecimal> {

        private final p<BigDecimal> a;
        private final BigDecimal b;
        b(p<BigDecimal> pVar, BigDecimal bigDecimal) {
            super();
            this.a = pVar;
            this.b = bigDecimal;
        }

        private static BigDecimal b(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.divide(bigDecimal2, 16, RoundingMode.FLOOR);
        }

        private static int j(BigDecimal bigDecimal) {
            return Math.min(999999999, bigDecimal.movePointRight(9).setScale(0, RoundingMode.HALF_UP).intValue());
        }

        public BigDecimal f(h0 h0Var) {
            byte b = (byte) 24;
            if (h0Var.a == (byte) 24) {
                return BigDecimal.ZERO;
            }
            return this.b;
        }

        public BigDecimal g(h0 h0Var) {
            return BigDecimal.ZERO;
        }

        public BigDecimal h(h0 h0Var) {
            BigDecimal num2;
            if (this.a == h0.Y) {
                if (h0Var.equals(h0.E)) {
                    return BigDecimal.ZERO;
                }
                byte b6 = (byte) 24;
                if (h0Var.a == b6) {
                    return h0.A;
                }
                BigDecimal num10 = h0.x;
                BigDecimal num11 = h0.y;
                num2 = BigDecimal.valueOf((long)h0Var.a).add(h0.b.b(BigDecimal.valueOf((long)h0Var.b), num10)).add(h0.b.b(BigDecimal.valueOf((long)h0Var.c), num11)).add(h0.b.b(BigDecimal.valueOf((long)h0Var.v), h0.y.multiply(h0.z)));
                return num2.setScale(15, RoundingMode.FLOOR).stripTrailingZeros();
            } else {
                net.time4j.c1 c1Var2 = h0.Z;
                if (this.a == h0.Z) {
                    if (h0Var.B0()) {
                        return BigDecimal.ZERO;
                    }
                    BigDecimal num9 = h0.x;
                    num2 = BigDecimal.valueOf((long)h0Var.b).add(h0.b.b(BigDecimal.valueOf((long)h0Var.c), num9)).add(h0.b.b(BigDecimal.valueOf((long)h0Var.v), h0.x.multiply(h0.z)));
                } else {
                    net.time4j.c1 c1Var3 = h0.a0;
                    if (this.a == h0.a0) {
                        if (h0Var.C0()) {
                            return BigDecimal.ZERO;
                        }
                        num2 = BigDecimal.valueOf((long)h0Var.c).add(h0.b.b(BigDecimal.valueOf((long)h0Var.v), h0.z));
                    }
                }
            }
            throw new UnsupportedOperationException(this.a.name());
        }

        public boolean i(h0 h0Var, BigDecimal bigDecimal) {
            boolean z = false;
            z = false;
            if (bigDecimal == null) {
                return false;
            }
            byte b = (byte) 24;
            final int i = 1;
            if (h0Var.a == (byte) 24) {
                if (this.a == h0.Z || this.a == h0.a0) {
                    if (BigDecimal.ZERO.compareTo(bigDecimal) == 0) {
                    }
                }
                return z;
            }
            if (BigDecimal.ZERO.compareTo(bigDecimal) <= 0) {
                if (this.b.compareTo(bigDecimal) >= 0) {
                }
            }
            return z;
        }

        public h0 k(h0 h0Var, BigDecimal bigDecimal, boolean z) {
            int intValue;
            int i;
            long longValueExact;
            long longValueExact2;
            long l2;
            long l3;
            int intValue2;
            byte b;
            int i2;
            if (bigDecimal == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else {
                int i3 = 0;
                if (this.a == h0.Y) {
                    BigDecimal scale5 = bigDecimal.setScale(i3, RoundingMode.FLOOR);
                    BigDecimal multiply = bigDecimal.subtract(scale5).multiply(h0.x);
                    BigDecimal scale4 = multiply.setScale(i3, RoundingMode.FLOOR);
                    BigDecimal multiply2 = multiply.subtract(scale4).multiply(h0.x);
                    BigDecimal scale = multiply2.setScale(i3, RoundingMode.FLOOR);
                    longValueExact = scale5.longValueExact();
                    intValue2 = scale4.intValue();
                    intValue = scale.intValue();
                    i = h0.b.j(multiply2.subtract(scale));
                    long l = 0L;
                    if (z) {
                        if (RoundingMode.FLOOR > l) {
                            cmp = (c.d(longValueExact, 24)) | intValue2 | intValue | i;
                            if (i2 | intValue2 | intValue | i == 0) {
                                return h0.F;
                            }
                        }
                        return h0.L0(i2, intValue2, intValue, i);
                    } else {
                        if (RoundingMode.FLOOR >= l) {
                            l = 24L;
                            if (RoundingMode.FLOOR <= l) {
                                i2 = (int)longValueExact;
                            }
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Value out of range: ";
                    bigDecimal = str + bigDecimal;
                    throw new IllegalArgumentException(bigDecimal);
                } else {
                    int i4 = 60;
                    if (this.a == h0.Z) {
                        BigDecimal scale2 = bigDecimal.setScale(i3, RoundingMode.FLOOR);
                        BigDecimal multiply3 = bigDecimal.subtract(scale2).multiply(h0.x);
                        scale = multiply3.setScale(i3, RoundingMode.FLOOR);
                        long longValueExact3 = scale2.longValueExact();
                        longValueExact = (long)h0Var.a;
                        if (z) {
                            longValueExact = (long)h0.g0(RoundingMode.FLOOR) + (c.b(longValueExact3, i4));
                            intValue2 = c.d(longValueExact3, i4);
                        } else {
                            longValueExact3.m0(l6);
                            intValue2 = (int)longValueExact3;
                        }
                    } else {
                        if (this.a == h0.a0) {
                            BigDecimal scale3 = bigDecimal.setScale(i3, RoundingMode.FLOOR);
                            longValueExact2 = scale3.longValueExact();
                            longValueExact = (long)h0Var.a;
                            if (z) {
                                intValue = c.d(longValueExact2, i4);
                                l2 = (long)h0Var.b + (c.b(longValueExact2, i4));
                                longValueExact = (long)h0.g0(h0Var.b) + (c.b(l2, i4));
                                int i5 = c.d(l2, i4);
                            } else {
                                longValueExact2.o0(l5);
                                intValue = (int)longValueExact2;
                            }
                        }
                    }
                }
                throw new UnsupportedOperationException(this.a.name());
            }
        }

        public p<?> d(h0 h0Var) {
            return null;
        }

        public p<?> e(h0 h0Var) {
            return null;
        }
    }

    private static class c implements k0<h0> {

        private final h a;
        /* synthetic */ c(h hVar, h0.a aVar) {
            this(hVar);
        }

        static /* synthetic */ k c(h0 h0Var, long j, h hVar) {
            return h0.c.e(h0Var, j, hVar);
        }

        private static k e(h0 h0Var, long j, h hVar) {
            long l = 0L;
            if (j == l) {
                byte b = (byte) 24;
                if (h0Var.a < (byte) 24) {
                    return new k(0L, r1, h0Var);
                }
            }
            return (k)h0.c.g(k.class, hVar, h0Var, j);
        }

        private static <R> R g(Class<R> cls, h hVar, h0 h0Var, long j) {
            int h0Var32;
            byte b;
            int hVar22;
            long l3;
            byte b2 = h0Var.b;
            b = h0Var.c;
            hVar22 = h0Var.v;
            int i6 = h0.a.a[hVar.ordinal()];
            int i10 = 60;
            switch (i6) {
                case 1:
                    l5 = (long)h0.g0(h0Var);
                    l3 = c.f((long)h0.g0(h0Var), j);
                    break;
                case 2:
                    long l2 = c.f((long)h0.h0(h0Var), j);
                    l5 = (long)h0.g0(h0Var);
                    l3 = c.f((long)h0.g0(h0Var), c.b(l2, l16, i10));
                    h0Var32 = c.d(l2, i10);
                    break;
                case 3:
                    long l9 = c.f((long)h0.i0(h0Var), j);
                    l2 = c.f((long)h0.h0(h0Var), c.b(l9, b, i10));
                    l3 = c.f((long)h0.g0(h0Var), c.b(l2, l16, i10));
                    int i5 = c.d(l9, i10);
                    break;
                case 4:
                    return h0.c.g(cls, h.NANOS, h0Var, c.i(j, r15, 1000000, b), r15);
                case 5:
                    return h0.c.g(cls, h.NANOS, h0Var, c.i(j, r15, 1000, b), r15);
                case 6:
                    long l7 = c.f((long)h0.O(h0Var), j);
                    int i12 = 1000000000;
                    long l11 = c.f((long)h0.i0(h0Var), c.b(l7, b, i12));
                    l2 = c.f((long)h0.h0(h0Var), c.b(l11, i6, i10));
                    l3 = c.f((long)h0.g0(h0Var), c.b(l2, l16, i10));
                    break;
                default:
                    throw new UnsupportedOperationException(h.NANOS.name());
            }
            int i13 = 24;
            int i14 = c.d(l3, i13);
            if ((i14 | h0Var32) | b | hVar22 == 0) {
                long l = 0L;
                h0Var = j > l && cls == obj4 ? h0.F : h0.E;
            } else {
                h0Var = h0.L0(i14, h0Var32, b, hVar22);
            }
            if (cls == h0.class) {
                return cls.cast(h0Var);
            }
            return cls.cast(new k(c.b(l3, i13), r15, h0Var));
        }

        public h0 d(h0 h0Var, long j) {
            if (j == 0) {
                return h0Var;
            }
            return (h0)h0.c.g(h0.class, this.a, h0Var, j);
        }

        public long f(h0 h0Var, h0 h0Var2) {
            long l = 3600000000000L;
            switch (h0.a.a[this.a.ordinal()]) {
                case 1: /* ordinal */
                    l = 3600000000000L;
                    break;
                case 2: /* ordinal */
                    l = 60000000000L;
                    break;
                case 3: /* ordinal */
                    int i5 = 1000000000;
                    break;
                case 4: /* ordinal */
                    int i6 = 1000000;
                    break;
                case 5: /* ordinal */
                    int i3 = 1000;
                    break;
                case 6: /* ordinal */
                    int i4 = 1;
                    break;
                default:
                    throw new UnsupportedOperationException(this.a.name());
            }
            return (h0Var2.x0() - h0Var.x0()) / l;
        }

        private c(h hVar) {
            super();
            this.a = hVar;
        }
    }

    private static class d implements y<h0, Integer> {

        private final p<Integer> a;
        private final int b = -1;
        private final int c;
        private final int v;
        d(p<Integer> pVar, int i, int i2) {
            super();
            this.a = pVar;
            if (pVar instanceof u) {
                this.b = pVar.u();
            } else {
                i = -1;
            }
            this.c = i;
            this.v = i2;
        }

        private p<?> b(h0 h0Var) {
            switch (this.b) {
                case 1:
                    return h0.O;
                case 2:
                    return h0.Q;
                case 3:
                    return h0.U;
                default:
                    return null;
            }
        }

        private static boolean i(h0 h0Var) {
            byte b = 24;
            boolean z = false;
            if (h0Var.a >= 12) {
                b = (byte) 24;
                if (h0Var.a == (byte) 24) {
                    int i3 = 1;
                } else {
                    int i2 = 0;
                }
            }
            return z;
        }

        private h0 l(h0 h0Var, int i) {
            net.time4j.l0 l0Var;
            net.time4j.h0 h0Var2;
            net.time4j.h0 h0Var3;
            net.time4j.h0 h0Var4;
            return (h0)h0Var.M((long)(c.l(i, (Integer)h0Var.p(this.a).intValue())), h.HOURS);
        }

        public p<?> d(h0 h0Var) {
            return b(h0Var);
        }

        public p<?> e(h0 h0Var) {
            return b(h0Var);
        }

        public Integer f(h0 h0Var) {
            if (h0Var.a == 24) {
                if (/* condition */) {
                    return null;
                }
            }
            if (h0Var.y0(this.a)) {
                return Integer.valueOf(this.v - 1);
            }
            return Integer.valueOf(this.v);
        }

        public Integer g(h0 h0Var) {
            return Integer.valueOf(this.c);
        }

        public Integer h(h0 h0Var) {
            int i;
            byte b = 24;
            byte b2;
            int i3 = 12;
            switch (this.b) {
                case 1:
                    return Integer.valueOf(b);
                case 2:
                    h0Var2 = h0.g0(h0Var) % 24;
                    return Integer.valueOf(b);
                case 3:
                    int i11 = h0.g0(h0Var) % 12;
                    return Integer.valueOf(b);
                case 4:
                    int i8 = h0.g0(h0Var) % 24;
                    return Integer.valueOf(b);
                case 5:
                    b = h0Var.a;
                    return Integer.valueOf(b);
                case 6:
                    b = h0Var.b;
                    return Integer.valueOf(b);
                case 7:
                    i = h0.g0(h0Var) * 60;
                    b2 = h0Var.b;
                    break;
                case 8:
                    b = h0Var.c;
                    return Integer.valueOf(b);
                case 9:
                    i2 = h0.h0(h0Var) * 60;
                    i = (h0.g0(h0Var) * 3600) + (h0.h0(h0Var) * 60);
                    b2 = h0Var.c;
                    break;
                case 10:
                    i = 1000000;
                    int i12 = h0.O(h0Var) / 1000000;
                    return Integer.valueOf(b);
                case 11:
                    int i9 = h0.O(h0Var) / 1000;
                    return Integer.valueOf(b);
                case 12:
                    int i5 = h0Var.v;
                    return Integer.valueOf(b);
                case 13:
                    int i10 = (int)(h0.f0(h0Var) / 1000000L);
                    return Integer.valueOf(b);
                default:
                    throw new UnsupportedOperationException(this.a.name());
            }
            int i7 = i + b2;
        }

        public boolean j(h0 h0Var, Integer integer) {
            boolean z = false;
            z = false;
            if (integer == null) {
                return false;
            }
            int value = integer.intValue();
            return false;
        }

        public h0 k(h0 h0Var, Integer integer, boolean z) {
            int integer22;
            int i;
            byte b = 12;
            if (integer == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else {
                if (z) {
                    return l(h0Var, integer.intValue());
                }
                if (!j(h0Var, integer)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Value out of range: ";
                    integer = str + integer;
                    throw new IllegalArgumentException(integer);
                } else {
                    b = h0Var.a;
                    byte b2 = h0Var.b;
                    byte b3 = h0Var.c;
                    integer22 = h0Var.v;
                    integer22 = integer.intValue();
                    integer22 = 0;
                    final int i3 = 1000000;
                    switch (this.b) {
                        case 1:
                            integer22 = integer22 + 12;
                            b = (byte) 12;
                            return h0.L0(integer22, integer22, integer22, integer22);
                        case 2:
                            z = 24;
                            return h0.L0(integer22, integer22, integer22, integer22);
                        case 3:
                            integer22 = integer22 + 12;
                            return h0.L0(integer22, integer22, integer22, integer22);
                        case 4:
                            return h0.L0(integer22, integer22, integer22, integer22);
                        case 5:
                            return h0.L0(integer22, integer22, integer22, integer22);
                        case 6:
                            integer22 = integer22 / 60;
                            integer22 = integer22 % 60;
                            return h0.L0(integer22, integer22, integer22, integer22);
                        case 7:
                            return h0.L0(integer22, integer22, integer22, integer22);
                        case 8:
                            integer22 = integer22 / 3600;
                            integer22 = integer22 % 3600;
                            integer22 = integer22 / 60;
                            integer22 = integer22 % 60;
                            return h0.L0(integer22, integer22, integer22, integer22);
                        case 9:
                            integer22 = integer22 * i3;
                            i = h0.O(h0Var) % i3;
                            break;
                        case 10:
                            integer22 = integer22 * 1000;
                            i = h0.O(h0Var) % 1000;
                            break;
                        case 11:
                            return h0.L0(integer22, integer22, integer22, integer22);
                        case 12:
                            return h0.P(integer22, h0.O(h0Var) % i3);
                        default:
                            throw new UnsupportedOperationException(this.a.name());
                    }
                    integer22 = integer22 + i;
                }
            }
        }
    }

    private static class e implements y<h0, Long> {

        private final p<Long> a;
        private final long b;
        private final long c;
        e(p<Long> pVar, long j, long j2) {
            super();
            this.a = pVar;
            this.b = j;
            this.c = j2;
        }

        private h0 j(h0 h0Var, long j) {
            net.time4j.h0 h0Var2;
            net.time4j.h0 h0Var3;
            int cmp2;
            final net.time4j.l0 l0Var = h0.W;
            final long l5 = 0L;
            if (this.a == h0.W) {
                long l4 = j.v0(r8, 86400000000L, h0.W);
                int i2 = h0Var.v % 1000;
                if (l4 == l5 && i2 == 0) {
                    if (j > l5) {
                        h0Var3 = h0.F;
                    } else {
                        h0Var3 = l4.q0(h0.W, i2);
                    }
                }
                return h0Var3;
            }
            long l2 = j.v0(r8, 86400000000000L, h0.W);
            if (l2 == l5) {
                if (j > l5) {
                    h0Var2 = h0.F;
                } else {
                    h0Var2 = l2.s0(h0.W);
                }
            }
            return h0Var2;
        }

        public Long e(h0 h0Var) {
            final net.time4j.l0 l0Var = h0.W;
            if (this.a == h0.W) {
                i = h0Var.v % 1000;
                if (h0.O(h0Var) % 1000 != 0) {
                    return Long.valueOf(this.c - 1L);
                }
            }
            return Long.valueOf(this.c);
        }

        public Long f(h0 h0Var) {
            return Long.valueOf(this.b);
        }

        public Long g(h0 h0Var) {
            long l;
            final net.time4j.l0 l0Var = h0.W;
            if (this.a == h0.W) {
                long l2 = 1000L;
                l = h0Var.x0() / l2;
            } else {
                l = h0Var.x0();
            }
            return Long.valueOf(l);
        }

        public boolean h(h0 h0Var, Long long) {
            boolean z = false;
            z = false;
            if (long == null) {
                return false;
            }
            final int i = 1;
            if (this.a == h0.W && value == this.c) {
                if (h0Var.v % 1000 == 0) {
                }
                return z;
            }
            long value2 = long.longValue();
            if (this.b <= value2) {
                long value3 = long.longValue();
                if (value3 <= this.c) {
                }
            }
            return z;
        }

        public h0 i(h0 h0Var, Long long, boolean z) {
            if (long == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else {
                if (z) {
                    return j(h0Var, long.longValue());
                }
                z = h(h0Var, long);
                if (!z) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Value out of range: ";
                    long = str + long;
                    throw new IllegalArgumentException(long);
                } else {
                    long value = long.longValue();
                    if (this.a == h0.W) {
                        return value.q0(z, h0Var.v % 1000);
                    }
                    return value.s0(z);
                }
            }
        }

        public p<?> b(h0 h0Var) {
            return null;
        }

        public p<?> d(h0 h0Var) {
            return null;
        }
    }

    private static class f implements t<h0> {
        private f() {
            super();
        }

        private static void h(q<?> qVar, String str) {
            final l0 eRROR_MESSAGE2 = l0.ERROR_MESSAGE;
            if (qVar.D(eRROR_MESSAGE2, str)) {
                qVar.G(l0.ERROR_MESSAGE, str);
            }
        }

        private static int j(q<?> qVar) {
            int i = -1;
            int i2 = 0;
            int i3;
            int i4 = qVar.e(h0.M);
            int i6 = Integer.MIN_VALUE;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            int i5 = qVar.e(h0.K);
            i = -1;
            if (i5 == 0) {
                return -1;
            }
            i2 = 0;
            if (i5 == 24) {
                return 0;
            }
            if (i5 != Integer.MIN_VALUE) {
                return i5;
            }
            c1Var = h0.I;
            if (qVar.v(c1Var)) {
                Object obj = qVar.p(h0.I);
                i2 = qVar.e(h0.J);
                if (i2 != Integer.MIN_VALUE) {
                    if (i2 == 0 && obj == a0.AM) {
                        return i;
                    }
                    if (i2 != 12) {
                    }
                    if (obj != a0.AM) {
                        i2 = i2 + 12;
                    }
                    return i2;
                }
                i3 = qVar.e(h0.L);
                if (i3 != Integer.MIN_VALUE && obj == a0.AM) {
                    return i3;
                }
            }
            return Integer.MIN_VALUE;
        }

        private static h0 k(q<?> qVar) {
            int value;
            int value2;
            int value3;
            net.time4j.l0 l0Var = h0.X;
            boolean z4 = qVar.v(l0Var);
            int i = 0;
            if (z4) {
                long value6 = (Long)qVar.p(h0.X).longValue();
                if (value6 >= 0) {
                    return value6.s0(z4);
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                String str8 = "NANO_OF_DAY out of range: ";
                str4 = str8 + value6;
                h0.f.h(qVar, str4);
                return null;
            }
            net.time4j.l0 l0Var2 = h0.W;
            value2 = 0;
            if (qVar.v(l0Var2)) {
                net.time4j.l0 l0Var6 = h0.U;
                if (qVar.v(l0Var6)) {
                    value2 = (Integer)qVar.p(h0.U).intValue() % 1000;
                }
                return (Long)qVar.p(h0.W).longValue().q0(value, value2);
            }
            net.time4j.l0 l0Var3 = h0.V;
            int i3 = 1000000;
            if (qVar.v(l0Var3)) {
                net.time4j.l0 l0Var13 = h0.U;
                if (qVar.v(l0Var13)) {
                    value3 = (Integer)qVar.p(h0.U).intValue();
                    StringBuilder stringBuilder = new StringBuilder();
                    String str5 = "NANO_OF_SECOND out of range: ";
                    str = str5 + value3;
                    h0.f.h(qVar, str);
                    return i;
                }
                net.time4j.l0 l0Var14 = h0.T;
                if (qVar.v(l0Var14)) {
                    value3 = (Integer)qVar.p(h0.T).intValue();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str6 = "MICRO_OF_SECOND out of range: ";
                    str2 = str6 + value3;
                    h0.f.h(qVar, str2);
                    return i;
                }
                int value5 = (Integer)qVar.p(h0.V).intValue();
                StringBuilder stringBuilder3 = new StringBuilder();
                String str7 = "MILLI_OF_DAY out of range: ";
                str3 = str7 + value5;
                h0.f.h(qVar, str3);
                return i;
            }
            net.time4j.l0 l0Var4 = h0.R;
            if (qVar.v(l0Var4)) {
                net.time4j.l0 l0Var10 = h0.U;
                if (qVar.v(l0Var10)) {
                    value2 = (Integer)qVar.p(h0.U).intValue();
                } else {
                    net.time4j.l0 l0Var11 = h0.T;
                    if (qVar.v(l0Var11)) {
                        value2 = (Integer)qVar.p(h0.T).intValue() * 1000;
                    } else {
                        net.time4j.l0 l0Var12 = h0.S;
                        if (qVar.v(l0Var12)) {
                            value2 = (Integer)qVar.p(h0.S).intValue() * i3;
                        } else {
                        }
                    }
                }
                return (h0)h0.L0(value2, value2, value2, value2).G(h0.R, qVar.p(h0.R));
            }
            net.time4j.l0 l0Var5 = h0.P;
            if (qVar.v(l0Var5)) {
                net.time4j.l0 l0Var7 = h0.U;
                if (qVar.v(l0Var7)) {
                    value2 = (Integer)qVar.p(h0.U).intValue();
                } else {
                    net.time4j.l0 l0Var8 = h0.T;
                    if (qVar.v(l0Var8)) {
                        value2 = (Integer)qVar.p(h0.T).intValue() * 1000;
                    } else {
                        net.time4j.l0 l0Var9 = h0.S;
                        if (qVar.v(l0Var9)) {
                            value2 = (Integer)qVar.p(h0.S).intValue() * i3;
                        } else {
                        }
                    }
                }
                net.time4j.l0 l0Var15 = h0.Q;
                if (qVar.v(l0Var15)) {
                    value2 = (Integer)qVar.p(h0.Q).intValue();
                } else {
                }
                return (h0)h0.L0(value2, value2, value2, value2).G(h0.P, qVar.p(h0.P));
            }
            return i;
        }

        public d0 a() {
            return d0.a;
        }

        public int d() {
            return g0.t0().d();
        }

        public String f(x xVar, Locale locale) {
            return b.t(e.ofStyle(xVar.getStyleValue()), locale);
        }

        public h0 g(q<?> qVar, net.time4j.engine.d dVar, boolean z, boolean z2) {
            int i3;
            int i5;
            int i4 = -2;
            int i6;
            int i7 = 12;
            int i8;
            if (qVar instanceof f) {
                return (i0)i0.U().D(qVar, dVar, z, z2).Z();
            }
            p pVar2 = h0.G;
            if (qVar.v(pVar2)) {
                return (h0)qVar.p(h0.G);
            }
            net.time4j.c1 c1Var3 = h0.Y;
            if (qVar.v(c1Var3)) {
                return h0.N0((BigDecimal)qVar.p(h0.Y));
            }
            int i16 = 24;
            int i9 = 0;
            z = false;
            int i = Integer.MIN_VALUE;
            if (qVar.e(h0.N) == Integer.MIN_VALUE) {
                i7 = h0.f.j(qVar);
                if (i7 == Integer.MIN_VALUE) {
                    return h0.f.k(qVar);
                }
                int i2 = -1;
                i4 = -2;
                if (!(i7 != i2 || i7 == -2)) {
                    if (z && i7 == i2) {
                        i7 = z;
                    }
                }
                h0.f.h(qVar, "Clock hour cannot be zero.");
                return null;
            }
            net.time4j.c1 c1Var = h0.Z;
            if (qVar.v(c1Var)) {
                return (h0)h0.e0.withValue(h0.I0(i7), qVar.p(h0.Z), z);
            }
            if (qVar.e(h0.O) == Integer.MIN_VALUE) {
            }
            net.time4j.c1 c1Var2 = h0.a0;
            if (qVar.v(c1Var2)) {
                return (h0)h0.f0.withValue(h0.J0(i7, i3), qVar.p(h0.a0), z);
            }
            if (qVar.e(h0.Q) == Integer.MIN_VALUE) {
            }
            if (qVar.e(h0.U) == Integer.MIN_VALUE) {
                int i13 = qVar.e(h0.T);
                if (i13 != Integer.MIN_VALUE) {
                    i = 1000;
                    i6 = c.h(i13, i);
                } else {
                    int i14 = qVar.e(h0.S);
                    if (i14 == Integer.MIN_VALUE) {
                    } else {
                        i = 1000000;
                        i6 = c.h(i14, i);
                    }
                }
            }
            if (h0.e0) {
                long l13 = c.f(c.i(c.f(c.f(c.i((long)i7, 3600L), c.i((long)i3, 60L)), (long)i5), 1000000000L), (long)i6);
                long l5 = 86400000000000L;
                long l7 = l13.v0(z, l5, z);
                long l14 = l13.u0(z, l5, z);
                long l6 = 0L;
                if (l14 != l6 && qVar.C(y.v, l14, h0.e0)) {
                    qVar.F(y.v, l14);
                }
                if (l7 == l6 && l14 > l6) {
                    return h0.F;
                }
                return l7.s0(i3);
            }
            if (h0.G >= 0 && h0.O >= 0 && h0.Q >= 0 && h0.S >= 0 && h0.G == i16) {
                i8 = (i3 | i5) | i6;
                i8 = 59;
                return h0.M0(i7, i3, i5, i6, z);
            }
            h0.f.h(qVar, "Time component out of range.");
            return i9;
        }

        /* synthetic */ f(h0.a aVar) {
            this();
        }

        public w<?> b() {
            return null;
        }

        public o i(h0 h0Var, net.time4j.engine.d dVar) {
            return h0Var;
        }
    }

    private static class g implements y<h0, a0> {
        private g() {
            super();
        }

        public p<?> b(h0 h0Var) {
            return h0.L;
        }

        public p<?> d(h0 h0Var) {
            return h0.L;
        }

        public a0 e(h0 h0Var) {
            return a0.PM;
        }

        public a0 f(h0 h0Var) {
            return a0.AM;
        }

        public a0 g(h0 h0Var) {
            return a0.ofHour(h0Var.a);
        }

        public h0 i(h0 h0Var, a0 a0Var, boolean z) {
            byte b = 0;
            if (h0Var.a == 24) {
                b = (byte) 0;
            } else {
                b = h0Var.a;
            }
            if (a0Var == null) {
                throw new IllegalArgumentException("Missing am/pm-value.");
            } else {
                final byte b3 = (byte) 12;
                if (a0Var == a0.AM) {
                    if (h0Var.a >= b3) {
                        b -= 12;
                    }
                } else {
                    if (a0Var == a0.PM && h0Var.a < b3) {
                        b += 12;
                    }
                }
                return h0.L0(b, h0Var.b, h0Var.c, h0Var.v);
            }
        }

        /* synthetic */ g(h0.a aVar) {
            this();
        }

        public boolean h(h0 h0Var, a0 a0Var) {
            boolean z = true;
            h0Var = a0Var != null ? 1 : 0;
            return (a0Var != null ? 1 : 0);
        }
    }

    private static class h implements y<h0, h> {
        private h() {
            super();
        }

        public h e(h0 h0Var) {
            return h.NANOS;
        }

        public h f(h0 h0Var) {
            return h.HOURS;
        }

        public h g(h0 h0Var) {
            if (h0Var.v != 0) {
                if (h0Var.v % 1000000 == 0) {
                    return h.MILLIS;
                }
                if (h0Var.v % 1000 == 0) {
                    return h.MICROS;
                }
                return h.NANOS;
            }
            if (h0Var.c != 0) {
                return h.SECONDS;
            }
            if (h0Var.b != 0) {
                return h.MINUTES;
            }
            return h.HOURS;
        }

        public h0 i(h0 h0Var, h hVar, boolean z) {
            if (hVar == null) {
                throw new IllegalArgumentException("Missing precision value.");
            } else {
                if (hVar.ordinal() >= g(h0Var).ordinal()) {
                    return h0Var;
                }
                switch (h0.a.a[hVar.ordinal()]) {
                    case 1: /* ordinal */
                        return h0.I0(h0.g0(h0Var));
                    case 2: /* ordinal */
                        return h0.J0(h0.g0(h0Var), h0.h0(h0Var));
                    case 3: /* ordinal */
                        return h0.K0(h0.g0(h0Var), h0.h0(h0Var), h0.i0(h0Var));
                    case 4: /* ordinal */
                        final int i = 1000000;
                        return h0.L0(h0.g0(h0Var), h0.h0(h0Var), h0.i0(h0Var), h0.O(h0Var) / i * i);
                    case 5: /* ordinal */
                        return h0.L0(h0.g0(h0Var), h0.h0(h0Var), h0.i0(h0Var), h0.O(h0Var) / 1000 * 1000);
                    case 6: /* ordinal */
                        return h0Var;
                    default:
                        throw new UnsupportedOperationException(hVar.name());
                }
            }
        }

        /* synthetic */ h(h0.a aVar) {
            this();
        }

        public p<?> b(h0 h0Var) {
            return null;
        }

        public p<?> d(h0 h0Var) {
            return null;
        }

        public boolean h(h0 h0Var, h hVar) {
            boolean z = true;
            h0Var = hVar != null ? 1 : 0;
            return (hVar != null ? 1 : 0);
        }
    }

    private static class i implements y<h0, h0> {
        private i() {
            super();
        }

        public h0 e(h0 h0Var) {
            return h0.F;
        }

        public h0 f(h0 h0Var) {
            return h0.E;
        }

        public h0 i(h0 h0Var, h0 h0Var2, boolean z) {
            if (h0Var2 == null) {
                throw new IllegalArgumentException("Missing time value.");
            } else {
                return h0Var2;
            }
        }

        /* synthetic */ i(h0.a aVar) {
            this();
        }

        public p<?> b(h0 h0Var) {
            return null;
        }

        public p<?> d(h0 h0Var) {
            return null;
        }

        public h0 g(h0 h0Var) {
            return h0Var;
        }

        public boolean h(h0 h0Var, h0 h0Var2) {
            boolean z = true;
            h0Var = h0Var2 != null ? 1 : 0;
            return (h0Var2 != null ? 1 : 0);
        }
    }
    static {
        int i;
        int r0 = Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? 46 : 44;
    }

    private h0(int i, int i2, int i3, int i4, boolean z) {
        super();
        if (z) {
            h0.l0((long)i);
            h0.m0((long)i2);
            l = (long)i3;
            h0.o0(l);
            h0.n0(i4);
            int i5 = 24;
            if (i == 24) {
                i5 = (i2 | i3) | i4;
                if (i2 | i3 | i4 != 0) {
                    throw new IllegalArgumentException("T24:00:00 exceeded.");
                }
            }
        }
        this.a = (byte)i;
        this.b = (byte)i2;
        this.c = (byte)i3;
        this.v = i4;
    }

    private boolean B0() {
        boolean z = true;
        int r0 = (this.b | this.c) | this.v == 0 ? 1 : 0;
        return ((this.b | this.c) | this.v == 0 ? 1 : 0);
    }

    private boolean C0() {
        boolean z = true;
        int r0 = this.c | this.v == 0 ? 1 : 0;
        return (this.c | this.v == 0 ? 1 : 0);
    }

    static Object F0(String str) {
        return h0.c0.get(str);
    }

    public static h0 G0() {
        return h0.F;
    }

    public static h0 H0() {
        return h0.E;
    }

    public static h0 I0(int i) {
        h0.l0((long)i);
        return h0.D[i];
    }

    public static h0 J0(int i, int i2) {
        if (i2 == 0) {
            return h0.I0(i);
        }
        h0 h0Var = new h0(i, i2, 0, 0, true);
        return h0Var;
    }

    public static h0 K0(int i, int i2, int i3) {
        if (i2 | i3 == 0) {
            return h0.I0(i);
        }
        h0 h0Var = new h0(i, i2, i3, 0, true);
        return h0Var;
    }

    public static h0 L0(int i, int i2, int i3, int i4) {
        return h0.M0(i, i2, i3, i4, true);
    }

    private static h0 M0(int i, int i2, int i3, int i4, boolean z) {
        if ((i2 | i3) | i4 == 0 && z) {
            return h0.I0(i);
        }
        h0 h0Var = new h0(i, i2, i3, i4, z);
        return h0Var;
    }

    public static h0 N0(BigDecimal bigDecimal) {
        return (h0)h0.d0.withValue(null, bigDecimal, false);
    }

    static /* synthetic */ int O(h0 h0Var) {
        return h0Var.v;
    }

    static void O0(StringBuilder sb, int i) {
        int length;
        int i3 = 6;
        sb.append(h0.w);
        String integer = Integer.toString(i);
        i3 = 9;
        if (i % 1000000 == 0) {
            i3 = 3;
        } else {
            i = i % 1000 == 0 ? 6 : i3;
        }
        length = integer.length();
        while (length < i3) {
            char c = '0';
            sb.append(c);
            length = length + 1;
        }
        i = 0;
        while (i < (i3 + integer.length()) - i3) {
            sb.append(integer.charAt(i));
            i = i + 1;
        }
    }

    static /* synthetic */ h0 P(int i, int i2) {
        return h0.r0(i, i2);
    }

    private static void P0(f0.b<w, h0> bVar) {
        item = r.class;
        Iterator it = d.c().g(item).iterator();
        while (it.hasNext()) {
            Class<r> item = it.next();
        }
        bVar.f(new l.c());
    }

    static /* synthetic */ boolean Q(h0 h0Var) {
        return h0Var.B0();
    }

    private static void Q0(f0.b<w, h0> bVar) {
        int bVar2;
        final net.time4j.h[] values = h.values();
        bVar2 = 0;
        for (net.time4j.h hVar : values) {
            bVar.g(hVar, new h0.c(hVar, null), hVar.getLength(), allOf);
        }
    }

    static /* synthetic */ boolean R(h0 h0Var) {
        return h0Var.C0();
    }

    static /* synthetic */ h0 S(long j, int i) {
        return h0.q0(j, i);
    }

    static /* synthetic */ h0 T(long j) {
        return h0.s0(j);
    }

    static /* synthetic */ long U(long j, long j2) {
        return h0.v0(j, j2);
    }

    static /* synthetic */ BigDecimal V() {
        return h0.A;
    }

    static /* synthetic */ BigDecimal W() {
        return h0.z;
    }

    static /* synthetic */ BigDecimal X() {
        return h0.y;
    }

    static /* synthetic */ BigDecimal Y() {
        return h0.x;
    }

    static /* synthetic */ void Z(long j) {
        h0.m0(j);
    }

    static /* synthetic */ void a0(long j) {
        h0.o0(j);
    }

    static /* synthetic */ y b0() {
        return h0.e0;
    }

    static /* synthetic */ y c0() {
        return h0.f0;
    }

    static /* synthetic */ long d0(long j, long j2) {
        return h0.u0(j, j2);
    }

    static /* synthetic */ h0 e0(int i, int i2, int i3, int i4, boolean z) {
        return h0.M0(i, i2, i3, i4, z);
    }

    static /* synthetic */ long f0(h0 h0Var) {
        return h0Var.x0();
    }

    static /* synthetic */ byte g0(h0 h0Var) {
        return h0Var.a;
    }

    static /* synthetic */ byte h0(h0 h0Var) {
        return h0Var.b;
    }

    static /* synthetic */ byte i0(h0 h0Var) {
        return h0Var.c;
    }

    private static void j0(int i, StringBuilder sb) {
        int i2 = 10;
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
    }

    public static f0<w, h0> k0() {
        return h0.g0;
    }

    private static void l0(long j) {
        if (j < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "HOUR_OF_DAY out of range: ";
            j = str + j;
            throw new IllegalArgumentException(j);
        } else {
            if (j <= 24) {
                return;
            }
        }
    }

    private static void m0(long j) {
        if (j < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "MINUTE_OF_HOUR out of range: ";
            j = str + j;
            throw new IllegalArgumentException(j);
        } else {
            if (j <= 59) {
                return;
            }
        }
    }

    private static void n0(int i) {
        if (i < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "NANO_OF_SECOND out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 1000000000;
            if (i < 1000000000) {
                return;
            }
        }
    }

    private static void o0(long j) {
        if (j < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "SECOND_OF_MINUTE out of range: ";
            j = str + j;
            throw new IllegalArgumentException(j);
        } else {
            if (j <= 59) {
                return;
            }
        }
    }

    private static h0 q0(long j, int i) {
        final long l = 1000000L;
        int i5 = (int)(j / l);
        i5 /= 60;
        return h0.L0(i6 / 60, i6 % 60, i5 % 60, (int)(j % l) * 1000 + i);
    }

    private static h0 r0(int i, int i2) {
        i /= 1000;
        int i9 = i8 / 60;
        return h0.L0(i9 / 60, i9 % 60, i8 % 60, (i % 1000) * 1000000 + i2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static h0 s0(long j) {
        long l = 1000000000L;
        int i3 = (int)(j / l);
        i3 /= 60;
        return h0.L0(i4 / 60, i4 % 60, i3 % 60, (int)(j % l));
    }

    private static void t0(Map<String, Object> map, p<?> pVar) {
        map.put(pVar.name(), pVar);
    }

    private static long u0(long j, long j2) {
        if (j >= 0) {
            return j / j2;
        }
        long l = 1L;
        return (j + l) / j2 - l;
    }

    private static long v0(long j, long j2) {
        long l;
        if (j >= 0) {
            l = j / j2;
        } else {
            long l3 = 1L;
            l2 = (j + l3) / j2;
            l = l2 - l3;
        }
        return j - (j2 * l);
    }

    private Object writeReplace() {
        return new SPX(this, 2);
    }

    private long x0() {
        final long l13 = 1000000000L;
        return (long)this.v + (long)this.c * l13 + (long)this.b * 60L * l13 + (long)this.a * 3600L * l13;
    }

    @Override // net.time4j.engine.i0
    public boolean A0(h0 h0Var) {
        boolean z = true;
        h0Var = p0(h0Var) < 0 ? 1 : 0;
        return (p0(h0Var) < 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    public boolean D0() {
        boolean z2 = false;
        if (B0()) {
            int r0 = this.a % 24 == 0 ? 1 : 0;
        }
        return (this.a % 24 == 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    public boolean E0(h0 h0Var) {
        boolean z = true;
        h0Var = p0(h0Var) == 0 ? 1 : 0;
        return (p0(h0Var) == 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    protected f0<w, h0> J() {
        return h0.g0;
    }

    @Override // net.time4j.engine.i0
    public k R0(long j, h hVar) {
        return this.e(j, r2, hVar);
    }

    @Override // net.time4j.engine.i0
    public int a() {
        return this.v;
    }

    @Override // net.time4j.engine.i0
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
        if (object instanceof h0) {
            if (this.a == object.a) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.v != object.v) {
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.engine.i0
    public int hashCode() {
        return (this.a + (this.b * 60)) + (this.c * 3600) + (this.v * 37);
    }

    @Override // net.time4j.engine.i0
    public int i() {
        return this.b;
    }

    @Override // net.time4j.engine.i0
    public int p0(h0 h0Var) {
        int i;
        int i3 = 0;
        i = this.a - h0Var.a;
        if (this.a - h0Var.a == 0 && this.b - h0Var.b == 0 && this.c - h0Var.c == 0) {
            i = this.v - h0Var.v;
        }
        if (this.a - h0Var.a < 0) {
            i3 = -1;
        } else {
            h0Var = this.a - h0Var.a == 0 ? 0 : 1;
        }
        return (this.a - h0Var.a == 0 ? 0 : 1);
    }

    @Override // net.time4j.engine.i0
    public int s() {
        return this.a;
    }

    @Override // net.time4j.engine.i0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(19);
        stringBuilder.append('T');
        h0.j0(this.a, stringBuilder);
        i = (this.b | this.c) | this.v;
        if (this.b | this.c | this.v != 0) {
            char c = ':';
            stringBuilder.append(c);
            h0.j0(this.b, stringBuilder);
            i2 = this.c | this.v;
            if (this.c | this.v != 0) {
                stringBuilder.append(c);
                h0.j0(this.c, stringBuilder);
                if (this.v != 0) {
                    h0.O0(stringBuilder, this.v);
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
    boolean y0(p<?> pVar) {
        boolean z;
        int i = 1000000;
        boolean z2 = true;
        if (pVar == h0.V) {
            i = 1000000;
            if (this.v % i != 0 || pVar == h0.N) {
                int i6 = 1;
            } else {
                if (!(!B0() || pVar == h0.P)) {
                    if (!(!C0() || pVar == h0.R)) {
                        if (!(this.v != 0 || pVar == h0.W)) {
                            i2 = this.v % 1000;
                            pVar = this.v % 1000 != 0 ? 1 : 0;
                        }
                    }
                }
            }
        }
        return (this.v % 1000 != 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    public boolean z0(h0 h0Var) {
        boolean z = true;
        h0Var = p0(h0Var) > 0 ? 1 : 0;
        return (p0(h0Var) > 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    protected h0 w0() {
        return this;
    }
}
