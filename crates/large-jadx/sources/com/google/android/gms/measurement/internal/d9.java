package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class d9 implements Runnable {

    final long a;
    final com.google.android.gms.measurement.internal.m9 b;
    d9(com.google.android.gms.measurement.internal.m9 m9, long l2) {
        this.b = m9;
        this.a = l2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        m9.r(this.b, this.a);
    }
}
