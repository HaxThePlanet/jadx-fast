package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class mp implements com.google.android.gms.internal.firebase-auth-api.lm {

    private String a;
    private String b;
    private final String c;
    public mp(String string) {
        super();
        this.c = string;
    }

    public mp(String string, String string2, String string3, String string4) {
        super();
        r.f(string);
        this.a = string;
        r.f(string2);
        this.b = string2;
        this.c = string4;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        String str;
        JSONObject jSONObject = new JSONObject();
        String str2 = this.a;
        if (str2 != null) {
            jSONObject.put("email", str2);
        }
        String str3 = this.b;
        if (str3 != null) {
            jSONObject.put("password", str3);
        }
        String str4 = this.c;
        if (str4 != null) {
            jSONObject.put("tenantId", str4);
        }
        return jSONObject.toString();
    }
}
