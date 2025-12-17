package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fo implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    private final String c;
    private final String v;
    fo(String string, String string2, String string3, String string4, String string5, String string6) {
        super();
        final String obj1 = "phone";
        r.f(obj1);
        this.a = obj1;
        r.f(string2);
        this.b = string2;
        this.c = string3;
        this.v = string4;
    }

    public static com.google.android.gms.internal.firebase-auth-api.fo a(String string, String string2, String string3) {
        r.f(string3);
        r.f(string2);
        super("phone", string, string2, string3, 0, 0);
        return foVar2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        String str;
        JSONObject jSONObject = new JSONObject();
        this.a.hashCode();
        jSONObject.put("mfaProvider", 1);
        jSONObject.put("mfaPendingCredential", this.b);
        JSONObject jSONObject2 = new JSONObject();
        String str6 = this.c;
        if (str6 != null) {
            jSONObject2.put("sessionInfo", str6);
        }
        String str7 = this.v;
        if (str7 != null) {
            jSONObject2.put("code", str7);
        }
        jSONObject.put("phoneVerificationInfo", jSONObject2);
        return jSONObject.toString();
    }
}
