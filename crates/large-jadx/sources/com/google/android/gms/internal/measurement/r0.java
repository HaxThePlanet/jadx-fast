package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public final class r0 extends com.google.android.gms.internal.measurement.o0 implements com.google.android.gms.internal.measurement.t0 {
    r0(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final Bundle c(Bundle bundle) {
        Parcel parcel = j();
        q0.d(parcel, bundle);
        Parcel obj2 = m(1, parcel);
        obj2.recycle();
        return (Bundle)q0.a(obj2, Bundle.CREATOR);
    }
}
