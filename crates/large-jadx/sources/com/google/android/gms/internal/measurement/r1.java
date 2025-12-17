package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class r1 extends com.google.android.gms.internal.measurement.u2 {

    final String w;
    final String x;
    final Bundle y;
    final com.google.android.gms.internal.measurement.g3 z;
    r1(com.google.android.gms.internal.measurement.g3 g3, String string2, String string3, Bundle bundle4) {
        this.z = g3;
        this.w = string2;
        this.x = string3;
        this.y = bundle4;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.z);
        r.j(f1Var);
        (f1)f1Var.clearConditionalUserProperty(this.w, this.x, this.y);
    }
}
