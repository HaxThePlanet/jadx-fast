package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.firebase-auth-api.kl;
import com.google.android.gms.internal.firebase-auth-api.ml;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zze;

/* loaded from: classes2.dex */
final class zzp implements e<zze> {

    final com.google.firebase.auth.PhoneAuthOptions zza;
    final com.google.firebase.auth.FirebaseAuth zzb;
    zzp(com.google.firebase.auth.FirebaseAuth firebaseAuth, com.google.firebase.auth.PhoneAuthOptions phoneAuthOptions2) {
        this.zzb = firebaseAuth;
        this.zza = phoneAuthOptions2;
        super();
    }

    public final void onComplete(j<zze> j) {
        String concat;
        String str;
        String i;
        Object valueOf;
        String str2;
        int length;
        int i3;
        int i2;
        String str3;
        String str4;
        final Object obj = this;
        if (!j.isSuccessful()) {
            concat = "Error while validating application identity: ";
            if (j.getException() != null) {
                valueOf = String.valueOf(j.getException().getMessage());
                if (valueOf.length() != 0) {
                    concat = concat.concat(valueOf);
                } else {
                    valueOf = new String(concat);
                    concat = valueOf;
                }
            }
            str2 = "FirebaseAuth";
            Log.e(str2, concat);
            Log.e(str2, "Proceeding without any application identifier.");
            str4 = str3;
        } else {
            str4 = str;
            str3 = i;
        }
        final long longValue = obj.zza.zzg().longValue();
        final com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks2 = FirebaseAuth.zzt(obj.zzb, obj.zza.zzh(), obj.zza.zze());
        com.google.firebase.auth.MultiFactorSession multiFactorSession = obj.zza.zzc();
        r.j(multiFactorSession);
        com.google.firebase.auth.MultiFactorSession multiFactorSession2 = multiFactorSession;
        int i4 = 1;
        int i5 = 0;
        if ((zzag)multiFactorSession2.zze()) {
            String str6 = obj.zza.zzh();
            r.j(str6);
            i2 = obj.zza.zzd() != null ? i4 : i5;
            FirebaseAuth.zzu(obj.zzb).l(multiFactorSession2, (String)str6, FirebaseAuth.zzy(obj.zzb), longValue, obj8, i2, obj.zza.zzj(), str3, str4, ml.b(), onVerificationStateChangedCallbacks2, obj.zza.zzi());
        }
        com.google.firebase.auth.PhoneMultiFactorInfo phoneMultiFactorInfo = obj.zza.zzf();
        r.j(phoneMultiFactorInfo);
        i3 = obj.zza.zzd() != null ? i4 : i5;
        FirebaseAuth.zzu(obj.zzb).m(multiFactorSession2, (PhoneMultiFactorInfo)phoneMultiFactorInfo, FirebaseAuth.zzy(obj.zzb), longValue, obj8, i3, obj.zza.zzj(), str3, str4, ml.b(), onVerificationStateChangedCallbacks2, obj.zza.zzi());
    }
}
