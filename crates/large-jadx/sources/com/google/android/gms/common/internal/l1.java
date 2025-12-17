package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class l1 extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.internal.l1> CREATOR;
    Bundle a;
    d[] b;
    int c;
    com.google.android.gms.common.internal.e v;
    static {
        m1 m1Var = new m1();
        l1.CREATOR = m1Var;
    }

    l1(Bundle bundle, d[] d2Arr2, int i3, com.google.android.gms.common.internal.e e4) {
        super();
        this.a = bundle;
        this.b = d2Arr2;
        this.c = i3;
        this.v = e4;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i8 = 0;
        b.e(parcel, 1, this.a, i8);
        b.r(parcel, 2, this.b, i2, i8);
        b.j(parcel, 3, this.c);
        b.n(parcel, 4, this.v, i2, i8);
        b.b(parcel, b.a(parcel));
    }
}
