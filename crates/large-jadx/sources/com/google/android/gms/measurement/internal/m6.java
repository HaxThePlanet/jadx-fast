package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class m6 implements Runnable {

    final long a;
    final com.google.android.gms.measurement.internal.i7 b;
    m6(com.google.android.gms.measurement.internal.i7 i7, long l2) {
        this.b = i7;
        this.a = l2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        g4Var.k.b(this.a);
        i7Var2.a.b().q().b("Session timeout duration set", Long.valueOf(this.a));
    }
}
