package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class nf extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.nf> CREATOR;
    private final String a;
    static {
        of ofVar = new of();
        nf.CREATOR = ofVar;
    }

    public nf(String string) {
        super();
        this.a = string;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.o(parcel, 1, this.a, false);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zza() {
        return this.a;
    }
}
