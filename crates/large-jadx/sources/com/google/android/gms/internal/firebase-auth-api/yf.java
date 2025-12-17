package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.zze;
import java.util.List;

/* loaded from: classes2.dex */
public final class yf extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.yf> CREATOR;
    final String a;
    final List<com.google.android.gms.internal.firebase-auth-api.xo> b;
    final zze c;
    static {
        zf zfVar = new zf();
        yf.CREATOR = zfVar;
    }

    public yf(String string, List<com.google.android.gms.internal.firebase-auth-api.xo> list2, zze zze3) {
        super();
        this.a = string;
        this.b = list2;
        this.c = zze3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final zze j2() {
        return this.c;
    }

    public final List<MultiFactorInfo> k2() {
        return zzba.zzb(this.b);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i6 = 0;
        b.o(parcel, 1, this.a, i6);
        b.s(parcel, 2, this.b, i6);
        b.n(parcel, 3, this.c, i2, i6);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzb() {
        return this.a;
    }
}
