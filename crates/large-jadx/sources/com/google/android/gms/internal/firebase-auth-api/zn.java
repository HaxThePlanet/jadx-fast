package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zn implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.yn> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i8;
        int i5;
        int cREATOR;
        int i6;
        int i7;
        int i4;
        int i3;
        int i;
        int i2;
        final int i10 = SafeParcelReader.w(parcel);
        i3 = i7;
        i2 = i;
        while (parcel.dataPosition() < i10) {
            i8 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel, i8);
            i2 = i8;
            i = i8;
            i3 = i8;
            i4 = i8;
            i7 = i8;
            i6 = i8;
        }
        SafeParcelReader.j(parcel, i10);
        super(i6, i7, i4, i3, i, i2);
        return obj11;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new yn[i];
    }
}
