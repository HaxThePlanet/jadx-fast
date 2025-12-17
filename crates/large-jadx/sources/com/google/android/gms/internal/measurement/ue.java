package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ue implements com.google.android.gms.internal.measurement.te {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        ue.a = t6Var.e("measurement.integration.disable_firebase_instance_id", false);
    }

    @Override // com.google.android.gms.internal.measurement.te
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.te
    public final boolean zzb() {
        return (Boolean)ue.a.b().booleanValue();
    }
}
