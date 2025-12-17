package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class o9 extends com.google.android.gms.measurement.internal.n {

    final com.google.android.gms.measurement.internal.p9 e;
    o9(com.google.android.gms.measurement.internal.p9 p9, com.google.android.gms.measurement.internal.x5 x52) {
        this.e = p9;
        super(x52);
    }

    @Override // com.google.android.gms.measurement.internal.n
    public final void c() {
        this.e.m();
        p9Var2.a.b().v().a("Starting upload from DelayedRunnable");
        p9Var3.b.A();
    }
}
