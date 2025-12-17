package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class je implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ke> {

    private static final com.google.android.gms.internal.measurement.je b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ke> a;
    static {
        je jeVar = new je();
        je.b = jeVar;
    }

    public je() {
        le leVar = new le();
        super();
        this.a = i7.a(i7.b(leVar));
    }

    public static boolean b() {
        return je.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.ke a() {
        return (ke)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
