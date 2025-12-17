package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class b7 implements Runnable {

    final com.google.android.gms.measurement.internal.h a;
    final long b;
    final int c;
    final long v;
    final boolean w;
    final com.google.android.gms.measurement.internal.i7 x;
    b7(com.google.android.gms.measurement.internal.i7 i7, com.google.android.gms.measurement.internal.h h2, long l3, int i4, long l5, boolean z6) {
        this.x = i7;
        this.a = h2;
        this.b = l3;
        this.c = l5;
        this.v = z6;
        this.w = obj8;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.x.K(this.a);
        this.x.z(this.b, obj2);
        i7.d0(this.x, this.a, this.c, this.v, obj8, true);
    }
}
