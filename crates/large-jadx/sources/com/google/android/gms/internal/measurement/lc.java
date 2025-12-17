package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class lc implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.mc> {

    private static final com.google.android.gms.internal.measurement.lc b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.mc> a;
    static {
        lc lcVar = new lc();
        lc.b = lcVar;
    }

    public lc() {
        nc ncVar = new nc();
        super();
        this.a = i7.a(i7.b(ncVar));
    }

    public static boolean b() {
        return lc.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.mc a() {
        return (mc)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
