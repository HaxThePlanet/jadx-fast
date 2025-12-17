package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class gf implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ff> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i5;
        int i;
        int i3;
        int i4;
        final int i6 = SafeParcelReader.w(parcel);
        i5 = i2;
        while (parcel.dataPosition() < i6) {
            i = SafeParcelReader.p(parcel);
            i3 = SafeParcelReader.k(i);
            if (i3 != 1) {
            } else {
            }
            i2 = SafeParcelReader.d(parcel, i, PhoneAuthCredential.CREATOR);
            if (i3 != 2) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i);
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i6);
        ff obj7 = new ff(i2, i5);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ff[i];
    }
}
