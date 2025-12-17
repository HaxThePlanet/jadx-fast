package d.f.a.m.m;

import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import java.util.List;

/* loaded from: classes.dex */
public class n extends d.f.a.m.m.p {

    public d.f.a.m.m.f k;
    d.f.a.m.m.g l = null;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            n.a.a = iArr;
            iArr[p.b.START.ordinal()] = 1;
            n.a.a[p.b.END.ordinal()] = 2;
            n.a.a[p.b.CENTER.ordinal()] = 3;
        }
    }
    public n(e e) {
        super(e);
        f obj3 = new f(this);
        this.k = obj3;
        int i = 0;
        fVar.e = f.a.TOP;
        fVar2.e = f.a.BOTTOM;
        obj3.e = f.a.BASELINE;
        this.f = 1;
    }

    @Override // d.f.a.m.m.p
    public void a(d.f.a.m.m.d d) {
        boolean mATCH_CONSTRAINT2;
        d.f.a.m.m.f mATCH_CONSTRAINT;
        int i2;
        float f;
        int i6;
        boolean i7;
        int i5;
        int i;
        int i3;
        float i4;
        d.f.a.m.m.g obj7;
        int i8 = n.a.a[this.j.ordinal()];
        i7 = 3;
        i3 = 2;
        i4 = 1;
        if (i8 != i4) {
            if (i8 != i3 && i8 != i7) {
                if (i8 != i7) {
                }
                e eVar = this.b;
                n(d, eVar.L, eVar.N, i4);
            }
            o(d);
        } else {
            p(d);
        }
        obj7 = this.e;
        final int i31 = 1056964608;
        final int i32 = 0;
        if (obj7.c && !obj7.j && this.d == e.b.MATCH_CONSTRAINT) {
            if (!obj7.j) {
                if (this.d == e.b.MATCH_CONSTRAINT) {
                    obj7 = this.b;
                    mATCH_CONSTRAINT2 = obj7.t;
                    if (mATCH_CONSTRAINT2 != i3) {
                        if (mATCH_CONSTRAINT2 != i7) {
                        } else {
                            if (gVar.j) {
                                obj7 = obj7.u();
                                if (obj7 != -1) {
                                    if (obj7 != null) {
                                        if (obj7 != i4) {
                                            obj7 = i32;
                                        } else {
                                            obj7 = this.b;
                                            f = (float)i17;
                                            obj7 = obj7.t();
                                            f /= obj7;
                                            obj7 = (int)i6;
                                        }
                                    } else {
                                        obj7 = this.b;
                                        f4 *= obj7;
                                    }
                                } else {
                                    obj7 = this.b;
                                    f = (float)i19;
                                    obj7 = obj7.t();
                                }
                                this.e.d(obj7);
                            }
                        }
                    } else {
                        obj7 = obj7.I();
                        obj7 = obj7.e;
                        if (obj7 != null && obj7.j) {
                            obj7 = obj7.e;
                            if (obj7.j) {
                                this.e.d((int)obj7);
                            }
                        }
                    }
                }
            }
        }
        obj7 = this.h;
        if (obj7.c) {
            mATCH_CONSTRAINT = this.i;
            if (!mATCH_CONSTRAINT.c) {
            } else {
                if (obj7.j && mATCH_CONSTRAINT.j && obj7.j) {
                    if (mATCH_CONSTRAINT.j) {
                        if (obj7.j) {
                        }
                    }
                }
                obj7 = this.b;
                if (!obj7.j && this.d == e.b.MATCH_CONSTRAINT && obj7.s == 0 && !obj7.f0()) {
                    if (this.d == e.b.MATCH_CONSTRAINT) {
                        obj7 = this.b;
                        if (obj7.s == 0) {
                            if (!obj7.f0()) {
                                d.f.a.m.m.f fVar7 = this.h;
                                obj7 += i27;
                                i15 += i28;
                                fVar7.d(obj7);
                                this.i.d(i16);
                                this.e.d(i16 - obj7);
                            }
                        }
                    }
                }
                if (!obj7.j && this.d == e.b.MATCH_CONSTRAINT && this.a == i4 && obj7.l.size() > 0 && obj7.l.size() > 0) {
                    if (this.d == e.b.MATCH_CONSTRAINT) {
                        if (this.a == i4) {
                            if (obj7.l.size() > 0) {
                                if (obj7.l.size() > 0) {
                                    i14 -= obj7;
                                    obj7 = this.e;
                                    i7 = obj7.m;
                                    if (mATCH_CONSTRAINT < i7) {
                                        obj7.d(mATCH_CONSTRAINT);
                                    } else {
                                        obj7.d(i7);
                                    }
                                }
                            }
                        }
                    }
                }
                if (!obj7.j) {
                }
                obj7 = obj7.l.get(i32);
                Object obj = fVar.l.get(i32);
                i20 += i24;
                i25 += i30;
                i4 = this.b.M();
                if (obj7.l.size() > 0 && obj7.l.size() > 0 && (f)obj7 == (f)obj) {
                    if (obj7.l.size() > 0) {
                        obj7 = obj7.l.get(i32);
                        obj = fVar.l.get(i32);
                        i20 += i24;
                        i25 += i30;
                        i4 = this.b.M();
                        if ((f)(f)obj7 == (f)(f)obj) {
                            i5 = obj7.g;
                            i = obj.g;
                            i4 = i31;
                        }
                        this.h.d((int)i10);
                        this.i.d(i12 += i7);
                    }
                }
            }
        }
    }

    @Override // d.f.a.m.m.p
    void d() {
        e eVar;
        Object bVar;
        d.f.a.m.m.f fVar;
        d.f.a.m.m.f fVar2;
        e gVar;
        boolean cmp;
        Object cENTER;
        boolean z4;
        boolean z;
        d.f.a.m.m.f size;
        boolean aVar;
        boolean z3;
        e.b mATCH_CONSTRAINT2;
        d mATCH_CONSTRAINT;
        int z5;
        d.f.a.m.m.f fVar3;
        d.f.a.m.m.f fVar4;
        e.b mATCH_PARENT;
        e.b fIXED;
        int i;
        int i2;
        e mATCH_CONSTRAINT3;
        boolean z2;
        eVar = this.b;
        if (eVar.a) {
            this.e.d(eVar.v());
        }
        if (!gVar2.j) {
            this.d = this.b.O();
            if (this.b.U()) {
                aVar = new a(this);
                this.l = aVar;
            }
            bVar = this.d;
            bVar = this.b.I();
            if (bVar != e.b.MATCH_CONSTRAINT && bVar == e.b.MATCH_PARENT && bVar != null && bVar.O() == e.b.FIXED) {
                if (bVar == e.b.MATCH_PARENT) {
                    bVar = this.b.I();
                    if (bVar != null) {
                        if (bVar.O() == e.b.FIXED) {
                            b(this.h, nVar7.h, eVar52.L.e());
                            b(this.i, nVar5.i, -i28);
                            this.e.d(i8 -= i25);
                        }
                    }
                }
                if (this.d == e.b.FIXED) {
                    this.e.d(this.b.v());
                }
            }
        } else {
            bVar = this.b.I();
            if (this.d == e.b.MATCH_PARENT && bVar != null && bVar.O() == e.b.FIXED) {
                bVar = this.b.I();
                if (bVar != null) {
                    if (bVar.O() == e.b.FIXED) {
                        b(this.h, nVar6.h, eVar50.L.e());
                        b(this.i, nVar.i, -i10);
                    }
                }
            }
        }
        gVar = this.e;
        z5 = gVar.j;
        i = 0;
        int i27 = 4;
        int i30 = 1;
        i2 = 2;
        final int i32 = 3;
        mATCH_CONSTRAINT3 = this.b;
        if (z5 && mATCH_CONSTRAINT3.a) {
            mATCH_CONSTRAINT3 = this.b;
            if (mATCH_CONSTRAINT3.a) {
                d[] objArr = mATCH_CONSTRAINT3.S;
                if (dVar11.f != null && dVar15.f != null) {
                    if (dVar15.f != null) {
                        if (mATCH_CONSTRAINT3.f0()) {
                            fVar13.f = eVar26.S[i2].e();
                            fVar2.f = -i4;
                        } else {
                            d.f.a.m.m.f fVar10 = h(eVar9.S[i2]);
                            if (fVar10 != null) {
                                b(this.h, fVar10, eVar43.S[i2].e());
                            }
                            d.f.a.m.m.f fVar11 = h(eVar10.S[i32]);
                            if (fVar11 != null) {
                                b(this.i, fVar11, -i19);
                            }
                            fVar12.b = i30;
                            fVar2.b = i30;
                        }
                        if (this.b.U()) {
                            b(this.k, this.h, this.b.n());
                        }
                    } else {
                        if (dVar12.f != null) {
                            size = h(objArr[i2]);
                            b(this.h, size, eVar35.S[i2].e());
                            b(this.i, this.h, gVar21.g);
                            if (size != null && this.b.U()) {
                                b(this.h, size, eVar35.S[i2].e());
                                b(this.i, this.h, gVar21.g);
                                if (this.b.U()) {
                                    b(this.k, this.h, this.b.n());
                                }
                            }
                        } else {
                            if (dVar13.f != null) {
                                fVar = h(objArr[i32]);
                                if (fVar != null) {
                                    b(this.i, fVar, -i13);
                                    b(this.h, this.i, -i15);
                                }
                                if (this.b.U()) {
                                    b(this.k, this.h, this.b.n());
                                }
                            } else {
                                if (dVar14.f != null) {
                                    size = h(objArr[i27]);
                                    if (size != null) {
                                        b(this.k, size, i);
                                        b(this.h, this.k, -i17);
                                        b(this.i, this.h, gVar24.g);
                                    }
                                } else {
                                    b(this.h, nVar2.h, this.b.T());
                                    b(this.i, this.h, gVar23.g);
                                    if (!mATCH_CONSTRAINT3 instanceof h && mATCH_CONSTRAINT3.I() != null && dVar3.f == null && this.b.U()) {
                                        if (mATCH_CONSTRAINT3.I() != null) {
                                            if (dVar3.f == null) {
                                                b(this.h, nVar2.h, this.b.T());
                                                b(this.i, this.h, gVar23.g);
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
                } else {
                }
            } else {
                if (!z5 && this.d == e.b.MATCH_CONSTRAINT) {
                    if (this.d == e.b.MATCH_CONSTRAINT) {
                        gVar = this.b;
                        z5 = gVar.t;
                        if (z5 != i2) {
                            if (z5 != i32) {
                            } else {
                                if (!gVar.f0()) {
                                    gVar = this.b;
                                    if (gVar.s == i32) {
                                    } else {
                                        d.f.a.m.m.g gVar3 = lVar.e;
                                        gVar15.l.add(gVar3);
                                        gVar3.k.add(this.e);
                                        d.f.a.m.m.g gVar4 = this.e;
                                        gVar4.b = i30;
                                        gVar4.k.add(this.h);
                                        gVar5.k.add(this.i);
                                    }
                                }
                            }
                        } else {
                            gVar = gVar.I();
                            if (gVar == null) {
                            } else {
                                d.f.a.m.m.g gVar6 = nVar3.e;
                                gVar17.l.add(gVar6);
                                gVar6.k.add(this.e);
                                d.f.a.m.m.g gVar7 = this.e;
                                gVar7.b = i30;
                                gVar7.k.add(this.h);
                                gVar8.k.add(this.i);
                            }
                        }
                    } else {
                        gVar.b(this);
                    }
                } else {
                }
                cmp = this.b;
                mATCH_CONSTRAINT = cmp.S;
                if (dVar35.f != null && dVar36.f != null) {
                    if (dVar36.f != null) {
                        if (cmp.f0()) {
                            fVar14.f = eVar28.S[i2].e();
                            cENTER.f = -i6;
                        } else {
                            d.f.a.m.m.f fVar15 = h(eVar13.S[i2]);
                            mATCH_CONSTRAINT = h(eVar30.S[i32]);
                            if (fVar15 != null) {
                                fVar15.b(this);
                            }
                            if (mATCH_CONSTRAINT != null) {
                                mATCH_CONSTRAINT.b(this);
                            }
                            this.j = p.b.CENTER;
                        }
                        if (this.b.U()) {
                            c(this.k, this.h, i30, this.l);
                        }
                    } else {
                        z2 = 0;
                        if (dVar37.f != null) {
                            cmp = h(mATCH_CONSTRAINT[i2]);
                            b(this.h, cmp, eVar47.S[i2].e());
                            c(this.i, this.h, i30, this.e);
                            if (cmp != null && this.b.U()) {
                                b(this.h, cmp, eVar47.S[i2].e());
                                c(this.i, this.h, i30, this.e);
                                if (this.b.U()) {
                                    c(this.k, this.h, i30, this.l);
                                }
                                mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                                cmp = eVar22.d;
                                if (this.d == mATCH_CONSTRAINT && Float.compare(f2, z2) > 0 && cmp.d == mATCH_CONSTRAINT) {
                                    if (Float.compare(f2, z2) > 0) {
                                        cmp = eVar22.d;
                                        if (cmp.d == mATCH_CONSTRAINT) {
                                            gVar12.k.add(this.e);
                                            gVar13.l.add(lVar3.e);
                                            cmp.a = this;
                                        }
                                    }
                                }
                            }
                        } else {
                            mATCH_CONSTRAINT3 = -1;
                            if (dVar33.f != null) {
                                cmp = h(mATCH_CONSTRAINT[i32]);
                                b(this.i, cmp, -i20);
                                c(this.h, this.i, mATCH_CONSTRAINT3, this.e);
                                if (cmp != null && this.b.U()) {
                                    b(this.i, cmp, -i20);
                                    c(this.h, this.i, mATCH_CONSTRAINT3, this.e);
                                    if (this.b.U()) {
                                        c(this.k, this.h, i30, this.l);
                                    }
                                }
                            } else {
                                if (dVar34.f != null) {
                                    cmp = h(mATCH_CONSTRAINT[i27]);
                                    if (cmp != null) {
                                        b(this.k, cmp, i);
                                        c(this.h, this.k, mATCH_CONSTRAINT3, this.l);
                                        c(this.i, this.h, i30, this.e);
                                    }
                                } else {
                                    b(this.h, nVar4.h, this.b.T());
                                    c(this.i, this.h, i30, this.e);
                                    if (!cmp instanceof h && cmp.I() != null && this.b.U()) {
                                        if (cmp.I() != null) {
                                            b(this.h, nVar4.h, this.b.T());
                                            c(this.i, this.h, i30, this.e);
                                            if (this.b.U()) {
                                                c(this.k, this.h, i30, this.l);
                                            }
                                            mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                                            cmp = eVar19.d;
                                            if (this.d == mATCH_CONSTRAINT && Float.compare(f, z2) > 0 && cmp.d == mATCH_CONSTRAINT) {
                                                if (Float.compare(f, z2) > 0) {
                                                    cmp = eVar19.d;
                                                    if (cmp.d == mATCH_CONSTRAINT) {
                                                        gVar10.k.add(this.e);
                                                        gVar11.l.add(lVar2.e);
                                                        cmp.a = this;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                }
                if (gVar9.l.size() == 0) {
                    size.c = i30;
                }
            }
        } else {
        }
    }

    @Override // d.f.a.m.m.p
    public void e() {
        d.f.a.m.m.f fVar;
        boolean z;
        fVar = this.h;
        if (fVar.j) {
            this.b.e1(fVar.g);
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        this.c = 0;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        final int i3 = 1;
        if (this.d == e.b.MATCH_CONSTRAINT && eVar.t == 0) {
            if (eVar.t == 0) {
                return i3;
            }
            return 0;
        }
        return i3;
    }

    @Override // d.f.a.m.m.p
    void q() {
        final int i = 0;
        this.g = i;
        this.h.c();
        fVar2.j = i;
        this.i.c();
        fVar4.j = i;
        this.k.c();
        fVar6.j = i;
        gVar.j = i;
    }

    @Override // d.f.a.m.m.p
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerticalRun ");
        stringBuilder.append(this.b.r());
        return stringBuilder.toString();
    }
}
