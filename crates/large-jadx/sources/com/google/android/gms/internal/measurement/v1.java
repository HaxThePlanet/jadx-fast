package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class v1 extends com.google.android.gms.internal.measurement.u2 {

    final Boolean w;
    final com.google.android.gms.internal.measurement.g3 x;
    v1(com.google.android.gms.internal.measurement.g3 g3, Boolean boolean2) {
        this.x = g3;
        this.w = boolean2;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        if (this.w != null) {
            com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.x);
            r.j(f1Var);
            (f1)f1Var.setMeasurementEnabled(this.w.booleanValue(), this.a);
        }
        com.google.android.gms.internal.measurement.f1 f1Var2 = g3.y(this.x);
        r.j(f1Var2);
        (f1)f1Var2.clearMeasurementEnabled(this.a);
    }
}
