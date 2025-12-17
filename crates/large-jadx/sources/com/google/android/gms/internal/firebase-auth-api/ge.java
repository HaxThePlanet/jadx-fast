package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class ge extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ge> CREATOR;
    private final String a;
    private final com.google.android.gms.internal.firebase-auth-api.up b;
    static {
        he heVar = new he();
        ge.CREATOR = heVar;
    }

    public ge(String string, com.google.android.gms.internal.firebase-auth-api.up up2) {
        super();
        this.a = string;
        this.b = up2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.up j2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i5 = 0;
        b.o(parcel, 1, this.a, i5);
        b.n(parcel, 2, this.b, i2, i5);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzb() {
        return this.a;
    }
}
