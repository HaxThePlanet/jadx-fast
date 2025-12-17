package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class rb implements com.google.android.gms.internal.measurement.qb {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> b;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> c;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> d;
    public static final com.google.android.gms.internal.measurement.w6<Boolean> e;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        com.google.android.gms.internal.measurement.t6 t6Var2 = t6Var.a();
        final int i = 1;
        rb.a = t6Var2.e("measurement.adid_zero.app_instance_id_fix", i);
        int i2 = 0;
        rb.b = t6Var2.e("measurement.adid_zero.service", i2);
        rb.c = t6Var2.e("measurement.adid_zero.adid_uid", i2);
        t6Var2.c("measurement.id.adid_zero.service", 0);
        rb.d = t6Var2.e("measurement.adid_zero.remove_lair_if_adidzero_false", i);
        rb.e = t6Var2.e("measurement.adid_zero.remove_lair_if_userid_cleared", i);
    }

    @Override // com.google.android.gms.internal.measurement.qb
    public final boolean a() {
        return (Boolean)rb.d.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qb
    public final boolean b() {
        return (Boolean)rb.c.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qb
    public final boolean c() {
        return (Boolean)rb.e.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qb
    public final boolean zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.qb
    public final boolean zzb() {
        return (Boolean)rb.a.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qb
    public final boolean zzc() {
        return (Boolean)rb.b.b().booleanValue();
    }
}
