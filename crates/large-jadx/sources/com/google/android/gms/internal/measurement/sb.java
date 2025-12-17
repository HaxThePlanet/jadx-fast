package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class sb implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.tb> {

    private static final com.google.android.gms.internal.measurement.sb b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.tb> a;
    static {
        sb sbVar = new sb();
        sb.b = sbVar;
    }

    public sb() {
        ub ubVar = new ub();
        super();
        this.a = i7.a(i7.b(ubVar));
    }

    public static boolean b() {
        return sb.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.tb a() {
        return (tb)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
