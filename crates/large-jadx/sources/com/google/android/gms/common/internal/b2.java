package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import f.c.a.d.b.g.a;
import f.c.a.d.b.g.c;

/* loaded from: classes2.dex */
public final class b2 extends a implements com.google.android.gms.common.internal.l {
    b2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // f.c.a.d.b.g.a
    public final void L0(int i, IBinder iBinder2, Bundle bundle3) {
        final Parcel parcel = n();
        parcel.writeInt(i);
        parcel.writeStrongBinder(iBinder2);
        c.d(parcel, bundle3);
        m(1, parcel);
    }
}
