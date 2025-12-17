package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.firebase-auth-api.up;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.GithubAuthCredential;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.PlayGamesAuthCredential;
import com.google.firebase.auth.TwitterAuthCredential;
import com.google.firebase.auth.zze;

/* loaded from: classes2.dex */
public final class zzh {
    public static up zza(AuthCredential authCredential, String string2) {
        r.j(authCredential);
        if (GoogleAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return GoogleAuthCredential.zzb((GoogleAuthCredential)authCredential, string2);
        }
        if (FacebookAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return FacebookAuthCredential.zzb((FacebookAuthCredential)authCredential, string2);
        }
        if (TwitterAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return TwitterAuthCredential.zzb((TwitterAuthCredential)authCredential, string2);
        }
        if (GithubAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return GithubAuthCredential.zzb((GithubAuthCredential)authCredential, string2);
        }
        if (PlayGamesAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return PlayGamesAuthCredential.zzb((PlayGamesAuthCredential)authCredential, string2);
        }
        if (!zze.class.isAssignableFrom(authCredential.getClass())) {
        } else {
            return zze.zzd((zze)authCredential, string2);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Unsupported credential type.");
        throw obj2;
    }
}
