package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.audio.o;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class h implements com.google.android.exoplayer2.l2.v.n {

    private final c0 a;
    private final d0 b;
    private final String c;
    private String d;
    private s e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private i1 k;
    private int l;
    private long m;
    public h() {
        super(0);
    }

    public h(String string) {
        super();
        c0 c0Var = new c0(new byte[16]);
        this.a = c0Var;
        d0 d0Var = new d0(c0Var.a);
        this.b = d0Var;
        int i = 0;
        this.f = i;
        this.g = i;
        this.h = i;
        this.i = i;
        this.m = -9223372036854775807L;
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
        boolean equals;
        Object str;
        int i2;
        int i;
        this.a.o(0);
        com.google.android.exoplayer2.audio.o.b bVar = o.d(this.a);
        equals = this.k;
        str = "audio/ac4";
        if (equals != null && bVar.b == equals.Q && bVar.a == equals.R) {
            if (bVar.b == equals.Q) {
                if (bVar.a == equals.R) {
                    if (!str.equals(equals.D)) {
                        i1.b bVar2 = new i1.b();
                        bVar2.S(this.d);
                        bVar2.e0(str);
                        bVar2.H(bVar.b);
                        bVar2.f0(bVar.a);
                        bVar2.V(this.c);
                        equals = bVar2.E();
                        this.k = equals;
                        this.e.e(equals);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        this.l = bVar.c;
        this.j = i10 /= l;
    }

    private boolean h(d0 d0) {
        int i2;
        int i4;
        int i3;
        int i5;
        int i6;
        int i;
        i4 = 0;
        while (d0.a() > 0) {
            i3 = 172;
            i6 = 1;
            i2 = d0.x();
            if (i2 == i3) {
            } else {
            }
            i5 = i4;
            this.h = i5;
            i = 65;
            i4 = 0;
            i5 = i6;
            if (d0.x() == i3) {
            }
            this.h = i4;
            i4 = i6;
        }
        return i4;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        s cmp;
        int i7;
        int i3;
        int i2;
        int i8;
        long l;
        int i4;
        int i;
        int i5;
        int i6;
        g.h(this.e);
        while (d0.a() > 0) {
            cmp = this.f;
            i7 = 0;
            i2 = 2;
            i8 = 1;
            if (cmp != null) {
            } else {
            }
            if (h(d0) != null) {
            }
            this.f = i8;
            this.b.d()[i7] = -84;
            if (this.i) {
            } else {
            }
            i3 = 64;
            this.b.d()[i8] = (byte)i3;
            this.g = i2;
            i3 = 65;
            if (cmp != i8) {
            } else {
            }
            i8 = 16;
            if (a(d0, this.b.d(), i8) != null) {
            }
            g();
            this.b.I(i7);
            this.e.c(this.b, i8);
            this.f = i2;
            if (cmp != i2) {
            } else {
            }
            cmp = Math.min(d0.a(), i11 -= i8);
            this.e.c(d0, cmp);
            i13 += cmp;
            this.g = i2;
            i = this.l;
            l = this.m;
            if (i2 == i && Long.compare(l, i2) != null) {
            }
            l = this.m;
            if (Long.compare(l, i2) != null) {
            }
            this.f = i7;
            this.e.d(l, obj5, 1, i, 0);
            this.m = l2 += l;
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        int i = 0;
        this.f = i;
        this.g = i;
        this.h = i;
        this.i = i;
        this.m = -9223372036854775807L;
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
            this.m = l;
        }
    }
}
