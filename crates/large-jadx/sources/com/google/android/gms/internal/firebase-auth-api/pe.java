package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
public final class pe implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.oe> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i5;
        int i6;
        int i;
        int i3;
        int i2;
        int i4;
        final int i7 = SafeParcelReader.w(parcel);
        i = i6;
        while (parcel.dataPosition() < i7) {
            i3 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i3);
            if (i2 != 1) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i3);
            if (i2 != 2) {
            } else {
            }
            i6 = SafeParcelReader.d(parcel, i3, ActionCodeSettings.CREATOR);
            if (i2 != 3) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i7);
        oe obj8 = new oe(i5, i6, i);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new oe[i];
    }
}
