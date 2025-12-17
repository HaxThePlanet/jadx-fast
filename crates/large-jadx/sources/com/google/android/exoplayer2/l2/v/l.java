package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.audio.y;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class l implements com.google.android.exoplayer2.l2.v.n {

    private final d0 a;
    private final String b;
    private String c;
    private s d;
    private int e = 0;
    private int f;
    private int g;
    private long h;
    private i1 i;
    private int j;
    private long k = -9223372036854775807L;
    public l(String string) {
        super();
        d0 d0Var = new d0(new byte[18]);
        this.a = d0Var;
        int i = 0;
        long l = -9223372036854775807L;
        this.b = string;
    }

    private boolean a(d0 d0, byte[] b2Arr2, int i3) {
        int obj3;
        int i2 = Math.min(d0.a(), i3 - i4);
        d0.j(b2Arr2, this.f, i2);
        obj3 += i2;
        this.f = obj3;
        obj3 = obj3 == i3 ? 1 : 0;
        return obj3;
    }

    @RequiresNonNull("output")
    private void g() {
        i1 i1Var;
        s sVar;
        int i;
        byte[] bArr = this.a.d();
        if (this.i == null) {
            i1Var = y.g(bArr, this.c, this.b, 0);
            this.i = i1Var;
            this.d.e(i1Var);
        }
        this.j = y.a(bArr);
        this.h = (long)i4;
    }

    private boolean h(d0 d0) {
        final int i7 = 0;
        while (d0.a() > 0) {
            i2 <<= 8;
            this.g = i3;
            i3 |= i8;
            this.g = i4;
            i7 = 0;
        }
        return i7;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        s cmp;
        int i;
        int i3;
        int i4;
        long l;
        int i2;
        int i6;
        int i7;
        int i5;
        g.h(this.d);
        while (d0.a() > 0) {
            int i9 = this.e;
            i = 1;
            if (h(d0) != null) {
            }
            this.e = i;
            i3 = 0;
            i4 = 2;
            i = 18;
            if (a(d0, this.a.d(), i) != null) {
            }
            g();
            this.a.I(i3);
            this.d.c(this.a, i);
            this.e = i4;
            cmp = Math.min(d0.a(), i11 -= i4);
            this.d.c(d0, cmp);
            i13 += cmp;
            this.f = i;
            i6 = this.j;
            l = this.k;
            if (i == i6 && Long.compare(l, l2) != 0) {
            }
            l = this.k;
            if (Long.compare(l, l2) != 0) {
            }
            this.e = i3;
            this.d.d(l, obj5, 1, i6, 0);
            this.k = l3 += i4;
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        int i = 0;
        this.e = i;
        this.f = i;
        this.g = i;
        this.k = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        d2.a();
        this.c = d2.b();
        this.d = k.t(d2.c(), 1);
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        if (Long.compare(l, l2) != 0) {
            this.k = l;
        }
    }
}
