package d.f.a.m.m;

import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import java.util.List;

/* compiled from: VerticalWidgetRun.java */
/* loaded from: classes.dex */
public class n extends p {

    public f k = new f();
    g l = null;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[p.b.values().length];
            n.a.a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n.a.a[p.b.END.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n.a.a[p.b.CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public n(e eVar) {
        super(eVar);
        this.h.e = f.a.TOP;
        this.i.e = f.a.BOTTOM;
        new f(this).e = f.a.BASELINE;
        this.f = 1;
    }

    @Override // d.f.a.m.m.p
    public void a(d dVar) {
        d.f.a.m.m.f fVar;
        float f;
        float f3;
        boolean z3;
        int i2;
        int i4;
        float f4;
        float f5;
        int i6;
        int i7 = n.a.a[this.j.ordinal()];
        int i = 3;
        int i3 = 2;
        int i5 = 1;
        if (n.a.a != i5) {
            o(dVar);
        } else {
            p(dVar);
        }
        f4 = 0.5f;
        i6 = 0;
        if (gVar.c && !gVar.j && this.d == e.b.MATCH_CONSTRAINT) {
            if (eVar5.t != i3) {
                if (eVar5.t == i) {
                    if (eVar5.d.e.j) {
                        int i41 = this.b.u();
                        if (i41 == -1) {
                            f3 = (float)eVar9.d.e.g;
                            f5 = this.b.t();
                        } else {
                            if (i41 == 0) {
                                f = (float)eVar8.d.e.g * this.b.t();
                            } else {
                                if (i41 != i5) {
                                } else {
                                    f3 = (float)eVar7.d.e.g;
                                    f5 = this.b.t();
                                    f = f3 / f5;
                                    f2 = f + f4;
                                    i6 = (int)f2;
                                }
                            }
                        }
                        this.e.d(i6);
                    }
                }
            } else {
                e eVar6 = this.b.I();
                if (eVar6 != null && gVar.j) {
                    this.e.d((int)(float)gVar.g * this.b.A + f4);
                }
            }
        }
        if (fVar2.c) {
            if (fVar.c) {
                if (fVar2.j && fVar.j && this.e.j) {
                    return;
                }
                if (!this.e.j && this.d == e.b.MATCH_CONSTRAINT && eVar4.s == 0 && !this.b.f0()) {
                    int i38 = (f)this.h.l.get(i6).g + fVar9.f;
                    int i16 = (f)this.i.l.get(i6).g + this.i.f;
                    this.h.d(i38);
                    this.i.d(i16);
                    this.e.d(i16 - i38);
                    return;
                }
                if (!this.e.j && this.d == e.b.MATCH_CONSTRAINT && this.a == i5 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    int i13 = (f)this.i.l.get(i6).g + this.i.f - (f)this.h.l.get(i6).g + this.h.f;
                    if (eVar5.d < gVar14.m) {
                        this.e.d(i13);
                    } else {
                        this.e.d(gVar14.m);
                    }
                }
                if (!this.e.j) {
                    return;
                }
                if (this.h.l.size() > 0) {
                    if (this.i.l.size() > 0) {
                        Object item4 = this.h.l.get(i6);
                        Object item = this.i.l.get(i6);
                        i2 = item4.g + this.h.f;
                        i4 = item.g + this.i.f;
                        f4 = this.b.M();
                        if (item4 == item) {
                        }
                        i3 = (i4 - i2) - this.e.g;
                        this.h.d((int)(float)i2 + f4 + (float)i3 * f4);
                        this.i.d(this.h.g + this.e.g);
                    }
                }
            }
        }
    }

    @Override // d.f.a.m.m.p
    void d() {
        d dVar;
        int i2;
        boolean z6;
        int i3 = 0;
        d.f.a.m.m.g gVar;
        d.f.a.m.m.g gVar2;
        e.b fIXED2;
        int i4 = 2;
        e eVar3;
        d dVar2;
        boolean z7;
        if (eVar.a) {
            this.e.d(this.b.v());
        }
        if (!this.e.j) {
            this.d = this.b.O();
            if (this.b.U()) {
                this.l = new a(this);
            }
            if (this.d != e.b.MATCH_CONSTRAINT && this.d == e.b.MATCH_PARENT) {
                e eVar32 = this.b.I();
                if (eVar32 != null && eVar32.O() == e.b.FIXED) {
                    b(this.h, eVar32.e.h, this.b.L.e());
                    b(this.i, eVar32.e.i, -this.b.N.e());
                    this.e.d((eVar32.v() - this.b.L.e()) - this.b.N.e());
                    return;
                }
                if (this.d == e.b.FIXED) {
                    this.e.d(this.b.v());
                }
            }
        } else {
            if (this.d == e.b.MATCH_PARENT) {
                e eVar5 = this.b.I();
                if (eVar5 != null) {
                    if (eVar5.O() == e.b.FIXED) {
                        b(this.h, eVar5.e.h, this.b.L.e());
                        b(this.i, eVar5.e.i, -this.b.N.e());
                        return;
                    }
                }
            }
        }
        i3 = 0;
        int i32 = 4;
        boolean z18 = true;
        i4 = 2;
        final int i36 = 3;
        if (gVar4.j) {
            if (!eVar3.a) {
                if (!gVar4.j) {
                    if (this.d != e.b.MATCH_CONSTRAINT) {
                        this.e.b(this);
                    } else {
                        if (eVar2.t != i4) {
                            if (eVar2.t == i36) {
                                if (!this.b.f0()) {
                                    if (eVar2.s != i36) {
                                        this.e.l.add(eVar2.d.e);
                                        gVar5.k.add(this.e);
                                        this.e.b = z18;
                                        gVar6.k.add(this.h);
                                        this.e.k.add(this.i);
                                    }
                                }
                            }
                        } else {
                            e eVar2 = this.b.I();
                            if (eVar2 != null) {
                                this.e.l.add(eVar2.e.e);
                                gVar8.k.add(this.e);
                                this.e.b = z18;
                                gVar9.k.add(this.h);
                                this.e.k.add(this.i);
                            }
                        }
                    }
                }
                if (objArr7[i4].f != null) {
                    if (objArr7[i36].f != null) {
                        if (this.b.f0()) {
                            this.h.f = this.b.S[i4].e();
                            i2 = -this.b.S[i36].e();
                            this.i.f = i2;
                        } else {
                            d.f.a.m.m.f fVar18 = h(this.b.S[i4]);
                            d.f.a.m.m.f fVar54 = h(this.b.S[i36]);
                            if (fVar18 != null) {
                                fVar18.b(this);
                            }
                            if (fVar54 != null) {
                                fVar54.b(this);
                            }
                            this.j = p.b.CENTER;
                        }
                        if (this.b.U()) {
                            c(this.k, this.h, z18, this.l);
                        }
                    } else {
                        float f3 = 0.0f;
                        if (objArr7[i4].f != null) {
                            d.f.a.m.m.f fVar28 = h(objArr7[i4]);
                            if (fVar28 != null) {
                                b(this.h, fVar28, this.b.S[i4].e());
                                c(this.i, this.h, z18, this.e);
                                if (this.b.U()) {
                                    c(this.k, this.h, z18, this.l);
                                }
                                e.b mATCH_CONSTRAINT23 = e.b.MATCH_CONSTRAINT;
                                if (this.d == e.b.MATCH_CONSTRAINT && f2 > 0.0f && lVar3.d == e.b.MATCH_CONSTRAINT) {
                                    lVar3.e.k.add(this.e);
                                    this.e.l.add(this.b.d.e);
                                    this.e.a = this;
                                }
                            }
                        } else {
                            int i37 = -1;
                            if (objArr7[i36].f != null) {
                                d.f.a.m.m.f fVar19 = h(objArr7[i36]);
                                if (fVar19 != null && this.b.U()) {
                                    c(this.k, this.h, z18, this.l);
                                }
                            } else {
                                if (objArr7[i32].f != null) {
                                    d.f.a.m.m.f fVar25 = h(objArr7[i32]);
                                    if (fVar25 != null) {
                                        b(this.k, fVar25, i3);
                                        c(this.h, this.k, i37, this.l);
                                        c(this.i, this.h, z18, this.e);
                                    }
                                } else {
                                    if (!(eVar16 instanceof h) && this.b.I() != null) {
                                        b(this.h, this.b.I().e.h, this.b.T());
                                        c(this.i, this.h, z18, this.e);
                                        if (this.b.U()) {
                                            c(this.k, this.h, z18, this.l);
                                        }
                                        e.b mATCH_CONSTRAINT22 = e.b.MATCH_CONSTRAINT;
                                        if (this.d == e.b.MATCH_CONSTRAINT && f > 0.0f && lVar2.d == e.b.MATCH_CONSTRAINT) {
                                            lVar2.e.k.add(this.e);
                                            this.e.l.add(this.b.d.e);
                                            this.e.a = this;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.e.l.size() == 0) {
                    this.e.c = z18;
                }
            } else {
                if (objArr[i4].f != null) {
                    if (objArr[i36].f != null) {
                        if (this.b.f0()) {
                            this.h.f = this.b.S[i4].e();
                            this.i.f = -this.b.S[i36].e();
                        } else {
                            d.f.a.m.m.f fVar12 = h(this.b.S[i4]);
                            if (fVar12 != null) {
                                b(this.h, fVar12, this.b.S[i4].e());
                            }
                            d.f.a.m.m.f fVar13 = h(this.b.S[i36]);
                            if (fVar13 != null) {
                                i3 = -this.b.S[i36].e();
                                b(this.i, fVar13, i3);
                            }
                            this.h.b = z18;
                            this.i.b = z18;
                        }
                        if (this.b.U()) {
                            b(this.k, this.h, this.b.n());
                        }
                    } else {
                        if (objArr[i4].f != null) {
                            d.f.a.m.m.f fVar = h(objArr[i4]);
                            if (fVar != null) {
                                b(this.h, fVar, this.b.S[i4].e());
                                b(this.i, this.h, this.e.g);
                                if (this.b.U()) {
                                    b(this.k, this.h, this.b.n());
                                }
                            }
                        } else {
                            if (objArr[i36].f != null) {
                                d.f.a.m.m.f fVar2 = h(objArr[i36]);
                                if (fVar2 != null) {
                                    b(this.i, fVar2, -this.b.S[i36].e());
                                    i3 = -this.e.g;
                                    b(this.h, this.i, i3);
                                }
                                if (this.b.U()) {
                                    b(this.k, this.h, this.b.n());
                                }
                            } else {
                                if (objArr[i32].f != null) {
                                    fVar = h(objArr[i32]);
                                    if (fVar != null) {
                                        b(this.k, fVar, i3);
                                        b(this.h, this.k, -this.b.n());
                                        b(this.i, this.h, this.e.g);
                                    }
                                } else {
                                    if (!(eVar3 instanceof h) && this.b.I() != null) {
                                        if (this.b.m(d.b.CENTER).f == null) {
                                            b(this.h, this.b.I().e.h, this.b.T());
                                            b(this.i, this.h, this.e.g);
                                            if (this.b.U()) {
                                                b(this.k, this.h, this.b.n());
                                            }
                                        }
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
            this.b.e1(fVar.g);
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        final boolean z = true;
        if (this.d == e.b.MATCH_CONSTRAINT) {
            if (this.b.t == 0) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // d.f.a.m.m.p
    void q() {
        final boolean z = false;
        this.g = z;
        this.h.c();
        this.h.j = z;
        this.i.c();
        this.i.j = z;
        this.k.c();
        this.k.j = z;
        this.e.j = z;
    }

    @Override // d.f.a.m.m.p
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "VerticalRun ";
        String str3 = this.b.r();
        str = str2 + str3;
        return str;
    }
}
