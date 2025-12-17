package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class o1 implements Parcelable.Creator<com.google.android.gms.common.internal.g> {
    static void a(com.google.android.gms.common.internal.g g, Parcel parcel2, int i3) {
        b.j(parcel2, 1, g.a);
        b.j(parcel2, 2, g.b);
        b.j(parcel2, 3, g.c);
        final int i19 = 0;
        b.o(parcel2, 4, g.v, i19);
        b.i(parcel2, 5, g.w, i19);
        b.r(parcel2, 6, g.x, i3, i19);
        b.e(parcel2, 7, g.y, i19);
        b.n(parcel2, 8, g.z, i3, i19);
        b.r(parcel2, 10, g.A, i3, i19);
        b.r(parcel2, 11, g.B, i3, i19);
        b.c(parcel2, 12, g.C);
        b.j(parcel2, 13, g.D);
        b.c(parcel2, 14, g.E);
        b.o(parcel2, 15, g.zza(), i19);
        b.b(parcel2, b.a(parcel2));
    }

    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i7;
        int cREATOR;
        int i6;
        int i5;
        int i15;
        int i3;
        int i10;
        int i12;
        int i4;
        int i;
        int i13;
        int i14;
        int i8;
        int i9;
        int i11;
        int i2;
        Parcel parcel2 = parcel;
        final int i16 = SafeParcelReader.w(parcel);
        i11 = i9;
        i2 = i14;
        while (parcel.dataPosition() < i16) {
            i7 = SafeParcelReader.p(parcel);
            i2 = i7;
            i11 = i7;
            i9 = i7;
            i8 = i7;
            i14 = i7;
            i13 = i7;
            SafeParcelReader.v(parcel2, i7);
            i = i7;
            i4 = i7;
            i12 = i7;
            i10 = i7;
            i3 = i7;
            i15 = i7;
            i5 = i7;
            i6 = i7;
        }
        SafeParcelReader.j(parcel2, i16);
        super(i6, i5, i15, i3, i10, i12, i4, i, i13, i14, i8, i9, i11, i2);
        return gVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new g[i];
    }
}
