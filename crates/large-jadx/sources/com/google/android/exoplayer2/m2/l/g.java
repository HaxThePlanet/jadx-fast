package com.google.android.exoplayer2.m2.l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m0;

/* loaded from: classes2.dex */
public final class g extends com.google.android.exoplayer2.m2.l.b {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.l.g> CREATOR;
    public final long a;
    public final long b;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.l.g> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.g a(Parcel parcel) {
            super(parcel.readLong(), obj2, parcel.readLong(), obj4, 0);
            return gVar2;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.g[] b(int i) {
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

    private g(long l, long l2) {
        super();
        this.a = l;
        this.b = obj3;
    }

    g(long l, long l2, com.google.android.exoplayer2.m2.l.g.a g$a3) {
        super(l, l2, a3, obj4);
    }

    static com.google.android.exoplayer2.m2.l.g a(d0 d0, long l2, m0 m03) {
        final long obj1 = g.b(d0, l2);
        g gVar = new g(obj1, l2, obj4.b(obj1), obj4);
        return gVar;
    }

    static long b(d0 d0, long l2) {
        int i;
        long cmp;
        int obj6;
        i = (long)i2;
        if (Long.compare(i7, i10) != 0) {
            obj6 &= i;
        } else {
            obj6 = -9223372036854775807L;
        }
        return obj6;
    }

    @Override // com.google.android.exoplayer2.m2.l.b
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }
}
