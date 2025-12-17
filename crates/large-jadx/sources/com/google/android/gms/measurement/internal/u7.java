package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class u7 implements Runnable {

    final com.google.android.gms.measurement.internal.p7 a;
    final long b;
    final com.google.android.gms.measurement.internal.w7 c;
    u7(com.google.android.gms.measurement.internal.w7 w7, com.google.android.gms.measurement.internal.p7 p72, long l3) {
        this.c = w7;
        this.a = p72;
        this.b = l3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        w7.y(this.c, this.a, false, this.b);
        com.google.android.gms.measurement.internal.w7 w7Var2 = this.c;
        int i = 0;
        w7Var2.e = i;
        w7Var2.a.L().u(i);
    }
}
