package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class wd implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.xd> {

    private static final com.google.android.gms.internal.measurement.wd b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.xd> a;
    static {
        wd wdVar = new wd();
        wd.b = wdVar;
    }

    public wd() {
        zd zdVar = new zd();
        super();
        this.a = i7.a(i7.b(zdVar));
    }

    public static boolean b() {
        wd.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return wd.b.a().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.xd a() {
        return (xd)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
