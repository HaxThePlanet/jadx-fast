package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzh implements Parcelable.Creator<com.google.firebase.auth.FacebookAuthCredential> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i3;
        int i4;
        int i;
        final int i5 = SafeParcelReader.w(parcel);
        i2 = 0;
        while (parcel.dataPosition() < i5) {
            i3 = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i3) != 1) {
            } else {
            }
            i2 = SafeParcelReader.e(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i5);
        FacebookAuthCredential obj6 = new FacebookAuthCredential(i2);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new FacebookAuthCredential[i];
    }
}
