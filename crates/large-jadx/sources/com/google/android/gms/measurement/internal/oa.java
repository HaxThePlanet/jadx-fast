package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class oa implements Parcelable.Creator<com.google.android.gms.measurement.internal.na> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i9;
        int i5;
        int i13;
        int i;
        int i12;
        int i15;
        int i6;
        int i18;
        int i17;
        int i11;
        int i21;
        int i22;
        int i23;
        int i4;
        int i19;
        int i10;
        int i2;
        int i16;
        int i3;
        int i7;
        int i14;
        int i8;
        int i20;
        String str;
        Parcel parcel2 = parcel;
        final int i24 = SafeParcelReader.w(parcel);
        i2 = i11;
        i16 = i10;
        i14 = i19;
        i20 = i8;
        str = str2;
        i22 = i27;
        while (parcel.dataPosition() < i24) {
            i9 = SafeParcelReader.p(parcel);
            str = i9;
            i20 = i9;
            i8 = i9;
            i14 = i9;
            i7 = i9;
            i3 = i9;
            i16 = i9;
            SafeParcelReader.v(parcel2, i9);
            i2 = i9;
            i10 = i9;
            i19 = i9;
            i4 = i9;
            i23 = i9;
            i22 = i9;
            i21 = i9;
            i11 = i9;
            i17 = i9;
            i18 = i9;
            i6 = i9;
            i15 = i9;
            i12 = i9;
            i = i9;
            i13 = i9;
        }
        SafeParcelReader.j(parcel2, i24);
        super(i13, i, i12, i15, i6, obj16, i18, obj18, i17, i11, i21, i22, obj23, i23, i4, obj26, i19, obj28, i10, i2, i16, i3, i7, i14, obj35, i8, i20, str);
        return naVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new na[i];
    }
}
