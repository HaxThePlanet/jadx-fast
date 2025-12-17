package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class k2 extends com.google.android.gms.internal.measurement.u2 {

    final String w;
    final com.google.android.gms.internal.measurement.b1 x;
    final com.google.android.gms.internal.measurement.g3 y;
    k2(com.google.android.gms.internal.measurement.g3 g3, String string2, com.google.android.gms.internal.measurement.b1 b13) {
        this.y = g3;
        this.w = string2;
        this.x = b13;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.y);
        r.j(f1Var);
        (f1)f1Var.getMaxUserProperties(this.w, this.x);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    protected final void b() {
        this.x.c(0);
    }
}
