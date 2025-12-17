package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.audio.o;
import com.google.android.exoplayer2.l2.i;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.p;
import com.google.android.exoplayer2.l2.q.b;
import com.google.android.exoplayer2.util.d0;

/* loaded from: classes2.dex */
public final class g implements i {

    private final com.google.android.exoplayer2.l2.v.h a;
    private final d0 b;
    private boolean c;
    static {
        final com.google.android.exoplayer2.l2.v.b bVar = b.a;
    }

    public g() {
        super();
        h hVar = new h();
        this.a = hVar;
        d0 d0Var = new d0(16384);
        this.b = d0Var;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void a(k k) {
        final int i = 0;
        e0.d dVar = new e0.d(i, 1);
        this.a.e(k, dVar);
        k.n();
        q.b bVar = new q.b(-9223372036854775807L, i);
        k.d(bVar);
    }

    @Override // com.google.android.exoplayer2.l2.i
    public boolean b(j j) {
        int i8;
        int i4;
        int i7;
        int i5;
        int i;
        int i6;
        int i3;
        int i2;
        int i9 = 10;
        d0 d0Var = new d0(i9);
        final int i11 = 0;
        i4 = i11;
        j.m(d0Var.d(), i11, i9);
        d0Var.I(i11);
        while (d0Var.A() != 4801587) {
            d0Var.J(3);
            i7 = d0Var.w();
            i4 += i;
            j.g(i7);
            j.m(d0Var.d(), i11, i9);
            d0Var.I(i11);
        }
        j.i();
        j.g(i4);
        i8 = i11;
        i5 = i4;
        j.m(d0Var.d(), i11, 7);
        d0Var.I(i11);
        int i14 = d0Var.D();
        while (i14 != 44096) {
            int i17 = 1;
            int i15 = o.e(d0Var.d(), i14);
            j.g(i15 += -7);
            j.m(d0Var.d(), i11, 7);
            d0Var.I(i11);
            i14 = d0Var.D();
            j.i();
            i5++;
            j.g(i5);
            i8 = i11;
        }
        return i11;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public int c(j j, p p2) {
        int i;
        boolean obj4;
        d0 obj5;
        final int i2 = 0;
        obj4 = j.read(this.b.d(), i2, 16384);
        obj5 = -1;
        if (obj4 == obj5) {
            return obj5;
        }
        this.b.I(i2);
        this.b.H(obj4);
        if (!this.c) {
            this.a.f(0, obj2);
            this.c = true;
        }
        this.a.b(this.b);
        return i2;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void d(long l, long l2) {
        this.c = false;
        this.a.c();
    }
}
