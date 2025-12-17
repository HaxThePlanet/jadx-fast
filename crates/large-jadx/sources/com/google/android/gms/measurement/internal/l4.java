package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class l4 {

    private final com.google.android.gms.measurement.internal.k4 a;
    public l4(com.google.android.gms.measurement.internal.k4 k4) {
        super();
        r.j(k4);
        this.a = k4;
    }

    public final void a(Context context, Intent intent2) {
        boolean obj4;
        String obj5;
        int i = 0;
        com.google.android.gms.measurement.internal.b5 b5Var = b5.H(context, i, i);
        com.google.android.gms.measurement.internal.q3 q3Var = b5Var.b();
        if (intent2 == null) {
            q3Var.w().a("Receiver called with null intent");
        }
        b5Var.d();
        obj5 = intent2.getAction();
        q3Var.v().b("Local receiver got", obj5);
        String str = "com.google.android.gms.measurement.UPLOAD";
        if (str.equals(obj5)) {
            obj5 = new Intent();
            obj5 = obj5.setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            obj5.setAction(str);
            q3Var.v().a("Starting wakeful intent.");
            this.a.a(context, obj5);
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(obj5)) {
            q3Var.w().a("Install Referrer Broadcasts are deprecated");
        }
    }
}
