package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ie implements com.google.android.gms.internal.measurement.he {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        ie.a = t6Var.e("measurement.collection.log_event_and_bundle_v2", true);
    }

    @Override // com.google.android.gms.internal.measurement.he
    public final boolean zza() {
        return (Boolean)ie.a.b().booleanValue();
    }
}
