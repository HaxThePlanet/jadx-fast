package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
@Deprecated
public final class d1 extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.internal.d1> CREATOR;
    final int a;
    static {
        e1 e1Var = new e1();
        d1.CREATOR = e1Var;
    }

    d1(int i) {
        super();
        this.a = i;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        b.b(parcel, b.a(parcel));
    }
}
