package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.audio.n;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class f implements com.google.android.exoplayer2.l2.v.n {

    private final c0 a;
    private final d0 b;
    private final String c;
    private String d;
    private s e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private i1 j;
    private int k;
    private long l;
    public f() {
        super(0);
    }

    public f(String string) {
        super();
        c0 c0Var = new c0(new byte[128]);
        this.a = c0Var;
        d0 d0Var = new d0(c0Var.a);
        this.b = d0Var;
        this.f = 0;
        this.l = -9223372036854775807L;
        this.c = string;
    }

    private boolean a(d0 d0, byte[] b2Arr2, int i3) {
        int obj3;
        int i2 = Math.min(d0.a(), i3 - i4);
        d0.j(b2Arr2, this.g, i2);
        obj3 += i2;
        this.g = obj3;
        obj3 = obj3 == i3 ? 1 : 0;
        return obj3;
    }

    @RequiresNonNull("output")
    private void g() {
        boolean i1Var;
        Object i2;
        int i;
        this.a.o(0);
        com.google.android.exoplayer2.audio.n.b bVar = n.e(this.a);
        i1Var = this.j;
        if (i1Var != null && bVar.c == i1Var.Q && bVar.b == i1Var.R) {
            if (bVar.c == i1Var.Q) {
                if (bVar.b == i1Var.R) {
                    if (!p0.b(bVar.a, i1Var.D)) {
                        i1.b bVar2 = new i1.b();
                        bVar2.S(this.d);
                        bVar2.e0(bVar.a);
                        bVar2.H(bVar.c);
                        bVar2.f0(bVar.b);
                        bVar2.V(this.c);
                        i1Var = bVar2.E();
                        this.j = i1Var;
                        this.e.e(i1Var);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        this.k = bVar.d;
        this.i = i10 /= l;
    }

    private boolean h(d0 d0) {
        int i5;
        int i3;
        int i4;
        int i;
        int i2;
        i3 = 0;
        while (d0.a() > 0) {
            i4 = 11;
            i = 1;
            i5 = d0.x();
            if (i5 == i4) {
            }
            this.h = i3;
            i3 = 0;
            i3 = i;
            if (d0.x() == i4) {
            }
            this.h = i3;
            i3 = i;
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        s cmp;
        int i;
        int i6;
        int i4;
        long l;
        int i3;
        int i7;
        int i2;
        int i5;
        g.h(this.e);
        while (d0.a() > 0) {
            cmp = this.f;
            i = 0;
            i6 = 2;
            i4 = 1;
            if (cmp != null) {
            } else {
            }
            if (h(d0) != null) {
            }
            this.f = i4;
            this.b.d()[i] = 11;
            this.b.d()[i4] = 119;
            this.g = i6;
            if (cmp != i4) {
            } else {
            }
            i4 = 128;
            if (a(d0, this.b.d(), i4) != null) {
            }
            g();
            this.b.I(i);
            this.e.c(this.b, i4);
            this.f = i6;
            if (cmp != i6) {
            } else {
            }
            cmp = Math.min(d0.a(), i10 -= i4);
            this.e.c(d0, cmp);
            i12 += cmp;
            this.g = i6;
            i7 = this.k;
            l = this.l;
            if (i6 == i7 && Long.compare(l, i6) != null) {
            }
            l = this.l;
            if (Long.compare(l, i6) != null) {
            }
            this.f = i;
            this.e.d(l, obj5, 1, i7, 0);
            this.l = l2 += l;
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        int i = 0;
        this.f = i;
        this.g = i;
        this.h = i;
        this.l = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        d2.a();
        this.d = d2.b();
        this.e = k.t(d2.c(), 1);
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        if (Long.compare(l, l2) != 0) {
            this.l = l;
        }
    }
}
