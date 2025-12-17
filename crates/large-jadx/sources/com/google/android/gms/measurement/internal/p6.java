package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class p6 implements Runnable {

    final long a;
    final com.google.android.gms.measurement.internal.i7 b;
    p6(com.google.android.gms.measurement.internal.i7 i7, long l2) {
        this.b = i7;
        this.a = l2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.z(this.a, obj2);
        AtomicReference atomicReference = new AtomicReference();
        i7Var2.a.L().S(atomicReference);
    }
}
