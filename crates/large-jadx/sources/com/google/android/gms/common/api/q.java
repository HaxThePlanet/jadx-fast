package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class q implements Parcelable.Creator<com.google.android.gms.common.api.Status> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int cREATOR;
        int i5;
        int i6;
        int i;
        int i7;
        int i4;
        int i2;
        final int i8 = SafeParcelReader.w(parcel);
        i = i6;
        i2 = i4;
        while (parcel.dataPosition() < i8) {
            i3 = SafeParcelReader.p(parcel);
            cREATOR = SafeParcelReader.k(i3);
            if (cREATOR != 1) {
            } else {
            }
            i = i3;
            if (cREATOR != 2) {
            } else {
            }
            i7 = i3;
            if (cREATOR != 3) {
            } else {
            }
            i4 = i3;
            if (cREATOR != 4) {
            } else {
            }
            i2 = i3;
            if (cREATOR != 1000) {
            } else {
            }
            i6 = i3;
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i8);
        super(i6, i, i7, i4, i2);
        return obj10;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new Status[i];
    }
}
