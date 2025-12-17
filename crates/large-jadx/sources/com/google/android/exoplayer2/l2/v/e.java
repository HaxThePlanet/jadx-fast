package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.audio.n;
import com.google.android.exoplayer2.l2.i;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.p;
import com.google.android.exoplayer2.l2.q.b;
import com.google.android.exoplayer2.util.d0;

/* loaded from: classes2.dex */
public final class e implements i {

    private final com.google.android.exoplayer2.l2.v.f a;
    private final d0 b;
    private boolean c;
    static {
        final com.google.android.exoplayer2.l2.v.a aVar = a.a;
    }

    public e() {
        super();
        f fVar = new f();
        this.a = fVar;
        d0 d0Var = new d0(2786);
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
        int i4;
        int i;
        int i3;
        int i2;
        int i6;
        int i5;
        int i7;
        int i8 = 10;
        d0 d0Var = new d0(i8);
        final int i10 = 0;
        i = i10;
        j.m(d0Var.d(), i10, i8);
        d0Var.I(i10);
        while (d0Var.A() != 4801587) {
            d0Var.J(3);
            i3 = d0Var.w();
            i += i6;
            j.g(i3);
            j.m(d0Var.d(), i10, i8);
            d0Var.I(i10);
        }
        j.i();
        j.g(i);
        i4 = i10;
        i2 = i;
        j.m(d0Var.d(), i10, 6);
        d0Var.I(i10);
        while (d0Var.D() != 2935) {
            j.i();
            i2++;
            j.g(i2);
            i4 = i10;
            j.m(d0Var.d(), i10, 6);
            d0Var.I(i10);
            int i14 = 1;
            int i15 = n.f(d0Var.d());
            j.g(i15 += -6);
        }
        return i10;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public int c(j j, p p2) {
        int i;
        boolean obj4;
        d0 obj5;
        final int i2 = 0;
        obj4 = j.read(this.b.d(), i2, 2786);
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
