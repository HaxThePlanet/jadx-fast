package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzp implements AdditionalUserInfo {

    public static final Parcelable.Creator<com.google.firebase.auth.internal.zzp> CREATOR;
    private final String zza;
    private final String zzb;
    private final Map<String, Object> zzc;
    private final boolean zzd;
    static {
        zzq zzq = new zzq();
        zzp.CREATOR = zzq;
    }

    public zzp(String string, String string2, boolean z3) {
        super();
        r.f(string);
        r.f(string2);
        this.zza = string;
        this.zzb = string2;
        this.zzc = zzaz.zzc(string2);
        this.zzd = z3;
    }

    public zzp(boolean z) {
        super();
        this.zzd = z;
        final int obj1 = 0;
        this.zzb = obj1;
        this.zza = obj1;
        this.zzc = obj1;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final int describeContents() {
        return 0;
    }

    public final Map<String, Object> getProfile() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final String getProviderId() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final String getUsername() {
        if ("github.com".equals(this.zza)) {
            return (String)this.zzc.get("login");
        }
        if ("twitter.com".equals(this.zza)) {
            return (String)this.zzc.get("screen_name");
        }
        return null;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final boolean isNewUser() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i5 = 0;
        b.o(parcel, 1, this.zza, i5);
        b.o(parcel, 2, this.zzb, i5);
        b.c(parcel, 3, this.zzd);
        b.b(parcel, b.a(parcel));
    }
}
