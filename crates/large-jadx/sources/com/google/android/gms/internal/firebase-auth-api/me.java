package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.ActionCodeSettings;

/* loaded from: classes2.dex */
public final class me extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.me> CREATOR;
    private final String a;
    private final ActionCodeSettings b;
    static {
        ne neVar = new ne();
        me.CREATOR = neVar;
    }

    public me(String string, ActionCodeSettings actionCodeSettings2) {
        super();
        this.a = string;
        this.b = actionCodeSettings2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final ActionCodeSettings j2() {
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
