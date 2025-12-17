package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zp implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.yp> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i5;
        int i3;
        int i;
        int i7;
        int i6;
        int i4;
        final int i8 = SafeParcelReader.w(parcel);
        i7 = i;
        i6 = i5;
        i4 = i9;
        while (parcel.dataPosition() < i8) {
            i2 = SafeParcelReader.p(parcel);
            i5 = SafeParcelReader.k(i2);
            if (i5 != 2) {
            } else {
            }
            i = i2;
            if (i5 != 3) {
            } else {
            }
            i7 = i2;
            if (i5 != 4) {
            } else {
            }
            i6 = i2;
            if (i5 != 5) {
            } else {
            }
            i4 = i2;
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i8);
        super(i, i7, i6, obj9, i4);
        return obj12;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new yp[i];
    }
}
