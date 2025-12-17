package com.google.android.exoplayer2.m2.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class e extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.e> CREATOR;
    public final String b;
    public final boolean c;
    public final boolean v;
    public final String[] w;
    private final com.google.android.exoplayer2.m2.k.i[] x;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.e> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.e a(Parcel parcel) {
            e eVar = new e(parcel);
            return eVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.e[] b(int i) {
            return new e[i];
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
        e.a aVar = new e.a();
        e.CREATOR = aVar;
    }

    e(Parcel parcel) {
        int i3;
        int i2;
        com.google.android.exoplayer2.m2.k.i[] arr;
        int i;
        android.os.Parcelable parcelable;
        super("CTOC");
        String string = parcel.readString();
        p0.i(string);
        this.b = (String)string;
        i = 0;
        i3 = parcel.readByte() != 0 ? i2 : i;
        this.c = i3;
        if (parcel.readByte() != 0) {
        } else {
            i2 = i;
        }
        this.v = i2;
        String[] stringArray = parcel.createStringArray();
        p0.i(stringArray);
        this.w = (String[])stringArray;
        int int = parcel.readInt();
        this.x = new i[int];
        while (i < int) {
            this.x[i] = (i)parcel.readParcelable(i.class.getClassLoader());
            i++;
        }
    }

    public e(String string, boolean z2, boolean z3, String[] string4Arr4, com.google.android.exoplayer2.m2.k.i[] i5Arr5) {
        super("CTOC");
        this.b = string;
        this.c = z2;
        this.v = z3;
        this.w = string4Arr4;
        this.x = i5Arr5;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Class<com.google.android.exoplayer2.m2.k.e> obj;
        boolean z;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (e.class != object.getClass()) {
            } else {
                if (this.c == object.c && this.v == object.v && p0.b(this.b, object.b) && Arrays.equals(this.w, object.w) && Arrays.equals(this.x, object.x)) {
                    if (this.v == object.v) {
                        if (p0.b(this.b, object.b)) {
                            if (Arrays.equals(this.w, object.w)) {
                                if (Arrays.equals(this.x, object.x)) {
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

    @Override // com.google.android.exoplayer2.m2.k.i
    public int hashCode() {
        int i;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return i6 += i;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        com.google.android.exoplayer2.m2.k.i iVar;
        parcel.writeString(this.b);
        parcel.writeByte((byte)obj6);
        parcel.writeByte((byte)obj6);
        parcel.writeStringArray(this.w);
        parcel.writeInt(obj6.length);
        com.google.android.exoplayer2.m2.k.i[] obj6 = this.x;
        final int i3 = 0;
        i = i3;
        while (i < obj6.length) {
            parcel.writeParcelable(obj6[i], i3);
            i++;
        }
    }
}
