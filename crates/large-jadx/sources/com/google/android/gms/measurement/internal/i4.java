package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.s0;

/* loaded from: classes2.dex */
public final class i4 implements ServiceConnection {

    private final String a;
    final com.google.android.gms.measurement.internal.j4 b;
    i4(com.google.android.gms.measurement.internal.j4 j4, String string2) {
        this.b = j4;
        super();
        this.a = string2;
    }

    static String a(com.google.android.gms.measurement.internal.i4 i4) {
        return i4.a;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        com.google.android.gms.internal.measurement.t0 obj2 = s0.m(iBinder2);
        if (iBinder2 != null && obj2 == null) {
            obj2 = s0.m(iBinder2);
            if (obj2 == null) {
                try {
                    obj2.a.b().w().a("Install Referrer Service implementation was not found");
                    obj3.a.b().v().a("Install Referrer Service connected");
                    h4 h4Var = new h4(this, obj2, this);
                    obj3.a.a().z(h4Var);
                    iBinder2 = this.b;
                    iBinder2 = iBinder2.a;
                    iBinder2 = iBinder2.b();
                    iBinder2 = iBinder2.w();
                    iBinder2.b("Exception occurred while calling Install Referrer API", componentName);
                    obj2.a.b().w().a("Install Referrer connection returned with null binder");
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        obj2.a.b().v().a("Install Referrer Service disconnected");
    }
}
