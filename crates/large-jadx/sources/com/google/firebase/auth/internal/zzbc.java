package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* loaded from: classes2.dex */
public final class zzbc implements Parcelable.Creator<com.google.firebase.auth.internal.zzbb> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i;
        int i3;
        int i2;
        final int i5 = SafeParcelReader.w(parcel);
        i4 = 0;
        while (parcel.dataPosition() < i5) {
            i = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i) != 1) {
            } else {
            }
            i4 = SafeParcelReader.i(parcel, i, PhoneMultiFactorInfo.CREATOR);
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i5);
        zzbb obj6 = new zzbb(i4);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zzbb[i];
    }
}
