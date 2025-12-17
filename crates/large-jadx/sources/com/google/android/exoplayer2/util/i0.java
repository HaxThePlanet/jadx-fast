package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.w0;

/* loaded from: classes2.dex */
public final class i0 implements com.google.android.exoplayer2.util.x {

    private final com.google.android.exoplayer2.util.i a;
    private boolean b;
    private long c;
    private long v;
    private u1 w;
    public i0(com.google.android.exoplayer2.util.i i) {
        super();
        this.a = i;
        this.w = u1.d;
    }

    @Override // com.google.android.exoplayer2.util.x
    public void a(long l) {
        boolean obj1;
        this.c = l;
        if (this.b) {
            this.v = this.a.a();
        }
    }

    @Override // com.google.android.exoplayer2.util.x
    public void b() {
        boolean z;
        if (!this.b) {
            this.v = this.a.a();
            this.b = true;
        }
    }

    @Override // com.google.android.exoplayer2.util.x
    public void c() {
        boolean z;
        if (this.b) {
            a(o());
            this.b = false;
        }
    }

    @Override // com.google.android.exoplayer2.util.x
    public u1 e() {
        return this.w;
    }

    @Override // com.google.android.exoplayer2.util.x
    public void h(u1 u1) {
        boolean z;
        if (this.b) {
            a(o());
        }
        this.w = u1;
    }

    @Override // com.google.android.exoplayer2.util.x
    public long o() {
        long l;
        long z;
        u1 u1Var;
        int cmp;
        int i;
        if (this.b) {
            l2 -= l3;
            u1Var = this.w;
            if (Float.compare(f, i) == 0) {
                z = w0.d(i2);
            } else {
                z = u1Var.a(i2);
            }
            l += z;
        }
        return l;
    }
}
