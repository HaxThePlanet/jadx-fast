package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class ap implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.zo> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i7;
        int i9;
        int i8;
        int i2;
        int i3;
        int i4;
        int i6;
        int i5;
        int i;
        final int i11 = SafeParcelReader.w(parcel);
        i = i5;
        while (parcel.dataPosition() < i11) {
            i7 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel, i7);
            i = i7;
            i5 = i7;
            i6 = i7;
            i4 = i7;
            i3 = i7;
            i2 = i7;
            i8 = i7;
        }
        SafeParcelReader.j(parcel, i11);
        super(i8, i2, i3, i4, i6, i5, i);
        return obj11;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zo[i];
    }
}
