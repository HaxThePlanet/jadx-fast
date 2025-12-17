package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzae implements Parcelable.Creator<com.google.firebase.auth.PhoneMultiFactorInfo> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i6;
        int i3;
        int i7;
        int i4;
        int i5;
        int i;
        final int i8 = SafeParcelReader.w(parcel);
        i = i4;
        i5 = i6;
        while (parcel.dataPosition() < i8) {
            i2 = SafeParcelReader.p(parcel);
            i6 = SafeParcelReader.k(i2);
            if (i6 != 1) {
            } else {
            }
            i7 = i2;
            if (i6 != 2) {
            } else {
            }
            i4 = i2;
            if (i6 != 3) {
            } else {
            }
            i5 = i2;
            if (i6 != 4) {
            } else {
            }
            i = i2;
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i8);
        super(i7, i4, i5, obj8, i);
        return obj11;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new PhoneMultiFactorInfo[i];
    }
}
