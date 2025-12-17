package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class s1 extends com.google.android.gms.internal.measurement.u2 {

    final String w;
    final String x;
    final com.google.android.gms.internal.measurement.b1 y;
    final com.google.android.gms.internal.measurement.g3 z;
    s1(com.google.android.gms.internal.measurement.g3 g3, String string2, String string3, com.google.android.gms.internal.measurement.b1 b14) {
        this.z = g3;
        this.w = string2;
        this.x = string3;
        this.y = b14;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.z);
        r.j(f1Var);
        (f1)f1Var.getConditionalUserProperties(this.w, this.x, this.y);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    protected final void b() {
        this.y.c(0);
    }
}
