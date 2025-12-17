package com.google.android.exoplayer2.m2.l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class f extends com.google.android.exoplayer2.m2.l.b {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.l.f> CREATOR;
    public final List<com.google.android.exoplayer2.m2.l.f.c> a;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.l.f> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.f a(Parcel parcel) {
            f fVar = new f(parcel, 0);
            return fVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.l.f[] b(int i) {
            return new f[i];
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
        private b(int i, long l2) {
            super();
            this.a = i;
            this.b = l2;
        }

        b(int i, long l2, com.google.android.exoplayer2.m2.l.f.a f$a3) {
            super(i, l2, a3);
        }

        static com.google.android.exoplayer2.m2.l.f.b a(Parcel parcel) {
            return f.b.c(parcel);
        }

        static void b(com.google.android.exoplayer2.m2.l.f.b f$b, Parcel parcel2) {
            b.d(parcel2);
        }

        private static com.google.android.exoplayer2.m2.l.f.b c(Parcel parcel) {
            f.b bVar = new f.b(parcel.readInt(), parcel.readLong(), obj3);
            return bVar;
        }

        private void d(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
        }
    }

    public static final class c {

        public final long a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final long e;
        public final List<com.google.android.exoplayer2.m2.l.f.b> f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;
        private c(long l, boolean z2, boolean z3, boolean z4, List<com.google.android.exoplayer2.m2.l.f.b> list5, long l6, boolean z7, long l8, int i9, int i10, int i11) {
            super();
            this.a = l;
            this.b = z3;
            this.c = z4;
            this.d = list5;
            this.f = Collections.unmodifiableList(l6);
            this.e = z7;
            this.g = i9;
            this.h = i10;
            this.i = obj12;
            this.j = obj13;
            this.k = obj14;
        }

        private c(Parcel parcel) {
            int i;
            int i4;
            int i5;
            int i2;
            int i3;
            com.google.android.exoplayer2.m2.l.f.b bVar;
            super();
            this.a = parcel.readLong();
            i2 = 0;
            final int i6 = 1;
            i = parcel.readByte() == i6 ? i6 : i2;
            this.b = i;
            i4 = parcel.readByte() == i6 ? i6 : i2;
            this.c = i4;
            i5 = parcel.readByte() == i6 ? i6 : i2;
            this.d = i5;
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i3 = i2;
            while (i3 < int) {
                arrayList.add(f.b.a(parcel));
                i3++;
            }
            this.f = Collections.unmodifiableList(arrayList);
            this.e = parcel.readLong();
            i2 = parcel.readByte() == i6 ? i6 : i2;
            this.g = i2;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }

        static com.google.android.exoplayer2.m2.l.f.c a(Parcel parcel) {
            return f.c.d(parcel);
        }

        static com.google.android.exoplayer2.m2.l.f.c b(d0 d0) {
            return f.c.e(d0);
        }

        static void c(com.google.android.exoplayer2.m2.l.f.c f$c, Parcel parcel2) {
            c.f(parcel2);
        }

        private static com.google.android.exoplayer2.m2.l.f.c d(Parcel parcel) {
            f.c cVar = new f.c(parcel);
            return cVar;
        }

        private static com.google.android.exoplayer2.m2.l.f.c e(d0 d0) {
            ArrayList arrayList;
            int i17;
            com.google.android.exoplayer2.m2.l.f.b bVar;
            int i12;
            int i2;
            int i6;
            long l2;
            int i15;
            ArrayList list;
            long l;
            int i16;
            int i7;
            int i5;
            int i3;
            int i;
            long l3;
            int i19;
            int i8;
            long l4;
            int i4;
            int i11;
            ArrayList arrayList2;
            int i10;
            int i13;
            int i9;
            int i14;
            long l5;
            int i18;
            i6 = i20 &= 128 != 0 ? 1 : 0;
            arrayList = new ArrayList();
            if (i6 == 0) {
                int i35 = d0.x();
                i5 = i35 & 128 != 0 ? 1 : 0;
                i = i35 & 64 != 0 ? 1 : 0;
                i16 = i35 &= i19 != 0 ? 1 : 0;
                if (i != 0) {
                    l4 = d0.z();
                } else {
                    l4 = -9223372036854775807L;
                }
                if (i == 0) {
                    int i22 = d0.x();
                    arrayList2 = new ArrayList(i22);
                    i13 = 0;
                    while (i13 < i22) {
                        bVar = new f.b(d0.x(), d0.z(), obj7, 0);
                        arrayList2.add(bVar);
                        i13++;
                        i19 = 32;
                    }
                    arrayList = arrayList2;
                }
                if (i16 != 0) {
                    long l7 = (long)i23;
                    i9 = Long.compare(i30, arrayList2) != 0 ? 1 : 0;
                    i15 = i17 / i34;
                    i12 = i9;
                } else {
                    i12 = 0;
                    i15 = -9223372036854775807L;
                }
                i14 = i;
                i10 = i8;
                l3 = i15;
                list = arrayList;
                i4 = i17;
                i11 = i7;
                l = l5;
                i3 = i12;
                i2 = i18;
            } else {
                list = arrayList;
                i2 = 0;
                l = -9223372036854775807L;
                i3 = 0;
                l3 = -9223372036854775807L;
                i4 = 0;
                i11 = 0;
                i10 = 0;
                i14 = 0;
            }
            super(d0.z(), obj2, i6, i2, i14, list, l, i7, i3, l3, i8, i4, i11, i10);
            return cVar2;
        }

        private void f(Parcel parcel) {
            int i;
            Object obj;
            parcel.writeLong(this.a);
            parcel.writeByte((byte)z);
            parcel.writeByte((byte)z2);
            parcel.writeByte((byte)z3);
            int size = this.f.size();
            parcel.writeInt(size);
            i = 0;
            while (i < size) {
                f.b.b((f.b)this.f.get(i), parcel);
                i++;
            }
            parcel.writeLong(this.e);
            parcel.writeByte((byte)z4);
            parcel.writeLong(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }
    }
    static {
        f.a aVar = new f.a();
        f.CREATOR = aVar;
    }

    private f(Parcel parcel) {
        int i;
        com.google.android.exoplayer2.m2.l.f.c cVar;
        super();
        final int int = parcel.readInt();
        ArrayList arrayList = new ArrayList(int);
        i = 0;
        while (i < int) {
            arrayList.add(f.c.a(parcel));
            i++;
        }
        this.a = Collections.unmodifiableList(arrayList);
    }

    f(Parcel parcel, com.google.android.exoplayer2.m2.l.f.a f$a2) {
        super(parcel);
    }

    private f(List<com.google.android.exoplayer2.m2.l.f.c> list) {
        super();
        this.a = Collections.unmodifiableList(list);
    }

    static com.google.android.exoplayer2.m2.l.f a(d0 d0) {
        int i;
        com.google.android.exoplayer2.m2.l.f.c cVar;
        final int i2 = d0.x();
        ArrayList arrayList = new ArrayList(i2);
        i = 0;
        while (i < i2) {
            arrayList.add(f.c.b(d0));
            i++;
        }
        f obj4 = new f(arrayList);
        return obj4;
    }

    @Override // com.google.android.exoplayer2.m2.l.b
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        Object obj;
        int obj4 = this.a.size();
        parcel.writeInt(obj4);
        i = 0;
        while (i < obj4) {
            f.c.c((f.c)this.a.get(i), parcel);
            i++;
        }
    }
}
