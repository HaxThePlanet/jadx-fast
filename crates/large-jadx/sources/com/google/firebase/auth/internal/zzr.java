package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zze;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzr implements AuthResult {

    public static final Parcelable.Creator<com.google.firebase.auth.internal.zzr> CREATOR;
    private com.google.firebase.auth.internal.zzx zza;
    private com.google.firebase.auth.internal.zzp zzb;
    private zze zzc;
    static {
        zzs zzs = new zzs();
        zzr.CREATOR = zzs;
    }

    public zzr(com.google.firebase.auth.internal.zzx zzx) {
        com.google.firebase.auth.internal.zzp zzb;
        int i;
        boolean empty;
        String providerId;
        String str;
        boolean z;
        super();
        r.j(zzx);
        Object obj = zzx;
        this.zza = (zzx)obj;
        List list = obj.zzo();
        this.zzb = 0;
        i = 0;
        while (i < list.size()) {
            if (!TextUtils.isEmpty((zzt)list.get(i).zza())) {
            }
            i++;
            empty = new zzp((zzt)list.get(i).getProviderId(), (zzt)list.get(i).zza(), zzx.zzs());
            this.zzb = empty;
        }
        if (this.zzb == null) {
            zzb = new zzp(zzx.zzs());
            this.zzb = zzb;
        }
        this.zzc = zzx.zzj();
    }

    zzr(com.google.firebase.auth.internal.zzx zzx, com.google.firebase.auth.internal.zzp zzp2, zze zze3) {
        super();
        this.zza = zzx;
        this.zzb = zzp2;
        this.zzc = zze3;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AuthCredential getCredential() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final FirebaseUser getUser() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i6 = 0;
        b.n(parcel, 1, this.zza, i2, i6);
        b.n(parcel, 2, this.zzb, i2, i6);
        b.n(parcel, 3, this.zzc, i2, i6);
        b.b(parcel, b.a(parcel));
    }
}
