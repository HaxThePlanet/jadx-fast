package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class je implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ie> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i5;
        int i2;
        int i;
        int i4;
        final int i6 = SafeParcelReader.w(parcel);
        i5 = i3;
        while (parcel.dataPosition() < i6) {
            i2 = SafeParcelReader.p(parcel);
            i = SafeParcelReader.k(i2);
            if (i != 1) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i2);
            if (i != 2) {
            } else {
            }
            i5 = SafeParcelReader.d(parcel, i2, PhoneAuthCredential.CREATOR);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i6);
        ie obj7 = new ie(i3, i5);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ie[i];
    }
}
