package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class r5 implements Callable<List<com.google.android.gms.measurement.internal.ga>> {

    final String a;
    final com.google.android.gms.measurement.internal.u5 b;
    r5(com.google.android.gms.measurement.internal.u5 u5, String string2) {
        this.b = u5;
        this.a = string2;
        super();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        u5.q2(this.b).e();
        return u5.q2(this.b).U().e0(this.a);
    }
}
