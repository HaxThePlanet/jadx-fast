package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class r implements Parcelable.Creator<com.google.android.gms.common.d> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i2;
        int i6;
        int i5;
        int i4;
        int i;
        final int i7 = SafeParcelReader.w(parcel);
        i3 = 0;
        i2 = 0;
        i6 = -1;
        while (parcel.dataPosition() < i7) {
            i5 = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i5);
            if (i4 != 1) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i5);
            if (i4 != 2) {
            } else {
            }
            i2 = SafeParcelReader.r(parcel, i5);
            if (i4 != 3) {
            } else {
            }
            i6 = SafeParcelReader.s(parcel, i5);
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i7);
        d obj9 = new d(i3, i2, i6, obj4);
        return obj9;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new d[i];
    }
}
