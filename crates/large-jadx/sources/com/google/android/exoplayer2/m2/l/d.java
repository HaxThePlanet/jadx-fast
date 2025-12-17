package com.google.android.exoplayer2.m2.l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class d extends com.google.android.exoplayer2.m2.l.b {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.l.d> CREATOR;
    public final boolean A;
    public final long B;
    public final int C;
    public final int D;
    public final int E;
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean v;
    public final boolean w;
    public final long x;
    public final long y;
    public final List<com.google.android.exoplayer2.m2.l.d.b> z;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.l.d> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.d a(Parcel parcel) {
            d dVar = new d(parcel, 0);
            return dVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.d[] b(int i) {
            return new d[i];
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

    public static final class b {

        public final int a;
        public final long b;
        public final long c;
        private b(int i, long l2, long l3) {
            super();
            this.a = i;
            this.b = l2;
            this.c = obj4;
        }

        b(int i, long l2, long l3, com.google.android.exoplayer2.m2.l.d.a d$a4) {
            super(i, l2, l3, a4, obj5);
        }

        public static com.google.android.exoplayer2.m2.l.d.b a(Parcel parcel) {
            super(parcel.readInt(), parcel.readLong(), obj3, parcel.readLong(), obj5);
            return bVar2;
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
        }
    }
    static {
        d.a aVar = new d.a();
        d.CREATOR = aVar;
    }

    private d(long l, boolean z2, boolean z3, boolean z4, boolean z5, long l6, long l7, List<com.google.android.exoplayer2.m2.l.d.b> list8, boolean z9, long l10, int i11, int i12, int i13) {
        final Object obj = this;
        super();
        obj.a = l;
        obj.b = z3;
        obj.c = z4;
        obj.v = z5;
        obj.w = l6;
        obj.x = l7;
        obj.y = z9;
        obj.z = Collections.unmodifiableList(i11);
        obj.A = i12;
        obj.B = i13;
        obj.C = obj18;
        obj.D = obj19;
        obj.E = obj20;
    }

    private d(Parcel parcel) {
        int i4;
        int i5;
        int i2;
        int i6;
        int i;
        int i3;
        com.google.android.exoplayer2.m2.l.d.b bVar;
        super();
        this.a = parcel.readLong();
        i = 0;
        final int i7 = 1;
        i4 = parcel.readByte() == i7 ? i7 : i;
        this.b = i4;
        i5 = parcel.readByte() == i7 ? i7 : i;
        this.c = i5;
        i2 = parcel.readByte() == i7 ? i7 : i;
        this.v = i2;
        i6 = parcel.readByte() == i7 ? i7 : i;
        this.w = i6;
        this.x = parcel.readLong();
        this.y = parcel.readLong();
        int int = parcel.readInt();
        ArrayList arrayList = new ArrayList(int);
        i3 = i;
        while (i3 < int) {
            arrayList.add(d.b.a(parcel));
            i3++;
        }
        this.z = Collections.unmodifiableList(arrayList);
        i = parcel.readByte() == i7 ? i7 : i;
        this.A = i;
        this.B = parcel.readLong();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
    }

    d(Parcel parcel, com.google.android.exoplayer2.m2.l.d.a d$a2) {
        super(parcel);
    }

    static com.google.android.exoplayer2.m2.l.d a(d0 d0, long l2, m0 m03) {
        Object emptyList;
        int i4;
        int i7;
        com.google.android.exoplayer2.m2.l.d.b bVar;
        int i15;
        int i;
        int i5;
        long l7;
        long l4;
        long l8;
        int i13;
        int i6;
        int i8;
        List list;
        int i9;
        int i10;
        long l6;
        long l;
        int arrayList;
        int i12;
        int i14;
        int i3;
        com.google.android.exoplayer2.m2.l.d.b bVar2;
        int i16;
        int i11;
        long l5;
        long l3;
        int i17;
        int i2;
        long l9;
        final Object obj = obj30;
        i = i18 &= 128 != 0 ? 1 : 0;
        if (i == 0) {
            int i33 = d0.x();
            i6 = i33 & 128 != 0 ? 1 : 0;
            i8 = i33 & 64 != 0 ? 1 : 0;
            i9 = i33 & 32 != 0 ? 1 : 0;
            i13 = i33 &= 16 != 0 ? 1 : 0;
            if (i8 != 0 && i13 == 0) {
                if (i13 == 0) {
                    l6 = g.b(d0, l2);
                } else {
                    l6 = -9223372036854775807L;
                }
            } else {
            }
            if (i8 == 0) {
                int i20 = d0.x();
                arrayList = new ArrayList(i20);
                i4 = 0;
                while (i4 < i20) {
                    if (i13 == 0) {
                    } else {
                    }
                    l7 = -9223372036854775807L;
                    super(d0.x(), l7, obj20, obj.b(l7), obj22, 0);
                    arrayList.add(bVar);
                    i4++;
                    l7 = l5;
                }
                emptyList = arrayList;
            }
            if (i9 != 0) {
                long l11 = (long)i22;
                i14 = Long.compare(i28, bVar2) != 0 ? 1 : 0;
                l4 = i4 / i32;
                i15 = i14;
            } else {
                i15 = 0;
                l4 = -9223372036854775807L;
            }
            i12 = i4;
            i2 = i8;
            i3 = i38;
            i16 = arrayList;
            list = emptyList;
            i10 = i15;
            l = l4;
            i5 = i13;
            i7 = i6;
            l8 = l9;
        } else {
            list = emptyList;
            i7 = 0;
            i5 = 0;
            l8 = -9223372036854775807L;
            i10 = 0;
            l = -9223372036854775807L;
            i12 = 0;
            i3 = 0;
            i16 = 0;
            i2 = 0;
        }
        super(d0.z(), obj3, i, i7, i2, i5, l8, i13, obj.b(l8), i8, list, i10, l, arrayList, i12, i3, i16);
        return dVar2;
    }

    @Override // com.google.android.exoplayer2.m2.l.b
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        Object obj;
        parcel.writeLong(this.a);
        parcel.writeByte((byte)obj4);
        parcel.writeByte((byte)obj4);
        parcel.writeByte((byte)obj4);
        parcel.writeByte((byte)obj4);
        parcel.writeLong(this.x);
        parcel.writeLong(this.y);
        int obj4 = this.z.size();
        parcel.writeInt(obj4);
        i = 0;
        while (i < obj4) {
            (d.b)this.z.get(i).b(parcel);
            i++;
        }
        parcel.writeByte((byte)obj4);
        parcel.writeLong(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
    }
}
