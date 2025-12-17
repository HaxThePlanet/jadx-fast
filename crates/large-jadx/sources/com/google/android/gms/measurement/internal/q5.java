package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class q5 implements Runnable {

    final com.google.android.gms.measurement.internal.ea a;
    final com.google.android.gms.measurement.internal.na b;
    final com.google.android.gms.measurement.internal.u5 c;
    q5(com.google.android.gms.measurement.internal.u5 u5, com.google.android.gms.measurement.internal.ea ea2, com.google.android.gms.measurement.internal.na na3) {
        this.c = u5;
        this.a = ea2;
        this.b = na3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        u5.q2(this.c).e();
        if (this.a.j2() == null) {
            u5.q2(this.c).t(this.a, this.b);
        }
        u5.q2(this.c).z(this.a, this.b);
    }
}
