package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class id implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.hd> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i2;
        int i;
        int i4;
        int i5;
        final int i6 = SafeParcelReader.w(parcel);
        i2 = i3;
        while (parcel.dataPosition() < i6) {
            i = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i);
            if (i4 != 1) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i);
            if (i4 != 2) {
            } else {
            }
            i2 = SafeParcelReader.e(parcel, i);
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i6);
        hd obj7 = new hd(i3, i2);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new hd[i];
    }
}
