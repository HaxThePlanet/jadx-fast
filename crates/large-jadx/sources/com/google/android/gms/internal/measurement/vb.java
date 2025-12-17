package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class vb implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.xb> {

    private static final com.google.android.gms.internal.measurement.vb b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.xb> a;
    static {
        vb vbVar = new vb();
        vb.b = vbVar;
    }

    public vb() {
        yb ybVar = new yb();
        super();
        this.a = i7.a(i7.b(ybVar));
    }

    public static boolean b() {
        return vb.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.xb a() {
        return (xb)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
