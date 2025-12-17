package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamic.b;

/* loaded from: classes2.dex */
final class d3 extends com.google.android.gms.internal.measurement.u2 {

    final Activity w;
    final com.google.android.gms.internal.measurement.b1 x;
    final com.google.android.gms.internal.measurement.f3 y;
    d3(com.google.android.gms.internal.measurement.f3 f3, Activity activity2, com.google.android.gms.internal.measurement.b1 b13) {
        this.y = f3;
        this.w = activity2;
        this.x = b13;
        super(f3.a, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(f3Var.a);
        r.j(f1Var);
        (f1)f1Var.onActivitySaveInstanceState(b.p2(this.w), this.x, this.b);
    }
}
