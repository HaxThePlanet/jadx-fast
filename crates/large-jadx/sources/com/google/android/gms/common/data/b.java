package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<com.google.android.gms.common.data.DataHolder> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i6;
        int cREATOR;
        int i;
        int i7;
        int i3;
        int i4;
        int i2;
        int i5;
        final int i8 = SafeParcelReader.w(parcel);
        i2 = i7;
        i5 = i4;
        while (parcel.dataPosition() < i8) {
            i6 = SafeParcelReader.p(parcel);
            cREATOR = SafeParcelReader.k(i6);
            if (cREATOR != 1) {
            } else {
            }
            i3 = i6;
            if (cREATOR != 2) {
            } else {
            }
            i4 = i6;
            if (cREATOR != 3) {
            } else {
            }
            i2 = i6;
            if (cREATOR != 4) {
            } else {
            }
            i5 = i6;
            if (cREATOR != 1000) {
            } else {
            }
            i7 = i6;
            SafeParcelReader.v(parcel, i6);
        }
        SafeParcelReader.j(parcel, i8);
        super(i7, i3, i4, i2, i5);
        obj10.l2();
        return obj10;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
