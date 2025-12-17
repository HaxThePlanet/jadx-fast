package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class jo implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    public jo(String string) {
        super();
        r.f(string);
        this.a = string;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.a);
        return jSONObject.toString();
    }
}
