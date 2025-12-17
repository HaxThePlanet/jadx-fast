package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class do implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private String b;
    private final String c;
    private final String v;
    private final String w;
    do(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        super();
        final String obj1 = "phone";
        r.f(obj1);
        this.a = obj1;
        r.f(string2);
        this.b = string2;
        this.c = string3;
        this.w = string4;
        this.v = string7;
    }

    public static com.google.android.gms.internal.firebase-auth-api.do a(String string, String string2, String string3, String string4) {
        r.f(string3);
        r.f(string2);
        super("phone", string, string2, string3, 0, 0, string4);
        return doVar2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.do b(String string) {
        this.b = string;
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        int str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.b);
        this.a.hashCode();
        jSONObject.put("mfaProvider", 1);
        String str6 = this.v;
        if (str6 != null) {
            jSONObject.put("displayName", str6);
        }
        JSONObject jSONObject2 = new JSONObject();
        String str8 = this.c;
        if (str8 != null) {
            jSONObject2.put("sessionInfo", str8);
        }
        String str9 = this.w;
        if (str9 != null) {
            jSONObject2.put("code", str9);
        }
        jSONObject.put("phoneVerificationInfo", jSONObject2);
        return jSONObject.toString();
    }
}
