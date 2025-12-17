package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class xe implements com.google.android.gms.internal.measurement.we {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        xe.a = t6Var.e("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true);
    }

    @Override // com.google.android.gms.internal.measurement.we
    public final boolean zza() {
        return (Boolean)xe.a.b().booleanValue();
    }
}
