package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zze;

/* loaded from: classes2.dex */
public final class zzaf implements Parcelable.Creator<com.google.firebase.auth.internal.zzae> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        Parcelable.Creator cREATOR;
        int i4;
        int i3;
        int i6;
        int i5;
        int i;
        int i7;
        final int i8 = SafeParcelReader.w(parcel);
        i = i5;
        while (parcel.dataPosition() < i8) {
            i2 = SafeParcelReader.p(parcel);
            cREATOR = SafeParcelReader.k(i2);
            if (cREATOR != 1) {
            } else {
            }
            i4 = i2;
            if (cREATOR != 2) {
            } else {
            }
            i3 = i2;
            if (cREATOR != 3) {
            } else {
            }
            i6 = i2;
            if (cREATOR != 4) {
            } else {
            }
            i5 = i2;
            if (cREATOR != 5) {
            } else {
            }
            i = i2;
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i8);
        super(i4, i3, i6, i5, i);
        return obj10;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zzae[i];
    }
}
