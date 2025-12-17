package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class od implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.nd> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i;
        int i4;
        int i2;
        int i5;
        final int i6 = SafeParcelReader.w(parcel);
        i = i3;
        while (parcel.dataPosition() < i6) {
            i4 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i4);
            if (i2 != 1) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i4);
            if (i2 != 2) {
            } else {
            }
            i = SafeParcelReader.e(parcel, i4);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i6);
        nd obj7 = new nd(i3, i);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new nd[i];
    }
}
