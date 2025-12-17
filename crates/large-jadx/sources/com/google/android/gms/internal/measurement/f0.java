package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class f0 implements com.google.android.gms.internal.measurement.h0 {

    private final com.google.android.gms.internal.measurement.b5 a;
    private final String b;
    public f0(com.google.android.gms.internal.measurement.b5 b5, String string2) {
        super();
        this.a = b5;
        this.b = string2;
    }

    @Override // com.google.android.gms.internal.measurement.h0
    public final com.google.android.gms.internal.measurement.b5 a(com.google.android.gms.internal.measurement.q q) {
        com.google.android.gms.internal.measurement.b5 b5Var2 = this.a.a();
        b5Var2.f(this.b, q);
        return b5Var2;
    }
}
