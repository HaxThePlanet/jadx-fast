package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class oc implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.pc> {

    private static final com.google.android.gms.internal.measurement.oc b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.pc> a;
    static {
        oc ocVar = new oc();
        oc.b = ocVar;
    }

    public oc() {
        qc qcVar = new qc();
        super();
        this.a = i7.a(i7.b(qcVar));
    }

    public static boolean b() {
        return oc.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.pc a() {
        return (pc)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
