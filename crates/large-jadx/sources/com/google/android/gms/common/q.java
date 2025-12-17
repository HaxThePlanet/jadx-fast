package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class q implements Parcelable.Creator<com.google.android.gms.common.b> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i5;
        int i3;
        int i4;
        int i6;
        int i2;
        int i7;
        int i;
        final int i8 = SafeParcelReader.w(parcel);
        i6 = i4;
        i3 = i5;
        while (parcel.dataPosition() < i8) {
            i2 = SafeParcelReader.p(parcel);
            i7 = SafeParcelReader.k(i2);
            if (i7 != 1) {
            } else {
            }
            i4 = SafeParcelReader.r(parcel, i2);
            if (i7 != 2) {
            } else {
            }
            i6 = SafeParcelReader.r(parcel, i2);
            if (i7 != 3) {
            } else {
            }
            i5 = SafeParcelReader.d(parcel, i2, PendingIntent.CREATOR);
            if (i7 != 4) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i2);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i8);
        b obj9 = new b(i4, i6, i5, i3);
        return obj9;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new b[i];
    }
}
