package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class z7 implements Runnable {

    final com.google.android.gms.measurement.internal.na a;
    final com.google.android.gms.measurement.internal.w8 b;
    z7(com.google.android.gms.measurement.internal.w8 w8, com.google.android.gms.measurement.internal.na na2) {
        this.b = w8;
        this.a = na2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.measurement.internal.g3 g3Var;
        com.google.android.gms.measurement.internal.na naVar;
        String str;
        g3Var = w8.H(this.b);
        if (g3Var == null) {
            w8Var2.a.b().r().a("Failed to reset data on the service: not connected to service");
        }
        r.j(this.a);
        g3Var.J(this.a);
        w8.N(this.b);
    }
}
