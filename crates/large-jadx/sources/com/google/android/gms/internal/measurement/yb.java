package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class yb implements com.google.android.gms.internal.measurement.xb {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        yb.a = t6Var.e("measurement.client.click_identifier_control.dev", false);
    }

    @Override // com.google.android.gms.internal.measurement.xb
    public final boolean zza() {
        return (Boolean)yb.a.b().booleanValue();
    }
}
