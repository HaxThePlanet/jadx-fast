package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.h.k.c;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a implements Parcelable {

    public static final Parcelable.Creator<com.google.android.material.datepicker.a> CREATOR;
    private final com.google.android.material.datepicker.m a;
    private final com.google.android.material.datepicker.m b;
    private final com.google.android.material.datepicker.a.c c;
    private com.google.android.material.datepicker.m v;
    private final int w;
    private final int x;

    static class a implements Parcelable.Creator<com.google.android.material.datepicker.a> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.material.datepicker.a a(Parcel parcel) {
            super((m)parcel.readParcelable(m.class.getClassLoader()), (m)parcel.readParcelable(m.class.getClassLoader()), (a.c)parcel.readParcelable(a.c.class.getClassLoader()), (m)parcel.readParcelable(m.class.getClassLoader()), 0);
            return obj8;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.material.datepicker.a[] b(int i) {
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

    public static final class b {

        static final long e;
        static final long f;
        private long a;
        private long b;
        private Long c;
        private com.google.android.material.datepicker.a.c d;
        static {
            int i3 = 0;
            a.b.e = u.a(mVar.x);
            int i4 = 11;
            a.b.f = u.a(mVar2.x);
        }

        public b() {
            super();
            this.a = a.b.e;
            this.b = a.b.f;
            this.d = g.a(Long.MIN_VALUE);
        }

        b(com.google.android.material.datepicker.a a) {
            super();
            this.a = a.b.e;
            this.b = a.b.f;
            this.d = g.a(Long.MIN_VALUE);
            this.a = mVar.x;
            this.b = mVar2.x;
            this.c = Long.valueOf(mVar3.x);
            this.d = a.d(a);
        }

        public com.google.android.material.datepicker.a a() {
            int i;
            String longValue;
            Bundle bundle = new Bundle();
            longValue = "DEEP_COPY_VALIDATOR_KEY";
            bundle.putParcelable(longValue, this.d);
            long l = this.a;
            Long num = this.c;
            if (num == null) {
                i = 0;
            } else {
                i = m.e(num.longValue());
            }
            super(m.e(l), m.e(this.b), (a.c)bundle.getParcelable(longValue), i, 0);
            return aVar;
        }

        public com.google.android.material.datepicker.a.b b(long l) {
            this.c = Long.valueOf(l);
            return this;
        }
    }

    public interface c extends Parcelable {
        @Override // android.os.Parcelable
        public abstract boolean g1(long l);
    }
    static {
        a.a aVar = new a.a();
        a.CREATOR = aVar;
    }

    private a(com.google.android.material.datepicker.m m, com.google.android.material.datepicker.m m2, com.google.android.material.datepicker.a.c a$c3, com.google.android.material.datepicker.m m4) {
        com.google.android.material.datepicker.a.c obj3;
        super();
        this.a = m;
        this.b = m2;
        this.v = m4;
        this.c = c3;
        if (m4 != null) {
            if (m.a(m4) > 0) {
            } else {
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("start Month cannot be after current Month");
            throw obj1;
        }
        if (m4 != null) {
            if (m4.a(m2) > 0) {
            } else {
            }
            obj1 = new IllegalArgumentException("current Month cannot be after end Month");
            throw obj1;
        }
        this.x = obj3++;
        this.w = obj2++;
    }

    a(com.google.android.material.datepicker.m m, com.google.android.material.datepicker.m m2, com.google.android.material.datepicker.a.c a$c3, com.google.android.material.datepicker.m m4, com.google.android.material.datepicker.a.a a$a5) {
        super(m, m2, c3, m4);
    }

    static com.google.android.material.datepicker.m a(com.google.android.material.datepicker.a a) {
        return a.a;
    }

    static com.google.android.material.datepicker.m b(com.google.android.material.datepicker.a a) {
        return a.b;
    }

    static com.google.android.material.datepicker.m c(com.google.android.material.datepicker.a a) {
        return a.v;
    }

    static com.google.android.material.datepicker.a.c d(com.google.android.material.datepicker.a a) {
        return a.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    com.google.android.material.datepicker.m e(com.google.android.material.datepicker.m m) {
        com.google.android.material.datepicker.m obj2;
        if (m.a(this.a) < 0) {
            return this.a;
        }
        if (m.a(this.b) > 0) {
            obj2 = this.b;
        }
        return obj2;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i;
        boolean equals;
        com.google.android.material.datepicker.m mVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof a) {
            return i2;
        }
        if (this.a.equals(object.a) && this.b.equals(object.b) && c.a(this.v, object.v) && this.c.equals(object.c)) {
            if (this.b.equals(object.b)) {
                if (c.a(this.v, object.v)) {
                    if (this.c.equals(object.c)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public com.google.android.material.datepicker.a.c f() {
        return this.c;
    }

    @Override // android.os.Parcelable
    com.google.android.material.datepicker.m g() {
        return this.b;
    }

    @Override // android.os.Parcelable
    int h() {
        return this.x;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        Object[] arr = new Object[4];
        return Arrays.hashCode(this.a, this.b, this.v, this.c);
    }

    @Override // android.os.Parcelable
    com.google.android.material.datepicker.m i() {
        return this.v;
    }

    @Override // android.os.Parcelable
    com.google.android.material.datepicker.m j() {
        return this.a;
    }

    @Override // android.os.Parcelable
    int k() {
        return this.w;
    }

    @Override // android.os.Parcelable
    boolean l(long l) {
        int cmp;
        int i;
        long l2;
        long obj5;
        cmp = this.b;
        if (Long.compare(l2, l) <= 0 && Long.compare(l, l2) <= 0) {
            cmp = this.b;
            if (Long.compare(l, l2) <= 0) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    void m(com.google.android.material.datepicker.m m) {
        this.v = m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        final int i = 0;
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.v, i);
        parcel.writeParcelable(this.c, i);
    }
}
