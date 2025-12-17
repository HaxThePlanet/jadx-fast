package com.google.android.exoplayer2.m2.j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.m2.a.b;
import com.google.android.exoplayer2.n1.b;
import com.google.android.exoplayer2.util.g;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b implements a.b {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.j.b> CREATOR;
    public final byte[] a;
    public final String b;
    public final String c;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.j.b> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.j.b a(Parcel parcel) {
            b bVar = new b(parcel);
            return bVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.j.b[] b(int i) {
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
    static {
        b.a aVar = new b.a();
        b.CREATOR = aVar;
    }

    b(Parcel parcel) {
        super();
        byte[] byteArray = parcel.createByteArray();
        g.e(byteArray);
        this.a = (byte[])byteArray;
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public b(byte[] bArr, String string2, String string3) {
        super();
        this.a = bArr;
        this.b = string2;
        this.c = string3;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public boolean equals(Object object) {
        Class<com.google.android.exoplayer2.m2.j.b> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && b.class != object.getClass()) {
            if (b.class != object.getClass()) {
            }
            return Arrays.equals(this.a, object.a);
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public String toString() {
        Object[] arr = new Object[3];
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.b, this.c, Integer.valueOf(bArr.length));
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public void w(n1.b n1$b) {
        final String str = this.b;
        if (str != null) {
            b.U(str);
        }
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
