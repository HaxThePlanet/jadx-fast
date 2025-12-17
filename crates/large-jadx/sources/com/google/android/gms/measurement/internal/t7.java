package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class t7 implements Runnable {

    final long a;
    final com.google.android.gms.measurement.internal.w7 b;
    t7(com.google.android.gms.measurement.internal.w7 w7, long l2) {
        this.b = w7;
        this.a = l2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        w7Var.a.y().n(this.a);
        w7Var2.e = 0;
    }
}
