package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class ShortDynamicLinkImplCreator implements Parcelable.Creator<com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl> {

    public static final int CONTENT_DESCRIPTION;
    static void writeToParcel(com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl shortDynamicLinkImpl, Parcel parcel2, int i3) {
        final int i5 = 0;
        b.n(parcel2, 1, shortDynamicLinkImpl.getShortLink(), i3, i5);
        b.n(parcel2, 2, shortDynamicLinkImpl.getPreviewLink(), i3, i5);
        b.s(parcel2, 3, shortDynamicLinkImpl.getWarnings(), i5);
        b.b(parcel2, b.a(parcel2));
    }

    @Override // android.os.Parcelable$Creator
    public com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl createFromParcel(Parcel parcel) {
        int i3;
        int i4;
        int i2;
        int i5;
        int i;
        int i6;
        final int i7 = SafeParcelReader.w(parcel);
        i2 = i4;
        while (parcel.dataPosition() < i7) {
            i5 = SafeParcelReader.p(parcel);
            i = SafeParcelReader.k(i5);
            if (i != 1) {
            } else {
            }
            i3 = SafeParcelReader.d(parcel, i5, Uri.CREATOR);
            if (i != 2) {
            } else {
            }
            i4 = SafeParcelReader.d(parcel, i5, Uri.CREATOR);
            if (i != 3) {
            } else {
            }
            i2 = SafeParcelReader.i(parcel, i5, ShortDynamicLinkImpl.WarningImpl.CREATOR);
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i7);
        ShortDynamicLinkImpl obj8 = new ShortDynamicLinkImpl(i3, i4, i2);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl[] newArray(int i) {
        return new ShortDynamicLinkImpl[i];
    }

    @Override // android.os.Parcelable$Creator
    public Object[] newArray(int i) {
        return newArray(i);
    }
}
