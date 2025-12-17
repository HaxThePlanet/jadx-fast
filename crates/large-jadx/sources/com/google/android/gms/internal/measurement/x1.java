package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class x1 extends com.google.android.gms.internal.measurement.u2 {

    final com.google.android.gms.internal.measurement.g3 w;
    x1(com.google.android.gms.internal.measurement.g3 g3) {
        this.w = g3;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.w);
        r.j(f1Var);
        (f1)f1Var.resetAnalyticsData(this.a);
    }
}
