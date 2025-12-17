package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class q2 extends com.google.android.gms.internal.measurement.u2 {

    final com.google.android.gms.internal.measurement.w2 w;
    final com.google.android.gms.internal.measurement.g3 x;
    q2(com.google.android.gms.internal.measurement.g3 g3, com.google.android.gms.internal.measurement.w2 w22) {
        this.x = g3;
        this.w = w22;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.x);
        r.j(f1Var);
        (f1)f1Var.registerOnMeasurementEventListener(this.w);
    }
}
