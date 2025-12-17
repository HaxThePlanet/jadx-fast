package d.f.a.m.m;

import d.f.a.m.a;
import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import d.f.a.m.f;
import d.f.a.m.g;
import d.f.a.m.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    private static d.f.a.m.m.b.a a;
    private static int b;
    private static int c;
    static {
        b.a aVar = new b.a();
        h.a = aVar;
        int i = 0;
        h.b = i;
        h.c = i;
    }

    private static boolean a(int i, e e2) {
        e.b cmp2;
        int i4;
        e.b mATCH_CONSTRAINT;
        e.b fIXED;
        e.b fIXED2;
        int i3;
        e.b mATCH_CONSTRAINT2;
        int i2;
        int cmp;
        e.b obj7;
        obj7 = e2.y();
        cmp2 = e2.O();
        if (e2.I() != null) {
            i4 = e2.I();
        } else {
            i4 = 0;
        }
        if (i4 != 0) {
            fIXED = i4.y();
            fIXED2 = e.b.FIXED;
        }
        if (i4 != 0) {
            i4 = i4.O();
            fIXED = e.b.FIXED;
        }
        mATCH_CONSTRAINT = e.b.FIXED;
        int i5 = 0;
        i3 = 0;
        final int i6 = 1;
        if (obj7 != mATCH_CONSTRAINT && !e2.i0() && obj7 != e.b.WRAP_CONTENT) {
            if (!e2.i0()) {
                if (obj7 != e.b.WRAP_CONTENT) {
                    mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
                    if (obj7 == mATCH_CONSTRAINT2 && e2.s == 0 && Float.compare(f2, i5) == 0) {
                        if (e2.s == 0) {
                            if (Float.compare(f2, i5) == 0) {
                                if (!e2.V(i3)) {
                                    if (obj7 == mATCH_CONSTRAINT2 && e2.s == i6 && e2.Y(i3, e2.R())) {
                                        if (e2.s == i6) {
                                            if (e2.Y(i3, e2.R())) {
                                                i2 = i6;
                                            } else {
                                                i2 = i3;
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
        } else {
        }
        if (cmp2 != mATCH_CONSTRAINT && !e2.j0() && cmp2 != e.b.WRAP_CONTENT) {
            if (!e2.j0()) {
                if (cmp2 != e.b.WRAP_CONTENT) {
                    mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                    if (cmp2 == mATCH_CONSTRAINT && e2.t == 0 && Float.compare(f, i5) == 0) {
                        if (e2.t == 0) {
                            if (Float.compare(f, i5) == 0) {
                                if (!e2.V(i6)) {
                                    if (obj7 == mATCH_CONSTRAINT && e2.t == i6 && e2.Y(i6, e2.v())) {
                                        if (e2.t == i6) {
                                            if (e2.Y(i6, e2.v())) {
                                                obj7 = i6;
                                            } else {
                                                obj7 = i3;
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
        } else {
        }
        if (Float.compare(obj8, i5) > 0 && i2 == 0 && obj7 != null) {
            if (i2 == 0) {
                if (obj7 != null) {
                }
            }
            return i6;
        }
        if (i2 != 0 && obj7 != null) {
            if (obj7 != null) {
                i3 = i6;
            }
        }
        return i3;
    }

    private static void b(int i, e e2, d.f.a.m.m.b.b b$b3, boolean z4) {
        boolean z;
        Object iterator2;
        HashSet iterator;
        boolean aVar;
        d next2;
        int i3;
        int i4;
        HashSet next;
        d cmp;
        e eVar;
        boolean aVar2;
        d dVar;
        int i2;
        d mATCH_CONSTRAINT2;
        Object mATCH_CONSTRAINT;
        boolean aVar3;
        final Object obj = e2;
        final d.f.a.m.m.b.b bVar = b3;
        final boolean z2 = z4;
        if (e2.b0()) {
        }
        final int i7 = 1;
        h.b = i5 += i7;
        z = i + 1;
        if (!obj instanceof f && e2.h0() && h.a(z, obj)) {
            if (e2.h0()) {
                z = i + 1;
                if (h.a(z, obj)) {
                    aVar = new b.a();
                    f.I1(z, obj, bVar, aVar, b.a.k);
                }
            }
        }
        iterator2 = obj.m(d.b.LEFT);
        next2 = obj.m(d.b.RIGHT);
        i4 = iterator2.d();
        final int i10 = next2.d();
        final int i13 = 0;
        final int i14 = 8;
        if (iterator2.c() != null && iterator2.m()) {
            if (iterator2.m()) {
                iterator2 = iterator2.c().iterator();
                while (iterator2.hasNext()) {
                    next = iterator2.next();
                    eVar = next.d;
                    i2 = i + 1;
                    mATCH_CONSTRAINT2 = h.a(i2, eVar);
                    if (eVar.h0() && mATCH_CONSTRAINT2) {
                    }
                    mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                    if (eVar.y() == mATCH_CONSTRAINT) {
                    } else {
                    }
                    if (eVar.h0()) {
                    } else {
                    }
                    cmp = eVar.K;
                    if ((d)next == cmp && dVar7.f == null) {
                    } else {
                    }
                    mATCH_CONSTRAINT2 = eVar.M;
                    if ((d)next == mATCH_CONSTRAINT2 && cmp.f == null) {
                    } else {
                    }
                    next = mATCH_CONSTRAINT2.f;
                    if ((d)next == cmp && next && next.m() && !eVar.d0()) {
                    }
                    next = mATCH_CONSTRAINT2.f;
                    if (next) {
                    }
                    if (next.m()) {
                    }
                    if (!eVar.d0()) {
                    }
                    h.d(i2, bVar, eVar, z2);
                    if (cmp.f == null) {
                    } else {
                    }
                    next = i4 - i11;
                    eVar.w0(next - i17, next);
                    h.b(i2, eVar, bVar, z2);
                    if (dVar7.f == null) {
                    } else {
                    }
                    i12 += i4;
                    eVar.w0(next, i18 += next);
                    h.b(i2, eVar, bVar, z2);
                    if (mATCH_CONSTRAINT2) {
                    } else {
                    }
                    if (eVar.y() == mATCH_CONSTRAINT && eVar.w >= 0 && eVar.v >= 0) {
                    }
                    if (eVar.w >= 0) {
                    }
                    if (eVar.v >= 0) {
                    }
                    if (eVar.Q() != i14) {
                    } else {
                    }
                    if (!eVar.d0()) {
                    }
                    if (!eVar.g0()) {
                    }
                    cmp = dVar3.f;
                    if ((d)next == eVar.K && cmp != null) {
                    } else {
                    }
                    next = dVar2.f;
                    if ((d)next == eVar.M && next != null && next.m()) {
                    } else {
                    }
                    next = 0;
                    if (next && !eVar.d0()) {
                    }
                    if (!eVar.d0()) {
                    }
                    h.e(i2, obj, bVar, eVar, z2);
                    next = dVar2.f;
                    if (next != null) {
                    } else {
                    }
                    if (next.m()) {
                    } else {
                    }
                    next = i7;
                    cmp = dVar3.f;
                    if (cmp != null) {
                    } else {
                    }
                    if (!cmp.m()) {
                    } else {
                    }
                    if (eVar.s == 0 && Float.compare(f2, i13) == 0 && !eVar.d0() && !eVar.g0()) {
                    }
                    if (Float.compare(f2, i13) == 0) {
                    }
                    if (mATCH_CONSTRAINT2) {
                    }
                    aVar3 = new b.a();
                    f.I1(i2, eVar, bVar, aVar3, b.a.k);
                }
            }
        }
        if (obj instanceof g) {
        }
        if (next2.c() != null && next2.m()) {
            if (next2.m()) {
                iterator = next2.c().iterator();
                while (iterator.hasNext()) {
                    next2 = iterator.next();
                    i4 = next2.d;
                    next = i + 1;
                    cmp = h.a(next, i4);
                    if (i4.h0() && cmp) {
                    }
                    dVar = dVar5.f;
                    if ((d)next2 == i4.K && dVar != null) {
                    } else {
                    }
                    dVar = dVar4.f;
                    if ((d)next2 == i4.M && dVar != null && dVar.m()) {
                    } else {
                    }
                    eVar = 0;
                    mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
                    if (i4.y() == mATCH_CONSTRAINT2) {
                    } else {
                    }
                    if (i4.h0()) {
                    } else {
                    }
                    cmp = i4.K;
                    if ((d)next2 == cmp && dVar6.f == null) {
                    } else {
                    }
                    i2 = i4.M;
                    if ((d)next2 == i2 && cmp.f == null) {
                    } else {
                    }
                    if (eVar != 0 && i4.d0() == null) {
                    }
                    if (i4.d0() == null) {
                    }
                    h.d(next, bVar, i4, z2);
                    if (cmp.f == null) {
                    } else {
                    }
                    next2 = i10 - i8;
                    i4.w0(next2 - i15, next2);
                    h.b(next, i4, bVar, z2);
                    if (dVar6.f == null) {
                    } else {
                    }
                    i9 += i10;
                    i4.w0(next2, i16 += next2);
                    h.b(next, i4, bVar, z2);
                    if (cmp) {
                    } else {
                    }
                    if (i4.y() == mATCH_CONSTRAINT2 && i4.w >= 0 && i4.v >= 0) {
                    }
                    if (i4.w >= 0) {
                    }
                    if (i4.v >= 0) {
                    }
                    if (i4.Q() != i14) {
                    } else {
                    }
                    if (i4.d0() == null) {
                    }
                    if (i4.g0() == null) {
                    }
                    if (eVar != 0) {
                    }
                    if (i4.d0() == null) {
                    }
                    h.e(next, obj, bVar, i4, z2);
                    if (i4.s == null && Float.compare(f, i13) == null && i4.d0() == null && i4.g0() == null && eVar != 0 && i4.d0() == null) {
                    }
                    if (Float.compare(f, i13) == null) {
                    }
                    dVar = dVar4.f;
                    if (dVar != null) {
                    } else {
                    }
                    if (dVar.m()) {
                    } else {
                    }
                    eVar = i7;
                    dVar = dVar5.f;
                    if (dVar != null) {
                    } else {
                    }
                    if (!dVar.m()) {
                    } else {
                    }
                    if (cmp) {
                    }
                    aVar2 = new b.a();
                    f.I1(next, i4, bVar, aVar2, b.a.k);
                }
            }
        }
        e2.l0();
    }

    private static void c(int i, a a2, d.f.a.m.m.b.b b$b3, int i4, boolean z5) {
        int obj1;
        if (a2.k1()) {
            if (i4 == 0) {
                h.b(i++, a2, b3, z5);
            } else {
                h.i(i++, a2, b3);
            }
        }
    }

    private static void d(int i, d.f.a.m.m.b.b b$b2, e e3, boolean z4) {
        float f;
        int i3;
        int i4;
        int i5;
        int i2;
        float f2;
        int i6;
        f = e3.w();
        i4 = dVar.f.d();
        i5 = dVar3.f.d();
        final int i17 = 1056964608;
        if (i4 == i5) {
            f = i17;
        } else {
            i4 = i11;
            i5 = i14;
        }
        int i12 = e3.R();
        i15 -= i12;
        if (i4 > i5) {
            i16 -= i12;
        }
        if (i2 > 0) {
            i7 += i17;
        } else {
            f *= f2;
        }
        i8 += i4;
        i6 = i9 + i12;
        if (i4 > i5) {
            i6 = i9 - i12;
        }
        e3.w0(i9, i6);
        h.b(i++, e3, b2, z4);
    }

    private static void e(int i, e e2, d.f.a.m.m.b.b b$b3, e e4, boolean z5) {
        float f;
        int i8;
        int i7;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int obj7;
        Object obj8;
        i10 += i11;
        i12 -= i3;
        i2 = e4.R();
        i6 = 1056964608;
        if (i7 >= i8 && e4.Q() != 8) {
            i2 = e4.R();
            i6 = 1056964608;
            if (e4.Q() != 8) {
                i4 = e4.s;
                if (i4 == 2) {
                    if (e2 instanceof f) {
                        obj8 = e2.R();
                    } else {
                        obj8 = e2.I().R();
                    }
                    i2 = (int)i15;
                } else {
                    if (i4 == 0) {
                        i2 = i7 - i8;
                    }
                }
                obj8 = e4.w;
                if (obj8 > 0) {
                    i2 = Math.min(obj8, Math.max(e4.v, i2));
                }
            }
            i8 += obj8;
            e4.w0(i8, i2 += i8);
            h.b(i++, e4, b3, z5);
        }
    }

    private static void f(int i, d.f.a.m.m.b.b b$b2, e e3) {
        float f;
        int i5;
        int i6;
        int i4;
        int i3;
        float f2;
        int i7;
        int i2;
        f = e3.M();
        i6 = dVar.f.d();
        i4 = dVar3.f.d();
        int i17 = 1056964608;
        if (i6 == i4) {
            f = i17;
        } else {
            i6 = i11;
            i4 = i14;
        }
        int i12 = e3.v();
        i15 -= i12;
        if (i6 > i4) {
            i16 -= i12;
        }
        if (i3 > 0) {
            i8 += i17;
        } else {
            f *= f2;
        }
        int i9 = (int)i5;
        i2 = i7 + i12;
        if (i6 > i4) {
            i2 = i7 - i12;
        }
        e3.z0(i7, i2);
        h.i(i++, e3, b2);
    }

    private static void g(int i, e e2, d.f.a.m.m.b.b b$b3, e e4) {
        float f;
        int i6;
        int i2;
        int i8;
        int i7;
        int i3;
        int i5;
        int i4;
        int obj7;
        Object obj8;
        f = e4.M();
        i10 += i11;
        i12 -= i7;
        i8 = e4.v();
        i4 = 1056964608;
        if (i2 >= i6 && e4.Q() != 8) {
            i8 = e4.v();
            i4 = 1056964608;
            if (e4.Q() != 8) {
                i3 = e4.t;
                if (i3 == 2) {
                    if (e2 instanceof f) {
                        obj8 = e2.v();
                    } else {
                        obj8 = e2.I().v();
                    }
                    i8 = (int)i15;
                } else {
                    if (i3 == 0) {
                        i8 = i2 - i6;
                    }
                }
                obj8 = e4.z;
                if (obj8 > 0) {
                    i8 = Math.min(obj8, Math.max(e4.y, i8));
                }
            }
            i6 += obj8;
            e4.z0(i6, i8 += i6);
            h.i(i++, e4, b3);
        }
    }

    public static void h(f f, d.f.a.m.m.b.b b$b2) {
        e.b bVar;
        int i11;
        int fIXED;
        int i3;
        int i12;
        int i2;
        int i4;
        int i9;
        Object obj2;
        int i5;
        int i6;
        int i10;
        boolean z2;
        int i;
        boolean z;
        int i8;
        int i7;
        Object obj;
        boolean z3;
        e obj13;
        final int i18 = 0;
        h.b = i18;
        h.c = i18;
        f.p0();
        final ArrayList list = f.i1();
        final int size = list.size();
        i9 = i18;
        while (i9 < size) {
            (e)list.get(i9).p0();
            i9++;
        }
        boolean z4 = f.F1();
        if (f.y() == e.b.FIXED) {
            f.w0(i18, f.R());
        } else {
            f.x0(i18);
        }
        i = i5;
        z = 1056964608;
        i8 = -1;
        i7 = 1;
        while (i11 < size) {
            obj = list.get(i11);
            if (obj instanceof g) {
            } else {
            }
            if (obj instanceof a && (a)(e)obj.o1() == 0) {
            }
            i11++;
            z = 1056964608;
            i8 = -1;
            i7 = 1;
            if ((a)obj.o1() == 0) {
            }
            i = i7;
            if ((g)obj.j1() == i7) {
            }
            if (obj.k1() != i8) {
            } else {
            }
            if (obj.l1() != i8 && f.i0()) {
            } else {
            }
            if (f.i0()) {
            }
            i5 = i7;
            obj.n1((int)i21);
            if (f.i0()) {
            } else {
            }
            obj.n1(i22 -= z);
            obj.n1(obj.k1());
        }
        if (i5 != 0) {
            i11 = i18;
            while (i11 < size) {
                i5 = list.get(i11);
                if (i5 instanceof g && (g)(e)i5.j1() == i7) {
                }
                i11++;
                if ((g)i5.j1() == i7) {
                }
                h.b(i18, i5, b2, z4);
            }
        }
        h.b(i18, f, b2, z4);
        if (i != 0) {
            i11 = i18;
            while (i11 < size) {
                i5 = list.get(i11);
                if (i5 instanceof a && (a)(e)i5.o1() == 0) {
                }
                i11++;
                if ((a)i5.o1() == 0) {
                }
                h.c(i18, i5, b2, i18, z4);
            }
        }
        if (f.O() == e.b.FIXED) {
            f.z0(i18, f.v());
        } else {
            f.y0(i18);
        }
        i6 = i12;
        while (i3 < size) {
            i = list.get(i3);
            if (i instanceof g) {
            } else {
            }
            if (i instanceof a && (a)(e)i.o1() == i7) {
            }
            i3++;
            if ((a)i.o1() == i7) {
            }
            i6 = i7;
            if ((g)i.j1() == 0) {
            }
            if (i.k1() != i8) {
            } else {
            }
            if (i.l1() != i8 && f.j0()) {
            } else {
            }
            if (f.j0()) {
            }
            i12 = i7;
            i.n1((int)i16);
            if (f.j0()) {
            } else {
            }
            i.n1(i17 -= obj);
            i.n1(i.k1());
        }
        if (i12 != 0) {
            i3 = i18;
            while (i3 < size) {
                i12 = list.get(i3);
                if (i12 instanceof g && (g)(e)i12.j1() == 0) {
                }
                i3++;
                if ((g)i12.j1() == 0) {
                }
                h.i(i7, i12, b2);
            }
        }
        h.i(i18, f, b2);
        if (i6 != 0) {
            obj13 = i18;
            while (obj13 < size) {
                i3 = list.get(obj13);
                if (i3 instanceof a && (a)(e)i3.o1() == i7) {
                }
                obj13++;
                if ((a)i3.o1() == i7) {
                }
                h.c(i18, i3, b2, i7, z4);
            }
        }
        obj13 = i18;
        while (obj13 < size) {
            i3 = list.get(obj13);
            if ((e)i3.h0() && h.a(i18, i3)) {
            }
            obj13++;
            if (h.a(i18, i3)) {
            }
            f.I1(i18, i3, b2, h.a, b.a.k);
            if (i3 instanceof g) {
            } else {
            }
            h.b(i18, i3, b2, z4);
            h.i(i18, i3, b2);
            if ((g)i3.j1() == 0) {
            } else {
            }
            h.b(i18, i3, b2, z4);
            h.i(i18, i3, b2);
        }
    }

    private static void i(int i, e e2, d.f.a.m.m.b.b b$b3) {
        boolean z;
        Object iterator2;
        HashSet iterator;
        Object iterator3;
        boolean aVar2;
        d next3;
        HashSet set;
        int i2;
        int next2;
        int i5;
        HashSet next;
        int i3;
        int i4;
        boolean aVar4;
        int mATCH_CONSTRAINT3;
        e eVar;
        int i6;
        boolean aVar;
        boolean dVar;
        d cmp;
        Object mATCH_CONSTRAINT;
        boolean aVar3;
        Object mATCH_CONSTRAINT2;
        final Object obj = e2;
        final d.f.a.m.m.b.b bVar = b3;
        if (e2.k0()) {
        }
        final int i9 = 1;
        h.c = i7 += i9;
        z = i + 1;
        if (!obj instanceof f && e2.h0() && h.a(z, obj)) {
            if (e2.h0()) {
                z = i + 1;
                if (h.a(z, obj)) {
                    aVar2 = new b.a();
                    f.I1(z, obj, bVar, aVar2, b.a.k);
                }
            }
        }
        iterator2 = obj.m(d.b.TOP);
        next3 = obj.m(d.b.BOTTOM);
        next2 = iterator2.d();
        i5 = next3.d();
        i3 = 0;
        i4 = 8;
        mATCH_CONSTRAINT3 = 0;
        if (iterator2.c() != null && iterator2.m()) {
            if (iterator2.m()) {
                iterator2 = iterator2.c().iterator();
                while (iterator2.hasNext()) {
                    next = iterator2.next();
                    eVar = next.d;
                    i6 = i + 1;
                    boolean z4 = h.a(i6, eVar);
                    if (eVar.h0() && z4) {
                    }
                    mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
                    if (eVar.O() == mATCH_CONSTRAINT2) {
                    } else {
                    }
                    if (eVar.h0()) {
                    } else {
                    }
                    cmp = eVar.L;
                    if ((d)next == cmp && dVar7.f == null) {
                    } else {
                    }
                    mATCH_CONSTRAINT = eVar.N;
                    if ((d)next == mATCH_CONSTRAINT && mATCH_CONSTRAINT.f == null) {
                    } else {
                    }
                    next = mATCH_CONSTRAINT.f;
                    if ((d)next == cmp && next && next.m()) {
                    }
                    next = mATCH_CONSTRAINT.f;
                    if (next) {
                    }
                    if (next.m()) {
                    }
                    h.f(i6, bVar, eVar);
                    if (mATCH_CONSTRAINT.f == null) {
                    } else {
                    }
                    next = next2 - i13;
                    eVar.z0(next - i17, next);
                    h.i(i6, eVar, bVar);
                    if (dVar7.f == null) {
                    } else {
                    }
                    i14 += next2;
                    eVar.z0(next, i18 += next);
                    h.i(i6, eVar, bVar);
                    if (z4) {
                    } else {
                    }
                    if (eVar.O() == mATCH_CONSTRAINT2 && eVar.z >= 0 && eVar.y >= 0) {
                    }
                    if (eVar.z >= 0) {
                    }
                    if (eVar.y >= 0) {
                    }
                    if (eVar.Q() != i4) {
                    } else {
                    }
                    if (!eVar.f0()) {
                    }
                    if (!eVar.g0()) {
                    }
                    cmp = dVar6.f;
                    if ((d)next == eVar.L && cmp != null) {
                    } else {
                    }
                    next = dVar2.f;
                    if ((d)next == eVar.N && next != null && next.m()) {
                    } else {
                    }
                    next = mATCH_CONSTRAINT3;
                    if (next && !eVar.f0()) {
                    }
                    if (!eVar.f0()) {
                    }
                    h.g(i6, obj, bVar, eVar);
                    next = dVar2.f;
                    if (next != null) {
                    } else {
                    }
                    if (next.m()) {
                    } else {
                    }
                    next = i9;
                    cmp = dVar6.f;
                    if (cmp != null) {
                    } else {
                    }
                    if (!cmp.m()) {
                    } else {
                    }
                    if (eVar.t == 0 && Float.compare(f2, i3) == 0 && !eVar.f0() && !eVar.g0()) {
                    }
                    if (Float.compare(f2, i3) == 0) {
                    }
                    if (z4) {
                    }
                    aVar3 = new b.a();
                    f.I1(i6, eVar, bVar, aVar3, b.a.k);
                }
            }
        }
        if (obj instanceof g) {
        }
        if (next3.c() != null && next3.m()) {
            if (next3.m()) {
                iterator = next3.c().iterator();
                while (iterator.hasNext()) {
                    next3 = iterator.next();
                    next2 = next3.d;
                    next = i + 1;
                    eVar = h.a(next, next2);
                    if (next2.h0() && eVar) {
                    }
                    dVar = dVar4.f;
                    if ((d)next3 == next2.L && dVar != null) {
                    } else {
                    }
                    dVar = dVar3.f;
                    if ((d)next3 == next2.N && dVar != null && dVar.m()) {
                    } else {
                    }
                    i6 = mATCH_CONSTRAINT3;
                    mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                    if (next2.O() == mATCH_CONSTRAINT) {
                    } else {
                    }
                    if (next2.h0()) {
                    } else {
                    }
                    eVar = next2.L;
                    if ((d)next3 == eVar && dVar5.f == null) {
                    } else {
                    }
                    cmp = next2.N;
                    if ((d)next3 == cmp && eVar.f == null) {
                    } else {
                    }
                    if (i6 != 0 && next2.f0() == null) {
                    }
                    if (next2.f0() == null) {
                    }
                    h.f(next, bVar, next2);
                    if (eVar.f == null) {
                    } else {
                    }
                    next3 = i5 - i11;
                    next2.z0(next3 - i16, next3);
                    h.i(next, next2, bVar);
                    if (dVar5.f == null) {
                    } else {
                    }
                    i10 += i5;
                    next2.z0(next3, i15 += next3);
                    h.i(next, next2, bVar);
                    if (eVar) {
                    } else {
                    }
                    if (next2.O() == mATCH_CONSTRAINT && next2.z >= 0 && next2.y >= 0) {
                    }
                    if (next2.z >= 0) {
                    }
                    if (next2.y >= 0) {
                    }
                    if (next2.Q() != i4) {
                    } else {
                    }
                    if (next2.f0() == null) {
                    }
                    if (next2.g0() == null) {
                    }
                    if (i6 != 0) {
                    }
                    if (next2.f0() == null) {
                    }
                    h.g(next, obj, bVar, next2);
                    if (next2.t == null && Float.compare(f, i3) == null && next2.f0() == null && next2.g0() == null && i6 != 0 && next2.f0() == null) {
                    }
                    if (Float.compare(f, i3) == null) {
                    }
                    dVar = dVar3.f;
                    if (dVar != null) {
                    } else {
                    }
                    if (dVar.m()) {
                    } else {
                    }
                    i6 = i9;
                    dVar = dVar4.f;
                    if (dVar != null) {
                    } else {
                    }
                    if (!dVar.m()) {
                    } else {
                    }
                    if (eVar) {
                    }
                    aVar = new b.a();
                    f.I1(next, next2, bVar, aVar, b.a.k);
                }
            }
        }
        iterator3 = obj.m(d.b.BASELINE);
        if (iterator3.c() != null && iterator3.m()) {
            if (iterator3.m()) {
                iterator3 = iterator3.c().iterator();
                while (iterator3.hasNext()) {
                    next2 = iterator3.next();
                    i5 = next2.d;
                    next = i + 1;
                    i3 = h.a(next, i5);
                    if (i5.h0() && i3 != 0) {
                    }
                    if (i5.O() == e.b.MATCH_CONSTRAINT) {
                    } else {
                    }
                    if (i5.h0() != 0) {
                    } else {
                    }
                    if ((d)next2 == i5.O) {
                    }
                    i5.v0(i12 += set);
                    h.i(next, i5, bVar);
                    if (i3 != 0) {
                    }
                    if (i3 != 0) {
                    }
                    aVar4 = new b.a();
                    f.I1(next, i5, bVar, aVar4, b.a.k);
                }
            }
        }
        e2.m0();
    }
}
