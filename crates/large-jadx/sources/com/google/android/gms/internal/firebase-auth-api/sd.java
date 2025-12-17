package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class sd implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.rd> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i3;
        int i5;
        int i6;
        int i4;
        int i;
        final int i7 = SafeParcelReader.w(parcel);
        i5 = i3;
        while (parcel.dataPosition() < i7) {
            i6 = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i6);
            if (i4 != 1) {
            } else {
            }
            i2 = SafeParcelReader.e(parcel, i6);
            if (i4 != 2) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i6);
            if (i4 != 3) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i6);
            SafeParcelReader.v(parcel, i6);
        }
        SafeParcelReader.j(parcel, i7);
        rd obj8 = new rd(i2, i3, i5);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new rd[i];
    }
}
