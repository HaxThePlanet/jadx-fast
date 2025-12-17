package com.google.android.exoplayer2.m2.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class c extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.c> CREATOR;
    public final byte[] b;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.c> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.c a(Parcel parcel) {
            c cVar = new c(parcel);
            return cVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.c[] b(int i) {
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
        final String string = parcel.readString();
        p0.i(string);
        super((String)string);
        final byte[] obj2 = parcel.createByteArray();
        p0.i(obj2);
        this.b = (byte[])obj2;
    }

    public c(String string, byte[] b2Arr2) {
        super(string);
        this.b = b2Arr2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i;
        byte[] equals;
        Class<com.google.android.exoplayer2.m2.k.c> obj;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (c.class != object.getClass()) {
            } else {
                if (this.a.equals(object.a) && Arrays.equals(this.b, object.b)) {
                    if (Arrays.equals(this.b, object.b)) {
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
        return i5 += i2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
    }
}
