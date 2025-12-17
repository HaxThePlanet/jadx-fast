package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class a extends a {

    public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.internal.a> CREATOR;
    final int a;
    private int b;
    private Bundle c;
    static {
        d dVar = new d();
        a.CREATOR = dVar;
    }

    a(int i, int i2, Bundle bundle3) {
        super();
        this.a = i;
        this.b = i2;
        this.c = bundle3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int j2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        b.j(parcel, 2, j2());
        b.e(parcel, 3, this.c, false);
        b.b(parcel, b.a(parcel));
    }
}
