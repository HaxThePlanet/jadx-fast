package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class p1 implements Parcelable.Creator<com.google.android.gms.internal.measurement.o1> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i10;
        int i6;
        int i9;
        int i2;
        int i7;
        int i8;
        int i5;
        int i;
        int i3;
        int i4;
        Parcel parcel2 = parcel;
        final int i11 = SafeParcelReader.w(parcel);
        i2 = i9;
        i4 = i3;
        i7 = i13;
        while (parcel.dataPosition() < i11) {
            i10 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i10);
            i4 = i10;
            i3 = i10;
            i = i10;
            i5 = i10;
            i8 = i10;
            i7 = i10;
            i2 = i10;
            i9 = i10;
        }
        SafeParcelReader.j(parcel2, i11);
        super(i9, obj8, i2, obj10, i7, i8, i5, i, i3, i4);
        return o1Var;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new o1[i];
    }
}
