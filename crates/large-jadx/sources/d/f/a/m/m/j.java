package d.f.a.m.m;

import d.f.a.m.e;
import d.f.a.m.g;
import java.util.List;

/* loaded from: classes.dex */
class j extends d.f.a.m.m.p {
    public j(e e) {
        super(e);
        e.d.f();
        e.e.f();
        this.f = (g)e.j1();
    }

    private void q(d.f.a.m.m.f f) {
        fVar.k.add(f);
        f.l.add(this.h);
    }

    @Override // d.f.a.m.m.p
    public void a(d.f.a.m.m.d d) {
        d.f.a.m.m.f obj3 = this.h;
        if (!obj3.c) {
        }
        if (obj3.j) {
        }
        this.h.d((int)obj3);
    }

    @Override // d.f.a.m.m.p
    void d() {
        Object list;
        d.f.a.m.m.f fVar;
        Object list2;
        d.f.a.m.m.f i2;
        int i;
        e eVar = this.b;
        i2 = (g)eVar.k1();
        i = eVar.l1();
        eVar.m1();
        final int i4 = 1;
        final int i5 = -1;
        if (eVar.j1() == i4) {
            if (i2 != i5) {
                fVar14.l.add(lVar8.h);
                fVar15.k.add(this.h);
                list2.f = i2;
            } else {
                if (i != i5) {
                    fVar11.l.add(lVar7.i);
                    fVar12.k.add(this.h);
                    list2.f = -i;
                } else {
                    d.f.a.m.m.f fVar9 = this.h;
                    fVar9.b = i4;
                    fVar9.l.add(lVar6.i);
                    fVar10.k.add(this.h);
                }
            }
            q(lVar3.h);
            q(lVar4.i);
        } else {
            if (i2 != i5) {
                fVar7.l.add(nVar8.h);
                fVar8.k.add(this.h);
                list.f = i2;
            } else {
                if (i != i5) {
                    fVar4.l.add(nVar7.i);
                    fVar5.k.add(this.h);
                    list.f = -i;
                } else {
                    d.f.a.m.m.f fVar2 = this.h;
                    fVar2.b = i4;
                    fVar2.l.add(nVar6.i);
                    fVar3.k.add(this.h);
                }
            }
            q(nVar3.h);
            q(nVar4.i);
        }
    }

    @Override // d.f.a.m.m.p
    public void e() {
        e eVar;
        int i;
        if ((g)this.b.j1() == 1) {
            this.b.d1(fVar.g);
        } else {
            this.b.e1(fVar2.g);
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        this.h.c();
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        return 0;
    }
}
