package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class m2 extends com.google.android.gms.internal.measurement.u2 {

    final com.google.android.gms.internal.measurement.b1 w;
    final int x;
    final com.google.android.gms.internal.measurement.g3 y;
    m2(com.google.android.gms.internal.measurement.g3 g3, com.google.android.gms.internal.measurement.b1 b12, int i3) {
        this.y = g3;
        this.w = b12;
        this.x = i3;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.y);
        r.j(f1Var);
        (f1)f1Var.getTestFlag(this.w, this.x);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    protected final void b() {
        this.w.c(0);
    }
}
