package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.i1;

/* loaded from: classes2.dex */
final class h7 implements Runnable {

    final i1 a;
    final com.google.android.gms.measurement.internal.u b;
    final String c;
    final com.google.android.gms.measurement.internal.AppMeasurementDynamiteService v;
    h7(com.google.android.gms.measurement.internal.AppMeasurementDynamiteService appMeasurementDynamiteService, i1 i12, com.google.android.gms.measurement.internal.u u3, String string4) {
        this.v = appMeasurementDynamiteService;
        this.a = i12;
        this.b = u3;
        this.c = string4;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        service.a.L().p(this.a, this.b, this.c);
    }
}
