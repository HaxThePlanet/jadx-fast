package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class bd implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.cd> {

    private static final com.google.android.gms.internal.measurement.bd b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.cd> a;
    static {
        bd bdVar = new bd();
        bd.b = bdVar;
    }

    public bd() {
        dd ddVar = new dd();
        super();
        this.a = i7.a(i7.b(ddVar));
    }

    public static boolean b() {
        bd.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return bd.b.a().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.cd a() {
        return (cd)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
