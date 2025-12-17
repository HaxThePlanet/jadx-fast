package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.i1;

/* loaded from: classes2.dex */
final class ja implements Runnable {

    final i1 a;
    final String b;
    final String c;
    final com.google.android.gms.measurement.internal.AppMeasurementDynamiteService v;
    ja(com.google.android.gms.measurement.internal.AppMeasurementDynamiteService appMeasurementDynamiteService, i1 i12, String string3, String string4) {
        this.v = appMeasurementDynamiteService;
        this.a = i12;
        this.b = string3;
        this.c = string4;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        service.a.L().T(this.a, this.b, this.c);
    }
}
