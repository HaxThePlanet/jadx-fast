package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzq implements Parcelable.Creator<com.google.firebase.auth.internal.zzp> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i3;
        int i5;
        int i6;
        int i2;
        int i;
        final int i7 = SafeParcelReader.w(parcel);
        i5 = i8;
        i3 = i4;
        while (parcel.dataPosition() < i7) {
            i6 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i6);
            if (i2 != 1) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i6);
            if (i2 != 2) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i6);
            if (i2 != 3) {
            } else {
            }
            i5 = SafeParcelReader.l(parcel, i6);
            SafeParcelReader.v(parcel, i6);
        }
        SafeParcelReader.j(parcel, i7);
        zzp obj8 = new zzp(i4, i3, i5);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zzp[i];
    }
}
