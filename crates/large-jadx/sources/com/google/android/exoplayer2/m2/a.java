package com.google.android.exoplayer2.m2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.n1.b;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class a implements Parcelable {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.a> CREATOR;
    private final com.google.android.exoplayer2.m2.a.b[] a;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.a> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.a a(Parcel parcel) {
            a aVar = new a(parcel);
            return aVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.a[] b(int i) {
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

    public interface b extends Parcelable {
        @Override // android.os.Parcelable
        public byte[] S1() {
            return null;
        }

        @Override // android.os.Parcelable
        public i1 g0() {
            return null;
        }

        @Override // android.os.Parcelable
        public void w(n1.b n1$b) {
        }
    }
    static {
        a.a aVar = new a.a();
        a.CREATOR = aVar;
    }

    a(Parcel parcel) {
        int i;
        com.google.android.exoplayer2.m2.a.b[] objArr;
        Parcelable parcelable;
        super();
        this.a = new a.b[parcel.readInt()];
        i = 0;
        objArr = this.a;
        while (i < objArr.length) {
            objArr[i] = (a.b)parcel.readParcelable(a.b.class.getClassLoader());
            i++;
            objArr = this.a;
        }
    }

    public a(List<? extends com.google.android.exoplayer2.m2.a.b> list) {
        super();
        this.a = (a.b[])list.toArray(new a.b[0]);
    }

    public a(com.google.android.exoplayer2.m2.a.b... a$bArr) {
        super();
        this.a = bArr;
    }

    @Override // android.os.Parcelable
    public com.google.android.exoplayer2.m2.a a(com.google.android.exoplayer2.m2.a.b... a$bArr) {
        if (bArr.length == 0) {
            return this;
        }
        a aVar = new a((a.b[])p0.r0(this.a, bArr));
        return aVar;
    }

    @Override // android.os.Parcelable
    public com.google.android.exoplayer2.m2.a b(com.google.android.exoplayer2.m2.a a) {
        if (a == null) {
            return this;
        }
        return a(a.a);
    }

    @Override // android.os.Parcelable
    public com.google.android.exoplayer2.m2.a.b c(int i) {
        return this.a[i];
    }

    @Override // android.os.Parcelable
    public int d() {
        return objArr.length;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        Class<com.google.android.exoplayer2.m2.a> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && a.class != object.getClass()) {
            if (a.class != object.getClass()) {
            }
            return Arrays.equals(this.a, object.a);
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // android.os.Parcelable
    public String toString() {
        String concat;
        String valueOf = String.valueOf(Arrays.toString(this.a));
        final String str = "entries=";
        if (valueOf.length() != 0) {
            concat = str.concat(valueOf);
        } else {
            concat = new String(str);
        }
        return concat;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        com.google.android.exoplayer2.m2.a.b bVar;
        parcel.writeInt(obj6.length);
        com.google.android.exoplayer2.m2.a.b[] obj6 = this.a;
        final int i3 = 0;
        i = i3;
        while (i < obj6.length) {
            parcel.writeParcelable(obj6[i], i3);
            i++;
        }
    }
}
