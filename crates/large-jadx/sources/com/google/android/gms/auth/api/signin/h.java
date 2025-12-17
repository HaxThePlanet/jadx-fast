package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<com.google.android.gms.auth.api.signin.SignInAccount> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        String str2;
        String str;
        int i4;
        int i3;
        int i;
        int i2;
        final int i5 = SafeParcelReader.w(parcel);
        i4 = i6;
        str = str2;
        while (parcel.dataPosition() < i5) {
            i3 = SafeParcelReader.p(parcel);
            i = SafeParcelReader.k(i3);
            if (i != 4) {
            } else {
            }
            str2 = SafeParcelReader.e(parcel, i3);
            if (i != 7) {
            } else {
            }
            i4 = SafeParcelReader.d(parcel, i3, GoogleSignInAccount.CREATOR);
            if (i != 8) {
            } else {
            }
            str = SafeParcelReader.e(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i5);
        SignInAccount obj8 = new SignInAccount(str2, i4, str);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
