package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class s7 implements Runnable {

    final com.google.android.gms.measurement.internal.w7 a;
    s7(com.google.android.gms.measurement.internal.w7 w7) {
        this.a = w7;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        final com.google.android.gms.measurement.internal.w7 w7Var = this.a;
        w7Var.e = w7.r(w7Var);
    }
}
