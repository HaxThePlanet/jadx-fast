package d.f.a.m.m;

import d.f.a.m.d;
import d.f.a.m.e;
import d.f.a.m.e.b;
import d.f.a.m.f;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c extends d.f.a.m.m.p {

    ArrayList<d.f.a.m.m.p> k;
    private int l;
    public c(e e, int i2) {
        super(e);
        ArrayList obj1 = new ArrayList();
        this.k = obj1;
        this.f = i2;
        q();
    }

    private void q() {
        e eVar4;
        e eVar3;
        int i;
        int size;
        int i3;
        e eVar;
        e next2;
        boolean next;
        d.f.a.m.m.p pVar;
        int i2;
        e eVar2;
        eVar = this.b.J(this.f);
        next2 = eVar4;
        eVar4 = eVar2;
        while (eVar4 != null) {
            eVar = eVar4.J(this.f);
            next2 = eVar4;
            eVar4 = eVar2;
        }
        this.b = next2;
        this.k.add(next2.L(this.f));
        eVar3 = next2.H(this.f);
        while (eVar3 != null) {
            this.k.add(eVar3.L(this.f));
            eVar3 = eVar3.H(this.f);
        }
        Iterator iterator = this.k.iterator();
        pVar = 1;
        while (iterator.hasNext()) {
            next2 = iterator.next();
            i2 = this.f;
            if (i2 == 0) {
            } else {
            }
            if (i2 == pVar) {
            }
            pVar = 1;
            next2.c = this;
            next2.b = this;
        }
        if (this.f == 0 && (f)this.b.I().F1()) {
            size = (f)this.b.I().F1() ? pVar : 0;
        } else {
        }
        if (size != 0 && this.k.size() > pVar) {
            if (this.k.size() > pVar) {
                ArrayList list4 = this.k;
                this.b = obj.b;
            }
        }
        if (this.f == 0) {
            i3 = this.b.x();
        } else {
            i3 = this.b.N();
        }
        this.l = i3;
    }

    private e r() {
        int i;
        Object obj;
        int i2;
        int i3;
        i = 0;
        while (i < this.k.size()) {
            obj = this.k.get(i);
            i++;
        }
        return null;
    }

    private e s() {
        int i;
        Object obj;
        int i2;
        int i3;
        size--;
        while (i >= 0) {
            obj = this.k.get(i);
            i--;
        }
        return null;
    }

    @Override // d.f.a.m.m.p
    public void a(d.f.a.m.m.d d) {
        boolean z;
        int i6;
        int i;
        int i7;
        int i18;
        int i23;
        int i24;
        int i33;
        int i34;
        d.f.a.m.m.f fVar4;
        int i30;
        int i21;
        int i9;
        float f2;
        int size;
        int i25;
        int i3;
        int i36;
        boolean i8;
        int i4;
        int i11;
        int i14;
        int i32;
        int i26;
        int i2;
        int i22;
        int i35;
        d.f.a.m.m.f fVar;
        d.f.a.m.m.f fVar2;
        int i15;
        d.f.a.m.m.f fVar3;
        d.f.a.m.m.g gVar;
        float f3;
        int i27;
        d.f.a.m.m.g cmp;
        Object i19;
        int mATCH_CONSTRAINT3;
        e.b mATCH_CONSTRAINT;
        int i37;
        int i5;
        int i28;
        int mATCH_CONSTRAINT2;
        int i29;
        int i10;
        int i12;
        int cmp2;
        int i13;
        int i31;
        int i20;
        float f;
        int i16;
        int i38;
        int i17;
        final Object obj = this;
        if (fVar5.j) {
            if (!fVar6.j) {
            } else {
                e eVar2 = obj.b.I();
                if (eVar2 instanceof f) {
                    i6 = (f)eVar2.F1();
                } else {
                    i6 = 0;
                }
                i51 -= i62;
                size = obj.k.size();
                i25 = 0;
                i36 = 8;
                while (i25 < size) {
                    if (obj2.b.Q() == i36) {
                        break;
                    }
                    i25++;
                    i36 = 8;
                }
                i25 = i3;
                i14 = size + -1;
                i26 = i14;
                while (i26 >= 0) {
                    if (obj4.b.Q() != i36) {
                        break;
                    } else {
                    }
                    i26--;
                }
                i2 = 0;
                while (i2 < 2) {
                    i37 = 0;
                    i5 = 0;
                    i29 = 0;
                    i10 = 0;
                    i12 = 0;
                    while (i37 < size) {
                        i30 = obj.k.get(i37);
                        i10++;
                        if (i37 > 0 && i37 >= i25) {
                        }
                        cmp = i30.e;
                        i8 = cmp.g;
                        if (i30.d != e.b.MATCH_CONSTRAINT) {
                        } else {
                        }
                        f3 = 0;
                        if (i30.a == 1 && i2 == 0) {
                        } else {
                        }
                        if (cmp.j) {
                        } else {
                        }
                        i36 = i13;
                        if (f3 == 0) {
                        } else {
                        }
                        i5 += i36;
                        if (i37 < i14 && i37 < i3) {
                        }
                        i37++;
                        i36 = 8;
                        i27 = 2;
                        if (i37 < i3) {
                        }
                        i5 += i30;
                        i29++;
                        i36 = eVar6.o0[obj.f];
                        if (Float.compare(i36, f3) >= 0) {
                        }
                        i12 += i36;
                        i36 = i13;
                        f3 = 1;
                        if (i2 == 0) {
                        } else {
                        }
                        i36 = cmp.m;
                        i29++;
                        cmp = obj.f;
                        i13 = i8;
                        f3 = 1;
                        if (i37 >= i25) {
                        }
                        i5 += cmp;
                    }
                    i2++;
                    i36 = 8;
                    i30 = obj.k.get(i37);
                    i10++;
                    if (i37 > 0 && i37 >= i25) {
                    }
                    cmp = i30.e;
                    i8 = cmp.g;
                    if (i30.d != e.b.MATCH_CONSTRAINT) {
                    } else {
                    }
                    f3 = 0;
                    if (i30.a == 1 && i2 == 0) {
                    } else {
                    }
                    if (cmp.j) {
                    } else {
                    }
                    i36 = i13;
                    if (f3 == 0) {
                    } else {
                    }
                    i5 += i36;
                    if (i37 < i14 && i37 < i3) {
                    }
                    i37++;
                    i36 = 8;
                    i27 = 2;
                    if (i37 < i3) {
                    }
                    i5 += i30;
                    i29++;
                    i36 = eVar6.o0[obj.f];
                    if (Float.compare(i36, f3) >= 0) {
                    }
                    i12 += i36;
                    i36 = i13;
                    f3 = 1;
                    if (i2 == 0) {
                    } else {
                    }
                    i36 = cmp.m;
                    i29++;
                    cmp = obj.f;
                    i13 = i8;
                    f3 = 1;
                    if (i37 >= i25) {
                    }
                    i5 += cmp;
                }
                i21 = 0;
                i5 = 0;
                i29 = 0;
                i12 = 0;
                i4 = fVar18.g;
                if (i6 != 0) {
                    i4 = fVar20.g;
                }
                i22 = 1056964608;
                if (i5 > i33) {
                    int i74 = 1073741824;
                    if (i6 != 0) {
                        i4 += f3;
                    } else {
                        i4 -= f3;
                    }
                }
                if (i29 > 0) {
                    i27 = (int)i76;
                    mATCH_CONSTRAINT3 = 0;
                    i37 = 0;
                    while (mATCH_CONSTRAINT3 < size) {
                        Object obj3 = obj.k.get(mATCH_CONSTRAINT3);
                        i13 = i27;
                        if (obj3.b.Q() == 8) {
                        } else {
                        }
                        i19 = obj3.e;
                        if (obj3.d == e.b.MATCH_CONSTRAINT && !i19.j) {
                        } else {
                        }
                        i16 = i6;
                        i38 = i21;
                        i20 = i4;
                        f = f3;
                        mATCH_CONSTRAINT3++;
                        i27 = i13;
                        i5 = i31;
                        i4 = i20;
                        f3 = f;
                        i6 = i16;
                        i21 = i38;
                        i22 = 1056964608;
                        i19 = obj3.e;
                        if (!i19.j) {
                        } else {
                        }
                        if (Float.compare(i12, i28) > 0) {
                        } else {
                        }
                        i20 = i4;
                        i4 = i13;
                        if (obj.f == 0) {
                        } else {
                        }
                        f = f3;
                        e eVar11 = obj3.b;
                        i16 = i6;
                        mATCH_CONSTRAINT2 = i73;
                        f3 = i17;
                        i38 = i21;
                        if (obj3.a == 1) {
                        } else {
                        }
                        i = i4;
                        if (f3 > 0) {
                        }
                        if (i7 != i4) {
                        }
                        obj3.e.d(i4);
                        i37++;
                        i4 = i7;
                        i7 = Math.min(f3, Math.max(mATCH_CONSTRAINT2, i));
                        i = Math.min(i4, i19.m);
                        e eVar17 = obj3.b;
                        f = f3;
                        f3 = eVar17.w;
                        mATCH_CONSTRAINT2 = eVar17.v;
                        i16 = i6;
                        i20 = i4;
                        i4 = (int)i67;
                    }
                    i16 = i6;
                    i38 = i21;
                    i20 = i4;
                    if (i37 > 0) {
                        i29 -= i37;
                        i6 = 0;
                        i21 = 0;
                        while (i6 < size) {
                            i4 = obj.k.get(i6);
                            if (i4.b.Q() == 0.000000000000000000000000000000000000000000011f) {
                            } else {
                            }
                            if (i6 > 0 && i6 >= i25) {
                            }
                            if (i6 < i14 && i6 < i3) {
                            }
                            i6++;
                            if (i6 < i3) {
                            }
                            i21 += i4;
                            if (i6 >= i25) {
                            }
                            i21 += i22;
                        }
                        i5 = i21;
                    } else {
                        i5 = i31;
                    }
                    if (obj.l == 2 && i37 == 0) {
                        if (i37 == 0) {
                            obj.l = 0;
                        } else {
                            z = 0;
                        }
                    } else {
                    }
                } else {
                    i16 = i6;
                    i38 = i21;
                    i20 = i4;
                    i31 = i5;
                    z = 0;
                    i9 = 2;
                }
                if (i5 > i33) {
                    obj.l = i9;
                }
                if (i38 > 0 && i29 == 0 && i25 == i3) {
                    if (i29 == 0) {
                        if (i25 == i3) {
                            obj.l = i9;
                        }
                    }
                }
                i30 = obj.l;
                int i69 = 1;
                if (i30 == i69) {
                    i32 = i38;
                    if (i32 > i69) {
                        i53 /= i30;
                    } else {
                        if (i32 == i69) {
                            i52 /= i30;
                        } else {
                            i33 = z;
                        }
                    }
                    if (i29 > 0) {
                        i33 = z;
                    }
                    i30 = z;
                    i36 = i20;
                    while (i30 < size) {
                        if (i16 != 0) {
                        } else {
                        }
                        i18 = i30;
                        z = obj.k.get(i18);
                        if (z.b.Q() == 8) {
                        } else {
                        }
                        if (i30 > 0) {
                        }
                        if (i30 > 0 && i30 >= i25) {
                        }
                        if (i16 != 0) {
                        } else {
                        }
                        z.h.d(i36);
                        d.f.a.m.m.g gVar4 = z.e;
                        f3 = gVar4.g;
                        if (z.d == e.b.MATCH_CONSTRAINT && z.a == 1) {
                        }
                        if (i16 != 0) {
                        } else {
                        }
                        i36 += f3;
                        if (i16 != 0) {
                        } else {
                        }
                        z.i.d(i36);
                        z.g = true;
                        if (i30 < i14 && i30 < i3) {
                        }
                        i30++;
                        if (i30 < i3) {
                        }
                        if (i16 != 0) {
                        } else {
                        }
                        i36 += z;
                        i36 -= z;
                        z.h.d(i36);
                        i36 -= f3;
                        if (z.a == 1) {
                        }
                        f3 = gVar4.m;
                        z.i.d(i36);
                        if (i30 >= i25) {
                        }
                        if (i16 != 0) {
                        } else {
                        }
                        i36 += i35;
                        i36 -= i35;
                        if (i16 != 0) {
                        } else {
                        }
                        i36 += i33;
                        i36 -= i33;
                        z.h.d(i36);
                        z.i.d(i36);
                        i18 = size - i44;
                    }
                } else {
                    if (i30 == 0) {
                        int i61 = 1;
                        i57 /= i70;
                        if (i29 > 0) {
                            i33 = z;
                        }
                        i30 = z;
                        i36 = i20;
                        while (i30 < size) {
                            if (i16 != 0) {
                            } else {
                            }
                            i24 = i30;
                            z = obj.k.get(i24);
                            if (z.b.Q() == 8) {
                            } else {
                            }
                            if (i16 != 0) {
                            } else {
                            }
                            i36 += i33;
                            if (i30 > 0 && i30 >= i25) {
                            }
                            if (i16 != 0) {
                            } else {
                            }
                            z.h.d(i11);
                            gVar = z.e;
                            if (z.d == e.b.MATCH_CONSTRAINT && z.a == 1) {
                            }
                            if (i16 != 0) {
                            } else {
                            }
                            i11 += f3;
                            if (i16 != 0) {
                            } else {
                            }
                            z.i.d(i36);
                            if (i30 < i14 && i30 < i3) {
                            }
                            i30++;
                            if (i30 < i3) {
                            }
                            if (i16 != 0) {
                            } else {
                            }
                            i36 += z;
                            i36 -= z;
                            z.h.d(i36);
                            i11 -= f3;
                            if (z.a == 1) {
                            }
                            f3 = Math.min(gVar.g, gVar.m);
                            z.i.d(i11);
                            if (i30 >= i25) {
                            }
                            if (i16 != 0) {
                            } else {
                            }
                            i11 += i15;
                            i11 -= i15;
                            i36 -= i33;
                            z.h.d(i36);
                            z.i.d(i36);
                            i24 = size - i50;
                        }
                    } else {
                        if (i30 == 2) {
                            if (obj.f == 0) {
                                f2 = obj.b.w();
                            } else {
                                f2 = obj.b.M();
                            }
                            if (i16 != 0) {
                                f2 = i36 - f2;
                            }
                            if ((int)i56 >= 0) {
                                if (i29 > 0) {
                                    i33 = z;
                                }
                            } else {
                            }
                            i36 = i16 != 0 ? i20 - i33 : i20 + i33;
                            i30 = z;
                            while (i30 < size) {
                                if (i16 != 0) {
                                } else {
                                }
                                i23 = i30;
                                z = obj.k.get(i23);
                                if (z.b.Q() == 8) {
                                } else {
                                }
                                if (i30 > 0 && i30 >= i25) {
                                }
                                if (i16 != 0) {
                                } else {
                                }
                                z.h.d(i36);
                                d.f.a.m.m.g gVar2 = z.e;
                                f3 = gVar2.g;
                                if (z.d == e.b.MATCH_CONSTRAINT) {
                                } else {
                                }
                                mATCH_CONSTRAINT3 = 1;
                                if (i16 != 0) {
                                } else {
                                }
                                i36 += f3;
                                if (i16 != 0) {
                                } else {
                                }
                                z.i.d(i36);
                                if (i30 < i14 && i30 < i3) {
                                }
                                i30++;
                                if (i30 < i3) {
                                }
                                if (i16 != 0) {
                                } else {
                                }
                                i36 += z;
                                i36 -= z;
                                z.h.d(i36);
                                i36 -= f3;
                                if (z.a == 1) {
                                }
                                f3 = gVar2.m;
                                z.i.d(i36);
                                if (i30 >= i25) {
                                }
                                if (i16 != 0) {
                                } else {
                                }
                                i36 += i34;
                                i36 -= i34;
                                z.h.d(i36);
                                z.i.d(i36);
                                mATCH_CONSTRAINT3 = 1;
                                i23 = size - i47;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // d.f.a.m.m.p
    void d() {
        int i4;
        Object next;
        d.f.a.m.m.f fVar;
        int i2;
        int i3;
        Object eVar;
        d.f.a.m.m.f i;
        Object eVar2;
        Iterator iterator = this.k.iterator();
        for (p next : iterator) {
            next.d();
        }
        int size = this.k.size();
        int i6 = 1;
        if (size < i6) {
        }
        i = 0;
        e eVar4 = obj2.b;
        e eVar3 = obj.b;
        if (this.f == 0) {
            d dVar5 = eVar4.K;
            d dVar3 = eVar3.M;
            d.f.a.m.m.f fVar4 = i(dVar5, i);
            i2 = dVar5.e();
            eVar2 = r();
            if (eVar2 != null) {
                i2 = eVar2.K.e();
            }
            if (fVar4 != null) {
                b(this.h, fVar4, i2);
            }
            fVar = i(dVar3, i);
            i4 = dVar3.e();
            eVar = s();
            if (eVar != null) {
                i4 = eVar.M.e();
            }
            if (fVar != null) {
                b(this.i, fVar, -i4);
            }
        } else {
            d dVar7 = eVar4.L;
            d dVar = eVar3.N;
            i = i(dVar7, i6);
            i3 = dVar7.e();
            eVar2 = r();
            if (eVar2 != null) {
                i3 = eVar2.L.e();
            }
            if (i != null) {
                b(this.h, i, i3);
            }
            fVar = i(dVar, i6);
            i4 = dVar.e();
            eVar = s();
            if (eVar != null) {
                i4 = eVar.N.e();
            }
            if (fVar != null) {
                b(this.i, fVar, -i4);
            }
        }
        fVar2.a = this;
        fVar3.a = this;
    }

    @Override // d.f.a.m.m.p
    public void e() {
        int i;
        Object obj;
        i = 0;
        while (i < this.k.size()) {
            (p)this.k.get(i).e();
            i++;
        }
    }

    @Override // d.f.a.m.m.p
    void f() {
        Object next;
        this.c = 0;
        Iterator iterator = this.k.iterator();
        for (p next : iterator) {
            next.f();
        }
    }

    @Override // d.f.a.m.m.p
    public long j() {
        int i2;
        int i;
        long l2;
        long l;
        i2 = 0;
        i = 0;
        while (i < this.k.size()) {
            Object obj = this.k.get(i);
            i4 += l2;
            i++;
        }
        return i2;
    }

    @Override // d.f.a.m.m.p
    boolean m() {
        int i;
        boolean z;
        final int i3 = 0;
        i = i3;
        while (i < this.k.size()) {
            i++;
        }
        return 1;
    }

    @Override // d.f.a.m.m.p
    public String toString() {
        String str2;
        String str3;
        String str;
        StringBuilder stringBuilder = new StringBuilder("ChainRun ");
        str2 = this.f == 0 ? "horizontal : " : "vertical : ";
        stringBuilder.append(str2);
        Iterator iterator = this.k.iterator();
        for (p next2 : iterator) {
            stringBuilder.append("<");
            stringBuilder.append(next2);
            stringBuilder.append("> ");
        }
        return stringBuilder.toString();
    }
}
