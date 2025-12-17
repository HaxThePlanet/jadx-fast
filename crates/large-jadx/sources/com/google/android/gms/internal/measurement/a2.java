package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class a2 extends com.google.android.gms.internal.measurement.u2 {

    final String w;
    final com.google.android.gms.internal.measurement.g3 x;
    a2(com.google.android.gms.internal.measurement.g3 g3, String string2) {
        this.x = g3;
        this.w = string2;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.x);
        r.j(f1Var);
        (f1)f1Var.beginAdUnitExposure(this.w, this.b);
    }
}
