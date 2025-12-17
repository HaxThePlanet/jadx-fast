package com.google.android.exoplayer2;

import com.google.android.exoplayer2.n2.g;
import com.google.android.exoplayer2.n2.n;
import com.google.android.exoplayer2.n2.o;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes.dex */
final class o1 {

    public final w a;
    public final Object b;
    public final f0[] c;
    public boolean d;
    public boolean e;
    public com.google.android.exoplayer2.p1 f;
    public boolean g;
    private final boolean[] h;
    private final com.google.android.exoplayer2.a2[] i;
    private final n j;
    private final com.google.android.exoplayer2.s1 k;
    private com.google.android.exoplayer2.o1 l;
    private l0 m;
    private o n;
    private long o;
    public o1(com.google.android.exoplayer2.a2[] a2Arr, long l2, n n3, f f4, com.google.android.exoplayer2.s1 s15, com.google.android.exoplayer2.p1 p16, o o7) {
        super();
        this.i = a2Arr;
        this.o = l2;
        this.j = f4;
        this.k = p16;
        final y.a aVar = o7.a;
        this.b = aVar.a;
        this.f = o7;
        this.m = l0.v;
        this.n = obj15;
        this.c = new f0[a2Arr.length];
        this.h = new boolean[a2Arr.length];
        this.a = o1.e(aVar, p16, s15, o7.b, obj4);
    }

    private void c(f0[] f0Arr) {
        int i;
        int qVar;
        int i2;
        i = 0;
        com.google.android.exoplayer2.a2[] objArr = this.i;
        while (i < objArr.length) {
            if (objArr[i].i() == 7 && this.n.c(i)) {
            }
            i++;
            objArr = this.i;
            if (this.n.c(i)) {
            }
            qVar = new q();
            f0Arr[i] = qVar;
        }
    }

    private static w e(y.a y$a, com.google.android.exoplayer2.s1 s12, f f3, long l4, long l5) {
        k kVar;
        Object wVar;
        int i2;
        int i;
        long l;
        int obj7;
        if (Long.compare(obj12, obj7) != 0) {
            super(s12.g(a, f3, l4), 1, 0, obj4, obj12, obj6);
            wVar = obj7;
        }
        return wVar;
    }

    private void f() {
        int i;
        boolean z;
        g gVar;
        if (!r()) {
        }
        i = 0;
        o oVar = this.n;
        while (i < oVar.a) {
            gVar = oVar2.c[i];
            if (oVar.c(i) && gVar != null) {
            }
            i++;
            oVar = this.n;
            if (gVar != null) {
            }
            gVar.g();
        }
    }

    private void g(f0[] f0Arr) {
        int i;
        int i2;
        int i3;
        i = 0;
        com.google.android.exoplayer2.a2[] objArr = this.i;
        while (i < objArr.length) {
            if (objArr[i].i() == 7) {
            }
            i++;
            objArr = this.i;
            f0Arr[i] = 0;
        }
    }

    private void h() {
        int i;
        boolean z;
        g gVar;
        if (!r()) {
        }
        i = 0;
        o oVar = this.n;
        while (i < oVar.a) {
            gVar = oVar2.c[i];
            if (oVar.c(i) && gVar != null) {
            }
            i++;
            oVar = this.n;
            if (gVar != null) {
            }
            gVar.i();
        }
    }

    private boolean r() {
        int i;
        i = this.l == null ? 1 : 0;
        return i;
    }

    private static void u(com.google.android.exoplayer2.s1 s1, w w2) {
        boolean z;
        Throwable obj1;
        Object obj2;
        try {
            if (w2 instanceof k) {
            } else {
            }
            s1.z(w2.a);
            s1.z((k)w2);
            w2 = "MediaPeriodHolder";
            v.d(w2, "Period release failed.", s1);
        }
    }

    public void A() {
        long l;
        int i;
        final w wVar = this.a;
        if (wVar instanceof k && Long.compare(l, l2) == 0) {
            if (Long.compare(l, l2) == 0) {
                l = Long.MIN_VALUE;
            }
            (k)wVar.v(0, obj4);
        }
    }

