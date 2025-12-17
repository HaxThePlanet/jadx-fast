package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class de implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ce> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i;
        int i3;
        int i4;
        int i5;
        final int i6 = SafeParcelReader.w(parcel);
        i = i2;
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
            i = SafeParcelReader.e(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i6);
        ce obj7 = new ce(i2, i);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ce[i];
    }
}
