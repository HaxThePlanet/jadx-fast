package com.google.firebase.dynamiclinks.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class WarningImplCreator implements Parcelable.Creator<com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl.WarningImpl> {

    public static final int CONTENT_DESCRIPTION;
    static void writeToParcel(com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl.WarningImpl shortDynamicLinkImpl$WarningImpl, Parcel parcel2, int i3) {
        b.o(parcel2, 2, warningImpl.getMessage(), false);
        b.b(parcel2, b.a(parcel2));
    }

    @Override // android.os.Parcelable$Creator
    public com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl.WarningImpl createFromParcel(Parcel parcel) {
        int i2;
        int i4;
        int i3;
        int i;
        final int i5 = SafeParcelReader.w(parcel);
        i2 = 0;
        while (parcel.dataPosition() < i5) {
            i4 = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i4) != 2) {
            } else {
            }
            i2 = SafeParcelReader.e(parcel, i4);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i5);
        ShortDynamicLinkImpl.WarningImpl obj6 = new ShortDynamicLinkImpl.WarningImpl(i2);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl.WarningImpl[] newArray(int i) {
        return new ShortDynamicLinkImpl.WarningImpl[i];
    }

    @Override // android.os.Parcelable$Creator
    public Object[] newArray(int i) {
        return newArray(i);
    }
}
