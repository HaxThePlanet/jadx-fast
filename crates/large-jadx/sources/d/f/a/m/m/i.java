package d.f.a.m.m;

import d.f.a.m.a;
import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import d.f.a.m.f;
import d.f.a.m.g;
import d.f.a.m.i;
import d.f.a.m.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class i {
    public static d.f.a.m.m.o a(e e, int i2, ArrayList<d.f.a.m.m.o> arrayList3, d.f.a.m.m.o o4) {
        int i6;
        boolean i3;
        d z;
        int i;
        int i4;
        int size;
        int size2;
        int i5;
        Object obj6;
        Object obj9;
        i6 = i2 == 0 ? e.r0 : e.s0;
        i = 0;
        i4 = -1;
        if (i6 != i4) {
            if (o4 != null) {
                if (i6 != o4.b) {
                    size = i;
                    while (size < arrayList3.size()) {
                        size2 = arrayList3.get(size);
                        if ((o)size2.c() == i6) {
                            break;
                        } else {
                        }
                        size++;
                    }
                } else {
                    if (i6 != i4) {
                        return o4;
                    }
                }
            } else {
            }
        } else {
        }
        i6 = (i)e.j1(i2);
        if (obj9 == null && e instanceof i && i6 != i4) {
            if (e instanceof i) {
                i6 = (i)e.j1(i2);
                if (i6 != i4) {
                    i4 = i;
                    while (i4 < arrayList3.size()) {
                        size = arrayList3.get(i4);
                        if ((o)size.c() == i6) {
                            break;
                        } else {
                        }
                        i4++;
                    }
                }
            }
            if (obj9 == null) {
                obj9 = new o(i2);
            }
            arrayList3.add(obj9);
        }
        Object obj = e;
        if (obj9.a(e) && e instanceof g && obj.j1() == 0) {
            if (e instanceof g) {
                obj = e;
                if (obj.j1() == 0) {
                    i = 1;
                }
                (g)obj.i1().b(i, arrayList3, obj9);
            }
            if (i2 == 0) {
                e.r0 = obj9.c();
                e.K.b(i2, arrayList3, obj9);
                e.M.b(i2, arrayList3, obj9);
            } else {
                e.s0 = obj9.c();
                e.L.b(i2, arrayList3, obj9);
                e.O.b(i2, arrayList3, obj9);
                e.N.b(i2, arrayList3, obj9);
            }
            e.R.b(i2, arrayList3, obj9);
        }
        return obj9;
    }

    private static d.f.a.m.m.o b(ArrayList<d.f.a.m.m.o> arrayList, int i2) {
        int i;
        Object obj;
        int i3;
        i = 0;
        while (i < arrayList.size()) {
            obj = arrayList.get(i);
            i++;
        }
        return null;
    }

    public static boolean c(f f, d.f.a.m.m.b.b b$b2) {
        e.b iterator7;
        Object fIXED;
        int wRAP_CONTENT;
        int i11;
        boolean z3;
        d dVar;
        boolean arrayList5;
        int arrayList2;
        int i5;
        int i;
        d.f.a.e iterator;
        boolean z2;
        Object iterator2;
        Object iterator9;
        Object iterator5;
        Object iterator4;
        Object iterator8;
        Object iterator6;
        Object iterator3;
        int next;
        e.b wRAP_CONTENT2;
        int i7;
        boolean z;
        int next6;
        HashSet next2;
        HashSet next7;
        HashSet next9;
        HashSet next4;
        HashSet next5;
        HashSet next8;
        HashSet next3;
        int i2;
        e.b bVar5;
        int arrayList6;
        int i4;
        int i6;
        int i9;
        int i8;
        e.b bVar;
        int arrayList3;
        int i3;
        e.b bVar3;
        int arrayList7;
        int i12;
        int arrayList;
        int arrayList4;
        int i13;
        e.b bVar2;
        int i10;
        Object obj;
        d.f.a.m.m.b.b bVar6;
        e.b bVar4;
        final Object obj2 = f;
        ArrayList list = f.i1();
        int size2 = list.size();
        i11 = 0;
        i = i11;
        while (i < size2) {
            Object obj3 = list.get(i);
            i++;
        }
        iterator = obj2.A0;
        if (iterator != null) {
            iterator.A = l += bVar;
        }
        next6 = i11;
        arrayList6 = 0;
        arrayList3 = 0;
        arrayList7 = 0;
        arrayList = 0;
        arrayList4 = 0;
        i13 = 0;
        while (next6 < size2) {
            obj = list.get(next6);
            if (!i.d(f.y(), f.O(), (e)obj.y(), obj.O())) {
            } else {
            }
            bVar6 = b2;
            iterator = obj instanceof g;
            bVar2 = obj;
            if (iterator != null && (g)bVar2.j1() == 0 && arrayList7 == null) {
            }
            if (obj instanceof i) {
            }
            if (dVar2.f == null && dVar3.f == null && iterator == null && !obj instanceof a && arrayList4 == null) {
            }
            if (dVar4.f == null && dVar5.f == null && dVar6.f == null && iterator == null && !obj instanceof a && i13 == 0) {
            }
            next6++;
            i11 = 0;
            if (dVar5.f == null) {
            }
            if (dVar6.f == null) {
            }
            if (iterator == null) {
            }
            if (!obj instanceof a) {
            }
            if (i13 == 0) {
            }
            i13.add(obj);
            arrayList5 = new ArrayList();
            i13 = arrayList5;
            if (dVar3.f == null) {
            }
            if (iterator == null) {
            }
            if (!obj instanceof a) {
            }
            if (arrayList4 == null) {
            }
            arrayList4.add(obj);
            arrayList4 = new ArrayList();
            if (obj instanceof a) {
            } else {
            }
            z3 = obj;
            if (arrayList3 == null) {
            }
            arrayList3.add((i)z3);
            if (arrayList == null) {
            }
            arrayList.add(z3);
            arrayList = new ArrayList();
            arrayList3 = new ArrayList();
            z3 = obj;
            if ((a)z3.o1() == 0 && arrayList3 == null) {
            }
            if (z3.o1() == 1 && arrayList == null) {
            }
            if (arrayList == null) {
            }
            arrayList.add(z3);
            arrayList = new ArrayList();
            if (arrayList3 == null) {
            }
            arrayList3.add(z3);
            arrayList3 = new ArrayList();
            bVar2 = obj;
            if ((g)bVar2.j1() == 0) {
            }
            if (bVar2.j1() == 1 && arrayList6 == null) {
            }
            if (arrayList6 == null) {
            }
            arrayList6.add(bVar2);
            arrayList6 = new ArrayList();
            if (arrayList7 == null) {
            }
            arrayList7.add(bVar2);
            arrayList7 = new ArrayList();
            f.I1(i11, obj, b2, obj2.Q0, b.a.k);
        }
        arrayList2 = new ArrayList();
        if (arrayList6 != null) {
            iterator = arrayList6.iterator();
            for (g next6 : iterator) {
                i.a(next6, 0, arrayList2, 0);
            }
        }
        i4 = 0;
        i10 = 0;
        if (arrayList3 != null) {
            iterator = arrayList3.iterator();
            for (i next6 : iterator) {
                arrayList3 = i.a(next6, i4, arrayList2, i10);
                next6.i1(arrayList2, i4, arrayList3);
                arrayList3.b(arrayList2);
                i4 = 0;
                i10 = 0;
            }
        }
        iterator2 = obj2.m(d.b.LEFT);
        if (iterator2.c() != null) {
            iterator2 = iterator2.c().iterator();
            for (d next10 : iterator2) {
                i.a(next10.d, 0, arrayList2, 0);
            }
        }
        iterator9 = obj2.m(d.b.RIGHT);
        if (iterator9.c() != null) {
            iterator9 = iterator9.c().iterator();
            for (d next16 : iterator9) {
                i.a(next16.d, 0, arrayList2, 0);
            }
        }
        iterator5 = obj2.m(d.b.CENTER);
        if (iterator5.c() != null) {
            iterator5 = iterator5.c().iterator();
            for (d next15 : iterator5) {
                i.a(next15.d, 0, arrayList2, 0);
            }
        }
        i3 = 0;
        if (arrayList4 != null) {
            iterator5 = arrayList4.iterator();
            for (e next9 : iterator5) {
                i.a(next9, 0, arrayList2, i3);
            }
        }
        if (arrayList7 != null) {
            iterator5 = arrayList7.iterator();
            for (g next9 : iterator5) {
                i.a(next9, 1, arrayList2, i3);
            }
        }
        i9 = 1;
        if (arrayList != null) {
            iterator5 = arrayList.iterator();
            for (i next9 : iterator5) {
                arrayList7 = i.a(next9, i9, arrayList2, i3);
                next9.i1(arrayList2, i9, arrayList7);
                arrayList7.b(arrayList2);
                i9 = 1;
                i3 = 0;
            }
        }
        iterator4 = obj2.m(d.b.TOP);
        if (iterator4.c() != null) {
            iterator4 = iterator4.c().iterator();
            for (d next14 : iterator4) {
                i.a(next14.d, 1, arrayList2, 0);
            }
        }
        iterator8 = obj2.m(d.b.BASELINE);
        if (iterator8.c() != null) {
            iterator8 = iterator8.c().iterator();
            for (d next13 : iterator8) {
                i.a(next13.d, 1, arrayList2, 0);
            }
        }
        iterator6 = obj2.m(d.b.BOTTOM);
        if (iterator6.c() != null) {
            iterator6 = iterator6.c().iterator();
            for (d next12 : iterator6) {
                i.a(next12.d, 1, arrayList2, 0);
            }
        }
        iterator3 = obj2.m(d.b.CENTER);
        if (iterator3.c() != null) {
            iterator3 = iterator3.c().iterator();
            for (d next11 : iterator3) {
                i.a(next11.d, 1, arrayList2, 0);
            }
        }
        int i20 = 0;
        if (i13 != 0) {
            iterator3 = i13.iterator();
            for (e next3 : iterator3) {
                i.a(next3, 1, arrayList2, i20);
            }
        }
        next = 0;
        while (next < size2) {
            next3 = list.get(next);
            i8 = i.b(arrayList2, next3.r0);
            next3 = i.b(arrayList2, next3.s0);
            if ((e)next3.n0() && i8 != null && next3 != null) {
            }
            next++;
            i8 = i.b(arrayList2, next3.r0);
            next3 = i.b(arrayList2, next3.s0);
            if (i8 != null) {
            }
            if (next3 != null) {
            }
            i8.g(0, next3);
            next3.i(2);
            arrayList2.remove(i8);
        }
        if (arrayList2.size() <= 1) {
            return 0;
        }
        if (f.y() == e.b.WRAP_CONTENT) {
            iterator7 = arrayList2.iterator();
            wRAP_CONTENT = i20;
            i8 = 0;
            while (iterator7.hasNext()) {
                next = iterator7.next();
                if ((o)next.d() == 1) {
                } else {
                }
                next3 = null;
                next.h(next3);
                i3 = next.f(f.B1(), next3);
                if (i3 > i8) {
                }
                wRAP_CONTENT = next;
                i8 = i3;
            }
            if (wRAP_CONTENT != 0) {
                obj2.G0(e.b.FIXED);
                obj2.b1(i8);
                wRAP_CONTENT.h(true);
            } else {
                wRAP_CONTENT = i20;
            }
        } else {
        }
        if (f.O() == e.b.WRAP_CONTENT) {
            fIXED = arrayList2.iterator();
            arrayList2 = i20;
            i8 = 0;
            while (fIXED.hasNext()) {
                wRAP_CONTENT2 = fIXED.next();
                if ((o)wRAP_CONTENT2.d() == null) {
                } else {
                }
                wRAP_CONTENT2.h(null);
                i3 = wRAP_CONTENT2.f(f.B1(), 1);
                if (i3 > i8) {
                }
                arrayList2 = wRAP_CONTENT2;
                i8 = i3;
            }
            i2 = 0;
            if (arrayList2 != null) {
                obj2.X0(e.b.FIXED);
                obj2.C0(i8);
                arrayList2.h(true);
                i7 = arrayList2;
            } else {
                i7 = i20;
            }
        } else {
            i2 = 0;
            i12 = 1;
        }
        if (wRAP_CONTENT == 0) {
            if (i7 != 0) {
                i5 = i12;
            } else {
                i5 = i2;
            }
        } else {
        }
        return i5;
    }

    public static boolean d(e.b e$b, e.b e$b2, e.b e$b3, e.b e$b4) {
        e.b mATCH_PARENT2;
        e.b wRAP_CONTENT;
        e.b mATCH_PARENT;
        int obj5;
        int obj6;
        e.b obj7;
        mATCH_PARENT2 = e.b.FIXED;
        final int i = 0;
        final int i2 = 1;
        wRAP_CONTENT = e.b.WRAP_CONTENT;
        if (b3 != mATCH_PARENT2 && b3 != wRAP_CONTENT) {
            wRAP_CONTENT = e.b.WRAP_CONTENT;
            if (b3 != wRAP_CONTENT) {
                if (b3 == e.b.MATCH_PARENT && b != wRAP_CONTENT) {
                    if (b != wRAP_CONTENT) {
                        obj5 = i2;
                    } else {
                        obj5 = i;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        obj7 = e.b.WRAP_CONTENT;
        if (b4 != mATCH_PARENT2 && b4 != obj7) {
            obj7 = e.b.WRAP_CONTENT;
            if (b4 != obj7) {
                if (b4 == e.b.MATCH_PARENT && b2 != obj7) {
                    if (b2 != obj7) {
                        obj6 = i2;
                    } else {
                        obj6 = i;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (obj5 == null && obj6 != null) {
            if (obj6 != null) {
            }
            return i;
        }
        return i2;
    }
}
