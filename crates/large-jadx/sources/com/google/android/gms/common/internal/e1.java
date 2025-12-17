package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class e1 implements Parcelable.Creator<com.google.android.gms.common.internal.d1> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i;
        int i2;
        int i4;
        final int i5 = SafeParcelReader.w(parcel);
        i3 = 0;
        while (parcel.dataPosition() < i5) {
            i = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i) != 1) {
            } else {
            }
            i3 = SafeParcelReader.r(parcel, i);
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i5);
        d1 obj6 = new d1(i3);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new d1[i];
    }
}
