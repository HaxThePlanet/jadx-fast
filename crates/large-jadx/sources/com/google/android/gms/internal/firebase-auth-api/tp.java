package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class tp implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.sp> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i3;
        int i5;
        int i4;
        int i;
        final int i6 = SafeParcelReader.w(parcel);
        i2 = 0;
        i3 = 0;
        while (parcel.dataPosition() < i6) {
            i5 = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i5);
            if (i4 != 1) {
            } else {
            }
            i2 = SafeParcelReader.r(parcel, i5);
            if (i4 != 2) {
            } else {
            }
            i3 = SafeParcelReader.g(parcel, i5);
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i6);
        sp obj7 = new sp(i2, i3);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new sp[i];
    }
}
