package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class rd extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.rd> CREATOR;
    private final String a;
    private final String b;
    private final String c;
    static {
        sd sdVar = new sd();
        rd.CREATOR = sdVar;
    }

    public rd(String string, String string2, String string3) {
        super();
        this.a = string;
        this.b = string2;
        this.c = string3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i5 = 0;
        b.o(parcel, 1, this.a, i5);
        b.o(parcel, 2, this.b, i5);
        b.o(parcel, 3, this.c, i5);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zza() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzb() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.c;
    }
}
