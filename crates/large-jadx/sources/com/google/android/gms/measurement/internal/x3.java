package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class x3 implements Runnable {

    final boolean a;
    final com.google.android.gms.measurement.internal.y3 b;
    x3(com.google.android.gms.measurement.internal.y3 y3, boolean z2) {
        this.b = y3;
        this.a = z2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        y3.a(this.b).n(this.a);
    }
}
