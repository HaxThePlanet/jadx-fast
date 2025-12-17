package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.de;

/* loaded from: classes2.dex */
final class n5 implements Runnable {

    final com.google.android.gms.measurement.internal.u a;
    final com.google.android.gms.measurement.internal.na b;
    final com.google.android.gms.measurement.internal.u5 c;
    n5(com.google.android.gms.measurement.internal.u5 u5, com.google.android.gms.measurement.internal.u u2, com.google.android.gms.measurement.internal.na na3) {
        this.c = u5;
        this.a = u2;
        this.b = na3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.measurement.internal.u uVar = this.c.p2(this.a, this.b);
        de.b();
        if (u5.q2(this.c).S().B(0, c3.r0)) {
            this.c.s2(uVar, this.b);
        }
        u5.r2(this.c, uVar, this.b);
    }
}
