package com.facebook.share.b;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public final class c extends com.facebook.share.b.a<com.facebook.share.b.c, Object> {

    public static final Parcelable.Creator<com.facebook.share.b.c> CREATOR;
    @Deprecated
    private final Uri A;
    private final String B;
    @Deprecated
    private final String y;
    @Deprecated
    private final String z;

    static class a implements Parcelable.Creator<com.facebook.share.b.c> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.c a(Parcel parcel) {
            c cVar = new c(parcel);
            return cVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.c[] b(int i) {
            return new c[i];
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
        c.a aVar = new c.a();
        c.CREATOR = aVar;
    }

    c(Parcel parcel) {
        super(parcel);
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.A = (Uri)parcel.readParcelable(Uri.class.getClassLoader());
        this.B = parcel.readString();
    }

    @Override // com.facebook.share.b.a
    public String d() {
        return this.B;
    }

    @Override // com.facebook.share.b.a
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.b.a
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeParcelable(this.A, 0);
        parcel.writeString(this.B);
    }
}
