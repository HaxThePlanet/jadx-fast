package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class r0 implements Parcelable.Creator<com.google.android.gms.common.internal.q0> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i4;
        int i3;
        int i5;
        int i6;
        int i7;
        int i;
        final int i8 = SafeParcelReader.w(parcel);
        i5 = i3;
        i4 = i2;
        while (parcel.dataPosition() < i8) {
            i6 = SafeParcelReader.p(parcel);
            i7 = SafeParcelReader.k(i6);
            if (i7 != 1) {
            } else {
            }
            i3 = SafeParcelReader.r(parcel, i6);
            if (i7 != 2) {
            } else {
            }
            i2 = SafeParcelReader.d(parcel, i6, Account.CREATOR);
            if (i7 != 3) {
            } else {
            }
            i5 = SafeParcelReader.r(parcel, i6);
            if (i7 != 4) {
            } else {
            }
            i4 = SafeParcelReader.d(parcel, i6, GoogleSignInAccount.CREATOR);
            SafeParcelReader.v(parcel, i6);
        }
        SafeParcelReader.j(parcel, i8);
        q0 obj9 = new q0(i3, i2, i5, i4);
        return obj9;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new q0[i];
    }
}
