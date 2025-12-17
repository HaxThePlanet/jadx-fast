package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class xd implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.wd> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i6;
        int i5;
        int i3;
        int i;
        int i2;
        int i4;
        final int i7 = SafeParcelReader.w(parcel);
        i3 = i5;
        while (parcel.dataPosition() < i7) {
            i = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i);
            if (i2 != 1) {
            } else {
            }
            i6 = SafeParcelReader.d(parcel, i, PhoneAuthCredential.CREATOR);
            if (i2 != 2) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i);
            if (i2 != 3) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i);
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i7);
        wd obj8 = new wd(i6, i5, i3);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new wd[i];
    }
}
