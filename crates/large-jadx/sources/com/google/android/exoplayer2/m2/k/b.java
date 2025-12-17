package com.google.android.exoplayer2.m2.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.n1.b;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.b> CREATOR;
    public final String b;
    public final String c;
    public final int v;
    public final byte[] w;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.b> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.b a(Parcel parcel) {
            b bVar = new b(parcel);
            return bVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.b[] b(int i) {
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
        super("APIC");
        String string = parcel.readString();
        p0.i(string);
        this.b = (String)string;
        this.c = parcel.readString();
        this.v = parcel.readInt();
        final byte[] obj2 = parcel.createByteArray();
        p0.i(obj2);
        this.w = (byte[])obj2;
    }

    public b(String string, String string2, int i3, byte[] b4Arr4) {
        super("APIC");
        this.b = string;
        this.c = string2;
        this.v = i3;
        this.w = b4Arr4;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i2;
        int i;
        Class<com.google.android.exoplayer2.m2.k.b> obj;
        int i3;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i4 = 0;
        if (object != null) {
            if (b.class != object.getClass()) {
            } else {
                if (this.v == object.v && p0.b(this.b, object.b) && p0.b(this.c, object.c) && Arrays.equals(this.w, object.w)) {
                    if (p0.b(this.b, object.b)) {
                        if (p0.b(this.c, object.c)) {
                            if (Arrays.equals(this.w, object.w)) {
                            } else {
                                i2 = i4;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i2;
        }
        return i4;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public int hashCode() {
        int i;
        int i2;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = i2;
        }
        String str2 = this.c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i11 += i4;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public String toString() {
        String str = this.a;
        final String str4 = this.b;
        final String str5 = this.c;
        StringBuilder stringBuilder = new StringBuilder(i2 += length3);
        stringBuilder.append(str);
        stringBuilder.append(": mimeType=");
        stringBuilder.append(str4);
        stringBuilder.append(", description=");
        stringBuilder.append(str5);
        return stringBuilder.toString();
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void w(n1.b n1$b) {
        b.G(this.w, this.v);
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.v);
        parcel.writeByteArray(this.w);
    }
}
