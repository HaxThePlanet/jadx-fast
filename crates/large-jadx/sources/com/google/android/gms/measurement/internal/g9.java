package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class g9 implements Runnable {

    final long a;
    final long b;
    final com.google.android.gms.measurement.internal.h9 c;
    g9(com.google.android.gms.measurement.internal.h9 h9, long l2, long l3) {
        this.c = h9;
        super();
        this.a = l2;
        this.b = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f9 f9Var = new f9(this);
        m9Var.a.a().z(f9Var);
    }
}
