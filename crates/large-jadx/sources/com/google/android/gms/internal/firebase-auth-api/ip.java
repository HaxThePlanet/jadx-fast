package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class ip implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.hp> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i5;
        int i6;
        int i7;
        int i3;
        int i9;
        int i8;
        int i2;
        int i;
        int i4;
        int i10;
        Parcel parcel2 = parcel;
        final int i12 = SafeParcelReader.w(parcel);
        i4 = i9;
        i10 = i;
        i3 = i13;
        while (parcel.dataPosition() < i12) {
            i5 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i5);
            i10 = i5;
            i4 = i5;
            i = i5;
            i2 = i5;
            i8 = i5;
            i9 = i5;
            i3 = i5;
            i7 = i5;
        }
        SafeParcelReader.j(parcel2, i12);
        super(i7, i3, obj9, i9, i8, i2, i, i4, i10);
        return hpVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new hp[i];
    }
}
