package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class gp implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.fp> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i4;
        int i5;
        int i;
        int i6;
        int i3;
        int i7;
        final int i8 = SafeParcelReader.w(parcel);
        i = i5;
        while (parcel.dataPosition() < i8) {
            i6 = SafeParcelReader.p(parcel);
            i3 = SafeParcelReader.k(i6);
            if (i3 != 2) {
            } else {
            }
            i2 = SafeParcelReader.e(parcel, i6);
            if (i3 != 3) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i6);
            if (i3 != 4) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i6);
            if (i3 != 5) {
            } else {
            }
            i = SafeParcelReader.d(parcel, i6, xo.CREATOR);
            SafeParcelReader.v(parcel, i6);
        }
        SafeParcelReader.j(parcel, i8);
        fp obj9 = new fp(i2, i4, i5, i);
        return obj9;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new fp[i];
    }
}
