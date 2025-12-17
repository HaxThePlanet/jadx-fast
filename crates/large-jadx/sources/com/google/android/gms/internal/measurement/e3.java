package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamic.b;

/* loaded from: classes2.dex */
final class e3 extends com.google.android.gms.internal.measurement.u2 {

    final Activity w;
    final com.google.android.gms.internal.measurement.f3 x;
    e3(com.google.android.gms.internal.measurement.f3 f3, Activity activity2) {
        this.x = f3;
        this.w = activity2;
        super(f3.a, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(f3Var.a);
        r.j(f1Var);
        (f1)f1Var.onActivityDestroyed(b.p2(this.w), this.b);
    }
}
