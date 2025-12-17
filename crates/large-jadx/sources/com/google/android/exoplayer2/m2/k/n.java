package com.google.android.exoplayer2.m2.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public final class n extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.n> CREATOR;
    public final String b;
    public final String c;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.n> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.n a(Parcel parcel) {
            n nVar = new n(parcel);
            return nVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.n[] b(int i) {
            return new n[i];
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
        n.a aVar = new n.a();
        n.CREATOR = aVar;
    }

    n(Parcel parcel) {
        String string = parcel.readString();
        p0.i(string);
        super((String)string);
        this.b = parcel.readString();
        final String obj2 = parcel.readString();
        p0.i(obj2);
        this.c = (String)obj2;
    }

    public n(String string, String string2, String string3) {
        super(string);
        this.b = string2;
        this.c = string3;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i;
        String equals;
        Class<com.google.android.exoplayer2.m2.k.n> obj;
        String str;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (n.class != object.getClass()) {
            } else {
                if (this.a.equals(object.a) && p0.b(this.b, object.b) && p0.b(this.c, object.c)) {
                    if (p0.b(this.b, object.b)) {
                        if (p0.b(this.c, object.c)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public int hashCode() {
        int i;
        int i2;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        } else {
            i = i2;
        }
        String str3 = this.c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return i8 += i2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public String toString() {
        String str = this.a;
        final String str3 = this.c;
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(str);
        stringBuilder.append(": url=");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
