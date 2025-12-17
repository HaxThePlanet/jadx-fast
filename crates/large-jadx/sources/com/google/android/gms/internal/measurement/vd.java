package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class vd implements com.google.android.gms.internal.measurement.ud {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        vd.a = t6Var.e("measurement.validation.internal_limits_internal_event_params", false);
        t6Var.c("measurement.id.validation.internal_limits_internal_event_params", 0);
    }

    @Override // com.google.android.gms.internal.measurement.ud
    public final boolean zza() {
        return (Boolean)vd.a.b().booleanValue();
    }
}
