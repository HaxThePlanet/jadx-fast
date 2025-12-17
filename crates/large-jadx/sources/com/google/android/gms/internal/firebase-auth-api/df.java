package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.EmailAuthCredential;

/* loaded from: classes2.dex */
public final class df extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.df> CREATOR;
    private final EmailAuthCredential a;
    static {
        ef efVar = new ef();
        df.CREATOR = efVar;
    }

    public df(EmailAuthCredential emailAuthCredential) {
        super();
        this.a = emailAuthCredential;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final EmailAuthCredential j2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.n(parcel, 1, this.a, i2, false);
        b.b(parcel, b.a(parcel));
    }
}
