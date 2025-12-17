package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class e implements Parcelable.Creator<com.google.android.gms.auth.api.signin.GoogleSignInAccount> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int cREATOR;
        int i9;
        int i11;
        int i8;
        int i7;
        int i10;
        int i5;
        int i12;
        int i3;
        int i;
        int i2;
        int i6;
        int i13;
        Parcel parcel2 = parcel;
        final int i14 = SafeParcelReader.w(parcel);
        i13 = i6;
        i9 = cREATOR;
        i3 = i15;
        while (parcel.dataPosition() < i14) {
            i4 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i4);
            i13 = i4;
            i6 = i4;
            i2 = i4;
            i = i4;
            i3 = i4;
            i12 = i4;
            i5 = i4;
            i10 = i4;
            i7 = i4;
            i8 = i4;
            i11 = i4;
            i9 = i4;
        }
        SafeParcelReader.j(parcel2, i14);
        super(i9, i11, i8, i7, i10, i5, i12, i3, obj15, i, i2, i6, i13);
        return googleSignInAccount;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
