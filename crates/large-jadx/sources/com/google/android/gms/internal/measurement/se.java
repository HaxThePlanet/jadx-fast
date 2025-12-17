package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class se implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.te> {

    private static final com.google.android.gms.internal.measurement.se b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.te> a;
    static {
        se seVar = new se();
        se.b = seVar;
    }

    public se() {
        ue ueVar = new ue();
        super();
        this.a = i7.a(i7.b(ueVar));
    }

    public static boolean b() {
        se.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return se.b.a().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.te a() {
        return (te)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
