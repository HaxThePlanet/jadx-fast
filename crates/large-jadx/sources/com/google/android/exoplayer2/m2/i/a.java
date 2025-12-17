package com.google.android.exoplayer2.m2.i;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.m2.a.b;
import com.google.android.exoplayer2.util.p0;
import com.revenuecat.purchases.interfaces.PurchaseCallbackKt.toPurchaseCallback.1;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a implements a.b {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.i.a> CREATOR;
    private static final i1 y;
    private static final i1 z;
    public final String a;
    public final String b;
    public final long c;
    public final long v;
    public final byte[] w;
    private int x;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.i.a> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.i.a a(Parcel parcel) {
            a aVar = new a(parcel);
            return aVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.i.a[] b(int i) {
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
        i1.b bVar = new i1.b();
        bVar.e0("application/id3");
        a.y = bVar.E();
        i1.b bVar2 = new i1.b();
        bVar2.e0("application/x-scte35");
        a.z = bVar2.E();
        a.a aVar = new a.a();
        a.CREATOR = aVar;
    }

    a(Parcel parcel) {
        super();
        String string = parcel.readString();
        p0.i(string);
        this.a = (String)string;
        String string2 = parcel.readString();
        p0.i(string2);
        this.b = (String)string2;
        this.c = parcel.readLong();
        this.v = parcel.readLong();
        final byte[] obj3 = parcel.createByteArray();
        p0.i(obj3);
        this.w = (byte[])obj3;
    }

    public a(String string, String string2, long l3, long l4, byte[] b5Arr5) {
        super();
        this.a = string;
        this.b = string2;
        this.c = l3;
        this.v = b5Arr5;
        this.w = obj7;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public byte[] S1() {
        byte[] bArr;
        bArr = g0() != null ? this.w : 0;
        return bArr;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public boolean equals(Object object) {
        int i;
        int cmp;
        Class<com.google.android.exoplayer2.m2.i.a> obj;
        Object class;
        long l;
        Object obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (a.class != object.getClass()) {
            } else {
                if (Long.compare(l2, l) == 0 && Long.compare(l3, l) == 0 && p0.b(this.a, object.a) && p0.b(this.b, object.b) && Arrays.equals(this.w, object.w)) {
                    if (Long.compare(l3, l) == 0) {
                        if (p0.b(this.a, object.a)) {
                            if (p0.b(this.b, object.b)) {
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
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public i1 g0() {
        String equals;
        int str;
        int i;
        equals = this.a;
        equals.hashCode();
        i = -1;
        switch (equals) {
            case "urn:scte:scte35:2014:bin":
                i = 0;
                break;
            case "https://aomedia.org/emsg/ID3":
                i = 1;
                break;
            case "https://developer.apple.com/streaming/emsg-id3":
                i = 2;
                break;
            default:
        }
        switch (i) {
            case 0:
                return a.z;
            case 1:
                return a.y;
            default:
                return null;
        }
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public int hashCode() {
        int i3;
        int i5;
        int i4;
        int i2;
        int i6;
        int i;
        if (this.x == 0) {
            String str = this.a;
            if (str != null) {
                i4 = str.hashCode();
            } else {
                i4 = i2;
            }
            String str2 = this.b;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long l = this.c;
            int i21 = 32;
            long l2 = this.v;
            this.x = i16 += i5;
        }
        return this.x;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public String toString() {
        String str = this.a;
        final String str5 = this.b;
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append("EMSG: scheme=");
        stringBuilder.append(str);
        stringBuilder.append(", id=");
        stringBuilder.append(this.v);
        stringBuilder.append(", durationMs=");
        stringBuilder.append(this.c);
        stringBuilder.append(", value=");
        stringBuilder.append(str5);
        return stringBuilder.toString();
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.v);
        parcel.writeByteArray(this.w);
    }
}
