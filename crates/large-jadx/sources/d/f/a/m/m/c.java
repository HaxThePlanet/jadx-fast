package d.f.a.m.m;

import d.f.a.m.d;
import d.f.a.m.e;
import d.f.a.m.e.b;
import d.f.a.m.f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChainRun.java */
/* loaded from: classes.dex */
public class c extends p {

    ArrayList<p> k = new ArrayList<>();
    private int l;
    public c(e eVar, int i) {
        super(eVar);
        final ArrayList arrayList = new ArrayList();
        this.f = i;
        q();
    }

    private void q() {
        e item;
        e eVar;
        int size = 0;
        int i2;
        d.f.a.m.m.p pVar;
        item = this.b.J(this.f);
        while (this.b != null) {
            item = item.J(this.f);
        }
        this.b = item;
        this.k.add(item.L(this.f));
        eVar = item.H(this.f);
        while (this.b != null) {
            this.k.add(eVar.L(this.f));
            eVar = eVar.H(this.f);
        }
        Iterator it = this.k.iterator();
        pVar = 1;
        while (it.hasNext()) {
            item = it.next();
        }
        if (this.f == 0) {
            d.f.a.m.m.p r0 = (f)this.b.I().F1() ? pVar : 0;
        }
        if (this.k != 0 && this.k.size() > pVar) {
            this.b = (p)this.k.get(this.k.size() - pVar).b;
        }
        if (this.f == 0) {
            i2 = this.b.x();
        } else {
            i2 = this.b.N();
        }
        this.l = i2;
    }

    private e r() {
        int i = 0;
        i = 0;
        while (i < this.k.size()) {
            Object item = this.k.get(i);
            int i3 = 8;
            if (item.b.Q() != 8) {
                return item.b;
            }
        }
        return null;
    }

    private e s() {
        int i;
        i = this.k.size() - 1;
        while (this.k >= 0) {
            Object item = this.k.get(i);
            int i3 = 8;
            if (item.b.Q() != 8) {
                return item.b;
            }
        }
        return null;
    }

