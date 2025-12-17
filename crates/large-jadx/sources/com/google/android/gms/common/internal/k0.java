package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class k0 implements Parcelable.Creator<com.google.android.gms.common.internal.o> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i5;
        int i10;
        int i;
        int i2;
        int i8;
        int i7;
        int i9;
        int i6;
        int i3;
        Parcel parcel2 = parcel;
        final int i11 = SafeParcelReader.w(parcel);
        i6 = i9;
        i7 = i8;
        i3 = i2;
        while (parcel.dataPosition() < i11) {
            i4 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i4);
            i3 = i4;
            i6 = i4;
            i9 = i4;
            i7 = i4;
            i8 = i4;
            i2 = i4;
            i = i4;
            i10 = i4;
        }
        SafeParcelReader.j(parcel2, i11);
        super(i10, i, i2, i8, obj11, i7, obj13, i9, i6, i3);
        return oVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new o[i];
    }
}
