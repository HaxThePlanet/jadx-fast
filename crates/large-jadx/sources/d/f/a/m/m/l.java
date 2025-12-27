package d.f.a.m.m;

import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import java.util.List;

/* compiled from: HorizontalWidgetRun.java */
/* loaded from: classes.dex */
public class l extends p {

    private static int[] k;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[p.b.values().length];
            l.a.a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[p.b.END.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                l.a.a[p.b.CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        l.k = new int[2];
    }

    public l(e eVar) {
        super(eVar);
        this.h.e = f.a.LEFT;
        this.i.e = f.a.RIGHT;
        this.f = 0;
    }

    private void q(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        i2 -= i;
        i4 -= i3;
        i = -1;
        final int i10 = 0;
        final float f2 = 0.5f;
        final int i8 = 1;
        if (i5 != -1) {
            if (i5 == 0) {
                i = (int)(float)i11 * f + f2;
                iArr[i10] = i;
                iArr[i8] = i11;
            } else {
                if (i5 == i8) {
                    i = (int)(float)i9 * f + f2;
                    iArr[i10] = i9;
                    iArr[i8] = i;
                }
            }
        } else {
            i = (int)(float)i11 * f + f2;
            f = (float)i9 / f + f2;
            i6 = (int)f;
            if (i > i9 || i11 > i11) {
                if (i9 <= i9 && i6 <= i11) {
                    iArr[i10] = i9;
                    iArr[i8] = i6;
                }
            } else {
                iArr[i10] = i;
                iArr[i8] = i11;
            }
        }
    }

    @Override // d.f.a.m.m.p
    public void a(d dVar) {
        int max;
        int i;
        float f;
        d.f.a.m.m.f fVar4;
        float f3;
        float f4;
        int i2;
        d.f.a.m.m.d dVar2;
        int i3;
        float f5;
        final Object dVar3 = this;
        int i6 = l.a.a[dVar3.j.ordinal()];
        i = 2;
        i = 3;
        i = 1;
        i = 0;
        if (l.a.a != i) {
            dVar2 = dVar;
            o(dVar);
        } else {
            dVar2 = dVar;
            p(dVar);
        }
        f5 = 0.5f;
        if (!dVar3.e.j && dVar3.d == e.b.MATCH_CONSTRAINT) {
            if (eVar2.s != i) {
                if (eVar2.s == i) {
                    int i4 = -1;
                    if (eVar2.t == 0 || eVar2.t == i) {
                        int r1 = i;
                        int r2 = i;
                        int r4 = i;
                        int r5 = i;
                        int i5 = dVar3.b.u();
                        if (dVar3.j != 0 && eVar2.L != 0 && eVar2.M != 0 && eVar2.N != 0) {
                            float f6 = dVar3.b.t();
                            if (fVar5.j && fVar6.j) {
                                if (fVar3.c) {
                                    if (dVar3.i.c) {
                                        i = (f)fVar3.l.get(i).g + dVar3.h.f;
                                        i4 = (f)dVar3.i.l.get(i).g - dVar3.i.f;
                                        i = fVar5.g + fVar5.f;
                                        i = fVar6.g - fVar6.f;
                                        this.q(l.k, i, i4, i, i, f6, i5);
                                        dVar3.e.d(l.k[i]);
                                        dVar3.b.e.e.d(l.k[i]);
                                    }
                                }
                                return;
                            }
                            if (fVar2.j && fVar24.j) {
                                return;
                            }
                            return;
                        }
                        if (dVar3.i.c != 0 && eVar2.M != 0) {
                            if (dVar3.h.c) {
                                float f8 = dVar3.b.t();
                                i = (f)dVar3.h.l.get(i).g + dVar3.h.f;
                                i = (f)dVar3.i.l.get(i).g - dVar3.i.f;
                                if (i5 == i4 || i5 == 0) {
                                    i = (int)(float)(dVar3.g(i - i, i)) * f8 + f5;
                                    int i84 = dVar3.g(i, i);
                                    if (dVar3.h != i84) {
                                        i = (int)(float)i84 / f8 + f5;
                                    }
                                    dVar3.e.d(i);
                                    dVar3.b.e.e.d(i84);
                                } else {
                                    if (i5 == i) {
                                        i = (int)(float)(dVar3.g(i - i, i)) / f8 + f5;
                                        int i85 = dVar3.g(i, i);
                                        if (dVar3.h != i85) {
                                            i = (int)(float)i85 * f8 + f5;
                                        }
                                        dVar3.e.d(i);
                                        dVar3.b.e.e.d(i85);
                                    }
                                }
                            }
                            return;
                        }
                        if (dVar3.h != 0 && eVar2.N != 0) {
                            return;
                        }
                    }
                }
            } else {
                e eVar16 = dVar3.b.I();
                if (eVar16 != null && gVar23.j) {
                    dVar3.e.d((int)(float)gVar23.g * dVar3.b.x + f5);
                }
            }
        }
        if (fVar.c) {
            if (fVar4.c) {
                if (fVar.j && fVar4.j && dVar3.e.j) {
                    return;
                }
                if (!dVar3.e.j && dVar3.d == e.b.MATCH_CONSTRAINT && eVar.s == 0 && !dVar3.b.d0()) {
                    int i13 = (f)dVar3.h.l.get(i).g + fVar33.f;
                    int i38 = (f)dVar3.i.l.get(i).g + dVar3.i.f;
                    dVar3.h.d(i13);
                    dVar3.i.d(i38);
                    dVar3.e.d(i38 - i13);
                    return;
                }
                if (!dVar3.e.j && dVar3.d == e.b.MATCH_CONSTRAINT && dVar3.a == i && dVar3.h.l.size() > 0 && dVar3.i.l.size() > 0) {
                    if (eVar18.w > 0) {
                        max = Math.min(eVar18.w, Math.max(eVar18.v, Math.min((f)dVar3.i.l.get(i).g + dVar3.i.f - (f)dVar3.h.l.get(i).g + dVar3.h.f, dVar3.e.m)));
                    }
                    dVar3.e.d(max);
                }
                if (!dVar3.e.j) {
                    return;
                }
                Object item2 = dVar3.h.l.get(i);
                Object item13 = dVar3.i.l.get(i);
                i2 = item2.g + dVar3.h.f;
                i3 = item13.g + dVar3.i.f;
                f5 = dVar3.b.w();
                if (item2 == item13) {
                }
                dVar3.h.d((int)(float)i2 + f5 + (float)(i3 - i2) - dVar3.e.g * f5);
                dVar3.i.d(dVar3.h.g + dVar3.e.g);
            }
        }
    }

    @Override // d.f.a.m.m.p
    void d() {
        e eVar2;
        int i = 0;
        e.b bVar3;
        e.b fIXED2;
        d dVar;
        int i3 = 2;
        if (eVar.a) {
            this.e.d(this.b.R());
        }
        if (!this.e.j) {
            e.b bVar = this.b.y();
            this.d = bVar;
            if (bVar != e.b.MATCH_CONSTRAINT && bVar == e.b.MATCH_PARENT) {
                e eVar28 = this.b.I();
                if (eVar28 != null) {
                    b(this.h, eVar28.d.h, this.b.K.e());
                    b(this.i, eVar28.d.i, -this.b.M.e());
                    this.e.d((eVar28.R() - this.b.K.e()) - this.b.M.e());
                    return;
                }
                if (this.d == e.b.FIXED) {
                    this.e.d(this.b.R());
                }
            }
        } else {
            mATCH_PARENT2 = e.b.MATCH_PARENT;
            if (this.d == e.b.MATCH_PARENT) {
                e eVar4 = this.b.I();
                if (eVar4 != null) {
                    b(this.h, eVar4.d.h, this.b.K.e());
                    b(this.i, eVar4.d.i, -this.b.M.e());
                    return;
                }
            }
        }
        i = 0;
        int i2 = 1;
        if (gVar.j) {
            if (!eVar2.a) {
                if (this.d == e.b.MATCH_CONSTRAINT) {
                    i3 = 2;
                    if (eVar32.s != 2) {
                        i3 = 3;
                        if (eVar32.s == i3) {
                            if (eVar32.t != i3) {
                                gVar.l.add(eVar32.e.e);
                                gVar27.k.add(this.e);
                                this.b.e.h.k.add(this.e);
                                this.b.e.i.k.add(this.e);
                                this.e.b = true;
                                gVar12.k.add(this.h);
                                this.e.k.add(this.i);
                                this.h.l.add(this.e);
                                this.i.l.add(this.e);
                            } else {
                                this.h.a = this;
                                this.i.a = this;
                                nVar14.h.a = this;
                                nVar14.i.a = this;
                                this.e.a = this;
                                if (this.b.f0()) {
                                    this.e.l.add(this.b.e.e);
                                    this.b.e.e.k.add(this.e);
                                    nVar5.e.a = this;
                                    this.e.l.add(nVar5.h);
                                    this.e.l.add(this.b.e.i);
                                    this.b.e.h.k.add(this.e);
                                    this.b.e.i.k.add(this.e);
                                } else {
                                    if (this.b.d0()) {
                                        this.b.e.e.l.add(this.e);
                                        this.e.k.add(this.b.e.e);
                                    } else {
                                        this.b.e.e.l.add(this.e);
                                    }
                                }
                            }
                        }
                    } else {
                        e eVar10 = this.b.I();
                        if (eVar10 != null) {
                            this.e.l.add(eVar10.e.e);
                            gVar3.k.add(this.e);
                            this.e.b = true;
                            gVar4.k.add(this.h);
                            this.e.k.add(this.i);
                        }
                    }
                }
                if (objArr[i].f != null) {
                    if (objArr[i2].f != null) {
                        if (this.b.d0()) {
                            this.h.f = this.b.S[i].e();
                            this.i.f = -this.b.S[i2].e();
                        } else {
                            d.f.a.m.m.f fVar4 = h(this.b.S[i]);
                            d.f.a.m.m.f fVar27 = h(this.b.S[i2]);
                            if (fVar4 != null) {
                                fVar4.b(this);
                            }
                            if (fVar27 != null) {
                                fVar27.b(this);
                            }
                            this.j = p.b.CENTER;
                        }
                    } else {
                        if (objArr[i].f != null) {
                            d.f.a.m.m.f fVar = h(objArr[i]);
                            if (fVar != null) {
                                b(this.h, fVar, this.b.S[i].e());
                                c(this.i, this.h, i2, this.e);
                            }
                        } else {
                            if (objArr[i2].f != null) {
                                fVar = h(objArr[i2]);
                                if (fVar != null) {
                                    b(this.i, fVar, -this.b.S[i2].e());
                                    i = -1;
                                    c(this.h, this.i, i, this.e);
                                }
                            } else {
                                if (!(eVar5 instanceof h) && this.b.I() != null) {
                                    b(this.h, this.b.I().d.h, this.b.S());
                                    c(this.i, this.h, i2, this.e);
                                }
                            }
                        }
                    }
                }
            } else {
                if (objArr3[i].f != null) {
                    if (objArr3[i2].f != null) {
                        if (this.b.d0()) {
                            this.h.f = this.b.S[i].e();
                            this.i.f = -this.b.S[i2].e();
                        } else {
                            d.f.a.m.m.f fVar14 = h(this.b.S[i]);
                            if (fVar14 != null) {
                                b(this.h, fVar14, this.b.S[i].e());
                            }
                            d.f.a.m.m.f fVar15 = h(this.b.S[i2]);
                            if (fVar15 != null) {
                                i = -this.b.S[i2].e();
                                b(this.i, fVar15, i);
                            }
                            this.h.b = true;
                            this.i.b = true;
                        }
                    } else {
                        if (objArr3[i].f != null) {
                            fVar = h(objArr3[i]);
                            if (fVar != null) {
                                b(this.h, fVar, this.b.S[i].e());
                                b(this.i, this.h, this.e.g);
                            }
                        } else {
                            if (objArr3[i2].f != null) {
                                fVar = h(objArr3[i2]);
                                if (fVar != null) {
                                    b(this.i, fVar, -this.b.S[i2].e());
                                    i = -this.e.g;
                                    b(this.h, this.i, i);
                                }
                            } else {
                                if (!(eVar2 instanceof h) && this.b.I() != null) {
                                    if (this.b.m(d.b.CENTER).f == null) {
                                        b(this.h, this.b.I().d.h, this.b.S());
                                        b(this.i, this.h, this.e.g);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // d.f.a.m.m.p
    public void e() {
        if (fVar.j) {
            this.b.d1(fVar.g);
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        final boolean z = true;
        if (this.d == e.b.MATCH_CONSTRAINT) {
            if (this.b.s == 0) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // d.f.a.m.m.p
    void r() {
        final boolean z = false;
        this.g = z;
        this.h.c();
        this.h.j = z;
        this.i.c();
        this.i.j = z;
        this.e.j = z;
    }

    @Override // d.f.a.m.m.p
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "HorizontalRun ";
        String str3 = this.b.r();
        str = str2 + str3;
        return str;
    }
}
