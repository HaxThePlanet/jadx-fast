package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<com.google.android.gms.auth.api.signin.internal.a> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i4;
        int i6;
        int i3;
        int i2;
        int i5;
        final int i7 = SafeParcelReader.w(parcel);
        i6 = i8;
        i4 = i;
        while (parcel.dataPosition() < i7) {
            i3 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i3);
            if (i2 != 1) {
            } else {
            }
            i = SafeParcelReader.r(parcel, i3);
            if (i2 != 2) {
            } else {
            }
            i4 = SafeParcelReader.r(parcel, i3);
            if (i2 != 3) {
            } else {
            }
            i6 = SafeParcelReader.a(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i7);
        a obj8 = new a(i, i4, i6);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new a[i];
    }
}
