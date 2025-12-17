package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzd implements Parcelable.Creator<com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        final int i2 = SafeParcelReader.w(parcel);
        while (parcel.dataPosition() < i2) {
            i = SafeParcelReader.p(parcel);
            SafeParcelReader.k(i);
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i2);
        PhoneAuthProvider.ForceResendingToken obj3 = new PhoneAuthProvider.ForceResendingToken();
        return obj3;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new PhoneAuthProvider.ForceResendingToken[i];
    }
}
