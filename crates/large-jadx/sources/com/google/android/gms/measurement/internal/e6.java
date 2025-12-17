package com.google.android.gms.measurement.internal;

import android.util.Log;

/* loaded from: classes2.dex */
final class e6 implements com.google.android.gms.measurement.internal.k3 {

    final com.google.android.gms.measurement.internal.b5 a;
    e6(com.google.android.gms.measurement.internal.f6 f6, com.google.android.gms.measurement.internal.b5 b52) {
        this.a = b52;
        super();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final boolean zza() {
        boolean loggable;
        int i;
        if (this.a.q() && Log.isLoggable(this.a.b().C(), 3)) {
            if (Log.isLoggable(this.a.b().C(), 3)) {
                return 1;
            }
        }
        return 0;
    }
}
