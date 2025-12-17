package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamic.b;

/* loaded from: classes2.dex */
final class u1 extends com.google.android.gms.internal.measurement.u2 {

    final Activity w;
    final String x;
    final String y;
    final com.google.android.gms.internal.measurement.g3 z;
    u1(com.google.android.gms.internal.measurement.g3 g3, Activity activity2, String string3, String string4) {
        this.z = g3;
        this.w = activity2;
        this.x = string3;
        this.y = string4;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.z);
        r.j(f1Var);
        (f1)f1Var.setCurrentScreen(b.p2(this.w), this.x, this.y, this.a);
    }
}
