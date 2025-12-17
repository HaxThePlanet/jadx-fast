package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class tc implements com.google.android.gms.internal.measurement.sc {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        tc.a = t6Var.e("measurement.client.firebase_feature_rollout.v1.enable", true);
    }

    @Override // com.google.android.gms.internal.measurement.sc
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.sc
    public final boolean zzb() {
        return (Boolean)tc.a.b().booleanValue();
    }
}
