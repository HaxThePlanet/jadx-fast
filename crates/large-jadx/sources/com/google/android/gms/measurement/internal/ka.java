package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.i1;

/* loaded from: classes2.dex */
final class ka implements Runnable {

    final i1 a;
    final com.google.android.gms.measurement.internal.AppMeasurementDynamiteService b;
    ka(com.google.android.gms.measurement.internal.AppMeasurementDynamiteService appMeasurementDynamiteService, i1 i12) {
        this.b = appMeasurementDynamiteService;
        this.a = i12;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        service.a.N().C(this.a, service2.a.n());
    }
}
