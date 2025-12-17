package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class qc implements com.google.android.gms.internal.measurement.pc {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        qc.a = t6Var.e("measurement.upload.file_truncate_fix", false);
    }

    @Override // com.google.android.gms.internal.measurement.pc
    public final boolean zza() {
        return (Boolean)qc.a.b().booleanValue();
    }
}
