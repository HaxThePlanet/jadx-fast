package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class fa implements Parcelable.Creator<com.google.android.gms.measurement.internal.ea> {
    static void a(com.google.android.gms.measurement.internal.ea ea, Parcel parcel2, int i3) {
        b.j(parcel2, 1, ea.a);
        int i6 = 2;
        final int i11 = 0;
        b.o(parcel2, i6, ea.b, i11);
        b.l(parcel2, 3, ea.c);
        b.m(parcel2, 4, ea.v, i11);
        b.h(parcel2, 5, 0, i11);
        b.o(parcel2, 6, ea.w, i11);
        b.o(parcel2, 7, ea.x, i11);
        b.g(parcel2, 8, ea.y, i11);
        b.b(parcel2, b.a(parcel2));
    }

    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i9;
        int i6;
        int i7;
        int i8;
        int i;
        int i10;
        int i3;
        int i4;
        int i2;
        int i5;
        Parcel parcel2 = parcel;
        final int i12 = SafeParcelReader.w(parcel);
        i5 = i2;
        i7 = i6;
        i = i13;
        while (parcel.dataPosition() < i12) {
            i9 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel2, i9);
            i5 = i9;
            i2 = i9;
            i4 = i9;
            i3 = i9;
            i10 = i9;
            i = i9;
            i8 = i9;
            i7 = i9;
        }
        SafeParcelReader.j(parcel2, i12);
        super(i7, i8, i, obj10, i10, i3, i4, i2, i5);
        return eaVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ea[i];
    }
}
