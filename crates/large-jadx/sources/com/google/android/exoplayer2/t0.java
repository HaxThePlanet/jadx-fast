package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public abstract class t0 implements com.google.android.exoplayer2.v1 {

    protected final com.google.android.exoplayer2.g2.c a;
    protected t0() {
        super();
        g2.c cVar = new g2.c();
        this.a = cVar;
    }

    private int c0() {
        int i;
        if (N() == 1) {
            i = 0;
        }
        return i;
    }

    private void k0(long l) {
        int i;
        long obj5 = d();
        if (Long.compare(obj5, l3) != 0) {
            i = Math.min(l2 += l, obj1);
        }
        w(Math.max(i, obj1));
    }

    @Override // com.google.android.exoplayer2.v1
    public final boolean F() {
        int i2;
        int i;
        if (E() == 3 && l() && L() == 0) {
            if (l()) {
                i2 = L() == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.v1
    public final boolean I(int i) {
        return k().b(i);
    }

    @Override // com.google.android.exoplayer2.v1
    public final void S() {
        boolean z;
        if (!O().q()) {
            if (h()) {
            } else {
                if (d0()) {
                    j0();
                } else {
                    if (g0() && f0()) {
                        if (f0()) {
                            h0();
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.v1
    public final void T() {
        k0(B());
    }

    @Override // com.google.android.exoplayer2.v1
    public final void W() {
        k0(-l);
    }

    @Override // com.google.android.exoplayer2.v1
    public final int a0() {
        int i;
        boolean z2;
        int i2;
        boolean z;
        com.google.android.exoplayer2.g2 g2Var = O();
        if (g2Var.q()) {
            i = -1;
        } else {
            i = g2Var.e(x(), c0(), Q());
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.v1
    protected com.google.android.exoplayer2.v1.b b(com.google.android.exoplayer2.v1.b v1$b) {
        int i3;
        boolean z2;
        int i6;
        int i4;
        boolean z3;
        int i7;
        boolean z6;
        int i5;
        boolean z5;
        int i2;
        int i;
        boolean z;
        boolean z7;
        boolean z4;
        v1.b.a aVar = new v1.b.a();
        aVar.b(b);
        i3 = 1;
        aVar.d(3, obj5 ^= i3);
        final int i10 = 0;
        if (q() && !h()) {
            i6 = !h() ? i3 : i10;
        } else {
        }
        aVar.d(4, i6);
        if (e0() && !h()) {
            i4 = !h() ? i3 : i10;
        } else {
        }
        aVar.d(5, i4);
        if (!O().q()) {
            if (!e0() && g0()) {
                if (g0()) {
                    if (q() && !h()) {
                        i7 = !h() ? i3 : i10;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        aVar.d(6, i7);
        if (d0() && !h()) {
            i5 = !h() ? i3 : i10;
        } else {
        }
        aVar.d(7, i5);
        if (!O().q()) {
            if (!d0()) {
                if (g0() && f0() && !h()) {
                    if (f0()) {
                        i2 = !h() ? i3 : i10;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        aVar.d(8, i2);
        aVar.d(9, z8 ^= i3);
        if (q() && !h()) {
            i = !h() ? i3 : i10;
        } else {
        }
        aVar.d(10, i);
        if (q() && !h()) {
            if (!h()) {
            } else {
                i3 = i10;
            }
        } else {
        }
        aVar.d(11, i3);
        return aVar.e();
    }

    @Override // com.google.android.exoplayer2.v1
    public final int b0() {
        int i;
        boolean z2;
        int i2;
        boolean z;
        com.google.android.exoplayer2.g2 g2Var = O();
        if (g2Var.q()) {
            i = -1;
        } else {
            i = g2Var.l(x(), c0(), Q());
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.v1
    public final long c() {
        long l;
        boolean z;
        com.google.android.exoplayer2.g2.c cVar;
        com.google.android.exoplayer2.g2 g2Var = O();
        if (g2Var.q()) {
            l = -9223372036854775807L;
        } else {
            l = g2Var.n(x(), this.a).d();
        }
        return l;
    }

    @Override // com.google.android.exoplayer2.v1
    public final boolean d0() {
        int i;
        i = a0() != -1 ? 1 : 0;
        return i;
    }

    @Override // com.google.android.exoplayer2.v1
    public final boolean e0() {
        int i;
        i = b0() != -1 ? 1 : 0;
        return i;
    }

    @Override // com.google.android.exoplayer2.v1
    public final boolean f0() {
        com.google.android.exoplayer2.g2 g2Var;
        int i;
        boolean z;
        com.google.android.exoplayer2.g2.c cVar;
        g2Var = O();
        if (!g2Var.q() && cVar2.i) {
            i = cVar2.i ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.v1
    public final boolean g0() {
        com.google.android.exoplayer2.g2 g2Var;
        int i;
        boolean z;
        com.google.android.exoplayer2.g2.c cVar;
        g2Var = O();
        if (!g2Var.q() && g2Var.n(x(), this.a).f()) {
            i = g2Var.n(x(), this.a).f() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.v1
    public final void h0() {
        i0(x());
    }

    @Override // com.google.android.exoplayer2.v1
    public final void i0(int i) {
        j(i, -9223372036854775807L);
    }

    @Override // com.google.android.exoplayer2.v1
    public final void j0() {
        final int i = a0();
        if (i != -1) {
            i0(i);
        }
    }

    @Override // com.google.android.exoplayer2.v1
    public final void l0() {
        final int i = b0();
        if (i != -1) {
            i0(i);
        }
    }

    @Override // com.google.android.exoplayer2.v1
    public final boolean q() {
        com.google.android.exoplayer2.g2 g2Var;
        int i;
        boolean z;
        com.google.android.exoplayer2.g2.c cVar;
        g2Var = O();
        if (!g2Var.q() && cVar2.h) {
            i = cVar2.h ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.v1
    public final void stop() {
        n(false);
    }

    @Override // com.google.android.exoplayer2.v1
    public final void w(long l) {
        j(x(), l);
    }

    @Override // com.google.android.exoplayer2.v1
    public final void y() {
        boolean cmp;
        boolean z;
        long l;
        if (!O().q()) {
            if (h()) {
            } else {
                cmp = e0();
                if (g0() && !q()) {
                    if (!q()) {
                        if (cmp) {
                            l0();
                        }
                    } else {
                        if (cmp && Long.compare(l2, l) <= 0) {
                            if (Long.compare(l2, l) <= 0) {
                                l0();
                            } else {
                                w(0);
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        }
    }
}
