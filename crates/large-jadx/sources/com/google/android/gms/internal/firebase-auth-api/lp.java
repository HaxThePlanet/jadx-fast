package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.util.n;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class lp implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.lp> {

    private static final String x = "lp";
    private String a;
    private com.google.android.gms.internal.firebase-auth-api.bp b;
    private String c;
    private String v;
    private long w;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final long a() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String c() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String d() {
        return this.v;
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.zo> e() {
        com.google.android.gms.internal.firebase-auth-api.bp bpVar = this.b;
        if (bpVar != null) {
            return bpVar.l2();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            int i = 0;
            this.a = n.a(jSONObject.optString("email", i));
            n.a(jSONObject.optString("passwordHash", i));
            final int i3 = 0;
            jSONObject.optBoolean("emailVerified", i3);
            n.a(jSONObject.optString("displayName", i));
            n.a(jSONObject.optString("photoUrl", i));
            this.b = bp.j2(jSONObject.optJSONArray("providerUserInfo"));
            this.c = n.a(jSONObject.optString("idToken", i));
            this.v = n.a(jSONObject.optString("refreshToken", i));
            this.w = jSONObject.optLong("expiresIn", 0);
            return this;
            string = hq.a(th, lp.x, string);
            throw string;
        }
    }
}
