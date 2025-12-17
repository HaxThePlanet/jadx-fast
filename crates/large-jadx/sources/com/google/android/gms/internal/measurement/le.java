package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class le implements com.google.android.gms.internal.measurement.ke {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        le.a = t6Var.e("measurement.scheduler.task_thread.cleanup_on_exit", false);
    }

    @Override // com.google.android.gms.internal.measurement.ke
    public final boolean zza() {
        return (Boolean)le.a.b().booleanValue();
    }
}
