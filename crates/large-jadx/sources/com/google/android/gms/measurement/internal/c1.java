package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class c1 implements Runnable {

    final long a;
    final com.google.android.gms.measurement.internal.d2 b;
    c1(com.google.android.gms.measurement.internal.d2 d2, long l2) {
        this.b = d2;
        this.a = l2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        d2.k(this.b, this.a);
    }
}
