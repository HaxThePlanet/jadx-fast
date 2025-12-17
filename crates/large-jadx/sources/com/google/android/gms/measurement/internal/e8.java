package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class e8 implements Runnable {

    final com.google.android.gms.measurement.internal.na a;
    final Bundle b;
    final com.google.android.gms.measurement.internal.w8 c;
    e8(com.google.android.gms.measurement.internal.w8 w8, com.google.android.gms.measurement.internal.na na2, Bundle bundle3) {
        this.c = w8;
        this.a = na2;
        this.b = bundle3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.c);
        if (g3Var == null) {
            w8Var2.a.b().r().a("Failed to send default event parameters to service");
        }
        r.j(this.a);
        g3Var.t(this.b, this.a);
    }
}
