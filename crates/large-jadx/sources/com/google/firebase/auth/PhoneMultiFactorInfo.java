package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.firebase-auth-api.zzll;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PhoneMultiFactorInfo extends com.google.firebase.auth.MultiFactorInfo {

    public static final Parcelable.Creator<com.google.firebase.auth.PhoneMultiFactorInfo> CREATOR;
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final String zzd;
    static {
        zzae zzae = new zzae();
        PhoneMultiFactorInfo.CREATOR = zzae;
    }

    public PhoneMultiFactorInfo(String string, String string2, long l3, String string4) {
        super();
        r.f(string);
        this.zza = string;
        this.zzb = string2;
        this.zzc = l3;
        r.f(obj5);
        this.zzd = obj5;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String getDisplayName() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public long getEnrollmentTimestamp() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String getFactorId() {
        return "phone";
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String getPhoneNumber() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String getUid() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("factorIdKey", "phone");
        jSONObject.putOpt("uid", this.zza);
        jSONObject.putOpt("displayName", this.zzb);
        jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
        jSONObject.putOpt("phoneNumber", this.zzd);
        return jSONObject;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public void writeToParcel(Parcel parcel, int i2) {
        final int i5 = 0;
        b.o(parcel, 1, getUid(), i5);
        int i3 = 2;
        b.o(parcel, i3, getDisplayName(), i5);
        b.l(parcel, 3, getEnrollmentTimestamp());
        b.o(parcel, 4, getPhoneNumber(), i5);
        b.b(parcel, b.a(parcel));
    }
}
