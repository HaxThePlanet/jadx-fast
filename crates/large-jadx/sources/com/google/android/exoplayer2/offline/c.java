package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public final class c implements Comparable<com.google.android.exoplayer2.offline.c>, Parcelable {

    public static final Parcelable.Creator<com.google.android.exoplayer2.offline.c> CREATOR;
    public final int a;
    public final int b;
    public final int c;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.offline.c> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.offline.c a(Parcel parcel) {
            c cVar = new c(parcel);
            return cVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.offline.c[] b(int i) {
            return new c[i];
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
        c.a aVar = new c.a();
        c.CREATOR = aVar;
    }

    c(Parcel parcel) {
        super();
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public int a(com.google.android.exoplayer2.offline.c c) {
        int i;
        int i2;
        Object obj3;
        if (i3 -= i2 == 0 && i4 -= i2 == 0) {
            if (i4 -= i2 == 0) {
                i5 -= obj3;
            }
        }
        return i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return a((c)object);
    }

    @Override // java.lang.Comparable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i2;
        int i;
        Class<com.google.android.exoplayer2.offline.c> obj;
        int i3;
        Class class;
        int obj5;
        if (this == object) {
            return 1;
        }
        final int i4 = 0;
        if (object != null) {
            if (c.class != object.getClass()) {
            } else {
                if (this.a == object.a && this.b == object.b && this.c == object.c) {
                    if (this.b == object.b) {
                        if (this.c == object.c) {
                        } else {
                            i2 = i4;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i2;
        }
        return i4;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append(this.a);
        String str = ".";
        stringBuilder.append(str);
        stringBuilder.append(this.b);
        stringBuilder.append(str);
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    @Override // java.lang.Comparable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }
}
