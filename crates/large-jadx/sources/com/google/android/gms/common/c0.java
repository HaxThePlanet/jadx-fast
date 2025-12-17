package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.dynamic.a.a;
import com.google.android.gms.dynamic.b;

/* loaded from: classes2.dex */
public final class c0 extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.c0> CREATOR;
    private final String a;
    private final boolean b;
    private final boolean c;
    private final Context v;
    private final boolean w;
    static {
        d0 d0Var = new d0();
        c0.CREATOR = d0Var;
    }

    c0(String string, boolean z2, boolean z3, IBinder iBinder4, boolean z5) {
        super();
        this.a = string;
        this.b = z2;
        this.c = z3;
        this.v = (Context)b.n(a.a.m(iBinder4));
        this.w = z5;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i7 = 0;
        b.o(parcel, 1, this.a, i7);
        b.c(parcel, 2, this.b);
        b.c(parcel, 3, this.c);
        b.i(parcel, 4, b.p2(this.v), i7);
        b.c(parcel, 5, this.w);
        b.b(parcel, b.a(parcel));
    }
}
