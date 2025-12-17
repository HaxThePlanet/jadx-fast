package com.google.android.exoplayer2.m2.l;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public final class e extends com.google.android.exoplayer2.m2.l.b {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.l.e> CREATOR;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.l.e> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.e a(Parcel parcel) {
            e obj1 = new e();
            return obj1;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.e[] b(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        e.a aVar = new e.a();
        e.CREATOR = aVar;
    }

    @Override // com.google.android.exoplayer2.m2.l.b
    public void writeToParcel(Parcel parcel, int i2) {
    }
}
