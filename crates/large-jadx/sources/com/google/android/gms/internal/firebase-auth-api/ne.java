package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
public final class ne implements Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.me> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i5;
        int i2;
        int i;
        int i3;
        int i4;
        final int i6 = SafeParcelReader.w(parcel);
        i2 = i5;
        while (parcel.dataPosition() < i6) {
            i = SafeParcelReader.p(parcel);
            i3 = SafeParcelReader.k(i);
            if (i3 != 1) {
            } else {
            }
            i5 = SafeParcelReader.e(parcel, i);
            if (i3 != 2) {
            } else {
            }
            i2 = SafeParcelReader.d(parcel, i, ActionCodeSettings.CREATOR);
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i6);
        me obj7 = new me(i5, i2);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new me[i];
    }
}
