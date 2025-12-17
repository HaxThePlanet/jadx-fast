package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class t6 implements Runnable {

    final AtomicReference a;
    final String b;
    final String c;
    final com.google.android.gms.measurement.internal.i7 v;
    t6(com.google.android.gms.measurement.internal.i7 i7, AtomicReference atomicReference2, String string3, String string4, String string5) {
        this.v = i7;
        this.a = atomicReference2;
        this.b = string4;
        this.c = string5;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        i7Var.a.L().U(this.a, 0, this.b, this.c);
    }
}
