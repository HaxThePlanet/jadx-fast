package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class wc implements com.google.android.gms.internal.measurement.vc {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> b;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        final int i = 1;
        wc.a = t6Var.e("measurement.client.consent.suppress_1p_in_ga4f_install", i);
        wc.b = t6Var.e("measurement.client.consent.gmpappid_worker_thread_fix", i);
    }

    @Override // com.google.android.gms.internal.measurement.vc
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.vc
    public final boolean zzb() {
        return (Boolean)wc.a.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.vc
    public final boolean zzc() {
        return (Boolean)wc.b.b().booleanValue();
    }
}
