package com.google.android.exoplayer2.m2.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class g extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.g> CREATOR;
    public final String b;
    public final String c;
    public final String v;
    public final byte[] w;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.g> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.g a(Parcel parcel) {
            g gVar = new g(parcel);
            return gVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.g[] b(int i) {
            return new g[i];
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
        g.a aVar = new g.a();
        g.CREATOR = aVar;
    }

    g(Parcel parcel) {
        super("GEOB");
        String string = parcel.readString();
        p0.i(string);
        this.b = (String)string;
        String string2 = parcel.readString();
        p0.i(string2);
        this.c = (String)string2;
        String string3 = parcel.readString();
        p0.i(string3);
        this.v = (String)string3;
        final byte[] obj2 = parcel.createByteArray();
        p0.i(obj2);
        this.w = (byte[])obj2;
    }

    public g(String string, String string2, String string3, byte[] b4Arr4) {
        super("GEOB");
        this.b = string;
        this.c = string2;
        this.v = string3;
        this.w = b4Arr4;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i;
        boolean z;
        Class<com.google.android.exoplayer2.m2.k.g> obj;
        String str;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (g.class != object.getClass()) {
            } else {
                if (p0.b(this.b, object.b) && p0.b(this.c, object.c) && p0.b(this.v, object.v) && Arrays.equals(this.w, object.w)) {
                    if (p0.b(this.c, object.c)) {
                        if (p0.b(this.v, object.v)) {
                            if (Arrays.equals(this.w, object.w)) {
                            } else {
                                i = i2;
                            }
                        } else {
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
        int i3;
        int i2;
        int i;
        String str = this.b;
        i = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = i;
        }
        String str2 = this.c;
        if (str2 != null) {
            i2 = str2.hashCode();
        } else {
            i2 = i;
        }
        String str3 = this.v;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return i11 += i4;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public String toString() {
        String str = this.a;
        final String str5 = this.b;
        final String str6 = this.c;
        final String str7 = this.v;
        StringBuilder stringBuilder = new StringBuilder(i3 += length4);
        stringBuilder.append(str);
        stringBuilder.append(": mimeType=");
        stringBuilder.append(str5);
        stringBuilder.append(", filename=");
        stringBuilder.append(str6);
        stringBuilder.append(", description=");
        stringBuilder.append(str7);
        return stringBuilder.toString();
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.v);
        parcel.writeByteArray(this.w);
    }
}
