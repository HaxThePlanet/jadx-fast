package d.f.a.m.m;

import d.f.a.m.a;
import d.f.a.m.e;
import d.f.a.m.i;
import java.util.Iterator;
import java.util.List;

/* compiled from: HelperReferences.java */
/* loaded from: classes.dex */
class k extends p {
    public k(e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.h.k.add(fVar);
        fVar.l.add(this.h);
    }

    @Override // d.f.a.m.m.p
    public void a(d dVar) {
        Iterator it;
        int i = 0;
        int i3 = eVar.m1();
        it = this.h.l.iterator();
        i = -1;
        i = 0;
        while (it.hasNext()) {
            int r4 = i;
        }
        if (i3 == 0 || i3 == 2) {
            i = i + eVar.n1();
            this.h.d(i);
        }
    }

    @Override // d.f.a.m.m.p
    void d() {
        d.f.a.m.m.f fVar;
        d.f.a.m.m.f fVar2;
        d.f.a.m.m.f fVar3;
        d.f.a.m.m.f fVar4;
        d.f.a.m.m.f.a rIGHT2;
        int i2 = 0;
        d.f.a.m.m.f fVar5;
        z = eVar instanceof a;
        if (eVar instanceof a) {
            boolean z3 = true;
            this.h.b = z3;
            int i3 = eVar.m1();
            boolean z2 = eVar.l1();
            int i = 8;
            i2 = 0;
            if (i3 == 0) {
                this.h.e = f.a.LEFT;
                while (i2 < eVar.v0) {
                    e eVar13 = eVar.u0[i2];
                    i2 = i2 + 1;
                }
                q(this.b.d.h);
                q(this.b.d.i);
            } else {
                if (i3 == z3) {
                    this.h.e = f.a.RIGHT;
                    while (i2 < eVar.v0) {
                        e eVar10 = eVar.u0[i2];
                        i2 = i2 + 1;
                    }
                    q(this.b.d.h);
                    q(this.b.d.i);
                } else {
                    if (i3 == 2) {
                        this.h.e = f.a.TOP;
                        while (i2 < eVar.v0) {
                            e eVar11 = eVar.u0[i2];
                            i2 = i2 + 1;
                        }
                        q(this.b.e.h);
                        q(this.b.e.i);
                    } else {
                        if (i3 == 3) {
                            this.h.e = f.a.BOTTOM;
                            while (i2 < eVar.v0) {
                                e eVar12 = eVar.u0[i2];
                                i2 = i2 + 1;
                            }
                            q(this.b.e.h);
                            q(this.b.e.i);
                        }
                    }
                }
            }
        }
    }

    @Override // d.f.a.m.m.p
    public void e() {
        z = eVar instanceof a;
        if (eVar instanceof a) {
            int i = eVar.m1();
            if (i == 0 || i == 1) {
                this.b.d1(this.h.g);
            }
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        this.c = null;
        this.h.c();
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        return false;
    }
}
