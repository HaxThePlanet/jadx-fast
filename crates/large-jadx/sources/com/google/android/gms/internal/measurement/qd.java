package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class qd implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.rd> {

    private static final com.google.android.gms.internal.measurement.qd b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.rd> a;
    static {
        qd qdVar = new qd();
        qd.b = qdVar;
    }

    public qd() {
        sd sdVar = new sd();
        super();
        this.a = i7.a(i7.b(sdVar));
    }

    public static boolean b() {
        return qd.b.a().zza();
    }

    public static boolean c() {
        return qd.b.a().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.rd a() {
        return (rd)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
