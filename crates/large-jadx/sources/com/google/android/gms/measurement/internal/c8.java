package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class c8 implements Runnable {

    final com.google.android.gms.measurement.internal.na a;
    final com.google.android.gms.measurement.internal.w8 b;
    c8(com.google.android.gms.measurement.internal.w8 w8, com.google.android.gms.measurement.internal.na na2) {
        this.b = w8;
        this.a = na2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.b);
        if (g3Var == null) {
            w8Var2.a.b().r().a("Discarding data. Failed to send app launch");
        }
        r.j(this.a);
        g3Var.q0(this.a);
        w8Var5.a.C().t();
        this.b.r(g3Var, 0, this.a);
        w8.N(this.b);
    }
}
