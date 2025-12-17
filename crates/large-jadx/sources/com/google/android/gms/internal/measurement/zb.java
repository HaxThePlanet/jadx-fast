package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zb implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ac> {

    private static final com.google.android.gms.internal.measurement.zb b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ac> a;
    static {
        zb zbVar = new zb();
        zb.b = zbVar;
    }

    public zb() {
        bc bcVar = new bc();
        super();
        this.a = i7.a(i7.b(bcVar));
    }

    public static boolean b() {
        return zb.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.ac a() {
        return (ac)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
