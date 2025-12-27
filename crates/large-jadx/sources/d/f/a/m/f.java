package d.f.a.m;

import d.f.a.d;
import d.f.a.m.m.b;
import d.f.a.m.m.b.a;
import d.f.a.m.m.b.b;
import d.f.a.m.m.h;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ConstraintWidgetContainer.java */
/* loaded from: classes.dex */
public class f extends l {

    public d.f.a.e A0;
    protected d B0 = new d();
    int C0;
    int D0;
    public int E0 = 0;
    public int F0 = 0;
    c[] G0;
    c[] H0;
    private int I0 = 257;
    private boolean J0 = false;
    private boolean K0 = false;
    private WeakReference<d> L0 = null;
    private WeakReference<d> M0 = null;
    private WeakReference<d> N0 = null;
    private WeakReference<d> O0 = null;
    HashSet<e> P0 = new HashSet<>();
    public b.a Q0 = new b$a();
    b v0 = new b();
    public d.f.a.m.m.e w0 = new e();
    private int x0;
    protected b.b y0 = null;
    private boolean z0 = false;
    public f() {
        super();
        b bVar = new b(this);
        d.f.a.m.m.e eVar = new e(this);
        d dVar = new d();
        int i3 = 4;
        this.G0 = new c[i3];
        this.H0 = new c[i3];
        HashSet hashSet = new HashSet();
        b.a aVar = new b.a();
    }

    public static boolean I1(int i, e eVar, b.b bVar, b.a aVar, int i2) {
        boolean i3;
        int i4;
        float f2;
        int i6;
        int i7;
        i3 = false;
        if (bVar == null) {
            return false;
        }
        if (eVar.Q() != 8) {
            if (!(eVar instanceof g)) {
                if (!(eVar instanceof a)) {
                    aVar.a = eVar.y();
                    aVar.b = eVar.O();
                    aVar.c = eVar.R();
                    aVar.d = eVar.v();
                    aVar.i = i3;
                    aVar.j = i2;
                    d.f.a.m.e.b mATCH_CONSTRAINT2 = e.b.MATCH_CONSTRAINT;
                    i4 = 1;
                    i2 = aVar.a == e.b.MATCH_CONSTRAINT ? i4 : i3;
                    int r0 = aVar.b == e.b.MATCH_CONSTRAINT ? i4 : i3;
                    float f = 0.0f;
                    if (aVar.a) {
                        int r3 = eVar.Z > 0.0f ? i4 : i3;
                    }
                    if (e.b.MATCH_CONSTRAINT) {
                        int r2 = eVar.Z > 0.0f ? i4 : i3;
                    }
                    if (aVar.a && eVar.V(i3) && eVar.s == 0 && !eVar.Z) {
                        aVar.a = e.b.WRAP_CONTENT;
                        if (e.b.MATCH_CONSTRAINT && eVar.t == 0) {
                            aVar.a = e.b.FIXED;
                        }
                    }
                    if (e.b.MATCH_CONSTRAINT && eVar.V(i4) && eVar.t == 0 && 0.0f == 0) {
                        aVar.b = e.b.WRAP_CONTENT;
                        if (e.b.WRAP_CONTENT && eVar.s == 0) {
                            aVar.b = e.b.FIXED;
                        }
                    }
                    if (eVar.i0()) {
                        aVar.a = e.b.FIXED;
                    }
                    if (eVar.j0()) {
                        aVar.b = e.b.FIXED;
                    }
                    int i13 = 4;
                    if (eVar.Z) {
                        if (eVar.u[i3] == i13) {
                            aVar.a = e.b.FIXED;
                        } else {
                            if (!e.b.WRAP_CONTENT) {
                                d.f.a.m.e.b fIXED2 = e.b.FIXED;
                                if (aVar.b == e.b.FIXED) {
                                } else {
                                    aVar.a = e.b.WRAP_CONTENT;
                                    bVar.b(eVar, aVar);
                                }
                                aVar.a = e.b.FIXED;
                                aVar.c = (int)(eVar.t() * (float)i7);
                            }
                        }
                    }
                    if (0.0f != 0) {
                        if (eVar.u[i4] == i13) {
                            aVar.b = e.b.FIXED;
                        } else {
                            if (!eVar.t) {
                                d.f.a.m.e.b fIXED26 = e.b.FIXED;
                                if (aVar.a == e.b.FIXED) {
                                } else {
                                    aVar.b = e.b.WRAP_CONTENT;
                                    bVar.b(eVar, aVar);
                                }
                                aVar.b = e.b.FIXED;
                                if (eVar.u() == -1) {
                                    aVar.d = (int)(float)i6 / eVar.t();
                                } else {
                                    aVar.d = (int)(eVar.t() * (float)i6);
                                }
                            }
                        }
                    }
                }
                bVar.b(eVar, aVar);
                eVar.b1(aVar.e);
                eVar.C0(aVar.f);
                eVar.B0(aVar.h);
                eVar.r0(aVar.g);
                aVar.j = b.a.k;
                return aVar.i;
            }
        }
        aVar.e = i3;
        aVar.f = i3;
        return false;
    }

