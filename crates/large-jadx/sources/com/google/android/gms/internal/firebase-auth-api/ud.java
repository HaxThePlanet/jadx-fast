package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class ud implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.td> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i4;
        int i2;
        int i3;
        final int i5 = SafeParcelReader.w(parcel);
        i = 0;
        while (parcel.dataPosition() < i5) {
            i4 = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i4) != 1) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i4);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i5);
        td obj6 = new td(i);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new td[i];
    }
}
