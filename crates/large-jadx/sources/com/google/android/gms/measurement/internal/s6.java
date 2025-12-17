package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class s6 implements Runnable {

    final AtomicReference a;
    final com.google.android.gms.measurement.internal.i7 b;
    s6(com.google.android.gms.measurement.internal.i7 i7, AtomicReference atomicReference2) {
        this.b = i7;
        this.a = atomicReference2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        final AtomicReference atomicReference = this.a;
        this.a.set(Boolean.valueOf(i7Var.a.z().B(i7Var2.a.B().s(), c3.K)));
        this.a.notify();
        return;
        synchronized (atomicReference) {
            atomicReference = this.a;
            this.a.set(Boolean.valueOf(i7Var.a.z().B(i7Var2.a.B().s(), c3.K)));
            this.a.notify();
        }
    }
}
