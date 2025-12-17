package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class t9 implements Runnable {

    final com.google.android.gms.measurement.internal.ca a;
    final com.google.android.gms.measurement.internal.ba b;
    t9(com.google.android.gms.measurement.internal.ba ba, com.google.android.gms.measurement.internal.ca ca2) {
        this.b = ba;
        this.a = ca2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        ba.i0(this.b, this.a);
        this.b.v();
    }
}
