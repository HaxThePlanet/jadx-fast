package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.c.a;
import com.google.android.gms.common.internal.c.b;

/* loaded from: classes2.dex */
public final class m3 extends c<com.google.android.gms.measurement.internal.g3> {
    public m3(Context context, Looper looper2, c.a c$a3, c.b c$b4) {
        super(context, looper2, 93, a3, b4, 0);
    }

    @Override // com.google.android.gms.common.internal.c
    public final IInterface createServiceInterface(IBinder iBinder) {
        IInterface localInterface;
        boolean z;
        int obj3;
        if (iBinder == null) {
            obj3 = 0;
        } else {
            localInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
            if (localInterface instanceof g3) {
                obj3 = localInterface;
            } else {
                localInterface = new d3(iBinder);
                obj3 = localInterface;
            }
        }
        return obj3;
    }

    @Override // com.google.android.gms.common.internal.c
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getStartServiceAction() {
        return "com.google.android.gms.measurement.START";
    }
}
