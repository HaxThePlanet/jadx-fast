package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* loaded from: classes2.dex */
public final class zzah implements Parcelable.Creator<com.google.firebase.auth.internal.zzag> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i5;
        int i6;
        int i2;
        int i;
        int i3;
        final int i7 = SafeParcelReader.w(parcel);
        i6 = i5;
        while (parcel.dataPosition() < i7) {
            i2 = SafeParcelReader.p(parcel);
            i = SafeParcelReader.k(i2);
            if (i != 1) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i2);
            if (i != 2) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i2);
            if (i != 3) {
            } else {
            }
            i6 = SafeParcelReader.i(parcel, i2, PhoneMultiFactorInfo.CREATOR);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i7);
        zzag obj8 = new zzag(i4, i5, i6);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zzag[i];
    }
}
