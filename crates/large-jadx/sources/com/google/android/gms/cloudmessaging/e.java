package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class e implements Parcelable.Creator<com.google.android.gms.cloudmessaging.a> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i3;
        int i4;
        int i2;
        final int i5 = SafeParcelReader.w(parcel);
        i = 0;
        while (parcel.dataPosition() < i5) {
            i3 = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i3) != 1) {
            } else {
            }
            i = SafeParcelReader.d(parcel, i3, Intent.CREATOR);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i5);
        a obj6 = new a(i);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new a[i];
    }
}
