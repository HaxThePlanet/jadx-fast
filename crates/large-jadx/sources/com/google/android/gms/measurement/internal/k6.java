package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class k6 implements Runnable {

    final boolean a;
    final com.google.android.gms.measurement.internal.i7 b;
    k6(com.google.android.gms.measurement.internal.i7 i7, boolean z2) {
        this.b = i7;
        this.a = z2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean valueOf;
        boolean z;
        boolean z2;
        boolean valueOf2;
        boolean str;
        valueOf = i7Var.a.o();
        i7Var8.a.k(this.a);
        if (i7Var3.a.n() == this.a) {
            i7Var4.a.b().v().b("Default data collection state already set to", Boolean.valueOf(this.a));
        }
        if (i7Var5.a.o() != valueOf) {
            if (i7Var6.a.o() != i7Var9.a.n()) {
                i7Var7.a.b().x().c("Default data collection is different than actual status", Boolean.valueOf(this.a), Boolean.valueOf(valueOf));
            }
        } else {
        }
        i7.f0(this.b);
    }
}
