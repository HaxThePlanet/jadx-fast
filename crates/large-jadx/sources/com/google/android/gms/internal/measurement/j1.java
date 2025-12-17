package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public final class j1 extends com.google.android.gms.internal.measurement.o0 implements com.google.android.gms.internal.measurement.l1 {
    j1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final int b() {
        Parcel parcel2 = m(2, j());
        parcel2.recycle();
        return parcel2.readInt();
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void r(String string, String string2, Bundle bundle3, long l4) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeString(string2);
        q0.d(parcel, bundle3);
        parcel.writeLong(l4);
        n(1, parcel);
    }
}
