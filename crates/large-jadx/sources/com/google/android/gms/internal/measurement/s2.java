package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class s2 extends com.google.android.gms.internal.measurement.u2 {

    final boolean A;
    final boolean B;
    final com.google.android.gms.internal.measurement.g3 C;
    final Long w;
    final String x;
    final String y;
    final Bundle z;
    s2(com.google.android.gms.internal.measurement.g3 g3, Long long2, String string3, String string4, Bundle bundle5, boolean z6, boolean z7) {
        this.C = g3;
        this.w = long2;
        this.x = string3;
        this.y = string4;
        this.z = bundle5;
        this.A = z6;
        this.B = z7;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        long longValue;
        Long num = this.w;
        if (num == null) {
            longValue = this.a;
        } else {
            longValue = num.longValue();
        }
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.C);
        r.j(f1Var);
        (f1)f1Var.logEvent(this.x, this.y, this.z, this.A, this.B, longValue);
    }
}
