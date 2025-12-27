package net.time4j.calendar;

import java.util.Locale;
import net.time4j.engine.b0;
import net.time4j.engine.k;
import net.time4j.engine.k0;
import net.time4j.engine.m;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.engine.y;

/* compiled from: EastAsianCalendar.java */
/* loaded from: classes3.dex */
public abstract class f<U, D extends f<U, D>> extends m<U, D> {

    private final transient int a;
    private final transient int b;
    private final transient h c;
    private final transient int v;
    private final transient long w;
    private final transient int x;

    static class a {
    }

    private static class b<D extends f<?, D>> implements y<D, c> {

        private final p<?> a;
        private final boolean b;
        /* synthetic */ b(p pVar, boolean z, f.a aVar) {
            this(pVar, z);
        }

        public p<?> b(D d) {
            return this.a;
        }

        public p<?> d(D d) {
            return this.a;
        }

        public c e(D d) {
            int i = 56;
            d = d.Y() == 94 ? 56 : 60;
            return (d.Y() == 94 ? 56 : 60);
        }

        public c f(D d) {
            net.time4j.calendar.c cVar;
            net.time4j.calendar.c cVar2;
            final int i3 = 1;
            if (this.b) {
                if (d.Y() == 75) {
                    cVar2 = c.s(10);
                } else {
                    cVar2 = c.s(i3);
                }
                return cVar2;
            }
            if (d.Y() == 72) {
                cVar = c.s(22);
            } else {
                cVar = c.s(i3);
            }
            return cVar;
        }

        public c g(D d) {
            return d.i0();
        }

        public boolean h(D d, c cVar) {
            boolean z = true;
            d = cVar != null && f(d).i(cVar) <= 0 && e(d).i(cVar) >= 0 ? 1 : 0;
            return (cVar != null && f(d).i(cVar) <= 0 && e(d).i(cVar) >= 0 ? 1 : 0);
        }

        public D i(D d, c cVar, boolean z) {
            net.time4j.calendar.h d2;
            int i;
            if (!h(d, cVar)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Invalid cyclic year: ";
                cVar = str + cVar;
                throw new IllegalArgumentException(cVar);
            } else {
                net.time4j.calendar.d dVar = d.X();
                int i3 = d.q();
                d2 = d.e0();
                final int number = cVar.getNumber();
                final int i2 = d.Y();
                if (d2.e()) {
                    if (d2.getNumber() != dVar.g(i2, number)) {
                    } else {
                    }
                }
                if (i3 <= 29) {
                    return dVar.e(i2, number, d2, i3, dVar.t(i2, number, d2, i3));
                }
                long l4 = dVar.t(i2, number, d2, 1);
                int min = Math.min(i3, dVar.v(l4).l0());
                return dVar.e(i2, number, d2, min, (l4 + (long)min) - 1L);
            }
        }

        private b(p<?> pVar, boolean z) {
            super();
            this.a = pVar;
            this.b = z;
        }
    }

    private static class c<D extends f<?, D>> implements k0<D> {

        private final int a;
        c(int i) {
            super();
            this.a = i;
        }

        private static <D extends f<?, D>> long e(D d, D d2, int i) {
            net.time4j.engine.g d22;
            net.time4j.calendar.f d3;
            net.time4j.calendar.h hVar;
            int number2;
            boolean z;
            int i2;
            int number3;
            int i4;
            int i5;
            int i6;
            int i7;
            net.time4j.calendar.d dVar = d.X();
            number2 = 1;
            if (i != 0 && i != number2) {
                if (i != 2) {
                    if (i != 3 && i == 4) {
                        return d2.c() - d.c();
                    }
                    return (d2.c() - d.c()) / 7L;
                }
                boolean z2 = d.R(d2);
                if (z2) {
                    d3 = d;
                    d22 = d2;
                } else {
                    d3 = d;
                    d22 = d2;
                }
                hVar = d22.e0();
                number2 = hVar.getNumber();
                z = hVar.e();
                i = dVar.g(d22.Y(), d22.i0().getNumber());
                i2 = 0;
                while (i4 == d3.Y()) {
                }
                if (i2 > 0 && d22.q() > d3.q()) {
                    i2 = i2 - 1;
                }
                if (z2) {
                    i2 = -i2;
                }
                return (long)i2;
            }
            return (f.c.e(d, d2, number2)) / 60L;
        }

