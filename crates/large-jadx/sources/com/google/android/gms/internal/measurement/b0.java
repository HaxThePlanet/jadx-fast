package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class b0 implements Callable {

    public final com.google.android.gms.internal.measurement.c1 a;
    public b0(com.google.android.gms.internal.measurement.c1 c1) {
        super();
        this.a = c1;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        y8 y8Var = new y8(c1Var.c);
        return y8Var;
    }
}
