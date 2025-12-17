package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class xp implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    public xp(String string, String string2) {
        super();
        r.f(string);
        this.a = string;
        this.b = string2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        int str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", this.a);
        jSONObject.put("returnSecureToken", true);
        String str4 = this.b;
        if (str4 != null) {
            jSONObject.put("tenantId", str4);
        }
        return jSONObject.toString();
    }
}
