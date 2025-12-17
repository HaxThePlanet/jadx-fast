package com.google.firebase.auth.internal;

import com.google.firebase.auth.FirebaseAuthSettings;

/* loaded from: classes2.dex */
public final class zzw extends FirebaseAuthSettings {

    private String zza;
    private String zzb;
    private boolean zzc = false;
    private boolean zzd = false;
    public zzw() {
        super();
        final int i = 0;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void forceRecaptchaFlowForTesting(boolean z) {
        this.zzd = z;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void setAppVerificationDisabledForTesting(boolean z) {
        this.zzc = z;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void setAutoRetrievedSmsCodeForPhoneNumber(String string, String string2) {
        this.zza = string;
        this.zzb = string2;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final boolean zzc() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final boolean zzd() {
        String zza;
        if (this.zza != null && this.zzb != null) {
            if (this.zzb != null) {
                return 1;
            }
        }
        return 0;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final boolean zze() {
        return this.zzc;
    }
}
