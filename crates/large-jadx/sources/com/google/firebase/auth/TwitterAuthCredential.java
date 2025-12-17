package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.firebase-auth-api.up;

/* loaded from: classes2.dex */
public class TwitterAuthCredential extends com.google.firebase.auth.AuthCredential {

    public static final Parcelable.Creator<com.google.firebase.auth.TwitterAuthCredential> CREATOR;
    private String zza;
    private String zzb;
    static {
        zzag zzag = new zzag();
        TwitterAuthCredential.CREATOR = zzag;
    }

    TwitterAuthCredential(String string, String string2) {
        super();
        r.f(string);
        this.zza = string;
        r.f(string2);
        this.zzb = string2;
    }

    public static up zzb(com.google.firebase.auth.TwitterAuthCredential twitterAuthCredential, String string2) {
        r.j(twitterAuthCredential);
        super(0, twitterAuthCredential.zza, twitterAuthCredential.getProvider(), 0, twitterAuthCredential.zzb, 0, string2, 0, 0);
        return upVar2;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "twitter.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "twitter.com";
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
        TwitterAuthCredential twitterAuthCredential = new TwitterAuthCredential(this.zza, this.zzb);
        return twitterAuthCredential;
    }
}
