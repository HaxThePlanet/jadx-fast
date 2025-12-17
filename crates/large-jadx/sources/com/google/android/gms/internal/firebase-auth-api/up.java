package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.internal.zzi;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class up extends a implements com.google.android.gms.internal.firebase-auth-api.lm {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.up> CREATOR;
    private boolean A;
    private boolean B;
    private String C;
    private String D;
    private String E;
    private String F;
    private boolean G;
    private String H;
    private String a;
    private String b;
    private String c;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    static {
        vp vpVar = new vp();
        up.CREATOR = vpVar;
    }

    public up() {
        super();
        final int i = 1;
        this.A = i;
        this.B = i;
    }

    public up(zzi zzi, String string2) {
        super();
        r.j(zzi);
        final String str = zzi.zzd();
        r.f(str);
        this.D = str;
        r.f(string2);
        this.E = string2;
        String obj2 = zzi.zzc();
        r.f(obj2);
        this.w = obj2;
        this.A = true;
        obj2 = new StringBuilder();
        obj2.append("providerId=");
        obj2.append(this.w);
        this.y = obj2.toString();
    }

    public up(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        boolean obj1;
        boolean obj3;
        super();
        this.a = "http://localhost";
        this.c = string;
        this.v = string2;
        this.z = string5;
        this.C = string6;
        this.F = string7;
        this.H = string8;
        int obj2 = 1;
        this.A = obj2;
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(this.v)) {
            if (TextUtils.isEmpty(this.v)) {
                if (TextUtils.isEmpty(this.C)) {
                } else {
                }
                obj1 = new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
                throw obj1;
            }
        }
        r.f(string3);
        this.w = string3;
        this.x = 0;
        obj1 = new StringBuilder();
        String obj4 = "&";
        if (!TextUtils.isEmpty(this.c)) {
            obj1.append("id_token=");
            obj1.append(this.c);
            obj1.append(obj4);
        }
        if (!TextUtils.isEmpty(this.v)) {
            obj1.append("access_token=");
            obj1.append(this.v);
            obj1.append(obj4);
        }
        if (!TextUtils.isEmpty(this.x)) {
            obj1.append("identifier=");
            obj1.append(this.x);
            obj1.append(obj4);
        }
        if (!TextUtils.isEmpty(this.z)) {
            obj1.append("oauth_token_secret=");
            obj1.append(this.z);
            obj1.append(obj4);
        }
        if (!TextUtils.isEmpty(this.C)) {
            obj1.append("code=");
            obj1.append(this.C);
            obj1.append(obj4);
        }
        if (!TextUtils.isEmpty(string9)) {
            obj1.append("nonce=");
            obj1.append(string9);
            obj1.append(obj4);
        }
        obj1.append("providerId=");
        obj1.append(this.w);
        this.y = obj1.toString();
        this.B = obj2;
    }

    up(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, boolean z9, boolean z10, String string11, String string12, String string13, String string14, boolean z15, String string16) {
        final Object obj = this;
        super();
        obj.a = string;
        obj.b = string2;
        obj.c = string3;
        obj.v = string4;
        obj.w = string5;
        obj.x = string6;
        obj.y = string7;
        obj.z = string8;
        obj.A = z9;
        obj.B = z10;
        obj.C = string11;
        obj.D = string12;
        obj.E = string13;
        obj.F = string14;
        obj.G = z15;
        obj.H = string16;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.up j2(boolean z) {
        this.B = false;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.up k2(String string) {
        r.f(string);
        this.b = string;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.up l2(boolean z) {
        this.G = true;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.up m2(boolean z) {
        this.A = true;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.up n2(String string) {
        this.F = string;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i18 = 0;
        b.o(parcel, 2, this.a, i18);
        b.o(parcel, 3, this.b, i18);
        b.o(parcel, 4, this.c, i18);
        b.o(parcel, 5, this.v, i18);
        b.o(parcel, 6, this.w, i18);
        b.o(parcel, 7, this.x, i18);
        b.o(parcel, 8, this.y, i18);
        b.o(parcel, 9, this.z, i18);
        b.c(parcel, 10, this.A);
        b.c(parcel, 11, this.B);
        b.o(parcel, 12, this.C, i18);
        b.o(parcel, 13, this.D, i18);
        b.o(parcel, 14, this.E, i18);
        b.o(parcel, 15, this.F, i18);
        b.c(parcel, 16, this.G);
        b.o(parcel, 17, this.H, i18);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zza() {
        boolean empty;
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.B);
        jSONObject.put("returnSecureToken", this.A);
        String str3 = this.b;
        if (str3 != null) {
            jSONObject.put("idToken", str3);
        }
        String str4 = this.y;
        if (str4 != null) {
            jSONObject.put("postBody", str4);
        }
        String str5 = this.F;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        String str6 = this.H;
        if (str6 != null) {
            jSONObject.put("pendingToken", str6);
        }
        if (!TextUtils.isEmpty(this.D)) {
            jSONObject.put("sessionId", this.D);
        }
        String str10 = "requestUri";
        if (!TextUtils.isEmpty(this.E)) {
            jSONObject.put(str10, this.E);
        } else {
            str = this.a;
            if (str != null) {
                jSONObject.put(str10, str);
            }
        }
        jSONObject.put("returnIdpCredential", this.G);
        return jSONObject.toString();
    }
}
