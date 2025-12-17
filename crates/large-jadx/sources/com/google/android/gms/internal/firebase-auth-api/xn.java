package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class xn implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    private final String c;
    public xn(String string, String string2) {
        super();
        r.f(string);
        this.a = string;
        this.b = "http://localhost";
        this.c = string2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("identifier", this.a);
        jSONObject.put("continueUri", this.b);
        String str4 = this.c;
        if (str4 != null) {
            jSONObject.put("tenantId", str4);
        }
        return jSONObject.toString();
    }
}
