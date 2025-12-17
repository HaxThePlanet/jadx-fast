package com.google.android.gms.common.internal.z;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.v;
import f.c.a.d.b.e.a;
import f.c.a.d.b.e.c;

/* loaded from: classes2.dex */
public final class a extends a implements IInterface {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // f.c.a.d.b.e.a
    public final void p2(v v) {
        final android.os.Parcel parcel = j();
        c.b(parcel, v);
        n(1, parcel);
    }
}
