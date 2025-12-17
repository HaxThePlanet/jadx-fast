package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class m1 implements Parcelable.Creator<com.google.android.gms.common.internal.l1> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i4;
        int i3;
        int i5;
        int i7;
        int i6;
        int i;
        final int i8 = SafeParcelReader.w(parcel);
        i5 = i9;
        i4 = i3;
        while (parcel.dataPosition() < i8) {
            i7 = SafeParcelReader.p(parcel);
            i6 = SafeParcelReader.k(i7);
            if (i6 != 1) {
            } else {
            }
            i2 = SafeParcelReader.a(parcel, i7);
            if (i6 != 2) {
            } else {
            }
            i4 = SafeParcelReader.h(parcel, i7, d.CREATOR);
            if (i6 != 3) {
            } else {
            }
            i5 = SafeParcelReader.r(parcel, i7);
            if (i6 != 4) {
            } else {
            }
            i3 = SafeParcelReader.d(parcel, i7, e.CREATOR);
            SafeParcelReader.v(parcel, i7);
        }
        SafeParcelReader.j(parcel, i8);
        l1 obj9 = new l1(i2, i4, i5, i3);
        return obj9;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new l1[i];
    }
}
