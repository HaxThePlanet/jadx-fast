package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class p5 implements Callable<byte[]> {

    final com.google.android.gms.measurement.internal.u a;
    final String b;
    final com.google.android.gms.measurement.internal.u5 c;
    p5(com.google.android.gms.measurement.internal.u5 u5, com.google.android.gms.measurement.internal.u u2, String string3) {
        this.c = u5;
        this.a = u2;
        this.b = string3;
        super();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        u5.q2(this.c).e();
        u5.q2(this.c).b0().h();
        b5.t();
        throw 0;
    }
}
