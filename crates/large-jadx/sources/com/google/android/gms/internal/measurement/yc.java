package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class yc implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.zc> {

    private static final com.google.android.gms.internal.measurement.yc b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.zc> a;
    static {
        yc ycVar = new yc();
        yc.b = ycVar;
    }

    public yc() {
        ad adVar = new ad();
        super();
        this.a = i7.a(i7.b(adVar));
    }

    public static boolean b() {
        yc.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return yc.b.a().zzb();
    }

    public static boolean d() {
        return yc.b.a().zzc();
    }

    public static boolean e() {
        return yc.b.a().b();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.zc a() {
        return (zc)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
