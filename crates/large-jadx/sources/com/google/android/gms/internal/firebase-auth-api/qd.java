package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class qd implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.pd> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i5;
        int i6;
        int i2;
        int i4;
        int i;
        final int i7 = SafeParcelReader.w(parcel);
        i6 = i5;
        while (parcel.dataPosition() < i7) {
            i2 = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i2);
            if (i4 != 1) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i2);
            if (i4 != 2) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i2);
            if (i4 != 3) {
            } else {
            }
            i6 = SafeParcelReader.e(parcel, i2);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i7);
        pd obj8 = new pd(i3, i5, i6);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new pd[i];
    }
}