    public long a(o o, long l2, boolean z3) {
        return this.b(o, l2, obj4, obj11);
    }

    public long b(o o, long l2, boolean z3, boolean[] z4Arr4) {
        int i3;
        boolean[] zArr;
        int i2;
        boolean z;
        int i;
        g[] objArr;
        boolean[] length;
        final Object obj = this;
        final Object obj2 = o;
        final int i4 = 0;
        i3 = i4;
        i2 = 1;
        while (i3 < obj2.a) {
            if (z4Arr4 == null && o.b(obj.n, i3)) {
            } else {
            }
            i2 = i4;
            obj.h[i3] = i2;
            i3++;
            i2 = 1;
            if (o.b(obj.n, i3)) {
            } else {
            }
        }
        g(obj.c);
        f();
        obj.n = obj2;
        h();
        c(obj.c);
        obj.e = i4;
        i = i4;
        f0[] objArr4 = obj.c;
        while (i < objArr4.length) {
            if (objArr4[i] != null) {
            } else {
            }
            if (obj2.c[i] == null) {
            } else {
            }
            objArr = i4;
            g.f(objArr);
            i++;
            objArr4 = obj.c;
            objArr = i2;
            g.f(o.c(i));
            if (obj.i[i].i() != 7) {
            }
            obj.e = i2;
        }
        return obj.a.q(obj2.c, obj.h, obj.c, obj18, l2);
    }

    public void d(long l) {
        g.f(r());
        this.a.b(y(l));
    }

    public long i() {
        w z;
        int cmp;
        long l;
        if (!this.d) {
            return p1Var.b;
        }
        final long l3 = Long.MIN_VALUE;
        if (this.e) {
            l = this.a.e();
        } else {
            l = l3;
        }
        if (Long.compare(l, l3) == 0) {
            l = cmp.e;
        }
        return l;
    }

    public com.google.android.exoplayer2.o1 j() {
        return this.l;
    }

    public long k() {
        int i;
        if (!this.d) {
            i = 0;
        } else {
            i = this.a.a();
        }
        return i;
    }

    public long l() {
        return this.o;
    }

    public long m() {
        return l += l2;
    }

    public l0 n() {
        return this.m;
    }

    public o o() {
        return this.n;
    }

    public void p(float f, com.google.android.exoplayer2.g2 g22) {
        long l;
        long l2;
        long l3;
        int obj8;
        this.d = true;
        this.m = this.a.r();
        obj8 = this.f;
        l2 = obj8.e;
        if (Long.compare(l2, l3) != 0 && Long.compare(l, l2) >= 0) {
            if (Long.compare(l, l2) >= 0) {
                l = Math.max(0, obj1);
            }
        }
        obj8 = 0;
        long obj7 = a(v(f, g22), l, obj1);
        com.google.android.exoplayer2.p1 p1Var = this.f;
        this.o = l4 += i4;
        this.f = p1Var.b(obj7);
    }

    public boolean q() {
        boolean cmp;
        int i;
        long l;
        if (this.d) {
            if (this.e) {
                i = Long.compare(l2, l) == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public void s(long l) {
        boolean z;
        long obj2;
        g.f(r());
        if (this.d) {
            this.a.f(y(l));
        }
    }

    public void t() {
        f();
        o1.u(this.k, this.a);
    }

    public o v(float f, com.google.android.exoplayer2.g2 g22) {
        int i;
        y.a aVar;
        final o obj6 = this.j.d(this.i, n(), p1Var.a, g22);
        g[] objArr = obj6.c;
        i = 0;
        while (i < objArr.length) {
            aVar = objArr[i];
            if (aVar != null) {
            }
            i++;
            aVar.p(f);
        }
        return obj6;
    }

    public void w(com.google.android.exoplayer2.o1 o1) {
        if (o1 == this.l) {
        }
        f();
        this.l = o1;
        h();
    }

    public void x(long l) {
        this.o = l;
    }

    public long y(long l) {
        return l -= l2;
    }

    public long z(long l) {
        return l += l2;
    }
}
