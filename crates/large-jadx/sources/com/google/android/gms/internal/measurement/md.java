package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class md implements com.google.android.gms.internal.measurement.ld {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        md.a = t6Var.e("measurement.ga.ga_app_id", false);
    }

    @Override // com.google.android.gms.internal.measurement.ld
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.ld
    public final boolean zzb() {
        return (Boolean)md.a.b().booleanValue();
    }
}
