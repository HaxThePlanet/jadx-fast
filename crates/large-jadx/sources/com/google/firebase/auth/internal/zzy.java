package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.firebase-auth-api.to;
import com.google.firebase.auth.zze;

/* loaded from: classes2.dex */
public final class zzy implements Parcelable.Creator<com.google.firebase.auth.internal.zzx> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int cREATOR;
        int i12;
        int i9;
        int i13;
        int i;
        int i6;
        int i2;
        int i7;
        int i3;
        int i5;
        int i11;
        int i10;
        int i8;
        Parcel parcel2 = parcel;
        final int i14 = SafeParcelReader.w(parcel);
        i8 = i10;
        i11 = cREATOR;
        while (parcel.dataPosition() < i14) {
            i4 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i4);
            i8 = i4;
            i10 = i4;
            i11 = i4;
            i5 = i4;
            i3 = i4;
            i7 = i4;
            i2 = i4;
            i6 = i4;
            i = i4;
            i13 = i4;
            i9 = i4;
            i12 = i4;
        }
        SafeParcelReader.j(parcel2, i14);
        super(i12, i9, i13, i, i6, i2, i7, i3, i5, i11, i10, i8);
        return zzx;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zzx[i];
    }
}
