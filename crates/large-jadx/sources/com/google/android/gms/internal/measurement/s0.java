package com.google.android.gms.internal.measurement;

import android.os.IBinder;

/* loaded from: classes2.dex */
public abstract class s0 extends com.google.android.gms.internal.measurement.p0 implements com.google.android.gms.internal.measurement.t0 {
    public static com.google.android.gms.internal.measurement.t0 m(IBinder iBinder) {
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        if (localInterface instanceof t0) {
            return (t0)localInterface;
        }
        r0 r0Var = new r0(iBinder);
        return r0Var;
    }
}
