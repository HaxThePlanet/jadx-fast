package d.f.a.m;

import d.f.a.d;

/* loaded from: classes.dex */
public class a extends d.f.a.m.i {

    private int w0 = 0;
    private boolean x0 = true;
    private int y0 = 0;
    boolean z0 = false;
    public a() {
        super();
        final int i = 0;
        final int i2 = 1;
    }

    @Override // d.f.a.m.i
    public void g(d d, boolean z2) {
        d.f.a.m.d dVar2;
        int i3;
        int i8;
        boolean z;
        d.f.a.m.d[] objArr;
        int i;
        d.f.a.m.d dVar;
        int length;
        d.f.a.m.e eVar;
        int i2;
        int i4;
        boolean z4;
        Object obj;
        boolean z3;
        int i7;
        d.f.a.m.e.b mATCH_CONSTRAINT;
        boolean z5;
        d.f.a.i iVar2;
        d.f.a.i iVar;
        int i6;
        Object dVar3;
        int i5;
        int obj14;
        obj14 = this.S;
        final int i11 = 0;
        obj14[i11] = this.K;
        i = 2;
        obj14[i] = this.L;
        final int i12 = 1;
        obj14[i12] = this.M;
        final int i13 = 3;
        obj14[i13] = this.N;
        obj14 = i11;
        objArr = this.S;
        for (Object dVar15 : obj0) {
            dVar.i = d.q(dVar15);
            objArr = this.S;
        }
        obj14 = this.w0;
        length = 4;
        obj14 = objArr[obj14];
        if (obj14 >= 0 && obj14 < length && !this.z0) {
            length = 4;
            if (obj14 < length) {
                obj14 = objArr[obj14];
                if (!this.z0) {
                    k1();
                }
                if (this.z0) {
                    this.z0 = i11;
                    obj14 = this.w0;
                    if (obj14 != null) {
                        if (obj14 == i12) {
                            d.f(obj14.i, this.b0);
                            d.f(obj14.i, this.b0);
                        } else {
                            if (obj14 != i) {
                                if (obj14 == i13) {
                                    d.f(obj14.i, this.c0);
                                    d.f(obj14.i, this.c0);
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
                i3 = i11;
                while (i3 < this.v0) {
                    eVar = this.u0[i3];
                    obj = this.w0;
                    obj = this.w0;
                    i3++;
                }
                i8 = i11;
                if (!this.K.k()) {
                    if (this.M.k()) {
                        i2 = i12;
                    } else {
                        i2 = i11;
                    }
                } else {
                }
                if (!this.L.k()) {
                    if (this.N.k()) {
                        i7 = i12;
                    } else {
                        i7 = i11;
                    }
                } else {
                }
                if (i8 == 0) {
                    mATCH_CONSTRAINT = this.w0;
                    if (mATCH_CONSTRAINT == 0) {
                        if (i2 == 0) {
                            if (mATCH_CONSTRAINT == i) {
                                if (i7 == 0) {
                                    if (mATCH_CONSTRAINT == i12) {
                                        if (i2 == 0) {
                                            if (mATCH_CONSTRAINT == i13 && i7 != 0) {
                                                i4 = i7 != 0 ? i12 : i11;
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                obj = 5;
                if (i4 == 0) {
                    obj = length;
                }
                eVar = i11;
                while (eVar < this.v0) {
                    mATCH_CONSTRAINT = this.u0[eVar];
                    if (!this.x0 && !mATCH_CONSTRAINT.h()) {
                    } else {
                    }
                    z5 = d.q(mATCH_CONSTRAINT.S[this.w0]);
                    d.f.a.m.d[] objArr4 = mATCH_CONSTRAINT.S;
                    int i16 = this.w0;
                    dVar30.i = z5;
                    if (dVar31.f != null && dVar33.d == this) {
                    } else {
                    }
                    mATCH_CONSTRAINT = i11;
                    if (i16 != 0) {
                    } else {
                    }
                    d.i(obj14.i, z5, i19 -= mATCH_CONSTRAINT, i8);
                    d.e(obj14.i, z5, i18 += mATCH_CONSTRAINT, obj);
                    eVar++;
                    if (i16 == i) {
                    } else {
                    }
                    d.g(obj14.i, z5, i17 += mATCH_CONSTRAINT, i8);
                    if (dVar33.d == this) {
                    } else {
                    }
                    i14 += i11;
                    if (!mATCH_CONSTRAINT.h()) {
                    } else {
                    }
                }
                obj14 = this.w0;
                objArr = 8;
                if (obj14 == null) {
                    d.e(obj14.i, dVar16.i, i11, objArr);
                    d.e(obj14.i, dVar7.i, i11, length);
                    d.e(obj14.i, dVar8.i, i11, i11);
                } else {
                    if (obj14 == i12) {
                        d.e(obj14.i, dVar19.i, i11, objArr);
                        d.e(obj14.i, dVar13.i, i11, length);
                        d.e(obj14.i, dVar14.i, i11, i11);
                    } else {
                        if (obj14 == i) {
                            d.e(obj14.i, dVar18.i, i11, objArr);
                            d.e(obj14.i, dVar11.i, i11, length);
                            d.e(obj14.i, dVar12.i, i11, i11);
                        } else {
                            if (obj14 == i13) {
                                d.e(obj14.i, dVar17.i, i11, objArr);
                                d.e(obj14.i, dVar9.i, i11, length);
                                d.e(obj14.i, dVar10.i, i11, i11);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // d.f.a.m.i
    public boolean h() {
        return 1;
    }

    @Override // d.f.a.m.i
    public boolean i0() {
        return this.z0;
    }

    @Override // d.f.a.m.i
    public boolean j0() {
        return this.z0;
    }

    @Override // d.f.a.m.i
    public boolean k1() {
        int i2;
        int i7;
        int i6;
        int i3;
        int i5;
        d.f.a.m.e eVar;
        int i8;
        int i;
        int i4;
        boolean bOTTOM;
        i2 = 0;
        final int i11 = 1;
        i7 = i2;
        i3 = i11;
        i8 = this.v0;
        i = 3;
        i4 = 2;
        while (i7 < i8) {
            eVar = this.u0[i7];
            if (!this.x0 && !eVar.h()) {
            } else {
            }
            bOTTOM = this.w0;
            if (bOTTOM != 0) {
            } else {
            }
            if (!eVar.i0()) {
            } else {
            }
            bOTTOM = this.w0;
            if (bOTTOM != i4) {
            } else {
            }
            if (!eVar.j0()) {
            }
            i7++;
            i8 = this.v0;
            i = 3;
            i4 = 2;
            i3 = i2;
            if (bOTTOM == i) {
            }
            if (bOTTOM == i11 && !eVar.i0()) {
            } else {
            }
            if (!eVar.h()) {
            } else {
            }
        }
        if (i3 != 0 && i8 > 0) {
            if (i8 > 0) {
                i5 = i6;
                while (i2 < this.v0) {
                    i8 = this.u0[i2];
                    if (!this.x0 && !i8.h()) {
                    } else {
                    }
                    if (i5 == 0) {
                    }
                    bOTTOM = this.w0;
                    if (bOTTOM == 0) {
                    } else {
                    }
                    if (bOTTOM == i11) {
                    } else {
                    }
                    if (bOTTOM == i4) {
                    } else {
                    }
                    if (bOTTOM == i) {
                    }
                    i2++;
                    i6 = Math.max(i6, i8.m(d.b.BOTTOM).d());
                    i6 = Math.min(i6, i8.m(d.b.TOP).d());
                    i6 = Math.max(i6, i8.m(d.b.RIGHT).d());
                    i6 = Math.min(i6, i8.m(d.b.LEFT).d());
                    int i13 = this.w0;
                    if (i13 == 0) {
                    } else {
                    }
                    if (i13 == i11) {
                    } else {
                    }
                    if (i13 == i4) {
                    } else {
                    }
                    if (i13 == i) {
                    }
                    i5 = i11;
                    i6 = i8.m(d.b.BOTTOM).d();
                    i6 = i8.m(d.b.TOP).d();
                    i6 = i8.m(d.b.RIGHT).d();
                    i6 = i8.m(d.b.LEFT).d();
                    if (!i8.h()) {
                    } else {
                    }
                }
                i6 += i9;
                int i10 = this.w0;
                if (i10 != 0) {
                    if (i10 == i11) {
                        w0(i12, i12);
                    } else {
                        z0(i12, i12);
                    }
                } else {
                }
                this.z0 = i11;
                return i11;
            }
        }
        return i2;
    }

    @Override // d.f.a.m.i
    public boolean l1() {
        return this.x0;
    }

    @Override // d.f.a.m.i
    public int m1() {
        return this.w0;
    }

    @Override // d.f.a.m.i
    public int n1() {
        return this.y0;
    }

    @Override // d.f.a.m.i
    public int o1() {
        int i2;
        int i;
        int i3 = this.w0;
        i2 = 1;
        if (i3 != 0 && i3 != i2 && i3 != 2 && i3 != 3) {
            i2 = 1;
            if (i3 != i2) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return -1;
                    }
                }
                return i2;
            }
        }
        return 0;
    }

    @Override // d.f.a.m.i
    protected void p1() {
        int i;
        d.f.a.m.e eVar;
        boolean z;
        int i2;
        int i3;
        final int i4 = 0;
        i = i4;
        while (i < this.v0) {
            eVar = this.u0[i];
            if (!this.x0 && !eVar.h()) {
            } else {
            }
            z = this.w0;
            i2 = 1;
            if (z != 0) {
            } else {
            }
            eVar.J0(i4, i2);
            i++;
            if (z == i2) {
            } else {
            }
            if (z != 2) {
            } else {
            }
            eVar.J0(i2, i2);
            if (z == 3) {
            }
            if (!eVar.h()) {
            } else {
            }
        }
    }

    @Override // d.f.a.m.i
    public void q1(boolean z) {
        this.x0 = z;
    }

    @Override // d.f.a.m.i
    public void r1(int i) {
        this.w0 = i;
    }

    @Override // d.f.a.m.i
    public void s1(int i) {
        this.y0 = i;
    }

    @Override // d.f.a.m.i
    public String toString() {
        String string;
        int i;
        d.f.a.m.e eVar;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[Barrier] ");
        stringBuilder2.append(r());
        stringBuilder2.append(" {");
        string = stringBuilder2.toString();
        i = 0;
        while (i < this.v0) {
            if (i > 0) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(this.u0[i].r());
            string = stringBuilder.toString();
            i++;
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(", ");
            string = stringBuilder.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string);
        stringBuilder3.append("}");
        return stringBuilder3.toString();
    }
}
