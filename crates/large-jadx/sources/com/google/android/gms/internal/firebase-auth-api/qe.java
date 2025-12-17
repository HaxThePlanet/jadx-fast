package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class qe extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.qe> CREATOR;
    private final com.google.android.gms.internal.firebase-auth-api.hp a;
    static {
        re reVar = new re();
        qe.CREATOR = reVar;
    }

    public qe(com.google.android.gms.internal.firebase-auth-api.hp hp) {
        super();
        this.a = hp;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.hp j2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.n(parcel, 1, this.a, i2, false);
        b.b(parcel, b.a(parcel));
    }
}
