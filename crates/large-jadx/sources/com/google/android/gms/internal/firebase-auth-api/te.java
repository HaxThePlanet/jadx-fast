package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class te implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.se> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i4;
        int i3;
        int i;
        final int i5 = SafeParcelReader.w(parcel);
        i2 = 0;
        while (parcel.dataPosition() < i5) {
            i4 = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i4) != 1) {
            } else {
            }
            i2 = SafeParcelReader.e(parcel, i4);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i5);
        se obj6 = new se(i2);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new se[i];
    }
}
