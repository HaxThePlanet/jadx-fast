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

/* compiled from: Direct.java */
/* loaded from: classes.dex */
public class h {

    private static b.a a;
    private static int b;
    private static int c;
    static {
        h.a = new b.a();
        int i = 0;
        h.b = i;
        h.c = i;
    }

    private static boolean a(int i, e eVar) {
        e.b bVar;
        int i2 = 0;
        e.b fIXED2;
        e.b fIXED22;
        boolean z5 = false;
        int i3;
        int cmp;
        boolean z2;
        e.b bVar2 = eVar.y();
        bVar = eVar.O();
        e eVar3 = eVar.I() != null ? (f)eVar3 : 0;
        if (i2 != 0) {
            fIXED22 = i2.y();
            fIXED23 = e.b.FIXED;
        }
        if (i2 != 0) {
            e.b bVar3 = i2.O();
            fIXED22 = e.b.FIXED;
        }
        fIXED2 = e.b.FIXED;
        float f2 = 0.0f;
        i3 = 0;
        i3 = 1;
        if (bVar2 == e.b.FIXED || !(eVar.i0() && bVar2 == e.b.WRAP_CONTENT && bVar2 != e.b.MATCH_CONSTRAINT)) {
        } else {
            if (eVar.s == 0) {
                if (eVar.Z != 0.0f || !eVar.V(i3)) {
                    if (bVar2 == e.b.MATCH_CONSTRAINT && eVar.s == i3) {
                        if (!(eVar.Y(i3, eVar.R()))) {
                        }
                    }
                }
            }
        }
        if (bVar == e.b.FIXED || !(eVar.j0() && bVar == e.b.WRAP_CONTENT && bVar != e.b.MATCH_CONSTRAINT)) {
        } else {
            if (eVar.t == 0) {
                if (eVar.Z != 0.0f || !eVar.V(i3)) {
                    if (bVar2 == e.b.MATCH_CONSTRAINT && eVar.t == i3) {
                        if (!(eVar.Y(i3, eVar.v()))) {
                        }
                    }
                }
            }
        }
        if (eVar.Z > 0.0f) {
            return e.b.MATCH_CONSTRAINT == 0 && eVar.t != 0 ? i3 : i3;
        }
        if (e.b.MATCH_CONSTRAINT != 0 && eVar.t != 0) {
        }
        return z5;
    }

    private static void b(int i, e eVar, b.b bVar, boolean z) {
        d item;
        int i5;
        HashSet set2;
        boolean z3 = false;
        d cmp;
        boolean z5;
        int i7;
        d dVar5;
        d dVar6;
        Object mATCH_CONSTRAINT2;
        final Object eVar22 = eVar;
        final d.f.a.m.m.b.b bVar32 = bVar;
        final boolean z42 = z;
        if (eVar.b0()) {
            return;
        }
        final int i2 = 1;
        h.b += i2;
        z = eVar22 instanceof f;
        if (!(eVar22 instanceof f) && eVar.h0()) {
            int i10 = i + 1;
            if (h.a(i10, eVar22)) {
                f.I1(i10, eVar22, bVar32, new b.a(), b.a.k);
            }
        }
        d dVar = eVar22.m(d.b.LEFT);
        item = eVar22.m(d.b.RIGHT);
        i5 = dVar.d();
        final int i18 = item.d();
        final float f2 = 0.0f;
        final int i25 = 8;
        if (dVar.c() != null && dVar.m()) {
            Iterator it2 = dVar.c().iterator();
            while (it2.hasNext()) {
                Object item2 = it2.next();
                i7 = i + 1;
                boolean z8 = h.a(i7, item2.d);
                mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
            }
        }
        if (eVar22 instanceof g) {
            return;
        }
        if (item.c() != null && item.m()) {
            Iterator it = item.c().iterator();
            while (it.hasNext()) {
                item = it.next();
                int i19 = i + 1;
                boolean z18 = h.a(i19, item.d);
                Object mATCH_CONSTRAINT22 = e.b.MATCH_CONSTRAINT;
            }
        }
        eVar.l0();
    }

    private static void c(int i, a aVar, b.b bVar, int i2, boolean z) {
        if (aVar.k1() && i2 == 0) {
            i2 = i + 1;
            h.b(i2, aVar, bVar, z);
        }
    }

