package d.f.a.m.m;

import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import java.util.List;

/* loaded from: classes.dex */
public class l extends d.f.a.m.m.p {

    private static int[] k;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            l.a.a = iArr;
            iArr[p.b.START.ordinal()] = 1;
            l.a.a[p.b.END.ordinal()] = 2;
            l.a.a[p.b.CENTER.ordinal()] = 3;
        }
    }
    static {
        l.k = new int[2];
    }

    public l(e e) {
        super(e);
        obj2.e = f.a.LEFT;
        obj2.e = f.a.RIGHT;
        this.f = 0;
    }

    private void q(int[] iArr, int i2, int i3, int i4, int i5, float f6, int i7) {
        int obj4;
        int obj8;
        int obj9;
        i3 -= i2;
        i5 -= i4;
        final int obj6 = 0;
        final int i = 1056964608;
        final int i6 = 1;
        if (i7 != -1) {
            if (i7 != 0) {
                if (i7 != i6) {
                } else {
                    iArr[obj6] = obj5;
                    iArr[i6] = (int)obj4;
                }
            } else {
                iArr[obj6] = (int)obj4;
                iArr[i6] = obj7;
            }
        } else {
            obj4 = (int)obj4;
            obj8 = (int)obj9;
            if (obj4 <= obj5 && obj7 <= obj7) {
                if (obj7 <= obj7) {
                    iArr[obj6] = obj4;
                    iArr[i6] = obj7;
                } else {
                    if (obj5 <= obj5 && obj8 <= obj7) {
                        if (obj8 <= obj7) {
                            iArr[obj6] = obj5;
                            iArr[i6] = obj8;
                        }
                    }
                }
            } else {
            }
        }
    }

    @Override // d.f.a.m.m.p
    public void a(d.f.a.m.m.d d) {
        boolean z9;
        boolean z5;
        boolean z;
        int size;
        d.f.a.m.m.f fVar4;
        boolean z10;
        boolean z7;
        boolean z8;
        d.f.a.m.m.f fVar;
        d.f.a.m.m.f fVar5;
        float f3;
        int i3;
        d.f.a.m.m.f mATCH_CONSTRAINT2;
        boolean z3;
        boolean z6;
        boolean z4;
        int i9;
        int i;
        float f;
        int i6;
        int i2;
        boolean z2;
        d.f.a.m.m.d mATCH_CONSTRAINT;
        int i4;
        int i8;
        int i10;
        float f2;
        int i7;
        d.f.a.m.m.f fVar2;
        d.f.a.m.m.f fVar3;
        int i5;
        float f4;
        final Object obj22 = this;
        int i11 = l.a.a[obj22.j.ordinal()];
        i3 = 2;
        i6 = 3;
        final int i100 = 1;
        final int i101 = 0;
        if (i11 != i100) {
            if (i11 != i3 && i11 != i6) {
                if (i11 != i6) {
                }
                e eVar14 = obj22.b;
                obj22.n(d, eVar14.K, eVar14.M, i101);
            }
            mATCH_CONSTRAINT = d;
            o(d);
        } else {
            mATCH_CONSTRAINT = d;
            p(d);
        }
        final int i102 = 1056964608;
        if (!gVar.j && obj22.d == e.b.MATCH_CONSTRAINT) {
            if (obj22.d == e.b.MATCH_CONSTRAINT) {
                z9 = obj22.b;
                mATCH_CONSTRAINT = z9.s;
                if (mATCH_CONSTRAINT != i3) {
                    if (mATCH_CONSTRAINT != i6) {
                    } else {
                        i9 = z9.t;
                        mATCH_CONSTRAINT = -1;
                        if (i9 != 0) {
                            if (i9 == i6) {
                                d.f.a.m.m.n nVar8 = z9.e;
                                fVar2 = nVar8.h;
                                fVar3 = nVar8.i;
                                i3 = dVar2.f != null ? i100 : i101;
                                i6 = dVar5.f != null ? i100 : i101;
                                i8 = dVar8.f != null ? i100 : i101;
                                i10 = dVar10.f != null ? i100 : i101;
                                i5 = z9.u();
                                f4 = obj22.b.t();
                                fVar5 = obj22.h;
                                if (i3 != 0 && i6 != 0 && i8 != 0 && i10 != 0 && fVar2.j && fVar3.j && fVar5.c) {
                                    if (i6 != 0) {
                                        if (i8 != 0) {
                                            if (i10 != 0) {
                                                f4 = obj22.b.t();
                                                if (fVar2.j) {
                                                    if (fVar3.j) {
                                                        fVar5 = obj22.h;
                                                        if (fVar5.c) {
                                                            if (!fVar26.c) {
                                                            } else {
                                                                this.q(l.k, i27 + i64, i28 - i65, i29 + i66, i30 - i67, f4, i5);
                                                                obj22.e.d(l.k[i101]);
                                                                nVar7.e.d(l.k[i100]);
                                                            }
                                                        }
                                                    }
                                                }
                                                fVar = obj22.h;
                                                z3 = obj22.i;
                                                if (fVar.j && z3.j && fVar2.c && !fVar3.c) {
                                                    z3 = obj22.i;
                                                    if (z3.j) {
                                                        if (fVar2.c) {
                                                            if (!fVar3.c) {
                                                            }
                                                            this.q(l.k, i92 += i19, i20 - i55, i21 + i56, i22 - i57, f4, i5);
                                                            obj22.e.d(l.k[i101]);
                                                            nVar5.e.d(l.k[i100]);
                                                        }
                                                    }
                                                }
                                                d.f.a.m.m.f fVar15 = obj22.h;
                                                if (fVar15.c && fVar23.c && fVar2.c && !fVar3.c) {
                                                    if (fVar23.c) {
                                                        if (fVar2.c) {
                                                            if (!fVar3.c) {
                                                            }
                                                            this.q(l.k, i23 + i59, i24 - i60, i25 + i61, i26 - i62, f4, i5);
                                                            obj22.e.d(l.k[i101]);
                                                            nVar6.e.d(l.k[i100]);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (i3 != 0 && i8 != 0 && fVar13.c && !fVar14.c) {
                                    if (i8 != 0) {
                                        if (fVar13.c) {
                                            if (!fVar14.c) {
                                            }
                                            z9 = obj22.b.t();
                                            i50 += i84;
                                            i85 -= i8;
                                            if (i5 != mATCH_CONSTRAINT && i5 != 0) {
                                                if (i5 != 0) {
                                                    if (i5 != i100) {
                                                    } else {
                                                        i6 = (int)i91;
                                                        mATCH_CONSTRAINT = obj22.g(i6, i100);
                                                        if (i6 != mATCH_CONSTRAINT) {
                                                            i3 = (int)i54;
                                                        }
                                                        obj22.e.d(i3);
                                                        nVar4.e.d(mATCH_CONSTRAINT);
                                                    }
                                                } else {
                                                    i6 = (int)i88;
                                                    mATCH_CONSTRAINT = obj22.g(i6, i100);
                                                    if (i6 != mATCH_CONSTRAINT) {
                                                        i3 = (int)i52;
                                                    }
                                                    obj22.e.d(i3);
                                                    nVar3.e.d(mATCH_CONSTRAINT);
                                                }
                                            } else {
                                            }
                                        }
                                    }
                                }
                                if (i6 != 0 && i10 != 0 && fVar2.c && !fVar3.c) {
                                    if (i10 != 0) {
                                        if (fVar2.c) {
                                            if (!fVar3.c) {
                                            }
                                            z9 = obj22.b.t();
                                            i45 += i76;
                                            i77 -= i8;
                                            if (i5 != mATCH_CONSTRAINT) {
                                                if (i5 != 0) {
                                                    if (i5 != i100) {
                                                    } else {
                                                        i6 = (int)i83;
                                                        mATCH_CONSTRAINT = obj22.g(i6, i101);
                                                        if (i6 != mATCH_CONSTRAINT) {
                                                            i3 = (int)i49;
                                                        }
                                                        obj22.e.d(mATCH_CONSTRAINT);
                                                        nVar2.e.d(i3);
                                                    }
                                                } else {
                                                    i6 = (int)i80;
                                                    mATCH_CONSTRAINT = obj22.g(i6, i101);
                                                    if (i6 != mATCH_CONSTRAINT) {
                                                        i3 = (int)i47;
                                                    }
                                                    obj22.e.d(mATCH_CONSTRAINT);
                                                    nVar.e.d(i3);
                                                }
                                            } else {
                                            }
                                        }
                                    }
                                }
                            } else {
                                int i31 = z9.u();
                                if (i31 != mATCH_CONSTRAINT) {
                                    if (i31 != 0) {
                                        if (i31 != i100) {
                                            z9 = i101;
                                        } else {
                                            e eVar13 = obj22.b;
                                            f = (float)i71;
                                            f3 = eVar13.t();
                                            f *= f3;
                                            z9 = (int)i9;
                                        }
                                    } else {
                                        e eVar12 = obj22.b;
                                        f11 /= f3;
                                    }
                                } else {
                                    e eVar11 = obj22.b;
                                    f = (float)i69;
                                    f3 = eVar11.t();
                                }
                                obj22.e.d(z9);
                            }
                        } else {
                        }
                    }
                } else {
                    z9 = z9.I();
                    z9 = lVar.e;
                    if (z9 != null && z9.j) {
                        z9 = lVar.e;
                        if (z9.j) {
                            obj22.e.d((int)i34);
                        }
                    }
                }
            }
        }
        fVar4 = obj22.h;
        if (fVar4.c) {
            mATCH_CONSTRAINT2 = obj22.i;
            if (!mATCH_CONSTRAINT2.c) {
            } else {
                if (fVar4.j && mATCH_CONSTRAINT2.j && gVar8.j) {
                    if (mATCH_CONSTRAINT2.j) {
                        if (gVar8.j) {
                        }
                    }
                }
                z = obj22.b;
                if (!gVar2.j && obj22.d == e.b.MATCH_CONSTRAINT && z.s == 0 && !z.d0()) {
                    if (obj22.d == e.b.MATCH_CONSTRAINT) {
                        z = obj22.b;
                        if (z.s == 0) {
                            if (!z.d0()) {
                                d.f.a.m.m.f fVar31 = obj22.h;
                                i17 += i96;
                                i43 += i97;
                                fVar31.d(i18);
                                obj22.i.d(i44);
                                obj22.e.d(i44 - i18);
                            }
                        }
                    }
                }
                e eVar15 = obj22.b;
                i6 = eVar15.w;
                if (!gVar3.j && obj22.d == e.b.MATCH_CONSTRAINT && obj22.a == i100 && fVar6.l.size() > 0 && fVar7.l.size() > 0 && i6 > 0) {
                    if (obj22.d == e.b.MATCH_CONSTRAINT) {
                        if (obj22.a == i100) {
                            if (fVar6.l.size() > 0) {
                                if (fVar7.l.size() > 0) {
                                    eVar15 = obj22.b;
                                    i6 = eVar15.w;
                                    if (i6 > 0) {
                                        size = Math.min(i6, Math.max(eVar15.v, Math.min(i36 -= i13, gVar4.m)));
                                    }
                                    obj22.e.d(size);
                                }
                            }
                        }
                    }
                }
                if (!gVar5.j) {
                }
                Object obj2 = fVar9.l.get(i101);
                Object obj16 = fVar19.l.get(i101);
                i74 += i93;
                i94 += i99;
                i8 = obj22.b.w();
                if ((f)obj2 == (f)obj16) {
                    i2 = obj2.g;
                    i4 = obj16.g;
                    i8 = i102;
                }
                obj22.h.d((int)i40);
                obj22.i.d(i42 += i6);
            }
        }
    }

    @Override // d.f.a.m.m.p
    void d() {
        e eVar;
        Object bVar2;
        d.f.a.m.m.f cENTER;
        Object gVar;
        boolean z2;
        e.b mATCH_CONSTRAINT2;
        d[] cENTER2;
        Object bVar;
        e.b bVar3;
        int i;
        e.b fIXED;
        int i3;
        d dVar;
        boolean z;
        e.b mATCH_CONSTRAINT;
        int i2;
        eVar = this.b;
        if (eVar.a) {
            this.e.d(eVar.R());
        }
        if (!gVar2.j) {
            bVar2 = this.b.y();
            this.d = bVar2;
            e.b mATCH_PARENT = e.b.MATCH_PARENT;
            bVar2 = this.b.I();
            if (bVar2 != e.b.MATCH_CONSTRAINT && bVar2 == mATCH_PARENT && bVar2 != null && bVar2.y() != e.b.FIXED && bVar2.y() == mATCH_PARENT) {
                mATCH_PARENT = e.b.MATCH_PARENT;
                if (bVar2 == mATCH_PARENT) {
                    bVar2 = this.b.I();
                    if (bVar2 != null) {
                        if (bVar2.y() != e.b.FIXED) {
                            if (bVar2.y() == mATCH_PARENT) {
                            }
                        }
                        b(this.h, lVar6.h, eVar44.K.e());
                        b(this.i, lVar4.i, -i26);
                        this.e.d(i9 -= i24);
                    }
                }
                if (this.d == e.b.FIXED) {
                    this.e.d(this.b.R());
                }
            }
        } else {
            mATCH_CONSTRAINT2 = e.b.MATCH_PARENT;
            bVar2 = this.b.I();
            if (this.d == mATCH_CONSTRAINT2 && bVar2 != null && bVar2.y() != e.b.FIXED && bVar2.y() == mATCH_CONSTRAINT2) {
                bVar2 = this.b.I();
                if (bVar2 != null) {
                    if (bVar2.y() != e.b.FIXED) {
                        if (bVar2.y() == mATCH_CONSTRAINT2) {
                        }
                    }
                    b(this.h, lVar5.h, eVar39.K.e());
                    b(this.i, lVar.i, -i11);
                }
            }
        }
        gVar = this.e;
        i = 0;
        i3 = 1;
        cENTER2 = this.b;
        if (gVar.j && cENTER2.a) {
            cENTER2 = this.b;
            if (cENTER2.a) {
                d[] objArr2 = cENTER2.S;
                if (dVar31.f != null && dVar33.f != null) {
                    if (dVar33.f != null) {
                        if (cENTER2.d0()) {
                            fVar16.f = eVar28.S[i].e();
                            cENTER.f = -i7;
                        } else {
                            d.f.a.m.m.f fVar13 = h(eVar18.S[i]);
                            if (fVar13 != null) {
                                b(this.h, fVar13, eVar43.S[i].e());
                            }
                            d.f.a.m.m.f fVar14 = h(eVar19.S[i3]);
                            if (fVar14 != null) {
                                b(this.i, fVar14, -i22);
                            }
                            fVar15.b = i3;
                            cENTER.b = i3;
                        }
                    } else {
                        if (dVar32.f != null) {
                            cENTER = h(objArr2[i]);
                            if (cENTER != null) {
                                b(this.h, cENTER, eVar40.S[i].e());
                                b(this.i, this.h, gVar30.g);
                            }
                        } else {
                            if (dVar19.f != null) {
                                cENTER = h(objArr2[i3]);
                                if (cENTER != null) {
                                    b(this.i, cENTER, -i17);
                                    b(this.h, this.i, -i19);
                                }
                            } else {
                                if (!cENTER2 instanceof h && cENTER2.I() != null && dVar6.f == null) {
                                    if (cENTER2.I() != null) {
                                        if (dVar6.f == null) {
                                            b(this.h, lVar3.h, this.b.S());
                                            b(this.i, this.h, gVar29.g);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                }
            } else {
                if (this.d == e.b.MATCH_CONSTRAINT) {
                    bVar = this.b;
                    mATCH_CONSTRAINT = bVar.s;
                    if (mATCH_CONSTRAINT != 2) {
                        i2 = 3;
                        if (mATCH_CONSTRAINT != i2) {
                        } else {
                            if (bVar.t == i2) {
                                fVar34.a = this;
                                fVar35.a = this;
                                d.f.a.m.m.n nVar14 = bVar.e;
                                i2.a = this;
                                mATCH_CONSTRAINT.a = this;
                                gVar.a = this;
                                if (bVar.f0()) {
                                    gVar9.l.add(nVar11.e);
                                    gVar10.k.add(this.e);
                                    d.f.a.m.m.n nVar5 = eVar10.e;
                                    gVar20.a = this;
                                    gVar21.l.add(nVar5.h);
                                    gVar11.l.add(nVar12.i);
                                    fVar6.k.add(this.e);
                                    fVar7.k.add(this.e);
                                } else {
                                    if (this.b.d0()) {
                                        gVar7.l.add(this.e);
                                        gVar8.k.add(nVar10.e);
                                    } else {
                                        gVar6.l.add(this.e);
                                    }
                                }
                            } else {
                                d.f.a.m.m.g gVar23 = nVar13.e;
                                gVar.l.add(gVar23);
                                gVar23.k.add(this.e);
                                fVar8.k.add(this.e);
                                fVar9.k.add(this.e);
                                d.f.a.m.m.g gVar12 = this.e;
                                gVar12.b = i3;
                                gVar12.k.add(this.h);
                                gVar13.k.add(this.i);
                                fVar10.l.add(this.e);
                                fVar11.l.add(this.e);
                            }
                        }
                    } else {
                        gVar = bVar.I();
                        if (gVar == null) {
                        } else {
                            d.f.a.m.m.g gVar3 = nVar.e;
                            gVar15.l.add(gVar3);
                            gVar3.k.add(this.e);
                            d.f.a.m.m.g gVar4 = this.e;
                            gVar4.b = i3;
                            gVar4.k.add(this.h);
                            gVar5.k.add(this.i);
                        }
                    }
                }
                cENTER = this.b;
                cENTER2 = cENTER.S;
                if (dVar28.f != null && dVar30.f != null) {
                    if (dVar30.f != null) {
                        if (cENTER.d0()) {
                            fVar4.f = eVar23.S[i].e();
                            cENTER.f = -i5;
                        } else {
                            d.f.a.m.m.f fVar3 = h(eVar5.S[i]);
                            cENTER2 = h(eVar22.S[i3]);
                            if (fVar3 != null) {
                                fVar3.b(this);
                            }
                            if (cENTER2 != null) {
                                cENTER2.b(this);
                            }
                            this.j = p.b.CENTER;
                        }
                    } else {
                        if (dVar29.f != null) {
                            cENTER = h(cENTER2[i]);
                            if (cENTER != null) {
                                b(this.h, cENTER, eVar42.S[i].e());
                                c(this.i, this.h, i3, this.e);
                            }
                        } else {
                            if (dVar17.f != null) {
                                cENTER = h(cENTER2[i3]);
                                if (cENTER != null) {
                                    b(this.i, cENTER, -i15);
                                    c(this.h, this.i, -1, this.e);
                                }
                            } else {
                                if (!cENTER instanceof h && cENTER.I() != null) {
                                    if (cENTER.I() != null) {
                                        b(this.h, lVar2.h, this.b.S());
                                        c(this.i, this.h, i3, this.e);
                                    }
                                }
                            }
                        }
                    }
                } else {
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
            this.b.d1(fVar.g);
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        this.c = 0;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        final int i3 = 1;
        if (this.d == e.b.MATCH_CONSTRAINT && eVar.s == 0) {
            if (eVar.s == 0) {
                return i3;
            }
            return 0;
        }
        return i3;
    }

    @Override // d.f.a.m.m.p
    void r() {
        final int i = 0;
        this.g = i;
        this.h.c();
        fVar2.j = i;
        this.i.c();
        fVar4.j = i;
        gVar.j = i;
    }

    @Override // d.f.a.m.m.p
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HorizontalRun ");
        stringBuilder.append(this.b.r());
        return stringBuilder.toString();
    }
}
