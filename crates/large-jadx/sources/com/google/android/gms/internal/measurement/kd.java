package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class kd implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ld> {

    private static final com.google.android.gms.internal.measurement.kd b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ld> a;
    static {
        kd kdVar = new kd();
        kd.b = kdVar;
    }

    public kd() {
        md mdVar = new md();
        super();
        this.a = i7.a(i7.b(mdVar));
    }

    public static boolean b() {
        kd.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return kd.b.a().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.ld a() {
        return (ld)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
