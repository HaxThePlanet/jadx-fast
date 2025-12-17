package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class cf implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.bf> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i;
        int i6;
        int i2;
        int i5;
        int i3;
        final int i7 = SafeParcelReader.w(parcel);
        i6 = i;
        while (parcel.dataPosition() < i7) {
            i2 = SafeParcelReader.p(parcel);
            i5 = SafeParcelReader.k(i2);
            if (i5 != 1) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i2);
            if (i5 != 2) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i2);
            if (i5 != 3) {
            } else {
            }
            i6 = SafeParcelReader.e(parcel, i2);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i7);
        bf obj8 = new bf(i4, i, i6);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new bf[i];
    }
}
