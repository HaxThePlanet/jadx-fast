package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.audio.b0.a;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class u implements com.google.android.exoplayer2.l2.v.n {

    private final d0 a;
    private final b0.a b;
    private final String c;
    private s d;
    private String e;
    private int f = 0;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l = -9223372036854775807L;
    public u(String string) {
        super();
        d0 d0Var = new d0(4);
        this.a = d0Var;
        d0Var.d()[0] = -1;
        b0.a aVar = new b0.a();
        this.b = aVar;
        long l = -9223372036854775807L;
        this.c = string;
    }

    private void a(d0 d0) {
        int i5;
        int i;
        int i6;
        boolean z;
        int i4;
        int i2;
        int i3;
        byte[] bArr = d0.d();
        i5 = d0.e();
        int i7 = d0.f();
        while (i5 < i7) {
            int i10 = 255;
            i4 = 0;
            i2 = 1;
            if (b2 &= i10 == i10) {
            } else {
            }
            i = i4;
            i3 = 224;
            if (this.i && b3 &= i3 == i3) {
            } else {
            }
            i6 = i4;
            this.i = i;
            i5++;
            i3 = 224;
            if (b3 &= i3 == i3) {
            } else {
            }
            i6 = i2;
            i = i2;
        }
        d0.I(i7);
    }

    @RequiresNonNull("output")
    private void g(d0 d0) {
        int i;
        int i4;
        int i3;
        long l;
        int i2;
        i4 = this.g;
        i = Math.min(d0.a(), i6 -= i4);
        this.d.c(d0, i);
        obj8 += i;
        this.g = obj8;
        final int i8 = this.k;
        if (obj8 < i8) {
        }
        long l3 = this.l;
        if (Long.compare(l3, l) != 0) {
            this.d.d(l3, i4, 1, i8, 0);
            this.l = l2 += i4;
        }
        int obj8 = 0;
        this.g = obj8;
        this.f = obj8;
    }

    @RequiresNonNull("output")
    private void h(d0 d0) {
        boolean z;
        int i;
        Object obj8;
        final int i9 = 4;
        int i3 = Math.min(d0.a(), i5 - 4);
        d0.j(this.a.d(), this.g, i3);
        obj8 += i3;
        this.g = obj8;
        if (obj8 < i9) {
        }
        int i4 = 0;
        this.a.I(i4);
        int i8 = 1;
        if (!this.b.a(this.a.n())) {
            this.g = i4;
            this.f = i8;
        }
        obj8 = this.b;
        this.k = obj8.c;
        if (!this.h) {
            this.j = i17 /= l;
            obj8 = new i1.b();
            obj8.S(this.e);
            obj8.e0(aVar.b);
            obj8.W(4096);
            obj8.H(aVar2.e);
            obj8.f0(aVar3.d);
            obj8.V(this.c);
            this.d.e(obj8.E());
            this.h = i8;
        }
        this.a.I(i4);
        this.d.c(this.a, i9);
        this.f = 2;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        s sVar;
        int i;
        g.h(this.d);
        while (d0.a() > 0) {
            sVar = this.f;
            a(d0);
            h(d0);
            g(d0);
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        int i = 0;
        this.f = i;
        this.g = i;
        this.i = i;
        this.l = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        d2.a();
        this.e = d2.b();
        this.d = k.t(d2.c(), 1);
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        if (Long.compare(l, l2) != 0) {
            this.l = l;
        }
    }
}
