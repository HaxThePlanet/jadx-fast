package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.firebase-auth-api.mo;
import com.google.android.gms.internal.firebase-auth-api.zo;
import com.google.android.gms.internal.firebase-auth-api.zzll;
import com.google.firebase.auth.UserInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzt extends a implements UserInfo {

    public static final Parcelable.Creator<com.google.firebase.auth.internal.zzt> CREATOR;
    private final String zza;
    private final String zzb;
    private final String zzc;
    private String zzd;
    private Uri zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private final String zzi;
    static {
        zzu zzu = new zzu();
        zzt.CREATOR = zzu;
    }

    public zzt(mo mo, String string2) {
        String string;
        super();
        r.j(mo);
        String obj3 = "firebase";
        r.f(obj3);
        string = mo.x2();
        r.f(string);
        this.zza = string;
        this.zzb = obj3;
        this.zzf = mo.w2();
        this.zzc = mo.v2();
        obj3 = mo.l2();
        if (obj3 != null) {
            this.zzd = obj3.toString();
            this.zze = obj3;
        }
        this.zzh = mo.zzs();
        this.zzi = 0;
        this.zzg = mo.y2();
    }

    public zzt(zo zo) {
        String string;
        super();
        r.j(zo);
        this.zza = zo.zzd();
        String str2 = zo.zzf();
        r.f(str2);
        this.zzb = str2;
        this.zzc = zo.zzb();
        Uri uri = zo.j2();
        if (uri != null) {
            this.zzd = uri.toString();
            this.zze = uri;
        }
        this.zzf = zo.zzc();
        this.zzg = zo.zze();
        this.zzh = false;
        this.zzi = zo.zzg();
    }

    public zzt(String string, String string2, String string3, String string4, String string5, String string6, boolean z7, String string8) {
        boolean obj1;
        super();
        this.zza = string;
        this.zzb = string2;
        this.zzf = string3;
        this.zzg = string4;
        this.zzc = string5;
        this.zzd = string6;
        if (!TextUtils.isEmpty(string6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z7;
        this.zzi = string8;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String getDisplayName() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String getEmail() {
        return this.zzf;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Uri getPhotoUrl() {
        boolean empty;
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            if (this.zze == null) {
                this.zze = Uri.parse(this.zzd);
            }
        }
        return this.zze;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String getProviderId() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String getUid() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean isEmailVerified() {
        return this.zzh;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i10 = 0;
        b.o(parcel, 1, this.zza, i10);
        b.o(parcel, 2, this.zzb, i10);
        b.o(parcel, 3, this.zzc, i10);
        b.o(parcel, 4, this.zzd, i10);
        b.o(parcel, 5, this.zzf, i10);
        b.o(parcel, 6, this.zzg, i10);
        b.c(parcel, 7, this.zzh);
        b.o(parcel, 8, this.zzi, i10);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zza() {
        return this.zzi;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("userId", this.zza);
        jSONObject.putOpt("providerId", this.zzb);
        jSONObject.putOpt("displayName", this.zzc);
        jSONObject.putOpt("photoUrl", this.zzd);
        jSONObject.putOpt("email", this.zzf);
        jSONObject.putOpt("phoneNumber", this.zzg);
        jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
        jSONObject.putOpt("rawUserInfo", this.zzi);
        return jSONObject.toString();
    }
}
