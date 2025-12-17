package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public final class b2 extends com.google.android.play.core.internal.y1 implements com.google.android.play.core.internal.d2 {
    b2(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    @Override // com.google.android.play.core.internal.y1
    public final void X0(String string, Bundle bundle2, com.google.android.play.core.internal.f2 f23) {
        final Parcel parcel = j();
        parcel.writeString(string);
        a2.b(parcel, bundle2);
        a2.c(parcel, f23);
        m(2, parcel);
    }
}
