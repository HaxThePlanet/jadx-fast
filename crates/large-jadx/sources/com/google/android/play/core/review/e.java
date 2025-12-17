package com.google.android.play.core.review;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
final class e implements Parcelable.Creator<com.google.android.play.core.review.ReviewInfo> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int obj3;
        obj3 = parcel.readInt() != 0 ? 1 : 0;
        d dVar = new d((PendingIntent)parcel.readParcelable(ReviewInfo.class.getClassLoader()), obj3);
        return dVar;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new ReviewInfo[i];
    }
}
