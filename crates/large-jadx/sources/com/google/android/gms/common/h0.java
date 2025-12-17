package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.a2;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.z1;
import com.google.android.gms.dynamic.b;

/* loaded from: classes2.dex */
public final class h0 extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.h0> CREATOR;
    private final String a;
    private final com.google.android.gms.common.x b;
    private final boolean c;
    private final boolean v;
    static {
        i0 i0Var = new i0();
        h0.CREATOR = i0Var;
    }

    h0(String string, IBinder iBinder2, boolean z3, boolean z4) {
        int obj3;
        int obj4;
        super();
        this.a = string;
        if (iBinder2 == null) {
        } else {
            obj4 = z1.m(iBinder2).b();
            if (obj4 == null) {
                obj4 = obj3;
            } else {
                obj4 = b.n(obj4);
            }
            if (obj4 != null) {
                obj3 = new y(obj4);
            } else {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            }
        }
        this.b = obj3;
        this.c = z3;
        this.v = z4;
    }

    h0(String string, com.google.android.gms.common.x x2, boolean z3, boolean z4) {
        super();
        this.a = string;
        this.b = x2;
        this.c = z3;
        this.v = z4;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        com.google.android.gms.common.x xVar;
        int str;
        final int i5 = 0;
        b.o(parcel, 1, this.a, i5);
        if (this.b == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            xVar = 0;
        }
        b.i(parcel, 2, xVar, i5);
        b.c(parcel, 3, this.c);
        b.c(parcel, 4, this.v);
        b.b(parcel, b.a(parcel));
    }
}
