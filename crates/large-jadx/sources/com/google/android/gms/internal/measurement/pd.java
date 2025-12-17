package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class pd implements com.google.android.gms.internal.measurement.od {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> b;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        int i = 1;
        pd.a = t6Var.e("measurement.sdk.collection.enable_extend_user_property_size", i);
        t6Var.e("measurement.sdk.collection.last_deep_link_referrer2", i);
        pd.b = t6Var.e("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        t6Var.c("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    @Override // com.google.android.gms.internal.measurement.od
    public final boolean zza() {
        return (Boolean)pd.a.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.od
    public final boolean zzb() {
        return (Boolean)pd.b.b().booleanValue();
    }
}
