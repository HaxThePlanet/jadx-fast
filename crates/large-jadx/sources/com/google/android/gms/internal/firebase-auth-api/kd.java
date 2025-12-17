package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class kd implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.jd> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i5;
        int i3;
        int i4;
        int i;
        final int i6 = SafeParcelReader.w(parcel);
        i5 = i2;
        while (parcel.dataPosition() < i6) {
            i3 = SafeParcelReader.p(parcel);
            i4 = SafeParcelReader.k(i3);
            if (i4 != 1) {
            } else {
            }
            i2 = SafeParcelReader.e(parcel, i3);
            if (i4 != 2) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i6);
        jd obj7 = new jd(i2, i5);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new jd[i];
    }
}
