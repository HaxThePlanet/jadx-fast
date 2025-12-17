package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class a7 implements Runnable {

    final Boolean a;
    final com.google.android.gms.measurement.internal.i7 b;
    a7(com.google.android.gms.measurement.internal.i7 i7, Boolean boolean2) {
        this.b = i7;
        this.a = boolean2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        i7.e0(this.b, this.a, true);
    }
}
