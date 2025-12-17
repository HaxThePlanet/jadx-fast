package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes2.dex */
public final class g1 extends com.google.android.gms.internal.measurement.o0 implements com.google.android.gms.internal.measurement.i1 {
    g1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void c(Bundle bundle) {
        final android.os.Parcel parcel = j();
        q0.d(parcel, bundle);
        n(1, parcel);
    }
}
