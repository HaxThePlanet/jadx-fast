package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class r6 implements Runnable {

    final Bundle a;
    final com.google.android.gms.measurement.internal.i7 b;
    r6(com.google.android.gms.measurement.internal.i7 i7, Bundle bundle2) {
        this.b = i7;
        this.a = bundle2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        final Object obj = this;
        String str = "creation_timestamp";
        String str4 = "app_id";
        final com.google.android.gms.measurement.internal.i7 i7Var = obj.b;
        Bundle bundle = obj.a;
        i7Var.h();
        i7Var.i();
        r.j(bundle);
        String string2 = bundle.getString("name");
        r.f(string2);
        if (!i7Var.a.o()) {
            i7Var.a.b().v().a("Conditional property not cleared since app measurement is disabled");
        }
        super(string2, 0, obj9, 0, "");
        final String string4 = bundle.getString(str4);
        final String str13 = "";
        super(bundle.getString(str4), "", eaVar3, bundle.getLong(str), obj9, bundle.getBoolean("active"), bundle.getString("trigger_event_name"), 0, bundle.getLong("trigger_timeout"), string4, 0, bundle.getLong("time_to_live"), str13, i7Var.a.N().w0(string4, bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), str13, bundle.getLong(str), obj19, true));
        i7Var.a.L().s(cVar3);
    }
}
