package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class re implements com.google.android.gms.internal.measurement.qe {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        re.a = t6Var.e("measurement.collection.synthetic_data_mitigation", false);
    }

    @Override // com.google.android.gms.internal.measurement.qe
    public final boolean zza() {
        return (Boolean)re.a.b().booleanValue();
    }
}
