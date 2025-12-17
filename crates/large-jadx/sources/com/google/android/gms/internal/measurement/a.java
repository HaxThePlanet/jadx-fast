package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class a implements Callable {

    public final com.google.android.gms.internal.measurement.c1 a;
    public a(com.google.android.gms.internal.measurement.c1 c1) {
        super();
        this.a = c1;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.b();
    }
}