    private static void d(int i, b.b bVar, e eVar, boolean z) {
        float f;
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        f = eVar.w();
        i2 = eVar.K.f.d();
        i3 = eVar.M.f.d();
        final float f5 = 0.5f;
        if (i2 == i3) {
            int i8 = f5;
        } else {
        }
        int i10 = eVar.R();
        i4 = (i3 - i2) - i10;
        if (eVar.K > eVar.M) {
            i4 = (i2 - i3) - i10;
        }
        if (eVar.M > 0) {
            f3 = (float)i4;
            f2 = (f * f3) + f5;
        } else {
            f3 = (float)i4;
            f2 = f * f3;
        }
        int i7 = (int)f2 + i2;
        i5 = i7 + i10;
        if (eVar.K > eVar.M) {
            i5 = i7 - i10;
        }
        eVar.w0(i7, i5);
        h.b(i + 1, eVar, bVar, z);
    }

    private static void e(int i, e eVar, b.b bVar, e eVar2, boolean z) {
        int max;
        int i5;
        int i6 = 8;
        int i10;
        i2 = eVar2.K.f.d() + eVar2.K.e();
        i3 = eVar2.M.f.d() - eVar2.M.e();
        if (eVar2.K >= eVar2.K.f) {
            max = eVar2.R();
            i6 = 8;
            float f2 = 0.5f;
            if (eVar2.Q() != 8) {
                i6 = 2;
                if (eVar2.s == 2) {
                    if (eVar instanceof f) {
                        i10 = eVar.R();
                    } else {
                        i10 = eVar.I().R();
                    }
                    f3 = (float)i10;
                    max = (int)(eVar2.w() * f2) * f3;
                } else {
                    if (eVar2.s == 0) {
                        max = i3 - i2;
                    }
                }
                if (eVar2.w > 0) {
                    max = Math.min(eVar2.w, Math.max(eVar2.v, max));
                }
            }
            i3 = (i3 - i2) - max;
            f = (eVar2.w() * (float)i3) + f2;
            i9 = (int)f;
            i2 = i2 + i9;
            i4 = max + i2;
            eVar2.w0(i2, i4);
            i7 = i + 1;
            h.b(i7, eVar2, bVar, z);
        }
    }

    private static void f(int i, b.b bVar, e eVar) {
        float f;
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        f = eVar.M();
        i2 = eVar.L.f.d();
        i3 = eVar.N.f.d();
        float f5 = 0.5f;
        if (i2 == i3) {
            int i8 = f5;
        } else {
        }
        int i10 = eVar.v();
        i4 = (i3 - i2) - i10;
        if (eVar.L > eVar.N) {
            i4 = (i2 - i3) - i10;
        }
        if (eVar.N > 0) {
            f3 = (float)i4;
            f2 = (f * f3) + f5;
        } else {
            f3 = (float)i4;
            f2 = f * f3;
        }
        int i7 = (int)f2;
        i5 = i2 + i7;
        i6 = i5 + i10;
        if (eVar.L > eVar.N) {
            i5 = i2 - i7;
            i6 = i5 - i10;
        }
        eVar.z0(i5, i6);
        h.i(i + 1, eVar, bVar);
    }

    private static void g(int i, e eVar, b.b bVar, e eVar2) {
        int max;
        int i5;
        int i6 = 8;
        int i10;
        float f = eVar2.M();
        i2 = eVar2.L.f.d() + eVar2.L.e();
        i3 = eVar2.N.f.d() - eVar2.N.e();
        if (eVar2.N.f >= eVar2.L) {
            max = eVar2.v();
            i6 = 8;
            float f2 = 0.5f;
            if (eVar2.Q() != 8) {
                i6 = 2;
                if (eVar2.t == 2) {
                    if (eVar instanceof f) {
                        i10 = eVar.v();
                    } else {
                        i10 = eVar.I().v();
                    }
                    f3 = (float)i10;
                    max = (int)(f * f2) * f3;
                } else {
                    if (eVar2.t == 0) {
                        max = i3 - i2;
                    }
                }
                if (eVar2.z > 0) {
                    max = Math.min(eVar2.z, Math.max(eVar2.y, max));
                }
            }
            i3 = (i3 - i2) - max;
            f = (f * (float)i3) + f2;
            i9 = (int)f;
            i2 = i2 + i9;
            i4 = max + i2;
            eVar2.z0(i2, i4);
            i7 = i + 1;
            h.i(i7, eVar2, bVar);
        }
    }

