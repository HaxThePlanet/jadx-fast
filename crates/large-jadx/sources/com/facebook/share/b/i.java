package com.facebook.share.b;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public final class i extends com.facebook.share.b.d {

    public static final Parcelable.Creator<com.facebook.share.b.i> CREATOR;
    private final Bitmap b;
    private final Uri c;
    private final boolean v = false;
    private final String w;

    static class a implements Parcelable.Creator<com.facebook.share.b.i> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.i a(Parcel parcel) {
            i iVar = new i(parcel);
            return iVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.i[] b(int i) {
            return new i[i];
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
        i.a aVar = new i.a();
        i.CREATOR = aVar;
    }

    i(Parcel parcel) {
        super(parcel);
        this.b = (Bitmap)parcel.readParcelable(Bitmap.class.getClassLoader());
        this.c = (Uri)parcel.readParcelable(Uri.class.getClassLoader());
        int i = parcel.readByte() != 0 ? 1 : i;
        int i2 = 0;
        this.w = parcel.readString();
    }

    @Override // com.facebook.share.b.d
    public Uri a() {
        return this.c;
    }

    @Override // com.facebook.share.b.d
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.b.d
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        final int i = 0;
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
        parcel.writeByte((byte)obj3);
        parcel.writeString(this.w);
    }
}
