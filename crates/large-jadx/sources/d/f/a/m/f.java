package d.f.a.m;

import d.f.a.d;
import d.f.a.e;
import d.f.a.i;
import d.f.a.m.m.b;
import d.f.a.m.m.b.a;
import d.f.a.m.m.b.b;
import d.f.a.m.m.e;
import d.f.a.m.m.h;
import d.f.a.m.m.i;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class f extends d.f.a.m.l {

    public e A0;
    protected d B0;
    int C0;
    int D0;
    public int E0 = 0;
    public int F0 = 0;
    d.f.a.m.c[] G0;
    d.f.a.m.c[] H0;
    private int I0 = 257;
    private boolean J0 = false;
    private boolean K0 = false;
    private WeakReference<d.f.a.m.d> L0 = null;
    private WeakReference<d.f.a.m.d> M0 = null;
    private WeakReference<d.f.a.m.d> N0 = null;
    private WeakReference<d.f.a.m.d> O0 = null;
    HashSet<d.f.a.m.e> P0;
    public b.a Q0;
    b v0;
    public e w0;
    private int x0;
    protected b.b y0 = null;
    private boolean z0 = false;
    static {
    }

    public f() {
        super();
        b bVar = new b(this);
        this.v0 = bVar;
        e eVar = new e(this);
        this.w0 = eVar;
        int i = 0;
        final int i2 = 0;
        d dVar = new d();
        this.B0 = dVar;
        int i3 = 4;
        this.G0 = new c[i3];
        this.H0 = new c[i3];
        int i4 = 257;
        HashSet hashSet = new HashSet();
        this.P0 = hashSet;
        b.a aVar = new b.a();
        this.Q0 = aVar;
    }

    public static boolean I1(int i, d.f.a.m.e e2, b.b b$b3, b.a b$a4, int i5) {
        int i2;
        d.f.a.m.e.b wRAP_CONTENT;
        int i6;
        int i3;
        int cmp;
        int i4;
        int cmp2;
        float f;
        int obj5;
        int obj9;
        obj5 = 0;
        if (b3 == null) {
            return obj5;
        }
        if (e2.Q() != 8 && !e2 instanceof g) {
            if (!e2 instanceof g) {
                if (e2 instanceof a) {
                } else {
                    a4.a = e2.y();
                    a4.b = e2.O();
                    a4.c = e2.R();
                    a4.d = e2.v();
                    a4.i = obj5;
                    a4.j = i5;
                    d.f.a.m.e.b mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                    int i10 = 1;
                    obj9 = a4.a == mATCH_CONSTRAINT ? i10 : obj5;
                    i2 = a4.b == mATCH_CONSTRAINT ? i10 : obj5;
                    cmp = 0;
                    if (obj9 != null && Float.compare(f3, cmp) > 0) {
                        i4 = Float.compare(f3, cmp) > 0 ? i10 : obj5;
                    } else {
                    }
                    if (i2 != 0 && Float.compare(f, cmp) > 0) {
                        i3 = Float.compare(f, cmp) > 0 ? i10 : obj5;
                    } else {
                    }
                    a4.a = e.b.WRAP_CONTENT;
                    if (obj9 != null && e2.V(obj5) && e2.s == 0 && i4 == 0 && i2 != 0 && e2.t == 0) {
                        if (e2.V(obj5)) {
                            if (e2.s == 0) {
                                if (i4 == 0) {
                                    a4.a = e.b.WRAP_CONTENT;
                                    if (i2 != 0) {
                                        if (e2.t == 0) {
                                            a4.a = e.b.FIXED;
                                        }
                                    }
                                    obj9 = obj5;
                                }
                            }
                        }
                    }
                    a4.b = e.b.WRAP_CONTENT;
                    if (i2 != 0 && e2.V(i10) && e2.t == 0 && i3 == 0 && obj9 != null && e2.s == 0) {
                        if (e2.V(i10)) {
                            if (e2.t == 0) {
                                if (i3 == 0) {
                                    a4.b = e.b.WRAP_CONTENT;
                                    if (obj9 != null) {
                                        if (e2.s == 0) {
                                            a4.b = e.b.FIXED;
                                        }
                                    }
                                    i2 = obj5;
                                }
                            }
                        }
                    }
                    if (e2.i0()) {
                        a4.a = e.b.FIXED;
                        obj9 = obj5;
                    }
                    if (e2.j0()) {
                        a4.b = e.b.FIXED;
                        i2 = obj5;
                    }
                    int i11 = 4;
                    if (i4 != 0) {
                        if (e2.u[obj5] == i11) {
                            a4.a = e.b.FIXED;
                        } else {
                            if (i2 == 0) {
                                d.f.a.m.e.b fIXED = e.b.FIXED;
                                if (a4.b == fIXED) {
                                    obj5 = a4.d;
                                } else {
                                    a4.a = e.b.WRAP_CONTENT;
                                    b3.b(e2, a4);
                                    obj5 = a4.f;
                                }
                                a4.a = fIXED;
                                a4.c = (int)i2;
                            }
                        }
                    }
                    if (i3 != 0) {
                        if (e2.u[i10] == i11) {
                            a4.b = e.b.FIXED;
                        } else {
                            if (obj9 == null) {
                                obj9 = e.b.FIXED;
                                if (a4.a == obj9) {
                                    obj5 = a4.c;
                                } else {
                                    a4.b = e.b.WRAP_CONTENT;
                                    b3.b(e2, a4);
                                    obj5 = a4.e;
                                }
                                a4.b = obj9;
                                if (e2.u() == -1) {
                                    a4.d = (int)obj5;
                                } else {
                                    a4.d = (int)obj9;
                                }
                            }
                        }
                    }
                }
                b3.b(e2, a4);
                e2.b1(a4.e);
                e2.C0(a4.f);
                e2.B0(a4.h);
                e2.r0(a4.g);
                a4.j = b.a.k;
                return a4.i;
            }
        }
        a4.e = obj5;
        a4.f = obj5;
        return obj5;
    }

    private void K1() {
        final int i = 0;
        this.E0 = i;
        this.F0 = i;
    }

    private void o1(d.f.a.m.e e) {
        int copyOf;
        d.f.a.m.c[] h02 = this.H0;
        if (e0++ >= h02.length) {
            this.H0 = (c[])Arrays.copyOf(h02, length *= 2);
        }
        c cVar = new c(e, 0, F1());
        this.H0[this.E0] = cVar;
        this.E0 = obj6++;
    }

    private void r1(d.f.a.m.d d, i i2) {
        this.B0.h(i2, this.B0.q(d), 0, 5);
    }

    private void s1(d.f.a.m.d d, i i2) {
        this.B0.h(this.B0.q(d), i2, 0, 5);
    }

    private void t1(d.f.a.m.e e) {
        int copyOf;
        final int i2 = 1;
        d.f.a.m.c[] g02 = this.G0;
        if (f0 += i2 >= g02.length) {
            this.G0 = (c[])Arrays.copyOf(g02, length *= 2);
        }
        c cVar = new c(e, i2, F1());
        this.G0[this.F0] = cVar;
        this.F0 = obj6 += i2;
    }

    @Override // d.f.a.m.l
    public int A1() {
        return this.I0;
    }

    @Override // d.f.a.m.l
    public d B1() {
        return this.B0;
    }

    @Override // d.f.a.m.l
    public void C1() {
        this.w0.j();
    }

    @Override // d.f.a.m.l
    public void D1() {
        this.w0.k();
    }

    @Override // d.f.a.m.l
    public boolean E1() {
        return this.K0;
    }

    @Override // d.f.a.m.l
    public boolean F1() {
        return this.z0;
    }

    @Override // d.f.a.m.l
    public boolean G1() {
        return this.J0;
    }

    @Override // d.f.a.m.l
    public long H1(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        final Object obj = this;
        final int i11 = i8;
        obj.C0 = i11;
        final int i12 = i9;
        obj.D0 = i12;
        return obj.v0.d(this, i, i11, i12, i2, i3, i4, i5, i6, i7);
    }

    @Override // d.f.a.m.l
    public boolean J1(int i) {
        int obj2;
        obj2 = i0 &= i == i ? 1 : 0;
        return obj2;
    }

    @Override // d.f.a.m.l
    public void L1(b.b b$b) {
        this.y0 = b;
        this.w0.n(b);
    }

    @Override // d.f.a.m.l
    public void M1(int i) {
        this.I0 = i;
        d.r = J1(512);
    }

    @Override // d.f.a.m.l
    public void N1(int i) {
        this.x0 = i;
    }

    @Override // d.f.a.m.l
    public void O1(boolean z) {
        this.z0 = z;
    }

    @Override // d.f.a.m.l
    public boolean P1(d d, boolean[] z2Arr2) {
        int i;
        int i2;
        boolean z;
        i = 0;
        z2Arr2[2] = i;
        boolean obj6 = J1(64);
        h1(d, obj6);
        i2 = i;
        while (i < this.u0.size()) {
            Object obj = this.u0.get(i);
            (e)obj.h1(d, obj6);
            if (obj.X()) {
            }
            i++;
            i2 = 1;
        }
        return i2;
    }

    @Override // d.f.a.m.l
    public void Q1() {
        this.v0.e(this);
    }

    @Override // d.f.a.m.l
    public void g1(boolean z, boolean z2) {
        int i;
        Object obj;
        super.g1(z, z2);
        i = 0;
        while (i < this.u0.size()) {
            (e)this.u0.get(i).g1(z, z2);
            i++;
        }
    }

    @Override // d.f.a.m.l
    public void j1() {
        int i23;
        int i6;
        int i21;
        Object obj2;
        Object obj4;
        Object obj5;
        Object obj;
        int i2;
        int i25;
        int i11;
        d.f.a.m.e.b bVar;
        int i7;
        int i5;
        int i;
        int i12;
        int i8;
        int i13;
        int fIXED;
        int i19;
        int i18;
        int i3;
        int i28;
        int wRAP_CONTENT2;
        int i14;
        int i24;
        int i10;
        int i22;
        int wRAP_CONTENT3;
        int i9;
        boolean aVar;
        d.f.a.m.e.b bVar2;
        int i15;
        int i16;
        boolean z3;
        d.f.a.m.e.b mATCH_CONSTRAINT;
        int i4;
        d.f.a.m.e.b bVar3;
        int i20;
        int wRAP_CONTENT;
        Object obj3;
        int i26;
        int z;
        boolean z2;
        int i27;
        int i17;
        final Object obj6 = this;
        i12 = 0;
        obj6.b0 = i12;
        obj6.c0 = i12;
        obj6.J0 = i12;
        obj6.K0 = i12;
        final int size = obj6.u0.size();
        i = Math.max(i12, R());
        i28 = Math.max(i12, v());
        d.f.a.m.e.b[] objArr4 = obj6.V;
        wRAP_CONTENT2 = 1;
        final d.f.a.m.e.b bVar5 = objArr4[wRAP_CONTENT2];
        d.f.a.m.e.b bVar4 = objArr4[i12];
        e a0 = obj6.A0;
        if (a0 != null) {
            a0.z = l += i15;
        }
        if (obj6.x0 == 0 && j.b(obj6.I0, wRAP_CONTENT2)) {
            if (j.b(obj6.I0, wRAP_CONTENT2)) {
                h.h(obj6, z1());
                i10 = i12;
                while (i10 < size) {
                    wRAP_CONTENT3 = obj6.u0.get(i10);
                    if ((e)wRAP_CONTENT3.h0() && !wRAP_CONTENT3 instanceof g && !wRAP_CONTENT3 instanceof a && !wRAP_CONTENT3 instanceof k && !wRAP_CONTENT3.g0()) {
                    }
                    i10++;
                    if (!wRAP_CONTENT3 instanceof g) {
                    }
                    if (!wRAP_CONTENT3 instanceof a) {
                    }
                    if (!wRAP_CONTENT3 instanceof k) {
                    }
                    if (!wRAP_CONTENT3.g0()) {
                    }
                    mATCH_CONSTRAINT = e.b.MATCH_CONSTRAINT;
                    if (wRAP_CONTENT3.s(i12) == mATCH_CONSTRAINT && wRAP_CONTENT3.s != wRAP_CONTENT2 && wRAP_CONTENT3.s(wRAP_CONTENT2) == mATCH_CONSTRAINT && wRAP_CONTENT3.t != wRAP_CONTENT2) {
                    } else {
                    }
                    aVar = i12;
                    if (aVar == 0) {
                    }
                    aVar = new b.a();
                    f.I1(i12, wRAP_CONTENT3, obj6.y0, aVar, b.a.k);
                    if (wRAP_CONTENT3.s != wRAP_CONTENT2) {
                    } else {
                    }
                    if (wRAP_CONTENT3.s(wRAP_CONTENT2) == mATCH_CONSTRAINT) {
                    } else {
                    }
                    if (wRAP_CONTENT3.t != wRAP_CONTENT2) {
                    } else {
                    }
                    aVar = wRAP_CONTENT2;
                }
            }
        }
        if (size > 2) {
            wRAP_CONTENT3 = e.b.WRAP_CONTENT;
            if (bVar4 != wRAP_CONTENT3) {
                if (bVar5 == wRAP_CONTENT3 && j.b(obj6.I0, 1024) && i.c(obj6, z1())) {
                    if (j.b(obj6.I0, 1024)) {
                        if (i.c(obj6, z1())) {
                            if (bVar4 == wRAP_CONTENT3) {
                                if (i < R() && i > 0) {
                                    if (i > 0) {
                                        obj6.b1(i);
                                        obj6.J0 = wRAP_CONTENT2;
                                    } else {
                                        i = R();
                                    }
                                } else {
                                }
                            }
                            if (bVar5 == wRAP_CONTENT3) {
                                if (i28 < v() && i28 > 0) {
                                    if (i28 > 0) {
                                        obj6.C0(i28);
                                        obj6.K0 = wRAP_CONTENT2;
                                    } else {
                                        i28 = v();
                                    }
                                } else {
                                }
                            }
                            i9 = i28;
                            i3 = i;
                            i23 = wRAP_CONTENT2;
                        } else {
                            i9 = i28;
                            i3 = i;
                            i23 = i12;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        int i44 = 64;
        if (!obj6.J1(i44)) {
            if (obj6.J1(128)) {
                i16 = wRAP_CONTENT2;
            } else {
                i16 = i12;
            }
        } else {
        }
        d b012 = obj6.B0;
        b012.h = i12;
        b012.i = i12;
        if (obj6.I0 != 0 && i16 != 0) {
            if (i16 != 0) {
                b012.i = wRAP_CONTENT2;
            }
        }
        d.f.a.m.e.b wRAP_CONTENT4 = e.b.WRAP_CONTENT;
        if (y() != wRAP_CONTENT4) {
            if (O() == wRAP_CONTENT4) {
                i4 = wRAP_CONTENT2;
            } else {
                i4 = i12;
            }
        } else {
        }
        K1();
        i20 = i12;
        while (i20 < size) {
            obj3 = obj6.u0.get(i20);
            if (obj3 instanceof l) {
            }
            i20++;
            (l)(e)obj3.j1();
        }
        boolean z4 = obj6.J1(i44);
        wRAP_CONTENT = i23;
        i6 = i12;
        i26 = wRAP_CONTENT2;
        while (i26 != 0) {
            z2 = i6 + 1;
            obj6.B0.D();
            K1();
            obj6.k(obj6.B0);
            i21 = i12;
            while (i21 < size) {
                (e)obj6.u0.get(i21).k(obj6.B0);
                i21++;
                i12 = 0;
                wRAP_CONTENT2 = 1;
            }
            z = obj6.n1(obj6.B0);
            obj2 = obj6.L0;
            i8 = 0;
            if (obj2 != null && obj2.get() != null) {
            }
            obj4 = obj6.N0;
            if (obj4 != null && obj4.get() != null) {
            }
            obj5 = obj6.M0;
            if (obj5 != null && obj5.get() != null) {
            }
            obj = obj6.O0;
            if (obj != null && obj.get() != null) {
            }
            if (z) {
            }
            if (z) {
            } else {
            }
            obj6.h1(obj6.B0, z4);
            i5 = 0;
            while (i5 < size) {
                (e)obj6.u0.get(i5).h1(obj6.B0, z4);
                i5++;
            }
            i2 = 0;
            if (i4 != 0 && z2 < 8 && j.a[2]) {
            } else {
            }
            i27 = i2;
            i25 = Math.max(obj6.e0, R());
            if (i25 > R()) {
            }
            i11 = Math.max(obj6.f0, v());
            if (i11 > v()) {
            } else {
            }
            i24 = 1;
            i19 = wRAP_CONTENT;
            if (i19 == 0) {
            } else {
            }
            wRAP_CONTENT = i19;
            i18 = i27;
            i7 = 8;
            if (z2 > i7) {
            } else {
            }
            i26 = i18;
            i6 = z2;
            i12 = 0;
            wRAP_CONTENT2 = 1;
            i22 = 2;
            i26 = 0;
            i22 = 0;
            wRAP_CONTENT = e.b.WRAP_CONTENT;
            if (obj6.V[i22] == wRAP_CONTENT && i3 > 0 && R() > i3) {
            }
            if (obj6.V[i24] == wRAP_CONTENT && i9 > 0 && v() > i9) {
            } else {
            }
            if (i9 > 0) {
            } else {
            }
            if (v() > i9) {
            } else {
            }
            obj6.K0 = i24;
            obj6.V[i24] = e.b.FIXED;
            obj6.C0(i9);
            i7 = 8;
            i18 = 1;
            wRAP_CONTENT = 1;
            if (i3 > 0) {
            }
            if (R() > i3) {
            }
            obj6.J0 = i24;
            obj6.V[i22] = e.b.FIXED;
            obj6.b1(i3);
            i27 = i19;
            obj6.C0(i11);
            i24 = 1;
            obj6.V[i24] = e.b.FIXED;
            i27 = i19;
            obj6.b1(i25);
            obj6.V[0] = e.b.FIXED;
            wRAP_CONTENT = 1;
            i27 = 1;
            if (z2 < 8) {
            } else {
            }
            if (j.a[2]) {
            } else {
            }
            i14 = 0;
            i22 = 0;
            z = 0;
            while (i14 < size) {
                Object obj7 = obj6.u0.get(i14);
                z = Math.max(z, i31 += i17);
                i22 = Math.max(i22, i33 += i39);
                i14++;
                i2 = i27;
                i13 = 8;
            }
            i27 = i2;
            i2 = Math.max(obj6.e0, z);
            i13 = Math.max(obj6.f0, i22);
            wRAP_CONTENT2 = e.b.WRAP_CONTENT;
            if (bVar4 == wRAP_CONTENT2 && R() < i2) {
            }
            if (bVar5 == wRAP_CONTENT2 && v() < i13) {
            }
            if (v() < i13) {
            }
            obj6.C0(i13);
            obj6.V[1] = wRAP_CONTENT2;
            wRAP_CONTENT = 1;
            i27 = 1;
            if (R() < i2) {
            }
            obj6.b1(i2);
            obj6.V[0] = wRAP_CONTENT2;
            wRAP_CONTENT = 1;
            i27 = 1;
            obj7 = obj6.u0.get(i14);
            z = Math.max(z, i31 += i17);
            i22 = Math.max(i22, i33 += i39);
            i14++;
            i2 = i27;
            i13 = 8;
            (e)obj6.u0.get(i5).h1(obj6.B0, z4);
            i5++;
            i2 = obj6.P1(obj6.B0, j.a);
            obj6.B0.z();
            if (obj.get() != null) {
            }
            obj6.r1((d)obj6.O0.get(), obj6.B0.q(obj6.M));
            obj6.O0 = i8;
            if (obj5.get() != null) {
            }
            obj6.s1((d)obj6.M0.get(), obj6.B0.q(obj6.K));
            obj6.M0 = i8;
            if (obj4.get() != null) {
            }
            obj6.r1((d)obj6.N0.get(), obj6.B0.q(obj6.N));
            obj6.N0 = i8;
            if (obj2.get() != null) {
            }
            obj6.s1((d)obj6.L0.get(), obj6.B0.q(obj6.L));
            obj6.L0 = i8;
            (e)obj6.u0.get(i21).k(obj6.B0);
            i21++;
            i12 = 0;
            wRAP_CONTENT2 = 1;
            string.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("EXCEPTION : ");
            stringBuilder.append(string);
            Throwable string = stringBuilder.toString();
            System.out.println(string);
        }
        obj6.u0 = obj6.u0;
        if (wRAP_CONTENT != 0) {
            i6 = obj6.V;
            i6[0] = bVar4;
            i6[1] = bVar5;
        }
        obj6.q0(obj6.B0.v());
    }

    @Override // d.f.a.m.l
    void m1(d.f.a.m.e e, int i2) {
        int i;
        if (i2 == 0) {
            o1(e);
        } else {
            if (i2 == 1) {
                t1(e);
            }
        }
    }

    @Override // d.f.a.m.l
    public boolean n1(d d) {
        Iterator iterator;
        int i3;
        int size;
        HashSet hashSet;
        boolean next2;
        int wRAP_CONTENT2;
        int i4;
        Object iterator2;
        int i;
        boolean next;
        boolean z;
        Object wRAP_CONTENT;
        Object fIXED;
        int i2;
        int i5;
        boolean z2 = J1(64);
        g(d, z2);
        iterator = this.u0.size();
        final int i8 = 0;
        wRAP_CONTENT2 = i3;
        i = 1;
        while (i3 < iterator) {
            Object obj = this.u0.get(i3);
            (e)obj.J0(i8, i8);
            obj.J0(i, i8);
            if (obj instanceof a) {
            }
            i3++;
            i = 1;
            wRAP_CONTENT2 = i;
        }
        if (wRAP_CONTENT2 != 0) {
            i3 = i8;
            while (i3 < iterator) {
                wRAP_CONTENT2 = this.u0.get(i3);
                if (wRAP_CONTENT2 instanceof a) {
                }
                i3++;
                (a)(e)wRAP_CONTENT2.p1();
            }
        }
        this.P0.clear();
        size = i8;
        while (size < iterator) {
            wRAP_CONTENT2 = this.u0.get(size);
            if ((e)wRAP_CONTENT2.f()) {
            }
            size++;
            if (wRAP_CONTENT2 instanceof k) {
            } else {
            }
            wRAP_CONTENT2.g(d, z2);
            this.P0.add(wRAP_CONTENT2);
        }
        while (this.P0.size() > 0) {
            iterator2 = this.P0.iterator();
            while (iterator2.hasNext()) {
                next = iterator2.next();
                if ((k)(e)next.l1(this.P0)) {
                    break loop_20;
                } else {
                }
            }
            if (this.P0.size() == this.P0.size()) {
            }
            Iterator iterator3 = this.P0.iterator();
            for (e wRAP_CONTENT2 : iterator3) {
                wRAP_CONTENT2.g(d, z2);
            }
            this.P0.clear();
            (e)iterator3.next().g(d, z2);
            next = iterator2.next();
            if ((k)(e)next.l1(this.P0)) {
            } else {
            }
            next.g(d, z2);
            this.P0.remove(next);
        }
        if (d.r) {
            hashSet = new HashSet();
            i4 = i8;
            while (i4 < iterator) {
                next = this.u0.get(i4);
                if (!(e)next.f()) {
                }
                i4++;
                hashSet.add(next);
            }
            i2 = y() == e.b.WRAP_CONTENT ? i8 : i;
            this.e(this, d, hashSet, i2, false);
            iterator = hashSet.iterator();
            for (e hashSet : iterator) {
                j.a(this, d, hashSet);
                hashSet.g(d, z2);
            }
        } else {
            next2 = i8;
            while (next2 < iterator) {
                wRAP_CONTENT2 = this.u0.get(next2);
                if (wRAP_CONTENT2 instanceof f) {
                } else {
                }
                j.a(this, d, (e)wRAP_CONTENT2);
                if (!wRAP_CONTENT2.f()) {
                }
                next2++;
                wRAP_CONTENT2.g(d, z2);
                d.f.a.m.e.b[] objArr = wRAP_CONTENT2.V;
                z = objArr[i8];
                next = objArr[i];
                wRAP_CONTENT = e.b.WRAP_CONTENT;
                if (z == wRAP_CONTENT) {
                }
                if (next == wRAP_CONTENT) {
                }
                wRAP_CONTENT2.g(d, z2);
                if (z == wRAP_CONTENT) {
                }
                if (next == wRAP_CONTENT) {
                }
                wRAP_CONTENT2.X0(next);
                wRAP_CONTENT2.G0(z);
                wRAP_CONTENT2.X0(e.b.FIXED);
                wRAP_CONTENT2.G0(e.b.FIXED);
            }
        }
        int i7 = 0;
        if (this.E0 > 0) {
            b.b(this, d, i7, i8);
        }
        if (this.F0 > 0) {
            b.b(this, d, i7, i);
        }
        return i;
    }

    @Override // d.f.a.m.l
    public void o0() {
        this.B0.D();
        int i = 0;
        this.C0 = i;
        this.D0 = i;
        super.o0();
    }

    @Override // d.f.a.m.l
    public void p1(d.f.a.m.d d) {
        WeakReference weakReference;
        int i;
        weakReference = this.O0;
        if (weakReference != null && weakReference.get() != null) {
            if (weakReference.get() != null) {
                if (d.d() > (d)this.O0.get().d()) {
                    weakReference = new WeakReference(d);
                    this.O0 = weakReference;
                }
            } else {
            }
        } else {
        }
    }

    @Override // d.f.a.m.l
    public void q1(d.f.a.m.d d) {
        WeakReference weakReference;
        int i;
        weakReference = this.M0;
        if (weakReference != null && weakReference.get() != null) {
            if (weakReference.get() != null) {
                if (d.d() > (d)this.M0.get().d()) {
                    weakReference = new WeakReference(d);
                    this.M0 = weakReference;
                }
            } else {
            }
        } else {
        }
    }

    @Override // d.f.a.m.l
    void u1(d.f.a.m.d d) {
        WeakReference weakReference;
        int i;
        weakReference = this.N0;
        if (weakReference != null && weakReference.get() != null) {
            if (weakReference.get() != null) {
                if (d.d() > (d)this.N0.get().d()) {
                    weakReference = new WeakReference(d);
                    this.N0 = weakReference;
                }
            } else {
            }
        } else {
        }
    }

    @Override // d.f.a.m.l
    void v1(d.f.a.m.d d) {
        WeakReference weakReference;
        int i;
        weakReference = this.L0;
        if (weakReference != null && weakReference.get() != null) {
            if (weakReference.get() != null) {
                if (d.d() > (d)this.L0.get().d()) {
                    weakReference = new WeakReference(d);
                    this.L0 = weakReference;
                }
            } else {
            }
        } else {
        }
    }

    @Override // d.f.a.m.l
    public boolean w1(boolean z) {
        return this.w0.f(z);
    }

    @Override // d.f.a.m.l
    public boolean x1(boolean z) {
        return this.w0.g(z);
    }

    @Override // d.f.a.m.l
    public boolean y1(boolean z, int i2) {
        return this.w0.h(z, i2);
    }

    @Override // d.f.a.m.l
    public b.b z1() {
        return this.y0;
    }
}
