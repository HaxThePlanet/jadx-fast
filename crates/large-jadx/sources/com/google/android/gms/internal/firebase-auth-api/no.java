package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zze;

/* loaded from: classes2.dex */
public final class no implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.mo> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i6;
        Parcelable.Creator cREATOR;
        int i14;
        int i;
        int i10;
        int i7;
        int i2;
        int i8;
        int i3;
        int i12;
        int i11;
        int i5;
        int i13;
        int i4;
        int i9;
        Parcel parcel2 = parcel;
        final int i15 = SafeParcelReader.w(parcel);
        i5 = i11;
        i13 = i10;
        i9 = i4;
        while (parcel.dataPosition() < i15) {
            i6 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i6);
            i9 = i6;
            i4 = i6;
            i13 = i6;
            i5 = i6;
            i11 = i6;
            i12 = i6;
            i3 = i6;
            i8 = i6;
            i2 = i6;
            i7 = i6;
            i10 = i6;
            i = i6;
            i14 = i6;
        }
        SafeParcelReader.j(parcel2, i15);
        super(i14, i, i10, i7, i2, i8, i3, i12, i11, obj16, i5, obj18, i13, i4, i9);
        return moVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new mo[i];
    }
}
