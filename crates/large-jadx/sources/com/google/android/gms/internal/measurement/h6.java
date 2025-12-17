package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class h6 implements com.google.android.gms.internal.measurement.f6 {

    public final com.google.android.gms.internal.measurement.j6 a;
    public final String b;
    public h6(com.google.android.gms.internal.measurement.j6 j6, String string2) {
        super();
        this.a = j6;
        this.b = string2;
    }

    @Override // com.google.android.gms.internal.measurement.f6
    public final Object zza() {
        return this.a.d(this.b);
    }
}
