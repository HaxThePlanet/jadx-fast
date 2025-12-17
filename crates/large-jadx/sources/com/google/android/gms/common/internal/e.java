package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class e extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.internal.e> CREATOR;
    private final com.google.android.gms.common.internal.t a;
    private final boolean b;
    private final boolean c;
    private final int[] v;
    private final int w;
    private final int[] x;
    static {
        n1 n1Var = new n1();
        e.CREATOR = n1Var;
    }

    public e(com.google.android.gms.common.internal.t t, boolean z2, boolean z3, int[] i4Arr4, int i5, int[] i6Arr6) {
        super();
        this.a = t;
        this.b = z2;
        this.c = z3;
        this.v = i4Arr4;
        this.w = i5;
        this.x = i6Arr6;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int j2() {
        return this.w;
    }

    public int[] k2() {
        return this.v;
    }

    public int[] l2() {
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean m2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean n2() {
        return this.c;
    }

    public com.google.android.gms.common.internal.t o2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i9 = 0;
        b.n(parcel, 1, o2(), i2, i9);
        b.c(parcel, 2, m2());
        b.c(parcel, 3, n2());
        b.k(parcel, 4, k2(), i9);
        b.j(parcel, 5, j2());
        b.k(parcel, 6, l2(), i9);
        b.b(parcel, b.a(parcel));
    }
}
