package d.f.a.m;

import d.f.a.d;

/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class a extends i {

    private int w0 = 0;
    private boolean x0 = true;
    private int y0 = 0;
    boolean z0 = false;
    public a() {
        super();
    }

    @Override // d.f.a.m.i
    public void g(d dVar, boolean z) {
        int i;
        boolean z8;
        d.f.a.m.e eVar;
        d.f.a.m.d dVar4;
        d.f.a.m.e.b bVar2;
        int length = 5;
        d.f.a.m.e.b mATCH_CONSTRAINT2;
        boolean z6;
        d.f.a.i iVar;
        int i4;
        d.f.a.m.d dVar5;
        i = 0;
        this.S[i] = this.K;
        int i2 = 2;
        this.S[i2] = this.L;
        i = 1;
        this.S[i] = this.M;
        final int i13 = 3;
        this.S[i13] = this.N;
        length = objArr.length;
        while (this.S < objArr.length) {
            objArr[i].i = dVar.q(objArr[i]);
            i = i + 1;
            length = objArr.length;
        }
        if (this.w0 >= 0 && this.w0 < length) {
            d.f.a.m.d dVar37 = objArr[i6];
            if (!this.z0) {
                k1();
            }
            if (this.z0) {
                this.z0 = false;
                if (this.w0 == 0 || this.w0 == i) {
                    dVar.f(this.K.i, this.b0);
                    dVar.f(this.M.i, this.b0);
                }
                return;
            }
            while (this.b0 < this.v0) {
                eVar = this.u0[i];
                if (!this.x0 && !this.v0.h()) {
                    break;
                }
            }
            if (!this.K.k()) {
                if (this.M.k()) {
                } else {
                }
            }
            if (!this.L.k()) {
                if (this.N.k()) {
                } else {
                }
            }
            if (this.M || this.w0 == 0) {
            } else {
                if (this.v0 != 0 || this.w0 == i2) {
                } else {
                    if (!(this.L != 0 || this.w0 == i)) {
                        int r6 = i;
                    }
                }
            }
            length = 5;
            if (this.v0 == 0) {
            }
            while (this.v0 < this.v0) {
                d.f.a.m.e eVar10 = this.u0[i];
                i = i + 1;
            }
            int i8 = 8;
            if (this.w0 == 0) {
                dVar.e(this.M.i, this.K.i, i, i8);
                dVar.e(this.K.i, this.W.M.i, i, length);
                dVar.e(this.K.i, this.W.K.i, i, i);
            } else {
                if (this.w0 == i) {
                    dVar.e(this.K.i, this.M.i, i, i8);
                    dVar.e(this.K.i, this.W.K.i, i, length);
                    dVar.e(this.K.i, this.W.M.i, i, i);
                } else {
                    if (this.w0 == this.K.i) {
                        dVar.e(this.N.i, this.L.i, i, i8);
                        dVar.e(this.L.i, this.W.N.i, i, length);
                        dVar.e(this.L.i, this.W.L.i, i, i);
                    } else {
                        if (this.w0 == i13) {
                            dVar.e(this.L.i, this.N.i, i, i8);
                            dVar.e(this.L.i, this.W.L.i, i, length);
                            dVar.e(this.L.i, this.W.N.i, i, i);
                        }
                    }
                }
            }
        }
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
        int max = 0;
        boolean z;
        d.f.a.m.e eVar;
        int i;
        boolean z2;
        int i5;
        d.f.a.m.d.b rIGHT2;
        max = 0;
        max = 1;
        int i2 = 3;
        int i3 = 2;
        while (max < this.v0) {
            eVar = this.u0[max];
            max = max + 1;
        }
        if (max != 0 && this.v0 > 0) {
            while (max < this.v0) {
                d.f.a.m.e eVar2 = this.u0[max];
                max = max + 1;
            }
            max += i6;
            if (this.w0 == 0 || this.w0 == max) {
                w0(i8, i8);
            }
            this.z0 = true;
            return true;
        }
        return false;
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
        if (this.w0 != 0 && this.w0 != i && this.w0 != 2) {
            int i2 = 3;
            if (this.w0 != 3) {
                return -1;
            }
            return i;
        }
        return 0;
    }

    @Override // d.f.a.m.i
    protected void p1() {
        int i;
        boolean z;
        int i2;
        int i3;
        i = 0;
        while (i < this.v0) {
            d.f.a.m.e eVar = this.u0[i];
            i = i + 1;
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
        String str;
        int i = 0;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        String str6 = "[Barrier] ";
        String str7 = r();
        String str8 = " {";
        str = str6 + str7 + str8;
        i = 0;
        while (i < this.v0) {
            stringBuilder = new StringBuilder();
            String str5 = this.u0[i].r();
            str = str + str5;
            i = i + 1;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        String str2 = "}";
        str3 = str + str2;
        return str3;
    }

    @Override // d.f.a.m.i
    public boolean h() {
        return true;
    }
}
