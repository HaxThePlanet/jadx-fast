package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class o5 implements Runnable {

    final com.google.android.gms.measurement.internal.u a;
    final String b;
    final com.google.android.gms.measurement.internal.u5 c;
    o5(com.google.android.gms.measurement.internal.u5 u5, com.google.android.gms.measurement.internal.u u2, String string3) {
        this.c = u5;
        this.a = u2;
        this.b = string3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        u5.q2(this.c).e();
        u5.q2(this.c).j(this.a, this.b);
    }
}
