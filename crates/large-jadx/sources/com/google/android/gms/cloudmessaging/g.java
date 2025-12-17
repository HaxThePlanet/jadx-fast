package com.google.android.gms.cloudmessaging;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
final class g implements Parcelable.Creator<com.google.android.gms.cloudmessaging.i> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        i iVar = new i(parcel.readStrongBinder());
        return iVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new i[i];
    }
}
