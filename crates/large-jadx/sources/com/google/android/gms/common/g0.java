package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class g0 implements Parcelable.Creator<com.google.android.gms.common.f0> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        final int i7 = SafeParcelReader.w(parcel);
        i3 = i8;
        i2 = i;
        while (parcel.dataPosition() < i7) {
            i4 = SafeParcelReader.p(parcel);
            i5 = SafeParcelReader.k(i4);
            if (i5 != 1) {
            } else {
            }
            i = SafeParcelReader.l(parcel, i4);
            if (i5 != 2) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i4);
            if (i5 != 3) {
            } else {
            }
            i2 = SafeParcelReader.r(parcel, i4);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i7);
        f0 obj8 = new f0(i, i3, i2);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new f0[i];
    }
}
