package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzaa implements Parcelable.Creator<com.google.firebase.auth.GoogleAuthCredential> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i5;
        int i4;
        int i3;
        int i2;
        final int i6 = SafeParcelReader.w(parcel);
        i5 = i;
        while (parcel.dataPosition() < i6) {
            i4 = SafeParcelReader.p(parcel);
            i3 = SafeParcelReader.k(i4);
            if (i3 != 1) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i4);
            if (i3 != 2) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i4);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i6);
        GoogleAuthCredential obj7 = new GoogleAuthCredential(i, i5);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new GoogleAuthCredential[i];
    }
}
