package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class v7 implements Runnable {

    final com.google.android.gms.measurement.internal.w7 a;
    v7(com.google.android.gms.measurement.internal.w7 w7) {
        this.a = w7;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        w7.v(this.a, 0);
    }
}
