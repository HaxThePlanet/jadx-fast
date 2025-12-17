package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class io implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    public io(String string) {
        super();
        this.a = ho.zza.toString();
        r.f(string);
        this.b = string;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grantType", this.a);
        jSONObject.put("refreshToken", this.b);
        return jSONObject.toString();
    }
}
