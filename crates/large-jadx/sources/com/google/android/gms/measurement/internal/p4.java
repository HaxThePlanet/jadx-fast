package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.ff;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class p4 implements Callable {

    public final com.google.android.gms.measurement.internal.t4 a;
    public final String b;
    public p4(com.google.android.gms.measurement.internal.t4 t4, String string2) {
        super();
        this.a = t4;
        this.b = string2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        o4 o4Var = new o4(this.a, this.b);
        ff ffVar = new ff("internal.appMetadata", o4Var);
        return ffVar;
    }
}
