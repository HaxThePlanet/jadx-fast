package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class m5 implements Runnable {

    final com.google.android.gms.measurement.internal.na a;
    final com.google.android.gms.measurement.internal.u5 b;
    m5(com.google.android.gms.measurement.internal.u5 u5, com.google.android.gms.measurement.internal.na na2) {
        this.b = u5;
        this.a = na2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        u5.q2(this.b).e();
        com.google.android.gms.measurement.internal.ba baVar2 = u5.q2(this.b);
        final com.google.android.gms.measurement.internal.na naVar = this.a;
        baVar2.a().h();
        baVar2.g();
        r.f(naVar.a);
        com.google.android.gms.measurement.internal.h hVar = h.b(naVar.N);
        baVar2.b().v().c("Setting consent, package, consent", naVar.a, hVar);
        baVar2.y(naVar.a, hVar);
        if (hVar.m(baVar2.T(naVar.a))) {
            baVar2.u(naVar);
        }
    }
}
