package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class w6 implements Runnable {

    final AtomicReference a;
    final com.google.android.gms.measurement.internal.i7 b;
    w6(com.google.android.gms.measurement.internal.i7 i7, AtomicReference atomicReference2) {
        this.b = i7;
        this.a = atomicReference2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        final AtomicReference atomicReference = this.a;
        this.a.set(i7Var.a.z().x(i7Var2.a.B().s(), c3.L));
        this.a.notify();
        return;
        synchronized (atomicReference) {
            atomicReference = this.a;
            this.a.set(i7Var.a.z().x(i7Var2.a.B().s(), c3.L));
            this.a.notify();
        }
    }
}
