package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class kc implements com.google.android.gms.internal.measurement.jc {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        kc.a = t6Var.a().e("measurement.service.event_config_fix", true);
    }

    @Override // com.google.android.gms.internal.measurement.jc
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.jc
    public final boolean zzb() {
        return (Boolean)kc.a.b().booleanValue();
    }
}
