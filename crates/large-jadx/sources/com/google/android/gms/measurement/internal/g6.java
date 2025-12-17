package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
public final class g6 implements Runnable {

    public final com.google.android.gms.measurement.internal.i7 a;
    public g6(com.google.android.gms.measurement.internal.i7 i7) {
        super();
        this.a = i7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.measurement.internal.i7 i7Var = this.a;
        i7Var.h();
        long l = g4Var3.s.a();
        g4Var4.s.b(i3 += l);
        i7Var.a.z();
        if (!g4Var2.r.b() && Long.compare(l, i2) >= 0) {
            l = g4Var3.s.a();
            g4Var4.s.b(i3 += l);
            i7Var.a.z();
            if (Long.compare(l, i2) >= 0) {
                i7Var.a.b().w().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                g4Var.r.a(true);
            }
            i7Var.a.j();
        }
        i7Var.a.b().q().a("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
