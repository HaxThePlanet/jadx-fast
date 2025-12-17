package com.google.android.exoplayer2.m2.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class l extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.l> CREATOR;
    public final String b;
    public final byte[] c;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.l> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.l a(Parcel parcel) {
            l lVar = new l(parcel);
            return lVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.l[] b(int i) {
            return new l[i];
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
        l.a aVar = new l.a();
        l.CREATOR = aVar;
    }

    l(Parcel parcel) {
        super("PRIV");
        String string = parcel.readString();
        p0.i(string);
        this.b = (String)string;
        final byte[] obj2 = parcel.createByteArray();
        p0.i(obj2);
        this.c = (byte[])obj2;
    }

    public l(String string, byte[] b2Arr2) {
        super("PRIV");
        this.b = string;
        this.c = b2Arr2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i;
        byte[] z;
        Class<com.google.android.exoplayer2.m2.k.l> obj;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (l.class != object.getClass()) {
            } else {
                if (p0.b(this.b, object.b) && Arrays.equals(this.c, object.c)) {
                    if (Arrays.equals(this.c, object.c)) {
                    } else {
                        i = i2;
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
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return i5 += i2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public String toString() {
        String str = this.a;
        final String str3 = this.b;
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(str);
        stringBuilder.append(": owner=");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeByteArray(this.c);
    }
}
