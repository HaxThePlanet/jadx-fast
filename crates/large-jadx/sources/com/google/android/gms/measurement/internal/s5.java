package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class s5 implements Runnable {

    final com.google.android.gms.measurement.internal.na a;
    final com.google.android.gms.measurement.internal.u5 b;
    s5(com.google.android.gms.measurement.internal.u5 u5, com.google.android.gms.measurement.internal.na na2) {
        this.b = u5;
        this.a = na2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        u5.q2(this.b).e();
        u5.q2(this.b).p(this.a);
    }
}
