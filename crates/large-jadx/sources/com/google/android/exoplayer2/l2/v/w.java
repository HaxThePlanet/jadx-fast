package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public final class w implements com.google.android.exoplayer2.l2.v.y {

    private i1 a;
    private m0 b;
    private s c;
    public w(String string) {
        super();
        i1.b bVar = new i1.b();
        bVar.e0(string);
        this.a = bVar.E();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void c() {
        g.h(this.b);
        p0.i(this.c);
    }

    @Override // com.google.android.exoplayer2.l2.v.y
    public void a(m0 m0, k k2, com.google.android.exoplayer2.l2.v.e0.d e0$d3) {
        this.b = m0;
        d3.a();
        s obj1 = k2.t(d3.c(), 5);
        this.c = obj1;
        obj1.e(this.a);
    }

    @Override // com.google.android.exoplayer2.l2.v.y
    public void b(d0 d0) {
        long l;
        s sVar;
        Object i1Var;
        long cmp2;
        int i2;
        int cmp;
        int i;
        c();
        final long l2 = this.b.d();
        l = this.b.e();
        cmp2 = -9223372036854775807L;
        if (Long.compare(l2, cmp2) != 0) {
            if (Long.compare(l, cmp2) == 0) {
            } else {
                i1Var = this.a;
                if (Long.compare(l, l3) != 0) {
                    i1Var = i1Var.a();
                    i1Var.i0(l);
                    l = i1Var.E();
                    this.a = l;
                    this.c.e(l);
                }
                i2 = d0.a();
                this.c.c(d0, i2);
                this.c.d(l2, obj3, 1, i2, 0);
            }
        }
    }
}
