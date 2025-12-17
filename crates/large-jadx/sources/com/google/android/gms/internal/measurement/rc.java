package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class rc implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.sc> {

    private static final com.google.android.gms.internal.measurement.rc b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.sc> a;
    static {
        rc rcVar = new rc();
        rc.b = rcVar;
    }

    public rc() {
        tc tcVar = new tc();
        super();
        this.a = i7.a(i7.b(tcVar));
    }

    public static boolean b() {
        rc.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return rc.b.a().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.sc a() {
        return (sc)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
