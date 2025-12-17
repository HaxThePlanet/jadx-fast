package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.UserProfileChangeRequest;

/* loaded from: classes2.dex */
public final class rf extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.rf> CREATOR;
    private final UserProfileChangeRequest a;
    private final String b;
    static {
        sf sfVar = new sf();
        rf.CREATOR = sfVar;
    }

    public rf(UserProfileChangeRequest userProfileChangeRequest, String string2) {
        super();
        this.a = userProfileChangeRequest;
        this.b = string2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final UserProfileChangeRequest j2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i5 = 0;
        b.n(parcel, 1, this.a, i2, i5);
        b.o(parcel, 2, this.b, i5);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzb() {
        return this.b;
    }
}
