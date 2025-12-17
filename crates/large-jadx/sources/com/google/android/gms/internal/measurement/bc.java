package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class bc implements com.google.android.gms.internal.measurement.ac {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        bc.a = t6Var.e("measurement.service.click_identifier_control", false);
    }

    @Override // com.google.android.gms.internal.measurement.ac
    public final boolean zza() {
        return (Boolean)bc.a.b().booleanValue();
    }
}
