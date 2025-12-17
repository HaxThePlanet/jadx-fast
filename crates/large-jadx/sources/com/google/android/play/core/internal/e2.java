package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes2.dex */
public abstract class e2 extends com.google.android.play.core.internal.z1 implements com.google.android.play.core.internal.f2 {
    public e2() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // com.google.android.play.core.internal.z1
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        android.os.Parcelable obj1;
        int obj3;
        if (i != 2) {
            if (i != 3) {
                return 0;
            }
            k((Bundle)a2.a(parcel2, Bundle.CREATOR));
        } else {
            h((Bundle)a2.a(parcel2, Bundle.CREATOR));
        }
        return 1;
    }
}
