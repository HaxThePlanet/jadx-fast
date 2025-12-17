package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ye implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.af> {

    private static final com.google.android.gms.internal.measurement.ye b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.af> a;
    static {
        ye yeVar = new ye();
        ye.b = yeVar;
    }

    public ye() {
        bf bfVar = new bf();
        super();
        this.a = i7.a(i7.b(bfVar));
    }

    public static boolean b() {
        return ye.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.af a() {
        return (af)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
