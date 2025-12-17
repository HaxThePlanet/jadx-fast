package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zze;

/* loaded from: classes2.dex */
public final class zzs implements Parcelable.Creator<com.google.firebase.auth.internal.zzr> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i3;
        int i2;
        int i5;
        int i6;
        int i4;
        final int i7 = SafeParcelReader.w(parcel);
        i2 = i3;
        while (parcel.dataPosition() < i7) {
            i5 = SafeParcelReader.p(parcel);
            i6 = SafeParcelReader.k(i5);
            if (i6 != 1) {
            } else {
            }
            i = SafeParcelReader.d(parcel, i5, zzx.CREATOR);
            if (i6 != 2) {
            } else {
            }
            i3 = SafeParcelReader.d(parcel, i5, zzp.CREATOR);
            if (i6 != 3) {
            } else {
            }
            i2 = SafeParcelReader.d(parcel, i5, zze.CREATOR);
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i7);
        zzr obj8 = new zzr(i, i3, i2);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zzr[i];
    }
}
