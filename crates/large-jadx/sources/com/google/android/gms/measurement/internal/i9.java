package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class i9 implements Runnable {

    final com.google.android.gms.measurement.internal.la a;
    final com.google.android.gms.measurement.internal.AppMeasurementDynamiteService b;
    i9(com.google.android.gms.measurement.internal.AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.measurement.internal.la la2) {
        this.b = appMeasurementDynamiteService;
        this.a = la2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        service.a.I().I(this.a);
    }
}
