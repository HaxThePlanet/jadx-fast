package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class EmailAuthCredential extends com.google.firebase.auth.AuthCredential {

    public static final Parcelable.Creator<com.google.firebase.auth.EmailAuthCredential> CREATOR;
    private String zza;
    private String zzb;
    private final String zzc;
    private String zzd;
    private boolean zze;
    static {
        zzg zzg = new zzg();
        EmailAuthCredential.CREATOR = zzg;
    }

    EmailAuthCredential(String string, String string2, String string3, String string4, boolean z5) {
        boolean obj1;
        super();
        r.f(string);
        this.zza = string;
        if (TextUtils.isEmpty(string2)) {
            if (TextUtils.isEmpty(string3)) {
            } else {
            }
            obj1 = new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
            throw obj1;
        }
        this.zzb = string2;
        this.zzc = string3;
        this.zzd = string4;
        this.zze = z5;
    }

    public static boolean zzi(String string) {
        boolean empty;
        com.google.firebase.auth.ActionCodeUrl obj2;
        final int i = 0;
        if (TextUtils.isEmpty(string)) {
            return i;
        }
        obj2 = ActionCodeUrl.parseLink(string);
        if (obj2 != null && obj2.getOperation() == 4) {
            if (obj2.getOperation() == 4) {
                return 1;
            }
        }
        return i;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "password";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        if (!TextUtils.isEmpty(this.zzb)) {
            return "password";
        }
        return "emailLink";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i7 = 0;
        b.o(parcel, 1, this.zza, i7);
        b.o(parcel, 2, this.zzb, i7);
        b.o(parcel, 3, this.zzc, i7);
        b.o(parcel, 4, this.zzd, i7);
        b.c(parcel, 5, this.zze);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final com.google.firebase.auth.AuthCredential zza() {
        super(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        return emailAuthCredential2;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final com.google.firebase.auth.EmailAuthCredential zzb(com.google.firebase.auth.FirebaseUser firebaseUser) {
        this.zzd = firebaseUser.zzf();
        this.zze = true;
        return this;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String zzc() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String zzd() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final String zzf() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final boolean zzg() {
        if (!TextUtils.isEmpty(this.zzc)) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final boolean zzh() {
        return this.zze;
    }
}
