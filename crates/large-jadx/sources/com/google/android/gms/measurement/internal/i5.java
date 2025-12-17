package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class i5 implements Callable<List<com.google.android.gms.measurement.internal.c>> {

    final String a;
    final String b;
    final String c;
    final com.google.android.gms.measurement.internal.u5 v;
    i5(com.google.android.gms.measurement.internal.u5 u5, String string2, String string3, String string4) {
        this.v = u5;
        this.a = string2;
        this.b = string3;
        this.c = string4;
        super();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        u5.q2(this.v).e();
        return u5.q2(this.v).U().c0(this.a, this.b, this.c);
    }
}
