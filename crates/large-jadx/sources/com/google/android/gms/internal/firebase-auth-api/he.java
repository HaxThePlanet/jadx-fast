package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class he implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ge> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i;
        int i5;
        int i4;
        int i2;
        final int i6 = SafeParcelReader.w(parcel);
        i = i3;
        while (parcel.dataPosition() < i6) {
            i5 = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i5);
            if (i4 != 1) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i5);
            if (i4 != 2) {
            } else {
            }
            i = SafeParcelReader.d(parcel, i5, up.CREATOR);
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i6);
        ge obj7 = new ge(i3, i);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ge[i];
    }
}
