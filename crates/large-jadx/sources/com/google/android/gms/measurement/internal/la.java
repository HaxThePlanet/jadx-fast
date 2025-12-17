package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.l1;

/* loaded from: classes2.dex */
final class la implements com.google.android.gms.measurement.internal.c6 {

    public final l1 a;
    final com.google.android.gms.measurement.internal.AppMeasurementDynamiteService b;
    la(com.google.android.gms.measurement.internal.AppMeasurementDynamiteService appMeasurementDynamiteService, l1 l12) {
        this.b = appMeasurementDynamiteService;
        super();
        this.a = l12;
    }

    @Override // com.google.android.gms.measurement.internal.c6
    public final void a(String string, String string2, Bundle bundle3, long l4) {
        try {
            this.a.r(string, string2, bundle3, l4);
            string2 = this.b;
            string2 = string2.a;
            if (string2 != null) {
            }
            string2 = string2.b();
            string2 = string2.w();
            bundle3 = "Event interceptor threw exception";
            string2.b(bundle3, string);
        }
    }
}
