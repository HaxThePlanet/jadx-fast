package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class DynamicLinkDataCreator implements Parcelable.Creator<com.google.firebase.dynamiclinks.internal.DynamicLinkData> {

    public static final int CONTENT_DESCRIPTION;
    static void writeToParcel(com.google.firebase.dynamiclinks.internal.DynamicLinkData dynamicLinkData, Parcel parcel2, int i3) {
        final int i8 = 0;
        b.o(parcel2, 1, dynamicLinkData.getDynamicLink(), i8);
        b.o(parcel2, 2, dynamicLinkData.getDeepLink(), i8);
        int i6 = 3;
        b.j(parcel2, i6, dynamicLinkData.getMinVersion());
        b.l(parcel2, 4, dynamicLinkData.getClickTimestamp());
        b.e(parcel2, 5, dynamicLinkData.getExtensionBundle(), i8);
        b.n(parcel2, 6, dynamicLinkData.getRedirectUrl(), i3, i8);
        b.b(parcel2, b.a(parcel2));
    }

    @Override // android.os.Parcelable$Creator
    public com.google.firebase.dynamiclinks.internal.DynamicLinkData createFromParcel(Parcel parcel) {
        int i;
        int i4;
        int cREATOR;
        int i6;
        int i8;
        int i5;
        int i7;
        int i2;
        int i3;
        final int i10 = SafeParcelReader.w(parcel);
        i3 = i2;
        i5 = cREATOR;
        i7 = i11;
        while (parcel.dataPosition() < i10) {
            i4 = SafeParcelReader.p(parcel);
            SafeParcelReader.v(parcel, i4);
            i3 = i4;
            i2 = i4;
            i7 = i4;
            i5 = i4;
            i8 = i4;
            i6 = i4;
        }
        SafeParcelReader.j(parcel, i10);
        super(i6, i8, i5, i7, obj10, i2, i3);
        return obj14;
    }

    @Override // android.os.Parcelable$Creator
    public Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public com.google.firebase.dynamiclinks.internal.DynamicLinkData[] newArray(int i) {
        return new DynamicLinkData[i];
    }

    @Override // android.os.Parcelable$Creator
    public Object[] newArray(int i) {
        return newArray(i);
    }
}
