package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class e9 implements Runnable {

    final long a;
    final com.google.android.gms.measurement.internal.m9 b;
    e9(com.google.android.gms.measurement.internal.m9 m9, long l2) {
        this.b = m9;
        this.a = l2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        m9.q(this.b, this.a);
    }
}
