package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzag implements Parcelable.Creator<com.google.firebase.auth.TwitterAuthCredential> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i3;
        int i5;
        int i2;
        int i4;
        final int i6 = SafeParcelReader.w(parcel);
        i3 = i;
        while (parcel.dataPosition() < i6) {
            i5 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i5);
            if (i2 != 1) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i5);
            if (i2 != 2) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i5);
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i6);
        TwitterAuthCredential obj7 = new TwitterAuthCredential(i, i3);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new TwitterAuthCredential[i];
    }
}
