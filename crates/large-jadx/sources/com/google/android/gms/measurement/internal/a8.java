package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class a8 implements Runnable {

    final AtomicReference a;
    final com.google.android.gms.measurement.internal.na b;
    final com.google.android.gms.measurement.internal.w8 c;
    a8(com.google.android.gms.measurement.internal.w8 w8, AtomicReference atomicReference2, com.google.android.gms.measurement.internal.na na3) {
        this.c = w8;
        this.a = atomicReference2;
        this.b = na3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        Object atomicReference2;
        com.google.android.gms.measurement.internal.na naVar;
        final AtomicReference atomicReference3 = this.a;
        synchronized (atomicReference3) {
            w8Var5.a.b().x().a("Analytics storage consent denied; will not get app instance id");
            int i = 0;
            w8Var6.a.I().C(i);
            g4Var2.g.b(i);
            this.a.set(i);
            this.a.notify();
        }
    }
}
