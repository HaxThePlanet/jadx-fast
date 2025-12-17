package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class bf implements com.google.android.gms.internal.measurement.af {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        bf.a = t6Var.e("measurement.collection.service.update_with_analytics_fix", false);
    }

    @Override // com.google.android.gms.internal.measurement.af
    public final boolean zza() {
        return (Boolean)bf.a.b().booleanValue();
    }
}
