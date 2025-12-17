package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzz implements FirebaseUserMetadata {

    public static final Parcelable.Creator<com.google.firebase.auth.internal.zzz> CREATOR;
    private final long zza;
    private final long zzb;
    static {
        zzaa zzaa = new zzaa();
        zzz.CREATOR = zzaa;
    }

    public zzz(long l, long l2) {
        super();
        this.zza = l;
        this.zzb = obj3;
    }

    @Override // com.google.firebase.auth.FirebaseUserMetadata
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.FirebaseUserMetadata
    public final long getCreationTimestamp() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.FirebaseUserMetadata
    public final long getLastSignInTimestamp() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.FirebaseUserMetadata
    public final void writeToParcel(Parcel parcel, int i2) {
        b.l(parcel, 1, this.zza);
        b.l(parcel, 2, this.zzb);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.firebase.auth.FirebaseUserMetadata
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("lastSignInTimestamp", this.zza);
        jSONObject.put("creationTimestamp", this.zzb);
        return jSONObject;
    }
}
