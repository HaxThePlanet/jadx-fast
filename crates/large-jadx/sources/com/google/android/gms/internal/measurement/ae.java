package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ae implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.be> {

    private static final com.google.android.gms.internal.measurement.ae b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.be> a;
    static {
        ae aeVar = new ae();
        ae.b = aeVar;
    }

    public ae() {
        ce ceVar = new ce();
        super();
        this.a = i7.a(i7.b(ceVar));
    }

    public static double a() {
        return ae.b.d().zza();
    }

    public static long b() {
        return ae.b.d().zzb();
    }

    public static long c() {
        return ae.b.d().zzc();
    }

    public static String e() {
        return ae.b.d().b();
    }

    public static boolean f() {
        return ae.b.d().a();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.be d() {
        return (be)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return d();
    }
}
