package net.time4j.calendar;

import net.time4j.b0;
import net.time4j.calendar.s.b;
import net.time4j.calendar.s.d;
import net.time4j.engine.k;
import net.time4j.engine.m;
import net.time4j.engine.z;
import net.time4j.g0;
import net.time4j.i0;
import net.time4j.tz.p;

/* compiled from: EastAsianCS.java */
/* loaded from: classes3.dex */
abstract class d<D extends f<?, D>> implements k<D> {

    private static final long a = 0L;
    private static final long b = 0L;
    private static final long c = 0L;
    static {
        int i4 = 1;
        d.a = g0.K0(1645, i4, 28).c();
        d.b = g0.K0(3000, i4, 27).c();
        d.c = g0.K0(-2636, 2, 15).c();
    }

    d() {
        super();
    }

    private long f(int i, int i2, h hVar) {
        long l4 = p((q(i, i2)) + (long)(hVar.getNumber() - 1) * 29);
        if (hVar.equals(v(l4).e0())) {
            return l4;
        }
        return p(l4 + 1L);
    }

    private boolean j(long j, long j2) {
        int cmp;
        boolean z3 = true;
        long l;
        if (j2 < j || !this.k(j2, r5)) {
            int i2 = 0;
        } else {
            j = j(j, o(j2)) ? 1 : 0;
        }
        return (j(j, o(j2)) ? 1 : 0);
    }

    private static long m(long j, long j2) {
        return Math.round((double)(j2 - j) / 29.530588861d);
    }

    private long o(long j) {
        return d.NEW_MOON.before(n(j)).w0(i(j)).h0().c();
    }

    private long r(long j) {
        long l11 = w(j);
        final long l7 = 1L;
        long l = p(l11 + l7);
        long l9 = p(l + l7);
        long l6 = d.m(l, o((w(370L + l11)) + l7));
        if (l6 == 12 && !this.k(l, r10) && this.k(l9, obj2)) {
            return p(l9 + 1L);
        }
        return l9;
    }

    private long s(long j) {
        long l = r(j);
        if (j >= l) {
            return l;
        }
        return r(j - 180L);
    }

    private long w(long j) {
        int i = 11;
        g0 g0Var;
        int i3;
        final p pVar = i(j);
        g0 g0Var2 = g0.P0(j, z.UTC);
        i = 11;
        if (g0Var2.o() > 11) {
            i = 15;
            if (g0Var2.q() <= 15) {
                i3 = g0Var2.m() - 1;
            } else {
                i3 = g0Var2.m();
            }
        }
        b wINTER_SOLSTICE2 = b.WINTER_SOLSTICE;
        if (wINTER_SOLSTICE2.inYear(i3).w0(pVar).X().R(g0Var2)) {
            i3 = i3 - 1;
            g0Var = b.WINTER_SOLSTICE.inYear(i3).w0(pVar).X();
        }
        return g0Var.c();
    }

    public final long c() {
        return d.b;
    }

    public long d() {
        return d.a;
    }

    final int g(int i, int i2) {
        int i3;
        int i4 = 0;
        final int[] iArr = h();
        int i15 = (i - 1) * 60 + i2 - 1;
        i4 = 0;
        final int i8 = 2;
        i3 = (i15 - iArr[i4]) / 3 * i8;
        length = iArr.length;
        for (int length : iArr) {
            if (length >= i15) {
            }
        }
        return i4;
    }

    final boolean k(long j) {
        boolean z = true;
        final double d4 = 30d;
        j = (int)(Math.floor(o.solarLongitude(c.h(n(j)).d()) / d4)) + 2 % 12 == (int)(Math.floor((o.solarLongitude(c.h(n(p(j + 1L))).d())) / d4)) + 2 % 12 ? 1 : 0;
        return ((int)(Math.floor(o.solarLongitude(c.h(n(j)).d()) / d4)) + 2 % 12 == (int)(Math.floor((o.solarLongitude(c.h(n(p(j + 1L))).d())) / d4)) + 2 % 12 ? 1 : 0);
    }

    boolean l(int i, int i2, h hVar, int i3) {
        boolean z = false;
        int i5 = 72;
        z = false;
        i5 = 72;
        if (i >= i5 && i <= number && i2 >= i3 && i2 <= 60 && i == i5 && i2 >= 22 && i == number && i2 <= 56 && i3 >= i3 && i3 <= i5 && hVar != null && hVar.e()) {
            if (hVar.getNumber() == g(i, i2)) {
                if (i3 == i5) {
                    long l = f(i, i2, hVar);
                    long l4 = (p(1L + l)) - l;
                    if (l4 == 30) {
                    }
                    return z;
                }
            }
            return true;
        }
        return false;
    }

    b0 n(long j) {
        return g0.P0(j, z.UTC).s0().S(i(j));
    }

    final long p(long j) {
        return d.NEW_MOON.atOrAfter(n(j)).w0(i(j)).h0().c();
    }

    final long q(int i, int i2) {
        return s((long)(Math.floor((double)d.c + (double)(i - 1) * 60 + i2 - 0.5d * 365.242189d)));
    }

    final long t(int i, int i2, h hVar, int i3) {
        if (!l(i, i2, hVar, i3)) {
            throw new IllegalArgumentException("Invalid date.");
        } else {
            return (f(i, i2, hVar)) + (long)i3 - 1L;
        }
    }

    public final long u(D d) {
        return t(d.Y(), d.i0().getNumber(), d.e0(), d.q());
    }

    public final D v(long j) {
        int i2 = 0;
        net.time4j.calendar.h hVar;
        int i4 = 12;
        long l3;
        int i3 = 60;
        final Object j4 = this;
        long l4 = w(j);
        long l12 = 1L;
        long l = j4.p(l4 + l12);
        long l2 = j4.o(j + l12);
        long l11 = d.m(l, j4.o((j4.w(370L + l4)) + l12));
        i2 = 1;
        int r2 = l11 == 12 ? i2 : 0;
        if (i2 != 0 && j4.j(l, l6, l2, obj2)) {
            l3 = (d.m(l, l6, l2, obj2)) - 1L;
        }
        i4 = 12;
        i4 = c.d(l3, i4);
        if (i4 != 0) {
        }
        long l15 = (long)(Math.floor((1.5d - (double)i4 / 12d) + (double)(j - d.c) / 365.242189d));
        i3 = 60;
        i3 = c.d(l15, i3);
        if (i3 != 0) {
        }
        if (i2 != 0 && j4.k(l2, obj2)) {
            if (!j4.j(l, j4.o(l2))) {
            }
        }
        return this.e(i, i3, hVar, (int)(j - l2) + 1L, j);
    }

    abstract D e(int i, int i2, h hVar, int i3, long j);

    abstract int[] h();

    abstract p i(long j);
}
