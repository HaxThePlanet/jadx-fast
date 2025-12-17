package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

/* loaded from: classes2.dex */
class e implements Parcelable {

    public static final Parcelable.Creator<com.google.android.material.timepicker.e> CREATOR;
    private final com.google.android.material.timepicker.c a;
    private final com.google.android.material.timepicker.c b;
    final int c;
    int v;
    int w;
    int x;
    int y;

    static class a implements Parcelable.Creator<com.google.android.material.timepicker.e> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.material.timepicker.e a(Parcel parcel) {
            e eVar = new e(parcel);
            return eVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.material.timepicker.e[] b(int i) {
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

    public e() {
        super(0);
    }

    public e(int i) {
        final int i2 = 0;
        super(i2, i2, 10, i);
    }

    public e(int i, int i2, int i3, int i4) {
        int obj2;
        super();
        this.v = i;
        this.w = i2;
        this.x = i3;
        this.c = i4;
        this.y = e.f(i);
        c obj1 = new c(59);
        this.a = obj1;
        obj2 = i4 == 1 ? 24 : 12;
        obj1 = new c(obj2);
        this.b = obj1;
    }

    protected e(Parcel parcel) {
        super(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    public static String a(Resources resources, java.lang.CharSequence charSequence2) {
        return e.b(resources, charSequence2, "%02d");
    }

    public static String b(Resources resources, java.lang.CharSequence charSequence2, String string3) {
        Object[] arr = new Object[1];
        return String.format(obj2.locale, string3, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence2))));
    }

    private static int f(int i) {
        int obj1;
        obj1 = i >= 12 ? 1 : 0;
        return obj1;
    }

    @Override // android.os.Parcelable
    public int c() {
        int i;
        final int i5 = 1;
        if (this.c == i5) {
            return i3 %= 24;
        }
        i = this.v;
        final int i8 = 12;
        if (i % 12 == 0) {
            return i8;
        }
        if (this.y == i5) {
            i -= i8;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public com.google.android.material.timepicker.c d() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public com.google.android.material.timepicker.c e() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i3;
        int i;
        int i2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i4 = 0;
        if (!object instanceof e) {
            return i4;
        }
        if (this.v == object.v && this.w == object.w && this.c == object.c && this.x == object.x) {
            if (this.w == object.w) {
                if (this.c == object.c) {
                    if (this.x == object.x) {
                    } else {
                        i3 = i4;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i3;
    }

    @Override // android.os.Parcelable
    public void g(int i) {
        int i2;
        final int i4 = 1;
        if (this.c == i4) {
            this.v = i;
        }
        if (this.y == i4) {
        } else {
            i2 = 0;
        }
        this.v = obj4 += i2;
    }

    @Override // android.os.Parcelable
    public void h(int i) {
        this.y = e.f(i);
        this.v = i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        Object[] arr = new Object[4];
        return Arrays.hashCode(Integer.valueOf(this.c), Integer.valueOf(this.v), Integer.valueOf(this.w), Integer.valueOf(this.x));
    }

    @Override // android.os.Parcelable
    public void i(int i) {
        this.w = i %= 60;
    }

    @Override // android.os.Parcelable
    public void j(int i) {
        int i3;
        int i4;
        int i2;
        if (i != this.y) {
            this.y = i;
            i3 = this.v;
            i4 = 12;
            if (i3 < i4 && i == 1) {
                if (i == 1) {
                    this.v = i3 += i4;
                } else {
                    if (i3 >= i4 && i == 0) {
                        if (i == 0) {
                            this.v = i3 -= i4;
                        }
                    }
                }
            } else {
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeInt(this.c);
    }
}
