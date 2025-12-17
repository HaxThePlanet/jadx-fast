package com.google.android.exoplayer2.m2.l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public final class a extends com.google.android.exoplayer2.m2.l.b {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.l.a> CREATOR;
    public final long a;
    public final long b;
    public final byte[] c;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.l.a> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.a a(Parcel parcel) {
            a aVar = new a(parcel, 0);
            return aVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.a[] b(int i) {
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

    private a(long l, byte[] b2Arr2, long l3) {
        super();
        this.a = obj4;
        this.b = l;
        this.c = l3;
    }

    private a(Parcel parcel) {
        super();
        this.a = parcel.readLong();
        this.b = parcel.readLong();
        final byte[] obj3 = parcel.createByteArray();
        p0.i(obj3);
        this.c = (byte[])obj3;
    }

    a(Parcel parcel, com.google.android.exoplayer2.m2.l.a.a a$a2) {
        super(parcel);
    }

    static com.google.android.exoplayer2.m2.l.a a(d0 d0, int i2, long l3) {
        i2 += -4;
        final byte[] bArr = new byte[obj7];
        d0.j(bArr, 0, obj7);
        super(d0.z(), obj2, bArr, l3, obj5);
        return obj6;
    }

    @Override // com.google.android.exoplayer2.m2.l.b
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
        parcel.writeByteArray(this.c);
    }
}
