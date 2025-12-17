package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class nc implements com.google.android.gms.internal.measurement.mc {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        nc.a = t6Var.e("measurement.config.fix_feature_flags_from_config", true);
    }

    @Override // com.google.android.gms.internal.measurement.mc
    public final boolean zza() {
        return (Boolean)nc.a.b().booleanValue();
    }
}
