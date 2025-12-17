package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class b0 implements Runnable {

    final String a;
    final long b;
    final com.google.android.gms.measurement.internal.d2 c;
    b0(com.google.android.gms.measurement.internal.d2 d2, String string2, long l3) {
        this.c = d2;
        this.a = string2;
        this.b = l3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        d2.j(this.c, this.a, this.b);
    }
}
