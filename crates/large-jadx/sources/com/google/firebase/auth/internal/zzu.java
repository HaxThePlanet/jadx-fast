package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzu implements Parcelable.Creator<com.google.firebase.auth.internal.zzt> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i7;
        int i;
        int i4;
        int i5;
        int i6;
        int i2;
        int i10;
        int i3;
        int i8;
        int i9;
        final int i12 = SafeParcelReader.w(parcel);
        i9 = i3;
        i8 = i;
        while (parcel.dataPosition() < i12) {
            i7 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel, i7);
            i9 = i7;
            i8 = i7;
            i3 = i7;
            i6 = i7;
            i2 = i7;
            i10 = i7;
            i5 = i7;
            i4 = i7;
        }
        SafeParcelReader.j(parcel, i12);
        super(i4, i5, i6, i2, i10, i3, i8, i9);
        return obj13;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new zzt[i];
    }
}
