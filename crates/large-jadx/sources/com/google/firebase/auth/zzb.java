package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzb implements Parcelable.Creator<com.google.firebase.auth.ActionCodeSettings> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i12;
        int i6;
        int i8;
        int i7;
        int i9;
        int i5;
        int i3;
        int i4;
        int i10;
        int i11;
        int i;
        int i2;
        final int i13 = SafeParcelReader.w(parcel);
        i = i10;
        i2 = i11;
        while (parcel.dataPosition() < i13) {
            i12 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel, i12);
            i2 = i12;
            i = i12;
            i11 = i12;
            i10 = i12;
            i4 = i12;
            i3 = i12;
            i5 = i12;
            i9 = i12;
            i7 = i12;
            i8 = i12;
        }
        SafeParcelReader.j(parcel, i13);
        super(i8, i7, i9, i5, i3, i4, i10, i11, i, i2);
        return obj15;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ActionCodeSettings[i];
    }
}
