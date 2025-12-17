package com.google.android.gms.internal.firebase-auth-api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class zo extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.zo> CREATOR;
    private String a;
    private String b;
    private String c;
    private String v;
    private String w;
    private String x;
    private String y;
    static {
        ap apVar = new ap();
        zo.CREATOR = apVar;
    }

    zo(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        super();
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.v = string4;
        this.w = string5;
        this.x = string6;
        this.y = string7;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Uri j2() {
        if (!TextUtils.isEmpty(this.c)) {
            return Uri.parse(this.c);
        }
        return null;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void k2(String string) {
        this.w = string;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i9 = 0;
        b.o(parcel, 2, this.a, i9);
        b.o(parcel, 3, this.b, i9);
        b.o(parcel, 4, this.c, i9);
        b.o(parcel, 5, this.v, i9);
        b.o(parcel, 6, this.w, i9);
        b.o(parcel, 7, this.x, i9);
        b.o(parcel, 8, this.y, i9);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzb() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.y;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzd() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zze() {
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzf() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzg() {
        return this.w;
    }
}
