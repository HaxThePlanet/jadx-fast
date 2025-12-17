package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.firebase-auth-api.t1;
import com.google.android.gms.internal.firebase-auth-api.up;

/* loaded from: classes2.dex */
public final class zze extends com.google.firebase.auth.OAuthCredential {

    public static final Parcelable.Creator<com.google.firebase.auth.zze> CREATOR;
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final up zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    static {
        zzf zzf = new zzf();
        zze.CREATOR = zzf;
    }

    zze(String string, String string2, String string3, up up4, String string5, String string6, String string7) {
        super();
        this.zza = t1.c(string);
        this.zzb = string2;
        this.zzc = string3;
        this.zzd = up4;
        this.zze = string5;
        this.zzf = string6;
        this.zzg = string7;
    }

    public static com.google.firebase.auth.zze zzb(up up) {
        r.k(up, "Must specify a non-null webSignInCredential");
        super(0, 0, 0, up, 0, 0, 0);
        return zze;
    }

    public static com.google.firebase.auth.zze zzc(String string, String string2, String string3, String string4, String string5) {
        boolean empty;
        r.g(string, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(string2)) {
            if (TextUtils.isEmpty(string3)) {
            } else {
            }
            IllegalArgumentException obj9 = new IllegalArgumentException("Must specify an idToken or an accessToken.");
            throw obj9;
        }
        super(string, string2, string3, 0, string4, string5, 0);
        return zze2;
    }

    public static up zzd(com.google.firebase.auth.zze zze, String string2) {
        r.j(zze);
        up zzd = zze.zzd;
        if (zzd != null) {
            return zzd;
        }
        super(zze.zzb, zze.zzc, zze.zza, 0, zze.zzf, 0, string2, zze.zze, zze.zzg);
        return upVar;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String getAccessToken() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String getIdToken() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String getProvider() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String getSecret() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final String getSignInMethod() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i10 = 0;
        b.o(parcel, 1, this.zza, i10);
        b.o(parcel, 2, this.zzb, i10);
        b.o(parcel, 3, this.zzc, i10);
        b.n(parcel, 4, this.zzd, i2, i10);
        b.o(parcel, 5, this.zze, i10);
        b.o(parcel, 6, this.zzf, i10);
        b.o(parcel, 7, this.zzg, i10);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public final com.google.firebase.auth.AuthCredential zza() {
        super(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        return zze3;
    }
}
