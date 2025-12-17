package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ic implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.jc> {

    private static final com.google.android.gms.internal.measurement.ic b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.jc> a;
    static {
        ic icVar = new ic();
        ic.b = icVar;
    }

    public ic() {
        kc kcVar = new kc();
        super();
        this.a = i7.a(i7.b(kcVar));
    }

    public static boolean b() {
        ic.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return ic.b.a().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.jc a() {
        return (jc)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
