package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
public final class tf extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.tf> CREATOR;
    private final String a;
    private final String b;
    private final ActionCodeSettings c;
    static {
        uf ufVar = new uf();
        tf.CREATOR = ufVar;
    }

    public tf(String string, String string2, ActionCodeSettings actionCodeSettings3) {
        super();
        this.a = string;
        this.b = string2;
        this.c = actionCodeSettings3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final ActionCodeSettings j2() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i6 = 0;
        b.o(parcel, 1, this.a, i6);
        b.o(parcel, 2, this.b, i6);
        b.n(parcel, 3, this.c, i2, i6);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzb() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.b;
    }
}
