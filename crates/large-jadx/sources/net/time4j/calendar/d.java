package net.time4j.calendar;

import net.time4j.b0;
import net.time4j.calendar.s.b;
import net.time4j.calendar.s.c;
import net.time4j.calendar.s.d;
import net.time4j.engine.k;
import net.time4j.engine.m;
import net.time4j.engine.z;
import net.time4j.f1.c;
import net.time4j.g0;
import net.time4j.i0;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
abstract class d<D extends net.time4j.calendar.f<?, D>>  implements k<D> {

    private static final long a;
    private static final long b;
    private static final long c;
    static {
        int i4 = 1;
        d.a = g0.K0(1645, i4, 28).c();
        d.b = g0.K0(3000, i4, 27).c();
        d.c = g0.K0(-2636, 2, 15).c();
    }

    private long f(int i, int i2, net.time4j.calendar.h h3) {
        long obj3 = p(obj3 += l);
        if (h3.equals(v(obj3).e0())) {
            return obj3;
        }
        return p(obj3 += i5);
    }

    private boolean j(long l, long l2) {
        boolean cmp;
        long obj2;
        long obj4;
        if (Long.compare(obj4, l) >= 0) {
            if (!k(obj4)) {
                obj2 = j(l, l2) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private static long m(long l, long l2) {
        return Math.round(obj0 /= obj2);
    }

    private long o(long l) {
        return d.NEW_MOON.before(n(l)).w0(i(l)).h0().c();
    }

    private long r(long l) {
        boolean obj9;
        obj9 = w(l);
        final int i4 = 1;
        obj9 = p(obj9 += i4);
        long l5 = p(obj9 + i4);
        if (Long.compare(l4, i7) == 0 && !k(obj9) && k(l5)) {
            if (!k(obj9)) {
                if (k(l5)) {
                }
            }
            return p(l5 += i4);
        }
        return l5;
    }

    private long s(long l) {
        long l2 = r(l);
        if (Long.compare(l, l2) >= 0) {
            return l2;
        }
        return r(l -= i);
    }

    private long w(long l) {
        int i;
        g0 g0Var;
        boolean obj4;
        int obj5;
        final p pVar = i(l);
        obj4 = g0.P0(l, obj5);
        if (obj4.o() > 11) {
            if (obj4.q() <= 15) {
                obj5--;
            } else {
                obj5 = obj4.m();
            }
        } else {
        }
        b wINTER_SOLSTICE = b.WINTER_SOLSTICE;
        if (wINTER_SOLSTICE.inYear(obj5).w0(pVar).X().R(obj4)) {
            g0Var = wINTER_SOLSTICE.inYear(obj5--).w0(pVar).X();
        }
        return g0Var.c();
    }

    @Override // net.time4j.engine.k
    public Object a(long l) {
        return v(l);
    }

    @Override // net.time4j.engine.k
    public long b(Object object) {
        return u((f)object);
    }

    @Override // net.time4j.engine.k
    public final long c() {
        return d.b;
    }

    @Override // net.time4j.engine.k
    public long d() {
        return d.a;
    }

    abstract D e(int i, int i2, net.time4j.calendar.h h3, int i4, long l5);

    @Override // net.time4j.engine.k
    final int g(int i, int i2) {
        int i4;
        int i3;
        int length;
        int obj6;
        final int[] iArr = h();
        obj5--;
        final int i8 = 2;
        i7 *= i8;
        while (i4 < iArr.length) {
            length = iArr[i4];
            if (length >= obj5) {
                break;
            } else {
            }
            i4 += i3;
        }
        return obj6;
    }

    @Override // net.time4j.engine.k
    abstract int[] h();

    @Override // net.time4j.engine.k
    abstract p i(long l);

    @Override // net.time4j.engine.k
    final boolean k(long l) {
        int obj7;
        final long l2 = 4629137466983448576L;
        obj7 = i3 %= 12 == obj7 %= 12 ? 1 : 0;
        return obj7;
    }

    @Override // net.time4j.engine.k
    boolean l(int i, int i2, net.time4j.calendar.h h3, int i4) {
        int i7;
        int i3;
        boolean number;
        int i5;
        int i6;
        i3 = 72;
        number = 94;
        i5 = 1;
        if (i >= i3 && i <= number && i2 >= i5 && i2 <= 60) {
            number = 94;
            if (i <= number) {
                i5 = 1;
                if (i2 >= i5) {
                    if (i2 <= 60) {
                        if (i == i3) {
                            if (i2 >= 22) {
                                if (i == number) {
                                    i3 = 30;
                                    if (i2 <= 56 && i4 >= i5 && i4 <= i3 && h3 != null) {
                                        if (i4 >= i5) {
                                            i3 = 30;
                                            if (i4 <= i3) {
                                                if (h3 != null) {
                                                    if (h3.e() && h3.getNumber() != g(i, i2)) {
                                                        if (h3.getNumber() != g(i, i2)) {
                                                        } else {
                                                            long obj6 = f(i, i2, h3);
                                                            if (i4 == i3 && Long.compare(obj8, obj6) == 0) {
                                                                obj6 = f(i, i2, h3);
                                                                if (Long.compare(obj8, obj6) == 0) {
                                                                    i7 = i5;
                                                                }
                                                                return i7;
                                                            }
                                                        }
                                                    } else {
                                                    }
                                                    return i5;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override // net.time4j.engine.k
    b0 n(long l) {
        return g0.P0(l, obj3).s0().S(i(l));
    }

    @Override // net.time4j.engine.k
    final long p(long l) {
        return d.NEW_MOON.atOrAfter(n(l)).w0(i(l)).h0().c();
    }

    @Override // net.time4j.engine.k
    final long q(int i, int i2) {
        return s((long)obj5);
    }

    @Override // net.time4j.engine.k
    final long t(int i, int i2, net.time4j.calendar.h h3, int i4) {
        if (!l(i, i2, h3, i4)) {
        } else {
            return obj2 -= obj4;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Invalid date.");
        throw obj2;
    }

    public final long u(D d) {
        return t(d.Y(), d.i0().getNumber(), d.e0(), d.q());
    }

    public final D v(long l) {
        long l3;
        int i;
        net.time4j.calendar.h hVar;
        boolean z;
        int i3;
        long l2;
        long l4;
        int i2;
        final Object obj2 = this;
        long l5 = w(l);
        int i12 = 1;
        l3 = obj2.p(l5 += i12);
        l2 = obj2.o(l + i12);
        int i10 = 1;
        i = Long.compare(l8, i15) == 0 ? i10 : 0;
        if (i != 0 && obj2.j(l3, obj1)) {
            if (obj2.j(l3, obj1)) {
                l4 -= i12;
            }
        }
        int i16 = c.d(l4, obj11);
        if (i16 == 0) {
        } else {
            i3 = i16;
        }
        long l11 = (long)floor;
        i2 = 60;
        int i19 = c.d(l11, obj11);
        if (i19 == 0) {
        } else {
            i2 = i19;
        }
        if (i != 0 && obj2.k(l2) && !obj2.j(l3, obj1)) {
            if (obj2.k(l2)) {
                if (!obj2.j(l3, obj1)) {
                    hVar = l3;
                }
            }
        }
        return this.e(i10 += i26, i2, hVar, (int)i21, l);
    }
}
