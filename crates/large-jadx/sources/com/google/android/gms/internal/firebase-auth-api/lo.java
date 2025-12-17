package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class lo implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ko> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i2;
        int i3;
        int i4;
        final int i5 = SafeParcelReader.w(parcel);
        i = 0;
        while (parcel.dataPosition() < i5) {
            i2 = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i2) != 2) {
            } else {
            }
            i = SafeParcelReader.d(parcel, i2, oo.CREATOR);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i5);
        ko obj6 = new ko(i);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ko[i];
    }
}
