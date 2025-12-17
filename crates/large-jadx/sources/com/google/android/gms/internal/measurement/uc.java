package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class uc implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.vc> {

    private static final com.google.android.gms.internal.measurement.uc b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.vc> a;
    static {
        uc ucVar = new uc();
        uc.b = ucVar;
    }

    public uc() {
        wc wcVar = new wc();
        super();
        this.a = i7.a(i7.b(wcVar));
    }

    public static boolean b() {
        uc.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return uc.b.a().zzb();
    }

    public static boolean d() {
        return uc.b.a().zzc();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.vc a() {
        return (vc)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
