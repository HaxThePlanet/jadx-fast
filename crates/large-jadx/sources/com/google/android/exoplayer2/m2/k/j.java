package com.google.android.exoplayer2.m2.k;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public final class j extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.j> CREATOR;
    public final String b;
    public final String c;
    public final String v;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.j> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.j a(Parcel parcel) {
            j jVar = new j(parcel);
            return jVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.j[] b(int i) {
            return new j[i];
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
        j.a aVar = new j.a();
        j.CREATOR = aVar;
    }

    j(Parcel parcel) {
        super("----");
        String string = parcel.readString();
        p0.i(string);
        this.b = (String)string;
        String string2 = parcel.readString();
        p0.i(string2);
        this.c = (String)string2;
        final String obj2 = parcel.readString();
        p0.i(obj2);
        this.v = (String)obj2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i;
        String z;
        Class<com.google.android.exoplayer2.m2.k.j> obj;
        String str;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (j.class != object.getClass()) {
            } else {
                if (p0.b(this.c, object.c) && p0.b(this.b, object.b) && p0.b(this.v, object.v)) {
                    if (p0.b(this.b, object.b)) {
                        if (p0.b(this.v, object.v)) {
                        } else {
                            i = i2;
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
        int i2;
        int i;
        int i3;
        String str = this.b;
        i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = i3;
        }
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        } else {
            i = i3;
        }
        String str3 = this.v;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i8 += i3;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public String toString() {
        String str = this.a;
        final String str4 = this.b;
        final String str5 = this.c;
        StringBuilder stringBuilder = new StringBuilder(i2 += length3);
        stringBuilder.append(str);
        stringBuilder.append(": domain=");
        stringBuilder.append(str4);
        stringBuilder.append(", description=");
        stringBuilder.append(str5);
        return stringBuilder.toString();
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.v);
    }
}
