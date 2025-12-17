package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class k0 implements Parcelable {

    public static final Parcelable.Creator<com.google.android.exoplayer2.source.k0> CREATOR;
    public final int a;
    private final i1[] b;
    private int c;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.source.k0> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.source.k0 a(Parcel parcel) {
            k0 k0Var = new k0(parcel);
            return k0Var;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.source.k0[] b(int i) {
            return new k0[i];
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
        k0.a aVar = new k0.a();
        k0.CREATOR = aVar;
    }

    k0(Parcel parcel) {
        int i;
        i1[] objArr;
        Parcelable parcelable;
        super();
        int int = parcel.readInt();
        this.a = int;
        this.b = new i1[int];
        i = 0;
        while (i < this.a) {
            this.b[i] = (i1)parcel.readParcelable(i1.class.getClassLoader());
            i++;
        }
    }

    public k0(i1... i1Arr) {
        int i;
        super();
        i = i1Arr.length > 0 ? 1 : 0;
        g.f(i);
        this.b = i1Arr;
        this.a = i1Arr.length;
        f();
    }

    private static void c(String string, String string2, String string3, int i4) {
        StringBuilder stringBuilder = new StringBuilder(i2 += length3);
        stringBuilder.append("Different ");
        stringBuilder.append(string);
        stringBuilder.append(" combined in one TrackGroup: '");
        stringBuilder.append(string2);
        stringBuilder.append("' (track 0) and '");
        stringBuilder.append(string3);
        stringBuilder.append("' (track ");
        stringBuilder.append(i4);
        stringBuilder.append(")");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        v.d("TrackGroup", "", illegalStateException);
    }

    private static String d(String string) {
        boolean equals;
        String obj1;
        if (string != null) {
            if (string.equals("und")) {
                obj1 = "";
            }
        } else {
        }
        return obj1;
    }

    private static int e(int i) {
        return i |= 16384;
    }

    private void f() {
        int i;
        int i2;
        int length;
        int i4 = 0;
        i = 1;
        i1[] objArr6 = this.b;
        for (Object i1Var8 : obj4) {
            objArr6 = this.b;
        }
    }

    @Override // android.os.Parcelable
    public i1 a(int i) {
        return this.b[i];
    }

    @Override // android.os.Parcelable
    public int b(i1 i1) {
        int i;
        i1 i1Var;
        int length;
        i = 0;
        i1[] objArr = this.b;
        for (Object i1Var : obj1) {
            objArr = this.b;
        }
        return -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i2;
        i1[] i;
        Class<com.google.android.exoplayer2.source.k0> obj;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object != null) {
            if (k0.class != object.getClass()) {
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
        int i2;
        if (this.c == 0) {
            this.c = i4 += i2;
        }
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        i1 i1Var;
        parcel.writeInt(this.a);
        int obj4 = 0;
        i = obj4;
        while (i < this.a) {
            parcel.writeParcelable(this.b[i], obj4);
            i++;
        }
    }
}
