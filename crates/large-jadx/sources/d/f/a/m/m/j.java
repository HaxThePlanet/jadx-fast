package d.f.a.m.m;

import d.f.a.m.e;
import d.f.a.m.g;
import java.util.List;

/* compiled from: GuidelineReference.java */
/* loaded from: classes.dex */
class j extends p {
    public j(e eVar) {
        super(eVar);
        eVar.d.f();
        eVar.e.f();
        this.f = eVar.j1();
    }

    private void q(f fVar) {
        this.h.k.add(fVar);
        fVar.l.add(this.h);
    }

    @Override // d.f.a.m.m.p
    public void a(d dVar) {
        if (!fVar2.c) {
            return;
        }
        if (fVar2.j) {
            return;
        }
        this.h.d((int)(float)(f)fVar2.l.get(0).g * (g)this.b.m1() + 0.5f);
    }

    @Override // d.f.a.m.m.p
    void d() {
        d.f.a.m.m.f fVar2;
        int i;
        int i3 = eVar.k1();
        i = eVar.l1();
        eVar.m1();
        final int i6 = 1;
        final int i7 = -1;
        if (eVar.j1() == i6) {
            if (i3 != i7) {
                this.h.l.add(this.b.W.d.h);
                this.b.W.d.h.k.add(this.h);
                this.h.f = i3;
            } else {
                if (i != i7) {
                    this.h.l.add(this.b.W.d.i);
                    this.b.W.d.i.k.add(this.h);
                    this.h.f = -i;
                } else {
                    this.h.b = true;
                    fVar12.l.add(this.b.W.d.i);
                    this.b.W.d.i.k.add(this.h);
                }
            }
            q(this.b.d.h);
            q(this.b.d.i);
        } else {
            if (i3 != i7) {
                this.h.l.add(this.b.W.e.h);
                this.b.W.e.h.k.add(this.h);
                this.h.f = i3;
            } else {
                if (i != i7) {
                    this.h.l.add(this.b.W.e.i);
                    this.b.W.e.i.k.add(this.h);
                    this.h.f = -i;
                } else {
                    this.h.b = true;
                    fVar3.l.add(this.b.W.e.i);
                    this.b.W.e.i.k.add(this.h);
                }
            }
            q(this.b.e.h);
            q(this.b.e.i);
        }
    }

    @Override // d.f.a.m.m.p
    public void e() {
        if ((g)this.b.j1() == 1) {
            this.b.d1(this.h.g);
        } else {
            this.b.e1(this.h.g);
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        this.h.c();
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        return false;
    }
}
