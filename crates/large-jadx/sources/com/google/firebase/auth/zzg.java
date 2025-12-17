package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzg implements Parcelable.Creator<com.google.firebase.auth.EmailAuthCredential> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i;
        int i2;
        int i4;
        int i5;
        int i7;
        int i8;
        int i6;
        final int i9 = SafeParcelReader.w(parcel);
        i8 = i7;
        i6 = i;
        while (parcel.dataPosition() < i9) {
            i3 = SafeParcelReader.p(parcel);
            i = SafeParcelReader.k(i3);
            if (i != 1) {
            } else {
            }
            i4 = i3;
            if (i != 2) {
            } else {
            }
            i5 = i3;
            if (i != 3) {
            } else {
            }
            i7 = i3;
            if (i != 4) {
            } else {
            }
            i8 = i3;
            if (i != 5) {
            } else {
            }
            i6 = i3;
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i9);
        super(i4, i5, i7, i8, i6);
        return obj10;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new EmailAuthCredential[i];
    }
}
