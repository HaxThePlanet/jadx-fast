package com.facebook.share.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public class b implements Parcelable {

    public static final Parcelable.Creator<com.facebook.share.b.b> CREATOR;
    private final String a;

    static class a implements Parcelable.Creator<com.facebook.share.b.b> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.b a(Parcel parcel) {
            b bVar = new b(parcel);
            return bVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.share.b.b[] b(int i) {
            return new b[i];
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

    public static class b {

        private String a;
        static String a(com.facebook.share.b.b.b b$b) {
            return b.a;
        }

        public com.facebook.share.b.b b() {
            b bVar = new b(this, 0);
            return bVar;
        }

        com.facebook.share.b.b.b c(Parcel parcel) {
            d((b)parcel.readParcelable(b.class.getClassLoader()));
            return this;
        }

        public com.facebook.share.b.b.b d(com.facebook.share.b.b b) {
            if (b == null) {
                return this;
            }
            e(b.a());
            return this;
        }

        public com.facebook.share.b.b.b e(String string) {
            this.a = string;
            return this;
        }
    }
    static {
        b.a aVar = new b.a();
        b.CREATOR = aVar;
    }

    b(Parcel parcel) {
        super();
        this.a = parcel.readString();
    }

    private b(com.facebook.share.b.b.b b$b) {
        super();
        this.a = b.b.a(b);
    }

    b(com.facebook.share.b.b.b b$b, com.facebook.share.b.b.a b$a2) {
        super(b);
    }

    @Override // android.os.Parcelable
    public String a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
    }
}
