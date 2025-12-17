package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class d7 implements Runnable {

    final com.google.android.gms.measurement.internal.h a;
    final int b;
    final long c;
    final boolean v;
    final com.google.android.gms.measurement.internal.i7 w;
    d7(com.google.android.gms.measurement.internal.i7 i7, com.google.android.gms.measurement.internal.h h2, int i3, long l4, boolean z5) {
        this.w = i7;
        this.a = h2;
        this.b = i3;
        this.c = l4;
        this.v = obj6;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.w.K(this.a);
        i7.d0(this.w, this.a, this.b, this.c, obj6, false);
    }
}
