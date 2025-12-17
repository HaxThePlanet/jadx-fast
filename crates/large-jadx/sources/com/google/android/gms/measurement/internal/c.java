package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class c extends a {

    public static final Parcelable.Creator<com.google.android.gms.measurement.internal.c> CREATOR;
    public com.google.android.gms.measurement.internal.u A;
    public final long B;
    public final com.google.android.gms.measurement.internal.u C;
    public String a;
    public String b;
    public com.google.android.gms.measurement.internal.ea c;
    public long v;
    public boolean w;
    public String x;
    public final com.google.android.gms.measurement.internal.u y;
    public long z;
    static {
        d dVar = new d();
        c.CREATOR = dVar;
    }

    c(com.google.android.gms.measurement.internal.c c) {
        super();
        r.j(c);
        this.a = c.a;
        this.b = c.b;
        this.c = c.c;
        this.v = c.v;
        this.w = c.w;
        this.x = c.x;
        this.y = c.y;
        this.z = c.z;
        this.A = c.A;
        this.B = c.B;
        this.C = c.C;
    }

    c(String string, String string2, com.google.android.gms.measurement.internal.ea ea3, long l4, boolean z5, String string6, com.google.android.gms.measurement.internal.u u7, long l8, com.google.android.gms.measurement.internal.u u9, long l10, com.google.android.gms.measurement.internal.u u11) {
        super();
        this.a = string;
        this.b = string2;
        this.c = ea3;
        this.v = l4;
        this.w = string6;
        this.x = u7;
        this.y = l8;
        this.z = u9;
        this.A = u11;
        this.B = obj12;
        this.C = obj14;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i11 = 0;
        b.o(parcel, 2, this.a, i11);
        b.o(parcel, 3, this.b, i11);
        int i5 = 4;
        b.n(parcel, i5, this.c, i2, i11);
        b.l(parcel, 5, this.v);
        b.c(parcel, 6, this.w);
        b.o(parcel, 7, this.x, i11);
        int i8 = 8;
        b.n(parcel, i8, this.y, i2, i11);
        b.l(parcel, 9, this.z);
        int i9 = 10;
        b.n(parcel, i9, this.A, i2, i11);
        b.l(parcel, 11, this.B);
        b.n(parcel, 12, this.C, i2, i11);
        b.b(parcel, b.a(parcel));
    }
}
