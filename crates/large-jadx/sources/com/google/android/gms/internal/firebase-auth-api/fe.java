package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class fe implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ee> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i3;
        int i6;
        int i4;
        int i2;
        int i5;
        final int i7 = SafeParcelReader.w(parcel);
        i6 = i3;
        while (parcel.dataPosition() < i7) {
            i4 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i4);
            if (i2 != 1) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i4);
            if (i2 != 2) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i4);
            if (i2 != 3) {
            } else {
            }
            i6 = SafeParcelReader.e(parcel, i4);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i7);
        ee obj8 = new ee(i, i3, i6);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ee[i];
    }
}