    @Override // d.f.a.m.m.p
    public void a(d dVar) {
        int i = 0;
        int max;
        int i2 = 0;
        d.f.a.m.m.f fVar2;
        Object item;
        int i4 = 0;
        int i5 = 2;
        float f;
        int i6 = 0;
        int i7;
        int i8;
        int i9 = 0;
        float f2 = 1056964608;
        d.f.a.m.m.f fVar6;
        int i13;
        float f3;
        int i15;
        int i16;
        int i17;
        int min;
        d.f.a.m.m.g gVar3;
        int i19;
        e.b bVar;
        e.b bVar2;
        e.b bVar3;
        e.b bVar4;
        int i20;
        e.b mATCH_CONSTRAINT22;
        e.b mATCH_CONSTRAINT23;
        int i21;
        int i14;
        e.b mATCH_CONSTRAINT24;
        int i22 = 0;
        int i23 = 0;
        int cmp;
        final Object dVar2 = this;
        if (dVar2.h.j) {
            if (dVar2.i.j) {
                e eVar2 = dVar2.b.I();
                if (eVar2 instanceof f) {
                    boolean z3 = eVar2.F1();
                } else {
                    i = 0;
                }
                i2 = dVar2.i.g - dVar2.h.g;
                int size = dVar2.k.size();
                i6 = 0;
                i6 = -1;
                max = 8;
                while (i6 < dVar2.k) {
                }
                i6 = size - 1;
                while (i6 >= 0) {
                    if ((p)dVar2.k.get(i6).b.Q() != max) {
                        break;
                    }
                }
                i9 = 0;
                max = 2;
                while (i9 < 2) {
                    i21 = 0;
                    i4 = 0;
                    i22 = 0;
                    i4 = 0;
                    i23 = 0;
                    while (i21 < dVar2.k) {
                        item = dVar2.k.get(i21);
                        if (item.b.Q() != max) {
                            i4 = i4 + 1;
                        }
                    }
                    if (i22 == 0) {
                        break;
                    }
                    item = dVar2.k.get(i21);
                    if (item.b.Q() != max) {
                        i4 = i4 + 1;
                    }
                }
                i4 = 0;
                i4 = 0;
                i22 = 0;
                i23 = 0;
                if (dVar2.b != 0) {
                }
                f2 = 0.5f;
                if (i4 > i2) {
                    float f15 = 2f;
                    if (dVar2.b != 0) {
                        i13 = (int)(float)(i4 - i2) / f15 + f2;
                        max = max + i13;
                    } else {
                        i13 = (int)(float)(i4 - i2) / f15 + f2;
                        max = max - i13;
                    }
                }
                if (i22 > 0) {
                    f3 = (float)(i2 - i4);
                    max = (int)(f3 / (float)i22) + f2;
                    i20 = 0;
                    i21 = 0;
                    while (i20 < dVar2.k) {
                        Object item7 = dVar2.k.get(i20);
                        i20 = i20 + 1;
                        f2 = 0.5f;
                    }
                    if (i21 > 0) {
                        i22 = i22 - i21;
                        i = 0;
                        i4 = 0;
                        while (dVar2.i.j < dVar2.k) {
                            Object item5 = dVar2.k.get(i);
                            f3 = 0.000000000000000000000000000000000000000000011f;
                            i = i + 1;
                        }
                    } else {
                    }
                    i5 = 2;
                    if (dVar2.l != 2 || i21 != 0) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                        dVar2.l = i2;
                    }
                } else {
                    i2 = 0;
                    i5 = 2;
                }
                if (i4 > i2) {
                    dVar2.l = i5;
                }
                if (i4 > 0 && i22 == 0 && i6 == i6) {
                    dVar2.l = i5;
                }
                int i50 = 1;
                if (dVar2.l == i50) {
                    if (0.5f > i50) {
                        i2 = i4 - 1;
                        i2 = (i2 - i4) / i2;
                    } else {
                        if (0.5f == i50) {
                            i2 = 2;
                            i2 = (i2 - i4) / i2;
                        } else {
                        }
                    }
                    if (i22 > 0) {
                    }
                    while (dVar2.k < dVar2.k) {
                        Object item2 = dVar2.k.get(i2);
                        i2 = i2 + 1;
                    }
                } else {
                    if (dVar2.l == 0) {
                        i2 = (i2 - i4) / (i4 + 1);
                        if (i22 > 0) {
                        }
                        while (dVar2.k < dVar2.k) {
                            Object item4 = dVar2.k.get(i2);
                            i2 = i2 + 1;
                        }
                    } else {
                        max = 2;
                        if (dVar2.l == 2 && dVar2.f == 0) {
                            f = dVar2.b.w();
                            if (i != 0) {
                                f = 1f - f;
                            }
                            i2 = (int)(float)(i2 - i4) * f + 0.5f;
                            int r2 = i2;
                            int r7 = i != 0 ? max - i2 : max + i2;
                            while (dVar2.b < dVar2.k) {
                                Object item3 = dVar2.k.get(i2);
                                i4 = 8;
                                i2 = i2 + 1;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // d.f.a.m.m.p
    void d() {
        int i;
        int i2;
        int i3;
        e eVar2;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            (p)it.next().d();
        }
        int size = this.k.size();
        int i5 = 1;
        if (size < i5) {
            return;
        }
        int i6 = 0;
        if (this.f == 0) {
            d.f.a.m.m.f fVar6 = i(eVar4.K, i6);
            i2 = eVar4.K.e();
            eVar2 = r();
            if (eVar2 != null) {
                i2 = eVar2.K.e();
            }
            if (fVar6 != null) {
                b(this.h, fVar6, i2);
            }
            d.f.a.m.m.f fVar = i(eVar3.M, i6);
            i = eVar3.M.e();
            e eVar = s();
            if (eVar != null) {
                i = eVar.M.e();
            }
            if (fVar != null) {
                i = -i;
                b(this.i, fVar, i);
            }
        } else {
            d.f.a.m.m.f fVar2 = i(eVar4.L, i5);
            i3 = eVar4.L.e();
            eVar2 = r();
            if (eVar2 != null) {
                i3 = eVar2.L.e();
            }
            if (fVar2 != null) {
                b(this.h, fVar2, i3);
            }
            fVar = i(eVar3.N, i5);
            i = eVar3.N.e();
            eVar = s();
            if (eVar != null) {
                i = eVar.N.e();
            }
            if (fVar != null) {
                i = -i;
                b(this.i, fVar, i);
            }
        }
        this.h.a = this;
        this.i.a = this;
    }

    @Override // d.f.a.m.m.p
    public void e() {
        int i = 0;
        i = 0;
        while (i < this.k.size()) {
            (p)this.k.get(i).e();
            i = i + 1;
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        this.c = null;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            (p)it.next().f();
        }
    }

    @Override // d.f.a.m.m.p
    public long j() {
        int i = 0;
        int i2 = 0;
        i = 0;
        i2 = 0;
        while (i2 < this.k.size()) {
            Object item = this.k.get(i2);
            l = (long)item.i.f;
            i = (i + (long)item.h.f) + item.j() + l;
            i2 = i2 + 1;
        }
        return i;
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        int i;
        i = 0;
        while (i < this.k.size()) {
            if (!(p)this.k.get(i).m()) {
                return false;
            }
        }
        return true;
    }

    @Override // d.f.a.m.m.p
    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder("ChainRun ");
        String r1 = this.f == 0 ? "horizontal : " : "vertical : ";
        stringBuilder.append((this.f == 0 ? "horizontal : " : "vertical : "));
        Iterator it = (this.f == 0 ? "horizontal : " : "vertical : ").iterator();
        while (it.hasNext()) {
            str3 = "<";
            stringBuilder.append(str3);
            stringBuilder.append((p)it.next());
            str2 = "> ";
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }
}
