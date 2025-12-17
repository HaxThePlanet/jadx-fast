package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zze;

/* loaded from: classes2.dex */
public final class wf implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.vf> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i7;
        int i5;
        int i4;
        int i;
        int i6;
        int i2;
        int i3;
        final int i8 = SafeParcelReader.w(parcel);
        i = i4;
        while (parcel.dataPosition() < i8) {
            i6 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i6);
            if (i2 != 1) {
            } else {
            }
            i7 = SafeParcelReader.d(parcel, i6, Status.CREATOR);
            if (i2 != 2) {
            } else {
            }
            i5 = SafeParcelReader.d(parcel, i6, zze.CREATOR);
            if (i2 != 3) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i6);
            if (i2 != 4) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i6);
            SafeParcelReader.v(parcel, i6);
        }
        SafeParcelReader.j(parcel, i8);
        vf obj9 = new vf(i7, i5, i4, i);
        return obj9;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new vf[i];
    }
}
