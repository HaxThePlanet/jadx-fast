package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzaa implements Parcelable.Creator<com.google.firebase.auth.internal.zzz> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i4;
        int i3;
        int i2;
        int i5;
        final int i6 = SafeParcelReader.w(parcel);
        i4 = i;
        while (parcel.dataPosition() < i6) {
            i3 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i3);
            if (i2 != 1) {
            } else {
            }
            i = SafeParcelReader.s(parcel, i3);
            if (i2 != 2) {
            } else {
            }
            i4 = SafeParcelReader.s(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i6);
        zzz obj9 = new zzz(i, obj2, i4, obj4);
        return obj9;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zzz[i];
    }
}
