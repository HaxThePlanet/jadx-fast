package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.firebase-auth-api.up;

/* loaded from: classes2.dex */
public final class zzf implements Parcelable.Creator<com.google.firebase.auth.zze> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i7;
        int cREATOR;
        int i2;
        int i;
        int i8;
        int i4;
        int i5;
        int i9;
        int i3;
        final int i10 = SafeParcelReader.w(parcel);
        i3 = i9;
        while (parcel.dataPosition() < i10) {
            i7 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel, i7);
            i3 = i7;
            i9 = i7;
            i5 = i7;
            i4 = i7;
            i8 = i7;
            i = i7;
            i2 = i7;
        }
        SafeParcelReader.j(parcel, i10);
        super(i2, i, i8, i4, i5, i9, i3);
        return obj11;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zze[i];
    }
}
