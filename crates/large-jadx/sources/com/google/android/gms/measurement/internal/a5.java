package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class a5 implements Runnable {

    final com.google.android.gms.measurement.internal.f6 a;
    final com.google.android.gms.measurement.internal.b5 b;
    a5(com.google.android.gms.measurement.internal.b5 b5, com.google.android.gms.measurement.internal.f6 f62) {
        this.b = b5;
        this.a = f62;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        b5.e(this.b, this.a);
        this.b.m(f6Var2.g);
    }
}
