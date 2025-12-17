package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class pb implements com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.qb> {

    private static final com.google.android.gms.internal.measurement.pb b;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.qb> a;
    static {
        pb pbVar = new pb();
        pb.b = pbVar;
    }

    public pb() {
        rb rbVar = new rb();
        super();
        this.a = i7.a(i7.b(rbVar));
    }

    public static boolean b() {
        pb.b.a().zza();
        return 1;
    }

    public static boolean c() {
        return pb.b.a().zzb();
    }

    public static boolean d() {
        return pb.b.a().zzc();
    }

    public static boolean e() {
        return pb.b.a().b();
    }

    public static boolean f() {
        return pb.b.a().a();
    }

    public static boolean g() {
        return pb.b.a().c();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final com.google.android.gms.internal.measurement.qb a() {
        return (qb)this.a.zza();
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final Object zza() {
        return a();
    }
}
