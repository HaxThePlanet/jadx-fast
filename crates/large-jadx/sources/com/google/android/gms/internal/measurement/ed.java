package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ed implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.fd> {

    private static final com.google.android.gms.internal.measurement.ed b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.fd> a;
    static {
        ed edVar = new ed();
        ed.b = edVar;
    }

    public ed() {
        gd gdVar = new gd();
        super();
        this.a = i7.a(i7.b(gdVar));
    }

    public static boolean b() {
        return ed.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.fd a() {
        return (fd)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
