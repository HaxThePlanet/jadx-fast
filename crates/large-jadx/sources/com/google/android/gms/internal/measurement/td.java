package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class td implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ud> {

    private static final com.google.android.gms.internal.measurement.td b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ud> a;
    static {
        td tdVar = new td();
        td.b = tdVar;
    }

    public td() {
        vd vdVar = new vd();
        super();
        this.a = i7.a(i7.b(vdVar));
    }

    public static boolean b() {
        return td.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.ud a() {
        return (ud)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
