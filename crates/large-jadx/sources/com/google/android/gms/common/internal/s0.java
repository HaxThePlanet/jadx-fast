package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class s0 extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.internal.s0> CREATOR;
    final int a;
    final IBinder b;
    private final b c;
    private final boolean v;
    private final boolean w;
    static {
        t0 t0Var = new t0();
        s0.CREATOR = t0Var;
    }

    s0(int i, IBinder iBinder2, b b3, boolean z4, boolean z5) {
        super();
        this.a = i;
        this.b = iBinder2;
        this.c = b3;
        this.v = z4;
        this.w = z5;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean equals(Object object) {
        boolean equals;
        Object obj5;
        final int i = 0;
        if (object == null) {
            return i;
        }
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        if (!object instanceof s0) {
            return i;
        }
        if (this.c.equals(object.c) && p.a(j2(), (s0)object.j2())) {
            if (p.a(j2(), object.j2())) {
                return i2;
            }
        }
        return i;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.common.internal.k j2() {
        IBinder iBinder = this.b;
        if (iBinder == null) {
            return null;
        }
        return k.a.m(iBinder);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final b k2() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        final int i9 = 0;
        b.i(parcel, 2, this.b, i9);
        b.n(parcel, 3, this.c, i2, i9);
        b.c(parcel, 4, this.v);
        b.c(parcel, 5, this.w);
        b.b(parcel, b.a(parcel));
    }
}
