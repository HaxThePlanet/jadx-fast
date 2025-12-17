package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ge implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.he> {

    private static final com.google.android.gms.internal.measurement.ge b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.he> a;
    static {
        ge geVar = new ge();
        ge.b = geVar;
    }

    public ge() {
        ie ieVar = new ie();
        super();
        this.a = i7.a(i7.b(ieVar));
    }

    public static boolean b() {
        return ge.b.a().zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.he a() {
        return (he)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
