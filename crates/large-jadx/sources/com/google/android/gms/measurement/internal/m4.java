package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.ef;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class m4 implements Callable {

    public final com.google.android.gms.measurement.internal.t4 a;
    public m4(com.google.android.gms.measurement.internal.t4 t4) {
        super();
        this.a = t4;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        ef efVar = new ef(t4Var.j);
        return efVar;
    }
}