        private static void f(long j) {
            if (j > 1200) {
                throw new ArithmeticException("Month arithmetic limited to delta not greater than 1200.");
            } else {
                long l = -1200L;
                if (j >= l) {
                    return;
                }
            }
        }

        private static <D extends f<?, D>> D g(int i, int i2, h hVar, int i3, d<D> dVar) {
            if (i3 <= 29) {
                return dVar.e(i, i2, hVar, i3, dVar.t(i, i2, hVar, i3));
            }
            long l = dVar.t(i, i2, hVar, 1);
            final int min = Math.min(i3, dVar.v(l).l0());
            return dVar.e(i, i2, hVar, min, (l + (long)min) - 1L);
        }

        public D c(D d, long j) {
            long j22;
            net.time4j.calendar.h hVar;
            int i2;
            int number;
            boolean z2;
            net.time4j.calendar.h hVar2;
            long l2 = 0;
            int i3;
            j22 = j;
            final net.time4j.calendar.d dVar = d.X();
            int i7 = d.q();
            i2 = d.Y();
            number = d.i0().getNumber();
            hVar2 = d.e0();
            number = 60;
            number = 1;
            if (this.a != 0) {
                if (this.a != number) {
                    if (this.a != 2 && this.a != 3) {
                        int i = 4;
                        if (this.a != 4) {
                            throw new UnsupportedOperationException();
                        } else {
                            return dVar.v(c.f(d.c(), j22));
                        }
                    }
                    f.c.f(j);
                    l2 = 0L;
                    number = -1;
                    int r8 = number;
                    number = hVar2.getNumber();
                    z2 = hVar2.e();
                    i3 = dVar.g(i2, number);
                    while (j22 != l2) {
                    }
                    if (z2) {
                        hVar = h.f(number).i();
                    }
                    return f.c.g(i2, number, hVar, i7, dVar);
                }
            } else {
                long l = 60L;
                j22 = c.i(j22, l);
            }
            long l4 = c.f((long)(i2 * number) + number - number, j22);
            int i12 = c.g(c.b(l4, number));
            int i5 = (c.d(l4, number)) + number;
            if (hVar2.e()) {
                if (dVar.g(i12, i5) != hVar2.getNumber()) {
                    hVar2 = h.f(hVar2.getNumber());
                }
            }
            return f.c.g(i12, i5, hVar2, i7, dVar);
        }

        public long d(D d, D d2) {
            return f.c.e(d, d2, this.a);
        }
    }

    private static class e<D extends f<?, D>> implements y<D, h> {

        private final p<?> a;
        /* synthetic */ e(p pVar, f.a aVar) {
            this(pVar);
        }

        static <D extends f<?, D>> D i(D d, h hVar) {
            final net.time4j.calendar.d dVar = d.X();
            int i8 = d.q();
            final int number = d.i0().getNumber();
            if (i8 <= 29) {
                return dVar.e(d.Y(), number, hVar, i8, dVar.t(d.Y(), number, hVar, i8));
            }
            long l2 = dVar.t(d.Y(), number, hVar, 1);
            int min = Math.min(i8, dVar.v(l2).l0());
            return dVar.e(d.Y(), number, hVar, min, (l2 + (long)min) - 1L);
        }

        public p<?> b(D d) {
            return this.a;
        }

        public p<?> d(D d) {
            return this.a;
        }

        public h e(D d) {
            return h.f(12);
        }

        public h f(D d) {
            return h.f(1);
        }

        public h g(D d) {
            return d.e0();
        }

        public boolean h(D d, h hVar) {
            boolean z;
            boolean z2 = true;
            int number;
            if (hVar == null || hVar.e()) {
                int i3 = 0;
            } else {
                d = hVar.getNumber() == d.d0() ? 1 : 0;
            }
            return (hVar.getNumber() == d.d0() ? 1 : 0);
        }

        public D j(D d, h hVar, boolean z) {
            if (!h(d, hVar)) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str = "Invalid month: ";
                hVar = str + hVar;
                throw new IllegalArgumentException(hVar);
            } else {
                return f.e.i(d, hVar);
            }
        }

