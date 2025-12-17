package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class t extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.internal.t> CREATOR;
    private final int a;
    private final boolean b;
    private final boolean c;
    private final int v;
    private final int w;
    static {
        c1 c1Var = new c1();
        t.CREATOR = c1Var;
    }

    public t(int i, boolean z2, boolean z3, int i4, int i5) {
        super();
        this.a = i;
        this.b = z2;
        this.c = z3;
        this.v = i4;
        this.w = i5;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int j2() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int k2() {
        return this.w;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean l2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean m2() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int n2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, n2());
        b.c(parcel, 2, l2());
        b.c(parcel, 3, m2());
        b.j(parcel, 4, j2());
        b.j(parcel, 5, k2());
        b.b(parcel, b.a(parcel));
    }
}
