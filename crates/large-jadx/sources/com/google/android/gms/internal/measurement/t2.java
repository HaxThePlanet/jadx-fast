package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamic.b;

/* loaded from: classes2.dex */
final class t2 extends com.google.android.gms.internal.measurement.u2 {

    final com.google.android.gms.internal.measurement.g3 A;
    final String w;
    final String x;
    final Object y;
    final boolean z;
    t2(com.google.android.gms.internal.measurement.g3 g3, String string2, String string3, Object object4, boolean z5) {
        this.A = g3;
        this.w = string2;
        this.x = string3;
        this.y = object4;
        this.z = z5;
        super(g3, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.A);
        r.j(f1Var);
        (f1)f1Var.setUserProperty(this.w, this.x, b.p2(this.y), this.z, this.a);
    }
}
