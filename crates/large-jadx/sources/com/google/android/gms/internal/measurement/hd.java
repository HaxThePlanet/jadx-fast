package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class hd implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.id> {

    private static final com.google.android.gms.internal.measurement.hd b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.id> a;
    static {
        hd hdVar = new hd();
        hd.b = hdVar;
    }

    public hd() {
        jd jdVar = new jd();
        super();
        this.a = i7.a(i7.b(jdVar));
    }

    public static boolean b() {
        return hd.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.id a() {
        return (id)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
