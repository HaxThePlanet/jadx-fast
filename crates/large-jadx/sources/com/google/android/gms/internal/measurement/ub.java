package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ub implements com.google.android.gms.internal.measurement.tb {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        ub.a = t6Var.e("measurement.androidId.delete_feature", true);
        t6Var.e("measurement.log_androidId_enabled", false);
    }

    @Override // com.google.android.gms.internal.measurement.tb
    public final boolean zza() {
        return (Boolean)ub.a.b().booleanValue();
    }
}
