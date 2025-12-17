package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class c1 implements Parcelable.Creator<com.google.android.gms.common.internal.t> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i3;
        int i2;
        int i4;
        int i8;
        int i5;
        int i6;
        int i7;
        final int i9 = SafeParcelReader.w(parcel);
        i6 = i5;
        while (parcel.dataPosition() < i9) {
            i = SafeParcelReader.p(parcel);
            i3 = SafeParcelReader.k(i);
            if (i3 != 1) {
            } else {
            }
            i2 = i;
            if (i3 != 2) {
            } else {
            }
            i4 = i;
            if (i3 != 3) {
            } else {
            }
            i8 = i;
            if (i3 != 4) {
            } else {
            }
            i5 = i;
            if (i3 != 5) {
            } else {
            }
            i6 = i;
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i9);
        super(i2, i4, i8, i5, i6);
        return obj10;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new t[i];
    }
}
