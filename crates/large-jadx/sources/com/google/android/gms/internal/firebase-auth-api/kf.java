package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* loaded from: classes2.dex */
public final class kf implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.jf> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z;
        int i;
        int cREATOR;
        int i3;
        int i10;
        int i6;
        int i5;
        int i2;
        int i4;
        int i7;
        int i8;
        int i9;
        Parcel parcel2 = parcel;
        final int i11 = SafeParcelReader.w(parcel);
        i9 = i4;
        i8 = i7;
        i5 = i12;
        while (parcel.dataPosition() < i11) {
            i = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i);
            i9 = i;
            i8 = i;
            i7 = i;
            i4 = i;
            i2 = i;
            i5 = i;
            i6 = i;
            i10 = i;
            i3 = i;
        }
        SafeParcelReader.j(parcel2, i11);
        super(i3, i10, i6, i5, obj11, i2, i4, i7, i8, i9);
        return jfVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new jf[i];
    }
}
