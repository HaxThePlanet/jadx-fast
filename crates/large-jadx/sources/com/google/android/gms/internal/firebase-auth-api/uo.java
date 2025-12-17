package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class uo implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.to> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i7;
        int i8;
        int i6;
        int i4;
        int i;
        int i2;
        int i5;
        final int i9 = SafeParcelReader.w(parcel);
        i2 = i;
        while (parcel.dataPosition() < i9) {
            i3 = SafeParcelReader.p(parcel);
            i7 = SafeParcelReader.k(i3);
            if (i7 != 2) {
            } else {
            }
            i8 = i3;
            if (i7 != 3) {
            } else {
            }
            i6 = i3;
            if (i7 != 4) {
            } else {
            }
            i4 = i3;
            if (i7 != 5) {
            } else {
            }
            i = i3;
            if (i7 != 6) {
            } else {
            }
            i2 = i3;
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i9);
        super(i8, i6, i4, i, i2);
        return obj10;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new to[i];
    }
}
