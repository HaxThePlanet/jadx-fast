package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class d0 implements Parcelable.Creator<com.google.android.gms.common.c0> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i5;
        int i4;
        int i8;
        int i6;
        int i2;
        int i3;
        int i7;
        int i;
        final int i9 = SafeParcelReader.w(parcel);
        i7 = i6;
        i = i3;
        while (parcel.dataPosition() < i9) {
            i5 = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i5);
            if (i4 != 1) {
            } else {
            }
            i6 = i5;
            if (i4 != 2) {
            } else {
            }
            i2 = i5;
            if (i4 != 3) {
            } else {
            }
            i3 = i5;
            if (i4 != 4) {
            } else {
            }
            i7 = i5;
            if (i4 != 5) {
            } else {
            }
            i = i5;
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i9);
        super(i6, i2, i3, i7, i);
        return obj10;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new c0[i];
    }
}
