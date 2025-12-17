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
import net.time4j.f1.c;
import net.time4j.g1.c;

/* loaded from: classes3.dex */
public abstract class f<U, D extends net.time4j.calendar.f<U, D>>  extends m<U, D> {

    private final transient int a;
    private final transient int b;
    private final transient net.time4j.calendar.h c;
    private final transient int v;
    private final transient long w;
    private final transient int x;

    static class a {
    }

    private static class b implements y<D, net.time4j.calendar.c> {

        private final p<?> a;
        private final boolean b;
        private b(p<?> p, boolean z2) {
            super();
            this.a = p;
            this.b = z2;
        }

        b(p p, boolean z2, net.time4j.calendar.f.a f$a3) {
            super(p, z2);
        }

        public p<?> b(D d) {
            return this.a;
        }

        public p<?> d(D d) {
            return this.a;
        }

        public net.time4j.calendar.c e(D d) {
            int obj2;
            obj2 = d.Y() == 94 ? 56 : 60;
            return c.s(obj2);
        }

        public net.time4j.calendar.c f(D d) {
            net.time4j.calendar.c obj3;
            final int i3 = 1;
            if (this.b) {
                if (d.Y() == 75) {
                    obj3 = c.s(10);
                } else {
                    obj3 = c.s(i3);
                }
                return obj3;
            }
            if (d.Y() == 72) {
                obj3 = c.s(22);
            } else {
                obj3 = c.s(i3);
            }
            return obj3;
        }

