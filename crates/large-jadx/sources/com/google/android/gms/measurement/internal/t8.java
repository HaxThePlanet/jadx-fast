package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes2.dex */
final class t8 implements Runnable {

    final com.google.android.gms.measurement.internal.v8 a;
    t8(com.google.android.gms.measurement.internal.v8 v8) {
        this.a = v8;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.measurement.internal.w8 w8Var = v8Var.c;
        w8Var2.a.d();
        ComponentName componentName = new ComponentName(w8Var.a.f(), "com.google.android.gms.measurement.AppMeasurementService");
        w8.M(w8Var, componentName);
    }
}
