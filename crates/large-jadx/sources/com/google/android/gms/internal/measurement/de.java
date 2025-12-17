package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class de implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ee> {

    private static final com.google.android.gms.internal.measurement.de b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ee> a;
    static {
        de deVar = new de();
        de.b = deVar;
    }

    public de() {
        fe feVar = new fe();
        super();
        this.a = i7.a(i7.b(feVar));
    }

    public static boolean b() {
        de.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return de.b.a().zzb();
    }

    public static boolean d() {
        return de.b.a().zzc();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.ee a() {
        return (ee)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
