package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hp extends a implements com.google.android.gms.internal.firebase-auth-api.lm {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.hp> CREATOR;
    private com.google.android.gms.internal.firebase-auth-api.vn A;
    private final String a;
    private final long b;
    private final boolean c;
    private final String v;
    private final String w;
    private final String x;
    private final boolean y;
    private final String z;
    static {
        ip ipVar = new ip();
        hp.CREATOR = ipVar;
    }

    public hp(String string, long l2, boolean z3, String string4, String string5, String string6, boolean z7, String string8) {
        super();
        r.f(string);
        this.a = string;
        this.b = l2;
        this.c = string4;
        this.v = string5;
        this.w = string6;
        this.x = z7;
        this.y = string8;
        this.z = obj9;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final long j2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void k2(com.google.android.gms.internal.firebase-auth-api.vn vn) {
        this.A = vn;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean l2() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        int i = 1;
        final int i9 = 0;
        b.o(parcel, i, this.a, i9);
        b.l(parcel, 2, this.b);
        b.c(parcel, 3, this.c);
        b.o(parcel, 4, this.v, i9);
        b.o(parcel, 5, this.w, i9);
        b.o(parcel, 6, this.x, i9);
        b.c(parcel, 7, this.y);
        b.o(parcel, 8, this.z, i9);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zza() {
        Object vnVar;
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("phoneNumber", this.a);
        String str3 = this.w;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.x;
        if (str4 != null) {
            jSONObject.put("recaptchaToken", str4);
        }
        vnVar = this.A;
        if (vnVar != null) {
            jSONObject.put("autoRetrievalInfo", vnVar.a());
        }
        String str5 = this.z;
        if (str5 != null) {
            jSONObject.put("safetyNetToken", str5);
        }
        return jSONObject.toString();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzd() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zzg() {
        return this.y;
    }
}
