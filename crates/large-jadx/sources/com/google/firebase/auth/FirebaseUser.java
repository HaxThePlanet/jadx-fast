package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.firebase-auth-api.to;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class FirebaseUser extends a implements com.google.firebase.auth.UserInfo {
    public j<Void> delete() {
        return FirebaseAuth.getInstance(zza()).zza(this);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getDisplayName();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getEmail();

    public j<com.google.firebase.auth.GetTokenResult> getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zza()).zzc(this, z);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract com.google.firebase.auth.FirebaseUserMetadata getMetadata();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract com.google.firebase.auth.MultiFactor getMultiFactor();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getPhoneNumber();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract Uri getPhotoUrl();

    public abstract List<? extends com.google.firebase.auth.UserInfo> getProviderData();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getProviderId();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getTenantId();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getUid();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract boolean isAnonymous();

    public j<com.google.firebase.auth.AuthResult> linkWithCredential(com.google.firebase.auth.AuthCredential authCredential) {
        r.j(authCredential);
        return FirebaseAuth.getInstance(zza()).zzd(this, authCredential);
    }

    public j<Void> reauthenticate(com.google.firebase.auth.AuthCredential authCredential) {
        r.j(authCredential);
        return FirebaseAuth.getInstance(zza()).zze(this, authCredential);
    }

    public j<com.google.firebase.auth.AuthResult> reauthenticateAndRetrieveData(com.google.firebase.auth.AuthCredential authCredential) {
        r.j(authCredential);
        return FirebaseAuth.getInstance(zza()).zzf(this, authCredential);
    }

    public j<Void> reload() {
        com.google.firebase.auth.FirebaseAuth instance = FirebaseAuth.getInstance(zza());
        zzt zzt = new zzt(instance);
        return instance.zzg(this, zzt);
    }

    public j<Void> sendEmailVerification() {
        zzw zzw = new zzw(this);
        return FirebaseAuth.getInstance(zza()).zzc(this, false).continueWithTask(zzw);
    }

    public j<Void> sendEmailVerification(com.google.firebase.auth.ActionCodeSettings actionCodeSettings) {
        zzx zzx = new zzx(this, actionCodeSettings);
        return FirebaseAuth.getInstance(zza()).zzc(this, false).continueWithTask(zzx);
    }

    public j<com.google.firebase.auth.AuthResult> startActivityForLinkWithProvider(Activity activity, com.google.firebase.auth.FederatedAuthProvider federatedAuthProvider2) {
        r.j(activity);
        r.j(federatedAuthProvider2);
        return FirebaseAuth.getInstance(zza()).zzj(activity, federatedAuthProvider2, this);
    }

    public j<com.google.firebase.auth.AuthResult> startActivityForReauthenticateWithProvider(Activity activity, com.google.firebase.auth.FederatedAuthProvider federatedAuthProvider2) {
        r.j(activity);
        r.j(federatedAuthProvider2);
        return FirebaseAuth.getInstance(zza()).zzk(activity, federatedAuthProvider2, this);
    }

    public j<com.google.firebase.auth.AuthResult> unlink(String string) {
        r.f(string);
        return FirebaseAuth.getInstance(zza()).zzm(this, string);
    }

    public j<Void> updateEmail(String string) {
        r.f(string);
        return FirebaseAuth.getInstance(zza()).zzn(this, string);
    }

    public j<Void> updatePassword(String string) {
        r.f(string);
        return FirebaseAuth.getInstance(zza()).zzo(this, string);
    }

    public j<Void> updatePhoneNumber(com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zza()).zzp(this, phoneAuthCredential);
    }

    public j<Void> updateProfile(com.google.firebase.auth.UserProfileChangeRequest userProfileChangeRequest) {
        r.j(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zza()).zzq(this, userProfileChangeRequest);
    }

    public j<Void> verifyBeforeUpdateEmail(String string) {
        return verifyBeforeUpdateEmail(string, 0);
    }

    public j<Void> verifyBeforeUpdateEmail(String string, com.google.firebase.auth.ActionCodeSettings actionCodeSettings2) {
        zzy zzy = new zzy(this, string, actionCodeSettings2);
        return FirebaseAuth.getInstance(zza()).zzc(this, false).continueWithTask(zzy);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract FirebaseApp zza();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract com.google.firebase.auth.FirebaseUser zzb();

    public abstract com.google.firebase.auth.FirebaseUser zzc(List<? extends com.google.firebase.auth.UserInfo> list);

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract to zzd();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String zze();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String zzf();

    public abstract List<String> zzg();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract void zzh(to to);

    public abstract void zzi(List<com.google.firebase.auth.MultiFactorInfo> list);
}
