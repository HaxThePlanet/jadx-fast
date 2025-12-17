package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class me implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ne> {

    private static final com.google.android.gms.internal.measurement.me b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.ne> a;
    static {
        me meVar = new me();
        me.b = meVar;
    }

    public me() {
        oe oeVar = new oe();
        super();
        this.a = i7.a(i7.b(oeVar));
    }

    public static boolean b() {
        me.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return me.b.a().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.ne a() {
        return (ne)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
