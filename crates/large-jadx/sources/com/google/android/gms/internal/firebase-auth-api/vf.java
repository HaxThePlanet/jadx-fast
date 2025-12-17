package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.zze;

/* loaded from: classes2.dex */
public final class vf extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.vf> CREATOR;
    private final Status a;
    private final zze b;
    private final String c;
    private final String v;
    static {
        wf wfVar = new wf();
        vf.CREATOR = wfVar;
    }

    public vf(Status status, zze zze2, String string3, String string4) {
        super();
        this.a = status;
        this.b = zze2;
        this.c = string3;
        this.v = string4;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Status j2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final zze k2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i7 = 0;
        b.n(parcel, 1, this.a, i2, i7);
        b.n(parcel, 2, this.b, i2, i7);
        b.o(parcel, 3, this.c, i7);
        b.o(parcel, 4, this.v, i7);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzd() {
        return this.v;
    }
}