    private void K1() {
        final int i = 0;
        this.E0 = i;
        this.F0 = i;
    }

    private void o1(e eVar) {
        i = this.E0 + 1;
        if (this.E0 + 1 >= h022.length) {
            this.H0 = (c[])Arrays.copyOf(this.H0, h022.length * 2);
        }
        this.H0[this.E0] = new c(eVar, 0, F1());
        this.E0++;
    }

    private void r1(d dVar, d.f.a.i iVar) {
        this.B0.h(iVar, this.B0.q(dVar), 0, 5);
    }

    private void s1(d dVar, d.f.a.i iVar) {
        this.B0.h(this.B0.q(dVar), iVar, 0, 5);
    }

    private void t1(e eVar) {
        final int i3 = 1;
        i = this.F0 + i3;
        if (this.F0 + i3 >= g022.length) {
            this.G0 = (c[])Arrays.copyOf(this.G0, g022.length * 2);
        }
        this.G0[this.F0] = new c(eVar, i3, F1());
        this.F0 += i3;
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
        final Object i12 = this;
        final int i82 = i8;
        i12.C0 = i82;
        final int i92 = i9;
        i12.D0 = i92;
        return i12.v0.d(this, i, i82, i92, i2, i3, i4, i5, i6, i7);
    }

    @Override // d.f.a.m.l
    public boolean J1(int i) {
        boolean z = true;
        i = (this.I0 & i) == i ? 1 : 0;
        return ((this.I0 & i) == i ? 1 : 0);
    }

