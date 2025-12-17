package d.f.a.m.m;

import d.f.a.m.a;
import d.f.a.m.e;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class k extends d.f.a.m.m.p {
    public k(e e) {
        super(e);
    }

    private void q(d.f.a.m.m.f f) {
        fVar.k.add(f);
        f.l.add(this.h);
    }

    @Override // d.f.a.m.m.p
    public void a(d.f.a.m.m.d d) {
        d.f.a.m.m.f fVar;
        Iterator iterator;
        int i3;
        int i;
        int i2;
        int obj7;
        obj7 = this.b;
        int i4 = (a)obj7.m1();
        iterator = fVar2.l.iterator();
        final int i5 = -1;
        i3 = 0;
        i = i5;
        while (iterator.hasNext()) {
            i2 = next2.g;
            if (i != i5) {
            } else {
            }
            i = i2;
            if (i3 < i2) {
            }
            i3 = i2;
            if (i2 < i) {
            }
        }
        if (i4 != 0) {
            if (i4 == 2) {
                this.h.d(i += obj7);
            } else {
                this.h.d(i3 += obj7);
            }
        } else {
        }
    }

    @Override // d.f.a.m.m.p
    void d() {
        Object eVar;
        d.f.a.m.m.f fVar2;
        d.f.a.m.m.f fVar3;
        d.f.a.m.m.f fVar4;
        d.f.a.m.m.f fVar;
        boolean i3;
        d.f.a.m.m.f.a bOTTOM;
        boolean z;
        int i2;
        int i;
        d.f.a.m.m.f fVar5;
        eVar = this.b;
        if (eVar instanceof a) {
            int i4 = 1;
            fVar10.b = i4;
            i3 = (a)eVar.m1();
            z = eVar.l1();
            i2 = 8;
            i = 0;
            if (i3 != 0) {
                if (i3 != i4) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                        } else {
                            fVar4.e = f.a.BOTTOM;
                            while (i < eVar.v0) {
                                fVar4 = eVar.u0[i];
                                if (!z && fVar4.Q() == i2) {
                                } else {
                                }
                                fVar4 = nVar6.i;
                                fVar4.k.add(this.h);
                                fVar13.l.add(fVar4);
                                i++;
                                if (fVar4.Q() == i2) {
                                } else {
                                }
                            }
                            q(nVar3.h);
                            q(nVar4.i);
                        }
                    } else {
                        fVar3.e = f.a.TOP;
                        while (i < eVar.v0) {
                            fVar3 = eVar.u0[i];
                            if (!z && fVar3.Q() == i2) {
                            } else {
                            }
                            fVar3 = nVar5.h;
                            fVar3.k.add(this.h);
                            fVar12.l.add(fVar3);
                            i++;
                            if (fVar3.Q() == i2) {
                            } else {
                            }
                        }
                        q(nVar.h);
                        q(nVar2.i);
                    }
                } else {
                    fVar2.e = f.a.RIGHT;
                    while (i < eVar.v0) {
                        fVar2 = eVar.u0[i];
                        if (!z && fVar2.Q() == i2) {
                        } else {
                        }
                        fVar2 = lVar5.i;
                        fVar2.k.add(this.h);
                        fVar11.l.add(fVar2);
                        i++;
                        if (fVar2.Q() == i2) {
                        } else {
                        }
                    }
                    q(lVar.h);
                    q(lVar2.i);
                }
            } else {
                fVar.e = f.a.LEFT;
                while (i < eVar.v0) {
                    fVar = eVar.u0[i];
                    if (!z && fVar.Q() == i2) {
                    } else {
                    }
                    fVar = lVar6.h;
                    fVar.k.add(this.h);
                    fVar14.l.add(fVar);
                    i++;
                    if (fVar.Q() == i2) {
                    } else {
                    }
                }
                q(lVar3.h);
                q(lVar4.i);
            }
        }
    }

    @Override // d.f.a.m.m.p
    public void e() {
        e eVar;
        boolean z;
        eVar = this.b;
        if (eVar instanceof a) {
            int i = (a)eVar.m1();
            if (i != 0) {
                if (i == 1) {
                    this.b.d1(fVar.g);
                } else {
                    this.b.e1(fVar2.g);
                }
            } else {
            }
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        this.c = 0;
        this.h.c();
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        return 0;
    }
}
