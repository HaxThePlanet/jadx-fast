package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class q8 implements Runnable {

    final com.google.android.gms.measurement.internal.g3 a;
    final com.google.android.gms.measurement.internal.v8 b;
    q8(com.google.android.gms.measurement.internal.v8 v8, com.google.android.gms.measurement.internal.g3 g32) {
        this.b = v8;
        this.a = g32;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        int i;
        final com.google.android.gms.measurement.internal.v8 v8Var = this.b;
        v8.a(this.b, false);
        synchronized (v8Var) {
            w8Var2.a.b().v().a("Connected to service");
            v8Var5.c.x(this.a);
        }
    }
}
