package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ve implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.we> {

    private static final com.google.android.gms.internal.measurement.ve b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.we> a;
    static {
        ve veVar = new ve();
        ve.b = veVar;
    }

    public ve() {
        xe xeVar = new xe();
        super();
        this.a = i7.a(i7.b(xeVar));
    }

    public static boolean b() {
        return ve.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.we a() {
        return (we)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
