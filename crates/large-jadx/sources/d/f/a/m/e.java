package d.f.a.m;

import d.f.a.b;
import d.f.a.d;
import d.f.a.e;
import d.f.a.i;
import d.f.a.l.a;
import d.f.a.m.m.f;
import d.f.a.m.m.l;
import d.f.a.m.m.n;
import d.f.a.m.m.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ConstraintWidget.java */
/* loaded from: classes.dex */
public class e {

    public static float t0 = 0.5f;
    public float A = 1f;
    int B = -1;
    float C = 1f;
    private int[] D;
    private float E = 0f;
    private boolean F = false;
    private boolean G;
    private boolean H = false;
    private int I = 0;
    private int J = 0;
    public d K = new d();
    public d L = new d();
    public d M = new d();
    public d N = new d();
    public d O = new d();
    d P = new d();
    d Q = new d();
    public d R = new d();
    public d[] S;
    protected ArrayList<d> T = new ArrayList<>();
    private boolean[] U;
    public e.b[] V;
    public e W = null;
    int X = 0;
    int Y = 0;
    public float Z = 0f;
    public boolean a = false;
    protected int a0 = -1;
    public d.f.a.m.m.c b;
    protected int b0 = 0;
    public d.f.a.m.m.c c;
    protected int c0 = 0;
    public l d = null;
    int d0 = 0;
    public n e = null;
    protected int e0;
    public boolean[] f;
    protected int f0;
    private boolean g = true;
    float g0;
    private boolean h = false;
    float h0;
    private boolean i = true;
    private Object i0;
    private int j = -1;
    private int j0 = 0;
    private int k = -1;
    private String k0 = null;
    private boolean l = false;
    private String l0 = null;
    private boolean m = false;
    int m0 = 0;
    private boolean n = false;
    int n0 = 0;
    private boolean o = false;
    public float[] o0;
    public int p = -1;
    protected e[] p0;
    public int q = -1;
    protected e[] q0;
    private int r = 0;
    public int r0 = -1;
    public int s = 0;
    public int s0 = -1;
    public int t = 0;
    public int[] u;
    public int v = 0;
    public int w = 0;
    public float x = 1f;
    public int y = 0;
    public int z = 0;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[e.b.values().length];
            e.a.b = iArr;
            int i2 = 1;
            try {
                iArr[e.b.FIXED.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int i9 = 4;
                int[] iArr13 = new int[d.b.values().length];
                e.a.a = iArr13;
                return;
            }
            int i = 2;
            try {
                e.a.b[e.b.WRAP_CONTENT.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum b {

        FIXED,
        MATCH_CONSTRAINT,
        MATCH_PARENT,
        WRAP_CONTENT;
    }
    public e() {
        super();
        final int i = 0;
        final d.f.a.m.e eVar = null;
        int i2 = 2;
        this.f = new boolean[] { 1, 1 };
        int i3 = 1;
        a aVar = new a(this);
        this.u = new int[i2];
        this.D = new int[] { 0x7fffffff /* Unknown resource */, 0x7fffffff /* Unknown resource */ };
        d.f.a.m.d dVar6 = new d(this, d.b.CENTER_X);
        d.f.a.m.d dVar7 = new d(this, d.b.CENTER_Y);
        d.f.a.m.d[] arr4 = new d[6];
        arr4[i] = new d(this, d.b.LEFT);
        arr4[i3] = new d(this, d.b.RIGHT);
        arr4[i2] = new d(this, d.b.TOP);
        arr4[3] = new d(this, d.b.BOTTOM);
        arr4[4] = new d(this, d.b.BASELINE);
        arr4[5] = new d(this, d.b.CENTER);
        this.S = arr4;
        ArrayList arrayList = new ArrayList();
        this.U = new boolean[i2];
        d.f.a.m.e.b[] arr3 = new e.b[i2];
        d.f.a.m.e.b fIXED2 = e.b.FIXED;
        arr3[i] = fIXED2;
        arr3[i3] = fIXED2;
        this.V = arr3;
        float f = e.t0;
        this.g0 = f;
        this.h0 = f;
        this.o0 = new float[] { -1082130432, -1082130432 };
        d.f.a.m.e[] arr2 = new e[i2];
        arr2[i] = eVar;
        arr2[i3] = eVar;
        this.p0 = arr2;
        d.f.a.m.e[] arr = new e[i2];
        arr[i] = eVar;
        arr[i3] = eVar;
        this.q0 = arr;
        d();
    }

    private boolean a0(int i) {
        d.f.a.m.d dVar;
        boolean z = true;
        d.f.a.m.d dVar2;
        int i2;
        i2 = i * 2;
        if (objArr[i2].f != null) {
            if (objArr[i2].f.f != objArr[i2]) {
                i2 = i2 + 1;
                if (objArr[i2].f != null) {
                    if (objArr[i2].f.f != objArr[i2]) {
                        int i4 = 0;
                    }
                }
            }
        }
        return z;
    }

    private void d() {
        this.T.add(this.K);
        this.T.add(this.L);
        this.T.add(this.M);
        this.T.add(this.N);
        this.T.add(this.P);
        this.T.add(this.Q);
        this.T.add(this.R);
        this.T.add(this.O);
    }

    private void i(d dVar, boolean z, boolean z2, boolean z3, boolean z4, i iVar, i iVar2, e.b bVar, boolean z5, d dVar2, d dVar3, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, int i8, float f2, boolean z11) {
        int i242;
        int max;
        i dVar22;
        d.f.a.m.e eVar;
        i iVar62;
        d.f.a.m.e eVar2;
        d.f.a.m.e eVar3;
        i iVar72;
        i iVar3;
        boolean z12;
        int cmp = 0;
        d.f.a.m.e eVar5;
        boolean z14;
        boolean z13;
        d.f.a.m.d dVar103;
        d.f.a.m.e eVar6;
        int i10 = 0;
        int z52 = 1;
        int i16 = 4;
        int z32;
        int i17 = 1;
        int i9;
        final Object dVar32 = this;
        final i dVar23 = dVar;
        iVar62 = iVar;
        int i142 = i3;
        int i152 = i4;
        i242 = i7;
        i242 = i8;
        iVar = dVar23.q(dVar2);
        dVar22 = dVar23.q(dVar3);
        iVar2 = dVar23.q(dVar2.i());
        iVar62 = dVar23.q(dVar3.i());
        if (d.w() != null) {
            e eVar4 = d.w();
            long l2 = 1L;
            eVar4.w += l2;
        }
        z = dVar2.n();
        boolean z16 = dVar3.n();
        boolean z22 = dVar32.R.n();
        boolean r5 = z16 ? z + 1 : z;
        if (z22) {
            z++;
        }
        int r18 = z6 ? 3 : i5;
        int i29 = e.a.b[bVar.ordinal()];
        i16 = 1;
        int r2 = i242;
        int i50 = -1;
        if (dVar32.j == i50 || !z) {
            i242 = i2;
        } else {
            dVar32.j = i50;
            i242 = 0;
        }
        if (dVar32.k != i50 && !z) {
            dVar32.k = i50;
            i242 = 0;
        }
        i242 = 8;
        if (dVar32.j0 == i242) {
            i242 = 0;
            i242 = 0;
        }
        if (z11) {
            if (z || z16 || z22) {
                if (z && !z16) {
                    dVar23.e(iVar, iVar2, dVar2.e(), i242);
                }
            } else {
                dVar23.f(iVar, i);
            }
        }
        if (i242 == 0) {
            if (z5) {
                int i11 = 0;
                dVar23.e(dVar22, iVar, i11, 3);
                i242 = 8;
                if (i142 > 0) {
                    dVar23.h(dVar22, iVar, i142, i242);
                }
                i242 = Integer.MAX_VALUE;
                if (i152 < Integer.MAX_VALUE) {
                    dVar23.j(dVar22, iVar, i152, i242);
                }
            } else {
                i11 = 0;
                dVar23.e(dVar22, iVar, i242, i242);
            }
            z52 = z4;
        } else {
            i = 2;
            i242 = 0;
            if (dVar32.R == 2 || !(z6 && i242 == 1)) {
                int i18 = -2;
                int r6 = i242;
                int r1 = i242;
                if (dVar32.j > 0 && i242 != 1) {
                }
                if (dVar32.j0 > 0) {
                    i242 = 8;
                    dVar23.h(dVar22, iVar, i242, i242);
                    i242 = Math.max(i242, i242);
                }
                if (i242 > 0) {
                    int r3 = z2 != 0 && i242 == 1 ? i242 : 1;
                    if (i242 != 0) {
                        i242 = 8;
                        dVar23.j(dVar22, iVar, i242, i242);
                    } else {
                        i242 = 8;
                    }
                    i242 = Math.min(i242, i242);
                } else {
                    i242 = 8;
                }
                if (i242 == 1) {
                    if (z2 != 0) {
                        dVar23.e(dVar22, iVar, i242, i242);
                        i7 = 5;
                    } else {
                        if (z8) {
                            i7 = 5;
                            dVar23.e(dVar22, iVar, i242, i7);
                            dVar23.j(dVar22, iVar, i242, i242);
                        } else {
                            i7 = 5;
                            dVar23.e(dVar22, iVar, i242, i7);
                            dVar23.j(dVar22, iVar, i242, i242);
                        }
                    }
                    z52 = z4;
                } else {
                    if (i242 == 2) {
                        d.f.a.m.d.b tOP2 = d.b.TOP;
                        if (dVar2.j() != d.b.TOP) {
                            if (dVar2.j() == d.b.BOTTOM) {
                                iVar2 = dVar23.q(dVar32.W.m(d.b.TOP));
                                iVar3 = dVar23.q(dVar32.W.m(d.b.BOTTOM));
                            } else {
                                iVar2 = dVar23.q(dVar32.W.m(d.b.LEFT));
                                iVar3 = dVar23.q(dVar32.W.m(d.b.RIGHT));
                            }
                        }
                        b bVar2 = dVar.r();
                        i3 = 5;
                        bVar2.k(dVar22, iVar, iVar3, iVar2, f2);
                        dVar23.d(bVar2);
                        if (z2 != 0) {
                            i242 = 0;
                        }
                        z52 = z4;
                    } else {
                        z52 = 1;
                    }
                }
            } else {
                if (i242 == 0) {
                    if (d.b.TOP > 0) {
                        max = Math.min(i242, Math.max(i242, i242));
                    }
                    i242 = 8;
                    dVar23.e(dVar22, iVar, max, i242);
                    z52 = z4;
                }
            }
        }
        if (z11 && z8) {
            iVar72 = iVar2;
            cmp = 0;
            i8 = 2;
            iVar62 = iVar;
            if (dVar32.R < dVar32.j0 && z2 != 0 && z52 != 0) {
                cmp = 8;
                dVar23.h(iVar, iVar62, cmp, cmp);
                if (!z) {
                    if (dVar32.O.f == null) {
                        cmp = 1;
                    } else {
                    }
                }
                if (!z) {
                    if (dVar32.O.f == null) {
                    } else {
                        f = 0.0f;
                        if (eVar2.Z != 0.0f) {
                            d.f.a.m.e.b mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
                            if (objArr[cmp] == e.b.MATCH_CONSTRAINT) {
                                cmp = 1;
                                int r14 = cmp;
                            }
                        }
                    }
                }
                if (Integer.MAX_VALUE != 0) {
                    dVar23.h(iVar72, dVar22, cmp, 8);
                }
            }
            return;
        }
        iVar72 = iVar2;
        cmp = 0;
        iVar62 = iVar;
        i8 = 2;
    }

    public int A() {
        return this.I;
    }

    public void A0(int i, int i2, int i3, int i4) {
        int i8 = 0;
        int i5;
        int i7;
        i5 = i3 - i;
        i7 = i4 - i2;
        this.b0 = i;
        this.c0 = i2;
        i8 = 0;
        if (this.j0 == 8) {
            this.X = i8;
            this.Y = i8;
            return;
        }
        fIXED2 = e.b.FIXED;
        if (objArr[i8] == e.b.FIXED && i3 - i < this.X) {
        }
        int i6 = 1;
        if (objArr[i6] == e.b.FIXED && i4 - i2 < this.Y) {
        }
        this.X = i5;
        this.Y = i7;
        if (i7 < this.f0) {
            this.Y = this.f0;
        }
        if (i5 < this.e0) {
            this.X = this.e0;
        }
        if (this.w > 0 && objArr[i8] == e.b.MATCH_CONSTRAINT) {
            this.X = Math.min(this.X, this.w);
        }
        if (this.z > 0 && this.V[i6] == e.b.MATCH_CONSTRAINT) {
            this.Y = Math.min(this.Y, this.z);
        }
        if (i5 != this.X) {
            this.j = this.X;
        }
        if (i7 != this.Y) {
            this.k = this.Y;
        }
    }

    public int B() {
        return this.J;
    }

    public void B0(boolean z) {
        this.F = z;
    }

    public int C(int i) {
        if (i == 0) {
            return R();
        }
        if (i == 1) {
            return v();
        }
        return 0;
    }

    public void C0(int i) {
        this.Y = i;
        if (i < this.f0) {
            this.Y = this.f0;
        }
    }

    public int D() {
        return this.D[1];
    }

    public void D0(float f) {
        this.g0 = f;
    }

    public int E() {
        return this.D[0];
    }

    public void E0(int i) {
        this.m0 = i;
    }

    public int F() {
        return this.f0;
    }

    public void F0(int i, int i2) {
        this.b0 = i;
        i2 -= i;
        this.X = i4;
        if (i4 < this.e0) {
            this.X = this.e0;
        }
    }

    public int G() {
        return this.e0;
    }

    public void G0(e.b bVar) {
        this.V[0] = bVar;
    }

    public e H(int i) {
        if (i == 0) {
            if (dVar3.f != null && dVar.f == this.M) {
                return dVar.d;
            }
        } else {
            if (this.M == 1) {
                if (dVar3.f != null && dVar.f == this.N) {
                    return dVar.d;
                }
            }
        }
        return null;
    }

    public void H0(int i, int i2, int i3, float f) {
        int i5 = 0;
        this.s = i;
        this.v = i2;
        if (i3 == 0x7fffffff /* Unknown resource */) {
            i5 = 0;
        }
        this.w = i5;
        this.x = f;
        if (f > 0) {
            if (f < 1065353216 && i == 0) {
                int i4 = 2;
                this.s = i4;
            }
        }
    }

    public e I() {
        return this.W;
    }

    public void I0(float f) {
        this.o0[0] = f;
    }

    public e J(int i) {
        if (i == 0) {
            if (dVar3.f != null && dVar.f == this.K) {
                return dVar.d;
            }
        } else {
            if (this.K == 1) {
                if (dVar3.f != null && dVar.f == this.L) {
                    return dVar.d;
                }
            }
        }
        return null;
    }

    protected void J0(int i, boolean z) {
        this.U[i] = z;
    }

    public int K() {
        return S() + this.X;
    }

    public void K0(boolean z) {
        this.G = z;
    }

    public p L(int i) {
        if (i == 0) {
            return this.d;
        }
        if (this.d == 1) {
            return this.e;
        }
        return null;
    }

    public void L0(boolean z) {
        this.H = z;
    }

    public float M() {
        return this.h0;
    }

    public void M0(int i, int i2) {
        this.I = i;
        this.J = i2;
        P0(false);
    }

    public int N() {
        return this.n0;
    }

    public void N0(int i) {
        this.D[1] = i;
    }

    public e.b O() {
        return this.V[1];
    }

    public void O0(int i) {
        this.D[0] = i;
    }

    public int P() {
        int i = 0;
        i = 0;
        if (this.K != null) {
            i = 0 + this.L.g;
        }
        if (this.M != null) {
            i = i + this.N.g;
        }
        return i;
    }

    public void P0(boolean z) {
        this.g = z;
    }

    public int Q() {
        return this.j0;
    }

    public void Q0(int i) {
        if (i < 0) {
            int i2 = 0;
            this.f0 = i2;
        } else {
            this.f0 = i;
        }
    }

    public int R() {
        if (this.j0 == 8) {
            return 0;
        }
        return this.X;
    }

    public void R0(int i) {
        if (i < 0) {
            int i2 = 0;
            this.e0 = i2;
        } else {
            this.e0 = i;
        }
    }

    public int S() {
        if (this.W != null) {
            z = eVar instanceof f;
            if (eVar instanceof f) {
                return eVar.C0 + this.b0;
            }
        }
        return this.b0;
    }

    public void S0(int i, int i2) {
        this.b0 = i;
        this.c0 = i2;
    }

    public int T() {
        if (this.W != null) {
            z = eVar instanceof f;
            if (eVar instanceof f) {
                return eVar.D0 + this.c0;
            }
        }
        return this.c0;
    }

    public void T0(e eVar) {
        this.W = eVar;
    }

    public boolean U() {
        return this.F;
    }

    public void U0(float f) {
        this.h0 = f;
    }

    public boolean V(int i) {
        boolean z = true;
        boolean z2 = true;
        int i2;
        final int i3 = 2;
        i2 = 1;
        i2 = 0;
        if (i == 0) {
            i = i2;
            int r3 = i2;
            if (i2 + i2 >= i3) {
            }
            return z2;
        }
        i = i2;
        r3 = i2;
        r3 = i2;
        if ((i2 + i2) + i2 >= i3) {
        }
        return z;
    }

    public void V0(int i) {
        this.n0 = i;
    }

    public boolean W() {
        int i;
        i = 0;
        while (i < this.T.size()) {
            if ((d)this.T.get(i).l()) {
                return true;
            }
        }
        return false;
    }

    public void W0(int i, int i2) {
        this.c0 = i;
        i2 -= i;
        this.Y = i4;
        if (i4 < this.f0) {
            this.Y = this.f0;
        }
    }

    public boolean X() {
        boolean z = false;
        final int i4 = -1;
        if (this.j != i4 || this.k != i4) {
            int i3 = 1;
        }
        return z;
    }

    public void X0(e.b bVar) {
        this.V[1] = bVar;
    }

    public boolean Y(int i, int i2) {
        boolean z = true;
        boolean z2 = true;
        int i4 = 1;
        final int i3 = 0;
        if (i == 0) {
            if (this.K.f != null && this.K.f.m()) {
                if (this.M.f != null && this.M.f.m()) {
                    if ((this.M.f.d() - this.M.e()) - (this.K.f.d() + this.K.e()) < i2) {
                    }
                    return z2;
                }
            }
        } else {
            if (this.L.f != null && this.L.f.m()) {
                if (this.N.f != null && this.N.f.m()) {
                    if ((this.N.f.d() - this.N.e()) - (this.L.f.d() + this.L.e()) < i2) {
                    }
                    return z;
                }
            }
        }
        return false;
    }

    public void Y0(int i, int i2, int i3, float f) {
        int i5 = 0;
        this.t = i;
        this.y = i2;
        if (i3 == 0x7fffffff /* Unknown resource */) {
            i5 = 0;
        }
        this.z = i5;
        this.A = f;
        if (f > 0) {
            if (f < 1065353216 && i == 0) {
                int i4 = 2;
                this.t = i4;
            }
        }
    }

    public void Z(d.b bVar, e eVar, d.b bVar2, int i, int i2) {
        m(bVar).a(eVar.m(bVar2), i, i2, true);
    }

    public void Z0(float f) {
        this.o0[1] = f;
    }

    public void a1(int i) {
        this.j0 = i;
    }

    public boolean b0() {
        return this.n;
    }

    public void b1(int i) {
        this.X = i;
        if (i < this.e0) {
            this.X = this.e0;
        }
    }

    public boolean c0(int i) {
        return this.U[i];
    }

    public void c1(int i) {
        if (i >= 0 && i <= 3) {
            this.r = i;
        }
    }

    public boolean d0() {
        if (dVar.f == null || dVar2.f != this.K) {
            if (dVar.f != null && dVar2.f == this.M) {
                return true;
            }
        }
        return false;
    }

    public void d1(int i) {
        this.b0 = i;
    }

    public void e(f fVar, d dVar, HashSet<e> hashSet, int i, boolean z) {
        boolean hasNext;
        d.f.a.m.e eVar;
        d.f.a.m.f fVar2;
        d dVar22;
        HashSet hashSet32;
        int i42;
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.a(fVar, dVar, this);
            hashSet.remove(this);
            g(dVar, fVar.J1(64));
        }
        if (i == 0) {
            HashSet set4 = this.K.c();
            if (set4 != null) {
                Iterator it4 = set4.iterator();
                while (it4.hasNext()) {
                    z = true;
                    (d)it4.next().d.e(fVar, dVar, hashSet, i, z);
                }
            }
            HashSet set = this.M.c();
            if (set != null) {
                Iterator it5 = set.iterator();
                while (it5.hasNext()) {
                    z = true;
                    (d)it5.next().d.e(fVar, dVar, hashSet, i, z);
                }
            }
        } else {
            HashSet set2 = this.L.c();
            if (set2 != null) {
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    z = true;
                    (d)it.next().d.e(fVar, dVar, hashSet, i, z);
                }
            }
            HashSet set3 = this.N.c();
            if (set3 != null) {
                Iterator it2 = set3.iterator();
                while (it2.hasNext()) {
                    z = true;
                    (d)it2.next().d.e(fVar, dVar, hashSet, i, z);
                }
            }
            set = this.O.c();
            if (set != null) {
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    z = true;
                    (d)it3.next().d.e(fVar, dVar, hashSet, i, z);
                }
            }
        }
    }

