package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class af implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ze> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i;
        int i3;
        int i2;
        int i5;
        final int i6 = SafeParcelReader.w(parcel);
        i = i4;
        while (parcel.dataPosition() < i6) {
            i3 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i3);
            if (i2 != 1) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i3);
            if (i2 != 2) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i6);
        ze obj7 = new ze(i4, i);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ze[i];
    }
}
