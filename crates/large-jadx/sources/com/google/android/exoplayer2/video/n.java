package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes2.dex */
public final class n implements Parcelable {

    public static final Parcelable.Creator<com.google.android.exoplayer2.video.n> CREATOR;
    public final int a;
    public final int b;
    public final int c;
    public final byte[] v;
    private int w;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.video.n> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.video.n a(Parcel parcel) {
            n nVar = new n(parcel);
            return nVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.video.n[] b(int i) {
            return new n[i];
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
        n.a aVar = new n.a();
        n.CREATOR = aVar;
    }

    public n(int i, int i2, int i3, byte[] b4Arr4) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.v = b4Arr4;
    }

    n(Parcel parcel) {
        byte[] obj2;
        super();
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        if (p0.w0(parcel)) {
            obj2 = parcel.createByteArray();
        } else {
            obj2 = 0;
        }
        this.v = obj2;
    }

    @Pure
    public static int a(int i) {
        int i2;
        int i3 = 1;
        final int i5 = 6;
        if (i != i3 && i != 9 && i != 4 && i != 5 && i != i5 && i != 7) {
            i5 = 6;
            if (i != 9) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != i5) {
                            if (i != 7) {
                                return -1;
                            }
                        }
                    }
                }
                return 2;
            }
            return i5;
        }
        return i3;
    }

    @Pure
    public static int b(int i) {
        int i3;
        int i4;
        int i2;
        i4 = 6;
        i2 = 7;
        if (i != 1 && i != 16 && i != 18 && i != i4 && i != i2) {
            i4 = 6;
            if (i != 16) {
                i2 = 7;
                if (i != 18) {
                    if (i != i4) {
                        if (i != i2) {
                            return -1;
                        }
                    }
                }
                return i2;
            }
            return i4;
        }
        return 3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i3;
        int i;
        Class<com.google.android.exoplayer2.video.n> obj;
        int i2;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i4 = 0;
        if (object != null) {
            if (n.class != object.getClass()) {
            } else {
                if (this.a == object.a && this.b == object.b && this.c == object.c && Arrays.equals(this.v, object.v)) {
                    if (this.b == object.b) {
                        if (this.c == object.c) {
                            if (Arrays.equals(this.v, object.v)) {
                            } else {
                                i3 = i4;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i3;
        }
        return i4;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i2;
        int i;
        if (this.w == 0) {
            this.w = i10 += i;
        }
        return this.w;
    }

    @Override // android.os.Parcelable
    public String toString() {
        int i;
        i = this.v != null ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("ColorInfo(");
        stringBuilder.append(this.a);
        String str = ", ";
        stringBuilder.append(str);
        stringBuilder.append(this.b);
        stringBuilder.append(str);
        stringBuilder.append(this.c);
        stringBuilder.append(str);
        stringBuilder.append(i);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int obj2;
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        obj2 = this.v != null ? 1 : 0;
        p0.L0(parcel, obj2);
        obj2 = this.v;
        if (obj2 != null) {
            parcel.writeByteArray(obj2);
        }
    }
}
