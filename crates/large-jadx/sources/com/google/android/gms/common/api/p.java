package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class p implements Parcelable.Creator<com.google.android.gms.common.api.Scope> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        final int i6 = SafeParcelReader.w(parcel);
        i = 0;
        i2 = 0;
        while (parcel.dataPosition() < i6) {
            i3 = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i3);
            if (i4 != 1) {
            } else {
            }
            i = SafeParcelReader.r(parcel, i3);
            if (i4 != 2) {
            } else {
            }
            i2 = SafeParcelReader.e(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i6);
        Scope obj7 = new Scope(i, i2);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new Scope[i];
    }
}
