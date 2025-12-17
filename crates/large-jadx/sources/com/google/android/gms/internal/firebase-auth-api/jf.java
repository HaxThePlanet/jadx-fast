package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.PhoneMultiFactorInfo;

/* loaded from: classes2.dex */
public final class jf extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.jf> CREATOR;
    private final boolean A;
    private final PhoneMultiFactorInfo a;
    private final String b;
    private final String c;
    private final long v;
    private final boolean w;
    private final boolean x;
    private final String y;
    private final String z;
    static {
        kf kfVar = new kf();
        jf.CREATOR = kfVar;
    }

    public jf(PhoneMultiFactorInfo phoneMultiFactorInfo, String string2, String string3, long l4, boolean z5, boolean z6, String string7, String string8, boolean z9) {
        super();
        this.a = phoneMultiFactorInfo;
        this.b = string2;
        this.c = string3;
        this.v = l4;
        this.w = z6;
        this.x = string7;
        this.y = string8;
        this.z = z9;
        this.A = obj10;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final long j2() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final PhoneMultiFactorInfo k2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i10 = 1;
        final int i11 = 0;
        b.n(parcel, i10, this.a, i2, i11);
        b.o(parcel, 2, this.b, i11);
        b.o(parcel, 3, this.c, i11);
        b.l(parcel, 4, this.v);
        b.c(parcel, 5, this.w);
        b.c(parcel, 6, this.x);
        b.o(parcel, 7, this.y, i11);
        b.o(parcel, 8, this.z, i11);
        b.c(parcel, 9, this.A);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzd() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zze() {
        return this.z;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzf() {
        return this.y;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zzg() {
        return this.w;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zzh() {
        return this.A;
    }
}
