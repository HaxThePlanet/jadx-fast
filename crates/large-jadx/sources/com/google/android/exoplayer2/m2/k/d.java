package com.google.android.exoplayer2.m2.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class d extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.d> CREATOR;
    public final String b;
    public final int c;
    public final int v;
    public final long w;
    public final long x;
    private final com.google.android.exoplayer2.m2.k.i[] y;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.d> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.d a(Parcel parcel) {
            d dVar = new d(parcel);
            return dVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.d[] b(int i) {
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
    static {
        d.a aVar = new d.a();
        d.CREATOR = aVar;
    }

    d(Parcel parcel) {
        int i;
        com.google.android.exoplayer2.m2.k.i[] objArr;
        android.os.Parcelable parcelable;
        super("CHAP");
        String string = parcel.readString();
        p0.i(string);
        this.b = (String)string;
        this.c = parcel.readInt();
        this.v = parcel.readInt();
        this.w = parcel.readLong();
        this.x = parcel.readLong();
        int int3 = parcel.readInt();
        this.y = new i[int3];
        i = 0;
        while (i < int3) {
            this.y[i] = (i)parcel.readParcelable(i.class.getClassLoader());
            i++;
        }
    }

    public d(String string, int i2, int i3, long l4, long l5, com.google.android.exoplayer2.m2.k.i[] i6Arr6) {
        super("CHAP");
        this.b = string;
        this.c = i2;
        this.v = i3;
        this.w = l4;
        this.x = i6Arr6;
        this.y = obj9;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i2;
        int cmp;
        Class<com.google.android.exoplayer2.m2.k.d> obj;
        int i;
        Class class;
        long l;
        Object obj7;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object != null) {
            if (d.class != object.getClass()) {
            } else {
                if (this.c == object.c && this.v == object.v && Long.compare(l2, l) == 0 && Long.compare(l3, l) == 0 && p0.b(this.b, object.b) && Arrays.equals(this.y, object.y)) {
                    if (this.v == object.v) {
                        if (Long.compare(l2, l) == 0) {
                            if (Long.compare(l3, l) == 0) {
                                if (p0.b(this.b, object.b)) {
                                    if (Arrays.equals(this.y, object.y)) {
                                    } else {
                                        i2 = i3;
                                    }
                                } else {
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
            return i2;
        }
        return i3;
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
        return i14 += i;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        com.google.android.exoplayer2.m2.k.i iVar;
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.v);
        parcel.writeLong(this.w);
        parcel.writeLong(this.x);
        parcel.writeInt(obj6.length);
        com.google.android.exoplayer2.m2.k.i[] obj6 = this.y;
        final int i3 = 0;
        i = i3;
        while (i < obj6.length) {
            parcel.writeParcelable(obj6[i], i3);
            i++;
        }
    }
}
