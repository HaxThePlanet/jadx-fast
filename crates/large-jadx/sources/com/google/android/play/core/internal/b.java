package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public final class b extends com.google.android.play.core.internal.y1 implements com.google.android.play.core.internal.d {
    b(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    @Override // com.google.android.play.core.internal.y1
    public final void i2(String string, Bundle bundle2, com.google.android.play.core.internal.f f3) {
        final Parcel parcel = j();
        parcel.writeString(string);
        a2.b(parcel, bundle2);
        a2.c(parcel, f3);
        m(2, parcel);
    }
}
