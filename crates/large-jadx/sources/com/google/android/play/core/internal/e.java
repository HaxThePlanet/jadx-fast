package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes2.dex */
public abstract class e extends com.google.android.play.core.internal.z1 implements com.google.android.play.core.internal.f {
    public e() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    @Override // com.google.android.play.core.internal.z1
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        if (i == 2) {
            k((Bundle)a2.a(parcel2, Bundle.CREATOR));
            return 1;
        }
        return 0;
    }
}
