package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class i0 implements com.google.android.gms.internal.measurement.h0 {

    private final com.google.android.gms.internal.measurement.b5 a;
    private final String b;
    public i0(com.google.android.gms.internal.measurement.b5 b5, String string2) {
        super();
        this.a = b5;
        this.b = string2;
    }

    @Override // com.google.android.gms.internal.measurement.h0
    public final com.google.android.gms.internal.measurement.b5 a(com.google.android.gms.internal.measurement.q q) {
        this.a.e(this.b, q);
        return this.a;
    }
}
