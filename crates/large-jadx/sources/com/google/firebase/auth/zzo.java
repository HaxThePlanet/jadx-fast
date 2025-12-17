package com.google.firebase.auth;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.firebase.auth.internal.zze;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class zzo implements e<zze> {

    final String zza;
    final long zzb;
    final TimeUnit zzc;
    final com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd;
    final Activity zze;
    final Executor zzf;
    final boolean zzg;
    final com.google.firebase.auth.FirebaseAuth zzh;
    zzo(com.google.firebase.auth.FirebaseAuth firebaseAuth, String string2, long l3, TimeUnit timeUnit4, com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthProvider$OnVerificationStateChangedCallbacks5, Activity activity6, Executor executor7, boolean z8) {
        this.zzh = firebaseAuth;
        this.zza = string2;
        this.zzb = l3;
        this.zzc = onVerificationStateChangedCallbacks5;
        this.zzd = activity6;
        this.zze = executor7;
        this.zzf = z8;
        this.zzg = obj9;
        super();
    }

    public final void onComplete(j<zze> j) {
        Object result;
        int i;
        int length;
        int i2;
        int i3;
        String obj14;
        if (!j.isSuccessful()) {
            if (j.getException() != null) {
                obj14 = j.getException().getMessage();
            } else {
                obj14 = "";
            }
            obj14 = String.valueOf(obj14);
            String str = "Error while validating application identity: ";
            if (obj14.length() != 0) {
                obj14 = str.concat(obj14);
            } else {
                obj14 = new String(str);
            }
            result = "FirebaseAuth";
            Log.e(result, obj14);
            Log.e(result, "Proceeding without any application identifier.");
            i3 = i2;
        } else {
            i2 = obj14;
            i3 = i;
        }
        this.zzh.zzI(this.zza, this.zzb, obj5, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, i2);
    }
}
