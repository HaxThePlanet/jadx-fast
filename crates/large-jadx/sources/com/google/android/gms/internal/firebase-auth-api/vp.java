package com.google.android.gms.internal.firebase-auth-api;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class vp implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.up> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i12;
        int i11;
        int i5;
        int i13;
        int i15;
        int i;
        int i2;
        int i9;
        int i17;
        int i16;
        int i7;
        int i18;
        int i4;
        int i10;
        int i3;
        int i6;
        int i14;
        int i8;
        Parcel parcel2 = parcel;
        final int i19 = SafeParcelReader.w(parcel);
        i14 = i18;
        i8 = i6;
        while (parcel.dataPosition() < i19) {
            i12 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i12);
            i8 = i12;
            i14 = i12;
            i6 = i12;
            i3 = i12;
            i10 = i12;
            i4 = i12;
            i18 = i12;
            i7 = i12;
            i16 = i12;
            i17 = i12;
            i9 = i12;
            i2 = i12;
            i = i12;
            i15 = i12;
            i13 = i12;
            i5 = i12;
        }
        SafeParcelReader.j(parcel2, i19);
        super(i5, i13, i15, i, i2, i9, i17, i16, i7, i18, i4, i10, i3, i6, i14, i8);
        return upVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new up[i];
    }
}
