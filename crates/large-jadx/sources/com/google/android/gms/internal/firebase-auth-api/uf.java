package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
public final class uf implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.tf> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i5;
        int i;
        int i6;
        int i2;
        int i3;
        final int i7 = SafeParcelReader.w(parcel);
        i = i5;
        while (parcel.dataPosition() < i7) {
            i6 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i6);
            if (i2 != 1) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i6);
            if (i2 != 2) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i6);
            if (i2 != 3) {
            } else {
            }
            i = SafeParcelReader.d(parcel, i6, ActionCodeSettings.CREATOR);
            SafeParcelReader.v(parcel, i6);
        }
        SafeParcelReader.j(parcel, i7);
        tf obj8 = new tf(i4, i5, i);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new tf[i];
    }
}
