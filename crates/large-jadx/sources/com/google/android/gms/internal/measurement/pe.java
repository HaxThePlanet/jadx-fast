package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class pe implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.qe> {

    private static final com.google.android.gms.internal.measurement.pe b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.qe> a;
    static {
        pe peVar = new pe();
        pe.b = peVar;
    }

    public pe() {
        re reVar = new re();
        super();
        this.a = i7.a(i7.b(reVar));
    }

    public static boolean b() {
        return pe.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.qe a() {
        return (qe)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
