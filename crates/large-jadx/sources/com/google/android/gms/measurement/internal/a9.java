package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class a9 implements Runnable {

    final com.google.android.gms.measurement.internal.ba a;
    final Runnable b;
    a9(com.google.android.gms.measurement.internal.c9 c9, com.google.android.gms.measurement.internal.ba ba2, Runnable runnable3) {
        this.a = ba2;
        this.b = runnable3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e();
        this.a.j0(this.b);
        this.a.A();
    }
}
