package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzah implements Parcelable.Creator<com.google.firebase.auth.UserProfileChangeRequest> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i7;
        int i6;
        int i2;
        int i;
        int i3;
        int i4;
        int i5;
        final int i8 = SafeParcelReader.w(parcel);
        i = i2;
        i6 = i7;
        while (parcel.dataPosition() < i8) {
            i3 = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i3);
            if (i4 != 2) {
            } else {
            }
            i2 = SafeParcelReader.e(parcel, i3);
            if (i4 != 3) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i3);
            if (i4 != 4) {
            } else {
            }
            i7 = SafeParcelReader.l(parcel, i3);
            if (i4 != 5) {
            } else {
            }
            i6 = SafeParcelReader.l(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i8);
        UserProfileChangeRequest obj9 = new UserProfileChangeRequest(i2, i, i7, i6);
        return obj9;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new UserProfileChangeRequest[i];
    }
}
