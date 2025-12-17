package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzz implements Parcelable.Creator<com.google.firebase.auth.GithubAuthCredential> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i3;
        int i2;
        int i;
        final int i5 = SafeParcelReader.w(parcel);
        i4 = 0;
        while (parcel.dataPosition() < i5) {
            i3 = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i3) != 1) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i5);
        GithubAuthCredential obj6 = new GithubAuthCredential(i4);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new GithubAuthCredential[i];
    }
}
