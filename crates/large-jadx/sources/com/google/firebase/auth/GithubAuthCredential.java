package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.firebase-auth-api.up;

/* loaded from: classes2.dex */
public class GithubAuthCredential extends com.google.firebase.auth.AuthCredential {

    public static final Parcelable.Creator<com.google.firebase.auth.GithubAuthCredential> CREATOR;
    private String zza;
    static {
        zzz zzz = new zzz();
        GithubAuthCredential.CREATOR = zzz;
    }

    GithubAuthCredential(String string) {
        super();
        r.f(string);
        this.zza = string;
    }

    public static up zzb(com.google.firebase.auth.GithubAuthCredential githubAuthCredential, String string2) {
        r.j(githubAuthCredential);
        super(0, githubAuthCredential.zza, githubAuthCredential.getProvider(), 0, 0, 0, string2, 0, 0);
        return upVar2;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "github.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "github.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final void writeToParcel(Parcel parcel, int i2) {
        b.o(parcel, 1, this.zza, false);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final com.google.firebase.auth.AuthCredential zza() {
        GithubAuthCredential githubAuthCredential = new GithubAuthCredential(this.zza);
        return githubAuthCredential;
    }
}
