package com.google.android.exoplayer2.m2.h;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.m2.a.b;
import com.google.android.exoplayer2.util.g;

/* loaded from: classes2.dex */
public final class a implements a.b {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.h.a> CREATOR;
    public final int a;
    public final String b;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.h.a> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.h.a a(Parcel parcel) {
            final String string = parcel.readString();
            g.e(string);
            a aVar = new a(parcel.readInt(), (String)string);
            return aVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.h.a[] b(int i) {
            return new a[i];
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
        a.a aVar = new a.a();
        a.CREATOR = aVar;
    }

    public a(int i, String string2) {
        super();
        this.a = i;
        this.b = string2;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public String toString() {
        final String str3 = this.b;
        StringBuilder stringBuilder = new StringBuilder(length += 33);
        stringBuilder.append("Ait(controlCode=");
        stringBuilder.append(this.a);
        stringBuilder.append(",url=");
        stringBuilder.append(str3);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeInt(this.a);
    }
}
