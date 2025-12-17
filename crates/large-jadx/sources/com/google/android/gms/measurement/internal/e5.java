package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class e5 implements Runnable {

    final com.google.android.gms.measurement.internal.c a;
    final com.google.android.gms.measurement.internal.u5 b;
    e5(com.google.android.gms.measurement.internal.u5 u5, com.google.android.gms.measurement.internal.c c2) {
        this.b = u5;
        this.a = c2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        u5.q2(this.b).e();
        if (cVar.c.j2() == null) {
            u5.q2(this.b).r(this.a);
        }
        u5.q2(this.b).w(this.a);
    }
}
