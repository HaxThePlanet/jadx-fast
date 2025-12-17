package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class w9 implements Callable<String> {

    final com.google.android.gms.measurement.internal.na a;
    final com.google.android.gms.measurement.internal.ba b;
    w9(com.google.android.gms.measurement.internal.ba ba, com.google.android.gms.measurement.internal.na na2) {
        this.b = ba;
        this.a = na2;
        super();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str2;
        boolean z;
        Object str;
        String str4 = naVar2.a;
        r.j(str4);
        if (this.b.T((String)str4).k()) {
            if (!h.b(naVar.N).k()) {
                this.b.b().v().a("Analytics storage consent denied. Returning null app instance id");
                str2 = 0;
            } else {
                str2 = this.b.R(this.a).f0();
            }
        } else {
        }
        return str2;
    }
}
