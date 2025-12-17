package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.firebase-auth-api.up;

/* loaded from: classes2.dex */
public class FacebookAuthCredential extends com.google.firebase.auth.AuthCredential {

    public static final Parcelable.Creator<com.google.firebase.auth.FacebookAuthCredential> CREATOR;
    private final String zza;
    static {
        zzh zzh = new zzh();
        FacebookAuthCredential.CREATOR = zzh;
    }

    FacebookAuthCredential(String string) {
        super();
        r.f(string);
        this.zza = string;
    }

    public static up zzb(com.google.firebase.auth.FacebookAuthCredential facebookAuthCredential, String string2) {
        r.j(facebookAuthCredential);
        super(0, facebookAuthCredential.zza, facebookAuthCredential.getProvider(), 0, 0, 0, string2, 0, 0);
        return upVar2;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "facebook.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "facebook.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final void writeToParcel(Parcel parcel, int i2) {
        b.o(parcel, 1, this.zza, false);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final com.google.firebase.auth.AuthCredential zza() {
        FacebookAuthCredential facebookAuthCredential = new FacebookAuthCredential(this.zza);
        return facebookAuthCredential;
    }
}
