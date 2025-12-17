package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class PhoneAuthCredential extends com.google.firebase.auth.AuthCredential implements java.lang.Cloneable {

    public static final Parcelable.Creator<com.google.firebase.auth.PhoneAuthCredential> CREATOR;
    private String zza;
    private String zzb;
    private boolean zzc;
    private String zzd;
    private boolean zze;
    private String zzf;
    private String zzg;
    static {
        zzac zzac = new zzac();
        PhoneAuthCredential.CREATOR = zzac;
    }

    PhoneAuthCredential(String string, String string2, boolean z3, String string4, boolean z5, String string6, String string7) {
        int i;
        boolean empty;
        super();
        i = 0;
        if (z3 && !TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string7)) {
            if (!TextUtils.isEmpty(string4)) {
                if (!TextUtils.isEmpty(string7)) {
                    if (z3) {
                        i = i2;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        r.b(i, "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, temporary proof, or enrollment ID.");
        this.zza = string;
        this.zzb = string2;
        this.zzc = z3;
        this.zzd = string4;
        this.zze = z5;
        this.zzf = string6;
        this.zzg = string7;
    }

    public static com.google.firebase.auth.PhoneAuthCredential zzc(String string, String string2) {
        super(string, string2, 0, 0, 1, 0, 0);
        return phoneAuthCredential2;
    }

    public static com.google.firebase.auth.PhoneAuthCredential zzd(String string, String string2) {
        super(0, 0, 0, string, 1, string2, 0);
        return phoneAuthCredential2;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final Object clone() {
        return zzb();
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "phone";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "phone";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSmsCode() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i9 = 0;
        b.o(parcel, 1, this.zza, i9);
        b.o(parcel, 2, getSmsCode(), i9);
        b.c(parcel, 3, this.zzc);
        b.o(parcel, 4, this.zzd, i9);
        b.c(parcel, 5, this.zze);
        b.o(parcel, 6, this.zzf, i9);
        b.o(parcel, 7, this.zzg, i9);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final com.google.firebase.auth.AuthCredential zza() {
        return zzb();
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final com.google.firebase.auth.PhoneAuthCredential zzb() {
        super(this.zza, getSmsCode(), this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        return phoneAuthCredential2;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final com.google.firebase.auth.PhoneAuthCredential zze(boolean z) {
        this.zze = false;
        return this;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String zzf() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String zzg() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String zzh() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final boolean zzi() {
        return this.zze;
    }
}
