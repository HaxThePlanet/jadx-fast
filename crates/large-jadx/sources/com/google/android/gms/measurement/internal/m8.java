package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class m8 implements Runnable {

    final com.google.android.gms.measurement.internal.na a;
    final boolean b;
    final com.google.android.gms.measurement.internal.c c;
    final com.google.android.gms.measurement.internal.w8 v;
    m8(com.google.android.gms.measurement.internal.w8 w8, boolean z2, com.google.android.gms.measurement.internal.na na3, boolean z4, com.google.android.gms.measurement.internal.c c5, com.google.android.gms.measurement.internal.c c6) {
        this.v = w8;
        this.a = na3;
        this.b = z4;
        this.c = c5;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.v);
        if (g3Var == null) {
            w8Var2.a.b().r().a("Discarding data. Failed to send conditional user property to service");
        }
        r.j(this.a);
        i = this.b ? 0 : this.c;
        this.v.r(g3Var, i, this.a);
        w8.N(this.v);
    }
}
