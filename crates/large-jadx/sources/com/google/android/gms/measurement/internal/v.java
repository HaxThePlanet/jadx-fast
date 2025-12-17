package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class v implements Parcelable.Creator<com.google.android.gms.measurement.internal.u> {
    static void a(com.google.android.gms.measurement.internal.u u, Parcel parcel2, int i3) {
        final int i6 = 0;
        b.o(parcel2, 2, u.a, i6);
        int i5 = 3;
        b.n(parcel2, i5, u.b, i3, i6);
        b.o(parcel2, 4, u.c, i6);
        b.l(parcel2, 5, u.v);
        b.b(parcel2, b.a(parcel2));
    }

    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int cREATOR;
        int i5;
        int i2;
        int i3;
        int i6;
        int i4;
        final int i7 = SafeParcelReader.w(parcel);
        i6 = i3;
        i4 = cREATOR;
        while (parcel.dataPosition() < i7) {
            i = SafeParcelReader.p(parcel);
            cREATOR = SafeParcelReader.k(i);
            if (cREATOR != 2) {
            } else {
            }
            i2 = i;
            if (cREATOR != 3) {
            } else {
            }
            i3 = i;
            if (cREATOR != 4) {
            } else {
            }
            i6 = i;
            if (cREATOR != 5) {
            } else {
            }
            i4 = i;
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i7);
        super(i2, i3, i6, i4, obj9);
        return obj11;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new u[i];
    }
}
