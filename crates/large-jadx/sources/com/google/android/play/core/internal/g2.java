package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes2.dex */
public final class g2 extends com.google.android.play.core.internal.y1 implements com.google.android.play.core.internal.i2 {
    g2(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    @Override // com.google.android.play.core.internal.y1
    public final void C0(String string, Bundle bundle2, Bundle bundle3, com.google.android.play.core.internal.k2 k24) {
        final Parcel parcel = j();
        parcel.writeString(string);
        a2.b(parcel, bundle2);
        a2.b(parcel, bundle3);
        a2.c(parcel, k24);
        m(11, parcel);
    }

    @Override // com.google.android.play.core.internal.y1
    public final void L1(String string, Bundle bundle2, com.google.android.play.core.internal.k2 k23) {
        final Parcel parcel = j();
        parcel.writeString(string);
        a2.b(parcel, bundle2);
        a2.c(parcel, k23);
        m(10, parcel);
    }

    @Override // com.google.android.play.core.internal.y1
    public final void P1(String string, Bundle bundle2, Bundle bundle3, com.google.android.play.core.internal.k2 k24) {
        final Parcel parcel = j();
        parcel.writeString(string);
        a2.b(parcel, bundle2);
        a2.b(parcel, bundle3);
        a2.c(parcel, k24);
        m(9, parcel);
    }

    public final void W0(String string, List<Bundle> list2, Bundle bundle3, com.google.android.play.core.internal.k2 k24) {
        final Parcel parcel = j();
        parcel.writeString(string);
        parcel.writeTypedList(list2);
        a2.b(parcel, bundle3);
        a2.c(parcel, k24);
        m(14, parcel);
    }

    @Override // com.google.android.play.core.internal.y1
    public final void X(String string, Bundle bundle2, com.google.android.play.core.internal.k2 k23) {
        final Parcel parcel = j();
        parcel.writeString(string);
        a2.b(parcel, bundle2);
        a2.c(parcel, k23);
        m(5, parcel);
    }

    @Override // com.google.android.play.core.internal.y1
    public final void j1(String string, Bundle bundle2, Bundle bundle3, com.google.android.play.core.internal.k2 k24) {
        final Parcel parcel = j();
        parcel.writeString(string);
        a2.b(parcel, bundle2);
        a2.b(parcel, bundle3);
        a2.c(parcel, k24);
        m(6, parcel);
    }

    @Override // com.google.android.play.core.internal.y1
    public final void k2(String string, Bundle bundle2, Bundle bundle3, com.google.android.play.core.internal.k2 k24) {
        final Parcel parcel = j();
        parcel.writeString(string);
        a2.b(parcel, bundle2);
        a2.b(parcel, bundle3);
        a2.c(parcel, k24);
        m(7, parcel);
    }
}
