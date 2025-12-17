package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamic.b;

/* loaded from: classes2.dex */
final class x2 extends com.google.android.gms.internal.measurement.u2 {

    final Bundle w;
    final Activity x;
    final com.google.android.gms.internal.measurement.f3 y;
    x2(com.google.android.gms.internal.measurement.f3 f3, Bundle bundle2, Activity activity3) {
        this.y = f3;
        this.w = bundle2;
        this.x = activity3;
        super(f3.a, 1);
    }

    @Override // com.google.android.gms.internal.measurement.u2
    final void a() {
        Bundle bundle;
        boolean key;
        String str;
        boolean z;
        if (this.w != null) {
            bundle = new Bundle();
            str = "com.google.app_measurement.screen_service";
            key = this.w.get(str);
            if (this.w.containsKey(str) && key instanceof Bundle != null) {
                key = this.w.get(str);
                if (key instanceof Bundle != null) {
                    bundle.putBundle(str, (Bundle)key);
                }
            }
        } else {
            bundle = 0;
        }
        com.google.android.gms.internal.measurement.f1 f1Var = g3.y(f3Var.a);
        r.j(f1Var);
        (f1)f1Var.onActivityCreated(b.p2(this.x), bundle, this.b);
    }
}
