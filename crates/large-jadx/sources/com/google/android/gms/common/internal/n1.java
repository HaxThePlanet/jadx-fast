package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class n1 implements Parcelable.Creator<com.google.android.gms.common.internal.e> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int cREATOR;
        int i2;
        int i4;
        int i;
        int i7;
        int i5;
        int i6;
        final int i9 = SafeParcelReader.w(parcel);
        i5 = i;
        i6 = i7;
        while (parcel.dataPosition() < i9) {
            i3 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel, i3);
            i6 = i3;
            i5 = i3;
            i7 = i3;
            i = i3;
            i4 = i3;
            i2 = i3;
        }
        SafeParcelReader.j(parcel, i9);
        super(i2, i4, i, i7, i5, i6);
        return obj11;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new e[i];
    }
}
