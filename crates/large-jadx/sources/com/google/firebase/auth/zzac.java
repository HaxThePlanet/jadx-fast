package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzac implements Parcelable.Creator<com.google.firebase.auth.PhoneAuthCredential> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i3;
        int i8;
        int i;
        int i7;
        int i9;
        int i5;
        int i6;
        int i2;
        final int i11 = SafeParcelReader.w(parcel);
        i5 = i7;
        i2 = i6;
        while (parcel.dataPosition() < i11) {
            i4 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel, i4);
            i2 = i4;
            i6 = i4;
            i5 = i4;
            i9 = i4;
            i7 = i4;
            i = i4;
            i8 = i4;
        }
        SafeParcelReader.j(parcel, i11);
        super(i8, i, i7, i9, i5, i6, i2);
        return obj12;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new PhoneAuthCredential[i];
    }
}
