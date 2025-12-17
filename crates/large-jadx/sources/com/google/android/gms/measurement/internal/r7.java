package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class r7 implements Runnable {

    final com.google.android.gms.measurement.internal.p7 a;
    final com.google.android.gms.measurement.internal.p7 b;
    final long c;
    final boolean v;
    final com.google.android.gms.measurement.internal.w7 w;
    r7(com.google.android.gms.measurement.internal.w7 w7, com.google.android.gms.measurement.internal.p7 p72, com.google.android.gms.measurement.internal.p7 p73, long l4, boolean z5) {
        this.w = w7;
        this.a = p72;
        this.b = p73;
        this.c = l4;
        this.v = obj6;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        w7.w(this.w, this.a, this.b, this.c, obj4, this.v);
    }
}
