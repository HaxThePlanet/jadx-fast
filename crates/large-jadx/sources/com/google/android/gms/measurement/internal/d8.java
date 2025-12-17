package com.google.android.gms.measurement.internal;

import android.content.Context;

/* loaded from: classes2.dex */
final class d8 implements Runnable {

    final com.google.android.gms.measurement.internal.p7 a;
    final com.google.android.gms.measurement.internal.w8 b;
    d8(com.google.android.gms.measurement.internal.w8 w8, com.google.android.gms.measurement.internal.p7 p72) {
        this.b = w8;
        this.a = p72;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        int i3;
        int i;
        int i2;
        String packageName;
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.b);
        if (g3Var == null) {
            w8Var2.a.b().r().a("Failed to send current screen to service");
        }
        com.google.android.gms.measurement.internal.p7 p7Var = this.a;
        if (p7Var == null) {
            g3Var.U0(0, obj3, 0, 0);
        } else {
            g3Var.U0(p7Var.c, obj3, p7Var.a, p7Var.b);
        }
        w8.N(this.b);
    }
}
