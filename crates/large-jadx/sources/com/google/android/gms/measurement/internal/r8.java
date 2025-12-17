package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes2.dex */
final class r8 implements Runnable {

    final ComponentName a;
    final com.google.android.gms.measurement.internal.v8 b;
    r8(com.google.android.gms.measurement.internal.v8 v8, ComponentName componentName2) {
        this.b = v8;
        this.a = componentName2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        w8.M(v8Var.c, this.a);
    }
}
