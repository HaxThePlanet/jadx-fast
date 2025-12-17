package com.google.android.gms.common.internal;

import android.os.IBinder;
import f.c.a.d.b.g.b;

/* loaded from: classes2.dex */
public abstract class y0 extends b implements com.google.android.gms.common.internal.z0 {
    public static com.google.android.gms.common.internal.z0 m(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (localInterface instanceof z0) {
            return (z0)localInterface;
        }
        x0 x0Var = new x0(iBinder);
        return x0Var;
    }
}
