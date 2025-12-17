package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fq implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    public fq(String string, String string2) {
        super();
        r.f(string);
        this.a = string;
        r.f(string2);
        this.b = string2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.a);
        jSONObject.put("mfaEnrollmentId", this.b);
        return jSONObject.toString();
    }
}
