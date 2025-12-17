package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class hc implements com.google.android.gms.internal.measurement.gc {

    public static final com.google.android.gms.internal.measurement.w6<Long> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        int i = 1;
        t6Var.e("measurement.client.consent_state_v1", i);
        t6Var.e("measurement.client.3p_consent_state_v1", i);
        t6Var.e("measurement.service.consent_state_v1_W36", i);
        hc.a = t6Var.c("measurement.service.storage_consent_support_version", 203600);
    }

    @Override // com.google.android.gms.internal.measurement.gc
    public final long zza() {
        return (Long)hc.a.b().longValue();
    }
}
