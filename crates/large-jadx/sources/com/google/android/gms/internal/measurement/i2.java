package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamic.b;

/* loaded from: classes2.dex */
final class i2 extends com.google.android.gms.internal.measurement.u2 {

    final String w;
    final Object x;
    final com.google.android.gms.internal.measurement.g3 y;
    i2(com.google.android.gms.internal.measurement.g3 g3, boolean z2, int i3, String string4, Object object5, Object object6, Object object7) {
        this.y = g3;
        this.w = string4;
        this.x = object5;
        super(g3, 0);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(this.y);
        r.j(f1Var);
        int i = 0;
        (f1)f1Var.logHealthData(5, this.w, b.p2(this.x), b.p2(i), b.p2(i));
    }
}
