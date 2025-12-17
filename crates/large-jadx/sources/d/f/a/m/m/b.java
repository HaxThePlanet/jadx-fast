package d.f.a.m.m;

import d.f.a.d;
import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import d.f.a.m.e.b;
import d.f.a.m.f;
import d.f.a.m.j;
import d.f.a.m.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    private final ArrayList<e> a;
    private d.f.a.m.m.b.a b;
    private f c;

    public static class a {

        public static int k = 0;
        public static int l = 1;
        public static int m = 2;
        public e.b a;
        public e.b b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public int j;
        static {
        }
    }

    public interface b {
        public abstract void a();

        public abstract void b(e e, d.f.a.m.m.b.a b$a2);
    }
    public b(f f) {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        b.a aVar = new b.a();
        this.b = aVar;
        this.c = f;
    }

    private boolean a(d.f.a.m.m.b.b b$b, e e2, int i3) {
        int cmp;
        int i;
        int obj8;
        aVar.a = e2.y();
        aVar2.b = e2.O();
        aVar3.c = e2.R();
        aVar4.d = e2.v();
        d.f.a.m.m.b.a aVar5 = this.b;
        int i5 = 0;
        aVar5.i = i5;
        aVar5.j = i3;
        e.b mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
        final int i6 = 1;
        obj8 = aVar5.a == mATCH_CONSTRAINT ? i6 : i5;
        cmp = aVar5.b == mATCH_CONSTRAINT ? i6 : i5;
        int i7 = 0;
        if (obj8 != null && Float.compare(obj8, i7) > 0) {
            obj8 = Float.compare(obj8, i7) > 0 ? i6 : i5;
        } else {
        }
        if (cmp != 0 && Float.compare(f, i7) > 0) {
            i = Float.compare(f, i7) > 0 ? i6 : i5;
        } else {
        }
        int i8 = 4;
        if (obj8 != null && e2.u[i5] == i8) {
            if (e2.u[i5] == i8) {
                aVar5.a = e.b.FIXED;
            }
        }
        if (i != 0 && e2.u[i6] == i8) {
            if (e2.u[i6] == i8) {
                aVar5.b = e.b.FIXED;
            }
        }
        b.b(e2, aVar5);
        e2.b1(obj6.e);
        e2.C0(obj6.f);
        e2.B0(obj6.h);
        e2.r0(obj6.g);
        d.f.a.m.m.b.a obj6 = this.b;
        obj6.j = b.a.k;
        return obj6.i;
    }

    private void b(f f) {
        int i;
        Object obj;
        boolean cmp;
        d.f.a.m.m.n nVar;
        e.b bVar;
        e.b mATCH_CONSTRAINT;
        int i2;
        boolean z;
        final d.f.a.m.m.b.b bVar2 = f.z1();
        final int i4 = 0;
        i = i4;
        while (i < f.u0.size()) {
            obj = f.u0.get(i);
            if (obj instanceof g) {
            } else {
            }
            if (obj instanceof a) {
            } else {
            }
            if ((e)obj.g0()) {
            } else {
            }
            cmp = obj.d;
            nVar = obj.e;
            if (f.J1(64) && cmp != null && nVar != null && gVar.j && gVar2.j) {
            } else {
            }
            cmp = obj.s(i4);
            nVar = 1;
            bVar = obj.s(nVar);
            mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
            if (cmp == mATCH_CONSTRAINT && obj.s != nVar && bVar == mATCH_CONSTRAINT && obj.t != nVar) {
            } else {
            }
            i2 = i4;
            if (i2 == 0 && f.J1(nVar) && !obj instanceof k) {
            } else {
            }
            nVar = i2;
            if (nVar != 0) {
            } else {
            }
            a(bVar2, obj, b.a.k);
            obj = f.A0;
            if (obj != null) {
            }
            i++;
            obj.a = l += bVar;
            if (f.J1(nVar)) {
            } else {
            }
            if (!obj instanceof k) {
            } else {
            }
            if (cmp == mATCH_CONSTRAINT && obj.s == 0 && bVar != mATCH_CONSTRAINT && !obj.d0()) {
            }
            if (bVar == mATCH_CONSTRAINT && obj.t == 0 && cmp != mATCH_CONSTRAINT && !obj.d0()) {
            }
            if (cmp != mATCH_CONSTRAINT) {
            } else {
            }
            if (Float.compare(f2, bVar) > 0) {
            } else {
            }
            if (bVar == mATCH_CONSTRAINT && Float.compare(f2, bVar) > 0) {
            } else {
            }
            if (obj.t == 0) {
            }
            if (cmp != mATCH_CONSTRAINT) {
            }
            if (!obj.d0()) {
            }
            i2 = nVar;
            if (obj.s == 0) {
            }
            if (bVar != mATCH_CONSTRAINT) {
            }
            if (!obj.d0()) {
            }
            i2 = nVar;
            if (obj.s != nVar) {
            } else {
            }
            if (bVar == mATCH_CONSTRAINT) {
            } else {
            }
            if (obj.t != nVar) {
            } else {
            }
            i2 = nVar;
            cmp = obj.d;
            if (cmp != null) {
            } else {
            }
            nVar = obj.e;
            if (nVar != null) {
            } else {
            }
            if (gVar.j) {
            } else {
            }
            if (gVar2.j) {
            } else {
            }
        }
        bVar2.a();
    }

    private void c(f f, String string2, int i3, int i4, int i5) {
        final int i2 = 0;
        f.R0(i2);
        f.Q0(i2);
        f.b1(i4);
        f.C0(i5);
        f.R0(f.G());
        f.Q0(f.F());
        this.c.N1(i3);
        this.c.j1();
    }

    public long d(f f, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i19;
        int i22;
        int i13;
        int i14;
        int i23;
        int size;
        int i18;
        d.f.a.m.m.b.b bVar2;
        int size2;
        int i;
        int i29;
        int i26;
        int str;
        int i12;
        boolean z2;
        int cmp;
        int i25;
        int i27;
        int i30;
        Object obj;
        int i21;
        d.f.a.e eVar;
        boolean z;
        int i28;
        int i32;
        int i16;
        int i11;
        e.b mATCH_CONSTRAINT;
        int i20;
        int i31;
        int i33;
        d.f.a.m.m.b.b bVar;
        int i15;
        int i17;
        int i24;
        int obj25;
        f obj26;
        String obj27;
        int obj28;
        int obj29;
        int obj30;
        int obj31;
        final Object obj2 = this;
        Object obj3 = f;
        i13 = i2;
        i14 = i5;
        size = i7;
        size2 = obj3.u0.size();
        boolean z5 = j.b(i13, 128);
        i12 = 0;
        if (!z5) {
            if (j.b(i13, 64)) {
                i19 = 1;
            } else {
                i19 = i12;
            }
        } else {
        }
        if (i19 != 0) {
            i27 = i12;
            while (i27 < size2) {
                obj = obj3.u0.get(i27);
                mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                if ((e)obj.y() == mATCH_CONSTRAINT) {
                } else {
                }
                i28 = i12;
                if (obj.O() == mATCH_CONSTRAINT) {
                } else {
                }
                cmp = i12;
                if (i28 != 0 && cmp != 0 && Float.compare(f2, i28) > 0) {
                } else {
                }
                z2 = i12;
                i27++;
                if (cmp != 0) {
                } else {
                }
                if (Float.compare(f2, i28) > 0) {
                } else {
                }
                z2 = 1;
                cmp = 1;
                i28 = 1;
            }
        }
        obj = d.x;
        if (i19 != 0 && obj != null) {
            obj = d.x;
            if (obj != null) {
                obj.c = l3 += i25;
            }
        }
        i21 = 1073741824;
        if (i14 == i21) {
            if (size != i21) {
                i32 = z5 ? 1 : i12;
            } else {
            }
        } else {
        }
        i16 = 2;
        if (i19 &= i32 != 0) {
            i25 = Math.min(f.E(), i6);
            int i52 = Math.min(f.D(), i8);
            if (i14 == i21 && f.R() != i25) {
                if (f.R() != i25) {
                    obj3.b1(i25);
                    f.C1();
                }
            }
            if (size == i21 && f.v() != i52) {
                if (f.v() != i52) {
                    obj3.C0(i52);
                    f.C1();
                }
            }
            if (i14 == i21 && size == i21) {
                if (size == i21) {
                    str = obj3.w1(z5);
                    i30 = i16;
                } else {
                    if (i14 == i21) {
                        i25 &= z7;
                        i30 = 1;
                    } else {
                        i30 = i12;
                    }
                    if (size == i21) {
                        z6 &= i25;
                        i30++;
                    } else {
                        str = i25;
                    }
                }
            } else {
            }
            if (str != null) {
                mATCH_CONSTRAINT = i14 == i21 ? 1 : i12;
                i14 = size == i21 ? 1 : i12;
                obj3.g1(mATCH_CONSTRAINT, i14);
            }
        } else {
            i30 = str;
        }
        if (str != null) {
            if (i30 != i16 && size2 > 0) {
                if (size2 > 0) {
                    b(f);
                }
                e(f);
                size = obj2.a.size();
                if (size2 > 0) {
                    this.c(f, "First pass", 0, f.R(), f.v());
                }
                if (size > 0) {
                    e.b wRAP_CONTENT = e.b.WRAP_CONTENT;
                    mATCH_CONSTRAINT = f.y() == wRAP_CONTENT ? 1 : i12;
                    size2 = f.O() == wRAP_CONTENT ? 1 : i12;
                    str = Math.max(f.R(), obj2.c.G());
                    i25 = Math.max(f.v(), obj2.c.F());
                    i21 = i30;
                    while (i30 < size) {
                        Object obj4 = obj2.a.get(i30);
                        if (!obj4 instanceof k) {
                        } else {
                        }
                        obj31 = i14;
                        i31 = i26;
                        eVar = obj3.A0;
                        i33 = i;
                        if (eVar != null) {
                        }
                        i29 = obj4.R();
                        i26 = obj4.v();
                        if (i29 != (e)obj4.R()) {
                        } else {
                        }
                        i = obj25;
                        obj4.C0(i26);
                        if (i26 != obj4.v() && size2 != 0 && obj4.p() > i25) {
                        }
                        i21 = i | i14;
                        i30++;
                        i14 = obj31;
                        i26 = i31;
                        i = i33;
                        i12 = 0;
                        i16 = 2;
                        obj4.C0(i26);
                        if (size2 != 0) {
                        }
                        i = 1;
                        if (obj4.p() > i25) {
                        }
                        i25 = i23;
                        obj4.b1(i29);
                        if (mATCH_CONSTRAINT != 0 && obj4.K() > str) {
                        }
                        i = 1;
                        if (obj4.K() > str) {
                        }
                        str = i29;
                        eVar.b = l2 += i20;
                        obj31 = i14;
                        i33 = i;
                        i31 = i26;
                    }
                    i = i16;
                    i14 = 0;
                    while (i14 < i) {
                        i26 = 0;
                        while (i26 < size) {
                            i12 = obj2.a.get(i26);
                            if (i12 instanceof h) {
                            } else {
                            }
                            if (i12 instanceof g) {
                            } else {
                            }
                            if ((e)i12.Q() == 8) {
                            } else {
                            }
                            if (i22 != 0 && gVar.j && gVar2.j) {
                            } else {
                            }
                            if (i12 instanceof k) {
                            } else {
                            }
                            i15 = b.a.l;
                            i17 = i22;
                            if (i14 == 1) {
                            }
                            z3 |= i21;
                            d.f.a.e a0 = obj3.A0;
                            i24 = size;
                            bVar = bVar2;
                            if (a0 != null) {
                            } else {
                            }
                            i20 = 1;
                            i18 = i12.R();
                            bVar2 = i12.v();
                            i12.b1(i18);
                            if (i18 != i12.R() && mATCH_CONSTRAINT != 0 && i12.K() > str) {
                            }
                            i12.C0(bVar2);
                            if (bVar2 != i12.v() && size2 != 0 && i12.p() > i25) {
                            }
                            if (i12.U() && i12.n() != i12.n()) {
                            } else {
                            }
                            i21 = i22;
                            i26++;
                            bVar2 = bVar;
                            i22 = i17;
                            size = i24;
                            i = 2;
                            if (i12.n() != i12.n()) {
                            } else {
                            }
                            i21 = 1;
                            i12.C0(bVar2);
                            if (size2 != 0) {
                            }
                            i22 = 1;
                            if (i12.p() > i25) {
                            }
                            i25 = i22;
                            i12.b1(i18);
                            if (mATCH_CONSTRAINT != 0) {
                            }
                            i22 = 1;
                            if (i12.K() > str) {
                            }
                            str = Math.max(str, i39 += i18);
                            a0.b = l += i20;
                            i15 = b.a.m;
                            i17 = i22;
                            i24 = size;
                            bVar = bVar2;
                            i20 = 1;
                            if (gVar.j) {
                            } else {
                            }
                            if (gVar2.j) {
                            } else {
                            }
                            if (i12 instanceof k) {
                            } else {
                            }
                        }
                        i20 = 1;
                        if (i21 != 0) {
                        }
                        this.c(f, "intermediate pass", i14++, i, i26);
                        bVar2 = bVar;
                        i22 = i17;
                        size = i24;
                        i = 2;
                        i21 = 0;
                        i12 = obj2.a.get(i26);
                        if (i12 instanceof h) {
                        } else {
                        }
                        if (i12 instanceof g) {
                        } else {
                        }
                        if ((e)i12.Q() == 8) {
                        } else {
                        }
                        if (i22 != 0 && gVar.j && gVar2.j) {
                        } else {
                        }
                        if (i12 instanceof k) {
                        } else {
                        }
                        i15 = b.a.l;
                        i17 = i22;
                        if (i14 == 1) {
                        }
                        z3 |= i21;
                        a0 = obj3.A0;
                        i24 = size;
                        bVar = bVar2;
                        if (a0 != null) {
                        } else {
                        }
                        i20 = 1;
                        i18 = i12.R();
                        bVar2 = i12.v();
                        i12.b1(i18);
                        if (i18 != i12.R() && mATCH_CONSTRAINT != 0 && i12.K() > str) {
                        }
                        i12.C0(bVar2);
                        if (bVar2 != i12.v() && size2 != 0 && i12.p() > i25) {
                        }
                        if (i12.U() && i12.n() != i12.n()) {
                        } else {
                        }
                        i21 = i22;
                        i26++;
                        bVar2 = bVar;
                        i22 = i17;
                        size = i24;
                        i = 2;
                        if (i12.n() != i12.n()) {
                        } else {
                        }
                        i21 = 1;
                        i12.C0(bVar2);
                        if (size2 != 0) {
                        }
                        i22 = 1;
                        if (i12.p() > i25) {
                        }
                        i25 = i22;
                        i12.b1(i18);
                        if (mATCH_CONSTRAINT != 0) {
                        }
                        i22 = 1;
                        if (i12.K() > str) {
                        }
                        str = Math.max(str, i39 += i18);
                        a0.b = l += i20;
                        i15 = b.a.m;
                        i17 = i22;
                        i24 = size;
                        bVar = bVar2;
                        i20 = 1;
                        if (gVar.j) {
                        } else {
                        }
                        if (gVar2.j) {
                        } else {
                        }
                        if (i12 instanceof k) {
                        } else {
                        }
                    }
                    i22 = obj31;
                } else {
                    i22 = i14;
                }
                obj3.M1(i22);
            }
        } else {
        }
        return 0;
    }

    public void e(f f) {
        int i;
        Object obj;
        e.b bVar;
        e.b mATCH_CONSTRAINT;
        this.a.clear();
        i = 0;
        while (i < f.u0.size()) {
            obj = f.u0.get(i);
            mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
            if ((e)obj.y() != mATCH_CONSTRAINT) {
            } else {
            }
            this.a.add(obj);
            i++;
            if (obj.O() == mATCH_CONSTRAINT) {
            }
        }
        f.C1();
    }
}
