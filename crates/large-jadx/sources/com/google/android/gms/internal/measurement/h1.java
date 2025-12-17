package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes2.dex */
public abstract class h1 extends com.google.android.gms.internal.measurement.p0 implements com.google.android.gms.internal.measurement.i1 {
    public h1() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.p0
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        final int obj4 = 1;
        if (i == obj4) {
            c((Bundle)q0.a(parcel2, Bundle.CREATOR));
            parcel3.writeNoException();
            return obj4;
        }
        return 0;
    }
}
