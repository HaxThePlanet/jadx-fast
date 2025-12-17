package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<com.google.android.gms.measurement.internal.c> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int cREATOR;
        int i12;
        int i9;
        int i10;
        int i3;
        int i6;
        int i7;
        int i4;
        int i5;
        int i2;
        int i11;
        int i8;
        Parcel parcel2 = parcel;
        final int i13 = SafeParcelReader.w(parcel);
        i11 = i5;
        i8 = i2;
        i6 = i15;
        while (parcel.dataPosition() < i13) {
            i = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i);
            i8 = i;
            i11 = i;
            i2 = i;
            i5 = i;
            i4 = i;
            i7 = i;
            i6 = i;
            i3 = i;
            i10 = i;
            i9 = i;
            i12 = i;
        }
        SafeParcelReader.j(parcel2, i13);
        super(i12, i9, i10, i3, obj11, i6, i7, i4, i5, obj16, i2, i11, obj19, i8);
        return cVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new c[i];
    }
}
