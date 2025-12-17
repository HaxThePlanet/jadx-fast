package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public final class ie extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.ie> CREATOR;
    private final String a;
    private final PhoneAuthCredential b;
    static {
        je jeVar = new je();
        ie.CREATOR = jeVar;
    }

    public ie(String string, PhoneAuthCredential phoneAuthCredential2) {
        super();
        this.a = string;
        this.b = phoneAuthCredential2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final PhoneAuthCredential j2() {
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
