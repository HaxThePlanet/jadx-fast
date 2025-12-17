package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.wb;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class n4 implements Callable {

    public final com.google.android.gms.measurement.internal.t4 a;
    public final String b;
    public n4(com.google.android.gms.measurement.internal.t4 t4, String string2) {
        super();
        this.a = t4;
        this.b = string2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        s4 s4Var = new s4(this.a, this.b);
        wb wbVar = new wb("internal.remoteConfig", s4Var);
        return wbVar;
    }
}
