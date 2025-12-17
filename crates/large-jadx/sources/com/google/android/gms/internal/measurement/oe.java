package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class oe implements com.google.android.gms.internal.measurement.ne {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        oe.a = t6Var.a().e("measurement.service.refactor.package_side_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.ne
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.ne
    public final boolean zzb() {
        return (Boolean)oe.a.b().booleanValue();
    }
}
