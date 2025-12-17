package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class mf implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.lf> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i5;
        int i4;
        int i2;
        int i3;
        final int i6 = SafeParcelReader.w(parcel);
        i5 = i;
        while (parcel.dataPosition() < i6) {
            i4 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i4);
            if (i2 != 1) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i4);
            if (i2 != 2) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i4);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i6);
        lf obj7 = new lf(i, i5);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new lf[i];
    }
}
