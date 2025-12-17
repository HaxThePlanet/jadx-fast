package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ep implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    private final String c;
    public ep(String string, String string2, String string3) {
        super();
        r.f(string);
        this.a = string;
        this.b = string2;
        this.c = string3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("oobCode", this.a);
        String str3 = this.b;
        if (str3 != null) {
            jSONObject.put("newPassword", str3);
        }
        String str4 = this.c;
        if (str4 != null) {
            jSONObject.put("tenantId", str4);
        }
        return jSONObject.toString();
    }
}
