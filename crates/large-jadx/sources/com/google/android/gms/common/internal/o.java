package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class o extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.internal.o> CREATOR;
    private final int a;
    private final int b;
    private final int c;
    private final long v;
    private final long w;
    private final String x;
    private final String y;
    private final int z;
    static {
        k0 k0Var = new k0();
        o.CREATOR = k0Var;
    }

    public o(int i, int i2, int i3, long l4, long l5, String string6, String string7, int i8) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.v = l4;
        this.w = string6;
        this.x = i8;
        this.y = obj9;
        this.z = obj10;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        b.j(parcel, 2, this.b);
        int i8 = 3;
        b.j(parcel, i8, this.c);
        b.l(parcel, 4, this.v);
        b.l(parcel, 5, this.w);
        int i14 = 0;
        b.o(parcel, 6, this.x, i14);
        b.o(parcel, 7, this.y, i14);
        b.j(parcel, 8, this.z);
        b.b(parcel, b.a(parcel));
    }
}