        private e(p<?> pVar) {
            super();
            this.a = pVar;
        }
    }

    private static class d<D extends f<?, D>> implements b0<D> {

        private final p<?> a;
        private final int b;
        /* synthetic */ d(int i, p pVar, f.a aVar) {
            this(i, pVar);
        }

        public p<?> b(D d) {
            return this.a;
        }

        public p<?> d(D d) {
            return this.a;
        }

        public int e(D d) {
            int number;
            boolean z;
            if (this.b != 0 && this.b != 1) {
                if (this.b != 2) {
                    if (this.b != 3) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = "Unknown element index: ";
                        r0 = str + this.b;
                        throw new UnsupportedOperationException(r0);
                    } else {
                        return d.Y();
                    }
                }
                number = d.e0().getNumber();
                int i6 = d.d0();
                if (i6 <= 0 || i6 >= number) {
                    if (d.e0().e()) {
                        number = number + 1;
                    }
                }
                return number;
            }
            return d.q();
        }

        public Integer f(D d) {
            int i3 = 13;
            if (this.b != 0) {
                int i2 = 1;
                if (this.b != 1) {
                    i2 = 2;
                    if (this.b != 2) {
                        i2 = 3;
                        if (this.b != i2) {
                            StringBuilder stringBuilder = new StringBuilder();
                            String str = "Unknown element index: ";
                            r0 = str + this.b;
                            throw new UnsupportedOperationException(r0);
                        } else {
                            net.time4j.calendar.d dVar = d.X();
                            i3 = (f)dVar.a(dVar.c()).Y();
                        }
                    }
                    d = d.k0() ? 13 : 12;
                } else {
                    d = d.m0();
                }
            } else {
                d = d.l0();
            }
            return (d.k0() ? 13 : 12);
        }

        public Integer g(D d) {
            final int i2 = 3;
            if (this.b == i2) {
                net.time4j.calendar.d dVar = d.X();
                return Integer.valueOf((f)dVar.a(dVar.d()).Y());
            }
            return 1;
        }

        public Integer h(D d) {
            return Integer.valueOf(e(d));
        }

        public boolean i(D d, int i) {
            boolean z = false;
            int i3 = 12;
            int i4;
            z = false;
            i = 1;
            if (i < i) {
                return false;
            }
            if (this.b == 0 && i > i7) {
                return false;
            }
            if (this.b == i && i <= d.m0()) {
                return z;
            }
            if (this.b == 2 && i > 12) {
                i3 = 13;
                if (i == 13 && d.d0() > 0) {
                }
                return z;
            }
            int i10 = 3;
            if (this.b != i10) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Unknown element index: ";
                i = str + this.b;
                throw new UnsupportedOperationException(i);
            } else {
                net.time4j.calendar.d dVar = d.X();
                if (i >= (f)dVar.a(dVar.d()).Y() && i <= (f)dVar.a(dVar.c()).Y()) {
                }
                return z;
            }
        }

        public boolean j(D d, Integer integer) {
            boolean z2 = false;
            int value;
            if (integer != null) {
                d = i(d, integer.intValue()) ? 1 : 0;
            }
            return (i(d, integer.intValue()) ? 1 : 0);
        }

        public D k(D d, int i, boolean z) {
            int i3 = 1;
            int i4;
            net.time4j.calendar.h hVar;
            i3 = 1;
            if (this.b != 0 && this.b != i3 && this.b != 2) {
                if (this.b != 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str5 = "Unknown element index: ";
                    i = str5 + this.b;
                    throw new UnsupportedOperationException(i);
                } else {
                    if (!i(d, i)) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        String str2 = "Sexagesimal cycle out of range: ";
                        i = str2 + i;
                        throw new IllegalArgumentException(i);
                    } else {
                        return (f)f.h0(i3).b(d, (long)(i - d.Y()));
                    }
                }
            }
            if (this.b) {
                return d.X().v((d.c() + (long)i) - (long)d.q());
            }
            if (i < i3) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str = "Day of month out of range: ";
                i = str + i;
                throw new IllegalArgumentException(i);
            } else {
                int i5 = 30;
                if (i <= i5) {
                    return d.X().e(d.Y(), d.i0().getNumber(), d.e0(), i, (d.c() + (long)i) - (long)d.q());
                }
            }
        }

        public D l(D d, Integer integer, boolean z) {
            if (integer == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else {
                return k(d, integer.intValue(), z);
            }
        }

        private d(int i, p<?> pVar) {
            super();
            this.b = i;
            this.a = pVar;
        }
    }
    f(int i, int i2, h hVar, int i3, long j) {
        super();
        this.a = i;
        this.b = i2;
        this.c = hVar;
        this.v = i3;
        this.w = j;
        this.x = X().g(i, i2);
    }

    static <D extends f<?, D>> y<D, Integer> Z(p<?> pVar) {
        return new f.d(3, pVar, null);
    }

    static <D extends f<?, D>> y<D, Integer> a0() {
        final p pVar = null;
        return new f.d(0, pVar, pVar);
    }

    static <D extends f<?, D>> y<D, Integer> c0() {
        final p pVar = null;
        return new f.d(1, pVar, pVar);
    }

    static <D extends f<?, D>> y<D, Integer> f0(p<?> pVar) {
        return new f.d(2, pVar, null);
    }

    static <D extends f<?, D>> y<D, h> g0(p<?> pVar) {
        return new f.e(pVar, null);
    }

    static <D extends f<?, D>> k0<D> h0(int i) {
        return new f.c(i);
    }

    static <D extends f<?, D>> y<D, c> j0(p<?> pVar) {
        return new f.b(pVar, false, null);
    }

    @Override // net.time4j.engine.m
    int Y() {
        return this.a;
    }

    @Override // net.time4j.engine.m
    public int b0() {
        return (int)(this.w - (X().q(this.a, this.b))) + 1L;
    }

    @Override // net.time4j.engine.m
    public long c() {
        return this.w;
    }

    @Override // net.time4j.engine.m
    int d0() {
        return this.x;
    }

    @Override // net.time4j.engine.m
    public h e0() {
        return this.c;
    }

    @Override // net.time4j.engine.m
    public boolean equals(Object object) {
        boolean z = true;
        int i2;
        int i3;
        long l;
        int cmp;
        z = true;
        if (object == this) {
            return true;
        }
        final int i = 0;
        if (object == null) {
            return false;
        }
        if (getClass() == object.getClass()) {
            if (this.a == object.a) {
                if (this.b == object.b) {
                    if (this.v == object.v) {
                        if (this.c.equals(object.c)) {
                            if (this.w != object.w) {
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.engine.m
    public int hashCode() {
        return (int)(l ^ (l >>> 32L));
    }

    @Override // net.time4j.engine.m
    public c i0() {
        return c.s(this.b);
    }

    @Override // net.time4j.engine.m
    public boolean k0() {
        boolean z = true;
        int r0 = this.x > 0 ? 1 : 0;
        return (this.x > 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.m
    public int l0() {
        final long l5 = 1L;
        return (int)(long)this.v + (X().p(this.w + l5)) - this.w - l5;
    }

    @Override // net.time4j.engine.m
    public int m0() {
        int i;
        int i2 = 1;
        i2 = 1;
        i2 = this.b + i2;
        if (this.b > 60) {
            i = this.a + 1;
        } else {
        }
        return (int)(X().q(i, i2)) - (X().q(this.a, this.b));
    }

    @Override // net.time4j.engine.m
    public int q() {
        return this.v;
    }

    @Override // net.time4j.engine.m
    public String toString() {
        String value;
        StringBuilder stringBuilder = new StringBuilder();
        if ((c)getClass().getAnnotation(c.class).value().equals("dangi")) {
            value = "korean";
        }
        stringBuilder.append(value);
        stringBuilder.append('[');
        stringBuilder.append(i0().k(Locale.ROOT));
        stringBuilder.append('(');
        stringBuilder.append(e(b.a));
        stringBuilder.append(")-");
        stringBuilder.append(this.c.toString());
        stringBuilder.append('-');
        if (this.v < 10) {
            stringBuilder.append('0');
        }
        stringBuilder.append(this.v);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override // net.time4j.engine.m
    abstract d<D> X();
}
