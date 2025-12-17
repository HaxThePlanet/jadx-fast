package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class y1 extends com.google.android.gms.internal.measurement.u2 {

    final long w;
    final com.google.android.gms.internal.measurement.g3 x;
    y1(com.google.android.gms.internal.measurement.g3 g3, long l2) {
        this.x = g3;
        this.w = l2;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.x);
        r.j(f1Var);
        (f1)f1Var.setSessionTimeoutDuration(this.w);
    }
}
