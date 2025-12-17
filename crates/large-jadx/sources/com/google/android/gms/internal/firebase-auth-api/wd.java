package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class wd extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.wd> CREATOR;
    private final PhoneAuthCredential a;
    private final String b;
    private final String c;
    static {
        xd xdVar = new xd();
        wd.CREATOR = xdVar;
    }

    public wd(PhoneAuthCredential phoneAuthCredential, String string2, String string3) {
        super();
        this.a = phoneAuthCredential;
        this.b = string2;
        this.c = string3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final PhoneAuthCredential j2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i6 = 0;
        b.n(parcel, 1, this.a, i2, i6);
        b.o(parcel, 2, this.b, i6);
        b.o(parcel, 3, this.c, i6);
        b.b(parcel, b.a(parcel));
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
