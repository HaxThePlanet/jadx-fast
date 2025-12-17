package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.e;

/* loaded from: classes2.dex */
abstract class u2 implements Runnable {

    final long a;
    final long b;
    final boolean c;
    final com.google.android.gms.internal.measurement.g3 v;
    u2(com.google.android.gms.internal.measurement.g3 g3, boolean z2) {
        this.v = g3;
        super();
        this.a = g3.b.currentTimeMillis();
        this.b = g3.b.a();
        this.c = z2;
    }

    @Override // java.lang.Runnable
    abstract void a();

    @Override // java.lang.Runnable
    protected void b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (g3.o(this.v)) {
            b();
        }
        a();
    }
}
