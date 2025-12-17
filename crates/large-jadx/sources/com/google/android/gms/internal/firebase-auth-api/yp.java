package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class yp extends a implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.yp> {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.yp> CREATOR;
    private static final String w;
    private String a;
    private String b;
    private long c;
    private boolean v;
    static {
        yp.w = yp.class.getSimpleName();
        zp zpVar = new zp();
        yp.CREATOR = zpVar;
    }

    yp(String string, String string2, long l3, boolean z4) {
        super();
        this.a = string;
        this.b = string2;
        this.c = l3;
        this.v = obj5;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final long j2() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        int i5 = 0;
        b.o(parcel, 2, this.a, i5);
        int i3 = 3;
        b.o(parcel, i3, this.b, i5);
        b.l(parcel, 4, this.c);
        b.c(parcel, 5, this.v);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            int i = 0;
            this.a = n.a(jSONObject.optString("idToken", i));
            this.b = n.a(jSONObject.optString("refreshToken", i));
            this.c = jSONObject.optLong("expiresIn", 0);
            this.v = jSONObject.optBoolean("isNewUser", false);
            return this;
            string = hq.a(th, yp.w, string);
            throw string;
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzd() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zze() {
        return this.v;
    }
}
