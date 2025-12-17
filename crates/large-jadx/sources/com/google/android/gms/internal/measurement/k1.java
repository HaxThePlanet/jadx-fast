package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes2.dex */
public abstract class k1 extends com.google.android.gms.internal.measurement.p0 implements com.google.android.gms.internal.measurement.l1 {
    public k1() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.p0
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        Object obj;
        String string2;
        String string;
        android.os.Parcelable parcelable;
        long long;
        int obj7;
        int obj8;
        final int obj10 = 1;
        if (i != obj10) {
            if (i != 2) {
                return 0;
            }
            parcel3.writeNoException();
            parcel3.writeInt(b());
        } else {
            this.r(parcel2.readString(), parcel2.readString(), (Bundle)q0.a(parcel2, Bundle.CREATOR), parcel2.readLong());
            parcel3.writeNoException();
        }
        return obj10;
    }
}
