package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class qp implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    private final String c;
    private final String v;
    private final String w;
    private final String x;
    private final String y;
    private com.google.android.gms.internal.firebase-auth-api.vn z;
    private qp(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        super();
        final String obj1 = "phone";
        r.f(obj1);
        this.a = obj1;
        r.f(string2);
        this.b = string2;
        r.f(string3);
        this.c = string3;
        this.w = string4;
        this.v = string5;
        this.x = string6;
        this.y = string7;
    }

    public static com.google.android.gms.internal.firebase-auth-api.qp a(String string, String string2, String string3, String string4, String string5, String string6) {
        r.f(string3);
        super("phone", string, string2, string3, string4, string5, string6);
        return qpVar2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String b() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final void c(com.google.android.gms.internal.firebase-auth-api.vn vn) {
        this.z = vn;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        Object jSONObject;
        boolean empty2;
        boolean empty;
        Object vnVar;
        int str;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("mfaPendingCredential", this.b);
        jSONObject2.put("mfaEnrollmentId", this.c);
        this.a.hashCode();
        jSONObject2.put("mfaProvider", 1);
        jSONObject = new JSONObject();
        jSONObject.put("phoneNumber", this.w);
        if (this.w != null && !TextUtils.isEmpty(this.x)) {
            jSONObject = new JSONObject();
            jSONObject.put("phoneNumber", this.w);
            if (!TextUtils.isEmpty(this.x)) {
                jSONObject.put("recaptchaToken", this.x);
            }
            if (!TextUtils.isEmpty(this.y)) {
                jSONObject.put("safetyNetToken", this.y);
            }
            vnVar = this.z;
            if (vnVar != null) {
                jSONObject.put("autoRetrievalInfo", vnVar.a());
            }
            jSONObject2.put("phoneSignInInfo", jSONObject);
        }
        return jSONObject2.toString();
    }
}
