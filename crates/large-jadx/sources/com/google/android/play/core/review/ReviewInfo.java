package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public abstract class ReviewInfo implements Parcelable {

    public static final Parcelable.Creator<com.google.android.play.core.review.ReviewInfo> CREATOR;
    static {
        e eVar = new e();
        ReviewInfo.CREATOR = eVar;
    }

    @Override // android.os.Parcelable
    abstract PendingIntent a();

    @Override // android.os.Parcelable
    abstract boolean b();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(a(), 0);
        parcel.writeInt(b());
    }
}
