package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class zd implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.yd> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i;
        int i5;
        int i2;
        int i4;
        final int i6 = SafeParcelReader.w(parcel);
        i = i3;
        while (parcel.dataPosition() < i6) {
            i5 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i5);
            if (i2 != 1) {
            } else {
            }
            i3 = SafeParcelReader.d(parcel, i5, PhoneAuthCredential.CREATOR);
            if (i2 != 2) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i5);
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i6);
        yd obj7 = new yd(i3, i);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new yd[i];
    }
}
