package d.f.a.m.m;

import d.f.a.m.e;
import d.f.a.m.e.b;
import d.f.a.m.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    private f a;
    private boolean b = true;
    private boolean c = true;
    private f d;
    private ArrayList<d.f.a.m.m.p> e;
    private d.f.a.m.m.b.b f = null;
    private d.f.a.m.m.b.a g;
    ArrayList<d.f.a.m.m.m> h;
    public e(f f) {
        super();
        int i = 1;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        b.a aVar = new b.a();
        this.g = aVar;
        ArrayList arrayList3 = new ArrayList();
        this.h = arrayList3;
        this.a = f;
        this.d = f;
    }

    private void a(d.f.a.m.m.f f, int i2, int i3, d.f.a.m.m.f f4, ArrayList<d.f.a.m.m.m> arrayList5, d.f.a.m.m.m m6) {
        d.f.a.m.m.n next4;
        boolean next3;
        List next2;
        boolean next;
        List list3;
        List list;
        d.f.a.m.m.l lVar;
        int i;
        int i4;
        d.f.a.m.m.f fVar;
        ArrayList list2;
        d.f.a.m.m.m mVar;
        Iterator iterator;
        Object obj9;
        boolean obj11;
        d.f.a.m.m.m obj14;
        obj9 = f.d;
        next4 = this.a;
        if (obj9.c == null && obj9 != next4.d) {
            next4 = this.a;
            if (obj9 != next4.d) {
                if (obj9 == next4.e) {
                } else {
                    if (m6 == null) {
                        obj14 = new m(obj9, i3);
                        arrayList5.add(obj14);
                    }
                    obj9.c = obj14;
                    obj14.a(obj9);
                    obj11 = obj11.k.iterator();
                    while (obj11.hasNext()) {
                        next4 = obj11.next();
                        if (next4 instanceof f != null) {
                        }
                        this.a((f)(d)next4, i2, 0, f4, arrayList5, obj14);
                    }
                    obj11 = obj11.k.iterator();
                    while (obj11.hasNext()) {
                        next3 = obj11.next();
                        if (next3 instanceof f != null) {
                        }
                        this.a((f)(d)next3, i2, 1, f4, arrayList5, obj14);
                    }
                    obj11 = 1;
                    if (i2 == obj11 && obj9 instanceof n) {
                        if (obj9 instanceof n) {
                            iterator = fVar2.k.iterator();
                            while (iterator.hasNext()) {
                                next2 = iterator.next();
                                if (next2 instanceof f != null) {
                                }
                                this.a((f)(d)next2, i2, 2, f4, arrayList5, obj14);
                            }
                        }
                    }
                    Iterator iterator2 = fVar3.l.iterator();
                    while (iterator2.hasNext()) {
                        lVar = next6;
                        if ((f)lVar == f4) {
                        }
                        this.a((f)lVar, i2, 0, f4, arrayList5, obj14);
                        obj14.a = obj11;
                    }
                    iterator = fVar4.l.iterator();
                    while (iterator.hasNext()) {
                        lVar = next7;
                        if ((f)lVar == f4) {
                        }
                        this.a((f)lVar, i2, 1, f4, arrayList5, obj14);
                        obj14.a = obj11;
                    }
                    if (i2 == obj11 && obj9 instanceof n) {
                        if (obj9 instanceof n) {
                            obj9 = obj9.l.iterator();
                            for (Object obj11 : obj9) {
                                this.a((f)obj11, i2, 2, f4, arrayList5, obj14);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean b(f f) {
        int next;
        d.f.a.m.m.g gVar;
        float f2;
        int i2;
        int i5;
        int wRAP_CONTENT4;
        int i4;
        Object wRAP_CONTENT2;
        e.b mATCH_CONSTRAINT3;
        int mATCH_CONSTRAINT4;
        int mATCH_CONSTRAINT2;
        int mATCH_CONSTRAINT;
        int fIXED;
        e.b wRAP_CONTENT7;
        int wRAP_CONTENT6;
        int i;
        int wRAP_CONTENT3;
        e.b bVar;
        int i3;
        int wRAP_CONTENT;
        Object wRAP_CONTENT5;
        final Object obj = f;
        Iterator iterator = obj.u0.iterator();
        gVar = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            e.b[] objArr = next.V;
            wRAP_CONTENT2 = objArr[gVar];
            i = 1;
            wRAP_CONTENT4 = objArr[i];
            if ((e)next.Q() == 8) {
            } else {
            }
            wRAP_CONTENT3 = 1065353216;
            fIXED = 2;
            if (Float.compare(f14, wRAP_CONTENT3) < 0 && wRAP_CONTENT2 == e.b.MATCH_CONSTRAINT) {
            }
            if (Float.compare(f15, wRAP_CONTENT3) < 0 && wRAP_CONTENT4 == e.b.MATCH_CONSTRAINT) {
            }
            wRAP_CONTENT7 = 3;
            if (Float.compare(f16, i45) > 0) {
            }
            mATCH_CONSTRAINT3 = e.b.MATCH_CONSTRAINT;
            if (wRAP_CONTENT2 == mATCH_CONSTRAINT3 && next.s == i) {
            }
            wRAP_CONTENT6 = wRAP_CONTENT2;
            if (wRAP_CONTENT4 == mATCH_CONSTRAINT3 && next.t == i) {
            }
            bVar = wRAP_CONTENT4;
            d.f.a.m.m.l lVar11 = next.d;
            lVar11.d = wRAP_CONTENT6;
            wRAP_CONTENT2 = next.s;
            lVar11.a = wRAP_CONTENT2;
            d.f.a.m.m.n nVar11 = next.e;
            nVar11.d = bVar;
            i3 = next.t;
            nVar11.a = i3;
            wRAP_CONTENT4 = e.b.MATCH_PARENT;
            if (wRAP_CONTENT6 != wRAP_CONTENT4 && wRAP_CONTENT6 != e.b.FIXED) {
            } else {
            }
            if (bVar != wRAP_CONTENT4 && bVar != e.b.FIXED) {
            } else {
            }
            if (wRAP_CONTENT6 == wRAP_CONTENT4) {
            } else {
            }
            fIXED = i2;
            mATCH_CONSTRAINT3 = wRAP_CONTENT6;
            if (bVar == wRAP_CONTENT4) {
            } else {
            }
            wRAP_CONTENT6 = i5;
            wRAP_CONTENT7 = bVar;
            this.l(next, mATCH_CONSTRAINT3, fIXED, wRAP_CONTENT7, wRAP_CONTENT6);
            lVar10.e.d(next.R());
            nVar10.e.d(next.v());
            next.a = i;
            gVar = 0;
            wRAP_CONTENT6 = i5;
            wRAP_CONTENT7 = wRAP_CONTENT4;
            fIXED = i2;
            mATCH_CONSTRAINT3 = wRAP_CONTENT2;
            if (bVar != e.b.FIXED) {
            } else {
            }
            if (bVar == e.b.WRAP_CONTENT) {
            } else {
            }
            wRAP_CONTENT = 1056964608;
            if (wRAP_CONTENT6 == mATCH_CONSTRAINT3) {
            } else {
            }
            if (bVar == mATCH_CONSTRAINT3) {
            } else {
            }
            if (wRAP_CONTENT6 == mATCH_CONSTRAINT3 && bVar == mATCH_CONSTRAINT3) {
            }
            if (bVar == mATCH_CONSTRAINT3) {
            }
            if (wRAP_CONTENT2 != i) {
            } else {
            }
            wRAP_CONTENT7 = e.b.WRAP_CONTENT;
            this.l(next, wRAP_CONTENT7, 0, wRAP_CONTENT7, 0);
            gVar8.m = next.R();
            gVar.m = next.v();
            if (i3 == i) {
            } else {
            }
            wRAP_CONTENT4 = 2;
            wRAP_CONTENT4 = obj.V;
            wRAP_CONTENT7 = e.b.FIXED;
            if (i3 == wRAP_CONTENT4 && wRAP_CONTENT2 == wRAP_CONTENT4 && wRAP_CONTENT4[gVar] == wRAP_CONTENT7 && wRAP_CONTENT4[i] == wRAP_CONTENT7) {
            }
            if (wRAP_CONTENT2 == wRAP_CONTENT4) {
            }
            wRAP_CONTENT4 = obj.V;
            wRAP_CONTENT7 = e.b.FIXED;
            if (wRAP_CONTENT4[gVar] == wRAP_CONTENT7) {
            }
            if (wRAP_CONTENT4[i] == wRAP_CONTENT7) {
            }
            this.l(next, wRAP_CONTENT7, (int)i16, wRAP_CONTENT7, (int)i33);
            lVar9.e.d(next.R());
            nVar9.e.d(next.v());
            next.a = i;
            wRAP_CONTENT3 = e.b.WRAP_CONTENT;
            if (wRAP_CONTENT6 != wRAP_CONTENT3) {
            } else {
            }
            if (i3 == wRAP_CONTENT7) {
            } else {
            }
            if (i3 == i) {
            } else {
            }
            if (i3 == 2) {
            } else {
            }
            wRAP_CONTENT4 = next.S;
            if (wRAP_CONTENT5.f != null) {
            } else {
            }
            this.l(next, wRAP_CONTENT3, 0, bVar, 0);
            lVar6.e.d(next.R());
            nVar5.e.d(next.v());
            next.a = i;
            if (dVar.f == null) {
            } else {
            }
            fIXED = obj.V;
            wRAP_CONTENT3 = e.b.FIXED;
            if (fIXED[i] != wRAP_CONTENT3) {
            } else {
            }
            this.l(next, wRAP_CONTENT6, next.R(), wRAP_CONTENT3, (int)i12);
            lVar7.e.d(next.R());
            nVar6.e.d(next.v());
            next.a = i;
            if (fIXED[i] == wRAP_CONTENT4) {
            } else {
            }
            this.l(next, wRAP_CONTENT6, 0, wRAP_CONTENT3, 0);
            gVar.m = next.v();
            if (wRAP_CONTENT6 == wRAP_CONTENT3) {
            }
            fIXED = next.R();
            if (next.u() == -1) {
            }
            wRAP_CONTENT7 = e.b.FIXED;
            this.l(next, wRAP_CONTENT7, fIXED, wRAP_CONTENT7, (int)i27);
            lVar5.e.d(next.R());
            nVar4.e.d(next.v());
            next.a = i;
            f2 = i4 / f2;
            this.l(next, wRAP_CONTENT3, 0, wRAP_CONTENT3, 0);
            if (wRAP_CONTENT6 == e.b.FIXED) {
            } else {
            }
            wRAP_CONTENT5 = e.b.WRAP_CONTENT;
            if (bVar != wRAP_CONTENT5) {
            } else {
            }
            if (wRAP_CONTENT2 == wRAP_CONTENT7) {
            } else {
            }
            if (wRAP_CONTENT2 == i) {
            } else {
            }
            if (wRAP_CONTENT2 == fIXED) {
            } else {
            }
            fIXED = next.S;
            if (dVar11.f != null) {
            } else {
            }
            this.l(next, wRAP_CONTENT5, 0, bVar, 0);
            lVar2.e.d(next.R());
            nVar.e.d(next.v());
            next.a = i;
            if (dVar8.f == null) {
            } else {
            }
            wRAP_CONTENT3 = obj.V;
            fIXED = e.b.FIXED;
            if (wRAP_CONTENT3[gVar] != fIXED) {
            } else {
            }
            this.l(next, fIXED, (int)i7, bVar, next.v());
            lVar3.e.d(next.R());
            nVar2.e.d(next.v());
            next.a = i;
            if (wRAP_CONTENT3[gVar] == wRAP_CONTENT4) {
            } else {
            }
            this.l(next, wRAP_CONTENT5, 0, bVar, 0);
            gVar.m = next.R();
            if (bVar == wRAP_CONTENT5) {
            }
            wRAP_CONTENT6 = next.v();
            wRAP_CONTENT7 = e.b.FIXED;
            this.l(next, wRAP_CONTENT7, (int)i10, wRAP_CONTENT7, wRAP_CONTENT6);
            lVar4.e.d(next.R());
            nVar3.e.d(next.v());
            next.a = i;
            this.l(next, wRAP_CONTENT5, 0, wRAP_CONTENT5, 0);
            if (bVar == e.b.FIXED) {
            } else {
            }
            if (wRAP_CONTENT6 != e.b.FIXED) {
            } else {
            }
            if (wRAP_CONTENT6 == e.b.WRAP_CONTENT) {
            } else {
            }
            if (next.t == i) {
            }
            if (dVar4.f != null) {
            } else {
            }
            wRAP_CONTENT4 = e.b.WRAP_CONTENT;
            if (dVar5.f == null) {
            }
            if (next.s == i) {
            }
            if (dVar9.f != null) {
            } else {
            }
            wRAP_CONTENT2 = e.b.WRAP_CONTENT;
            if (dVar10.f == null) {
            }
            mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
            if (wRAP_CONTENT2 == mATCH_CONSTRAINT) {
            } else {
            }
            if (wRAP_CONTENT4 == mATCH_CONSTRAINT) {
            } else {
            }
            if (wRAP_CONTENT2 == mATCH_CONSTRAINT && wRAP_CONTENT4 == mATCH_CONSTRAINT && next.s == 0) {
            }
            if (wRAP_CONTENT4 == mATCH_CONSTRAINT) {
            }
            if (next.s == 0) {
            }
            if (next.t == 0) {
            }
            next.t = wRAP_CONTENT7;
            next.s = wRAP_CONTENT7;
            if (wRAP_CONTENT2 != e.b.WRAP_CONTENT) {
            } else {
            }
            next.t = wRAP_CONTENT7;
            if (wRAP_CONTENT2 == e.b.FIXED) {
            } else {
            }
            if (wRAP_CONTENT4 != e.b.WRAP_CONTENT) {
            } else {
            }
            next.s = wRAP_CONTENT7;
            if (wRAP_CONTENT4 == e.b.FIXED) {
            } else {
            }
            if (wRAP_CONTENT4 == e.b.MATCH_CONSTRAINT) {
            }
            next.t = fIXED;
            if (wRAP_CONTENT2 == e.b.MATCH_CONSTRAINT) {
            }
            next.s = fIXED;
            next.a = i;
        }
        return gVar;
    }

    private int e(f f, int i2) {
        int i3;
        int i;
        long l;
        i3 = 0;
        i = 0;
        while (i < this.h.size()) {
            i3 = Math.max(i3, obj2);
            i++;
        }
        return (int)i3;
    }

    private void i(d.f.a.m.m.p p, int i2, ArrayList<d.f.a.m.m.m> arrayList3) {
        int next;
        Object next4;
        boolean next2;
        boolean next3;
        boolean z;
        d.f.a.m.m.f fVar;
        Object obj;
        int i3;
        int i4;
        Object obj2;
        ArrayList list;
        int i;
        Object obj11;
        Iterator iterator = fVar2.k.iterator();
        while (iterator.hasNext()) {
            next4 = iterator.next();
            if (next4 instanceof f) {
            } else {
            }
            if (next4 instanceof p) {
            }
            this.a(next4.h, i2, 0, p.i, arrayList3, 0);
            this.a((f)(p)(d)next4, i2, 0, p.i, arrayList3, 0);
        }
        Iterator iterator2 = fVar3.k.iterator();
        while (iterator2.hasNext()) {
            next2 = iterator2.next();
            if (next2 instanceof f) {
            } else {
            }
            if (next2 instanceof p) {
            }
            this.a(next2.i, i2, 1, p.h, arrayList3, 0);
            this.a((f)(p)(d)next2, i2, 1, p.h, arrayList3, 0);
        }
        if (i2 == 1) {
            obj11 = obj11.k.iterator();
            while (obj11.hasNext()) {
                next = obj11.next();
                if (next instanceof f) {
                }
                this.a((f)(d)next, i2, 2, 0, arrayList3, 0);
            }
        }
    }

    private void l(e e, e.b e$b2, int i3, e.b e$b4, int i5) {
        final d.f.a.m.m.b.a aVar = this.g;
        aVar.a = b2;
        aVar.b = b4;
        aVar.c = i3;
        aVar.d = i5;
        this.f.b(e, aVar);
        e.b1(obj3.e);
        e.C0(obj3.f);
        e.B0(obj3.h);
        e.r0(obj3.g);
    }

    public void c() {
        d(this.e);
        this.h.clear();
        int i = 0;
        m.d = i;
        i(fVar.d, i, this.h);
        i(fVar2.e, 1, this.h);
        this.b = i;
    }

    public void d(ArrayList<d.f.a.m.m.p> arrayList) {
        Iterator iterator;
        int hashSet;
        boolean next2;
        Object next3;
        boolean next;
        d.f.a.m.m.j jVar;
        d.f.a.m.m.c cVar4;
        d.f.a.m.m.p cVar2;
        d.f.a.m.m.c cVar;
        d.f.a.m.m.p cVar3;
        int i;
        arrayList.clear();
        fVar.d.f();
        fVar2.e.f();
        arrayList.add(fVar3.d);
        arrayList.add(fVar4.e);
        Iterator iterator2 = fVar5.u0.iterator();
        hashSet = 0;
        while (iterator2.hasNext()) {
            next3 = iterator2.next();
            if (next3 instanceof g) {
            } else {
            }
            if ((e)next3.d0()) {
            } else {
            }
            arrayList.add(next3.d);
            if (next3.f0()) {
            } else {
            }
            arrayList.add(next3.e);
            if (next3 instanceof i) {
            }
            jVar = new k(next3);
            arrayList.add(jVar);
            if (next3.c == null) {
            }
            if (hashSet == null) {
            }
            hashSet.add(next3.c);
            hashSet = new HashSet();
            cVar = new c(next3, 1);
            next3.c = cVar;
            if (next3.b == null) {
            }
            if (hashSet == null) {
            }
            hashSet.add(next3.b);
            hashSet = new HashSet();
            cVar4 = new c(next3, 0);
            next3.b = cVar4;
            jVar = new j(next3);
            arrayList.add(jVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        iterator = arrayList.iterator();
        for (p hashSet : iterator) {
            hashSet.f();
        }
        final Iterator obj6 = arrayList.iterator();
        while (obj6.hasNext()) {
            iterator = obj6.next();
            if (iterator.b == this.d) {
            } else {
            }
            (p)iterator.d();
        }
    }

    public boolean f(boolean z) {
        int i2;
        d.f.a.m.m.n z2;
        boolean next;
        d.f.a.m.m.l lVar;
        int i;
        int next3;
        boolean next4;
        Object wRAP_CONTENT;
        e.b mATCH_PARENT2;
        boolean next2;
        e.b mATCH_PARENT;
        int obj10;
        i2 = 1;
        final int i3 = 0;
        if (!this.b) {
            if (this.c) {
                Iterator iterator = fVar5.u0.iterator();
                for (e next5 : iterator) {
                    next5.l();
                    next5.a = i3;
                    next5.d.r();
                    next5.e.q();
                }
                this.a.l();
                f fVar7 = this.a;
                fVar7.a = i3;
                fVar7.d.r();
                fVar8.e.q();
                this.c = i3;
            }
        } else {
        }
        if (b(this.d)) {
            return i3;
        }
        this.a.d1(i3);
        this.a.e1(i3);
        e.b bVar = this.a.s(i3);
        e.b bVar2 = this.a.s(i2);
        if (this.b) {
            c();
        }
        i = this.a.S();
        next3 = this.a.T();
        lVar3.h.d(i);
        nVar3.h.d(next3);
        m();
        wRAP_CONTENT = e.b.WRAP_CONTENT;
        if (bVar != wRAP_CONTENT) {
            if (bVar2 == wRAP_CONTENT && z &= i2 != 0) {
                if (z &= i2 != 0) {
                    wRAP_CONTENT = this.e.iterator();
                    while (wRAP_CONTENT.hasNext()) {
                        if (!(p)wRAP_CONTENT.next().m()) {
                            break;
                        } else {
                        }
                    }
                }
                if (obj10 != null && bVar == e.b.WRAP_CONTENT) {
                    if (bVar == e.b.WRAP_CONTENT) {
                        this.a.G0(e.b.FIXED);
                        f fVar20 = this.a;
                        fVar20.b1(e(fVar20, i3));
                        f fVar21 = this.a;
                        lVar6.e.d(fVar21.R());
                    }
                }
                if (obj10 != null && bVar2 == e.b.WRAP_CONTENT) {
                    if (bVar2 == e.b.WRAP_CONTENT) {
                        this.a.X0(e.b.FIXED);
                        obj10 = this.a;
                        obj10.C0(e(obj10, i2));
                        obj10 = this.a;
                        nVar4.e.d(obj10.v());
                    }
                }
            }
        } else {
        }
        obj10 = this.a;
        mATCH_PARENT2 = obj10.V;
        final e.b fIXED3 = e.b.FIXED;
        if (mATCH_PARENT2[i3] != fIXED3) {
            if (mATCH_PARENT2[i3] == e.b.MATCH_PARENT) {
                obj10 += i;
                lVar4.i.d(obj10);
                lVar5.e.d(obj10 -= i);
                m();
                obj10 = this.a;
                i = obj10.V;
                if (i[i2] != fIXED3) {
                    if (i[i2] == e.b.MATCH_PARENT) {
                        obj10 += next3;
                        nVar.i.d(obj10);
                        nVar2.e.d(obj10 -= next3);
                    }
                } else {
                }
                m();
                obj10 = i2;
            } else {
                obj10 = i3;
            }
        } else {
        }
        Iterator iterator2 = this.e.iterator();
        while (iterator2.hasNext()) {
            next3 = iterator2.next();
            if (next3.b == this.a && next3.g == null) {
            } else {
            }
            (p)next3.e();
            if (next3.g == null) {
            } else {
            }
        }
        Iterator iterator3 = this.e.iterator();
        for (p next4 : iterator3) {
        }
        this.a.G0(bVar);
        this.a.X0(bVar2);
        return i2;
    }

    public boolean g(boolean z) {
        d.f.a.m.m.g gVar3;
        d.f.a.m.m.g gVar;
        d.f.a.m.m.g gVar2;
        boolean obj5;
        final int i = 0;
        if (this.b) {
            obj5 = obj5.u0.iterator();
            for (e next2 : obj5) {
                next2.l();
                next2.a = i;
                d.f.a.m.m.l lVar = next2.d;
                gVar2.j = i;
                lVar.g = i;
                lVar.r();
                gVar3 = next2.e;
                gVar.j = i;
                gVar3.g = i;
                gVar3.q();
            }
            this.a.l();
            obj5 = this.a;
            obj5.a = i;
            obj5 = obj5.d;
            gVar4.j = i;
            obj5.g = i;
            obj5.r();
            obj5 = obj5.e;
            gVar3.j = i;
            obj5.g = i;
            obj5.q();
            c();
        }
        if (b(this.d)) {
            return i;
        }
        this.a.d1(i);
        this.a.e1(i);
        obj5.h.d(i);
        obj5.h.d(i);
        return 1;
    }

    public boolean h(boolean z, int i2) {
        int i3;
        int i4;
        e.b next2;
        boolean next3;
        Object wRAP_CONTENT;
        e.b mATCH_PARENT;
        boolean next;
        e.b fIXED;
        int i;
        int obj10;
        i3 = 1;
        final int i5 = 0;
        e.b bVar = this.a.s(i5);
        e.b bVar2 = this.a.s(i3);
        i4 = this.a.S();
        next2 = this.a.T();
        if (z &= i3 != 0) {
            wRAP_CONTENT = e.b.WRAP_CONTENT;
            if (bVar != wRAP_CONTENT) {
                if (bVar2 == wRAP_CONTENT) {
                    wRAP_CONTENT = this.e.iterator();
                    while (wRAP_CONTENT.hasNext()) {
                        next = wRAP_CONTENT.next();
                        if (next.f == i2) {
                            break;
                        } else {
                        }
                        if (!(p)next.m()) {
                            break;
                        } else {
                        }
                    }
                    if (i2 == 0) {
                        if (obj10 != null && bVar == e.b.WRAP_CONTENT) {
                            if (bVar == e.b.WRAP_CONTENT) {
                                this.a.G0(e.b.FIXED);
                                obj10 = this.a;
                                obj10.b1(e(obj10, i5));
                                obj10 = this.a;
                                lVar3.e.d(obj10.R());
                            }
                        }
                    } else {
                        if (obj10 != null && bVar2 == e.b.WRAP_CONTENT) {
                            if (bVar2 == e.b.WRAP_CONTENT) {
                                this.a.X0(e.b.FIXED);
                                obj10 = this.a;
                                obj10.C0(e(obj10, i3));
                                obj10 = this.a;
                                nVar3.e.d(obj10.v());
                            }
                        }
                    }
                }
            } else {
            }
        }
        if (i2 == 0) {
            obj10 = this.a;
            next2 = obj10.V;
            if (next2[i5] != e.b.FIXED) {
                if (next2[i5] == e.b.MATCH_PARENT) {
                    obj10 += i4;
                    lVar.i.d(obj10);
                    lVar2.e.d(obj10 -= i4);
                    obj10 = i3;
                } else {
                    obj10 = i5;
                }
            } else {
            }
        } else {
            obj10 = this.a;
            i4 = obj10.V;
            if (i4[i3] != e.b.FIXED) {
                if (i4[i3] == e.b.MATCH_PARENT) {
                    obj10 += next2;
                    nVar.i.d(obj10);
                    nVar2.e.d(obj10 -= next2);
                } else {
                }
            } else {
            }
        }
        m();
        Iterator iterator = this.e.iterator();
        while (iterator.hasNext()) {
            next2 = iterator.next();
            if (next2.f != i2) {
            } else {
            }
            if (next2.b == this.a && next2.g == null) {
            } else {
            }
            (p)next2.e();
            if (next2.g == null) {
            } else {
            }
        }
        Iterator iterator2 = this.e.iterator();
        while (iterator2.hasNext()) {
            next3 = iterator2.next();
            if (next3.f == i2) {
                break;
            } else {
            }
        }
        this.a.G0(bVar);
        this.a.X0(bVar2);
        return i3;
    }

    public void j() {
        this.b = true;
    }

    public void k() {
        this.c = true;
    }

    public void m() {
        Object next;
        boolean z;
        int i;
        Object obj;
        e.b bVar;
        int mATCH_CONSTRAINT;
        e.b wRAP_CONTENT;
        int i3;
        e.b bVar2;
        int i2;
        e.b fIXED;
        boolean z2;
        Iterator iterator = fVar.u0.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next.a) {
            } else {
            }
            e.b[] objArr = next.V;
            obj = 0;
            bVar2 = objArr[obj];
            i2 = 1;
            fIXED = objArr[i2];
            wRAP_CONTENT = e.b.WRAP_CONTENT;
            if (bVar2 != wRAP_CONTENT) {
            } else {
            }
            i = i2;
            if (fIXED != wRAP_CONTENT) {
            } else {
            }
            obj = i2;
            bVar = lVar3.e;
            mATCH_CONSTRAINT = bVar.j;
            i3 = nVar4.e;
            z2 = i3.j;
            if (mATCH_CONSTRAINT && z2) {
            } else {
            }
            if (mATCH_CONSTRAINT && obj != null) {
            } else {
            }
            if (z2 && i != 0) {
            }
            z = nVar.l;
            if (next.a && z != null) {
            }
            z = nVar.l;
            if (z != null) {
            }
            z.d((e)next.n());
            if (i != 0) {
            }
            this.l(next, wRAP_CONTENT, bVar.g, e.b.FIXED, i3.g);
            if (bVar2 == e.b.MATCH_CONSTRAINT) {
            } else {
            }
            lVar2.e.d(next.R());
            next.a = i2;
            i.m = next.R();
            if (obj != null) {
            } else {
            }
            this.l(next, e.b.FIXED, bVar.g, wRAP_CONTENT, i3.g);
            if (fIXED == e.b.MATCH_CONSTRAINT) {
            } else {
            }
            nVar2.e.d(next.v());
            next.a = i2;
            i.m = next.v();
            if (z2) {
            } else {
            }
            wRAP_CONTENT = e.b.FIXED;
            this.l(next, wRAP_CONTENT, bVar.g, wRAP_CONTENT, i3.g);
            next.a = i2;
            if (fIXED == e.b.MATCH_CONSTRAINT && next.t == i2) {
            }
            if (next.t == i2) {
            }
            if (bVar2 == e.b.MATCH_CONSTRAINT && next.s == i2) {
            } else {
            }
            i = obj;
            if (next.s == i2) {
            } else {
            }
        }
    }

    public void n(d.f.a.m.m.b.b b$b) {
        this.f = b;
    }
}