    @Override // d.f.a.m.l
    public void L1(b.b bVar) {
        this.y0 = bVar;
        this.w0.n(bVar);
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
    public boolean P1(d dVar, boolean[] zArr) {
        int i = 0;
        boolean z;
        z = false;
        zArr[2] = z;
        boolean z3 = J1(64);
        h1(dVar, z3);
        while (i < this.u0.size()) {
            Object item = this.u0.get(i);
            item.h1(dVar, z3);
            i = i + 1;
        }
        return z;
    }

    @Override // d.f.a.m.l
    public void Q1() {
        this.v0.e(this);
    }

    @Override // d.f.a.m.l
    public void g1(boolean z, boolean z2) {
        int i = 0;
        super.g1(z, z2);
        i = 0;
        while (i < this.u0.size()) {
            (e)this.u0.get(i).g1(z, z2);
            i = i + 1;
        }
    }

    @Override // d.f.a.m.l
    public void j1() {
        int max2;
        WeakReference weakReference4;
        int max4;
        int i = 8;
        int i2 = 0;
        int max;
        WeakReference item = null;
        int max6;
        int i4 = 0;
        d.f.a.m.e.b wRAP_CONTENT2;
        int max7 = 2;
        long l;
        boolean z;
        long l2 = 1;
        d.f.a.m.e.b mATCH_CONSTRAINT2;
        int max8 = 0;
        boolean z3;
        int i5;
        final Object obj9 = this;
        max2 = 0;
        obj9.b0 = max2;
        obj9.c0 = max2;
        obj9.J0 = false;
        obj9.K0 = false;
        final int size = obj9.u0.size();
        max = Math.max(max2, R());
        max6 = Math.max(max2, v());
        max2 = 1;
        final d.f.a.m.e.b bVar6 = objArr10[max2];
        d.f.a.m.e.b bVar5 = objArr10[max2];
        if (obj9.A0 != null) {
            l2 = 1L;
            a02.z += l2;
        }
        if (obj9.x0 == 0) {
            if (j.b(obj9.I0, max2)) {
                h.h(obj9, z1());
                while (obj9.A0 < size) {
                    Object item5 = obj9.u0.get(max2);
                    max2 = max2 + 1;
                }
            }
        }
        max7 = 2;
        if (size <= 2 || obj9.V != e.b.WRAP_CONTENT) {
        } else {
            if (bVar6 == e.b.WRAP_CONTENT) {
                if (j.b(obj9.I0, 1024)) {
                    if (i.c(obj9, z1())) {
                        if (obj9.V == e.b.WRAP_CONTENT) {
                            if (max >= R() || max <= 0) {
                                max = R();
                            } else {
                                obj9.b1(max);
                                obj9.J0 = true;
                            }
                        }
                        if (bVar6 == e.b.WRAP_CONTENT) {
                            if (max6 >= v() || max6 <= 0) {
                                max6 = v();
                            } else {
                                obj9.C0(max6);
                                obj9.K0 = true;
                            }
                        }
                    }
                }
            }
        }
        int i24 = 64;
        if (!obj9.J1(i24)) {
            if (obj9.J1(128)) {
            } else {
            }
        }
        obj9.B0.h = false;
        obj9.B0.i = false;
        if (obj9.I0 != 0 && max2 != 0) {
            obj9.B0.i = true;
        }
        d.f.a.m.e.b wRAP_CONTENT23 = e.b.WRAP_CONTENT;
        if (y() == e.b.WRAP_CONTENT || this.O() == e.b.WRAP_CONTENT) {
        }
        K1();
        while (obj9.I0 < size) {
            Object item2 = obj9.u0.get(max2);
            z3 = item2 instanceof l;
            max2 = max2 + 1;
        }
        boolean z7 = obj9.J1(i24);
        while (obj9.u0 != 0) {
            max2 = max2 + 1;
            try {
                obj9.B0.D();
                K1();
                obj9.k(obj9.B0);
                while (obj9.u0 < size) {
                    (e)obj9.u0.get(max2).k(obj9.B0);
                    max2 = max2 + 1;
                    max2 = 0;
                    max2 = 1;
                }
                boolean z8 = obj9.n1(obj9.B0);
                item = null;
                obj9.B0.z();
            } catch (Exception e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder();
                String str = "EXCEPTION : ";
                e = str + e;
                System.out.println(e);
            }
            int max5 = 8;
            int max3 = Math.max(obj9.e0, R());
            max4 = Math.max(obj9.f0, v());
            int r14 = max2 > obj9.u0 ? 0 : max2;
            max2 = 0;
            max2 = 1;
            max7 = 2;
        }
        obj9.u0 = obj9.u0;
        if (obj9.I0 != 0) {
            obj9.V[0] = bVar5;
            max2 = 1;
            obj9.V[max2] = bVar6;
        }
        obj9.q0(obj9.B0.v());
    }

    @Override // d.f.a.m.l
    void m1(e eVar, int i) {
        if (i == 0) {
            o1(eVar);
        } else {
            i = 1;
            if (i == 1) {
                t1(eVar);
            }
        }
    }

    @Override // d.f.a.m.l
    public boolean n1(d dVar) {
        int size;
        boolean hasNext2;
        Object obj;
        d.f.a.m.e.b bVar;
        boolean z;
        d.f.a.m.e.b bVar2;
        d.f.a.m.e.b wRAP_CONTENT22;
        d.f.a.m.e.b fIXED2;
        boolean z3 = J1(64);
        g(dVar, z3);
        int size2 = this.u0.size();
        size = 0;
        size = 1;
        while (size < this.u0) {
            Object item7 = this.u0.get(size);
            item7.J0(size, false);
            item7.J0(size, false);
            hasNext2 = item7 instanceof a;
            size = size + 1;
            size = 1;
        }
        if (size != 0) {
            while (size < this.u0) {
                Object item3 = this.u0.get(size);
                hasNext2 = item3 instanceof a;
                size = size + 1;
            }
        }
        this.P0.clear();
        while (this.P0 < this.u0) {
            Object item6 = this.u0.get(size);
            size = size + 1;
        }
        while (this.P0.size() > 0) {
            Iterator it2 = this.P0.iterator();
            while (it2.hasNext()) {
                Object item2 = it2.next();
                if (item2.l1(this.P0)) {
                    break loop_20;
                }
            }
            item2 = it2.next();
        }
        if (d.r) {
            HashSet hashSet = new HashSet();
            while (this.u0 < this.u0) {
                Object item = this.u0.get(size);
                size = size + 1;
            }
            int r10 = size;
            boolean z2 = false;
            this.e(this, dVar, hashSet, size, false);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                hashSet = it.next();
                j.a(this, dVar, hashSet);
                hashSet.g(dVar, z3);
            }
        } else {
            while (d.r < this.u0) {
                Object item4 = this.u0.get(size);
                size = size + 1;
            }
        }
        ArrayList list2 = null;
        if (this.E0 > 0) {
            b.b(this, dVar, list2, size);
        }
        if (this.F0 > 0) {
            b.b(this, dVar, list2, size);
        }
        return true;
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
    public void p1(d dVar) {
        int i;
        if (this.O0 != null && this.O0.get() != null) {
            if (dVar.d() > (d)this.O0.get().d()) {
                this.O0 = new WeakReference(dVar);
            }
        }
    }

    @Override // d.f.a.m.l
    public void q1(d dVar) {
        int i;
        if (this.M0 != null && this.M0.get() != null) {
            if (dVar.d() > (d)this.M0.get().d()) {
                this.M0 = new WeakReference(dVar);
            }
        }
    }

    @Override // d.f.a.m.l
    void u1(d dVar) {
        int i;
        if (this.N0 != null && this.N0.get() != null) {
            if (dVar.d() > (d)this.N0.get().d()) {
                this.N0 = new WeakReference(dVar);
            }
        }
    }

    @Override // d.f.a.m.l
    void v1(d dVar) {
        int i;
        if (this.L0 != null && this.L0.get() != null) {
            if (dVar.d() > (d)this.L0.get().d()) {
                this.L0 = new WeakReference(dVar);
            }
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
    public boolean y1(boolean z, int i) {
        return this.w0.h(z, i);
    }

    @Override // d.f.a.m.l
    public b.b z1() {
        return this.y0;
    }

}
