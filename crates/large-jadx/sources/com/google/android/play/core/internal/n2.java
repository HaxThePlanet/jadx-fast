package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public final class n2 extends com.google.android.play.core.internal.y1 implements IInterface {
    n2(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    @Override // com.google.android.play.core.internal.y1
    public final void c(Bundle bundle) {
        final android.os.Parcel parcel = j();
        a2.b(parcel, bundle);
        m(3, parcel);
    }

    @Override // com.google.android.play.core.internal.y1
    public final void h(Bundle bundle) {
        final android.os.Parcel parcel = j();
        a2.b(parcel, bundle);
        m(4, parcel);
    }

    @Override // com.google.android.play.core.internal.y1
    public final void p(Bundle bundle, Bundle bundle2) {
        final android.os.Parcel parcel = j();
        a2.b(parcel, bundle);
        a2.b(parcel, bundle2);
        m(2, parcel);
    }
}
