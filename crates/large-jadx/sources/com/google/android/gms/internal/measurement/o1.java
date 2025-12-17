package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class o1 extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.measurement.o1> CREATOR;
    public final long a;
    public final long b;
    public final boolean c;
    public final String v;
    public final String w;
    public final String x;
    public final Bundle y;
    public final String z;
    static {
        p1 p1Var = new p1();
        o1.CREATOR = p1Var;
    }

    public o1(long l, long l2, boolean z3, String string4, String string5, String string6, Bundle bundle7, String string8) {
        super();
        this.a = l;
        this.b = z3;
        this.c = string5;
        this.v = string6;
        this.w = bundle7;
        this.x = string8;
        this.y = obj9;
        this.z = obj10;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.l(parcel, 1, this.a);
        b.l(parcel, 2, this.b);
        b.c(parcel, 3, this.c);
        int i10 = 0;
        b.o(parcel, 4, this.v, i10);
        b.o(parcel, 5, this.w, i10);
        b.o(parcel, 6, this.x, i10);
        b.e(parcel, 7, this.y, i10);
        b.o(parcel, 8, this.z, i10);
        b.b(parcel, b.a(parcel));
    }
}
