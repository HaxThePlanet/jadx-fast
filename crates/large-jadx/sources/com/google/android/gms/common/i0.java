package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class i0 implements Parcelable.Creator<com.google.android.gms.common.h0> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i5;
        int i6;
        int i7;
        int i;
        int i2;
        int i3;
        int i4;
        final int i8 = SafeParcelReader.w(parcel);
        i = i7;
        i6 = i5;
        while (parcel.dataPosition() < i8) {
            i2 = SafeParcelReader.p(parcel);
            i3 = SafeParcelReader.k(i2);
            if (i3 != 1) {
            } else {
            }
            i7 = SafeParcelReader.e(parcel, i2);
            if (i3 != 2) {
            } else {
            }
            i = SafeParcelReader.q(parcel, i2);
            if (i3 != 3) {
            } else {
            }
            i5 = SafeParcelReader.l(parcel, i2);
            if (i3 != 4) {
            } else {
            }
            i6 = SafeParcelReader.l(parcel, i2);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i8);
        h0 obj9 = new h0(i7, i, i5, i6);
        return obj9;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new h0[i];
    }
}
