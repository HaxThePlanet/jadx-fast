package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class f0 extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.f0> CREATOR;
    private final boolean a;
    private final String b;
    private final int c;
    static {
        g0 g0Var = new g0();
        f0.CREATOR = g0Var;
    }

    f0(boolean z, String string2, int i3) {
        super();
        this.a = z;
        this.b = string2;
        this.c = obj1--;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean j2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final int k2() {
        return e0.a(this.c);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.c(parcel, 1, this.a);
        b.o(parcel, 2, this.b, false);
        b.j(parcel, 3, this.c);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzb() {
        return this.b;
    }
}
