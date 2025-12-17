package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class l0 implements Parcelable {

    public static final Parcelable.Creator<com.google.android.exoplayer2.source.l0> CREATOR;
    public static final com.google.android.exoplayer2.source.l0 v;
    public final int a;
    private final com.google.android.exoplayer2.source.k0[] b;
    private int c;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.source.l0> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.source.l0 a(Parcel parcel) {
            l0 l0Var = new l0(parcel);
            return l0Var;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.source.l0[] b(int i) {
            return new l0[i];
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
        l0 l0Var = new l0(new k0[0]);
        l0.v = l0Var;
        l0.a aVar = new l0.a();
        l0.CREATOR = aVar;
    }

    l0(Parcel parcel) {
        int i;
        com.google.android.exoplayer2.source.k0[] objArr;
        Parcelable parcelable;
        super();
        int int = parcel.readInt();
        this.a = int;
        this.b = new k0[int];
        i = 0;
        while (i < this.a) {
            this.b[i] = (k0)parcel.readParcelable(k0.class.getClassLoader());
            i++;
        }
    }

    public l0(com.google.android.exoplayer2.source.k0... k0Arr) {
        super();
        this.b = k0Arr;
        this.a = k0Arr.length;
    }

    @Override // android.os.Parcelable
    public com.google.android.exoplayer2.source.k0 a(int i) {
        return this.b[i];
    }

    @Override // android.os.Parcelable
    public int b(com.google.android.exoplayer2.source.k0 k0) {
        int i;
        com.google.android.exoplayer2.source.k0 k0Var;
        i = 0;
        while (i < this.a) {
            i++;
        }
        return -1;
    }

    @Override // android.os.Parcelable
    public boolean c() {
        int i;
        i = this.a == 0 ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i2;
        com.google.android.exoplayer2.source.k0[] i;
        Class<com.google.android.exoplayer2.source.l0> obj;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object != null) {
            if (l0.class != object.getClass()) {
            } else {
                if (this.a == object.a && Arrays.equals(this.b, object.b)) {
                    if (Arrays.equals(this.b, object.b)) {
                    } else {
                        i2 = i3;
                    }
                } else {
                }
            }
            return i2;
        }
        return i3;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b);
        }
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        com.google.android.exoplayer2.source.k0 k0Var;
        parcel.writeInt(this.a);
        int obj4 = 0;
        i = obj4;
        while (i < this.a) {
            parcel.writeParcelable(this.b[i], obj4);
            i++;
        }
    }
}
