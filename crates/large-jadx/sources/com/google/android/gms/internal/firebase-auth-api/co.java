package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class co implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.co> {

    private static final String y = "co";
    private String a;
    private String b;
    private boolean c;
    private long v;
    private List<com.google.android.gms.internal.firebase-auth-api.xo> w;
    private String x;
    static {
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final long a() {
        return this.v;
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

    public final List<com.google.android.gms.internal.firebase-auth-api.xo> e() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final boolean f() {
        if (!TextUtils.isEmpty(this.x)) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final boolean g() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.mm
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            final int i = 0;
            jSONObject.optString("localId", i);
            jSONObject.optString("email", i);
            this.a = jSONObject.optString("idToken", i);
            this.b = jSONObject.optString("refreshToken", i);
            this.c = jSONObject.optBoolean("isNewUser", false);
            this.v = jSONObject.optLong("expiresIn", 0);
            this.w = xo.l2(jSONObject.optJSONArray("mfaInfo"));
            this.x = jSONObject.optString("mfaPendingCredential", i);
            return this;
            string = hq.a(th, co.y, string);
            throw string;
        }
    }
}
