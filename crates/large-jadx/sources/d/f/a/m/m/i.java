package d.f.a.m.m;

import d.f.a.m.a;
import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e.b;
import d.f.a.m.f;
import d.f.a.m.g;
import d.f.a.m.i;
import d.f.a.m.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Grouping.java */
/* loaded from: classes.dex */
public class i {
    public static o a(d.f.a.m.e eVar, int i, ArrayList<o> arrayList, o oVar) {
        d dVar;
        boolean z3;
        int size = 0;
        int size2;
        int i3;
        Object item;
        int r0 = i == 0 ? eVar.r0 : eVar.s0;
        size = 0;
        size = -1;
        if (i == size || oVar != null) {
            if (i != size) {
                return oVar;
            }
        } else {
            if (i != oVar.b) {
                while (oVar.b < arrayList.size()) {
                    item = arrayList.get(size);
                    if (item.c() == i) {
                        break;
                    }
                }
            }
        }
        if (item == null) {
            z3 = eVar instanceof i;
            if (eVar instanceof i && i7 != size) {
                while (size < arrayList.size()) {
                    item = arrayList.get(size);
                    if (item.c() == i7) {
                        break;
                    }
                }
            }
            if (item == null) {
                d.f.a.m.m.o oVar2 = new o(i);
            }
            arrayList.add(item);
        }
        if (oVar.a(eVar)) {
            z2 = eVar instanceof g;
            if (eVar instanceof g) {
                Object eVar2 = eVar;
                if (eVar2.j1() == 0) {
                    size = 1;
                }
                eVar2.i1().b(size, arrayList, oVar);
            }
            if (i == 0) {
                eVar.r0 = oVar.c();
                eVar.K.b(i, arrayList, oVar);
                eVar.M.b(i, arrayList, oVar);
            } else {
                eVar.s0 = oVar.c();
                eVar.L.b(i, arrayList, oVar);
                eVar.O.b(i, arrayList, oVar);
                eVar.N.b(i, arrayList, oVar);
            }
            eVar.R.b(i, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList<o> arrayList, int i) {
        i = 0;
        while (i < arrayList.size()) {
            Object item = arrayList.get(i);
            if (i == item.b) {
                return item;
            }
        }
        return null;
    }

    public static boolean c(f fVar, b.b bVar) {
        Iterator it;
        e.b bVar2;
        d.f.a.m.m.o oVar;
        int i = 0;
        boolean z2;
        boolean z3;
        d.f.a.e eVar;
        d dVar5;
        d dVar9;
        int i3 = 0;
        boolean z5;
        HashSet item3;
        HashSet item4;
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        int i7 = 1;
        int i8 = 1;
        int i6 = 0;
        e.b bVar4;
        int i9 = 0;
        d.f.a.m.m.o oVar2 = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        e.b bVar6;
        int i14 = 0;
        d.f.a.m.m.o oVar4 = null;
        d.f.a.m.m.o oVar3 = null;
        d.f.a.m.m.b.b bVar22;
        e.b bVar7;
        final Object fVar2 = fVar;
        ArrayList list = fVar.i1();
        int size2 = list.size();
        i = 0;
        while (i < size2) {
            Object item16 = list.get(i);
            if (!i.d(fVar.y(), fVar.O(), item16.y(), item16.O())) {
                return false;
            }
        }
        if (fVar2.A0 != null) {
            eVar.A += l3;
        }
        i4 = 0;
        i9 = 0;
        i10 = 0;
        i11 = 0;
        i12 = 0;
        i13 = 0;
        while (eVar.A < size2) {
            Object item = list.get(i);
            eVar = item instanceof g;
            z = item instanceof i;
        }
        ArrayList arrayList2 = new ArrayList();
        if (i4 != 0) {
            Iterator it15 = i4.iterator();
            while (it15.hasNext()) {
                i4 = 0;
                oVar3 = null;
                i.a((g)it15.next(), i4, arrayList2, oVar3);
            }
        }
        i5 = 0;
        i14 = 0;
        if (i9 != 0) {
            Iterator it14 = i9.iterator();
            while (it14.hasNext()) {
                Object item14 = it14.next();
                d.f.a.m.m.o oVar10 = i.a(item14, i5, arrayList2, oVar4);
                item14.i1(arrayList2, i5, oVar10);
                oVar10.b(arrayList2);
                i5 = 0;
                oVar4 = null;
            }
        }
        d dVar3 = fVar2.m(d.b.LEFT);
        if (dVar3.c() != null) {
            Iterator it3 = dVar3.c().iterator();
            while (it3.hasNext()) {
                i5 = 0;
                i.a((d)it3.next().d, i5, arrayList2, null);
            }
        }
        d dVar4 = fVar2.m(d.b.RIGHT);
        if (dVar4.c() != null) {
            Iterator it13 = dVar4.c().iterator();
            while (it13.hasNext()) {
                i5 = 0;
                i.a((d)it13.next().d, i5, arrayList2, null);
            }
        }
        dVar5 = fVar2.m(d.b.CENTER);
        if (dVar5.c() != null) {
            Iterator it12 = dVar5.c().iterator();
            while (it12.hasNext()) {
                i5 = 0;
                i.a((d)it12.next().d, i5, arrayList2, null);
            }
        }
        i6 = 0;
        oVar2 = null;
        if (i12 != 0) {
            Iterator it4 = i12.iterator();
            while (it4.hasNext()) {
                i.a((e)it4.next(), 0, arrayList2, oVar2);
            }
        }
        if (i10 != 0) {
            Iterator it11 = i10.iterator();
            while (it11.hasNext()) {
                i6 = 1;
                i.a((g)it11.next(), i6, arrayList2, oVar2);
            }
        }
        i7 = 1;
        if (i11 != 0) {
            Iterator it10 = i11.iterator();
            while (it10.hasNext()) {
                item3 = it10.next();
                d.f.a.m.m.o oVar11 = i.a(item3, i7, arrayList2, oVar2);
                item3.i1(arrayList2, i7, oVar11);
                oVar11.b(arrayList2);
                i7 = 1;
                oVar2 = null;
            }
        }
        d dVar6 = fVar2.m(d.b.TOP);
        if (dVar6.c() != null) {
            Iterator it9 = dVar6.c().iterator();
            while (it9.hasNext()) {
                i7 = 1;
                oVar2 = null;
                i.a((d)it9.next().d, i7, arrayList2, oVar2);
            }
        }
        d dVar7 = fVar2.m(d.b.BASELINE);
        if (dVar7.c() != null) {
            Iterator it8 = dVar7.c().iterator();
            while (it8.hasNext()) {
                i7 = 1;
                oVar2 = null;
                i.a((d)it8.next().d, i7, arrayList2, oVar2);
            }
        }
        d dVar8 = fVar2.m(d.b.BOTTOM);
        if (dVar8.c() != null) {
            Iterator it7 = dVar8.c().iterator();
            while (it7.hasNext()) {
                i7 = 1;
                oVar2 = null;
                i.a((d)it7.next().d, i7, arrayList2, oVar2);
            }
        }
        dVar9 = fVar2.m(d.b.CENTER);
        if (dVar9.c() != null) {
            Iterator it6 = dVar9.c().iterator();
            while (it6.hasNext()) {
                i7 = 1;
                i.a((d)it6.next().d, i7, arrayList2, null);
            }
        }
        i8 = 1;
        oVar = null;
        if (i13 != 0) {
            Iterator it5 = i13.iterator();
            while (it5.hasNext()) {
                i.a((e)it5.next(), 1, arrayList2, oVar);
            }
        }
        i3 = 0;
        while (fVar2.A0 < size2) {
            Object item7 = list.get(i3);
            i3 = i3 + 1;
        }
        if (arrayList2.size() <= 1) {
            return false;
        }
        if (fVar.y() == e.b.WRAP_CONTENT) {
            Iterator it2 = arrayList2.iterator();
            i8 = 0;
            while (it2.hasNext()) {
                Object item5 = it2.next();
                oVar2 = 1;
            }
            if (e.b.WRAP_CONTENT != null) {
                fVar2.G0(e.b.FIXED);
                fVar2.b1(i8);
                oVar.h(true);
            } else {
            }
        }
        if (fVar.O() == e.b.WRAP_CONTENT) {
            it = arrayList2.iterator();
            i8 = 0;
            while (it.hasNext()) {
                e.b item2 = it.next();
            }
            i2 = 0;
            z3 = true;
            if (item.L != null) {
                fVar2.X0(e.b.FIXED);
                fVar2.C0(i8);
                oVar.h(true);
            } else {
            }
        } else {
            i2 = 0;
            int i23 = 1;
        }
        if (e.b.WRAP_CONTENT != null || fVar2.A0 != null) {
        }
        return z3;
    }

    public static boolean d(e.b bVar, e.b bVar2, e.b bVar3, e.b bVar4) {
        e.b fIXED2;
        e.b wRAP_CONTENT2;
        e.b mATCH_PARENT2;
        int i;
        e.b wRAP_CONTENT22;
        fIXED2 = e.b.FIXED;
        i = 0;
        i = 1;
        if (bVar3 == e.b.FIXED || !(bVar3 == e.b.WRAP_CONTENT && bVar3 != e.b.MATCH_PARENT)) {
        } else {
            if (bVar == e.b.WRAP_CONTENT) {
            }
        }
        if (bVar4 == e.b.FIXED || !(bVar4 == e.b.WRAP_CONTENT && bVar4 != e.b.MATCH_PARENT)) {
        } else {
            if (bVar2 == e.b.WRAP_CONTENT) {
            }
        }
        return true;
    }
}
