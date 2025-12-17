package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class f8 extends com.google.android.gms.measurement.internal.n {

    final com.google.android.gms.measurement.internal.w8 e;
    f8(com.google.android.gms.measurement.internal.w8 w8, com.google.android.gms.measurement.internal.x5 x52) {
        this.e = w8;
        super(x52);
    }

    @Override // com.google.android.gms.measurement.internal.n
    public final void c() {
        final com.google.android.gms.measurement.internal.w8 w8Var = this.e;
        w8Var.h();
        if (!w8Var.z()) {
        }
        w8Var.a.b().v().a("Inactivity, disconnecting from the service");
        w8Var.Q();
    }
}
