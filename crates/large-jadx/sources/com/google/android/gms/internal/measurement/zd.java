package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zd implements com.google.android.gms.internal.measurement.xd {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        zd.a = t6Var.e("measurement.config.persist_last_modified", true);
    }

    @Override // com.google.android.gms.internal.measurement.xd
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.xd
    public final boolean zzb() {
        return (Boolean)zd.a.b().booleanValue();
    }
}
