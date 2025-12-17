package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Calendar;

/* loaded from: classes2.dex */
final class m implements Comparable<com.google.android.material.datepicker.m>, Parcelable {

    public static final Parcelable.Creator<com.google.android.material.datepicker.m> CREATOR;
    private final Calendar a;
    final int b;
    final int c;
    final int v;
    final int w;
    final long x;
    private String y;

    static class a implements Parcelable.Creator<com.google.android.material.datepicker.m> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.material.datepicker.m a(Parcel parcel) {
            return m.c(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.material.datepicker.m[] b(int i) {
            return new m[i];
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
        m.a aVar = new m.a();
        m.CREATOR = aVar;
    }

    private m(Calendar calendar) {
        super();
        int i = 5;
        int i2 = 1;
        calendar.set(i, i2);
        final Calendar obj4 = u.f(calendar);
        this.a = obj4;
        this.b = obj4.get(2);
        this.c = obj4.get(i2);
        this.v = obj4.getMaximum(7);
        this.w = obj4.getActualMaximum(i);
        this.x = obj4.getTimeInMillis();
    }

    static com.google.android.material.datepicker.m c(int i, int i2) {
        final Calendar calendar = u.q();
        calendar.set(1, i);
        calendar.set(2, i2);
        m obj2 = new m(calendar);
        return obj2;
    }

    static com.google.android.material.datepicker.m e(long l) {
        final Calendar calendar = u.q();
        calendar.setTimeInMillis(l);
        m obj1 = new m(calendar);
        return obj1;
    }

    static com.google.android.material.datepicker.m f() {
        m mVar = new m(u.o());
        return mVar;
    }

    @Override // java.lang.Comparable
    public int a(com.google.android.material.datepicker.m m) {
        return this.a.compareTo(m.a);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return a((m)object);
    }

    @Override // java.lang.Comparable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        int i2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (!object instanceof m) {
            return i3;
        }
        if (this.b == object.b && this.c == object.c) {
            if (this.c == object.c) {
            } else {
                i = i3;
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        Object[] arr = new Object[2];
        return Arrays.hashCode(Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    @Override // java.lang.Comparable
    int i() {
        int i;
        int firstDayOfWeek;
        i2 -= firstDayOfWeek;
        if (i < 0) {
            i += firstDayOfWeek;
        }
        return i;
    }

    @Override // java.lang.Comparable
    long j(int i) {
        Calendar calendar2 = u.f(this.a);
        calendar2.set(5, i);
        return calendar2.getTimeInMillis();
    }

    @Override // java.lang.Comparable
    int k(long l) {
        Calendar calendar2 = u.f(this.a);
        calendar2.setTimeInMillis(l);
        return calendar2.get(5);
    }

    @Override // java.lang.Comparable
    String m(Context context) {
        String timeInMillis;
        String obj3;
        if (this.y == null) {
            this.y = f.g(context, this.a.getTimeInMillis());
        }
        return this.y;
    }

    @Override // java.lang.Comparable
    long n() {
        return this.a.getTimeInMillis();
    }

    @Override // java.lang.Comparable
    com.google.android.material.datepicker.m o(int i) {
        Calendar calendar2 = u.f(this.a);
        calendar2.add(2, i);
        m obj3 = new m(calendar2);
        return obj3;
    }

    @Override // java.lang.Comparable
    int p(com.google.android.material.datepicker.m m) {
        if (!calendar instanceof GregorianCalendar) {
        } else {
            return i3 += obj3;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Only Gregorian calendars are supported.");
        throw obj3;
    }

    @Override // java.lang.Comparable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.b);
    }
}
