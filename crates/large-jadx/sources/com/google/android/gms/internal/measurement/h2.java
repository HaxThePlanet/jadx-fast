package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class h2 extends com.google.android.gms.internal.measurement.u2 {

    final com.google.android.gms.internal.measurement.g3 A;
    final String w;
    final String x;
    final boolean y;
    final com.google.android.gms.internal.measurement.b1 z;
    h2(com.google.android.gms.internal.measurement.g3 g3, String string2, String string3, boolean z4, com.google.android.gms.internal.measurement.b1 b15) {
        this.A = g3;
        this.w = string2;
        this.x = string3;
        this.y = z4;
        this.z = b15;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.A);
        r.j(f1Var);
        (f1)f1Var.getUserProperties(this.w, this.x, this.y, this.z);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    protected final void b() {
        this.z.c(0);
    }
}
