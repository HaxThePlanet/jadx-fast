package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class op implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    private final String c;
    private final String v;
    private final String w;
    private final String x;
    private com.google.android.gms.internal.firebase-auth-api.vn y;
    private op(String string, String string2, String string3, String string4, String string5, String string6) {
        super();
        r.f(string);
        this.a = string;
        final String obj1 = "phone";
        r.f(obj1);
        this.b = obj1;
        this.c = string3;
        this.v = string4;
        this.w = string5;
        this.x = string6;
    }

    public static com.google.android.gms.internal.firebase-auth-api.op a(String string, String string2, String string3, String string4, String string5) {
        r.f(string2);
        super(string, "phone", string2, string3, string4, string5);
        return opVar2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String b() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final void c(com.google.android.gms.internal.firebase-auth-api.vn vn) {
        this.y = vn;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        Object jSONObject;
        boolean empty;
        boolean empty2;
        Object vnVar;
        int str;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("idToken", this.a);
        this.b.hashCode();
        jSONObject2.put("mfaProvider", 1);
        jSONObject = new JSONObject();
        jSONObject.put("phoneNumber", this.c);
        if (this.c != null && !TextUtils.isEmpty(this.w)) {
            jSONObject = new JSONObject();
            jSONObject.put("phoneNumber", this.c);
            if (!TextUtils.isEmpty(this.w)) {
                jSONObject.put("recaptchaToken", this.w);
            }
            if (!TextUtils.isEmpty(this.x)) {
                jSONObject.put("safetyNetToken", this.x);
            }
            vnVar = this.y;
            if (vnVar != null) {
                jSONObject.put("autoRetrievalInfo", vnVar.a());
            }
            jSONObject2.put("phoneEnrollmentInfo", jSONObject);
        }
        return jSONObject2.toString();
    }
}
