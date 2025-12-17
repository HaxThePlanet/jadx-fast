package com.google.android.gms.common.internal.z;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.y;
import f.c.a.d.b.e.d;

/* loaded from: classes2.dex */
public final class e extends h<com.google.android.gms.common.internal.z.a> {

    private final y a;
    public e(Context context, Looper looper2, d d3, y y4, f f5, m m6) {
        super(context, looper2, 270, d3, f5, m6);
        this.a = y4;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final IInterface createServiceInterface(IBinder iBinder) {
        IInterface localInterface;
        boolean z;
        int obj3;
        if (iBinder == null) {
            obj3 = 0;
        } else {
            localInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
            if (localInterface instanceof a) {
                obj3 = localInterface;
            } else {
                localInterface = new a(iBinder);
                obj3 = localInterface;
            }
        }
        return obj3;
    }

    @Override // com.google.android.gms.common.internal.h
    public final d[] getApiFeatures() {
        return d.b;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final Bundle getGetServiceRequestExtraArgs() {
        return this.a.b();
    }

    @Override // com.google.android.gms.common.internal.h
    public final int getMinApkVersion() {
        return 203390000;
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.h
    protected final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.h
    protected final boolean getUseDynamicLookup() {
        return 1;
    }
}
