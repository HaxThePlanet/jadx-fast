package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class ce extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ce> CREATOR;
    private final String a;
    private final String b;
    static {
        de deVar = new de();
        ce.CREATOR = deVar;
    }

    public ce(String string, String string2) {
        super();
        this.a = string;
        this.b = string2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i4 = 0;
        b.o(parcel, 1, this.a, i4);
        b.o(parcel, 2, this.b, i4);
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
}
