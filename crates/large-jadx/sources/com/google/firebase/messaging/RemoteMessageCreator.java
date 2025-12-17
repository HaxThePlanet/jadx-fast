package com.google.firebase.messaging;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class RemoteMessageCreator implements Parcelable.Creator<com.google.firebase.messaging.RemoteMessage> {

    public static final int CONTENT_DESCRIPTION;
    static void writeToParcel(com.google.firebase.messaging.RemoteMessage remoteMessage, Parcel parcel2, int i3) {
        b.e(parcel2, 2, remoteMessage.bundle, false);
        b.b(parcel2, b.a(parcel2));
    }

    @Override // android.os.Parcelable$Creator
    public com.google.firebase.messaging.RemoteMessage createFromParcel(Parcel parcel) {
        int i;
        int i3;
        int i4;
        int i2;
        final int i5 = SafeParcelReader.w(parcel);
        i = 0;
        while (parcel.dataPosition() < i5) {
            i3 = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i3) != 2) {
            } else {
            }
            i = SafeParcelReader.a(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i5);
        RemoteMessage obj6 = new RemoteMessage(i);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public com.google.firebase.messaging.RemoteMessage[] newArray(int i) {
        return new RemoteMessage[i];
    }

    @Override // android.os.Parcelable$Creator
    public Object[] newArray(int i) {
        return newArray(i);
    }
}
