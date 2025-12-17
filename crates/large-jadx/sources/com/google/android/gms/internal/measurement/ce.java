package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ce implements com.google.android.gms.internal.measurement.be {

    public static final com.google.android.gms.internal.measurement.w6<Boolean> a;
    public static final com.google.android.gms.internal.measurement.w6<Double> b;
    public static final com.google.android.gms.internal.measurement.w6<Long> c;
    public static final com.google.android.gms.internal.measurement.w6<Long> d;
    public static final com.google.android.gms.internal.measurement.w6<String> e;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        ce.a = t6Var.e("measurement.test.boolean_flag", false);
        ce.b = t6Var.b("measurement.test.double_flag", -4609434218613702656L);
        ce.c = t6Var.c("measurement.test.int_flag", -2);
        ce.d = t6Var.c("measurement.test.long_flag", -1);
        ce.e = t6Var.d("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean a() {
        return (Boolean)ce.a.b().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final String b() {
        return (String)ce.e.b();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final double zza() {
        return (Double)ce.b.b().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final long zzb() {
        return (Long)ce.c.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final long zzc() {
        return (Long)ce.d.b().longValue();
    }
}
