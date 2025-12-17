package com.google.android.exoplayer2.m2.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class k extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.k> CREATOR;
    public final int b;
    public final int c;
    public final int v;
    public final int[] w;
    public final int[] x;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.k> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.k a(Parcel parcel) {
            k kVar = new k(parcel);
            return kVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.k[] b(int i) {
            return new k[i];
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
        k.a aVar = new k.a();
        k.CREATOR = aVar;
    }

    public k(int i, int i2, int i3, int[] i4Arr4, int[] i5Arr5) {
        super("MLLT");
        this.b = i;
        this.c = i2;
        this.v = i3;
        this.w = i4Arr4;
        this.x = i5Arr5;
    }

    k(Parcel parcel) {
        super("MLLT");
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.v = parcel.readInt();
        int[] intArray = parcel.createIntArray();
        p0.i(intArray);
        this.w = (int[])intArray;
        final int[] obj2 = parcel.createIntArray();
        p0.i(obj2);
        this.x = (int[])obj2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i2;
        int equals;
        Class<com.google.android.exoplayer2.m2.k.k> obj;
        int i;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object != null) {
            if (k.class != object.getClass()) {
            } else {
                if (this.b == object.b && this.c == object.c && this.v == object.v && Arrays.equals(this.w, object.w) && Arrays.equals(this.x, object.x)) {
                    if (this.c == object.c) {
                        if (this.v == object.v) {
                            if (Arrays.equals(this.w, object.w)) {
                                if (Arrays.equals(this.x, object.x)) {
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
            }
            return i2;
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public int hashCode() {
        return i14 += i5;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.v);
        parcel.writeIntArray(this.w);
        parcel.writeIntArray(this.x);
    }
}
