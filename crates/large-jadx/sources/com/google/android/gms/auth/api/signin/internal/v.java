package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class v implements Parcelable.Creator<com.google.android.gms.auth.api.signin.internal.SignInConfiguration> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i5;
        int i2;
        int i3;
        int i;
        final int i6 = SafeParcelReader.w(parcel);
        i5 = i4;
        while (parcel.dataPosition() < i6) {
            i2 = SafeParcelReader.p(parcel);
            i3 = SafeParcelReader.k(i2);
            if (i3 != 2) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i2);
            if (i3 != 5) {
            } else {
            }
            i5 = SafeParcelReader.d(parcel, i2, GoogleSignInOptions.CREATOR);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i6);
        SignInConfiguration obj7 = new SignInConfiguration(i4, i5);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
