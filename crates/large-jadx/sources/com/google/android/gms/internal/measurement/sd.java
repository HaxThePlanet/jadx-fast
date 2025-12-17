package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class sd implements com.google.android.gms.internal.measurement.rd {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> b;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        final int i = 0;
        t6Var.c("measurement.id.lifecycle.app_in_background_parameter", i);
        final int i2 = 0;
        sd.a = t6Var.e("measurement.lifecycle.app_backgrounded_engagement", i2);
        t6Var.e("measurement.lifecycle.app_backgrounded_tracking", true);
        sd.b = t6Var.e("measurement.lifecycle.app_in_background_parameter", i2);
        t6Var.c("measurement.id.lifecycle.app_backgrounded_tracking", i);
    }

    @Override // com.google.android.gms.internal.measurement.rd
    public final boolean zza() {
        return (Boolean)sd.a.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.rd
    public final boolean zzb() {
        return (Boolean)sd.b.b().booleanValue();
    }
}
