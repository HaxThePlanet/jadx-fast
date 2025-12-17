package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class q6 implements Runnable {

    final Bundle a;
    final com.google.android.gms.measurement.internal.i7 b;
    q6(com.google.android.gms.measurement.internal.i7 i7, Bundle bundle2) {
        this.b = i7;
        this.a = bundle2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        final Object obj = this;
        String str = "app_id";
        com.google.android.gms.measurement.internal.i7 i7Var = obj.b;
        final Bundle bundle = obj.a;
        i7Var.h();
        i7Var.i();
        r.j(bundle);
        String string2 = bundle.getString("name");
        String string = bundle.getString("origin");
        r.f(string2);
        r.f(string);
        String str9 = "value";
        r.j(bundle.get(str9));
        if (!i7Var.a.o()) {
            i7Var.a.b().v().a("Conditional property not set since app measurement is disabled");
        }
        super(string2, bundle.getLong("triggered_timestamp"), obj8, bundle.get(str9), string);
        int i3 = 0;
        super(bundle.getString(str), string, eaVar3, bundle.getLong("creation_timestamp"), i3, 0, bundle.getString("trigger_event_name"), i7Var.a.N().w0(bundle.getString(str), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string, 0, obj13, true), bundle.getLong("trigger_timeout"), obj17, i7Var.a.N().w0(bundle.getString(str), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string, 0, obj13, true), bundle.getLong("time_to_live"), obj20, i7Var.a.N().w0(bundle.getString(str), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string, i3, obj13, true));
        i7Var.a.L().s(cVar);
    }
}
