package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class dd implements com.google.android.gms.internal.measurement.cd {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        final int i = 1;
        dd.a = t6Var.e("measurement.client.sessions.check_on_reset_and_enable2", i);
        t6Var.e("measurement.client.sessions.check_on_startup", i);
        t6Var.e("measurement.client.sessions.start_session_before_view_screen", i);
    }

    @Override // com.google.android.gms.internal.measurement.cd
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.cd
    public final boolean zzb() {
        return (Boolean)dd.a.b().booleanValue();
    }
}
