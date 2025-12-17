package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes2.dex */
public final class x0 extends com.google.android.play.core.internal.y1 implements com.google.android.play.core.internal.a1 {
    x0(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    public final void e2(String string, List<Bundle> list2, Bundle bundle3, com.google.android.play.core.internal.c1 c14) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeTypedList(list2);
        a2.b(parcel, bundle3);
        a2.c(parcel, c14);
        m(2, parcel);
    }
}
