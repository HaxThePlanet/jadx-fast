package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class nd implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.od> {

    private static final com.google.android.gms.internal.measurement.nd b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.od> a;
    static {
        nd ndVar = new nd();
        nd.b = ndVar;
    }

    public nd() {
        pd pdVar = new pd();
        super();
        this.a = i7.a(i7.b(pdVar));
    }

    public static boolean b() {
        return nd.b.a().zza();
    }

    public static boolean c() {
        return nd.b.a().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.od a() {
        return (od)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
