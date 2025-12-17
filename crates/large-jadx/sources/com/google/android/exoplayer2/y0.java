package com.google.android.exoplayer2;

/* loaded from: classes.dex */
@Deprecated
public class y0 implements com.google.android.exoplayer2.x0 {

    private final long a = -9223372036854775807L;
    private final long b = -9223372036854775807L;
    private final boolean c = false;
    public y0() {
        super();
        long l = -9223372036854775807L;
        int i = 0;
    }

    private static void l(com.google.android.exoplayer2.v1 v1, long l2) {
        int i;
        long obj5 = v1.d();
        if (Long.compare(obj5, l3) != 0) {
            i = Math.min(l += l2, obj1);
        }
        v1.w(Math.max(i, obj1));
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean a(com.google.android.exoplayer2.v1 v1, int i2) {
        v1.J(i2);
        return 1;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean b(com.google.android.exoplayer2.v1 v1) {
        boolean z;
        if (!this.c) {
            v1.T();
        } else {
            if (j() && v1.q()) {
                if (v1.q()) {
                    y0.l(v1, this.b);
                }
            }
        }
        return 1;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean c() {
        int i;
        boolean cmp;
        int i2;
        if (this.c) {
            if (Long.compare(l, i2) > 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean d(com.google.android.exoplayer2.v1 v1) {
        boolean z;
        if (!this.c) {
            v1.W();
        } else {
            if (c() && v1.q()) {
                if (v1.q()) {
                    y0.l(v1, -l);
                }
            }
        }
        return 1;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean e(com.google.android.exoplayer2.v1 v1, int i2, long l3) {
        v1.j(i2, l3);
        return 1;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean f(com.google.android.exoplayer2.v1 v1, boolean z2) {
        v1.m(z2);
        return 1;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean g(com.google.android.exoplayer2.v1 v1) {
        v1.f();
        return 1;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean h(com.google.android.exoplayer2.v1 v1) {
        v1.y();
        return 1;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean i(com.google.android.exoplayer2.v1 v1) {
        v1.S();
        return 1;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean j() {
        int i;
        boolean cmp;
        int i2;
        if (this.c) {
            if (Long.compare(l, i2) > 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.x0
    public boolean k(com.google.android.exoplayer2.v1 v1, boolean z2) {
        v1.A(z2);
        return 1;
    }
}
