package d.f.a.m.m;

import d.f.a.m.d;
import d.f.a.m.e;
import d.f.a.m.e.b;
import d.f.a.m.f;
import d.f.a.m.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: DependencyGraph.java */
/* loaded from: classes.dex */
public class e {

    private f a;
    private boolean b = true;
    private boolean c = true;
    private f d;
    private ArrayList<p> e = new ArrayList<>();
    private b.b f = null;
    private b.a g = new b$a();
    ArrayList<m> h = new ArrayList<>();
    public e(f fVar) {
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        d.f.a.m.m.b.a aVar = new b.a();
        ArrayList arrayList3 = new ArrayList();
        this.a = fVar;
        this.d = fVar;
    }

    private void a(f fVar, int i, int i2, f fVar2, ArrayList<m> arrayList, m mVar) {
        boolean hasNext3;
        d.f.a.m.m.l lVar;
        int i22;
        d.f.a.m.m.f fVar42;
        ArrayList arrayList52;
        d.f.a.m.m.m mVar62;
    }

    private boolean b(f fVar) {
        float f;
        int i4;
        e eVar;
        d dVar;
        e.b mATCH_PARENT2;
        int i2 = 2;
        int i3 = 0;
        d dVar2;
        e.b wRAP_CONTENT2;
        e.b wRAP_CONTENT22;
        d dVar3;
        int i9;
        float f2 = 1056964608;
        e.b fIXED2;
        final Object fVar2 = fVar;
        Iterator it = fVar2.u0.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object item = it.next();
            eVar = objArr4[i10];
            int i8 = 1;
            i4 = objArr4[i8];
            i2 = 8;
        }
        return false;
    }

    private int e(f fVar, int i) {
        int max = 0;
        max = 0;
        i = 0;
        while (i < this.h.size()) {
            max = Math.max(max, (m)this.h.get(i).b(fVar, i));
            i = i + 1;
        }
        return (int)max;
    }

    private void i(p pVar, int i, ArrayList<m> arrayList) {
        boolean hasNext2;
        boolean z;
        d.f.a.m.m.f fVar;
        d.f.a.m.m.f fVar2;
        int i22 = 0;
        int i3 = 0;
        d.f.a.m.m.f fVar3;
        ArrayList arrayList32 = null;
        d.f.a.m.m.m mVar = null;
        Iterator it2 = pVar.h.k.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            z = item instanceof f;
        }
        Iterator it3 = pVar.i.k.iterator();
        while (it3.hasNext()) {
            Object item3 = it3.next();
            z = item3 instanceof f;
        }
        i = 1;
        if (i == 1) {
            Iterator it = pVar.k.k.iterator();
            while (it.hasNext()) {
                Object item2 = it.next();
                hasNext2 = item2 instanceof f;
            }
        }
    }

    private void l(e eVar, e.b bVar, int i, e.b bVar2, int i2) {
        this.g.a = bVar;
        this.g.b = bVar2;
        this.g.c = i;
        this.g.d = i2;
        this.f.b(eVar, this.g);
        eVar.b1(this.g.e);
        eVar.C0(this.g.f);
        eVar.B0(this.g.h);
        eVar.r0(this.g.g);
    }

    public void c() {
        d(this.e);
        this.h.clear();
        int i = 0;
        m.d = i;
        i(this.a.d, i, this.h);
        i(this.a.e, 1, this.h);
        this.b = false;
    }

    public void d(ArrayList<p> arrayList) {
        java.util.Collection item2 = null;
        int i;
        arrayList.clear();
        this.d.d.f();
        this.d.e.f();
        arrayList.add(this.d.d);
        arrayList.add(this.d.e);
        Iterator it = this.d.u0.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object item3 = it.next();
        }
        if (item2 != null) {
            arrayList.addAll(item2);
        }
        Iterator item = arrayList.iterator();
        while (item.hasNext()) {
            (p)item.next().f();
        }
        final Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            item = it2.next();
        }
    }

    public boolean f(boolean z) {
        boolean z2 = true;
        e.b bVar;
        d.f.a.m.m.l lVar;
        Object item;
        e.b wRAP_CONTENT2;
        e.b mATCH_PARENT2;
        boolean z4;
        boolean hasNext4;
        e.b mATCH_PARENT22;
        int i4;
        int i = 1;
        i4 = z & i;
        z2 = false;
        if (this.b || this.c) {
            Iterator it = this.a.u0.iterator();
            while (it.hasNext()) {
                Object item2 = it.next();
                item2.l();
                item2.a = z2;
                item2.d.r();
                item2.e.q();
            }
            this.a.l();
            this.a.a = z2;
            fVar8.d.r();
            this.a.e.q();
            this.c = z2;
        }
        if (b(this.d)) {
            return false;
        }
        this.a.d1(z2);
        this.a.e1(z2);
        e.b bVar2 = this.a.s(z2);
        e.b bVar3 = this.a.s(i);
        if (this.b) {
            c();
        }
        int i2 = this.a.S();
        int i3 = this.a.T();
        this.a.d.h.d(i2);
        this.a.e.h.d(i3);
        m();
        wRAP_CONTENT2 = e.b.WRAP_CONTENT;
        if (bVar2 == e.b.WRAP_CONTENT || bVar3 == e.b.WRAP_CONTENT) {
            if (z & i != 0) {
                Iterator it4 = this.e.iterator();
                while (it4.hasNext()) {
                    if (!(p)it4.next().m()) {
                        break;
                    }
                }
            }
            if (i4 != 0 && bVar2 == e.b.WRAP_CONTENT) {
                this.a.G0(e.b.FIXED);
                this.a.b1(e(this.a, z2));
                fVar22.d.e.d(this.a.R());
            }
            if (e.b.WRAP_CONTENT != 0 && bVar3 == e.b.WRAP_CONTENT) {
                this.a.X0(e.b.FIXED);
                this.a.C0(e(this.a, i));
                fVar30.e.e.d(this.a.v());
            }
        }
        final e.b fIXED23 = e.b.FIXED;
        if (objArr2[z2] != e.b.FIXED) {
            if (objArr2[z2] == e.b.MATCH_PARENT) {
                int i9 = this.a.R() + i2;
                this.a.d.i.d(i9);
                this.a.d.e.d(i9 - i2);
                m();
                if (objArr[i] != e.b.FIXED) {
                    if (objArr[i] == e.b.MATCH_PARENT) {
                        int i12 = this.a.v() + i3;
                        this.a.e.i.d(i12);
                        this.a.e.e.d(i12 - i3);
                    }
                }
                m();
            } else {
            }
        }
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            Object item3 = it2.next();
        }
        Iterator it3 = this.e.iterator();
        while (it3.hasNext()) {
            item = it3.next();
            if (this.a) {
            }
        }
        this.a.G0(bVar2);
        this.a.X0(bVar3);
        return z2;
    }

    public boolean g(boolean z) {
        d.f.a.m.m.g gVar2;
        d.f.a.m.m.g gVar3;
        final boolean z3 = false;
        if (this.b) {
            Iterator it = this.a.u0.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                item.l();
                item.a = z3;
                lVar.e.j = z3;
                item.d.g = z3;
                item.d.r();
                nVar.e.j = z3;
                item.e.g = z3;
                item.e.q();
            }
            this.a.l();
            this.a.a = z3;
            lVar3.e.j = z3;
            fVar10.d.g = z3;
            fVar10.d.r();
            nVar3.e.j = z3;
            this.a.e.g = z3;
            this.a.e.q();
            c();
        }
        if (b(this.d)) {
            return false;
        }
        this.a.d1(z3);
        this.a.e1(z3);
        this.a.d.h.d(z3);
        this.a.e.h.d(z3);
        return true;
    }

    public boolean h(boolean z, int i) {
        boolean z3 = true;
        int i3;
        e.b item;
        Object item2;
        d.f.a.m.m.g gVar;
        e.b mATCH_PARENT2;
        boolean z2;
        e.b fIXED2;
        boolean hasNext3;
        int i5;
        i = 1;
        i = z & i;
        i = 0;
        e.b bVar = this.a.s(i);
        e.b bVar2 = this.a.s(i);
        i3 = this.a.S();
        int i7 = this.a.T();
        if (z & i != 0) {
            e.b wRAP_CONTENT2 = e.b.WRAP_CONTENT;
            if (bVar == e.b.WRAP_CONTENT || bVar2 == e.b.WRAP_CONTENT) {
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    Object item3 = it.next();
                    if (item3.f == i && !item3.m()) {
                        break;
                    }
                }
                if (i == 0) {
                    if (e.b.WRAP_CONTENT != 0 && bVar == e.b.WRAP_CONTENT) {
                        this.a.G0(e.b.FIXED);
                        this.a.b1(e(this.a, i));
                        fVar18.d.e.d(this.a.R());
                    }
                } else {
                    if (this.a != 0 && bVar2 == e.b.WRAP_CONTENT) {
                        this.a.X0(e.b.FIXED);
                        this.a.C0(e(this.a, i));
                        fVar21.e.e.d(this.a.v());
                    }
                }
            }
        }
        if (i == 0) {
            if (objArr2[i] != e.b.FIXED) {
                if (objArr2[i] == e.b.MATCH_PARENT) {
                    int i12 = this.a.R() + i3;
                    this.a.d.i.d(i12);
                    i6 = i12 - i3;
                    this.a.d.e.d(i6);
                } else {
                }
            }
        } else {
            if (objArr[i] != e.b.FIXED) {
                if (objArr[i] == e.b.MATCH_PARENT) {
                    int i14 = this.a.v() + i7;
                    this.a.e.i.d(i14);
                    i6 = i14 - i7;
                    this.a.e.e.d(i6);
                }
            }
        }
        m();
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            item = it2.next();
        }
        Iterator it3 = this.e.iterator();
        while (it3.hasNext()) {
            item2 = it3.next();
            if (item2.f == i) {
            }
        }
        this.a.G0(bVar);
        this.a.X0(bVar2);
        return z3;
    }

    public void j() {
        this.b = true;
    }

    public void k() {
        this.c = true;
    }

    public void m() {
        int i;
        e eVar;
        e.b fIXED2;
        int i2;
        e.b mATCH_CONSTRAINT2;
        int i3;
        e.b bVar;
        boolean z2;
        Iterator it = this.a.u0.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
    }

    public void n(b.b bVar) {
        this.f = bVar;
    }
}