        public net.time4j.calendar.c g(D d) {
            return d.i0();
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return b((f)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return d((f)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((f)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((f)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((f)object);
        }

        public boolean h(D d, net.time4j.calendar.c c2) {
            int cVar;
            int obj2;
            if (c2 != null && f(d).i(c2) <= 0 && e(d).i(c2) >= 0) {
                if (cVar.i(c2) <= 0) {
                    obj2 = obj2.i(c2) >= 0 ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj2;
        }

        public D i(D d, net.time4j.calendar.c c2, boolean z3) {
            net.time4j.calendar.h hVar;
            net.time4j.calendar.h obj8;
            int obj9;
            if (!h(d, c2)) {
            } else {
                net.time4j.calendar.d dVar = d.X();
                int i2 = d.q();
                net.time4j.calendar.h obj10 = d.e0();
                final int number = c2.getNumber();
                final int i = d.Y();
                if (obj10.e() && obj10.getNumber() != dVar.g(i, number)) {
                    if (obj10.getNumber() != dVar.g(i, number)) {
                        hVar = obj8;
                    } else {
                        hVar = obj10;
                    }
                } else {
                }
                if (i2 <= 29) {
                    return dVar.e(i, number, hVar, i2, dVar.t(i, number, hVar, i2));
                }
                obj8 = dVar.t(i, number, hVar, 1);
                int i3 = Math.min(i2, dVar.v(obj8).l0());
                return dVar.e(i, number, hVar, i3, obj8 - i4);
            }
            obj10 = new StringBuilder();
            obj10.append("Invalid cyclic year: ");
            obj10.append(c2);
            obj8 = new IllegalArgumentException(obj10.toString());
            throw obj8;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((f)object, (c)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return i((f)object, (c)object2, z3);
        }
    }

    private static class c implements k0<D> {

        private final int a;
        c(int i) {
            super();
            this.a = i;
        }

        private static <D extends net.time4j.calendar.f<?, D>> long e(D d, D d2, int i3) {
            int number;
            int i4;
            net.time4j.engine.g gVar;
            net.time4j.engine.g i5;
            net.time4j.calendar.h equals;
            int number3;
            boolean z;
            int i;
            int i2;
            int number2;
            int obj12;
            int obj13;
            int obj14;
            net.time4j.calendar.d dVar = d.X();
            i4 = 1;
            final int i12 = 60;
            if (i3 != 0 && i3 != i4 && i3 != 2 && i3 != 3) {
                i12 = 60;
                if (i3 != i4) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                            } else {
                                return obj13 -= l;
                            }
                            obj12 = new UnsupportedOperationException();
                            throw obj12;
                        }
                        return obj13 /= i9;
                    }
                    obj14 = d.R(d2);
                    if (obj14 != null) {
                        i5 = d;
                        gVar = d2;
                    } else {
                        gVar = d;
                        i5 = d2;
                    }
                    equals = gVar.e0();
                    number3 = equals.getNumber();
                    z = equals.e();
                    i = dVar.g(gVar.Y(), gVar.i0().getNumber());
                    final int i16 = 0;
                    i2 = i16;
                    while (obj12 == i5.Y()) {
                        if (obj13 != i5.i0().getNumber()) {
                        }
                        if (z) {
                        } else {
                        }
                        if (i == number3) {
                        } else {
                        }
                        number3++;
                        if (!z) {
                        }
                        if (z) {
                        }
                        i2++;
                        equals = h.f(number3).i();
                        if (number3 == 13) {
                        } else {
                        }
                        if (number3 == 0 && obj13-- == 0) {
                        }
                        if (obj13-- == 0) {
                        }
                        i = i15;
                        number3 = equals;
                        obj12--;
                        obj13 = i12;
                        if (obj13++ == 61) {
                        }
                        number3 = i4;
                        i = equals;
                        obj12++;
                        obj13 = i4;
                        z = i4;
                        number3++;
                        z = i16;
                        if (!equals.equals(i5.e0())) {
                        }
                    }
                    if (i2 > 0 && gVar.q() > i5.q()) {
                        if (gVar.q() > i5.q()) {
                            i2--;
                        }
                    }
                    if (obj14 != null) {
                        i2 = -i2;
                    }
                    return (long)i2;
                }
                obj14 -= number;
                if (obj14 > 0) {
                    number = d.e0().a(d2.e0());
                    if (number <= 0) {
                        if (number == 0 && d.q() > d2.q()) {
                            if (d.q() > d2.q()) {
                                obj14--;
                            }
                        }
                    } else {
                    }
                } else {
                    if (obj14 < 0) {
                        number = d.e0().a(d2.e0());
                        if (number >= 0) {
                            if (number == 0 && d.q() < d2.q()) {
                                if (d.q() < d2.q()) {
                                    obj14++;
                                }
                            }
                        } else {
                        }
                    }
                }
                return (long)obj14;
            }
            return obj12 /= i6;
        }

        private static void f(long l) {
            int cmp;
            int obj2;
            if (Long.compare(l, i) > 0) {
            } else {
                if (Long.compare(l, cmp) < 0) {
                } else {
                }
            }
            obj2 = new ArithmeticException("Month arithmetic limited to delta not greater than 1200.");
            throw obj2;
        }

        private static <D extends net.time4j.calendar.f<?, D>> D g(int i, int i2, net.time4j.calendar.h h3, int i4, net.time4j.calendar.d<D> d5) {
            if (i4 <= 29) {
                return d5.e(i, i2, h3, i4, d5.t(i, i2, h3, i4));
            }
            long l = d5.t(i, i2, h3, 1);
            final int i14 = Math.min(i4, d5.v(l).l0());
            return d5.e(i, i2, h3, i14, i6 - i9);
        }

        @Override // net.time4j.engine.k0
        public long a(Object object, Object object2) {
            return d((f)object, (f)object2);
        }

        @Override // net.time4j.engine.k0
        public Object b(Object object, long l2) {
            return c((f)object, l2);
        }

        public D c(D d, long l2) {
            long i8;
            net.time4j.calendar.h hVar;
            boolean number;
            int i7;
            int i3;
            int number2;
            boolean z;
            net.time4j.calendar.h hVar2;
            int i4;
            int i5;
            int i;
            int i2;
            int number3;
            int i6;
            int cmp;
            i8 = l2;
            final net.time4j.calendar.d dVar = d.X();
            int i11 = d.q();
            i3 = d.Y();
            number2 = d.i0().getNumber();
            hVar2 = d.e0();
            int i17 = obj.a;
            final int i18 = 60;
            final int i19 = 1;
            if (i17 != 0) {
                if (i17 != i19 && i17 != 2 && i17 != 3) {
                    if (i17 != 2) {
                        if (i17 != 3) {
                            if (i17 != 4) {
                            } else {
                                return dVar.v(c.f(d.c(), i3));
                            }
                            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                            throw unsupportedOperationException;
                        }
                        i8 = c.i(i8, obj1);
                    }
                    f.c.f(l2);
                    final int i22 = -1;
                    i4 = Long.compare(i8, i5) > 0 ? i19 : i22;
                    number3 = hVar2.getNumber();
                    z = hVar2.e();
                    i6 = dVar.g(i3, number2);
                    while (Long.compare(i8, i5) != 0) {
                        if (z) {
                        } else {
                        }
                        if (i4 == i19 && i6 == number3) {
                        } else {
                        }
                        if (i4 == i22) {
                        } else {
                        }
                        number3 += i4;
                        if (!z) {
                        }
                        i8 -= l7;
                        i5 = 0;
                        if (number3 == 13) {
                        } else {
                        }
                        if (number3 == 0 && number2-- == 0) {
                        }
                        if (number2-- == 0) {
                        }
                        number3 = i5;
                        i6 = i2;
                        i3--;
                        number2 = i18;
                        if (number2++ == 61) {
                        }
                        number3 = i19;
                        i6 = i5;
                        i3++;
                        number2 = i19;
                        if (i6 == number3 + -1) {
                        } else {
                        }
                        number3--;
                        z = i19;
                        if (i6 == number3) {
                        } else {
                        }
                        z = 0;
                        if (i4 == i19) {
                        }
                        number3++;
                    }
                    if (z) {
                        hVar = h.f(number3).i();
                    }
                    return f.c.g(i3, number2, hVar, i11, dVar);
                }
            } else {
                i8 = c.i(i8, obj1);
            }
            long l3 = c.f((long)i15, number2);
            int i16 = c.g(c.b(l3, obj1));
            i9 += i19;
            if (hVar2.e() && dVar.g(i16, i10) != hVar2.getNumber()) {
                if (dVar.g(i16, i10) != hVar2.getNumber()) {
                    hVar2 = h.f(hVar2.getNumber());
                }
            }
            return f.c.g(i16, i10, hVar2, i11, dVar);
        }

        public long d(D d, D d2) {
            return f.c.e(d, d2, this.a);
        }
    }

    private static class e implements y<D, net.time4j.calendar.h> {

        private final p<?> a;
        private e(p<?> p) {
            super();
            this.a = p;
        }

        e(p p, net.time4j.calendar.f.a f$a2) {
            super(p);
        }

        static <D extends net.time4j.calendar.f<?, D>> D i(D d, net.time4j.calendar.h h2) {
            final net.time4j.calendar.d dVar = d.X();
            int i8 = d.q();
            final int number = d.i0().getNumber();
            if (i8 <= 29) {
                return dVar.e(d.Y(), number, h2, i8, dVar.t(d.Y(), number, h2, i8));
            }
            long l2 = dVar.t(d.Y(), number, h2, 1);
            int i9 = Math.min(i8, dVar.v(l2).l0());
            return dVar.e(d.Y(), number, h2, i9, i10 -= i12);
        }

        public p<?> b(D d) {
            return this.a;
        }

        public p<?> d(D d) {
            return this.a;
        }

        public net.time4j.calendar.h e(D d) {
            return h.f(12);
        }

        public net.time4j.calendar.h f(D d) {
            return h.f(1);
        }

        public net.time4j.calendar.h g(D d) {
            return d.e0();
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return b((f)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return d((f)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((f)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((f)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((f)object);
        }

        public boolean h(D d, net.time4j.calendar.h h2) {
            boolean z;
            int obj2;
            int obj3;
            if (h2 != 0) {
                if (h2.e()) {
                    obj2 = h2.getNumber() == d.d0() ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj2;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((f)object, (h)object2);
        }

        public D j(D d, net.time4j.calendar.h h2, boolean z3) {
            if (!h(d, h2)) {
            } else {
                return f.e.i(d, h2);
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Invalid month: ");
            obj4.append(h2);
            IllegalArgumentException obj2 = new IllegalArgumentException(obj4.toString());
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return j((f)object, (h)object2, z3);
        }
    }

    private static class d implements b0<D> {

        private final p<?> a;
        private final int b;
        private d(int i, p<?> p2) {
            super();
            this.b = i;
            this.a = p2;
        }

        d(int i, p p2, net.time4j.calendar.f.a f$a3) {
            super(i, p2);
        }

        @Override // net.time4j.engine.b0
        public Object a(Object object, int i2, boolean z3) {
            return k((f)object, i2, z3);
        }

        public p<?> b(D d) {
            return this.a;
        }

        @Override // net.time4j.engine.b0
        public int c(Object object) {
            return e((f)object);
        }

        public p<?> d(D d) {
            return this.a;
        }

        public int e(D d) {
            int number;
            boolean obj3;
            int i = this.b;
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                        } else {
                            return d.Y();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown element index: ");
                        stringBuilder.append(this.b);
                        obj3 = new UnsupportedOperationException(stringBuilder.toString());
                        throw obj3;
                    }
                    number = d.e0().getNumber();
                    int i6 = d.d0();
                    if (i6 > 0) {
                        if (i6 >= number) {
                            if (d.e0().e()) {
                                number++;
                            }
                        } else {
                        }
                    } else {
                    }
                    return number;
                }
                return d.b0();
            }
            return d.q();
        }

        public Integer f(D d) {
            int i;
            int i2;
            int obj3;
            i = this.b;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        i2 = 3;
                        if (i != i2) {
                        } else {
                            obj3 = d.X();
                            obj3 = (f)obj3.a(obj3.c()).Y();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown element index: ");
                        stringBuilder.append(this.b);
                        obj3 = new UnsupportedOperationException(stringBuilder.toString());
                        throw obj3;
                    }
                    obj3 = d.k0() ? 13 : 12;
                } else {
                    obj3 = d.m0();
                }
            } else {
                obj3 = d.l0();
            }
            return Integer.valueOf(obj3);
        }

        public Integer g(D d) {
            final int i2 = 3;
            if (this.b == i2) {
                net.time4j.calendar.d obj3 = d.X();
                return Integer.valueOf((f)obj3.a(obj3.d()).Y());
            }
            return 1;
        }

        @Override // net.time4j.engine.b0
        public p getChildAtCeiling(Object object) {
            return b((f)object);
        }

        @Override // net.time4j.engine.b0
        public p getChildAtFloor(Object object) {
            return d((f)object);
        }

        @Override // net.time4j.engine.b0
        public Object getMaximum(Object object) {
            return f((f)object);
        }

        @Override // net.time4j.engine.b0
        public Object getMinimum(Object object) {
            return g((f)object);
        }

        @Override // net.time4j.engine.b0
        public Object getValue(Object object) {
            return h((f)object);
        }

        public Integer h(D d) {
            return Integer.valueOf(e(d));
        }

        public boolean i(D d, int i2) {
            int i3;
            int i;
            int obj6;
            i3 = 0;
            final int i5 = 1;
            if (i2 < i5) {
                return i3;
            }
            int i6 = this.b;
            int i7 = 30;
            if (i6 == 0 && i2 > i7) {
                i7 = 30;
                if (i2 > i7) {
                    return i3;
                }
                if (i2 == i7 && d.l0() == i7) {
                    if (d.l0() == i7) {
                        i3 = i5;
                    }
                    return i3;
                }
                return i5;
            }
            if (i6 == i5 && i2 <= d.m0()) {
                if (i2 <= d.m0()) {
                    i3 = i5;
                }
                return i3;
            }
            if (i6 == 2) {
                if (i2 > 12) {
                    if (i2 == 13 && d.d0() > 0) {
                        if (d.d0() > 0) {
                            i3 = i5;
                        }
                    }
                } else {
                }
                return i3;
            }
            int i10 = 3;
            if (i6 != i10) {
            } else {
                obj6 = d.X();
                if (i2 >= (f)obj6.a(obj6.d()).Y() && i2 <= (f)obj6.a(obj6.c()).Y()) {
                    if (i2 <= (f)obj6.a(obj6.c()).Y()) {
                        i3 = i5;
                    }
                }
                return i3;
            }
            StringBuilder obj7 = new StringBuilder();
            obj7.append("Unknown element index: ");
            obj7.append(this.b);
            obj6 = new UnsupportedOperationException(obj7.toString());
            throw obj6;
        }

        @Override // net.time4j.engine.b0
        public boolean isValid(Object object, Object object2) {
            return j((f)object, (Integer)object2);
        }

        public boolean j(D d, Integer integer2) {
            net.time4j.calendar.f obj1;
            int obj2;
            if (integer2 != 0 && i(d, integer2.intValue())) {
                obj1 = i(d, integer2.intValue()) ? 1 : 0;
            } else {
            }
            return obj1;
        }

        public D k(D d, int i2, boolean z3) {
            int i3;
            int i;
            int i4;
            int obj13;
            int obj14;
            i3 = this.b;
            i = 1;
            i4 = 0;
            if (i3 != 0 && i3 != i && i3 != 2) {
                if (i3 != i) {
                    i4 = 0;
                    if (i3 != 2) {
                        if (i3 != 3) {
                        } else {
                            if (!i(d, i2)) {
                            } else {
                                return (f)f.h0(i4).b(d, (long)obj13);
                            }
                            obj14 = new StringBuilder();
                            obj14.append("Sexagesimal cycle out of range: ");
                            obj14.append(i2);
                            IllegalArgumentException obj12 = new IllegalArgumentException(obj14.toString());
                            throw obj12;
                        }
                        obj13 = new StringBuilder();
                        obj13.append("Unknown element index: ");
                        obj13.append(this.b);
                        obj12 = new UnsupportedOperationException(obj13.toString());
                        throw obj12;
                    }
                    if (!i(d, i2)) {
                    } else {
                        obj14 = d.d0();
                        if (obj14 > 0 && obj14 < i2) {
                            if (obj14 < i2) {
                                if (i2 == obj14 += i) {
                                } else {
                                    i = i4;
                                }
                                i2--;
                                i4 = i;
                            }
                        }
                        if (i4 != 0) {
                            obj13 = h.f(obj13).i();
                        }
                        return f.e.i(d, obj13);
                    }
                    obj14 = new StringBuilder();
                    obj14.append("Ordinal month out of range: ");
                    obj14.append(i2);
                    obj12 = new IllegalArgumentException(obj14.toString());
                    throw obj12;
                }
                if (z3 == 0) {
                    if (i2 < i) {
                    } else {
                        if (i2 > d.m0()) {
                        } else {
                        }
                    }
                    obj14 = new StringBuilder();
                    obj14.append("Day of year out of range: ");
                    obj14.append(i2);
                    obj12 = new IllegalArgumentException(obj14.toString());
                    throw obj12;
                }
                return d.X().v(i8 -= obj13);
            }
            if (z3 != 0) {
                return d.X().v(i6 -= obj13);
            }
            if (i2 < i) {
            } else {
                obj14 = 30;
                if (i2 > obj14) {
                } else {
                    if (i2 == obj14) {
                        if (d.l0() < obj14) {
                        } else {
                        }
                    }
                    return d.X().e(d.Y(), d.i0().getNumber(), d.e0(), i2, i5 - l6);
                }
            }
            obj14 = new StringBuilder();
            obj14.append("Day of month out of range: ");
            obj14.append(i2);
            obj12 = new IllegalArgumentException(obj14.toString());
            throw obj12;
        }

        public D l(D d, Integer integer2, boolean z3) {
            if (integer2 == null) {
            } else {
                return k(d, integer2.intValue(), z3);
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("Missing element value.");
            throw obj1;
        }

        @Override // net.time4j.engine.b0
        public Object withValue(Object object, Object object2, boolean z3) {
            return l((f)object, (Integer)object2, z3);
        }
    }
    f(int i, int i2, net.time4j.calendar.h h3, int i4, long l5) {
        super();
        this.a = i;
        this.b = i2;
        this.c = h3;
        this.v = i4;
        this.w = l5;
        this.x = X().g(i, i2);
    }

    static <D extends net.time4j.calendar.f<?, D>> y<D, Integer> Z(p<?> p) {
        f.d dVar = new f.d(3, p, 0);
        return dVar;
    }

    static <D extends net.time4j.calendar.f<?, D>> y<D, Integer> a0() {
        final int i2 = 0;
        f.d dVar = new f.d(0, i2, i2);
        return dVar;
    }

    static <D extends net.time4j.calendar.f<?, D>> y<D, Integer> c0() {
        final int i2 = 0;
        f.d dVar = new f.d(1, i2, i2);
        return dVar;
    }

    static <D extends net.time4j.calendar.f<?, D>> y<D, Integer> f0(p<?> p) {
        f.d dVar = new f.d(2, p, 0);
        return dVar;
    }

    static <D extends net.time4j.calendar.f<?, D>> y<D, net.time4j.calendar.h> g0(p<?> p) {
        f.e eVar = new f.e(p, 0);
        return eVar;
    }

    static <D extends net.time4j.calendar.f<?, D>> k0<D> h0(int i) {
        f.c cVar = new f.c(i);
        return cVar;
    }

    static <D extends net.time4j.calendar.f<?, D>> y<D, net.time4j.calendar.c> j0(p<?> p) {
        f.b bVar = new f.b(p, 0, 0);
        return bVar;
    }

    abstract net.time4j.calendar.d<D> X();

    @Override // net.time4j.engine.m
    int Y() {
        return this.a;
    }

    @Override // net.time4j.engine.m
    public int b0() {
        return (int)i2;
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
    public net.time4j.calendar.h e0() {
        return this.c;
    }

    @Override // net.time4j.engine.m
    public boolean equals(Object object) {
        int i;
        int equals;
        int i2;
        long l;
        Object obj7;
        if (object == this) {
            return 1;
        }
        final int i3 = 0;
        if (object == null) {
            return i3;
        }
        if (getClass() == object.getClass()) {
            if (this.a == object.a && this.b == object.b && this.v == object.v && this.c.equals(object.c) && Long.compare(equals, l) == 0) {
                if (this.b == object.b) {
                    if (this.v == object.v) {
                        if (this.c.equals(object.c)) {
                            if (Long.compare(equals, l) == 0) {
                            } else {
                                i = i3;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i3;
    }

    @Override // net.time4j.engine.m
    public int hashCode() {
        long l = this.w;
        return (int)i;
    }

    @Override // net.time4j.engine.m
    public net.time4j.calendar.c i0() {
        return c.s(this.b);
    }

    @Override // net.time4j.engine.m
    public boolean k0() {
        int i;
        i = this.x > 0 ? 1 : 0;
        return i;
    }

    @Override // net.time4j.engine.m
    public int l0() {
        final int i4 = 1;
        return (int)i7;
    }

    @Override // net.time4j.engine.m
    public int m0() {
        int i2;
        int i;
        i5 += i;
        if (i6 > 60) {
            i2++;
        } else {
            i = i6;
        }
        return (int)i3;
    }

    @Override // net.time4j.engine.m
    public int q() {
        return this.v;
    }

    @Override // net.time4j.engine.m
    public String toString() {
        String value;
        int i;
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
    protected w y() {
        return J();
    }
}
