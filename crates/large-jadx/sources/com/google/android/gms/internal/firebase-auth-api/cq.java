package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class cq implements com.google.android.gms.internal.firebase-auth-api.lm {

    private String a;
    private String b;
    private String c;
    private String v;
    private String w;
    private boolean x;
    public static com.google.android.gms.internal.firebase-auth-api.cq a(String string, String string2, boolean z3) {
        cq cqVar = new cq();
        r.f(string);
        cqVar.b = string;
        r.f(string2);
        cqVar.c = string2;
        cqVar.x = z3;
        return cqVar;
    }

    public static com.google.android.gms.internal.firebase-auth-api.cq b(String string, String string2, boolean z3) {
        cq cqVar = new cq();
        r.f(string);
        cqVar.a = string;
        r.f(string2);
        cqVar.v = string2;
        cqVar.x = z3;
        return cqVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final void c(String string) {
        this.w = string;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        String str2;
        boolean z;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.v)) {
            jSONObject.put("phoneNumber", this.a);
            jSONObject.put("temporaryProof", this.v);
        } else {
            jSONObject.put("sessionInfo", this.b);
            jSONObject.put("code", this.c);
        }
        String str4 = this.w;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        if (!this.x) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }
}
