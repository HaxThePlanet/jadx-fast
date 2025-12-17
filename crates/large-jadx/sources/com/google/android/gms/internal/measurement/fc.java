package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class fc implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.gc> {

    private static final com.google.android.gms.internal.measurement.fc b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.gc> a;
    static {
        fc fcVar = new fc();
        fc.b = fcVar;
    }

    public fc() {
        hc hcVar = new hc();
        super();
        this.a = i7.a(i7.b(hcVar));
    }

    public static long a() {
        return fc.b.b().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.gc b() {
        return (gc)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return b();
    }
}
