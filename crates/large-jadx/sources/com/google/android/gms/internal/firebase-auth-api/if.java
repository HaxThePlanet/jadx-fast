package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class if implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.hf> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        boolean z;
        int i2;
        int i4;
        int i6;
        int i11;
        int i;
        int i7;
        int i8;
        int i9;
        int i10;
        int i3;
        int i5;
        Parcel parcel2 = parcel;
        final int i12 = SafeParcelReader.w(parcel);
        i5 = i9;
        i3 = i10;
        i7 = i13;
        while (parcel.dataPosition() < i12) {
            i2 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i2);
            i5 = i2;
            i3 = i2;
            i10 = i2;
            i9 = i2;
            i8 = i2;
            i7 = i2;
            i = i2;
            i11 = i2;
            i6 = i2;
        }
        SafeParcelReader.j(parcel2, i12);
        super(i6, i11, i, i7, obj11, i8, i9, i10, i3, i5);
        return hfVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new hf[i];
    }
}
