package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class e2 extends com.google.android.gms.internal.measurement.u2 {

    final com.google.android.gms.internal.measurement.b1 w;
    final com.google.android.gms.internal.measurement.g3 x;
    e2(com.google.android.gms.internal.measurement.g3 g3, com.google.android.gms.internal.measurement.b1 b12) {
        this.x = g3;
        this.w = b12;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.x);
        r.j(f1Var);
        (f1)f1Var.generateEventId(this.w);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    protected final void b() {
        this.w.c(0);
    }
}
