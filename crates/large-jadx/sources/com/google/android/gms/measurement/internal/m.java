package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class m implements Runnable {

    final com.google.android.gms.measurement.internal.x5 a;
    final com.google.android.gms.measurement.internal.n b;
    m(com.google.android.gms.measurement.internal.n n, com.google.android.gms.measurement.internal.x5 x52) {
        this.b = n;
        this.a = x52;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        this.a.d();
        if (b.a()) {
            this.a.a().z(this);
        }
        n.a(this.b, 0);
        if (this.b.e()) {
            this.b.c();
        }
    }
}
