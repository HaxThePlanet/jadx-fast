package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.util.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dq implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.dq> {

    private static final String y = "dq";
    private String a;
    private String b;
    private long c;
    private boolean v;
    private String w;
    private String x;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final long a() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String c() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String d() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final String e() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final boolean f() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            final int i = 0;
            this.a = n.a(jSONObject.optString("idToken", i));
            this.b = n.a(jSONObject.optString("refreshToken", i));
            this.c = jSONObject.optLong("expiresIn", 0);
            n.a(jSONObject.optString("localId", i));
            this.v = jSONObject.optBoolean("isNewUser", false);
            this.w = n.a(jSONObject.optString("temporaryProof", i));
            this.x = n.a(jSONObject.optString("phoneNumber", i));
            return this;
            string = hq.a(th, dq.y, string);
            throw string;
        }
    }
}