    public boolean e0() {
        return this.G;
    }

    public void e1(int i) {
        this.c0 = i;
    }

    boolean f() {
        boolean z2 = false;
        z = this instanceof k;
        if (!(this instanceof k)) {
            z = this instanceof g;
            if (this instanceof g) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z2;
    }

    public boolean f0() {
        if (dVar.f == null || dVar2.f != this.L) {
            if (dVar.f != null && dVar2.f == this.N) {
                return true;
            }
        }
        return false;
    }

    public void f1(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        int i5;
        float f = 1f;
        final int i6 = 0;
        final int i7 = -1;
        final int i8 = 1;
        if (this.B == i7) {
            if (!z3 || z4) {
                if (!z3 && z4 && this.a0 == i7) {
                    this.C = f / this.C;
                }
            } else {
                this.B = i6;
            }
        }
        if (this.B == 0) {
            if (this.L.n()) {
                if (!this.N.n()) {
                    this.B = i8;
                } else {
                    if (this.B == i8) {
                        if (this.K.n()) {
                            if (!this.M.n()) {
                                this.B = i6;
                            }
                        }
                    }
                }
            }
        }
        if (this.B == i7) {
            if (this.L.n()) {
                if (this.N.n()) {
                    if (this.K.n()) {
                        if (!this.M.n()) {
                            if (this.L.n()) {
                                if (this.N.n()) {
                                    this.B = i6;
                                } else {
                                    if (this.K.n() && this.M.n()) {
                                        this.C = f / this.C;
                                        this.B = i8;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (this.B == i7 && this.v > 0 && this.y == 0) {
            this.B = i6;
        }
    }

    public void g(d dVar, boolean z) {
        boolean z3;
        d.f.a.m.e eVar2;
        boolean z4 = true;
        int i3 = 0;
        int i4;
        d.f.a.m.e eVar3;
        d.f.a.m.e eVar6;
        n nVar;
        int i6;
        int i7;
        i iVar4;
        d.f.a.m.e.b bVar2;
        int i5;
        d.f.a.m.e.b bVar;
        d.f.a.m.e eVar;
        int i8;
        int i9 = 3;
        boolean z7;
        int i2;
        boolean z32 = false;
        f fVar = null;
        i iVar6;
        int i11 = 1;
        int i13 = 5;
        boolean z8;
        int i14 = -1;
        boolean z9 = true;
        int i17 = 8;
        int i15 = 0;
        boolean z36 = false;
        d.f.a.m.e.b[] objArr;
        int i20 = 2;
        int i21;
        int i19;
        d.f.a.m.e.b wRAP_CONTENT22;
        boolean z10;
        i iVar3;
        i iVar2;
        i iVar5;
        int i23 = 2;
        int i24 = 2;
        boolean z11 = false;
        int dVar5;
        int i25;
        i iVar8;
        i iVar7;
        d dVar2;
        int i22;
        float f2;
        long l = 1;
        boolean z12;
        int i30 = 0;
        int i31 = 1;
        boolean z13;
        int cmp;
        float f;
        boolean z44;
        int i33 = 0;
        int i28;
        d.f.a.m.e.b mATCH_CONSTRAINT2;
        d.f.a.m.e.b wRAP_CONTENT2;
        obj = this;
        dVar8 = dVar;
        iVar7 = dVar8.q(obj.K);
        iVar6 = dVar8.q(obj.M);
        iVar8 = dVar8.q(obj.L);
        iVar6 = dVar8.q(obj.N);
        iVar6 = dVar8.q(obj.O);
        i23 = 2;
        i9 = 3;
        i8 = 1;
        i8 = 0;
        if (obj.W != null) {
            if (obj.W != null) {
                int r2 = i8;
            }
            if (obj.W != null) {
                int r0 = i8;
            }
            if (obj.r == i8) {
            } else {
                if (obj.r == 2) {
                } else {
                    if (obj.r != 3) {
                    } else {
                    }
                }
            }
        }
        int i69 = 8;
        if (obj.j0 == i69 && !this.W()) {
            if (!zArr7[i8]) {
                if (!zArr7[i8]) {
                    return;
                }
            }
        }
        i13 = 5;
        if (obj.l || obj.m) {
            if (obj.l && z10 && obj.W != null) {
                if (obj.i) {
                    eVar8.q1(obj.K);
                    eVar8.p1(obj.M);
                } else {
                    dVar8.h(dVar8.q(eVar8.M), iVar6, i8, i13);
                }
            }
            if (obj.m) {
                dVar8.f(iVar8, obj.c0);
                dVar8.f(iVar6, obj.c0 + obj.Y);
                if (obj.O.l()) {
                    dVar8.f(iVar6, obj.c0 + obj.d0);
                }
                if (z10 && obj.W != null) {
                    if (obj.i) {
                        eVar9.v1(obj.L);
                        eVar9.u1(obj.N);
                    } else {
                        dVar8.h(dVar8.q(eVar9.N), iVar6, i8, i13);
                    }
                }
            }
            if (obj.l && obj.m) {
                obj.l = false;
                obj.m = false;
                return;
            }
        }
        e eVar10 = d.x;
        l = 1L;
        if (d.x != null) {
            eVar10.y += l;
        }
        if (z && obj.d != null && obj.e != null && fVar14.j && lVar4.i.j && nVar7.h.j && nVar7.i.j && obj.M != null) {
            eVar10.r += l;
            dVar8.f(iVar7, fVar14.g);
            dVar8.f(iVar6, obj.d.i.g);
            dVar8.f(iVar8, obj.e.h.g);
            dVar8.f(iVar6, obj.e.i.g);
            dVar8.f(iVar6, obj.e.k.g);
            if (obj.W != null && z10) {
                if (obj.f[i8] && !this.d0()) {
                    dVar8.h(dVar8.q(obj.W.M), iVar6, i8, i69);
                }
                if (z10) {
                    if (obj.f[1] && !this.f0()) {
                        dVar8.h(dVar8.q(obj.W.N), iVar6, i8, i69);
                    }
                }
            }
            obj.l = false;
            obj.m = false;
            return;
        }
        if (obj.M != null) {
            eVar10.s += l;
        }
        if (obj.W != null) {
            if (obj.a0(i8)) {
                (f)obj.W.m1(obj, i8);
                int i47 = 1;
            } else {
                z4 = d0();
            }
            int i56 = 1;
            if (obj.a0(i56)) {
                (f)obj.W.m1(obj, i56);
                int i57 = 1;
            } else {
                z4 = f0();
            }
            if (!obj.M && z10 && obj.j0 != i69 && obj.K.f == null && obj.M.f == null) {
                i8 = 1;
                dVar8.h(dVar8.q(obj.W.M), iVar6, i8, i8);
            }
            if (!nVar7.i.j && z10 && obj.j0 != i69 && obj.L.f == null && obj.N.f == null && obj.O == null) {
                i8 = 1;
                dVar8.h(dVar8.q(obj.W.N), iVar6, i8, i8);
            }
        } else {
        }
        if (obj.X >= obj.e0) {
        }
        if (obj.Y >= obj.f0) {
        }
        mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
        int r3 = objArr[i8] != e.b.MATCH_CONSTRAINT ? 1 : 0;
        i31 = 1;
        int r1 = objArr[1] != e.b.MATCH_CONSTRAINT ? 1 : 0;
        obj.B = obj.a0;
        obj.C = obj.Z;
        i3 = 4;
        if (obj.Z <= 0) {
        } else {
            if (obj.j0 != 8) {
                if (objArr[0] == e.b.MATCH_CONSTRAINT && obj.s == 0) {
                    i3 = 3;
                }
                int i79 = 1;
                if (objArr[i79] == e.b.MATCH_CONSTRAINT && obj.t == 0) {
                    i3 = 3;
                }
                i25 = 0;
                if (objArr[i25] == e.b.MATCH_CONSTRAINT) {
                    if (objArr[i79] != e.b.MATCH_CONSTRAINT) {
                        dVar5 = 3;
                    } else {
                        dVar5 = 3;
                        if (obj.s != dVar5 || obj.t != dVar5) {
                            int i58 = 0;
                            if (objArr[i58] != e.b.MATCH_CONSTRAINT || obj.s != obj.j0) {
                                i3 = 1;
                                if (objArr[i3] == e.b.MATCH_CONSTRAINT && obj.t == 3) {
                                    obj.B = i3;
                                    int i10 = -1;
                                    if (obj.a0 == -1) {
                                        obj.C = 1f / f3;
                                    }
                                    i3 = (int)(obj.C * (float)i2);
                                    i3 = 0;
                                    if (objArr[i3] != e.b.MATCH_CONSTRAINT) {
                                    } else {
                                    }
                                }
                            } else {
                                obj.B = i58;
                                f3 = f3 * (float)i3;
                                i2 = (int)f3;
                                i3 = 1;
                                if (objArr[i3] != e.b.MATCH_CONSTRAINT) {
                                    i3 = 0;
                                    i3 = 0;
                                } else {
                                    i3 = 0;
                                }
                            }
                        } else {
                            obj.f1(z10, z10, z36, z32);
                            i3 = 0;
                            i3 = 1;
                        }
                    }
                }
            } else {
                i3 = 0;
            }
        }
        obj.u[i3] = i3;
        i4 = 1;
        obj.u[i4] = i3;
        if (i3 != 0) {
            i14 = -1;
            int r20 = 1;
        } else {
            i14 = -1;
            i30 = 0;
        }
        if (i3 != 0) {
            int r38 = 1;
        } else {
            i33 = 0;
        }
        wRAP_CONTENT2 = e.b.WRAP_CONTENT;
        if (obj.V[0] == e.b.WRAP_CONTENT) {
            int r9 = obj instanceof f ? 1 : 0;
        }
        int r13 = obj.Z ? 0 : i2;
        i11 = 1;
        final int i32 = !obj.R.n();
        i15 = 0;
        i22 = 0;
        i24 = 2;
        if (obj.p == 2 || !(obj.l && !z)) {
        } else {
            if (obj.d != null) {
                if (fVar.j) {
                    if (!lVar2.i.j) {
                        dVar2 = dVar;
                        if (obj.W != null) {
                        } else {
                        }
                        if (obj.W != null) {
                        } else {
                        }
                        i28 = 0;
                        i28 = 1;
                        int r45 = i28;
                        z9 = true;
                        this.i(dVar, true, z10, z10, obj.f[i28], i22, iVar2, objArr3[i28], z11, obj.K, obj.M, obj.b0, i2, obj.e0, obj.D[i28], obj.g0, i30, i28, z4, z4, zArr3[0], i3, i3, obj.v, obj.w, obj.x, i32);
                    } else {
                        if (z) {
                            dVar2 = dVar;
                            dVar2.f(iVar7, fVar.g);
                            dVar2.f(iVar6, obj.d.i.g);
                            if (obj.W != null && z10 && obj.f[i61] && !this.d0()) {
                                dVar2.h(dVar2.q(obj.W.M), iVar6, i61, 8);
                            }
                        } else {
                            dVar5 = dVar;
                        }
                    }
                }
            }
        }
        if (!z) {
            i17 = 8;
            i3 = 0;
            i3 = 1;
            eVar3 = this;
            dVar2 = dVar;
        } else {
            eVar3 = this;
            if (eVar3.e != null) {
                if (fVar.j) {
                    if (nVar.i.j) {
                        dVar2 = dVar;
                        dVar2.f(iVar8, fVar.g);
                        dVar2.f(iVar6, eVar3.e.i.g);
                        dVar2.f(iVar6, eVar3.e.k.g);
                        if (eVar3.W == null || z4 || !z10) {
                            i17 = 8;
                            i3 = 0;
                            i3 = 1;
                        } else {
                            i3 = 1;
                            if (eVar3.f[i3]) {
                                i17 = 8;
                                i3 = 0;
                                dVar2.h(dVar2.q(eVar6.N), iVar6, i3, i17);
                            } else {
                                i17 = 8;
                                i3 = 0;
                            }
                        }
                    } else {
                        dVar2 = dVar;
                        i17 = 8;
                        i3 = 0;
                        i3 = 1;
                    }
                }
            }
        }
        i20 = 2;
        int r6 = i3;
        if (e.b.MATCH_CONSTRAINT == 0 || eVar3.m) {
        } else {
            if (eVar3.V[i3] == wRAP_CONTENT2) {
                r9 = i3;
            }
            if (obj.Z) {
            }
            if (eVar3.W != null) {
            } else {
            }
            if (eVar3.W != null) {
            } else {
            }
            if (eVar3.d0 > 0 || eVar3.j0 == obj.e0) {
                if (dVar28.f != null) {
                    dVar2.e(iVar6, iVar8, n(), i17);
                    dVar2.e(iVar6, dVar2.q(eVar3.O.f), eVar3.O.e(), i17);
                    if (z10) {
                        dVar2.h(iVar5, dVar2.q(eVar3.N), i3, 5);
                    }
                } else {
                    if (eVar3.j0 == obj.e0) {
                        dVar2.e(iVar6, iVar8, eVar3.O.e(), i17);
                    } else {
                        dVar2.e(iVar6, iVar8, n(), i17);
                    }
                }
            }
            int i29 = 0;
            int r18 = objArr5[i29] == mATCH_CONSTRAINT2 ? 1 : i29;
            this.i(dVar, false, z10, z10, eVar3.f[i3], iVar3, iVar5, objArr5[i3], z11, eVar3.L, eVar3.N, eVar3.c0, i3, eVar3.f0, eVar3.D[i3], eVar3.h0, i33, (objArr5[i29] == mATCH_CONSTRAINT2 ? 1 : i29), z4, z4, zArr3[1], i3, i3, eVar3.y, eVar3.z, eVar3.A, z44);
        }
        if (i3 == 0) {
            eVar3 = this;
        } else {
            i3 = 8;
            eVar3 = this;
            if (eVar3.B == 1) {
                dVar.k(iVar6, iVar8, iVar6, iVar7, eVar3.C, 8);
            } else {
                i3 = 8;
                dVar.k(iVar6, iVar7, iVar6, iVar8, eVar3.C, i3);
            }
        }
        if (eVar3.R.n()) {
            float f12 = 90f;
            dVar.b(eVar3, eVar3.R.i().g(), (float)(Math.toRadians((double)(eVar3.E + f12))), eVar3.R.e());
        }
        boolean z24 = false;
        eVar3.l = z24;
        eVar3.m = z24;
    }

    public boolean g0() {
        return this.H;
    }

    public void g1(boolean z, boolean z2) {
        int i;
        int z3;
        int z4;
        int i3 = -2147483648;
        int i4 = 2147483647;
        int i5;
        i5 = z & this.d.k();
        i6 = z2 & this.e.k();
        i3 = i - i;
        i4 = i - i;
        i = 0;
        if (i - i < 0 || i - i >= 0 || lVar2.h.g != Integer.MIN_VALUE || lVar2.h.g != Integer.MAX_VALUE || nVar2.h.g != Integer.MIN_VALUE || nVar2.h.g != Integer.MAX_VALUE || lVar2.i.g != Integer.MIN_VALUE || lVar2.i.g != Integer.MAX_VALUE || nVar2.i.g != Integer.MIN_VALUE || nVar2.i.g == Integer.MAX_VALUE) {
        }
        z3 = i - i;
        z4 = i - i;
        if (i5 != 0) {
            this.b0 = i;
        }
        if (i6 != 0) {
            this.c0 = i;
        }
        if (this.j0 == 8) {
            this.X = i;
            this.Y = i;
            return;
        }
        if (i5 != 0) {
            if (this.V[i] == e.b.FIXED && i - i < this.X) {
            }
            this.X = z3;
            if (this.d < this.e0) {
                this.X = this.e0;
            }
        }
        if (i6 != 0) {
            if (this.V[1] == e.b.FIXED && i - i < this.Y) {
            }
            this.Y = z4;
            if (nVar2.i < this.f0) {
                this.Y = this.f0;
            }
        }
    }

    public boolean h() {
        boolean z = true;
        int r0 = this.j0 != 8 ? 1 : 0;
        return (this.j0 != 8 ? 1 : 0);
    }

    public boolean h0() {
        boolean z2 = false;
        int i = 8;
        if (this.g) {
            i = 8;
            int r0 = this.j0 != 8 ? 1 : 0;
        }
        return (this.j0 != 8 ? 1 : 0);
    }

    public void h1(d dVar, boolean z) {
        int dVar2;
        d.f.a.m.d dVar3;
        int i = 2147483647;
        f fVar;
        int i2 = -2147483648;
        dVar2 = dVar.x(this.K);
        dVar2 = dVar.x(this.L);
        dVar2 = dVar.x(this.M);
        dVar2 = dVar.x(this.N);
        if (z && this.d != null && fVar.j && fVar2.j) {
        }
        if (this.e && this.e != null) {
            if (fVar3.j) {
                if (fVar4.j) {
                }
            }
        }
        i2 = dVar2 - dVar2;
        i = dVar2 - dVar2;
        if (dVar2 - dVar2 < 0 || dVar2 - dVar2 >= 0 || this.K != Integer.MIN_VALUE || this.K != Integer.MAX_VALUE || fVar3.g != Integer.MIN_VALUE || fVar3.g != Integer.MAX_VALUE || fVar2.g != Integer.MIN_VALUE || fVar2.g != Integer.MAX_VALUE || fVar4.g != Integer.MIN_VALUE || fVar4.g == Integer.MAX_VALUE) {
        }
        A0(dVar2, dVar2, dVar2, dVar2);
    }

    public boolean i0() {
        boolean z2 = false;
        if (!this.l) {
            if (this.K.m()) {
                if (this.M.m()) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
        }
        return z2;
    }

    public void j(e eVar, float f, int i) {
        final d.f.a.m.d.b cENTER2 = d.b.CENTER;
        this.Z(cENTER2, eVar, cENTER2, i, 0);
        this.E = f;
    }

    public boolean j0() {
        boolean z2 = false;
        if (!this.m) {
            if (this.L.m()) {
                if (this.N.m()) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
        }
        return z2;
    }

    public void k(d dVar) {
        dVar.q(this.K);
        dVar.q(this.L);
        dVar.q(this.M);
        dVar.q(this.N);
        if (this.d0 > 0) {
            dVar.q(this.O);
        }
    }

    public boolean k0() {
        return this.o;
    }

    public void l() {
        if (this.d == null) {
            this.d = new l(this);
        }
        if (this.e == null) {
            this.e = new n(this);
        }
    }

    public void l0() {
        this.n = true;
    }

    public d m(d.b bVar) {
        switch (e.a.a[bVar.ordinal()]) {
            case 1: /* ordinal */
                return this.K;
            case 2: /* ordinal */
                return this.L;
            case 3: /* ordinal */
                return this.M;
            case 4: /* ordinal */
                return this.N;
            case 5: /* ordinal */
                return this.O;
            case 6: /* ordinal */
                return this.R;
            case 7: /* ordinal */
                return this.P;
            case 8: /* ordinal */
                return this.Q;
            case 9: /* ordinal */
                return null;
            default:
                throw new AssertionError(this.P.name());
        }
    }

    public void m0() {
        this.o = true;
    }

    public int n() {
        return this.d0;
    }

    public boolean n0() {
        boolean z = false;
        final d.f.a.m.e.b mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
        final int i = 1;
        if (objArr[0] == e.b.MATCH_CONSTRAINT) {
            if (objArr[i] == e.b.MATCH_CONSTRAINT) {
            }
        }
        return z;
    }

    public float o(int i) {
        if (i == 0) {
            return this.g0;
        }
        if (this.g0 == 1) {
            return this.h0;
        }
        return -1082130432;
    }

    public void o0() {
        this.K.p();
        this.L.p();
        this.M.p();
        this.N.p();
        this.O.p();
        this.P.p();
        this.Q.p();
        this.R.p();
        d.f.a.m.e eVar = null;
        this.W = eVar;
        float f2 = 0.0f;
        this.E = f2;
        final int i2 = 0;
        this.X = i2;
        this.Y = i2;
        this.Z = f2;
        int i = -1;
        this.a0 = i;
        this.b0 = i2;
        this.c0 = i2;
        this.d0 = i2;
        this.e0 = i2;
        this.f0 = i2;
        float f3 = e.t0;
        this.g0 = f3;
        this.h0 = f3;
        final d.f.a.m.e.b fIXED2 = e.b.FIXED;
        this.V[i2] = fIXED2;
        final int i4 = 1;
        this.V[i4] = fIXED2;
        this.i0 = eVar;
        this.j0 = i2;
        this.l0 = eVar;
        this.m0 = i2;
        this.n0 = i2;
        float f4 = -1f;
        this.o0[i2] = f4;
        this.o0[i4] = f4;
        this.p = i;
        this.q = i;
        int i3 = Integer.MAX_VALUE;
        this.D[i2] = i3;
        this.D[i4] = i3;
        this.s = i2;
        this.t = i2;
        float f = 1f;
        this.x = f;
        this.A = f;
        this.w = i3;
        this.z = i3;
        this.v = i2;
        this.y = i2;
        this.B = i;
        this.C = f;
        this.f[i2] = i4;
        this.f[i4] = i4;
        this.H = false;
        this.U[i2] = i2;
        this.U[i4] = i2;
        this.g = true;
        this.u[i2] = i2;
        this.u[i4] = i2;
        this.j = i;
        this.k = i;
    }

    public int p() {
        return T() + this.Y;
    }

    public void p0() {
        int i = 0;
        boolean z = false;
        this.l = z;
        this.m = z;
        this.n = z;
        this.o = z;
        while (i < this.T.size()) {
            (d)this.T.get(i).q();
            i = i + 1;
        }
    }

    public Object q() {
        return this.i0;
    }

    public void q0(d.f.a.c cVar) {
        this.K.r(cVar);
        this.L.r(cVar);
        this.M.r(cVar);
        this.N.r(cVar);
        this.O.r(cVar);
        this.R.r(cVar);
        this.P.r(cVar);
        this.Q.r(cVar);
    }

    public String r() {
        return this.k0;
    }

    public void r0(int i) {
        int i2 = 1;
        this.d0 = i;
        i = i > 0 ? 1 : 0;
        this.F = (i > 0 ? 1 : 0);
    }

    public e.b s(int i) {
        if (i == 0) {
            return y();
        }
        if (i == 1) {
            return O();
        }
        return null;
    }

    public void s0(Object object) {
        this.i0 = object;
    }

    public float t() {
        return this.Z;
    }

    public void t0(String str) {
        this.k0 = str;
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        final String str11 = " ";
        str = "";
        if (this.l0 != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            String str14 = "type: ";
            str = str14 + this.l0 + str11;
        } else {
        }
        stringBuilder.append(str);
        if (this.k0 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str12 = "id: ";
            str = str12 + this.k0 + str11;
        }
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(this.b0);
        stringBuilder.append(", ");
        stringBuilder.append(this.c0);
        stringBuilder.append(") - (");
        stringBuilder.append(this.X);
        stringBuilder.append(" x ");
        stringBuilder.append(this.Y);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public int u() {
        return this.a0;
    }

    public void u0(String str) {
        int i = -1;
        float parsed;
        parsed = 0.0f;
        this.Z = 0.0f;
    }

    public int v() {
        if (this.j0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public void v0(int i) {
        if (!this.F) {
            return;
        }
        int i3 = i - this.d0;
        this.c0 = i3;
        this.L.s(i3);
        this.N.s(this.Y + i3);
        this.O.s(i);
        this.m = true;
    }

    public float w() {
        return this.g0;
    }

    public void w0(int i, int i2) {
        if (this.l) {
            return;
        }
        this.K.s(i);
        this.M.s(i2);
        this.b0 = i;
        this.X = i2 - i;
        this.l = true;
    }

    public int x() {
        return this.m0;
    }

    public void x0(int i) {
        this.K.s(i);
        this.b0 = i;
    }

    public e.b y() {
        return this.V[0];
    }

    public void y0(int i) {
        this.L.s(i);
        this.c0 = i;
    }

    public int z() {
        int i = 0;
        i = 0;
        if (this.K != null) {
            i = 0 + dVar.g;
        }
        if (this.M != null) {
            i = i + dVar2.g;
        }
        return i;
    }

    public void z0(int i, int i2) {
        if (this.m) {
            return;
        }
        this.L.s(i);
        this.N.s(i2);
        this.c0 = i;
        this.Y = i2 - i;
        if (this.F) {
            i3 = i + this.d0;
            this.O.s(i3);
        }
        this.m = true;
    }

}
