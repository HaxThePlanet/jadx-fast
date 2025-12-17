package d.f.a.m;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    protected d.f.a.m.e a;
    protected d.f.a.m.e b;
    protected d.f.a.m.e c;
    protected d.f.a.m.e d;
    protected d.f.a.m.e e;
    protected d.f.a.m.e f;
    protected d.f.a.m.e g;
    protected ArrayList<d.f.a.m.e> h;
    protected int i;
    protected int j;
    protected float k = 0f;
    int l;
    int m;
    int n;
    private int o;
    private boolean p = false;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    private boolean t;
    public c(d.f.a.m.e e, int i2, boolean z3) {
        super();
        int i = 0;
        int i3 = 0;
        this.a = e;
        this.o = i2;
        this.p = z3;
    }

    private void b() {
        int i8;
        d.f.a.m.e i5;
        boolean z;
        d.f.a.m.e eVar;
        d.f.a.m.e eVar3;
        d.f.a.m.e eVar5;
        int i;
        d.f.a.m.e eVar4;
        Object dVar;
        int i9;
        int i2;
        int i6;
        int cmp;
        d.f.a.m.e.b bVar;
        d.f.a.m.e iArr;
        int i3;
        float[] fArr;
        ArrayList arrayList;
        boolean z2;
        int mATCH_CONSTRAINT;
        d.f.a.m.e eVar2;
        int i4;
        int i7;
        int cmp2;
        int i12 = 2;
        i10 *= i12;
        eVar4 = eVar5;
        i9 = i;
        i2 = 1;
        while (i9 == 0) {
            this.i = i15 += i2;
            int i30 = this.o;
            eVar2 = 0;
            eVar5.q0[i30] = eVar2;
            eVar5.p0[i30] = eVar2;
            this.l = i17 += i2;
            mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
            if (eVar5.Q() != 8 && eVar5.s(this.o) != mATCH_CONSTRAINT) {
            }
            if (eVar4 != eVar5) {
            }
            dVar = dVar4.f;
            dVar = dVar.d;
            i6 = dVar.S;
            if (dVar != null && dVar7.f != null) {
            }
            if (eVar2 != 0) {
            } else {
            }
            eVar2 = eVar5;
            i9 = i2;
            eVar4 = eVar5;
            eVar5 = eVar2;
            i2 = 1;
            dVar = dVar.d;
            i6 = dVar.S;
            if (dVar7.f != null) {
            }
            if (dVar6.d != eVar5) {
            } else {
            }
            eVar2 = dVar;
            eVar4.q0[this.o] = eVar5;
            this.l = i17 += i2;
            mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
            if (eVar5.s(this.o) != mATCH_CONSTRAINT) {
            }
            i20 += i31;
            this.m = i21;
            i7 = i8 + 1;
            this.m = i21 += i32;
            i23 += i33;
            this.n = i24;
            this.n = i24 += i34;
            if (this.b == null) {
            }
            this.d = eVar5;
            i4 = this.o;
            if (eVar5.V[i4] == mATCH_CONSTRAINT) {
            }
            iArr = eVar5.u;
            i7 = 0;
            if (iArr[i4] != 0 && iArr[i4] != 3) {
            } else {
            }
            this.j = i27 += i2;
            fArr = eVar5.o0;
            mATCH_CONSTRAINT = fArr[i4];
            if (Float.compare(mATCH_CONSTRAINT, i7) > 0) {
            }
            if (c.c(eVar5, i4)) {
            }
            if (this.f == null) {
            }
            iArr = this.g;
            if (iArr != null) {
            }
            this.g = eVar5;
            if (this.o == 0) {
            } else {
            }
            if (eVar5.t != 0) {
            } else {
            }
            if (eVar5.y == 0) {
            }
            cmp = Float.compare(f, i7);
            i3 = eVar5.z;
            if (eVar5.s != 0) {
            } else {
            }
            if (eVar5.v == 0) {
            }
            i3 = eVar5.w;
            iArr.p0[this.o] = eVar5;
            this.f = eVar5;
            if (Float.compare(mATCH_CONSTRAINT, i7) < 0) {
            } else {
            }
            this.r = i2;
            if (this.h == null) {
            }
            this.h.add(eVar5);
            arrayList = new ArrayList();
            this.h = arrayList;
            this.q = i2;
            this.k = f2 += fArr;
            if (iArr[i4] != 3) {
            } else {
            }
            this.j = i27 += i2;
            fArr = eVar5.o0;
            mATCH_CONSTRAINT = fArr[i4];
            if (iArr[i4] == i12 && Float.compare(mATCH_CONSTRAINT, i7) > 0) {
            }
            this.b = eVar5;
            this.m = i29 += i4;
        }
        eVar = this.b;
        if (eVar != null) {
            this.m = i14 -= eVar;
        }
        eVar3 = this.d;
        if (eVar3 != null) {
            this.m = i13 -= i8;
        }
        this.c = eVar5;
        if (this.o == 0 && this.p) {
            if (this.p) {
                this.e = eVar5;
            } else {
                this.e = this.a;
            }
        } else {
        }
        if (this.r && this.q) {
            if (this.q) {
                i = i2;
            }
        }
        this.s = i;
    }

    private static boolean c(d.f.a.m.e e, int i2) {
        int i;
        int mATCH_CONSTRAINT;
        int[] obj2;
        int obj3;
        if (e.Q() != 8 && e.V[i2] == e.b.MATCH_CONSTRAINT) {
            if (e.V[i2] == e.b.MATCH_CONSTRAINT) {
                obj2 = e.u;
                if (obj2[i2] != 0) {
                    obj2 = obj2[i2] == 3 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public void a() {
        if (!this.t) {
            b();
        }
        this.t = true;
    }
}
