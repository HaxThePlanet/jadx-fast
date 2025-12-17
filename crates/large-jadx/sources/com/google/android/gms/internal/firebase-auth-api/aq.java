package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class aq implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    private final String c;
    public aq(String string, String string2, String string3) {
        super();
        r.f(string);
        this.a = string;
        r.f(string2);
        this.b = string2;
        this.c = string3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        int str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.a);
        jSONObject.put("password", this.b);
        jSONObject.put("returnSecureToken", true);
        String str5 = this.c;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        return jSONObject.toString();
    }
}
