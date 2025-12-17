package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class g implements com.google.android.material.datepicker.a.c {

    public static final Parcelable.Creator<com.google.android.material.datepicker.g> CREATOR;
    private final long a;

    static class a implements Parcelable.Creator<com.google.android.material.datepicker.g> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.material.datepicker.g a(Parcel parcel) {
            g gVar = new g(parcel.readLong(), obj2, 0);
            return gVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.material.datepicker.g[] b(int i) {
            return new g[i];
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
        g.a aVar = new g.a();
        g.CREATOR = aVar;
    }

    private g(long l) {
        super();
        this.a = l;
    }

    g(long l, com.google.android.material.datepicker.g.a g$a2) {
        super(l, a2);
    }

    public static com.google.android.material.datepicker.g a(long l) {
        g gVar = new g(l, obj2);
        return gVar;
    }

    @Override // com.google.android.material.datepicker.a$c
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.a$c
    public boolean equals(Object object) {
        int i;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof g) {
            return i2;
        }
        if (Long.compare(l, l2) == 0) {
        } else {
            i = i2;
        }
        return i;
    }

    @Override // com.google.android.material.datepicker.a$c
    public boolean g1(long l) {
        int obj3;
        obj3 = Long.compare(l, l2) >= 0 ? 1 : 0;
        return obj3;
    }

    @Override // com.google.android.material.datepicker.a$c
    public int hashCode() {
        Object[] arr = new Object[1];
        return Arrays.hashCode(Long.valueOf(this.a));
    }

    @Override // com.google.android.material.datepicker.a$c
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
    }
}
