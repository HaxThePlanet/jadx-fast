package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zze;

/* loaded from: classes2.dex */
public final class zf implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.yf> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i4;
        int i;
        int i2;
        int i5;
        int i6;
        final int i7 = SafeParcelReader.w(parcel);
        i = i4;
        while (parcel.dataPosition() < i7) {
            i2 = SafeParcelReader.p(parcel);
            i5 = SafeParcelReader.k(i2);
            if (i5 != 1) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i2);
            if (i5 != 2) {
            } else {
            }
            i4 = SafeParcelReader.i(parcel, i2, xo.CREATOR);
            if (i5 != 3) {
            } else {
            }
            i = SafeParcelReader.d(parcel, i2, zze.CREATOR);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i7);
        yf obj8 = new yf(i3, i4, i);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new yf[i];
    }
}