    public static void h(f fVar, b.b bVar) {
        int i;
        float f = 1056964608;
        boolean z2;
        int i6 = -1;
        Object item3;
        int i7;
        boolean z3;
        i = 0;
        h.b = i;
        h.c = i;
        fVar.p0();
        final ArrayList list = fVar.i1();
        final int size = list.size();
        while (i < size) {
            (e)list.get(i).p0();
            i = i + 1;
        }
        boolean z10 = fVar.F1();
        if (fVar.y() == e.b.FIXED) {
            fVar.w0(i, fVar.R());
        } else {
            fVar.x0(i);
        }
        f = 0.5f;
        i6 = -1;
        i = 1;
        while (i < size) {
            item3 = list.get(i);
            z3 = item3 instanceof g;
            i = i + 1;
        }
        if (e.b.FIXED != 0) {
            while (i < size) {
                Object item6 = list.get(i);
                i = i + 1;
            }
        }
        h.b(i, fVar, bVar, z10);
        if (i != 0) {
            while (i < size) {
                Object item7 = list.get(i);
                i = i + 1;
            }
        }
        if (fVar.O() == e.b.FIXED) {
            fVar.z0(i, fVar.v());
        } else {
            fVar.y0(i);
        }
        while (e.b.FIXED < size) {
            Object item8 = list.get(i);
            i = i + 1;
        }
        if (i != 0) {
            while (e.b.FIXED < size) {
                Object item5 = list.get(i);
                i = i + 1;
            }
        }
        h.i(i, fVar, bVar);
        if (e.b.FIXED != 0) {
            while (i < size) {
                Object item4 = list.get(i);
                i = i + 1;
            }
        }
        while (i < size) {
            Object item = list.get(i);
            i = i + 1;
        }
    }

    private static void i(int i, e eVar, b.b bVar) {
        d item;
        int i5;
        int i6;
        HashSet set3;
        boolean z3;
        float f = 0;
        int i7 = 8;
        int i2 = 0;
        d cmp;
        boolean z7;
        d dVar6;
        d dVar7;
        Object mATCH_CONSTRAINT2;
        final Object eVar22 = eVar;
        final d.f.a.m.m.b.b bVar32 = bVar;
        if (eVar.k0()) {
            return;
        }
        i2 = 1;
        h.c += i2;
        z = eVar22 instanceof f;
        if (!(eVar22 instanceof f) && eVar.h0()) {
            int i11 = i + 1;
            if (h.a(i11, eVar22)) {
                f.I1(i11, eVar22, bVar32, new b.a(), b.a.k);
            }
        }
        d dVar = eVar22.m(d.b.TOP);
        item = eVar22.m(d.b.BOTTOM);
        i5 = dVar.d();
        i6 = item.d();
        f = 0.0f;
        i7 = 8;
        i2 = 0;
        if (dVar.c() != null && dVar.m()) {
            Iterator it3 = dVar.c().iterator();
            while (it3.hasNext()) {
                Object item2 = it3.next();
                i2 = i + 1;
                boolean z22 = h.a(i2, item2.d);
                mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
            }
        }
        if (eVar22 instanceof g) {
            return;
        }
        if (item.c() != null && item.m()) {
            Iterator it = item.c().iterator();
            while (it.hasNext()) {
                item = it.next();
                int i21 = i + 1;
                boolean z20 = h.a(i21, item.d);
                Object mATCH_CONSTRAINT23 = e.b.MATCH_CONSTRAINT;
            }
        }
        d dVar2 = eVar22.m(d.b.BASELINE);
        if (dVar2.c() != null && dVar2.m()) {
            Iterator it2 = dVar2.c().iterator();
            while (it2.hasNext()) {
                Object item3 = it2.next();
                int i22 = i + 1;
                boolean z18 = h.a(i22, item3.d);
            }
        }
        eVar.m0();
    }
}
