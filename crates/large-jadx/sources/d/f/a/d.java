package d.f.a;

import d.f.a.m.d;
import d.f.a.m.d.b;
import d.f.a.m.e;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class d {

    public static boolean r = false;
    public static boolean s = true;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = false;
    private static int w = 1000;
    public static e x;
    public static long y;
    public static long z;
    public boolean a = false;
    int b = 0;
    private HashMap<String, i> c = null;
    private d.a d = new h();
    private int e = 32;
    private int f = 32;
    b[] g = null;
    public boolean h = false;
    public boolean i = false;
    private boolean[] j;
    int k = 1;
    int l = 0;
    private int m = 32;
    final c n = new c();
    private i[] o;
    private int p = 0;
    private d.a q;

    interface a {
        void a(d.a aVar);

        i b(d dVar, boolean[] zArr);

        void c(i iVar);

        void clear();

        i getKey();

        boolean isEmpty();
    }

    class b extends b {
        public b(c cVar) {
            super();
            this.e = new j(this, cVar);
        }
    }
    public d() {
        super();
        final int i5 = 32;
        this.j = new boolean[i5];
        this.o = new i[d.w];
        this.g = new b[i5];
        C();
        d.f.a.c cVar = new c();
        d.f.a.h hVar = new h(cVar);
        if (d.v) {
            this.q = new d.b(this, cVar);
        } else {
            this.q = new b(cVar);
        }
    }

    private final int B(d.a aVar, boolean z) {
        int z22;
        boolean z23;
        int i;
        d.f.a.b bVar;
        int i2 = 2139095039;
        d.f.a.e eVar;
        d.f.a.i iVar2;
        int i3;
        int i4;
        boolean z3;
        d.f.a.i.a uNRESTRICTED2;
        d.f.a.e eVar3 = d.x;
        final long l2 = 1L;
        if (d.x != null) {
            eVar3.h += l2;
        }
        z23 = false;
        z22 = z23;
        while (d.x.h < this.k) {
            this.j[z22] = z23;
            z22 = z22 + 1;
        }
        while (!d.x.h) {
            d.f.a.e eVar2 = d.x;
            i = i + 1;
            bVar = 1;
            d.f.a.i iVar = aVar.b(this, this.j);
            if (iVar != null) {
            }
        }
        return i;
    }

    private void C() {
        int i2 = 0;
        d.f.a.f fVar;
        final d.f.a.b bVar3 = null;
        i2 = 0;
        if (d.v) {
            while (i2 < this.l) {
                d.f.a.b bVar2 = this.g[i2];
                this.g[i2] = bVar3;
                i2 = i2 + 1;
            }
        } else {
            while (i2 < this.l) {
                d.f.a.b bVar = this.g[i2];
                this.g[i2] = bVar3;
                i2 = i2 + 1;
            }
        }
    }

    private i a(i.a aVar, String str) {
        d.f.a.i iVar;
        Object obj = this.n.c.b();
        if (obj == null) {
            new i(aVar, str).k(aVar, str);
        } else {
            obj.i();
            obj.k(aVar, str);
        }
        i2 = d.w;
        if (this.p >= d.w) {
            d.w *= 2;
            this.o = (i[])Arrays.copyOf(this.o, i2);
        }
        this.p++;
        this.o[this.p] = iVar;
        return iVar;
    }

    private final void l(b bVar) {
        d.f.a.i iVar;
        int bVar2;
        int i;
        d.f.a.b bVar4;
        int i2;
        int i3;
        if (!d.t || !bVar.f) {
            this.g[this.l] = bVar;
            bVar.a.v = this.l;
            this.l++;
            bVar.a.m(this, bVar);
        } else {
            bVar.a.j(this, bVar.b);
        }
        if (d.t && this.a) {
            boolean z2 = false;
            bVar2 = z2;
            while (this.g < this.l) {
                bVar2 = bVar2 + 1;
            }
            this.a = z2;
        }
    }

    private void n() {
        int i = 0;
        i = 0;
        while (i < this.l) {
            d.f.a.b bVar = this.g[i];
            bVar.a.x = bVar.b;
            i = i + 1;
        }
    }

    public static b s(d dVar, i iVar, i iVar2, float f) {
        final d.f.a.b bVar = dVar.r();
        bVar.j(iVar, iVar2, f);
        return bVar;
    }

    private int u(d.a aVar) {
        int i;
        int i2 = 1;
        boolean z;
        int cmp = 0;
        int i3 = 0;
        int i4 = 1;
        d.f.a.b[] objArr;
        d.f.a.b bVar;
        int i5;
        d.f.a.i.a aVar2;
        int i6 = 2139095039;
        d.f.a.i iVar3;
        d.f.a.i.a uNRESTRICTED2;
        float f3;
        int cmp2;
        long l;
        int i7;
        int i8;
        d.f.a.i.a aVar3;
        int cmp3;
        int cmp4;
        int cmp5;
        final Object aVar4 = this;
        i3 = 0;
        float f = 0.0f;
        while (i3 < aVar4.l) {
            if (objArr[i3].a.B != i.a.UNRESTRICTED) {
                break;
            }
        }
        i4 = 0;
        if (i4 != 0) {
            i4 = 0;
            cmp = 0;
            while (i4 == 0) {
                d.f.a.e eVar2 = d.x;
                while (i7 < aVar4.l) {
                    i8 = aVar4.g[i7];
                    i7 = i7 + 1;
                    uNRESTRICTED2 = 1;
                }
                i8 = aVar4.g[i7];
                i7 = i7 + 1;
                uNRESTRICTED2 = 1;
                int i10 = -1;
                i = aVar4.k / 2;
            }
        } else {
            cmp = 0;
        }
        return cmp;
    }

    public static e w() {
        return d.x;
    }

    private void y() {
        this.e *= 2;
        this.g = (b[])Arrays.copyOf(this.g, i4);
        this.n.d = (i[])Arrays.copyOf(cVar.d, this.e);
        this.j = new boolean[i];
        this.f = this.e;
        this.m = this.e;
        eVar = d.x;
        if (d.x != null) {
            eVar.d++;
            l = (long)i;
            eVar.o = Math.max(eVar.o, l);
            d.f.a.e eVar2 = d.x;
            eVar2.x = eVar2.o;
        }
    }

    void A(d.a aVar) {
        eVar = d.x;
        if (d.x != null) {
            eVar.t++;
            eVar.u = Math.max(eVar.u, (long)this.k);
            eVar = d.x;
            l = (long)this.l;
            eVar.v = Math.max(eVar.v, l);
        }
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        int i;
        Object obj;
        i = 0;
        length = objArr.length;
        for (d.f.a.i iVar : objArr) {
            length = objArr.length;
        }
        cVar3.c.c(this.o, this.p);
        this.p = i;
        obj = null;
        Arrays.fill(this.n.d, obj);
        if (this.c != null) {
            this.c.clear();
        }
        this.b = i;
        this.d.clear();
        this.k = 1;
        while (cVar3.c < this.l) {
            i = i + 1;
        }
        C();
        this.l = i;
        if (d.v) {
            this.q = new d.b(this, this.n);
        } else {
            this.q = new b(this.n);
        }
    }

    public void b(e eVar, e eVar2, float f, int i) {
        final Object eVar4 = this;
        Object eVar22 = eVar;
        Object f33 = eVar2;
        d.b lEFT2 = d.b.LEFT;
        d.b tOP2 = d.b.TOP;
        d.b rIGHT2 = d.b.RIGHT;
        d.b bOTTOM2 = d.b.BOTTOM;
        d.f.a.b bVar = r();
        double d = (double)f;
        double d2 = (double)i;
        bVar.q(eVar4.q(eVar22.m(tOP2)), eVar4.q(eVar22.m(bOTTOM2)), eVar4.q(f33.m(tOP2)), eVar4.q(f33.m(bOTTOM2)), (float)(Math.sin(d) * d2));
        eVar4.d(bVar);
        d.f.a.b bVar2 = r();
        bVar2.q(eVar4.q(eVar22.m(lEFT2)), iVar2, iVar, eVar3, (float)(Math.cos(d) * d2));
        eVar4.d(bVar2);
    }

    public void c(i iVar, i iVar2, int i, float f, i iVar3, i iVar4, int i2, int i3) {
        final int i82 = i3;
        final d.f.a.b bVar = r();
        bVar.h(iVar, iVar2, i, f, iVar3, iVar4, i2);
        if (i82 != 8) {
            bVar.d(this, i82);
        }
        d(bVar);
    }

    public void d(b bVar) {
        int i2 = 0;
        int i;
        boolean z3;
        d.f.a.i iVar2;
        int i3;
        int i4;
        int i5;
        if (bVar == null) {
            return;
        }
        d.f.a.e eVar = d.x;
        final long l = 1L;
        if (d.x != null) {
            eVar.f += l;
            if (bVar.f) {
                eVar.g += l;
            }
        }
        i2 = 1;
        i = this.l + i2;
        if (this.l + i2 < this.m) {
            i = this.k + i2;
            if (this.k + i2 >= this.f) {
                y();
            }
        }
        i2 = 0;
        if (!bVar.f) {
            bVar.D(this);
            if (bVar.isEmpty()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                iVar2 = p();
                bVar.a = iVar2;
                l(bVar);
                i4 = this.l + i2;
                if (this.l != this.l + i2) {
                } else {
                    this.q.a(bVar);
                    B(this.q, true);
                    i4 = -1;
                    if (iVar2.v == -1 && bVar.a == iVar2 && iVar != null && d.x != null) {
                        eVar2.j += l;
                        bVar.x(iVar);
                        if (!bVar.f) {
                            bVar.a.m(this, bVar);
                        }
                        if (d.v) {
                            this.n.a.a(bVar);
                        } else {
                            this.n.b.a(bVar);
                        }
                        this.l -= i2;
                    }
                }
            }
            if (!bVar.s()) {
                return;
            }
        }
        if (bVar.a == 0) {
            l(bVar);
        }
    }

    public b e(i iVar, i iVar2, int i, int i2) {
        final int i5 = 8;
        if (d.s && i2 == i5 && iVar2.y && iVar.v == -1) {
            iVar.j(this, iVar2.x + (float)i);
            return null;
        }
        d.f.a.b bVar = r();
        bVar.n(iVar, iVar2, i);
        if (i2 != i5) {
            bVar.d(this, i2);
        }
        d(bVar);
        return bVar;
    }

    public void f(i iVar, int i) {
        boolean z3;
        int i4;
        int i3 = -1;
        final int i10 = 1;
        if (d.s && iVar.v == i3) {
            final float f4 = (float)i;
            iVar.j(this, f4);
            i = 0;
            while (iVar.v < this.b + i10) {
                i3 = this.n.d[i];
                i = i + 1;
            }
            return;
        }
        if (iVar.v == i3) {
            d.f.a.b bVar = r();
            bVar.i(iVar, i);
            d(bVar);
        } else {
            bVar = this.g[i6];
            if (bVar.f) {
                f = (float)i;
                bVar.b = f;
            } else {
                if (bVar.e.a() == 0) {
                    bVar.f = true;
                    f = (float)i;
                    bVar.b = f;
                } else {
                    bVar = r();
                    bVar.m(iVar, i);
                    d(bVar);
                }
            }
        }
    }

    public void g(i iVar, i iVar2, int i, boolean z) {
        final d.f.a.b bVar = r();
        final d.f.a.i iVar3 = t();
        iVar3.w = 0;
        bVar.o(iVar, iVar2, iVar3, i);
        d(bVar);
    }

    public void h(i iVar, i iVar2, int i, int i2) {
        final d.f.a.b bVar = r();
        final d.f.a.i iVar3 = t();
        iVar3.w = 0;
        bVar.o(iVar, iVar2, iVar3, i);
        i = 8;
        if (i2 != 8) {
            float f = -1f;
            i = (int)(bVar.e.j(iVar3) * f);
            m(bVar, i, i2);
        }
        d(bVar);
    }

    public void i(i iVar, i iVar2, int i, boolean z) {
        final d.f.a.b bVar = r();
        final d.f.a.i iVar3 = t();
        iVar3.w = 0;
        bVar.p(iVar, iVar2, iVar3, i);
        d(bVar);
    }

    public void j(i iVar, i iVar2, int i, int i2) {
        final d.f.a.b bVar = r();
        final d.f.a.i iVar3 = t();
        iVar3.w = 0;
        bVar.p(iVar, iVar2, iVar3, i);
        i = 8;
        if (i2 != 8) {
            float f = -1f;
            i = (int)(bVar.e.j(iVar3) * f);
            m(bVar, i, i2);
        }
        d(bVar);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f, int i) {
        final d.f.a.b bVar = r();
        bVar.k(iVar, iVar2, iVar3, iVar4, f);
        if (i != 8) {
            bVar.d(this, i);
        }
        d(bVar);
    }

    void m(b bVar, int i, int i2) {
        bVar.e(o(i2, null), i);
    }

    public i o(int i, String str) {
        d.f.a.e eVar = d.x;
        if (d.x != null) {
            long l2 = 1L;
            eVar.l += l2;
        }
        if (this.k + 1 >= this.f) {
            y();
        }
        final d.f.a.i iVar = a(i.a.ERROR, str);
        this.b++;
        this.k++;
        iVar.c = i5;
        iVar.w = i;
        this.n.d[i5] = iVar;
        this.d.c(iVar);
        return iVar;
    }

    public i p() {
        d.f.a.e eVar = d.x;
        if (d.x != null) {
            long l2 = 1L;
            eVar.n += l2;
        }
        if (this.k + 1 >= this.f) {
            y();
        }
        d.f.a.i iVar = a(i.a.SLACK, null);
        this.b++;
        this.k++;
        iVar.c = i6;
        this.n.d[i6] = iVar;
        return iVar;
    }

    public i q(Object object) {
        int i = 0;
        d.f.a.i object2;
        int i2;
        i = 0;
        if (object == null) {
            return null;
        }
        if (this.k + 1 >= this.f) {
            y();
        }
        z = object instanceof d;
        if (object instanceof d) {
            if (object.h() == null) {
                object.r(this.n);
            }
            int i6 = -1;
            if (object2.c != i6 && object2.c <= this.b) {
                if (this.n.d[i3] == null && object2.c != i6) {
                    object2.i();
                    this.b++;
                    this.k++;
                    object2.c = i3;
                    object2.B = i.a.UNRESTRICTED;
                    this.n.d[i3] = object2;
                }
            }
        }
        return i;
    }

    public b r() {
        Object obj;
        final long l2 = 1L;
        if (d.v) {
            obj = this.n.a.b();
            if (obj == null) {
                d.f.a.d.b bVar = new d.b(this, this.n);
                d.z += l2;
            } else {
                obj.y();
            }
        } else {
            obj = this.n.b.b();
            if (obj == null) {
                d.f.a.b bVar2 = new b(this.n);
                d.y += l2;
            } else {
                obj.y();
            }
        }
        i.e();
        return obj;
    }

    public i t() {
        d.f.a.e eVar = d.x;
        if (d.x != null) {
            long l2 = 1L;
            eVar.m += l2;
        }
        if (this.k + 1 >= this.f) {
            y();
        }
        d.f.a.i iVar = a(i.a.SLACK, null);
        this.b++;
        this.k++;
        iVar.c = i6;
        this.n.d[i6] = iVar;
        return iVar;
    }

    public c v() {
        return this.n;
    }

    public int x(Object object) {
        d.f.a.i iVar = object.h();
        if (iVar != null) {
            return (int)(iVar.x + 0.5f);
        }
        return 0;
    }

    public void z() {
        int i = 0;
        long l;
        boolean z2;
        d.f.a.e eVar = d.x;
        final long l2 = 1L;
        if (d.x != null) {
            eVar.e += l2;
        }
        if (this.d.isEmpty()) {
            n();
            return;
        }
        if (this.h || this.i) {
            d.f.a.e eVar2 = d.x;
            if (d.x != null) {
                eVar2.q += l2;
            }
            i = 0;
            while (d.x.e < this.l) {
                if (!this.g[i].f) {
                    break;
                }
            }
            i = 1;
            if (this.h == 0) {
                A(this.d);
            } else {
                d.f.a.e eVar3 = d.x;
                if (d.x != null) {
                    eVar3.p += l2;
                }
                n();
            }
        }
    }

}
