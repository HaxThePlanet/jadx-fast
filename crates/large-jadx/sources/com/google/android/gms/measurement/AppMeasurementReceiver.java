package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.k4;
import com.google.android.gms.measurement.internal.l4;
import d.o.a.a;

/* loaded from: classes2.dex */
public final class AppMeasurementReceiver extends a implements k4 {

    private l4 c;
    @Override // d.o.a.a
    public void a(Context context, Intent intent2) {
        a.c(context, intent2);
    }

    @Override // d.o.a.a
    public void onReceive(Context context, Intent intent2) {
        l4 l4Var;
        if (this.c == null) {
            l4Var = new l4(this);
            this.c = l4Var;
        }
        this.c.a(context, intent2);
    }
}
