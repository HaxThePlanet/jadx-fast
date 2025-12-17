package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.firebase-auth-api.up;

/* loaded from: classes2.dex */
public class GoogleAuthCredential extends com.google.firebase.auth.AuthCredential {

    public static final Parcelable.Creator<com.google.firebase.auth.GoogleAuthCredential> CREATOR;
    private final String zza;
    private final String zzb;
    static {
        zzaa zzaa = new zzaa();
        GoogleAuthCredential.CREATOR = zzaa;
    }

    GoogleAuthCredential(String string, String string2) {
        int length;
        super();
        if (string == null) {
            if (string2 == null) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Must specify an idToken or an accessToken.");
            throw obj2;
        }
        if (string != null) {
            if (string.length() == 0) {
            } else {
            }
            obj2 = new IllegalArgumentException("idToken cannot be empty");
            throw obj2;
        }
        if (string2 != null) {
            if (string2.length() == 0) {
            } else {
            }
            obj2 = new IllegalArgumentException("accessToken cannot be empty");
            throw obj2;
        }
        this.zza = string;
        this.zzb = string2;
    }

    public static up zzb(com.google.firebase.auth.GoogleAuthCredential googleAuthCredential, String string2) {
        r.j(googleAuthCredential);
        super(googleAuthCredential.zza, googleAuthCredential.zzb, googleAuthCredential.getProvider(), 0, 0, 0, string2, 0, 0);
        return upVar2;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i4 = 0;
        b.o(parcel, 1, this.zza, i4);
        b.o(parcel, 2, this.zzb, i4);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final com.google.firebase.auth.AuthCredential zza() {
        GoogleAuthCredential googleAuthCredential = new GoogleAuthCredential(this.zza, this.zzb);
        return googleAuthCredential;
    }
}
