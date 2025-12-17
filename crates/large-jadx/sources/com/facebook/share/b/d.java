package com.facebook.share.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class d implements Parcelable {

    private final Bundle a;
    d(Parcel parcel) {
        super();
        this.a = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.a);
    }
}
