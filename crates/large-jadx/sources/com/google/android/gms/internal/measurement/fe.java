package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class fe implements com.google.android.gms.internal.measurement.ee {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> b;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        final int i = 1;
        fe.a = t6Var.e("measurement.module.pixie.ees", i);
        fe.b = t6Var.e("measurement.module.pixie.fix_array", i);
    }

    @Override // com.google.android.gms.internal.measurement.ee
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.ee
    public final boolean zzb() {
        return (Boolean)fe.a.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ee
    public final boolean zzc() {
        return (Boolean)fe.b.b().booleanValue();
    }
}
