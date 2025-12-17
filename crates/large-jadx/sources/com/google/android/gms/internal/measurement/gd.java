package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class gd implements com.google.android.gms.internal.measurement.fd {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        t6Var.e("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        gd.a = t6Var.e("measurement.collection.redundant_engagement_removal_enabled", false);
        t6Var.c("measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }

    @Override // com.google.android.gms.internal.measurement.fd
    public final boolean zza() {
        return (Boolean)gd.a.b().booleanValue();
    }
}
