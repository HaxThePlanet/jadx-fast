package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class y7 implements Runnable {

    final com.google.android.gms.measurement.internal.na a;
    final boolean b;
    final com.google.android.gms.measurement.internal.ea c;
    final com.google.android.gms.measurement.internal.w8 v;
    y7(com.google.android.gms.measurement.internal.w8 w8, com.google.android.gms.measurement.internal.na na2, boolean z3, com.google.android.gms.measurement.internal.ea ea4) {
        this.v = w8;
        this.a = na2;
        this.b = z3;
        this.c = ea4;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.v);
        if (g3Var == null) {
            w8Var2.a.b().r().a("Discarding data. Failed to set user property");
        }
        r.j(this.a);
        i = this.b ? 0 : this.c;
        this.v.r(g3Var, i, this.a);
        w8.N(this.v);
    }
}
