package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class w1 extends com.google.android.gms.internal.measurement.u2 {

    final Bundle w;
    final com.google.android.gms.internal.measurement.g3 x;
    w1(com.google.android.gms.internal.measurement.g3 g3, Bundle bundle2) {
        this.x = g3;
        this.w = bundle2;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.x);
        r.j(f1Var);
        (f1)f1Var.setConsentThirdParty(this.w, this.a);
    }
}
