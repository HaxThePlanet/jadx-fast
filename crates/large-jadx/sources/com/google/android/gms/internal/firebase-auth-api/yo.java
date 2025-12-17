package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class yo implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.xo> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i3;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        final int i8 = SafeParcelReader.w(parcel);
        i6 = i5;
        i7 = i3;
        while (parcel.dataPosition() < i8) {
            i = SafeParcelReader.p(parcel);
            i3 = SafeParcelReader.k(i);
            if (i3 != 1) {
            } else {
            }
            i4 = i;
            if (i3 != 2) {
            } else {
            }
            i5 = i;
            if (i3 != 3) {
            } else {
            }
            i6 = i;
            if (i3 != 4) {
            } else {
            }
            i7 = i;
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i8);
        super(i4, i5, i6, i7, obj9);
        return obj11;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new xo[i];
    }
}
