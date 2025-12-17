package com.facebook.share.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public final class f extends com.facebook.share.b.a<com.facebook.share.b.f, Object> {

    public static final Parcelable.Creator<com.facebook.share.b.f> CREATOR;
    private final com.facebook.share.b.e y;
    private final String z;

    static class a implements Parcelable.Creator<com.facebook.share.b.f> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.f a(Parcel parcel) {
            f fVar = new f(parcel);
            return fVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.f[] b(int i) {
            return new f[i];
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
        f.a aVar = new f.a();
        f.CREATOR = aVar;
    }

    f(Parcel parcel) {
        super(parcel);
        e.b bVar = new e.b();
        this.y = bVar.e(parcel).d();
        this.z = parcel.readString();
    }

    @Override // com.facebook.share.b.a
    public com.facebook.share.b.e d() {
        return this.y;
    }

    @Override // com.facebook.share.b.a
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.b.a
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.y, 0);
        parcel.writeString(this.z);
    }
}
