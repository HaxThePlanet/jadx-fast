package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.i1;

/* loaded from: classes2.dex */
final class h8 implements Runnable {

    final i1 a;
    final String b;
    final String c;
    final boolean v;
    final com.google.android.gms.measurement.internal.AppMeasurementDynamiteService w;
    h8(com.google.android.gms.measurement.internal.AppMeasurementDynamiteService appMeasurementDynamiteService, i1 i12, String string3, String string4, boolean z5) {
        this.w = appMeasurementDynamiteService;
        this.a = i12;
        this.b = string3;
        this.c = string4;
        this.v = z5;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        service.a.L().V(this.a, this.b, this.c, this.v);
    }
}
