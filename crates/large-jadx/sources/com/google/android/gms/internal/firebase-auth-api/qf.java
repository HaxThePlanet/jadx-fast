package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class qf implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.pf> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i5;
        int i3;
        int i4;
        int i;
        int i2;
        final int i6 = SafeParcelReader.w(parcel);
        i3 = i5;
        while (parcel.dataPosition() < i6) {
            i4 = SafeParcelReader.p(parcel);
            i = SafeParcelReader.k(i4);
            if (i != 1) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i4);
            if (i != 2) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i4);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i6);
        pf obj7 = new pf(i5, i3);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new pf[i];
    }
}
